package com.qiahao.nextvideo.utilities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/utilities/SystemPermissionDenied;", "Ljava/lang/SecurityException;", "permission", "", "<init>", "(Ljava/lang/String;)V", "getPermission", "()Ljava/lang/String;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SystemPermissionDenied extends SecurityException {

    @NotNull
    private final String permission;

    public SystemPermissionDenied(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "permission");
        this.permission = str;
    }

    @NotNull
    public final String getPermission() {
        return this.permission;
    }
}
