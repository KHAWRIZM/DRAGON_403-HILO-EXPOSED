package j1;

import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import kotlin.KotlinVersion;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import org.json.JSONArray;
import org.json.JSONObject;
import tech.sud.base.utils.BytesUtils;
import tech.sud.gip.asr.base.Sudif;
import tech.sud.gip.asr.base.Sudint;
import tech.sud.gip.asr.base.Sudnew;
import tech.sud.gip.asr.base.utils.ByteArrayBlockingQueue;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class p {

    /* renamed from: b, reason: collision with root package name */
    public boolean f١٥١٩٤b;

    /* renamed from: c, reason: collision with root package name */
    public WebSocket f١٥١٩٥c;

    /* renamed from: d, reason: collision with root package name */
    public k f١٥١٩٦d;

    /* renamed from: e, reason: collision with root package name */
    public String f١٥١٩٧e;

    /* renamed from: f, reason: collision with root package name */
    public f1.a f١٥١٩٨f;

    /* renamed from: g, reason: collision with root package name */
    public final Sudnew f١٥١٩٩g;

    /* renamed from: h, reason: collision with root package name */
    public Sudint f١٥٢٠٠h;

    /* renamed from: i, reason: collision with root package name */
    public long f١٥٢٠١i;

    /* renamed from: j, reason: collision with root package name */
    public String f١٥٢٠٢j;

    /* renamed from: k, reason: collision with root package name */
    public String f١٥٢٠٣k;

    /* renamed from: l, reason: collision with root package name */
    public long f١٥٢٠٤l;

    /* renamed from: a, reason: collision with root package name */
    public final String f١٥١٩٣a = "SudGIP ".concat(p.class.getSimpleName());

    /* renamed from: m, reason: collision with root package name */
    public final LinkedBlockingQueue f١٥٢٠٥m = new LinkedBlockingQueue();

    public p(Sudif sudif) {
        this.f١٥١٩٩g = sudif;
    }

    public static c a(byte[] bArr) {
        if (bArr.length == 0) {
            return new c();
        }
        c cVar = new c();
        int i10 = bArr[0] & 15;
        byte b10 = bArr[1];
        int i11 = (b10 >> 4) & 15;
        byte b11 = bArr[2];
        int i12 = (b11 >> 4) & 15;
        int i13 = b11 & 15;
        byte b12 = bArr[3];
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i10 * 4, bArr.length);
        if ((b10 & 1) != 0) {
            cVar.f١٥١٥٩d = BytesUtils.bytesToInt(Arrays.copyOfRange(copyOfRange, 0, 4));
            copyOfRange = Arrays.copyOfRange(copyOfRange, 4, copyOfRange.length);
        }
        if ((b10 & 2) != 0) {
            cVar.f١٥١٥٨c = true;
        }
        if ((b10 & 4) != 0) {
            cVar.f١٥١٥٧b = BytesUtils.bytesToInt(Arrays.copyOfRange(copyOfRange, 0, 4));
            copyOfRange = Arrays.copyOfRange(copyOfRange, 4, copyOfRange.length);
        }
        if (i11 != 9) {
            if (i11 == 15) {
                cVar.f١٥١٥٦a = BytesUtils.bytesToInt(Arrays.copyOfRange(copyOfRange, 0, 4));
                cVar.f١٥١٦٠e = BytesUtils.bytesToInt(Arrays.copyOfRange(copyOfRange, 4, 8));
                copyOfRange = Arrays.copyOfRange(copyOfRange, 8, copyOfRange.length);
            }
        } else {
            cVar.f١٥١٦٠e = BytesUtils.bytesToInt(Arrays.copyOfRange(copyOfRange, 0, 4));
            copyOfRange = Arrays.copyOfRange(copyOfRange, 4, copyOfRange.length);
        }
        if (copyOfRange.length != 0) {
            if (i13 == 1) {
                if (copyOfRange.length != 0) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(copyOfRange));
                        try {
                            byte[] bArr2 = new byte[256];
                            while (true) {
                                int read = gZIPInputStream.read(bArr2);
                                if (read <= 0) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            gZIPInputStream.close();
                            copyOfRange = byteArrayOutputStream.toByteArray();
                        } catch (Throwable th) {
                            try {
                                gZIPInputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                copyOfRange = null;
            }
            if (i12 == 1 && copyOfRange != null) {
                cVar.f١٥١٦١f = new String(copyOfRange);
            }
        }
        return cVar;
    }

    public static byte[] h(int i10) {
        return new byte[]{(byte) ((i10 >> 24) & KotlinVersion.MAX_COMPONENT_VALUE), (byte) ((i10 >> 16) & KotlinVersion.MAX_COMPONENT_VALUE), (byte) ((i10 >> 8) & KotlinVersion.MAX_COMPONENT_VALUE), (byte) (i10 & KotlinVersion.MAX_COMPONENT_VALUE)};
    }

    public static byte[] i(byte[] bArr, int i10) {
        if (i10 == 0) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream.write(bArr, 0, i10);
                gZIPOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (IOException e10) {
            e10.printStackTrace();
            return new byte[0];
        }
    }

    public final void c(b bVar, q qVar) {
        if (this.f١٥١٩٤b) {
            return;
        }
        SudLogger.d(this.f١٥١٩٣a, "startRecognize");
        LogUtils.file("DoubaoAsrAsyncClient", "startRecognize");
        this.f١٥١٩٤b = true;
        if (this.f١٥٢٠٤l == 0) {
            this.f١٥٢٠٤l = System.currentTimeMillis();
        }
        this.f١٥٢٠١i = bVar.f١٥١٥٣i;
        this.f١٥٢٠٢j = bVar.f١٥١٥٤j;
        this.f١٥٢٠٣k = bVar.f١٥١٤٩e;
        this.f١٥١٩٨f = bVar.f١٥١٥٠f;
        String str = bVar.f١٥١٤٥a;
        try {
            Request build = new Request.Builder().url(str).header("X-Api-App-Key", bVar.f١٥١٤٦b).header("X-Api-Access-Key", bVar.f١٥١٤٧c).header("X-Api-Resource-Id", bVar.f١٥١٤٨d).header("X-Api-Connect-Id", UUID.randomUUID().toString()).build();
            wf.d dVar = new wf.d();
            dVar.c = 3;
            dVar.b.a = "DoubaoHttpLoggingInterceptor";
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            OkHttpClient build2 = builder.pingInterval(50L, timeUnit).addInterceptor(dVar).readTimeout(100L, timeUnit).writeTimeout(100L, timeUnit).build();
            k kVar = new k(this, bVar, qVar);
            this.f١٥١٩٦d = kVar;
            this.f١٥١٩٥c = build2.newWebSocket(build, kVar);
        } catch (Exception e10) {
            LogUtils.file("DoubaoAsrAsyncClient", "发生了异常：" + LogUtils.getErrorInfo(e10));
        }
    }

    public final /* synthetic */ void d(c cVar, q qVar) {
        LogUtils.file("DoubaoAsrAsyncClient", "后端返回数据fail code:" + cVar.f١٥١٥٦a + " msg:" + cVar.f١٥١٦١f);
        qVar.c(new RuntimeException("doubao error code:" + cVar.f١٥١٥٦a + "  msg:" + cVar.f١٥١٦١f));
        b();
    }

    public final void e(final q qVar) {
        while (true) {
            if (this.f١٥١٩٤b || !this.f١٥٢٠٥m.isEmpty()) {
                try {
                    byte[] bArr = (byte[]) this.f١٥٢٠٥m.poll(100L, TimeUnit.MILLISECONDS);
                    if (bArr != null) {
                        final c a10 = a(bArr);
                        if (a10.f١٥١٥٦a != 0) {
                            ThreadUtils.postUITask(new Runnable() { // from class: j1.m
                                @Override // java.lang.Runnable
                                public final void run() {
                                    p.this.d(a10, qVar);
                                }
                            });
                            return;
                        }
                        if (a10.f١٥١٦١f != null) {
                            SudLogger.d(this.f١٥١٩٣a, "payloadMsg:" + a10.f١٥١٦١f);
                            LogUtils.file("DoubaoAsrAsyncClient", "payloadMsg:" + a10.f١٥١٦١f);
                            f(qVar, a10.f١٥١٦١f);
                        }
                        if (a10.f١٥١٥٨c) {
                            SudLogger.d(this.f١٥١٩٣a, "服务器返回了最后一个包，关闭asr识别");
                            LogUtils.file("DoubaoAsrAsyncClient", "服务器返回了最后一个包，关闭asr识别");
                            ThreadUtils.postUITask(new Runnable() { // from class: j1.n
                                @Override // java.lang.Runnable
                                public final void run() {
                                    p.this.b();
                                }
                            });
                            return;
                        }
                    } else {
                        continue;
                    }
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                } catch (Exception e10) {
                    LogUtils.file("DoubaoAsrAsyncClient", "处理响应时发生了异常：" + LogUtils.getErrorInfo(e10));
                }
            } else {
                return;
            }
        }
    }

    public final void f(final q qVar, final String str) {
        final boolean z10;
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("result");
            if (optJSONObject != null) {
                final String optString = optJSONObject.optString(ViewHierarchyConstants.TEXT_KEY);
                JSONArray optJSONArray = optJSONObject.optJSONArray("utterances");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    z10 = optJSONArray.getJSONObject(0).optBoolean("definite");
                } else {
                    z10 = false;
                }
                if ((!TextUtils.isEmpty(optString) && !optString.equals(this.f١٥١٩٧e)) || z10) {
                    this.f١٥١٩٧e = optString;
                    ThreadUtils.postUITask(new Runnable() { // from class: j1.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            p.this.g(z10, optString, str, qVar);
                        }
                    });
                }
            }
        } catch (Exception e10) {
            LogUtils.file("DoubaoAsrAsyncClient", "parserResponse json:" + str + " error:" + LogUtils.getErrorInfo(e10));
        }
    }

    public final /* synthetic */ void g(boolean z10, String str, String str2, q qVar) {
        LogUtils.file("DoubaoAsrAsyncClient", "===>onText definite:" + z10 + " text:" + str + " payloadStr:" + str2);
        long currentTimeMillis = System.currentTimeMillis();
        qVar.d(z10, str, str2, this.f١٥٢٠٤l, currentTimeMillis);
        this.f١٥٢٠٤l = currentTimeMillis;
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final void k() {
        Sudint sudint = this.f١٥٢٠٠h;
        if (sudint == null) {
            return;
        }
        synchronized (sudint) {
            if (sudint.Sudcase) {
                sudint.Sudcase = false;
                sudint.Sudgoto.removeCallbacks(sudint.Sudelse);
                sudint.Suddo();
            }
        }
        this.f١٥٢٠٠h = null;
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void b() {
        if (!this.f١٥١٩٤b) {
            return;
        }
        SudLogger.d(this.f١٥١٩٣a, "stopRecognize");
        LogUtils.file("DoubaoAsrAsyncClient", "stopRecognize");
        ThreadUtils.postUITask(new Runnable() { // from class: j1.l
            @Override // java.lang.Runnable
            public final void run() {
                p.this.k();
            }
        });
        this.f١٥١٩٤b = false;
        WebSocket webSocket = this.f١٥١٩٥c;
        if (webSocket != null) {
            webSocket.close(1000, "stopRecognize");
            this.f١٥١٩٥c = null;
        }
        f1.a aVar = this.f١٥١٩٨f;
        if (aVar != null) {
            ByteArrayBlockingQueue byteArrayBlockingQueue = aVar.f١٤٠٣٧a;
            if (byteArrayBlockingQueue != null) {
                byteArrayBlockingQueue.offer((byte) 0);
                aVar.f١٤٠٣٧a = null;
            }
            this.f١٥١٩٨f = null;
        }
        this.f١٥١٩٧e = null;
        this.f١٥٢٠٤l = 0L;
    }
}
