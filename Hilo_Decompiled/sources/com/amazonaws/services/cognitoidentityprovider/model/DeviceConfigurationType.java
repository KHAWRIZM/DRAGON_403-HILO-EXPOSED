package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DeviceConfigurationType implements Serializable {
    private Boolean challengeRequiredOnNewDevice;
    private Boolean deviceOnlyRememberedOnUserPrompt;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeviceConfigurationType)) {
            return false;
        }
        DeviceConfigurationType deviceConfigurationType = (DeviceConfigurationType) obj;
        if (deviceConfigurationType.getChallengeRequiredOnNewDevice() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getChallengeRequiredOnNewDevice() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (deviceConfigurationType.getChallengeRequiredOnNewDevice() != null && !deviceConfigurationType.getChallengeRequiredOnNewDevice().equals(getChallengeRequiredOnNewDevice())) {
            return false;
        }
        if (deviceConfigurationType.getDeviceOnlyRememberedOnUserPrompt() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getDeviceOnlyRememberedOnUserPrompt() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (deviceConfigurationType.getDeviceOnlyRememberedOnUserPrompt() == null || deviceConfigurationType.getDeviceOnlyRememberedOnUserPrompt().equals(getDeviceOnlyRememberedOnUserPrompt())) {
            return true;
        }
        return false;
    }

    public Boolean getChallengeRequiredOnNewDevice() {
        return this.challengeRequiredOnNewDevice;
    }

    public Boolean getDeviceOnlyRememberedOnUserPrompt() {
        return this.deviceOnlyRememberedOnUserPrompt;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getChallengeRequiredOnNewDevice() == null) {
            hashCode = 0;
        } else {
            hashCode = getChallengeRequiredOnNewDevice().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getDeviceOnlyRememberedOnUserPrompt() != null) {
            i10 = getDeviceOnlyRememberedOnUserPrompt().hashCode();
        }
        return i11 + i10;
    }

    public Boolean isChallengeRequiredOnNewDevice() {
        return this.challengeRequiredOnNewDevice;
    }

    public Boolean isDeviceOnlyRememberedOnUserPrompt() {
        return this.deviceOnlyRememberedOnUserPrompt;
    }

    public void setChallengeRequiredOnNewDevice(Boolean bool) {
        this.challengeRequiredOnNewDevice = bool;
    }

    public void setDeviceOnlyRememberedOnUserPrompt(Boolean bool) {
        this.deviceOnlyRememberedOnUserPrompt = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getChallengeRequiredOnNewDevice() != null) {
            sb.append("ChallengeRequiredOnNewDevice: " + getChallengeRequiredOnNewDevice() + ",");
        }
        if (getDeviceOnlyRememberedOnUserPrompt() != null) {
            sb.append("DeviceOnlyRememberedOnUserPrompt: " + getDeviceOnlyRememberedOnUserPrompt());
        }
        sb.append("}");
        return sb.toString();
    }

    public DeviceConfigurationType withChallengeRequiredOnNewDevice(Boolean bool) {
        this.challengeRequiredOnNewDevice = bool;
        return this;
    }

    public DeviceConfigurationType withDeviceOnlyRememberedOnUserPrompt(Boolean bool) {
        this.deviceOnlyRememberedOnUserPrompt = bool;
        return this;
    }
}
