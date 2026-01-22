package com.qiahao.nextvideo.view.planet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.oudi.utils.TimerTask;
import com.oudi.utils.ktx.TimerKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.planet.PlanetAdapter;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sud.gip.core.view.round.RoundedDrawable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 {2\u00020\u00012\u00020\u0002:\u0002|{B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ!\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0003¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\rH\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001f\u0010\u0010J!\u0010#\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\"\u001a\u00020\nH\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\rH\u0002¢\u0006\u0004\b%\u0010\u0010J\u0017\u0010(\u001a\u00020\u00112\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010,\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u0019H\u0002¢\u0006\u0004\b,\u0010-J\u001f\u00100\u001a\u00020\u00112\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u0019H\u0002¢\u0006\u0004\b0\u00101J\u000f\u00102\u001a\u00020\rH\u0002¢\u0006\u0004\b2\u0010\u0010J\u000f\u00103\u001a\u00020\rH\u0016¢\u0006\u0004\b3\u0010\u0010J\u0015\u00105\u001a\u00020\r2\u0006\u00104\u001a\u00020\u0011¢\u0006\u0004\b5\u0010\u0014J\u0015\u00108\u001a\u00020\r2\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\r¢\u0006\u0004\b:\u0010\u0010J\u0017\u0010<\u001a\u00020\u00112\u0006\u0010;\u001a\u00020&H\u0016¢\u0006\u0004\b<\u0010)J\u0017\u0010=\u001a\u00020\u00112\u0006\u0010;\u001a\u00020&H\u0016¢\u0006\u0004\b=\u0010)J\u001f\u0010@\u001a\u00020\r2\u0006\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\nH\u0015¢\u0006\u0004\b@\u0010AJ\u0017\u0010C\u001a\u00020\u00112\u0006\u0010B\u001a\u00020&H\u0016¢\u0006\u0004\bC\u0010)J\u000f\u0010D\u001a\u00020\rH\u0014¢\u0006\u0004\bD\u0010\u0010J7\u0010J\u001a\u00020\r2\u0006\u0010E\u001a\u00020\u00112\u0006\u0010F\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\nH\u0015¢\u0006\u0004\bJ\u0010KJ\u0017\u0010N\u001a\u00020\r2\b\u0010M\u001a\u0004\u0018\u00010L¢\u0006\u0004\bN\u0010OJ\r\u0010P\u001a\u00020\r¢\u0006\u0004\bP\u0010\u0010R*\u0010R\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010\u0017R\u0016\u0010W\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010Z\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010\\\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010XR\u0016\u0010]\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010XR\u0016\u0010^\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010XR\u0016\u0010_\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010XR\u0016\u0010`\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010XR\u0016\u0010a\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010XR\u0016\u0010c\u001a\u00020b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010dR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010fR\u0018\u0010h\u001a\u0004\u0018\u00010g8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010j\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010SR\u0016\u0010k\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010fR\u0016\u0010l\u001a\u0002068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u0018\u0010n\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010p\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010XR\u0016\u0010q\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010XR\u0016\u0010r\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\br\u0010XR\u0016\u0010s\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010XR\u0016\u0010t\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010fR\u0016\u0010u\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010XR\u0016\u0010v\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010XR\u0018\u0010x\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\u0016\u0010z\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010f¨\u0006}"}, d2 = {"Lcom/qiahao/nextvideo/view/planet/PlanetsView;", "Landroid/view/ViewGroup;", "Lcom/qiahao/nextvideo/view/planet/PlanetAdapter$OnDataSetChangeListener;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "init", "initializeScreenSize", "()V", "", "manualScroll", "setManualScroll", "(Z)V", "color", "setLightColor", "(I)V", "setDarkColor", "", "percent", "setRadiusPercent", "(F)V", "scrollSpeed", "setScrollSpeed", "initFromAdapter", "Landroid/view/View;", "view", "position", "addListener", "(Landroid/view/View;I)V", "resetChildren", "Landroid/view/MotionEvent;", "event", "handleTouchEvent", "(Landroid/view/MotionEvent;)Z", "x", "y", "distance", "(FF)F", "dx", "dy", "isValidMove", "(FF)Z", "processTouch", "onChange", "isRunning", "startOrStop", "Lcom/qiahao/nextvideo/view/planet/PlanetAdapter;", "adapter", "setAdapter", "(Lcom/qiahao/nextvideo/view/planet/PlanetAdapter;)V", "reset", "e", "onTrackballEvent", "onTouchEvent", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "ev", "onInterceptTouchEvent", "onDetachedFromWindow", "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "Lcom/qiahao/nextvideo/view/planet/PlanetsView$OnTagClickListener;", "listener", "setOnTagClickListener", "(Lcom/qiahao/nextvideo/view/planet/PlanetsView$OnTagClickListener;)V", "run", "value", "autoScrollMode", "I", "getAutoScrollMode", "()I", "setAutoScrollMode", "speed", "F", "Lcom/qiahao/nextvideo/view/planet/PlanetCalculator;", "mPlanetCalculator", "Lcom/qiahao/nextvideo/view/planet/PlanetCalculator;", "mAngleX", "mAngleY", "centerX", "centerY", "radius", "radiusPercent", "", "darkColor", "[F", "lightColor", "Z", "Landroid/view/ViewGroup$MarginLayoutParams;", "layoutParams", "Landroid/view/ViewGroup$MarginLayoutParams;", "minSize", "isOnTouch", "planetAdapter", "Lcom/qiahao/nextvideo/view/planet/PlanetAdapter;", "onTagClickListener", "Lcom/qiahao/nextvideo/view/planet/PlanetsView$OnTagClickListener;", "downX", "downY", "mScaleX", "startDistance", "multiplePointer", "startX", "startY", "Lcom/oudi/utils/TimerTask;", "mTimerTask", "Lcom/oudi/utils/TimerTask;", "isChange", "Companion", "OnTagClickListener", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlanetsView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlanetsView.kt\ncom/qiahao/nextvideo/view/planet/PlanetsView\n+ 2 Context.kt\nandroidx/core/content/ContextKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 5 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,594:1\n51#2,9:595\n1#3:604\n1869#4,2:605\n51#5:607\n*S KotlinDebug\n*F\n+ 1 PlanetsView.kt\ncom/qiahao/nextvideo/view/planet/PlanetsView\n*L\n92#1:595,9\n232#1:605,2\n518#1:607\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PlanetsView extends ViewGroup implements PlanetAdapter.OnDataSetChangeListener {
    private static final float ALPHA_FACTOR = 2.2f;
    private static final float ANGLE_DECAY_FACTOR = 0.95f;
    private static final float CLICKABLE_SCALE_THRESHOLD = 1.0f;
    private static final float DECELERATION_FACTOR = 0.1f;
    private static final float DECELERATION_THRESHOLD = 0.2f;
    private static final float DEFAULT_RADIUS_PERCENT = 0.9f;
    private static final float DEFAULT_SCROLL_SPEED = 2.0f;
    private static final float DEFAULT_START_ANGLE = 0.5f;
    private static final float MAX_ANGLE = 0.2f;
    public static final float MAX_SCALE = 1.0f;
    public static final float MINI_SCALE = 1.0f;
    private static final float MIN_ALPHA = 0.16f;
    private static final float MIN_SCALE = 0.01f;
    public static final int MODE_DECELERATE = 1;
    public static final int MODE_DISABLE = 0;
    public static final int MODE_UNIFORM = 2;
    private static final float SCALE_FACTOR = 0.6f;
    private static final float TRACKBALL_SCALE_FACTOR = 20.0f;
    private int autoScrollMode;
    private float centerX;
    private float centerY;

    @NotNull
    private float[] darkColor;
    private float downX;
    private float downY;
    private boolean isChange;
    private boolean isOnTouch;

    @Nullable
    private ViewGroup.MarginLayoutParams layoutParams;

    @NotNull
    private float[] lightColor;
    private float mAngleX;
    private float mAngleY;

    @Nullable
    private PlanetCalculator mPlanetCalculator;
    private float mScaleX;

    @Nullable
    private TimerTask mTimerTask;
    private boolean manualScroll;
    private int minSize;
    private boolean multiplePointer;

    @Nullable
    private OnTagClickListener onTagClickListener;

    @NotNull
    private PlanetAdapter planetAdapter;
    private float radius;
    private float radiusPercent;
    private float speed;
    private float startDistance;
    private float startX;
    private float startY;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/view/planet/PlanetsView$OnTagClickListener;", "", "onItemClick", "", "parent", "Landroid/view/ViewGroup;", "view", "Landroid/view/View;", "position", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public interface OnTagClickListener {
        void onItemClick(@Nullable ViewGroup parent, @Nullable View view, int position);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlanetsView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.speed = DEFAULT_SCROLL_SPEED;
        this.mAngleX = 0.5f;
        this.mAngleY = 0.5f;
        this.radiusPercent = DEFAULT_RADIUS_PERCENT;
        this.darkColor = new float[]{1.0f, 0.0f, 0.0f, 1.0f};
        this.lightColor = new float[]{0.9412f, 0.7686f, 0.2f, 1.0f};
        this.manualScroll = true;
        this.planetAdapter = new NullPlanetAdapter();
        this.isChange = true;
        init(context, null);
    }

    private final void addListener(View view, final int position) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.view.planet.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    PlanetsView.addListener$lambda$6(PlanetsView.this, position, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addListener$lambda$6(PlanetsView planetsView, int i, View view) {
        OnTagClickListener onTagClickListener = planetsView.onTagClickListener;
        if (onTagClickListener != null) {
            onTagClickListener.onItemClick(planetsView, view, i);
        }
    }

    private final float distance(float x, float y) {
        return (float) Math.sqrt((x * x) + (y * y));
    }

    private final boolean handleTouchEvent(MotionEvent event) {
        int pointerCount = event.getPointerCount();
        if (pointerCount > 1) {
            this.multiplePointer = true;
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked == 5 && event.getActionIndex() == 1) {
                            this.mScaleX = getScaleX();
                            this.startDistance = distance(event.getX(0) - event.getX(1), event.getY(0) - event.getY(1));
                            return true;
                        }
                    }
                } else {
                    if (pointerCount == 1 && !this.multiplePointer) {
                        float x = event.getX() - this.downX;
                        float y = event.getY() - this.downY;
                        if (isValidMove(x, y)) {
                            float f = this.radius;
                            float f2 = this.speed;
                            this.mAngleX = (y / f) * f2 * TRACKBALL_SCALE_FACTOR;
                            this.mAngleY = ((-x) / f) * f2 * TRACKBALL_SCALE_FACTOR;
                            processTouch();
                            this.downX = event.getX();
                            this.downY = event.getY();
                        }
                        return isValidMove(this.downX - this.startX, this.downY - this.startY);
                    }
                    if (pointerCount == 2) {
                        float distance = distance(event.getX(0) - event.getX(1), event.getY(0) - event.getY(1));
                        float coerceIn = RangesKt.coerceIn((((distance - this.startDistance) / (distance * 2)) + 1) * this.mScaleX, 1.0f, 1.0f);
                        setScaleX(coerceIn);
                        setScaleY(coerceIn);
                        return true;
                    }
                    return false;
                }
            }
            this.multiplePointer = false;
            this.isOnTouch = false;
        } else {
            this.isOnTouch = true;
            this.downX = event.getX();
            float y2 = event.getY();
            this.downY = y2;
            this.startX = this.downX;
            this.startY = y2;
        }
        return false;
    }

    @SuppressLint({"WrongConstant"})
    private final void init(Context context, AttributeSet attrs) {
        this.isChange = true;
        setFocusableInTouchMode(true);
        this.mPlanetCalculator = new PlanetCalculator(0.0f, 1, (DefaultConstructorMarker) null);
        if (attrs != null) {
            int[] iArr = R.styleable.PlanetsView;
            Intrinsics.checkNotNullExpressionValue(iArr, "PlanetsView");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr, 0, 0);
            setAutoScrollMode(obtainStyledAttributes.getInteger(0, 0));
            setManualScroll(obtainStyledAttributes.getBoolean(3, true));
            this.mAngleX = obtainStyledAttributes.getFloat(6, 0.5f);
            this.mAngleY = obtainStyledAttributes.getFloat(7, 0.5f);
            setLightColor(obtainStyledAttributes.getColor(2, -1));
            setDarkColor(obtainStyledAttributes.getColor(1, RoundedDrawable.DEFAULT_BORDER_COLOR));
            setRadiusPercent(obtainStyledAttributes.getFloat(4, DEFAULT_RADIUS_PERCENT));
            setScrollSpeed(obtainStyledAttributes.getFloat(5, DEFAULT_SCROLL_SPEED));
            obtainStyledAttributes.recycle();
        }
        initializeScreenSize();
        initFromAdapter();
    }

    private final void initFromAdapter() {
        post(new Runnable() { // from class: com.qiahao.nextvideo.view.planet.b
            @Override // java.lang.Runnable
            public final void run() {
                PlanetsView.initFromAdapter$lambda$5(PlanetsView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initFromAdapter$lambda$5(PlanetsView planetsView) {
        planetsView.centerX = (planetsView.getRight() - planetsView.getLeft()) / DEFAULT_SCROLL_SPEED;
        float bottom = (planetsView.getBottom() - planetsView.getTop()) / DEFAULT_SCROLL_SPEED;
        planetsView.centerY = bottom;
        float min = Math.min(planetsView.centerX, bottom) * planetsView.radiusPercent;
        planetsView.radius = min;
        PlanetCalculator planetCalculator = planetsView.mPlanetCalculator;
        if (planetCalculator != null) {
            planetCalculator.setRadius(min);
            planetCalculator.setTagColorLight(planetsView.lightColor);
            planetCalculator.setTagColorDark(planetsView.darkColor);
            planetCalculator.clear();
            int getCount = planetsView.planetAdapter.getGetCount();
            for (int i = 0; i < getCount; i++) {
                PlanetModel planetModel = new PlanetModel(planetsView.planetAdapter.getPopularity(i));
                planetModel.setView(planetsView.planetAdapter.getView(planetsView.getContext(), i, planetsView));
                planetCalculator.add(planetModel);
                planetsView.addListener(planetModel.getView(), i);
            }
            planetCalculator.create(true);
            planetCalculator.setAngleX(planetsView.mAngleX);
            planetCalculator.setAngleY(planetsView.mAngleY);
            planetCalculator.update();
        }
        planetsView.resetChildren();
    }

    @SuppressLint({"WrongConstant"})
    private final void initializeScreenSize() {
        Display defaultDisplay;
        if (Build.VERSION.SDK_INT >= 30) {
            defaultDisplay = getContext().getDisplay();
        } else {
            Object systemService = getContext().getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        }
        Point point = new Point();
        if (defaultDisplay != null) {
            defaultDisplay.getSize(point);
        }
        int i = point.x;
        int i2 = point.y;
        if (i2 < i) {
            i = i2;
        }
        this.minSize = i;
    }

    private final boolean isValidMove(float dx, float dy) {
        float scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        if (Math.abs(dx) <= scaledTouchSlop && Math.abs(dy) <= scaledTouchSlop) {
            return false;
        }
        return true;
    }

    private final void processTouch() {
        PlanetModel planetModel;
        View view;
        boolean z;
        boolean z2;
        float f = this.mAngleX * ANGLE_DECAY_FACTOR;
        float f2 = this.mAngleY * ANGLE_DECAY_FACTOR;
        if (Math.abs(f) > 0.2f || Math.abs(f2) > 0.2f) {
            this.mAngleX = f;
            this.mAngleY = f2;
        }
        PlanetCalculator planetCalculator = this.mPlanetCalculator;
        if (planetCalculator != null) {
            planetCalculator.setAngleX(this.mAngleX);
            planetCalculator.setAngleY(this.mAngleY);
            planetCalculator.update();
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            PlanetCalculator planetCalculator2 = this.mPlanetCalculator;
            if (planetCalculator2 != null && (planetModel = planetCalculator2.get(i)) != null && (view = planetModel.getView()) != null && view.getWidth() != 0 && view.getVisibility() != 8) {
                this.planetAdapter.onThemeColorChanged(view, planetModel.getColor());
                float scale = planetModel.getScale() * SCALE_FACTOR;
                if (scale <= 0.0f) {
                    scale = MIN_SCALE;
                }
                view.setScaleX(scale);
                view.setScaleY(scale);
                if (planetModel.getScale() >= 1.0f) {
                    z = true;
                } else {
                    z = false;
                }
                view.setClickable(z);
                float alpha = planetModel.getAlpha() * ALPHA_FACTOR;
                if (alpha < MIN_ALPHA) {
                    alpha = MIN_ALPHA;
                }
                view.setAlpha(alpha);
                float loc2DX = (this.centerX + planetModel.getLoc2DX()) - (view.getMeasuredWidth() / 2);
                float loc2DY = (this.centerY + planetModel.getLoc2DY()) - (view.getMeasuredHeight() / 2);
                if (view.getTag() instanceof float[]) {
                    Object tag = view.getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.FloatArray");
                    float[] fArr = (float[]) tag;
                    if (fArr.length == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        view.setTranslationX(loc2DX - fArr[0]);
                        view.setTranslationY(loc2DY - fArr[1]);
                        if (Math.abs(this.mAngleX) <= this.speed && Math.abs(this.mAngleY) <= this.speed) {
                            view.invalidate();
                        }
                    }
                }
            }
        }
    }

    private final void resetChildren() {
        List<PlanetModel> tagList;
        removeAllViews();
        PlanetCalculator planetCalculator = this.mPlanetCalculator;
        if (planetCalculator != null && (tagList = planetCalculator.getTagList()) != null) {
            Iterator<T> it = tagList.iterator();
            while (it.hasNext()) {
                View view = ((PlanetModel) it.next()).getView();
                if (view != null) {
                    addView(view);
                }
            }
        }
    }

    private final void setDarkColor(int color) {
        this.darkColor = new float[]{Color.alpha(color) / 255.0f, Color.red(color) / 255.0f, Color.green(color) / 255.0f, Color.blue(color) / 255.0f};
        onChange();
    }

    private final void setLightColor(int color) {
        this.lightColor = new float[]{Color.alpha(color) / 255.0f, Color.red(color) / 255.0f, Color.green(color) / 255.0f, Color.blue(color) / 255.0f};
        onChange();
    }

    private final void setManualScroll(boolean manualScroll) {
        this.manualScroll = manualScroll;
    }

    private final void setRadiusPercent(float percent) {
        double d = percent;
        if (0.0d <= d && d <= 1.0d) {
            this.radiusPercent = percent;
            onChange();
            return;
        }
        throw new IllegalArgumentException("Percent value not in range 0 to 1.");
    }

    private final void setScrollSpeed(float scrollSpeed) {
        this.speed = RangesKt.coerceAtLeast(scrollSpeed, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startOrStop$lambda$8$lambda$7(PlanetsView planetsView, long j) {
        planetsView.run();
        return Unit.INSTANCE;
    }

    public final int getAutoScrollMode() {
        return this.autoScrollMode;
    }

    @Override // com.qiahao.nextvideo.view.planet.PlanetAdapter.OnDataSetChangeListener
    public void onChange() {
        this.isChange = true;
        initFromAdapter();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        TimerTask timerTask = this.mTimerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
        this.mTimerTask = null;
        this.isChange = true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.manualScroll) {
            return handleTouchEvent(ev);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        PlanetModel planetModel;
        if (!this.isChange) {
            return;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            PlanetCalculator planetCalculator = this.mPlanetCalculator;
            if (planetCalculator != null) {
                planetModel = planetCalculator.get(i);
            } else {
                planetModel = null;
            }
            if (childAt != null && childAt.getVisibility() != 8 && planetModel != null) {
                this.planetAdapter.onThemeColorChanged(childAt, planetModel.getColor());
                float scale = planetModel.getScale() * SCALE_FACTOR;
                if (scale <= 0.0f) {
                    scale = MIN_SCALE;
                }
                childAt.setScaleX(scale);
                childAt.setScaleY(scale);
                float alpha = planetModel.getAlpha() * ALPHA_FACTOR;
                if (alpha < MIN_ALPHA) {
                    alpha = MIN_ALPHA;
                }
                childAt.setAlpha(alpha);
                float loc2DX = (this.centerX + planetModel.getLoc2DX()) - (childAt.getMeasuredWidth() / 2);
                float loc2DY = (this.centerY + planetModel.getLoc2DY()) - (childAt.getMeasuredHeight() / 2);
                childAt.layout((int) loc2DX, (int) loc2DY, (int) (childAt.getMeasuredWidth() + loc2DX), (int) (childAt.getMeasuredHeight() + loc2DY));
                childAt.setTag(new float[]{loc2DX, loc2DY});
            }
        }
        if (getChildCount() != 0) {
            this.isChange = false;
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int i2;
        int i3;
        int i4;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
        int mode = View.MeasureSpec.getMode(widthMeasureSpec);
        int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
        ViewGroup.MarginLayoutParams marginLayoutParams = this.layoutParams;
        if (marginLayoutParams == null) {
            if (marginLayoutParams == null) {
                marginLayoutParams = new ViewGroup.MarginLayoutParams(0, 0);
            }
            this.layoutParams = marginLayoutParams;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = this.layoutParams;
        if (marginLayoutParams2 != null) {
            i = marginLayoutParams2.leftMargin;
        } else {
            i = 0;
        }
        if (marginLayoutParams2 != null) {
            i2 = marginLayoutParams2.rightMargin;
        } else {
            i2 = 0;
        }
        int i5 = i + i2;
        if (marginLayoutParams2 != null) {
            i3 = marginLayoutParams2.topMargin;
        } else {
            i3 = 0;
        }
        if (marginLayoutParams2 != null) {
            i4 = marginLayoutParams2.bottomMargin;
        } else {
            i4 = 0;
        }
        int i6 = i3 + i4;
        if (mode != 1073741824) {
            size = this.minSize - i5;
        }
        if (mode2 != 1073741824) {
            size2 = this.minSize - i6;
        }
        setMeasuredDimension(size, size2);
        measureChildren(0, 0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.manualScroll) {
            handleTouchEvent(e);
            return true;
        }
        return super.onTouchEvent(e);
    }

    @Override // android.view.View
    public boolean onTrackballEvent(@NotNull MotionEvent e) {
        Intrinsics.checkNotNullParameter(e, "e");
        if (this.manualScroll) {
            float x = e.getX();
            float y = e.getY();
            float f = this.speed;
            float f2 = y * f * TRACKBALL_SCALE_FACTOR;
            this.mAngleX = f2;
            this.mAngleY = (-x) * f * TRACKBALL_SCALE_FACTOR;
            PlanetCalculator planetCalculator = this.mPlanetCalculator;
            if (planetCalculator != null) {
                planetCalculator.setAngleX(f2);
                planetCalculator.setAngleY(this.mAngleY);
                planetCalculator.update();
            }
            resetChildren();
            return true;
        }
        return true;
    }

    public final void reset() {
        this.isChange = true;
        PlanetCalculator planetCalculator = this.mPlanetCalculator;
        if (planetCalculator != null) {
            planetCalculator.reset();
        }
        resetChildren();
    }

    public final void run() {
        int i;
        if (!this.isOnTouch && (i = this.autoScrollMode) != 0) {
            if (i == 1) {
                if (Math.abs(this.mAngleX) > 0.2f) {
                    float f = this.mAngleX;
                    this.mAngleX = f - (f * DECELERATION_FACTOR);
                }
                if (Math.abs(this.mAngleY) > 0.2f) {
                    float f2 = this.mAngleY;
                    this.mAngleY = f2 - (DECELERATION_FACTOR * f2);
                }
            }
            processTouch();
        }
    }

    public final void setAdapter(@NotNull PlanetAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.planetAdapter = adapter;
        adapter.setOnDataSetChangeListener(this);
        onChange();
    }

    public final void setAutoScrollMode(int i) {
        this.autoScrollMode = i;
    }

    public final void setOnTagClickListener(@Nullable OnTagClickListener listener) {
        this.onTagClickListener = listener;
    }

    public final void startOrStop(boolean isRunning) {
        boolean z;
        BaseActivity activity;
        TimerTask timerTask;
        if (this.mTimerTask != null) {
            z = true;
        } else {
            z = false;
        }
        if (isRunning != z && (activity = HiloUtils.INSTANCE.getActivity(getContext())) != null) {
            if (isRunning) {
                TimerTask timerTask2 = this.mTimerTask;
                if (timerTask2 != null) {
                    timerTask2.cancel();
                }
                timerTask = TimerKtxKt.loopTask(activity, false, 20L, new Function1() { // from class: com.qiahao.nextvideo.view.planet.c
                    public final Object invoke(Object obj) {
                        Unit startOrStop$lambda$8$lambda$7;
                        startOrStop$lambda$8$lambda$7 = PlanetsView.startOrStop$lambda$8$lambda$7(PlanetsView.this, ((Long) obj).longValue());
                        return startOrStop$lambda$8$lambda$7;
                    }
                });
            } else {
                TimerTask timerTask3 = this.mTimerTask;
                if (timerTask3 != null) {
                    timerTask3.cancel();
                }
                timerTask = null;
            }
            this.mTimerTask = timerTask;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlanetsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.speed = DEFAULT_SCROLL_SPEED;
        this.mAngleX = 0.5f;
        this.mAngleY = 0.5f;
        this.radiusPercent = DEFAULT_RADIUS_PERCENT;
        this.darkColor = new float[]{1.0f, 0.0f, 0.0f, 1.0f};
        this.lightColor = new float[]{0.9412f, 0.7686f, 0.2f, 1.0f};
        this.manualScroll = true;
        this.planetAdapter = new NullPlanetAdapter();
        this.isChange = true;
        init(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PlanetsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.speed = DEFAULT_SCROLL_SPEED;
        this.mAngleX = 0.5f;
        this.mAngleY = 0.5f;
        this.radiusPercent = DEFAULT_RADIUS_PERCENT;
        this.darkColor = new float[]{1.0f, 0.0f, 0.0f, 1.0f};
        this.lightColor = new float[]{0.9412f, 0.7686f, 0.2f, 1.0f};
        this.manualScroll = true;
        this.planetAdapter = new NullPlanetAdapter();
        this.isChange = true;
        init(context, attributeSet);
    }
}
