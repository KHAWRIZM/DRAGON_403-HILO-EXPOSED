package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class EventContextDataType implements Serializable {
    private String city;
    private String country;
    private String deviceName;
    private String ipAddress;
    private String timezone;

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
        if (obj == null || !(obj instanceof EventContextDataType)) {
            return false;
        }
        EventContextDataType eventContextDataType = (EventContextDataType) obj;
        if (eventContextDataType.getIpAddress() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getIpAddress() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (eventContextDataType.getIpAddress() != null && !eventContextDataType.getIpAddress().equals(getIpAddress())) {
            return false;
        }
        if (eventContextDataType.getDeviceName() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getDeviceName() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (eventContextDataType.getDeviceName() != null && !eventContextDataType.getDeviceName().equals(getDeviceName())) {
            return false;
        }
        if (eventContextDataType.getTimezone() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getTimezone() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (eventContextDataType.getTimezone() != null && !eventContextDataType.getTimezone().equals(getTimezone())) {
            return false;
        }
        if (eventContextDataType.getCity() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getCity() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (eventContextDataType.getCity() != null && !eventContextDataType.getCity().equals(getCity())) {
            return false;
        }
        if (eventContextDataType.getCountry() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getCountry() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (eventContextDataType.getCountry() == null || eventContextDataType.getCountry().equals(getCountry())) {
            return true;
        }
        return false;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public String getTimezone() {
        return this.timezone;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i10 = 0;
        if (getIpAddress() == null) {
            hashCode = 0;
        } else {
            hashCode = getIpAddress().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getDeviceName() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getDeviceName().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getTimezone() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getTimezone().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getCity() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getCity().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getCountry() != null) {
            i10 = getCountry().hashCode();
        }
        return i14 + i10;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public void setTimezone(String str) {
        this.timezone = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIpAddress() != null) {
            sb.append("IpAddress: " + getIpAddress() + ",");
        }
        if (getDeviceName() != null) {
            sb.append("DeviceName: " + getDeviceName() + ",");
        }
        if (getTimezone() != null) {
            sb.append("Timezone: " + getTimezone() + ",");
        }
        if (getCity() != null) {
            sb.append("City: " + getCity() + ",");
        }
        if (getCountry() != null) {
            sb.append("Country: " + getCountry());
        }
        sb.append("}");
        return sb.toString();
    }

    public EventContextDataType withCity(String str) {
        this.city = str;
        return this;
    }

    public EventContextDataType withCountry(String str) {
        this.country = str;
        return this;
    }

    public EventContextDataType withDeviceName(String str) {
        this.deviceName = str;
        return this;
    }

    public EventContextDataType withIpAddress(String str) {
        this.ipAddress = str;
        return this;
    }

    public EventContextDataType withTimezone(String str) {
        this.timezone = str;
        return this;
    }
}
