package com.qiahao.nextvideo.room.luckybox;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.qiahao.base_common.model.common.ChannelEventGiftAddTime;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.model.LuckBoxConfigBean;
import com.qiahao.nextvideo.data.model.LuckyTeenRewardBean;
import com.qiahao.nextvideo.data.model.ScrollBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.DialogLuckyBoxBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.wallet.ExchangeDetailActivity;
import com.qiahao.nextvideo.ui.wallet.WalletActivity;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.qiahao.nextvideo.utilities.decorate.GridSpacingItemMulityCountryDecoration;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import com.zhpan.bannerview.BannerViewPager;
import io.reactivex.rxjava3.core.i0;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 d2\u00020\u00012\u00020\u0002:\u0002deB!\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0013\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0016\u0010\u0011J\u000f\u0010\u0017\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0017\u0010\u0011J7\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0019j\b\u0012\u0004\u0012\u00020\u0003`\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002¢\u0006\u0004\b \u0010!J\u0019\u0010$\u001a\u00020\r2\b\u0010#\u001a\u0004\u0018\u00010\"H\u0014¢\u0006\u0004\b$\u0010%J\r\u0010&\u001a\u00020\r¢\u0006\u0004\b&\u0010\u0011J\u0017\u0010)\u001a\u00020\r2\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J3\u0010.\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010,¢\u0006\u0004\b.\u0010/J\u0015\u00100\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b0\u00101J\u0015\u00102\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0007¢\u0006\u0004\b2\u00101J\u000f\u00103\u001a\u00020\rH\u0016¢\u0006\u0004\b3\u0010\u0011J\u0015\u00105\u001a\u00020\u001e2\u0006\u00104\u001a\u00020\u000b¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\rH\u0016¢\u0006\u0004\b7\u0010\u0011R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u00108\u001a\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0016\u0010I\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010L\u001a\u00020K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010Q\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u001b\u0010X\u001a\u00020S8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bT\u0010U\u001a\u0004\bV\u0010WR\u001b\u0010]\u001a\u00020Y8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010U\u001a\u0004\b[\u0010\\R\"\u0010^\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010\u000fR\u0014\u0010c\u001a\u00020;8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010=¨\u0006f"}, d2 = {"Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "Landroid/view/View$OnClickListener;", "", "mGroupId", "Landroid/content/Context;", "context", "", "theme", "<init>", "(Ljava/lang/String;Landroid/content/Context;I)V", "", ExchangeDetailActivity.TYPE_DIAMOND, "", "showDiamond", "(J)V", "initStyle", "()V", "initDataBinding", "initDiamond", "getConfig", "initScrollView", "initRewardRecyclerView", "openOneOrTeenLuckyBox", "times", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "arrayList", "startPlayGetRewardAnimator", "(IJLjava/util/ArrayList;)V", "", "isShowLight", "changeAllLightOrUnLight", "(Z)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "rotationView", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "showType", "", "picUrls", "luckyBoxLayout", "(ILjava/lang/Long;Ljava/util/List;)V", "changeLightOrUnLight", "(I)V", "changeScaleAnimator", "show", "money", "hasMoneyAndOpenPurchaseView", "(J)Z", "onDetachedFromWindow", "Ljava/lang/String;", "getMGroupId", "()Ljava/lang/String;", "Landroid/view/animation/RotateAnimation;", "animation", "Landroid/view/animation/RotateAnimation;", "getAnimation", "()Landroid/view/animation/RotateAnimation;", "setAnimation", "(Landroid/view/animation/RotateAnimation;)V", "Lcom/qiahao/nextvideo/databinding/DialogLuckyBoxBinding;", "binding", "Lcom/qiahao/nextvideo/databinding/DialogLuckyBoxBinding;", "getBinding", "()Lcom/qiahao/nextvideo/databinding/DialogLuckyBoxBinding;", "setBinding", "(Lcom/qiahao/nextvideo/databinding/DialogLuckyBoxBinding;)V", "mCurrentContext", "Landroid/content/Context;", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxDialog$LuckBoxDialogHandler;", "mLuckBoxDialogHandler", "Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxDialog$LuckBoxDialogHandler;", "mCurrentTimes", "I", "Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxRewardAdapter;", "mLuckyBoxRewardAdapter$delegate", "Lkotlin/Lazy;", "getMLuckyBoxRewardAdapter", "()Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxRewardAdapter;", "mLuckyBoxRewardAdapter", "Lcom/qiahao/nextvideo/room/luckybox/NewsAdapter;", "mNewsAdapter$delegate", "getMNewsAdapter", "()Lcom/qiahao/nextvideo/room/luckybox/NewsAdapter;", "mNewsAdapter", "mConfigDiamond", "J", "getMConfigDiamond", "()J", "setMConfigDiamond", "rotateAnimation", "Companion", "LuckBoxDialogHandler", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyBoxDialog extends BottomSheetDialog implements View.OnClickListener {

    @NotNull
    private static final String TAG = "LuckyBoxDialog";

    @Nullable
    private RotateAnimation animation;
    public DialogLuckyBoxBinding binding;

    @NotNull
    private nd.a mCompositeDisposable;
    private long mConfigDiamond;

    @NotNull
    private Context mCurrentContext;
    private int mCurrentTimes;

    @NotNull
    private final String mGroupId;
    private LuckBoxDialogHandler mLuckBoxDialogHandler;

    /* renamed from: mLuckyBoxRewardAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mLuckyBoxRewardAdapter;

    /* renamed from: mNewsAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mNewsAdapter;

    @NotNull
    private final RotateAnimation rotateAnimation;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxDialog$LuckBoxDialogHandler;", "Landroid/os/Handler;", "mLuckyBoxDialog", "Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxDialog;", "<init>", "(Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxDialog;)V", "mStandByCountAddTimes", "", "getMStandByCountAddTimes", "()J", "setMStandByCountAddTimes", "(J)V", "mRewardPlayCountAddTimes", "getMRewardPlayCountAddTimes", "setMRewardPlayCountAddTimes", "mLuckyBoxDialogReference", "Ljava/lang/ref/WeakReference;", "handleMessage", "", "msg", "Landroid/os/Message;", "sendStanByAnimatorStart", "isStart", "", "sendPlayAnimatorStart", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class LuckBoxDialogHandler extends Handler {
        public static final int ONE_TIMES_REWARD = 2;
        public static final int REWARD_PLAY_ANIMATOR_MESSAGE = 1;
        public static final int STANDBY_ANIMATOR_MESSAGE = 0;
        public static final int TEEN_TIMES_REWARD = 3;

        @Nullable
        private WeakReference<LuckyBoxDialog> mLuckyBoxDialogReference;
        private long mRewardPlayCountAddTimes;
        private long mStandByCountAddTimes;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public LuckBoxDialogHandler(@NotNull LuckyBoxDialog luckyBoxDialog) {
            super(r0);
            Intrinsics.checkNotNullParameter(luckyBoxDialog, "mLuckyBoxDialog");
            Looper myLooper = Looper.myLooper();
            Intrinsics.checkNotNull(myLooper);
            this.mLuckyBoxDialogReference = new WeakReference<>(luckyBoxDialog);
        }

        public final long getMRewardPlayCountAddTimes() {
            return this.mRewardPlayCountAddTimes;
        }

        public final long getMStandByCountAddTimes() {
            return this.mStandByCountAddTimes;
        }

        @Override // android.os.Handler
        public void handleMessage(@NotNull Message msg) {
            LuckyBoxDialog luckyBoxDialog;
            LuckyBoxDialog luckyBoxDialog2;
            LuckyBoxDialog luckyBoxDialog3;
            LuckyBoxDialog luckyBoxDialog4;
            Intrinsics.checkNotNullParameter(msg, "msg");
            super.handleMessage(msg);
            int i = msg.what;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            Bundle data = msg.getData();
                            long j = data.getLong(ExchangeDetailActivity.TYPE_DIAMOND, 0L);
                            ArrayList<String> stringArrayList = data.getStringArrayList("rewardList");
                            WeakReference<LuckyBoxDialog> weakReference = this.mLuckyBoxDialogReference;
                            if (weakReference != null && (luckyBoxDialog4 = weakReference.get()) != null) {
                                luckyBoxDialog4.luckyBoxLayout(2, Long.valueOf(j), stringArrayList);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    Bundle data2 = msg.getData();
                    long j2 = data2.getLong(ExchangeDetailActivity.TYPE_DIAMOND, 0L);
                    ArrayList<String> stringArrayList2 = data2.getStringArrayList("rewardList");
                    WeakReference<LuckyBoxDialog> weakReference2 = this.mLuckyBoxDialogReference;
                    if (weakReference2 != null && (luckyBoxDialog3 = weakReference2.get()) != null) {
                        luckyBoxDialog3.luckyBoxLayout(1, Long.valueOf(j2), stringArrayList2);
                        return;
                    }
                    return;
                }
                int i2 = (int) (this.mRewardPlayCountAddTimes % 6);
                WeakReference<LuckyBoxDialog> weakReference3 = this.mLuckyBoxDialogReference;
                if (weakReference3 != null && (luckyBoxDialog2 = weakReference3.get()) != null) {
                    luckyBoxDialog2.changeScaleAnimator(i2);
                }
                this.mRewardPlayCountAddTimes++;
                sendPlayAnimatorStart(false);
                return;
            }
            int i3 = (int) (this.mStandByCountAddTimes % 6);
            WeakReference<LuckyBoxDialog> weakReference4 = this.mLuckyBoxDialogReference;
            if (weakReference4 != null && (luckyBoxDialog = weakReference4.get()) != null) {
                luckyBoxDialog.changeLightOrUnLight(i3);
            }
            this.mStandByCountAddTimes++;
            sendStanByAnimatorStart(false);
        }

        public final void sendPlayAnimatorStart(boolean isStart) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            if (isStart) {
                this.mRewardPlayCountAddTimes = 0L;
                sendMessage(obtain);
            } else {
                sendMessageDelayed(obtain, 300L);
            }
        }

        public final void sendStanByAnimatorStart(boolean isStart) {
            Message obtain = Message.obtain();
            obtain.what = 0;
            if (isStart) {
                this.mStandByCountAddTimes = 0L;
                sendMessage(obtain);
            } else {
                sendMessageDelayed(obtain, 1000L);
            }
        }

        public final void setMRewardPlayCountAddTimes(long j) {
            this.mRewardPlayCountAddTimes = j;
        }

        public final void setMStandByCountAddTimes(long j) {
            this.mStandByCountAddTimes = j;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LuckyBoxDialog(@NotNull String str, @NotNull Context context, int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(str, "mGroupId");
        Intrinsics.checkNotNullParameter(context, "context");
        this.mGroupId = str;
        this.mCurrentContext = context;
        this.mCompositeDisposable = new nd.a();
        this.mLuckyBoxRewardAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.luckybox.h
            public final Object invoke() {
                LuckyBoxRewardAdapter mLuckyBoxRewardAdapter_delegate$lambda$0;
                mLuckyBoxRewardAdapter_delegate$lambda$0 = LuckyBoxDialog.mLuckyBoxRewardAdapter_delegate$lambda$0();
                return mLuckyBoxRewardAdapter_delegate$lambda$0;
            }
        });
        this.mNewsAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.luckybox.i
            public final Object invoke() {
                NewsAdapter mNewsAdapter_delegate$lambda$1;
                mNewsAdapter_delegate$lambda$1 = LuckyBoxDialog.mNewsAdapter_delegate$lambda$1();
                return mNewsAdapter_delegate$lambda$1;
            }
        });
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(5000L);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.rotateAnimation = rotateAnimation;
    }

    private final void changeAllLightOrUnLight(boolean isShowLight) {
        if (isShowLight) {
            ImageView imageView = getBinding().box1;
            Intrinsics.checkNotNullExpressionValue(imageView, "box1");
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_light_1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ImageView imageView2 = getBinding().box2;
            Intrinsics.checkNotNullExpressionValue(imageView2, "box2");
            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_light_3), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ImageView imageView3 = getBinding().box3;
            Intrinsics.checkNotNullExpressionValue(imageView3, "box3");
            ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_light_2), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ImageView imageView4 = getBinding().box4;
            Intrinsics.checkNotNullExpressionValue(imageView4, "box4");
            ImageKtxKt.loadImage$default(imageView4, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_light_5), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ImageView imageView5 = getBinding().box5;
            Intrinsics.checkNotNullExpressionValue(imageView5, "box5");
            ImageKtxKt.loadImage$default(imageView5, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_light_6), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ImageView imageView6 = getBinding().box6;
            Intrinsics.checkNotNullExpressionValue(imageView6, "box6");
            ImageKtxKt.loadImage$default(imageView6, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_light_4), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            return;
        }
        ImageView imageView7 = getBinding().box1;
        Intrinsics.checkNotNullExpressionValue(imageView7, "box1");
        ImageKtxKt.loadImage$default(imageView7, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_unlight_1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        ImageView imageView8 = getBinding().box2;
        Intrinsics.checkNotNullExpressionValue(imageView8, "box2");
        ImageKtxKt.loadImage$default(imageView8, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_unlight_3), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        ImageView imageView9 = getBinding().box3;
        Intrinsics.checkNotNullExpressionValue(imageView9, "box3");
        ImageKtxKt.loadImage$default(imageView9, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_unlight_2), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        ImageView imageView10 = getBinding().box4;
        Intrinsics.checkNotNullExpressionValue(imageView10, "box4");
        ImageKtxKt.loadImage$default(imageView10, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_unlight_5), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        ImageView imageView11 = getBinding().box5;
        Intrinsics.checkNotNullExpressionValue(imageView11, "box5");
        ImageKtxKt.loadImage$default(imageView11, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_unlight_6), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        ImageView imageView12 = getBinding().box6;
        Intrinsics.checkNotNullExpressionValue(imageView12, "box6");
        ImageKtxKt.loadImage$default(imageView12, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_unlight_4), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
    }

    private final void getConfig() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getLuckConfig(), new Function1() { // from class: com.qiahao.nextvideo.room.luckybox.d
            public final Object invoke(Object obj) {
                Unit config$lambda$5;
                config$lambda$5 = LuckyBoxDialog.getConfig$lambda$5(LuckyBoxDialog.this, (ApiResponse) obj);
                return config$lambda$5;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.luckybox.e
            public final Object invoke(Object obj) {
                Unit config$lambda$6;
                config$lambda$6 = LuckyBoxDialog.getConfig$lambda$6((Throwable) obj);
                return config$lambda$6;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getConfig$lambda$5(LuckyBoxDialog luckyBoxDialog, ApiResponse apiResponse) {
        int i;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        LuckBoxConfigBean luckBoxConfigBean = (LuckBoxConfigBean) apiResponse.getData();
        if (luckBoxConfigBean != null) {
            i = luckBoxConfigBean.getBuyDiamond();
        } else {
            i = 0;
        }
        luckyBoxDialog.mConfigDiamond = i;
        luckyBoxDialog.getBinding().oneTimesDiamond.setText(String.valueOf(luckyBoxDialog.mConfigDiamond));
        luckyBoxDialog.getBinding().teenTimesDiamond.setText(String.valueOf(luckyBoxDialog.mConfigDiamond * 10));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getConfig$lambda$6(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final LuckyBoxRewardAdapter getMLuckyBoxRewardAdapter() {
        return (LuckyBoxRewardAdapter) this.mLuckyBoxRewardAdapter.getValue();
    }

    private final NewsAdapter getMNewsAdapter() {
        return (NewsAdapter) this.mNewsAdapter.getValue();
    }

    private final void initDataBinding() {
        setBinding(DialogLuckyBoxBinding.inflate(LayoutInflater.from(this.mCurrentContext), null, false));
        setContentView(getBinding().getRoot());
        getBinding().setClick(this);
        luckyBoxLayout$default(this, 0, null, null, 6, null);
        initRewardRecyclerView();
        initScrollView();
        initDiamond();
        getConfig();
    }

    private final void initDiamond() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().fetchUserDiamond(), new Function1() { // from class: com.qiahao.nextvideo.room.luckybox.f
            public final Object invoke(Object obj) {
                Unit initDiamond$lambda$3;
                initDiamond$lambda$3 = LuckyBoxDialog.initDiamond$lambda$3((ApiResponse) obj);
                return initDiamond$lambda$3;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.luckybox.g
            public final Object invoke(Object obj) {
                Unit initDiamond$lambda$4;
                initDiamond$lambda$4 = LuckyBoxDialog.initDiamond$lambda$4((Throwable) obj);
                return initDiamond$lambda$4;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initDiamond$lambda$3(ApiResponse apiResponse) {
        Double d;
        double d2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        Double d3 = null;
        if (user != null) {
            d = Double.valueOf(user.getDiamondNum());
        } else {
            d = null;
        }
        ChannelEventGiftAddTime channelEventGiftAddTime = (ChannelEventGiftAddTime) apiResponse.getData();
        if (channelEventGiftAddTime != null) {
            d3 = Double.valueOf(channelEventGiftAddTime.getDiamondNum());
        }
        if (!Intrinsics.areEqual(d, d3)) {
            UserStore shared = companion.getShared();
            ChannelEventGiftAddTime channelEventGiftAddTime2 = (ChannelEventGiftAddTime) apiResponse.getData();
            if (channelEventGiftAddTime2 != null) {
                d2 = channelEventGiftAddTime2.getDiamondNum();
            } else {
                d2 = 0.0d;
            }
            UserStore.refreshDiamondOrGem$default(shared, d2, 0.0d, 2, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initDiamond$lambda$4(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void initRewardRecyclerView() {
        RecyclerView recyclerView = getBinding().teenTimesReward;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 5));
        recyclerView.addItemDecoration(new GridSpacingItemMulityCountryDecoration(5, Dimens.INSTANCE.dpToPx(5), true));
        recyclerView.setAdapter(getMLuckyBoxRewardAdapter());
    }

    private final void initScrollView() {
        BannerViewPager bannerViewPager = getBinding().bannerView;
        Intrinsics.checkNotNull(bannerViewPager, "null cannot be cast to non-null type com.zhpan.bannerview.BannerViewPager<com.qiahao.nextvideo.data.model.ScrollBean>");
        bannerViewPager.G(getMNewsAdapter());
        bannerViewPager.I(true);
        bannerViewPager.S(HonorResultCode.ADVANCED_RECORD_SUCCESS);
        bannerViewPager.c0(500);
        bannerViewPager.V(1);
        bannerViewPager.R(8);
        bannerViewPager.g();
        ArrayList<ScrollBean> luckyBoxRankCache = MMKVToLocalCache.INSTANCE.getLuckyBoxRankCache();
        if (luckyBoxRankCache != null) {
            getBinding().bannerView.C(luckyBoxRankCache);
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().getLuckBoxScroll(), new Function1() { // from class: com.qiahao.nextvideo.room.luckybox.j
            public final Object invoke(Object obj) {
                Unit initScrollView$lambda$9;
                initScrollView$lambda$9 = LuckyBoxDialog.initScrollView$lambda$9(LuckyBoxDialog.this, (ApiResponse) obj);
                return initScrollView$lambda$9;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.luckybox.k
            public final Object invoke(Object obj) {
                Unit initScrollView$lambda$10;
                initScrollView$lambda$10 = LuckyBoxDialog.initScrollView$lambda$10((Throwable) obj);
                return initScrollView$lambda$10;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initScrollView$lambda$10(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        Log.d(TAG, "initScrollView: false");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initScrollView$lambda$9(LuckyBoxDialog luckyBoxDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ArrayList<ScrollBean> arrayList = (ArrayList) apiResponse.getData();
        if (arrayList != null) {
            if (arrayList.size() > 10) {
                List<ScrollBean> subList = arrayList.subList(0, 10);
                Intrinsics.checkNotNullExpressionValue(subList, "subList(...)");
                MMKVToLocalCache.Companion companion = MMKVToLocalCache.INSTANCE;
                List mutableList = CollectionsKt.toMutableList(subList);
                Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.nextvideo.data.model.ScrollBean>");
                companion.saveLuckyBoxRankCache((ArrayList) mutableList);
            } else {
                MMKVToLocalCache.INSTANCE.saveLuckyBoxRankCache(arrayList);
            }
            luckyBoxDialog.getBinding().bannerView.C(arrayList);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initStyle() {
        setCanceledOnTouchOutside(true);
        FrameLayout frameLayout = (FrameLayout) findViewById(2131362643);
        if (frameLayout != null) {
            BottomSheetBehavior.s0(frameLayout).c1(false);
            BottomSheetBehavior.s0(frameLayout).Y0(-1);
            frameLayout.setBackground(new ColorDrawable(0));
        }
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        window.setDimAmount(0.0f);
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        WindowManager.LayoutParams attributes = window2.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.horizontalMargin = 0.0f;
        Window window3 = getWindow();
        Intrinsics.checkNotNull(window3);
        window3.setAttributes(attributes);
        Window window4 = getWindow();
        Intrinsics.checkNotNull(window4);
        window4.getDecorView().setPadding(0, 0, 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void luckyBoxLayout$default(LuckyBoxDialog luckyBoxDialog, int i, Long l, List list, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            l = 0L;
        }
        if ((i2 & 4) != 0) {
            list = null;
        }
        luckyBoxDialog.luckyBoxLayout(i, l, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LuckyBoxRewardAdapter mLuckyBoxRewardAdapter_delegate$lambda$0() {
        return new LuckyBoxRewardAdapter(R.layout.item_group_lucky_box);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NewsAdapter mNewsAdapter_delegate$lambda$1() {
        return new NewsAdapter();
    }

    private final void openOneOrTeenLuckyBox() {
        long j;
        i0<ApiResponse<LuckyTeenRewardBean>> openTeenTimesLuckyBox;
        final Long l;
        Log.d(TAG, "不可点击！！！！！: ");
        getBinding().drawOneTimes.setEnabled(false);
        getBinding().drawTeenTimes.setEnabled(false);
        if (this.mConfigDiamond == 0) {
            getConfig();
        }
        final Ref.LongRef longRef = new Ref.LongRef();
        if (this.mCurrentTimes == 1) {
            j = this.mConfigDiamond;
        } else {
            j = this.mConfigDiamond * 10;
        }
        longRef.element = j;
        if (hasMoneyAndOpenPurchaseView(j)) {
            if (this.mCurrentTimes == 1) {
                Log.d(TAG, "openOneOrTeenLuckyBox: 抽一次");
                openTeenTimesLuckyBox = AppServer.INSTANCE.getApis().openOneTimesLuckyBox();
            } else {
                Log.d(TAG, "openOneOrTeenLuckyBox: 抽十次");
                openTeenTimesLuckyBox = AppServer.INSTANCE.getApis().openTeenTimesLuckyBox();
            }
            i0<ApiResponse<LuckyTeenRewardBean>> i0Var = openTeenTimesLuckyBox;
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user != null) {
                l = Long.valueOf((long) user.getDiamondNum());
            } else {
                l = null;
            }
            Log.d(TAG, "openOneOrTeenLuckyBox: 原先的钱" + l);
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(i0Var, new Function1() { // from class: com.qiahao.nextvideo.room.luckybox.l
                public final Object invoke(Object obj) {
                    Unit openOneOrTeenLuckyBox$lambda$12;
                    openOneOrTeenLuckyBox$lambda$12 = LuckyBoxDialog.openOneOrTeenLuckyBox$lambda$12(LuckyBoxDialog.this, l, longRef, (ApiResponse) obj);
                    return openOneOrTeenLuckyBox$lambda$12;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.room.luckybox.m
                public final Object invoke(Object obj) {
                    Unit openOneOrTeenLuckyBox$lambda$13;
                    openOneOrTeenLuckyBox$lambda$13 = LuckyBoxDialog.openOneOrTeenLuckyBox$lambda$13(LuckyBoxDialog.this, (Throwable) obj);
                    return openOneOrTeenLuckyBox$lambda$13;
                }
            }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openOneOrTeenLuckyBox$lambda$12(LuckyBoxDialog luckyBoxDialog, Long l, Ref.LongRef longRef, ApiResponse apiResponse) {
        Double d;
        Double d2;
        long j;
        List<String> picUrls;
        long j2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore.Companion companion = UserStore.INSTANCE;
        User user = companion.getShared().getUser();
        List list = null;
        if (user != null) {
            d = Double.valueOf(user.getDiamondNum());
        } else {
            d = null;
        }
        if (((LuckyTeenRewardBean) apiResponse.getData()) != null) {
            d2 = Double.valueOf(r3.getDiamondNum());
        } else {
            d2 = null;
        }
        boolean areEqual = Intrinsics.areEqual(d, d2);
        long j3 = 0;
        if (!areEqual) {
            UserStore shared = companion.getShared();
            LuckyTeenRewardBean luckyTeenRewardBean = (LuckyTeenRewardBean) apiResponse.getData();
            if (luckyTeenRewardBean != null) {
                j2 = luckyTeenRewardBean.getDiamondNum();
            } else {
                j2 = 0;
            }
            UserStore.refreshDiamondOrGem$default(shared, j2, 0.0d, 2, null);
        }
        int i = luckyBoxDialog.mCurrentTimes;
        LuckyTeenRewardBean luckyTeenRewardBean2 = (LuckyTeenRewardBean) apiResponse.getData();
        if (luckyTeenRewardBean2 != null) {
            j = luckyTeenRewardBean2.getDiamondNum();
        } else {
            j = 0;
        }
        LuckyTeenRewardBean luckyTeenRewardBean3 = (LuckyTeenRewardBean) apiResponse.getData();
        if (luckyTeenRewardBean3 != null && (picUrls = luckyTeenRewardBean3.getPicUrls()) != null) {
            list = CollectionsKt.toMutableList(picUrls);
        }
        Intrinsics.checkNotNull(list, "null cannot be cast to non-null type java.util.ArrayList<kotlin.String>");
        luckyBoxDialog.startPlayGetRewardAnimator(i, j, (ArrayList) list);
        if (l != null) {
            j3 = l.longValue() - longRef.element;
        }
        luckyBoxDialog.showDiamond(j3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit openOneOrTeenLuckyBox$lambda$13(LuckyBoxDialog luckyBoxDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        Context context = luckyBoxDialog.mCurrentContext;
        String string = context.getString(2131952667);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        Toast normal$default = HiloToasty.Companion.normal$default(companion, context, string, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        Log.d(TAG, "可让点击！！！！！: ");
        luckyBoxDialog.getBinding().drawOneTimes.setEnabled(true);
        luckyBoxDialog.getBinding().drawTeenTimes.setEnabled(true);
        return Unit.INSTANCE;
    }

    private final void showDiamond(long diamond) {
        getBinding().diamondCountTickTextView.setText(String.valueOf(diamond));
    }

    private final void startPlayGetRewardAnimator(int times, long diamond, ArrayList<String> arrayList) {
        LuckBoxDialogHandler luckBoxDialogHandler = this.mLuckBoxDialogHandler;
        LuckBoxDialogHandler luckBoxDialogHandler2 = null;
        if (luckBoxDialogHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLuckBoxDialogHandler");
            luckBoxDialogHandler = null;
        }
        luckBoxDialogHandler.removeMessages(0);
        changeAllLightOrUnLight(true);
        LuckBoxDialogHandler luckBoxDialogHandler3 = this.mLuckBoxDialogHandler;
        if (luckBoxDialogHandler3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLuckBoxDialogHandler");
            luckBoxDialogHandler3 = null;
        }
        luckBoxDialogHandler3.sendPlayAnimatorStart(true);
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("rewardList", arrayList);
        bundle.putLong(ExchangeDetailActivity.TYPE_DIAMOND, diamond);
        obtain.setData(bundle);
        if (times == 1) {
            obtain.what = 2;
        } else {
            obtain.what = 3;
        }
        LuckBoxDialogHandler luckBoxDialogHandler4 = this.mLuckBoxDialogHandler;
        if (luckBoxDialogHandler4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLuckBoxDialogHandler");
        } else {
            luckBoxDialogHandler2 = luckBoxDialogHandler4;
        }
        luckBoxDialogHandler2.sendMessageDelayed(obtain, 1800L);
    }

    public final void changeLightOrUnLight(int times) {
        Log.d(TAG, "changeLightOrUnLight: times");
        if (times != 0) {
            if (times != 1) {
                if (times != 2) {
                    if (times != 3) {
                        if (times != 4) {
                            if (times == 5) {
                                ImageView imageView = getBinding().box5;
                                Intrinsics.checkNotNullExpressionValue(imageView, "box5");
                                ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_unlight_6), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                                ImageView imageView2 = getBinding().box6;
                                Intrinsics.checkNotNullExpressionValue(imageView2, "box6");
                                ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_light_4), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                                return;
                            }
                            return;
                        }
                        ImageView imageView3 = getBinding().box4;
                        Intrinsics.checkNotNullExpressionValue(imageView3, "box4");
                        ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_unlight_5), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                        ImageView imageView4 = getBinding().box5;
                        Intrinsics.checkNotNullExpressionValue(imageView4, "box5");
                        ImageKtxKt.loadImage$default(imageView4, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_light_6), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                        return;
                    }
                    ImageView imageView5 = getBinding().box3;
                    Intrinsics.checkNotNullExpressionValue(imageView5, "box3");
                    ImageKtxKt.loadImage$default(imageView5, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_unlight_2), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    ImageView imageView6 = getBinding().box4;
                    Intrinsics.checkNotNullExpressionValue(imageView6, "box4");
                    ImageKtxKt.loadImage$default(imageView6, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_light_5), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    return;
                }
                ImageView imageView7 = getBinding().box2;
                Intrinsics.checkNotNullExpressionValue(imageView7, "box2");
                ImageKtxKt.loadImage$default(imageView7, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_unlight_3), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                ImageView imageView8 = getBinding().box3;
                Intrinsics.checkNotNullExpressionValue(imageView8, "box3");
                ImageKtxKt.loadImage$default(imageView8, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_light_2), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                return;
            }
            ImageView imageView9 = getBinding().box1;
            Intrinsics.checkNotNullExpressionValue(imageView9, "box1");
            ImageKtxKt.loadImage$default(imageView9, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_unlight_1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            ImageView imageView10 = getBinding().box2;
            Intrinsics.checkNotNullExpressionValue(imageView10, "box2");
            ImageKtxKt.loadImage$default(imageView10, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_light_3), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            return;
        }
        ImageView imageView11 = getBinding().box6;
        Intrinsics.checkNotNullExpressionValue(imageView11, "box6");
        ImageKtxKt.loadImage$default(imageView11, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_unlight_4), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        ImageView imageView12 = getBinding().box1;
        Intrinsics.checkNotNullExpressionValue(imageView12, "box1");
        ImageKtxKt.loadImage$default(imageView12, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_light_1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
    }

    public final void changeScaleAnimator(int times) {
        ImageView imageView;
        Log.d(TAG, "changeLightOrUnLight: times");
        if (times != 0) {
            if (times != 1) {
                if (times != 2) {
                    if (times != 3) {
                        if (times != 4) {
                            if (times != 5) {
                                imageView = getBinding().box1;
                            } else {
                                imageView = getBinding().box6;
                            }
                        } else {
                            imageView = getBinding().box5;
                        }
                    } else {
                        imageView = getBinding().box4;
                    }
                } else {
                    imageView = getBinding().box3;
                }
            } else {
                imageView = getBinding().box2;
            }
        } else {
            imageView = getBinding().box1;
        }
        Intrinsics.checkNotNull(imageView);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) View.SCALE_X, 1.0f, 1.3f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(imageView, (Property<ImageView, Float>) View.SCALE_Y, 1.0f, 1.3f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(600L);
        animatorSet.start();
    }

    @Nullable
    public final RotateAnimation getAnimation() {
        return this.animation;
    }

    @NotNull
    public final DialogLuckyBoxBinding getBinding() {
        DialogLuckyBoxBinding dialogLuckyBoxBinding = this.binding;
        if (dialogLuckyBoxBinding != null) {
            return dialogLuckyBoxBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final long getMConfigDiamond() {
        return this.mConfigDiamond;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final boolean hasMoneyAndOpenPurchaseView(long money) {
        double d;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            d = user.getDiamondNum();
        } else {
            d = 0.0d;
        }
        if (d >= money) {
            return true;
        }
        getBinding().drawOneTimes.setEnabled(true);
        getBinding().drawTeenTimes.setEnabled(true);
        WalletActivity.INSTANCE.start(this.mCurrentContext);
        return false;
    }

    public final void luckyBoxLayout(int showType, @Nullable Long diamond, @Nullable List<String> picUrls) {
        LuckBoxDialogHandler luckBoxDialogHandler = null;
        if (showType != 0) {
            long j = 0;
            if (showType != 1) {
                if (showType == 2) {
                    getBinding().rewardLayout.setVisibility(0);
                    getBinding().teenTimesReward.setVisibility(0);
                    getBinding().onceLight.clearAnimation();
                    getBinding().onceLight.setVisibility(8);
                    getBinding().oneReward.setVisibility(8);
                    if (picUrls != null && !picUrls.isEmpty()) {
                        getMLuckyBoxRewardAdapter().setList(picUrls);
                    }
                    if (diamond != null) {
                        j = diamond.longValue();
                    }
                    showDiamond(j);
                    LuckBoxDialogHandler luckBoxDialogHandler2 = this.mLuckBoxDialogHandler;
                    if (luckBoxDialogHandler2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLuckBoxDialogHandler");
                        luckBoxDialogHandler2 = null;
                    }
                    luckBoxDialogHandler2.removeMessages(0);
                    LuckBoxDialogHandler luckBoxDialogHandler3 = this.mLuckBoxDialogHandler;
                    if (luckBoxDialogHandler3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLuckBoxDialogHandler");
                    } else {
                        luckBoxDialogHandler = luckBoxDialogHandler3;
                    }
                    luckBoxDialogHandler.removeMessages(1);
                    Log.d(TAG, "可让点击！！！！！: ");
                    getBinding().drawOneTimes.setEnabled(true);
                    getBinding().drawTeenTimes.setEnabled(true);
                    return;
                }
                return;
            }
            getBinding().rewardLayout.setVisibility(0);
            getBinding().teenTimesReward.setVisibility(8);
            getBinding().onceLight.setVisibility(0);
            rotationView();
            getBinding().oneReward.setVisibility(0);
            if (picUrls != null && !picUrls.isEmpty()) {
                String str = picUrls.get(0);
                if (str != null && str.length() != 0) {
                    ImageView imageView = getBinding().oneReward;
                    Intrinsics.checkNotNullExpressionValue(imageView, "oneReward");
                    ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
                    String str2 = picUrls.get(0);
                    ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
                    Dimens dimens = Dimens.INSTANCE;
                    lfit.setWidth(dimens.dpToPx(121));
                    lfit.setHeight(dimens.dpToPx(121));
                    Unit unit = Unit.INSTANCE;
                    ImageUIModel displayImage = companion.displayImage(str2, lfit);
                    displayImage.setPlaceholder(2131232497);
                    ViewUtilitiesKt.bind(imageView, displayImage);
                } else {
                    ImageView imageView2 = getBinding().oneReward;
                    Intrinsics.checkNotNullExpressionValue(imageView2, "oneReward");
                    ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_box_fail), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
            } else {
                ImageView imageView3 = getBinding().oneReward;
                Intrinsics.checkNotNullExpressionValue(imageView3, "oneReward");
                ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_box_fail), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            }
            if (diamond != null) {
                j = diamond.longValue();
            }
            showDiamond(j);
            LuckBoxDialogHandler luckBoxDialogHandler4 = this.mLuckBoxDialogHandler;
            if (luckBoxDialogHandler4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLuckBoxDialogHandler");
                luckBoxDialogHandler4 = null;
            }
            luckBoxDialogHandler4.removeMessages(0);
            LuckBoxDialogHandler luckBoxDialogHandler5 = this.mLuckBoxDialogHandler;
            if (luckBoxDialogHandler5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLuckBoxDialogHandler");
            } else {
                luckBoxDialogHandler = luckBoxDialogHandler5;
            }
            luckBoxDialogHandler.removeMessages(1);
            Log.d(TAG, "可让点击！！！！！: ");
            getBinding().drawOneTimes.setEnabled(true);
            getBinding().drawTeenTimes.setEnabled(true);
            return;
        }
        getBinding().rewardLayout.setVisibility(8);
        changeAllLightOrUnLight(false);
        LuckBoxDialogHandler luckBoxDialogHandler6 = this.mLuckBoxDialogHandler;
        if (luckBoxDialogHandler6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLuckBoxDialogHandler");
        } else {
            luckBoxDialogHandler = luckBoxDialogHandler6;
        }
        luckBoxDialogHandler.sendStanByAnimatorStart(true);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i = 2;
        int i2 = 0;
        switch (v.getId()) {
            case R.id.banner_click /* 2131362064 */:
            case R.id.ic_lucky_box_rank /* 2131363155 */:
                if (FastClickOneUtils.INSTANCE.isFastClick()) {
                    new LuckyBoxRankingDialog(this.mCurrentContext, i2, i, defaultConstructorMarker).show();
                    return;
                }
                return;
            case R.id.draw_one_times /* 2131362719 */:
                Log.d(TAG, "onClick: 点击");
                Log.d(TAG, "onClick: 抽一次--点击有效");
                this.mCurrentTimes = 1;
                openOneOrTeenLuckyBox();
                return;
            case R.id.draw_teen_times /* 2131362720 */:
                Log.d(TAG, "onClick: 点击");
                Log.d(TAG, "onClick: 抽十次--点击有效");
                this.mCurrentTimes = 10;
                openOneOrTeenLuckyBox();
                return;
            case R.id.ic_lucky_box_list /* 2131363154 */:
                if (FastClickOneUtils.INSTANCE.isFastClick()) {
                    new LuckyBoxRecordDialog(this.mCurrentContext, i2, i, defaultConstructorMarker).show();
                    return;
                }
                return;
            case R.id.ll_diamond /* 2131363545 */:
                if (FastClickOneUtils.INSTANCE.isFastClick()) {
                    WalletActivity.INSTANCE.start(this.mCurrentContext);
                    return;
                }
                return;
            case R.id.reward_again /* 2131364623 */:
                Log.d(TAG, "onClick: 点击");
                if (FastClickOneUtils.INSTANCE.isFastClick()) {
                    luckyBoxLayout$default(this, 0, null, null, 6, null);
                    openOneOrTeenLuckyBox();
                    return;
                }
                return;
            case R.id.reward_confirm /* 2131364624 */:
                Log.d(TAG, "可让点击！！！！！: ");
                getBinding().drawOneTimes.setEnabled(true);
                getBinding().drawTeenTimes.setEnabled(true);
                if (FastClickOneUtils.INSTANCE.isFastClick()) {
                    luckyBoxLayout$default(this, 0, null, null, 6, null);
                    return;
                }
                return;
            case R.id.reward_list /* 2131364627 */:
                new LuckyBoxBigPrizesDialog(this.mCurrentContext, i2, i, defaultConstructorMarker).show();
                return;
            default:
                return;
        }
    }

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        long j;
        super.onCreate(savedInstanceState);
        this.mLuckBoxDialogHandler = new LuckBoxDialogHandler(this);
        setDismissWithAnimation(true);
        initDataBinding();
        initStyle();
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null) {
            j = (long) user.getDiamondNum();
        } else {
            j = 0;
        }
        showDiamond(j);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        LuckBoxDialogHandler luckBoxDialogHandler = this.mLuckBoxDialogHandler;
        if (luckBoxDialogHandler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLuckBoxDialogHandler");
            luckBoxDialogHandler = null;
        }
        luckBoxDialogHandler.removeCallbacksAndMessages(null);
        this.mCompositeDisposable.d();
        getBinding().bannerView.e0();
        if (getBinding().onceAgain.getAnimation() != null) {
            getBinding().onceLight.getAnimation().cancel();
        }
    }

    public final void rotationView() {
        getBinding().onceLight.setAnimation(this.rotateAnimation);
        getBinding().onceLight.getAnimation().startNow();
    }

    public final void setAnimation(@Nullable RotateAnimation rotateAnimation) {
        this.animation = rotateAnimation;
    }

    public final void setBinding(@NotNull DialogLuckyBoxBinding dialogLuckyBoxBinding) {
        Intrinsics.checkNotNullParameter(dialogLuckyBoxBinding, "<set-?>");
        this.binding = dialogLuckyBoxBinding;
    }

    public final void setMConfigDiamond(long j) {
        this.mConfigDiamond = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show() {
        super/*android.app.Dialog*/.show();
        getBinding().bannerView.H(true);
    }

    public /* synthetic */ LuckyBoxDialog(String str, Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, context, (i2 & 4) != 0 ? R.style.HiloBottomSheetDialog : i);
    }
}
