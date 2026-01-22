package com.skydoves.balloon;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u001a\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000¢\u0006\u0002\u0010\b\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"LTR", "", "NO_Float_VALUE", "", "NO_INT_VALUE", "NO_LONG_VALUE", "", "takeIfNotNoIntValue", "(I)Ljava/lang/Integer;", "unaryMinus", "predicate", "", "balloon_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class DefinitionKt {
    public static final int LTR = 1;
    public static final float NO_Float_VALUE = 0.0f;
    public static final int NO_INT_VALUE = Integer.MIN_VALUE;
    public static final long NO_LONG_VALUE = -1;

    @Nullable
    public static final Integer takeIfNotNoIntValue(int i) {
        Integer valueOf = Integer.valueOf(i);
        if (i == Integer.MIN_VALUE) {
            return null;
        }
        return valueOf;
    }

    public static final int unaryMinus(int i, boolean z) {
        return z ? -i : i;
    }
}
