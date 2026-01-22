package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class Tag implements Serializable {
    private String tagKey;
    private String tagValue;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        if (tag.getTagKey() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getTagKey() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (tag.getTagKey() != null && !tag.getTagKey().equals(getTagKey())) {
            return false;
        }
        if (tag.getTagValue() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getTagValue() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (tag.getTagValue() == null || tag.getTagValue().equals(getTagValue())) {
            return true;
        }
        return false;
    }

    public String getTagKey() {
        return this.tagKey;
    }

    public String getTagValue() {
        return this.tagValue;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getTagKey() == null) {
            hashCode = 0;
        } else {
            hashCode = getTagKey().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getTagValue() != null) {
            i10 = getTagValue().hashCode();
        }
        return i11 + i10;
    }

    public void setTagKey(String str) {
        this.tagKey = str;
    }

    public void setTagValue(String str) {
        this.tagValue = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getTagKey() != null) {
            sb.append("TagKey: " + getTagKey() + ",");
        }
        if (getTagValue() != null) {
            sb.append("TagValue: " + getTagValue());
        }
        sb.append("}");
        return sb.toString();
    }

    public Tag withTagKey(String str) {
        this.tagKey = str;
        return this;
    }

    public Tag withTagValue(String str) {
        this.tagValue = str;
        return this;
    }
}
