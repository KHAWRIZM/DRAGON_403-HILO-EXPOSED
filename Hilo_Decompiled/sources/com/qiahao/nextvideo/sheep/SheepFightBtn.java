package com.qiahao.nextvideo.sheep;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.oudi.utils.ktx.UiKtxKt;
import com.tencent.qcloud.tuicore.TUIConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0014J\b\u0010#\u001a\u00020 H\u0014J\b\u0010$\u001a\u00020 H\u0014J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020'H\u0014J\u0006\u0010(\u001a\u00020 J\u0006\u0010)\u001a\u00020 R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/sheep/SheepFightBtn;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defAttrStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mWidth", "mHeight", "translateX", "", "clipPath", "Landroid/graphics/Path;", "pW", "x1", "x2", "x3", "x4", "mRun", "Ljava/lang/Runnable;", "mCommonRadius", "mPaint", "Landroid/graphics/Paint;", "rectF", "Landroid/graphics/RectF;", TUIConstants.TUICalling.PARAM_NAME_AUDIO_PATH, "getPath", "()Landroid/graphics/Path;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onAttachedToWindow", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "startLoop", "stopLoop", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SheepFightBtn extends AppCompatTextView {

    @NotNull
    private Path clipPath;
    private float mCommonRadius;
    private int mHeight;

    @NotNull
    private Paint mPaint;

    @Nullable
    private Runnable mRun;
    private int mWidth;
    private final int pW;

    @NotNull
    private final Path path;

    @NotNull
    private RectF rectF;
    private float translateX;
    private final int x1;
    private final float x2;
    private final int x3;
    private final int x4;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SheepFightBtn(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    public final Path getPath() {
        return this.path;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onAttachedToWindow() {
        super/*android.widget.TextView*/.onAttachedToWindow();
        startLoop();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopLoop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super/*android.widget.TextView*/.onDraw(canvas);
        if (this.mWidth <= 0) {
            return;
        }
        canvas.clipPath(this.clipPath);
        if (this.translateX >= this.mWidth + this.pW) {
            this.translateX = 0.0f;
        }
        this.translateX += 15.0f;
        this.path.reset();
        this.path.moveTo(this.translateX + this.x1, 0.0f);
        this.path.lineTo(this.translateX + this.x2, 0.0f);
        this.path.lineTo(this.translateX + this.x3, this.mHeight);
        this.path.lineTo(this.translateX + this.x4, this.mHeight);
        this.path.lineTo(this.translateX + this.x1, 0.0f);
        canvas.drawPath(this.path, this.mPaint);
        Runnable runnable = this.mRun;
        if (runnable != null) {
            postDelayed(runnable, 10L);
        }
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        this.mWidth = View.MeasureSpec.getSize(widthMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        this.mHeight = size;
        this.rectF.set(0.0f, 0.0f, this.mWidth, size);
        this.clipPath.reset();
        Path path = this.clipPath;
        RectF rectF = this.rectF;
        float f = this.mCommonRadius;
        path.addRoundRect(rectF, new float[]{f, f, f, f, f, f, f, f}, Path.Direction.CCW);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void startLoop() {
        stopLoop();
        Runnable runnable = new Runnable() { // from class: com.qiahao.nextvideo.sheep.l
            @Override // java.lang.Runnable
            public final void run() {
                SheepFightBtn.this.postInvalidate();
            }
        };
        this.mRun = runnable;
        postDelayed(runnable, 10L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void stopLoop() {
        Runnable runnable = this.mRun;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.mRun = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SheepFightBtn(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SheepFightBtn(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public SheepFightBtn(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.clipPath = new Path();
        this.pW = UiKtxKt.toPX(25);
        this.x1 = UiKtxKt.toPX(-25.0f);
        this.x3 = UiKtxKt.toPX(-12.5f);
        this.x4 = UiKtxKt.toPX(-37.5f);
        this.mCommonRadius = UiKtxKt.toPX(18.0f);
        this.mPaint = new Paint();
        this.rectF = new RectF();
        this.path = new Path();
        this.mPaint.setColor(Color.parseColor("#80FFFFFF"));
        this.mPaint.setAntiAlias(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.mCommonRadius);
        gradientDrawable.setColor(Color.parseColor("#33000000"));
        gradientDrawable.setStroke(UiKtxKt.toPX(1), -1);
        setBackground(gradientDrawable);
    }
}
