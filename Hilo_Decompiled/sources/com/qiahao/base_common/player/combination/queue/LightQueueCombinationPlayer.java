package com.qiahao.base_common.player.combination.queue;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import androidx.core.view.d1;
import androidx.core.view.m1;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.log.ILog;
import com.qiahao.base_common.R;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import com.qiahao.base_common.player.PlayerState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\rJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000e¢\u0006\u0004\b\u0018\u0010\u0017J\u001f\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u001a\u0010\u0014J\u001f\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u001b\u0010\u0014J\u000f\u0010\u001d\u001a\u00020\u001cH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\"R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R?\u0010-\u001a\u001f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010&\u001a\u0004\b5\u00106R\u001b\u0010:\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u0010&\u001a\u0004\b9\u00106R\u001b\u0010=\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b;\u0010&\u001a\u0004\b<\u0010\u001eR\u0018\u0010>\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010@\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010?¨\u0006A"}, d2 = {"Lcom/qiahao/base_common/player/combination/queue/LightQueueCombinationPlayer;", "Lcom/qiahao/base_common/player/combination/queue/SimpleQueueCombinationPlayer;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "", "playWhenReady", "Lcom/qiahao/base_common/player/PlayerState;", "state", "", "handlerAutoDarkBackground", "(ZLcom/qiahao/base_common/player/PlayerState;)V", "isEnabled", "autoDarkBackground", "(Z)V", "autoGone", "playbackState", "onPlayerStateChanged", "handlerAutoGone", "Landroidx/core/view/m1;", "createBackgroundAnimateListener", "()Landroidx/core/view/m1;", "onCleared", "()V", "autoDarkBackgroundEnabled", "Z", "autoGoneEnabled", "Landroid/view/View;", "darkBackgroundView$delegate", "Lkotlin/Lazy;", "getDarkBackgroundView", "()Landroid/view/View;", "darkBackgroundView", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "playerStateListener", "Lkotlin/jvm/functions/Function1;", "getPlayerStateListener", "()Lkotlin/jvm/functions/Function1;", "setPlayerStateListener", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/view/animation/Interpolator;", "backgroundInInterpolator$delegate", "getBackgroundInInterpolator", "()Landroid/view/animation/Interpolator;", "backgroundInInterpolator", "backgroundOutInterpolator$delegate", "getBackgroundOutInterpolator", "backgroundOutInterpolator", "backgroundAnimateListener$delegate", "getBackgroundAnimateListener", "backgroundAnimateListener", "backgroundAnimateIsRunning", "Ljava/lang/Boolean;", "needGoneFlag", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class LightQueueCombinationPlayer extends SimpleQueueCombinationPlayer {
    private boolean autoDarkBackgroundEnabled;
    private boolean autoGoneEnabled;

    @Nullable
    private Boolean backgroundAnimateIsRunning;

    /* renamed from: backgroundAnimateListener$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy backgroundAnimateListener;

    /* renamed from: backgroundInInterpolator$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy backgroundInInterpolator;

    /* renamed from: backgroundOutInterpolator$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy backgroundOutInterpolator;

    /* renamed from: darkBackgroundView$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy darkBackgroundView;

    @Nullable
    private Boolean needGoneFlag;

    @Nullable
    private Function1<? super PlayerState, Unit> playerStateListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightQueueCombinationPlayer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.darkBackgroundView = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                View darkBackgroundView_delegate$lambda$0;
                darkBackgroundView_delegate$lambda$0 = LightQueueCombinationPlayer.darkBackgroundView_delegate$lambda$0(LightQueueCombinationPlayer.this);
                return darkBackgroundView_delegate$lambda$0;
            }
        });
        this.backgroundInInterpolator = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AccelerateInterpolator backgroundInInterpolator_delegate$lambda$1;
                backgroundInInterpolator_delegate$lambda$1 = LightQueueCombinationPlayer.backgroundInInterpolator_delegate$lambda$1();
                return backgroundInInterpolator_delegate$lambda$1;
            }
        });
        this.backgroundOutInterpolator = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DecelerateInterpolator backgroundOutInterpolator_delegate$lambda$2;
                backgroundOutInterpolator_delegate$lambda$2 = LightQueueCombinationPlayer.backgroundOutInterpolator_delegate$lambda$2();
                return backgroundOutInterpolator_delegate$lambda$2;
            }
        });
        this.backgroundAnimateListener = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                m1 createBackgroundAnimateListener;
                createBackgroundAnimateListener = LightQueueCombinationPlayer.this.createBackgroundAnimateListener();
                return createBackgroundAnimateListener;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccelerateInterpolator backgroundInInterpolator_delegate$lambda$1() {
        return new AccelerateInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DecelerateInterpolator backgroundOutInterpolator_delegate$lambda$2() {
        return new DecelerateInterpolator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View darkBackgroundView_delegate$lambda$0(LightQueueCombinationPlayer lightQueueCombinationPlayer) {
        return new View(lightQueueCombinationPlayer.getContext());
    }

    private final m1 getBackgroundAnimateListener() {
        return (m1) this.backgroundAnimateListener.getValue();
    }

    private final Interpolator getBackgroundInInterpolator() {
        return (Interpolator) this.backgroundInInterpolator.getValue();
    }

    private final Interpolator getBackgroundOutInterpolator() {
        return (Interpolator) this.backgroundOutInterpolator.getValue();
    }

    private final View getDarkBackgroundView() {
        return (View) this.darkBackgroundView.getValue();
    }

    private final void handlerAutoDarkBackground(boolean playWhenReady, PlayerState state) {
        if (!this.autoDarkBackgroundEnabled) {
            return;
        }
        PlayerState playerState = PlayerState.READY;
        if (state == playerState && playWhenReady) {
            ILog.DefaultImpls.logD$default(this, "handlerAutoDarkBackground() animateIn", null, false, 6, null);
            d1.e(getDarkBackgroundView()).b(1.0f).g(getBackgroundInInterpolator()).h(null).p().l();
        } else if (state != playerState) {
            ILog.DefaultImpls.logD$default(this, "handlerAutoDarkBackground() animateOut", null, false, 6, null);
            d1.e(getDarkBackgroundView()).b(DownloadProgress.UNKNOWN_PROGRESS).g(getBackgroundOutInterpolator()).h(getBackgroundAnimateListener()).p().l();
        }
    }

    public final void autoDarkBackground(boolean isEnabled) {
        this.autoDarkBackgroundEnabled = isEnabled;
        if (isEnabled) {
            if (indexOfChild(getDarkBackgroundView()) < 0) {
                View darkBackgroundView = getDarkBackgroundView();
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                darkBackgroundView.setBackgroundColor(ResourcesKtxKt.getColorById(context, R.color.base_color_000000_50));
                getDarkBackgroundView().setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
                addView(getDarkBackgroundView(), 0, new FrameLayout.LayoutParams(-1, -1));
                return;
            }
            return;
        }
        removeView(getDarkBackgroundView());
    }

    public final void autoGone(boolean isEnabled) {
        this.autoGoneEnabled = isEnabled;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public m1 createBackgroundAnimateListener() {
        return new m1() { // from class: com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer$createBackgroundAnimateListener$1
            private final void checkGone() {
                Boolean bool;
                bool = LightQueueCombinationPlayer.this.needGoneFlag;
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    ILog.DefaultImpls.logD$default(LightQueueCombinationPlayer.this, "checkGone() GONE", null, false, 6, null);
                    LightQueueCombinationPlayer.this.setVisibility(8);
                    LightQueueCombinationPlayer.this.needGoneFlag = Boolean.FALSE;
                }
            }

            @Override // androidx.core.view.m1
            public void onAnimationCancel(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                LightQueueCombinationPlayer.this.backgroundAnimateIsRunning = Boolean.FALSE;
                checkGone();
            }

            @Override // androidx.core.view.m1
            public void onAnimationEnd(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                LightQueueCombinationPlayer.this.backgroundAnimateIsRunning = Boolean.FALSE;
                checkGone();
            }

            @Override // androidx.core.view.m1
            public void onAnimationStart(View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                LightQueueCombinationPlayer.this.backgroundAnimateIsRunning = Boolean.TRUE;
            }
        };
    }

    @Nullable
    public final Function1<PlayerState, Unit> getPlayerStateListener() {
        return this.playerStateListener;
    }

    protected void handlerAutoGone(boolean playWhenReady, @NotNull PlayerState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!this.autoGoneEnabled) {
            return;
        }
        if (state == PlayerState.BUFFERING) {
            ILog.DefaultImpls.logD$default(this, "handlerAutoGone() VISIBLE", null, false, 6, null);
            this.needGoneFlag = Boolean.FALSE;
            setVisibility(0);
        } else if (isIdleState()) {
            Boolean bool = this.backgroundAnimateIsRunning;
            Boolean bool2 = Boolean.TRUE;
            if (Intrinsics.areEqual(bool, bool2)) {
                ILog.DefaultImpls.logD$default(this, "handlerAutoGone() needGoneFlag", null, false, 6, null);
                this.needGoneFlag = bool2;
            } else {
                ILog.DefaultImpls.logD$default(this, "handlerAutoGone() GONE", null, false, 6, null);
                setVisibility(8);
            }
        }
    }

    @Override // com.qiahao.base_common.player.combination.queue.SimpleQueueCombinationPlayer, com.qiahao.base_common.player.combination.CombinationPlayer, com.qiahao.base_common.player.IPlayer, com.oudi.utils.ICleared
    public void onCleared() {
        super.onCleared();
        getDarkBackgroundView().clearAnimation();
    }

    @Override // com.qiahao.base_common.player.combination.queue.SimpleQueueCombinationPlayer, com.qiahao.base_common.player.combination.CombinationPlayer, com.qiahao.base_common.player.PlayerEventListener
    public void onPlayerStateChanged(boolean playWhenReady, @NotNull PlayerState playbackState) {
        Intrinsics.checkNotNullParameter(playbackState, "playbackState");
        super.onPlayerStateChanged(playWhenReady, playbackState);
        handlerAutoDarkBackground(playWhenReady, playbackState);
        handlerAutoGone(playWhenReady, playbackState);
        Function1<? super PlayerState, Unit> function1 = this.playerStateListener;
        if (function1 != null) {
            function1.invoke(playbackState);
        }
    }

    public final void setPlayerStateListener(@Nullable Function1<? super PlayerState, Unit> function1) {
        this.playerStateListener = function1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightQueueCombinationPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.darkBackgroundView = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                View darkBackgroundView_delegate$lambda$0;
                darkBackgroundView_delegate$lambda$0 = LightQueueCombinationPlayer.darkBackgroundView_delegate$lambda$0(LightQueueCombinationPlayer.this);
                return darkBackgroundView_delegate$lambda$0;
            }
        });
        this.backgroundInInterpolator = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AccelerateInterpolator backgroundInInterpolator_delegate$lambda$1;
                backgroundInInterpolator_delegate$lambda$1 = LightQueueCombinationPlayer.backgroundInInterpolator_delegate$lambda$1();
                return backgroundInInterpolator_delegate$lambda$1;
            }
        });
        this.backgroundOutInterpolator = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DecelerateInterpolator backgroundOutInterpolator_delegate$lambda$2;
                backgroundOutInterpolator_delegate$lambda$2 = LightQueueCombinationPlayer.backgroundOutInterpolator_delegate$lambda$2();
                return backgroundOutInterpolator_delegate$lambda$2;
            }
        });
        this.backgroundAnimateListener = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                m1 createBackgroundAnimateListener;
                createBackgroundAnimateListener = LightQueueCombinationPlayer.this.createBackgroundAnimateListener();
                return createBackgroundAnimateListener;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightQueueCombinationPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        this.darkBackgroundView = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                View darkBackgroundView_delegate$lambda$0;
                darkBackgroundView_delegate$lambda$0 = LightQueueCombinationPlayer.darkBackgroundView_delegate$lambda$0(LightQueueCombinationPlayer.this);
                return darkBackgroundView_delegate$lambda$0;
            }
        });
        this.backgroundInInterpolator = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AccelerateInterpolator backgroundInInterpolator_delegate$lambda$1;
                backgroundInInterpolator_delegate$lambda$1 = LightQueueCombinationPlayer.backgroundInInterpolator_delegate$lambda$1();
                return backgroundInInterpolator_delegate$lambda$1;
            }
        });
        this.backgroundOutInterpolator = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DecelerateInterpolator backgroundOutInterpolator_delegate$lambda$2;
                backgroundOutInterpolator_delegate$lambda$2 = LightQueueCombinationPlayer.backgroundOutInterpolator_delegate$lambda$2();
                return backgroundOutInterpolator_delegate$lambda$2;
            }
        });
        this.backgroundAnimateListener = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                m1 createBackgroundAnimateListener;
                createBackgroundAnimateListener = LightQueueCombinationPlayer.this.createBackgroundAnimateListener();
                return createBackgroundAnimateListener;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LightQueueCombinationPlayer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        this.darkBackgroundView = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                View darkBackgroundView_delegate$lambda$0;
                darkBackgroundView_delegate$lambda$0 = LightQueueCombinationPlayer.darkBackgroundView_delegate$lambda$0(LightQueueCombinationPlayer.this);
                return darkBackgroundView_delegate$lambda$0;
            }
        });
        this.backgroundInInterpolator = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AccelerateInterpolator backgroundInInterpolator_delegate$lambda$1;
                backgroundInInterpolator_delegate$lambda$1 = LightQueueCombinationPlayer.backgroundInInterpolator_delegate$lambda$1();
                return backgroundInInterpolator_delegate$lambda$1;
            }
        });
        this.backgroundOutInterpolator = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DecelerateInterpolator backgroundOutInterpolator_delegate$lambda$2;
                backgroundOutInterpolator_delegate$lambda$2 = LightQueueCombinationPlayer.backgroundOutInterpolator_delegate$lambda$2();
                return backgroundOutInterpolator_delegate$lambda$2;
            }
        });
        this.backgroundAnimateListener = LazyKt.lazy(new Function0() { // from class: com.qiahao.base_common.player.combination.queue.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                m1 createBackgroundAnimateListener;
                createBackgroundAnimateListener = LightQueueCombinationPlayer.this.createBackgroundAnimateListener();
                return createBackgroundAnimateListener;
            }
        });
    }
}
