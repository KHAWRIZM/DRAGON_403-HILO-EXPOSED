package com.qiahao.nextvideo.ui.reusable.views.squareprogressbar;

import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tech.sud.gip.core.view.round.RoundedDrawable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/squareprogressbar/PercentStyle;", "", "align", "Landroid/graphics/Paint$Align;", "textSize", "", "percentSign", "", "<init>", "(Landroid/graphics/Paint$Align;FZ)V", "getAlign", "()Landroid/graphics/Paint$Align;", "setAlign", "(Landroid/graphics/Paint$Align;)V", "getTextSize", "()F", "setTextSize", "(F)V", "isPercentSign", "()Z", "setPercentSign", "(Z)V", "customText", "", "getCustomText", "()Ljava/lang/String;", "setCustomText", "(Ljava/lang/String;)V", "textColor", "", "getTextColor", "()I", "setTextColor", "(I)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PercentStyle {

    @NotNull
    private Paint.Align align;

    @NotNull
    private String customText;
    private boolean isPercentSign;
    private int textColor;
    private float textSize;

    public PercentStyle(@NotNull Paint.Align align, float f, boolean z) {
        Intrinsics.checkNotNullParameter(align, "align");
        this.align = align;
        this.textSize = f;
        this.isPercentSign = z;
        this.customText = "%";
        this.textColor = RoundedDrawable.DEFAULT_BORDER_COLOR;
    }

    @NotNull
    public final Paint.Align getAlign() {
        return this.align;
    }

    @NotNull
    public final String getCustomText() {
        return this.customText;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    /* renamed from: isPercentSign, reason: from getter */
    public final boolean getIsPercentSign() {
        return this.isPercentSign;
    }

    public final void setAlign(@NotNull Paint.Align align) {
        Intrinsics.checkNotNullParameter(align, "<set-?>");
        this.align = align;
    }

    public final void setCustomText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.customText = str;
    }

    public final void setPercentSign(boolean z) {
        this.isPercentSign = z;
    }

    public final void setTextColor(int i) {
        this.textColor = i;
    }

    public final void setTextSize(float f) {
        this.textSize = f;
    }
}
