package com.tencent.qgame.animplayer.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import com.tencent.qgame.animplayer.mix.Src;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/tencent/qgame/animplayer/util/BitmapUtil;", "", "()V", "createEmptyBitmap", "Landroid/graphics/Bitmap;", "createTxtBitmap", "src", "Lcom/tencent/qgame/animplayer/mix/Src;", "animplayer_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class BitmapUtil {
    public static final BitmapUtil INSTANCE = new BitmapUtil();

    private BitmapUtil() {
    }

    @NotNull
    public final Bitmap createEmptyBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(16, 16, Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(0);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "Bitmap.createBitmap(16, …or.TRANSPARENT)\n        }");
        return createBitmap;
    }

    @NotNull
    public final Bitmap createTxtBitmap(@NotNull Src src) {
        int w = src.getW();
        int h = src.getH();
        Bitmap createBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Rect rect = new Rect(0, 0, w, h);
        Rect rect2 = new Rect();
        TextPaint textPaint = new TextPaint();
        float f = h;
        float f2 = 0.8f;
        textPaint.setTextSize(f * 0.8f);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);
        if (src.getStyle() == Src.Style.BOLD) {
            textPaint.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        }
        textPaint.setColor(src.getColor());
        String txt = src.getTxt();
        while (f2 > 0.1f) {
            textPaint.getTextBounds(txt, 0, txt.length(), rect2);
            if (rect2.width() <= rect.width()) {
                break;
            }
            f2 -= 0.1f;
            textPaint.setTextSize(f * f2);
        }
        Paint.FontMetricsInt fontMetricsInt = textPaint.getFontMetricsInt();
        canvas.drawText(txt, rect.centerX(), (rect.centerY() - (fontMetricsInt.top / 2)) - (fontMetricsInt.bottom / 2), textPaint);
        Intrinsics.checkExpressionValueIsNotNull(createBitmap, "bitmap");
        return createBitmap;
    }
}
