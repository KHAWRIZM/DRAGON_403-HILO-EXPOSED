package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AccountTakeoverActionType implements Serializable {
    private String eventAction;
    private Boolean notify;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccountTakeoverActionType)) {
            return false;
        }
        AccountTakeoverActionType accountTakeoverActionType = (AccountTakeoverActionType) obj;
        if (accountTakeoverActionType.getNotify() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getNotify() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (accountTakeoverActionType.getNotify() != null && !accountTakeoverActionType.getNotify().equals(getNotify())) {
            return false;
        }
        if (accountTakeoverActionType.getEventAction() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getEventAction() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (accountTakeoverActionType.getEventAction() == null || accountTakeoverActionType.getEventAction().equals(getEventAction())) {
            return true;
        }
        return false;
    }

    public String getEventAction() {
        return this.eventAction;
    }

    public Boolean getNotify() {
        return this.notify;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getNotify() == null) {
            hashCode = 0;
        } else {
            hashCode = getNotify().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getEventAction() != null) {
            i10 = getEventAction().hashCode();
        }
        return i11 + i10;
    }

    public Boolean isNotify() {
        return this.notify;
    }

    public void setEventAction(String str) {
        this.eventAction = str;
    }

    public void setNotify(Boolean bool) {
        this.notify = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getNotify() != null) {
            sb.append("Notify: " + getNotify() + ",");
        }
        if (getEventAction() != null) {
            sb.append("EventAction: " + getEventAction());
        }
        sb.append("}");
        return sb.toString();
    }

    public AccountTakeoverActionType withEventAction(String str) {
        this.eventAction = str;
        return this;
    }

    public AccountTakeoverActionType withNotify(Boolean bool) {
        this.notify = bool;
        return this;
    }

    public void setEventAction(AccountTakeoverEventActionType accountTakeoverEventActionType) {
        this.eventAction = accountTakeoverEventActionType.toString();
    }

    public AccountTakeoverActionType withEventAction(AccountTakeoverEventActionType accountTakeoverEventActionType) {
        this.eventAction = accountTakeoverEventActionType.toString();
        return this;
    }
}
