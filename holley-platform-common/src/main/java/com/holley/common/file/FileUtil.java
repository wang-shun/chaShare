package com.holley.common.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import com.holley.common.util.DateUtil;
import com.holley.common.util.StringEscapeUtil;
import com.holley.common.util.StringUtil;
import com.holley.common.util.SystemUtil;

/**
 * 其他文件操作方法直接调用 org.apache.commons.io.FileUtils,这儿是它的补充
 */
public class FileUtil extends FileUtils {

    public static Log           log                 = LogFactory.getLog(FileUtil.class);

    /* ============================================================================ */
    /* 常量 */
    /* ============================================================================ */
    private static final char   COLON_CHAR          = ':';
    private static final String UNC_PREFIX          = "//";
    private static final String SLASH               = "/";
    private static final char   SLASH_CHAR          = '/';
    private static final char   BACKSLASH_CHAR      = '\\';

    /** 后缀分隔符。 */
    public static final String  EXTENSION_SEPARATOR = ".";
    /** 当前目录记号："." */
    public static final String  CURRENT_DIR         = ".";
    /** 上级目录记号：".." */
    public static final String  UP_LEVEL_DIR        = "..";

    public static class ComparatorFileByDate implements Comparator<Object> {

        public int compare(Object first, Object last) {
            Map<String, String> map = (Map<String, String>) first;
            Map<String, String> map2 = (Map<String, String>) last;
            if (map != null && map2 != null) {
                Date lastModifiedDate = DateUtil.ShortStrToDate(map.get("lastModified"));
                Date lastModifiedDate2 = DateUtil.ShortStrToDate(map2.get("lastModified"));
                return lastModifiedDate.before(lastModifiedDate2) ? 0 : 1;
            }
            return 0;
        }
    }

    /**
     * 规格化路径
     * 
     * @param path
     * @return 规格化后的路径
     */
    public static String normalizeAbsolutePath(String path) {
        String normalizedPath = normalizePath(path, false);

        if ((normalizedPath != null) && !normalizedPath.startsWith(SLASH)) {
            if (normalizedPath.equals(CURRENT_DIR) || normalizedPath.equals(CURRENT_DIR + SLASH_CHAR)) {
                normalizedPath = SLASH;
            } else if (normalizedPath.startsWith(UP_LEVEL_DIR)) {
                normalizedPath = null;
            } else {
                normalizedPath = SLASH_CHAR + normalizedPath;
            }
        }

        return normalizedPath;
    }

    /**
     * 规格化路径
     * 
     * @param path
     * @return 规格化后的路径
     */
    public static String normalizePath(String path) {
        return normalizePath(path, SystemUtil.getOsInfo().isWindows());
    }

    /**
     * 规格化路径
     * 
     * @param path
     * @return 规格化后的路径
     */
    public static String normalizeWindowsPath(String path) {
        return normalizePath(path, true);
    }

    /**
     * 规格化后的路径
     * 
     * @param path
     * @return 规格化后的路径
     */
    public static String normalizeUnixPath(String path) {
        return normalizePath(path, false);
    }

