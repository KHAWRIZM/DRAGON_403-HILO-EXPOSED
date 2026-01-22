package com.alibaba.sdk.android.push.g;

import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;
import anetwork.channel.util.RequestConstant;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.ams.common.util.StringUtil;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.g.f;
import com.facebook.internal.ServerProtocol;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final AmsLogger f٦٦٩٥a = AmsLogger.getLogger("MPS:VipRequestManager");

    /* renamed from: b, reason: collision with root package name */
    private static g f٦٦٩٦b = null;

    /* renamed from: c, reason: collision with root package name */
    private static Context f٦٦٩٧c;

    /* renamed from: d, reason: collision with root package name */
    private final f f٦٦٩٨d = new f();

    private g() {
    }

    public static g a() {
        if (f٦٦٩٦b == null) {
            f٦٦٩٦b = new g();
        }
        return f٦٦٩٦b;
    }

    private String e() {
        return com.alibaba.sdk.android.ams.common.b.c.a().b();
    }

    private String f() {
        return com.alibaba.sdk.android.ams.common.b.c.a().c("mps_account");
    }

    private Map<String, String> g() {
        String b10 = b();
        HashMap hashMap = new HashMap();
        hashMap.put("appKey", b10);
        hashMap.put("os", "2");
        hashMap.put(ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "3.8.6.1");
        return hashMap;
    }

    public String b() {
        return com.alibaba.sdk.android.ams.common.b.c.a().a();
    }

    private String a(int i10) {
        f.a a10 = this.f٦٦٩٨d.a(i10);
        if (a10 == null) {
            return null;
        }
        return a10.a();
    }

    public void b(int i10, String[] strArr, String str, final CommonCallback commonCallback) {
        Map<String, String> a10;
        String str2;
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            h hVar = new h(f٦٦٩٧c, "https://" + com.alibaba.sdk.android.ams.common.a.a.d() + "/unbind-tag", new CommonCallback() { // from class: com.alibaba.sdk.android.push.g.g.9
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str3, String str4) {
                    g.this.a(str3, str4, "/unbind-tag");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str3, str4);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str3) {
                    if (commonCallback != null) {
                        g.this.a("/unbind-tag", System.currentTimeMillis() - currentTimeMillis);
                        commonCallback.onSuccess(str3);
                    }
                }
            });
            Map<String, String> g10 = g();
            if (i10 == 1) {
                f٦٦٩٥a.d("Unbinding tag from device.");
                a10 = a(DispatchConstants.DEVICEID, (String) null, (String[]) null, g10);
                str2 = com.alibaba.sdk.android.push.common.util.a.d.UNBIND_TAG_TO_DEVICE.a() + "";
            } else if (i10 == 2) {
                f٦٦٩٥a.d("Unbinding tag from account.");
                a10 = a("account", (String) null, (String[]) null, g10);
                str2 = com.alibaba.sdk.android.push.common.util.a.d.UNBIND_TAG_TO_ACCOUNT.a() + "";
            } else {
                if (i10 != 3) {
                    throw new com.alibaba.sdk.android.push.b.d("target is invalid.");
                }
                f٦٦٩٥a.d("Unbinding tag from alias.");
                a10 = a("alias", str, (String[]) null, g10);
                str2 = com.alibaba.sdk.android.push.common.util.a.d.UNBIND_TAG_TO_ALIAS.a() + "";
            }
            a10.put("VipRequestType", str2);
            Map<String, String> a11 = a("tags", (String) null, strArr, a10);
            a11.put("target", String.valueOf(i10));
            hVar.execute(a11);
        } catch (com.alibaba.sdk.android.push.b.c e10) {
            a(e10, "/unbind-tag", commonCallback);
        } catch (com.alibaba.sdk.android.push.b.d e11) {
            a(e11, "/unbind-tag", commonCallback);
        }
    }

    public void c(final CommonCallback commonCallback) {
        f٦٦٩٥a.d("check vip push status");
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            h hVar = new h(f٦٦٩٧c, "https://" + com.alibaba.sdk.android.ams.common.a.a.d() + "/push-status", new CommonCallback() { // from class: com.alibaba.sdk.android.push.g.g.14
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str, String str2) {
                    g.this.a(str, str2, "/push-status");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str, str2);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str) {
                    g.this.a("/push-status", System.currentTimeMillis() - currentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str);
                    }
                }
            });
            Map<String, String> a10 = a(DispatchConstants.DEVICEID, (String) null, (String[]) null, g());
            a10.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.CHECK_PUSH_STATUS.a()));
            hVar.execute(a10);
        } catch (com.alibaba.sdk.android.push.b.c e10) {
            a(e10, "/push-status", commonCallback);
        }
    }

    public void d(final CommonCallback commonCallback) {
        final long currentTimeMillis = System.currentTimeMillis();
        f٦٦٩٥a.d("unbinding vip");
        try {
            h hVar = new h(f٦٦٩٧c, "https://" + com.alibaba.sdk.android.ams.common.a.a.d() + "/push-switch", new CommonCallback() { // from class: com.alibaba.sdk.android.push.g.g.2
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str, String str2) {
                    g.this.a(str, str2, "/push-switch");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str, str2);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str) {
                    g.this.a("/push-switch", System.currentTimeMillis() - currentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str);
                    }
                }
            });
            Map<String, String> a10 = a(DispatchConstants.DEVICEID, (String) null, (String[]) null, g());
            a10.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.TURN_OFF_PUSH.a()));
            a10.put("enable", RequestConstant.FALSE);
            hVar.execute(a10);
        } catch (com.alibaba.sdk.android.push.b.c e10) {
            a(e10, "/push-switch false", commonCallback);
        }
    }

    public void e(final CommonCallback commonCallback) {
        final long currentTimeMillis = System.currentTimeMillis();
        f٦٦٩٥a.d("binding vip push");
        try {
            h hVar = new h(f٦٦٩٧c, "https://" + com.alibaba.sdk.android.ams.common.a.a.d() + "/push-switch", new CommonCallback() { // from class: com.alibaba.sdk.android.push.g.g.3
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str, String str2) {
                    g.this.a(str, str2, "/push-switch");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str, str2);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str) {
                    g.this.a("/push-switch", System.currentTimeMillis() - currentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str);
                    }
                }
            });
            Map<String, String> a10 = a(DispatchConstants.DEVICEID, (String) null, (String[]) null, g());
            a10.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.TURN_ON_PUSH.a()));
            a10.put("enable", "true");
            hVar.execute(a10);
        } catch (com.alibaba.sdk.android.push.b.c e10) {
            a(e10, "/push-switch true", commonCallback);
        }
    }

    public void f(final CommonCallback commonCallback) {
        final long currentTimeMillis = System.currentTimeMillis();
        f٦٦٩٥a.d("unbinding phone number");
        h hVar = new h(f٦٦٩٧c, "https://" + com.alibaba.sdk.android.ams.common.a.a.d() + "/unset-phone", new CommonCallback() { // from class: com.alibaba.sdk.android.push.g.g.5
            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onFailed(String str, String str2) {
                g.this.a(str, str2, "/unset-phone");
                CommonCallback commonCallback2 = commonCallback;
                if (commonCallback2 != null) {
                    commonCallback2.onFailed(str, str2);
                }
            }

            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onSuccess(String str) {
                g.this.a("/unset-phone", System.currentTimeMillis() - currentTimeMillis);
                CommonCallback commonCallback2 = commonCallback;
                if (commonCallback2 != null) {
                    commonCallback2.onSuccess(str);
                }
            }
        });
        try {
            Map<String, String> g10 = g();
            g10.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.UNBIND_PHONE_NUMBER.a()));
            hVar.execute(a(DispatchConstants.DEVICEID, (String) null, (String[]) null, g10));
        } catch (com.alibaba.sdk.android.push.b.c e10) {
            a(e10, "/unset-phone", commonCallback);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Map<String, String> a(String str, String str2, String[] strArr, Map<String, String> map) {
        String str3;
        int i10 = 0;
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1177318867:
                if (str.equals("account")) {
                    c10 = 0;
                    break;
                }
                break;
            case 3552281:
                if (str.equals("tags")) {
                    c10 = 1;
                    break;
                }
                break;
            case 92902992:
                if (str.equals("alias")) {
                    c10 = 2;
                    break;
                }
                break;
            case 1109191185:
                if (str.equals(DispatchConstants.DEVICEID)) {
                    c10 = 3;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                String f10 = f();
                if (StringUtil.isEmpty(f10)) {
                    throw new com.alibaba.sdk.android.push.b.c("account is empty");
                }
                map.put("account", f10);
                return map;
            case 1:
                if (strArr == null) {
                    throw new com.alibaba.sdk.android.push.b.c("tags array is empty");
                }
                StringBuilder sb = new StringBuilder();
                while (i10 < strArr.length) {
                    if (i10 == strArr.length - 1 || StringUtil.isEmpty(strArr[i10])) {
                        str3 = (i10 == strArr.length - 1 && !StringUtil.isEmpty(strArr[i10])) ? strArr[i10] : ",";
                        i10++;
                    } else {
                        sb.append(strArr[i10]);
                    }
                    sb.append(str3);
                    i10++;
                }
                if (StringUtil.isEmpty(sb.toString())) {
                    throw new com.alibaba.sdk.android.push.b.c("tags array is empty");
                }
                map.put("tags", sb.toString());
                return map;
            case 2:
                if (StringUtil.isEmpty(str2)) {
                    throw new com.alibaba.sdk.android.push.b.c("alias is empty");
                }
                map.put("alias", str2);
                return map;
            case 3:
                String e10 = e();
                if (StringUtil.isEmpty(e10)) {
                    throw new com.alibaba.sdk.android.push.b.c("deviceId is empty.");
                }
                map.put(DispatchConstants.DEVICEID, e10);
                return map;
            default:
                return map;
        }
    }

    public void b(Context context) {
        if (c(context)) {
            f٦٦٩٥a.e("onAppStart has already sent today");
            return;
        }
        f٦٦٩٥a.d("onAppStart");
        h hVar = new h(f٦٦٩٧c, "https://" + com.alibaba.sdk.android.ams.common.a.a.d() + "/active", new CommonCallback() { // from class: com.alibaba.sdk.android.push.g.g.6
            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onFailed(String str, String str2) {
                g.f٦٦٩٥a.e("onAppStart failed. errorCode:" + str + " errorMsg:" + str2);
            }

            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onSuccess(String str) {
                g.f٦٦٩٥a.d("onAppStart success");
                try {
                    com.alibaba.sdk.android.push.common.util.b.a(g.f٦٦٩٧c, "KEY_LAUNCH_MARK", System.currentTimeMillis());
                } catch (Throwable th) {
                    g.f٦٦٩٥a.e("onAppStart success", th);
                }
            }
        });
        try {
            Map<String, String> g10 = g();
            g10.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.ON_APP_START.a()));
            hVar.execute(a(DispatchConstants.DEVICEID, (String) null, (String[]) null, g10));
        } catch (com.alibaba.sdk.android.push.b.c e10) {
            a(e10, "/active", (CommonCallback) null);
        }
    }

    public void c(String str, final CommonCallback commonCallback) {
        final long currentTimeMillis = System.currentTimeMillis();
        f٦٦٩٥a.d("Removing alias from device");
        try {
            h hVar = new h(f٦٦٩٧c, "https://" + com.alibaba.sdk.android.ams.common.a.a.d() + "/remove-alias", new CommonCallback() { // from class: com.alibaba.sdk.android.push.g.g.12
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str2, String str3) {
                    g.this.a(str2, str3, "/remove-alias");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str2, str3);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str2) {
                    g.this.a("/remove-alias", System.currentTimeMillis() - currentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str2);
                    }
                }
            });
            Map<String, String> a10 = a(DispatchConstants.DEVICEID, (String) null, (String[]) null, g());
            if (StringUtil.isEmpty(str)) {
                str = "";
            }
            a10.put("alias", str);
            a10.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.UNBIND_ALIAS.a()));
            hVar.execute(a10);
        } catch (com.alibaba.sdk.android.push.b.c e10) {
            a(e10, "/remove-alias", commonCallback);
        }
    }

    public void d(String str, final CommonCallback commonCallback) {
        f٦٦٩٥a.d("binding phoneNumber:" + str);
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            h hVar = new h(f٦٦٩٧c, "https://" + com.alibaba.sdk.android.ams.common.a.a.d() + "/set-phone", new CommonCallback() { // from class: com.alibaba.sdk.android.push.g.g.4
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str2, String str3) {
                    g.this.a(str2, str3, "/set-phone");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str2, str3);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str2) {
                    g.this.a("/set-phone", System.currentTimeMillis() - currentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str2);
                    }
                }
            });
            Map<String, String> g10 = g();
            if (StringUtil.isEmpty(str)) {
                throw new com.alibaba.sdk.android.push.b.d("account input is empty!");
            }
            g10.put("mob", str);
            g10.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.BIND_PHONE_NUMBER.a()));
            hVar.execute(a(DispatchConstants.DEVICEID, (String) null, (String[]) null, g10));
        } catch (com.alibaba.sdk.android.push.b.c e10) {
            a(e10, "/set-phone", commonCallback);
        } catch (com.alibaba.sdk.android.push.b.d e11) {
            a(e11, "/set-phone", commonCallback);
        }
    }

    private static boolean c(Context context) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(com.alibaba.sdk.android.push.common.util.b.a(context, "KEY_LAUNCH_MARK"));
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    public void a(final int i10, final CommonCallback commonCallback) {
        String a10;
        final long currentTimeMillis = System.currentTimeMillis();
        AmsLogger amsLogger = f٦٦٩٥a;
        amsLogger.d("listTags");
        if (1 == i10 && (a10 = a(2)) != null) {
            amsLogger.d("get from cache");
            if (commonCallback != null) {
                commonCallback.onSuccess(a10);
                return;
            }
            return;
        }
        try {
            h hVar = new h(f٦٦٩٧c, "https://" + com.alibaba.sdk.android.ams.common.a.a.d() + "/list-tag", new CommonCallback() { // from class: com.alibaba.sdk.android.push.g.g.10
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str, String str2) {
                    g.this.a(str, str2, "/list-tag");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str, str2);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str) {
                    g.this.a("/list-tag", System.currentTimeMillis() - currentTimeMillis);
                    if (1 == i10) {
                        g.f٦٦٩٥a.d("store cache");
                        g.this.a(2, str);
                    }
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str);
                    }
                }
            });
            Map<String, String> g10 = g();
            if (i10 != 1) {
                throw new com.alibaba.sdk.android.push.b.d("target is invalid.");
            }
            Map<String, String> a11 = a(DispatchConstants.DEVICEID, (String) null, (String[]) null, g10);
            a11.put("target", String.valueOf(i10));
            a11.put("VipRequestType", com.alibaba.sdk.android.push.common.util.a.d.LIST_TAGS.a() + "");
            hVar.execute(a11);
        } catch (com.alibaba.sdk.android.push.b.c e10) {
            a(e10, "/list-tag", commonCallback);
        } catch (com.alibaba.sdk.android.push.b.d e11) {
            a(e11, "/list-tag", commonCallback);
        }
    }

    public void b(final CommonCallback commonCallback) {
        final long currentTimeMillis = System.currentTimeMillis();
        AmsLogger amsLogger = f٦٦٩٥a;
        amsLogger.d("listAliases");
        String a10 = a(1);
        if (a10 != null) {
            amsLogger.d("get from cache");
            if (commonCallback != null) {
                commonCallback.onSuccess(a10);
                return;
            }
            return;
        }
        try {
            h hVar = new h(f٦٦٩٧c, "https://" + com.alibaba.sdk.android.ams.common.a.a.d() + "/list-alias", new CommonCallback() { // from class: com.alibaba.sdk.android.push.g.g.13
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str, String str2) {
                    g.this.a(str, str2, "/list-alias");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str, str2);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str) {
                    g.f٦٦٩٥a.d("store cache");
                    g.this.a(1, str);
                    g.this.a("/list-alias", System.currentTimeMillis() - currentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str);
                    }
                }
            });
            Map<String, String> g10 = g();
            g10.put("VipRequestType", com.alibaba.sdk.android.push.common.util.a.d.LIST_ALIASES.a() + "");
            hVar.execute(a(DispatchConstants.DEVICEID, (String) null, (String[]) null, g10));
        } catch (com.alibaba.sdk.android.push.b.c e10) {
            a(e10, "/list-alias", commonCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, String str) {
        this.f٦٦٩٨d.a(i10, str);
    }

    public void b(String str, final CommonCallback commonCallback) {
        final long currentTimeMillis = System.currentTimeMillis();
        f٦٦٩٥a.d("Adding alias to device");
        try {
            h hVar = new h(f٦٦٩٧c, "https://" + com.alibaba.sdk.android.ams.common.a.a.d() + "/add-alias", new CommonCallback() { // from class: com.alibaba.sdk.android.push.g.g.11
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str2, String str3) {
                    g.this.a(str2, str3, "/add-alias");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str2, str3);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str2) {
                    g.this.a("/add-alias", System.currentTimeMillis() - currentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str2);
                    }
                }
            });
            Map<String, String> a10 = a("alias", str, (String[]) null, a(DispatchConstants.DEVICEID, (String) null, (String[]) null, g()));
            a10.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.BIND_ALIAS.a()));
            hVar.execute(a10);
        } catch (com.alibaba.sdk.android.push.b.c e10) {
            a(e10, "/add-alias", commonCallback);
        }
    }

    public void a(int i10, String[] strArr, String str, final CommonCallback commonCallback) {
        Map<String, String> a10;
        String str2;
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            h hVar = new h(f٦٦٩٧c, "https://" + com.alibaba.sdk.android.ams.common.a.a.d() + "/bind-tag", new CommonCallback() { // from class: com.alibaba.sdk.android.push.g.g.8
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str3, String str4) {
                    g.this.a(str3, str4, "/bind-tag");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str3, str4);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str3) {
                    g.this.a("/bind-tag", System.currentTimeMillis() - currentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str3);
                    }
                }
            });
            if (strArr == null || strArr.length == 0) {
                throw new com.alibaba.sdk.android.push.b.d("tags is empty.");
            }
            Map<String, String> g10 = g();
            if (i10 == 1) {
                f٦٦٩٥a.d("Binding tag to device.");
                a10 = a(DispatchConstants.DEVICEID, (String) null, (String[]) null, g10);
                str2 = com.alibaba.sdk.android.push.common.util.a.d.BIND_TAG_TO_DEVICE.a() + "";
            } else if (i10 == 2) {
                f٦٦٩٥a.d("Binding tag to account.");
                a10 = a("account", (String) null, (String[]) null, g10);
                str2 = com.alibaba.sdk.android.push.common.util.a.d.BIND_TAG_TO_ACCOUNT.a() + "";
            } else {
                if (i10 != 3) {
                    throw new com.alibaba.sdk.android.push.b.d("target is invalid.");
                }
                a10 = a("alias", str, (String[]) null, g10);
                str2 = com.alibaba.sdk.android.push.common.util.a.d.BIND_TAG_TO_ALIAS.a() + "";
            }
            a10.put("VipRequestType", str2);
            Map<String, String> a11 = a("tags", (String) null, strArr, a10);
            a11.put("target", String.valueOf(i10));
            hVar.execute(a11);
        } catch (com.alibaba.sdk.android.push.b.c e10) {
            a(e10, "/bind-tag", commonCallback);
        } catch (com.alibaba.sdk.android.push.b.d e11) {
            a(e11, "/bind-tag", commonCallback);
        }
    }

    public static void a(Context context) {
        f٦٦٩٧c = context;
        if (f٦٦٩٦b == null) {
            f٦٦٩٦b = a();
        }
    }

    public void a(final CommonCallback commonCallback) {
        f٦٦٩٥a.d("unbinding account");
        final long currentTimeMillis = System.currentTimeMillis();
        h hVar = new h(f٦٦٩٧c, "https://" + com.alibaba.sdk.android.ams.common.a.a.d() + "/unbind-account", new CommonCallback() { // from class: com.alibaba.sdk.android.push.g.g.7
            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onFailed(String str, String str2) {
                g.this.a(str, str2, "/unbind-account");
                CommonCallback commonCallback2 = commonCallback;
                if (commonCallback2 != null) {
                    commonCallback2.onFailed(str, str2);
                }
            }

            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onSuccess(String str) {
                g.this.a("");
                g.this.a("/unbind-account", System.currentTimeMillis() - currentTimeMillis);
                CommonCallback commonCallback2 = commonCallback;
                if (commonCallback2 != null) {
                    commonCallback2.onSuccess(str);
                }
            }
        });
        try {
            Map<String, String> g10 = g();
            g10.put("account", "");
            g10.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.UNBIND_ACCOUNT.a()));
            hVar.execute(a(DispatchConstants.DEVICEID, (String) null, (String[]) null, g10));
        } catch (com.alibaba.sdk.android.push.b.c e10) {
            a(e10, "/unbind-account", commonCallback);
        }
    }

    private void a(com.alibaba.sdk.android.push.b.c cVar, String str, CommonCallback commonCallback) {
        a((Throwable) cVar, str, commonCallback);
    }

    private void a(com.alibaba.sdk.android.push.b.d dVar, String str, CommonCallback commonCallback) {
        a((Throwable) dVar, str, commonCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.alibaba.sdk.android.ams.common.b.c.a().a("mps_account", str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, long j10) {
        com.alibaba.sdk.android.push.d.a a10 = com.alibaba.sdk.android.push.d.a.a();
        com.alibaba.sdk.android.ams.common.b.b a11 = com.alibaba.sdk.android.ams.common.b.c.a();
        if (a10 == null || a11 == null) {
            return;
        }
        a10.a(str, a11.b(), j10);
    }

    public void a(final String str, final CommonCallback commonCallback) {
        f٦٦٩٥a.d("binding account" + str);
        final long currentTimeMillis = System.currentTimeMillis();
        try {
            h hVar = new h(f٦٦٩٧c, "https://" + com.alibaba.sdk.android.ams.common.a.a.d() + "/bind-account", new CommonCallback() { // from class: com.alibaba.sdk.android.push.g.g.1
                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onFailed(String str2, String str3) {
                    g.this.a(str2, str3, "/bind-account");
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onFailed(str2, str3);
                    }
                }

                @Override // com.alibaba.sdk.android.push.CommonCallback
                public void onSuccess(String str2) {
                    g.this.a(str);
                    g.this.a("/bind-account", System.currentTimeMillis() - currentTimeMillis);
                    CommonCallback commonCallback2 = commonCallback;
                    if (commonCallback2 != null) {
                        commonCallback2.onSuccess(str2);
                    }
                }
            });
            Map<String, String> g10 = g();
            if (StringUtil.isEmpty(str)) {
                throw new com.alibaba.sdk.android.push.b.d("account input is empty!");
            }
            g10.put("account", str);
            g10.put("VipRequestType", String.valueOf(com.alibaba.sdk.android.push.common.util.a.d.BIND_ACCOUNT.a()));
            hVar.execute(a(DispatchConstants.DEVICEID, (String) null, (String[]) null, g10));
        } catch (com.alibaba.sdk.android.push.b.c e10) {
            a(e10, "/bind-account", commonCallback);
        } catch (com.alibaba.sdk.android.push.b.d e11) {
            a(e11, "/bind-account", commonCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        com.alibaba.sdk.android.push.d.a a10 = com.alibaba.sdk.android.push.d.a.a();
        com.alibaba.sdk.android.ams.common.b.b a11 = com.alibaba.sdk.android.ams.common.b.c.a();
        if (a10 == null || a11 == null) {
            return;
        }
        a10.a(str, str2, a11.b(), str3);
    }

    private void a(Throwable th, String str, CommonCallback commonCallback) {
        ErrorCode build = com.alibaba.sdk.android.push.common.a.d.f٦٦٠٥q.copy().msg(th.getMessage()).build();
        f٦٦٩٥a.e(str + " Fail: errorCode:" + build, th);
        if (commonCallback != null) {
            commonCallback.onFailed(build.getCode(), build.getMsg());
        }
        a(build.getCode(), build.getMsg(), str);
    }
}
