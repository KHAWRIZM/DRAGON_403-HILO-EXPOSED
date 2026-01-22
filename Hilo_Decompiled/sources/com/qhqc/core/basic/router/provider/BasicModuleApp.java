package com.qhqc.core.basic.router.provider;

import android.app.Application;
import io.agora.rtc.Constants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u0004\u0018\u00010\fJ\b\u0010\u0015\u001a\u00020\u000eH\u0007J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0011J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011J\u0006\u0010 \u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/qhqc/core/basic/router/provider/BasicModuleApp;", "", "()V", "AWS3_BASE_URL", "", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "mApiExceptionHandlerImpl", "Lcom/qhqc/core/basic/router/provider/IApiExceptionHandler;", "mApplication", "Landroid/app/Application;", "mProjectName", "mToastImpl", "Lcom/qhqc/core/basic/router/provider/IToast;", "mUserAuth", "Lcom/qhqc/core/basic/router/provider/UserAuth;", "apiExceptionHandler", "application", "init", "", "projectName", "initUserAuth", "auth", "projectDirectory", "registerApiExceptionHandler", "impl", "registerToastImpl", "toastImpl", "userAuth", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BasicModuleApp {

    @NotNull
    public static final String AWS3_BASE_URL = "https://image.whoisamy.shop/";
    private static boolean DEBUG;

    @Nullable
    private static IApiExceptionHandler mApiExceptionHandlerImpl;
    private static Application mApplication;

    @Nullable
    private static IToast mToastImpl;

    @NotNull
    public static final BasicModuleApp INSTANCE = new BasicModuleApp();

    @NotNull
    private static String mProjectName = "Basic";

    @NotNull
    private static UserAuth mUserAuth = new UserAuth(0, null, null, null, null, null, null, Constants.ERR_WATERMARKR_INFO, null);

    private BasicModuleApp() {
    }

    @JvmStatic
    @NotNull
    public static final Application application() {
        Application application = mApplication;
        if (application == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mApplication");
            return null;
        }
        return application;
    }

    @Nullable
    public final IApiExceptionHandler apiExceptionHandler() {
        return mApiExceptionHandlerImpl;
    }

    public final boolean getDEBUG() {
        return DEBUG;
    }

    public final void init(@NotNull Application application, @NotNull String projectName) {
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(projectName, "projectName");
        mApplication = application;
        mProjectName = projectName;
    }

    public final void initUserAuth(@NotNull UserAuth auth) {
        Intrinsics.checkNotNullParameter(auth, "auth");
        mUserAuth = auth;
    }

    @NotNull
    public final String projectDirectory() {
        return mProjectName;
    }

    public final void registerApiExceptionHandler(@NotNull IApiExceptionHandler impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        mApiExceptionHandlerImpl = impl;
    }

    public final void registerToastImpl(@NotNull IToast impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        mToastImpl = impl;
    }

    public final void setDEBUG(boolean z10) {
        DEBUG = z10;
    }

    @Nullable
    public final IToast toastImpl() {
        return mToastImpl;
    }

    @NotNull
    public final UserAuth userAuth() {
        return mUserAuth;
    }
}
