package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MFAOptionType implements Serializable {
    private String attributeName;
    private String deliveryMedium;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof MFAOptionType)) {
            return false;
        }
        MFAOptionType mFAOptionType = (MFAOptionType) obj;
        if (mFAOptionType.getDeliveryMedium() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getDeliveryMedium() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (mFAOptionType.getDeliveryMedium() != null && !mFAOptionType.getDeliveryMedium().equals(getDeliveryMedium())) {
            return false;
        }
        if (mFAOptionType.getAttributeName() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getAttributeName() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (mFAOptionType.getAttributeName() == null || mFAOptionType.getAttributeName().equals(getAttributeName())) {
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

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getDeliveryMedium() == null) {
            hashCode = 0;
        } else {
            hashCode = getDeliveryMedium().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getAttributeName() != null) {
            i10 = getAttributeName().hashCode();
        }
        return i11 + i10;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public void setDeliveryMedium(String str) {
        this.deliveryMedium = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDeliveryMedium() != null) {
            sb.append("DeliveryMedium: " + getDeliveryMedium() + ",");
        }
        if (getAttributeName() != null) {
            sb.append("AttributeName: " + getAttributeName());
        }
        sb.append("}");
        return sb.toString();
    }

    public MFAOptionType withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public MFAOptionType withDeliveryMedium(String str) {
        this.deliveryMedium = str;
        return this;
    }

    public void setDeliveryMedium(DeliveryMediumType deliveryMediumType) {
        this.deliveryMedium = deliveryMediumType.toString();
    }

    public MFAOptionType withDeliveryMedium(DeliveryMediumType deliveryMediumType) {
        this.deliveryMedium = deliveryMediumType.toString();
        return this;
    }
}
