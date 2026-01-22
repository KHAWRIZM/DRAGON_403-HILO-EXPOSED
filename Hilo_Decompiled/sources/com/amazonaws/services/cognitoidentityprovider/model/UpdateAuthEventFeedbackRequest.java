package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UpdateAuthEventFeedbackRequest extends AmazonWebServiceRequest implements Serializable {
    private String eventId;
    private String feedbackToken;
    private String feedbackValue;
    private String userPoolId;
    private String username;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateAuthEventFeedbackRequest)) {
            return false;
        }
        UpdateAuthEventFeedbackRequest updateAuthEventFeedbackRequest = (UpdateAuthEventFeedbackRequest) obj;
        if (updateAuthEventFeedbackRequest.getUserPoolId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserPoolId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (updateAuthEventFeedbackRequest.getUserPoolId() != null && !updateAuthEventFeedbackRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (updateAuthEventFeedbackRequest.getUsername() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getUsername() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (updateAuthEventFeedbackRequest.getUsername() != null && !updateAuthEventFeedbackRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if (updateAuthEventFeedbackRequest.getEventId() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getEventId() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (updateAuthEventFeedbackRequest.getEventId() != null && !updateAuthEventFeedbackRequest.getEventId().equals(getEventId())) {
            return false;
        }
        if (updateAuthEventFeedbackRequest.getFeedbackToken() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getFeedbackToken() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (updateAuthEventFeedbackRequest.getFeedbackToken() != null && !updateAuthEventFeedbackRequest.getFeedbackToken().equals(getFeedbackToken())) {
            return false;
        }
        if (updateAuthEventFeedbackRequest.getFeedbackValue() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getFeedbackValue() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (updateAuthEventFeedbackRequest.getFeedbackValue() == null || updateAuthEventFeedbackRequest.getFeedbackValue().equals(getFeedbackValue())) {
            return true;
        }
        return false;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getFeedbackToken() {
        return this.feedbackToken;
    }

    public String getFeedbackValue() {
        return this.feedbackValue;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getUsername() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getUsername().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getEventId() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getEventId().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getFeedbackToken() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getFeedbackToken().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getFeedbackValue() != null) {
            i10 = getFeedbackValue().hashCode();
        }
        return i14 + i10;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setFeedbackToken(String str) {
        this.feedbackToken = str;
    }

    public void setFeedbackValue(String str) {
        this.feedbackValue = str;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getEventId() != null) {
            sb.append("EventId: " + getEventId() + ",");
        }
        if (getFeedbackToken() != null) {
            sb.append("FeedbackToken: " + getFeedbackToken() + ",");
        }
        if (getFeedbackValue() != null) {
            sb.append("FeedbackValue: " + getFeedbackValue());
        }
        sb.append("}");
        return sb.toString();
    }

    public UpdateAuthEventFeedbackRequest withEventId(String str) {
        this.eventId = str;
        return this;
    }

    public UpdateAuthEventFeedbackRequest withFeedbackToken(String str) {
        this.feedbackToken = str;
        return this;
    }

    public UpdateAuthEventFeedbackRequest withFeedbackValue(String str) {
        this.feedbackValue = str;
        return this;
    }

    public UpdateAuthEventFeedbackRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public UpdateAuthEventFeedbackRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public void setFeedbackValue(FeedbackValueType feedbackValueType) {
        this.feedbackValue = feedbackValueType.toString();
    }

    public UpdateAuthEventFeedbackRequest withFeedbackValue(FeedbackValueType feedbackValueType) {
        this.feedbackValue = feedbackValueType.toString();
        return this;
    }
}
