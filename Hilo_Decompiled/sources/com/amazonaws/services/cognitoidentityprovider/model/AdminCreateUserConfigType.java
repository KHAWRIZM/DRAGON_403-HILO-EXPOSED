package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminCreateUserConfigType implements Serializable {
    private Boolean allowAdminCreateUserOnly;
    private MessageTemplateType inviteMessageTemplate;
    private Integer unusedAccountValidityDays;

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
        if (obj == null || !(obj instanceof AdminCreateUserConfigType)) {
            return false;
        }
        AdminCreateUserConfigType adminCreateUserConfigType = (AdminCreateUserConfigType) obj;
        if (adminCreateUserConfigType.getAllowAdminCreateUserOnly() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getAllowAdminCreateUserOnly() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (adminCreateUserConfigType.getAllowAdminCreateUserOnly() != null && !adminCreateUserConfigType.getAllowAdminCreateUserOnly().equals(getAllowAdminCreateUserOnly())) {
            return false;
        }
        if (adminCreateUserConfigType.getUnusedAccountValidityDays() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getUnusedAccountValidityDays() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (adminCreateUserConfigType.getUnusedAccountValidityDays() != null && !adminCreateUserConfigType.getUnusedAccountValidityDays().equals(getUnusedAccountValidityDays())) {
            return false;
        }
        if (adminCreateUserConfigType.getInviteMessageTemplate() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getInviteMessageTemplate() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (adminCreateUserConfigType.getInviteMessageTemplate() == null || adminCreateUserConfigType.getInviteMessageTemplate().equals(getInviteMessageTemplate())) {
            return true;
        }
        return false;
    }

    public Boolean getAllowAdminCreateUserOnly() {
        return this.allowAdminCreateUserOnly;
    }

    public MessageTemplateType getInviteMessageTemplate() {
        return this.inviteMessageTemplate;
    }

    public Integer getUnusedAccountValidityDays() {
        return this.unusedAccountValidityDays;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getAllowAdminCreateUserOnly() == null) {
            hashCode = 0;
        } else {
            hashCode = getAllowAdminCreateUserOnly().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getUnusedAccountValidityDays() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getUnusedAccountValidityDays().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getInviteMessageTemplate() != null) {
            i10 = getInviteMessageTemplate().hashCode();
        }
        return i12 + i10;
    }

    public Boolean isAllowAdminCreateUserOnly() {
        return this.allowAdminCreateUserOnly;
    }

    public void setAllowAdminCreateUserOnly(Boolean bool) {
        this.allowAdminCreateUserOnly = bool;
    }

    public void setInviteMessageTemplate(MessageTemplateType messageTemplateType) {
        this.inviteMessageTemplate = messageTemplateType;
    }

    public void setUnusedAccountValidityDays(Integer num) {
        this.unusedAccountValidityDays = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAllowAdminCreateUserOnly() != null) {
            sb.append("AllowAdminCreateUserOnly: " + getAllowAdminCreateUserOnly() + ",");
        }
        if (getUnusedAccountValidityDays() != null) {
            sb.append("UnusedAccountValidityDays: " + getUnusedAccountValidityDays() + ",");
        }
        if (getInviteMessageTemplate() != null) {
            sb.append("InviteMessageTemplate: " + getInviteMessageTemplate());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminCreateUserConfigType withAllowAdminCreateUserOnly(Boolean bool) {
        this.allowAdminCreateUserOnly = bool;
        return this;
    }

    public AdminCreateUserConfigType withInviteMessageTemplate(MessageTemplateType messageTemplateType) {
        this.inviteMessageTemplate = messageTemplateType;
        return this;
    }

    public AdminCreateUserConfigType withUnusedAccountValidityDays(Integer num) {
        this.unusedAccountValidityDays = num;
        return this;
    }
}
