package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListDevicesResult implements Serializable {
    private List<DeviceType> devices;
    private String paginationToken;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListDevicesResult)) {
            return false;
        }
        ListDevicesResult listDevicesResult = (ListDevicesResult) obj;
        if (listDevicesResult.getDevices() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getDevices() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (listDevicesResult.getDevices() != null && !listDevicesResult.getDevices().equals(getDevices())) {
            return false;
        }
        if (listDevicesResult.getPaginationToken() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getPaginationToken() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (listDevicesResult.getPaginationToken() == null || listDevicesResult.getPaginationToken().equals(getPaginationToken())) {
            return true;
        }
        return false;
    }

    public List<DeviceType> getDevices() {
        return this.devices;
    }

    public String getPaginationToken() {
        return this.paginationToken;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getDevices() == null) {
            hashCode = 0;
        } else {
            hashCode = getDevices().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getPaginationToken() != null) {
            i10 = getPaginationToken().hashCode();
        }
        return i11 + i10;
    }

    public void setDevices(Collection<DeviceType> collection) {
        if (collection == null) {
            this.devices = null;
        } else {
            this.devices = new ArrayList(collection);
        }
    }

    public void setPaginationToken(String str) {
        this.paginationToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDevices() != null) {
            sb.append("Devices: " + getDevices() + ",");
        }
        if (getPaginationToken() != null) {
            sb.append("PaginationToken: " + getPaginationToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListDevicesResult withDevices(DeviceType... deviceTypeArr) {
        if (getDevices() == null) {
            this.devices = new ArrayList(deviceTypeArr.length);
        }
        for (DeviceType deviceType : deviceTypeArr) {
            this.devices.add(deviceType);
        }
        return this;
    }

    public ListDevicesResult withPaginationToken(String str) {
        this.paginationToken = str;
        return this;
    }

    public ListDevicesResult withDevices(Collection<DeviceType> collection) {
        setDevices(collection);
        return this;
    }
}
