package com.holley.web.common.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;

import com.holley.common.constants.Globals;
import com.holley.common.constants.charge.ImgTypeEnum;
import com.holley.common.file.FileUtil;
import com.holley.common.util.StringUtil;

public final class ImageUtil {

    // private static final String[] chars = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D",
    // "E", "F", "G", "H", "I", "东", "南", "西", "北", "中", "发", "白" };
    private static final String[] chars      = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H" };
    private static final int      SIZE       = 4;
    private static final int      LINES      = 20;
    private static final int      WIDTH      = 200;
    private static final int      HEIGHT     = 100;
    private static final int      FONT_SIZE  = 60;
    private static final int      VOL_WIDTH  = 350;
    private static final int      VOL_HEIGHT = 350;
    private static final double   ANGLE_60   = 60.0;                                                                                        // 60度定值

    /**
     * 防止数字超出图片，设置最大值缩放等级
     * 
     * @param uaStr
     * @param ubStr
     * @param ucStr
     * @return
     */
    public static double getRate(String uaStr, String ubStr, String ucStr) {
        Double maxLength = 1.0;

        if (StringUtil.isNotEmpty(uaStr) && Double.valueOf(uaStr).compareTo(maxLength) > 0) {
            maxLength = Double.valueOf(uaStr);
        }

        if (StringUtil.isNotEmpty(ubStr) && Double.valueOf(ubStr).compareTo(maxLength) > 0) {
            maxLength = Double.valueOf(ubStr);
        }
        if (StringUtil.isNotEmpty(ucStr) && Double.valueOf(ucStr).compareTo(maxLength) > 0) {
            maxLength = Double.valueOf(ucStr);
        }

        Double rate = maxLength * 2 / VOL_WIDTH;
        if (rate < 1.0) {
            return 1.0;
        } else {
            return Math.round(rate) + 1;
        }
    }

    private static int calcLength(String length, double rate) {
        if (StringUtil.isNotEmpty(length)) {
            return (int) Math.round(Double.valueOf(length) / rate);
        }
        return 0;
    }

    /**
     * 2边和夹角求第三边边长
     * 
     * @param a
     * @param b
     * @param angle
     * @param rate
     * @return
     */
    public static int calcSideLength(String a, String b, Double angle) {
        if (StringUtil.isNotEmpty(a) && StringUtil.isNotEmpty(b)) {
            Double da = Double.valueOf(a);
            Double db = Double.valueOf(b);
            double radians = Math.toRadians(angle);
            double s = Math.sqrt(da * da + db * db - 2 * da * db * Math.cos(radians));
            return (int) Math.round(s);
        }

        return 0;
    }

