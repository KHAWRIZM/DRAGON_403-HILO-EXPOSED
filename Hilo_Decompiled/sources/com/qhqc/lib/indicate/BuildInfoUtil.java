package com.qhqc.lib.indicate;

import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Lcom/qhqc/lib/indicate/BuildInfoUtil;", "", "<init>", "()V", "getBuildInfo", "", "getBuildInfoVariable", "lib_deviceIndicate_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class BuildInfoUtil {

    @NotNull
    public static final BuildInfoUtil INSTANCE = new BuildInfoUtil();

    private BuildInfoUtil() {
    }

    @NotNull
    public final String getBuildInfo() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("brand," + Build.BRAND);
        stringBuffer.append("/product," + Build.PRODUCT);
        stringBuffer.append("/device," + Build.DEVICE);
        stringBuffer.append("/id," + Build.ID);
        stringBuffer.append("/incremental," + Build.VERSION.INCREMENTAL);
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
        return stringBuffer2;
    }

    @NotNull
    public final String getBuildInfoVariable() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("model," + Build.MODEL);
        stringBuffer.append("/android_version," + Build.VERSION.RELEASE);
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
        return stringBuffer2;
    }
}
