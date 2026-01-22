package com.qiahao.base_common.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.R;
import com.qiahao.base_common.common.BaseActivity;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007J\u0010\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017J\u0006\u0010\u001d\u001a\u00020\u000fJ\u0006\u0010\u001e\u001a\u00020\u000fJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007J\u0016\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\u000fJ\u0012\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(J\u0012\u0010)\u001a\u0004\u0018\u00010*2\b\u0010'\u001a\u0004\u0018\u00010(J\u000e\u0010+\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010+\u001a\u00020\u000f2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010,\u001a\u00020 J\u0014\u0010-\u001a\u00020\u000f2\f\u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u00010/J\u001e\u0010-\u001a\u00020\u000f2\u0016\u0010.\u001a\u0012\u0012\u0002\b\u0003\u0018\u000100j\b\u0012\u0002\b\u0003\u0018\u0001`1J\u001c\u0010-\u001a\u00020\u000f2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0001\u0018\u000102J\u0014\u00103\u001a\u00020\u000f2\f\u0010.\u001a\b\u0012\u0002\b\u0003\u0018\u00010/J\u001a\u00104\u001a\u00020\t2\u0006\u00105\u001a\u0002062\b\b\u0001\u00107\u001a\u00020\u0017H\u0007J1\u00108\u001a\u0004\u0018\u0001H9\"\u0004\b\u0000\u001092\u0006\u0010'\u001a\u00020(2\u0006\u0010:\u001a\u00020 2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002H90<¢\u0006\u0002\u0010=J\u000e\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020@J\u000e\u0010A\u001a\u00020\t2\u0006\u0010?\u001a\u00020@J\u0010\u0010B\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(H\u0007J\u0010\u0010C\u001a\u00020\u00172\u0006\u0010'\u001a\u00020(H\u0007J\u000e\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u0017J\b\u0010F\u001a\u00020\u000fH\u0007J\u0010\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020\u0007H\u0007J\u0010\u0010I\u001a\u00020 2\u0006\u0010H\u001a\u00020\u0007H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006J"}, d2 = {"Lcom/qiahao/base_common/utils/HiloUtils;", "", "<init>", "()V", "handler", "Landroid/os/Handler;", "lastClickTime", "", "runInMainThread", "", "task", "Ljava/lang/Runnable;", "delayMillis", "removeTask", "isFinish", "", "activity", "Landroid/app/Activity;", "notFinish", "isShowing", "dialog", "Landroid/app/Dialog;", "getBackgroundAlpha", "", "scrollY", "allDistance", "rightToLeftDirection", "getRightToLeftDirection", "()Z", "isFastClick", "notFastClick", "formatActivityTime", "", "startTime", "entTime", "checkActivityStart", "isMainThread", "getActivity", "Lcom/qiahao/base_common/common/BaseActivity;", "context", "Landroid/content/Context;", "getActivity2", "Landroidx/appcompat/app/AppCompatActivity;", "isForeground", "className", "isEmpty", "list", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "", "notEmpty", "setImageMirror", ViewHierarchyConstants.VIEW_KEY, "Landroid/widget/ImageView;", "drawableRes", "analyticData", "T", "fileString", "cls", "Ljava/lang/Class;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "transparentStatusBar", "window", "Landroid/view/Window;", "transparentNavigationBar", "getStatusBarHeight", "getNavigationBarHeight", "checkVersion", ServerProtocol.FALLBACK_DIALOG_PARAM_VERSION, "isNetworkAvailable", "formatRemainingTime", "remainingMillis", "formatRemainingTime2", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class HiloUtils {

    @NotNull
    public static final HiloUtils INSTANCE = new HiloUtils();

    @NotNull
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static long lastClickTime;

    private HiloUtils() {
    }

    @JvmStatic
    public static final void setImageMirror(@NotNull ImageView view, int drawableRes) {
        Intrinsics.checkNotNullParameter(view, "view");
        Drawable drawable = androidx.core.content.a.getDrawable(view.getContext(), drawableRes);
        if (drawable != null) {
            drawable.setAutoMirrored(INSTANCE.getRightToLeftDirection());
        } else {
            drawable = null;
        }
        view.setImageDrawable(drawable);
    }

    @Nullable
    public final <T> T analyticData(@NotNull Context context, @NotNull String fileString, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileString, "fileString");
        Intrinsics.checkNotNullParameter(cls, "cls");
        try {
            InputStream open = context.getAssets().open(fileString);
            Intrinsics.checkNotNullExpressionValue(open, "open(...)");
            byte[] bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
            return (T) new com.google.gson.d().j(new String(bArr, forName), cls);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public final int checkActivityStart(long startTime, long entTime) {
        long e10 = f.e();
        if (startTime + 1 <= e10 && e10 < entTime) {
            return 1;
        }
        if (e10 > entTime) {
            return 2;
        }
        return 0;
    }

    public final boolean checkVersion(int version) {
        if (Build.VERSION.SDK_INT >= version) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String formatActivityTime(long startTime, long entTime) {
        long e10 = f.e();
        long longValue = f.b().longValue();
        long j10 = 86400000 + longValue;
        long longValue2 = f.b().longValue() + 172800000;
        if (entTime < e10) {
            String f10 = f.f(startTime, f.f١٢٥٧٩f);
            Intrinsics.checkNotNull(f10);
            return f10;
        }
        if (startTime + 1 <= e10 && e10 < entTime) {
            return ResourcesKtxKt.getStringById(this, R.string.activity_now_time);
        }
        if (e10 + 1 <= startTime && startTime < j10) {
            String format = String.format(ResourcesKtxKt.getStringById(this, R.string.activity_today), Arrays.copyOf(new Object[]{f.f(startTime, f.f١٢٥٧٦c)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return format;
        }
        if (longValue + 86400001 <= startTime && startTime < longValue2) {
            String format2 = String.format(ResourcesKtxKt.getStringById(this, R.string.activity_tomorrow), Arrays.copyOf(new Object[]{f.f(startTime, f.f١٢٥٧٦c)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            return format2;
        }
        String f11 = f.f(startTime, f.f١٢٥٧٩f);
        Intrinsics.checkNotNull(f11);
        return f11;
    }

    @SuppressLint({"DefaultLocale"})
    @NotNull
    public final String formatRemainingTime(long remainingMillis) {
        int i10;
        long j10 = remainingMillis / 1000;
        long j11 = 60;
        long j12 = j10 / j11;
        long j13 = j12 / j11;
        long j14 = 24;
        long j15 = j13 / j14;
        long j16 = j10 % j11;
        long j17 = j12 % j11;
        long j18 = j13 % j14;
        if (j15 > 0) {
            if (j15 == 1) {
                i10 = R.string.day4;
            } else {
                i10 = R.string.days;
            }
            String stringById = ResourcesKtxKt.getStringById(this, i10);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j18), Long.valueOf(j17), Long.valueOf(j16)}, 3));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return j15 + stringById + " " + format;
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j18), Long.valueOf(j17), Long.valueOf(j16)}, 3));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        return format2;
    }

    @SuppressLint({"DefaultLocale"})
    @NotNull
    public final String formatRemainingTime2(long remainingMillis) {
        long j10 = remainingMillis / 1000;
        long j11 = 60;
        long j12 = j10 / j11;
        long j13 = j12 / j11;
        long j14 = j10 % j11;
        long j15 = j12 % j11;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j13), Long.valueOf(j15), Long.valueOf(j14)}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    @Nullable
    public final BaseActivity getActivity(@Nullable Context context) {
        if (context != null) {
            if (context instanceof BaseActivity) {
                return (BaseActivity) context;
            }
            if (context instanceof ContextWrapper) {
                return getActivity(((ContextWrapper) context).getBaseContext());
            }
        }
        return null;
    }

    @Nullable
    public final AppCompatActivity getActivity2(@Nullable Context context) {
        if (context != null) {
            if (context instanceof AppCompatActivity) {
                return (AppCompatActivity) context;
            }
            if (context instanceof ContextWrapper) {
                return getActivity2(((ContextWrapper) context).getBaseContext());
            }
        }
        return null;
    }

    public final int getBackgroundAlpha(int scrollY, int allDistance) {
        if (scrollY > allDistance) {
            return KotlinVersion.MAX_COMPONENT_VALUE;
        }
        if (scrollY < 0) {
            return 0;
        }
        return (int) ((scrollY / allDistance) * KotlinVersion.MAX_COMPONENT_VALUE);
    }

    @SuppressLint({"DiscouragedApi"})
    public final int getNavigationBarHeight(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final boolean getRightToLeftDirection() {
        if (l2.q.a(Locale.getDefault()) == 1) {
            return true;
        }
        return false;
    }

    @SuppressLint({"DiscouragedApi"})
    public final int getStatusBarHeight(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final boolean isEmpty(@Nullable List<?> list) {
        return list == null || list.isEmpty();
    }

    public final synchronized boolean isFastClick() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastClickTime < 500) {
            return true;
        }
        lastClickTime = currentTimeMillis;
        return false;
    }

    @RequiresApi(17)
    public final boolean isFinish(@Nullable Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return false;
        }
        return true;
    }

    public final boolean isForeground(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        String name = activity.getClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return isForeground(activity, name);
    }

    public final boolean isMainThread() {
        return Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper());
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        r1 = r0.getActiveNetwork();
     */
    @SuppressLint({"WrongConstant"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isNetworkAvailable() {
        Object obj;
        ConnectivityManager connectivityManager;
        Network activeNetwork;
        NetworkCapabilities networkCapabilities;
        Context baseContext;
        BaseApplication companion = BaseApplication.INSTANCE.getInstance();
        NetworkInfo networkInfo = null;
        if (companion != null && (baseContext = companion.getBaseContext()) != null) {
            obj = baseContext.getSystemService("connectivity");
        } else {
            obj = null;
        }
        if (obj instanceof ConnectivityManager) {
            connectivityManager = (ConnectivityManager) obj;
        } else {
            connectivityManager = null;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (connectivityManager != null && activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16)) {
                return true;
            }
            return false;
        }
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public final boolean isShowing(@Nullable Dialog dialog) {
        if (dialog != null && dialog.isShowing()) {
            return true;
        }
        return false;
    }

    public final boolean notEmpty(@Nullable List<?> list) {
        if (list != null && !list.isEmpty()) {
            return true;
        }
        return false;
    }

    public final synchronized boolean notFastClick() {
        return !isFastClick();
    }

    @RequiresApi(17)
    public final boolean notFinish(@Nullable Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return true;
        }
        return false;
    }

    public final void removeTask(@NotNull Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        handler.removeCallbacks(task);
    }

    public final void runInMainThread(@NotNull Runnable task) {
        Intrinsics.checkNotNullParameter(task, "task");
        handler.post(task);
    }

    public final void transparentNavigationBar(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        if (Build.VERSION.SDK_INT >= 29) {
            window.setNavigationBarContrastEnforced(false);
        }
        window.clearFlags(134217728);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 512);
        window.setNavigationBarColor(0);
    }

    public final void transparentStatusBar(@NotNull Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1280);
        window.setStatusBarColor(0);
    }

    public final boolean isEmpty(@Nullable ArrayList<?> list) {
        return list == null || list.isEmpty();
    }

    public final boolean isForeground(@Nullable Context context, @NotNull String className) {
        ComponentName componentName;
        Intrinsics.checkNotNullParameter(className, "className");
        if (context != null || !TextUtils.isEmpty(className)) {
            Intrinsics.checkNotNull(context);
            Object systemService = context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) systemService).getRunningTasks(1);
            Intrinsics.checkNotNull(runningTasks);
            if (!runningTasks.isEmpty()) {
                componentName = runningTasks.get(0).topActivity;
                Intrinsics.checkNotNull(componentName);
                return Intrinsics.areEqual(className, componentName.getClassName());
            }
        }
        return false;
    }

    public final void runInMainThread(@NotNull Runnable task, long delayMillis) {
        Intrinsics.checkNotNullParameter(task, "task");
        handler.postDelayed(task, delayMillis);
    }

    public final boolean isEmpty(@Nullable Map<String, ? extends Object> list) {
        return list == null || list.isEmpty();
    }
}
