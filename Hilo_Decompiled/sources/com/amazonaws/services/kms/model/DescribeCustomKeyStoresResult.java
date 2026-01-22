package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DescribeCustomKeyStoresResult implements Serializable {
    private List<CustomKeyStoresListEntry> customKeyStores = new ArrayList();
    private String nextMarker;
    private Boolean truncated;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeCustomKeyStoresResult)) {
            return false;
        }
        DescribeCustomKeyStoresResult describeCustomKeyStoresResult = (DescribeCustomKeyStoresResult) obj;
        if (describeCustomKeyStoresResult.getCustomKeyStores() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getCustomKeyStores() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (describeCustomKeyStoresResult.getCustomKeyStores() != null && !describeCustomKeyStoresResult.getCustomKeyStores().equals(getCustomKeyStores())) {
            return false;
        }
        if (describeCustomKeyStoresResult.getNextMarker() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getNextMarker() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (describeCustomKeyStoresResult.getNextMarker() != null && !describeCustomKeyStoresResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if (describeCustomKeyStoresResult.getTruncated() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getTruncated() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (describeCustomKeyStoresResult.getTruncated() == null || describeCustomKeyStoresResult.getTruncated().equals(getTruncated())) {
            return true;
        }
        return false;
    }

    public List<CustomKeyStoresListEntry> getCustomKeyStores() {
        return this.customKeyStores;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getCustomKeyStores() == null) {
            hashCode = 0;
        } else {
            hashCode = getCustomKeyStores().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getNextMarker() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getNextMarker().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getTruncated() != null) {
            i10 = getTruncated().hashCode();
        }
        return i12 + i10;
    }

    public Boolean isTruncated() {
        return this.truncated;
    }

    public void setCustomKeyStores(Collection<CustomKeyStoresListEntry> collection) {
        if (collection == null) {
            this.customKeyStores = null;
        } else {
            this.customKeyStores = new ArrayList(collection);
        }
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public void setTruncated(Boolean bool) {
        this.truncated = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCustomKeyStores() != null) {
            sb.append("CustomKeyStores: " + getCustomKeyStores() + ",");
        }
        if (getNextMarker() != null) {
            sb.append("NextMarker: " + getNextMarker() + ",");
        }
        if (getTruncated() != null) {
            sb.append("Truncated: " + getTruncated());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeCustomKeyStoresResult withCustomKeyStores(CustomKeyStoresListEntry... customKeyStoresListEntryArr) {
        if (getCustomKeyStores() == null) {
            this.customKeyStores = new ArrayList(customKeyStoresListEntryArr.length);
        }
        for (CustomKeyStoresListEntry customKeyStoresListEntry : customKeyStoresListEntryArr) {
            this.customKeyStores.add(customKeyStoresListEntry);
        }
        return this;
    }

    public DescribeCustomKeyStoresResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public DescribeCustomKeyStoresResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public DescribeCustomKeyStoresResult withCustomKeyStores(Collection<CustomKeyStoresListEntry> collection) {
        setCustomKeyStores(collection);
        return this;
    }
}
