package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetUserResult implements Serializable {
    private List<MFAOptionType> mFAOptions;
    private String preferredMfaSetting;
    private List<AttributeType> userAttributes;
    private List<String> userMFASettingList;
    private String username;

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
        if (obj == null || !(obj instanceof GetUserResult)) {
            return false;
        }
        GetUserResult getUserResult = (GetUserResult) obj;
        if (getUserResult.getUsername() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUsername() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (getUserResult.getUsername() != null && !getUserResult.getUsername().equals(getUsername())) {
            return false;
        }
        if (getUserResult.getUserAttributes() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getUserAttributes() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (getUserResult.getUserAttributes() != null && !getUserResult.getUserAttributes().equals(getUserAttributes())) {
            return false;
        }
        if (getUserResult.getMFAOptions() == null) {
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
        if (getUserResult.getMFAOptions() != null && !getUserResult.getMFAOptions().equals(getMFAOptions())) {
            return false;
        }
        if (getUserResult.getPreferredMfaSetting() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getPreferredMfaSetting() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (getUserResult.getPreferredMfaSetting() != null && !getUserResult.getPreferredMfaSetting().equals(getPreferredMfaSetting())) {
            return false;
        }
        if (getUserResult.getUserMFASettingList() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getUserMFASettingList() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (getUserResult.getUserMFASettingList() == null || getUserResult.getUserMFASettingList().equals(getUserMFASettingList())) {
            return true;
        }
        return false;
    }

    public List<MFAOptionType> getMFAOptions() {
        return this.mFAOptions;
    }

    public String getPreferredMfaSetting() {
        return this.preferredMfaSetting;
    }

    public List<AttributeType> getUserAttributes() {
        return this.userAttributes;
    }

    public List<String> getUserMFASettingList() {
        return this.userMFASettingList;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i10 = 0;
        if (getUsername() == null) {
            hashCode = 0;
        } else {
            hashCode = getUsername().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getUserAttributes() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getUserAttributes().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getMFAOptions() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getMFAOptions().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getPreferredMfaSetting() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getPreferredMfaSetting().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getUserMFASettingList() != null) {
            i10 = getUserMFASettingList().hashCode();
        }
        return i14 + i10;
    }

    public void setMFAOptions(Collection<MFAOptionType> collection) {
        if (collection == null) {
            this.mFAOptions = null;
        } else {
            this.mFAOptions = new ArrayList(collection);
        }
    }

    public void setPreferredMfaSetting(String str) {
        this.preferredMfaSetting = str;
    }

    public void setUserAttributes(Collection<AttributeType> collection) {
        if (collection == null) {
            this.userAttributes = null;
        } else {
            this.userAttributes = new ArrayList(collection);
        }
    }

    public void setUserMFASettingList(Collection<String> collection) {
        if (collection == null) {
            this.userMFASettingList = null;
        } else {
            this.userMFASettingList = new ArrayList(collection);
        }
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getUserAttributes() != null) {
            sb.append("UserAttributes: " + getUserAttributes() + ",");
        }
        if (getMFAOptions() != null) {
            sb.append("MFAOptions: " + getMFAOptions() + ",");
        }
        if (getPreferredMfaSetting() != null) {
            sb.append("PreferredMfaSetting: " + getPreferredMfaSetting() + ",");
        }
        if (getUserMFASettingList() != null) {
            sb.append("UserMFASettingList: " + getUserMFASettingList());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetUserResult withMFAOptions(MFAOptionType... mFAOptionTypeArr) {
        if (getMFAOptions() == null) {
            this.mFAOptions = new ArrayList(mFAOptionTypeArr.length);
        }
        for (MFAOptionType mFAOptionType : mFAOptionTypeArr) {
            this.mFAOptions.add(mFAOptionType);
        }
        return this;
    }

    public GetUserResult withPreferredMfaSetting(String str) {
        this.preferredMfaSetting = str;
        return this;
    }

    public GetUserResult withUserAttributes(AttributeType... attributeTypeArr) {
        if (getUserAttributes() == null) {
            this.userAttributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.userAttributes.add(attributeType);
        }
        return this;
    }

    public GetUserResult withUserMFASettingList(String... strArr) {
        if (getUserMFASettingList() == null) {
            this.userMFASettingList = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.userMFASettingList.add(str);
        }
        return this;
    }

    public GetUserResult withUsername(String str) {
        this.username = str;
        return this;
    }

    public GetUserResult withMFAOptions(Collection<MFAOptionType> collection) {
        setMFAOptions(collection);
        return this;
    }

    public GetUserResult withUserAttributes(Collection<AttributeType> collection) {
        setUserAttributes(collection);
        return this;
    }

    public GetUserResult withUserMFASettingList(Collection<String> collection) {
        setUserMFASettingList(collection);
        return this;
    }
}
