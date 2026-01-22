package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UserPoolDescriptionType implements Serializable {
    private Date creationDate;
    private String id;
    private LambdaConfigType lambdaConfig;
    private Date lastModifiedDate;
    private String name;
    private String status;

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
        if (obj == null || !(obj instanceof UserPoolDescriptionType)) {
            return false;
        }
        UserPoolDescriptionType userPoolDescriptionType = (UserPoolDescriptionType) obj;
        if (userPoolDescriptionType.getId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (userPoolDescriptionType.getId() != null && !userPoolDescriptionType.getId().equals(getId())) {
            return false;
        }
        if (userPoolDescriptionType.getName() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getName() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (userPoolDescriptionType.getName() != null && !userPoolDescriptionType.getName().equals(getName())) {
            return false;
        }
        if (userPoolDescriptionType.getLambdaConfig() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getLambdaConfig() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (userPoolDescriptionType.getLambdaConfig() != null && !userPoolDescriptionType.getLambdaConfig().equals(getLambdaConfig())) {
            return false;
        }
        if (userPoolDescriptionType.getStatus() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getStatus() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (userPoolDescriptionType.getStatus() != null && !userPoolDescriptionType.getStatus().equals(getStatus())) {
            return false;
        }
        if (userPoolDescriptionType.getLastModifiedDate() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getLastModifiedDate() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (userPoolDescriptionType.getLastModifiedDate() != null && !userPoolDescriptionType.getLastModifiedDate().equals(getLastModifiedDate())) {
            return false;
        }
        if (userPoolDescriptionType.getCreationDate() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getCreationDate() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (userPoolDescriptionType.getCreationDate() == null || userPoolDescriptionType.getCreationDate().equals(getCreationDate())) {
            return true;
        }
        return false;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getId() {
        return this.id;
    }

    public LambdaConfigType getLambdaConfig() {
        return this.lambdaConfig;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int i10 = 0;
        if (getId() == null) {
            hashCode = 0;
        } else {
            hashCode = getId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getName() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getName().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getLambdaConfig() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getLambdaConfig().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getStatus() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getStatus().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getLastModifiedDate() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getLastModifiedDate().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getCreationDate() != null) {
            i10 = getCreationDate().hashCode();
        }
        return i15 + i10;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLambdaConfig(LambdaConfigType lambdaConfigType) {
        this.lambdaConfig = lambdaConfigType;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getId() != null) {
            sb.append("Id: " + getId() + ",");
        }
        if (getName() != null) {
            sb.append("Name: " + getName() + ",");
        }
        if (getLambdaConfig() != null) {
            sb.append("LambdaConfig: " + getLambdaConfig() + ",");
        }
        if (getStatus() != null) {
            sb.append("Status: " + getStatus() + ",");
        }
        if (getLastModifiedDate() != null) {
            sb.append("LastModifiedDate: " + getLastModifiedDate() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate());
        }
        sb.append("}");
        return sb.toString();
    }

    public UserPoolDescriptionType withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public UserPoolDescriptionType withId(String str) {
        this.id = str;
        return this;
    }

    public UserPoolDescriptionType withLambdaConfig(LambdaConfigType lambdaConfigType) {
        this.lambdaConfig = lambdaConfigType;
        return this;
    }

    public UserPoolDescriptionType withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public UserPoolDescriptionType withName(String str) {
        this.name = str;
        return this;
    }

    public UserPoolDescriptionType withStatus(String str) {
        this.status = str;
        return this;
    }

    public void setStatus(StatusType statusType) {
        this.status = statusType.toString();
    }

    public UserPoolDescriptionType withStatus(StatusType statusType) {
        this.status = statusType.toString();
        return this;
    }
}
