package com.qiahao.base_common.wedgit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.h;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.R;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\u001a\u001a\u00020\u000bH\u0016J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u0012\u0010#\u001a\u00020\u00182\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u000bH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/qiahao/base_common/wedgit/LevelDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", FirebaseAnalytics.Param.LEVEL, "", "isCharm", "", "isWealth", "isActivity", "mTextColor", "", "mTextSize", "", "<init>", "(Landroid/content/Context;JZZZIF)V", "wrappedDrawable", "levelText", "", "textX", "textY", "textPaint", "Landroid/graphics/Paint;", "initDrawableBg", "", "getIntrinsicWidth", "getIntrinsicHeight", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "draw", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nLevelDrawable.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LevelDrawable.kt\ncom/qiahao/base_common/wedgit/LevelDrawable\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,135:1\n439#2:136\n*S KotlinDebug\n*F\n+ 1 LevelDrawable.kt\ncom/qiahao/base_common/wedgit/LevelDrawable\n*L\n34#1:136\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class LevelDrawable extends Drawable {

    @NotNull
    private final Context context;
    private final boolean isActivity;
    private final boolean isCharm;
    private final boolean isWealth;
    private final long level;

    @NotNull
    private final String levelText;
    private int mTextColor;
    private float mTextSize;

    @NotNull
    private final Paint textPaint;
    private float textX;
    private float textY;

    @Nullable
    private Drawable wrappedDrawable;

    public LevelDrawable(@NotNull Context context, long j10, boolean z10, boolean z11, boolean z12, int i10, float f10) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.level = j10;
        this.isCharm = z10;
        this.isWealth = z11;
        this.isActivity = z12;
        this.mTextColor = i10;
        this.mTextSize = f10;
        this.levelText = String.valueOf(j10);
        Paint paint = new Paint(1);
        paint.setColor(this.mTextColor);
        paint.setTextSize(this.mTextSize);
        try {
            paint.setTypeface(h.h(context, R.font.grade_font));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        this.textPaint = paint;
        initDrawableBg();
    }

    private final void initDrawableBg() {
        int i10;
        Drawable drawable;
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            i10 = service.getLevelBg(this.level, this.isCharm, this.isWealth, this.isActivity);
        } else {
            i10 = 0;
        }
        if (i10 != 0) {
            Drawable drawable2 = androidx.core.content.a.getDrawable(this.context, i10);
            if (drawable2 != null) {
                drawable = ImageKtxKt.toHorizontalMirror(drawable2, this.context);
            } else {
                drawable = null;
            }
            this.wrappedDrawable = drawable;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable drawable = this.wrappedDrawable;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        canvas.drawText(this.levelText, this.textX, this.textY, this.textPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.wrappedDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.wrappedDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NotNull Rect bounds) {
        float f10;
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        super.onBoundsChange(bounds);
        Drawable drawable = this.wrappedDrawable;
        if (drawable != null) {
            drawable.setBounds(bounds);
        }
        float width = bounds.width();
        float measureText = (0.6666667f * width) - (this.textPaint.measureText(this.levelText) * 1.0f);
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            f10 = measureText / 2;
        } else {
            f10 = (measureText / 2) + (width * 0.33333334f);
        }
        this.textX = bounds.left + f10;
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        this.textY = bounds.centerY() - ((fontMetrics.descent + fontMetrics.ascent) / 2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        Drawable drawable = this.wrappedDrawable;
        if (drawable != null) {
            drawable.setAlpha(alpha);
        }
        this.textPaint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Drawable drawable = this.wrappedDrawable;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        this.textPaint.setColorFilter(colorFilter);
    }

    public /* synthetic */ LevelDrawable(Context context, long j10, boolean z10, boolean z11, boolean z12, int i10, float f10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, j10, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? false : z11, (i11 & 16) != 0 ? false : z12, (i11 & 32) != 0 ? Color.parseColor("#FFFFFF") : i10, (i11 & 64) != 0 ? UiKtxKt.toPX(10) : f10);
    }
}
