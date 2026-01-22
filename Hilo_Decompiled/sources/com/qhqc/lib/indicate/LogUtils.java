package com.qhqc.lib.indicate;

import android.util.Log;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000bJ\u001a\u0010\u0010\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/qhqc/lib/indicate/LogUtils;", "", "<init>", "()V", "logEnable", "", "getLogEnable", "()Z", "setLogEnable", "(Z)V", "TAG", "", "d", "", "content", ViewHierarchyConstants.TAG_KEY, "e", "lib_deviceIndicate_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class LogUtils {

    @NotNull
    public static final LogUtils INSTANCE = new LogUtils();

    @NotNull
    private static final String TAG = "IndicateService";
    private static boolean logEnable;

    private LogUtils() {
    }

    public static /* synthetic */ void d$default(LogUtils logUtils, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = TAG;
        }
        logUtils.d(str, str2);
    }

    public static /* synthetic */ void e$default(LogUtils logUtils, String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = TAG;
        }
        logUtils.e(str, str2);
    }

    public final void d(@Nullable String content, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!logEnable) {
            return;
        }
        if (content == null) {
            content = "";
        }
        Log.d(tag, content);
    }

    public final void e(@Nullable String content, @NotNull String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (!logEnable) {
            return;
        }
        if (content == null) {
            content = "";
        }
        Log.e(tag, content);
    }

    public final boolean getLogEnable() {
        return logEnable;
    }

    public final void setLogEnable(boolean z10) {
        logEnable = z10;
    }
}
