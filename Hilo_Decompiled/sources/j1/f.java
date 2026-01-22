package j1;

import okhttp3.WebSocket;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f extends Thread {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WebSocket f١٥١٦٥a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f١٥١٦٦b;

    public f(k kVar, WebSocket webSocket) {
        this.f١٥١٦٦b = kVar;
        this.f١٥١٦٥a = webSocket;
    }

    public final /* synthetic */ void a(Exception exc) {
        this.f١٥١٦٦b.f١٥١٧٣b.c(new RuntimeException("doubao error code:-1  msg:" + exc));
        this.f١٥١٦٦b.f١٥١٨٢k.b();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.f١٥١٦٦b.c(this.f١٥١٦٥a);
        } catch (Exception e10) {
            LogUtils.file("DoubaoAsrAsyncClient", "发送数据发生异常：" + LogUtils.getErrorInfo(e10));
            ThreadUtils.postUITask(new Runnable() { // from class: j1.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.a(e10);
                }
            });
        } finally {
            LogUtils.file("DoubaoAsrAsyncClient", "发送语音数据的线程已经停止");
        }
    }
}
