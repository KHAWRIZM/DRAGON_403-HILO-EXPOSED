package com.skydoves.transformationlayout;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.transition.PathMotion;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.skydoves.transformationlayout.TransformationLayout;
import com.taobao.accs.common.Constants;
import com.therouter.inject.DebugOnlyKt;
import i8.i;
import i8.j;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.parcelize.Parcelize;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002:\u0007{|}~\u007f\u0080\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u0010U\u001a\u00020V2\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010U\u001a\u00020V2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010W\u001a\u00020\u000bH\u0002J\u0010\u0010X\u001a\u00020V2\u0006\u0010Y\u001a\u00020ZH\u0002J\u000e\u0010[\u001a\u00020V2\u0006\u0010P\u001a\u00020QJ\u001a\u0010[\u001a\u00020V2\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020V0]J\u000e\u0010^\u001a\u00020V2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020dJ\u0016\u0010e\u001a\u00020`2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010c\u001a\u00020dJ\u0016\u0010f\u001a\u00020`2\u0006\u0010g\u001a\u00020\u000e2\u0006\u0010c\u001a\u00020dJ\u001a\u0010h\u001a\u00020`2\u0006\u0010i\u001a\u00020d2\n\b\u0002\u0010c\u001a\u0004\u0018\u00010dJ\u0006\u0010j\u001a\u00020kJ\u0006\u0010l\u001a\u00020mJ\u000e\u0010n\u001a\u00020V2\u0006\u0010o\u001a\u00020pJ\u0016\u0010q\u001a\u00020V2\u0006\u0010o\u001a\u00020p2\u0006\u0010r\u001a\u00020\u0015J\u0006\u0010n\u001a\u00020VJ\u000e\u0010q\u001a\u00020V2\u0006\u0010r\u001a\u00020\u0015J\u000e\u0010s\u001a\u00020V2\u0006\u0010o\u001a\u00020pJ\u0016\u0010t\u001a\u00020V2\u0006\u0010o\u001a\u00020p2\u0006\u0010r\u001a\u00020\u0015J\u0006\u0010s\u001a\u00020VJ\u000e\u0010t\u001a\u00020V2\u0006\u0010r\u001a\u00020\u0015J \u0010u\u001a\u00020V2\u0006\u0010o\u001a\u00020p2\u0006\u0010v\u001a\u00020\u000e2\u0006\u0010w\u001a\u00020\u000eH\u0002J\u0018\u0010x\u001a\u00020y2\u0006\u0010v\u001a\u00020\u000e2\u0006\u0010w\u001a\u00020\u000eH\u0002J\b\u0010z\u001a\u00020VH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u0015X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R\u001e\u0010(\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001e\u0010+\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R\u001a\u0010.\u001a\u00020/X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001a\u0010@\u001a\u00020AX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020AX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER\u001a\u0010I\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0012\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0012\"\u0004\bO\u0010LR\u0014\u0010P\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010R\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0017\"\u0004\bT\u0010\u0019¨\u0006\u0081\u0001"}, d2 = {"Lcom/skydoves/transformationlayout/TransformationLayout;", "Landroid/widget/FrameLayout;", "Lcom/skydoves/transformationlayout/TransformationParams;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "targetView", "Landroid/view/View;", "value", "", "isTransformed", "()Z", "isTransforming", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "pathMotion", "Lcom/skydoves/transformationlayout/TransformationLayout$Motion;", "getPathMotion", "()Lcom/skydoves/transformationlayout/TransformationLayout$Motion;", "setPathMotion", "(Lcom/skydoves/transformationlayout/TransformationLayout$Motion;)V", "zOrder", "getZOrder", "()I", "setZOrder", "(I)V", "containerColor", "getContainerColor", "setContainerColor", "allContainerColors", "getAllContainerColors", "setAllContainerColors", "scrimColor", "getScrimColor", "setScrimColor", "direction", "Lcom/skydoves/transformationlayout/TransformationLayout$Direction;", "getDirection", "()Lcom/skydoves/transformationlayout/TransformationLayout$Direction;", "setDirection", "(Lcom/skydoves/transformationlayout/TransformationLayout$Direction;)V", "fadeMode", "Lcom/skydoves/transformationlayout/TransformationLayout$FadeMode;", "getFadeMode", "()Lcom/skydoves/transformationlayout/TransformationLayout$FadeMode;", "setFadeMode", "(Lcom/skydoves/transformationlayout/TransformationLayout$FadeMode;)V", "fitMode", "Lcom/skydoves/transformationlayout/TransformationLayout$FitMode;", "getFitMode", "()Lcom/skydoves/transformationlayout/TransformationLayout$FitMode;", "setFitMode", "(Lcom/skydoves/transformationlayout/TransformationLayout$FitMode;)V", "startElevation", "", "getStartElevation", "()F", "setStartElevation", "(F)V", "endElevation", "getEndElevation", "setEndElevation", "elevationShadowEnabled", "getElevationShadowEnabled", "setElevationShadowEnabled", "(Z)V", "holdAtEndEnabled", "getHoldAtEndEnabled", "setHoldAtEndEnabled", "onTransformFinishListener", "Lcom/skydoves/transformationlayout/OnTransformFinishListener;", "throttledTime", "getThrottledTime", "setThrottledTime", "getAttrs", "", "defStyleAttr", "setTypeArray", DebugOnlyKt.PACKAGE, "Landroid/content/res/TypedArray;", "setOnTransformFinishListener", "action", "Lkotlin/Function1;", "bindTargetView", "withActivity", "Landroid/os/Bundle;", AgooConstants.OPEN_ACTIIVTY_NAME, "Landroid/app/Activity;", "transitionName", "", "withContext", "withView", "view", "getBundle", "keyName", "getParams", "Lcom/skydoves/transformationlayout/TransformationLayout$Params;", "getParcelableParams", "Landroid/os/Parcelable;", "startTransform", "container", "Landroid/view/ViewGroup;", "startTransformWithDelay", "delay", "finishTransform", "finishTransformWithDelay", "beginDelayingAndTransform", "mStartView", "mEndView", "getTransform", "Lcom/google/android/material/transition/platform/MaterialContainerTransform;", "onFinishTransformation", "Params", "Direction", "FadeMode", "FitMode", "Motion", "Builder", "transformationlayout_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTransformationLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransformationLayout.kt\ncom/skydoves/transformationlayout/TransformationLayout\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,529:1\n1#2:530\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class TransformationLayout extends FrameLayout implements TransformationParams {
    private int allContainerColors;
    private int containerColor;

    @NotNull
    private Direction direction;
    private long duration;
    private boolean elevationShadowEnabled;
    private float endElevation;

    @NotNull
    private FadeMode fadeMode;

    @NotNull
    private FitMode fitMode;
    private boolean holdAtEndEnabled;
    private boolean isTransformed;
    private boolean isTransforming;

    @JvmField
    @Nullable
    public OnTransformFinishListener onTransformFinishListener;

    @NotNull
    private Motion pathMotion;
    private int scrimColor;
    private float startElevation;
    private View targetView;
    private long throttledTime;
    private int zOrder;

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\u000eJ\u0010\u0010\u0010\u001a\u00020\u00002\b\b\u0001\u0010\t\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0018J\u001a\u0010\u0017\u001a\u00020\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00190\u001bJ\u0006\u0010\u001d\u001a\u00020\u0007R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/skydoves/transformationlayout/TransformationLayout$Builder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "transformationLayout", "Lcom/skydoves/transformationlayout/TransformationLayout;", "setDuration", "value", "", "setPathMode", "Lcom/skydoves/transformationlayout/TransformationLayout$Motion;", "setZOrder", "", "setContainerColor", "setScrimColor", "setDirection", "Lcom/skydoves/transformationlayout/TransformationLayout$Direction;", "setFadeMode", "Lcom/skydoves/transformationlayout/TransformationLayout$FadeMode;", "setFitMode", "Lcom/skydoves/transformationlayout/TransformationLayout$FitMode;", "setOnTransformFinishListener", "Lcom/skydoves/transformationlayout/OnTransformFinishListener;", "", "action", "Lkotlin/Function1;", "", "build", "transformationlayout_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nTransformationLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransformationLayout.kt\ncom/skydoves/transformationlayout/TransformationLayout$Builder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,529:1\n1#2:530\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class Builder {

        @NotNull
        private final TransformationLayout transformationLayout;

        public Builder(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.transformationLayout = new TransformationLayout(context);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setOnTransformFinishListener$lambda$9(Function1 function1, boolean z) {
            function1.invoke(Boolean.valueOf(z));
        }

        @NotNull
        /* renamed from: build, reason: from getter */
        public final TransformationLayout getTransformationLayout() {
            return this.transformationLayout;
        }

        @NotNull
        public final Builder setContainerColor(int value) {
            this.transformationLayout.setContainerColor(value);
            return this;
        }

        @NotNull
        public final Builder setDirection(@NotNull Direction value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.transformationLayout.setDirection(value);
            return this;
        }

        @NotNull
        public final Builder setDuration(long value) {
            this.transformationLayout.setDuration(value);
            return this;
        }

        @NotNull
        public final Builder setFadeMode(@NotNull FadeMode value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.transformationLayout.setFadeMode(value);
            return this;
        }

        @NotNull
        public final Builder setFitMode(@NotNull FitMode value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.transformationLayout.setFitMode(value);
            return this;
        }

        @NotNull
        public final Builder setOnTransformFinishListener(@NotNull OnTransformFinishListener value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.transformationLayout.onTransformFinishListener = value;
            return this;
        }

        @NotNull
        public final Builder setPathMode(@NotNull Motion value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.transformationLayout.setPathMotion(value);
            return this;
        }

        @NotNull
        public final Builder setScrimColor(int value) {
            this.transformationLayout.setScrimColor(value);
            return this;
        }

        @NotNull
        public final Builder setZOrder(int value) {
            this.transformationLayout.setZOrder(value);
            return this;
        }

        public final /* synthetic */ void setOnTransformFinishListener(final Function1 action) {
            Intrinsics.checkNotNullParameter(action, "action");
            this.transformationLayout.onTransformFinishListener = new OnTransformFinishListener() { // from class: com.skydoves.transformationlayout.g
                @Override // com.skydoves.transformationlayout.OnTransformFinishListener
                public final void onFinish(boolean z) {
                    TransformationLayout.Builder.setOnTransformFinishListener$lambda$9(action, z);
                }
            };
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/skydoves/transformationlayout/TransformationLayout$Direction;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "AUTO", "ENTER", "RETURN", "transformationlayout_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class Direction {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Direction[] $VALUES;
        public static final Direction AUTO = new Direction("AUTO", 0, 0);
        public static final Direction ENTER = new Direction("ENTER", 1, 1);
        public static final Direction RETURN = new Direction("RETURN", 2, 2);
        private final int value;

        private static final /* synthetic */ Direction[] $values() {
            return new Direction[]{AUTO, ENTER, RETURN};
        }

        static {
            Direction[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Direction(String str, int i, int i2) {
            this.value = i2;
        }

        @NotNull
        public static EnumEntries<Direction> getEntries() {
            return $ENTRIES;
        }

        public static Direction valueOf(String str) {
            return (Direction) Enum.valueOf(Direction.class, str);
        }

        public static Direction[] values() {
            return (Direction[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/skydoves/transformationlayout/TransformationLayout$FadeMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "IN", "OUT", "CROSS", "THROUGH", "transformationlayout_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class FadeMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FadeMode[] $VALUES;
        private final int value;
        public static final FadeMode IN = new FadeMode("IN", 0, 0);
        public static final FadeMode OUT = new FadeMode("OUT", 1, 1);
        public static final FadeMode CROSS = new FadeMode("CROSS", 2, 2);
        public static final FadeMode THROUGH = new FadeMode("THROUGH", 3, 3);

        private static final /* synthetic */ FadeMode[] $values() {
            return new FadeMode[]{IN, OUT, CROSS, THROUGH};
        }

        static {
            FadeMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private FadeMode(String str, int i, int i2) {
            this.value = i2;
        }

        @NotNull
        public static EnumEntries<FadeMode> getEntries() {
            return $ENTRIES;
        }

        public static FadeMode valueOf(String str) {
            return (FadeMode) Enum.valueOf(FadeMode.class, str);
        }

        public static FadeMode[] values() {
            return (FadeMode[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/skydoves/transformationlayout/TransformationLayout$FitMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "AUTO", "WIDTH", "HEIGHT", "transformationlayout_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class FitMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ FitMode[] $VALUES;
        private final int value;
        public static final FitMode AUTO = new FitMode("AUTO", 0, 0);
        public static final FitMode WIDTH = new FitMode("WIDTH", 1, 1);
        public static final FitMode HEIGHT = new FitMode("HEIGHT", 2, 2);

        private static final /* synthetic */ FitMode[] $values() {
            return new FitMode[]{AUTO, WIDTH, HEIGHT};
        }

        static {
            FitMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private FitMode(String str, int i, int i2) {
            this.value = i2;
        }

        @NotNull
        public static EnumEntries<FitMode> getEntries() {
            return $ENTRIES;
        }

        public static FitMode valueOf(String str) {
            return (FitMode) Enum.valueOf(FitMode.class, str);
        }

        public static FitMode[] values() {
            return (FitMode[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\n"}, d2 = {"Lcom/skydoves/transformationlayout/TransformationLayout$Motion;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "ARC", "LINEAR", "getPathMotion", "Landroid/transition/PathMotion;", "transformationlayout_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class Motion {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Motion[] $VALUES;
        public static final Motion ARC = new Motion("ARC", 0, 0);
        public static final Motion LINEAR = new Motion("LINEAR", 1, 1);
        private final int value;

        private static final /* synthetic */ Motion[] $values() {
            return new Motion[]{ARC, LINEAR};
        }

        static {
            Motion[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Motion(String str, int i, int i2) {
            this.value = i2;
        }

        @NotNull
        public static EnumEntries<Motion> getEntries() {
            return $ENTRIES;
        }

        public static Motion valueOf(String str) {
            return (Motion) Enum.valueOf(Motion.class, str);
        }

        public static Motion[] values() {
            return (Motion[]) $VALUES.clone();
        }

        @Nullable
        public final PathMotion getPathMotion() {
            if (this.value == 0) {
                return new i();
            }
            return null;
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bB\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Bw\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010J\u001a\u00020\u0004HÆ\u0003J\t\u0010K\u001a\u00020\u0006HÆ\u0003J\t\u0010L\u001a\u00020\bHÆ\u0003J\t\u0010M\u001a\u00020\bHÆ\u0003J\t\u0010N\u001a\u00020\bHÆ\u0003J\t\u0010O\u001a\u00020\bHÆ\u0003J\t\u0010P\u001a\u00020\rHÆ\u0003J\t\u0010Q\u001a\u00020\u000fHÆ\u0003J\t\u0010R\u001a\u00020\u0011HÆ\u0003J\t\u0010S\u001a\u00020\u0013HÆ\u0003J\t\u0010T\u001a\u00020\u0013HÆ\u0003J\t\u0010U\u001a\u00020\u0016HÆ\u0003J\t\u0010V\u001a\u00020\u0016HÆ\u0003J\t\u0010W\u001a\u00020\u0019HÆ\u0003J\u0095\u0001\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0019HÆ\u0001J\u0006\u0010Y\u001a\u00020\bJ\u0013\u0010Z\u001a\u00020\u00162\b\u0010[\u001a\u0004\u0018\u00010\\HÖ\u0003J\t\u0010]\u001a\u00020\bHÖ\u0001J\t\u0010^\u001a\u00020\u0019HÖ\u0001J\u0016\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\t\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001a\u0010\n\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u001a\u0010\u000b\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u001a\u0010\f\u001a\u00020\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u0010\u000e\u001a\u00020\u000fX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u0010\u001a\u00020\u0011X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010\u0014\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010;\"\u0004\b?\u0010=R\u001a\u0010\u0015\u001a\u00020\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u001a\u0010\u0017\u001a\u00020\u0016X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010A\"\u0004\bE\u0010CR\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006d"}, d2 = {"Lcom/skydoves/transformationlayout/TransformationLayout$Params;", "Landroid/os/Parcelable;", "Lcom/skydoves/transformationlayout/TransformationParams;", "duration", "", "pathMotion", "Lcom/skydoves/transformationlayout/TransformationLayout$Motion;", "zOrder", "", "containerColor", "allContainerColors", "scrimColor", "direction", "Lcom/skydoves/transformationlayout/TransformationLayout$Direction;", "fadeMode", "Lcom/skydoves/transformationlayout/TransformationLayout$FadeMode;", "fitMode", "Lcom/skydoves/transformationlayout/TransformationLayout$FitMode;", "startElevation", "", "endElevation", "elevationShadowEnabled", "", "holdAtEndEnabled", "transitionName", "", "<init>", "(JLcom/skydoves/transformationlayout/TransformationLayout$Motion;IIIILcom/skydoves/transformationlayout/TransformationLayout$Direction;Lcom/skydoves/transformationlayout/TransformationLayout$FadeMode;Lcom/skydoves/transformationlayout/TransformationLayout$FitMode;FFZZLjava/lang/String;)V", "getDuration", "()J", "setDuration", "(J)V", "getPathMotion", "()Lcom/skydoves/transformationlayout/TransformationLayout$Motion;", "setPathMotion", "(Lcom/skydoves/transformationlayout/TransformationLayout$Motion;)V", "getZOrder", "()I", "setZOrder", "(I)V", "getContainerColor", "setContainerColor", "getAllContainerColors", "setAllContainerColors", "getScrimColor", "setScrimColor", "getDirection", "()Lcom/skydoves/transformationlayout/TransformationLayout$Direction;", "setDirection", "(Lcom/skydoves/transformationlayout/TransformationLayout$Direction;)V", "getFadeMode", "()Lcom/skydoves/transformationlayout/TransformationLayout$FadeMode;", "setFadeMode", "(Lcom/skydoves/transformationlayout/TransformationLayout$FadeMode;)V", "getFitMode", "()Lcom/skydoves/transformationlayout/TransformationLayout$FitMode;", "setFitMode", "(Lcom/skydoves/transformationlayout/TransformationLayout$FitMode;)V", "getStartElevation", "()F", "setStartElevation", "(F)V", "getEndElevation", "setEndElevation", "getElevationShadowEnabled", "()Z", "setElevationShadowEnabled", "(Z)V", "getHoldAtEndEnabled", "setHoldAtEndEnabled", "getTransitionName", "()Ljava/lang/String;", "setTransitionName", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", Constants.KEY_FLAGS, "transformationlayout_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final /* data */ class Params implements Parcelable, TransformationParams {

        @NotNull
        public static final Parcelable.Creator<Params> CREATOR = new Creator();
        private int allContainerColors;
        private int containerColor;

        @NotNull
        private Direction direction;
        private long duration;
        private boolean elevationShadowEnabled;
        private float endElevation;

        @NotNull
        private FadeMode fadeMode;

        @NotNull
        private FitMode fitMode;
        private boolean holdAtEndEnabled;

        @NotNull
        private Motion pathMotion;
        private int scrimColor;
        private float startElevation;

        @NotNull
        private String transitionName;
        private int zOrder;

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
        public static final class Creator implements Parcelable.Creator<Params> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Params createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Params(parcel.readLong(), Motion.valueOf(parcel.readString()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt(), Direction.valueOf(parcel.readString()), FadeMode.valueOf(parcel.readString()), FitMode.valueOf(parcel.readString()), parcel.readFloat(), parcel.readFloat(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Params[] newArray(int i) {
                return new Params[i];
            }
        }

        public Params(long j, @NotNull Motion motion, int i, int i2, int i3, int i4, @NotNull Direction direction, @NotNull FadeMode fadeMode, @NotNull FitMode fitMode, float f, float f2, boolean z, boolean z2, @NotNull String str) {
            Intrinsics.checkNotNullParameter(motion, "pathMotion");
            Intrinsics.checkNotNullParameter(direction, "direction");
            Intrinsics.checkNotNullParameter(fadeMode, "fadeMode");
            Intrinsics.checkNotNullParameter(fitMode, "fitMode");
            Intrinsics.checkNotNullParameter(str, "transitionName");
            this.duration = j;
            this.pathMotion = motion;
            this.zOrder = i;
            this.containerColor = i2;
            this.allContainerColors = i3;
            this.scrimColor = i4;
            this.direction = direction;
            this.fadeMode = fadeMode;
            this.fitMode = fitMode;
            this.startElevation = f;
            this.endElevation = f2;
            this.elevationShadowEnabled = z;
            this.holdAtEndEnabled = z2;
            this.transitionName = str;
        }

        /* renamed from: component1, reason: from getter */
        public final long getDuration() {
            return this.duration;
        }

        /* renamed from: component10, reason: from getter */
        public final float getStartElevation() {
            return this.startElevation;
        }

        /* renamed from: component11, reason: from getter */
        public final float getEndElevation() {
            return this.endElevation;
        }

        /* renamed from: component12, reason: from getter */
        public final boolean getElevationShadowEnabled() {
            return this.elevationShadowEnabled;
        }

        /* renamed from: component13, reason: from getter */
        public final boolean getHoldAtEndEnabled() {
            return this.holdAtEndEnabled;
        }

        @NotNull
        /* renamed from: component14, reason: from getter */
        public final String getTransitionName() {
            return this.transitionName;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final Motion getPathMotion() {
            return this.pathMotion;
        }

        /* renamed from: component3, reason: from getter */
        public final int getZOrder() {
            return this.zOrder;
        }

        /* renamed from: component4, reason: from getter */
        public final int getContainerColor() {
            return this.containerColor;
        }

        /* renamed from: component5, reason: from getter */
        public final int getAllContainerColors() {
            return this.allContainerColors;
        }

        /* renamed from: component6, reason: from getter */
        public final int getScrimColor() {
            return this.scrimColor;
        }

        @NotNull
        /* renamed from: component7, reason: from getter */
        public final Direction getDirection() {
            return this.direction;
        }

        @NotNull
        /* renamed from: component8, reason: from getter */
        public final FadeMode getFadeMode() {
            return this.fadeMode;
        }

        @NotNull
        /* renamed from: component9, reason: from getter */
        public final FitMode getFitMode() {
            return this.fitMode;
        }

        @NotNull
        public final Params copy(long duration, @NotNull Motion pathMotion, int zOrder, int containerColor, int allContainerColors, int scrimColor, @NotNull Direction direction, @NotNull FadeMode fadeMode, @NotNull FitMode fitMode, float startElevation, float endElevation, boolean elevationShadowEnabled, boolean holdAtEndEnabled, @NotNull String transitionName) {
            Intrinsics.checkNotNullParameter(pathMotion, "pathMotion");
            Intrinsics.checkNotNullParameter(direction, "direction");
            Intrinsics.checkNotNullParameter(fadeMode, "fadeMode");
            Intrinsics.checkNotNullParameter(fitMode, "fitMode");
            Intrinsics.checkNotNullParameter(transitionName, "transitionName");
            return new Params(duration, pathMotion, zOrder, containerColor, allContainerColors, scrimColor, direction, fadeMode, fitMode, startElevation, endElevation, elevationShadowEnabled, holdAtEndEnabled, transitionName);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Params)) {
                return false;
            }
            Params params = (Params) other;
            return this.duration == params.duration && this.pathMotion == params.pathMotion && this.zOrder == params.zOrder && this.containerColor == params.containerColor && this.allContainerColors == params.allContainerColors && this.scrimColor == params.scrimColor && this.direction == params.direction && this.fadeMode == params.fadeMode && this.fitMode == params.fitMode && Float.compare(this.startElevation, params.startElevation) == 0 && Float.compare(this.endElevation, params.endElevation) == 0 && this.elevationShadowEnabled == params.elevationShadowEnabled && this.holdAtEndEnabled == params.holdAtEndEnabled && Intrinsics.areEqual(this.transitionName, params.transitionName);
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public int getAllContainerColors() {
            return this.allContainerColors;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public int getContainerColor() {
            return this.containerColor;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        @NotNull
        public Direction getDirection() {
            return this.direction;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public long getDuration() {
            return this.duration;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public boolean getElevationShadowEnabled() {
            return this.elevationShadowEnabled;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public float getEndElevation() {
            return this.endElevation;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        @NotNull
        public FadeMode getFadeMode() {
            return this.fadeMode;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        @NotNull
        public FitMode getFitMode() {
            return this.fitMode;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public boolean getHoldAtEndEnabled() {
            return this.holdAtEndEnabled;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        @NotNull
        public Motion getPathMotion() {
            return this.pathMotion;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public int getScrimColor() {
            return this.scrimColor;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public float getStartElevation() {
            return this.startElevation;
        }

        @NotNull
        public final String getTransitionName() {
            return this.transitionName;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public int getZOrder() {
            return this.zOrder;
        }

        public int hashCode() {
            return (((((((((((((((((((((((((androidx.collection.c.a(this.duration) * 31) + this.pathMotion.hashCode()) * 31) + this.zOrder) * 31) + this.containerColor) * 31) + this.allContainerColors) * 31) + this.scrimColor) * 31) + this.direction.hashCode()) * 31) + this.fadeMode.hashCode()) * 31) + this.fitMode.hashCode()) * 31) + Float.floatToIntBits(this.startElevation)) * 31) + Float.floatToIntBits(this.endElevation)) * 31) + q2.a.a(this.elevationShadowEnabled)) * 31) + q2.a.a(this.holdAtEndEnabled)) * 31) + this.transitionName.hashCode();
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public void setAllContainerColors(int i) {
            this.allContainerColors = i;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public void setContainerColor(int i) {
            this.containerColor = i;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public void setDirection(@NotNull Direction direction) {
            Intrinsics.checkNotNullParameter(direction, "<set-?>");
            this.direction = direction;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public void setDuration(long j) {
            this.duration = j;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public void setElevationShadowEnabled(boolean z) {
            this.elevationShadowEnabled = z;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public void setEndElevation(float f) {
            this.endElevation = f;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public void setFadeMode(@NotNull FadeMode fadeMode) {
            Intrinsics.checkNotNullParameter(fadeMode, "<set-?>");
            this.fadeMode = fadeMode;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public void setFitMode(@NotNull FitMode fitMode) {
            Intrinsics.checkNotNullParameter(fitMode, "<set-?>");
            this.fitMode = fitMode;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public void setHoldAtEndEnabled(boolean z) {
            this.holdAtEndEnabled = z;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public void setPathMotion(@NotNull Motion motion) {
            Intrinsics.checkNotNullParameter(motion, "<set-?>");
            this.pathMotion = motion;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public void setScrimColor(int i) {
            this.scrimColor = i;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public void setStartElevation(float f) {
            this.startElevation = f;
        }

        public final void setTransitionName(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.transitionName = str;
        }

        @Override // com.skydoves.transformationlayout.TransformationParams
        public void setZOrder(int i) {
            this.zOrder = i;
        }

        @NotNull
        public String toString() {
            return "Params(duration=" + this.duration + ", pathMotion=" + this.pathMotion + ", zOrder=" + this.zOrder + ", containerColor=" + this.containerColor + ", allContainerColors=" + this.allContainerColors + ", scrimColor=" + this.scrimColor + ", direction=" + this.direction + ", fadeMode=" + this.fadeMode + ", fitMode=" + this.fitMode + ", startElevation=" + this.startElevation + ", endElevation=" + this.endElevation + ", elevationShadowEnabled=" + this.elevationShadowEnabled + ", holdAtEndEnabled=" + this.holdAtEndEnabled + ", transitionName=" + this.transitionName + ")";
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(@NotNull Parcel dest, int flags) {
            Intrinsics.checkNotNullParameter(dest, "dest");
            dest.writeLong(this.duration);
            dest.writeString(this.pathMotion.name());
            dest.writeInt(this.zOrder);
            dest.writeInt(this.containerColor);
            dest.writeInt(this.allContainerColors);
            dest.writeInt(this.scrimColor);
            dest.writeString(this.direction.name());
            dest.writeString(this.fadeMode.name());
            dest.writeString(this.fitMode.name());
            dest.writeFloat(this.startElevation);
            dest.writeFloat(this.endElevation);
            dest.writeInt(this.elevationShadowEnabled ? 1 : 0);
            dest.writeInt(this.holdAtEndEnabled ? 1 : 0);
            dest.writeString(this.transitionName);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransformationLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        DefaultParamValues defaultParamValues = DefaultParamValues.INSTANCE;
        this.duration = defaultParamValues.getDuration();
        this.pathMotion = defaultParamValues.getPathMotion();
        this.zOrder = defaultParamValues.getZOrder();
        this.containerColor = defaultParamValues.getContainerColor();
        this.allContainerColors = defaultParamValues.getAllContainerColors();
        this.scrimColor = defaultParamValues.getScrimColor();
        this.direction = defaultParamValues.getDirection();
        this.fadeMode = defaultParamValues.getFadeMode();
        this.fitMode = defaultParamValues.getFitMode();
        this.startElevation = defaultParamValues.getStartElevation();
        this.endElevation = defaultParamValues.getEndElevation();
        this.elevationShadowEnabled = defaultParamValues.getElevationShadowEnabled();
        this.holdAtEndEnabled = defaultParamValues.getHoldAtEndEnabled();
        this.throttledTime = SystemClock.elapsedRealtime();
    }

    private final void beginDelayingAndTransform(ViewGroup container, View mStartView, View mEndView) {
        this.isTransforming = true;
        ViewExtensionKt.visible(mStartView, false);
        ViewExtensionKt.visible(mEndView, true);
        TransitionManager.beginDelayedTransition(container, getTransform(mStartView, mEndView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void finishTransform$lambda$11(TransformationLayout transformationLayout, ViewGroup viewGroup) {
        View view = transformationLayout.targetView;
        if (view != null) {
            if (transformationLayout.isTransformed && !transformationLayout.isTransforming) {
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("targetView");
                    view = null;
                }
                transformationLayout.beginDelayingAndTransform(viewGroup, view, transformationLayout);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("You must set a targetView using bindTargetView() or transformation_targetView attribute.If you already set targetView, check you use duplicated resource id to the TransformLayout.");
    }

    private final void getAttrs(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TransformationLayout);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            setTypeArray(obtainStyledAttributes);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static /* synthetic */ Bundle getBundle$default(TransformationLayout transformationLayout, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = transformationLayout.getTransitionName();
        }
        return transformationLayout.getBundle(str, str2);
    }

    private final j getTransform(View view, View view2) {
        j jVar = new j();
        jVar.w(view);
        jVar.q(view2);
        jVar.addTarget(view2);
        jVar.setDuration(getDuration());
        jVar.setPathMotion(getPathMotion().getPathMotion());
        jVar.n(getZOrder());
        jVar.m(getContainerColor());
        jVar.l(getAllContainerColors());
        jVar.u(getScrimColor());
        jVar.x(getDirection().getValue());
        jVar.r(getFadeMode().getValue());
        jVar.s(getFitMode().getValue());
        jVar.v(getStartElevation());
        jVar.p(getEndElevation());
        jVar.o(getElevationShadowEnabled());
        jVar.t(getHoldAtEndEnabled());
        jVar.addListener(new Transition.TransitionListener() { // from class: com.skydoves.transformationlayout.TransformationLayout$getTransform$1$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition p0) {
                TransformationLayout.this.onFinishTransformation();
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition p0) {
                TransformationLayout.this.onFinishTransformation();
                TransformationLayout transformationLayout = TransformationLayout.this;
                OnTransformFinishListener onTransformFinishListener = transformationLayout.onTransformFinishListener;
                if (onTransformFinishListener != null) {
                    onTransformFinishListener.onFinish(transformationLayout.getIsTransformed());
                }
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition p0) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition p0) {
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition p0) {
            }
        });
        return jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onFinishTransformation() {
        this.isTransformed = !this.isTransformed;
        this.isTransforming = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setOnTransformFinishListener$lambda$2(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(z));
    }

    private final void setTypeArray(TypedArray a) {
        Motion motion;
        Direction direction;
        FadeMode fadeMode;
        FitMode fitMode;
        final int resourceId = a.getResourceId(R.styleable.TransformationLayout_transformation_targetView, -1);
        if (resourceId != -1) {
            post(new Runnable() { // from class: com.skydoves.transformationlayout.c
                @Override // java.lang.Runnable
                public final void run() {
                    TransformationLayout.setTypeArray$lambda$1$lambda$0(TransformationLayout.this, resourceId);
                }
            });
        }
        setDuration(a.getInteger(R.styleable.TransformationLayout_transformation_duration, (int) getDuration()));
        if (a.getInteger(R.styleable.TransformationLayout_transformation_pathMode, 0) == 0) {
            motion = Motion.ARC;
        } else {
            motion = Motion.LINEAR;
        }
        setPathMotion(motion);
        setZOrder(a.getInteger(R.styleable.TransformationLayout_transformation_zOrder, getZOrder()));
        setContainerColor(a.getColor(R.styleable.TransformationLayout_transformation_containerColor, getContainerColor()));
        setAllContainerColors(a.getColor(R.styleable.TransformationLayout_transformation_allContainerColor, getAllContainerColors()));
        setScrimColor(a.getColor(R.styleable.TransformationLayout_transformation_scrimColor, getScrimColor()));
        int integer = a.getInteger(R.styleable.TransformationLayout_transformation_direction, 0);
        if (integer != 0) {
            if (integer != 1) {
                direction = Direction.RETURN;
            } else {
                direction = Direction.ENTER;
            }
        } else {
            direction = Direction.AUTO;
        }
        setDirection(direction);
        int integer2 = a.getInteger(R.styleable.TransformationLayout_transformation_fadeMode, 0);
        if (integer2 != 0) {
            if (integer2 != 1) {
                if (integer2 != 2) {
                    fadeMode = FadeMode.THROUGH;
                } else {
                    fadeMode = FadeMode.CROSS;
                }
            } else {
                fadeMode = FadeMode.OUT;
            }
        } else {
            fadeMode = FadeMode.IN;
        }
        setFadeMode(fadeMode);
        int integer3 = a.getInteger(R.styleable.TransformationLayout_transformation_fitMode, 0);
        if (integer3 != 0) {
            if (integer3 != 1) {
                fitMode = FitMode.HEIGHT;
            } else {
                fitMode = FitMode.WIDTH;
            }
        } else {
            fitMode = FitMode.AUTO;
        }
        setFitMode(fitMode);
        setStartElevation(a.getFloat(R.styleable.TransformationLayout_transformation_startElevation, getStartElevation()));
        setEndElevation(a.getFloat(R.styleable.TransformationLayout_transformation_endElevation, getEndElevation()));
        setElevationShadowEnabled(a.getBoolean(R.styleable.TransformationLayout_transformation_elevationShadowEnabled, getElevationShadowEnabled()));
        setHoldAtEndEnabled(a.getBoolean(R.styleable.TransformationLayout_transformation_holdAtEndEnabled, getHoldAtEndEnabled()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTypeArray$lambda$1$lambda$0(TransformationLayout transformationLayout, int i) {
        View findViewById = transformationLayout.getRootView().findViewById(i);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        transformationLayout.bindTargetView(findViewById);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTransform$lambda$8(TransformationLayout transformationLayout, ViewGroup viewGroup) {
        if (transformationLayout.targetView != null) {
            if (!transformationLayout.isTransformed && !transformationLayout.isTransforming) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (elapsedRealtime - transformationLayout.throttledTime >= transformationLayout.getDuration()) {
                    transformationLayout.throttledTime = elapsedRealtime;
                    View view = transformationLayout.targetView;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("targetView");
                        view = null;
                    }
                    transformationLayout.beginDelayingAndTransform(viewGroup, transformationLayout, view);
                    return;
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("You must set a targetView using bindTargetView() or transformation_targetView attribute.If you already set targetView, check you use duplicated resource id to the TransformLayout.");
    }

    public final void bindTargetView(@NotNull View targetView) {
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        ViewExtensionKt.visible(targetView, false);
        this.targetView = targetView;
    }

    public final void finishTransform(@NotNull final ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        container.post(new Runnable() { // from class: com.skydoves.transformationlayout.a
            @Override // java.lang.Runnable
            public final void run() {
                TransformationLayout.finishTransform$lambda$11(TransformationLayout.this, container);
            }
        });
    }

    public final void finishTransformWithDelay(@NotNull final ViewGroup container, long delay) {
        Intrinsics.checkNotNullParameter(container, "container");
        postDelayed(new Runnable() { // from class: com.skydoves.transformationlayout.f
            @Override // java.lang.Runnable
            public final void run() {
                TransformationLayout.this.finishTransform(container);
            }
        }, delay);
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public int getAllContainerColors() {
        return this.allContainerColors;
    }

    @NotNull
    public final Bundle getBundle(@NotNull String keyName, @Nullable String transitionName) {
        Intrinsics.checkNotNullParameter(keyName, "keyName");
        if (transitionName != null) {
            setTransitionName(transitionName);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(keyName, getParams());
        return bundle;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public int getContainerColor() {
        return this.containerColor;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    @NotNull
    public Direction getDirection() {
        return this.direction;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public long getDuration() {
        return this.duration;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public boolean getElevationShadowEnabled() {
        return this.elevationShadowEnabled;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public float getEndElevation() {
        return this.endElevation;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    @NotNull
    public FadeMode getFadeMode() {
        return this.fadeMode;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    @NotNull
    public FitMode getFitMode() {
        return this.fitMode;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public boolean getHoldAtEndEnabled() {
        return this.holdAtEndEnabled;
    }

    @NotNull
    public final Params getParams() {
        long duration = getDuration();
        Motion pathMotion = getPathMotion();
        int zOrder = getZOrder();
        int containerColor = getContainerColor();
        int allContainerColors = getAllContainerColors();
        int scrimColor = getScrimColor();
        Direction direction = getDirection();
        FadeMode fadeMode = getFadeMode();
        FitMode fitMode = getFitMode();
        float startElevation = getStartElevation();
        float endElevation = getEndElevation();
        boolean elevationShadowEnabled = getElevationShadowEnabled();
        boolean holdAtEndEnabled = getHoldAtEndEnabled();
        String transitionName = getTransitionName();
        Intrinsics.checkNotNullExpressionValue(transitionName, "getTransitionName(...)");
        return new Params(duration, pathMotion, zOrder, containerColor, allContainerColors, scrimColor, direction, fadeMode, fitMode, startElevation, endElevation, elevationShadowEnabled, holdAtEndEnabled, transitionName);
    }

    @NotNull
    public final Parcelable getParcelableParams() {
        return getParams();
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    @NotNull
    public Motion getPathMotion() {
        return this.pathMotion;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public int getScrimColor() {
        return this.scrimColor;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public float getStartElevation() {
        return this.startElevation;
    }

    public final long getThrottledTime() {
        return this.throttledTime;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public int getZOrder() {
        return this.zOrder;
    }

    /* renamed from: isTransformed, reason: from getter */
    public final boolean getIsTransformed() {
        return this.isTransformed;
    }

    /* renamed from: isTransforming, reason: from getter */
    public final boolean getIsTransforming() {
        return this.isTransforming;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setAllContainerColors(int i) {
        this.allContainerColors = i;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setContainerColor(int i) {
        this.containerColor = i;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setDirection(@NotNull Direction direction) {
        Intrinsics.checkNotNullParameter(direction, "<set-?>");
        this.direction = direction;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setDuration(long j) {
        this.duration = j;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setElevationShadowEnabled(boolean z) {
        this.elevationShadowEnabled = z;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setEndElevation(float f) {
        this.endElevation = f;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setFadeMode(@NotNull FadeMode fadeMode) {
        Intrinsics.checkNotNullParameter(fadeMode, "<set-?>");
        this.fadeMode = fadeMode;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setFitMode(@NotNull FitMode fitMode) {
        Intrinsics.checkNotNullParameter(fitMode, "<set-?>");
        this.fitMode = fitMode;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setHoldAtEndEnabled(boolean z) {
        this.holdAtEndEnabled = z;
    }

    public final void setOnTransformFinishListener(@NotNull OnTransformFinishListener onTransformFinishListener) {
        Intrinsics.checkNotNullParameter(onTransformFinishListener, "onTransformFinishListener");
        this.onTransformFinishListener = onTransformFinishListener;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setPathMotion(@NotNull Motion motion) {
        Intrinsics.checkNotNullParameter(motion, "<set-?>");
        this.pathMotion = motion;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setScrimColor(int i) {
        this.scrimColor = i;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setStartElevation(float f) {
        this.startElevation = f;
    }

    public final void setThrottledTime(long j) {
        this.throttledTime = j;
    }

    @Override // com.skydoves.transformationlayout.TransformationParams
    public void setZOrder(int i) {
        this.zOrder = i;
    }

    public final void startTransform(@NotNull final ViewGroup container) {
        Intrinsics.checkNotNullParameter(container, "container");
        container.post(new Runnable() { // from class: com.skydoves.transformationlayout.e
            @Override // java.lang.Runnable
            public final void run() {
                TransformationLayout.startTransform$lambda$8(TransformationLayout.this, container);
            }
        });
    }

    public final void startTransformWithDelay(@NotNull final ViewGroup container, long delay) {
        Intrinsics.checkNotNullParameter(container, "container");
        postDelayed(new Runnable() { // from class: com.skydoves.transformationlayout.d
            @Override // java.lang.Runnable
            public final void run() {
                TransformationLayout.this.startTransform(container);
            }
        }, delay);
    }

    @NotNull
    public final Bundle withActivity(@NotNull Activity activity, @NotNull String transitionName) {
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        Intrinsics.checkNotNullParameter(transitionName, "transitionName");
        setTransitionName(transitionName);
        Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(activity, this, transitionName).toBundle();
        Intrinsics.checkNotNullExpressionValue(bundle, "toBundle(...)");
        return bundle;
    }

    @NotNull
    public final Bundle withContext(@NotNull Context context, @NotNull String transitionName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(transitionName, "transitionName");
        setTransitionName(transitionName);
        Activity activity = ContextExtensionKt.getActivity(context);
        if (activity != null) {
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(activity, this, transitionName).toBundle();
            Intrinsics.checkNotNullExpressionValue(bundle, "toBundle(...)");
            return bundle;
        }
        throw new IllegalArgumentException("The context parameter is must an activity's context!");
    }

    @NotNull
    public final Bundle withView(@NotNull View view, @NotNull String transitionName) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(transitionName, "transitionName");
        setTransitionName(transitionName);
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Activity activity = ContextExtensionKt.getActivity(context);
        if (activity != null) {
            Bundle bundle = ActivityOptions.makeSceneTransitionAnimation(activity, this, transitionName).toBundle();
            Intrinsics.checkNotNullExpressionValue(bundle, "toBundle(...)");
            return bundle;
        }
        throw new IllegalArgumentException("The context parameter is must an activity's context!");
    }

    public final void finishTransform() {
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        finishTransform((ViewGroup) parent);
    }

    public final void finishTransformWithDelay(long delay) {
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        finishTransformWithDelay((ViewGroup) parent, delay);
    }

    public final /* synthetic */ void setOnTransformFinishListener(final Function1 action) {
        Intrinsics.checkNotNullParameter(action, "action");
        setOnTransformFinishListener(new OnTransformFinishListener() { // from class: com.skydoves.transformationlayout.b
            @Override // com.skydoves.transformationlayout.OnTransformFinishListener
            public final void onFinish(boolean z) {
                TransformationLayout.setOnTransformFinishListener$lambda$2(action, z);
            }
        });
    }

    public final void startTransform() {
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        startTransform((ViewGroup) parent);
    }

    public final void startTransformWithDelay(long delay) {
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        startTransformWithDelay((ViewGroup) parent, delay);
    }

    private final void getAttrs(AttributeSet attributeSet, int defStyleAttr) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.TransformationLayout, defStyleAttr, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            setTypeArray(obtainStyledAttributes);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransformationLayout(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        DefaultParamValues defaultParamValues = DefaultParamValues.INSTANCE;
        this.duration = defaultParamValues.getDuration();
        this.pathMotion = defaultParamValues.getPathMotion();
        this.zOrder = defaultParamValues.getZOrder();
        this.containerColor = defaultParamValues.getContainerColor();
        this.allContainerColors = defaultParamValues.getAllContainerColors();
        this.scrimColor = defaultParamValues.getScrimColor();
        this.direction = defaultParamValues.getDirection();
        this.fadeMode = defaultParamValues.getFadeMode();
        this.fitMode = defaultParamValues.getFitMode();
        this.startElevation = defaultParamValues.getStartElevation();
        this.endElevation = defaultParamValues.getEndElevation();
        this.elevationShadowEnabled = defaultParamValues.getElevationShadowEnabled();
        this.holdAtEndEnabled = defaultParamValues.getHoldAtEndEnabled();
        this.throttledTime = SystemClock.elapsedRealtime();
        getAttrs(attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransformationLayout(@NotNull Context context, @NotNull AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, "attributeSet");
        DefaultParamValues defaultParamValues = DefaultParamValues.INSTANCE;
        this.duration = defaultParamValues.getDuration();
        this.pathMotion = defaultParamValues.getPathMotion();
        this.zOrder = defaultParamValues.getZOrder();
        this.containerColor = defaultParamValues.getContainerColor();
        this.allContainerColors = defaultParamValues.getAllContainerColors();
        this.scrimColor = defaultParamValues.getScrimColor();
        this.direction = defaultParamValues.getDirection();
        this.fadeMode = defaultParamValues.getFadeMode();
        this.fitMode = defaultParamValues.getFitMode();
        this.startElevation = defaultParamValues.getStartElevation();
        this.endElevation = defaultParamValues.getEndElevation();
        this.elevationShadowEnabled = defaultParamValues.getElevationShadowEnabled();
        this.holdAtEndEnabled = defaultParamValues.getHoldAtEndEnabled();
        this.throttledTime = SystemClock.elapsedRealtime();
        getAttrs(attributeSet, i);
    }
}
