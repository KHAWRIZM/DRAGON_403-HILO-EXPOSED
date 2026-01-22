package io.agora.rtc.video;

import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class VideoCanvas {

    @Deprecated
    public static final int RENDER_MODE_ADAPTIVE = 3;
    public static final int RENDER_MODE_FILL = 4;
    public static final int RENDER_MODE_FIT = 2;
    public static final int RENDER_MODE_HIDDEN = 1;
    public String channelId;
    public int mirrorMode;
    public int renderMode;
    public int uid;
    public View view;

    public VideoCanvas(View view) {
        this.view = view;
        this.renderMode = 1;
        this.mirrorMode = 0;
        this.uid = 0;
    }

    public VideoCanvas(View view, int i10, int i11) {
        this.view = view;
        this.renderMode = i10;
        this.uid = i11;
        this.mirrorMode = 0;
    }

    public VideoCanvas(View view, int i10, String str, int i11) {
        this.view = view;
        this.renderMode = i10;
        this.channelId = str;
        this.uid = i11;
        this.mirrorMode = 0;
    }

    public VideoCanvas(View view, int i10, int i11, int i12) {
        this.view = view;
        this.renderMode = i10;
        this.uid = i11;
        this.mirrorMode = i12;
    }

    public VideoCanvas(View view, int i10, String str, int i11, int i12) {
        this.view = view;
        this.renderMode = i10;
        this.mirrorMode = i12;
        this.channelId = str;
        this.uid = i11;
    }
}
