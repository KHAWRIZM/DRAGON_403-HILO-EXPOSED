package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class EmailConfigurationType implements Serializable {
    private String configurationSet;
    private String emailSendingAccount;
    private String from;
    private String replyToEmailAddress;
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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof EmailConfigurationType)) {
            return false;
        }
        EmailConfigurationType emailConfigurationType = (EmailConfigurationType) obj;
        if (emailConfigurationType.getSourceArn() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getSourceArn() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (emailConfigurationType.getSourceArn() != null && !emailConfigurationType.getSourceArn().equals(getSourceArn())) {
            return false;
        }
        if (emailConfigurationType.getReplyToEmailAddress() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getReplyToEmailAddress() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (emailConfigurationType.getReplyToEmailAddress() != null && !emailConfigurationType.getReplyToEmailAddress().equals(getReplyToEmailAddress())) {
            return false;
        }
        if (emailConfigurationType.getEmailSendingAccount() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getEmailSendingAccount() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (emailConfigurationType.getEmailSendingAccount() != null && !emailConfigurationType.getEmailSendingAccount().equals(getEmailSendingAccount())) {
            return false;
        }
        if (emailConfigurationType.getFrom() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getFrom() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (emailConfigurationType.getFrom() != null && !emailConfigurationType.getFrom().equals(getFrom())) {
            return false;
        }
        if (emailConfigurationType.getConfigurationSet() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getConfigurationSet() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (emailConfigurationType.getConfigurationSet() == null || emailConfigurationType.getConfigurationSet().equals(getConfigurationSet())) {
            return true;
        }
        return false;
    }

    public String getConfigurationSet() {
        return this.configurationSet;
    }

    public String getEmailSendingAccount() {
        return this.emailSendingAccount;
    }

    public String getFrom() {
        return this.from;
    }

    public String getReplyToEmailAddress() {
        return this.replyToEmailAddress;
    }

    public String getSourceArn() {
        return this.sourceArn;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i10 = 0;
        if (getSourceArn() == null) {
            hashCode = 0;
        } else {
            hashCode = getSourceArn().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getReplyToEmailAddress() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getReplyToEmailAddress().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getEmailSendingAccount() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getEmailSendingAccount().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getFrom() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getFrom().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getConfigurationSet() != null) {
            i10 = getConfigurationSet().hashCode();
        }
        return i14 + i10;
    }

    public void setConfigurationSet(String str) {
        this.configurationSet = str;
    }

    public void setEmailSendingAccount(String str) {
        this.emailSendingAccount = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setReplyToEmailAddress(String str) {
        this.replyToEmailAddress = str;
    }

    public void setSourceArn(String str) {
        this.sourceArn = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSourceArn() != null) {
            sb.append("SourceArn: " + getSourceArn() + ",");
        }
        if (getReplyToEmailAddress() != null) {
            sb.append("ReplyToEmailAddress: " + getReplyToEmailAddress() + ",");
        }
        if (getEmailSendingAccount() != null) {
            sb.append("EmailSendingAccount: " + getEmailSendingAccount() + ",");
        }
        if (getFrom() != null) {
            sb.append("From: " + getFrom() + ",");
        }
        if (getConfigurationSet() != null) {
            sb.append("ConfigurationSet: " + getConfigurationSet());
        }
        sb.append("}");
        return sb.toString();
    }

    public EmailConfigurationType withConfigurationSet(String str) {
        this.configurationSet = str;
        return this;
    }

    public EmailConfigurationType withEmailSendingAccount(String str) {
        this.emailSendingAccount = str;
        return this;
    }

    public EmailConfigurationType withFrom(String str) {
        this.from = str;
        return this;
    }

    public EmailConfigurationType withReplyToEmailAddress(String str) {
        this.replyToEmailAddress = str;
        return this;
    }

    public EmailConfigurationType withSourceArn(String str) {
        this.sourceArn = str;
        return this;
    }

    public void setEmailSendingAccount(EmailSendingAccountType emailSendingAccountType) {
        this.emailSendingAccount = emailSendingAccountType.toString();
    }

    public EmailConfigurationType withEmailSendingAccount(EmailSendingAccountType emailSendingAccountType) {
        this.emailSendingAccount = emailSendingAccountType.toString();
        return this;
    }
}
