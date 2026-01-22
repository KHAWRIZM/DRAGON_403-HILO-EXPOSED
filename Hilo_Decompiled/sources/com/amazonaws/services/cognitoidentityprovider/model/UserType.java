package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UserType implements Serializable {
    private List<AttributeType> attributes;
    private Boolean enabled;
    private List<MFAOptionType> mFAOptions;
    private Date userCreateDate;
    private Date userLastModifiedDate;
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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserType)) {
            return false;
        }
        UserType userType = (UserType) obj;
        if (userType.getUsername() == null) {
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
        if (userType.getUsername() != null && !userType.getUsername().equals(getUsername())) {
            return false;
        }
        if (userType.getAttributes() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getAttributes() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (userType.getAttributes() != null && !userType.getAttributes().equals(getAttributes())) {
            return false;
        }
        if (userType.getUserCreateDate() == null) {
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
        if (userType.getUserCreateDate() != null && !userType.getUserCreateDate().equals(getUserCreateDate())) {
            return false;
        }
        if (userType.getUserLastModifiedDate() == null) {
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
        if (userType.getUserLastModifiedDate() != null && !userType.getUserLastModifiedDate().equals(getUserLastModifiedDate())) {
            return false;
        }
        if (userType.getEnabled() == null) {
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
        if (userType.getEnabled() != null && !userType.getEnabled().equals(getEnabled())) {
            return false;
        }
        if (userType.getUserStatus() == null) {
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
        if (userType.getUserStatus() != null && !userType.getUserStatus().equals(getUserStatus())) {
            return false;
        }
        if (userType.getMFAOptions() == null) {
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
        if (userType.getMFAOptions() == null || userType.getMFAOptions().equals(getMFAOptions())) {
            return true;
        }
        return false;
    }

    public List<AttributeType> getAttributes() {
        return this.attributes;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public List<MFAOptionType> getMFAOptions() {
        return this.mFAOptions;
    }

    public Date getUserCreateDate() {
        return this.userCreateDate;
    }

    public Date getUserLastModifiedDate() {
        return this.userLastModifiedDate;
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
        int i10 = 0;
        if (getUsername() == null) {
            hashCode = 0;
        } else {
            hashCode = getUsername().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getAttributes() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getAttributes().hashCode();
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
        if (getMFAOptions() != null) {
            i10 = getMFAOptions().hashCode();
        }
        return i16 + i10;
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public void setAttributes(Collection<AttributeType> collection) {
        if (collection == null) {
            this.attributes = null;
        } else {
            this.attributes = new ArrayList(collection);
        }
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

    public void setUserCreateDate(Date date) {
        this.userCreateDate = date;
    }

    public void setUserLastModifiedDate(Date date) {
        this.userLastModifiedDate = date;
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
        if (getAttributes() != null) {
            sb.append("Attributes: " + getAttributes() + ",");
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
            sb.append("MFAOptions: " + getMFAOptions());
        }
        sb.append("}");
        return sb.toString();
    }

    public UserType withAttributes(AttributeType... attributeTypeArr) {
        if (getAttributes() == null) {
            this.attributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.attributes.add(attributeType);
        }
        return this;
    }

    public UserType withEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }

    public UserType withMFAOptions(MFAOptionType... mFAOptionTypeArr) {
        if (getMFAOptions() == null) {
            this.mFAOptions = new ArrayList(mFAOptionTypeArr.length);
        }
        for (MFAOptionType mFAOptionType : mFAOptionTypeArr) {
            this.mFAOptions.add(mFAOptionType);
        }
        return this;
    }

    public UserType withUserCreateDate(Date date) {
        this.userCreateDate = date;
        return this;
    }

    public UserType withUserLastModifiedDate(Date date) {
        this.userLastModifiedDate = date;
        return this;
    }

    public UserType withUserStatus(String str) {
        this.userStatus = str;
        return this;
    }

    public UserType withUsername(String str) {
        this.username = str;
        return this;
    }

    public void setUserStatus(UserStatusType userStatusType) {
        this.userStatus = userStatusType.toString();
    }

    public UserType withUserStatus(UserStatusType userStatusType) {
        this.userStatus = userStatusType.toString();
        return this;
    }

    public UserType withAttributes(Collection<AttributeType> collection) {
        setAttributes(collection);
        return this;
    }

    public UserType withMFAOptions(Collection<MFAOptionType> collection) {
        setMFAOptions(collection);
        return this;
    }
}
