package n1;

import e.d;
import j1.k;
import j1.p;
import java.nio.ByteBuffer;
import tech.sud.gip.asr.base.utils.ByteArrayBlockingQueue;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.ISudAiAgent;
import tech.sud.gip.core.ISudListenerAiAgent;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class b implements ISudAiAgent {

    /* renamed from: a, reason: collision with root package name */
    public final String f١٦١٤٦a = "SudGIP ".concat(b.class.getSimpleName());

    /* renamed from: b, reason: collision with root package name */
    public long f١٦١٤٧b;

    /* renamed from: c, reason: collision with root package name */
    public String f١٦١٤٨c;

    /* renamed from: d, reason: collision with root package name */
    public String f١٦١٤٩d;

    /* renamed from: e, reason: collision with root package name */
    public String f١٦١٥٠e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f١٦١٥١f;

    /* renamed from: g, reason: collision with root package name */
    public String f١٦١٥٢g;

    /* renamed from: h, reason: collision with root package name */
    public p f١٦١٥٣h;

    /* renamed from: i, reason: collision with root package name */
    public f1.a f١٦١٥٤i;

    /* renamed from: j, reason: collision with root package name */
    public ISudListenerAiAgent f١٦١٥٥j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f١٦١٥٦k;

    /* renamed from: l, reason: collision with root package name */
    public a f١٦١٥٧l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f١٦١٥٨m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f١٦١٥٩n;

    /* renamed from: o, reason: collision with root package name */
    public y0.b f١٦١٦٠o;

    public final synchronized void a() {
        try {
            LogUtils.file("AiAgentImpl", "stopASR currentIsRunning:" + this.f١٦١٥١f);
            SudLogger.d(this.f١٦١٤٦a, "stopASR currentIsRunning:" + this.f١٦١٥١f);
            if (this.f١٦١٥١f) {
                this.f١٦١٥١f = false;
                if (this.f١٦١٥٣h != null) {
                    f1.a aVar = this.f١٦١٥٤i;
                    if (aVar != null) {
                        ByteArrayBlockingQueue byteArrayBlockingQueue = aVar.f١٤٠٣٧a;
                        if (byteArrayBlockingQueue != null) {
                            byteArrayBlockingQueue.offer((byte) 0);
                            aVar.f١٤٠٣٧a = null;
                        }
                        this.f١٦١٥٤i = null;
                    }
                    p pVar = this.f١٦١٥٣h;
                    if (pVar != null) {
                        pVar.b();
                        this.f١٦١٥٣h = null;
                        LogUtils.file("AiAgentImpl", "Continuous recognition stopped.");
                        SudLogger.d(this.f١٦١٤٦a, "Continuous recognition stopped.");
                    }
                }
            }
        } finally {
        }
    }

    public final void pauseAudio() {
        k kVar;
        p pVar = this.f١٦١٥٣h;
        if (pVar != null) {
            SudLogger.d(pVar.f١٥١٩٣a, "pauseRecognize");
            LogUtils.file("DoubaoAsrAsyncClient", "pauseRecognize");
            if (pVar.f١٥١٩٥c != null && (kVar = pVar.f١٥١٩٦d) != null) {
                kVar.f١٥١٧٨g = true;
                f1.a aVar = kVar.f١٥١٧٢a.f١٥١٥٠f;
                ByteArrayBlockingQueue byteArrayBlockingQueue = aVar.f١٤٠٣٧a;
                if (byteArrayBlockingQueue != null) {
                    byteArrayBlockingQueue.offer((byte) 0);
                    aVar.f١٤٠٣٧a = null;
                }
            }
        }
    }

    public final void pushAudio(ByteBuffer byteBuffer, int i10) {
        if (!this.f١٦١٥٨m) {
            return;
        }
        synchronized (this) {
            if (byteBuffer != null && i10 != 0) {
                try {
                    if (!this.f١٦١٥١f && this.f١٦١٥٧l == null) {
                        a aVar = new a(this);
                        this.f١٦١٥٧l = aVar;
                        if (this.f١٦١٥٦k) {
                            this.f١٦١٥٦k = false;
                            ThreadUtils.postDelayedUITask(aVar, 5000L);
                        } else {
                            ThreadUtils.postUITask(aVar);
                        }
                    }
                    if (this.f١٦١٥٤i != null) {
                        try {
                            byte[] bArr = new byte[i10];
                            byteBuffer.get(bArr, 0, i10);
                            f1.a aVar2 = this.f١٦١٥٤i;
                            aVar2.getClass();
                            if (i10 != 0) {
                                aVar2.f١٤٠٣٧a.offerBuffer(bArr);
                            }
                        } catch (Exception unused) {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void sendText(String str) {
        if (!this.f١٦١٥٩n) {
            return;
        }
        long j10 = this.f١٦١٤٧b;
        String str2 = this.f١٦١٤٨c;
        String str3 = this.f١٦١٤٩d;
        String str4 = this.f١٦١٥٠e;
        String str5 = d.f١٣٧١٨a;
        yf.b bVar = new yf.b();
        bVar.a = j10;
        bVar.b = str2;
        bVar.c = str3;
        bVar.d = str4;
        bVar.e = str;
        bVar.f = null;
        d.f١٣٧١٩b.x(bVar, new e.b());
    }

    public final void setISudListenerAiAgent(ISudListenerAiAgent iSudListenerAiAgent) {
        this.f١٦١٥٥j = iSudListenerAiAgent;
    }

    public final void stopAudio() {
        p pVar = this.f١٦١٥٣h;
        if (pVar != null) {
            pVar.b();
        }
    }
}
