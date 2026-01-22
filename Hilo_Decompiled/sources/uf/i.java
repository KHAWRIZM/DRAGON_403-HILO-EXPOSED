package uf;

import c0.k;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class i implements Callback {
    public final /* synthetic */ c0.a a;

    public i(c0.a aVar) {
        this.a = aVar;
    }

    public static void a(c0.a aVar) {
        k kVar;
        if (aVar != null && (kVar = (k) aVar.a.get()) != null) {
            kVar.onCompleted();
        }
    }

    public static void b(c0.a aVar, int i, String str) {
        k kVar;
        if (aVar != null && (kVar = (k) aVar.a.get()) != null) {
            kVar.a(c0.c.a(i, aVar.b, str));
        }
    }

    public static void c(c0.a aVar, IOException iOException) {
        if (aVar != null) {
            int a = d.a.a(iOException);
            String str = "request error:" + iOException.toString();
            k kVar = (k) aVar.a.get();
            if (kVar != null) {
                kVar.a(c0.c.a(a, aVar.b, str));
            }
        }
    }

    public static void d(c0.a aVar, String str) {
        k kVar;
        if (aVar != null && (kVar = (k) aVar.a.get()) != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ret_code", 0);
                jSONObject.put("ret_msg", com.taobao.agoo.a.a.b.JSON_SUCCESS);
                jSONObject.put("request_id", aVar.b);
                jSONObject.put("event", aVar.c);
                jSONObject.put("data", str);
            } catch (Exception e) {
                LogUtils.file("SudAiManager", LogUtils.getErrorInfo(e));
            }
            kVar.onSseLine(jSONObject.toString());
        }
    }

    @Override // okhttp3.Callback
    public final void onFailure(Call call, final IOException iOException) {
        LogUtils.file("AiHttpService", "request error：" + LogUtils.getErrorInfo(iOException));
        final c0.a aVar = this.a;
        ThreadUtils.postUITask(new Runnable() { // from class: uf.e
            @Override // java.lang.Runnable
            public final void run() {
                i.c(aVar, iOException);
            }
        });
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call call, Response response) {
        if (response.isSuccessful()) {
            ResponseBody body = response.body();
            if (body != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(body.byteStream()));
                while (true) {
                    try {
                        final String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            LogUtils.file("AiHttpService", "aiSse line:" + readLine);
                            final c0.a aVar = this.a;
                            ThreadUtils.postUITask(new Runnable() { // from class: uf.f
                                @Override // java.lang.Runnable
                                public final void run() {
                                    i.d(aVar, readLine);
                                }
                            });
                        } else {
                            bufferedReader.close();
                            final c0.a aVar2 = this.a;
                            ThreadUtils.postUITask(new Runnable() { // from class: uf.g
                                @Override // java.lang.Runnable
                                public final void run() {
                                    i.a(aVar2);
                                }
                            });
                            return;
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            }
        } else {
            final String str = "http error code：" + response.code();
            final c0.a aVar3 = this.a;
            final int i = -1;
            ThreadUtils.postUITask(new Runnable() { // from class: uf.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.b(aVar3, i, str);
                }
            });
        }
    }
}
