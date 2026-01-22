package qf;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.qiahao.nextvideo.sheep.GameMatchActivity;
import com.qiahao.nextvideo.view.youtube.FadeViewHelper;
import com.taobao.accs.common.Constants;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import tech.sud.gip.base.ThreadUtils;
import tech.sud.gip.core.GameInfo;
import tech.sud.gip.core.ISudListenerInitSDK;
import tech.sud.gip.logger.SudLogger;
import tech.sud.logger.LogUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public final class x {
    public static final String p = "SudGIP ".concat(x.class.getSimpleName());
    public static final String[] q = {"https://dev-fqs.sudden.ltd/", "https://dev-fqs.sud.ltd/", "https://dev-fqs-os.sudden.ltd/", "https://dev-fqs.sudcdn.ltd/", "https://dev-fqs.sudcdn.cloud/"};
    public static final String[] r = {"https://fat-fqs.sudden.ltd/", "https://fat-fqs.sud.ltd/", "https://fat-fqs-os.sudden.ltd/", "https://fat-fqs.sudcdn.ltd/", "https://fat-fqs.sudcdn.cloud/"};
    public static final String[] s = {"https://sim-fqs.sudden.ltd/", "https://sim-fqs.sud.ltd/", "https://sim-fqs-os.sudden.ltd/", "https://sim-fqs.sudcdn.ltd/", "https://sim-fqs.sudcdn.cloud/"};
    public static final String[] t = {"https://fqs.sudden.ltd/", "https://fqs.sud.ltd/", "https://fqs-os.sudden.ltd/", "https://fqs.sudcdn.ltd/", "https://fqs.sudcdn.cloud/"};
    public ArrayList k;
    public vf.b l;
    public vf.b m;
    public boolean a = false;
    public String b = "";
    public String c = "";
    public String d = "";
    public String e = "";
    public String f = "";
    public String g = "";
    public String h = "";
    public String i = "";
    public final AtomicBoolean j = new AtomicBoolean(false);
    public final ArrayList n = new ArrayList(0);
    public final HashMap o = new HashMap();

    public x() {
        z();
    }

    public static /* synthetic */ void A(d.f fVar, vf.a aVar, String str) {
        int i = fVar.a;
        if (i == 0) {
            aVar.onSuccess(str);
        } else {
            aVar.onFailure(i, fVar.b);
        }
    }

    public static e.c a(JSONObject jSONObject) {
        e.c cVar = new e.c();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            cVar.a.put(next, jSONObject.getString(next));
        }
        return cVar;
    }

    public static String b(String str, String str2, String str3, wf.e eVar, vf.b bVar, a aVar) {
        Call newCall = i.b.newCall(e(str3, eVar, bVar).url(str).post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), str2)).build());
        if (aVar != null) {
            aVar.a = newCall;
        }
        ResponseBody body = newCall.execute().body();
        Objects.requireNonNull(body);
        String string = body.string();
        LogUtils.file("HttpService", "url=" + str + " request-id=" + str3);
        SudLogger.d(p, "url=" + str + " request-id=" + str3);
        return string;
    }

    public static String c(String str, String str2, wf.e eVar, vf.b bVar, a aVar) {
        Call newCall = i.b.newCall(e(str2, eVar, bVar).url(str).get().build());
        if (aVar != null) {
            aVar.a = newCall;
        }
        ResponseBody body = newCall.execute().body();
        Objects.requireNonNull(body);
        String string = body.string();
        LogUtils.file("HttpService", "url=" + str + " request-id=" + str2);
        SudLogger.d(p, "url=" + str + " request-id=" + str2);
        return string;
    }

    public static String d(String[] strArr, int i) {
        int i2;
        if (strArr != null && strArr.length != 0) {
            if (i > 0) {
                i2 = i - 1;
            } else {
                i2 = 0;
            }
            if (i2 < strArr.length) {
                return strArr[i2];
            }
        }
        return null;
    }

    public static Request.Builder e(String str, wf.e eVar, EventListener eventListener) {
        Request.Builder addHeader = new Request.Builder().addHeader("sud-sdk-version", "1.6.6.1277").addHeader("sud-sdk-version-alias", "v1.6.6.1277-static");
        String str2 = e.d.a;
        Request.Builder addHeader2 = addHeader.addHeader("sud-sdk-platform", String.valueOf(2)).addHeader("sud-sdk-app-id", e.d.g).addHeader("sud-sdk-bundle-id", e.d.d()).addHeader("sud-sdk-trace-id", e.d.j).addHeader("sud-sdk-request-id", str).addHeader("sud-sdk-user-id", f.d.a).addHeader("sud-sdk-sud-is-dynamic", String.valueOf(false)).addHeader("sud-sdk-et-is-dynamic", String.valueOf(false)).addHeader("Referer", e.e.b(str)).addHeader("sud-device-brand", u.g.a(u.h.a())).addHeader("sud-os-version", u.h.d()).addHeader("sud-device-id", u.h.c());
        addHeader2.tag(wf.e.class, eVar);
        if (eventListener != null) {
            addHeader2.tag(EventListener.class, eventListener);
        }
        return addHeader2;
    }

    public static void h(int i, vf.c cVar, zf.a aVar, String str) {
        String str2;
        d.k kVar;
        d.e eVar;
        if (i == 0) {
            g.a aVar2 = (g.a) cVar;
            if (aVar != null) {
                aVar2.getClass();
                if (!TextUtils.isEmpty(aVar.a)) {
                    g.g gVar = aVar2.a;
                    String str3 = aVar.a;
                    SudLogger.d(gVar.a, "connectWebSocket curIsRunning:" + gVar.f.get());
                    LogUtils.file("SudGIPWebSocket", "connectWebSocket curIsRunning:" + gVar.f.get());
                    if (!gVar.f.get()) {
                        return;
                    }
                    if (gVar.h != null) {
                        SudLogger.d(gVar.a, "connectWebSocket 已存在WebSocket无需重复连接");
                        LogUtils.file("SudGIPWebSocket", "connectWebSocket 已存在WebSocket无需重复连接");
                        return;
                    }
                    d.p pVar = e.d.e;
                    if (pVar != null && (kVar = pVar.c) != null && (eVar = kVar.d) != null) {
                        str2 = eVar.f;
                    } else {
                        str2 = null;
                    }
                    if (TextUtils.isEmpty(str2)) {
                        gVar.b(FadeViewHelper.DEFAULT_FADE_OUT_DELAY);
                        return;
                    }
                    String uri = Uri.parse(str2).buildUpon().appendQueryParameter("mgid", gVar.d + "").appendQueryParameter("roomid", gVar.c + "").build().toString();
                    StringBuilder sb2 = new StringBuilder("connectWebSocket:");
                    sb2.append(uri);
                    LogUtils.file("SudGIPWebSocket", sb2.toString());
                    Request build = new Request.Builder().url(uri).addHeader("Authorization", "Bearer " + str3).build();
                    wf.d dVar = new wf.d();
                    dVar.c = 3;
                    dVar.b.a = "SudGIPWsHttpLoggingInterceptor";
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    gVar.h = builder.pingInterval(10L, timeUnit).addInterceptor(dVar).readTimeout(100L, timeUnit).writeTimeout(100L, timeUnit).build().newWebSocket(build, new g.f(gVar));
                    return;
                }
            }
            aVar2.a.b(FadeViewHelper.DEFAULT_FADE_OUT_DELAY);
            return;
        }
        g.a aVar3 = (g.a) cVar;
        SudLogger.d(aVar3.a.a, "onFailure：" + str + "(" + i + ")");
        LogUtils.file("SudGIPWebSocket", "onFailure：" + str + "(" + i + ")");
        aVar3.a.b(FadeViewHelper.DEFAULT_FADE_OUT_DELAY);
    }

    public static /* synthetic */ void i(int i, vf.d dVar, String str) {
        if (i == 0) {
            dVar.getClass();
        } else {
            dVar.getClass();
        }
    }

    public static /* synthetic */ void k(d.f fVar, vf.a aVar, String str) {
        int i = fVar.a;
        if (i == 0) {
            aVar.onSuccess(str);
        } else {
            aVar.onFailure(i, fVar.b);
        }
    }

    public static void s(JSONObject jSONObject, GameInfo gameInfo) {
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        JSONObject jSONObject3 = jSONObject2.getJSONObject("mg_info");
        gameInfo.mgId = jSONObject3.getLong("mg_id");
        gameInfo.name = a(jSONObject3.getJSONObject("name")).a(e.d.d);
        gameInfo.version = jSONObject3.getString(Constants.SP_KEY_VERSION);
        gameInfo.orientation = jSONObject3.getInt("orientation");
        gameInfo.screenMode = jSONObject3.getInt("screen_mode");
        gameInfo.url = jSONObject3.getString("url");
        gameInfo.eUrl = jSONObject3.getString("eurl");
        if (jSONObject3.has("auturl")) {
            gameInfo.autUrl = jSONObject3.getString("auturl");
        }
        gameInfo.appID = jSONObject3.getString("game_app_id");
        gameInfo.hash = jSONObject3.getString("hash");
        gameInfo.engine = jSONObject3.getInt("engine");
        if (jSONObject3.has("unity_framework_type")) {
            gameInfo.unityFrameworkType = jSONObject3.getInt("unity_framework_type");
        }
        gameInfo.require = jSONObject3.getString("require").split(";");
        JSONObject optJSONObject = jSONObject3.optJSONObject("big_loading_pic");
        if (optJSONObject != null) {
            gameInfo.bigLoadingPic = a(optJSONObject).a(e.d.d);
        }
        if (jSONObject3.has("dynamic_config")) {
            gameInfo.dynamicConfig = jSONObject3.getJSONObject("dynamic_config").toString();
        } else {
            gameInfo.dynamicConfig = "{}";
        }
        gameInfo.clientVersion = jSONObject3.getLong("client_version");
        JSONObject optJSONObject2 = jSONObject3.optJSONObject("game_large_model_cfg");
        if (optJSONObject2 != null) {
            xf.a aVar = new xf.a();
            gameInfo.gameLargeModelCfg = aVar;
            aVar.a = optJSONObject2.optBoolean("enable_asr");
            gameInfo.gameLargeModelCfg.b = optJSONObject2.optBoolean("enable_channel");
            gameInfo.gameLargeModelCfg.c = optJSONObject2.optBoolean("enable_tts");
        }
        fd.d.b(gameInfo.mgId, 0, jSONObject2.optString("log_id"));
        fd.d.a();
    }

    public static void z() {
        i.a.c = 4;
        int i = e.d.f;
        if (i != 4 && i != 3) {
            wf.d.d = false;
        } else {
            wf.d.d = true;
        }
    }

    public final void B(ISudListenerInitSDK iSudListenerInitSDK, Context context, String str, String str2, boolean z, vf.b bVar, vf.b bVar2) {
        int length;
        synchronized (this) {
            try {
                t(iSudListenerInitSDK);
                if (this.j.get()) {
                    return;
                }
                this.j.set(true);
                int i = e.d.f;
                if (i == 4) {
                    length = q.length;
                } else if (i == 3) {
                    length = r.length;
                } else if (i == 2) {
                    length = s.length;
                } else {
                    length = t.length;
                }
                int i2 = length;
                vf.b bVar3 = this.l;
                if (bVar3 != null && bVar != null) {
                    bVar3.b(bVar);
                    bVar.a(this.l.b);
                }
                vf.b bVar4 = this.m;
                if (bVar4 != null && bVar2 != null) {
                    bVar4.b(bVar2);
                    bVar2.a(this.m.b);
                }
                l(str, 1, new l(this, context, str, str2, z, bVar2, i2, 1, bVar), bVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f() {
        this.a = false;
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.g = "";
        this.h = "";
        this.f = "";
        this.i = "";
        this.n.clear();
        this.o.clear();
    }

    public final synchronized void g(int i, String str) {
        ArrayList arrayList = this.k;
        if (arrayList == null) {
            LogUtils.file("HttpService", "error notifyInitSdkFailure but listenerList is null");
            return;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ((ISudListenerInitSDK) obj).onFailure(i, str);
        }
        this.k = null;
        this.j.set(false);
    }

    public final void j(d.f fVar, String str, l lVar, String str2) {
        int i;
        this.c = str2;
        if (lVar == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.b = str;
            x xVar = lVar.i;
            Context context = lVar.a;
            String str3 = lVar.b;
            String str4 = lVar.c;
            boolean z = lVar.d;
            vf.b bVar = lVar.e;
            if (xVar.a) {
                synchronized (xVar) {
                    try {
                        ArrayList arrayList = xVar.k;
                        if (arrayList == null) {
                            LogUtils.file("HttpService", "error notifyInitSdkSuccess but listenerList is null");
                        } else {
                            int size = arrayList.size();
                            int i2 = 0;
                            while (i2 < size) {
                                Object obj = arrayList.get(i2);
                                i2++;
                                ((ISudListenerInitSDK) obj).onSuccess();
                            }
                            xVar.k = null;
                            xVar.j.set(false);
                        }
                    } finally {
                    }
                }
            } else {
                c.d.f.b(context);
                String str5 = xVar.b;
                String packageName = context.getPackageName();
                vf.b bVar2 = new vf.b();
                xVar.m = bVar2;
                bVar2.b(bVar);
                xVar.m.a(str5);
                i.c.execute(new j(xVar, str3, str4, packageName, z, str5));
            }
        } else {
            StringBuilder sb2 = new StringBuilder("getFQSInfo fail appId=" + e.d.g);
            sb2.append(" isTestEnv=" + e.d.c);
            sb2.append(" ");
            sb2.append(" ret_code=" + fVar.a);
            sb2.append(" null == getSDKTokenUrl || getSDKTokenUrl.isEmpty(), Please contact SUD, Open production environment service");
            String str6 = fVar.b;
            if (str6 != null) {
                sb2.append(str6);
            }
            int i3 = fVar.a;
            String sb3 = sb2.toString();
            int i4 = lVar.f;
            if (i4 > 0 && (i = lVar.g) < i4) {
                x xVar2 = lVar.i;
                Context context2 = lVar.a;
                String str7 = lVar.b;
                String str8 = lVar.c;
                boolean z2 = lVar.d;
                int i5 = i + 1;
                vf.b bVar3 = lVar.h;
                vf.b bVar4 = lVar.e;
                vf.b bVar5 = xVar2.l;
                if (bVar5 != null && bVar3 != null) {
                    bVar5.b(bVar3);
                    bVar3.a(xVar2.l.b);
                }
                vf.b bVar6 = xVar2.m;
                if (bVar6 != null && bVar4 != null) {
                    bVar6.b(bVar4);
                    bVar4.a(xVar2.m.b);
                }
                xVar2.l(str7, i5, new l(xVar2, context2, str7, str8, z2, bVar4, i4, i5, bVar3), bVar3);
            } else {
                lVar.i.g(i3, sb3);
            }
        }
        this.l = null;
    }

    public final void l(String str, int i, final l lVar, vf.b bVar) {
        String d;
        String str2 = this.b;
        if (str2 != null && !str2.isEmpty()) {
            x xVar = lVar.i;
            Context context = lVar.a;
            String str3 = lVar.b;
            String str4 = lVar.c;
            boolean z = lVar.d;
            vf.b bVar2 = lVar.e;
            if (xVar.a) {
                synchronized (xVar) {
                    try {
                        ArrayList arrayList = xVar.k;
                        if (arrayList == null) {
                            LogUtils.file("HttpService", "error notifyInitSdkSuccess but listenerList is null");
                            return;
                        }
                        int size = arrayList.size();
                        int i2 = 0;
                        while (i2 < size) {
                            Object obj = arrayList.get(i2);
                            i2++;
                            ((ISudListenerInitSDK) obj).onSuccess();
                        }
                        xVar.k = null;
                        xVar.j.set(false);
                        return;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            c.d.f.b(context);
            String str5 = xVar.b;
            String packageName = context.getPackageName();
            vf.b bVar3 = new vf.b();
            xVar.m = bVar3;
            bVar3.b(bVar2);
            xVar.m.a(str5);
            i.c.execute(new j(xVar, str3, str4, packageName, z, str5));
            return;
        }
        int i3 = e.d.f;
        if (i3 == 4) {
            d = d(q, i);
        } else if (i3 == 3) {
            d = d(r, i);
        } else if (i3 == 2) {
            d = d(s, i);
        } else {
            d = d(t, i);
        }
        LogUtils.file("HttpService", "getFQSInfo baseUrl:" + d);
        SudLogger.d(p, "getFQSInfo baseUrl:" + d);
        final String str6 = d + u.j.b(str);
        final f.a aVar = new f.a("getFQSInfo");
        final wf.e eVar = new wf.e();
        aVar.n = eVar;
        vf.b bVar4 = new vf.b();
        this.l = bVar4;
        bVar4.b(bVar);
        this.l.a(str6);
        i.c.execute(new Runnable() { // from class: qf.u
            @Override // java.lang.Runnable
            public final void run() {
                x.this.m(str6, aVar, eVar, lVar);
            }
        });
    }

    public final void m(String str, f.a aVar, wf.e eVar, final l lVar) {
        String str2;
        String str3;
        final String str4;
        JSONObject optJSONObject;
        final d.f fVar = new d.f();
        try {
            fVar.a = 0;
            fVar.b = com.taobao.agoo.a.a.b.JSON_SUCCESS;
            str2 = c(str, aVar.c, eVar, this.l, null);
            try {
                JSONObject jSONObject = new JSONObject(str2);
                str3 = jSONObject.getString("url");
                try {
                    if (TextUtils.isEmpty(str3)) {
                        fVar.a = -1;
                        fVar.b = "url is null or empty";
                    }
                    optJSONObject = jSONObject.optJSONObject("checker");
                } catch (Exception e) {
                    e = e;
                    String str5 = "fqs error :" + LogUtils.getErrorInfo(e);
                    SudLogger.e(p, str5);
                    LogUtils.file("HttpService", str5);
                    if (fVar.a == 0) {
                        fVar.a = d.a.a(e);
                        fVar.b = e.toString();
                    }
                    if (str2 != null) {
                        aVar.d = str2;
                    } else {
                        aVar.getClass();
                    }
                    aVar.e = fVar.a;
                    String str6 = fVar.b;
                    if (str6 != null) {
                        aVar.f = str6;
                    }
                    str4 = "";
                    final String str7 = str3;
                    f.d.b(aVar);
                    ThreadUtils.postUITask(new Runnable() { // from class: qf.w
                        @Override // java.lang.Runnable
                        public final void run() {
                            x.this.j(fVar, str7, lVar, str4);
                        }
                    });
                }
            } catch (Exception e2) {
                e = e2;
                str3 = "";
            }
        } catch (Exception e3) {
            e = e3;
            str2 = "";
            str3 = str2;
        }
        if (optJSONObject != null) {
            str4 = optJSONObject.optString("url");
            final String str72 = str3;
            f.d.b(aVar);
            ThreadUtils.postUITask(new Runnable() { // from class: qf.w
                @Override // java.lang.Runnable
                public final void run() {
                    x.this.j(fVar, str72, lVar, str4);
                }
            });
        }
        str4 = "";
        final String str722 = str3;
        f.d.b(aVar);
        ThreadUtils.postUITask(new Runnable() { // from class: qf.w
            @Override // java.lang.Runnable
            public final void run() {
                x.this.j(fVar, str722, lVar, str4);
            }
        });
    }

    public final void n(String str, String str2, String str3, wf.e eVar, vf.b bVar, a aVar, final vf.a aVar2) {
        final String str4;
        final d.f fVar = new d.f();
        try {
            fVar.a = 0;
            fVar.b = com.taobao.agoo.a.a.b.JSON_SUCCESS;
            str4 = b(str, str2, str3, eVar, bVar, aVar);
        } catch (Exception e) {
            String str5 = "commonPost error :" + LogUtils.getErrorInfo(e);
            SudLogger.e(p, str5);
            LogUtils.file("HttpService", str5);
            if (fVar.a == 0) {
                fVar.a = d.a.a(e);
                fVar.b = e.toString();
            }
            str4 = "";
        }
        ThreadUtils.postUITask(new Runnable() { // from class: qf.t
            @Override // java.lang.Runnable
            public final void run() {
                x.A(fVar, aVar2, str4);
            }
        });
    }

    public final void o(final String str, final String str2, final o0.m mVar, final vf.a aVar, final a aVar2) {
        final String b = u.j.b(UUID.randomUUID().toString());
        final wf.e eVar = new wf.e();
        i.c.execute(new Runnable() { // from class: qf.o
            @Override // java.lang.Runnable
            public final void run() {
                x.this.n(str, str2, b, eVar, mVar, aVar2, aVar);
            }
        });
    }

    public final void p(String str, String str2, wf.e eVar, vf.b bVar, a aVar, final vf.a aVar2) {
        final String str3;
        final d.f fVar = new d.f();
        try {
            fVar.a = 0;
            fVar.b = com.taobao.agoo.a.a.b.JSON_SUCCESS;
            str3 = c(str, str2, eVar, bVar, aVar);
        } catch (Exception e) {
            String str4 = "commonGet error :" + LogUtils.getErrorInfo(e);
            SudLogger.e(p, str4);
            LogUtils.file("HttpService", str4);
            if (fVar.a == 0) {
                fVar.a = d.a.a(e);
                fVar.b = e.toString();
            }
            str3 = "";
        }
        ThreadUtils.postUITask(new Runnable() { // from class: qf.n
            @Override // java.lang.Runnable
            public final void run() {
                x.k(fVar, aVar2, str3);
            }
        });
    }

    public final void q(final String str, final o0.m mVar, final o0.q qVar, final a aVar) {
        final String b = u.j.b(UUID.randomUUID().toString());
        final wf.e eVar = new wf.e();
        i.c.execute(new Runnable() { // from class: qf.v
            @Override // java.lang.Runnable
            public final void run() {
                x.this.p(str, b, eVar, mVar, aVar, qVar);
            }
        });
    }

    public final void r(String str, boolean z) {
        d0.a.a("reportEvent.sp").c(u.j.b(UUID.randomUUID().toString()), str, z);
        String str2 = this.h;
        if (str2 != null && !str2.isEmpty()) {
            i.d.execute(new k(this));
        } else {
            LogUtils.file("HttpService", "还未初始化sdk成功，等待上报的数据为：" + str);
        }
    }

    public final synchronized void t(ISudListenerInitSDK iSudListenerInitSDK) {
        if (iSudListenerInitSDK == null) {
            return;
        }
        try {
            if (this.k == null) {
                this.k = new ArrayList();
            }
            this.k.add(iSudListenerInitSDK);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void u(final ISudListenerInitSDK iSudListenerInitSDK, final Context context, final String str, final String str2, final boolean z, final vf.b bVar, final vf.b bVar2) {
        ThreadUtils.postUITask(new Runnable() { // from class: qf.p
            @Override // java.lang.Runnable
            public final void run() {
                x.this.B(iSudListenerInitSDK, context, str, str2, z, bVar, bVar2);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void v(yf.a aVar, f.a aVar2, wf.e eVar, final vf.c cVar) {
        Exception e;
        String string;
        final zf.a aVar3 = new zf.a();
        String str = "";
        final String str2 = com.taobao.agoo.a.a.b.JSON_SUCCESS;
        final int i = 0;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("app_id", aVar.a);
            jSONObject.put("uid", aVar.a);
            String jSONObject2 = jSONObject.toString();
            String str3 = this.f;
            String str4 = aVar2.c;
            Request.Builder post = e(str4, eVar, null).url(str3).post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), jSONObject2));
            i.a(post);
            ResponseBody body = i.b.newCall(post.build()).execute().body();
            Objects.requireNonNull(body);
            string = body.string();
            LogUtils.file("HttpService", "url=" + str3 + " request-id=" + str4);
            SudLogger.d(p, "url=" + str3 + " request-id=" + str4);
        } catch (Exception e2) {
            e = e2;
        }
        try {
            JSONObject jSONObject3 = new JSONObject(string);
            i = jSONObject3.getInt("ret_code");
            str2 = jSONObject3.optString("ret_msg");
            JSONObject optJSONObject = jSONObject3.optJSONObject("data");
            if (optJSONObject != null) {
                aVar3.a = optJSONObject.optString("access_token");
                optJSONObject.optInt("expires_in");
            }
        } catch (Exception e3) {
            e = e3;
            str = string;
            String str5 = "fqs error :" + LogUtils.getErrorInfo(e);
            SudLogger.e(p, str5);
            LogUtils.file("HttpService", str5);
            if (i == 0) {
                i = d.a.a(e);
                str2 = e.toString();
            }
            if (str != null) {
                aVar2.d = str;
            } else {
                aVar2.getClass();
            }
            aVar2.e = i;
            if (str2 != null) {
                aVar2.f = str2;
            }
            ThreadUtils.postUITask(new Runnable() { // from class: qf.s
                @Override // java.lang.Runnable
                public final void run() {
                    x.h(i, cVar, aVar3, str2);
                }
            });
        }
        ThreadUtils.postUITask(new Runnable() { // from class: qf.s
            @Override // java.lang.Runnable
            public final void run() {
                x.h(i, cVar, aVar3, str2);
            }
        });
    }

    public final void w(final yf.a aVar, final g.a aVar2) {
        final f.a aVar3 = new f.a("getGateToken");
        final wf.e eVar = new wf.e();
        aVar3.n = eVar;
        i.c.execute(new Runnable() { // from class: qf.m
            @Override // java.lang.Runnable
            public final void run() {
                x.this.v(aVar, aVar3, eVar, aVar2);
            }
        });
    }

    public final void x(final yf.b bVar, final e.b bVar2) {
        i.c.execute(new Runnable() { // from class: qf.q
            @Override // java.lang.Runnable
            public final void run() {
                x.this.y(bVar, bVar2);
            }
        });
    }

    public final void y(yf.b bVar, final vf.d dVar) {
        final String str;
        d.k kVar;
        d.b bVar2;
        final int i = 0;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("message_id", u.j.b(UUID.randomUUID().toString()));
            jSONObject.put("mg_id", bVar.a);
            jSONObject.put(GameMatchActivity.ROOM_ID, bVar.b);
            jSONObject.put("message_type", 1);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("uid", bVar.c);
            jSONObject2.put("nickname", bVar.d);
            jSONObject.put(TUIConstants.TUICalling.SENDER, jSONObject2);
            jSONObject.put("content", bVar.e);
            jSONObject.put("timestamp", System.currentTimeMillis());
            if (bVar.f != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("asr_duration", bVar.f.a);
                jSONObject3.put("end_time", bVar.f.b);
                jSONObject3.put("log_id", bVar.f.c);
                jSONObject3.put("start_time", bVar.f.d);
                jSONObject3.put("audio_start_time", bVar.f.e);
                jSONObject3.put("audio_end_time", bVar.f.f);
                jSONObject.put("metrics", jSONObject3);
            }
            String jSONObject4 = jSONObject.toString();
            d.p pVar = e.d.e;
            String str2 = (pVar == null || (kVar = pVar.c) == null || (bVar2 = kVar.m) == null) ? null : bVar2.d;
            String b = u.j.b(UUID.randomUUID().toString());
            Request.Builder post = e(b, new wf.e(), null).url(str2).post(RequestBody.create(MediaType.get("application/json; charset=utf-8"), jSONObject4));
            i.a(post);
            ResponseBody body = i.b.newCall(post.build()).execute().body();
            Objects.requireNonNull(body);
            String string = body.string();
            LogUtils.file("HttpService", "url=" + str2 + " request-id=" + b);
            SudLogger.d(p, "url=" + str2 + " request-id=" + b);
            JSONObject jSONObject5 = new JSONObject(string);
            i = jSONObject5.getInt("ret_code");
            str = jSONObject5.optString("ret_msg");
        } catch (Exception e) {
            String str3 = "fqs error :" + LogUtils.getErrorInfo(e);
            SudLogger.e(p, str3);
            LogUtils.file("HttpService", str3);
            if (i == 0) {
                i = d.a.a(e);
                str = e.toString();
            } else {
                str = com.taobao.agoo.a.a.b.JSON_SUCCESS;
            }
        }
        ThreadUtils.postUITask(new Runnable() { // from class: qf.r
            @Override // java.lang.Runnable
            public final void run() {
                x.i(i, dVar, str);
            }
        });
    }
}
