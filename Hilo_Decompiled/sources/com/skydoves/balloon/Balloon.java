package com.skydoves.balloon;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.method.MovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.FloatRange;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.view.d1;
import androidx.core.widget.g;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.qiahao.nextvideo.ui.home.chat.dialog.MessageMenuDialog;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.IconForm;
import com.skydoves.balloon.TextForm;
import com.skydoves.balloon.databinding.LayoutBalloonLibrarySkydovesBinding;
import com.skydoves.balloon.databinding.LayoutBalloonOverlayLibrarySkydovesBinding;
import com.skydoves.balloon.extensions.ContextExtensionKt;
import com.skydoves.balloon.extensions.TextViewExtensionKt;
import com.skydoves.balloon.extensions.ViewExtensionKt;
import com.skydoves.balloon.overlay.BalloonAnchorOverlayView;
import com.skydoves.balloon.overlay.BalloonOverlayAnimation;
import com.skydoves.balloon.overlay.BalloonOverlayOval;
import com.skydoves.balloon.overlay.BalloonOverlayShape;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tech.sud.gip.core.view.round.RoundedDrawable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0002stB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020 H\u0002J\b\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020 H\u0002J\u0006\u0010&\u001a\u00020 J\u000e\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0006\u0010/\u001a\u00020-J\b\u00100\u001a\u000201H\u0002J\u0006\u00102\u001a\u000201J\u0010\u00103\u001a\u0002012\u0006\u00104\u001a\u000201H\u0002J\u0006\u00105\u001a\u000201J\b\u00106\u001a\u00020+H\u0002J\b\u00107\u001a\u000201H\u0002J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020-H\u0002J\u0010\u0010;\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010<\u001a\u00020 H\u0002J\b\u0010=\u001a\u00020 H\u0002J\b\u0010>\u001a\u00020 H\u0002J\b\u0010?\u001a\u00020 H\u0002J\b\u0010@\u001a\u00020 H\u0002J\b\u0010A\u001a\u00020 H\u0003J\b\u0010B\u001a\u00020 H\u0002J\b\u0010C\u001a\u00020 H\u0002J\b\u0010D\u001a\u00020 H\u0002J\b\u0010E\u001a\u00020 H\u0002J\u000e\u0010F\u001a\u00020 2\u0006\u0010G\u001a\u00020HJ\b\u0010I\u001a\u00020 H\u0007J\b\u0010J\u001a\u00020 H\u0007J6\u0010K\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00002#\b\u0004\u0010M\u001a\u001d\u0012\u0013\u0012\u00110\u0000¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(L\u0012\u0004\u0012\u00020 0NH\u0083\bJ,\u0010Q\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010R\u001a\u0002012\b\b\u0002\u0010S\u001a\u000201H\u0007J,\u0010T\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010R\u001a\u0002012\b\b\u0002\u0010S\u001a\u000201H\u0007J,\u0010U\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010R\u001a\u0002012\b\b\u0002\u0010S\u001a\u000201H\u0007J,\u0010V\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010R\u001a\u0002012\b\b\u0002\u0010S\u001a\u000201H\u0007J,\u0010W\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010R\u001a\u0002012\b\b\u0002\u0010S\u001a\u000201H\u0007J\u0016\u0010X\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-J&\u0010X\u001a\u00020\u00002\u0006\u0010L\u001a\u00020\u00002\u0006\u0010,\u001a\u00020-2\u0006\u0010R\u001a\u0002012\u0006\u0010S\u001a\u000201J\u001a\u0010Y\u001a\u00020 2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020 0NJ\u0010\u0010Y\u001a\u00020 2\b\u0010Z\u001a\u0004\u0018\u00010[J\u0014\u0010\\\u001a\u00020 2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020 0]J\u0010\u0010\\\u001a\u00020 2\b\u0010^\u001a\u0004\u0018\u00010_J \u0010`\u001a\u00020 2\u0018\u0010M\u001a\u0014\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020b\u0012\u0004\u0012\u00020 0aJ\u0010\u0010`\u001a\u00020 2\b\u0010c\u001a\u0004\u0018\u00010dJ\u0014\u0010e\u001a\u00020 2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020 0]J\u0010\u0010e\u001a\u00020 2\b\u0010f\u001a\u0004\u0018\u00010gJ\u0010\u0010h\u001a\u00020 2\b\u0010i\u001a\u0004\u0018\u00010jJ\u000e\u0010k\u001a\u00020 2\u0006\u0010,\u001a\u00020-J!\u0010k\u001a\u00020 2\u0006\u0010,\u001a\u00020-2\u000e\b\u0004\u0010M\u001a\b\u0012\u0004\u0012\u00020 0]H\u0083\bJ\u001e\u0010k\u001a\u00020 2\u0006\u0010,\u001a\u00020-2\u0006\u0010R\u001a\u0002012\u0006\u0010S\u001a\u000201J$\u0010l\u001a\u00020 2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010R\u001a\u0002012\b\b\u0002\u0010S\u001a\u000201H\u0007J$\u0010m\u001a\u00020 2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010R\u001a\u0002012\b\b\u0002\u0010S\u001a\u000201H\u0007J$\u0010n\u001a\u00020 2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010R\u001a\u0002012\b\b\u0002\u0010S\u001a\u000201H\u0007J$\u0010o\u001a\u00020 2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010R\u001a\u0002012\b\b\u0002\u0010S\u001a\u000201H\u0007J$\u0010p\u001a\u00020 2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010R\u001a\u0002012\b\b\u0002\u0010S\u001a\u000201H\u0007J\u0010\u0010q\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0002J!\u0010r\u001a\u00020 2\u0006\u0010,\u001a\u00020-2\u000e\b\u0004\u0010M\u001a\b\u0012\u0004\u0012\u00020 0]H\u0083\bJ$\u0010r\u001a\u00020 2\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010R\u001a\u0002012\b\b\u0002\u0010S\u001a\u000201H\u0007R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006u"}, d2 = {"Lcom/skydoves/balloon/Balloon;", "Landroidx/lifecycle/LifecycleObserver;", "context", "Landroid/content/Context;", "builder", "Lcom/skydoves/balloon/Balloon$Builder;", "(Landroid/content/Context;Lcom/skydoves/balloon/Balloon$Builder;)V", "balloonPersistence", "Lcom/skydoves/balloon/BalloonPersistence;", "getBalloonPersistence", "()Lcom/skydoves/balloon/BalloonPersistence;", "balloonPersistence$delegate", "Lkotlin/Lazy;", "binding", "Lcom/skydoves/balloon/databinding/LayoutBalloonLibrarySkydovesBinding;", "bodyWindow", "Landroid/widget/PopupWindow;", "destroyed", "", "<set-?>", "isShowing", "()Z", "onBalloonInitializedListener", "Lcom/skydoves/balloon/OnBalloonInitializedListener;", "getOnBalloonInitializedListener", "()Lcom/skydoves/balloon/OnBalloonInitializedListener;", "setOnBalloonInitializedListener", "(Lcom/skydoves/balloon/OnBalloonInitializedListener;)V", "overlayBinding", "Lcom/skydoves/balloon/databinding/LayoutBalloonOverlayLibrarySkydovesBinding;", "overlayWindow", "adjustFitsSystemWindows", "", "parent", "Landroid/view/ViewGroup;", "applyBalloonAnimation", "applyBalloonOverlayAnimation", "createByBuilder", "dismiss", "dismissWithDelay", "delay", "", "getArrowConstraintPositionX", "", "anchor", "Landroid/view/View;", "getArrowConstraintPositionY", "getContentView", "getDoubleArrowSize", "", "getMeasuredHeight", "getMeasuredTextWidth", "measuredWidth", "getMeasuredWidth", "getMinArrowPosition", "getStatusBarHeight", "getWindowBodyScreenLocation", "", "view", "initializeArrow", "initializeBackground", "initializeBalloonContent", "initializeBalloonListeners", "initializeBalloonOverlay", "initializeBalloonRoot", "initializeBalloonWindow", "initializeCustomLayoutWithResource", "initializeCustomLayoutWithView", "initializeIcon", "initializeText", "measureTextWidth", "textView", "Landroid/widget/TextView;", "onDestroy", "onPause", "relay", "balloon", MessageMenuDialog.BLOCK, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "relayShow", "xOff", "yOff", "relayShowAlignBottom", "relayShowAlignLeft", "relayShowAlignRight", "relayShowAlignTop", "relayShowAsDropDown", "setOnBalloonClickListener", "onBalloonClickListener", "Lcom/skydoves/balloon/OnBalloonClickListener;", "setOnBalloonDismissListener", "Lkotlin/Function0;", "onBalloonDismissListener", "Lcom/skydoves/balloon/OnBalloonDismissListener;", "setOnBalloonOutsideTouchListener", "Lkotlin/Function2;", "Landroid/view/MotionEvent;", "onBalloonOutsideTouchListener", "Lcom/skydoves/balloon/OnBalloonOutsideTouchListener;", "setOnBalloonOverlayClickListener", "onBalloonOverlayClickListener", "Lcom/skydoves/balloon/OnBalloonOverlayClickListener;", "setOnBalloonTouchListener", "onTouchListener", "Landroid/view/View$OnTouchListener;", "show", "showAlignBottom", "showAlignLeft", "showAlignRight", "showAlignTop", "showAsDropDown", "showOverlayWindow", "update", "Builder", "Factory", "balloon_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class Balloon implements LifecycleObserver {

    /* renamed from: balloonPersistence$delegate, reason: from kotlin metadata */
    private final Lazy balloonPersistence;
    private final LayoutBalloonLibrarySkydovesBinding binding;
    private final PopupWindow bodyWindow;
    private final Builder builder;
    private final Context context;
    private boolean destroyed;
    private boolean isShowing;

    @Nullable
    private OnBalloonInitializedListener onBalloonInitializedListener;
    private final LayoutBalloonOverlayLibrarySkydovesBinding overlayBinding;
    private final PopupWindow overlayWindow;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b?\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010k\u001a\u00020lJ\u000e\u00105\u001a\u00020\u00002\u0006\u0010m\u001a\u00020$J\u0010\u0010n\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\u0006J\u0010\u0010o\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u000e\u0010p\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u0006J\u0010\u0010q\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0010\u0010r\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0010\u0010s\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u000e\u0010t\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\rJ\u0010\u0010u\u001a\u00020\u00002\b\u0010m\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010v\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0010\u0010w\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u000e\u0010x\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u0012J\u0010\u0010y\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\u0006J\u0010\u0010z\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0010\u0010{\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0010\u0010|\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0010\u0010}\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u000e\u0010~\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u0018J\u0010\u0010\u007f\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010\u0080\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010\u0081\u0001\u001a\u00020\u00002\b\u0010m\u001a\u0004\u0018\u00010\u000fJ\u0011\u0010\u0082\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u000f\u0010\u0083\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u001cJ\u0011\u0010\u0084\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u000f\u0010\u0085\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u001fJ\u0011\u0010\u0086\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u000f\u0010\u0087\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\u0018J\u0011\u0010\u0088\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\u0006J\u0011\u0010\u0089\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u000f\u0010\u008a\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020$J\u000f\u0010\u008b\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020$J\u000f\u0010\u008c\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020$J\u000f\u0010\u008d\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020$J\u000f\u0010\u008e\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020$J\u0013\u0010\u008f\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bH\u0007J\u0013\u0010\u0090\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bH\u0007J\u000f\u0010\u0091\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020$J\u0011\u0010\u0092\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010\u0093\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010\u0094\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010\u0095\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010\u0096\u0001\u001a\u00020\u00002\b\u0010m\u001a\u0004\u0018\u00010\u000fJ\u0011\u0010\u0097\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u000f\u0010\u0098\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020.J\u000f\u0010\u0099\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u000200J\u0011\u0010\u009a\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010\u009b\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010\u009c\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010\u009d\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u000f\u0010\u009e\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020$J\u000f\u0010\u009f\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020$J\u000f\u0010 \u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020$J\u000f\u0010¡\u0001\u001a\u00020\u00002\u0006\u0010:\u001a\u000209J\u0011\u0010¡\u0001\u001a\u00020\u00002\b\b\u0001\u0010;\u001a\u00020\bJ\u0011\u0010¢\u0001\u001a\u00020\u00002\b\u0010m\u001a\u0004\u0018\u00010<J\u0011\u0010£\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010¤\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010¥\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010¦\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010§\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010¨\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u000f\u0010©\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020BJ\u001e\u0010ª\u0001\u001a\u00020\u00002\u0015\u0010«\u0001\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0005\u0012\u00030\u00ad\u00010¬\u0001J\u000f\u0010ª\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020DJ\u0018\u0010®\u0001\u001a\u00020\u00002\u000f\u0010«\u0001\u001a\n\u0012\u0005\u0012\u00030\u00ad\u00010¯\u0001J\u000f\u0010®\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020FJ\u001e\u0010°\u0001\u001a\u00020\u00002\u0015\u0010«\u0001\u001a\u0010\u0012\u0004\u0012\u000209\u0012\u0005\u0012\u00030\u00ad\u00010¬\u0001J\u000f\u0010°\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020HJ%\u0010±\u0001\u001a\u00020\u00002\u001c\u0010«\u0001\u001a\u0017\u0012\u0004\u0012\u000209\u0012\u0005\u0012\u00030³\u0001\u0012\u0005\u0012\u00030\u00ad\u00010²\u0001J\u000f\u0010±\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020JJ\u0018\u0010´\u0001\u001a\u00020\u00002\u000f\u0010«\u0001\u001a\n\u0012\u0005\u0012\u00030\u00ad\u00010¯\u0001J\u000f\u0010´\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020LJ\u000f\u0010µ\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020NJ\u0011\u0010¶\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010·\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010¸\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\u0006J\u000f\u0010¹\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020RJ\u000f\u0010º\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020TJ\u0011\u0010»\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010¼\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010½\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010¾\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010¿\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010À\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u000f\u0010Á\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020ZJ\u000f\u0010Â\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\bJ\u000f\u0010Ã\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020^J\u0011\u0010Ä\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010Å\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u000f\u0010Æ\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020aJ\u000f\u0010Ç\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\bJ\u000f\u0010È\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020$J\u0011\u0010É\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010Ê\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\u0006J\u000f\u0010Ë\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020gJ\u000f\u0010Ë\u0001\u001a\u00020\u00002\u0006\u0010m\u001a\u00020\bJ\u0011\u0010Ì\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bJ\u0011\u0010Í\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\u0006J\u0011\u0010Î\u0001\u001a\u00020\u00002\b\b\u0001\u0010m\u001a\u00020\bR\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\r8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u001c8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u001f2\u0006\u0010\u0005\u001a\u00020\u001f8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u00188\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010-\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u000f8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u0004\u0018\u00010.2\b\u0010\u0005\u001a\u0004\u0018\u00010.8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u0002002\u0006\u0010\u0005\u001a\u0002008\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u00103\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u00106\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u00107\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010:\u001a\u0004\u0018\u0001092\b\u0010\u0005\u001a\u0004\u0018\u0001098\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010=\u001a\u0004\u0018\u00010<2\b\u0010\u0005\u001a\u0004\u0018\u00010<8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010>\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010C\u001a\u0004\u0018\u00010B2\b\u0010\u0005\u001a\u0004\u0018\u00010B8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010E\u001a\u0004\u0018\u00010D2\b\u0010\u0005\u001a\u0004\u0018\u00010D8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010G\u001a\u0004\u0018\u00010F2\b\u0010\u0005\u001a\u0004\u0018\u00010F8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010I\u001a\u0004\u0018\u00010H2\b\u0010\u0005\u001a\u0004\u0018\u00010H8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010K\u001a\u0004\u0018\u00010J2\b\u0010\u0005\u001a\u0004\u0018\u00010J8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010M\u001a\u0004\u0018\u00010L2\b\u0010\u0005\u001a\u0004\u0018\u00010L8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010O\u001a\u0004\u0018\u00010N2\b\u0010\u0005\u001a\u0004\u0018\u00010N8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010P\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Q\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010S\u001a\u0004\u0018\u00010R2\b\u0010\u0005\u001a\u0004\u0018\u00010R8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010U\u001a\u00020T2\u0006\u0010\u0005\u001a\u00020T8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010V\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010W\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010X\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Y\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010[\u001a\u0004\u0018\u00010Z2\b\u0010\u0005\u001a\u0004\u0018\u00010Z8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\\\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010]\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010_\u001a\u00020^2\u0006\u0010\u0005\u001a\u00020^8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010`\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010b\u001a\u0004\u0018\u00010a2\b\u0010\u0005\u001a\u0004\u0018\u00010a8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010c\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010d\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010h\u001a\u0004\u0018\u00010g2\b\u0010\u0005\u001a\u0004\u0018\u00010g8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010i\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010j\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068\u0006@FX\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006Ï\u0001"}, d2 = {"Lcom/skydoves/balloon/Balloon$Builder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "<set-?>", "", "alpha", "", "arrowAlignAnchorPadding", "arrowAlignAnchorPaddingRatio", "arrowBottomPadding", "arrowColor", "Lcom/skydoves/balloon/ArrowConstraints;", "arrowConstraints", "Landroid/graphics/drawable/Drawable;", "arrowDrawable", "arrowLeftPadding", "Lcom/skydoves/balloon/ArrowOrientation;", "arrowOrientation", "arrowPosition", "arrowRightPadding", "arrowSize", "arrowTopPadding", "", "autoDismissDuration", "backgroundColor", "backgroundDrawable", "Lcom/skydoves/balloon/BalloonAnimation;", "balloonAnimation", "balloonAnimationStyle", "Lcom/skydoves/balloon/overlay/BalloonOverlayAnimation;", "balloonOverlayAnimation", "balloonOverlayAnimationStyle", "circularDuration", "cornerRadius", "", "dismissWhenClicked", "dismissWhenLifecycleOnPause", "dismissWhenOverlayClicked", "dismissWhenShowAgain", "dismissWhenTouchOutside", "elevation", "height", "iconColor", "iconDrawable", "Lcom/skydoves/balloon/IconForm;", "iconForm", "Lcom/skydoves/balloon/IconGravity;", "iconGravity", "iconSize", "iconSpace", "isFocusable", "isRtlSupport", "isStatusBarVisible", "isVisibleArrow", "isVisibleOverlay", "Landroid/view/View;", "layout", "layoutRes", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "marginBottom", "marginLeft", "marginRight", "marginTop", "Landroid/text/method/MovementMethod;", "movementMethod", "Lcom/skydoves/balloon/OnBalloonClickListener;", "onBalloonClickListener", "Lcom/skydoves/balloon/OnBalloonDismissListener;", "onBalloonDismissListener", "Lcom/skydoves/balloon/OnBalloonInitializedListener;", "onBalloonInitializedListener", "Lcom/skydoves/balloon/OnBalloonOutsideTouchListener;", "onBalloonOutsideTouchListener", "Lcom/skydoves/balloon/OnBalloonOverlayClickListener;", "onBalloonOverlayClickListener", "Landroid/view/View$OnTouchListener;", "onBalloonTouchListener", "overlayColor", "overlayPadding", "Landroid/graphics/Point;", "overlayPosition", "Lcom/skydoves/balloon/overlay/BalloonOverlayShape;", "overlayShape", "paddingBottom", "paddingLeft", "paddingRight", "paddingTop", "", "preferenceName", "showTimes", "supportRtlLayoutFactor", "", "text", "textColor", "Lcom/skydoves/balloon/TextForm;", "textForm", "textGravity", "textIsHtml", "textSize", "textTypeface", "Landroid/graphics/Typeface;", "textTypefaceObject", "width", "widthRatio", "build", "Lcom/skydoves/balloon/Balloon;", "value", "setAlpha", "setArrowAlignAnchorPadding", "setArrowAlignAnchorPaddingRatio", "setArrowBottomPadding", "setArrowColor", "setArrowColorResource", "setArrowConstraints", "setArrowDrawable", "setArrowDrawableResource", "setArrowLeftPadding", "setArrowOrientation", "setArrowPosition", "setArrowRightPadding", "setArrowSize", "setArrowSizeResource", "setArrowTopPadding", "setAutoDismissDuration", "setBackgroundColor", "setBackgroundColorResource", "setBackgroundDrawable", "setBackgroundDrawableResource", "setBalloonAnimation", "setBalloonAnimationStyle", "setBalloonOverlayAnimation", "setBalloonOverlayAnimationStyle", "setCircularDuration", "setCornerRadius", "setCornerRadiusResource", "setDismissWhenClicked", "setDismissWhenLifecycleOnPause", "setDismissWhenOverlayClicked", "setDismissWhenShowAgain", "setDismissWhenTouchOutside", "setElevation", "setElevationResource", "setFocusable", "setHeight", "setHeightResource", "setIconColor", "setIconColorResource", "setIconDrawable", "setIconDrawableResource", "setIconForm", "setIconGravity", "setIconSize", "setIconSizeResource", "setIconSpace", "setIconSpaceResource", "setIsStatusBarVisible", "setIsVisibleArrow", "setIsVisibleOverlay", "setLayout", "setLifecycleOwner", "setMargin", "setMarginBottom", "setMarginLeft", "setMarginResource", "setMarginRight", "setMarginTop", "setMovementMethod", "setOnBalloonClickListener", MessageMenuDialog.BLOCK, "Lkotlin/Function1;", "", "setOnBalloonDismissListener", "Lkotlin/Function0;", "setOnBalloonInitializedListener", "setOnBalloonOutsideTouchListener", "Lkotlin/Function2;", "Landroid/view/MotionEvent;", "setOnBalloonOverlayClickListener", "setOnBalloonTouchListener", "setOverlayColor", "setOverlayColorResource", "setOverlayPadding", "setOverlayPosition", "setOverlayShape", "setPadding", "setPaddingBottom", "setPaddingLeft", "setPaddingResource", "setPaddingRight", "setPaddingTop", "setPreferenceName", "setShowTime", "setText", "setTextColor", "setTextColorResource", "setTextForm", "setTextGravity", "setTextIsHtml", "setTextResource", "setTextSize", "setTextTypeface", "setWidth", "setWidthRatio", "setWidthResource", "balloon_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static final class Builder {

        @FloatRange(from = 0.0d, to = 1.0d)
        @JvmField
        public float alpha;

        @JvmField
        public int arrowAlignAnchorPadding;

        @JvmField
        public float arrowAlignAnchorPaddingRatio;

        @JvmField
        public int arrowBottomPadding;

        @JvmField
        public int arrowColor;

        @JvmField
        @NotNull
        public ArrowConstraints arrowConstraints;

        @JvmField
        @Nullable
        public Drawable arrowDrawable;

        @JvmField
        public int arrowLeftPadding;

        @JvmField
        @NotNull
        public ArrowOrientation arrowOrientation;

        @FloatRange(from = 0.0d, to = 1.0d)
        @JvmField
        public float arrowPosition;

        @JvmField
        public int arrowRightPadding;

        @JvmField
        public int arrowSize;

        @JvmField
        public int arrowTopPadding;

        @JvmField
        public long autoDismissDuration;

        @JvmField
        public int backgroundColor;

        @JvmField
        @Nullable
        public Drawable backgroundDrawable;

        @JvmField
        @NotNull
        public BalloonAnimation balloonAnimation;

        @JvmField
        public int balloonAnimationStyle;

        @JvmField
        @NotNull
        public BalloonOverlayAnimation balloonOverlayAnimation;

        @JvmField
        public int balloonOverlayAnimationStyle;

        @JvmField
        public long circularDuration;
        private final Context context;

        @JvmField
        public float cornerRadius;

        @JvmField
        public boolean dismissWhenClicked;

        @JvmField
        public boolean dismissWhenLifecycleOnPause;

        @JvmField
        public boolean dismissWhenOverlayClicked;

        @JvmField
        public boolean dismissWhenShowAgain;

        @JvmField
        public boolean dismissWhenTouchOutside;

        @JvmField
        public float elevation;

        @JvmField
        public int height;

        @JvmField
        public int iconColor;

        @JvmField
        @Nullable
        public Drawable iconDrawable;

        @JvmField
        @Nullable
        public IconForm iconForm;

        @JvmField
        @NotNull
        public IconGravity iconGravity;

        @JvmField
        public int iconSize;

        @JvmField
        public int iconSpace;

        @JvmField
        public boolean isFocusable;

        @JvmField
        public boolean isRtlSupport;

        @JvmField
        public boolean isStatusBarVisible;

        @JvmField
        public boolean isVisibleArrow;

        @JvmField
        public boolean isVisibleOverlay;

        @JvmField
        @Nullable
        public View layout;

        @JvmField
        public int layoutRes;

        @JvmField
        @Nullable
        public LifecycleOwner lifecycleOwner;

        @JvmField
        public int marginBottom;

        @JvmField
        public int marginLeft;

        @JvmField
        public int marginRight;

        @JvmField
        public int marginTop;

        @JvmField
        @Nullable
        public MovementMethod movementMethod;

        @JvmField
        @Nullable
        public OnBalloonClickListener onBalloonClickListener;

        @JvmField
        @Nullable
        public OnBalloonDismissListener onBalloonDismissListener;

        @JvmField
        @Nullable
        public OnBalloonInitializedListener onBalloonInitializedListener;

        @JvmField
        @Nullable
        public OnBalloonOutsideTouchListener onBalloonOutsideTouchListener;

        @JvmField
        @Nullable
        public OnBalloonOverlayClickListener onBalloonOverlayClickListener;

        @JvmField
        @Nullable
        public View.OnTouchListener onBalloonTouchListener;

        @JvmField
        public int overlayColor;

        @JvmField
        public float overlayPadding;

        @JvmField
        @Nullable
        public Point overlayPosition;

        @JvmField
        @NotNull
        public BalloonOverlayShape overlayShape;

        @JvmField
        public int paddingBottom;

        @JvmField
        public int paddingLeft;

        @JvmField
        public int paddingRight;

        @JvmField
        public int paddingTop;

        @JvmField
        @Nullable
        public String preferenceName;

        @JvmField
        public int showTimes;

        @JvmField
        public int supportRtlLayoutFactor;

        @JvmField
        @NotNull
        public CharSequence text;

        @JvmField
        public int textColor;

        @JvmField
        @Nullable
        public TextForm textForm;

        @JvmField
        public int textGravity;

        @JvmField
        public boolean textIsHtml;

        @JvmField
        public float textSize;

        @JvmField
        public int textTypeface;

        @JvmField
        @Nullable
        public Typeface textTypefaceObject;

        @JvmField
        public int width;

        @FloatRange(from = 0.0d, to = 1.0d)
        @JvmField
        public float widthRatio;

        public Builder(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.width = Integer.MIN_VALUE;
            this.height = Integer.MIN_VALUE;
            this.isVisibleArrow = true;
            this.arrowColor = Integer.MIN_VALUE;
            this.arrowSize = ContextExtensionKt.dp2Px(context, 12);
            this.arrowPosition = 0.5f;
            this.arrowConstraints = ArrowConstraints.ALIGN_BALLOON;
            this.arrowOrientation = ArrowOrientation.BOTTOM;
            this.arrowAlignAnchorPaddingRatio = 2.5f;
            this.backgroundColor = RoundedDrawable.DEFAULT_BORDER_COLOR;
            this.cornerRadius = ContextExtensionKt.dp2Px(context, 5);
            this.text = "";
            this.textColor = -1;
            this.textSize = 12.0f;
            this.textGravity = 17;
            this.iconGravity = IconGravity.LEFT;
            this.iconSize = ContextExtensionKt.dp2Px(context, 28);
            this.iconSpace = ContextExtensionKt.dp2Px(context, 8);
            this.iconColor = Integer.MIN_VALUE;
            this.alpha = 1.0f;
            this.elevation = ContextExtensionKt.dp2Px(context, 2.0f);
            this.layoutRes = Integer.MIN_VALUE;
            this.overlayShape = BalloonOverlayOval.INSTANCE;
            this.dismissWhenTouchOutside = true;
            this.dismissWhenOverlayClicked = true;
            this.autoDismissDuration = -1L;
            this.balloonAnimationStyle = Integer.MIN_VALUE;
            this.balloonOverlayAnimationStyle = Integer.MIN_VALUE;
            this.balloonAnimation = BalloonAnimation.FADE;
            this.balloonOverlayAnimation = BalloonOverlayAnimation.FADE;
            this.circularDuration = 500L;
            this.showTimes = 1;
            this.supportRtlLayoutFactor = DefinitionKt.unaryMinus(1, this.isRtlSupport);
            this.isFocusable = true;
            this.isStatusBarVisible = true;
        }

        @NotNull
        public final Balloon build() {
            return new Balloon(this.context, this);
        }

        @NotNull
        public final Builder isRtlSupport(boolean value) {
            this.supportRtlLayoutFactor = DefinitionKt.unaryMinus(1, value);
            this.isRtlSupport = value;
            return this;
        }

        @NotNull
        public final Builder setAlpha(@FloatRange(from = 0.0d, to = 1.0d) float value) {
            this.alpha = value;
            return this;
        }

        @NotNull
        public final Builder setArrowAlignAnchorPadding(int value) {
            this.arrowAlignAnchorPadding = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setArrowAlignAnchorPaddingRatio(float value) {
            this.arrowAlignAnchorPaddingRatio = value;
            return this;
        }

        @NotNull
        public final Builder setArrowBottomPadding(int value) {
            this.arrowBottomPadding = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setArrowColor(int value) {
            this.arrowColor = value;
            return this;
        }

        @NotNull
        public final Builder setArrowColorResource(int value) {
            this.arrowColor = ContextExtensionKt.contextColor(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setArrowConstraints(@NotNull ArrowConstraints value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.arrowConstraints = value;
            return this;
        }

        @NotNull
        public final Builder setArrowDrawable(@Nullable Drawable value) {
            Drawable drawable;
            if (value != null) {
                drawable = value.mutate();
            } else {
                drawable = null;
            }
            this.arrowDrawable = drawable;
            if (value != null && this.arrowSize == Integer.MIN_VALUE) {
                this.arrowSize = Math.max(value.getIntrinsicWidth(), value.getIntrinsicHeight());
            }
            return this;
        }

        @NotNull
        public final Builder setArrowDrawableResource(int value) {
            setArrowDrawable(ContextExtensionKt.contextDrawable(this.context, value));
            return this;
        }

        @NotNull
        public final Builder setArrowLeftPadding(int value) {
            this.arrowLeftPadding = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setArrowOrientation(@NotNull ArrowOrientation value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.arrowOrientation = value;
            return this;
        }

        @NotNull
        public final Builder setArrowPosition(@FloatRange(from = 0.0d, to = 1.0d) float value) {
            this.arrowPosition = value;
            return this;
        }

        @NotNull
        public final Builder setArrowRightPadding(int value) {
            this.arrowRightPadding = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setArrowSize(int value) {
            int i = Integer.MIN_VALUE;
            if (value != Integer.MIN_VALUE) {
                i = ContextExtensionKt.dp2Px(this.context, value);
            }
            this.arrowSize = i;
            return this;
        }

        @NotNull
        public final Builder setArrowSizeResource(int value) {
            this.arrowSize = ContextExtensionKt.dimen(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setArrowTopPadding(int value) {
            this.arrowTopPadding = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setAutoDismissDuration(long value) {
            this.autoDismissDuration = value;
            return this;
        }

        @NotNull
        public final Builder setBackgroundColor(int value) {
            this.backgroundColor = value;
            return this;
        }

        @NotNull
        public final Builder setBackgroundColorResource(int value) {
            this.backgroundColor = ContextExtensionKt.contextColor(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setBackgroundDrawable(@Nullable Drawable value) {
            Drawable drawable;
            if (value != null) {
                drawable = value.mutate();
            } else {
                drawable = null;
            }
            this.backgroundDrawable = drawable;
            return this;
        }

        @NotNull
        public final Builder setBackgroundDrawableResource(int value) {
            Drawable drawable;
            Drawable contextDrawable = ContextExtensionKt.contextDrawable(this.context, value);
            if (contextDrawable != null) {
                drawable = contextDrawable.mutate();
            } else {
                drawable = null;
            }
            this.backgroundDrawable = drawable;
            return this;
        }

        @NotNull
        public final Builder setBalloonAnimation(@NotNull BalloonAnimation value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.balloonAnimation = value;
            if (value == BalloonAnimation.CIRCULAR) {
                setFocusable(false);
            }
            return this;
        }

        @NotNull
        public final Builder setBalloonAnimationStyle(int value) {
            this.balloonAnimationStyle = value;
            return this;
        }

        @NotNull
        public final Builder setBalloonOverlayAnimation(@NotNull BalloonOverlayAnimation value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.balloonOverlayAnimation = value;
            return this;
        }

        @NotNull
        public final Builder setBalloonOverlayAnimationStyle(int value) {
            this.balloonOverlayAnimationStyle = value;
            return this;
        }

        @NotNull
        public final Builder setCircularDuration(long value) {
            this.circularDuration = value;
            return this;
        }

        @NotNull
        public final Builder setCornerRadius(float value) {
            this.cornerRadius = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setCornerRadiusResource(int value) {
            this.cornerRadius = ContextExtensionKt.dimen(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setDismissWhenClicked(boolean value) {
            this.dismissWhenClicked = value;
            return this;
        }

        @NotNull
        public final Builder setDismissWhenLifecycleOnPause(boolean value) {
            this.dismissWhenLifecycleOnPause = value;
            return this;
        }

        @NotNull
        public final Builder setDismissWhenOverlayClicked(boolean value) {
            this.dismissWhenOverlayClicked = value;
            return this;
        }

        @NotNull
        public final Builder setDismissWhenShowAgain(boolean value) {
            this.dismissWhenShowAgain = value;
            return this;
        }

        @NotNull
        public final Builder setDismissWhenTouchOutside(boolean value) {
            this.dismissWhenTouchOutside = value;
            if (!value) {
                setFocusable(value);
            }
            return this;
        }

        @TargetApi(21)
        @NotNull
        public final Builder setElevation(int value) {
            this.elevation = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @TargetApi(21)
        @NotNull
        public final Builder setElevationResource(int value) {
            this.elevation = ContextExtensionKt.dimen(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setFocusable(boolean value) {
            this.isFocusable = value;
            return this;
        }

        @NotNull
        public final Builder setHeight(int value) {
            boolean z;
            if (value <= 0 && value != Integer.MIN_VALUE) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.height = ContextExtensionKt.dp2Px(this.context, value);
                return this;
            }
            throw new IllegalArgumentException("The height of the balloon must bigger than zero.");
        }

        @NotNull
        public final Builder setHeightResource(int value) {
            this.height = ContextExtensionKt.dimen(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setIconColor(int value) {
            this.iconColor = value;
            return this;
        }

        @NotNull
        public final Builder setIconColorResource(int value) {
            this.iconColor = ContextExtensionKt.contextColor(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setIconDrawable(@Nullable Drawable value) {
            Drawable drawable;
            if (value != null) {
                drawable = value.mutate();
            } else {
                drawable = null;
            }
            this.iconDrawable = drawable;
            return this;
        }

        @NotNull
        public final Builder setIconDrawableResource(int value) {
            Drawable drawable;
            Drawable contextDrawable = ContextExtensionKt.contextDrawable(this.context, value);
            if (contextDrawable != null) {
                drawable = contextDrawable.mutate();
            } else {
                drawable = null;
            }
            this.iconDrawable = drawable;
            return this;
        }

        @NotNull
        public final Builder setIconForm(@NotNull IconForm value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.iconForm = value;
            return this;
        }

        @NotNull
        public final Builder setIconGravity(@NotNull IconGravity value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.iconGravity = value;
            return this;
        }

        @NotNull
        public final Builder setIconSize(int value) {
            this.iconSize = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setIconSizeResource(int value) {
            this.iconSize = ContextExtensionKt.dimen(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setIconSpace(int value) {
            this.iconSpace = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setIconSpaceResource(int value) {
            this.iconSpace = ContextExtensionKt.dimen(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setIsStatusBarVisible(boolean value) {
            this.isStatusBarVisible = value;
            return this;
        }

        @NotNull
        public final Builder setIsVisibleArrow(boolean value) {
            this.isVisibleArrow = value;
            return this;
        }

        @NotNull
        public final Builder setIsVisibleOverlay(boolean value) {
            this.isVisibleOverlay = value;
            return this;
        }

        @NotNull
        public final Builder setLayout(int layoutRes) {
            this.layoutRes = layoutRes;
            return this;
        }

        @NotNull
        public final Builder setLifecycleOwner(@Nullable LifecycleOwner value) {
            this.lifecycleOwner = value;
            return this;
        }

        @NotNull
        public final Builder setMargin(int value) {
            setMarginLeft(value);
            setMarginTop(value);
            setMarginRight(value);
            setMarginBottom(value);
            return this;
        }

        @NotNull
        public final Builder setMarginBottom(int value) {
            this.marginBottom = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setMarginLeft(int value) {
            this.marginLeft = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setMarginResource(int value) {
            int dimen = ContextExtensionKt.dimen(this.context, value);
            this.marginLeft = dimen;
            this.marginTop = dimen;
            this.marginRight = dimen;
            this.marginBottom = dimen;
            return this;
        }

        @NotNull
        public final Builder setMarginRight(int value) {
            this.marginRight = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setMarginTop(int value) {
            this.marginTop = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setMovementMethod(@NotNull MovementMethod value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.movementMethod = value;
            return this;
        }

        @NotNull
        public final Builder setOnBalloonClickListener(@NotNull OnBalloonClickListener value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.onBalloonClickListener = value;
            return this;
        }

        @NotNull
        public final Builder setOnBalloonDismissListener(@NotNull OnBalloonDismissListener value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.onBalloonDismissListener = value;
            return this;
        }

        @NotNull
        public final Builder setOnBalloonInitializedListener(@NotNull OnBalloonInitializedListener value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.onBalloonInitializedListener = value;
            return this;
        }

        @NotNull
        public final Builder setOnBalloonOutsideTouchListener(@NotNull OnBalloonOutsideTouchListener value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.onBalloonOutsideTouchListener = value;
            return this;
        }

        @NotNull
        public final Builder setOnBalloonOverlayClickListener(@NotNull OnBalloonOverlayClickListener value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.onBalloonOverlayClickListener = value;
            return this;
        }

        @NotNull
        public final Builder setOnBalloonTouchListener(@NotNull View.OnTouchListener value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.onBalloonTouchListener = value;
            return this;
        }

        @NotNull
        public final Builder setOverlayColor(int value) {
            this.overlayColor = value;
            return this;
        }

        @NotNull
        public final Builder setOverlayColorResource(int value) {
            this.overlayColor = ContextExtensionKt.contextColor(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setOverlayPadding(float value) {
            this.overlayPadding = value;
            return this;
        }

        @NotNull
        public final Builder setOverlayPosition(@NotNull Point value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.overlayPosition = value;
            return this;
        }

        @NotNull
        public final Builder setOverlayShape(@NotNull BalloonOverlayShape value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.overlayShape = value;
            return this;
        }

        @NotNull
        public final Builder setPadding(int value) {
            setPaddingLeft(value);
            setPaddingTop(value);
            setPaddingRight(value);
            setPaddingBottom(value);
            return this;
        }

        @NotNull
        public final Builder setPaddingBottom(int value) {
            this.paddingBottom = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setPaddingLeft(int value) {
            this.paddingLeft = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setPaddingResource(int value) {
            int dimen = ContextExtensionKt.dimen(this.context, value);
            this.paddingLeft = dimen;
            this.paddingTop = dimen;
            this.paddingRight = dimen;
            this.paddingBottom = dimen;
            return this;
        }

        @NotNull
        public final Builder setPaddingRight(int value) {
            this.paddingRight = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setPaddingTop(int value) {
            this.paddingTop = ContextExtensionKt.dp2Px(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setPreferenceName(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.preferenceName = value;
            return this;
        }

        @NotNull
        public final Builder setShowTime(int value) {
            this.showTimes = value;
            return this;
        }

        @NotNull
        public final Builder setText(@NotNull CharSequence value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.text = value;
            return this;
        }

        @NotNull
        public final Builder setTextColor(int value) {
            this.textColor = value;
            return this;
        }

        @NotNull
        public final Builder setTextColorResource(int value) {
            this.textColor = ContextExtensionKt.contextColor(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setTextForm(@NotNull TextForm value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.textForm = value;
            return this;
        }

        @NotNull
        public final Builder setTextGravity(int value) {
            this.textGravity = value;
            return this;
        }

        @NotNull
        public final Builder setTextIsHtml(boolean value) {
            this.textIsHtml = value;
            return this;
        }

        @NotNull
        public final Builder setTextResource(int value) {
            String string = this.context.getString(value);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(value)");
            this.text = string;
            return this;
        }

        @NotNull
        public final Builder setTextSize(float value) {
            this.textSize = value;
            return this;
        }

        @NotNull
        public final Builder setTextTypeface(int value) {
            this.textTypeface = value;
            return this;
        }

        @NotNull
        public final Builder setWidth(int value) {
            boolean z;
            if (value <= 0 && value != Integer.MIN_VALUE) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                this.width = ContextExtensionKt.dp2Px(this.context, value);
                return this;
            }
            throw new IllegalArgumentException("The width of the balloon must bigger than zero.");
        }

        @NotNull
        public final Builder setWidthRatio(@FloatRange(from = 0.0d, to = 1.0d) float value) {
            this.widthRatio = value;
            return this;
        }

        @NotNull
        public final Builder setWidthResource(int value) {
            this.width = ContextExtensionKt.dimen(this.context, value);
            return this;
        }

        @NotNull
        public final Builder setLayout(@NotNull View layout) {
            Intrinsics.checkNotNullParameter(layout, "layout");
            this.layout = layout;
            return this;
        }

        public final /* synthetic */ Builder setOnBalloonClickListener(Function1<? super View, Unit> block) {
            Intrinsics.checkNotNullParameter(block, MessageMenuDialog.BLOCK);
            this.onBalloonClickListener = new BalloonKt$sam$i$com_skydoves_balloon_OnBalloonClickListener$0(block);
            return this;
        }

        public final /* synthetic */ Builder setOnBalloonDismissListener(Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(block, MessageMenuDialog.BLOCK);
            this.onBalloonDismissListener = new BalloonKt$sam$i$com_skydoves_balloon_OnBalloonDismissListener$0(block);
            return this;
        }

        public final /* synthetic */ Builder setOnBalloonInitializedListener(Function1<? super View, Unit> block) {
            Intrinsics.checkNotNullParameter(block, MessageMenuDialog.BLOCK);
            this.onBalloonInitializedListener = new BalloonKt$sam$i$com_skydoves_balloon_OnBalloonInitializedListener$0(block);
            return this;
        }

        public final /* synthetic */ Builder setOnBalloonOutsideTouchListener(Function2<? super View, ? super MotionEvent, Unit> block) {
            Intrinsics.checkNotNullParameter(block, MessageMenuDialog.BLOCK);
            this.onBalloonOutsideTouchListener = new BalloonKt$sam$i$com_skydoves_balloon_OnBalloonOutsideTouchListener$0(block);
            setDismissWhenTouchOutside(false);
            return this;
        }

        @NotNull
        public final Builder setOnBalloonOverlayClickListener(@NotNull Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(block, MessageMenuDialog.BLOCK);
            this.onBalloonOverlayClickListener = new BalloonKt$sam$i$com_skydoves_balloon_OnBalloonOverlayClickListener$0(block);
            return this;
        }

        @NotNull
        public final Builder setTextTypeface(@NotNull Typeface value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.textTypefaceObject = value;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&¨\u0006\t"}, d2 = {"Lcom/skydoves/balloon/Balloon$Factory;", "", "()V", "create", "Lcom/skydoves/balloon/Balloon;", "context", "Landroid/content/Context;", "lifecycle", "Landroidx/lifecycle/LifecycleOwner;", "balloon_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static abstract class Factory {
        @NotNull
        public abstract Balloon create(@NotNull Context context, @Nullable LifecycleOwner lifecycle);
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;

        static {
            int[] iArr = new int[ArrowOrientation.values().length];
            $EnumSwitchMapping$0 = iArr;
            ArrowOrientation arrowOrientation = ArrowOrientation.BOTTOM;
            iArr[arrowOrientation.ordinal()] = 1;
            ArrowOrientation arrowOrientation2 = ArrowOrientation.TOP;
            iArr[arrowOrientation2.ordinal()] = 2;
            ArrowOrientation arrowOrientation3 = ArrowOrientation.LEFT;
            iArr[arrowOrientation3.ordinal()] = 3;
            ArrowOrientation arrowOrientation4 = ArrowOrientation.RIGHT;
            iArr[arrowOrientation4.ordinal()] = 4;
            int[] iArr2 = new int[ArrowOrientation.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[arrowOrientation.ordinal()] = 1;
            iArr2[arrowOrientation2.ordinal()] = 2;
            iArr2[arrowOrientation3.ordinal()] = 3;
            iArr2[arrowOrientation4.ordinal()] = 4;
            int[] iArr3 = new int[ArrowConstraints.values().length];
            $EnumSwitchMapping$2 = iArr3;
            ArrowConstraints arrowConstraints = ArrowConstraints.ALIGN_BALLOON;
            iArr3[arrowConstraints.ordinal()] = 1;
            ArrowConstraints arrowConstraints2 = ArrowConstraints.ALIGN_ANCHOR;
            iArr3[arrowConstraints2.ordinal()] = 2;
            int[] iArr4 = new int[ArrowConstraints.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[arrowConstraints.ordinal()] = 1;
            iArr4[arrowConstraints2.ordinal()] = 2;
            int[] iArr5 = new int[ArrowOrientation.values().length];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[arrowOrientation3.ordinal()] = 1;
            iArr5[arrowOrientation2.ordinal()] = 2;
            iArr5[arrowOrientation4.ordinal()] = 3;
            iArr5[arrowOrientation.ordinal()] = 4;
            int[] iArr6 = new int[BalloonAnimation.values().length];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[BalloonAnimation.ELASTIC.ordinal()] = 1;
            iArr6[BalloonAnimation.CIRCULAR.ordinal()] = 2;
            iArr6[BalloonAnimation.FADE.ordinal()] = 3;
            iArr6[BalloonAnimation.OVERSHOOT.ordinal()] = 4;
            int[] iArr7 = new int[BalloonOverlayAnimation.values().length];
            $EnumSwitchMapping$6 = iArr7;
            iArr7[BalloonOverlayAnimation.FADE.ordinal()] = 1;
        }
    }

    public Balloon(@NotNull Context context, @NotNull Builder builder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.context = context;
        this.builder = builder;
        LayoutBalloonLibrarySkydovesBinding inflate = LayoutBalloonLibrarySkydovesBinding.inflate(LayoutInflater.from(context), null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutBalloonLibrarySkyd…om(context), null, false)");
        this.binding = inflate;
        LayoutBalloonOverlayLibrarySkydovesBinding inflate2 = LayoutBalloonOverlayLibrarySkydovesBinding.inflate(LayoutInflater.from(context), null, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "LayoutBalloonOverlayLibr…om(context), null, false)");
        this.overlayBinding = inflate2;
        this.onBalloonInitializedListener = builder.onBalloonInitializedListener;
        this.balloonPersistence = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<BalloonPersistence>() { // from class: com.skydoves.balloon.Balloon$balloonPersistence$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BalloonPersistence m١٠٥invoke() {
                return BalloonPersistence.INSTANCE.getInstance(Balloon.this.context);
            }
        });
        this.bodyWindow = new PopupWindow(inflate.getRoot(), -2, -2);
        this.overlayWindow = new PopupWindow(inflate2.getRoot(), -1, -1);
        createByBuilder();
    }

    private final void adjustFitsSystemWindows(ViewGroup parent) {
        parent.setFitsSystemWindows(false);
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            Intrinsics.checkNotNullExpressionValue(childAt, "child");
            childAt.setFitsSystemWindows(false);
            if (childAt instanceof ViewGroup) {
                adjustFitsSystemWindows((ViewGroup) childAt);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyBalloonAnimation() {
        Builder builder = this.builder;
        int i = builder.balloonAnimationStyle;
        if (i == Integer.MIN_VALUE) {
            int i2 = WhenMappings.$EnumSwitchMapping$5[builder.balloonAnimation.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            this.bodyWindow.setAnimationStyle(R.style.Normal_Balloon_Library);
                            return;
                        } else {
                            this.bodyWindow.setAnimationStyle(R.style.Overshoot_Balloon_Library);
                            return;
                        }
                    }
                    this.bodyWindow.setAnimationStyle(R.style.Fade_Balloon_Library);
                    return;
                }
                View contentView = this.bodyWindow.getContentView();
                Intrinsics.checkNotNullExpressionValue(contentView, "bodyWindow.contentView");
                ViewExtensionKt.circularRevealed(contentView, this.builder.circularDuration);
                this.bodyWindow.setAnimationStyle(R.style.NormalDispose_Balloon_Library);
                return;
            }
            this.bodyWindow.setAnimationStyle(R.style.Elastic_Balloon_Library);
            return;
        }
        this.bodyWindow.setAnimationStyle(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyBalloonOverlayAnimation() {
        Builder builder = this.builder;
        if (builder.balloonOverlayAnimationStyle == Integer.MIN_VALUE) {
            if (WhenMappings.$EnumSwitchMapping$6[builder.balloonOverlayAnimation.ordinal()] != 1) {
                this.overlayWindow.setAnimationStyle(R.style.Normal_Balloon_Library);
                return;
            } else {
                this.overlayWindow.setAnimationStyle(R.style.Fade_Balloon_Library);
                return;
            }
        }
        this.overlayWindow.setAnimationStyle(builder.balloonAnimationStyle);
    }

    private final void createByBuilder() {
        Lifecycle lifecycle;
        initializeBackground();
        initializeBalloonRoot();
        initializeBalloonWindow();
        initializeBalloonContent();
        initializeBalloonOverlay();
        initializeBalloonListeners();
        Builder builder = this.builder;
        if (builder.layoutRes != Integer.MIN_VALUE) {
            initializeCustomLayoutWithResource();
        } else if (builder.layout != null) {
            initializeCustomLayoutWithView();
        } else {
            initializeIcon();
            initializeText();
        }
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        adjustFitsSystemWindows(root);
        LifecycleOwner lifecycleOwner = this.builder.lifecycleOwner;
        if (lifecycleOwner != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.addObserver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getArrowConstraintPositionX(View anchor) {
        RelativeLayout relativeLayout = this.binding.balloonContent;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.balloonContent");
        int i = getWindowBodyScreenLocation(relativeLayout)[0];
        int i2 = getWindowBodyScreenLocation(anchor)[0];
        float minArrowPosition = getMinArrowPosition();
        float measuredWidth = ((getMeasuredWidth() - minArrowPosition) - r4.marginRight) - r4.marginLeft;
        float f = r4.arrowSize / 2.0f;
        int i3 = WhenMappings.$EnumSwitchMapping$2[this.builder.arrowConstraints.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                if (anchor.getWidth() + i2 >= i) {
                    if (getMeasuredWidth() + i >= i2) {
                        float width = (((anchor.getWidth() * this.builder.arrowPosition) + i2) - i) - f;
                        if (width > getDoubleArrowSize()) {
                            if (width <= getMeasuredWidth() - getDoubleArrowSize()) {
                                return width;
                            }
                        } else {
                            return minArrowPosition;
                        }
                    }
                    return measuredWidth;
                }
                return minArrowPosition;
            }
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNullExpressionValue(this.binding.balloonWrapper, "binding.balloonWrapper");
        return (r8.getWidth() * this.builder.arrowPosition) - f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getArrowConstraintPositionY(View anchor) {
        RelativeLayout relativeLayout = this.binding.balloonContent;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.balloonContent");
        int statusBarHeight = getWindowBodyScreenLocation(relativeLayout)[1] - getStatusBarHeight();
        int statusBarHeight2 = getWindowBodyScreenLocation(anchor)[1] - getStatusBarHeight();
        float minArrowPosition = getMinArrowPosition();
        Builder builder = this.builder;
        float measuredHeight = ((getMeasuredHeight() - minArrowPosition) - builder.marginTop) - builder.marginBottom;
        int i = builder.arrowSize / 2;
        int i2 = WhenMappings.$EnumSwitchMapping$3[builder.arrowConstraints.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                if (anchor.getHeight() + statusBarHeight2 >= statusBarHeight) {
                    if (getMeasuredHeight() + statusBarHeight >= statusBarHeight2) {
                        float height = (((anchor.getHeight() * this.builder.arrowPosition) + statusBarHeight2) - statusBarHeight) - i;
                        if (height > getDoubleArrowSize()) {
                            if (height <= getMeasuredHeight() - getDoubleArrowSize()) {
                                return height;
                            }
                        } else {
                            return minArrowPosition;
                        }
                    }
                    return measuredHeight;
                }
                return minArrowPosition;
            }
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNullExpressionValue(this.binding.balloonWrapper, "binding.balloonWrapper");
        return (r10.getHeight() * this.builder.arrowPosition) - i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BalloonPersistence getBalloonPersistence() {
        return (BalloonPersistence) this.balloonPersistence.getValue();
    }

    private final int getDoubleArrowSize() {
        return this.builder.arrowSize * 2;
    }

    private final int getMeasuredTextWidth(int measuredWidth) {
        int i;
        int i2 = ContextExtensionKt.displaySize(this.context).x;
        Builder builder = this.builder;
        int dp2Px = builder.paddingLeft + builder.paddingRight + ContextExtensionKt.dp2Px(this.context, 24);
        Builder builder2 = this.builder;
        if (builder2.iconDrawable != null) {
            i = builder2.iconSize + builder2.iconSpace;
        } else {
            i = 0;
        }
        int i3 = dp2Px + i;
        float f = builder2.widthRatio;
        if (f != 0.0f) {
            return ((int) (i2 * f)) - i3;
        }
        int i4 = builder2.width;
        if (i4 != Integer.MIN_VALUE && i4 <= i2) {
            return i4 - i3;
        }
        int i5 = i2 - i3;
        if (measuredWidth >= i5) {
            return i5;
        }
        return measuredWidth;
    }

    private final float getMinArrowPosition() {
        return (r0.arrowSize * this.builder.arrowAlignAnchorPaddingRatio) + r0.arrowAlignAnchorPadding;
    }

    private final int getStatusBarHeight() {
        Rect rect = new Rect();
        Context context = this.context;
        if ((context instanceof Activity) && this.builder.isStatusBarVisible) {
            Window window = ((Activity) context).getWindow();
            Intrinsics.checkNotNullExpressionValue(window, "context.window");
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            return rect.top;
        }
        return 0;
    }

    private final int[] getWindowBodyScreenLocation(View view) {
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeArrow(final View anchor) {
        final AppCompatImageView appCompatImageView = this.binding.balloonArrow;
        ViewExtensionKt.visible(appCompatImageView, this.builder.isVisibleArrow);
        int i = this.builder.arrowSize;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        int i2 = WhenMappings.$EnumSwitchMapping$0[this.builder.arrowOrientation.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        RelativeLayout relativeLayout = this.binding.balloonContent;
                        Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.balloonContent");
                        layoutParams.addRule(7, relativeLayout.getId());
                        appCompatImageView.setRotation(90.0f);
                    }
                } else {
                    RelativeLayout relativeLayout2 = this.binding.balloonContent;
                    Intrinsics.checkNotNullExpressionValue(relativeLayout2, "binding.balloonContent");
                    layoutParams.addRule(5, relativeLayout2.getId());
                    appCompatImageView.setRotation(-90.0f);
                }
            } else {
                RelativeLayout relativeLayout3 = this.binding.balloonContent;
                Intrinsics.checkNotNullExpressionValue(relativeLayout3, "binding.balloonContent");
                layoutParams.addRule(6, relativeLayout3.getId());
                appCompatImageView.setRotation(0.0f);
            }
        } else {
            RelativeLayout relativeLayout4 = this.binding.balloonContent;
            Intrinsics.checkNotNullExpressionValue(relativeLayout4, "binding.balloonContent");
            layoutParams.addRule(8, relativeLayout4.getId());
            appCompatImageView.setRotation(180.0f);
        }
        appCompatImageView.setLayoutParams(layoutParams);
        appCompatImageView.setAlpha(this.builder.alpha);
        Drawable drawable = this.builder.arrowDrawable;
        if (drawable != null) {
            appCompatImageView.setImageDrawable(drawable);
        }
        Builder builder = this.builder;
        appCompatImageView.setPadding(builder.arrowLeftPadding, builder.arrowTopPadding, builder.arrowRightPadding, builder.arrowBottomPadding);
        Builder builder2 = this.builder;
        int i3 = builder2.arrowColor;
        if (i3 != Integer.MIN_VALUE) {
            g.c(appCompatImageView, ColorStateList.valueOf(i3));
        } else {
            g.c(appCompatImageView, ColorStateList.valueOf(builder2.backgroundColor));
        }
        this.binding.getRoot().post(new Runnable() { // from class: com.skydoves.balloon.Balloon$initializeArrow$$inlined$with$lambda$1
            @Override // java.lang.Runnable
            public final void run() {
                float arrowConstraintPositionX;
                float arrowConstraintPositionY;
                OnBalloonInitializedListener onBalloonInitializedListener = this.getOnBalloonInitializedListener();
                if (onBalloonInitializedListener != null) {
                    onBalloonInitializedListener.onBalloonInitialized(this.getContentView());
                }
                int i4 = Balloon.WhenMappings.$EnumSwitchMapping$1[this.builder.arrowOrientation.ordinal()];
                if (i4 != 1 && i4 != 2) {
                    if (i4 == 3 || i4 == 4) {
                        AppCompatImageView appCompatImageView2 = appCompatImageView;
                        arrowConstraintPositionY = this.getArrowConstraintPositionY(anchor);
                        appCompatImageView2.setY(arrowConstraintPositionY);
                        return;
                    }
                    return;
                }
                AppCompatImageView appCompatImageView3 = appCompatImageView;
                arrowConstraintPositionX = this.getArrowConstraintPositionX(anchor);
                appCompatImageView3.setX(arrowConstraintPositionX);
            }
        });
    }

    private final void initializeBackground() {
        CardView cardView = this.binding.balloonCard;
        cardView.setAlpha(this.builder.alpha);
        cardView.setCardElevation(this.builder.elevation);
        Builder builder = this.builder;
        Drawable drawable = builder.backgroundDrawable;
        if (drawable == null) {
            cardView.setCardBackgroundColor(builder.backgroundColor);
            cardView.setRadius(this.builder.cornerRadius);
        } else {
            cardView.setBackground(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeBalloonContent() {
        Builder builder = this.builder;
        int i = (builder.arrowSize * 2) - 2;
        int i2 = (int) builder.elevation;
        RelativeLayout relativeLayout = this.binding.balloonContent;
        int i3 = WhenMappings.$EnumSwitchMapping$4[builder.arrowOrientation.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        relativeLayout.setPadding(i2, 0, i2, i);
                    }
                } else {
                    relativeLayout.setPadding(0, i2, i, i2);
                }
            } else {
                relativeLayout.setPadding(i2, i, i2, 0);
            }
        } else {
            relativeLayout.setPadding(i, i2, 0, i2);
        }
        AppCompatTextView appCompatTextView = this.binding.balloonText;
        Builder builder2 = this.builder;
        appCompatTextView.setPadding(builder2.paddingLeft, builder2.paddingTop, builder2.paddingRight, builder2.paddingBottom);
    }

    private final void initializeBalloonListeners() {
        setOnBalloonClickListener(this.builder.onBalloonClickListener);
        setOnBalloonDismissListener(this.builder.onBalloonDismissListener);
        setOnBalloonOutsideTouchListener(this.builder.onBalloonOutsideTouchListener);
        setOnBalloonTouchListener(this.builder.onBalloonTouchListener);
        setOnBalloonOverlayClickListener(this.builder.onBalloonOverlayClickListener);
    }

    private final void initializeBalloonOverlay() {
        if (this.builder.isVisibleOverlay) {
            this.overlayWindow.setClippingEnabled(false);
            this.overlayBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.skydoves.balloon.Balloon$initializeBalloonOverlay$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Balloon.this.dismiss();
                }
            });
            BalloonAnchorOverlayView balloonAnchorOverlayView = this.overlayBinding.balloonOverlayView;
            balloonAnchorOverlayView.setOverlayColor(this.builder.overlayColor);
            balloonAnchorOverlayView.setOverlayPadding(this.builder.overlayPadding);
            balloonAnchorOverlayView.setOverlayPosition(this.builder.overlayPosition);
            balloonAnchorOverlayView.setBalloonOverlayShape(this.builder.overlayShape);
        }
    }

    private final void initializeBalloonRoot() {
        ViewGroup.LayoutParams layoutParams = this.binding.balloonWrapper.getLayoutParams();
        if (layoutParams != null) {
            Builder builder = this.builder;
            ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(builder.marginLeft, builder.marginTop, builder.marginRight, builder.marginBottom);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    @TargetApi(21)
    private final void initializeBalloonWindow() {
        PopupWindow popupWindow = this.bodyWindow;
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(this.builder.isFocusable);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setElevation(this.builder.elevation);
    }

    private final void initializeCustomLayoutWithResource() {
        this.binding.balloonCard.removeAllViews();
        LayoutInflater.from(this.context).inflate(this.builder.layoutRes, (ViewGroup) this.binding.balloonCard, true);
    }

    private final void initializeCustomLayoutWithView() {
        this.binding.balloonCard.removeAllViews();
        this.binding.balloonCard.addView(this.builder.layout);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, com.skydoves.balloon.vectortext.VectorTextView] */
    private final void initializeIcon() {
        ?? r0 = this.binding.balloonText;
        IconForm iconForm = this.builder.iconForm;
        if (iconForm != null) {
            TextViewExtensionKt.applyIconForm(r0, iconForm);
            return;
        }
        Context context = r0.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        IconForm.Builder builder = new IconForm.Builder(context);
        builder.setDrawable(this.builder.iconDrawable);
        builder.setIconSize(this.builder.iconSize);
        builder.setIconColor(this.builder.iconColor);
        builder.setIconSpace(this.builder.iconSpace);
        builder.setDrawableGravity(this.builder.iconGravity);
        Unit unit = Unit.INSTANCE;
        TextViewExtensionKt.applyIconForm(r0, builder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializeText() {
        AppCompatTextView appCompatTextView = this.binding.balloonText;
        TextForm textForm = this.builder.textForm;
        if (textForm != null) {
            TextViewExtensionKt.applyTextForm(appCompatTextView, textForm);
        } else {
            Context context = appCompatTextView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            TextForm.Builder builder = new TextForm.Builder(context);
            builder.setText(this.builder.text);
            builder.setTextSize(this.builder.textSize);
            builder.setTextColor(this.builder.textColor);
            builder.setTextIsHtml(this.builder.textIsHtml);
            builder.setTextGravity(this.builder.textGravity);
            builder.setTextTypeface(this.builder.textTypeface);
            builder.setTextTypeface(this.builder.textTypefaceObject);
            appCompatTextView.setMovementMethod(this.builder.movementMethod);
            Unit unit = Unit.INSTANCE;
            TextViewExtensionKt.applyTextForm(appCompatTextView, builder.build());
        }
        Intrinsics.checkNotNullExpressionValue(appCompatTextView, "this");
        measureTextWidth(appCompatTextView);
    }

    private final Balloon relay(final Balloon balloon, final Function1<? super Balloon, Unit> block) {
        setOnBalloonDismissListener(new Function0<Unit>() { // from class: com.skydoves.balloon.Balloon$relay$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m١٠٧invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m١٠٧invoke() {
                if (Balloon.this.destroyed) {
                    return;
                }
                block.invoke(balloon);
            }
        });
        return balloon;
    }

    public static /* synthetic */ Balloon relayShow$default(Balloon balloon, Balloon balloon2, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return balloon.relayShow(balloon2, view, i, i2);
    }

    public static /* synthetic */ Balloon relayShowAlignBottom$default(Balloon balloon, Balloon balloon2, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return balloon.relayShowAlignBottom(balloon2, view, i, i2);
    }

    public static /* synthetic */ Balloon relayShowAlignLeft$default(Balloon balloon, Balloon balloon2, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return balloon.relayShowAlignLeft(balloon2, view, i, i2);
    }

    public static /* synthetic */ Balloon relayShowAlignRight$default(Balloon balloon, Balloon balloon2, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return balloon.relayShowAlignRight(balloon2, view, i, i2);
    }

    public static /* synthetic */ Balloon relayShowAlignTop$default(Balloon balloon, Balloon balloon2, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return balloon.relayShowAlignTop(balloon2, view, i, i2);
    }

    private final void show(final View anchor, final Function0<Unit> block) {
        if (getIsShowing() || this.destroyed || ContextExtensionKt.isFinishing(this.context) || !d1.U(anchor)) {
            if (this.builder.dismissWhenShowAgain) {
                dismiss();
                return;
            }
            return;
        }
        this.isShowing = true;
        String str = this.builder.preferenceName;
        if (str != null) {
            if (!getBalloonPersistence().shouldShowUP(str, this.builder.showTimes)) {
                return;
            } else {
                getBalloonPersistence().putIncrementedTimes(str);
            }
        }
        long j = this.builder.autoDismissDuration;
        if (j != -1) {
            dismissWithDelay(j);
        }
        anchor.post(new Runnable() { // from class: com.skydoves.balloon.Balloon$show$2
            @Override // java.lang.Runnable
            public final void run() {
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding;
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding2;
                Balloon.this.initializeText();
                layoutBalloonLibrarySkydovesBinding = Balloon.this.binding;
                layoutBalloonLibrarySkydovesBinding.getRoot().measure(0, 0);
                Balloon.this.bodyWindow.setWidth(Balloon.this.getMeasuredWidth());
                Balloon.this.bodyWindow.setHeight(Balloon.this.getMeasuredHeight());
                layoutBalloonLibrarySkydovesBinding2 = Balloon.this.binding;
                AppCompatTextView appCompatTextView = layoutBalloonLibrarySkydovesBinding2.balloonText;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "this.binding.balloonText");
                appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                Balloon.this.initializeArrow(anchor);
                Balloon.this.initializeBalloonContent();
                Balloon.this.applyBalloonOverlayAnimation();
                Balloon.this.showOverlayWindow(anchor);
                Balloon.this.applyBalloonAnimation();
                block.invoke();
            }
        });
    }

    public static /* synthetic */ void showAlignBottom$default(Balloon balloon, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        balloon.showAlignBottom(view, i, i2);
    }

    public static /* synthetic */ void showAlignLeft$default(Balloon balloon, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        balloon.showAlignLeft(view, i, i2);
    }

    public static /* synthetic */ void showAlignRight$default(Balloon balloon, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        balloon.showAlignRight(view, i, i2);
    }

    public static /* synthetic */ void showAlignTop$default(Balloon balloon, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        balloon.showAlignTop(view, i, i2);
    }

    public static /* synthetic */ void showAsDropDown$default(Balloon balloon, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        balloon.showAsDropDown(view, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showOverlayWindow(View anchor) {
        if (this.builder.isVisibleOverlay) {
            this.overlayBinding.balloonOverlayView.setAnchorView(anchor);
            this.overlayWindow.showAtLocation(anchor, 17, 0, 0);
        }
    }

    public static /* synthetic */ void update$default(Balloon balloon, View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        balloon.update(view, i, i2);
    }

    public final void dismiss() {
        if (this.isShowing) {
            final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.skydoves.balloon.Balloon$dismiss$dismissWindow$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                public /* bridge */ /* synthetic */ Object invoke() {
                    m١٠٦invoke();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m١٠٦invoke() {
                    PopupWindow popupWindow;
                    Balloon.this.isShowing = false;
                    popupWindow = Balloon.this.overlayWindow;
                    popupWindow.dismiss();
                    Balloon.this.bodyWindow.dismiss();
                }
            };
            if (this.builder.balloonAnimation == BalloonAnimation.CIRCULAR) {
                final View contentView = this.bodyWindow.getContentView();
                Intrinsics.checkNotNullExpressionValue(contentView, "this.bodyWindow.contentView");
                final long j = this.builder.circularDuration;
                contentView.post(new Runnable() { // from class: com.skydoves.balloon.Balloon$dismiss$$inlined$circularUnRevealed$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (contentView.isAttachedToWindow()) {
                            View view = contentView;
                            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, (view.getLeft() + contentView.getRight()) / 2, (contentView.getTop() + contentView.getBottom()) / 2, Math.max(contentView.getWidth(), contentView.getHeight()), 0.0f);
                            createCircularReveal.setDuration(j);
                            createCircularReveal.start();
                            createCircularReveal.addListener(new AnimatorListenerAdapter() { // from class: com.skydoves.balloon.Balloon$dismiss$$inlined$circularUnRevealed$1.1
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(@Nullable Animator animation) {
                                    super.onAnimationEnd(animation);
                                    function0.invoke();
                                }
                            });
                        }
                    }
                });
                return;
            }
            function0.invoke();
        }
    }

    public final void dismissWithDelay(long delay) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.skydoves.balloon.Balloon$dismissWithDelay$1
            @Override // java.lang.Runnable
            public final void run() {
                Balloon.this.dismiss();
            }
        }, delay);
    }

    @NotNull
    public final View getContentView() {
        CardView cardView = this.binding.balloonCard;
        Intrinsics.checkNotNullExpressionValue(cardView, "binding.balloonCard");
        return cardView;
    }

    public final int getMeasuredHeight() {
        int i = this.builder.height;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "this.binding.root");
        return root.getMeasuredHeight();
    }

    public final int getMeasuredWidth() {
        int i = ContextExtensionKt.displaySize(this.context).x;
        Builder builder = this.builder;
        float f = builder.widthRatio;
        if (f != 0.0f) {
            return (int) (i * f);
        }
        int i2 = builder.width;
        if (i2 != Integer.MIN_VALUE && i2 < i) {
            return i2;
        }
        FrameLayout root = this.binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        if (root.getMeasuredWidth() <= i) {
            FrameLayout root2 = this.binding.getRoot();
            Intrinsics.checkNotNullExpressionValue(root2, "this.binding.root");
            return root2.getMeasuredWidth();
        }
        return i;
    }

    @Nullable
    public final OnBalloonInitializedListener getOnBalloonInitializedListener() {
        return this.onBalloonInitializedListener;
    }

    /* renamed from: isShowing, reason: from getter */
    public final boolean getIsShowing() {
        return this.isShowing;
    }

    public final void measureTextWidth(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(ContextExtensionKt.displaySize(context).y, 0));
        textView.getLayoutParams().width = getMeasuredTextWidth(textView.getMeasuredWidth());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        this.destroyed = true;
        this.overlayWindow.dismiss();
        this.bodyWindow.dismiss();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        if (this.builder.dismissWhenLifecycleOnPause) {
            onDestroy();
        }
    }

    @JvmOverloads
    @NotNull
    public final Balloon relayShow(@NotNull Balloon balloon, @NotNull View view) {
        return relayShow$default(this, balloon, view, 0, 0, 12, null);
    }

    @JvmOverloads
    @NotNull
    public final Balloon relayShowAlignBottom(@NotNull Balloon balloon, @NotNull View view) {
        return relayShowAlignBottom$default(this, balloon, view, 0, 0, 12, null);
    }

    @JvmOverloads
    @NotNull
    public final Balloon relayShowAlignLeft(@NotNull Balloon balloon, @NotNull View view) {
        return relayShowAlignLeft$default(this, balloon, view, 0, 0, 12, null);
    }

    @JvmOverloads
    @NotNull
    public final Balloon relayShowAlignRight(@NotNull Balloon balloon, @NotNull View view) {
        return relayShowAlignRight$default(this, balloon, view, 0, 0, 12, null);
    }

    @JvmOverloads
    @NotNull
    public final Balloon relayShowAlignTop(@NotNull Balloon balloon, @NotNull View view) {
        return relayShowAlignTop$default(this, balloon, view, 0, 0, 12, null);
    }

    @NotNull
    public final Balloon relayShowAsDropDown(@NotNull final Balloon balloon, @NotNull final View anchor) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setOnBalloonDismissListener(new Function0<Unit>() { // from class: com.skydoves.balloon.Balloon$relayShowAsDropDown$$inlined$relay$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m١٠٣invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m١٠٣invoke() {
                if (Balloon.this.destroyed) {
                    return;
                }
                Balloon.showAsDropDown$default(balloon, anchor, 0, 0, 6, null);
            }
        });
        return balloon;
    }

    public final void setOnBalloonClickListener(@Nullable final OnBalloonClickListener onBalloonClickListener) {
        this.binding.balloonWrapper.setOnClickListener(new View.OnClickListener() { // from class: com.skydoves.balloon.Balloon$setOnBalloonClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnBalloonClickListener onBalloonClickListener2 = onBalloonClickListener;
                if (onBalloonClickListener2 != null) {
                    Intrinsics.checkNotNullExpressionValue(view, "it");
                    onBalloonClickListener2.onBalloonClick(view);
                }
                if (Balloon.this.builder.dismissWhenClicked) {
                    Balloon.this.dismiss();
                }
            }
        });
    }

    public final void setOnBalloonDismissListener(@Nullable final OnBalloonDismissListener onBalloonDismissListener) {
        this.bodyWindow.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.skydoves.balloon.Balloon$setOnBalloonDismissListener$1
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                Balloon.this.dismiss();
                OnBalloonDismissListener onBalloonDismissListener2 = onBalloonDismissListener;
                if (onBalloonDismissListener2 != null) {
                    onBalloonDismissListener2.onBalloonDismiss();
                }
            }
        });
    }

    public final void setOnBalloonInitializedListener(@Nullable OnBalloonInitializedListener onBalloonInitializedListener) {
        this.onBalloonInitializedListener = onBalloonInitializedListener;
    }

    public final void setOnBalloonOutsideTouchListener(@Nullable final OnBalloonOutsideTouchListener onBalloonOutsideTouchListener) {
        this.bodyWindow.setTouchInterceptor(new View.OnTouchListener() { // from class: com.skydoves.balloon.Balloon$setOnBalloonOutsideTouchListener$1
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(@NotNull View view, @NotNull MotionEvent event) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(event, "event");
                if (event.getAction() == 4) {
                    if (Balloon.this.builder.dismissWhenTouchOutside) {
                        Balloon.this.dismiss();
                    }
                    OnBalloonOutsideTouchListener onBalloonOutsideTouchListener2 = onBalloonOutsideTouchListener;
                    if (onBalloonOutsideTouchListener2 != null) {
                        onBalloonOutsideTouchListener2.onBalloonOutsideTouch(view, event);
                        return true;
                    }
                    return true;
                }
                return false;
            }
        });
    }

    public final void setOnBalloonOverlayClickListener(@Nullable final OnBalloonOverlayClickListener onBalloonOverlayClickListener) {
        this.overlayBinding.getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.skydoves.balloon.Balloon$setOnBalloonOverlayClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OnBalloonOverlayClickListener onBalloonOverlayClickListener2 = onBalloonOverlayClickListener;
                if (onBalloonOverlayClickListener2 != null) {
                    onBalloonOverlayClickListener2.onBalloonOverlayClick();
                }
                if (Balloon.this.builder.dismissWhenOverlayClicked) {
                    Balloon.this.dismiss();
                }
            }
        });
    }

    public final void setOnBalloonTouchListener(@Nullable View.OnTouchListener onTouchListener) {
        if (onTouchListener != null) {
            this.bodyWindow.setTouchInterceptor(onTouchListener);
        }
    }

    @JvmOverloads
    public final void showAlignBottom(@NotNull View view) {
        showAlignBottom$default(this, view, 0, 0, 6, null);
    }

    @JvmOverloads
    public final void showAlignLeft(@NotNull View view) {
        showAlignLeft$default(this, view, 0, 0, 6, null);
    }

    @JvmOverloads
    public final void showAlignRight(@NotNull View view) {
        showAlignRight$default(this, view, 0, 0, 6, null);
    }

    @JvmOverloads
    public final void showAlignTop(@NotNull View view) {
        showAlignTop$default(this, view, 0, 0, 6, null);
    }

    @JvmOverloads
    public final void showAsDropDown(@NotNull View view) {
        showAsDropDown$default(this, view, 0, 0, 6, null);
    }

    @JvmOverloads
    public final void update(@NotNull View view) {
        update$default(this, view, 0, 0, 6, null);
    }

    @JvmOverloads
    @NotNull
    public final Balloon relayShow(@NotNull Balloon balloon, @NotNull View view, int i) {
        return relayShow$default(this, balloon, view, i, 0, 8, null);
    }

    @JvmOverloads
    @NotNull
    public final Balloon relayShowAlignBottom(@NotNull Balloon balloon, @NotNull View view, int i) {
        return relayShowAlignBottom$default(this, balloon, view, i, 0, 8, null);
    }

    @JvmOverloads
    @NotNull
    public final Balloon relayShowAlignLeft(@NotNull Balloon balloon, @NotNull View view, int i) {
        return relayShowAlignLeft$default(this, balloon, view, i, 0, 8, null);
    }

    @JvmOverloads
    @NotNull
    public final Balloon relayShowAlignRight(@NotNull Balloon balloon, @NotNull View view, int i) {
        return relayShowAlignRight$default(this, balloon, view, i, 0, 8, null);
    }

    @JvmOverloads
    @NotNull
    public final Balloon relayShowAlignTop(@NotNull Balloon balloon, @NotNull View view, int i) {
        return relayShowAlignTop$default(this, balloon, view, i, 0, 8, null);
    }

    @NotNull
    public final Balloon relayShowAsDropDown(@NotNull final Balloon balloon, @NotNull final View anchor, final int xOff, final int yOff) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setOnBalloonDismissListener(new Function0<Unit>() { // from class: com.skydoves.balloon.Balloon$relayShowAsDropDown$$inlined$relay$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m١٠٤invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m١٠٤invoke() {
                if (Balloon.this.destroyed) {
                    return;
                }
                balloon.showAsDropDown(anchor, xOff, yOff);
            }
        });
        return balloon;
    }

    public final /* synthetic */ void setOnBalloonClickListener(Function1<? super View, Unit> block) {
        Intrinsics.checkNotNullParameter(block, MessageMenuDialog.BLOCK);
        setOnBalloonClickListener(new BalloonKt$sam$com_skydoves_balloon_OnBalloonClickListener$0(block));
    }

    public final /* synthetic */ void setOnBalloonDismissListener(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, MessageMenuDialog.BLOCK);
        setOnBalloonDismissListener(new BalloonKt$sam$com_skydoves_balloon_OnBalloonDismissListener$0(block));
    }

    public final /* synthetic */ void setOnBalloonOverlayClickListener(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, MessageMenuDialog.BLOCK);
        setOnBalloonOverlayClickListener(new BalloonKt$sam$com_skydoves_balloon_OnBalloonOverlayClickListener$0(block));
    }

    @JvmOverloads
    public final void showAlignBottom(@NotNull View view, int i) {
        showAlignBottom$default(this, view, i, 0, 4, null);
    }

    @JvmOverloads
    public final void showAlignLeft(@NotNull View view, int i) {
        showAlignLeft$default(this, view, i, 0, 4, null);
    }

    @JvmOverloads
    public final void showAlignRight(@NotNull View view, int i) {
        showAlignRight$default(this, view, i, 0, 4, null);
    }

    @JvmOverloads
    public final void showAlignTop(@NotNull View view, int i) {
        showAlignTop$default(this, view, i, 0, 4, null);
    }

    @JvmOverloads
    public final void showAsDropDown(@NotNull View view, int i) {
        showAsDropDown$default(this, view, i, 0, 4, null);
    }

    @JvmOverloads
    public final void update(@NotNull View view, int i) {
        update$default(this, view, i, 0, 4, null);
    }

    private final void update(View anchor, Function0<Unit> block) {
        if (getIsShowing()) {
            initializeArrow(anchor);
            block.invoke();
        }
    }

    @JvmOverloads
    @NotNull
    public final Balloon relayShow(@NotNull final Balloon balloon, @NotNull final View anchor, final int xOff, final int yOff) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setOnBalloonDismissListener(new Function0<Unit>() { // from class: com.skydoves.balloon.Balloon$relayShow$$inlined$relay$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m٩٨invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m٩٨invoke() {
                if (Balloon.this.destroyed) {
                    return;
                }
                balloon.show(anchor, xOff, yOff);
            }
        });
        return balloon;
    }

    @JvmOverloads
    @NotNull
    public final Balloon relayShowAlignBottom(@NotNull final Balloon balloon, @NotNull final View anchor, final int xOff, final int yOff) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setOnBalloonDismissListener(new Function0<Unit>() { // from class: com.skydoves.balloon.Balloon$relayShowAlignBottom$$inlined$relay$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m٩٩invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m٩٩invoke() {
                if (Balloon.this.destroyed) {
                    return;
                }
                balloon.showAlignBottom(anchor, xOff, yOff);
            }
        });
        return balloon;
    }

    @JvmOverloads
    @NotNull
    public final Balloon relayShowAlignLeft(@NotNull final Balloon balloon, @NotNull final View anchor, final int xOff, final int yOff) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setOnBalloonDismissListener(new Function0<Unit>() { // from class: com.skydoves.balloon.Balloon$relayShowAlignLeft$$inlined$relay$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m١٠٠invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m١٠٠invoke() {
                if (Balloon.this.destroyed) {
                    return;
                }
                balloon.showAlignLeft(anchor, xOff, yOff);
            }
        });
        return balloon;
    }

    @JvmOverloads
    @NotNull
    public final Balloon relayShowAlignRight(@NotNull final Balloon balloon, @NotNull final View anchor, final int xOff, final int yOff) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setOnBalloonDismissListener(new Function0<Unit>() { // from class: com.skydoves.balloon.Balloon$relayShowAlignRight$$inlined$relay$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m١٠١invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m١٠١invoke() {
                if (Balloon.this.destroyed) {
                    return;
                }
                balloon.showAlignRight(anchor, xOff, yOff);
            }
        });
        return balloon;
    }

    @JvmOverloads
    @NotNull
    public final Balloon relayShowAlignTop(@NotNull final Balloon balloon, @NotNull final View anchor, final int xOff, final int yOff) {
        Intrinsics.checkNotNullParameter(balloon, "balloon");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        setOnBalloonDismissListener(new Function0<Unit>() { // from class: com.skydoves.balloon.Balloon$relayShowAlignTop$$inlined$relay$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m١٠٢invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m١٠٢invoke() {
                if (Balloon.this.destroyed) {
                    return;
                }
                balloon.showAlignTop(anchor, xOff, yOff);
            }
        });
        return balloon;
    }

    @JvmOverloads
    public final void showAlignBottom(@NotNull final View anchor, final int xOff, final int yOff) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (getIsShowing() || this.destroyed || ContextExtensionKt.isFinishing(this.context) || !d1.U(anchor)) {
            if (this.builder.dismissWhenShowAgain) {
                dismiss();
                return;
            }
            return;
        }
        this.isShowing = true;
        String str = this.builder.preferenceName;
        if (str != null) {
            if (!getBalloonPersistence().shouldShowUP(str, this.builder.showTimes)) {
                return;
            } else {
                getBalloonPersistence().putIncrementedTimes(str);
            }
        }
        long j = this.builder.autoDismissDuration;
        if (j != -1) {
            dismissWithDelay(j);
        }
        anchor.post(new Runnable() { // from class: com.skydoves.balloon.Balloon$showAlignBottom$$inlined$show$1
            @Override // java.lang.Runnable
            public final void run() {
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding;
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding2;
                Balloon.this.initializeText();
                layoutBalloonLibrarySkydovesBinding = Balloon.this.binding;
                layoutBalloonLibrarySkydovesBinding.getRoot().measure(0, 0);
                Balloon.this.bodyWindow.setWidth(Balloon.this.getMeasuredWidth());
                Balloon.this.bodyWindow.setHeight(Balloon.this.getMeasuredHeight());
                layoutBalloonLibrarySkydovesBinding2 = Balloon.this.binding;
                AppCompatTextView appCompatTextView = layoutBalloonLibrarySkydovesBinding2.balloonText;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "this.binding.balloonText");
                appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                Balloon.this.initializeArrow(anchor);
                Balloon.this.initializeBalloonContent();
                Balloon.this.applyBalloonOverlayAnimation();
                Balloon.this.showOverlayWindow(anchor);
                Balloon.this.applyBalloonAnimation();
                this.bodyWindow.showAsDropDown(anchor, this.builder.supportRtlLayoutFactor * (((anchor.getMeasuredWidth() / 2) - (this.getMeasuredWidth() / 2)) + xOff), yOff);
            }
        });
    }

    @JvmOverloads
    public final void showAlignLeft(@NotNull final View anchor, final int xOff, final int yOff) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (getIsShowing() || this.destroyed || ContextExtensionKt.isFinishing(this.context) || !d1.U(anchor)) {
            if (this.builder.dismissWhenShowAgain) {
                dismiss();
                return;
            }
            return;
        }
        this.isShowing = true;
        String str = this.builder.preferenceName;
        if (str != null) {
            if (!getBalloonPersistence().shouldShowUP(str, this.builder.showTimes)) {
                return;
            } else {
                getBalloonPersistence().putIncrementedTimes(str);
            }
        }
        long j = this.builder.autoDismissDuration;
        if (j != -1) {
            dismissWithDelay(j);
        }
        anchor.post(new Runnable() { // from class: com.skydoves.balloon.Balloon$showAlignLeft$$inlined$show$1
            @Override // java.lang.Runnable
            public final void run() {
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding;
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding2;
                Balloon.this.initializeText();
                layoutBalloonLibrarySkydovesBinding = Balloon.this.binding;
                layoutBalloonLibrarySkydovesBinding.getRoot().measure(0, 0);
                Balloon.this.bodyWindow.setWidth(Balloon.this.getMeasuredWidth());
                Balloon.this.bodyWindow.setHeight(Balloon.this.getMeasuredHeight());
                layoutBalloonLibrarySkydovesBinding2 = Balloon.this.binding;
                AppCompatTextView appCompatTextView = layoutBalloonLibrarySkydovesBinding2.balloonText;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "this.binding.balloonText");
                appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                Balloon.this.initializeArrow(anchor);
                Balloon.this.initializeBalloonContent();
                Balloon.this.applyBalloonOverlayAnimation();
                Balloon.this.showOverlayWindow(anchor);
                Balloon.this.applyBalloonAnimation();
                this.bodyWindow.showAsDropDown(anchor, (-this.getMeasuredWidth()) + xOff, ((-(this.getMeasuredHeight() / 2)) - (anchor.getMeasuredHeight() / 2)) + yOff);
            }
        });
    }

    @JvmOverloads
    public final void showAlignRight(@NotNull final View anchor, final int xOff, final int yOff) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (getIsShowing() || this.destroyed || ContextExtensionKt.isFinishing(this.context) || !d1.U(anchor)) {
            if (this.builder.dismissWhenShowAgain) {
                dismiss();
                return;
            }
            return;
        }
        this.isShowing = true;
        String str = this.builder.preferenceName;
        if (str != null) {
            if (!getBalloonPersistence().shouldShowUP(str, this.builder.showTimes)) {
                return;
            } else {
                getBalloonPersistence().putIncrementedTimes(str);
            }
        }
        long j = this.builder.autoDismissDuration;
        if (j != -1) {
            dismissWithDelay(j);
        }
        anchor.post(new Runnable() { // from class: com.skydoves.balloon.Balloon$showAlignRight$$inlined$show$1
            @Override // java.lang.Runnable
            public final void run() {
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding;
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding2;
                Balloon.this.initializeText();
                layoutBalloonLibrarySkydovesBinding = Balloon.this.binding;
                layoutBalloonLibrarySkydovesBinding.getRoot().measure(0, 0);
                Balloon.this.bodyWindow.setWidth(Balloon.this.getMeasuredWidth());
                Balloon.this.bodyWindow.setHeight(Balloon.this.getMeasuredHeight());
                layoutBalloonLibrarySkydovesBinding2 = Balloon.this.binding;
                AppCompatTextView appCompatTextView = layoutBalloonLibrarySkydovesBinding2.balloonText;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "this.binding.balloonText");
                appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                Balloon.this.initializeArrow(anchor);
                Balloon.this.initializeBalloonContent();
                Balloon.this.applyBalloonOverlayAnimation();
                Balloon.this.showOverlayWindow(anchor);
                Balloon.this.applyBalloonAnimation();
                PopupWindow popupWindow = this.bodyWindow;
                View view = anchor;
                popupWindow.showAsDropDown(view, view.getMeasuredWidth() + xOff, ((-(this.getMeasuredHeight() / 2)) - (anchor.getMeasuredHeight() / 2)) + yOff);
            }
        });
    }

    @JvmOverloads
    public final void showAlignTop(@NotNull final View anchor, final int xOff, final int yOff) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (getIsShowing() || this.destroyed || ContextExtensionKt.isFinishing(this.context) || !d1.U(anchor)) {
            if (this.builder.dismissWhenShowAgain) {
                dismiss();
                return;
            }
            return;
        }
        this.isShowing = true;
        String str = this.builder.preferenceName;
        if (str != null) {
            if (!getBalloonPersistence().shouldShowUP(str, this.builder.showTimes)) {
                return;
            } else {
                getBalloonPersistence().putIncrementedTimes(str);
            }
        }
        long j = this.builder.autoDismissDuration;
        if (j != -1) {
            dismissWithDelay(j);
        }
        anchor.post(new Runnable() { // from class: com.skydoves.balloon.Balloon$showAlignTop$$inlined$show$1
            @Override // java.lang.Runnable
            public final void run() {
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding;
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding2;
                Balloon.this.initializeText();
                layoutBalloonLibrarySkydovesBinding = Balloon.this.binding;
                layoutBalloonLibrarySkydovesBinding.getRoot().measure(0, 0);
                Balloon.this.bodyWindow.setWidth(Balloon.this.getMeasuredWidth());
                Balloon.this.bodyWindow.setHeight(Balloon.this.getMeasuredHeight());
                layoutBalloonLibrarySkydovesBinding2 = Balloon.this.binding;
                AppCompatTextView appCompatTextView = layoutBalloonLibrarySkydovesBinding2.balloonText;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "this.binding.balloonText");
                appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                Balloon.this.initializeArrow(anchor);
                Balloon.this.initializeBalloonContent();
                Balloon.this.applyBalloonOverlayAnimation();
                Balloon.this.showOverlayWindow(anchor);
                Balloon.this.applyBalloonAnimation();
                this.bodyWindow.showAsDropDown(anchor, this.builder.supportRtlLayoutFactor * (((anchor.getMeasuredWidth() / 2) - (this.getMeasuredWidth() / 2)) + xOff), ((-this.getMeasuredHeight()) - anchor.getMeasuredHeight()) + yOff);
            }
        });
    }

    @JvmOverloads
    public final void showAsDropDown(@NotNull final View anchor, final int xOff, final int yOff) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (getIsShowing() || this.destroyed || ContextExtensionKt.isFinishing(this.context) || !d1.U(anchor)) {
            if (this.builder.dismissWhenShowAgain) {
                dismiss();
                return;
            }
            return;
        }
        this.isShowing = true;
        String str = this.builder.preferenceName;
        if (str != null) {
            if (!getBalloonPersistence().shouldShowUP(str, this.builder.showTimes)) {
                return;
            } else {
                getBalloonPersistence().putIncrementedTimes(str);
            }
        }
        long j = this.builder.autoDismissDuration;
        if (j != -1) {
            dismissWithDelay(j);
        }
        anchor.post(new Runnable() { // from class: com.skydoves.balloon.Balloon$showAsDropDown$$inlined$show$1
            @Override // java.lang.Runnable
            public final void run() {
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding;
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding2;
                Balloon.this.initializeText();
                layoutBalloonLibrarySkydovesBinding = Balloon.this.binding;
                layoutBalloonLibrarySkydovesBinding.getRoot().measure(0, 0);
                Balloon.this.bodyWindow.setWidth(Balloon.this.getMeasuredWidth());
                Balloon.this.bodyWindow.setHeight(Balloon.this.getMeasuredHeight());
                layoutBalloonLibrarySkydovesBinding2 = Balloon.this.binding;
                AppCompatTextView appCompatTextView = layoutBalloonLibrarySkydovesBinding2.balloonText;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "this.binding.balloonText");
                appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                Balloon.this.initializeArrow(anchor);
                Balloon.this.initializeBalloonContent();
                Balloon.this.applyBalloonOverlayAnimation();
                Balloon.this.showOverlayWindow(anchor);
                Balloon.this.applyBalloonAnimation();
                this.bodyWindow.showAsDropDown(anchor, xOff, yOff);
            }
        });
    }

    public final /* synthetic */ void setOnBalloonOutsideTouchListener(Function2<? super View, ? super MotionEvent, Unit> block) {
        Intrinsics.checkNotNullParameter(block, MessageMenuDialog.BLOCK);
        setOnBalloonOutsideTouchListener(new BalloonKt$sam$com_skydoves_balloon_OnBalloonOutsideTouchListener$0(block));
    }

    @JvmOverloads
    public final void update(@NotNull View anchor, int xOff, int yOff) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (getIsShowing()) {
            initializeArrow(anchor);
            this.bodyWindow.update(anchor, xOff, yOff, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void show(@NotNull final View anchor) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (getIsShowing() || this.destroyed || ContextExtensionKt.isFinishing(this.context) || !d1.U(anchor)) {
            if (this.builder.dismissWhenShowAgain) {
                dismiss();
                return;
            }
            return;
        }
        this.isShowing = true;
        String str = this.builder.preferenceName;
        if (str != null) {
            if (!getBalloonPersistence().shouldShowUP(str, this.builder.showTimes)) {
                return;
            } else {
                getBalloonPersistence().putIncrementedTimes(str);
            }
        }
        long j = this.builder.autoDismissDuration;
        if (j != -1) {
            dismissWithDelay(j);
        }
        anchor.post(new Runnable() { // from class: com.skydoves.balloon.Balloon$show$$inlined$show$1
            @Override // java.lang.Runnable
            public final void run() {
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding;
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding2;
                Balloon.this.initializeText();
                layoutBalloonLibrarySkydovesBinding = Balloon.this.binding;
                layoutBalloonLibrarySkydovesBinding.getRoot().measure(0, 0);
                Balloon.this.bodyWindow.setWidth(Balloon.this.getMeasuredWidth());
                Balloon.this.bodyWindow.setHeight(Balloon.this.getMeasuredHeight());
                layoutBalloonLibrarySkydovesBinding2 = Balloon.this.binding;
                AppCompatTextView appCompatTextView = layoutBalloonLibrarySkydovesBinding2.balloonText;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "this.binding.balloonText");
                appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                Balloon.this.initializeArrow(anchor);
                Balloon.this.initializeBalloonContent();
                Balloon.this.applyBalloonOverlayAnimation();
                Balloon.this.showOverlayWindow(anchor);
                Balloon.this.applyBalloonAnimation();
                this.bodyWindow.showAsDropDown(anchor, this.builder.supportRtlLayoutFactor * ((anchor.getMeasuredWidth() / 2) - (this.getMeasuredWidth() / 2)), (-this.getMeasuredHeight()) - (anchor.getMeasuredHeight() / 2));
            }
        });
    }

    public final void show(@NotNull final View anchor, final int xOff, final int yOff) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        if (getIsShowing() || this.destroyed || ContextExtensionKt.isFinishing(this.context) || !d1.U(anchor)) {
            if (this.builder.dismissWhenShowAgain) {
                dismiss();
                return;
            }
            return;
        }
        this.isShowing = true;
        String str = this.builder.preferenceName;
        if (str != null) {
            if (!getBalloonPersistence().shouldShowUP(str, this.builder.showTimes)) {
                return;
            } else {
                getBalloonPersistence().putIncrementedTimes(str);
            }
        }
        long j = this.builder.autoDismissDuration;
        if (j != -1) {
            dismissWithDelay(j);
        }
        anchor.post(new Runnable() { // from class: com.skydoves.balloon.Balloon$show$$inlined$show$2
            @Override // java.lang.Runnable
            public final void run() {
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding;
                LayoutBalloonLibrarySkydovesBinding layoutBalloonLibrarySkydovesBinding2;
                Balloon.this.initializeText();
                layoutBalloonLibrarySkydovesBinding = Balloon.this.binding;
                layoutBalloonLibrarySkydovesBinding.getRoot().measure(0, 0);
                Balloon.this.bodyWindow.setWidth(Balloon.this.getMeasuredWidth());
                Balloon.this.bodyWindow.setHeight(Balloon.this.getMeasuredHeight());
                layoutBalloonLibrarySkydovesBinding2 = Balloon.this.binding;
                AppCompatTextView appCompatTextView = layoutBalloonLibrarySkydovesBinding2.balloonText;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "this.binding.balloonText");
                appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                Balloon.this.initializeArrow(anchor);
                Balloon.this.initializeBalloonContent();
                Balloon.this.applyBalloonOverlayAnimation();
                Balloon.this.showOverlayWindow(anchor);
                Balloon.this.applyBalloonAnimation();
                this.bodyWindow.showAsDropDown(anchor, xOff, yOff);
            }
        });
    }
}
