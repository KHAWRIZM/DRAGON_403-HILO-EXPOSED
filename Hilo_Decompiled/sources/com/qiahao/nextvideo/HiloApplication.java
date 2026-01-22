package com.qiahao.nextvideo;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.net.LocalServerSocket;
import android.net.http.HttpResponseCache;
import android.os.Build;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.multidex.MultiDex;
import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory;
import com.alibaba.sdk.android.push.register.GcmRegister;
import com.alibaba.sdk.android.push.register.OppoRegister;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.RemoteConfigKt;
import com.opensource.svgaplayer.SVGAParser;
import com.oudi.core.support.ActivityLifecycleManager;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qhqc.core.basic.net.exception.ApiErrorException;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.router.provider.IApiExceptionHandler;
import com.qhqc.core.basic.router.provider.IToast;
import com.qiahao.base_common.AllModuleServiceManager;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.network.CommunityServerInfo;
import com.qiahao.base_common.network.ServerConfigureKt;
import com.qiahao.base_common.room.dataBase.AppDataBase;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.AppBuildUtils;
import com.qiahao.base_common.utils.language.LanguageHelper;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.service.AliCloudService;
import com.qiahao.nextvideo.data.service.OutPutOtherModuleService;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qiahao.nextvideo.utilities.XLogInitUtil;
import com.qiahao.nextvideo.utilities.alicloud.push.AliCloudPushServiceRegisterCommonCallback;
import com.qiahao.nextvideo.utilities.firebase.CockroachHandler;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.taobao.accs.utl.BaseMonitor;
import com.tencent.mmkv.MMKV;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.therouter.TheRouter;
import com.wanjian.cockroach.Cockroach;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\b\u0010\u0012\u001a\u00020\u000bH\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u000bH\u0003J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/qiahao/nextvideo/HiloApplication;", "Lcom/qiahao/base_common/BaseApplication;", "<init>", "()V", "mLocalServerSocket", "Landroid/net/LocalServerSocket;", "getMLocalServerSocket", "()Landroid/net/LocalServerSocket;", "setMLocalServerSocket", "(Landroid/net/LocalServerSocket;)V", "attachBaseContext", "", "base", "Landroid/content/Context;", "onCreate", "initCommunityParam", "strictMode", "updateFireBaseServer", "getSimOperator", "checkByCreateLocalServerSocket", "", "uniqueMsg", "", "initChannel", "isMainProcess", "getProcessName", "pid", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHiloApplication.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HiloApplication.kt\ncom/qiahao/nextvideo/HiloApplication\n+ 2 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,356:1\n106#2:357\n78#2,22:358\n*S KotlinDebug\n*F\n+ 1 HiloApplication.kt\ncom/qiahao/nextvideo/HiloApplication\n*L\n342#1:357\n342#1:358,22\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloApplication extends BaseApplication {
    public static Context CONTEXT;
    private static boolean mainActivityInited;

    @Nullable
    private volatile LocalServerSocket mLocalServerSocket;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static int isRestartFlag = -1;
    private static int isDailyOneRequest = -1;

    @NotNull
    private static final LifecycleOwner appLifecycleScope = ProcessLifecycleOwner.Companion.get();

    @NotNull
    private static String simOperator = "";

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/qiahao/nextvideo/HiloApplication$Companion;", "", "<init>", "()V", "CONTEXT", "Landroid/content/Context;", "getCONTEXT", "()Landroid/content/Context;", "setCONTEXT", "(Landroid/content/Context;)V", "isRestartFlag", "", "()I", "setRestartFlag", "(I)V", "isDailyOneRequest", "setDailyOneRequest", "appLifecycleScope", "Landroidx/lifecycle/LifecycleOwner;", "getAppLifecycleScope", "()Landroidx/lifecycle/LifecycleOwner;", "simOperator", "", "getSimOperator", "()Ljava/lang/String;", "setSimOperator", "(Ljava/lang/String;)V", "mainActivityInited", "", "getMainActivityInited", "()Z", "setMainActivityInited", "(Z)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final LifecycleOwner getAppLifecycleScope() {
            return HiloApplication.appLifecycleScope;
        }

        @NotNull
        public final Context getCONTEXT() {
            Context context = HiloApplication.CONTEXT;
            if (context != null) {
                return context;
            }
            Intrinsics.throwUninitializedPropertyAccessException("CONTEXT");
            return null;
        }

        public final boolean getMainActivityInited() {
            return HiloApplication.mainActivityInited;
        }

        @NotNull
        public final String getSimOperator() {
            return HiloApplication.simOperator;
        }

        public final int isDailyOneRequest() {
            return HiloApplication.isDailyOneRequest;
        }

        public final int isRestartFlag() {
            return HiloApplication.isRestartFlag;
        }

        public final void setCONTEXT(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "<set-?>");
            HiloApplication.CONTEXT = context;
        }

        public final void setDailyOneRequest(int i) {
            HiloApplication.isDailyOneRequest = i;
        }

        public final void setMainActivityInited(boolean z) {
            HiloApplication.mainActivityInited = z;
        }

        public final void setRestartFlag(int i) {
            HiloApplication.isRestartFlag = i;
        }

        public final void setSimOperator(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            HiloApplication.simOperator = str;
        }

        private Companion() {
        }
    }

    static {
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new vc.c() { // from class: com.qiahao.nextvideo.f
            @Override // vc.c
            public final tc.d a(Context context, tc.f fVar) {
                tc.d _init_$lambda$7;
                _init_$lambda$7 = HiloApplication._init_$lambda$7(context, fVar);
                return _init_$lambda$7;
            }
        });
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new vc.b() { // from class: com.qiahao.nextvideo.g
            @Override // vc.b
            public final tc.c a(Context context, tc.f fVar) {
                tc.c _init_$lambda$8;
                _init_$lambda$8 = HiloApplication._init_$lambda$8(context, fVar);
                return _init_$lambda$8;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tc.d _init_$lambda$7(Context context, tc.f fVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fVar, "layout");
        fVar.setDisableContentWhenRefresh(true);
        fVar.setHeaderInsetStart(0.0f);
        fVar.setEnableNestedScroll(true);
        fVar.setHeaderTriggerRate(1.0f);
        MaterialHeader materialHeader = new MaterialHeader(context);
        materialHeader.b(2131099914);
        return materialHeader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final tc.c _init_$lambda$8(Context context, tc.f fVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fVar, "layout");
        return new FootLoading(context);
    }

    private final boolean checkByCreateLocalServerSocket(String uniqueMsg) {
        if (this.mLocalServerSocket != null) {
            return false;
        }
        try {
            this.mLocalServerSocket = new LocalServerSocket(uniqueMsg);
            return false;
        } catch (Exception unused) {
            System.exit(0);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        }
    }

    private final String getProcessName(int pid) {
        BufferedReader bufferedReader;
        int i;
        boolean z;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            Intrinsics.checkNotNullExpressionValue(readLine, "readLine(...)");
            if (!TextUtils.isEmpty(readLine)) {
                int length = readLine.length() - 1;
                int i2 = 0;
                boolean z2 = false;
                while (i2 <= length) {
                    if (!z2) {
                        i = i2;
                    } else {
                        i = length;
                    }
                    if (Intrinsics.compare(readLine.charAt(i), 32) <= 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z2) {
                        if (!z) {
                            z2 = true;
                        } else {
                            i2++;
                        }
                    } else {
                        if (!z) {
                            break;
                        }
                        length--;
                    }
                }
                readLine = readLine.subSequence(i2, length + 1).toString();
            }
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return readLine;
        } catch (Throwable th2) {
            th = th2;
            try {
                th.printStackTrace();
                return null;
            } finally {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"WrongConstant"})
    private final void getSimOperator() {
        TelephonyManager telephonyManager;
        String str;
        Object systemService = getSystemService("phone");
        if (systemService instanceof TelephonyManager) {
            telephonyManager = (TelephonyManager) systemService;
        } else {
            telephonyManager = null;
        }
        if (telephonyManager == null || (str = telephonyManager.getSimOperator()) == null) {
            str = "";
        }
        setSimOperator(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"WrongConstant"})
    private final void initChannel() {
        if (Build.VERSION.SDK_INT >= 26) {
            Object systemService = getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationChannel a = com.google.android.gms.common.e.a(MessageService.MSG_DB_NOTIFY_REACHED, "notification channel", 4);
            a.setDescription("notification description");
            a.enableLights(true);
            na.a.a(a, -65536);
            a.enableVibration(true);
            a.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            com.google.android.gms.common.b.a((NotificationManager) systemService, a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initCommunityParam() {
        String baseUrl;
        BasicModuleApp basicModuleApp = BasicModuleApp.INSTANCE;
        basicModuleApp.init(this, "hilo");
        basicModuleApp.setDEBUG(false);
        basicModuleApp.registerApiExceptionHandler(new IApiExceptionHandler() { // from class: com.qiahao.nextvideo.HiloApplication$initCommunityParam$1$1
            public void handleException(ApiErrorException e) {
                Intrinsics.checkNotNullParameter(e, "e");
                Log.e("apiError", e.getCode() + " : " + e.getMsg() + " : " + e.getErrorData());
            }
        });
        basicModuleApp.registerToastImpl(new IToast() { // from class: com.qiahao.nextvideo.HiloApplication$initCommunityParam$1$2
            public void showToast(CharSequence text) {
                Intrinsics.checkNotNullParameter(text, "text");
                Toast.makeText(HiloApplication.this.getApplicationContext(), text, 0).show();
            }

            public void showToast(Context context, CharSequence text, int duration) {
                Intrinsics.checkNotNullParameter(context, "context");
                Toast.makeText(context, text, duration).show();
            }

            public void showToast(Context context, CharSequence text) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(text, "text");
                Toast.makeText(context, text, 0).show();
            }
        });
        CommunityServerInfo communityServerInfo = (CommunityServerInfo) ServerConfigureKt.getCommunityServers().get("communityServer");
        if (communityServerInfo != null && (baseUrl = communityServerInfo.getBaseUrl()) != null) {
            Log.e("communityUrl11", baseUrl);
            BaseControlUtils.INSTANCE.changeCommunityServer(baseUrl);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean isMainProcess() {
        return Intrinsics.areEqual(getPackageName(), getProcessName(Process.myPid()));
    }

    private final void strictMode() {
    }

    private final void updateFireBaseServer() {
        Firebase firebase = Firebase.INSTANCE;
        RemoteConfigKt.getRemoteConfig(firebase).fetchAndActivate().addOnCompleteListener(new OnCompleteListener() { // from class: com.qiahao.nextvideo.e
            public final void onComplete(Task task) {
                HiloApplication.updateFireBaseServer$lambda$4(task);
            }
        });
        RemoteConfigKt.getRemoteConfig(firebase).addOnConfigUpdateListener(new ConfigUpdateListener() { // from class: com.qiahao.nextvideo.HiloApplication$updateFireBaseServer$2
            public void onError(FirebaseRemoteConfigException error) {
                Intrinsics.checkNotNullParameter(error, BaseMonitor.COUNT_ERROR);
            }

            public void onUpdate(ConfigUpdate configUpdate) {
                Intrinsics.checkNotNullParameter(configUpdate, "configUpdate");
                if (configUpdate.getUpdatedKeys().contains("appConfig")) {
                    String string = RemoteConfigKt.getRemoteConfig(Firebase.INSTANCE).getString("appConfig");
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "firebase_base_url", string, (String) null, 4, (Object) null);
                    ServerConfigureKt.updateServer(string);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateFireBaseServer$lambda$4(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isSuccessful()) {
            String string = RemoteConfigKt.getRemoteConfig(Firebase.INSTANCE).getString("appConfig");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "firebase_base_url", string, (String) null, 4, (Object) null);
        }
    }

    protected void attachBaseContext(@Nullable Context base) {
        super.attachBaseContext(base);
    }

    @Nullable
    public final LocalServerSocket getMLocalServerSocket() {
        return this.mLocalServerSocket;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate() {
        MultiDex.install(this);
        TheRouter.init(getApplicationContext(), false);
        super.onCreate();
        INSTANCE.setCONTEXT(getApplicationContext());
        AppBuildUtils.INSTANCE.init("google", false);
        if (checkByCreateLocalServerSocket("com.qiahao.nextvideo_only")) {
            return;
        }
        if (isMainProcess()) {
            AppDataBase.Companion companion = AppDataBase.Companion;
            Context applicationContext = getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            companion.getDatabase(applicationContext);
            registerActivityLifecycleCallbacks(ActivityLifecycleManager.INSTANCE);
            XLogInitUtil.INSTANCE.initXLogInit();
            Cockroach.install(this, new CockroachHandler());
            ie.a.A((pd.g) null);
            updateFireBaseServer();
            AppRequestUtils.INSTANCE.serviceDeviceID(this, LifecycleOwnerKt.getLifecycleScope(appLifecycleScope));
            LanguageHelper.INSTANCE.wrapContext(getApplicationContext());
            AllModuleServiceManager.Companion.get().setAppService(new OutPutOtherModuleService());
            TUIChatService.getInstance().init(this);
            SVGAParser.Companion.shareParser().init(this);
            Unit unit = Unit.INSTANCE;
            HttpResponseCache.install(new File(getApplicationContext().getCacheDir(), "http"), 524288000L);
            AliCloudService.INSTANCE.init();
            FirebaseApp.initializeApp(this);
            FirebaseMessaging.getInstance().setAutoInitEnabled(true);
            FirebaseMessaging.getInstance().subscribeToTopic("firebaseAndroid");
            getSimOperator();
            try {
                MMKV.initialize(getApplicationContext());
            } catch (Exception e) {
                FirebaseCrashlytics.getInstance().recordException(e);
            }
        }
        PushServiceFactory.init(this);
        Unit unit2 = Unit.INSTANCE;
        PushServiceFactory.getCloudPushService().register(this, new AliCloudPushServiceRegisterCommonCallback());
        OppoRegister.register(this, getString(2131953590), getString(2131953591));
        GcmRegister.register(this, ResourcesKtxKt.getStringById(this, 2131952859), ResourcesKtxKt.getStringById(this, 2131952855), ResourcesKtxKt.getStringById(this, 2131952858), ResourcesKtxKt.getStringById(this, 2131952856));
        initChannel();
        initCommunityParam();
    }

    public final void setMLocalServerSocket(@Nullable LocalServerSocket localServerSocket) {
        this.mLocalServerSocket = localServerSocket;
    }
}
