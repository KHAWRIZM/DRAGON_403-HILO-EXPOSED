package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CompromisedCredentialsRiskConfigurationType implements Serializable {
    private CompromisedCredentialsActionsType actions;
    private List<String> eventFilter;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CompromisedCredentialsRiskConfigurationType)) {
            return false;
        }
        CompromisedCredentialsRiskConfigurationType compromisedCredentialsRiskConfigurationType = (CompromisedCredentialsRiskConfigurationType) obj;
        if (compromisedCredentialsRiskConfigurationType.getEventFilter() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getEventFilter() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (compromisedCredentialsRiskConfigurationType.getEventFilter() != null && !compromisedCredentialsRiskConfigurationType.getEventFilter().equals(getEventFilter())) {
            return false;
        }
        if (compromisedCredentialsRiskConfigurationType.getActions() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getActions() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (compromisedCredentialsRiskConfigurationType.getActions() == null || compromisedCredentialsRiskConfigurationType.getActions().equals(getActions())) {
            return true;
        }
        return false;
    }

    public CompromisedCredentialsActionsType getActions() {
        return this.actions;
    }

    public List<String> getEventFilter() {
        return this.eventFilter;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getEventFilter() == null) {
            hashCode = 0;
        } else {
            hashCode = getEventFilter().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getActions() != null) {
            i10 = getActions().hashCode();
        }
        return i11 + i10;
    }

    public void setActions(CompromisedCredentialsActionsType compromisedCredentialsActionsType) {
        this.actions = compromisedCredentialsActionsType;
    }

    public void setEventFilter(Collection<String> collection) {
        if (collection == null) {
            this.eventFilter = null;
        } else {
            this.eventFilter = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getEventFilter() != null) {
            sb.append("EventFilter: " + getEventFilter() + ",");
        }
        if (getActions() != null) {
            sb.append("Actions: " + getActions());
        }
        sb.append("}");
        return sb.toString();
    }

    public CompromisedCredentialsRiskConfigurationType withActions(CompromisedCredentialsActionsType compromisedCredentialsActionsType) {
        this.actions = compromisedCredentialsActionsType;
        return this;
    }

    public CompromisedCredentialsRiskConfigurationType withEventFilter(String... strArr) {
        if (getEventFilter() == null) {
            this.eventFilter = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.eventFilter.add(str);
        }
        return this;
    }

    public CompromisedCredentialsRiskConfigurationType withEventFilter(Collection<String> collection) {
        setEventFilter(collection);
        return this;
    }
}
