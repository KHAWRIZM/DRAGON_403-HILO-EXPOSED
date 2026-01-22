package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SetUserSettingsRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private List<MFAOptionType> mFAOptions;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetUserSettingsRequest)) {
            return false;
        }
        SetUserSettingsRequest setUserSettingsRequest = (SetUserSettingsRequest) obj;
        if (setUserSettingsRequest.getAccessToken() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getAccessToken() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (setUserSettingsRequest.getAccessToken() != null && !setUserSettingsRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if (setUserSettingsRequest.getMFAOptions() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getMFAOptions() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (setUserSettingsRequest.getMFAOptions() == null || setUserSettingsRequest.getMFAOptions().equals(getMFAOptions())) {
            return true;
        }
        return false;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public List<MFAOptionType> getMFAOptions() {
        return this.mFAOptions;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getAccessToken() == null) {
            hashCode = 0;
        } else {
            hashCode = getAccessToken().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getMFAOptions() != null) {
            i10 = getMFAOptions().hashCode();
        }
        return i11 + i10;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setMFAOptions(Collection<MFAOptionType> collection) {
        if (collection == null) {
            this.mFAOptions = null;
        } else {
            this.mFAOptions = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getMFAOptions() != null) {
            sb.append("MFAOptions: " + getMFAOptions());
        }
        sb.append("}");
        return sb.toString();
    }

    public SetUserSettingsRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public SetUserSettingsRequest withMFAOptions(MFAOptionType... mFAOptionTypeArr) {
        if (getMFAOptions() == null) {
            this.mFAOptions = new ArrayList(mFAOptionTypeArr.length);
        }
        for (MFAOptionType mFAOptionType : mFAOptionTypeArr) {
            this.mFAOptions.add(mFAOptionType);
        }
        return this;
    }

    public SetUserSettingsRequest withMFAOptions(Collection<MFAOptionType> collection) {
        setMFAOptions(collection);
        return this;
    }
}
