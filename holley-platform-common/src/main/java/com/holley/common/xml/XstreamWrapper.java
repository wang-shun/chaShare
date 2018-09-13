package com.holley.common.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.holley.common.file.FileUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * xml 和对象的转换工具
 * 
 * @author zhouli
 */
public class XstreamWrapper {

    private static Log log     = LogFactory.getLog(XstreamWrapper.class);

    private XStream    xstream = null;

    /**
     * 构造函数
     * 
     * @param aliasMap -
     */
    public XstreamWrapper(Map<String, Class<?>> aliasMap) {
        xstream = new XStream(new DomDriver());

        // 初始化别名
        if (aliasMap != null) {
            for (Entry<String, Class<?>> entry : aliasMap.entrySet()) {
                if (log.isDebugEnabled()) log.debug("alias " + entry.getKey() + ":" + entry.getValue());
                xstream.alias(entry.getKey(), entry.getValue());
            }
        }
    }

    /**
     * 保存对象到一个XML文件
     * 
     * @param obj
     * @param xmlFile
     */
    public void saveObjectToXML(Object obj, File xmlFile) {
        Writer writer = null;
        try {
            if (xmlFile == null || !FileUtil.createFile(xmlFile)) {
                throw new RuntimeException("Invalid Save File " + xmlFile);
            }

            //
            writer = new OutputStreamWriter(new FileOutputStream(xmlFile), "utf-8");

            if (log.isDebugEnabled()) log.debug("save to file" + xmlFile.toString());
            xstream.toXML(obj, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 输出对象到输出流
     * 
     * @param obj
     * @param writer
     */
    public void saveObjectToXML(Object obj, Writer writer) {
        try {
            if (writer == null) {
                throw new RuntimeException("Invalid writer.");
            }

            xstream.toXML(obj, writer);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * Ojbect转换为xml文本
     * 
     * @param obj
     * @return string
     */
    public String getFromObject(Object obj) {
        if (obj != null) {
            return xstream.toXML(obj);
        } else {
            return null;
        }
    }

    /**
     * 从xml文本中得到Object
     * 
     * @param xmlContent
     * @return Object
     */
    public Object getFromXml(String xmlContent) {
        return xstream.fromXML(xmlContent);
    }

    /**
     * 从xml文件中得到Object
     * 
     * @param xmlFile
     * @return Object
     */
    public Object getFromXml(File xmlFile) {
        if (xmlFile == null || !xmlFile.exists()) {
            return null;
        }

        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(xmlFile), "utf-8");
            return xstream.fromXML(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 从xml文件中得到Object
     * 
     * @param xmlFile
     * @return Object
     */
    public Object getFromXml(InputStream in) {
        if (in == null) {
            return null;
        }

        Reader reader = null;
        try {
            reader = new InputStreamReader(in, "utf-8");
            return xstream.fromXML(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 保存对象到xml文件,static方法
     * 
     * @param file
     * @param object
     * @return
     * @throws SynchronizationBigBuyerException
     * @throws IOException
     */
    public static boolean setObjectToXml(File file, Object object) {
        if (object == null || file == null) {
            return false;
        }
        XstreamWrapper wrapper = new XstreamWrapper(new HashMap<String, Class<?>>());
        wrapper.saveObjectToXML(object, file);
        return true;

    }

    /**
     * 读取xml文件到对象, static方法
     * 
     * @param file
     * @return
     * @throws IOException
     * @throws SynchronizationBigBuyerException
     */
    public static Object getObjectToXml(InputStream in) {
        if (in == null) {
            return null;
        }

        XstreamWrapper wrapper = new XstreamWrapper(new HashMap<String, Class<?>>());
        return wrapper.getFromXml(in);
    }

    /**
     * 读取xml文件到对象, static方法
     * 
     * @param file
     * @return
     * @throws IOException
     * @throws SynchronizationBigBuyerException
     */
    public static Object getObjectToXml(File file) {
        if (file == null) {
            return null;
        }

        XstreamWrapper wrapper = new XstreamWrapper(new HashMap<String, Class<?>>());
        return wrapper.getFromXml(file);
    }

}
