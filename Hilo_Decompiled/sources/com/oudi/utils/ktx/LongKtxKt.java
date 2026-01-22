package com.oudi.utils.ktx;

import com.google.firebase.dynamiclinks.DynamicLink;
import com.oudi.utils.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0001¢\u0006\u0002\u0010\u0004\u001a(\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00012\b\b\u0002\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"toW", "", "", "placeholder", "(Ljava/lang/Long;Ljava/lang/String;)Ljava/lang/String;", "toK", "toShortCount", "threshold", DynamicLink.Builder.KEY_SUFFIX, "scale", "", "lib_utils_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class LongKtxKt {
    public static final String toK(Long l10, String placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        if (l10 != null && l10.longValue() != 0) {
            return StringUtils.INSTANCE.toShortCount(l10.longValue(), 999L, "k", 1);
        }
        return placeholder;
    }

    public static /* synthetic */ String toK$default(Long l10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "0";
        }
        return toK(l10, str);
    }

    public static final String toShortCount(long j10, long j11, String suffix, int i10) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        return StringUtils.INSTANCE.toShortCount(j10, j11, suffix, i10);
    }

    public static /* synthetic */ String toShortCount$default(long j10, long j11, String str, int i10, int i11, Object obj) {
        int i12;
        if ((i11 & 1) != 0) {
            j11 = 9999;
        }
        long j12 = j11;
        if ((i11 & 2) != 0) {
            str = "万";
        }
        String str2 = str;
        if ((i11 & 4) != 0) {
            i12 = 1;
        } else {
            i12 = i10;
        }
        return toShortCount(j10, j12, str2, i12);
    }

    public static final String toW(Long l10, String placeholder) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        if (l10 != null && l10.longValue() != 0) {
            return StringUtils.INSTANCE.toShortCount(l10.longValue(), 9999L, "w", 1);
        }
        return placeholder;
    }

    public static /* synthetic */ String toW$default(Long l10, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = "0";
        }
        return toW(l10, str);
    }
}
