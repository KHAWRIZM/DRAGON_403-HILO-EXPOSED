package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminGetUserResult implements Serializable {
    private Boolean enabled;
    private List<MFAOptionType> mFAOptions;
    private String preferredMfaSetting;
    private List<AttributeType> userAttributes;
    private Date userCreateDate;
    private Date userLastModifiedDate;
    private List<String> userMFASettingList;
    private String userStatus;
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
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        boolean z26;
        boolean z27;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminGetUserResult)) {
            return false;
        }
        AdminGetUserResult adminGetUserResult = (AdminGetUserResult) obj;
        if (adminGetUserResult.getUsername() == null) {
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
        if (adminGetUserResult.getUsername() != null && !adminGetUserResult.getUsername().equals(getUsername())) {
            return false;
        }
        if (adminGetUserResult.getUserAttributes() == null) {
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
        if (adminGetUserResult.getUserAttributes() != null && !adminGetUserResult.getUserAttributes().equals(getUserAttributes())) {
            return false;
        }
        if (adminGetUserResult.getUserCreateDate() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getUserCreateDate() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (adminGetUserResult.getUserCreateDate() != null && !adminGetUserResult.getUserCreateDate().equals(getUserCreateDate())) {
            return false;
        }
        if (adminGetUserResult.getUserLastModifiedDate() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getUserLastModifiedDate() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (adminGetUserResult.getUserLastModifiedDate() != null && !adminGetUserResult.getUserLastModifiedDate().equals(getUserLastModifiedDate())) {
            return false;
        }
        if (adminGetUserResult.getEnabled() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getEnabled() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (adminGetUserResult.getEnabled() != null && !adminGetUserResult.getEnabled().equals(getEnabled())) {
            return false;
        }
        if (adminGetUserResult.getUserStatus() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getUserStatus() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (adminGetUserResult.getUserStatus() != null && !adminGetUserResult.getUserStatus().equals(getUserStatus())) {
            return false;
        }
        if (adminGetUserResult.getMFAOptions() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getMFAOptions() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (adminGetUserResult.getMFAOptions() != null && !adminGetUserResult.getMFAOptions().equals(getMFAOptions())) {
            return false;
        }
        if (adminGetUserResult.getPreferredMfaSetting() == null) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (getPreferredMfaSetting() == null) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (z24 ^ z25) {
            return false;
        }
        if (adminGetUserResult.getPreferredMfaSetting() != null && !adminGetUserResult.getPreferredMfaSetting().equals(getPreferredMfaSetting())) {
            return false;
        }
        if (adminGetUserResult.getUserMFASettingList() == null) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (getUserMFASettingList() == null) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z26 ^ z27) {
            return false;
        }
        if (adminGetUserResult.getUserMFASettingList() == null || adminGetUserResult.getUserMFASettingList().equals(getUserMFASettingList())) {
            return true;
        }
        return false;
    }

    public Boolean getEnabled() {
        return this.enabled;
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

    public Date getUserCreateDate() {
        return this.userCreateDate;
    }

    public Date getUserLastModifiedDate() {
        return this.userLastModifiedDate;
    }

    public List<String> getUserMFASettingList() {
        return this.userMFASettingList;
    }

    public String getUserStatus() {
        return this.userStatus;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
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
        if (getUserCreateDate() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getUserCreateDate().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getUserLastModifiedDate() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getUserLastModifiedDate().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getEnabled() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getEnabled().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getUserStatus() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getUserStatus().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getMFAOptions() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getMFAOptions().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getPreferredMfaSetting() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getPreferredMfaSetting().hashCode();
        }
        int i18 = (i17 + hashCode8) * 31;
        if (getUserMFASettingList() != null) {
            i10 = getUserMFASettingList().hashCode();
        }
        return i18 + i10;
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
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

    public void setUserCreateDate(Date date) {
        this.userCreateDate = date;
    }

    public void setUserLastModifiedDate(Date date) {
        this.userLastModifiedDate = date;
    }

    public void setUserMFASettingList(Collection<String> collection) {
        if (collection == null) {
            this.userMFASettingList = null;
        } else {
            this.userMFASettingList = new ArrayList(collection);
        }
    }

    public void setUserStatus(String str) {
        this.userStatus = str;
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
        if (getUserCreateDate() != null) {
            sb.append("UserCreateDate: " + getUserCreateDate() + ",");
        }
        if (getUserLastModifiedDate() != null) {
            sb.append("UserLastModifiedDate: " + getUserLastModifiedDate() + ",");
        }
        if (getEnabled() != null) {
            sb.append("Enabled: " + getEnabled() + ",");
        }
        if (getUserStatus() != null) {
            sb.append("UserStatus: " + getUserStatus() + ",");
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

    public AdminGetUserResult withEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }

    public AdminGetUserResult withMFAOptions(MFAOptionType... mFAOptionTypeArr) {
        if (getMFAOptions() == null) {
            this.mFAOptions = new ArrayList(mFAOptionTypeArr.length);
        }
        for (MFAOptionType mFAOptionType : mFAOptionTypeArr) {
            this.mFAOptions.add(mFAOptionType);
        }
        return this;
    }

    public AdminGetUserResult withPreferredMfaSetting(String str) {
        this.preferredMfaSetting = str;
        return this;
    }

    public AdminGetUserResult withUserAttributes(AttributeType... attributeTypeArr) {
        if (getUserAttributes() == null) {
            this.userAttributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.userAttributes.add(attributeType);
        }
        return this;
    }

    public AdminGetUserResult withUserCreateDate(Date date) {
        this.userCreateDate = date;
        return this;
    }

    public AdminGetUserResult withUserLastModifiedDate(Date date) {
        this.userLastModifiedDate = date;
        return this;
    }

    public AdminGetUserResult withUserMFASettingList(String... strArr) {
        if (getUserMFASettingList() == null) {
            this.userMFASettingList = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.userMFASettingList.add(str);
        }
        return this;
    }

    public AdminGetUserResult withUserStatus(String str) {
        this.userStatus = str;
        return this;
    }

    public AdminGetUserResult withUsername(String str) {
        this.username = str;
        return this;
    }

    public void setUserStatus(UserStatusType userStatusType) {
        this.userStatus = userStatusType.toString();
    }

    public AdminGetUserResult withUserStatus(UserStatusType userStatusType) {
        this.userStatus = userStatusType.toString();
        return this;
    }

    public AdminGetUserResult withMFAOptions(Collection<MFAOptionType> collection) {
        setMFAOptions(collection);
        return this;
    }

    public AdminGetUserResult withUserAttributes(Collection<AttributeType> collection) {
        setUserAttributes(collection);
        return this;
    }

    public AdminGetUserResult withUserMFASettingList(Collection<String> collection) {
        setUserMFASettingList(collection);
        return this;
    }
}
