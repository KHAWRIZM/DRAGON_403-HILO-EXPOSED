package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MessageTemplateType implements Serializable {
    private String emailMessage;
    private String emailSubject;
    private String sMSMessage;

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
        if (obj == null || !(obj instanceof MessageTemplateType)) {
            return false;
        }
        MessageTemplateType messageTemplateType = (MessageTemplateType) obj;
        if (messageTemplateType.getSMSMessage() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getSMSMessage() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (messageTemplateType.getSMSMessage() != null && !messageTemplateType.getSMSMessage().equals(getSMSMessage())) {
            return false;
        }
        if (messageTemplateType.getEmailMessage() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getEmailMessage() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (messageTemplateType.getEmailMessage() != null && !messageTemplateType.getEmailMessage().equals(getEmailMessage())) {
            return false;
        }
        if (messageTemplateType.getEmailSubject() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getEmailSubject() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (messageTemplateType.getEmailSubject() == null || messageTemplateType.getEmailSubject().equals(getEmailSubject())) {
            return true;
        }
        return false;
    }

    public String getEmailMessage() {
        return this.emailMessage;
    }

    public String getEmailSubject() {
        return this.emailSubject;
    }

    public String getSMSMessage() {
        return this.sMSMessage;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getSMSMessage() == null) {
            hashCode = 0;
        } else {
            hashCode = getSMSMessage().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getEmailMessage() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getEmailMessage().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getEmailSubject() != null) {
            i10 = getEmailSubject().hashCode();
        }
        return i12 + i10;
    }

    public void setEmailMessage(String str) {
        this.emailMessage = str;
    }

    public void setEmailSubject(String str) {
        this.emailSubject = str;
    }

    public void setSMSMessage(String str) {
        this.sMSMessage = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSMSMessage() != null) {
            sb.append("SMSMessage: " + getSMSMessage() + ",");
        }
        if (getEmailMessage() != null) {
            sb.append("EmailMessage: " + getEmailMessage() + ",");
        }
        if (getEmailSubject() != null) {
            sb.append("EmailSubject: " + getEmailSubject());
        }
        sb.append("}");
        return sb.toString();
    }

    public MessageTemplateType withEmailMessage(String str) {
        this.emailMessage = str;
        return this;
    }

    public MessageTemplateType withEmailSubject(String str) {
        this.emailSubject = str;
        return this;
    }

    public MessageTemplateType withSMSMessage(String str) {
        this.sMSMessage = str;
        return this;
    }
}
