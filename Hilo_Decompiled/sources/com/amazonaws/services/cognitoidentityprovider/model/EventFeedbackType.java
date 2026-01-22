package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class EventFeedbackType implements Serializable {
    private Date feedbackDate;
    private String feedbackValue;
    private String provider;

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
        if (obj == null || !(obj instanceof EventFeedbackType)) {
            return false;
        }
        EventFeedbackType eventFeedbackType = (EventFeedbackType) obj;
        if (eventFeedbackType.getFeedbackValue() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getFeedbackValue() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (eventFeedbackType.getFeedbackValue() != null && !eventFeedbackType.getFeedbackValue().equals(getFeedbackValue())) {
            return false;
        }
        if (eventFeedbackType.getProvider() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getProvider() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (eventFeedbackType.getProvider() != null && !eventFeedbackType.getProvider().equals(getProvider())) {
            return false;
        }
        if (eventFeedbackType.getFeedbackDate() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getFeedbackDate() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (eventFeedbackType.getFeedbackDate() == null || eventFeedbackType.getFeedbackDate().equals(getFeedbackDate())) {
            return true;
        }
        return false;
    }

    public Date getFeedbackDate() {
        return this.feedbackDate;
    }

    public String getFeedbackValue() {
        return this.feedbackValue;
    }

    public String getProvider() {
        return this.provider;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getFeedbackValue() == null) {
            hashCode = 0;
        } else {
            hashCode = getFeedbackValue().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getProvider() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getProvider().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getFeedbackDate() != null) {
            i10 = getFeedbackDate().hashCode();
        }
        return i12 + i10;
    }

    public void setFeedbackDate(Date date) {
        this.feedbackDate = date;
    }

    public void setFeedbackValue(String str) {
        this.feedbackValue = str;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getFeedbackValue() != null) {
            sb.append("FeedbackValue: " + getFeedbackValue() + ",");
        }
        if (getProvider() != null) {
            sb.append("Provider: " + getProvider() + ",");
        }
        if (getFeedbackDate() != null) {
            sb.append("FeedbackDate: " + getFeedbackDate());
        }
        sb.append("}");
        return sb.toString();
    }

    public EventFeedbackType withFeedbackDate(Date date) {
        this.feedbackDate = date;
        return this;
    }

    public EventFeedbackType withFeedbackValue(String str) {
        this.feedbackValue = str;
        return this;
    }

    public EventFeedbackType withProvider(String str) {
        this.provider = str;
        return this;
    }

    public void setFeedbackValue(FeedbackValueType feedbackValueType) {
        this.feedbackValue = feedbackValueType.toString();
    }

    public EventFeedbackType withFeedbackValue(FeedbackValueType feedbackValueType) {
        this.feedbackValue = feedbackValueType.toString();
        return this;
    }
}
