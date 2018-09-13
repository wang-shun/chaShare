package com.holley.common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class TestUtil {

    public static void writeFile(String content, String path) {
        FileOutputStream fos = null;
        BufferedWriter bw = null;
        try {
            File file = new File(path);
            fos = new FileOutputStream(file);
            bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
            bw.write(content);
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null) bw.close();
                if (fos != null) fos.close();
            } catch (IOException ie) {
            }
        }
    }

    /*
     * public static String convert2Html(String fileName, String path) throws TransformerException, IOException,
     * ParserConfigurationException { HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(fileName));//
     * WordToHtmlUtils.loadDoc(new // FileInputStream(inputFile)); WordToHtmlConverter wordToHtmlConverter = new
     * WordToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
     * wordToHtmlConverter.setPicturesManager(new PicturesManager() { public String savePicture(byte[] content,
     * PictureType pictureType, String suggestedName) { return suggestedName; } });
     * wordToHtmlConverter.processDocument(wordDocument); // save pictures List pics =
     * wordDocument.getPicturesTable().getAllPictures(); if (pics != null) { for (int i = 0; i < pics.size(); i++) {
     * Picture pic = (Picture) pics.get(i); try { pic.writeImageContent(new FileOutputStream(path +
     * pic.suggestFullFileName())); } catch (FileNotFoundException e) { e.printStackTrace(); } } } Document htmlDocument
     * = wordToHtmlConverter.getDocument(); ByteArrayOutputStream out = new ByteArrayOutputStream(); DOMSource domSource
     * = new DOMSource(htmlDocument); StreamResult streamResult = new StreamResult(out); TransformerFactory tf =
     * TransformerFactory.newInstance(); Transformer serializer = tf.newTransformer();
     * serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); serializer.setOutputProperty(OutputKeys.INDENT,
     * "yes"); serializer.setOutputProperty(OutputKeys.METHOD, "html"); serializer.transform(domSource, streamResult);
     * out.close(); return new String(out.toByteArray()); // writeFile(new String(out.toByteArray()), outPutFile); }
     */
}
