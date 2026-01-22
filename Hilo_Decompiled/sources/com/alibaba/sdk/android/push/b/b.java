package com.alibaba.sdk.android.push.b;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import anet.channel.util.ALog;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.crashdefend.CrashDefendApi;
import com.alibaba.sdk.android.crashdefend.CrashDefendCallback;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.logger.LogLevel;
import com.alibaba.sdk.android.push.CloudPushService;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.IPushPermissionCallback;
import com.alibaba.sdk.android.push.f.a;
import com.alibaba.sdk.android.push.notification.CPushMessage;
import com.alibaba.sdk.android.sender.AlicloudSender;
import com.alibaba.sdk.android.sender.SdkInfo;
import com.taobao.accs.ACCSClient;
import com.taobao.accs.utl.AccsLogger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b implements CloudPushService {

    /* renamed from: a, reason: collision with root package name */
    private static final b f٦٤٨٢a = new b();

    /* renamed from: b, reason: collision with root package name */
    private a f٦٤٨٣b;

    /* renamed from: c, reason: collision with root package name */
    private Context f٦٤٨٤c;

    /* renamed from: f, reason: collision with root package name */
    private a.InterfaceC٠٠٨٢a f٦٤٨٧f;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٦٤٨٥d = true;

    /* renamed from: e, reason: collision with root package name */
    private boolean f٦٤٨٦e = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f٦٤٨٨g = false;

    private void d() {
        SdkInfo sdkInfo = new SdkInfo();
        sdkInfo.setSdkId("push");
        sdkInfo.setSdkVersion("3.8.6.1");
        sdkInfo.setAppKey(com.alibaba.sdk.android.ams.common.b.c.a().a());
        if (com.alibaba.sdk.android.ams.common.a.a.a() != null) {
            AlicloudSender.asyncSend(com.alibaba.sdk.android.ams.common.a.a.a(), sdkInfo);
        } else {
            AlicloudSender.asyncSend(com.alibaba.sdk.android.ams.common.a.a.b(), sdkInfo);
        }
    }

    private void e() {
        if (this.f٦٤٨٣b != null || this.f٦٤٨٤c == null) {
            return;
        }
        this.f٦٤٨٣b = new a(this.f٦٤٨٤c);
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void addAlias(final String str, final CommonCallback commonCallback) {
        a("addAlias", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.2
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.b(str, commonCallback);
            }
        });
    }

    public a.InterfaceC٠٠٨٢a b() {
        return this.f٦٤٨٧f;
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void bindAccount(final String str, final CommonCallback commonCallback) {
        a("bindAccount", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.26
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.a(str, commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void bindPhoneNumber(final String str, final CommonCallback commonCallback) {
        a("bindPhoneNumber", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.21
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.d(str, commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void bindTag(final int i10, final String[] strArr, final String str, final CommonCallback commonCallback) {
        a("bindTag", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.28
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.a(i10, strArr, str, commonCallback);
            }
        });
    }

    public boolean c() {
        return this.f٦٤٨٨g;
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void checkPushChannelStatus(final CommonCallback commonCallback) {
        a("checkPushChannelStatus", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.17
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.f(commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void clearNotifications() {
        a("clearNotifications", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.14
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.b();
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void clickMessage(final CPushMessage cPushMessage) {
        a("clickMessage", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.19
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.a(cPushMessage);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void closeDoNotDisturbMode() {
        a("closeDoNotDisturbMode", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.7
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.a(false);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void dismissMessage(final CPushMessage cPushMessage) {
        a("dismissMessage", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.18
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.b(cPushMessage);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public String getDeviceId() {
        if (a("getDeviceId", (CommonCallback) null, (Runnable) null)) {
            return this.f٦٤٨٣b.a();
        }
        return null;
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public String getUTDeviceId() {
        if (a("getUTDeviceId", (CommonCallback) null, (Runnable) null)) {
            return this.f٦٤٨٣b.a(this.f٦٤٨٤c);
        }
        return null;
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void listAliases(final CommonCallback commonCallback) {
        a("listAlias", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.4
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.b(commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void listTags(final int i10, final CommonCallback commonCallback) {
        a("listTags", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.30
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.a(i10, commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void onAppStart() {
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public synchronized void register(final Context context, final CommonCallback commonCallback) {
        if (context != null) {
            a("register", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.12
                @Override // java.lang.Runnable
                public void run() {
                    ALog.setUseTlog(false);
                    ACCSClient.changeNetworkSdkLoggerToAccs();
                    b.this.a(context, commonCallback);
                }
            });
            return;
        }
        AmsLogger.getImportantLogger().e("context null");
        if (commonCallback != null) {
            ErrorCode build = com.alibaba.sdk.android.push.common.a.d.f٦٦٠٥q.copy().detail("register context null").build();
            commonCallback.onFailed(build.getCode(), build.getMsg());
        }
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void removeAlias(final String str, final CommonCallback commonCallback) {
        a("removeAlias", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.c(str, commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void requestNotificationPermission(Activity activity, int i10, IPushPermissionCallback iPushPermissionCallback) {
        if (Build.VERSION.SDK_INT < 33 || androidx.core.content.a.checkSelfPermission(activity, "android.permission.POST_NOTIFICATIONS") != -1) {
            return;
        }
        if (androidx.core.content.a.checkSelfPermission(activity, "android.permission.POST_NOTIFICATIONS") != -1) {
            if (iPushPermissionCallback != null) {
                iPushPermissionCallback.onPushPermissionGranted();
            }
        } else if (!androidx.core.app.b.j(activity, "android.permission.POST_NOTIFICATIONS")) {
            androidx.core.app.b.g(activity, new String[]{"android.permission.POST_NOTIFICATIONS"}, i10);
        } else if (iPushPermissionCallback != null) {
            iPushPermissionCallback.onPushPermissionForbidden();
        }
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setAppSecret(final String str) {
        a("setAppSecret", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.13
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.c(str);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setAppkey(final String str) {
        a("setAppKey", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.11
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.b(str);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setDebug(final boolean z10) {
        a("setDebug", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.24
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.b(z10);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setDoNotDisturb(final int i10, final int i11, final int i12, final int i13, final CommonCallback commonCallback) {
        a("setDoNotDisturb", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.6
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.a(i10, i11, i12, i13, commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setEnableCrashDefend(boolean z10) {
        this.f٦٤٨٦e = z10;
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setLargeIconDownloadListener(a.InterfaceC٠٠٨٢a r12) {
        this.f٦٤٨٧f = r12;
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setLogLevel(final int i10) {
        a("setLogLevel", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.5
            @Override // java.lang.Runnable
            public void run() {
                AmsLogger.log_level = i10;
                int i11 = 0;
                ALog.setUseTlog(false);
                ACCSClient.changeNetworkSdkLoggerToAccs();
                int i12 = i10;
                if (i12 == -1) {
                    AccsLogger.enable(false);
                    i11 = 5;
                } else {
                    if (i12 != 0 && i12 != 2 && i12 != 1) {
                        return;
                    }
                    AccsLogger.enable(true);
                    int i13 = i10;
                    if (i13 == 0) {
                        AccsLogger.setLevel(LogLevel.WARN);
                        i11 = 3;
                    } else {
                        if (i13 == 1) {
                            AccsLogger.setLevel(LogLevel.INFO);
                            ALog.setLevel(2);
                            return;
                        }
                        AccsLogger.setLevel(LogLevel.DEBUG);
                    }
                }
                ALog.setLevel(i11);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setNotificationLargeIcon(final Bitmap bitmap) {
        a("setNotificationLargeIcon", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.9
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.a(bitmap);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setNotificationShowInGroup(boolean z10) {
        this.f٦٤٨٨g = z10;
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setNotificationSmallIcon(final int i10) {
        a("setNotificationSmallIcon", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.10
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.a(i10);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setNotificationSoundFilePath(final String str) {
        a("setNotificationSoundFilePath", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.8
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.a(str);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void setPushIntentService(final Class cls) {
        a("setPushIntentService", (CommonCallback) null, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.20
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.a(cls);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void turnOffPushChannel(final CommonCallback commonCallback) {
        a("turnOffPushChannel", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.16
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.d(commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void turnOnPushChannel(final CommonCallback commonCallback) {
        a("turnOnPushChannel", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.15
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.e(commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void unbindAccount(final CommonCallback commonCallback) {
        a("unbindAccount", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.27
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.a(commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void unbindPhoneNumber(final CommonCallback commonCallback) {
        a("unbindPhoneNumber", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.22
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.c(commonCallback);
            }
        });
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void unbindTag(final int i10, final String[] strArr, final String str, final CommonCallback commonCallback) {
        a("unBindTag", commonCallback, new Runnable() { // from class: com.alibaba.sdk.android.push.b.b.29
            @Override // java.lang.Runnable
            public void run() {
                b.this.f٦٤٨٣b.b(i10, strArr, str, commonCallback);
            }
        });
    }

    public static b a() {
        return f٦٤٨٢a;
    }

    @Override // com.alibaba.sdk.android.push.CloudPushService
    public void register(Context context, String str, String str2, CommonCallback commonCallback) {
        if (commonCallback != null) {
            ErrorCode build = com.alibaba.sdk.android.push.common.a.d.f٦٦١٠v.copy().msg("请使用PushServiceFactory.init(Context appContext, String appKey, String appSecret)动态设置appKey appSecret").build();
            commonCallback.onFailed(build.getCode(), build.getMsg());
        }
    }

    public void a(Context context) {
        AmsLogger.getImportantLogger().i("Initialize Mobile Push service...");
        this.f٦٤٨٤c = context;
        if (this.f٦٤٨٣b == null) {
            this.f٦٤٨٣b = new a(context);
        }
        if (this.f٦٤٨٦e) {
            CrashDefendApi.registerCrashDefendSdk(context, "push", "3.8.6.1", 10, 5, new CrashDefendCallback() { // from class: com.alibaba.sdk.android.push.b.b.1
                @Override // com.alibaba.sdk.android.crashdefend.CrashDefendCallback
                public void onSdkClosed(int i10) {
                    AmsLogger.getImportantLogger().e("crash limit exceeds, close forever");
                    b.this.f٦٤٨٥d = false;
                }

                @Override // com.alibaba.sdk.android.crashdefend.CrashDefendCallback
                public void onSdkStart(int i10, int i11, int i12) {
                    b.this.f٦٤٨٥d = true;
                }

                @Override // com.alibaba.sdk.android.crashdefend.CrashDefendCallback
                public void onSdkStop(int i10, int i11, int i12, long j10) {
                    AmsLogger.getImportantLogger().e("crash limit exceeds");
                    b.this.f٦٤٨٥d = false;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(final Context context, final CommonCallback commonCallback) {
        AmsLogger.getImportantLogger().i("call register");
        com.alibaba.sdk.android.push.g.a.a().a(new CommonCallback() { // from class: com.alibaba.sdk.android.push.b.b.23
            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onFailed(String str, String str2) {
                commonCallback.onFailed(str, str2);
            }

            @Override // com.alibaba.sdk.android.push.CommonCallback
            public void onSuccess(String str) {
                commonCallback.onSuccess(str);
                b.this.f٦٤٨٣b.b(context);
            }
        });
        com.alibaba.sdk.android.push.d.a.a(context).a(com.alibaba.sdk.android.ams.common.b.c.a().a());
        d();
        a(context, com.alibaba.sdk.android.ams.common.b.c.a().a(), com.alibaba.sdk.android.ams.common.b.c.a().d());
    }

    private synchronized void a(Context context, String str, String str2) {
        com.alibaba.sdk.android.push.a.a.a().a(context, str, str2, "3.8.6.1");
        com.alibaba.sdk.android.push.a.a.a().a(new com.alibaba.sdk.android.push.a.b() { // from class: com.alibaba.sdk.android.push.b.b.25
            @Override // com.alibaba.sdk.android.push.a.b
            public void a(boolean z10) {
                com.alibaba.sdk.android.push.d.a.a().a(z10);
            }
        });
    }

    private boolean a(String str, CommonCallback commonCallback, Runnable runnable) {
        if (this.f٦٤٨٤c == null) {
            AmsLogger.getImportantLogger().e("please call PushServiceFactory.init first");
            if (commonCallback != null) {
                ErrorCode build = com.alibaba.sdk.android.push.common.a.d.f٦٦٠٩u.copy().detail(str).build();
                commonCallback.onFailed(build.getCode(), build.getMsg());
            }
            return false;
        }
        e();
        if (this.f٦٤٨٥d) {
            if (runnable == null) {
                return true;
            }
            runnable.run();
            return true;
        }
        AmsLogger.getImportantLogger().e("push disabled");
        if (commonCallback != null) {
            ErrorCode build2 = com.alibaba.sdk.android.push.common.a.d.f٦٦٠٨t.copy().detail(str).build();
            commonCallback.onFailed(build2.getCode(), build2.getMsg());
        }
        return false;
    }
}
