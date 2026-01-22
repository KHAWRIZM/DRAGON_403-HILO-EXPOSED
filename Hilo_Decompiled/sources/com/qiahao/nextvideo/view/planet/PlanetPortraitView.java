package com.qiahao.nextvideo.view.planet;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 82\u00020\u0001:\u00018B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010%\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J(\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020\nH\u0014J\u0010\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020.H\u0014J\u000e\u0010/\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\nJ\u000e\u00102\u001a\u00020&2\u0006\u0010\f\u001a\u00020\nJ\u0010\u00103\u001a\u00020&2\b\b\u0001\u00104\u001a\u00020\nJ\u0006\u00105\u001a\u00020&J\u0006\u00106\u001a\u00020&J\b\u00107\u001a\u00020&H\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/qiahao/nextvideo/view/planet/PlanetPortraitView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "radius", "spreadPaint", "Landroid/graphics/Paint;", "centerX", "", "centerY", "distance", "alpha_change", "default_alpha", "maxRadius", "delayMilliseconds", "duration", "cirNums", "getCirNums", "()I", "setCirNums", "(I)V", "spreadRadius", "", "alphas", "value", "", "isShowing", "()Z", "ringCount", "init", "", "onSizeChanged", "w", "h", "oldw", "oldh", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setMaxRadius", "setRingCount", "count", "setRadius", "setColor", "color", "show", "dismiss", "dismissImmediately", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlanetPortraitView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlanetPortraitView.kt\ncom/qiahao/nextvideo/view/planet/PlanetPortraitView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,185:1\n1#2:186\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PlanetPortraitView extends View {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String TAG = "PortraitAnimationView";
    private int alpha_change;

    @NotNull
    private final List<Integer> alphas;
    private float centerX;
    private float centerY;
    private int cirNums;
    private final int default_alpha;
    private int delayMilliseconds;
    private float distance;
    private int duration;
    private boolean isShowing;
    private int maxRadius;
    private int radius;
    private int ringCount;

    @Nullable
    private Paint spreadPaint;

    @NotNull
    private final List<Float> spreadRadius;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/view/planet/PlanetPortraitView$Companion;", "", "<init>", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String getTAG() {
            return PlanetPortraitView.TAG;
        }

        public final void setTAG(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            PlanetPortraitView.TAG = str;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlanetPortraitView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.radius = 100;
        this.distance = 5.0f;
        this.alpha_change = 2;
        this.default_alpha = 255;
        this.maxRadius = 80;
        this.delayMilliseconds = 33;
        this.duration = HonorResultCode.ADVANCED_RECORD_SUCCESS;
        this.cirNums = 3;
        this.spreadRadius = new ArrayList();
        this.alphas = new ArrayList();
        this.ringCount = 5;
        init(context, null);
    }

    private final void dismissImmediately() {
        this.ringCount = 0;
        this.isShowing = false;
        this.alphas.clear();
        this.spreadRadius.clear();
        setVisibility(8);
    }

    private final void init(Context context, AttributeSet attrs) {
        if (this.isShowing) {
            this.alphas.add(Integer.valueOf(this.default_alpha));
            this.spreadRadius.add(Float.valueOf(0.0f));
        }
        Paint paint = new Paint();
        this.spreadPaint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = this.spreadPaint;
        if (paint2 != null) {
            paint2.setAlpha(255);
        }
        if (attrs != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.PortraitAnimationView);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            int i = obtainStyledAttributes.getInt(5, this.radius);
            Dimens dimens = Dimens.INSTANCE;
            this.radius = dimens.dpToPx(i);
            this.maxRadius = dimens.dpToPx(obtainStyledAttributes.getInt(4, this.maxRadius));
            obtainStyledAttributes.getColor(0, androidx.core.content.a.getColor(context, 2131101214));
            int color = obtainStyledAttributes.getColor(6, androidx.core.content.a.getColor(context, 2131101214));
            this.delayMilliseconds = obtainStyledAttributes.getInt(1, 35);
            this.duration = obtainStyledAttributes.getInt(3, HonorResultCode.ADVANCED_RECORD_SUCCESS);
            obtainStyledAttributes.recycle();
            Paint paint3 = this.spreadPaint;
            if (paint3 != null) {
                paint3.setColor(color);
            }
        }
        int i2 = this.default_alpha;
        int i3 = this.duration;
        int i4 = this.delayMilliseconds;
        this.alpha_change = (int) ((i2 / (i3 / i4)) + 0.5f);
        this.distance = (this.maxRadius - this.radius) / (i3 / i4);
    }

    public final void dismiss() {
        this.isShowing = false;
    }

    public final int getCirNums() {
        return this.cirNums;
    }

    /* renamed from: isShowing, reason: from getter */
    public final boolean getIsShowing() {
        return this.isShowing;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.ringCount <= 0) {
            dismissImmediately();
            return;
        }
        int size = this.spreadRadius.size();
        for (int i = 0; i < size; i++) {
            int intValue = this.alphas.get(i).intValue();
            Paint paint = this.spreadPaint;
            if (paint != null) {
                paint.setAlpha(intValue);
            }
            float floatValue = this.spreadRadius.get(i).floatValue();
            Paint paint2 = this.spreadPaint;
            if (paint2 != null) {
                canvas.drawCircle(this.centerX, this.centerY, this.radius + floatValue, paint2);
            }
            if (intValue > 0 && floatValue < 300.0f) {
                this.alphas.set(i, Integer.valueOf(intValue - this.alpha_change));
                this.spreadRadius.set(i, Float.valueOf(floatValue + this.distance));
            }
        }
        if (this.isShowing && this.alphas.size() > 0) {
            if (this.alphas.get(r10.size() - 1).intValue() <= 150 && this.alphas.size() < this.cirNums) {
                this.spreadRadius.add(Float.valueOf(0.0f));
                this.alphas.add(Integer.valueOf(this.default_alpha));
            }
        }
        if (this.spreadRadius.size() >= this.cirNums || (!this.isShowing && this.spreadRadius.size() > 0)) {
            this.alphas.remove(0);
            this.spreadRadius.remove(0);
            if (this.spreadRadius.size() == 0) {
                postInvalidateDelayed(this.delayMilliseconds);
            }
            this.ringCount--;
        }
        if (this.spreadRadius.size() > 0) {
            postInvalidateDelayed(this.delayMilliseconds);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.centerX = w / 2;
        this.centerY = h / 2;
    }

    public final void setCirNums(int i) {
        this.cirNums = i;
    }

    public final void setColor(int color) {
        Paint paint = this.spreadPaint;
        if (paint != null) {
            paint.setColor(androidx.core.content.a.getColor(getContext(), color));
        }
    }

    public final void setMaxRadius(int maxRadius) {
        this.maxRadius = maxRadius;
        this.distance = maxRadius / (this.duration / this.delayMilliseconds);
    }

    public final void setRadius(int radius) {
        this.radius = radius;
    }

    public final void setRingCount(int count) {
        this.ringCount = count;
    }

    public final void show() {
        this.ringCount = 100000;
        if (getVisibility() == 8) {
            setVisibility(0);
        }
        if (!this.isShowing) {
            if (this.alphas.size() == 0) {
                this.alphas.add(Integer.valueOf(this.default_alpha));
                this.spreadRadius.add(Float.valueOf(0.0f));
            }
            this.isShowing = true;
            postInvalidate();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlanetPortraitView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.radius = 100;
        this.distance = 5.0f;
        this.alpha_change = 2;
        this.default_alpha = 255;
        this.maxRadius = 80;
        this.delayMilliseconds = 33;
        this.duration = HonorResultCode.ADVANCED_RECORD_SUCCESS;
        this.cirNums = 3;
        this.spreadRadius = new ArrayList();
        this.alphas = new ArrayList();
        this.ringCount = 5;
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlanetPortraitView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.radius = 100;
        this.distance = 5.0f;
        this.alpha_change = 2;
        this.default_alpha = 255;
        this.maxRadius = 80;
        this.delayMilliseconds = 33;
        this.duration = HonorResultCode.ADVANCED_RECORD_SUCCESS;
        this.cirNums = 3;
        this.spreadRadius = new ArrayList();
        this.alphas = new ArrayList();
        this.ringCount = 5;
        init(context, attributeSet);
    }
}
