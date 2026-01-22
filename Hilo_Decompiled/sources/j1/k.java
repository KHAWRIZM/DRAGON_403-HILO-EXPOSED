package j1;

import android.os.SystemClock;
import com.amazonaws.services.s3.internal.Constants;
import com.luck.picture.lib.config.PictureMimeType;
import com.qiahao.base_common.network.BaseServer;
import com.qiahao.base_common.network.interceptors.HeaderInterceptor;
import java.util.UUID;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;
import org.json.JSONObject;
import tech.sud.gip.asr.base.Sudint;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class k extends WebSocketListener {

    /* renamed from: a, reason: collision with root package name */
    public final b f١٥١٧٢a;

    /* renamed from: b, reason: collision with root package name */
    public final q f١٥١٧٣b;

    /* renamed from: c, reason: collision with root package name */
    public final int f١٥١٧٤c = 16000;

    /* renamed from: d, reason: collision with root package name */
    public final int f١٥١٧٥d = 16;

    /* renamed from: e, reason: collision with root package name */
    public final int f١٥١٧٦e = 1;

    /* renamed from: f, reason: collision with root package name */
    public final int f١٥١٧٧f = (int) ((((200 * 1.0f) / 1000.0f) * 16000) * 2);

    /* renamed from: g, reason: collision with root package name */
    public boolean f١٥١٧٨g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f١٥١٧٩h;

    /* renamed from: i, reason: collision with root package name */
    public f f١٥١٨٠i;

    /* renamed from: j, reason: collision with root package name */
    public d f١٥١٨١j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ p f١٥١٨٢k;

    public k(p pVar, b bVar, q qVar) {
        this.f١٥١٨٢k = pVar;
        this.f١٥١٧٢a = bVar;
        this.f١٥١٧٣b = qVar;
    }

    public final /* synthetic */ void a() {
        this.f١٥١٨٢k.k();
        this.f١٥١٧٣b.b();
    }

    public final /* synthetic */ void b(Throwable th) {
        this.f١٥١٧٣b.c(th);
        this.f١٥١٨٢k.b();
    }

    public final void c(WebSocket webSocket) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uid", this.f١٥١٧٢a.f١٥١٤٩e);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("format", "pcm");
        jSONObject2.put("codec", "raw");
        jSONObject2.put("rate", this.f١٥١٧٤c);
        jSONObject2.put("bits", this.f١٥١٧٥d);
        jSONObject2.put("channel", this.f١٥١٧٦e);
        jSONObject2.put(HeaderInterceptor.LANGUAGE, this.f١٥١٧٢a.f١٥١٥١g);
        JSONObject jSONObject3 = this.f١٥١٧٢a.f١٥١٥٥k;
        if (jSONObject3 == null) {
            jSONObject3 = new JSONObject();
            jSONObject3.put("model_name", this.f١٥١٧٢a.f١٥١٥٢h);
            jSONObject3.put("enable_punc", true);
            jSONObject3.put("enable_itn", true);
            jSONObject3.put("enable_nonstream", true);
            jSONObject3.put("end_window_size", 200);
            jSONObject3.put("force_to_speech_time", 1);
            jSONObject3.put("result_type", "single");
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("user", jSONObject);
        jSONObject4.put(PictureMimeType.MIME_TYPE_PREFIX_AUDIO, jSONObject2);
        jSONObject4.put("request", jSONObject3);
        String jSONObject5 = jSONObject4.toString();
        SudLogger.d(this.f١٥١٨٢k.f١٥١٩٣a, "发送完整客户端请求: " + jSONObject5);
        LogUtils.file("DoubaoAsrAsyncClient", "发送完整客户端请求: " + jSONObject5);
        byte[] bytes = jSONObject5.getBytes();
        byte[] i10 = p.i(bytes, bytes.length);
        byte b10 = (byte) 17;
        byte[] bArr = {17, b10, b10, 0};
        byte[] h10 = p.h(i10.length);
        byte[] h11 = p.h(1);
        byte[] bArr2 = new byte[i10.length + 12];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        System.arraycopy(h11, 0, bArr2, 4, 4);
        System.arraycopy(h10, 0, bArr2, 8, 4);
        System.arraycopy(i10, 0, bArr2, 12, i10.length);
        webSocket.send(ByteString.of(bArr2));
        int i11 = 1;
        while (true) {
            p pVar = this.f١٥١٨٢k;
            if (pVar.f١٥١٩٤b) {
                if (this.f١٥١٧٩h) {
                    SudLogger.d(pVar.f١٥١٩٣a, "已经发了最后一个包，不再发送数据包");
                    LogUtils.file("DoubaoAsrAsyncClient", "已经发了最后一个包，不再发送数据包");
                    ThreadUtils.postUITask(new Runnable() { // from class: j1.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            k.this.e();
                        }
                    });
                    return;
                }
                if (this.f١٥١٧٨g) {
                    SudLogger.d(pVar.f١٥١٩٣a, "给后端发送最后一个数据包");
                    LogUtils.file("DoubaoAsrAsyncClient", "给后端发送最后一个数据包");
                    d(webSocket, new byte[this.f١٥١٧٧f], true, -(i11 + 1));
                    this.f١٥١٧٩h = true;
                    return;
                }
                f1.a aVar = this.f١٥١٧٢a.f١٥١٥٠f;
                int i12 = this.f١٥١٧٧f;
                byte[] bArr3 = new byte[i12];
                aVar.getClass();
                int i13 = 0;
                while (i13 < i12) {
                    try {
                        i13 += aVar.f١٤٠٣٧a.takeBuffer(bArr3, i13);
                    } catch (Exception unused) {
                    }
                }
                if (i13 <= 0) {
                    SudLogger.d(this.f١٥١٨٢k.f١٥١٩٣a, "===>read len <= 0,exit");
                    LogUtils.file("DoubaoAsrAsyncClient", "===>read len <= 0,exit");
                } else {
                    i11++;
                    d(webSocket, bArr3, false, i11);
                }
            } else {
                return;
            }
        }
    }

    public final void d(WebSocket webSocket, byte[] bArr, boolean z10, int i10) {
        int i11;
        if (z10) {
            i11 = 3;
        } else {
            i11 = 1;
        }
        byte[] bArr2 = {17, (byte) (i11 | 32), (byte) 17, 0};
        byte[] h10 = p.h(i10);
        byte[] i12 = p.i(bArr, bArr.length);
        byte[] h11 = p.h(i12.length);
        byte[] bArr3 = new byte[i12.length + 12];
        System.arraycopy(bArr2, 0, bArr3, 0, 4);
        System.arraycopy(h10, 0, bArr3, 4, 4);
        System.arraycopy(h11, 0, bArr3, 8, 4);
        System.arraycopy(i12, 0, bArr3, 12, i12.length);
        webSocket.send(ByteString.of(bArr3));
    }

    public final /* synthetic */ void e() {
        this.f١٥١٨٢k.b();
    }

    public final void f() {
        p pVar = this.f١٥١٨٢k;
        pVar.k();
        Sudint sudint = new Sudint(pVar.f١٥٢٠١i, pVar.f١٥٢٠٣k, pVar.f١٥٢٠٢j, pVar.f١٥١٩٩g);
        pVar.f١٥٢٠٠h = sudint;
        synchronized (sudint) {
            if (!sudint.Sudcase) {
                sudint.Sudcase = true;
                sudint.Suddo = 0;
                sudint.Sudif = u.j.b(UUID.randomUUID().toString());
                sudint.Sudchar = SystemClock.elapsedRealtime();
                sudint.Sudgoto.removeCallbacks(sudint.Sudelse);
                sudint.Sudgoto.postDelayed(sudint.Sudelse, BaseServer.TIMEOUT_DEBUG);
            }
        }
        this.f١٥١٧٣b.a();
    }

    public final void onClosed(WebSocket webSocket, int i10, String str) {
        super.onClosed(webSocket, i10, str);
        LogUtils.file("DoubaoAsrAsyncClient", "===> onClosed： code:" + i10 + " reason:" + str);
        SudLogger.d(this.f١٥١٨٢k.f١٥١٩٣a, "===> onClosed： code:" + i10 + " reason:" + str);
        ThreadUtils.postUITask(new Runnable() { // from class: j1.g
            @Override // java.lang.Runnable
            public final void run() {
                k.this.a();
            }
        });
    }

    public final void onClosing(WebSocket webSocket, int i10, String str) {
        super.onClosing(webSocket, i10, str);
        webSocket.close(i10, str);
        LogUtils.file("DoubaoAsrAsyncClient", "===> onClosing： code:" + i10 + " reason:" + str);
        SudLogger.d(this.f١٥١٨٢k.f١٥١٩٣a, "===> onClosing： code:" + i10 + " reason:" + str);
    }

    public final void onFailure(WebSocket webSocket, final Throwable th, Response response) {
        String response2;
        super.onFailure(webSocket, th, response);
        StringBuilder sb = new StringBuilder("===> onFailure： Throwable:");
        sb.append(th.getMessage());
        sb.append(" Response:");
        String str = Constants.NULL_VERSION_ID;
        if (response == null) {
            response2 = Constants.NULL_VERSION_ID;
        } else {
            response2 = response.toString();
        }
        sb.append(response2);
        LogUtils.file("DoubaoAsrAsyncClient", sb.toString());
        String str2 = this.f١٥١٨٢k.f١٥١٩٣a;
        StringBuilder sb2 = new StringBuilder("===> onFailure： Throwable:");
        sb2.append(th.getMessage());
        sb2.append(" Response:");
        if (response != null) {
            str = response.toString();
        }
        sb2.append(str);
        SudLogger.d(str2, sb2.toString());
        ThreadUtils.postUITask(new Runnable() { // from class: j1.i
            @Override // java.lang.Runnable
            public final void run() {
                k.this.b(th);
            }
        });
    }

    public final void onMessage(WebSocket webSocket, ByteString byteString) {
        this.f١٥١٨٢k.f١٥٢٠٥m.offer(byteString.toByteArray());
    }

    public final void onOpen(WebSocket webSocket, Response response) {
        String header = response.header("X-Tt-Logid");
        LogUtils.file("DoubaoAsrAsyncClient", "===> onOpen,X-Tt-Logid:" + header);
        SudLogger.d(this.f١٥١٨٢k.f١٥١٩٣a, "===> onOpen,X-Tt-Logid:" + header);
        ThreadUtils.postUITask(new Runnable() { // from class: j1.h
            @Override // java.lang.Runnable
            public final void run() {
                k.this.f();
            }
        });
        if (this.f١٥١٨٠i == null) {
            f fVar = new f(this, webSocket);
            this.f١٥١٨٠i = fVar;
            fVar.start();
        }
        if (this.f١٥١٨١j == null) {
            d dVar = new d(this);
            this.f١٥١٨١j = dVar;
            dVar.start();
        }
    }
}
