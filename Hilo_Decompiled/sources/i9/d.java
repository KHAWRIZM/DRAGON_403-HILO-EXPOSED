package i9;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.sdk.android.push.oppo.BuildConfig;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.heytap.mcssdk.constant.MessageConstant$CommandId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import p9.h;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class d {

    /* renamed from: i, reason: collision with root package name */
    private static final int[] f١٤٧٩٧i = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115};

    /* renamed from: j, reason: collision with root package name */
    private static final int[] f١٤٧٩٨j = {99, 111, 109, 46, 99, 111, 108, 111, 114, 111, 115, 46, 109, 99, 115, 115, 100, 107, 46, 97, 99, 116, 105, 111, 110, 46, 82, 69, 67, 69, 73, 86, 69, 95, 83, 68, 75, 95, 77, 69, 83, 83, 65, 71, 69};

    /* renamed from: k, reason: collision with root package name */
    private static String f١٤٧٩٩k = "";

    /* renamed from: l, reason: collision with root package name */
    private static int f١٤٨٠٠l = 0;

    /* renamed from: m, reason: collision with root package name */
    private static String f١٤٨٠١m;

    /* renamed from: n, reason: collision with root package name */
    private static boolean f١٤٨٠٢n;

    /* renamed from: a, reason: collision with root package name */
    private Context f١٤٨٠٣a;

    /* renamed from: b, reason: collision with root package name */
    private List f١٤٨٠٤b;

    /* renamed from: c, reason: collision with root package name */
    private List f١٤٨٠٥c;

    /* renamed from: d, reason: collision with root package name */
    private String f١٤٨٠٦d;

    /* renamed from: e, reason: collision with root package name */
    private String f١٤٨٠٧e;

    /* renamed from: f, reason: collision with root package name */
    private String f١٤٨٠٨f;

    /* renamed from: g, reason: collision with root package name */
    private r9.a f١٤٨٠٩g;

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap f١٤٨١٠h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final d f١٤٨١١a = new d(null);
    }

    /* synthetic */ d(c cVar) {
        this();
    }

    private l9.a a(int i10) {
        if (this.f١٤٨١٠h.containsKey(Integer.valueOf(i10))) {
            l9.a aVar = (l9.a) this.f١٤٨١٠h.get(Integer.valueOf(i10));
            if (e(aVar)) {
                aVar.c(1);
                aVar.d(System.currentTimeMillis());
                p9.d.a("addCommandToMap : appLimitBean.setCount(1)");
                return aVar;
            }
            aVar.c(aVar.a() + 1);
            p9.d.a("addCommandToMap :appLimitBean.getCount() + 1");
            return aVar;
        }
        l9.a aVar2 = new l9.a(System.currentTimeMillis(), 1);
        this.f١٤٨١٠h.put(Integer.valueOf(i10), aVar2);
        p9.d.a("addCommandToMap :appBean is null");
        return aVar2;
    }

    private synchronized void b(m9.d dVar) {
        if (dVar != null) {
            this.f١٤٨٠٥c.add(dVar);
        }
    }

    private synchronized void c(n9.c cVar) {
        if (cVar != null) {
            this.f١٤٨٠٤b.add(cVar);
        }
    }

    private boolean e(l9.a aVar) {
        long b10 = aVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        p9.d.a("checkTimeNeedUpdate : lastedTime " + b10 + " currentTime:" + currentTimeMillis);
        if (currentTimeMillis - b10 > 1000) {
            return true;
        }
        return false;
    }

    public static d h() {
        return a.f١٤٨١١a;
    }

    private Intent i(int i10, String str, JSONObject jSONObject) {
        Intent intent = new Intent();
        intent.setAction(q(this.f١٤٨٠٣a));
        intent.setPackage(j(this.f١٤٨٠٣a));
        intent.putExtra("type", i10);
        JSONObject jSONObject2 = new JSONObject();
        try {
            Context context = this.f١٤٨٠٣a;
            jSONObject2.putOpt("versionName", h.e(context, context.getPackageName()));
            Context context2 = this.f١٤٨٠٣a;
            jSONObject2.putOpt("versionCode", Integer.valueOf(h.c(context2, context2.getPackageName())));
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.get(next));
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            intent.putExtra("extra", jSONObject2.toString());
            throw th;
        }
        intent.putExtra("extra", jSONObject2.toString());
        intent.putExtra(NativeProtocol.WEB_DIALOG_PARAMS, str);
        intent.putExtra("appPackage", this.f١٤٨٠٣a.getPackageName());
        intent.putExtra("appKey", this.f١٤٨٠٦d);
        intent.putExtra("appSecret", this.f١٤٨٠٧e);
        intent.putExtra("registerID", this.f١٤٨٠٨f);
        intent.putExtra(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, r());
        return intent;
    }

    private String k(Context context) {
        boolean z10;
        boolean z11;
        int packageUid;
        int packageUid2;
        if (TextUtils.isEmpty(f١٤٧٩٩k)) {
            f١٤٧٩٩k = new String(j9.a.l("Y29tLm1jcy5hY3Rpb24uUkVDRUlWRV9TREtfTUVTU0FHRQ=="));
        }
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(f١٤٧٩٩k), 8192);
        if (Build.VERSION.SDK_INT >= 24) {
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            while (it.hasNext()) {
                String str = it.next().serviceInfo.packageName;
                try {
                    z10 = false;
                    if ((context.getPackageManager().getApplicationInfo(str, 0).flags & 1) == 1) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    packageUid = context.getPackageManager().getPackageUid(str, 0);
                    packageUid2 = context.getPackageManager().getPackageUid("android", 0);
                    if (packageUid == packageUid2) {
                        z10 = true;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (z11 || z10) {
                    return str;
                }
            }
            return null;
        }
        return null;
    }

    public static String r() {
        return BuildConfig.OPPO_VERSION;
    }

    private boolean v(Context context) {
        if (this.f١٤٨٠٣a == null) {
            this.f١٤٨٠٣a = context.getApplicationContext();
        }
        String j10 = j(this.f١٤٨٠٣a);
        if (h.f(this.f١٤٨٠٣a, j10) && h.c(this.f١٤٨٠٣a, j10) >= 1019 && h.g(this.f١٤٨٠٣a, j10, "supportOpenPush")) {
            return true;
        }
        return false;
    }

    private void y(int i10, String str, JSONObject jSONObject) {
        if (d(i10)) {
            r9.a aVar = this.f١٤٨٠٩g;
            if (aVar != null) {
                aVar.onError(g(i10), "api_call_too_frequently");
                return;
            }
            return;
        }
        try {
            this.f١٤٨٠٣a.startService(i(i10, str, jSONObject));
        } catch (Exception e10) {
            p9.d.b("startMcsService--Exception" + e10.getMessage());
        }
    }

    private void z(int i10, JSONObject jSONObject) {
        y(i10, "", jSONObject);
    }

    public boolean d(int i10) {
        l9.a a10 = a(i10);
        if (i10 == 12291 || i10 == 12312 || a10.a() <= 2) {
            return false;
        }
        return true;
    }

    public Context f() {
        return this.f١٤٨٠٣a;
    }

    public int g(int i10) {
        switch (i10) {
            case 12289:
                return -1;
            case MessageConstant$CommandId.COMMAND_UNREGISTER /* 12290 */:
                return -2;
            case MessageConstant$CommandId.COMMAND_STATISTIC /* 12291 */:
                return -14;
            default:
                switch (i10) {
                    case MessageConstant$CommandId.COMMAND_SET_PUSH_TIME /* 12298 */:
                        return -11;
                    case MessageConstant$CommandId.COMMAND_PAUSE_PUSH /* 12299 */:
                        return -3;
                    case MessageConstant$CommandId.COMMAND_RESUME_PUSH /* 12300 */:
                        return -4;
                    default:
                        switch (i10) {
                            case MessageConstant$CommandId.COMMAND_GET_PUSH_STATUS /* 12306 */:
                                return -10;
                            case MessageConstant$CommandId.COMMAND_SET_NOTIFICATION_TYPE /* 12307 */:
                                return -6;
                            case MessageConstant$CommandId.COMMAND_CLEAR_NOTIFICATION_TYPE /* 12308 */:
                                return -7;
                            case MessageConstant$CommandId.COMMAND_GET_NOTIFICATION_STATUS /* 12309 */:
                                return -5;
                            case MessageConstant$CommandId.COMMAND_SET_NOTIFICATION_SETTINGS /* 12310 */:
                                return -8;
                            case MessageConstant$CommandId.COMMAND_CLEAR_PKG_NOTIFICATION /* 12311 */:
                                return -9;
                            case MessageConstant$CommandId.COMMAND_SEND_INSTANT_ACK /* 12312 */:
                                return -13;
                            case MessageConstant$CommandId.COMMAND_NOTIFICATION_ALLOWANCE /* 12313 */:
                                return -12;
                            default:
                                switch (i10) {
                                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_OPEN /* 12316 */:
                                        return -15;
                                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_CLOSE /* 12317 */:
                                        return -16;
                                    case MessageConstant$CommandId.COMMAND_APP_NOTIFICATION_GET /* 12318 */:
                                        return -17;
                                    default:
                                        return 0;
                                }
                        }
                }
        }
    }

    public String j(Context context) {
        if (f١٤٨٠١m == null) {
            String k10 = k(context);
            if (k10 == null) {
                f١٤٨٠١m = h.a(f١٤٧٩٧i);
                f١٤٨٠٢n = false;
            } else {
                f١٤٨٠١m = k10;
                f١٤٨٠٢n = true;
            }
        }
        return f١٤٨٠١m;
    }

    public List l() {
        return this.f١٤٨٠٥c;
    }

    public List m() {
        return this.f١٤٨٠٤b;
    }

    public r9.a n() {
        return this.f١٤٨٠٩g;
    }

    public r9.c o() {
        return null;
    }

    public r9.d p() {
        return null;
    }

    public String q(Context context) {
        if (f١٤٨٠١m == null) {
            k(context);
        }
        if (f١٤٨٠٢n) {
            if (TextUtils.isEmpty(f١٤٧٩٩k)) {
                f١٤٧٩٩k = new String(j9.a.l("Y29tLm1jcy5hY3Rpb24uUkVDRUlWRV9TREtfTUVTU0FHRQ=="));
            }
            return f١٤٧٩٩k;
        }
        return h.a(f١٤٧٩٨j);
    }

    public d s(Context context, boolean z10) {
        if (context != null) {
            t(context);
            new k9.a().c(this.f١٤٨٠٣a);
            p9.d.c(z10);
            return this;
        }
        throw new IllegalArgumentException("context can't be null");
    }

    public void t(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f١٤٨٠٣a = applicationContext;
        if (f١٤٨٠١m == null) {
            String k10 = k(applicationContext);
            if (k10 == null) {
                f١٤٨٠١m = h.a(f١٤٧٩٧i);
                f١٤٨٠٢n = false;
            } else {
                f١٤٨٠١m = k10;
                f١٤٨٠٢n = true;
            }
        }
    }

    public boolean u(Context context) {
        return v(context);
    }

    public void w(Context context, String str, String str2, JSONObject jSONObject, r9.a aVar) {
        if (context == null) {
            if (aVar != null) {
                aVar.onRegister(-2, null);
                return;
            }
            return;
        }
        if (this.f١٤٨٠٣a == null) {
            this.f١٤٨٠٣a = context.getApplicationContext();
        }
        if (!h.h(this.f١٤٨٠٣a)) {
            if (aVar != null) {
                aVar.onRegister(-2, null);
                return;
            }
            return;
        }
        this.f١٤٨٠٦d = str;
        this.f١٤٨٠٧e = str2;
        this.f١٤٨٠٩g = aVar;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.putOpt("appVersionCode", Integer.valueOf(h.b(context)));
            jSONObject.putOpt("appVersionName", h.d(context));
        } catch (JSONException e10) {
            p9.d.b("register-Exception:" + e10.getMessage());
        }
        z(12289, jSONObject);
    }

    public void x(String str) {
        this.f١٤٨٠٨f = str;
    }

    private d() {
        this.f١٤٨٠٤b = new ArrayList();
        this.f١٤٨٠٥c = new ArrayList();
        this.f١٤٨٠٨f = null;
        synchronized (d.class) {
            int i10 = f١٤٨٠٠l;
            if (i10 <= 0) {
                f١٤٨٠٠l = i10 + 1;
            } else {
                throw new RuntimeException("PushService can't create again!");
            }
        }
        b(new m9.b());
        b(new m9.a());
        c(new n9.b());
        c(new n9.a());
        this.f١٤٨١٠h = new ConcurrentHashMap();
    }
}
