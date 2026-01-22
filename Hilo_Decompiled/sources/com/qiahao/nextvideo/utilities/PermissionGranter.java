package com.qiahao.nextvideo.utilities;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J;\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u001e\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\bH&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/utilities/PermissionGranter;", "", "requestPermission", "", "permissions", "", "", "resultHandler", "Lkotlin/Function2;", "", "([Ljava/lang/String;Lkotlin/jvm/functions/Function2;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public interface PermissionGranter {
    void requestPermission(@NotNull String[] permissions, @NotNull Function2<? super String[], ? super int[], Unit> resultHandler);
}
