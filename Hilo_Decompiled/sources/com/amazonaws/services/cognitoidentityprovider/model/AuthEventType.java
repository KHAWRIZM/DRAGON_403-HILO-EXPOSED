package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AuthEventType implements Serializable {
    private List<ChallengeResponseType> challengeResponses;
    private Date creationDate;
    private EventContextDataType eventContextData;
    private EventFeedbackType eventFeedback;
    private String eventId;
    private String eventResponse;
    private EventRiskType eventRisk;
    private String eventType;

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
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AuthEventType)) {
            return false;
        }
        AuthEventType authEventType = (AuthEventType) obj;
        if (authEventType.getEventId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getEventId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (authEventType.getEventId() != null && !authEventType.getEventId().equals(getEventId())) {
            return false;
        }
        if (authEventType.getEventType() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getEventType() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (authEventType.getEventType() != null && !authEventType.getEventType().equals(getEventType())) {
            return false;
        }
        if (authEventType.getCreationDate() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getCreationDate() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (authEventType.getCreationDate() != null && !authEventType.getCreationDate().equals(getCreationDate())) {
            return false;
        }
        if (authEventType.getEventResponse() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getEventResponse() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (authEventType.getEventResponse() != null && !authEventType.getEventResponse().equals(getEventResponse())) {
            return false;
        }
        if (authEventType.getEventRisk() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getEventRisk() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (authEventType.getEventRisk() != null && !authEventType.getEventRisk().equals(getEventRisk())) {
            return false;
        }
        if (authEventType.getChallengeResponses() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getChallengeResponses() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (authEventType.getChallengeResponses() != null && !authEventType.getChallengeResponses().equals(getChallengeResponses())) {
            return false;
        }
        if (authEventType.getEventContextData() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getEventContextData() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (authEventType.getEventContextData() != null && !authEventType.getEventContextData().equals(getEventContextData())) {
            return false;
        }
        if (authEventType.getEventFeedback() == null) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (getEventFeedback() == null) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (z24 ^ z25) {
            return false;
        }
        if (authEventType.getEventFeedback() == null || authEventType.getEventFeedback().equals(getEventFeedback())) {
            return true;
        }
        return false;
    }

    public List<ChallengeResponseType> getChallengeResponses() {
        return this.challengeResponses;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public EventContextDataType getEventContextData() {
        return this.eventContextData;
    }

    public EventFeedbackType getEventFeedback() {
        return this.eventFeedback;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getEventResponse() {
        return this.eventResponse;
    }

    public EventRiskType getEventRisk() {
        return this.eventRisk;
    }

    public String getEventType() {
        return this.eventType;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int i10 = 0;
        if (getEventId() == null) {
            hashCode = 0;
        } else {
            hashCode = getEventId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getEventType() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getEventType().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getCreationDate() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getCreationDate().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getEventResponse() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getEventResponse().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getEventRisk() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getEventRisk().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getChallengeResponses() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getChallengeResponses().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getEventContextData() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getEventContextData().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getEventFeedback() != null) {
            i10 = getEventFeedback().hashCode();
        }
        return i17 + i10;
    }

    public void setChallengeResponses(Collection<ChallengeResponseType> collection) {
        if (collection == null) {
            this.challengeResponses = null;
        } else {
            this.challengeResponses = new ArrayList(collection);
        }
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setEventContextData(EventContextDataType eventContextDataType) {
        this.eventContextData = eventContextDataType;
    }

    public void setEventFeedback(EventFeedbackType eventFeedbackType) {
        this.eventFeedback = eventFeedbackType;
    }

    public void setEventId(String str) {
        this.eventId = str;
    }

    public void setEventResponse(String str) {
        this.eventResponse = str;
    }

    public void setEventRisk(EventRiskType eventRiskType) {
        this.eventRisk = eventRiskType;
    }

    public void setEventType(String str) {
        this.eventType = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getEventId() != null) {
            sb.append("EventId: " + getEventId() + ",");
        }
        if (getEventType() != null) {
            sb.append("EventType: " + getEventType() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate() + ",");
        }
        if (getEventResponse() != null) {
            sb.append("EventResponse: " + getEventResponse() + ",");
        }
        if (getEventRisk() != null) {
            sb.append("EventRisk: " + getEventRisk() + ",");
        }
        if (getChallengeResponses() != null) {
            sb.append("ChallengeResponses: " + getChallengeResponses() + ",");
        }
        if (getEventContextData() != null) {
            sb.append("EventContextData: " + getEventContextData() + ",");
        }
        if (getEventFeedback() != null) {
            sb.append("EventFeedback: " + getEventFeedback());
        }
        sb.append("}");
        return sb.toString();
    }

    public AuthEventType withChallengeResponses(ChallengeResponseType... challengeResponseTypeArr) {
        if (getChallengeResponses() == null) {
            this.challengeResponses = new ArrayList(challengeResponseTypeArr.length);
        }
        for (ChallengeResponseType challengeResponseType : challengeResponseTypeArr) {
            this.challengeResponses.add(challengeResponseType);
        }
        return this;
    }

    public AuthEventType withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public AuthEventType withEventContextData(EventContextDataType eventContextDataType) {
        this.eventContextData = eventContextDataType;
        return this;
    }

    public AuthEventType withEventFeedback(EventFeedbackType eventFeedbackType) {
        this.eventFeedback = eventFeedbackType;
        return this;
    }

    public AuthEventType withEventId(String str) {
        this.eventId = str;
        return this;
    }

    public AuthEventType withEventResponse(String str) {
        this.eventResponse = str;
        return this;
    }

    public AuthEventType withEventRisk(EventRiskType eventRiskType) {
        this.eventRisk = eventRiskType;
        return this;
    }

    public AuthEventType withEventType(String str) {
        this.eventType = str;
        return this;
    }

    public void setEventResponse(EventResponseType eventResponseType) {
        this.eventResponse = eventResponseType.toString();
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType.toString();
    }

    public AuthEventType withEventResponse(EventResponseType eventResponseType) {
        this.eventResponse = eventResponseType.toString();
        return this;
    }

    public AuthEventType withEventType(EventType eventType) {
        this.eventType = eventType.toString();
        return this;
    }

    public AuthEventType withChallengeResponses(Collection<ChallengeResponseType> collection) {
        setChallengeResponses(collection);
        return this;
    }
}
