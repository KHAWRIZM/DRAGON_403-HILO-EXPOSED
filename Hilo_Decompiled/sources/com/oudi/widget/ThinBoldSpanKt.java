package com.oudi.widget;

import android.text.SpannableString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toThinBoldSpannable", "Landroid/text/SpannableString;", "", "lib_widget_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ThinBoldSpanKt {
    @NotNull
    public static final SpannableString toThinBoldSpannable(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ThinBoldSpan(), 0, charSequence.length(), 17);
        return spannableString;
    }
}
