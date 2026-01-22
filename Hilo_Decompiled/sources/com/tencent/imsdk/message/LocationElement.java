package com.tencent.imsdk.message;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class LocationElement extends MessageBaseElement {
    private String description;
    private double latitude;
    private double longitude;

    public LocationElement() {
        setElementType(7);
    }

    public String getDescription() {
        return this.description;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }
}
