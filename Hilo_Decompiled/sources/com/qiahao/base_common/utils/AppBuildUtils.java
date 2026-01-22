package com.qiahao.base_common.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0012\u001a\u00020\u00132\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0015\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000bR\u0011\u0010\u0016\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000bR\u0011\u0010\u0017\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u0011\u0010\u0018\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000bR\u0011\u0010\u0019\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/qiahao/base_common/utils/AppBuildUtils;", "", "<init>", "()V", "FLAVOR_OFFICIAL", "", "FLAVOR_GOOGLE", "FLAVOR_HUAWEI", "DEBUG", "", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "FLAVOR", "flavor", "getFlavor", "()Ljava/lang/String;", "init", "", "debug", "isTest", "isTestOrDebug", "isGoogle", "isHuawei", "isRelease", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class AppBuildUtils {

    @NotNull
    private static final String FLAVOR_GOOGLE = "google";

    @NotNull
    private static final String FLAVOR_HUAWEI = "huawei";

    @NotNull
    private static final String FLAVOR_OFFICIAL = "official";

    @NotNull
    public static final AppBuildUtils INSTANCE = new AppBuildUtils();
    private static boolean DEBUG = true;

    @Nullable
    private static String FLAVOR = "";

    private AppBuildUtils() {
    }

    public final boolean getDEBUG() {
        return DEBUG;
    }

    @Nullable
    public final String getFlavor() {
        String str = FLAVOR;
        if (str == null) {
            return "";
        }
        return str;
    }

    public final void init(@Nullable String flavor, boolean debug) {
        FLAVOR = flavor;
        DEBUG = debug;
    }

    public final boolean isGoogle() {
        return Intrinsics.areEqual(FLAVOR, FLAVOR_GOOGLE);
    }

    public final boolean isHuawei() {
        return Intrinsics.areEqual(FLAVOR, FLAVOR_HUAWEI);
    }

    public final boolean isRelease() {
        return !isTest();
    }

    public final boolean isTest() {
        return Intrinsics.areEqual(FLAVOR, FLAVOR_OFFICIAL);
    }

    public final boolean isTestOrDebug() {
        if (!isTest() && !DEBUG) {
            return false;
        }
        return true;
    }

    public final void setDEBUG(boolean z10) {
        DEBUG = z10;
    }
}
