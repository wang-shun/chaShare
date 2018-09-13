package com.holley.common.xml;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Stack;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlWriter {

    public static String     NL           = System.getProperty("line.separator");
    public static String     elementSpan  = " ";
    private Writer           writer       = null;                                // underlying writer
    private StringBuffer     writerBuffer = null;                                // underlying writerBuffer
    private Stack<String>    stack        = new Stack<String>();                  ; // of xml Element names
    private boolean          empty;                                              // is the current node empty
    private boolean          closed       = true;                                // is the current node closed...
    private String           encoding;
    private FileOutputStream outputStream = null;
    private boolean          linebeak;                                           // is the current node closed...

    /**
     * Create an XmlWriter on top of an existing java.io.Writer.
     */
    private void print(String s) throws IOException {
        linebeak = false;
        if (this.writerBuffer != null) {
            this.writerBuffer.append(s);
        } else if (this.writer != null) {
            this.writer.write(s);
        }
    }

    private void print(char ch) throws IOException {
        if (this.writerBuffer != null) {
            this.writerBuffer.append(ch);
        } else if (this.writer != null) {
            this.writer.write(ch);
        }
    }

    private void println() throws IOException {
        if (!linebeak) {
            print(NL);
            linebeak = true;
        }
    }

    public XmlWriter(StringBuffer writerBuffer) {
        this.writerBuffer = writerBuffer;
    }

    public XmlWriter(Writer writer) {
        this.writer = writer;
    }

    public XmlWriter(String fName, String encoding) throws IOException {
        this.outputStream = new FileOutputStream(fName);
        this.writer = new OutputStreamWriter(outputStream, encoding);
    }

    public XmlWriter(OutputStream outStream, String encoding) throws IOException {
        this.outputStream = null;
        this.writer = new OutputStreamWriter(outStream, encoding);
    }

    public XmlWriter(String fName) throws IOException {
        this.writer = new FileWriter(fName);
    }

    public void dataElement(String name, String content) throws IOException {
        startElement(name);
        closeOpeningTag();
        writeEscapeXml(content);
        endElement();
    }

    /**
     * Begin to output an Element.
     * 
     * @param String name of Element.
     */

    private void fillBlank() throws IOException {
        for (int i = 0; i < stack.size(); i++) {
            print(elementSpan);

        }
    }

    public XmlWriter startElement(String name) throws IOException {
        closeOpeningTag();
        println();
        this.closed = false;
        stack.add(name);
        fillBlank();
        print("<");
        print(name);

        this.empty = true;
        return this;
    }

    // close off the opening tag
    private void closeOpeningTag() throws IOException {
        if (!this.closed) {
            addAttributes();
            this.closed = true;
            print(">");
        }
    }

    // write out all current attributes
    private void addAttributes() throws IOException {
        this.empty = false;
    }

    /**
     * Write an attribute out for the current Element. Any xml characters in the value are escaped. Currently it does
     * not actually throw the exception, but the api is set that way for future changes.
     * 
     * @param String name of attribute.
     * @param String value of attribute.
     */
    public XmlWriter addAttribute(String attr, String value) throws IOException {
        print(" ");
        print(attr);
        print("=\"");
        this.writeEscapeXml(value);
        print("\"");
        return this;
    }

    /**
     * End the current Element. This will throw an exception if it is called when there is not a currently open Element.
     */
    public XmlWriter endElement() throws IOException {
        if (this.stack.empty()) {
            throw new IOException("Called endElement too many times. ");
        }
        if (!this.empty) {
            fillBlank();
        }
        String name = (String) this.stack.pop();
        if (name != null) {
            if (this.empty) {
                addAttributes();
                print("/>");
            } else {
                print("</");
                print(name);
                print(">");
            }
            this.empty = false;
            this.closed = true;
            println();
        }
        return this;
    }

    /**
     * Close this writerBuffer. It does not close the underlying writerBuffer, but does throw an exception if there are
     * as yet unclosed tags.
     */
    public void close() throws IOException {
        if (writer != null) {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
        if (this.outputStream != null) {
            try {
                this.outputStream.close();
            } catch (Exception e) {
            }
        }
    }

    public XmlWriter startDocument(String encoding, boolean standalone) throws IOException {
        print("<?xml ");
        addAttribute("version", "1.0");
        if (encoding != null) {
            addAttribute("encoding", encoding);
        }
        if (standalone) {
            addAttribute("standalone", "yes");
        }
        print("?>");
        println();
        this.setEncoding(encoding);
        return this;
    }

    /**
     * Output body text. Any xml characters are escaped.
     */
    public XmlWriter characters(String text) throws IOException {
        closeOpeningTag();
        this.empty = false;
        this.writeEscapeXml(text);
        return this;
    }

    public XmlWriter raw(String text) throws IOException {
        print(text);
        return this;
    }

    public XmlWriter CDATA(String text) throws IOException {
        closeOpeningTag();
        print("<![CDATA[");
        print(text);
        print("]]>");
        this.empty = false;
        return this;
    }

    public XmlWriter comment(String text) throws IOException {
        closeOpeningTag();
        print("<!--");
        print(text);
        print("-->");
        this.empty = false;
        return this;

    }

    public XmlWriter processingInstruction(String name, String value) throws IOException {
        closeOpeningTag();
        print("<?");
        print(name);
        print(" ");
        print(value);
        print("?>");
        this.empty = false;
        return this;

    }

    public XmlWriter reference(String text) throws IOException {
        closeOpeningTag();
        print("&");
        print(text);
        print(";");
        this.empty = false;
        return this;
    }

    static public String xmlEncode(String str) {
        StringBuffer buf = new StringBuffer();
        XmlWriter writer = new XmlWriter(buf);
        try {
            writer.writeEscapeXml(str);
        } catch (Exception e) {
        }
        return buf.toString();

    }

    public void writeEscapeXml(String str) throws IOException {
        int idx, length = str.length();
        char val;

        for (idx = 0; idx < length; idx++) {
            val = str.charAt(idx);

            switch (val) {
                case '\'':
                    print("&apos;");
                    break;
                case '\"':
                    print("&quot;");
                    break;
                case '<':
                    print("&lt;");
                    break;
                case '>':
                    print("&gt;");
                    break;
                case '&':
                    print("&amp;");
                    break;
                default:

                    /*
                     * if((encoding == null)&&(val > 0x7f)) { print("&#"); print(Integer.toString(val)); print(';'); }
                     * else { print(val); }
                     */
                    print(val);
                    break;
            }
        }
    }

    public void endDocument() throws IOException {
        println();
        if (!this.stack.empty()) {
            throw new IOException("Tags are not all closed. " + "Possibly, " + this.stack.pop() + " is unclosed. ");
        }

    }

    public void writeNode(Node node) throws IOException {
        int type = node.getNodeType();

        switch (type) {
            // print the document element
            case Node.DOCUMENT_NODE:
                writeNode(((Document) node).getDocumentElement());
                break;
            // print element with attributes
            case Node.ELEMENT_NODE:
                startElement(node.getNodeName());
                NamedNodeMap attrs = node.getAttributes();
                for (int i = 0; i < attrs.getLength(); i++) {
                    Node attr = attrs.item(i);
                    this.addAttribute(attr.getNodeName(), attr.getNodeValue());
                }
                NodeList children = node.getChildNodes();
                int len = children.getLength();
                for (int i = 0; i < len; i++) {
                    writeNode(children.item(i));
                }
                ;
                this.endElement();
                break;

            // handle ENTITY reference nodes
            case Node.ENTITY_REFERENCE_NODE:
                reference(node.getNodeName());
                break;
            // print cdata sections
            case Node.CDATA_SECTION_NODE:
                this.CDATA(node.getNodeValue());
                break;
            case Node.TEXT_NODE:
                String s = node.getNodeValue().trim();
                if (s.length() > 0) {
                    this.characters(s);
                }
                break;
            // print processing instruction
            case Node.PROCESSING_INSTRUCTION_NODE:
                processingInstruction(node.getNodeName(), node.getNodeValue());
                break;
            case Node.COMMENT_NODE:
                comment(node.getNodeValue());
                break;
        }
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getEncoding() {
        return encoding;
    }

}