    /**
     * 电压向量图
     * 
     * @return
     */
    public static BufferedImage getVoltageImage(String ua, String ub, String uc, Double pUa, Double pUc) {
        BufferedImage image = new BufferedImage(VOL_WIDTH, VOL_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphic = (Graphics2D) image.getGraphics();

        // 底图
        Color color = new Color(221, 221, 255);
        graphic.setColor(color);
        graphic.fillRect(0, 0, VOL_WIDTH, VOL_HEIGHT);
        Integer pointX = VOL_WIDTH / 2; // 中间点
        Integer pointY = VOL_HEIGHT / 2;
        graphic.setColor(Color.BLACK);
        graphic.setFont(new Font(null, Font.PLAIN + Font.PLAIN, 1));
        graphic.setStroke(new BasicStroke(0));

        int uabLength = calcSideLength(ua, ub, 120.0);
        int ucbLength = calcSideLength(uc, ub, 120.0);

        // 画ua,ub,uc基线
        double rate = getRate(String.valueOf(uabLength), String.valueOf(ucbLength), uc);
        int uaLength = calcLength(ua, rate);
        int ubLength = calcLength(ub, rate);
        int ucLength = calcLength(uc, rate);
        uabLength = calcLength(String.valueOf(uabLength), rate);
        ucbLength = calcLength(String.valueOf(ucbLength), rate);

        pUa = pUa == null ? 0 : pUa; // Uab相角
        pUc = pUc == null ? 0 : pUc; // Ucb相角

        Point ubPoint = getSelfPoint(pointX, pointY, 210, ubLength);// 左顶点
        Point ucPoint = getSelfPoint(pointX, pointY, -30, ucLength);// 右顶点
        graphic.drawLine(pointX, pointY, pointX, pointY - uaLength);
        graphic.drawLine(pointX, pointY, (int) ubPoint.getX(), (int) ubPoint.getY());
        graphic.drawLine(pointX, pointY, (int) ucPoint.getX(), (int) ucPoint.getY());

        // 顶点添加箭头
        addArray(graphic, pointX, pointY - uaLength, -90);
        addArray(graphic, (int) ubPoint.getX(), (int) ubPoint.getY(), 30);
        addArray(graphic, (int) ucPoint.getX(), (int) ucPoint.getY(), 150);

        // 顶点添加文字
        graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
        graphic.drawString("Ua", pointX, pointY - uaLength);
        graphic.drawString("Ub", (int) ubPoint.getX() - 20, (int) ubPoint.getY());
        graphic.drawString("Uc", (int) ucPoint.getX(), (int) ucPoint.getY());

        // 画uab,ucb
        graphic.setColor(new Color(207, 48, 52)); // 偏红色
        Point pointUab = getSelfPoint(pointX, pointY, 90 + pUa, uabLength);
        drawSelfLine(graphic, pointX, pointY, pointUab, -90 + pUa);
        graphic.drawString("Uab", (int) pointUab.getX(), (int) pointUab.getY());

        Point pointUcb = getSelfPoint(pointX, pointY, 210 - pUc, ucbLength);
        drawSelfLine(graphic, pointX, pointY, pointUcb, 30 - pUc);
        graphic.drawString("Ucb", (int) pointUcb.getX() - 25, (int) pointUcb.getY());

        return image;
    }

    /**
     * 六角图
     * 
     * @return
     */
    public static BufferedImage getHexPinsImageByCircle(String linemode, Double anglea, Double angleb, Double anglec) {
        int width = 240, height = 240;
        int radius = 110;
        String MSfont = "微软雅黑";
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphic = (Graphics2D) image.getGraphics();
        graphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 底图
        Color color = new Color(255, 255, 255);
        graphic.setColor(color);
        graphic.fillRect(0, 0, width, height);
        Integer pointX = width / 2 - 6; // 中间点
        Integer pointY = height / 2;
        graphic.setColor(Color.BLACK);
        graphic.setFont(new Font(null, Font.PLAIN + Font.PLAIN, 0));
        // graphic.setStroke(new BasicStroke(2));

        graphic.setColor(Color.BLACK);
        graphic.setStroke(new BasicStroke(0));
        int gap = 30;// 两原之间的间距
        int smallRadius = (int) (radius * Math.cos(Math.PI * 45 / 180)) - 20;// 小圆半径
        int greatRadius = smallRadius + gap;
        graphic.setColor(new Color(223, 232, 246));
        graphic.fillOval(pointX - greatRadius, pointY - greatRadius, greatRadius * 2, greatRadius * 2);// 大圆
        graphic.setColor(Color.BLACK);
        graphic.drawOval(pointX - greatRadius, pointY - greatRadius, greatRadius * 2, greatRadius * 2);// 大圆
        graphic.setColor(Color.WHITE);
        graphic.fillOval(pointX - smallRadius, pointY - smallRadius, smallRadius * 2, smallRadius * 2);// 小圆
        graphic.setColor(Color.BLACK);
        graphic.drawOval(pointX - smallRadius, pointY - smallRadius, smallRadius * 2, smallRadius * 2);// 小圆

        Point UabPoint = getSelfPoint(pointX, pointY, 120, greatRadius + 25);
        graphic.drawLine(pointX, pointY, (int) UabPoint.getX(), (int) UabPoint.getY());
        // addArray(graphic, (int) UabPoint.getX(), (int) UabPoint.getY(), -60);暂时不画箭头
        graphic.setFont(new Font(MSfont, Font.BOLD + Font.BOLD, 12));
        graphic.drawString("Uab", (int) UabPoint.getX(), (int) UabPoint.getY());
        Point UbaPoint = getSelfPoint(pointX, pointY, -60, greatRadius + 25);
        graphic.drawLine(pointX, pointY, (int) UbaPoint.getX(), (int) UbaPoint.getY());
        // addArray(graphic, (int) UbaPoint.getX(), (int) UbaPoint.getY(), 120);
        graphic.setFont(new Font(MSfont, Font.BOLD + Font.BOLD, 12));
        graphic.drawString("Uba", (int) UbaPoint.getX(), (int) UbaPoint.getY());

        Point UacPoint = getSelfPoint(pointX, pointY, 60, greatRadius + 25);
        graphic.drawLine(pointX, pointY, (int) UacPoint.getX(), (int) UacPoint.getY());
        graphic.setFont(new Font(MSfont, Font.BOLD + Font.BOLD, 12));
        graphic.drawString("Uac", (int) UacPoint.getX(), (int) UacPoint.getY());
        Point UcaPoint = getSelfPoint(pointX, pointY, -120, greatRadius + 25);
        graphic.drawLine(pointX, pointY, (int) UcaPoint.getX(), (int) UcaPoint.getY());
        graphic.setFont(new Font(MSfont, Font.BOLD + Font.BOLD, 12));
        graphic.drawString("Uca", (int) UcaPoint.getX(), (int) UcaPoint.getY() + 10);

        // int tempX = (int) (radius * Math.cos(Math.PI * 30 / 180));
        // int tempY = (int) (radius * Math.sin(Math.PI * 30 / 180));
        graphic.drawLine(pointX, pointY, pointX - greatRadius - 25, pointY);
        graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
        graphic.drawString("Ucb", pointX - greatRadius - 25, pointY - 5);
        graphic.drawLine(pointX, pointY, pointX + greatRadius + 25, pointY);
        graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
        graphic.drawString("Ubc", pointX + greatRadius + 5, pointY - 5);

        graphic.setStroke(new BasicStroke(2));
        double realAngle = 0;
        // 画uab,ucb
        if (anglea != null) {
            graphic.setColor(new Color(255, 194, 14)); // 黄色
            graphic.drawLine(pointX, pointY - greatRadius, pointX, pointY);
            graphic.setFont(new Font(MSfont, Font.BOLD + Font.BOLD, 14));
            graphic.drawString("Ua", pointX, pointY - greatRadius);
            addArray(graphic, pointX, pointY - greatRadius, -90);

            realAngle = ANGLE_60 + 30 - anglea;
            graphic.setColor(new Color(255, 194, 14)); // 黄色
            Point IaPoint = getSelfPoint(pointX, pointY, realAngle, smallRadius);
            graphic.drawLine(pointX, pointY, (int) IaPoint.getX(), (int) IaPoint.getY());
            addArray(graphic, (int) IaPoint.getX(), (int) IaPoint.getY(), -90 - anglea);
        }

        if (!"0".equals(linemode) && angleb != null) {// 非三相三线才画B相位角
            realAngle = -ANGLE_60 + 30;
            Point UbPoint = getSelfPoint(pointX, pointY, realAngle, greatRadius);
            graphic.setColor(Color.GREEN); // 绿色
            graphic.drawLine(pointX, pointY, (int) UbPoint.getX(), (int) UbPoint.getY());
            addArray(graphic, (int) UbPoint.getX(), (int) UbPoint.getY(), 150);
            graphic.drawString("Ub", (int) UbPoint.getX(), (int) UbPoint.getY() + 10);

            realAngle = -ANGLE_60 + 30 - angleb;
            graphic.setColor(Color.GREEN);
            Point IbPoint = getSelfPoint(pointX, pointY, realAngle, smallRadius);
            graphic.drawLine(pointX, pointY, (int) IbPoint.getX(), (int) IbPoint.getY());
            addArray(graphic, (int) IbPoint.getX(), (int) IbPoint.getY(), 150 - angleb);
        }
        if (anglec != null) {
            realAngle = 180 + 30;
            Point UcPoint = getSelfPoint(pointX, pointY, realAngle, greatRadius);
            graphic.setColor(Color.RED);
            graphic.drawLine(pointX, pointY, (int) UcPoint.getX(), (int) UcPoint.getY());
            graphic.drawString("Uc", (int) UcPoint.getX() - 10, (int) UcPoint.getY() + 20);
            addArray(graphic, (int) UcPoint.getX(), (int) UcPoint.getY(), 30);

            realAngle = 180 + 30 - anglec;
            graphic.setColor(Color.RED);
            Point IcPoint = getSelfPoint(pointX, pointY, realAngle, smallRadius);
            graphic.drawLine(pointX, pointY, (int) IcPoint.getX(), (int) IcPoint.getY());
            addArray(graphic, (int) IcPoint.getX(), (int) IcPoint.getY(), 30 - anglec);
        }
        return image;
    }

    /**
     * linemodeid= 0 三相三线 <br/>
     * linemodeid= 1 三相四线 <br/>
     * linemodeid= 2<br/>
     * 单相 六角图
     * 
     * @return
     */
    public static BufferedImage getHexPinsImage(String linemode, Double anglea, Double angleb, Double anglec) {
        int width = 240, height = 240;
        int radius = 110;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphic = (Graphics2D) image.getGraphics();
        // ---------- 增加下面的代码使得背景透明 -----------------
        // image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        // 消除线条锯齿
        graphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 底图
        graphic.setColor(Color.BLACK);
        graphic.fillRect(0, 0, width, height);
        Integer pointX = width / 2; // 中间点
        Integer pointY = height / 2;
        graphic.setColor(Color.BLACK);
        graphic.setFont(new Font(null, Font.PLAIN + Font.PLAIN, 0));
        // graphic.setStroke(new BasicStroke(2));

        graphic.setColor(Color.BLACK);
        graphic.setStroke(new BasicStroke(2));
        int gap = 30;// 两原之间的间距
        int smallRadius = (int) (radius * Math.cos(Math.PI * 45 / 180)) - 20;// 小圆半径
        int greatRadius = smallRadius + gap;
        graphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphic.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        double realAngle = 0;
        if ("0".equals(linemode)) {
            // Uab
            graphic.setColor(new Color(178, 210, 53));
            Point UabPoint = getSelfPoint(pointX, pointY, 120, greatRadius + 25);
            graphic.drawLine(pointX, pointY, (int) UabPoint.getX(), (int) UabPoint.getY());
            addArray(graphic, (int) UabPoint.getX(), (int) UabPoint.getY(), -60);
            graphic.setFont(new Font("微软雅黑", Font.BOLD + Font.BOLD, 12));
            graphic.drawString("Uab", (int) UabPoint.getX(), (int) UabPoint.getY());

            // Ubc 以下代码可用，但是图上暂不显示
            // graphic.setColor(Color.green);
            // graphic.drawLine(pointX, pointY, pointX + greatRadius + 25, pointY);
            // graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
            // graphic.drawString("Ubc", pointX + greatRadius + 5, pointY - 5);
            // addArray(graphic, pointX + greatRadius + 25, pointY, 180);

            // Ucb
            graphic.setColor(new Color(126, 192, 238));// Color.BLUE);
            graphic.drawLine(pointX, pointY, pointX - greatRadius - 25, pointY);
            graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
            graphic.drawString("Ucb", pointX - greatRadius - 5, pointY - 5);
            addArray(graphic, pointX - greatRadius - 25, pointY, 0);

            graphic.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 16, 4 }, 0));
            graphic.setColor(new Color(255, 194, 14)); // 黄色
            graphic.drawLine(pointX, pointY - greatRadius, pointX, pointY);
            graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
            graphic.drawString("Ua", pointX, pointY - greatRadius);
            addArray(graphic, pointX, pointY - greatRadius, -90);

