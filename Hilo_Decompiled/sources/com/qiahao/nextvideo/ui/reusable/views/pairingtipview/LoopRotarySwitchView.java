package com.qiahao.nextvideo.ui.reusable.views.pairingtipview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.pairingtipview.listener.OnItemClickListener;
import com.qiahao.nextvideo.ui.reusable.views.pairingtipview.listener.OnItemSelectedListener;
import com.qiahao.nextvideo.ui.reusable.views.pairingtipview.listener.OnLoopViewTouchListener;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u001d\u0018\u0000 \u0081\u00012\u00020\u0001:\u0006\u0081\u0001\u0082\u0001\u0083\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ&\u00109\u001a\u00020:\"\u0004\b\u0000\u0010;2\u0016\u0010<\u001a\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+H\u0002J\u0006\u0010A\u001a\u00020:J(\u0010B\u001a\u00020:2\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020\u0007H\u0014J0\u0010G\u001a\u00020:2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0007H\u0014J\u000e\u0010\r\u001a\u00020:2\u0006\u0010M\u001a\u00020$J\u001c\u0010\r\u001a\u00020:2\b\b\u0002\u0010N\u001a\u00020\u001a2\b\b\u0002\u0010O\u001a\u00020\u001aH\u0007J\u0006\u0010P\u001a\u00020:J\b\u0010Q\u001a\u00020:H\u0002J\u001a\u0010R\u001a\u00020:2\u0006\u0010S\u001a\u00020\u001a2\b\u0010T\u001a\u0004\u0018\u00010UH\u0002J\b\u0010V\u001a\u00020\u0007H\u0002J\u0010\u0010W\u001a\u00020$2\u0006\u0010X\u001a\u00020YH\u0002J\u0010\u0010Z\u001a\u00020$2\u0006\u0010X\u001a\u00020YH\u0016J\u0010\u0010[\u001a\u00020$2\u0006\u0010\\\u001a\u00020YH\u0016J\u0010\u00104\u001a\u00020:2\u0006\u0010X\u001a\u00020YH\u0002J\f\u0010,\u001a\b\u0012\u0004\u0012\u00020*0]J\u0006\u0010^\u001a\u00020\u0007J\u000e\u0010_\u001a\u00020:2\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010`\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010a\u001a\u00020:2\b\u0010.\u001a\u0004\u0018\u00010/J\u0010\u0010b\u001a\u00020:2\b\u00102\u001a\u0004\u0018\u000103J\u0010\u0010c\u001a\u00020:2\b\u00100\u001a\u0004\u0018\u000101J\u000e\u0010d\u001a\u00020\u00002\u0006\u0010e\u001a\u00020$J\u000e\u0010j\u001a\u00020\u00002\u0006\u0010f\u001a\u00020gJ\u000e\u0010l\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u001aJ\u000e\u0010n\u001a\u00020\u00002\u0006\u0010o\u001a\u00020'J\u001e\u0010p\u001a\u00020:2\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u00072\u0006\u0010q\u001a\u00020$J \u0010r\u001a\u0004\u0018\u00010\f2\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u00072\u0006\u0010q\u001a\u00020$J\u000e\u0010s\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0007J\u0018\u0010t\u001a\u00020\u00002\u0006\u0010u\u001a\u00020$2\u0006\u0010v\u001a\u00020$H\u0002J\u000e\u0010w\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0007J\u0010\u0010x\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010y\u001a\u0004\u0018\u00010\fJ\u000e\u0010z\u001a\u00020:2\u0006\u0010\u000e\u001a\u00020\fJ\b\u0010{\u001a\u0004\u0018\u00010\fJ\u000e\u0010|\u001a\u00020:2\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010}\u001a\u0004\u0018\u00010\fJ\u0006\u0010~\u001a\u00020:J\u0006\u0010\u007f\u001a\u00020:J\t\u0010\u0080\u0001\u001a\u00020:H\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010(\u001a\u0012\u0012\u0004\u0012\u00020*0)j\b\u0012\u0004\u0012\u00020*`+¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u001aX\u0082D¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u00020>8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001c\u0010f\u001a\u00020g8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010k¨\u0006\u0084\u0001"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/pairingtipview/LoopRotarySwitchView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mOrientation", "restAnimator", "Landroid/animation/ValueAnimator;", "rAnimation", "zAnimation", "xAnimation", "loopRotationX", "value", "loopRotationZ", "getLoopRotationZ", "()I", "mGestureDetector", "Landroid/view/GestureDetector;", "selectItem", "size", "loopRadius", "", "multiple", "distance", "angle", "getAngle", "()F", "setAngle", "(F)V", "lastAngle", "isAutoRotation", "", "touching", "autoRotatinDirection", "Lcom/qiahao/nextvideo/ui/reusable/views/pairingtipview/AutoScrollDirection;", "views", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "getViews", "()Ljava/util/ArrayList;", "onItemSelectedListener", "Lcom/qiahao/nextvideo/ui/reusable/views/pairingtipview/listener/OnItemSelectedListener;", "onLoopViewTouchListener", "Lcom/qiahao/nextvideo/ui/reusable/views/pairingtipview/listener/OnLoopViewTouchListener;", "onItemClickListener", "Lcom/qiahao/nextvideo/ui/reusable/views/pairingtipview/listener/OnItemClickListener;", "isCanClickListener", "enableClickX", "limitX", "loopHandler", "Lcom/qiahao/nextvideo/ui/reusable/views/pairingtipview/LoopRotarySwitchView$IncomingHandler;", "sortList", "", "T", "list", "geomeryController", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "getGeomeryController", "()Landroid/view/GestureDetector$SimpleOnGestureListener;", "initView", "onSizeChanged", "w", "h", "oldw", "oldh", "onLayout", "changed", "l", "t", "r", "b", "fromZeroToLoopR", "from", "to", "checkChildView", "restPosition", "animRotationTo", "finall", "complete", "Ljava/lang/Runnable;", "calculateItem", "onTouch", "event", "Landroid/view/MotionEvent;", "onTouchEvent", "dispatchTouchEvent", "ev", "", "getSelectItem", "setSelectItem", "setLoopRadius", "setOnItemSelectedListener", "setOnItemClickListener", "setOnLoopViewTouchListener", "setAutoRotation", "autoRotation", "autoRotationTime", "", "getAutoRotationTime", "()J", "setAutoRotationTime", "(J)V", "setMultiple", "mMultiple", "setAutoScrollDirection", "mAutoScrollDirection", "createXAnimation", "start", "createZAnimation", "setOrientation", "setHorizontal", "horizontal", "anim", "setLoopRotationX", "setLoopRotationZ", "getrAnimation", "setzAnimation", "getzAnimation", "setxAnimation", "getxAnimation", "slideIn", "slideOut", "onDetachedFromWindow", "Companion", "IncomingHandler", "SortComparator", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LoopRotarySwitchView extends RelativeLayout {
    private static final int LoopR = Dimens.INSTANCE.dpToPx(92);
    private static final int horizontal = 1;
    private float angle;

    @NotNull
    private AutoScrollDirection autoRotatinDirection;
    private long autoRotationTime;
    private float distance;
    private float enableClickX;
    private boolean isAutoRotation;
    private boolean isCanClickListener;
    private float lastAngle;
    private final float limitX;

    @NotNull
    private IncomingHandler loopHandler;
    private float loopRadius;
    private int loopRotationX;
    private int loopRotationZ;

    @Nullable
    private GestureDetector mGestureDetector;
    private int mOrientation;
    private float multiple;

    @Nullable
    private OnItemClickListener onItemClickListener;

    @Nullable
    private OnItemSelectedListener onItemSelectedListener;

    @Nullable
    private OnLoopViewTouchListener onLoopViewTouchListener;
    private ValueAnimator rAnimation;
    private ValueAnimator restAnimator;
    private int selectItem;
    private int size;
    private boolean touching;

    @NotNull
    private final ArrayList<View> views;
    private ValueAnimator xAnimation;
    private ValueAnimator zAnimation;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/pairingtipview/LoopRotarySwitchView$IncomingHandler;", "Lcom/qiahao/nextvideo/ui/reusable/views/pairingtipview/LoopRotarySwitchViewHandler;", "mService", "Lcom/qiahao/nextvideo/ui/reusable/views/pairingtipview/LoopRotarySwitchView;", "<init>", "(Lcom/qiahao/nextvideo/ui/reusable/views/pairingtipview/LoopRotarySwitchView;)V", "loopRotarySwitchView", "doScroll", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class IncomingHandler extends LoopRotarySwitchViewHandler {

        @NotNull
        private LoopRotarySwitchView loopRotarySwitchView;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AutoScrollDirection.values().length];
                try {
                    iArr[AutoScrollDirection.LEFT.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AutoScrollDirection.RIGHT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public IncomingHandler(@NotNull LoopRotarySwitchView loopRotarySwitchView) {
            super(HonorResultCode.AUDIO_PLAY_SERVICE_SUCCESS);
            Intrinsics.checkNotNullParameter(loopRotarySwitchView, "mService");
            this.loopRotarySwitchView = loopRotarySwitchView;
        }

        @Override // com.qiahao.nextvideo.ui.reusable.views.pairingtipview.LoopRotarySwitchViewHandler
        public void doScroll() {
            int i;
            LoopRotarySwitchView loopRotarySwitchView = this.loopRotarySwitchView;
            if (loopRotarySwitchView.size != 0) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[loopRotarySwitchView.autoRotatinDirection.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        i = (-360) / loopRotarySwitchView.size;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    i = 360 / loopRotarySwitchView.size;
                }
                if (loopRotarySwitchView.getAngle() == 360.0f) {
                    loopRotarySwitchView.setAngle(0.0f);
                }
                loopRotarySwitchView.animRotationTo(loopRotarySwitchView.getAngle() + i, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/pairingtipview/LoopRotarySwitchView$SortComparator;", "Ljava/util/Comparator;", "Landroid/view/View;", "<init>", "(Lcom/qiahao/nextvideo/ui/reusable/views/pairingtipview/LoopRotarySwitchView;)V", "compare", "", "lhs", "rhs", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public final class SortComparator implements Comparator<View> {
        public SortComparator() {
        }

        @Override // java.util.Comparator
        public int compare(@NotNull View lhs, @NotNull View rhs) {
            Intrinsics.checkNotNullParameter(lhs, "lhs");
            Intrinsics.checkNotNullParameter(rhs, "rhs");
            float f = 1000;
            try {
                return (int) ((lhs.getScaleX() * f) - (f * rhs.getScaleX()));
            } catch (Exception unused) {
                return 0;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoopRotarySwitchView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animRotationTo(float finall, final Runnable complete) {
        float f = this.angle;
        if (f == finall) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, finall);
        this.restAnimator = ofFloat;
        ValueAnimator valueAnimator = null;
        if (ofFloat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restAnimator");
            ofFloat = null;
        }
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ValueAnimator valueAnimator2 = this.restAnimator;
        if (valueAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restAnimator");
            valueAnimator2 = null;
        }
        valueAnimator2.setDuration(300L);
        ValueAnimator valueAnimator3 = this.restAnimator;
        if (valueAnimator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restAnimator");
            valueAnimator3 = null;
        }
        valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.pairingtipview.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                LoopRotarySwitchView.animRotationTo$lambda$2(LoopRotarySwitchView.this, valueAnimator4);
            }
        });
        ValueAnimator valueAnimator4 = this.restAnimator;
        if (valueAnimator4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restAnimator");
            valueAnimator4 = null;
        }
        valueAnimator4.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.pairingtipview.LoopRotarySwitchView$animRotationTo$2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                boolean z;
                int calculateItem;
                int i;
                OnItemSelectedListener onItemSelectedListener;
                OnItemSelectedListener onItemSelectedListener2;
                int i2;
                int i3;
                int i4;
                Intrinsics.checkNotNullParameter(animation, "animation");
                z = LoopRotarySwitchView.this.touching;
                if (!z) {
                    LoopRotarySwitchView loopRotarySwitchView = LoopRotarySwitchView.this;
                    calculateItem = loopRotarySwitchView.calculateItem();
                    loopRotarySwitchView.selectItem = calculateItem;
                    i = LoopRotarySwitchView.this.selectItem;
                    if (i < 0) {
                        LoopRotarySwitchView loopRotarySwitchView2 = LoopRotarySwitchView.this;
                        int i5 = loopRotarySwitchView2.size;
                        i4 = LoopRotarySwitchView.this.selectItem;
                        loopRotarySwitchView2.selectItem = i5 + i4;
                    }
                    onItemSelectedListener = LoopRotarySwitchView.this.onItemSelectedListener;
                    if (onItemSelectedListener != null) {
                        onItemSelectedListener2 = LoopRotarySwitchView.this.onItemSelectedListener;
                        Intrinsics.checkNotNull(onItemSelectedListener2);
                        i2 = LoopRotarySwitchView.this.selectItem;
                        ArrayList<View> views = LoopRotarySwitchView.this.getViews();
                        i3 = LoopRotarySwitchView.this.selectItem;
                        View view = views.get(i3);
                        Intrinsics.checkNotNullExpressionValue(view, "get(...)");
                        onItemSelectedListener2.selected(i2, view);
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        });
        if (complete != null) {
            ValueAnimator valueAnimator5 = this.restAnimator;
            if (valueAnimator5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("restAnimator");
                valueAnimator5 = null;
            }
            valueAnimator5.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.pairingtipview.LoopRotarySwitchView$animRotationTo$3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    complete.run();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            });
        }
        ValueAnimator valueAnimator6 = this.restAnimator;
        if (valueAnimator6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("restAnimator");
        } else {
            valueAnimator = valueAnimator6;
        }
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animRotationTo$lambda$2(LoopRotarySwitchView loopRotarySwitchView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        if (!loopRotarySwitchView.touching) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            loopRotarySwitchView.angle = ((Float) animatedValue).floatValue();
            loopRotarySwitchView.initView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateItem() {
        float f = this.angle;
        return ((int) (f / (360 / r1))) % this.size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkChildView$lambda$1(int i, LoopRotarySwitchView loopRotarySwitchView, View view) {
        OnItemClickListener onItemClickListener;
        if (i != loopRotarySwitchView.selectItem) {
            loopRotarySwitchView.setSelectItem(i);
            return;
        }
        if (loopRotarySwitchView.isCanClickListener && (onItemClickListener = loopRotarySwitchView.onItemClickListener) != null) {
            Intrinsics.checkNotNull(onItemClickListener);
            View view2 = loopRotarySwitchView.views.get(i);
            Intrinsics.checkNotNullExpressionValue(view2, "get(...)");
            onItemClickListener.onItemClick(i, view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createXAnimation$lambda$3(LoopRotarySwitchView loopRotarySwitchView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        loopRotarySwitchView.loopRotationX = ((Integer) animatedValue).intValue();
        loopRotarySwitchView.initView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createZAnimation$lambda$4(LoopRotarySwitchView loopRotarySwitchView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        loopRotarySwitchView.loopRotationZ = ((Integer) animatedValue).intValue();
        loopRotarySwitchView.initView();
    }

    private final GestureDetector.SimpleOnGestureListener getGeomeryController() {
        return new GestureDetector.SimpleOnGestureListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.pairingtipview.LoopRotarySwitchView$geomeryController$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Intrinsics.checkNotNullParameter(e2, "e2");
                LoopRotarySwitchView loopRotarySwitchView = LoopRotarySwitchView.this;
                float f = 4;
                loopRotarySwitchView.setAngle(loopRotarySwitchView.getAngle() + (((float) Math.cos(Math.toRadians(LoopRotarySwitchView.this.getLoopRotationZ()))) * (distanceX / f)) + (((float) Math.sin(Math.toRadians(LoopRotarySwitchView.this.getLoopRotationZ()))) * (distanceY / f)));
                LoopRotarySwitchView.this.initView();
                return true;
            }
        };
    }

    private final void isCanClickListener(MotionEvent event) {
        int action = event.getAction();
        if (action != 0) {
            boolean z = true;
            if (action == 1 || action == 3) {
                if (this.isAutoRotation) {
                    IncomingHandler incomingHandler = this.loopHandler;
                    incomingHandler.sendEmptyMessageDelayed(1000, incomingHandler.getLoopTime());
                }
                float x = event.getX();
                float f = this.enableClickX;
                if (x - f > this.limitX || f - event.getX() > this.limitX) {
                    z = false;
                }
                this.isCanClickListener = z;
                return;
            }
            return;
        }
        this.enableClickX = event.getX();
        if (this.isAutoRotation) {
            this.loopHandler.removeMessages(1000);
        }
    }

    private final boolean onTouch(MotionEvent event) {
        if (event.getAction() == 0) {
            this.lastAngle = this.angle;
            this.touching = true;
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        Intrinsics.checkNotNull(gestureDetector);
        if (gestureDetector.onTouchEvent(event)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (event.getAction() != 1 && event.getAction() != 3) {
            return true;
        }
        this.touching = false;
        restPosition();
        return true;
    }

    public static /* synthetic */ void rAnimation$default(LoopRotarySwitchView loopRotarySwitchView, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = loopRotarySwitchView.loopRadius;
        }
        loopRotarySwitchView.rAnimation(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rAnimation$lambda$0(LoopRotarySwitchView loopRotarySwitchView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "valueAnimator");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        loopRotarySwitchView.loopRadius = ((Float) animatedValue).floatValue();
        loopRotarySwitchView.initView();
    }

    private final void restPosition() {
        int i = this.size;
        if (i == 0) {
            return;
        }
        float f = 360 / i;
        float f2 = this.angle;
        if (f2 < 0.0f) {
            f = -f;
        }
        float f3 = ((int) (f2 / f)) * f;
        float f4 = (((int) (f2 / f)) * f) + f;
        if (f2 < 0.0f ? f2 - this.lastAngle < 0.0f : f2 - this.lastAngle > 0.0f) {
            f3 = f4;
        }
        animRotationTo(f3, null);
    }

    private final LoopRotarySwitchView setHorizontal(boolean horizontal2, boolean anim) {
        if (anim) {
            if (horizontal2) {
                createZAnimation(this.loopRotationZ, 0, true);
            } else {
                createZAnimation(this.loopRotationZ, 90, true);
            }
        } else {
            if (horizontal2) {
                setLoopRotationZ(0);
            } else {
                setLoopRotationZ(90);
            }
            initView();
            Unit unit = Unit.INSTANCE;
        }
        return this;
    }

    private final LoopRotarySwitchView setLoopRotationZ(int loopRotationZ) {
        this.loopRotationZ = loopRotationZ;
        return this;
    }

    private final <T> void sortList(ArrayList<View> list) {
        SortComparator sortComparator = new SortComparator();
        Object[] array = list.toArray(new View[list.size()]);
        Intrinsics.checkNotNullExpressionValue(array, "toArray(...)");
        View[] viewArr = (View[]) array;
        Arrays.sort(viewArr, sortComparator);
        ListIterator<View> listIterator = list.listIterator();
        Intrinsics.checkNotNullExpressionValue(listIterator, "listIterator(...)");
        int i = 0;
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(viewArr[i]);
            i++;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            list.get(i2).bringToFront();
        }
    }

    public final void checkChildView() {
        int size = this.views.size();
        for (int i = 0; i < size; i++) {
            this.views.remove(i);
        }
        int childCount = getChildCount();
        this.size = childCount;
        for (final int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            this.views.add(childAt);
            childAt.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.pairingtipview.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoopRotarySwitchView.checkChildView$lambda$1(i2, this, view);
                }
            });
        }
    }

    public final void createXAnimation(int from, int to, boolean start) {
        if (this.xAnimation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xAnimation");
        }
        ValueAnimator valueAnimator = this.xAnimation;
        ValueAnimator valueAnimator2 = null;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xAnimation");
            valueAnimator = null;
        }
        if (valueAnimator.isRunning()) {
            ValueAnimator valueAnimator3 = this.xAnimation;
            if (valueAnimator3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("xAnimation");
                valueAnimator3 = null;
            }
            valueAnimator3.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(from, to);
        this.xAnimation = ofInt;
        if (ofInt == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xAnimation");
            ofInt = null;
        }
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.pairingtipview.d
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                LoopRotarySwitchView.createXAnimation$lambda$3(LoopRotarySwitchView.this, valueAnimator4);
            }
        });
        ValueAnimator valueAnimator4 = this.xAnimation;
        if (valueAnimator4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xAnimation");
            valueAnimator4 = null;
        }
        valueAnimator4.setInterpolator(new DecelerateInterpolator());
        ValueAnimator valueAnimator5 = this.xAnimation;
        if (valueAnimator5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xAnimation");
            valueAnimator5 = null;
        }
        valueAnimator5.setDuration(2000L);
        if (start) {
            ValueAnimator valueAnimator6 = this.xAnimation;
            if (valueAnimator6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("xAnimation");
            } else {
                valueAnimator2 = valueAnimator6;
            }
            valueAnimator2.start();
        }
    }

    @Nullable
    public final ValueAnimator createZAnimation(int from, int to, boolean start) {
        if (this.zAnimation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zAnimation");
        }
        ValueAnimator valueAnimator = this.zAnimation;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zAnimation");
            valueAnimator = null;
        }
        if (valueAnimator.isRunning()) {
            ValueAnimator valueAnimator2 = this.zAnimation;
            if (valueAnimator2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("zAnimation");
                valueAnimator2 = null;
            }
            valueAnimator2.cancel();
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(from, to);
        this.zAnimation = ofInt;
        if (ofInt == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zAnimation");
            ofInt = null;
        }
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.pairingtipview.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                LoopRotarySwitchView.createZAnimation$lambda$4(LoopRotarySwitchView.this, valueAnimator3);
            }
        });
        ValueAnimator valueAnimator3 = this.zAnimation;
        if (valueAnimator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zAnimation");
            valueAnimator3 = null;
        }
        valueAnimator3.setInterpolator(new DecelerateInterpolator());
        ValueAnimator valueAnimator4 = this.zAnimation;
        if (valueAnimator4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zAnimation");
            valueAnimator4 = null;
        }
        valueAnimator4.setDuration(2000L);
        if (start) {
            ValueAnimator valueAnimator5 = this.zAnimation;
            if (valueAnimator5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("zAnimation");
                valueAnimator5 = null;
            }
            valueAnimator5.start();
        }
        ValueAnimator valueAnimator6 = this.zAnimation;
        if (valueAnimator6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zAnimation");
            return null;
        }
        return valueAnimator6;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        onTouch(ev);
        OnLoopViewTouchListener onLoopViewTouchListener = this.onLoopViewTouchListener;
        if (onLoopViewTouchListener != null) {
            Intrinsics.checkNotNull(onLoopViewTouchListener);
            onLoopViewTouchListener.onTouch(ev);
        }
        isCanClickListener(ev);
        return super.dispatchTouchEvent(ev);
    }

    public final float getAngle() {
        return this.angle;
    }

    public final long getAutoRotationTime() {
        return this.loopHandler.getLoopTime();
    }

    public final int getLoopRotationZ() {
        return this.loopRotationZ;
    }

    public final int getSelectItem() {
        return this.selectItem;
    }

    @NotNull
    public final ArrayList<View> getViews() {
        return this.views;
    }

    @Nullable
    public final ValueAnimator getrAnimation() {
        ValueAnimator valueAnimator = this.rAnimation;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rAnimation");
            return null;
        }
        return valueAnimator;
    }

    @Nullable
    public final ValueAnimator getxAnimation() {
        ValueAnimator valueAnimator = this.xAnimation;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("xAnimation");
            return null;
        }
        return valueAnimator;
    }

    @Nullable
    public final ValueAnimator getzAnimation() {
        ValueAnimator valueAnimator = this.zAnimation;
        if (valueAnimator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("zAnimation");
            return null;
        }
        return valueAnimator;
    }

    public final void initView() {
        int size = this.views.size();
        for (int i = 0; i < size; i++) {
            double d = (this.angle + 180) - ((i * 360) / this.size);
            float sin = ((float) Math.sin(Math.toRadians(d))) * this.loopRadius;
            float cos = (float) Math.cos(Math.toRadians(d));
            float f = this.loopRadius;
            float f2 = this.distance;
            float f3 = (f2 - (cos * f)) / (f2 + f);
            this.views.get(i).setScaleX(f3);
            this.views.get(i).setScaleY(f3);
            float sin2 = ((float) Math.sin(Math.toRadians(this.loopRotationX * Math.cos(Math.toRadians(d))))) * this.loopRadius;
            float f4 = ((float) (-Math.sin(Math.toRadians(-this.loopRotationZ)))) * sin;
            this.views.get(i).setTranslationX(sin + ((((float) Math.cos(Math.toRadians(-this.loopRotationZ))) * sin) - sin));
            this.views.get(i).setTranslationY(sin2 + f4);
        }
        ArrayList<View> arrayList = new ArrayList<>();
        arrayList.clear();
        int size2 = this.views.size();
        for (int i2 = 0; i2 < size2; i2++) {
            arrayList.add(this.views.get(i2));
        }
        sortList(arrayList);
        postInvalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.loopHandler.removeCallbacksAndMessages(null);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (changed) {
            checkChildView();
            OnItemSelectedListener onItemSelectedListener = this.onItemSelectedListener;
            if (onItemSelectedListener != null) {
                this.isCanClickListener = true;
                Intrinsics.checkNotNull(onItemSelectedListener);
                int i = this.selectItem;
                View view = this.views.get(i);
                Intrinsics.checkNotNullExpressionValue(view, "get(...)");
                onItemSelectedListener.selected(i, view);
            }
            rAnimation$default(this, 0.0f, 0.0f, 3, null);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        initView();
        if (this.isAutoRotation) {
            IncomingHandler incomingHandler = this.loopHandler;
            incomingHandler.sendEmptyMessageDelayed(1000, incomingHandler.getLoopTime());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        OnLoopViewTouchListener onLoopViewTouchListener = this.onLoopViewTouchListener;
        if (onLoopViewTouchListener != null) {
            Intrinsics.checkNotNull(onLoopViewTouchListener);
            onLoopViewTouchListener.onTouch(event);
        }
        isCanClickListener(event);
        return true;
    }

    @JvmOverloads
    public final void rAnimation() {
        rAnimation$default(this, 0.0f, 0.0f, 3, null);
    }

    public final void setAngle(float f) {
        this.angle = f;
    }

    @NotNull
    public final LoopRotarySwitchView setAutoRotation(boolean autoRotation) {
        this.isAutoRotation = autoRotation;
        this.loopHandler.setLoop(autoRotation);
        return this;
    }

    /* renamed from: setAutoRotationTime, reason: collision with other method in class */
    public final void m٨٤setAutoRotationTime(long j) {
        this.autoRotationTime = j;
    }

    @NotNull
    public final LoopRotarySwitchView setAutoScrollDirection(@NotNull AutoScrollDirection mAutoScrollDirection) {
        Intrinsics.checkNotNullParameter(mAutoScrollDirection, "mAutoScrollDirection");
        this.autoRotatinDirection = mAutoScrollDirection;
        return this;
    }

    @NotNull
    public final LoopRotarySwitchView setLoopRadius(float loopRadius) {
        this.loopRadius = loopRadius;
        this.distance = this.multiple * loopRadius;
        return this;
    }

    @NotNull
    public final LoopRotarySwitchView setLoopRotationX(int loopRotationX) {
        this.loopRotationX = loopRotationX;
        return this;
    }

    @NotNull
    public final LoopRotarySwitchView setMultiple(float mMultiple) {
        this.multiple = mMultiple;
        return this;
    }

    public final void setOnItemClickListener(@Nullable OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public final void setOnItemSelectedListener(@Nullable OnItemSelectedListener onItemSelectedListener) {
        this.onItemSelectedListener = onItemSelectedListener;
    }

    public final void setOnLoopViewTouchListener(@Nullable OnLoopViewTouchListener onLoopViewTouchListener) {
        this.onLoopViewTouchListener = onLoopViewTouchListener;
    }

    @NotNull
    public final LoopRotarySwitchView setOrientation(int mOrientation) {
        boolean z = true;
        if (mOrientation != 1) {
            z = false;
        }
        setHorizontal(z, false);
        return this;
    }

    public final void setSelectItem(int selectItem) {
        float f;
        int i;
        float f2;
        int i2;
        float f3;
        if (selectItem >= 0) {
            if (getSelectItem() == 0) {
                if (selectItem == this.views.size() - 1) {
                    f = this.angle;
                    i = 360 / this.size;
                    f3 = f - i;
                } else {
                    f2 = this.angle;
                    i2 = 360 / this.size;
                    f3 = f2 + i2;
                }
            } else if (getSelectItem() == this.views.size() - 1) {
                if (selectItem == 0) {
                    f2 = this.angle;
                    i2 = 360 / this.size;
                    f3 = f2 + i2;
                } else {
                    f = this.angle;
                    i = 360 / this.size;
                    f3 = f - i;
                }
            } else if (selectItem > getSelectItem()) {
                f2 = this.angle;
                i2 = 360 / this.size;
                f3 = f2 + i2;
            } else {
                f = this.angle;
                i = 360 / this.size;
                f3 = f - i;
            }
            int i3 = this.size;
            float f4 = 360 / i3;
            if (f3 < 0.0f) {
                f4 = -f4;
            }
            float f5 = ((int) (f3 / f4)) * f4;
            if (i3 > 0) {
                animRotationTo(f5, null);
            }
        }
    }

    public final void setxAnimation(@NotNull ValueAnimator xAnimation) {
        Intrinsics.checkNotNullParameter(xAnimation, "xAnimation");
        this.xAnimation = xAnimation;
    }

    public final void setzAnimation(@NotNull ValueAnimator zAnimation) {
        Intrinsics.checkNotNullParameter(zAnimation, "zAnimation");
        this.zAnimation = zAnimation;
    }

    public final void slideIn() {
    }

    public final void slideOut() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoopRotarySwitchView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    /* renamed from: getViews, reason: collision with other method in class */
    public final List<View> m٨٣getViews() {
        return this.views;
    }

    @JvmOverloads
    public final void rAnimation(float f) {
        rAnimation$default(this, f, 0.0f, 2, null);
    }

    @NotNull
    public final LoopRotarySwitchView setAutoRotationTime(long autoRotationTime) {
        this.loopHandler.setLoopTime(autoRotationTime);
        return this;
    }

    public /* synthetic */ LoopRotarySwitchView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void rAnimation(boolean fromZeroToLoopR) {
        if (fromZeroToLoopR) {
            rAnimation(1.0f, LoopR);
        } else {
            rAnimation(LoopR, 1.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LoopRotarySwitchView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mOrientation = 1;
        int i2 = LoopR;
        float f = i2;
        this.loopRadius = f;
        this.multiple = 4.7f;
        this.distance = 4.7f * f;
        AutoScrollDirection autoScrollDirection = AutoScrollDirection.LEFT;
        this.autoRotatinDirection = autoScrollDirection;
        this.views = new ArrayList<>();
        this.isCanClickListener = true;
        this.limitX = 30.0f;
        this.loopHandler = new IncomingHandler(this);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LoopRotarySwitchView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        int i3 = obtainStyledAttributes.getInt(1, 0);
        this.mOrientation = obtainStyledAttributes.getInt(2, 1);
        this.isAutoRotation = obtainStyledAttributes.getBoolean(0, false);
        this.loopRadius = obtainStyledAttributes.getDimension(3, i2);
        obtainStyledAttributes.recycle();
        this.mGestureDetector = new GestureDetector(context, getGeomeryController());
        this.loopRotationZ = this.mOrientation != 1 ? 90 : 0;
        this.autoRotatinDirection = i3 != 0 ? AutoScrollDirection.RIGHT : autoScrollDirection;
        this.loopHandler.setLoop(this.isAutoRotation);
    }

    @JvmOverloads
    public final void rAnimation(float from, float to) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(from, to);
        this.rAnimation = ofFloat;
        ValueAnimator valueAnimator = null;
        if (ofFloat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rAnimation");
            ofFloat = null;
        }
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.pairingtipview.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                LoopRotarySwitchView.rAnimation$lambda$0(LoopRotarySwitchView.this, valueAnimator2);
            }
        });
        ValueAnimator valueAnimator2 = this.rAnimation;
        if (valueAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rAnimation");
            valueAnimator2 = null;
        }
        valueAnimator2.setInterpolator(new DecelerateInterpolator());
        ValueAnimator valueAnimator3 = this.rAnimation;
        if (valueAnimator3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rAnimation");
            valueAnimator3 = null;
        }
        valueAnimator3.setDuration(2000L);
        ValueAnimator valueAnimator4 = this.rAnimation;
        if (valueAnimator4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rAnimation");
        } else {
            valueAnimator = valueAnimator4;
        }
        valueAnimator.start();
    }
}
