package com.alibaba.sdk.android.sender;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.sdk.android.logger.ILog;
import com.alibaba.sdk.android.tbrest.SendService;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AlicloudSender {

    /* renamed from: a, reason: collision with root package name */
    private static final String f٦٧٨٩a = null;

    /* renamed from: c, reason: collision with root package name */
    private static Map<String, SdkInfo> f٦٧٩١c;

    /* renamed from: d, reason: collision with root package name */
    private static Map<String, a> f٦٧٩٢d;

    /* renamed from: g, reason: collision with root package name */
    private static SendService f٦٧٩٥g;

    /* renamed from: b, reason: collision with root package name */
    private static final ExecutorService f٦٧٩٠b = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicBoolean f٦٧٩٣e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private static final AtomicBoolean f٦٧٩٤f = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    private static final ILog f٦٧٩٦h = SenderLog.getLogger(AlicloudSender.class);

    /* renamed from: i, reason: collision with root package name */
    private static boolean f٦٧٩٧i = false;

    /* renamed from: j, reason: collision with root package name */
    @SuppressLint({"SimpleDateFormat"})
    private static final SimpleDateFormat f٦٧٩٨j = new SimpleDateFormat("yyyyMMdd");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f٦٨٠٢a;

        /* renamed from: b, reason: collision with root package name */
        private String f٦٨٠٣b;

        /* renamed from: c, reason: collision with root package name */
        private String f٦٨٠٤c;

        private a() {
            this.f٦٨٠٢a = -1;
            this.f٦٨٠٣b = "";
            this.f٦٨٠٤c = "";
        }
    }

    public static void asyncSend(Application application, SdkInfo sdkInfo) {
        if (application == null) {
            f٦٧٩٦h.d("asyncSend failed. application is null. ");
            return;
        }
        if (sdkInfo == null) {
            f٦٧٩٦h.d("asyncSend failed. sdk info is null. ");
            return;
        }
        String a10 = sdkInfo.a();
        if (TextUtils.isEmpty(a10)) {
            f٦٧٩٦h.d("asyncSend failed. sdk id is empty. ");
            return;
        }
        if (TextUtils.isEmpty(sdkInfo.b())) {
            f٦٧٩٦h.d("asyncSend failed. sdk version is empty. ");
            return;
        }
        a(application.getApplicationContext());
        a(application);
        f٦٧٩١c.put(a10, sdkInfo);
        b(application.getApplicationContext(), sdkInfo);
    }

    private static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static Map<String, a> c(Context context) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        String string = context.getSharedPreferences("sp_emas_info", 0).getString("emas_sdk_info", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                if (jSONArray.length() > 0) {
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i10);
                        String string2 = jSONObject.getString("id");
                        a aVar = new a();
                        aVar.f٦٨٠٣b = jSONObject.getString("time");
                        aVar.f٦٨٠٢a = jSONObject.getInt("statu");
                        aVar.f٦٨٠٤c = jSONObject.getString(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION);
                        concurrentHashMap.put(string2, aVar);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return concurrentHashMap;
    }

    public static void openHttp() {
        f٦٧٩٧i = true;
    }

    private static void a(Application application) {
        if (f٦٧٩٤f.compareAndSet(false, true)) {
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.alibaba.sdk.android.sender.AlicloudSender.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    if (AlicloudSender.f٦٧٩١c == null || AlicloudSender.f٦٧٩١c.isEmpty()) {
                        return;
                    }
                    Iterator it = AlicloudSender.f٦٧٩١c.values().iterator();
                    while (it.hasNext()) {
                        AlicloudSender.b(activity.getApplicationContext(), (SdkInfo) it.next());
                    }
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                }
            });
        }
    }

    @Deprecated
    public static void asyncSend(Context context, SdkInfo sdkInfo) {
        if (context == null) {
            f٦٧٩٦h.d("asyncSend failed. context is null. ");
            return;
        }
        if (sdkInfo == null) {
            f٦٧٩٦h.d("asyncSend failed. sdk info is null. ");
            return;
        }
        String a10 = sdkInfo.a();
        if (TextUtils.isEmpty(a10)) {
            f٦٧٩٦h.d("asyncSend failed. sdk id is empty. ");
        } else {
            if (TextUtils.isEmpty(sdkInfo.b())) {
                f٦٧٩٦h.d("asyncSend failed. sdk version is empty. ");
                return;
            }
            a(context.getApplicationContext());
            f٦٧٩١c.put(a10, sdkInfo);
            b(context.getApplicationContext(), sdkInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final Context context, final SdkInfo sdkInfo) {
        final String format = f٦٧٩٨j.format(new Date(System.currentTimeMillis()));
        try {
            a aVar = f٦٧٩٢d.get(sdkInfo.a());
            if (aVar == null || !TextUtils.equals(format, aVar.f٦٨٠٣b) || !TextUtils.equals(sdkInfo.b(), aVar.f٦٨٠٤c) || aVar.f٦٨٠٢a != 0) {
                f٦٧٩٠b.execute(new Runnable() { // from class: com.alibaba.sdk.android.sender.AlicloudSender.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AlicloudSender.b(context, sdkInfo, format);
                    }
                });
                return;
            }
            f٦٧٩٦h.d(sdkInfo.a() + " " + sdkInfo.b() + " send abort send. ");
        } catch (Exception unused) {
        }
    }

    private static void a(Context context) {
        if (f٦٧٩٣e.compareAndSet(false, true)) {
            f٦٧٩١c = new ConcurrentHashMap();
            f٦٧٩٢d = c(context);
            SendService sendService = new SendService();
            f٦٧٩٥g = sendService;
            sendService.openHttp = Boolean.valueOf(f٦٧٩٧i);
            f٦٧٩٥g.init(context, "24527540@android", "24527540", b(context), null, null);
            f٦٧٩٥g.appSecret = "56fc10fbe8c6ae7d0d895f49c4fb6838";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, SdkInfo sdkInfo, String str) {
        a aVar = f٦٧٩٢d.get(sdkInfo.a());
        if (aVar == null) {
            aVar = new a();
            f٦٧٩٢d.put(sdkInfo.a(), aVar);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sdkId", sdkInfo.a());
        hashMap.put(RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, context.getPackageName());
        hashMap.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, sdkInfo.b());
        hashMap.put("kVersion", "1.1.4");
        if (!TextUtils.isEmpty(sdkInfo.c())) {
            hashMap.put("appKey", sdkInfo.c());
        }
        Map<String, String> map = sdkInfo.f٦٨٠٥a;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("_aliyun_biz_id", "emas-active");
        ILog iLog = f٦٧٩٦h;
        iLog.d(sdkInfo.a() + " " + sdkInfo.b() + " start send. ");
        boolean booleanValue = f٦٧٩٥g.sendRequest("adash-emas.cn-hangzhou.aliyuncs.com", System.currentTimeMillis(), f٦٧٨٩a, 19999, sdkInfo.a() + "_biz_active", null, null, hashMap).booleanValue();
        StringBuilder sb = new StringBuilder();
        sb.append(sdkInfo.a());
        sb.append(" ");
        sb.append(sdkInfo.b());
        sb.append(" send ");
        sb.append(booleanValue ? "success. " : "failed. ");
        iLog.d(sb.toString());
        aVar.f٦٨٠٣b = str;
        aVar.f٦٨٠٤c = sdkInfo.b();
        aVar.f٦٨٠٢a = booleanValue ? 0 : -1;
        a(context, f٦٧٩٢d);
    }

    private static void a(Context context, Map<String, a> map) {
        SharedPreferences.Editor remove;
        if (map == null || map.isEmpty()) {
            remove = context.getSharedPreferences("sp_emas_info", 0).edit().remove("emas_sdk_info");
        } else {
            JSONArray jSONArray = new JSONArray();
            for (String str : map.keySet()) {
                a aVar = map.get(str);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", str);
                    jSONObject.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, aVar.f٦٨٠٤c);
                    jSONObject.put("time", aVar.f٦٨٠٣b);
                    jSONObject.put("statu", aVar.f٦٨٠٢a);
                    jSONArray.put(jSONObject);
                } catch (Exception unused) {
                }
            }
            remove = context.getSharedPreferences("sp_emas_info", 0).edit().putString("emas_sdk_info", jSONArray.toString());
        }
        remove.apply();
    }
}
