package com.oudi.widget;

import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/oudi/widget/ThinBoldSpan;", "Landroid/text/style/CharacterStyle;", "<init>", "()V", "updateDrawState", "", "tp", "Landroid/text/TextPaint;", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ThinBoldSpan extends CharacterStyle {
    @Override // android.text.style.CharacterStyle
    public void updateDrawState(@Nullable TextPaint tp) {
        if (tp != null) {
            tp.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        if (tp != null) {
            tp.setStrokeWidth(0.55f);
        }
    }
}
