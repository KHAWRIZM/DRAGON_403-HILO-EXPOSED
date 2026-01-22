package com.tencent.rtmp.ui;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final /* synthetic */ class a implements Runnable {
    private final TXCloudVideoView a;

    private a(TXCloudVideoView tXCloudVideoView) {
        this.a = tXCloudVideoView;
    }

    public static Runnable a(TXCloudVideoView tXCloudVideoView) {
        return new a(tXCloudVideoView);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.hideIndicatorView();
    }
}
