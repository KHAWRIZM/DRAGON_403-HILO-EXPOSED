package com.qiahao.nextvideo.ui.home.matching.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import cf.m;
import com.opensource.svgaplayer.SVGACallback;
import com.qiahao.base_common.model.common.ChannelEventStartup;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.AgoraVideoCallConfig;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.databinding.ViewWrapperMatchingPendingBinding;
import com.qiahao.nextvideo.ui.paired.DoneType;
import com.qiahao.nextvideo.ui.paired.DuetConnectionCountDownTimer;
import com.qiahao.nextvideo.ui.paired.DuetConnectionCountDownTimerDelegate;
import com.qiahao.nextvideo.ui.paired.MatchingActionPendingUIModel;
import com.qiahao.nextvideo.ui.paired.SoloConnectionCountDownTimer;
import com.qiahao.nextvideo.ui.paired.SoloConnectionCountDownTimerDelegate;
import com.qiahao.nextvideo.ui.paired.Style;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.ui.videocall.VideoCallPreloadModel;
import com.qiahao.nextvideo.utilities.DebugToolsKt;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import io.reactivex.rxjava3.core.z;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 X2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001XB\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0012J\u0019\u0010\u0018\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001e\u0010\u0012J\u000f\u0010\u001f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u001f\u0010\u0012J\u0017\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b$\u0010#R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010'R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010+\u001a\u0004\b,\u0010-R\u0017\u0010/\u001a\u00020.8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0017\u00104\u001a\u0002038\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R$\u00109\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010@\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010AR\u0016\u0010D\u001a\u00020C8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010FR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u001b\u0010O\u001a\u00020J8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010NR\u001b\u0010T\u001a\u00020P8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bQ\u0010L\u001a\u0004\bR\u0010SR\u001a\u0010V\u001a\b\u0012\u0004\u0012\u00020\u000e0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bV\u0010W¨\u0006Y"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/matching/view/MatchingPendingViewWrapper;", "Lcom/qiahao/nextvideo/ui/paired/SoloConnectionCountDownTimerDelegate;", "Lcom/qiahao/nextvideo/ui/paired/DuetConnectionCountDownTimerDelegate;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/content/Context;", "context", "Landroid/view/ViewGroup;", "parent", "Lcom/qiahao/nextvideo/ui/paired/MatchingActionPendingUIModel;", "uiModel", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/qiahao/nextvideo/ui/paired/MatchingActionPendingUIModel;)V", "Lcom/qiahao/nextvideo/data/model/AgoraVideoCallConfig;", "agoraVideoCallConfig", "", "subscribeRemoteVideoFirstFrame", "(Lcom/qiahao/nextvideo/data/model/AgoraVideoCallConfig;Lcom/qiahao/nextvideo/ui/paired/MatchingActionPendingUIModel;)V", "registerEventBus", "()V", "unRegisterEventBus", "refuseInviteButtonPressed", "acceptInviteButtonPressed", "", "refuseReason", "remoteUserRefused", "(Ljava/lang/String;)V", "Lcom/qiahao/base_common/model/eventBus/VideoEvent;", "event", "onVideoEvent", "(Lcom/qiahao/base_common/model/eventBus/VideoEvent;)V", "soloConnectionCountDownTimerDelegateDidTimeout", "duetConnectionCountDownTimerDelegateDidTimeout", "Landroid/view/View;", "v", "onViewAttachedToWindow", "(Landroid/view/View;)V", "onViewDetachedFromWindow", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "Lcom/qiahao/nextvideo/ui/paired/MatchingActionPendingUIModel;", "getUiModel", "()Lcom/qiahao/nextvideo/ui/paired/MatchingActionPendingUIModel;", "Lcom/qiahao/nextvideo/databinding/ViewWrapperMatchingPendingBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/ViewWrapperMatchingPendingBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ViewWrapperMatchingPendingBinding;", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "Lcom/qiahao/nextvideo/ui/home/matching/view/MatchingDelegate;", "delegate", "Lcom/qiahao/nextvideo/ui/home/matching/view/MatchingDelegate;", "getDelegate", "()Lcom/qiahao/nextvideo/ui/home/matching/view/MatchingDelegate;", "setDelegate", "(Lcom/qiahao/nextvideo/ui/home/matching/view/MatchingDelegate;)V", "", "localConnectStatus", "I", "remoteConnectStatus", "Lnd/c;", "pendingCountDownProgressBarDispose", "Lnd/c;", "Lcom/qiahao/nextvideo/data/model/AgoraVideoCallConfig;", "Lcom/opensource/svgaplayer/SVGACallback;", "crySvgAnimationCallback", "Lcom/opensource/svgaplayer/SVGACallback;", "Lcom/qiahao/nextvideo/ui/paired/DuetConnectionCountDownTimer;", "duetConnectionCountDownTimer$delegate", "Lkotlin/Lazy;", "getDuetConnectionCountDownTimer", "()Lcom/qiahao/nextvideo/ui/paired/DuetConnectionCountDownTimer;", "duetConnectionCountDownTimer", "Lcom/qiahao/nextvideo/ui/paired/SoloConnectionCountDownTimer;", "soloConnectionCountDownTimer$delegate", "getSoloConnectionCountDownTimer", "()Lcom/qiahao/nextvideo/ui/paired/SoloConnectionCountDownTimer;", "soloConnectionCountDownTimer", "Lkotlin/Function0;", "stopAllTipsInCountDown", "Lkotlin/jvm/functions/Function0;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MatchingPendingViewWrapper implements SoloConnectionCountDownTimerDelegate, DuetConnectionCountDownTimerDelegate, View.OnAttachStateChangeListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "MatchingPendingViewWrapper";

    @Nullable
    private AgoraVideoCallConfig agoraVideoCallConfig;

    @NotNull
    private final ViewWrapperMatchingPendingBinding binding;

    @NotNull
    private final nd.a compositeDisposable;

    @NotNull
    private final Context context;

    @Nullable
    private SVGACallback crySvgAnimationCallback;

    @Nullable
    private MatchingDelegate delegate;

    /* renamed from: duetConnectionCountDownTimer$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy duetConnectionCountDownTimer;
    private int localConnectStatus;

    @NotNull
    private final ViewGroup parent;
    private nd.c pendingCountDownProgressBarDispose;
    private int remoteConnectStatus;

    /* renamed from: soloConnectionCountDownTimer$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy soloConnectionCountDownTimer;

    @NotNull
    private final Function0<Unit> stopAllTipsInCountDown;

    @NotNull
    private final MatchingActionPendingUIModel uiModel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/matching/view/MatchingPendingViewWrapper$Companion;", "", "<init>", "()V", "TAG", "", "getTAG$annotations", "getTAG", "()Ljava/lang/String;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getTAG$annotations() {
        }

        @NotNull
        public final String getTAG() {
            return MatchingPendingViewWrapper.TAG;
        }

        private Companion() {
        }
    }

    public MatchingPendingViewWrapper(@NotNull Context context, @NotNull ViewGroup viewGroup, @NotNull MatchingActionPendingUIModel matchingActionPendingUIModel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Intrinsics.checkNotNullParameter(matchingActionPendingUIModel, "uiModel");
        this.context = context;
        this.parent = viewGroup;
        this.uiModel = matchingActionPendingUIModel;
        ViewWrapperMatchingPendingBinding inflate = ViewWrapperMatchingPendingBinding.inflate(LayoutInflater.from(context), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        this.compositeDisposable = new nd.a();
        this.crySvgAnimationCallback = new SVGACallback() { // from class: com.qiahao.nextvideo.ui.home.matching.view.MatchingPendingViewWrapper$crySvgAnimationCallback$1
            public void onFinished() {
                MatchingPendingViewWrapper.this.getUiModel().setDoneType(DoneType.REMOTE_USER_REJECTED);
                MatchingDelegate delegate = MatchingPendingViewWrapper.this.getDelegate();
                if (delegate != null) {
                    delegate.matchingNext(MatchingPendingViewWrapper.this.getUiModel(), MatchingPendingViewWrapper.this.stopAllTipsInCountDown);
                }
            }

            public void onPause() {
            }

            public void onRepeat() {
            }

            public void onStep(int frame, double percentage) {
            }
        };
        this.duetConnectionCountDownTimer = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.matching.view.a
            public final Object invoke() {
                DuetConnectionCountDownTimer duetConnectionCountDownTimer_delegate$lambda$1;
                duetConnectionCountDownTimer_delegate$lambda$1 = MatchingPendingViewWrapper.duetConnectionCountDownTimer_delegate$lambda$1(MatchingPendingViewWrapper.this);
                return duetConnectionCountDownTimer_delegate$lambda$1;
            }
        });
        this.soloConnectionCountDownTimer = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.matching.view.b
            public final Object invoke() {
                SoloConnectionCountDownTimer soloConnectionCountDownTimer_delegate$lambda$3;
                soloConnectionCountDownTimer_delegate$lambda$3 = MatchingPendingViewWrapper.soloConnectionCountDownTimer_delegate$lambda$3(MatchingPendingViewWrapper.this);
                return soloConnectionCountDownTimer_delegate$lambda$3;
            }
        });
        this.stopAllTipsInCountDown = new Function0() { // from class: com.qiahao.nextvideo.ui.home.matching.view.c
            public final Object invoke() {
                Unit stopAllTipsInCountDown$lambda$4;
                stopAllTipsInCountDown$lambda$4 = MatchingPendingViewWrapper.stopAllTipsInCountDown$lambda$4(MatchingPendingViewWrapper.this);
                return stopAllTipsInCountDown$lambda$4;
            }
        };
        registerEventBus();
        inflate.getRoot().addOnAttachStateChangeListener(this);
        inflate.getRoot().setVisibility(0);
        AppUtilitiesKt.vibrator(context, 300L);
        this.pendingCountDownProgressBarDispose = z.interval(matchingActionPendingUIModel.getWaitDuration(), TimeUnit.MILLISECONDS).take(matchingActionPendingUIModel.getWaitDuration() * 100).observeOn(md.b.c()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.matching.view.MatchingPendingViewWrapper.1
            public final void accept(Long l) {
                Intrinsics.checkNotNullParameter(l, "it");
                MatchingPendingViewWrapper.this.getBinding().connectStatusProgressBar.setProgress((((float) l.longValue()) + 1.0f) / ((float) MatchingPendingViewWrapper.this.getUiModel().getWaitDuration()));
                if (MatchingPendingViewWrapper.this.getBinding().connectStatusProgressBar.getProgress() == 100.0f) {
                    MatchingPendingViewWrapper.this.getUiModel().setDoneType(DoneType.PENDING_COUNTDOWN_DONE);
                    AgoraRtcService.leaveChannel$default(AgoraRtcService.INSTANCE, null, 1, null);
                    MatchingDelegate delegate = MatchingPendingViewWrapper.this.getDelegate();
                    if (delegate != null) {
                        delegate.matchingNext(MatchingPendingViewWrapper.this.getUiModel(), MatchingPendingViewWrapper.this.stopAllTipsInCountDown);
                    }
                }
            }
        });
        inflate.acceptInviteButton.startConnectionAnimation();
        GenderAgeTextView genderAgeTextView = inflate.ageTextView;
        Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
        Resources resources = inflate.getRoot().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, matchingActionPendingUIModel.getToUserSexIconDrawableResID(), 0));
        inflate.ageTextView.setBackgroundResource(matchingActionPendingUIModel.getToUserSexBackgroundResID());
        AppCompatImageView appCompatImageView = inflate.countryFlagImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "countryFlagImageView");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        ViewUtilitiesKt.bind$default(appCompatImageView, companion.countryTag(matchingActionPendingUIModel.getToUser().getCountryIcon()), null, 2, null);
        CircleImageView circleImageView = inflate.circleImageView;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "circleImageView");
        ImageUIModel full = companion.full(matchingActionPendingUIModel.getToUser().getAvatar());
        full.setPlaceholder(Integer.valueOf(matchingActionPendingUIModel.getToUserDefaultAvtarResID()));
        ViewUtilitiesKt.bind$default(circleImageView, full, null, 2, null);
        inflate.ageTextView.setText(matchingActionPendingUIModel.getToUser().getAge());
        inflate.nicknameTextView.setText(matchingActionPendingUIModel.getToUser().getNick());
        inflate.countryProvinceTextView.setText(matchingActionPendingUIModel.getToUser().getCountry());
        if (matchingActionPendingUIModel.getToUser().isVip()) {
            inflate.iconVip.setVisibility(0);
        } else {
            inflate.iconVip.setVisibility(8);
        }
        inflate.acceptInviteButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.view.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MatchingPendingViewWrapper.this.acceptInviteButtonPressed();
            }
        });
        inflate.refuseInviteButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.view.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MatchingPendingViewWrapper.this.refuseInviteButtonPressed();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void acceptInviteButtonPressed() {
        this.localConnectStatus = 1;
        this.binding.acceptInviteButton.disableAnimation();
        getSoloConnectionCountDownTimer().start();
        nd.c cVar = this.pendingCountDownProgressBarDispose;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pendingCountDownProgressBarDispose");
            cVar = null;
        }
        cVar.dispose();
        this.binding.connectStatusProgressBar.setStyle(Style.CONNECTING);
        this.binding.refuseInviteButton.setEnabled(false);
        this.binding.refuseInviteButton.setText(this.context.getString(2131954470));
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(MatchingProvide.INSTANCE.accept(this.uiModel.getMatchUniqueID(), this.uiModel.getToUser().getExternalId(), this.uiModel.getConditionRegion(), this.uiModel.getConditionGender()), new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.view.f
            public final Object invoke(Object obj) {
                Unit acceptInviteButtonPressed$lambda$10;
                acceptInviteButtonPressed$lambda$10 = MatchingPendingViewWrapper.acceptInviteButtonPressed$lambda$10(MatchingPendingViewWrapper.this, (ApiResponse) obj);
                return acceptInviteButtonPressed$lambda$10;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.matching.view.g
            public final Object invoke(Object obj) {
                Unit acceptInviteButtonPressed$lambda$11;
                acceptInviteButtonPressed$lambda$11 = MatchingPendingViewWrapper.acceptInviteButtonPressed$lambda$11(MatchingPendingViewWrapper.this, (Throwable) obj);
                return acceptInviteButtonPressed$lambda$11;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit acceptInviteButtonPressed$lambda$10(MatchingPendingViewWrapper matchingPendingViewWrapper, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        DebugToolsKt.printf(AgoraRtcService.TAG, "匹配点击接受视频成功accept onSuccess " + apiResponse);
        MatchingDelegate matchingDelegate = matchingPendingViewWrapper.delegate;
        if (matchingDelegate != null) {
            matchingDelegate.matchingAccept(matchingPendingViewWrapper.uiModel);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit acceptInviteButtonPressed$lambda$11(MatchingPendingViewWrapper matchingPendingViewWrapper, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        DebugToolsKt.printfE(AgoraRtcService.TAG, "接受点击视频失败accept onError " + th);
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = matchingPendingViewWrapper.context;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = matchingPendingViewWrapper.context.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(localizedMessage, "getString(...)");
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        AgoraRtcService.leaveChannel$default(AgoraRtcService.INSTANCE, null, 1, null);
        MatchingDelegate matchingDelegate = matchingPendingViewWrapper.delegate;
        if (matchingDelegate != null) {
            matchingDelegate.matchingNext(matchingPendingViewWrapper.uiModel, matchingPendingViewWrapper.stopAllTipsInCountDown);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DuetConnectionCountDownTimer duetConnectionCountDownTimer_delegate$lambda$1(MatchingPendingViewWrapper matchingPendingViewWrapper) {
        DuetConnectionCountDownTimer duetConnectionCountDownTimer = new DuetConnectionCountDownTimer(matchingPendingViewWrapper.uiModel.getDualWaitTimeInSec());
        duetConnectionCountDownTimer.setDelegate(matchingPendingViewWrapper);
        return duetConnectionCountDownTimer;
    }

    private final DuetConnectionCountDownTimer getDuetConnectionCountDownTimer() {
        return (DuetConnectionCountDownTimer) this.duetConnectionCountDownTimer.getValue();
    }

    private final SoloConnectionCountDownTimer getSoloConnectionCountDownTimer() {
        return (SoloConnectionCountDownTimer) this.soloConnectionCountDownTimer.getValue();
    }

    @NotNull
    public static final String getTAG() {
        return INSTANCE.getTAG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refuseInviteButtonPressed() {
        this.binding.connectFailedSvgImageView.setCallback((SVGACallback) null);
        this.binding.connectFailedSvgImageView.stopAnimation();
        AgoraRtcService.leaveChannel$default(AgoraRtcService.INSTANCE, null, 1, null);
        MatchingDelegate matchingDelegate = this.delegate;
        if (matchingDelegate != null) {
            matchingDelegate.matchingNext(this.uiModel, this.stopAllTipsInCountDown);
        }
    }

    private final void registerEventBus() {
        if (!cf.c.c().j(this)) {
            cf.c.c().p(this);
        }
    }

    private final void remoteUserRefused(String refuseReason) {
        this.compositeDisposable.dispose();
        this.compositeDisposable.d();
        this.binding.refuseInviteButton.setText(refuseReason);
        this.binding.acceptInviteButton.disableAnimation();
        this.binding.connectStatusProgressBar.closeAlphaAnimation();
        this.binding.refuseInviteButton.setClickable(false);
        this.binding.connectFailedSvgImageView.setCallback(this.crySvgAnimationCallback);
        this.binding.connectFailedSvgImageView.startAnimation();
        this.stopAllTipsInCountDown.invoke();
        AgoraRtcService.leaveChannel$default(AgoraRtcService.INSTANCE, null, 1, null);
    }

    static /* synthetic */ void remoteUserRefused$default(MatchingPendingViewWrapper matchingPendingViewWrapper, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = matchingPendingViewWrapper.context.getString(2131954258);
        }
        matchingPendingViewWrapper.remoteUserRefused(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SoloConnectionCountDownTimer soloConnectionCountDownTimer_delegate$lambda$3(MatchingPendingViewWrapper matchingPendingViewWrapper) {
        SoloConnectionCountDownTimer soloConnectionCountDownTimer = new SoloConnectionCountDownTimer(matchingPendingViewWrapper.uiModel.getSingleWaitTimeInSec());
        soloConnectionCountDownTimer.setDelegate(matchingPendingViewWrapper);
        return soloConnectionCountDownTimer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit stopAllTipsInCountDown$lambda$4(MatchingPendingViewWrapper matchingPendingViewWrapper) {
        nd.c cVar = matchingPendingViewWrapper.pendingCountDownProgressBarDispose;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pendingCountDownProgressBarDispose");
            cVar = null;
        }
        cVar.dispose();
        matchingPendingViewWrapper.getDuetConnectionCountDownTimer().cancel();
        matchingPendingViewWrapper.getSoloConnectionCountDownTimer().cancel();
        return Unit.INSTANCE;
    }

    private final void subscribeRemoteVideoFirstFrame(AgoraVideoCallConfig agoraVideoCallConfig, final MatchingActionPendingUIModel uiModel) {
        final Function2 function2 = new Function2() { // from class: com.qiahao.nextvideo.ui.home.matching.view.h
            public final Object invoke(Object obj, Object obj2) {
                Unit subscribeRemoteVideoFirstFrame$lambda$9;
                subscribeRemoteVideoFirstFrame$lambda$9 = MatchingPendingViewWrapper.subscribeRemoteVideoFirstFrame$lambda$9(MatchingPendingViewWrapper.this, uiModel, (String) obj, (Throwable) obj2);
                return subscribeRemoteVideoFirstFrame$lambda$9;
            }
        };
        AgoraRtcService agoraRtcService = AgoraRtcService.INSTANCE;
        nd.c subscribe = agoraRtcService.getRemoteVideoStatusRelay().observeOn(RxUtilsKt.getMainThread()).subscribe(new MatchingPendingViewWrapper$subscribeRemoteVideoFirstFrame$1(uiModel, this, function2), new pd.g() { // from class: com.qiahao.nextvideo.ui.home.matching.view.MatchingPendingViewWrapper$subscribeRemoteVideoFirstFrame$2
            public final void accept(Throwable th) {
                Intrinsics.checkNotNullParameter(th, "throwable");
                function2.invoke("匹配后等待频道中的通话准备 wait call-ready in channel", th);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.compositeDisposable);
        AgoraRtcService.joinChannel$default(agoraRtcService, agoraVideoCallConfig.getToken(), agoraVideoCallConfig.getChannelID(), null, agoraVideoCallConfig.getLocalAgoraId(), 4, null);
        MatchingDelegate matchingDelegate = this.delegate;
        if (matchingDelegate != null) {
            matchingDelegate.matchingFloatView(uiModel);
        }
        Log.d("匹配对话框页面Wrap", "正常两方连接中--进入声网");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit subscribeRemoteVideoFirstFrame$lambda$9(MatchingPendingViewWrapper matchingPendingViewWrapper, MatchingActionPendingUIModel matchingActionPendingUIModel, String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "reason");
        Intrinsics.checkNotNullParameter(th, "throwable");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = matchingPendingViewWrapper.context;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = matchingPendingViewWrapper.context.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(localizedMessage, "getString(...)");
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        DebugToolsKt.printf(TAG, str);
        Log.d("MatchingPendingViewW..", "subscribeRemoteVideoFirstFrame: 匹配后获取声网第一帧失败报错");
        AgoraRtcService.leaveChannel$default(AgoraRtcService.INSTANCE, null, 1, null);
        MatchingDelegate matchingDelegate = matchingPendingViewWrapper.delegate;
        if (matchingDelegate != null) {
            matchingDelegate.matchingNext(matchingActionPendingUIModel, matchingPendingViewWrapper.stopAllTipsInCountDown);
        }
        return Unit.INSTANCE;
    }

    private final void unRegisterEventBus() {
        if (cf.c.c().j(this)) {
            cf.c.c().r(this);
        }
    }

    @Override // com.qiahao.nextvideo.ui.paired.DuetConnectionCountDownTimerDelegate
    public void duetConnectionCountDownTimerDelegateDidTimeout() {
        String string = this.context.getString(2131954258);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        remoteUserRefused(string);
    }

    @NotNull
    public final ViewWrapperMatchingPendingBinding getBinding() {
        return this.binding;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final MatchingDelegate getDelegate() {
        return this.delegate;
    }

    @NotNull
    public final ViewGroup getParent() {
        return this.parent;
    }

    @NotNull
    public final MatchingActionPendingUIModel getUiModel() {
        return this.uiModel;
    }

    @m(threadMode = ThreadMode.MAIN)
    public final void onVideoEvent(@NotNull VideoEvent event) {
        MatchingDelegate matchingDelegate;
        MatchingDelegate matchingDelegate2;
        MatchingDelegate matchingDelegate3;
        UserProxy.MatchConfirm matchConfirm;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(event, "event");
        String type = event.getType();
        switch (type.hashCode()) {
            case 614862977:
                if (type.equals("VIDEO_RESULT")) {
                    try {
                        if (event.getData() instanceof UserProxy.Video) {
                            Object data = event.getData();
                            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type userProxy.UserProxy.Video");
                            if (((UserProxy.Video) data).getStatus() == 1 && (matchingDelegate = this.delegate) != null) {
                                matchingDelegate.matchingNext(this.uiModel, this.stopAllTipsInCountDown);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        DebugToolsKt.printfE(TAG, "eventRelay 内部try()catch{}" + e.getLocalizedMessage());
                        return;
                    }
                }
                return;
            case 1679599019:
                if (type.equals("remote_first_frame_match")) {
                    Log.d("匹配对话框页面Wrap", "正常两方连接中--接收到声网的第一帧视频");
                    Object data2 = event.getData();
                    Intrinsics.checkNotNull(data2, "null cannot be cast to non-null type com.qiahao.base_common.model.common.ChannelEventStartup");
                    ChannelEventStartup channelEventStartup = (ChannelEventStartup) data2;
                    long diffTimeInSecs = channelEventStartup.getDiffTimeInSecs();
                    AgoraVideoCallConfig agoraVideoCallConfig = this.agoraVideoCallConfig;
                    if (agoraVideoCallConfig != null && (matchingDelegate2 = this.delegate) != null) {
                        matchingDelegate2.matchingStartup(VideoCallPreloadModel.INSTANCE.init(agoraVideoCallConfig, this.uiModel.getFromUser(), this.uiModel.getToUser(), this.uiModel.getMatchUniqueID(), channelEventStartup, Long.valueOf(diffTimeInSecs)));
                        return;
                    }
                    return;
                }
                return;
            case 1872033254:
                if (type.equals("SPECIFY_VIDEO_CALL_DIALED_PENDING") && (matchingDelegate3 = this.delegate) != null) {
                    matchingDelegate3.matchingNext(this.uiModel, this.stopAllTipsInCountDown);
                    return;
                }
                return;
            case 2099749879:
                if (type.equals("MATCH_RESULT")) {
                    try {
                        Object data3 = event.getData();
                        if (data3 instanceof UserProxy.MatchConfirm) {
                            matchConfirm = (UserProxy.MatchConfirm) data3;
                        } else {
                            matchConfirm = null;
                        }
                        if (matchConfirm == null || !Intrinsics.areEqual(matchConfirm.getMatchUniqueId(), this.uiModel.getMatchUniqueID())) {
                            return;
                        }
                        this.remoteConnectStatus = matchConfirm.getStatus();
                        getSoloConnectionCountDownTimer().cancel();
                        int i = this.remoteConnectStatus;
                        if (i != 1) {
                            if (i != 2) {
                                if (i == 3) {
                                    UserStore.Companion companion = UserStore.INSTANCE;
                                    UserStore.refreshUserInfo$default(companion.getShared(), companion.getShared().getUser(), null, null, false, 14, null);
                                    remoteUserRefused$default(this, null, 1, null);
                                    AgoraRtcService.leaveChannel$default(AgoraRtcService.INSTANCE, null, 1, null);
                                    return;
                                }
                                return;
                            }
                            if (matchConfirm.getFailType() == 1) {
                                if (this.localConnectStatus == 1) {
                                    remoteUserRefused$default(this, null, 1, null);
                                }
                            } else {
                                remoteUserRefused$default(this, null, 1, null);
                            }
                            AgoraRtcService.leaveChannel$default(AgoraRtcService.INSTANCE, null, 1, null);
                            return;
                        }
                        AgoraRtcService.leaveChannel$default(AgoraRtcService.INSTANCE, null, 1, null);
                        Log.d("匹配对话框页面Wrap", "正常两方连接中---------------------------");
                        getDuetConnectionCountDownTimer().start();
                        this.binding.refuseInviteButton.setText(this.context.getString(2131952366));
                        AgoraVideoCallConfig.Companion companion2 = AgoraVideoCallConfig.INSTANCE;
                        Boolean isLike = this.uiModel.getToUser().isLike();
                        if (isLike != null) {
                            z = isLike.booleanValue();
                        } else {
                            z = false;
                        }
                        Boolean isLikeMe = this.uiModel.getToUser().isLikeMe();
                        if (isLikeMe != null) {
                            z2 = isLikeMe.booleanValue();
                        } else {
                            z2 = false;
                        }
                        AgoraVideoCallConfig init = companion2.init(matchConfirm, z, z2);
                        this.agoraVideoCallConfig = init;
                        Intrinsics.checkNotNull(init);
                        subscribeRemoteVideoFirstFrame(init, this.uiModel);
                        return;
                    } catch (Exception e2) {
                        HiloToasty.Companion companion3 = HiloToasty.Companion;
                        Context context = this.context;
                        String string = context.getString(2131954249);
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        Toast normal$default = HiloToasty.Companion.normal$default(companion3, context, string, false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                        }
                        DebugToolsKt.printfE(TAG, "duetChatRoomMessageRelay内部try()catch{}" + e2.getLocalizedMessage());
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        DebugToolsKt.printf("taohui onViewAttachedToWindow");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        DebugToolsKt.printf("taohui onViewDetachedFromWindow");
        this.binding.getRoot().removeOnAttachStateChangeListener(this);
        this.compositeDisposable.dispose();
        this.compositeDisposable.d();
        nd.c cVar = null;
        this.crySvgAnimationCallback = null;
        this.binding.connectFailedSvgImageView.setCallback((SVGACallback) null);
        this.binding.connectFailedSvgImageView.clear();
        this.binding.connectFailedSvgImageView.stopAnimation(true);
        nd.c cVar2 = this.pendingCountDownProgressBarDispose;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pendingCountDownProgressBarDispose");
        } else {
            cVar = cVar2;
        }
        cVar.dispose();
        getSoloConnectionCountDownTimer().cancel();
        this.stopAllTipsInCountDown.invoke();
        unRegisterEventBus();
    }

    public final void setDelegate(@Nullable MatchingDelegate matchingDelegate) {
        this.delegate = matchingDelegate;
    }

    @Override // com.qiahao.nextvideo.ui.paired.SoloConnectionCountDownTimerDelegate
    public void soloConnectionCountDownTimerDelegateDidTimeout() {
        String string = this.context.getString(2131954258);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        remoteUserRefused(string);
    }
}
