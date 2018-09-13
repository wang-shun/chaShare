package com.holley.common.file;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractXlsWriter {

    private OutputStream out;
    private String       encoding = null;

    public abstract void start();

    public abstract void end();

    public abstract void writeContentCell(int row, short col, Object value) throws Exception;

    public abstract void writeHeaderCell(int row, short col, Object value) throws Exception;

    /**
     * 添加标题
     * 
     * @param title 标题
     * @param colCount 数据的列数数据的列数
     */
    public abstract void addTitle(String title, int colCount) throws Exception;

    public abstract void addTitle(String title, int colCount, boolean isBold) throws Exception;

    protected int        row     = 0;

    private List<Object> errRows = new ArrayList<Object>();

    public void init() {
        setRow(0);
        errRows.clear();
    }

    public void addRow(Object[] record) {
        for (short i = 0; i < record.length; i++) {
            try {
                writeContentCell(this.row, i, record[i]);
            } catch (Exception e) {
                errRows.add(Integer.valueOf(this.row));
            }
        }
        this.row++;
    }

    public void addHeader(Object[] record) {
        for (short i = 0; i < record.length; i++) {
            try {
                writeHeaderCell(this.row, i, record[i]);
            } catch (Exception e) {
                errRows.add(Integer.valueOf(this.row));
            }
        }
        this.row++;
    }

    public void close() {
        try {
            getOut().close();
        } catch (IOException e) {
            // do nothing;
        }
    }

    public OutputStream getOut() {
        return out;
    }

    public void setOut(OutputStream out) {
        this.out = out;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public List<Object> getErrRows() {
        return errRows;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

}
