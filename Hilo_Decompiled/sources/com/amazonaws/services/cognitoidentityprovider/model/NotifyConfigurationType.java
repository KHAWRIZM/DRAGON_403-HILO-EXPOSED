package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class NotifyConfigurationType implements Serializable {
    private NotifyEmailType blockEmail;
    private String from;
    private NotifyEmailType mfaEmail;
    private NotifyEmailType noActionEmail;
    private String replyTo;
    private String sourceArn;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NotifyConfigurationType)) {
            return false;
        }
        NotifyConfigurationType notifyConfigurationType = (NotifyConfigurationType) obj;
        if (notifyConfigurationType.getFrom() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getFrom() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (notifyConfigurationType.getFrom() != null && !notifyConfigurationType.getFrom().equals(getFrom())) {
            return false;
        }
        if (notifyConfigurationType.getReplyTo() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getReplyTo() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (notifyConfigurationType.getReplyTo() != null && !notifyConfigurationType.getReplyTo().equals(getReplyTo())) {
            return false;
        }
        if (notifyConfigurationType.getSourceArn() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getSourceArn() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (notifyConfigurationType.getSourceArn() != null && !notifyConfigurationType.getSourceArn().equals(getSourceArn())) {
            return false;
        }
        if (notifyConfigurationType.getBlockEmail() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getBlockEmail() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (notifyConfigurationType.getBlockEmail() != null && !notifyConfigurationType.getBlockEmail().equals(getBlockEmail())) {
            return false;
        }
        if (notifyConfigurationType.getNoActionEmail() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getNoActionEmail() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (notifyConfigurationType.getNoActionEmail() != null && !notifyConfigurationType.getNoActionEmail().equals(getNoActionEmail())) {
            return false;
        }
        if (notifyConfigurationType.getMfaEmail() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getMfaEmail() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (notifyConfigurationType.getMfaEmail() == null || notifyConfigurationType.getMfaEmail().equals(getMfaEmail())) {
            return true;
        }
        return false;
    }

    public NotifyEmailType getBlockEmail() {
        return this.blockEmail;
    }

    public String getFrom() {
        return this.from;
    }

    public NotifyEmailType getMfaEmail() {
        return this.mfaEmail;
    }

    public NotifyEmailType getNoActionEmail() {
        return this.noActionEmail;
    }

    public String getReplyTo() {
        return this.replyTo;
    }

    public String getSourceArn() {
        return this.sourceArn;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int i10 = 0;
        if (getFrom() == null) {
            hashCode = 0;
        } else {
            hashCode = getFrom().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getReplyTo() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getReplyTo().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getSourceArn() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getSourceArn().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getBlockEmail() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getBlockEmail().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getNoActionEmail() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getNoActionEmail().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getMfaEmail() != null) {
            i10 = getMfaEmail().hashCode();
        }
        return i15 + i10;
    }

    public void setBlockEmail(NotifyEmailType notifyEmailType) {
        this.blockEmail = notifyEmailType;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setMfaEmail(NotifyEmailType notifyEmailType) {
        this.mfaEmail = notifyEmailType;
    }

    public void setNoActionEmail(NotifyEmailType notifyEmailType) {
        this.noActionEmail = notifyEmailType;
    }

    public void setReplyTo(String str) {
        this.replyTo = str;
    }

    public void setSourceArn(String str) {
        this.sourceArn = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getFrom() != null) {
            sb.append("From: " + getFrom() + ",");
        }
        if (getReplyTo() != null) {
            sb.append("ReplyTo: " + getReplyTo() + ",");
        }
        if (getSourceArn() != null) {
            sb.append("SourceArn: " + getSourceArn() + ",");
        }
        if (getBlockEmail() != null) {
            sb.append("BlockEmail: " + getBlockEmail() + ",");
        }
        if (getNoActionEmail() != null) {
            sb.append("NoActionEmail: " + getNoActionEmail() + ",");
        }
        if (getMfaEmail() != null) {
            sb.append("MfaEmail: " + getMfaEmail());
        }
        sb.append("}");
        return sb.toString();
    }

    public NotifyConfigurationType withBlockEmail(NotifyEmailType notifyEmailType) {
        this.blockEmail = notifyEmailType;
        return this;
    }

    public NotifyConfigurationType withFrom(String str) {
        this.from = str;
        return this;
    }

    public NotifyConfigurationType withMfaEmail(NotifyEmailType notifyEmailType) {
        this.mfaEmail = notifyEmailType;
        return this;
    }

    public NotifyConfigurationType withNoActionEmail(NotifyEmailType notifyEmailType) {
        this.noActionEmail = notifyEmailType;
        return this;
    }

    public NotifyConfigurationType withReplyTo(String str) {
        this.replyTo = str;
        return this;
    }

    public NotifyConfigurationType withSourceArn(String str) {
        this.sourceArn = str;
        return this;
    }
}
