package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminSetUserSettingsRequest extends AmazonWebServiceRequest implements Serializable {
    private List<MFAOptionType> mFAOptions;
    private String userPoolId;
    private String username;

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
        if (obj == null || !(obj instanceof AdminSetUserSettingsRequest)) {
            return false;
        }
        AdminSetUserSettingsRequest adminSetUserSettingsRequest = (AdminSetUserSettingsRequest) obj;
        if (adminSetUserSettingsRequest.getUserPoolId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserPoolId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (adminSetUserSettingsRequest.getUserPoolId() != null && !adminSetUserSettingsRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (adminSetUserSettingsRequest.getUsername() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getUsername() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (adminSetUserSettingsRequest.getUsername() != null && !adminSetUserSettingsRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if (adminSetUserSettingsRequest.getMFAOptions() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getMFAOptions() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (adminSetUserSettingsRequest.getMFAOptions() == null || adminSetUserSettingsRequest.getMFAOptions().equals(getMFAOptions())) {
            return true;
        }
        return false;
    }

    public List<MFAOptionType> getMFAOptions() {
        return this.mFAOptions;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getUsername() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getUsername().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getMFAOptions() != null) {
            i10 = getMFAOptions().hashCode();
        }
        return i12 + i10;
    }

    public void setMFAOptions(Collection<MFAOptionType> collection) {
        if (collection == null) {
            this.mFAOptions = null;
        } else {
            this.mFAOptions = new ArrayList(collection);
        }
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getMFAOptions() != null) {
            sb.append("MFAOptions: " + getMFAOptions());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminSetUserSettingsRequest withMFAOptions(MFAOptionType... mFAOptionTypeArr) {
        if (getMFAOptions() == null) {
            this.mFAOptions = new ArrayList(mFAOptionTypeArr.length);
        }
        for (MFAOptionType mFAOptionType : mFAOptionTypeArr) {
            this.mFAOptions.add(mFAOptionType);
        }
        return this;
    }

    public AdminSetUserSettingsRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminSetUserSettingsRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public AdminSetUserSettingsRequest withMFAOptions(Collection<MFAOptionType> collection) {
        setMFAOptions(collection);
        return this;
    }
}
