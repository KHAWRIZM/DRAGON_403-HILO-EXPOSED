package com.qiahao.nextvideo.utilities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/utilities/SystemPermissionsDenied;", "Ljava/lang/SecurityException;", "permissions", "", "", "<init>", "([Ljava/lang/String;)V", "getPermissions", "()[Ljava/lang/String;", "[Ljava/lang/String;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SystemPermissionsDenied extends SecurityException {

    @NotNull
    private final String[] permissions;

    public SystemPermissionsDenied(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        this.permissions = strArr;
    }

    @NotNull
    public final String[] getPermissions() {
        return this.permissions;
    }
}
