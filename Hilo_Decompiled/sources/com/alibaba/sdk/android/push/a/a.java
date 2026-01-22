package com.alibaba.sdk.android.push.a;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.beacon.Beacon;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final AmsLogger f٦٤٥٥a = AmsLogger.getLogger("MPS:BeaconManager");

    /* renamed from: b, reason: collision with root package name */
    private Context f٦٤٥٦b;

    /* renamed from: c, reason: collision with root package name */
    private b f٦٤٥٧c;

    /* renamed from: d, reason: collision with root package name */
    private Beacon f٦٤٥٨d;

    /* renamed from: e, reason: collision with root package name */
    private final Beacon.OnUpdateListener f٦٤٥٩e;

    /* renamed from: f, reason: collision with root package name */
    private final Beacon.OnServiceErrListener f٦٤٦٠f;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.alibaba.sdk.android.push.a.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class C٠٠٧٧a {

        /* renamed from: a, reason: collision with root package name */
        static final a f٦٤٦٣a = new a();
    }

    private a() {
        this.f٦٤٥٦b = null;
        this.f٦٤٥٧c = null;
        this.f٦٤٥٨d = null;
        this.f٦٤٥٩e = new Beacon.OnUpdateListener() { // from class: com.alibaba.sdk.android.push.a.a.1
            @Override // com.alibaba.sdk.android.beacon.Beacon.OnUpdateListener
            public void onUpdate(List<Beacon.Config> list) {
                a.this.a(list);
            }
        };
        this.f٦٤٦٠f = new Beacon.OnServiceErrListener() { // from class: com.alibaba.sdk.android.push.a.a.2
            @Override // com.alibaba.sdk.android.beacon.Beacon.OnServiceErrListener
            public void onErr(Beacon.Error error) {
                a.f٦٤٥٥a.e("beacon error. errorCode:" + error.errCode + ", errorMsg:" + error.errMsg);
            }
        };
    }

    public static a a() {
        return C٠٠٧٧a.f٦٤٦٣a;
    }

    public void a(Context context, String str, String str2, String str3) {
        this.f٦٤٥٦b = context;
        AmsLogger amsLogger = f٦٤٥٥a;
        amsLogger.d("appkey:" + str);
        if (this.f٦٤٥٦b == null) {
            amsLogger.e("context is null !!");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sdkId", "push");
        hashMap.put("sdkVer", str3);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            Beacon build = new Beacon.Builder().appKey(str).appSecret(str2).extras(hashMap).startPoll(false).build();
            this.f٦٤٥٨d = build;
            build.addUpdateListener(this.f٦٤٥٩e);
            this.f٦٤٥٨d.addServiceErrListener(this.f٦٤٦٠f);
            this.f٦٤٥٨d.start(this.f٦٤٥٦b.getApplicationContext());
            return;
        }
        amsLogger.e("invalid appkey or appsecret. appkey:" + str + ", appsecret:" + str2);
    }

    public void a(b bVar) {
        this.f٦٤٥٧c = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<Beacon.Config> list) {
        f٦٤٥٥a.d("parse beacon config");
        if (list == null || list.size() == 0) {
            return;
        }
        for (Beacon.Config config : list) {
            f٦٤٥٥a.d("beacon key:" + config.key + "; beacon value:" + config.value);
            if (config.key.equalsIgnoreCase("___push_service___")) {
                a(config);
            }
        }
    }

    private boolean a(Beacon.Config config) {
        if (config == null || !config.key.equalsIgnoreCase("___push_service___")) {
            return false;
        }
        String str = config.value;
        if (str != null) {
            f٦٤٥٥a.d("push configs:" + str);
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("ut")) {
                    a(jSONObject.getString("ut"));
                }
            } catch (JSONException e10) {
                f٦٤٥٥a.e("parse push configs failed.", e10);
                return false;
            }
        }
        return true;
    }

    private boolean a(String str) {
        if (str == null || this.f٦٤٥٧c == null) {
            return false;
        }
        f٦٤٥٥a.d("is report enabled:" + str);
        this.f٦٤٥٧c.a(str.equalsIgnoreCase("disabled") ^ true);
        return true;
    }
}
