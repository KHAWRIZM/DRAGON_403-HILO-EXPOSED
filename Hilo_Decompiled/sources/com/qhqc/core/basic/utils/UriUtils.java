package com.qhqc.core.basic.utils;

import android.net.Uri;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¨\u0006\t"}, d2 = {"Lcom/qhqc/core/basic/utils/UriUtils;", "", "()V", "getParamInUri", "", "str", TransferTable.COLUMN_KEY, "parseValidUri", "Landroid/net/Uri;", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class UriUtils {

    @NotNull
    public static final UriUtils INSTANCE = new UriUtils();

    private UriUtils() {
    }

    @Nullable
    public final String getParamInUri(@Nullable String str, @NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Uri parse = Uri.parse(str);
            if (parse.getBooleanQueryParameter(key, false)) {
                return parse.getQueryParameter(key);
            }
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Nullable
    public final Uri parseValidUri(@Nullable String str) {
        try {
            Uri parse = Uri.parse(str);
            if (!parse.isAbsolute()) {
                return null;
            }
            if (!parse.isHierarchical()) {
                return null;
            }
            return parse;
        } catch (Exception unused) {
            return null;
        }
    }
}
