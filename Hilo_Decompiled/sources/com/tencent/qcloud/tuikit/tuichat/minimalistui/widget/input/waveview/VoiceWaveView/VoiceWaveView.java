package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.waveview.VoiceWaveView;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import com.tencent.qcloud.tuikit.tuichat.R;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0007J\u000e\u0010S\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0007J\u000e\u0010T\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0007J\u0010\u0010U\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0007H\u0002J\u0006\u0010V\u001a\u00020QJ\u0010\u0010W\u001a\u00020Q2\u0006\u0010X\u001a\u00020YH\u0014J\u0006\u0010Z\u001a\u00020QJ\n\u0010[\u001a\u0004\u0018\u00010\\H\u0014J\u0012\u0010]\u001a\u00020Q2\b\u0010^\u001a\u0004\u0018\u00010\\H\u0014R*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\u0018\u00101\u001a\n 3*\u0004\u0018\u00010202X\u0082\u000e¢\u0006\u0004\n\u0002\u00104R\u000e\u00105\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00108\u001a\u000209¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u001e\u0010=\u001a\u00020<2\u0006\u0010\n\u001a\u00020<@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001a\u0010E\u001a\u00020FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010%\"\u0004\bM\u0010'R\u0010\u0010N\u001a\u0004\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/minimalistui/widget/input/waveview/VoiceWaveView/VoiceWaveView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Ljava/util/LinkedList;", "bodyWaveList", "getBodyWaveList", "()Ljava/util/LinkedList;", "headerWaveList", "getHeaderWaveList", "footerWaveList", "getFooterWaveList", "waveList", "lineSpace", "", "getLineSpace", "()F", "setLineSpace", "(F)V", "lineWidth", "getLineWidth", "setLineWidth", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "lineColor", "getLineColor", "()I", "setLineColor", "(I)V", "paintLine", "Landroid/graphics/Paint;", "getPaintLine", "()Landroid/graphics/Paint;", "setPaintLine", "(Landroid/graphics/Paint;)V", "paintPathLine", "getPaintPathLine", "setPaintPathLine", "valueAnimator", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "Landroid/animation/ValueAnimator;", "valueAnimatorOffset", "valHandler", "Landroid/os/Handler;", "linePath", "Landroid/graphics/Path;", "getLinePath", "()Landroid/graphics/Path;", "", "isStart", "()Z", "waveMode", "Lcom/tencent/qcloud/tuikit/tuichat/minimalistui/widget/input/waveview/VoiceWaveView/WaveMode;", "getWaveMode", "()Lcom/tencent/qcloud/tuikit/tuichat/minimalistui/widget/input/waveview/VoiceWaveView/WaveMode;", "setWaveMode", "(Lcom/tencent/qcloud/tuikit/tuichat/minimalistui/widget/input/waveview/VoiceWaveView/WaveMode;)V", "lineType", "Lcom/tencent/qcloud/tuikit/tuichat/minimalistui/widget/input/waveview/VoiceWaveView/LineType;", "getLineType", "()Lcom/tencent/qcloud/tuikit/tuichat/minimalistui/widget/input/waveview/VoiceWaveView/LineType;", "setLineType", "(Lcom/tencent/qcloud/tuikit/tuichat/minimalistui/widget/input/waveview/VoiceWaveView/LineType;)V", "showGravity", "getShowGravity", "setShowGravity", "runnable", "Ljava/lang/Runnable;", "addBody", "", "num", "addHeader", "addFooter", "checkNum", "start", "onDraw", "canvas", "Landroid/graphics/Canvas;", "stop", "onSaveInstanceState", "Landroid/os/Parcelable;", "onRestoreInstanceState", "state", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVoiceWaveView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VoiceWaveView.kt\ncom/tencent/qcloud/tuikit/tuichat/minimalistui/widget/input/waveview/VoiceWaveView/VoiceWaveView\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,308:1\n1#2:309\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class VoiceWaveView extends View {

    @NotNull
    private LinkedList<Integer> bodyWaveList;
    private long duration;

    @NotNull
    private LinkedList<Integer> footerWaveList;

    @NotNull
    private LinkedList<Integer> headerWaveList;
    private volatile boolean isStart;
    private int lineColor;

    @NotNull
    private final Path linePath;
    private float lineSpace;

    @NotNull
    private LineType lineType;
    private float lineWidth;

    @Nullable
    private Paint paintLine;

    @Nullable
    private Paint paintPathLine;

    @Nullable
    private Runnable runnable;
    private int showGravity;

    @NotNull
    private Handler valHandler;
    private ValueAnimator valueAnimator;
    private float valueAnimatorOffset;

    @NotNull
    private LinkedList<Integer> waveList;

    @NotNull
    private WaveMode waveMode;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoiceWaveView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void checkNum(int num) {
        if (num >= 0 && num <= 100) {
        } else {
            throw new Exception("num must between 0 and 100");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void start$lambda$1(VoiceWaveView voiceWaveView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "it");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        voiceWaveView.valueAnimatorOffset = ((Float) animatedValue).floatValue();
        voiceWaveView.invalidate();
    }

    public final void addBody(int num) {
        checkNum(num);
        this.bodyWaveList.add(Integer.valueOf(num));
    }

    public final void addFooter(int num) {
        checkNum(num);
        this.footerWaveList.add(Integer.valueOf(num));
    }

    public final void addHeader(int num) {
        checkNum(num);
        this.headerWaveList.add(Integer.valueOf(num));
    }

    @NotNull
    public final LinkedList<Integer> getBodyWaveList() {
        return this.bodyWaveList;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final LinkedList<Integer> getFooterWaveList() {
        return this.footerWaveList;
    }

    @NotNull
    public final LinkedList<Integer> getHeaderWaveList() {
        return this.headerWaveList;
    }

    public final int getLineColor() {
        return this.lineColor;
    }

    @NotNull
    public final Path getLinePath() {
        return this.linePath;
    }

    public final float getLineSpace() {
        return this.lineSpace;
    }

    @NotNull
    public final LineType getLineType() {
        return this.lineType;
    }

    public final float getLineWidth() {
        return this.lineWidth;
    }

    @Nullable
    public final Paint getPaintLine() {
        return this.paintLine;
    }

    @Nullable
    public final Paint getPaintPathLine() {
        return this.paintPathLine;
    }

    public final int getShowGravity() {
        return this.showGravity;
    }

    @NotNull
    public final WaveMode getWaveMode() {
        return this.waveMode;
    }

    /* renamed from: isStart, reason: from getter */
    public final boolean getIsStart() {
        return this.isStart;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0191 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x013c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onDraw(@NotNull Canvas canvas) {
        Paint paint;
        float f;
        float f2;
        float f3;
        int i;
        float measuredHeight;
        Paint paint2;
        float f4;
        float f5;
        float f6;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.waveList.clear();
        this.waveList.addAll(this.headerWaveList);
        this.waveList.addAll(this.bodyWaveList);
        this.waveList.addAll(this.footerWaveList);
        this.linePath.reset();
        Paint paint3 = this.paintPathLine;
        if (paint3 != null) {
            paint3.setStrokeWidth(this.lineWidth);
        }
        Paint paint4 = this.paintPathLine;
        if (paint4 != null) {
            paint4.setColor(this.lineColor);
        }
        Paint paint5 = this.paintLine;
        if (paint5 != null) {
            paint5.setStrokeWidth(this.lineWidth);
        }
        Paint paint6 = this.paintLine;
        if (paint6 != null) {
            paint6.setColor(this.lineColor);
        }
        int size = this.waveList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 >= this.headerWaveList.size() && i2 < this.waveList.size() - this.footerWaveList.size()) {
                f = this.valueAnimatorOffset;
            } else {
                f = 1.0f;
            }
            double doubleValue = (this.waveList.get(i2).doubleValue() / 100.0d) * getMeasuredHeight() * f;
            int absoluteGravity = Gravity.getAbsoluteGravity(this.showGravity, getLayoutDirection()) & 7;
            float f7 = 0.0f;
            if (absoluteGravity != 1) {
                if (absoluteGravity != 3) {
                    if (absoluteGravity != 5) {
                        f3 = 0.0f;
                        f2 = 0.0f;
                        i = this.showGravity & 112;
                        if (i == 16) {
                            if (i != 48) {
                                if (i != 80) {
                                    measuredHeight = 0.0f;
                                } else {
                                    f7 = (float) (getMeasuredHeight() - doubleValue);
                                    measuredHeight = getMeasuredHeight();
                                }
                            } else {
                                measuredHeight = (float) doubleValue;
                            }
                        } else {
                            double d = doubleValue / 2;
                            f7 = (float) ((getMeasuredHeight() / 2) - d);
                            measuredHeight = (float) ((getMeasuredHeight() / 2) + d);
                        }
                        if (this.lineType == LineType.BAR_CHART && (paint2 = this.paintLine) != null && canvas != null) {
                            canvas.drawLine(f2, f7, f3, measuredHeight, paint2);
                        }
                        if (this.lineType == LineType.LINE_GRAPH) {
                            if (i2 == 0) {
                                this.linePath.moveTo(f2, f7);
                                float f8 = 2;
                                this.linePath.lineTo(f3 + (this.lineWidth / f8) + (this.lineSpace / f8), measuredHeight);
                            } else {
                                this.linePath.lineTo(f2, f7);
                                float f9 = 2;
                                this.linePath.lineTo(f3 + (this.lineWidth / f9) + (this.lineSpace / f9), measuredHeight);
                            }
                        }
                    } else {
                        float size2 = this.waveList.size() * (this.lineSpace + this.lineWidth);
                        if (size2 < getMeasuredWidth()) {
                            float f10 = this.lineSpace;
                            float f11 = this.lineWidth;
                            f2 = (i2 * (f10 + f11)) + (f11 / 2) + (getMeasuredWidth() - size2);
                        } else {
                            f4 = i2;
                            f5 = this.lineSpace;
                            f6 = this.lineWidth;
                        }
                    }
                } else {
                    f4 = i2;
                    f5 = this.lineSpace;
                    f6 = this.lineWidth;
                }
                f2 = (f4 * (f5 + f6)) + (f6 / 2);
            } else {
                float size3 = this.waveList.size() * (this.lineSpace + this.lineWidth);
                if (size3 < getMeasuredWidth()) {
                    float f12 = this.lineSpace;
                    float f13 = this.lineWidth;
                    float f14 = i2 * (f12 + f13);
                    float f15 = 2;
                    f2 = f14 + (f13 / f15) + ((getMeasuredWidth() - size3) / f15);
                } else {
                    float f16 = this.lineSpace;
                    float f17 = this.lineWidth;
                    f2 = (i2 * (f16 + f17)) + (f17 / 2);
                }
            }
            f3 = f2;
            i = this.showGravity & 112;
            if (i == 16) {
            }
            if (this.lineType == LineType.BAR_CHART) {
                canvas.drawLine(f2, f7, f3, measuredHeight, paint2);
            }
            if (this.lineType == LineType.LINE_GRAPH) {
            }
        }
        if (this.lineType == LineType.LINE_GRAPH && (paint = this.paintPathLine) != null && canvas != null) {
            canvas.drawPath(this.linePath, paint);
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(@Nullable Parcelable state) {
        super.onRestoreInstanceState(state);
    }

    @Override // android.view.View
    @Nullable
    protected Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public final void setLineColor(int i) {
        this.lineColor = i;
    }

    public final void setLineSpace(float f) {
        this.lineSpace = f;
    }

    public final void setLineType(@NotNull LineType lineType) {
        Intrinsics.checkNotNullParameter(lineType, "<set-?>");
        this.lineType = lineType;
    }

    public final void setLineWidth(float f) {
        this.lineWidth = f;
    }

    public final void setPaintLine(@Nullable Paint paint) {
        this.paintLine = paint;
    }

    public final void setPaintPathLine(@Nullable Paint paint) {
        this.paintPathLine = paint;
    }

    public final void setShowGravity(int i) {
        this.showGravity = i;
    }

    public final void setWaveMode(@NotNull WaveMode waveMode) {
        Intrinsics.checkNotNullParameter(waveMode, "<set-?>");
        this.waveMode = waveMode;
    }

    public final void start() {
        if (this.isStart) {
            return;
        }
        this.isStart = true;
        WaveMode waveMode = this.waveMode;
        if (waveMode == WaveMode.UP_DOWN) {
            this.valueAnimator.setDuration(this.duration);
            this.valueAnimator.setRepeatMode(2);
            this.valueAnimator.setRepeatCount(-1);
            this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.waveview.VoiceWaveView.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    VoiceWaveView.start$lambda$1(VoiceWaveView.this, valueAnimator);
                }
            });
            this.valueAnimator.start();
            return;
        }
        if (waveMode == WaveMode.LEFT_RIGHT) {
            Runnable runnable = new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.input.waveview.VoiceWaveView.VoiceWaveView$start$2
                @Override // java.lang.Runnable
                public void run() {
                    Handler handler;
                    Integer pollLast = VoiceWaveView.this.getBodyWaveList().pollLast();
                    if (pollLast != null) {
                        VoiceWaveView.this.getBodyWaveList().add(0, Integer.valueOf(pollLast.intValue()));
                    }
                    VoiceWaveView.this.invalidate();
                    handler = VoiceWaveView.this.valHandler;
                    handler.postDelayed(this, VoiceWaveView.this.getDuration());
                }
            };
            this.runnable = runnable;
            Handler handler = this.valHandler;
            Intrinsics.checkNotNull(runnable, "null cannot be cast to non-null type java.lang.Runnable");
            handler.post(runnable);
        }
    }

    public final void stop() {
        this.isStart = false;
        Runnable runnable = this.runnable;
        if (runnable != null) {
            Handler handler = this.valHandler;
            Intrinsics.checkNotNull(runnable);
            handler.removeCallbacks(runnable);
        }
        this.valueAnimator.cancel();
        this.waveList.clear();
        this.bodyWaveList.clear();
        this.headerWaveList.clear();
        this.footerWaveList.clear();
        this.linePath.reset();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoiceWaveView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ VoiceWaveView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public VoiceWaveView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.bodyWaveList = new LinkedList<>();
        this.headerWaveList = new LinkedList<>();
        this.footerWaveList = new LinkedList<>();
        this.waveList = new LinkedList<>();
        this.lineSpace = 10.0f;
        this.lineWidth = 20.0f;
        this.duration = Long.MAX_VALUE;
        this.lineColor = -16776961;
        this.valueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.valueAnimatorOffset = 1.0f;
        this.valHandler = new Handler();
        this.linePath = new Path();
        WaveMode waveMode = WaveMode.UP_DOWN;
        this.waveMode = waveMode;
        LineType lineType = LineType.BAR_CHART;
        this.lineType = lineType;
        this.showGravity = 83;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.VoiceWaveView, 0, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            this.lineWidth = obtainStyledAttributes.getDimension(R.styleable.VoiceWaveView_lineWidth, 5.0f);
            this.lineSpace = obtainStyledAttributes.getDimension(R.styleable.VoiceWaveView_lineSpace, 5.0f);
            this.duration = obtainStyledAttributes.getInt(R.styleable.VoiceWaveView_duration, 200);
            this.showGravity = obtainStyledAttributes.getInt(R.styleable.VoiceWaveView_android_gravity, 83);
            this.lineColor = obtainStyledAttributes.getInt(R.styleable.VoiceWaveView_lineColor, -16776961);
            int i2 = obtainStyledAttributes.getInt(R.styleable.VoiceWaveView_waveMode, 0);
            if (i2 == 0) {
                this.waveMode = waveMode;
            } else if (i2 == 1) {
                this.waveMode = WaveMode.LEFT_RIGHT;
            }
            int i3 = obtainStyledAttributes.getInt(R.styleable.VoiceWaveView_lineType, 0);
            if (i3 == 0) {
                this.lineType = lineType;
            } else if (i3 == 1) {
                this.lineType = LineType.LINE_GRAPH;
            }
            obtainStyledAttributes.recycle();
        }
        Paint paint = new Paint();
        this.paintLine = paint;
        paint.setAntiAlias(true);
        Paint paint2 = this.paintLine;
        if (paint2 != null) {
            paint2.setStrokeCap(Paint.Cap.ROUND);
        }
        Paint paint3 = new Paint();
        this.paintPathLine = paint3;
        paint3.setAntiAlias(true);
        Paint paint4 = this.paintPathLine;
        if (paint4 != null) {
            paint4.setStyle(Paint.Style.STROKE);
        }
    }
}
