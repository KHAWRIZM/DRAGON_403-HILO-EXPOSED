package org.xmlpull.v1;

import java.io.PrintStream;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class XmlPullParserException extends Exception {
    protected int column;
    protected Throwable detail;
    protected int row;

    public XmlPullParserException(String str) {
        super(str);
        this.row = -1;
        this.column = -1;
    }

    public int getColumnNumber() {
        return this.column;
    }

    public Throwable getDetail() {
        return this.detail;
    }

    public int getLineNumber() {
        return this.row;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.detail == null) {
            super.printStackTrace();
            return;
        }
        PrintStream printStream = System.err;
        synchronized (printStream) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(super.getMessage());
            stringBuffer.append("; nested exception is:");
            printStream.println(stringBuffer.toString());
            this.detail.printStackTrace();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public XmlPullParserException(String str, XmlPullParser xmlPullParser, Throwable th) {
        super(r0.toString());
        String stringBuffer;
        String stringBuffer2;
        StringBuffer stringBuffer3 = new StringBuffer();
        String str2 = "";
        if (str == null) {
            stringBuffer = "";
        } else {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(str);
            stringBuffer4.append(" ");
            stringBuffer = stringBuffer4.toString();
        }
        stringBuffer3.append(stringBuffer);
        if (xmlPullParser == null) {
            stringBuffer2 = "";
        } else {
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("(position:");
            stringBuffer5.append(xmlPullParser.getPositionDescription());
            stringBuffer5.append(") ");
            stringBuffer2 = stringBuffer5.toString();
        }
        stringBuffer3.append(stringBuffer2);
        if (th != null) {
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("caused by: ");
            stringBuffer6.append(th);
            str2 = stringBuffer6.toString();
        }
        stringBuffer3.append(str2);
        this.row = -1;
        this.column = -1;
        if (xmlPullParser != null) {
            this.row = xmlPullParser.getLineNumber();
            this.column = xmlPullParser.getColumnNumber();
        }
        this.detail = th;
    }
}
