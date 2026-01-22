package com.oudi.utils;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.style.ReplacementSpan;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ4\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010$H\u0016JR\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006."}, d2 = {"Lcom/oudi/utils/RoundBackgroundColorSpan;", "Landroid/text/style/ReplacementSpan;", "textColor", "", "textSize", "bgColor", "paddingHorizontal", "paddingVertical", "marginHorizontal", "round", "<init>", "(IIIIIII)V", "getTextColor", "()I", "setTextColor", "(I)V", "getTextSize", "setTextSize", "getBgColor", "setBgColor", "getPaddingHorizontal", "setPaddingHorizontal", "getPaddingVertical", "setPaddingVertical", "getMarginHorizontal", "setMarginHorizontal", "getRound", "setRound", "getSize", "paint", "Landroid/graphics/Paint;", ViewHierarchyConstants.TEXT_KEY, "", "start", "end", "fm", "Landroid/graphics/Paint$FontMetricsInt;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "x", "", ViewHierarchyConstants.DIMENSION_TOP_KEY, "y", "bottom", "lib_utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class RoundBackgroundColorSpan extends ReplacementSpan {
    private int bgColor;
    private int marginHorizontal;
    private int paddingHorizontal;
    private int paddingVertical;
    private int round;
    private int textColor;
    private int textSize;

    public RoundBackgroundColorSpan(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.textColor = i10;
        this.textSize = i11;
        this.bgColor = i12;
        this.paddingHorizontal = i13;
        this.paddingVertical = i14;
        this.marginHorizontal = i15;
        this.round = i16;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x10, int top, int y10, int bottom, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        paint.setColor(this.bgColor);
        RectF rectF = new RectF(x10 + this.marginHorizontal, top, paint.measureText(text, start, end) + x10 + this.paddingHorizontal, bottom);
        float f10 = this.round;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        paint.setColor(this.textColor);
        paint.setTextSize(this.textSize);
        canvas.drawText(String.valueOf(text), start, end, x10 + this.paddingHorizontal + this.marginHorizontal, y10 - this.paddingVertical, paint);
        paint.setColor(paint.getColor());
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final int getMarginHorizontal() {
        return this.marginHorizontal;
    }

    public final int getPaddingHorizontal() {
        return this.paddingHorizontal;
    }

    public final int getPaddingVertical() {
        return this.paddingVertical;
    }

    public final int getRound() {
        return this.round;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        Intrinsics.checkNotNullParameter(paint, "paint");
        return ((int) paint.measureText(text, start, end)) + this.paddingHorizontal + this.marginHorizontal;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public final void setBgColor(int i10) {
        this.bgColor = i10;
    }

    public final void setMarginHorizontal(int i10) {
        this.marginHorizontal = i10;
    }

    public final void setPaddingHorizontal(int i10) {
        this.paddingHorizontal = i10;
    }

    public final void setPaddingVertical(int i10) {
        this.paddingVertical = i10;
    }

    public final void setRound(int i10) {
        this.round = i10;
    }

    public final void setTextColor(int i10) {
        this.textColor = i10;
    }

    public final void setTextSize(int i10) {
        this.textSize = i10;
    }
}
