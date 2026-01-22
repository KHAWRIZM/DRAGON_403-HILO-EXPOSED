package com.qhqc.core.basic.widget.svprogresshud;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.facebook.internal.NativeProtocol;
import com.qhqc.core.basic.widget.R;
import com.qhqc.core.basic.widget.svprogresshud.listener.OnDismissListener;
import com.qhqc.core.basic.widget.svprogresshud.view.SVCircleProgressBar;
import com.qhqc.core.basic.widget.svprogresshud.view.SVProgressDefaultView;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 M2\u00020\u0001:\u0003MNOB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u00122\u0006\u00102\u001a\u00020\u0012H\u0002J\u0006\u00103\u001a\u00020/J\u0006\u00104\u001a\u00020/J\b\u00105\u001a\u00020/H\u0004J\b\u00106\u001a\u00020/H\u0004J\b\u00107\u001a\u00020/H\u0004J\u0006\u0010\u0013\u001a\u00020\u0012J\b\u00108\u001a\u00020/H\u0002J\b\u00109\u001a\u00020/H\u0002J\u0010\u0010:\u001a\u00020/2\u0006\u0010;\u001a\u00020\u0012H\u0002J\u0010\u0010<\u001a\u00020/2\b\u0010=\u001a\u0004\u0018\u00010\tJ\u0010\u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020\u0017H\u0002J\u0010\u0010@\u001a\u00020/2\b\u0010A\u001a\u0004\u0018\u00010BJ\u0006\u0010C\u001a\u00020/J\u0010\u0010D\u001a\u00020/2\b\u0010A\u001a\u0004\u0018\u00010BJ\u0018\u0010D\u001a\u00020/2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010?\u001a\u00020\u0017J\u0010\u0010E\u001a\u00020/2\b\u0010A\u001a\u0004\u0018\u00010BJ\u0018\u0010E\u001a\u00020/2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010?\u001a\u00020\u0017J\u0010\u0010F\u001a\u00020/2\b\u0010A\u001a\u0004\u0018\u00010BJ\u0018\u0010F\u001a\u00020/2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010?\u001a\u00020\u0017J\u000e\u0010G\u001a\u00020/2\u0006\u0010?\u001a\u00020\u0017J\u0018\u0010H\u001a\u00020/2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010?\u001a\u00020\u0017J\u0010\u0010I\u001a\u00020/2\b\u0010A\u001a\u0004\u0018\u00010BJ\u0018\u0010I\u001a\u00020/2\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010?\u001a\u00020\u0017J\b\u0010J\u001a\u00020/H\u0002J\u0010\u0010K\u001a\u00020/2\b\u0010L\u001a\u0004\u0018\u00010BR\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u00030\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010%\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b&\u0010\u0010R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010)\u001a\u0004\u0018\u00010*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0010\u0010-\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/qhqc/core/basic/widget/svprogresshud/SVProgressHUD;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contextWeak", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "decorView", "Landroid/view/ViewGroup;", "gravity", "", "inAnim", "Landroid/view/animation/Animation;", "inAnimation", "getInAnimation", "()Landroid/view/animation/Animation;", "isDismissing", "", "isShowing", "mHandler", "Lcom/qhqc/core/basic/widget/svprogresshud/SVProgressHUD$MyHandler;", "mSVProgressHUDMaskType", "Lcom/qhqc/core/basic/widget/svprogresshud/SVProgressHUD$SVProgressHUDMaskType;", "mSharedView", "Lcom/qhqc/core/basic/widget/svprogresshud/view/SVProgressDefaultView;", "onCancelableTouchListener", "Landroid/view/View$OnTouchListener;", "onDismissListener", "Lcom/qhqc/core/basic/widget/svprogresshud/listener/OnDismissListener;", "getOnDismissListener", "()Lcom/qhqc/core/basic/widget/svprogresshud/listener/OnDismissListener;", "setOnDismissListener", "(Lcom/qhqc/core/basic/widget/svprogresshud/listener/OnDismissListener;)V", "outAnim", "outAnimListener", "Landroid/view/animation/Animation$AnimationListener;", "outAnimation", "getOutAnimation", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/widget/FrameLayout$LayoutParams;", "progressBar", "Lcom/qhqc/core/basic/widget/svprogresshud/view/SVCircleProgressBar;", "getProgressBar", "()Lcom/qhqc/core/basic/widget/svprogresshud/view/SVCircleProgressBar;", "rootView", "configMaskType", "", "bg", "clickable", "cancelable", "dismiss", "dismissImmediately", "initAnimation", "initDefaultView", "initViews", "onAttached", "scheduleDismiss", "setCancelable", "isCancelable", "setDecorView", "viewGroup", "setMaskType", "maskType", "setText", "string", "", "show", "showErrorWithStatus", "showInfoWithStatus", "showSuccessWithStatus", "showWithMaskType", "showWithProgress", "showWithStatus", "svShow", "updateStatus", "s", "Companion", "MyHandler", "SVProgressHUDMaskType", "basic_widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class SVProgressHUD {
    private static final long DISMISSDELAYED = 1000;

    @NotNull
    private final WeakReference<Context> contextWeak;

    @Nullable
    private ViewGroup decorView;
    private int gravity;

    @Nullable
    private Animation inAnim;
    private boolean isDismissing;
    private boolean isShowing;

    @NotNull
    private final MyHandler mHandler;

    @Nullable
    private SVProgressHUDMaskType mSVProgressHUDMaskType;

    @Nullable
    private SVProgressDefaultView mSharedView;

    @NotNull
    private final View.OnTouchListener onCancelableTouchListener;

    @Nullable
    private OnDismissListener onDismissListener;

    @Nullable
    private Animation outAnim;

    @NotNull
    private final Animation.AnimationListener outAnimListener;

    @NotNull
    private final FrameLayout.LayoutParams params;

    @Nullable
    private ViewGroup rootView;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R$\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/qhqc/core/basic/widget/svprogresshud/SVProgressHUD$MyHandler;", "Landroid/os/Handler;", "svProgressHUD", "Lcom/qhqc/core/basic/widget/svprogresshud/SVProgressHUD;", "(Lcom/qhqc/core/basic/widget/svprogresshud/SVProgressHUD;)V", "wr", "Ljava/lang/ref/WeakReference;", "getWr", "()Ljava/lang/ref/WeakReference;", "setWr", "(Ljava/lang/ref/WeakReference;)V", "handleMessage", "", "msg", "Landroid/os/Message;", "basic_widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class MyHandler extends Handler {

        @Nullable
        private WeakReference<SVProgressHUD> wr;

        public MyHandler(@Nullable SVProgressHUD sVProgressHUD) {
            this.wr = new WeakReference<>(sVProgressHUD);
        }

        @Nullable
        public final WeakReference<SVProgressHUD> getWr() {
            return this.wr;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            WeakReference<SVProgressHUD> weakReference = this.wr;
            if (weakReference != null) {
                Intrinsics.checkNotNull(weakReference);
                if (weakReference.get() != null) {
                    super.handleMessage(msg);
                    WeakReference<SVProgressHUD> weakReference2 = this.wr;
                    Intrinsics.checkNotNull(weakReference2);
                    SVProgressHUD sVProgressHUD = weakReference2.get();
                    Intrinsics.checkNotNull(sVProgressHUD);
                    sVProgressHUD.dismiss();
                }
            }
        }

        public final void setWr(@Nullable WeakReference<SVProgressHUD> weakReference) {
            this.wr = weakReference;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/qhqc/core/basic/widget/svprogresshud/SVProgressHUD$SVProgressHUDMaskType;", "", "(Ljava/lang/String;I)V", "None", "Clear", "Black", "Gradient", "ClearCancel", "BlackCancel", "GradientCancel", "basic_widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class SVProgressHUDMaskType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SVProgressHUDMaskType[] $VALUES;
        public static final SVProgressHUDMaskType None = new SVProgressHUDMaskType("None", 0);
        public static final SVProgressHUDMaskType Clear = new SVProgressHUDMaskType("Clear", 1);
        public static final SVProgressHUDMaskType Black = new SVProgressHUDMaskType("Black", 2);
        public static final SVProgressHUDMaskType Gradient = new SVProgressHUDMaskType("Gradient", 3);
        public static final SVProgressHUDMaskType ClearCancel = new SVProgressHUDMaskType("ClearCancel", 4);
        public static final SVProgressHUDMaskType BlackCancel = new SVProgressHUDMaskType("BlackCancel", 5);
        public static final SVProgressHUDMaskType GradientCancel = new SVProgressHUDMaskType("GradientCancel", 6);

        private static final /* synthetic */ SVProgressHUDMaskType[] $values() {
            return new SVProgressHUDMaskType[]{None, Clear, Black, Gradient, ClearCancel, BlackCancel, GradientCancel};
        }

        static {
            SVProgressHUDMaskType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private SVProgressHUDMaskType(String str, int i10) {
        }

        @NotNull
        public static EnumEntries<SVProgressHUDMaskType> getEntries() {
            return $ENTRIES;
        }

        public static SVProgressHUDMaskType valueOf(String str) {
            return (SVProgressHUDMaskType) Enum.valueOf(SVProgressHUDMaskType.class, str);
        }

        public static SVProgressHUDMaskType[] values() {
            return (SVProgressHUDMaskType[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SVProgressHUDMaskType.values().length];
            try {
                iArr[SVProgressHUDMaskType.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SVProgressHUDMaskType.Clear.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SVProgressHUDMaskType.ClearCancel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SVProgressHUDMaskType.Black.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[SVProgressHUDMaskType.BlackCancel.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[SVProgressHUDMaskType.Gradient.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[SVProgressHUDMaskType.GradientCancel.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SVProgressHUD(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.contextWeak = new WeakReference<>(context);
        this.params = new FrameLayout.LayoutParams(-1, -2, 80);
        this.gravity = 17;
        this.mHandler = new MyHandler(this);
        this.onCancelableTouchListener = new View.OnTouchListener() { // from class: com.qhqc.core.basic.widget.svprogresshud.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean onCancelableTouchListener$lambda$1;
                onCancelableTouchListener$lambda$1 = SVProgressHUD.onCancelableTouchListener$lambda$1(SVProgressHUD.this, view, motionEvent);
                return onCancelableTouchListener$lambda$1;
            }
        };
        this.outAnimListener = new Animation.AnimationListener() { // from class: com.qhqc.core.basic.widget.svprogresshud.SVProgressHUD$outAnimListener$1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(@NotNull Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SVProgressHUD.this.dismissImmediately();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(@NotNull Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(@NotNull Animation animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }
        };
        this.gravity = 17;
        initViews();
        initDefaultView();
        initAnimation();
    }

    private final void configMaskType(int bg, boolean clickable, boolean cancelable) {
        ViewGroup viewGroup = this.rootView;
        Intrinsics.checkNotNull(viewGroup);
        viewGroup.setBackgroundResource(bg);
        ViewGroup viewGroup2 = this.rootView;
        Intrinsics.checkNotNull(viewGroup2);
        viewGroup2.setClickable(clickable);
        setCancelable(cancelable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dismissImmediately$lambda$0(SVProgressHUD this$0) {
        SVProgressDefaultView sVProgressDefaultView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.decorView != null && this$0.rootView != null && (sVProgressDefaultView = this$0.mSharedView) != null) {
            Intrinsics.checkNotNull(sVProgressDefaultView);
            sVProgressDefaultView.dismiss();
            ViewGroup viewGroup = this$0.rootView;
            Intrinsics.checkNotNull(viewGroup);
            viewGroup.removeView(this$0.mSharedView);
            ViewGroup viewGroup2 = this$0.decorView;
            Intrinsics.checkNotNull(viewGroup2);
            viewGroup2.removeView(this$0.rootView);
            this$0.isShowing = false;
            this$0.isDismissing = false;
            OnDismissListener onDismissListener = this$0.onDismissListener;
            if (onDismissListener != null) {
                Intrinsics.checkNotNull(onDismissListener);
                onDismissListener.onDismiss(this$0);
            }
        }
    }

    private final void onAttached() {
        this.isShowing = true;
        ViewGroup viewGroup = this.decorView;
        Intrinsics.checkNotNull(viewGroup);
        viewGroup.addView(this.rootView);
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        if (sVProgressDefaultView.getParent() != null) {
            SVProgressDefaultView sVProgressDefaultView2 = this.mSharedView;
            Intrinsics.checkNotNull(sVProgressDefaultView2);
            ViewParent parent = sVProgressDefaultView2.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup) parent).removeView(this.mSharedView);
        }
        ViewGroup viewGroup2 = this.rootView;
        Intrinsics.checkNotNull(viewGroup2);
        viewGroup2.addView(this.mSharedView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCancelableTouchListener$lambda$1(SVProgressHUD this$0, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 0) {
            this$0.dismiss();
            this$0.setCancelable(false);
        }
        return false;
    }

    private final void scheduleDismiss() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.sendEmptyMessageDelayed(0, DISMISSDELAYED);
    }

    private final void setCancelable(boolean isCancelable) {
        ViewGroup viewGroup = this.rootView;
        Intrinsics.checkNotNull(viewGroup);
        View findViewById = viewGroup.findViewById(R.id.sv_outmost_container);
        if (isCancelable) {
            findViewById.setOnTouchListener(this.onCancelableTouchListener);
        } else {
            findViewById.setOnTouchListener(null);
        }
    }

    private final void setMaskType(SVProgressHUDMaskType maskType) {
        int i10;
        this.mSVProgressHUDMaskType = maskType;
        if (maskType == null) {
            i10 = -1;
        } else {
            i10 = WhenMappings.$EnumSwitchMapping$0[maskType.ordinal()];
        }
        switch (i10) {
            case 1:
                configMaskType(android.R.color.transparent, false, false);
                return;
            case 2:
                configMaskType(android.R.color.transparent, true, false);
                return;
            case 3:
                configMaskType(android.R.color.transparent, true, true);
                return;
            case 4:
                configMaskType(R.color.bgColor_overlay, true, false);
                return;
            case 5:
                configMaskType(R.color.bgColor_overlay, true, true);
                return;
            case 6:
                configMaskType(R.drawable.bg_overlay_gradient, true, false);
                return;
            case 7:
                configMaskType(R.drawable.bg_overlay_gradient, true, true);
                return;
            default:
                return;
        }
    }

    private final void svShow() {
        this.mHandler.removeCallbacksAndMessages(null);
        onAttached();
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        sVProgressDefaultView.startAnimation(this.inAnim);
    }

    public final void dismiss() {
        dismissImmediately();
    }

    public final void dismissImmediately() {
        ViewGroup viewGroup = this.decorView;
        Intrinsics.checkNotNull(viewGroup);
        viewGroup.post(new Runnable() { // from class: com.qhqc.core.basic.widget.svprogresshud.b
            @Override // java.lang.Runnable
            public final void run() {
                SVProgressHUD.dismissImmediately$lambda$0(SVProgressHUD.this);
            }
        });
    }

    @Nullable
    public final Animation getInAnimation() {
        Context context = this.contextWeak.get();
        if (context == null) {
            return null;
        }
        return AnimationUtils.loadAnimation(context, SVProgressHUDAnimateUtil.INSTANCE.getAnimationResource(this.gravity, true));
    }

    @Nullable
    public final OnDismissListener getOnDismissListener() {
        return this.onDismissListener;
    }

    @Nullable
    public final Animation getOutAnimation() {
        Context context = this.contextWeak.get();
        if (context == null) {
            return null;
        }
        return AnimationUtils.loadAnimation(context, SVProgressHUDAnimateUtil.INSTANCE.getAnimationResource(this.gravity, false));
    }

    @Nullable
    public final SVCircleProgressBar getProgressBar() {
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        return sVProgressDefaultView.getCircleProgressBar();
    }

    protected final void initAnimation() {
        if (this.inAnim == null) {
            this.inAnim = getInAnimation();
        }
        if (this.outAnim == null) {
            this.outAnim = getOutAnimation();
        }
    }

    protected final void initDefaultView() {
        Context context = this.contextWeak.get();
        if (context == null) {
            return;
        }
        SVProgressDefaultView sVProgressDefaultView = new SVProgressDefaultView(context);
        this.mSharedView = sVProgressDefaultView;
        this.params.gravity = this.gravity;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        sVProgressDefaultView.setLayoutParams(this.params);
    }

    protected final void initViews() {
        Context context = this.contextWeak.get();
        if (context == null) {
            return;
        }
        LayoutInflater from = LayoutInflater.from(context);
        View findViewById = ((Activity) context).getWindow().getDecorView().findViewById(android.R.id.content);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        this.decorView = (ViewGroup) findViewById;
        View inflate = from.inflate(R.layout.basic_widget_layout_svprogresshud, (ViewGroup) null, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        this.rootView = viewGroup;
        Intrinsics.checkNotNull(viewGroup);
        viewGroup.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    }

    public final boolean isShowing() {
        ViewGroup viewGroup = this.rootView;
        Intrinsics.checkNotNull(viewGroup);
        if (viewGroup.getParent() == null && !this.isShowing) {
            return false;
        }
        return true;
    }

    public final void setDecorView(@Nullable ViewGroup viewGroup) {
        if (!this.isShowing) {
            this.decorView = viewGroup;
        }
    }

    public final void setOnDismissListener(@Nullable OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    public final void setText(@Nullable String string) {
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        sVProgressDefaultView.setText(string);
    }

    public final void show() {
        if (isShowing()) {
            return;
        }
        setMaskType(SVProgressHUDMaskType.Black);
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        sVProgressDefaultView.show();
        svShow();
    }

    public final void showErrorWithStatus(@Nullable String string) {
        if (isShowing()) {
            return;
        }
        setMaskType(SVProgressHUDMaskType.Black);
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        sVProgressDefaultView.showErrorWithStatus(string);
        svShow();
        scheduleDismiss();
    }

    public final void showInfoWithStatus(@Nullable String string) {
        if (isShowing()) {
            return;
        }
        setMaskType(SVProgressHUDMaskType.Black);
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        sVProgressDefaultView.showInfoWithStatus(string);
        svShow();
        scheduleDismiss();
    }

    public final void showSuccessWithStatus(@Nullable String string) {
        if (isShowing()) {
            return;
        }
        setMaskType(SVProgressHUDMaskType.Black);
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        sVProgressDefaultView.showSuccessWithStatus(string);
        svShow();
        scheduleDismiss();
    }

    public final void showWithMaskType(@NotNull SVProgressHUDMaskType maskType) {
        Intrinsics.checkNotNullParameter(maskType, "maskType");
        if (isShowing()) {
            return;
        }
        setMaskType(maskType);
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        sVProgressDefaultView.show();
        svShow();
    }

    public final void showWithProgress(@Nullable String string, @NotNull SVProgressHUDMaskType maskType) {
        Intrinsics.checkNotNullParameter(maskType, "maskType");
        if (isShowing()) {
            return;
        }
        setMaskType(maskType);
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        sVProgressDefaultView.showWithProgress(string);
        svShow();
    }

    public final void showWithStatus(@Nullable String string) {
        if (isShowing()) {
            return;
        }
        setMaskType(SVProgressHUDMaskType.Black);
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        sVProgressDefaultView.showWithStatus(string);
        svShow();
    }

    public final void updateStatus(@Nullable String s10) {
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        sVProgressDefaultView.showWithStatus(s10);
    }

    public final void showWithStatus(@Nullable String string, @NotNull SVProgressHUDMaskType maskType) {
        Intrinsics.checkNotNullParameter(maskType, "maskType");
        if (isShowing()) {
            return;
        }
        setMaskType(maskType);
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        sVProgressDefaultView.showWithStatus(string);
        svShow();
    }

    public final void showErrorWithStatus(@Nullable String string, @NotNull SVProgressHUDMaskType maskType) {
        Intrinsics.checkNotNullParameter(maskType, "maskType");
        if (isShowing()) {
            return;
        }
        setMaskType(maskType);
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        sVProgressDefaultView.showErrorWithStatus(string);
        svShow();
        scheduleDismiss();
    }

    public final void showInfoWithStatus(@Nullable String string, @NotNull SVProgressHUDMaskType maskType) {
        Intrinsics.checkNotNullParameter(maskType, "maskType");
        if (isShowing()) {
            return;
        }
        setMaskType(maskType);
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        sVProgressDefaultView.showInfoWithStatus(string);
        svShow();
        scheduleDismiss();
    }

    public final void showSuccessWithStatus(@Nullable String string, @NotNull SVProgressHUDMaskType maskType) {
        Intrinsics.checkNotNullParameter(maskType, "maskType");
        if (isShowing()) {
            return;
        }
        setMaskType(maskType);
        SVProgressDefaultView sVProgressDefaultView = this.mSharedView;
        Intrinsics.checkNotNull(sVProgressDefaultView);
        sVProgressDefaultView.showSuccessWithStatus(string);
        svShow();
        scheduleDismiss();
    }
}
