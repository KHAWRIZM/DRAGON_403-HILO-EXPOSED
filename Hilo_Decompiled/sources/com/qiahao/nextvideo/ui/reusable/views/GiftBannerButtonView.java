package com.qiahao.nextvideo.ui.reusable.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.opensource.svgaplayer.SVGACallback;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.utils.SVGARange;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.model.GiftBannerData;
import com.qiahao.nextvideo.data.room.GiftBannerButtonData;
import com.qiahao.nextvideo.databinding.EnvelopeBannerBinding;
import com.qiahao.nextvideo.databinding.GiftBannerView1Binding;
import com.qiahao.nextvideo.room.activity.RoomActivity;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u0017\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010!\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J)\u0010'\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020#2\u0006\u0010 \u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002¢\u0006\u0004\b'\u0010(J!\u0010*\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b*\u0010+J\u001f\u0010.\u001a\u00020\n2\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020\n2\u0006\u0010-\u001a\u00020,2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b0\u0010/J)\u00102\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u00101\u001a\u00020\u0006H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00105\u001a\u000204H\u0002¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\n¢\u0006\u0004\b7\u0010\fJ\r\u00108\u001a\u00020\n¢\u0006\u0004\b8\u0010\fJ\r\u00109\u001a\u00020\n¢\u0006\u0004\b9\u0010\fJ\u000f\u0010:\u001a\u00020\nH\u0014¢\u0006\u0004\b:\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010;R\u0016\u0010<\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010A\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0014\u0010D\u001a\u00020C8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010ER$\u0010G\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010M\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010=\u001a\u0004\bM\u00106\"\u0004\bN\u0010OR\"\u0010P\u001a\u00020,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010V\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0017\u0010]\u001a\u00020\\8\u0006¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u0018\u0010a\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010c\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u001b\u0010j\u001a\u00020e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i¨\u0006k"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/GiftBannerButtonView;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "mContext", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "toRoom", "()V", "enterAnimator", "leaveAnimator", "Lcom/opensource/svgaplayer/SVGAImageView;", "svgaView", "initSVGA", "(Lcom/opensource/svgaplayer/SVGAImageView;)V", "Landroid/widget/FrameLayout$LayoutParams;", "mLayoutParams", "refreshView", "(Landroid/widget/FrameLayout$LayoutParams;)V", "Lcom/qiahao/nextvideo/data/model/GiftBannerData;", "data", "handleRocketBanner", "(Lcom/qiahao/nextvideo/data/model/GiftBannerData;Landroid/widget/FrameLayout$LayoutParams;)V", "Lcom/qiahao/nextvideo/data/room/GiftBannerButtonData;", "globalBean", "handleEnvelopeBanner", "(Lcom/qiahao/nextvideo/data/room/GiftBannerButtonData;Landroid/widget/FrameLayout$LayoutParams;)V", "Lcom/qiahao/nextvideo/databinding/GiftBannerView1Binding;", "binding", "refreshRocketGift", "(Lcom/qiahao/nextvideo/data/model/GiftBannerData;Lcom/qiahao/nextvideo/databinding/GiftBannerView1Binding;)V", "LuserProxy/UserProxy1$GroupLuckyBagBanner;", "Lcom/qiahao/nextvideo/databinding/EnvelopeBannerBinding;", "Lcom/qiahao/base_common/model/svip/SvipData;", "svip", "refreshDefaultGift", "(LuserProxy/UserProxy1$GroupLuckyBagBanner;Lcom/qiahao/nextvideo/databinding/EnvelopeBannerBinding;Lcom/qiahao/base_common/model/svip/SvipData;)V", "bannerLevel", "setRoomRocketSrc", "(Ljava/lang/Integer;Lcom/qiahao/nextvideo/databinding/GiftBannerView1Binding;)V", "", "url", "playSVGA", "(Ljava/lang/String;Lcom/opensource/svgaplayer/SVGAImageView;)V", "playNetworkSVGA", "nobleLevel", "setIdBackGroup", "(ILcom/qiahao/nextvideo/databinding/GiftBannerView1Binding;I)V", "", "isContextValid", "()Z", "show", "hide", "hideImmediate", "onDetachedFromWindow", "Landroid/content/Context;", "isAnimation", "Z", "mSVGAImageView", "Lcom/opensource/svgaplayer/SVGAImageView;", "Lcom/opensource/svgaplayer/SVGACallback;", "mCallBack", "Lcom/opensource/svgaplayer/SVGACallback;", "Ljava/lang/Runnable;", "callback", "Ljava/lang/Runnable;", "Lcom/qiahao/nextvideo/ui/reusable/views/GfitBannerButtonListener;", "mListener", "Lcom/qiahao/nextvideo/ui/reusable/views/GfitBannerButtonListener;", "getMListener", "()Lcom/qiahao/nextvideo/ui/reusable/views/GfitBannerButtonListener;", "setMListener", "(Lcom/qiahao/nextvideo/ui/reusable/views/GfitBannerButtonListener;)V", "isShow", "setShow", "(Z)V", "mGroupId", "Ljava/lang/String;", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "(Ljava/lang/String;)V", "mHeight", "I", "getMHeight", "()I", "setMHeight", "(I)V", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "rocketBannerBinding", "Lcom/qiahao/nextvideo/databinding/GiftBannerView1Binding;", "envelopeBannerBinding", "Lcom/qiahao/nextvideo/databinding/EnvelopeBannerBinding;", "Lcom/opensource/svgaplayer/SVGAParser;", "parser$delegate", "Lkotlin/Lazy;", "getParser", "()Lcom/opensource/svgaplayer/SVGAParser;", "parser", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGiftBannerButtonView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GiftBannerButtonView.kt\ncom/qiahao/nextvideo/ui/reusable/views/GiftBannerButtonView\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,476:1\n61#2,9:477\n61#2,9:486\n*S KotlinDebug\n*F\n+ 1 GiftBannerButtonView.kt\ncom/qiahao/nextvideo/ui/reusable/views/GiftBannerButtonView\n*L\n308#1:477,9\n341#1:486,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GiftBannerButtonView extends LinearLayout {

    @NotNull
    private final Runnable callback;

    @NotNull
    private final nd.a compositeDisposable;

    @Nullable
    private EnvelopeBannerBinding envelopeBannerBinding;
    private boolean isAnimation;
    private boolean isShow;

    @Nullable
    private SVGACallback mCallBack;

    @NotNull
    private final Context mContext;

    @NotNull
    private String mGroupId;
    private int mHeight;

    @Nullable
    private GfitBannerButtonListener mListener;

    @Nullable
    private SVGAImageView mSVGAImageView;

    /* renamed from: parser$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy parser;

    @Nullable
    private GiftBannerView1Binding rocketBannerBinding;

    public /* synthetic */ GiftBannerButtonView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final void enterAnimator() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<GiftBannerButtonView, Float>) View.TRANSLATION_X, Dimens.INSTANCE.getScreenWidth(), 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.GiftBannerButtonView$enterAnimator$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                GiftBannerButtonView.this.isAnimation = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Runnable runnable;
                Intrinsics.checkNotNullParameter(animation, "animation");
                GiftBannerButtonView.this.isAnimation = false;
                GiftBannerButtonView giftBannerButtonView = GiftBannerButtonView.this;
                runnable = giftBannerButtonView.callback;
                giftBannerButtonView.removeCallbacks(runnable);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                GiftBannerButtonView.this.isAnimation = true;
            }
        });
        ofFloat.start();
    }

    private final SVGAParser getParser() {
        return (SVGAParser) this.parser.getValue();
    }

    private final void handleEnvelopeBanner(GiftBannerButtonData globalBean, FrameLayout.LayoutParams mLayoutParams) {
        Object data = globalBean.getData();
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type userProxy.UserProxy1.GroupLuckyBagBanner");
        UserProxy1.GroupLuckyBagBanner groupLuckyBagBanner = (UserProxy1.GroupLuckyBagBanner) data;
        this.mGroupId = groupLuckyBagBanner.getGroupId();
        MeetingRoomManager.INSTANCE.getMGiftBannerButtonList().remove(0);
        if (this.envelopeBannerBinding == null) {
            removeAllViews();
            EnvelopeBannerBinding inflate = EnvelopeBannerBinding.inflate(LayoutInflater.from(this.mContext), this, true);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            this.envelopeBannerBinding = inflate;
            SVGAImageView sVGAImageView = inflate.defaultSVGA;
            Intrinsics.checkNotNullExpressionValue(sVGAImageView, "defaultSVGA");
            initSVGA(sVGAImageView);
        }
        EnvelopeBannerBinding envelopeBannerBinding = this.envelopeBannerBinding;
        Intrinsics.checkNotNull(envelopeBannerBinding);
        envelopeBannerBinding.defaultLayout.setVisibility(0);
        Dimens dimens = Dimens.INSTANCE;
        mLayoutParams.width = dimens.dpToPx(241);
        mLayoutParams.height = dimens.dpToPx(57);
        mLayoutParams.topMargin = this.mHeight;
        mLayoutParams.gravity = 49;
        setLayoutParams(mLayoutParams);
        refreshDefaultGift(groupLuckyBagBanner, envelopeBannerBinding, globalBean.getSvip());
    }

    private final void handleRocketBanner(GiftBannerData data, FrameLayout.LayoutParams mLayoutParams) {
        this.mGroupId = data.getGroupId();
        MeetingRoomManager.INSTANCE.getMGiftBannerButtonList().remove(0);
        if (this.rocketBannerBinding == null) {
            removeAllViews();
            GiftBannerView1Binding inflate = GiftBannerView1Binding.inflate(LayoutInflater.from(this.mContext), this, true);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            this.rocketBannerBinding = inflate;
            SVGAImageView sVGAImageView = inflate.defaultSVGA;
            Intrinsics.checkNotNullExpressionValue(sVGAImageView, "defaultSVGA");
            initSVGA(sVGAImageView);
        }
        GiftBannerView1Binding giftBannerView1Binding = this.rocketBannerBinding;
        Intrinsics.checkNotNull(giftBannerView1Binding);
        giftBannerView1Binding.defaultLayout.setVisibility(0);
        Dimens dimens = Dimens.INSTANCE;
        mLayoutParams.width = dimens.dpToPx(231);
        mLayoutParams.height = dimens.dpToPx(59);
        mLayoutParams.topMargin = this.mHeight;
        mLayoutParams.gravity = 49;
        setLayoutParams(mLayoutParams);
        refreshRocketGift(data, giftBannerView1Binding);
    }

    private final void initSVGA(SVGAImageView svgaView) {
        SVGACallback sVGACallback = new SVGACallback() { // from class: com.qiahao.nextvideo.ui.reusable.views.GiftBannerButtonView$initSVGA$1
            public void onFinished() {
                GiftBannerButtonView.this.hide();
            }

            public void onPause() {
            }

            public void onRepeat() {
            }

            public void onStep(int frame, double percentage) {
            }
        };
        this.mCallBack = sVGACallback;
        svgaView.setCallback(sVGACallback);
        this.mSVGAImageView = svgaView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isContextValid() {
        Activity activity;
        Context context = this.mContext;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return false;
        }
        return true;
    }

    private final void leaveAnimator() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<GiftBannerButtonView, Float>) View.TRANSLATION_X, 0.0f, -Dimens.INSTANCE.getScreenWidth());
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new GiftBannerButtonView$leaveAnimator$1$1(this));
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SVGAParser parser_delegate$lambda$1() {
        return SVGAParser.Companion.shareParser();
    }

    private final void playNetworkSVGA(String url, final SVGAImageView svgaView) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        getParser().decodeFromURL(new URL(url), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.reusable.views.GiftBannerButtonView$playNetworkSVGA$1
            public void onComplete(SVGAVideoEntity videoItem) {
                boolean isContextValid;
                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                isContextValid = GiftBannerButtonView.this.isContextValid();
                if (!isContextValid) {
                    return;
                }
                svgaView.stopAnimation(true);
                svgaView.setImageDrawable(new SVGADrawable(videoItem));
                svgaView.startAnimation((SVGARange) null, true);
            }

            public void onError() {
            }
        });
    }

    private final void playSVGA(String url, final SVGAImageView svgaView) {
        if (StringsKt.isBlank(url)) {
            return;
        }
        getParser().decodeFromAssets(url, new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.reusable.views.GiftBannerButtonView$playSVGA$1
            public void onComplete(SVGAVideoEntity videoItem) {
                boolean isContextValid;
                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                isContextValid = GiftBannerButtonView.this.isContextValid();
                if (!isContextValid) {
                    return;
                }
                svgaView.stopAnimation(true);
                svgaView.setImageDrawable(new SVGADrawable(videoItem));
                svgaView.startAnimation((SVGARange) null, true);
            }

            public void onError() {
            }
        });
    }

    private final void refreshDefaultGift(UserProxy1.GroupLuckyBagBanner globalBean, EnvelopeBannerBinding binding, SvipData svip) {
        String str;
        binding.userCode.setBackgroundResource(R.drawable.shape_envelope_id);
        SVGAImageView sVGAImageView = binding.defaultSVGA;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView, "defaultSVGA");
        playSVGA("svga/envelope_banner.svga", sVGAImageView);
        final ConstraintLayout constraintLayout = binding.contentClick;
        final long j = 800;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.GiftBannerButtonView$refreshDefaultGift$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    this.toRoom();
                }
            }
        });
        AppCompatImageView appCompatImageView = binding.sendAvatar;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "sendAvatar");
        ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.image100(globalBean.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        TextView textView = binding.userName;
        String nick = globalBean.getNick();
        if (nick != null) {
            str = DataExternalKt.maxLengthSuffix(nick, 8, "...");
        } else {
            str = null;
        }
        textView.setText(str);
        TextView textView2 = binding.userCode;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        String code = globalBean.getCode();
        if (code == null) {
            code = "";
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{code}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView2.setText(format);
        if (svip != null && svip.isMystery()) {
            AppCompatImageView appCompatImageView2 = binding.sendAvatar;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "sendAvatar");
            ImageKtxKt.loadImage$default(appCompatImageView2, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            TextView textView3 = binding.userName;
            String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131953504), Arrays.copyOf(new Object[]{svip.mysteryNumber()}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            textView3.setText(format2);
            binding.userCode.setVisibility(8);
        }
        binding.contentText.setText(ResourcesKtxKt.getStringById(this, 2131954040));
        binding.diamond.setText(NumberUtilsKt.rankNumberFormat(globalBean.getDiamond()));
    }

    private final void refreshRocketGift(GiftBannerData globalBean, GiftBannerView1Binding binding) {
        int i;
        String str;
        Integer bannerLevel = globalBean.getBannerLevel();
        if (bannerLevel != null) {
            i = bannerLevel.intValue();
        } else {
            i = 1;
        }
        setIdBackGroup(i, binding, globalBean.getNobleLevel());
        String str2 = "";
        if (TextUtils.isEmpty(globalBean.getCustomEffectUrl())) {
            Integer bannerLevel2 = globalBean.getBannerLevel();
            String str3 = "svga/global_tip1.svga";
            if (bannerLevel2 == null || bannerLevel2.intValue() != 1) {
                if (bannerLevel2 != null && bannerLevel2.intValue() == 2) {
                    str3 = "svga/global_tip2.svga";
                } else if ((bannerLevel2 != null && bannerLevel2.intValue() == 3) || ((bannerLevel2 != null && bannerLevel2.intValue() == 4) || (bannerLevel2 != null && bannerLevel2.intValue() == 5))) {
                    str3 = "svga/global_tip3.svga";
                }
            }
            SVGAImageView sVGAImageView = binding.defaultSVGA;
            Intrinsics.checkNotNullExpressionValue(sVGAImageView, "defaultSVGA");
            playSVGA(str3, sVGAImageView);
        } else {
            String customEffectUrl = globalBean.getCustomEffectUrl();
            if (customEffectUrl == null) {
                customEffectUrl = "";
            }
            SVGAImageView sVGAImageView2 = binding.defaultSVGA;
            Intrinsics.checkNotNullExpressionValue(sVGAImageView2, "defaultSVGA");
            playNetworkSVGA(customEffectUrl, sVGAImageView2);
        }
        final ConstraintLayout constraintLayout = binding.contentClick;
        final long j = 800;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.GiftBannerButtonView$refreshRocketGift$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    this.toRoom();
                }
            }
        });
        AppCompatImageView appCompatImageView = binding.sendAvatar;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "sendAvatar");
        ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.image100(globalBean.getSendAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        TextView textView = binding.userName;
        String sendUserName = globalBean.getSendUserName();
        String str4 = null;
        if (sendUserName != null) {
            str = DataExternalKt.maxLengthSuffix(sendUserName, 8, "...");
        } else {
            str = null;
        }
        textView.setText(str);
        TextView textView2 = binding.userCode;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        String sendCode = globalBean.getSendCode();
        if (sendCode != null) {
            str2 = sendCode;
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str2}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView2.setText(format);
        SvipData svip = globalBean.getSvip();
        if (svip != null && svip.isMystery()) {
            AppCompatImageView appCompatImageView2 = binding.sendAvatar;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "sendAvatar");
            ImageKtxKt.loadImage$default(appCompatImageView2, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            TextView textView3 = binding.userName;
            String stringById2 = ResourcesKtxKt.getStringById(this, 2131953504);
            SvipData svip2 = globalBean.getSvip();
            if (svip2 != null) {
                str4 = svip2.mysteryNumber();
            }
            String format2 = String.format(stringById2, Arrays.copyOf(new Object[]{str4}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            textView3.setText(format2);
            binding.userCode.setVisibility(8);
        }
        binding.contentText.setText(ResourcesKtxKt.getStringById(this, 2131952135));
        binding.contentText.setGravity(3);
        setRoomRocketSrc(globalBean.getBannerLevel(), binding);
    }

    @SuppressLint({"SetTextI18n"})
    private final void refreshView(FrameLayout.LayoutParams mLayoutParams) {
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (meetingRoomManager.getMGiftBannerButtonList().isEmpty()) {
            hideImmediate();
            return;
        }
        GiftBannerButtonData giftBannerButtonData = meetingRoomManager.getMGiftBannerButtonList().get(0);
        Intrinsics.checkNotNullExpressionValue(giftBannerButtonData, "get(...)");
        GiftBannerButtonData giftBannerButtonData2 = giftBannerButtonData;
        String type = giftBannerButtonData2.getType();
        if (Intrinsics.areEqual(type, GiftBannerButtonData.BANNER_ENVELOPE)) {
            if (giftBannerButtonData2.getData() instanceof UserProxy1.GroupLuckyBagBanner) {
                handleEnvelopeBanner(giftBannerButtonData2, mLayoutParams);
            }
        } else if (Intrinsics.areEqual(type, GiftBannerButtonData.BANNER_ROCKET) && (giftBannerButtonData2.getData() instanceof GiftBannerData)) {
            Object data = giftBannerButtonData2.getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.GiftBannerData");
            handleRocketBanner((GiftBannerData) data, mLayoutParams);
        }
    }

    private final void setIdBackGroup(int bannerLevel, GiftBannerView1Binding binding, int nobleLevel) {
        int i;
        if (nobleLevel >= 7) {
            i = R.drawable.shape_global_id_noble7;
        } else {
            if (bannerLevel != 1) {
                if (bannerLevel == 2) {
                    i = R.drawable.shape_global_id_tip2;
                } else if (3 <= bannerLevel && bannerLevel < 6) {
                    i = R.drawable.shape_global_id_tip3;
                }
            }
            i = R.drawable.shape_global_id_tip1;
        }
        binding.userCode.setBackgroundResource(i);
    }

    static /* synthetic */ void setIdBackGroup$default(GiftBannerButtonView giftBannerButtonView, int i, GiftBannerView1Binding giftBannerView1Binding, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        giftBannerButtonView.setIdBackGroup(i, giftBannerView1Binding, i2);
    }

    private final void setRoomRocketSrc(Integer bannerLevel, GiftBannerView1Binding binding) {
        int i;
        if (bannerLevel != null && bannerLevel.intValue() == 1) {
            i = R.drawable.icon_rocket_small_green_panel;
        } else if (bannerLevel != null && bannerLevel.intValue() == 2) {
            i = R.drawable.icon_rocket_small_blue_panel;
        } else if (bannerLevel != null && bannerLevel.intValue() == 3) {
            i = R.drawable.icon_rocket_small_red_panel;
        } else if (bannerLevel != null && bannerLevel.intValue() == 4) {
            i = R.drawable.icon_rocket_small_purple_panel;
        } else if (bannerLevel != null && bannerLevel.intValue() == 5) {
            i = R.drawable.icon_rocket_small_orange_panel;
        } else {
            i = R.drawable.icon_rocket_green_global;
        }
        ImageView imageView = binding.giftPic;
        Intrinsics.checkNotNullExpressionValue(imageView, "giftPic");
        ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(i), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit show$lambda$4$lambda$3$lambda$2(GiftBannerButtonView giftBannerButtonView, int i, int i2) {
        int px;
        if (HiloUtils.INSTANCE.getActivity(giftBannerButtonView.mContext) instanceof RoomActivity) {
            px = UiKtxKt.toPX(60);
        } else {
            px = UiKtxKt.toPX(100);
        }
        giftBannerButtonView.mHeight = i + px;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toRoom() {
        GfitBannerButtonListener gfitBannerButtonListener;
        if (!this.isAnimation && this.mGroupId.length() > 0 && (gfitBannerButtonListener = this.mListener) != null) {
            gfitBannerButtonListener.openRoom(this.mGroupId, 1);
        }
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final int getMHeight() {
        return this.mHeight;
    }

    @Nullable
    public final GfitBannerButtonListener getMListener() {
        return this.mListener;
    }

    public final void hide() {
        if (this.isShow && isContextValid()) {
            leaveAnimator();
        }
    }

    public final void hideImmediate() {
        if (this.isShow) {
            this.isShow = false;
            if (!isContextValid()) {
                return;
            }
            try {
                Object obj = this.mContext;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.qiahao.nextvideo.app.base.HiloBaseActivity");
                FrameLayout container = ((HiloBaseActivity) obj).getContainer();
                if (container != null) {
                    container.removeView(this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: isShow, reason: from getter */
    public final boolean getIsShow() {
        return this.isShow;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.compositeDisposable.d();
        SVGAImageView sVGAImageView = this.mSVGAImageView;
        if (sVGAImageView != null) {
            sVGAImageView.clear();
        }
        this.mCallBack = null;
        removeCallbacks(this.callback);
        this.rocketBannerBinding = null;
        this.envelopeBannerBinding = null;
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void setMHeight(int i) {
        this.mHeight = i;
    }

    public final void setMListener(@Nullable GfitBannerButtonListener gfitBannerButtonListener) {
        this.mListener = gfitBannerButtonListener;
    }

    public final void setShow(boolean z) {
        this.isShow = z;
    }

    public final void show() {
        HiloBaseActivity hiloBaseActivity;
        FrameLayout container;
        if (this.isShow) {
            return;
        }
        this.isShow = true;
        if (!isContextValid()) {
            this.isShow = false;
            return;
        }
        try {
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (!meetingRoomManager.getMGiftBannerButtonList().isEmpty() && !meetingRoomManager.getMGiftBannerButtonList().get(0).checkSupportType()) {
                meetingRoomManager.getMGiftBannerButtonList().remove(0);
                this.isShow = false;
                show();
                return;
            }
            Object obj = this.mContext;
            if (obj instanceof HiloBaseActivity) {
                hiloBaseActivity = (HiloBaseActivity) obj;
            } else {
                hiloBaseActivity = null;
            }
            if (hiloBaseActivity != null && (container = hiloBaseActivity.getContainer()) != null) {
                container.addView(this);
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                FrameLayout container2 = ((HiloBaseActivity) this.mContext).getContainer();
                if (container2 != null) {
                    ((HiloBaseActivity) this.mContext).getStatusBarTopOrBottom(container2, new Function2() { // from class: com.qiahao.nextvideo.ui.reusable.views.b
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit show$lambda$4$lambda$3$lambda$2;
                            show$lambda$4$lambda$3$lambda$2 = GiftBannerButtonView.show$lambda$4$lambda$3$lambda$2(GiftBannerButtonView.this, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
                            return show$lambda$4$lambda$3$lambda$2;
                        }
                    });
                }
                enterAnimator();
                refreshView(layoutParams2);
            }
        } catch (Exception unused) {
            this.isShow = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GiftBannerButtonView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        this.callback = new Runnable() { // from class: com.qiahao.nextvideo.ui.reusable.views.c
            @Override // java.lang.Runnable
            public final void run() {
                GiftBannerButtonView.this.isAnimation = false;
            }
        };
        this.mGroupId = "";
        this.compositeDisposable = new nd.a();
        this.parser = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.reusable.views.d
            public final Object invoke() {
                SVGAParser parser_delegate$lambda$1;
                parser_delegate$lambda$1 = GiftBannerButtonView.parser_delegate$lambda$1();
                return parser_delegate$lambda$1;
            }
        });
    }
}
