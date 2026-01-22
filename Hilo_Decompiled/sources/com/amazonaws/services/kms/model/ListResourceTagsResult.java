package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListResourceTagsResult implements Serializable {
    private String nextMarker;
    private List<Tag> tags = new ArrayList();
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
        if (obj == null || !(obj instanceof ListResourceTagsResult)) {
            return false;
        }
        ListResourceTagsResult listResourceTagsResult = (ListResourceTagsResult) obj;
        if (listResourceTagsResult.getTags() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getTags() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (listResourceTagsResult.getTags() != null && !listResourceTagsResult.getTags().equals(getTags())) {
            return false;
        }
        if (listResourceTagsResult.getNextMarker() == null) {
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
        if (listResourceTagsResult.getNextMarker() != null && !listResourceTagsResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if (listResourceTagsResult.getTruncated() == null) {
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
        if (listResourceTagsResult.getTruncated() == null || listResourceTagsResult.getTruncated().equals(getTruncated())) {
            return true;
        }
        return false;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public List<Tag> getTags() {
        return this.tags;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getTags() == null) {
            hashCode = 0;
        } else {
            hashCode = getTags().hashCode();
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

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            this.tags = new ArrayList(collection);
        }
    }

    public void setTruncated(Boolean bool) {
        this.truncated = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getTags() != null) {
            sb.append("Tags: " + getTags() + ",");
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

    public ListResourceTagsResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public ListResourceTagsResult withTags(Tag... tagArr) {
        if (getTags() == null) {
            this.tags = new ArrayList(tagArr.length);
        }
        for (Tag tag : tagArr) {
            this.tags.add(tag);
        }
        return this;
    }

    public ListResourceTagsResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public ListResourceTagsResult withTags(Collection<Tag> collection) {
        setTags(collection);
        return this;
    }
}
