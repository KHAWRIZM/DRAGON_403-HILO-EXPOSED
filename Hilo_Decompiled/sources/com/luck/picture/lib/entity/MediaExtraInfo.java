package com.luck.picture.lib.entity;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class MediaExtraInfo {
    private long duration;
    private int height;
    private String orientation;
    private String videoThumbnail;
    private int width;

    public long getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    public String getOrientation() {
        return this.orientation;
    }

    public String getVideoThumbnail() {
        return this.videoThumbnail;
    }

    public int getWidth() {
        return this.width;
    }

    public void setDuration(long j10) {
        this.duration = j10;
    }

    public void setHeight(int i10) {
        this.height = i10;
    }

    public void setOrientation(String str) {
        this.orientation = str;
    }

    public void setVideoThumbnail(String str) {
        this.videoThumbnail = str;
    }

    public void setWidth(int i10) {
        this.width = i10;
    }

    public String toString() {
        return "MediaExtraInfo{videoThumbnail='" + this.videoThumbnail + "', width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", orientation='" + this.orientation + "'}";
    }
}
