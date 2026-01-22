package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class VerificationMessageTemplateType implements Serializable {
    private String defaultEmailOption;
    private String emailMessage;
    private String emailMessageByLink;
    private String emailSubject;
    private String emailSubjectByLink;
    private String smsMessage;

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
        if (obj == null || !(obj instanceof VerificationMessageTemplateType)) {
            return false;
        }
        VerificationMessageTemplateType verificationMessageTemplateType = (VerificationMessageTemplateType) obj;
        if (verificationMessageTemplateType.getSmsMessage() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getSmsMessage() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (verificationMessageTemplateType.getSmsMessage() != null && !verificationMessageTemplateType.getSmsMessage().equals(getSmsMessage())) {
            return false;
        }
        if (verificationMessageTemplateType.getEmailMessage() == null) {
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
        if (verificationMessageTemplateType.getEmailMessage() != null && !verificationMessageTemplateType.getEmailMessage().equals(getEmailMessage())) {
            return false;
        }
        if (verificationMessageTemplateType.getEmailSubject() == null) {
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
        if (verificationMessageTemplateType.getEmailSubject() != null && !verificationMessageTemplateType.getEmailSubject().equals(getEmailSubject())) {
            return false;
        }
        if (verificationMessageTemplateType.getEmailMessageByLink() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getEmailMessageByLink() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (verificationMessageTemplateType.getEmailMessageByLink() != null && !verificationMessageTemplateType.getEmailMessageByLink().equals(getEmailMessageByLink())) {
            return false;
        }
        if (verificationMessageTemplateType.getEmailSubjectByLink() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getEmailSubjectByLink() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (verificationMessageTemplateType.getEmailSubjectByLink() != null && !verificationMessageTemplateType.getEmailSubjectByLink().equals(getEmailSubjectByLink())) {
            return false;
        }
        if (verificationMessageTemplateType.getDefaultEmailOption() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getDefaultEmailOption() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (verificationMessageTemplateType.getDefaultEmailOption() == null || verificationMessageTemplateType.getDefaultEmailOption().equals(getDefaultEmailOption())) {
            return true;
        }
        return false;
    }

    public String getDefaultEmailOption() {
        return this.defaultEmailOption;
    }

    public String getEmailMessage() {
        return this.emailMessage;
    }

    public String getEmailMessageByLink() {
        return this.emailMessageByLink;
    }

    public String getEmailSubject() {
        return this.emailSubject;
    }

    public String getEmailSubjectByLink() {
        return this.emailSubjectByLink;
    }

    public String getSmsMessage() {
        return this.smsMessage;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int i10 = 0;
        if (getSmsMessage() == null) {
            hashCode = 0;
        } else {
            hashCode = getSmsMessage().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getEmailMessage() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getEmailMessage().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getEmailSubject() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getEmailSubject().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getEmailMessageByLink() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getEmailMessageByLink().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getEmailSubjectByLink() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getEmailSubjectByLink().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getDefaultEmailOption() != null) {
            i10 = getDefaultEmailOption().hashCode();
        }
        return i15 + i10;
    }

    public void setDefaultEmailOption(String str) {
        this.defaultEmailOption = str;
    }

    public void setEmailMessage(String str) {
        this.emailMessage = str;
    }

    public void setEmailMessageByLink(String str) {
        this.emailMessageByLink = str;
    }

    public void setEmailSubject(String str) {
        this.emailSubject = str;
    }

    public void setEmailSubjectByLink(String str) {
        this.emailSubjectByLink = str;
    }

    public void setSmsMessage(String str) {
        this.smsMessage = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSmsMessage() != null) {
            sb.append("SmsMessage: " + getSmsMessage() + ",");
        }
        if (getEmailMessage() != null) {
            sb.append("EmailMessage: " + getEmailMessage() + ",");
        }
        if (getEmailSubject() != null) {
            sb.append("EmailSubject: " + getEmailSubject() + ",");
        }
        if (getEmailMessageByLink() != null) {
            sb.append("EmailMessageByLink: " + getEmailMessageByLink() + ",");
        }
        if (getEmailSubjectByLink() != null) {
            sb.append("EmailSubjectByLink: " + getEmailSubjectByLink() + ",");
        }
        if (getDefaultEmailOption() != null) {
            sb.append("DefaultEmailOption: " + getDefaultEmailOption());
        }
        sb.append("}");
        return sb.toString();
    }

    public VerificationMessageTemplateType withDefaultEmailOption(String str) {
        this.defaultEmailOption = str;
        return this;
    }

    public VerificationMessageTemplateType withEmailMessage(String str) {
        this.emailMessage = str;
        return this;
    }

    public VerificationMessageTemplateType withEmailMessageByLink(String str) {
        this.emailMessageByLink = str;
        return this;
    }

    public VerificationMessageTemplateType withEmailSubject(String str) {
        this.emailSubject = str;
        return this;
    }

    public VerificationMessageTemplateType withEmailSubjectByLink(String str) {
        this.emailSubjectByLink = str;
        return this;
    }

    public VerificationMessageTemplateType withSmsMessage(String str) {
        this.smsMessage = str;
        return this;
    }

    public void setDefaultEmailOption(DefaultEmailOptionType defaultEmailOptionType) {
        this.defaultEmailOption = defaultEmailOptionType.toString();
    }

    public VerificationMessageTemplateType withDefaultEmailOption(DefaultEmailOptionType defaultEmailOptionType) {
        this.defaultEmailOption = defaultEmailOptionType.toString();
        return this;
    }
}