    /**
     * 规格化路径。规则如下：
     * <ol>
     * <li>路径为<code>null</code>，则返回<code>null</code>。</li>
     * <li>将所有backslash("\\")转化成slash("/")。</li>
     * <li>去除重复的"/"或"\\"。</li>
     * <li>去除"."，如果发现".."，则向上朔一级目录。</li>
     * <li>空绝对路径返回"/"，空相对路径返回"./"。</li>
     * <li>保留路径末尾的"/"（如果有的话）。</li>
     * <li>对于绝对路径，如果".."上朔的路径超过了根目录，则看作非法路径，返回<code>null</code>。</li>
     * <li>对于Windows系统，有些路径有特殊的前缀，如驱动器名"c:"和UNC名"//hostname"，对于这些路径，保留其前缀，并对其后的路径部分适用上述所有规则。</li>
     * <li>Windows驱动器名被转换成大写，如"c:"转换成"C:"。</li>
     * </ol>
     * 
     * @param path 要规格化的路径
     * @param isWindows 是否是windows路径，如果为<code>true</code>，则支持驱动器名和UNC路径
     * @return 规格化后的路径，如果路径非法，则返回<code>null</code>
     */
    private static String normalizePath(String path, boolean isWindows) {
        if (path == null) {
            return null;
        }

        path = path.trim();

        path = path.replace(BACKSLASH_CHAR, SLASH_CHAR); // 将"\\"转换成"/"，以便统一处理

        // 取得系统特定的路径前缀，对于windows系统，可能是："C:"或是"//hostname"
        String prefix = getSystemDependentPrefix(path, isWindows);

        if (prefix == null) {
            return null;
        }

        path = path.substring(prefix.length());
        // 对于绝对路径，prefix必须以"/"结尾，反之，绝对路径的prefix.length > 0
        if ((prefix.length() > 0) || path.startsWith(SLASH)) {
            prefix += SLASH_CHAR;
        }

        // 保留path尾部的"/"
        boolean endsWithSlash = path.endsWith(SLASH);

        // 压缩路径中的"."和".."
        StringTokenizer tokenizer = new StringTokenizer(path, "/");
        StringBuffer buffer = new StringBuffer(prefix.length() + path.length());
        int level = 0;

        buffer.append(prefix);

        while (tokenizer.hasMoreTokens()) {
            String element = tokenizer.nextToken();
            // 忽略"."
            if (CURRENT_DIR.equals(element)) {
                continue;
            }
            // 回朔".."
            if (UP_LEVEL_DIR.equals(element)) {
                if (level == 0) {
                    // 如果prefix存在，并且试图越过最上层目录，这是不可能的，
                    // 返回null，表示路径非法。
                    if (prefix.length() > 0) {
                        return null;
                    }
                    buffer.append(UP_LEVEL_DIR).append(SLASH_CHAR);
                } else {
                    level--;

                    boolean found = false;

                    for (int i = buffer.length() - 2; i >= prefix.length(); i--) {
                        if (buffer.charAt(i) == SLASH_CHAR) {
                            buffer.setLength(i + 1);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        buffer.setLength(prefix.length());
                    }
                }
                continue;
            }

            // 添加到path
            buffer.append(element).append(SLASH_CHAR);
            level++;
        }

        // 如果是空的路径，则设置为"./"
        if (buffer.length() == 0) {
            buffer.append(CURRENT_DIR).append(SLASH_CHAR);
        }

        // 保留最后的"/"
        if (!endsWithSlash && (buffer.length() > prefix.length()) && (buffer.charAt(buffer.length() - 1) == SLASH_CHAR)) {
            buffer.setLength(buffer.length() - 1);
        }

        return buffer.toString();
    }

    /**
     * 得到文件状态码，用文件的最后修改时间和文件长度做异或
     * 
     * @param fileName
     * @return
     */
    public static int getStausCode(String fileName) {
        int code = 0;
        File f = new File(fileName);
        if (f.exists()) {
            code = (int) (f.lastModified() ^ f.length());
        }

        return code;
    }

    /**
     * 取得和系统相关的文件名前缀。对于Windows系统，可能是驱动器名或UNC路径前缀"//hostname"。如果不存在前缀，则返回空字符串。
     * 
     * @param path 绝对路径
     * @param isWindows 是否为windows系统
     * @return 和系统相关的文件名前缀，如果路径非法，例如："//"，则返回<code>null</code>
     */
    private static String getSystemDependentPrefix(String path, boolean isWindows) {
        if (isWindows) {
            // 判断UNC路径
            if (path.startsWith(UNC_PREFIX)) {
                // 非法UNC路径："//"
                if (path.length() == UNC_PREFIX.length()) {
                    return null;
                }

                // 假设路径为//hostname/subpath，返回//hostname
                int index = path.indexOf(SLASH, UNC_PREFIX.length());

                if (index != -1) {
                    return path.substring(0, index);
                } else {
                    return path;
                }
            }

            // 判断Windows绝对路径："c:/..."
            if ((path.length() > 1) && (path.charAt(1) == COLON_CHAR)) {
                return path.substring(0, 2).toUpperCase();
            }
        }

        return "";
    }

    /**
     * 取得较短的文件目录名 如/a/b/v/../x.doc 返回 /a/b/x.doc
     * 
     * @param fileName Description of Parameter
     * @return The ShortFileName value
     */
    public static String getShortFileName(String fileName) {
        StringBuffer sb = new StringBuffer();
        String[] sa = fileName.replace('\\', '/').split("/");
        for (int i = 0; i < sa.length; i++) {
            if (sa[i].equals(".")) {
                sa[i] = null;
            }
            if (sa[i].equals("..")) {
                sa[i] = null;
                if (i > 0) {
                    sa[i - 1] = null;
                }
            }
        }

        for (int i = 0; i < sa.length; i++) {
            if (sa[i] != null) {
                sb.append("/");
                sb.append(sa[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 读一个文件返回内容字符串
     * 
     * @param fileName 文件名
     * @return Description of the Returned Value
     * @exception IOException Description of Exception
     */
    public static String readFromFile(String fileName) throws IOException {
        return readFromFile(fileName, null);
    }

    /**
     * 读文件返回字符，指定编码方式
     * 
     * @param fileName 文件名
     * @param encoding 编码方式
     * @return 返回字符串
     * @exception IOException Description of Exception
     */
    public static String readFromFile(String fileName, String encoding) throws IOException {
        FileInputStream fin = new FileInputStream(fileName);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream(fin.available());
        streamCopy(fin, outStream);
        fin.close();
        if (encoding != null) {
            return new String(outStream.toByteArray(), encoding);
        } else {
            return new String(outStream.toByteArray());
        }
    }

    /**
     * 把字符串写到文件里
     * 
     * @param fileName 文件名
     * @param content 要写的内容
     * @exception IOException Description of Exception
     */
    public static void writeToFile(String fileName, String content) throws IOException {
        writeToFile(fileName, new ByteArrayInputStream(content.getBytes()), false);
    }

    /**
     * 把字符串写到文件里
     * 
     * @param fileName
     * @param content
     * @param encoding
     * @throws IOException
     */
    public static void writeToFile(String fileName, String content, String encoding) throws IOException {
        writeToFile(fileName, new ByteArrayInputStream(content.getBytes(encoding)), false);
    }

    /**
     * 把流的内容写到文件中
     * 
     * @param fileName 文件名
     * @param iStream 输入流
     * @exception IOException Description of Exception
     */
    public static void writeToFile(String fileName, InputStream iStream) throws IOException {
        writeToFile(fileName, iStream, false);
    }

    /**
     * 把一个输入流复制到一个输出流中,
     * 
     * @param in 输入流
     * @param out 输出流
     * @exception IOException Description of Exception
     */
    public static long streamCopy(InputStream in, OutputStream out) throws IOException {
        long writeCount = 0;
        if ((in == null) || (out == null)) {
            return 0;
        }
        byte[] buffer = new byte[32 * 1024];
        int bytesRead = 0;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
            writeCount += bytesRead;
        }
        return writeCount;
    }

    /**
     * 把输入流写到文件,完成后会关闭流
     * 
     * @param fileName 文件名
     * @param iStream 输入流
     * @param createDir 如果没有目录true创建,false不创建,默认false
     * @throws IOException
     */
    public static void writeToFile(String fileName, InputStream iStream, boolean createDir) throws IOException {
        File theFile = new File(fileName);
        if (createDir && theFile.getParentFile() != null) {
            theFile.getParentFile().mkdirs();
        }

        FileOutputStream fOut = null;
        try {
            fOut = new FileOutputStream(theFile);
            streamCopy(iStream, fOut);
        } catch (Exception e) {
            log.error(e);
            throw new IOException("FileUtil.WriteToFile failed, got: " + e.toString());
        } finally {
            close(iStream);
            close(fOut);
        }
    }

    /**
     * 关闭流
     * 
     * @param iStream
     */
    public static void close(InputStream iStream) {
        if (iStream != null) {
            try {
                iStream.close();
            } catch (Exception e) {
                log.error(e);
            }
        }
    }

    /**
     * 关闭流
     * 
     * @param oStream
     */
    public static void close(OutputStream oStream) {
        if (oStream != null) {
            try {
                oStream.close();
            } catch (Exception e) {
                log.error(e);
            }
        }
    }

    /**
     * 从URL中取得文件。
     * 
     * @param url URL
     * @return 文件, 如果URL为空，或不代表一个文件, 则返回<code>null</code>
     */
    public static File toFile(URL url) {
        if (url == null) {
            return null;
        }

        if (url.getProtocol().equals("file")) {
            String path = url.getPath();

            if (path != null) {
                return new File(StringEscapeUtil.unescapeURL(path));
            }
        }

        return null;
    }

    /**
     * 建立一个文件
     * 
     * @param file
     * @return
     */
    public static boolean createFile(File file) {
        if (file == null) {
            throw new RuntimeException(" can not create null file.");
        }

        if (file.exists()) return true;

        File parentDir = file.getParentFile();
        if (log.isDebugEnabled()) {
            log.debug("parentDir : " + parentDir);
        }
        if (parentDir != null && !parentDir.exists()) {
            if (!parentDir.mkdirs()) {
                return false;
            }
        }
        try {
            return file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 得到当前目录
     * 
     * @return
     * @throws IOException
     */
    public static final String getCurrentDirectory() throws IOException {
        File currentDirectory = new File(".");
        return currentDirectory.getCanonicalPath();
    }

    /**
     * 复制文件夹
     * 
     * @param sourceDir
     * @param targetDir
     * @throws IOException
     */
    public static void copyDirectiory(String sourceDir, String targetDir) throws IOException {
        File sourceFileDir = new File(sourceDir);
        File targetFileDir = new File(targetDir);
        if (!sourceFileDir.exists()) return;
        if (targetFileDir.exists()) return;
        // 新建目标目录
        (new File(targetDir)).mkdirs();
        // 获取源文件夹当前下的文件或目录
        File[] file = (new File(sourceDir)).listFiles();
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                // 源文件
                File sourceFile = file[i];
                // 目标文件
                File targetFile = new File(new File(targetDir).getAbsolutePath() + File.separator + file[i].getName());
                copyFile(sourceFile, targetFile);
            }
            if (file[i].isDirectory()) {
                // 准备复制的源文件夹
                String dir1 = sourceDir + "/" + file[i].getName();
                // 准备复制的目标文件夹
                String dir2 = targetDir + "/" + file[i].getName();
                copyDirectiory(dir1, dir2);
            }
        }
    }

    /**
     * 返回文件夹内文件大小(单位KB)
     * 
     * @param file
     * @return
     */
    public static double getDirSize(File file) {
        // 判断文件是否存在
        if (file.exists()) {
            // 如果是目录则递归计算其内容的总大小
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                double size = 0;
                for (File f : children)
                    size += getDirSize(f);
                return size;
            } else {// 如果是文件则直接返回其大小,以“kb”为单位
                double size = (double) file.length() / 1024 / 1024;
                return size;
            }
        } else {
            return 0.0;
        }
    }

    /**
     * 文件拷贝
     * 
     * @param sourceFile
     * @param targetFile
     * @throws IOException
     */
    public static void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            // 新建文件输入流并对它进行缓冲
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }

            outBuff.flush();
        } finally {
            if (inBuff != null) inBuff.close();
            if (outBuff != null) outBuff.close();
        }
    }

    /**
     * 上传文件到服务器
     * 
     * @param dir 指定目录
     * @param pic 上传文件
     * @param picFileName 存储的文件名
     * @return 返回随机文件名
     */
    public static String uploadFile(String dir, File pic, String picFileName) {
        if (pic != null && dir != null) {
            File dirF = new File(dir);
            if (!dirF.exists()) {
                dirF.mkdirs();
            }

            String tempFileName = StringUtil.randomString(40);

            String[] fileName = StringUtils.split(picFileName, ".");
            String returnfileName = "";

            if (fileName.length >= 2) {
                returnfileName = tempFileName + "." + fileName[fileName.length - 1]; // 保留文件名后缀;
                tempFileName = dir + "/" + returnfileName;

                try {
                    FileUtil.copyFile(pic, new File(tempFileName));
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            return returnfileName;
        }
        return null;
    }

    /**
     * Description: 向FTP服务器上传文件
     * 
     * @param ip FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param path FTP服务器保存目录
     * @param filename 上传到FTP服务器上的文件名
     * @param input 输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFtpFile(String ip, int port, String username, String password, String path, String filename, InputStream input) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(ip, port);// 连接FTP服务器
            // 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.changeWorkingDirectory(path);
            ftp.storeFile(filename, input);

            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    /**
     * Description: 从FTP服务器下载文件
     * 
     * @param ip FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param remotePath FTP服务器上的相对路径
     * @param fileName 要下载的文件名
     * @param localPath 下载后保存到本地的路径
     * @return
     */
    public static boolean downFtpFile(String ip, int port, String username, String password, String remotePath, String fileName, String localPath) {
        boolean success = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(ip, port);
            // 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }

            ftp.enterLocalPassiveMode();
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles(remotePath);
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    File localFile = new File(localPath + "/" + ff.getName());

                    OutputStream is = new FileOutputStream(localFile);
                    ftp.retrieveFile(ff.getName(), is);
                    is.close();
                }
            }

            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    /**
     * 一行行读取文件，并保存为List
     * 
     * @param filename
     * @param rownum 读取的行数量，-1表示全部读取
     * @return
     */
    public static List<String> readLinesFromFile(String filename, int rownum) {
        List<String> list = new ArrayList<String>();
        LineNumberReader lineNumberReader = null;
        try {
            // 构造LineNumberReader实例
            lineNumberReader = new LineNumberReader(new FileReader(filename));

            String s = "";
            while (s != null) {
                s = lineNumberReader.readLine();

                if (rownum != -1) {
                    if (lineNumberReader.getLineNumber() <= rownum) {
                        list.add(s);
                    } else {
                        return list;
                    }
                } else {
                    list.add(s);
                }

            }

            return list;

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // 关闭lineNumberReader
            try {
                if (lineNumberReader != null) {
                    lineNumberReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 读取文件的某一行
     * 
     * @param filename
     * @param rownum
     * @return
     */
    public static String readLineFromFile(String filename, int rownum) {

        LineNumberReader lineNumberReader = null;
        try {
            // 构造LineNumberReader实例
            lineNumberReader = new LineNumberReader(new FileReader(filename));

            String s = "";
            while (s != null) {
                s = lineNumberReader.readLine();
                if (lineNumberReader.getLineNumber() == rownum) {
                    return s;
                }
            }

            return null;

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // 关闭lineNumberReader
            try {
                if (lineNumberReader != null) {
                    lineNumberReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 删除单个文件
     * 
     * @param sPath 被删除文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

    /**
     * 删除目录下的文件,不迭代删除
     * 
     * @param sPath 被删除目录的文件路径
     * @return 目录删除成功返回true，否则返回false
     */
    public static boolean deleteDirFile(String sPath) {
        // 如果sPath不以文件分隔符结尾，自动添加文件分隔符
        if (!sPath.endsWith(File.separator)) {
            sPath = sPath + File.separator;
        }
        File dirFile = new File(sPath);
        // 如果dir对应的文件不存在，或者不是一个目录，则退出
        if (!dirFile.exists() || !dirFile.isDirectory()) {
            return false;
        }
        boolean flag = true;
        // 删除文件夹下的所有文件
        File[] files = dirFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            // 删除子文件
            if (files[i].isFile()) {
                files[i].delete();
            }
        }

        return flag;
    }

    /**
     * 读取配置文件
     * 
     * @param resource
     * @return
     */
    public static Properties loadProperty(String resource) {
        Properties prop = new Properties();
        InputStream is = null;
        try {
            // FileInputStream is=new FileInputStream("config.properties");
            is = Properties.class.getClassLoader().getResourceAsStream(resource);
            prop.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }
}
