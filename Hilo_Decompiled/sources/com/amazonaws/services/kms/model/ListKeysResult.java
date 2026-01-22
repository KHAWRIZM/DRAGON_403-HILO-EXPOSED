package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListKeysResult implements Serializable {
    private List<KeyListEntry> keys = new ArrayList();
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
        if (obj == null || !(obj instanceof ListKeysResult)) {
            return false;
        }
        ListKeysResult listKeysResult = (ListKeysResult) obj;
        if (listKeysResult.getKeys() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getKeys() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (listKeysResult.getKeys() != null && !listKeysResult.getKeys().equals(getKeys())) {
            return false;
        }
        if (listKeysResult.getNextMarker() == null) {
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
        if (listKeysResult.getNextMarker() != null && !listKeysResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if (listKeysResult.getTruncated() == null) {
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
        if (listKeysResult.getTruncated() == null || listKeysResult.getTruncated().equals(getTruncated())) {
            return true;
        }
        return false;
    }

    public List<KeyListEntry> getKeys() {
        return this.keys;
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
        if (getKeys() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeys().hashCode();
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

    public void setKeys(Collection<KeyListEntry> collection) {
        if (collection == null) {
            this.keys = null;
        } else {
            this.keys = new ArrayList(collection);
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
        if (getKeys() != null) {
            sb.append("Keys: " + getKeys() + ",");
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

    public ListKeysResult withKeys(KeyListEntry... keyListEntryArr) {
        if (getKeys() == null) {
            this.keys = new ArrayList(keyListEntryArr.length);
        }
        for (KeyListEntry keyListEntry : keyListEntryArr) {
            this.keys.add(keyListEntry);
        }
        return this;
    }

    public ListKeysResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public ListKeysResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public ListKeysResult withKeys(Collection<KeyListEntry> collection) {
        setKeys(collection);
        return this;
    }
}
