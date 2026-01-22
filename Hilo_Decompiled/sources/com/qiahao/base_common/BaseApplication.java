package com.qiahao.base_common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import androidx.multidex.MultiDexApplication;
import com.google.gson.d;
import com.liulishuo.okdownload.DownloadTask;
import com.therouter.TheRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u0017H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006!"}, d2 = {"Lcom/qiahao/base_common/BaseApplication;", "Landroidx/multidex/MultiDexApplication;", "<init>", "()V", "simOperator", "", "getSimOperator", "()Ljava/lang/String;", "setSimOperator", "(Ljava/lang/String;)V", "mStatusHeight", "", "getMStatusHeight", "()I", "setMStatusHeight", "(I)V", "mNavigationHeight", "getMNavigationHeight", "setMNavigationHeight", "onCreate", "", "attachBaseContext", "base", "Landroid/content/Context;", "getVersionName", "isEmulator", "", "isVPNConnected", "checkStatusAndNavigationHeight", "getPackageInfo", "Landroid/content/pm/PackageInfo;", "context", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseApplication.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseApplication.kt\ncom/qiahao/base_common/BaseApplication\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,106:1\n12637#2,2:107\n*S KotlinDebug\n*F\n+ 1 BaseApplication.kt\ncom/qiahao/base_common/BaseApplication\n*L\n83#1:107,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class BaseApplication extends MultiDexApplication {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final d GSON = new d();

    @Nullable
    private static BaseApplication instance;
    private int mNavigationHeight;
    private int mStatusHeight;

    @NotNull
    private String simOperator = "";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/qiahao/base_common/BaseApplication$Companion;", "", "<init>", "()V", "Lcom/google/gson/d;", "GSON", "Lcom/google/gson/d;", "getGSON", "()Lcom/google/gson/d;", "Lcom/qiahao/base_common/BaseApplication;", "instance", "Lcom/qiahao/base_common/BaseApplication;", "getInstance", "()Lcom/qiahao/base_common/BaseApplication;", "setInstance", "(Lcom/qiahao/base_common/BaseApplication;)V", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final d getGSON() {
            return BaseApplication.GSON;
        }

        @Nullable
        public final BaseApplication getInstance() {
            return BaseApplication.instance;
        }

        public final void setInstance(@Nullable BaseApplication baseApplication) {
            BaseApplication.instance = baseApplication;
        }

        private Companion() {
        }
    }

    private final PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    public void attachBaseContext(@Nullable Context base) {
        TheRouter.setDebug(false);
        super.attachBaseContext(base);
    }

    public final boolean checkStatusAndNavigationHeight() {
        if (this.mStatusHeight > 0 && this.mNavigationHeight >= 0) {
            return true;
        }
        return false;
    }

    public final int getMNavigationHeight() {
        return this.mNavigationHeight;
    }

    public final int getMStatusHeight() {
        return this.mStatusHeight;
    }

    @NotNull
    public final String getSimOperator() {
        return this.simOperator;
    }

    @Nullable
    public final String getVersionName() {
        PackageInfo packageInfo = getPackageInfo(this);
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return "";
    }

    public final boolean isEmulator() {
        if (Build.VERSION.SDK_INT >= 26) {
            String FINGERPRINT = Build.FINGERPRINT;
            if (FINGERPRINT != null) {
                Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                if (StringsKt.startsWith$default(FINGERPRINT, "generic", false, 2, (Object) null)) {
                    return true;
                }
            }
            if (FINGERPRINT != null) {
                Intrinsics.checkNotNullExpressionValue(FINGERPRINT, "FINGERPRINT");
                if (StringsKt.startsWith$default(FINGERPRINT, "unknown", false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        }
        String FINGERPRINT2 = Build.FINGERPRINT;
        if (FINGERPRINT2 != null) {
            Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
            if (StringsKt.startsWith$default(FINGERPRINT2, "generic", false, 2, (Object) null)) {
                return true;
            }
        }
        if (FINGERPRINT2 != null) {
            Intrinsics.checkNotNullExpressionValue(FINGERPRINT2, "FINGERPRINT");
            if (StringsKt.startsWith$default(FINGERPRINT2, "unknown", false, 2, (Object) null)) {
                return true;
            }
        }
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        if (StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "google_sdk", false, 2, (Object) null)) {
            return true;
        }
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        if (StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "Emulator", false, 2, (Object) null)) {
            return true;
        }
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        if (StringsKt.contains$default((CharSequence) MODEL, (CharSequence) "Android SDK built for x86", false, 2, (Object) null)) {
            return true;
        }
        String MANUFACTURER = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
        if (StringsKt.contains$default((CharSequence) MANUFACTURER, (CharSequence) "Genymotion", false, 2, (Object) null)) {
            return true;
        }
        String BRAND = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(BRAND, "BRAND");
        if (StringsKt.startsWith$default(BRAND, "generic", false, 2, (Object) null)) {
            String DEVICE = Build.DEVICE;
            Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
            if (StringsKt.startsWith$default(DEVICE, "generic", false, 2, (Object) null)) {
                return true;
            }
        }
        if (Intrinsics.areEqual("google_sdk", Build.PRODUCT)) {
            return true;
        }
        String HARDWARE = Build.HARDWARE;
        Intrinsics.checkNotNullExpressionValue(HARDWARE, "HARDWARE");
        if (StringsKt.contains$default((CharSequence) HARDWARE, (CharSequence) "goldfish", false, 2, (Object) null)) {
            return true;
        }
        return false;
    }

    public final boolean isVPNConnected() {
        Object obj;
        Network activeNetwork;
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            obj = applicationContext.getSystemService("connectivity");
        } else {
            obj = null;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) obj;
        if (Build.VERSION.SDK_INT >= 23) {
            activeNetwork = connectivityManager.getActiveNetwork();
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
            if (networkCapabilities == null || !networkCapabilities.hasTransport(4)) {
                return false;
            }
        } else {
            Network[] allNetworks = connectivityManager.getAllNetworks();
            Intrinsics.checkNotNullExpressionValue(allNetworks, "getAllNetworks(...)");
            for (Network network : allNetworks) {
                NetworkCapabilities networkCapabilities2 = connectivityManager.getNetworkCapabilities(network);
                if (networkCapabilities2 == null || !networkCapabilities2.hasTransport(4)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public final void setMNavigationHeight(int i10) {
        this.mNavigationHeight = i10;
    }

    public final void setMStatusHeight(int i10) {
        this.mStatusHeight = i10;
    }

    public final void setSimOperator(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.simOperator = str;
    }
}
