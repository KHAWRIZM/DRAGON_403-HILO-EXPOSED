package com.amazonaws.services.s3.internal;

import com.amazonaws.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class XmlWriter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    List<String> tags = new ArrayList();
    StringBuilder sb = new StringBuilder();

    private void appendEscapedString(String str, StringBuilder sb) {
        String str2;
        if (str == null) {
            str = "";
        }
        int length = str.length();
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            char charAt = str.charAt(i10);
            if (charAt != '\t') {
                if (charAt != '\n') {
                    if (charAt != '\r') {
                        if (charAt != '\"') {
                            if (charAt != '&') {
                                if (charAt != '<') {
                                    if (charAt != '>') {
                                        str2 = null;
                                    } else {
                                        str2 = "&gt;";
                                    }
                                } else {
                                    str2 = "&lt;";
                                }
                            } else {
                                str2 = "&amp;";
                            }
                        } else {
                            str2 = "&quot;";
                        }
                    } else {
                        str2 = "&#13;";
                    }
                } else {
                    str2 = "&#10;";
                }
            } else {
                str2 = "&#9;";
            }
            if (str2 != null) {
                if (i11 < i10) {
                    sb.append((CharSequence) str, i11, i10);
                }
                this.sb.append(str2);
                i11 = i10 + 1;
            }
            i10++;
        }
        if (i11 < i10) {
            this.sb.append((CharSequence) str, i11, i10);
        }
    }

    private void writeAttr(String str, String str2) {
        StringBuilder sb = this.sb;
        sb.append(' ');
        sb.append(str);
        sb.append("=\"");
        appendEscapedString(str2, this.sb);
        this.sb.append("\"");
    }

    public XmlWriter end() {
        String remove = this.tags.remove(r0.size() - 1);
        StringBuilder sb = this.sb;
        sb.append("</");
        sb.append(remove);
        sb.append(">");
        return this;
    }

    public byte[] getBytes() {
        return toString().getBytes(StringUtils.UTF8);
    }

    public XmlWriter start(String str) {
        StringBuilder sb = this.sb;
        sb.append("<");
        sb.append(str);
        sb.append(">");
        this.tags.add(str);
        return this;
    }

    public String toString() {
        return this.sb.toString();
    }

    public XmlWriter value(String str) {
        appendEscapedString(str, this.sb);
        return this;
    }

    public XmlWriter start(String str, String str2, String str3) {
        StringBuilder sb = this.sb;
        sb.append("<");
        sb.append(str);
        writeAttr(str2, str3);
        this.sb.append(">");
        this.tags.add(str);
        return this;
    }

    public XmlWriter start(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = this.sb;
        sb.append("<");
        sb.append(str);
        for (int i10 = 0; i10 < Math.min(strArr.length, strArr2.length); i10++) {
            writeAttr(strArr[i10], strArr2[i10]);
        }
        this.sb.append(">");
        this.tags.add(str);
        return this;
    }
}
