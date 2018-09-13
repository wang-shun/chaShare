package com.holley.common.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConfigurationFile {

    private String fileName;

    public ConfigurationFile(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 从ini配置文件中读取字符变量的值
     * 
     * @param section 要获取的变量所在段名称
     * @param variable 要获取的变量名称
     * @param defaultValue 变量名称不存在时的默认值
     * @return 变量的字符型值
     */

    public String getProfileString(String section, String variable, String defaultValue) {
        BufferedReader bufferedReader = null;

        try {
            String strLine;
            String value = "";
            bufferedReader = new BufferedReader(new FileReader(fileName));
            boolean isInSection = false;
            while ((strLine = bufferedReader.readLine()) != null) {
                strLine = strLine.trim();
                strLine = strLine.split("[;]")[0];
                Pattern p;
                Matcher m;
                p = Pattern.compile("\\[\\s*.*\\s*\\]");
                m = p.matcher(strLine);
                if (m.matches()) {
                    p = Pattern.compile("\\[\\s*" + section + "\\s*\\]");
                    m = p.matcher(strLine);
                    if (m.matches()) {
                        isInSection = true;
                    } else {
                        isInSection = false;
                    }
                }

                if (isInSection == true) {
                    strLine = strLine.trim();
                    String[] strArray = strLine.split("=");
                    if (strArray.length == 1) {
                        value = strArray[0].trim();
                        if (value.equalsIgnoreCase(variable)) {
                            value = "";
                            return value;
                        }
                    } else if (strArray.length == 2) {
                        value = strArray[0].trim();
                        if (value.equalsIgnoreCase(variable)) {
                            value = strArray[1].trim();
                            return value;
                        }
                    } else if (strArray.length > 2) {
                        value = strArray[0].trim();
                        if (value.equalsIgnoreCase(variable)) {
                            value = strLine.substring(strLine.indexOf("=") + 1).trim();
                            return value;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
                // Logger.getLogger(ConfigurationFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return defaultValue;
    }

    /**
     * 修改ini配置文件中字符变量的值
     * 
     * @param section 要修改的变量所在段名称
     * @param variable 要修改的变量名称
     * @param value 变量的新值
     * @return 设置是否成功
     */

    public boolean setProfileString(String section, String variable, String value) {
        BufferedReader bufferedReader = null;

        try {
            boolean isInSection = false;
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String allLine = "";
            String fileContent = "";

            while ((allLine = bufferedReader.readLine()) != null) {
                String remarkStr = "";
                String strLine = "";
                allLine = allLine.trim();

                if (allLine.split("[;]").length > 1) {
                    remarkStr = ";" + allLine.split(";")[1];
                } else {
                    remarkStr = "";
                }

                strLine = allLine.split(";")[0];
                Pattern p;
                Matcher m;
                p = Pattern.compile("\\[\\s*.*\\s*\\]");
                m = p.matcher(strLine);
                if (m.matches()) {
                    p = Pattern.compile("\\[\\s*" + section + "\\s*\\]");
                    m = p.matcher(strLine);
                    if (m.matches()) {
                        isInSection = true;
                    } else {
                        isInSection = false;
                    }
                }

                if (isInSection == true) {
                    strLine = strLine.trim();
                    String[] strArray = strLine.split("=");
                    String getValue = strArray[0].trim();

                    if (getValue.equalsIgnoreCase(variable)) {
                        String newLine = getValue + "=" + value + remarkStr;
                        fileContent += newLine + "\r\n";
                        while ((allLine = bufferedReader.readLine()) != null) {
                            fileContent += allLine + "\r\n";
                        }

                        bufferedReader.close();
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, false));
                        bufferedWriter.write(fileContent);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        return true;
                    }
                }
                fileContent += allLine + "\r\n";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
            }
        }

        return false;
    }

    /**
     * 从ini配置文件中读取变量的值
     * 
     * @param file 配置文件的路径
     * @param section 要获取的变量所在段名称
     * @param variable 要获取的变量名称
     * @param defaultValue 变量名称不存在时的默认值
     * @return 变量的值
     * @throws IOException 抛出文件操作可能出现的io异常
     */

    public static String getProfileString(String file, String section, String variable, String defaultValue) {
        BufferedReader bufferedReader = null;

        try {
            boolean isInSection = false;
            bufferedReader = new BufferedReader(new FileReader(file));
            String strLine = "";

            while ((strLine = bufferedReader.readLine()) != null) {
                strLine = strLine.trim();
                strLine = strLine.split("[;]")[0];
                Pattern p = Pattern.compile("\\[\\s*.*\\s*\\]");
                Matcher m = p.matcher(strLine);

                if (m.matches()) {
                    p = Pattern.compile("\\[\\s*" + section + "\\s*\\]");
                    m = p.matcher(strLine);
                    if (m.matches()) {
                        isInSection = true;
                    } else {
                        isInSection = false;
                    }
                }

                if (isInSection == true) {
                    String value = "";
                    strLine = strLine.trim();
                    String[] strArray = strLine.split("=");

                    if (strArray.length == 1) {
                        value = strArray[0].trim();
                        if (value.equalsIgnoreCase(variable)) {
                            value = "";
                            return value;
                        }

                    } else if (strArray.length == 2) {
                        value = strArray[0].trim();
                        if (value.equalsIgnoreCase(variable)) {
                            value = strArray[1].trim();
                            return value;
                        }

                    } else if (strArray.length > 2) {
                        value = strArray[0].trim();
                        if (value.equalsIgnoreCase(variable)) {
                            value = strLine.substring(strLine.indexOf("=") + 1).trim();
                            return value;
                        }
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
            }
        }

        return defaultValue;
    }

    /**
     * 修改ini配置文件中变量的值
     * 
     * @param file 配置文件的路径
     * @param section 要修改的变量所在段名称
     * @param variable 要修改的变量名称
     * @param value 变量的新值
     * @throws IOException 抛出文件操作可能出现的io异常
     */

    public static boolean setProfileString(String file, String section, String variable, String value) {
        BufferedReader bufferedReader = null;
        try {
            boolean isInSection = false;
            bufferedReader = new BufferedReader(new FileReader(file));
            String allLine = "";
            String fileContent = "";

            while ((allLine = bufferedReader.readLine()) != null) {

                String remarkStr = "";
                String strLine = "";
                allLine = allLine.trim();
                if (allLine.split("[;]").length > 1) {
                    remarkStr = ";" + allLine.split(";")[1];
                } else {
                    remarkStr = "";
                }

                strLine = allLine.split(";")[0];
                Pattern p;
                Matcher m;
                p = Pattern.compile("\\[\\s*.*\\s*\\]");
                m = p.matcher(strLine);

                if (m.matches()) {
                    p = Pattern.compile("\\[\\s*" + section + "\\s*\\]");
                    m = p.matcher(strLine);
                    if (m.matches()) {
                        isInSection = true;
                    } else {
                        isInSection = false;
                    }
                }

                if (isInSection == true) {
                    strLine = strLine.trim();
                    String[] strArray = strLine.split("=");
                    String getValue = strArray[0].trim();

                    if (getValue.equalsIgnoreCase(variable)) {
                        String newLine = getValue + "=" + value + remarkStr;
                        fileContent += newLine + "\r\n";

                        while ((allLine = bufferedReader.readLine()) != null) {
                            fileContent += allLine + "\r\n";
                        }

                        bufferedReader.close();
                        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                        bufferedWriter.write(fileContent);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        return true;
                    }
                }
                fileContent += allLine + "\r\n";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException ex) {
            }
        }

        return false;

    }

}
