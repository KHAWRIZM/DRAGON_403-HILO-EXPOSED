package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ScheduleKeyDeletionRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private Integer pendingWindowInDays;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ScheduleKeyDeletionRequest)) {
            return false;
        }
        ScheduleKeyDeletionRequest scheduleKeyDeletionRequest = (ScheduleKeyDeletionRequest) obj;
        if (scheduleKeyDeletionRequest.getKeyId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getKeyId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (scheduleKeyDeletionRequest.getKeyId() != null && !scheduleKeyDeletionRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (scheduleKeyDeletionRequest.getPendingWindowInDays() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getPendingWindowInDays() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (scheduleKeyDeletionRequest.getPendingWindowInDays() == null || scheduleKeyDeletionRequest.getPendingWindowInDays().equals(getPendingWindowInDays())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Integer getPendingWindowInDays() {
        return this.pendingWindowInDays;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getPendingWindowInDays() != null) {
            i10 = getPendingWindowInDays().hashCode();
        }
        return i11 + i10;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setPendingWindowInDays(Integer num) {
        this.pendingWindowInDays = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getPendingWindowInDays() != null) {
            sb.append("PendingWindowInDays: " + getPendingWindowInDays());
        }
        sb.append("}");
        return sb.toString();
    }

    public ScheduleKeyDeletionRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ScheduleKeyDeletionRequest withPendingWindowInDays(Integer num) {
        this.pendingWindowInDays = num;
        return this;
    }
}
