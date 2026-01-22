package com.qhqc.core.basic.ktx;

import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0012\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a+\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u0001*\u0002H\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\r\u001a\u0012\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0003¨\u0006\u0010"}, d2 = {"setStyleColor", "Landroid/text/SpannableString;", "color", "", "setStyleSize", "dimens", "", "setStyleTargetTextSpan", "T", "what", "", "targetText", "", "(Landroid/text/SpannableString;Ljava/lang/Object;Ljava/lang/String;)Landroid/text/SpannableString;", "setStyleTypeface", "style", "basic_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SpannableStringKtxKt {
    @NotNull
    public static final SpannableString setStyleColor(@NotNull SpannableString spannableString, int i10) {
        Intrinsics.checkNotNullParameter(spannableString, "<this>");
        spannableString.setSpan(new ForegroundColorSpan(i10), 0, spannableString.length(), 33);
        return spannableString;
    }

    @NotNull
    public static final SpannableString setStyleSize(@NotNull SpannableString spannableString, float f10) {
        Intrinsics.checkNotNullParameter(spannableString, "<this>");
        spannableString.setSpan(new AbsoluteSizeSpan(DisplayKtxKt.getSp(f10)), 0, spannableString.length(), 33);
        return spannableString;
    }

    @NotNull
    public static final <T extends SpannableString> T setStyleTargetTextSpan(@NotNull T t10, @NotNull Object what, @Nullable String str) {
        Intrinsics.checkNotNullParameter(t10, "<this>");
        Intrinsics.checkNotNullParameter(what, "what");
        if (str != null && str.length() != 0) {
            if (t10.length() == 0) {
                return t10;
            }
            int indexOf$default = StringsKt.indexOf$default((CharSequence) t10, str, 0, false, 6, (Object) null);
            int length = str.length() + indexOf$default;
            if (indexOf$default >= 0 && length <= t10.length()) {
                t10.setSpan(what, indexOf$default, length, 33);
            }
        }
        return t10;
    }

    @NotNull
    public static final SpannableString setStyleTypeface(@NotNull SpannableString spannableString, int i10) {
        Intrinsics.checkNotNullParameter(spannableString, "<this>");
        spannableString.setSpan(new StyleSpan(i10), 0, spannableString.length(), 33);
        return spannableString;
    }
}
