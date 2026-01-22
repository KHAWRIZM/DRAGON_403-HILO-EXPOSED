package com.qiahao.nextvideo.ui.reusable.views;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.model.MatchingFloatData;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.data.service.agora.AgoraRtcService;
import com.qiahao.nextvideo.data.service.match.MatchingProvide;
import com.qiahao.nextvideo.databinding.FloatingViewBinding;
import com.qiahao.nextvideo.room.manager.RoomEvent;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.skydoves.balloon.Balloon;
import com.skydoves.balloon.BalloonAnimation;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.android.agoo.common.AgooConstants;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 R2\u00020\u0001:\u0002SRB-\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0010\u0010\rJ\u000f\u0010\u0011\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\rJ\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\rJ\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0017¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0018\u0010\rJ\u0017\u0010\u001b\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b \u0010\u001cJ\r\u0010!\u001a\u00020\u000b¢\u0006\u0004\b!\u0010\rJ\r\u0010\"\u001a\u00020\u000b¢\u0006\u0004\b\"\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010#R\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010%R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010%R\u0016\u0010.\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010%R\u0016\u0010/\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010%R\u0016\u00100\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010%R\u0016\u00101\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010%R\u0016\u00102\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010%R\u0014\u00103\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u0010%R\u0014\u00104\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u0010%R\u0014\u00105\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u0010%R\u0014\u00106\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010%R\u0018\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020\u00078\u0002X\u0082D¢\u0006\u0006\n\u0004\b<\u0010%R\u0016\u0010=\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010;R\"\u0010>\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010;\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0014\u0010C\u001a\u00020B8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010F\u001a\u00020E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u001b\u0010M\u001a\u00020H8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR\u001a\u0010N\u001a\u00020\u00158BX\u0082\u0004¢\u0006\f\u0012\u0004\bO\u0010\r\u001a\u0004\bN\u0010?R\u001a\u0010P\u001a\u00020\u00158BX\u0082\u0004¢\u0006\f\u0012\u0004\bQ\u0010\r\u001a\u0004\bP\u0010?¨\u0006T"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/MatchingFloatView;", "Landroid/widget/RelativeLayout;", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "mContext", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Ljava/lang/ref/WeakReference;Landroid/util/AttributeSet;I)V", "", "dismissPress", "()V", "welt", "updateWindowManager", "clickCloseButton", "registerEventBus", "unregisterEventBus", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "onDetachedFromWindow", "Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;", AgooConstants.OPEN_ACTIIVTY_NAME, "showTip", "(Lcom/qiahao/nextvideo/app/base/HiloBaseActivity;)V", "Lcom/qiahao/nextvideo/room/manager/RoomEvent;", "onRoomEvent", "(Lcom/qiahao/nextvideo/room/manager/RoomEvent;)V", "show", "hide", VerificationCodeFragment.TYPE_BIND, "Ljava/lang/ref/WeakReference;", "floatBallParamsX", "I", "floatBallParamsY", "Landroid/view/WindowManager$LayoutParams;", "floatBallParams", "Landroid/view/WindowManager$LayoutParams;", "Landroid/view/WindowManager;", "windowManager", "Landroid/view/WindowManager;", "inputStartX", "inputStartY", "viewStartX", "viewStartY", "inMovingX", "inMovingY", "screenHeight", "screenWidth", "dp160", "dp48", "Landroid/animation/ValueAnimator;", "valueAnimator", "Landroid/animation/ValueAnimator;", "moveVertical", "Z", "slop", "isDrag", "isShow", "()Z", "setShow", "(Z)V", "Lnd/a;", "compositeDisposable", "Lnd/a;", "Lcom/qiahao/nextvideo/databinding/FloatingViewBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/FloatingViewBinding;", "Lcom/skydoves/balloon/Balloon;", "matchingFloatViewTipBalloon$delegate", "Lkotlin/Lazy;", "getMatchingFloatViewTipBalloon", "()Lcom/skydoves/balloon/Balloon;", "matchingFloatViewTipBalloon", "isLeftSide", "isLeftSide$annotations", "isRightSide", "isRightSide$annotations", "Companion", "Mode", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nMatchingFloatView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MatchingFloatView.kt\ncom/qiahao/nextvideo/ui/reusable/views/MatchingFloatView\n+ 2 Balloon.kt\ncom/skydoves/balloon/BalloonKt\n*L\n1#1,419:1\n94#2:420\n*S KotlinDebug\n*F\n+ 1 MatchingFloatView.kt\ncom/qiahao/nextvideo/ui/reusable/views/MatchingFloatView\n*L\n120#1:420\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MatchingFloatView extends RelativeLayout {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "FloatingView";

    @NotNull
    private static final String keyOfFirstShowTipsInDay = "keyOfFirstShowTipsInDay";

    @NotNull
    private final FloatingViewBinding binding;

    @NotNull
    private final nd.a compositeDisposable;
    private final int dp160;
    private final int dp48;

    @NotNull
    private WindowManager.LayoutParams floatBallParams;
    private int floatBallParamsX;
    private int floatBallParamsY;
    private int inMovingX;
    private int inMovingY;
    private int inputStartX;
    private int inputStartY;
    private boolean isDrag;
    private boolean isShow;

    @NotNull
    private final WeakReference<Activity> mContext;

    /* renamed from: matchingFloatViewTipBalloon$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy matchingFloatViewTipBalloon;
    private boolean moveVertical;
    private final int screenHeight;
    private final int screenWidth;
    private final int slop;

    @Nullable
    private ValueAnimator valueAnimator;
    private int viewStartX;
    private int viewStartY;

    @NotNull
    private WindowManager windowManager;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0002X\u0083D¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0003R\u001c\u0010\u0007\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0003\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/MatchingFloatView$Companion;", "", "<init>", "()V", "TAG", "", "getTAG$annotations", "keyOfFirstShowTipsInDay", "getKeyOfFirstShowTipsInDay$annotations", "getKeyOfFirstShowTipsInDay", "()Ljava/lang/String;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getKeyOfFirstShowTipsInDay$annotations() {
        }

        @JvmStatic
        private static /* synthetic */ void getTAG$annotations() {
        }

        @NotNull
        public final String getKeyOfFirstShowTipsInDay() {
            return MatchingFloatView.keyOfFirstShowTipsInDay;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/MatchingFloatView$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "CONNECTING", "WAITING", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Mode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Mode[] $VALUES;
        public static final Mode NORMAL = new Mode("NORMAL", 0);
        public static final Mode CONNECTING = new Mode("CONNECTING", 1);
        public static final Mode WAITING = new Mode("WAITING", 2);

        private static final /* synthetic */ Mode[] $values() {
            return new Mode[]{NORMAL, CONNECTING, WAITING};
        }

        static {
            Mode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Mode(String str, int i) {
        }

        @NotNull
        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }

        public static Mode valueOf(String str) {
            return (Mode) Enum.valueOf(Mode.class, str);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Mode.values().length];
            try {
                iArr[Mode.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Mode.WAITING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Mode.CONNECTING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MatchingFloatView(@NotNull WeakReference<Activity> weakReference) {
        this(weakReference, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(weakReference, "mContext");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(View view) {
        cf.c.c().l(new VideoEvent("CLICK_MATCHING_FLOAT", new Object()));
    }

    private final void clickCloseButton() {
        UserService.INSTANCE.getShared().clientReport(2);
        AgoraRtcService.leaveChannel$default(AgoraRtcService.INSTANCE, null, 1, null);
        hide();
        cf.c.c().l(new VideoEvent("DEFAULT", new Object()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void dismissPress() {
        MatchingProvide matchingProvide = MatchingProvide.INSTANCE;
        MatchingFloatData matchingFloatData = matchingProvide.getMatchingFloatData();
        if (matchingFloatData != null && matchingFloatData.getMode() == Mode.CONNECTING) {
            matchingProvide.cancelConnection(matchingFloatData.getMatchUniqueId());
        }
        clickCloseButton();
        cf.c.c().l(new VideoEvent("DEFAULT", new Object()));
    }

    @NotNull
    public static final String getKeyOfFirstShowTipsInDay() {
        return INSTANCE.getKeyOfFirstShowTipsInDay();
    }

    private final Balloon getMatchingFloatViewTipBalloon() {
        return (Balloon) this.matchingFloatViewTipBalloon.getValue();
    }

    private final boolean isLeftSide() {
        if (getX() == 0.0f) {
            return true;
        }
        return false;
    }

    private static /* synthetic */ void isLeftSide$annotations() {
    }

    private final boolean isRightSide() {
        if (getX() == this.screenWidth - getWidth()) {
            return true;
        }
        return false;
    }

    private static /* synthetic */ void isRightSide$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Balloon matchingFloatViewTipBalloon_delegate$lambda$1(MatchingFloatView matchingFloatView) {
        Context context = matchingFloatView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Balloon.Builder builder = new Balloon.Builder(context);
        builder.balloonAnimation = BalloonAnimation.CIRCULAR;
        builder.backgroundColor = Color.parseColor("#a155ff");
        builder.arrowSize = 0;
        Dimens dimens = Dimens.INSTANCE;
        builder.paddingTop = dimens.getMarginMedium();
        builder.paddingBottom = dimens.getMarginMedium();
        builder.textGravity = 1;
        builder.setText(ResourcesKtxKt.getStringById(builder, 2131953399));
        builder.setTextSize(12.0f);
        builder.setTextColor(-1);
        builder.setWidthRatio(1.0f);
        builder.setCornerRadius(0.0f);
        builder.setDismissWhenTouchOutside(false);
        builder.setAutoDismissDuration(2000L);
        return builder.build();
    }

    private final void registerEventBus() {
        if (!cf.c.c().j(this)) {
            cf.c.c().p(this);
        }
    }

    public static /* synthetic */ void show$default(MatchingFloatView matchingFloatView, HiloBaseActivity hiloBaseActivity, int i, Object obj) {
        if ((i & 1) != 0) {
            hiloBaseActivity = null;
        }
        matchingFloatView.show(hiloBaseActivity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit showTip$lambda$6(MatchingFloatView matchingFloatView, HiloBaseActivity hiloBaseActivity, int i, int i2) {
        if (!matchingFloatView.getMatchingFloatViewTipBalloon().getIsShowing()) {
            Balloon matchingFloatViewTipBalloon = matchingFloatView.getMatchingFloatViewTipBalloon();
            View decorView = hiloBaseActivity.getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            matchingFloatViewTipBalloon.showAlignTop(decorView, 0, i);
        }
        return Unit.INSTANCE;
    }

    private final void unregisterEventBus() {
        if (cf.c.c().j(this)) {
            cf.c.c().r(this);
        }
    }

    private final void updateWindowManager() {
        if (this.isShow) {
            this.windowManager.updateViewLayout(this, this.floatBallParams);
            WindowManager.LayoutParams layoutParams = this.floatBallParams;
            int i = layoutParams.x;
            this.floatBallParamsX = i;
            this.floatBallParamsY = layoutParams.y;
            MMKVStore mMKVStore = MMKVStore.INSTANCE;
            IStore.DefaultImpls.setValue$default(mMKVStore, "MatchingFloatViewX", Integer.valueOf(i), (String) null, 4, (Object) null);
            IStore.DefaultImpls.setValue$default(mMKVStore, "MatchingFloatViewY", Integer.valueOf(this.floatBallParamsY), (String) null, 4, (Object) null);
        }
    }

    private final void welt() {
        int i;
        int i2;
        int i3;
        WindowManager.LayoutParams layoutParams = this.floatBallParams;
        int i4 = layoutParams.x;
        int i5 = layoutParams.y;
        this.moveVertical = false;
        if (i5 < getHeight() && (i3 = this.floatBallParams.x) >= this.slop && i3 <= (this.screenWidth - getWidth()) - this.slop) {
            i5 = 0;
        } else if (this.floatBallParams.y > this.screenHeight - (getHeight() * 2) && (i = this.floatBallParams.x) >= this.slop && i <= (this.screenWidth - getWidth()) - this.slop) {
            i5 = this.screenHeight - getHeight();
        } else {
            this.moveVertical = true;
            i4 = this.floatBallParams.x < (this.screenWidth / 2) - (getWidth() / 2) ? 0 : this.screenWidth - getWidth();
        }
        if (this.moveVertical) {
            this.valueAnimator = ValueAnimator.ofInt(this.floatBallParams.x, i4);
            i2 = i4 - this.floatBallParams.x;
        } else {
            this.valueAnimator = ValueAnimator.ofInt(this.floatBallParams.y, i5);
            i2 = i5 - this.floatBallParams.y;
        }
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(Math.abs(i2));
        }
        ValueAnimator valueAnimator2 = this.valueAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.i
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                    MatchingFloatView.welt$lambda$5(MatchingFloatView.this, valueAnimator3);
                }
            });
        }
        ValueAnimator valueAnimator3 = this.valueAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.setInterpolator(new AccelerateInterpolator());
        }
        ValueAnimator valueAnimator4 = this.valueAnimator;
        if (valueAnimator4 != null) {
            valueAnimator4.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void welt$lambda$5(MatchingFloatView matchingFloatView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(valueAnimator, "animation");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        if (matchingFloatView.moveVertical) {
            matchingFloatView.floatBallParams.x = intValue;
        } else {
            matchingFloatView.floatBallParams.y = intValue;
        }
        matchingFloatView.updateWindowManager();
    }

    public final void bind() {
        String string;
        MatchingFloatData matchingFloatData = MatchingProvide.INSTANCE.getMatchingFloatData();
        if (matchingFloatData != null) {
            AppCompatTextView appCompatTextView = this.binding.currentStateTextView;
            int i = WhenMappings.$EnumSwitchMapping$0[matchingFloatData.getMode().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        string = this.binding.getRoot().getContext().getString(2131952367);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    string = this.binding.getRoot().getContext().getString(2131954468);
                }
            } else {
                string = this.binding.getRoot().getContext().getString(2131954006);
            }
            appCompatTextView.setText(string);
            this.binding.rotateAnimationView.bind(matchingFloatData.getMode());
            CircleImageView circleImageView = this.binding.avatarCircleImageView;
            Intrinsics.checkNotNullExpressionValue(circleImageView, "avatarCircleImageView");
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            String avatarUrl = matchingFloatData.getAvatarUrl();
            ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
            Dimens dimens = Dimens.INSTANCE;
            fill.setWidth(dimens.getMediumAvatarSize());
            fill.setHeight(dimens.getMediumAvatarSize());
            Unit unit = Unit.INSTANCE;
            ViewUtilitiesKt.bind$default(circleImageView, companion.displayUserAvatarImage(avatarUrl, fill), null, 2, null);
        }
    }

    public final void hide() {
        if (this.isShow) {
            IStore.DefaultImpls.setValue$default(MMKVStore.INSTANCE, "matching_view", Boolean.FALSE, (String) null, 4, (Object) null);
            this.isShow = false;
            this.windowManager.removeViewImmediate(this);
        }
        unregisterEventBus();
        this.compositeDisposable.d();
    }

    /* renamed from: isShow, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            if (valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.valueAnimator;
                Intrinsics.checkNotNull(valueAnimator2);
                valueAnimator2.cancel();
            }
        }
        this.compositeDisposable.d();
        unregisterEventBus();
        super.onDetachedFromWindow();
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onRoomEvent(@NotNull RoomEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getMEventId() == 211) {
            String str = TAG;
            Log.d(str, "initObserve1: " + Thread.currentThread().getName());
            if (this.isShow) {
                Log.d(str, "initObserve1:关闭！！！}");
                dismissPress();
            } else {
                Log.d(str, "initObserve1:本来已经关闭 不需要关闭}");
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    this.inMovingX = (int) event.getRawX();
                    int rawY = (int) event.getRawY();
                    this.inMovingY = rawY;
                    int i = this.viewStartX;
                    int i2 = this.inMovingX;
                    int i3 = this.inputStartX;
                    int i4 = (i + i2) - i3;
                    int i5 = (this.viewStartY + rawY) - this.inputStartY;
                    if (this.screenHeight > 0 && this.screenWidth > 0) {
                        if (Math.abs(i2 - i3) > this.slop && Math.abs(this.inMovingY - this.inputStartY) > this.slop) {
                            this.isDrag = true;
                            WindowManager.LayoutParams layoutParams = this.floatBallParams;
                            layoutParams.x = i4;
                            layoutParams.y = i5;
                            updateWindowManager();
                        } else {
                            this.isDrag = false;
                        }
                    } else {
                        this.isDrag = false;
                        return super.onTouchEvent(event);
                    }
                }
            } else {
                if (this.isDrag) {
                    setPressed(false);
                }
                welt();
            }
        } else {
            ValueAnimator valueAnimator = this.valueAnimator;
            if (valueAnimator != null) {
                Intrinsics.checkNotNull(valueAnimator);
                if (valueAnimator.isRunning()) {
                    ValueAnimator valueAnimator2 = this.valueAnimator;
                    Intrinsics.checkNotNull(valueAnimator2);
                    valueAnimator2.cancel();
                }
            }
            setPressed(true);
            this.isDrag = false;
            this.inputStartX = (int) event.getRawX();
            this.inputStartY = (int) event.getRawY();
            WindowManager.LayoutParams layoutParams2 = this.floatBallParams;
            this.viewStartX = layoutParams2.x;
            this.viewStartY = layoutParams2.y;
        }
        if (this.isDrag || super.onTouchEvent(event)) {
            return true;
        }
        return false;
    }

    public final void setShow(boolean z) {
        this.isShow = z;
    }

    public final void show(@Nullable HiloBaseActivity activity) {
        MMKVStore mMKVStore = MMKVStore.INSTANCE;
        IStore.DefaultImpls.setValue$default(mMKVStore, "matching_view", Boolean.TRUE, (String) null, 4, (Object) null);
        if (this.isShow) {
            bind();
            return;
        }
        this.compositeDisposable.d();
        registerEventBus();
        showTip(activity);
        this.isShow = true;
        this.floatBallParamsX = ((Number) IStore.DefaultImpls.getValue$default(mMKVStore, "MatchingFloatViewX", -1, (String) null, 4, (Object) null)).intValue();
        int intValue = ((Number) IStore.DefaultImpls.getValue$default(mMKVStore, "MatchingFloatViewY", -1, (String) null, 4, (Object) null)).intValue();
        this.floatBallParamsY = intValue;
        int i = this.floatBallParamsX;
        if (i != -1 && intValue != -1) {
            WindowManager.LayoutParams layoutParams = this.floatBallParams;
            layoutParams.x = i;
            layoutParams.y = intValue;
        } else {
            WindowManager.LayoutParams layoutParams2 = this.floatBallParams;
            int i2 = this.dp48;
            layoutParams2.x = i2;
            int i3 = (this.screenHeight - this.dp160) - i2;
            layoutParams2.y = i3;
            this.floatBallParamsX = i2;
            this.floatBallParamsY = i3;
        }
        this.windowManager.addView(this, this.floatBallParams);
        welt();
        bind();
    }

    public final void showTip(@Nullable final HiloBaseActivity activity) {
        if (this.isShow) {
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
            MMKVStore mMKVStore = MMKVStore.INSTANCE;
            String str = keyOfFirstShowTipsInDay;
            String str2 = (String) IStore.DefaultImpls.getValue$default(mMKVStore, str, "", (String) null, 4, (Object) null);
            if (str2 != null && !StringsKt.isBlank(str2)) {
                Intrinsics.checkNotNull(format);
                if (str2.contentEquals(format)) {
                    return;
                }
            }
            IStore.DefaultImpls.getValue$default(mMKVStore, str, format, (String) null, 4, (Object) null);
            if (activity != null) {
                activity.getStatusBarTopOrBottom(this, new Function2() { // from class: com.qiahao.nextvideo.ui.reusable.views.j
                    public final Object invoke(Object obj, Object obj2) {
                        Unit showTip$lambda$6;
                        showTip$lambda$6 = MatchingFloatView.showTip$lambda$6(MatchingFloatView.this, activity, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                        return showTip$lambda$6;
                    }
                });
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MatchingFloatView(@NotNull WeakReference<Activity> weakReference, @Nullable AttributeSet attributeSet) {
        this(weakReference, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(weakReference, "mContext");
    }

    public /* synthetic */ MatchingFloatView(WeakReference weakReference, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(weakReference, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MatchingFloatView(@NotNull WeakReference<Activity> weakReference, @Nullable AttributeSet attributeSet, int i) {
        super(weakReference.get(), attributeSet, i);
        Intrinsics.checkNotNullParameter(weakReference, "mContext");
        this.mContext = weakReference;
        this.floatBallParamsX = -1;
        this.floatBallParamsY = -1;
        this.floatBallParams = new WindowManager.LayoutParams();
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        this.windowManager = (WindowManager) systemService;
        Dimens dimens = Dimens.INSTANCE;
        this.screenHeight = dimens.getScreenHeight();
        this.screenWidth = dimens.getScreenWidth();
        this.dp160 = dimens.dpToPx(UserProxyUtility.exitRoom);
        this.dp48 = dimens.dpToPx(48);
        this.slop = 3;
        this.compositeDisposable = new nd.a();
        FloatingViewBinding inflate = FloatingViewBinding.inflate(LayoutInflater.from(weakReference.get()), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        this.matchingFloatViewTipBalloon = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.reusable.views.k
            public final Object invoke() {
                Balloon matchingFloatViewTipBalloon_delegate$lambda$1;
                matchingFloatViewTipBalloon_delegate$lambda$1 = MatchingFloatView.matchingFloatViewTipBalloon_delegate$lambda$1(MatchingFloatView.this);
                return matchingFloatViewTipBalloon_delegate$lambda$1;
            }
        });
        WindowManager.LayoutParams layoutParams = this.floatBallParams;
        layoutParams.flags |= 262184;
        layoutParams.dimAmount = 0.2f;
        layoutParams.height = -2;
        layoutParams.width = -2;
        layoutParams.gravity = 51;
        layoutParams.format = 1;
        layoutParams.alpha = 1.0f;
        layoutParams.x = 0;
        layoutParams.y = dimens.getScreenHeight() / 2;
        inflate.dismissImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MatchingFloatView.this.dismissPress();
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MatchingFloatView._init_$lambda$3(view);
            }
        });
    }
}
