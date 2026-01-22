package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CreateGrantResult implements Serializable {
    private String grantId;
    private String grantToken;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateGrantResult)) {
            return false;
        }
        CreateGrantResult createGrantResult = (CreateGrantResult) obj;
        if (createGrantResult.getGrantToken() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getGrantToken() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (createGrantResult.getGrantToken() != null && !createGrantResult.getGrantToken().equals(getGrantToken())) {
            return false;
        }
        if (createGrantResult.getGrantId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getGrantId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (createGrantResult.getGrantId() == null || createGrantResult.getGrantId().equals(getGrantId())) {
            return true;
        }
        return false;
    }

    public String getGrantId() {
        return this.grantId;
    }

    public String getGrantToken() {
        return this.grantToken;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getGrantToken() == null) {
            hashCode = 0;
        } else {
            hashCode = getGrantToken().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getGrantId() != null) {
            i10 = getGrantId().hashCode();
        }
        return i11 + i10;
    }

    public void setGrantId(String str) {
        this.grantId = str;
    }

    public void setGrantToken(String str) {
        this.grantToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getGrantToken() != null) {
            sb.append("GrantToken: " + getGrantToken() + ",");
        }
        if (getGrantId() != null) {
            sb.append("GrantId: " + getGrantId());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateGrantResult withGrantId(String str) {
        this.grantId = str;
        return this;
    }

    public CreateGrantResult withGrantToken(String str) {
        this.grantToken = str;
        return this;
    }
}
