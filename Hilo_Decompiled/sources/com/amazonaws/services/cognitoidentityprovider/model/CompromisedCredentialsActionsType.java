package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CompromisedCredentialsActionsType implements Serializable {
    private String eventAction;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CompromisedCredentialsActionsType)) {
            return false;
        }
        CompromisedCredentialsActionsType compromisedCredentialsActionsType = (CompromisedCredentialsActionsType) obj;
        if (compromisedCredentialsActionsType.getEventAction() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getEventAction() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (compromisedCredentialsActionsType.getEventAction() == null || compromisedCredentialsActionsType.getEventAction().equals(getEventAction())) {
            return true;
        }
        return false;
    }

    public String getEventAction() {
        return this.eventAction;
    }

    public int hashCode() {
        int hashCode;
        if (getEventAction() == null) {
            hashCode = 0;
        } else {
            hashCode = getEventAction().hashCode();
        }
        return 31 + hashCode;
    }

    public void setEventAction(String str) {
        this.eventAction = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getEventAction() != null) {
            sb.append("EventAction: " + getEventAction());
        }
        sb.append("}");
        return sb.toString();
    }

    public CompromisedCredentialsActionsType withEventAction(String str) {
        this.eventAction = str;
        return this;
    }

    public void setEventAction(CompromisedCredentialsEventActionType compromisedCredentialsEventActionType) {
        this.eventAction = compromisedCredentialsEventActionType.toString();
    }

    public CompromisedCredentialsActionsType withEventAction(CompromisedCredentialsEventActionType compromisedCredentialsEventActionType) {
        this.eventAction = compromisedCredentialsEventActionType.toString();
        return this;
    }
}