            // Ub
            graphic.setColor(Color.green);
            Point UbPoint = getSelfPoint(pointX, pointY, -30, greatRadius);
            graphic.drawLine(pointX, pointY, (int) UbPoint.getX(), (int) UbPoint.getY());
            addArray(graphic, (int) UbPoint.getX(), (int) UbPoint.getY(), 150);
            graphic.setColor(Color.green);
            graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 12));
            graphic.drawString("Ub", (int) UbPoint.getX(), (int) UbPoint.getY());

            // Uc
            graphic.setColor(Color.RED);
            Point UcPoint = getSelfPoint(pointX, pointY, -150, greatRadius);
            graphic.drawLine(pointX, pointY, (int) UcPoint.getX(), (int) UcPoint.getY());
            addArray(graphic, (int) UcPoint.getX(), (int) UcPoint.getY(), 30);
            graphic.setColor(Color.RED);
            graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 12));
            graphic.drawString("Uc", (int) UcPoint.getX() - 10, (int) UcPoint.getY() + 10);
            graphic.setStroke(new BasicStroke(2));

            if (anglea != null) {
                realAngle = 120 - anglea;
                graphic.setColor(new Color(255, 194, 14)); // 黄色
                Point IaPoint = getSelfPoint(pointX, pointY, realAngle, smallRadius);
                graphic.drawLine(pointX, pointY, (int) IaPoint.getX(), (int) IaPoint.getY());
                addArray(graphic, (int) IaPoint.getX(), (int) IaPoint.getY(), -(180 - realAngle));
                graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
                graphic.drawString("Ia", (int) IaPoint.getX() + 5, (int) IaPoint.getY());
            }
            if (anglec != null) {
                if (anglec > 30) {
                    realAngle = -180 - anglec;
                } else {
                    realAngle = 180 - anglec;
                }
                graphic.setColor(Color.RED);
                Point IcPoint = getSelfPoint(pointX, pointY, realAngle, smallRadius);
                graphic.drawLine(pointX, pointY, (int) IcPoint.getX(), (int) IcPoint.getY());
                addArray(graphic, (int) IcPoint.getX(), (int) IcPoint.getY(), -(180 - realAngle));
                graphic.setColor(Color.RED);
                graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
                graphic.drawString("Ic", (int) IcPoint.getX() - 12, (int) IcPoint.getY() + 5);
            }
        } else {
            graphic.setColor(new Color(255, 194, 14)); // 黄色
            graphic.drawLine(pointX, pointY - greatRadius, pointX, pointY);
            graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
            graphic.drawString("Ua", pointX, pointY - greatRadius);
            addArray(graphic, pointX, pointY - greatRadius, -90);

            // Ub
            graphic.setColor(Color.green);
            Point UbPoint = getSelfPoint(pointX, pointY, -30, greatRadius);
            graphic.drawLine(pointX, pointY, (int) UbPoint.getX(), (int) UbPoint.getY());
            addArray(graphic, (int) UbPoint.getX(), (int) UbPoint.getY(), 150);
            graphic.setColor(Color.green);
            graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 12));
            graphic.drawString("Ub", (int) UbPoint.getX(), (int) UbPoint.getY());

            // Uc
            graphic.setColor(Color.RED);
            Point UcPoint = getSelfPoint(pointX, pointY, -150, greatRadius);
            graphic.drawLine(pointX, pointY, (int) UcPoint.getX(), (int) UcPoint.getY());
            addArray(graphic, (int) UcPoint.getX(), (int) UcPoint.getY(), 30);
            graphic.setColor(Color.RED);
            graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 12));
            graphic.drawString("Uc", (int) UcPoint.getX() - 10, (int) UcPoint.getY() + 10);
            graphic.setStroke(new BasicStroke(2));

            if (anglea != null) {
                realAngle = 90 - anglea;
                graphic.setColor(new Color(255, 194, 14)); // 黄色
                Point IaPoint = getSelfPoint(pointX, pointY, realAngle, smallRadius);
                graphic.drawLine(pointX, pointY, (int) IaPoint.getX(), (int) IaPoint.getY());
                addArray(graphic, (int) IaPoint.getX(), (int) IaPoint.getY(), -(180 - realAngle));
                graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
                graphic.drawString("Ia", (int) IaPoint.getX() + 5, (int) IaPoint.getY());
            }
            if (angleb != null) {
                realAngle = -30 - angleb;
                graphic.setColor(Color.green);
                Point IbPoint = getSelfPoint(pointX, pointY, realAngle, smallRadius);
                graphic.drawLine(pointX, pointY, (int) IbPoint.getX(), (int) IbPoint.getY());
                addArray(graphic, (int) IbPoint.getX(), (int) IbPoint.getY(), -(180 - realAngle));
                graphic.setColor(Color.green);
                graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
                graphic.drawString("Ib", (int) IbPoint.getX(), (int) IbPoint.getY() + 2);
            }
            if (anglec != null) {
                realAngle = -150 - anglec;
                graphic.setColor(Color.RED);
                Point IcPoint = getSelfPoint(pointX, pointY, realAngle, smallRadius);
                graphic.drawLine(pointX, pointY, (int) IcPoint.getX(), (int) IcPoint.getY());
                addArray(graphic, (int) IcPoint.getX(), (int) IcPoint.getY(), -(180 - realAngle));
                graphic.setColor(Color.RED);
                graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
                graphic.drawString("Ic", (int) IcPoint.getX() - 12, (int) IcPoint.getY() + 5);
            }
        }
        graphic.dispose();
        return image;
    }

    /**
     * 已Ua为基准
     * 
     * @param linemode
     * @param anglea
     * @param angleb
     * @param anglec
     * @return
     */
    public static BufferedImage getHexPinsImageStand(String linemode, Double angle0, Double angle1, Double angle2, Double angle3, Double angle4, Double angle5) {
        int width = 240, height = 240;
        int radius = 110;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphic = (Graphics2D) image.getGraphics();
        // ---------- 增加下面的代码使得背景透明 -----------------
        // image = g2d.getDeviceConfiguration().createCompatibleImage(width, height, Transparency.TRANSLUCENT);
        // 消除线条锯齿
        graphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 底图
        graphic.setColor(Color.BLACK);
        graphic.fillRect(0, 0, width, height);
        Integer pointX = width / 2; // 中间点
        Integer pointY = height / 2;
        graphic.setColor(Color.BLACK);
        graphic.setFont(new Font(null, Font.PLAIN + Font.PLAIN, 0));
        // graphic.setStroke(new BasicStroke(2));

        graphic.setColor(Color.BLACK);
        graphic.setStroke(new BasicStroke(2));
        int gap = 30;// 两原之间的间距
        int smallRadius = (int) (radius * Math.cos(Math.PI * 45 / 180)) - 20;// 小圆半径
        int greatRadius = smallRadius + gap;
        graphic.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphic.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        double realAngle = 0;
        if ("0".equals(linemode)) {
            // Uab
            graphic.setColor(new Color(178, 210, 53));// Color.RED);
            graphic.setStroke(new BasicStroke((float) 0.9));
            Point UabPoint = getSelfPoint(pointX, pointY, 120, greatRadius + 25);
            graphic.drawLine(pointX, pointY, (int) UabPoint.getX(), (int) UabPoint.getY());
            addArray(graphic, (int) UabPoint.getX(), (int) UabPoint.getY(), -60);
            graphic.setFont(new Font("微软雅黑", Font.BOLD + Font.BOLD, 12));
            // graphic.setColor(new Color(215, 19, 69));
            graphic.drawString("Uab", (int) UabPoint.getX(), (int) UabPoint.getY());

            graphic.setStroke(new BasicStroke(2));
            // Ucb
            graphic.setColor(Color.green);
            graphic.drawLine(pointX, pointY, pointX - greatRadius - 25, pointY);
            graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
            graphic.drawString("Ucb", pointX - greatRadius - 5, pointY - 5);
            addArray(graphic, pointX - greatRadius - 25, pointY, 0);

            graphic.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 16, 4 }, 0));
            graphic.setColor(new Color(255, 194, 14)); // 黄色
            graphic.drawLine(pointX, pointY - greatRadius, pointX, pointY);
            graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
            graphic.drawString("Ua", pointX, pointY - greatRadius);
            addArray(graphic, pointX, pointY - greatRadius, -90);

            graphic.setColor(Color.green);
            Point UbPoint = getSelfPoint(pointX, pointY, -30, greatRadius);
            graphic.drawLine(pointX, pointY, (int) UbPoint.getX(), (int) UbPoint.getY());
            addArray(graphic, (int) UbPoint.getX(), (int) UbPoint.getY(), 150);
            graphic.setColor(Color.green);
            graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 12));
            graphic.drawString("Ub", (int) UbPoint.getX(), (int) UbPoint.getY());

            graphic.setColor(Color.RED);
            Point UcPoint = getSelfPoint(pointX, pointY, -150, greatRadius);
            graphic.drawLine(pointX, pointY, (int) UcPoint.getX(), (int) UcPoint.getY());
            addArray(graphic, (int) UcPoint.getX(), (int) UcPoint.getY(), 30);
            graphic.setColor(Color.RED);
            graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 12));
            graphic.drawString("Uc", (int) UcPoint.getX() - 10, (int) UcPoint.getY() + 10);

            graphic.setStroke(new BasicStroke(2));

            realAngle = 120 - angle3;// 已Uab 为标准
            graphic.setColor(new Color(255, 194, 14)); // 黄色
            Point IaPoint = getSelfPoint(pointX, pointY, realAngle, smallRadius);
            graphic.drawLine(pointX, pointY, (int) IaPoint.getX(), (int) IaPoint.getY());
            addArray(graphic, (int) IaPoint.getX(), (int) IaPoint.getY(), -(180 - realAngle));
            graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
            graphic.drawString("Ia", (int) IaPoint.getX() + 5, (int) IaPoint.getY());

            realAngle = 120 - angle5;
            graphic.setColor(Color.RED);
            Point IcPoint = getSelfPoint(pointX, pointY, realAngle, smallRadius);
            graphic.drawLine(pointX, pointY, (int) IcPoint.getX(), (int) IcPoint.getY());
            addArray(graphic, (int) IcPoint.getX(), (int) IcPoint.getY(), -(180 - realAngle));
            graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
            graphic.drawString("Ic", (int) IcPoint.getX() - 12, (int) IcPoint.getY() + 5);

        } else {
            // Ua
            graphic.setColor(new Color(255, 194, 14)); // 黄色
            graphic.drawLine(pointX, pointY - greatRadius, pointX, pointY);
            graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
            graphic.drawString("Ua", pointX, pointY - greatRadius);
            addArray(graphic, pointX, pointY - greatRadius, -90);

            double b1 = 120, b2 = 240;
            // Ub
            if (angle1 != null) {
                if (Math.abs(b1 - angle1) <= 10) {
                    angle1 = b1;
                }
                if (Math.abs(b2 - angle1) <= 10) {
                    angle1 = b2;
                }
                realAngle = 90 - angle1;// 已Uab 为标准
                graphic.setColor(Color.green);
                Point UbPoint = getSelfPoint(pointX, pointY, realAngle, greatRadius);
                graphic.drawLine(pointX, pointY, (int) UbPoint.getX(), (int) UbPoint.getY());
                addArray(graphic, (int) UbPoint.getX(), (int) UbPoint.getY(), -(180 - realAngle));
                graphic.setColor(Color.green);
                graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 12));
                if (realAngle < -90) {
                    graphic.drawString("Ub", (int) UbPoint.getX() - 15, (int) UbPoint.getY());
                } else graphic.drawString("Ub", (int) UbPoint.getX() + 15, (int) UbPoint.getY());
            }

            // Uc
            if (angle2 != null) {
                if (Math.abs(b1 - angle2) <= 10) {
                    angle2 = b1;
                }
                if (Math.abs(b2 - angle2) <= 10) {
                    angle2 = b2;
                }
                realAngle = 90 - angle2;// 已Uab 为标准
                graphic.setColor(Color.RED);
                Point UcPoint = getSelfPoint(pointX, pointY, realAngle, greatRadius);
                graphic.drawLine(pointX, pointY, (int) UcPoint.getX(), (int) UcPoint.getY());
                addArray(graphic, (int) UcPoint.getX(), (int) UcPoint.getY(), -(180 - realAngle));
                graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 12));
                if (realAngle < -90) {
                    graphic.drawString("Uc", (int) UcPoint.getX() - 10, (int) UcPoint.getY() + 10);
                } else graphic.drawString("Uc", (int) UcPoint.getX() + 10, (int) UcPoint.getY() + 10);
            }
            if (angle3 != null) {
                realAngle = 90 - angle3;// 已Uab 为标准
                graphic.setColor(new Color(255, 194, 14)); // 黄色
                Point IaPoint = getSelfPoint(pointX, pointY, realAngle, smallRadius);
                graphic.drawLine(pointX, pointY, (int) IaPoint.getX(), (int) IaPoint.getY());
                addArray(graphic, (int) IaPoint.getX(), (int) IaPoint.getY(), -(180 - realAngle));
                graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
                graphic.drawString("Ia", (int) IaPoint.getX() + 15, (int) IaPoint.getY());
            }
            if (angle4 != null) {
                realAngle = 90 - angle4;
                graphic.setColor(Color.green);
                Point IbPoint = getSelfPoint(pointX, pointY, realAngle, smallRadius);
                graphic.drawLine(pointX, pointY, (int) IbPoint.getX(), (int) IbPoint.getY());
                addArray(graphic, (int) IbPoint.getX(), (int) IbPoint.getY(), -(180 - realAngle));
                graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
                graphic.drawString("Ib", (int) IbPoint.getX() - 15, (int) IbPoint.getY() + 2);
            }
            if (angle5 != null) {
                realAngle = 90 - angle5;
                graphic.setColor(Color.RED);
                Point IcPoint = getSelfPoint(pointX, pointY, realAngle, smallRadius);
                graphic.drawLine(pointX, pointY, (int) IcPoint.getX(), (int) IcPoint.getY());
                addArray(graphic, (int) IcPoint.getX(), (int) IcPoint.getY(), -(180 - realAngle));
                graphic.setFont(new Font(null, Font.BOLD + Font.BOLD, 14));
                graphic.drawString("Ic", (int) IcPoint.getX() - 15, (int) IcPoint.getY() + 5);
            }
        }
        graphic.dispose();
        return image;
    }

    /**
     * 从原点开始计算线段的另个一个点
     * 
     * @param intX 原点x
     * @param intY 原点y
     * @param angle 线段从x轴旋转的角度 +逆时针 -顺时针
     * @param lineLength 线段长度
     * @return
     */
    public static Point getSelfPoint(int intX, int intY, double angle, int lineLength) {
        double radians = Math.toRadians(angle);
        int addX = (int) (lineLength * Math.cos(radians));
        int addY = (int) (lineLength * Math.sin(radians));
        Point point = new Point(intX + addX, intY - addY);
        return point;
    }

    /**
     * 自定义画线,包含箭头
     * 
     * @param graphic
     * @param intX 起点x
     * @param intY 起点y
     * @param angle 从x轴算起的角度
     * @param lineLength 线段长度
     */
    public static void drawSelfLine(Graphics graphic, int intX, int intY, Point point, double angle) {
        graphic.drawLine(intX, intY, (int) point.getX(), (int) point.getY());
        addArray(graphic, (int) point.getX(), (int) point.getY(), angle);
    }

    /**
     * 给点添加箭头,算法：默认箭头的中间轴和x轴重合，箭头从原点可以+-角度旋转。
     * 
     * @param graphic
     * @param intX 起点X
     * @param intY 起点Y
     * @param angle 箭头旋转角度 逆时针转动是角度值是正数，顺时针转动角度是负数
     */
    public static void addArray(Graphics graphic, int intX, int intY, double angle) {
        double arrayRadians = Math.toRadians(-20 + angle);
        int arrayAaddX = (int) (10 * Math.cos(arrayRadians));
        int arrayAddY = (int) (10 * Math.sin(arrayRadians));

        double arrayRadians2 = Math.toRadians(20 + angle);
        int arrayAaddX2 = (int) (10 * Math.cos(arrayRadians2));
        int arrayAddY2 = (int) (10 * Math.sin(arrayRadians2));

        graphic.drawLine(intX, intY, intX + arrayAaddX, intY - arrayAddY); // 左边箭头
        graphic.drawLine(intX, intY, intX + arrayAaddX2, intY - arrayAddY2);
    }

    public static Map<String, BufferedImage> getImage() {
        StringBuffer sb = new StringBuffer();
        BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics graphic = image.getGraphics();
        graphic.setColor(Color.LIGHT_GRAY);
        graphic.fillRect(0, 0, WIDTH, HEIGHT);
        Random ran = new Random();
        // 画随机字符
        for (int i = 1; i <= SIZE; i++) {

            int r = ran.nextInt(chars.length);
            graphic.setColor(getRandomColor());
            graphic.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
            graphic.drawString(chars[r], (i - 1) * WIDTH / SIZE, HEIGHT / 2);
            sb.append(chars[r]);// 将字符保存，存入Session
        }
        // 画干扰线
        for (int i = 1; i <= LINES; i++) {
            graphic.setColor(getRandomColor());
            graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
        }
        Map<String, BufferedImage> map = new HashMap<String, BufferedImage>();
        map.put(sb.toString(), image);
        return map;
    }

    private static Color getRandomColor() {
        Random ran = new Random();
        Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
        // System.out.println(color.get());
        return color;
    }

    /**
     * 将BufferedImage持有的图像转化为指定图像格式的字节数组。
     * 
     * @param bufferedImage 图像。
     * @param formatName 图像格式名称。
     * @return 指定图像格式的字节数组。
     * @throws java.io.IOException IO异常。
     */
    public static byte[] imageToByte(final BufferedImage bufferedImage, final String formatName) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, formatName, output);
        try {
            return output.toByteArray();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    /**
     * 判断文件是否是图片，如果是，返回true，否则，返回false
     * 
     * @param file 需要验证的File文件
     * @return true or false
     * @throws IOException
     */
    public static Boolean fileIsImage(File file) throws Exception {
        // 将文件转换成输入流
        try {
            InputStream is = new FileInputStream(file);
            // 用image IO读取文件，如果文件file不是图片，则为null
            BufferedImage image = ImageIO.read(is);
            if (image != null) { // 如果image不为空，则说明file文件是图片
                return true;
            }
        } catch (Exception e) {
            throw new RuntimeException("必须上传图片类型文件!");
        }
        return false;
    }

    /**
     * @param srcfile 源文件
     * @param dist 存储地址
     * @return
     */
    public static boolean createThumbnailSmall(File srcfile, String dist) {
        try {
            if (!srcfile.exists()) {
                return false;
            }

            BufferedImage image = ImageIO.read(srcfile);
            FileOutputStream os = new FileOutputStream(dist);
            // JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
            // encoder.encode(image);
            ImageIO.write(image, "jpeg", os);
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static Map<String, Object> uploadImg(File upload, Object id, ImgTypeEnum imgType, String servletRealPath) throws Exception {
        // Globals.IMG_HEAD_URL
        Map<String, Object> map = new HashMap<String, Object>();
        String imgPathName = "";
        String destFileName = "";
        String realFileName = "";
        String realUrl = "";
        String msg = "success";
        String url = "";
        String imgSuffix = ".jpg";
        if (upload == null) {
            msg = "上传图片为空！！";
        } else if (!ImageUtil.fileIsImage(upload)) {
            msg = "必须上传图片类型文件！！";
        }
        if ("success".equals(msg)) {
            if (id instanceof Date) {
                Date date = (Date) id;
                imgPathName = imgType.getFilename() + date.getTime() + imgSuffix;
            } else {
                imgPathName = imgType.getFilename() + id + imgSuffix;
            }
            destFileName = servletRealPath + File.separator + imgType.getFilepath();
            realUrl = Globals.IMG_DATA_FILE + File.separator + imgType.getFilepath() + File.separator + imgPathName;
            realFileName = destFileName + File.separator + imgPathName;
            realUrl = realUrl.replaceAll("\\\\", "/");
            File f = new File(destFileName);
            if (!f.exists()) {
                f.mkdirs();
            }
            if (ImageUtil.createThumbnailSmall(upload, realFileName)) {
                url = realUrl;
            } else {
                msg = "上传图片失败！！";
            }
        }
        map.put("msg", msg);
        map.put("url", url);
        return map;
    }

    public static Map<String, Object> uploadDoc(File doc, int id, String docType, String servletRealPath) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String msg = "success";
        String docName = "";
        if (doc != null) {
            if (Globals.TYPE_DOC.equals(docType)) {
                docName = Globals.KEY_PILE_TEMP_DOC + id + Globals.TYPE_DOC;
            } else if (Globals.TYPE_PDF.equals(docType)) {
                docName = Globals.KEY_PILE_TEMP_DOC + id + Globals.TYPE_PDF;
            }
            String realFileName = servletRealPath + File.separator + Globals.DOC_PILE_TEMP_FILE + File.separator + docName;
            File file = new File(realFileName);
            String url = Globals.IMG_DATA_FILE + File.separator + Globals.DOC_PILE_TEMP_FILE + File.separator + docName;
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            url = url.replaceAll("\\\\", "/");
            map.put("url", url);
            FileUtil.copyFile(doc, file);
        } else {
            msg = "上传文件不能为空！！";
        }
        map.put("msg", msg);
        return map;
    }

}
