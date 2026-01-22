package com.oudi.core.component.application;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.oudi.utils.AppUtils;
import com.oudi.utils.ClassInterfaceUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0015J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/oudi/core/component/application/SuperApplication;", "Landroid/app/Application;", "<init>", "()V", "ROOT_PACKAGE", "", "mAppDelegateList", "", "Lcom/oudi/core/component/application/IApplicationDelegate;", "onCreate", "", "onInitialize", "initApplicationDelegate", "isMainProcess", "", "context", "Landroid/content/Context;", "getProcessName", "pid", "", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSuperApplication.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperApplication.kt\ncom/oudi/core/component/application/SuperApplication\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Strings.kt\nkotlin/text/StringsKt__StringsKt\n*L\n1#1,102:1\n1863#2,2:103\n108#3:105\n80#3,22:106\n*S KotlinDebug\n*F\n+ 1 SuperApplication.kt\ncom/oudi/core/component/application/SuperApplication\n*L\n52#1:103,2\n86#1:105\n86#1:106,22\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class SuperApplication extends Application {

    @NotNull
    private final String ROOT_PACKAGE = "com.meiqijiacheng";

    @Nullable
    private List<? extends IApplicationDelegate> mAppDelegateList;

    private final String getProcessName(int pid) {
        BufferedReader bufferedReader;
        int i10;
        boolean z10;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (!TextUtils.isEmpty(readLine)) {
                Intrinsics.checkNotNull(readLine);
                int length = readLine.length() - 1;
                int i11 = 0;
                boolean z11 = false;
                while (i11 <= length) {
                    if (!z11) {
                        i10 = i11;
                    } else {
                        i10 = length;
                    }
                    if (Intrinsics.compare((int) readLine.charAt(i10), 32) <= 0) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z11) {
                        if (!z10) {
                            z11 = true;
                        } else {
                            i11++;
                        }
                    } else {
                        if (!z10) {
                            break;
                        }
                        length--;
                    }
                }
                readLine = readLine.subSequence(i11, length + 1).toString();
            }
            try {
                bufferedReader.close();
            } catch (IOException e10) {
                e10.printStackTrace();
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
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                }
            }
        }
    }

    private final void initApplicationDelegate() {
        List<? extends IApplicationDelegate> objectsWithInterface = ClassInterfaceUtils.getObjectsWithInterface(this, IApplicationDelegate.class, this.ROOT_PACKAGE);
        this.mAppDelegateList = objectsWithInterface;
        if (objectsWithInterface != null) {
            Iterator<T> it = objectsWithInterface.iterator();
            while (it.hasNext()) {
                ((IApplicationDelegate) it.next()).onCreate();
            }
        }
    }

    public boolean isMainProcess(@NotNull Context context) {
        ActivityManager activityManager;
        Intrinsics.checkNotNullParameter(context, "context");
        int myPid = Process.myPid();
        Object systemService = context.getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> list = null;
        if (systemService instanceof ActivityManager) {
            activityManager = (ActivityManager) systemService;
        } else {
            activityManager = null;
        }
        if (activityManager != null) {
            list = activityManager.getRunningAppProcesses();
        }
        if (list == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return Intrinsics.areEqual(context.getApplicationInfo().packageName, runningAppProcessInfo.processName);
            }
        }
        return false;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        AppUtils.init((Application) this);
        initApplicationDelegate();
        if (isMainProcess(this)) {
            onInitialize();
        }
    }

    public void onInitialize() {
    }
}
