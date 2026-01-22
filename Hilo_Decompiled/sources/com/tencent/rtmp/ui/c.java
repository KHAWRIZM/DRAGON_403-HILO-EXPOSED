package com.tencent.rtmp.ui;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
final /* synthetic */ class c implements Runnable {
    private final TXCloudVideoView a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;

    private c(TXCloudVideoView tXCloudVideoView, int i, int i2, int i3, int i4) {
        this.a = tXCloudVideoView;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public static Runnable a(TXCloudVideoView tXCloudVideoView, int i, int i2, int i3, int i4) {
        return new c(tXCloudVideoView, i, i2, i3, i4);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.showFocusViewInternal(this.b, this.c, this.d, this.e);
    }
}
