package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class NotifyEmailType implements Serializable {
    private String htmlBody;
    private String subject;
    private String textBody;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NotifyEmailType)) {
            return false;
        }
        NotifyEmailType notifyEmailType = (NotifyEmailType) obj;
        if (notifyEmailType.getSubject() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getSubject() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (notifyEmailType.getSubject() != null && !notifyEmailType.getSubject().equals(getSubject())) {
            return false;
        }
        if (notifyEmailType.getHtmlBody() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getHtmlBody() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (notifyEmailType.getHtmlBody() != null && !notifyEmailType.getHtmlBody().equals(getHtmlBody())) {
            return false;
        }
        if (notifyEmailType.getTextBody() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getTextBody() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (notifyEmailType.getTextBody() == null || notifyEmailType.getTextBody().equals(getTextBody())) {
            return true;
        }
        return false;
    }

    public String getHtmlBody() {
        return this.htmlBody;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getTextBody() {
        return this.textBody;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getSubject() == null) {
            hashCode = 0;
        } else {
            hashCode = getSubject().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getHtmlBody() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getHtmlBody().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getTextBody() != null) {
            i10 = getTextBody().hashCode();
        }
        return i12 + i10;
    }

    public void setHtmlBody(String str) {
        this.htmlBody = str;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public void setTextBody(String str) {
        this.textBody = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSubject() != null) {
            sb.append("Subject: " + getSubject() + ",");
        }
        if (getHtmlBody() != null) {
            sb.append("HtmlBody: " + getHtmlBody() + ",");
        }
        if (getTextBody() != null) {
            sb.append("TextBody: " + getTextBody());
        }
        sb.append("}");
        return sb.toString();
    }

    public NotifyEmailType withHtmlBody(String str) {
        this.htmlBody = str;
        return this;
    }

    public NotifyEmailType withSubject(String str) {
        this.subject = str;
        return this;
    }

    public NotifyEmailType withTextBody(String str) {
        this.textBody = str;
        return this;
    }
}
