package com.qiahao.nextvideo.ui.reusable.viewcontroller.host;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.s;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.controller.ViewController;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentationStyle;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.presentation.PresentingAnimation;
import com.qiahao.nextvideo.ui.reusable.viewcontroller.util.animation.AnimationEndListener;
import com.qiahao.nextvideo.utilities.AnimationUtilitiesKt;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\bH\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u0017J\u001d\u0010\u001a\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ5\u0010 \u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001e¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\b¢\u0006\u0004\b\"\u0010\u0017J\r\u0010#\u001a\u00020\b¢\u0006\u0004\b#\u0010\u0017J\r\u0010$\u001a\u00020\b¢\u0006\u0004\b$\u0010\u0017J%\u0010%\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001e¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u001cH\u0016¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b*\u0010\nJ!\u0010*\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\u00062\u0006\u0010,\u001a\u00020+H\u0016¢\u0006\u0004\b*\u0010-J\u0019\u0010.\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b.\u0010\nJ\u0019\u00101\u001a\u00020\u001c2\b\u00100\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0004\b1\u00102J\u0015\u00105\u001a\u00020\b2\u0006\u00104\u001a\u000203¢\u0006\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00109R&\u0010>\u001a\u0012\u0012\u0004\u0012\u00020<0;j\b\u0012\u0004\u0012\u00020<`=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R2\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\u000b0;j\b\u0012\u0004\u0012\u00020\u000b`=8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010?\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010F\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010(\"\u0004\bO\u0010PR\u0018\u0010Q\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR(\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010S\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0003\u0010T\u001a\u0004\bU\u0010VR\"\u0010W\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010M\u001a\u0004\bX\u0010(\"\u0004\bY\u0010PR\u0016\u0010[\u001a\u00020Z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0014\u0010^\u001a\u00020]8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u001d\u0010d\u001a\b\u0012\u0004\u0012\u00020\u000b0`8F¢\u0006\f\u0012\u0004\bc\u0010\u0017\u001a\u0004\ba\u0010bR\u0013\u0010g\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\be\u0010f¨\u0006h"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/host/ControllerHost;", "Landroid/widget/FrameLayout;", "Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;", AgooConstants.OPEN_ACTIIVTY_NAME, "<init>", "(Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;)V", "Landroid/view/View;", "view", "", "measureChild", "(Landroid/view/View;)V", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/ViewController;", "viewController", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/presentation/PresentationStyle;", AgooConstants.MESSAGE_BODY_STYLE, "Landroid/animation/ObjectAnimator;", "createExitAnimation", "(Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/ViewController;Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/presentation/PresentationStyle;)Landroid/animation/ObjectAnimator;", "createEnterAnimation", "createPushAnimation", "(Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/ViewController;)Landroid/animation/ObjectAnimator;", "createPopAnimation", "onlyAllowTopViewToReceiveTouch", "()V", "printStack", "onDestroy", "addBottom", "(Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/ViewController;Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;)V", "", "animated", "Lkotlin/Function0;", "completion", "push", "(Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/ViewController;Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;ZLkotlin/jvm/functions/Function0;)V", "popAll", "popToRoot", "popAllButTop", "pop", "(ZLkotlin/jvm/functions/Function0;)Z", "onBackPressed", "()Z", "child", "addView", "", "index", "(Landroid/view/View;I)V", "removeView", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/host/RemoveRootControllerHost;", "listener", "setRemoveRootControllerListener", "(Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/host/RemoveRootControllerHost;)V", "", "disappearRatio", "F", "dimRatio", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/host/DimView;", "Lkotlin/collections/ArrayList;", "dimCovers", "Ljava/util/ArrayList;", "controllers", "getControllers", "()Ljava/util/ArrayList;", "setControllers", "(Ljava/util/ArrayList;)V", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/host/OnOutsideClickListener;", "onOutsideClickListener", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/host/OnOutsideClickListener;", "getOnOutsideClickListener", "()Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/host/OnOutsideClickListener;", "setOnOutsideClickListener", "(Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/host/OnOutsideClickListener;)V", "dismissControllerHost", "Z", "getDismissControllerHost", "setDismissControllerHost", "(Z)V", "removeRootListener", "Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/host/RemoveRootControllerHost;", "value", "Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;", "getActivity", "()Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;", "transactionInProgress", "getTransactionInProgress", "setTransactionInProgress", "Landroid/graphics/Rect;", "testRect", "Landroid/graphics/Rect;", "Landroidx/core/view/s;", "detector", "Landroidx/core/view/s;", "", "getViewControllers", "()Ljava/util/List;", "getViewControllers$annotations", "viewControllers", "getTopViewController", "()Lcom/qiahao/nextvideo/ui/reusable/viewcontroller/controller/ViewController;", "topViewController", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nControllerHost.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ControllerHost.kt\ncom/qiahao/nextvideo/ui/reusable/viewcontroller/host/ControllerHost\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,614:1\n1869#2,2:615\n1869#2,2:617\n1869#2,2:619\n1869#2,2:621\n*S KotlinDebug\n*F\n+ 1 ControllerHost.kt\ncom/qiahao/nextvideo/ui/reusable/viewcontroller/host/ControllerHost\n*L\n188#1:615,2\n215#1:617,2\n218#1:619,2\n318#1:621,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public class ControllerHost extends FrameLayout {

    @Nullable
    private HiloBaseActivity activity;

    @NotNull
    private ArrayList<ViewController> controllers;

    @NotNull
    private final s detector;

    @NotNull
    private ArrayList<DimView> dimCovers;
    private float dimRatio;
    private float disappearRatio;
    private boolean dismissControllerHost;

    @Nullable
    private OnOutsideClickListener onOutsideClickListener;

    @Nullable
    private RemoveRootControllerHost removeRootListener;

    @NotNull
    private Rect testRect;
    private boolean transactionInProgress;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PresentingAnimation.values().length];
            try {
                iArr[PresentingAnimation.RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PresentingAnimation.RIGHT_REVEAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PresentingAnimation.RIGHT_TRANSLATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PresentingAnimation.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PresentingAnimation.BOTTOM_FADE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ControllerHost(@NotNull HiloBaseActivity hiloBaseActivity) {
        super(hiloBaseActivity);
        Intrinsics.checkNotNullParameter(hiloBaseActivity, AgooConstants.OPEN_ACTIIVTY_NAME);
        this.disappearRatio = 0.1f;
        this.dimRatio = 0.5f;
        this.dimCovers = new ArrayList<>();
        this.controllers = new ArrayList<>();
        this.activity = hiloBaseActivity;
        setBackgroundColor(0);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.testRect = new Rect();
        this.detector = new s(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.qiahao.nextvideo.ui.reusable.viewcontroller.host.ControllerHost$detector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent e) {
                PresentationStyle presentationStyle;
                Intrinsics.checkNotNullParameter(e, "e");
                ViewController topViewController = ControllerHost.this.getTopViewController();
                if (topViewController != null) {
                    presentationStyle = topViewController.getPresentationStyle();
                } else {
                    presentationStyle = null;
                }
                if (presentationStyle != null) {
                    if (ControllerHost.this.getOnOutsideClickListener() != null) {
                        OnOutsideClickListener onOutsideClickListener = ControllerHost.this.getOnOutsideClickListener();
                        if (onOutsideClickListener != null) {
                            onOutsideClickListener.onOutsideClicked();
                        }
                    } else if (presentationStyle.getAllowDismiss() && !presentationStyle.getFullscreen() && presentationStyle.getAllowTapOutsideToDismiss()) {
                        ControllerHost.this.pop(true, null);
                    }
                }
                return true;
            }
        });
    }

    private final ObjectAnimator createEnterAnimation(ViewController viewController, PresentationStyle style) {
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        int i = WhenMappings.$EnumSwitchMapping$0[style.getAnimation().ordinal()];
        if (i != 1) {
            if (i != 2 && i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewController.getRequireView(), "alpha", 0.0f, 1.0f);
                        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
                        return ofFloat;
                    }
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(viewController.getRequireView(), "alpha", 0.0f, 1.0f);
                    Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(...)");
                    return ofFloat2;
                }
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(viewController.getRequireView(), "translationY", (-this.disappearRatio) * measuredHeight, 0.0f);
                Intrinsics.checkNotNullExpressionValue(ofFloat3, "ofFloat(...)");
                return ofFloat3;
            }
            bringChildToFront(viewController.getRequireView());
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(viewController.getRequireView(), AnimationUtilitiesKt.propertyNameInTranslationX, -measuredWidth, 0.0f);
            Intrinsics.checkNotNullExpressionValue(ofFloat4, "ofFloat(...)");
            return ofFloat4;
        }
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(viewController.getRequireView(), AnimationUtilitiesKt.propertyNameInTranslationX, (-this.disappearRatio) * measuredWidth, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat5, "ofFloat(...)");
        return ofFloat5;
    }

    private final ObjectAnimator createExitAnimation(ViewController viewController, PresentationStyle style) {
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        int i = WhenMappings.$EnumSwitchMapping$0[style.getAnimation().ordinal()];
        if (i != 1) {
            if (i != 2 && i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewController.getRequireView(), "alpha", 1.0f, 0.0f);
                        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
                        return ofFloat;
                    }
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(viewController.getRequireView(), "alpha", 1.0f, 0.0f);
                    Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(...)");
                    return ofFloat2;
                }
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(viewController.getRequireView(), "translationY", 0.0f, (-this.disappearRatio) * measuredHeight);
                Intrinsics.checkNotNullExpressionValue(ofFloat3, "ofFloat(...)");
                return ofFloat3;
            }
            bringChildToFront(viewController.getRequireView());
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(viewController.getRequireView(), AnimationUtilitiesKt.propertyNameInTranslationX, 0.0f, -measuredWidth);
            Intrinsics.checkNotNullExpressionValue(ofFloat4, "ofFloat(...)");
            return ofFloat4;
        }
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(viewController.getRequireView(), AnimationUtilitiesKt.propertyNameInTranslationX, 0.0f, (-this.disappearRatio) * measuredWidth);
        Intrinsics.checkNotNullExpressionValue(ofFloat5, "ofFloat(...)");
        return ofFloat5;
    }

    private final ObjectAnimator createPopAnimation(ViewController viewController) {
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        int i = WhenMappings.$EnumSwitchMapping$0[viewController.getPresentationStyle().getAnimation().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4 && i != 5) {
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewController.getRequireView(), "alpha", 1.0f, 0.0f);
                        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
                        return ofFloat;
                    }
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(viewController.getRequireView(), "translationY", 0.0f, measuredHeight);
                    Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(...)");
                    return ofFloat2;
                }
            } else {
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(viewController.getRequireView(), AnimationUtilitiesKt.propertyNameInTranslationX, 0.0f, 0.0f);
                Intrinsics.checkNotNullExpressionValue(ofFloat3, "ofFloat(...)");
                return ofFloat3;
            }
        }
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(viewController.getRequireView(), AnimationUtilitiesKt.propertyNameInTranslationX, 0.0f, measuredWidth);
        Intrinsics.checkNotNullExpressionValue(ofFloat4, "ofFloat(...)");
        return ofFloat4;
    }

    private final ObjectAnimator createPushAnimation(ViewController viewController) {
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        int i = WhenMappings.$EnumSwitchMapping$0[viewController.getPresentationStyle().getAnimation().ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4 && i != 5) {
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewController.getRequireView(), "alpha", 0.0f, 1.0f);
                        Intrinsics.checkNotNullExpressionValue(ofFloat, "ofFloat(...)");
                        return ofFloat;
                    }
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(viewController.getRequireView(), "translationY", measuredHeight, 0.0f);
                    Intrinsics.checkNotNullExpressionValue(ofFloat2, "ofFloat(...)");
                    return ofFloat2;
                }
            } else {
                ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(viewController.getRequireView(), AnimationUtilitiesKt.propertyNameInTranslationX, 0.0f, 0.0f);
                Intrinsics.checkNotNullExpressionValue(ofFloat3, "ofFloat(...)");
                return ofFloat3;
            }
        }
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(viewController.getRequireView(), AnimationUtilitiesKt.propertyNameInTranslationX, measuredWidth, 0.0f);
        Intrinsics.checkNotNullExpressionValue(ofFloat4, "ofFloat(...)");
        return ofFloat4;
    }

    public static /* synthetic */ void getViewControllers$annotations() {
    }

    private final void measureChild(View view) {
        int i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        int max = Math.max(0, (getMeasuredWidth() - layoutParams2.leftMargin) - layoutParams2.rightMargin);
        int i2 = Integer.MIN_VALUE;
        if (layoutParams2.width == -1) {
            i = 1073741824;
        } else {
            i = Integer.MIN_VALUE;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, i);
        int max2 = Math.max(0, (getMeasuredHeight() - layoutParams2.topMargin) - layoutParams2.bottomMargin);
        if (layoutParams2.height == -1) {
            i2 = 1073741824;
        }
        view.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(max2, i2));
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void onlyAllowTopViewToReceiveTouch() {
        if (getChildCount() != 0 && getChildCount() % 2 == 0) {
            int childCount = getChildCount();
            while (true) {
                childCount--;
                if (-1 < childCount) {
                    getChildAt(childCount).setOnTouchListener(new View.OnTouchListener() { // from class: com.qiahao.nextvideo.ui.reusable.viewcontroller.host.a
                        @Override // android.view.View.OnTouchListener
                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            boolean onlyAllowTopViewToReceiveTouch$lambda$9;
                            onlyAllowTopViewToReceiveTouch$lambda$9 = ControllerHost.onlyAllowTopViewToReceiveTouch$lambda$9(view, motionEvent);
                            return onlyAllowTopViewToReceiveTouch$lambda$9;
                        }
                    });
                } else {
                    getChildAt(getChildCount() - 1).setOnTouchListener(null);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onlyAllowTopViewToReceiveTouch$lambda$9(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void printStack() {
        DebugToolsKt.printf("===========");
        DebugToolsKt.printf("COUNT", Integer.valueOf(this.controllers.size()), Integer.valueOf(this.dimCovers.size()), Integer.valueOf(getChildCount()));
        DebugToolsKt.printf("Stack     :", this.controllers);
        DebugToolsKt.printf("Dim Covers:", this.dimCovers);
        DebugToolsKt.printf("===========");
    }

    public final void addBottom(@NotNull ViewController viewController, @NotNull HiloBaseActivity activity) {
        Intrinsics.checkNotNullParameter(viewController, "viewController");
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        viewController.doCreateView(this, activity);
        if (viewController.getPresentationStyle().getFullscreen()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(viewController.getRequireView().getLayoutParams());
            layoutParams.width = -1;
            layoutParams.height = -1;
            viewController.getRequireView().setLayoutParams(layoutParams);
            this.controllers.add(0, viewController);
            addView(viewController.getRequireView(), 0);
            measureChild(viewController.getRequireView());
            viewController.getRequireView().setVisibility(8);
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            DimView dimView = new DimView(context);
            this.dimCovers.add(0, dimView);
            addView(dimView, 0);
            if (viewController.getPresentationStyle().getDim()) {
                dimView.setAlpha(this.dimRatio);
            }
            printStack();
            return;
        }
        throw new RuntimeException("You can't add a non-full screen view controller at bottom");
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View child) {
        super.addView(child);
        onlyAllowTopViewToReceiveTouch();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev) {
        if (getChildCount() != 0 && ev != null) {
            getChildAt(getChildCount() - 1).getHitRect(this.testRect);
            if (this.testRect.contains((int) ev.getX(), (int) ev.getY())) {
                super.dispatchTouchEvent(ev);
            } else {
                this.detector.a(ev);
            }
            return true;
        }
        return false;
    }

    @Nullable
    public final HiloBaseActivity getActivity() {
        return this.activity;
    }

    @NotNull
    public final ArrayList<ViewController> getControllers() {
        return this.controllers;
    }

    public final boolean getDismissControllerHost() {
        return this.dismissControllerHost;
    }

    @Nullable
    public final OnOutsideClickListener getOnOutsideClickListener() {
        return this.onOutsideClickListener;
    }

    @Nullable
    public final ViewController getTopViewController() {
        return (ViewController) CollectionsKt.lastOrNull(this.controllers);
    }

    public final boolean getTransactionInProgress() {
        return this.transactionInProgress;
    }

    @NotNull
    public final List<ViewController> getViewControllers() {
        return this.controllers;
    }

    public boolean onBackPressed() {
        PresentationStyle presentationStyle;
        if (this.dismissControllerHost && this.controllers.size() <= 1) {
            RemoveRootControllerHost removeRootControllerHost = this.removeRootListener;
            if (removeRootControllerHost != null) {
                removeRootControllerHost.removeRootControllerHost();
            }
            return false;
        }
        ViewController topViewController = getTopViewController();
        if (topViewController != null && topViewController.onBackPressed()) {
            return true;
        }
        ViewController topViewController2 = getTopViewController();
        if (topViewController2 != null && (presentationStyle = topViewController2.getPresentationStyle()) != null && !presentationStyle.getAllowDismiss()) {
            return true;
        }
        if (this.controllers.size() <= 1) {
            return false;
        }
        pop(true, null);
        return true;
    }

    public final void onDestroy() {
        popAll();
        this.activity = null;
    }

    public final boolean pop(final boolean animated, @Nullable final Function0<Unit> completion) {
        View requireView;
        View requireView2;
        printStack();
        if (this.dismissControllerHost && this.controllers.size() <= 1) {
            RemoveRootControllerHost removeRootControllerHost = this.removeRootListener;
            if (removeRootControllerHost != null) {
                removeRootControllerHost.removeRootControllerHost();
            }
            return false;
        }
        if (this.transactionInProgress || this.controllers.size() == 1) {
            return false;
        }
        this.transactionInProgress = true;
        ArrayList<ViewController> arrayList = this.controllers;
        ViewController remove = arrayList.remove(arrayList.size() - 1);
        Intrinsics.checkNotNullExpressionValue(remove, "removeAt(...)");
        final ViewController viewController = remove;
        ArrayList<DimView> arrayList2 = this.dimCovers;
        DimView remove2 = arrayList2.remove(arrayList2.size() - 1);
        Intrinsics.checkNotNullExpressionValue(remove2, "removeAt(...)");
        final DimView dimView = remove2;
        final ViewController topViewController = getTopViewController();
        if (topViewController != null && (requireView2 = topViewController.getRequireView()) != null) {
            requireView2.setVisibility(0);
        }
        if (!viewController.getPresentationStyle().getOverCurrentContext() && topViewController != null) {
            topViewController.viewWillAppear(animated);
        }
        if (viewController.get_isVisible()) {
            viewController.viewWillDisappear(animated);
        }
        if (animated) {
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(createPopAnimation(viewController));
            if (!viewController.getPresentationStyle().getOverCurrentContext() && topViewController != null) {
                arrayList3.add(createEnterAnimation(topViewController, viewController.getPresentationStyle()));
            }
            arrayList3.add(ObjectAnimator.ofFloat(dimView, "alpha", dimView.getAlpha(), 0.0f));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimationEndListener() { // from class: com.qiahao.nextvideo.ui.reusable.viewcontroller.host.ControllerHost$pop$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    ViewController viewController2;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    ControllerHost.this.removeView(dimView);
                    try {
                        ViewController viewController3 = topViewController;
                        if (viewController3 != null) {
                            ControllerHost.this.bringChildToFront(viewController3.getRequireView());
                        }
                        if (!viewController.getPresentationStyle().getOverCurrentContext() && (viewController2 = topViewController) != null) {
                            viewController2.viewDidAppear(animated);
                        }
                        if (viewController.get_isVisible()) {
                            viewController.viewDidDisappear(animated);
                        }
                        viewController.doDestroyView(ControllerHost.this);
                        ControllerHost.this.setTransactionInProgress(false);
                        ControllerHost.this.printStack();
                    } catch (Exception unused) {
                    }
                    Function0<Unit> function0 = completion;
                    if (function0 != null) {
                        function0.invoke();
                    }
                }
            });
            animatorSet.setDuration(viewController.getPresentationStyle().getDuration());
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                ((Animator) it.next()).setDuration(viewController.getPresentationStyle().getDuration());
            }
            animatorSet.playTogether(arrayList3);
            animatorSet.start();
        } else {
            if (!viewController.getPresentationStyle().getOverCurrentContext() && topViewController != null) {
                topViewController.viewDidAppear(animated);
            }
            if (topViewController != null && (requireView = topViewController.getRequireView()) != null) {
                requireView.setTranslationX(0.0f);
                requireView.setTranslationY(0.0f);
                requireView.setAlpha(1.0f);
            }
            dimView.setAlpha(0.0f);
            if (viewController.get_isVisible()) {
                viewController.viewDidDisappear(animated);
            }
            removeView(dimView);
            viewController.doDestroyView(this);
            this.transactionInProgress = false;
            printStack();
            if (completion != null) {
                completion.invoke();
            }
        }
        return true;
    }

    public final void popAll() {
        RemoveRootControllerHost removeRootControllerHost;
        ViewController topViewController = getTopViewController();
        if (topViewController != null) {
            topViewController.viewWillDisappear(false);
        }
        ViewController topViewController2 = getTopViewController();
        if (topViewController2 != null) {
            topViewController2.viewDidDisappear(false);
        }
        Iterator it = CollectionsKt.reversed(this.controllers).iterator();
        while (it.hasNext()) {
            ((ViewController) it.next()).doDestroyView(this);
        }
        Iterator it2 = CollectionsKt.reversed(this.dimCovers).iterator();
        while (it2.hasNext()) {
            removeView((DimView) it2.next());
        }
        this.controllers.clear();
        this.dimCovers.clear();
        if (this.dismissControllerHost && this.controllers.size() <= 1 && (removeRootControllerHost = this.removeRootListener) != null) {
            removeRootControllerHost.removeRootControllerHost();
        }
    }

    public final void popAllButTop() {
        while (this.controllers.size() > 1) {
            int size = this.controllers.size() - 2;
            ViewController remove = this.controllers.remove(size);
            Intrinsics.checkNotNullExpressionValue(remove, "removeAt(...)");
            ViewController viewController = remove;
            if (viewController.get_isVisible()) {
                viewController.viewWillDisappear(false);
                viewController.viewDidDisappear(false);
            }
            viewController.doDestroyView(this);
            DimView remove2 = this.dimCovers.remove(size);
            Intrinsics.checkNotNullExpressionValue(remove2, "removeAt(...)");
            removeView(remove2);
        }
        printStack();
    }

    public final void popToRoot() {
        while (this.controllers.size() > 1) {
            pop(false, null);
        }
        printStack();
    }

    public final void push(@NotNull final ViewController viewController, @NotNull HiloBaseActivity activity, final boolean animated, @Nullable final Function0<Unit> completion) {
        Intrinsics.checkNotNullParameter(viewController, "viewController");
        Intrinsics.checkNotNullParameter(activity, AgooConstants.OPEN_ACTIIVTY_NAME);
        if (this.transactionInProgress) {
            return;
        }
        printStack();
        this.transactionInProgress = true;
        viewController.doCreateView(this, activity);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(viewController.getRequireView().getLayoutParams());
        if (!viewController.getPresentationStyle().getFullscreen()) {
            layoutParams.setMarginStart(viewController.getPresentationStyle().getMinimumSideMargin());
            layoutParams.setMarginEnd(viewController.getPresentationStyle().getMinimumSideMargin());
            layoutParams.topMargin = viewController.getPresentationStyle().getMinimumSideMargin();
            layoutParams.bottomMargin = viewController.getPresentationStyle().getMinimumSideMargin();
        } else if (viewController.processStatusBarCover() == 0) {
            layoutParams.topMargin = viewController.processStatusBarCover();
        }
        layoutParams.gravity = viewController.getPresentationStyle().getGravity();
        viewController.getRequireView().setLayoutParams(layoutParams);
        final ViewController topViewController = getTopViewController();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        final DimView dimView = new DimView(context);
        this.dimCovers.add(dimView);
        addView(dimView);
        addView(viewController.getRequireView());
        measureChild(viewController.getRequireView());
        viewController.viewWillAppear(animated);
        if (!viewController.getPresentationStyle().getOverCurrentContext() && topViewController != null) {
            topViewController.viewWillDisappear(animated);
        }
        if (animated) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(createPushAnimation(viewController));
            if (!viewController.getPresentationStyle().getOverCurrentContext() && topViewController != null) {
                arrayList.add(createExitAnimation(topViewController, viewController.getPresentationStyle()));
            }
            if (viewController.getPresentationStyle().getDim()) {
                arrayList.add(ObjectAnimator.ofFloat(dimView, "alpha", dimView.getAlpha(), this.dimRatio));
            }
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.addListener(new AnimationListener() { // from class: com.qiahao.nextvideo.ui.reusable.viewcontroller.host.ControllerHost$push$1
                @Override // com.qiahao.nextvideo.ui.reusable.viewcontroller.animation.AnimationListener, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    View requireView;
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    try {
                        ControllerHost.this.bringChildToFront(dimView);
                        ControllerHost.this.bringChildToFront(viewController.getRequireView());
                        viewController.viewDidAppear(animated);
                        if (!viewController.getPresentationStyle().getOverCurrentContext()) {
                            ViewController viewController2 = topViewController;
                            if (viewController2 != null) {
                                viewController2.viewDidDisappear(animated);
                            }
                            ViewController viewController3 = topViewController;
                            if (viewController3 != null && (requireView = viewController3.getRequireView()) != null) {
                                requireView.setVisibility(8);
                            }
                        }
                        ControllerHost.this.setTransactionInProgress(false);
                        Function0<Unit> function0 = completion;
                        if (function0 != null) {
                            function0.invoke();
                        }
                        ControllerHost.this.printStack();
                    } catch (Exception unused) {
                    }
                }
            });
            animatorSet.setDuration(viewController.getPresentationStyle().getDuration());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Animator) it.next()).setDuration(viewController.getPresentationStyle().getDuration());
            }
            animatorSet.playTogether(arrayList);
            animatorSet.start();
            this.controllers.add(viewController);
            return;
        }
        if (viewController.getPresentationStyle().getDim()) {
            dimView.setAlpha(this.dimRatio);
        }
        this.controllers.add(viewController);
        this.transactionInProgress = false;
        viewController.viewDidAppear(animated);
        if (!viewController.getPresentationStyle().getOverCurrentContext() && topViewController != null) {
            topViewController.viewDidDisappear(animated);
        }
        printStack();
        if (completion != null) {
            completion.invoke();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(@Nullable View view) {
        super.removeView(view);
        onlyAllowTopViewToReceiveTouch();
    }

    public final void setControllers(@NotNull ArrayList<ViewController> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.controllers = arrayList;
    }

    public final void setDismissControllerHost(boolean z) {
        this.dismissControllerHost = z;
    }

    public final void setOnOutsideClickListener(@Nullable OnOutsideClickListener onOutsideClickListener) {
        this.onOutsideClickListener = onOutsideClickListener;
    }

    public final void setRemoveRootControllerListener(@NotNull RemoveRootControllerHost listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.removeRootListener = listener;
    }

    public final void setTransactionInProgress(boolean z) {
        this.transactionInProgress = z;
    }

    @Override // android.view.ViewGroup
    public void addView(@Nullable View child, int index) {
        super.addView(child, index);
        onlyAllowTopViewToReceiveTouch();
    }
}
