package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CodeDeliveryDetailsType implements Serializable {
    private String attributeName;
    private String deliveryMedium;
    private String destination;

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
        if (obj == null || !(obj instanceof CodeDeliveryDetailsType)) {
            return false;
        }
        CodeDeliveryDetailsType codeDeliveryDetailsType = (CodeDeliveryDetailsType) obj;
        if (codeDeliveryDetailsType.getDestination() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getDestination() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (codeDeliveryDetailsType.getDestination() != null && !codeDeliveryDetailsType.getDestination().equals(getDestination())) {
            return false;
        }
        if (codeDeliveryDetailsType.getDeliveryMedium() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getDeliveryMedium() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (codeDeliveryDetailsType.getDeliveryMedium() != null && !codeDeliveryDetailsType.getDeliveryMedium().equals(getDeliveryMedium())) {
            return false;
        }
        if (codeDeliveryDetailsType.getAttributeName() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getAttributeName() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (codeDeliveryDetailsType.getAttributeName() == null || codeDeliveryDetailsType.getAttributeName().equals(getAttributeName())) {
            return true;
        }
        return false;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public String getDeliveryMedium() {
        return this.deliveryMedium;
    }

    public String getDestination() {
        return this.destination;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getDestination() == null) {
            hashCode = 0;
        } else {
            hashCode = getDestination().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getDeliveryMedium() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getDeliveryMedium().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getAttributeName() != null) {
            i10 = getAttributeName().hashCode();
        }
        return i12 + i10;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public void setDeliveryMedium(String str) {
        this.deliveryMedium = str;
    }

    public void setDestination(String str) {
        this.destination = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDestination() != null) {
            sb.append("Destination: " + getDestination() + ",");
        }
        if (getDeliveryMedium() != null) {
            sb.append("DeliveryMedium: " + getDeliveryMedium() + ",");
        }
        if (getAttributeName() != null) {
            sb.append("AttributeName: " + getAttributeName());
        }
        sb.append("}");
        return sb.toString();
    }

    public CodeDeliveryDetailsType withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public CodeDeliveryDetailsType withDeliveryMedium(String str) {
        this.deliveryMedium = str;
        return this;
    }

    public CodeDeliveryDetailsType withDestination(String str) {
        this.destination = str;
        return this;
    }

    public void setDeliveryMedium(DeliveryMediumType deliveryMediumType) {
        this.deliveryMedium = deliveryMediumType.toString();
    }

    public CodeDeliveryDetailsType withDeliveryMedium(DeliveryMediumType deliveryMediumType) {
        this.deliveryMedium = deliveryMediumType.toString();
        return this;
    }
}
