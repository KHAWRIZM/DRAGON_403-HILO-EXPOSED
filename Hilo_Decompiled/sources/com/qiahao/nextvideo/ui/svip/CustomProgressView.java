package com.qiahao.nextvideo.ui.svip;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sud.gip.core.view.round.RoundedDrawable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001<B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B%\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\u001c\u0010)\u001a\u00020*2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\tH\u0014J\u0010\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u000200H\u0015J\b\u00101\u001a\u00020*H\u0002J\b\u00102\u001a\u00020*H\u0002J\u000e\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\fJ\u0016\u00103\u001a\u00020*2\u0006\u00104\u001a\u00020\f2\u0006\u00105\u001a\u000206J\u000e\u00107\u001a\u00020*2\u0006\u00108\u001a\u000209J\u000e\u0010:\u001a\u00020*2\u0006\u0010\r\u001a\u00020\fJ\u0006\u0010;\u001a\u00020\fR+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/qiahao/nextvideo/ui/svip/CustomProgressView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "<set-?>", "", "progress", "getProgress", "()F", "setProgress", "(F)V", "progress$delegate", "Lkotlin/properties/ReadWriteProperty;", "maxProgress", "progressStartColor", "progressEndColor", "progressBackgroundColor", "progressBackgroundColorStart", "progressBackgroundColorEnd", "progressPaint", "Landroid/graphics/Paint;", "progressBGPaint", "progressPointPaint", "WRAP_WIDTH", "WRAP_HEIGHT", "widthSize", "heightSize", "progressBGRect", "Landroid/graphics/RectF;", "progressRect", "isCircle", "", "hintPoint", "isRtl", "initAttr", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "init", "initSize", "setProgressAnim", "percentage", "duration", "", "setConfigs", "configs", "Lcom/qiahao/nextvideo/ui/svip/CustomProgressView$Configs;", "setCurrentProgress", "getCurrentProgress", "Configs", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomProgressView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomProgressView.kt\ncom/qiahao/nextvideo/ui/svip/CustomProgressView\n+ 2 Delegates.kt\nkotlin/properties/Delegates\n*L\n1#1,319:1\n33#2,3:320\n*S KotlinDebug\n*F\n+ 1 CustomProgressView.kt\ncom/qiahao/nextvideo/ui/svip/CustomProgressView\n*L\n23#1:320,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CustomProgressView extends View {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(CustomProgressView.class, "progress", "getProgress()F", 0))};
    private final int WRAP_HEIGHT;
    private final int WRAP_WIDTH;
    private int heightSize;
    private boolean hintPoint;
    private boolean isCircle;
    private boolean isRtl;
    private float maxProgress;

    /* renamed from: progress$delegate, reason: from kotlin metadata */
    @NotNull
    private final ReadWriteProperty progress;

    @NotNull
    private final Paint progressBGPaint;

    @NotNull
    private final RectF progressBGRect;
    private int progressBackgroundColor;
    private int progressBackgroundColorEnd;
    private int progressBackgroundColorStart;
    private int progressEndColor;

    @NotNull
    private final Paint progressPaint;

    @NotNull
    private final Paint progressPointPaint;

    @NotNull
    private final RectF progressRect;
    private int progressStartColor;
    private int widthSize;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/svip/CustomProgressView$Configs;", "", "<init>", "()V", "startColor", "", "getStartColor", "()I", "setStartColor", "(I)V", "endColor", "getEndColor", "setEndColor", "backgroundStartColor", "getBackgroundStartColor", "setBackgroundStartColor", "backgroundEndColor", "getBackgroundEndColor", "setBackgroundEndColor", "pointColor", "getPointColor", "setPointColor", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Configs {
        private int backgroundEndColor;
        private int backgroundStartColor;
        private int endColor;
        private int pointColor;
        private int startColor;

        public final int getBackgroundEndColor() {
            return this.backgroundEndColor;
        }

        public final int getBackgroundStartColor() {
            return this.backgroundStartColor;
        }

        public final int getEndColor() {
            return this.endColor;
        }

        public final int getPointColor() {
            return this.pointColor;
        }

        public final int getStartColor() {
            return this.startColor;
        }

        public final void setBackgroundEndColor(int i) {
            this.backgroundEndColor = i;
        }

        public final void setBackgroundStartColor(int i) {
            this.backgroundStartColor = i;
        }

        public final void setEndColor(int i) {
            this.endColor = i;
        }

        public final void setPointColor(int i) {
            this.pointColor = i;
        }

        public final void setStartColor(int i) {
            this.startColor = i;
        }
    }

    public CustomProgressView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Delegates delegates = Delegates.INSTANCE;
        final Float valueOf = Float.valueOf(0.0f);
        this.progress = new ObservableProperty<Float>(valueOf) { // from class: com.qiahao.nextvideo.ui.svip.CustomProgressView$special$$inlined$observable$1
            protected void afterChange(KProperty<?> property, Float oldValue, Float newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                newValue.floatValue();
                oldValue.floatValue();
                this.invalidate();
            }
        };
        this.progressStartColor = -65536;
        this.progressEndColor = -65536;
        this.progressBackgroundColor = -7829368;
        this.progressPaint = new Paint();
        this.progressBGPaint = new Paint();
        this.progressPointPaint = new Paint();
        this.progressBGRect = new RectF();
        this.progressRect = new RectF();
        initAttr(context, attributeSet);
    }

    private final float getProgress() {
        return ((Number) this.progress.getValue(this, $$delegatedProperties[0])).floatValue();
    }

    private final void init() {
        if (this.isCircle) {
            this.progressBGPaint.setColor(this.progressBackgroundColor);
            Paint paint = this.progressBGPaint;
            Paint.Style style = Paint.Style.STROKE;
            paint.setStyle(style);
            this.progressPaint.setStyle(style);
            return;
        }
        this.progressBGPaint.setColor(this.progressBackgroundColor);
        Paint paint2 = this.progressBGPaint;
        Paint.Style style2 = Paint.Style.FILL;
        paint2.setStyle(style2);
        this.progressPaint.setStyle(style2);
        this.progressPointPaint.setStyle(style2);
        this.progressPointPaint.setColor(this.progressEndColor);
    }

    private final void initAttr(Context context, AttributeSet attrs) {
        Intrinsics.checkNotNull(context);
        Intrinsics.checkNotNull(attrs);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            try {
                if (!isInEditMode()) {
                    this.isRtl = HiloUtils.INSTANCE.getRightToLeftDirection();
                }
                this.maxProgress = 100.0f;
                this.isCircle = obtainStyledAttributes.getBoolean(1, false);
                this.hintPoint = obtainStyledAttributes.getBoolean(0, false);
                setProgress(obtainStyledAttributes.getFloat(2, 0.0f));
                this.progressBackgroundColor = obtainStyledAttributes.getColor(3, -7829368);
                this.progressBackgroundColorStart = obtainStyledAttributes.getColor(5, 0);
                this.progressBackgroundColorEnd = obtainStyledAttributes.getColor(4, 0);
                this.progressStartColor = obtainStyledAttributes.getColor(7, -1);
                this.progressEndColor = obtainStyledAttributes.getColor(6, RoundedDrawable.DEFAULT_BORDER_COLOR);
                init();
            } catch (Exception e) {
                e.printStackTrace();
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private final void initSize() {
        if (this.isCircle) {
            this.progressBGPaint.setStrokeWidth(this.heightSize / 10.0f);
            this.progressPaint.setStrokeWidth(this.heightSize / 10.0f);
            RectF rectF = this.progressBGRect;
            rectF.left = 10.0f;
            rectF.right = this.widthSize - 10.0f;
            rectF.top = 10.0f;
            rectF.bottom = this.heightSize - 10.0f;
            return;
        }
        this.progressBGPaint.setStrokeWidth(this.heightSize / 3.0f);
        this.progressPaint.setStrokeWidth(this.heightSize / 3.0f);
        boolean z = this.hintPoint;
        if (z) {
            RectF rectF2 = this.progressBGRect;
            rectF2.left = 0.0f;
            rectF2.right = this.widthSize * 1.0f;
        } else {
            RectF rectF3 = this.progressBGRect;
            int i = this.heightSize;
            rectF3.left = i / 2.0f;
            rectF3.right = (this.widthSize * 1.0f) - (i / 2.0f);
        }
        RectF rectF4 = this.progressBGRect;
        int i2 = this.heightSize;
        rectF4.top = i2 / 5.0f;
        float f = 5;
        rectF4.bottom = (i2 * 4.0f) / f;
        if (this.isRtl) {
            if (z) {
                this.progressRect.right = this.widthSize * 1.0f;
            } else {
                this.progressRect.right = this.widthSize - (i2 / 2.0f);
            }
        } else if (z) {
            this.progressRect.left = 0.0f;
        } else {
            this.progressRect.left = (i2 / 2.0f) + 0.0f;
        }
        RectF rectF5 = this.progressRect;
        rectF5.top = i2 / 5.0f;
        rectF5.bottom = (i2 * 4.0f) / f;
    }

    private final void setProgress(float f) {
        this.progress.setValue(this, $$delegatedProperties[0], Float.valueOf(f));
    }

    public final float getCurrentProgress() {
        return getProgress();
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(@NotNull Canvas canvas) {
        float progress;
        float f;
        LinearGradient linearGradient;
        LinearGradient linearGradient2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.save();
        float f2 = this.heightSize * 0.3f;
        if (this.isRtl) {
            if (this.hintPoint) {
                int i = this.widthSize;
                f = i - ((i * getProgress()) / this.maxProgress);
            } else {
                f = this.widthSize - ((((r3 - r1) * getProgress()) / this.maxProgress) + (this.heightSize / 2.0f));
            }
            this.progressRect.left = f;
        } else {
            if (this.hintPoint) {
                progress = (this.widthSize * getProgress()) / this.maxProgress;
            } else {
                progress = (((this.widthSize - r1) * getProgress()) / this.maxProgress) + (this.heightSize / 2.0f);
            }
            f = progress;
            this.progressRect.right = f;
        }
        Paint paint = this.progressPaint;
        if (this.isRtl) {
            linearGradient = new LinearGradient(f, 0.0f, this.progressRect.right, 0.0f, this.progressEndColor, this.progressStartColor, Shader.TileMode.CLAMP);
        } else {
            linearGradient = new LinearGradient(0.0f, 0.0f, f, 0.0f, this.progressStartColor, this.progressEndColor, Shader.TileMode.CLAMP);
        }
        paint.setShader(linearGradient);
        if (this.progressBackgroundColorStart != 0 && this.progressBackgroundColorEnd != 0) {
            Paint paint2 = this.progressBGPaint;
            if (this.isRtl) {
                int i2 = this.widthSize;
                linearGradient2 = new LinearGradient(i2, 0.0f, i2 - ((i2 * getProgress()) / this.maxProgress), 0.0f, this.progressBackgroundColorStart, this.progressBackgroundColorEnd, Shader.TileMode.CLAMP);
            } else {
                linearGradient2 = new LinearGradient((this.widthSize * getProgress()) / this.maxProgress, 0.0f, this.widthSize, 0.0f, this.progressBackgroundColorStart, this.progressBackgroundColorEnd, Shader.TileMode.CLAMP);
            }
            paint2.setShader(linearGradient2);
        }
        if (this.isCircle) {
            canvas.drawArc(this.progressBGRect, 270.0f, 360.0f, true, this.progressBGPaint);
            canvas.drawArc(this.progressBGRect, 270.0f, (getProgress() * 360.0f) / this.maxProgress, false, this.progressPaint);
        } else {
            canvas.drawRoundRect(this.progressBGRect, f2, f2, this.progressBGPaint);
            canvas.drawRoundRect(this.progressRect, f2, f2, this.progressPaint);
            if (!this.hintPoint) {
                int i3 = this.heightSize;
                canvas.drawCircle(f, i3 / 2.0f, i3 / 2.0f, this.progressPointPaint);
            }
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        this.widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        this.heightSize = size;
        if (mode == Integer.MIN_VALUE && mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(this.WRAP_WIDTH, this.WRAP_HEIGHT);
        } else if (mode == Integer.MIN_VALUE) {
            setMeasuredDimension(this.WRAP_WIDTH, size);
        } else if (mode2 == Integer.MIN_VALUE) {
            setMeasuredDimension(this.widthSize, this.WRAP_HEIGHT);
        } else {
            setMeasuredDimension(this.widthSize, size);
        }
        initSize();
    }

    public final void setConfigs(@NotNull Configs configs) {
        Intrinsics.checkNotNullParameter(configs, "configs");
        if (configs.getStartColor() != 0) {
            this.progressStartColor = configs.getStartColor();
        }
        if (configs.getEndColor() != 0) {
            this.progressEndColor = configs.getEndColor();
        }
        this.progressPointPaint.setColor(configs.getPointColor());
        if (configs.getBackgroundStartColor() != 0 && configs.getBackgroundEndColor() != 0) {
            this.progressBGPaint.setShader(new LinearGradient(0.0f, 0.0f, this.widthSize, 0.0f, configs.getBackgroundStartColor(), configs.getBackgroundEndColor(), Shader.TileMode.CLAMP));
        }
    }

    public final void setCurrentProgress(float progress) {
        setProgress(progress);
    }

    public final void setProgressAnim(float percentage) {
        if (percentage > 100.0f) {
            percentage = 100.0f;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, "progress", percentage).setDuration(1000L);
        Intrinsics.checkNotNullExpressionValue(duration, "setDuration(...)");
        duration.start();
    }

    public final void setProgressAnim(float percentage, long duration) {
        if (percentage > 100.0f) {
            percentage = 100.0f;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this, "progress", percentage).setDuration(duration);
        Intrinsics.checkNotNullExpressionValue(duration2, "setDuration(...)");
        duration2.start();
    }

    public CustomProgressView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Delegates delegates = Delegates.INSTANCE;
        final Float valueOf = Float.valueOf(0.0f);
        this.progress = new ObservableProperty<Float>(valueOf) { // from class: com.qiahao.nextvideo.ui.svip.CustomProgressView$special$$inlined$observable$2
            protected void afterChange(KProperty<?> property, Float oldValue, Float newValue) {
                Intrinsics.checkNotNullParameter(property, "property");
                newValue.floatValue();
                oldValue.floatValue();
                this.invalidate();
            }
        };
        this.progressStartColor = -65536;
        this.progressEndColor = -65536;
        this.progressBackgroundColor = -7829368;
        this.progressPaint = new Paint();
        this.progressBGPaint = new Paint();
        this.progressPointPaint = new Paint();
        this.progressBGRect = new RectF();
        this.progressRect = new RectF();
        initAttr(context, attributeSet);
    }
}
