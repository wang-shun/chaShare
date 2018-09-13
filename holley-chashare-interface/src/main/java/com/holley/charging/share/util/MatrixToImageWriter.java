package com.holley.charging.share.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class MatrixToImageWriter {

    private static final int BLACK = 0xFF000000;
    private static final int WHITE = 0xFFFFFFFF;

    private MatrixToImageWriter() {
    }

    public static BufferedImage toBufferedImage(BitMatrix matrix) {
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
            }
        }
        return image;
    }

    public static void writeToFile(BitMatrix matrix, String format, File file) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, file)) {
            throw new IOException("Could not write an image of format " + format + " to " + file);
        }
    }

    public static void writeToStream(BitMatrix matrix, String format, OutputStream stream) throws IOException {
        BufferedImage image = toBufferedImage(matrix);
        if (!ImageIO.write(image, format, stream)) {
            throw new IOException("Could not write an image of format " + format);
        }
    }

    public static void createCodeStream(String text, HttpServletResponse response) throws Exception {

        // response.setContentType("image/jpeg");
        ServletOutputStream sos = response.getOutputStream();

        int width = 500;
        int height = 500;
        // 二维码的图片格式
        String format = "jpg";
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        Map hints = new HashMap();
        // 内容所使用编码
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

        // 生成二维码

        MatrixToImageWriter.writeToStream(bitMatrix, format, sos);

        sos.close();

    }
}
