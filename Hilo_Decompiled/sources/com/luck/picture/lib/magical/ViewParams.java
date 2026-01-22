package com.luck.picture.lib.magical;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ViewParams implements Parcelable {
    public static final Parcelable.Creator<ViewParams> CREATOR = new Parcelable.Creator<ViewParams>() { // from class: com.luck.picture.lib.magical.ViewParams.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ViewParams createFromParcel(Parcel parcel) {
            return new ViewParams(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ViewParams[] newArray(int i10) {
            return new ViewParams[i10];
        }
    };
    public int height;
    public int left;
    public int top;
    public int width;

    public ViewParams() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getHeight() {
        return this.height;
    }

    public int getLeft() {
        return this.left;
    }

    public int getTop() {
        return this.top;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i10) {
        this.height = i10;
    }

    public void setLeft(int i10) {
        this.left = i10;
    }

    public void setTop(int i10) {
        this.top = i10;
    }

    public void setWidth(int i10) {
        this.width = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.left);
        parcel.writeInt(this.top);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
    }

    protected ViewParams(Parcel parcel) {
        this.left = parcel.readInt();
        this.top = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
    }
}
