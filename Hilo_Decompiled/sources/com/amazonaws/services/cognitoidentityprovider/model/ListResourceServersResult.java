package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListResourceServersResult implements Serializable {
    private String nextToken;
    private List<ResourceServerType> resourceServers;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListResourceServersResult)) {
            return false;
        }
        ListResourceServersResult listResourceServersResult = (ListResourceServersResult) obj;
        if (listResourceServersResult.getResourceServers() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getResourceServers() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (listResourceServersResult.getResourceServers() != null && !listResourceServersResult.getResourceServers().equals(getResourceServers())) {
            return false;
        }
        if (listResourceServersResult.getNextToken() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getNextToken() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (listResourceServersResult.getNextToken() == null || listResourceServersResult.getNextToken().equals(getNextToken())) {
            return true;
        }
        return false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<ResourceServerType> getResourceServers() {
        return this.resourceServers;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getResourceServers() == null) {
            hashCode = 0;
        } else {
            hashCode = getResourceServers().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getNextToken() != null) {
            i10 = getNextToken().hashCode();
        }
        return i11 + i10;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setResourceServers(Collection<ResourceServerType> collection) {
        if (collection == null) {
            this.resourceServers = null;
        } else {
            this.resourceServers = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getResourceServers() != null) {
            sb.append("ResourceServers: " + getResourceServers() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListResourceServersResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public ListResourceServersResult withResourceServers(ResourceServerType... resourceServerTypeArr) {
        if (getResourceServers() == null) {
            this.resourceServers = new ArrayList(resourceServerTypeArr.length);
        }
        for (ResourceServerType resourceServerType : resourceServerTypeArr) {
            this.resourceServers.add(resourceServerType);
        }
        return this;
    }

    public ListResourceServersResult withResourceServers(Collection<ResourceServerType> collection) {
        setResourceServers(collection);
        return this;
    }
}
