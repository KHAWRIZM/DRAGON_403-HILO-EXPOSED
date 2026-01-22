package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DeviceType implements Serializable {
    private List<AttributeType> deviceAttributes;
    private Date deviceCreateDate;
    private String deviceKey;
    private Date deviceLastAuthenticatedDate;
    private Date deviceLastModifiedDate;

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
        if (obj == null || !(obj instanceof DeviceType)) {
            return false;
        }
        DeviceType deviceType = (DeviceType) obj;
        if (deviceType.getDeviceKey() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getDeviceKey() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (deviceType.getDeviceKey() != null && !deviceType.getDeviceKey().equals(getDeviceKey())) {
            return false;
        }
        if (deviceType.getDeviceAttributes() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getDeviceAttributes() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (deviceType.getDeviceAttributes() != null && !deviceType.getDeviceAttributes().equals(getDeviceAttributes())) {
            return false;
        }
        if (deviceType.getDeviceCreateDate() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getDeviceCreateDate() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (deviceType.getDeviceCreateDate() != null && !deviceType.getDeviceCreateDate().equals(getDeviceCreateDate())) {
            return false;
        }
        if (deviceType.getDeviceLastModifiedDate() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getDeviceLastModifiedDate() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (deviceType.getDeviceLastModifiedDate() != null && !deviceType.getDeviceLastModifiedDate().equals(getDeviceLastModifiedDate())) {
            return false;
        }
        if (deviceType.getDeviceLastAuthenticatedDate() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getDeviceLastAuthenticatedDate() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (deviceType.getDeviceLastAuthenticatedDate() == null || deviceType.getDeviceLastAuthenticatedDate().equals(getDeviceLastAuthenticatedDate())) {
            return true;
        }
        return false;
    }

    public List<AttributeType> getDeviceAttributes() {
        return this.deviceAttributes;
    }

    public Date getDeviceCreateDate() {
        return this.deviceCreateDate;
    }

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public Date getDeviceLastAuthenticatedDate() {
        return this.deviceLastAuthenticatedDate;
    }

    public Date getDeviceLastModifiedDate() {
        return this.deviceLastModifiedDate;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i10 = 0;
        if (getDeviceKey() == null) {
            hashCode = 0;
        } else {
            hashCode = getDeviceKey().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getDeviceAttributes() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getDeviceAttributes().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getDeviceCreateDate() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getDeviceCreateDate().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getDeviceLastModifiedDate() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getDeviceLastModifiedDate().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getDeviceLastAuthenticatedDate() != null) {
            i10 = getDeviceLastAuthenticatedDate().hashCode();
        }
        return i14 + i10;
    }

    public void setDeviceAttributes(Collection<AttributeType> collection) {
        if (collection == null) {
            this.deviceAttributes = null;
        } else {
            this.deviceAttributes = new ArrayList(collection);
        }
    }

    public void setDeviceCreateDate(Date date) {
        this.deviceCreateDate = date;
    }

    public void setDeviceKey(String str) {
        this.deviceKey = str;
    }

    public void setDeviceLastAuthenticatedDate(Date date) {
        this.deviceLastAuthenticatedDate = date;
    }

    public void setDeviceLastModifiedDate(Date date) {
        this.deviceLastModifiedDate = date;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDeviceKey() != null) {
            sb.append("DeviceKey: " + getDeviceKey() + ",");
        }
        if (getDeviceAttributes() != null) {
            sb.append("DeviceAttributes: " + getDeviceAttributes() + ",");
        }
        if (getDeviceCreateDate() != null) {
            sb.append("DeviceCreateDate: " + getDeviceCreateDate() + ",");
        }
        if (getDeviceLastModifiedDate() != null) {
            sb.append("DeviceLastModifiedDate: " + getDeviceLastModifiedDate() + ",");
        }
        if (getDeviceLastAuthenticatedDate() != null) {
            sb.append("DeviceLastAuthenticatedDate: " + getDeviceLastAuthenticatedDate());
        }
        sb.append("}");
        return sb.toString();
    }

    public DeviceType withDeviceAttributes(AttributeType... attributeTypeArr) {
        if (getDeviceAttributes() == null) {
            this.deviceAttributes = new ArrayList(attributeTypeArr.length);
        }
        for (AttributeType attributeType : attributeTypeArr) {
            this.deviceAttributes.add(attributeType);
        }
        return this;
    }

    public DeviceType withDeviceCreateDate(Date date) {
        this.deviceCreateDate = date;
        return this;
    }

    public DeviceType withDeviceKey(String str) {
        this.deviceKey = str;
        return this;
    }

    public DeviceType withDeviceLastAuthenticatedDate(Date date) {
        this.deviceLastAuthenticatedDate = date;
        return this;
    }

    public DeviceType withDeviceLastModifiedDate(Date date) {
        this.deviceLastModifiedDate = date;
        return this;
    }

    public DeviceType withDeviceAttributes(Collection<AttributeType> collection) {
        setDeviceAttributes(collection);
        return this;
    }
}
