package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UpdateResourceServerResult implements Serializable {
    private ResourceServerType resourceServer;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateResourceServerResult)) {
            return false;
        }
        UpdateResourceServerResult updateResourceServerResult = (UpdateResourceServerResult) obj;
        if (updateResourceServerResult.getResourceServer() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getResourceServer() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (updateResourceServerResult.getResourceServer() == null || updateResourceServerResult.getResourceServer().equals(getResourceServer())) {
            return true;
        }
        return false;
    }

    public ResourceServerType getResourceServer() {
        return this.resourceServer;
    }

    public int hashCode() {
        int hashCode;
        if (getResourceServer() == null) {
            hashCode = 0;
        } else {
            hashCode = getResourceServer().hashCode();
        }
        return 31 + hashCode;
    }

    public void setResourceServer(ResourceServerType resourceServerType) {
        this.resourceServer = resourceServerType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getResourceServer() != null) {
            sb.append("ResourceServer: " + getResourceServer());
        }
        sb.append("}");
        return sb.toString();
    }

    public UpdateResourceServerResult withResourceServer(ResourceServerType resourceServerType) {
        this.resourceServer = resourceServerType;
        return this;
    }
}
