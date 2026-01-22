package com.qiahao.nextvideo.ui.reusable.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RelationTypeUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseActivity;
import com.qiahao.nextvideo.data.model.GiftBannerData;
import com.qiahao.nextvideo.databinding.GiftBannerView1Binding;
import com.qiahao.nextvideo.databinding.GiftBannerView2Binding;
import com.qiahao.nextvideo.databinding.GiftBannerView3Binding;
import com.qiahao.nextvideo.databinding.GiftBannerView4Binding;
import com.qiahao.nextvideo.databinding.GiftBannerView5Binding;
import com.qiahao.nextvideo.databinding.GiftBannerView6Binding;
import com.qiahao.nextvideo.room.activity.RoomActivity;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import userProxy.UserProxy;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00107\u001a\u000208H\u0002J\u0006\u00109\u001a\u000208J\b\u0010:\u001a\u000208H\u0002J\b\u0010;\u001a\u000208H\u0002J\u0010\u0010<\u001a\u0002082\u0006\u0010=\u001a\u00020\rH\u0002J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020@H\u0003J \u0010A\u001a\u0002082\u0006\u0010B\u001a\u00020@2\u0006\u0010C\u001a\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0002J\u0018\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u000200H\u0003J\u0018\u0010I\u001a\u0002082\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020&H\u0002J\u0018\u0010J\u001a\u0002082\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020.H\u0002J\u0018\u0010K\u001a\u0002082\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020*H\u0002J\u0018\u0010L\u001a\u0002082\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020,H\u0002J\u0018\u0010M\u001a\u0002082\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020(H\u0003J\u0018\u0010N\u001a\u0002082\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020&H\u0002J\u0010\u0010O\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020GH\u0002J\u0018\u0010Q\u001a\u0002082\u0006\u0010R\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\rH\u0002J\u0018\u0010S\u001a\u0002082\u0006\u0010R\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\rH\u0002J\u001f\u0010T\u001a\u0002082\b\u0010U\u001a\u0004\u0018\u00010\u00072\u0006\u0010H\u001a\u00020&H\u0002¢\u0006\u0002\u0010VJ\"\u0010W\u001a\u0002082\u0006\u0010U\u001a\u00020\u00072\u0006\u0010H\u001a\u00020&2\b\b\u0002\u0010X\u001a\u00020\u0007H\u0002J\u0018\u0010Y\u001a\u0002082\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020&H\u0003J\u0006\u0010Z\u001a\u000208J\u0006\u0010[\u001a\u000208J\b\u0010\\\u001a\u00020\u000bH\u0002J\b\u0010]\u001a\u000208H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b3\u00104¨\u0006^"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/GlobalTipSvga2;", "Landroid/widget/LinearLayout;", "mContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isAnimation", "", "mSVGAImageView", "Lcom/opensource/svgaplayer/SVGAImageView;", "mCallBack", "Lcom/opensource/svgaplayer/SVGACallback;", "mListener", "Lcom/qiahao/nextvideo/ui/reusable/views/GlobalTipSvgaListener;", "getMListener", "()Lcom/qiahao/nextvideo/ui/reusable/views/GlobalTipSvgaListener;", "setMListener", "(Lcom/qiahao/nextvideo/ui/reusable/views/GlobalTipSvgaListener;)V", "isShow", "()Z", "setShow", "(Z)V", "mGroupId", "", "getMGroupId", "()Ljava/lang/String;", "setMGroupId", "(Ljava/lang/String;)V", "mHeight", "getMHeight", "()I", "setMHeight", "(I)V", "bannerView1Binding", "Lcom/qiahao/nextvideo/databinding/GiftBannerView1Binding;", "bannerView2Binding", "Lcom/qiahao/nextvideo/databinding/GiftBannerView2Binding;", "bannerView3Binding", "Lcom/qiahao/nextvideo/databinding/GiftBannerView3Binding;", "bannerView4Binding", "Lcom/qiahao/nextvideo/databinding/GiftBannerView4Binding;", "bannerView5Binding", "Lcom/qiahao/nextvideo/databinding/GiftBannerView5Binding;", "bannerView6Binding", "Lcom/qiahao/nextvideo/databinding/GiftBannerView6Binding;", "parser", "Lcom/opensource/svgaplayer/SVGAParser;", "getParser", "()Lcom/opensource/svgaplayer/SVGAParser;", "parser$delegate", "Lkotlin/Lazy;", "toRoom", "", "show", "enterAnimator", "leaveAnimator", "initSVGA", "svgaView", "refreshView", "mLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "configureLayoutParams", "params", "widthDp", "heightDp", "countryMsg", "globalBean", "Lcom/qiahao/nextvideo/data/model/GiftBannerData;", "binding", "pkBanner", "refreshSVIPUpgrades", "refreshCpUpgrades", "refreshNewCp", "refreshCp", "refreshDefaultGift", "getSvgaUrl", "data", "playSVGA", "url", "playNetworkSVGA", "setRoomRocketSrc", "bannerLevel", "(Ljava/lang/Integer;Lcom/qiahao/nextvideo/databinding/GiftBannerView1Binding;)V", "setIdBackGroup", "nobleLevel", "changeLayoutShow", "hide", "hideImmediate", "isContextValid", "onDetachedFromWindow", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGlobalTipSvga2.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GlobalTipSvga2.kt\ncom/qiahao/nextvideo/ui/reusable/views/GlobalTipSvga2\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 Color.kt\nandroidx/core/graphics/ColorKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,875:1\n61#2,9:876\n61#2,9:887\n61#2,9:898\n61#2,9:910\n61#2,9:921\n61#2,9:930\n61#2,9:941\n439#3:885\n439#3:886\n439#3:896\n439#3:897\n439#3:908\n439#3:909\n439#3:919\n439#3:920\n439#3:939\n439#3:940\n439#3:950\n439#3:951\n439#3:952\n439#3:953\n439#3:954\n439#3:955\n1#4:907\n*S KotlinDebug\n*F\n+ 1 GlobalTipSvga2.kt\ncom/qiahao/nextvideo/ui/reusable/views/GlobalTipSvga2\n*L\n364#1:876,9\n393#1:887,9\n416#1:898,9\n451#1:910,9\n483#1:921,9\n508#1:930,9\n566#1:941,9\n376#1:885\n377#1:886\n401#1:896\n402#1:897\n438#1:908\n439#1:909\n472#1:919\n473#1:920\n550#1:939\n551#1:940\n780#1:950\n781#1:951\n786#1:952\n787#1:953\n799#1:954\n800#1:955\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GlobalTipSvga2 extends LinearLayout {

    @Nullable
    private GiftBannerView1Binding bannerView1Binding;

    @Nullable
    private GiftBannerView2Binding bannerView2Binding;

    @Nullable
    private GiftBannerView3Binding bannerView3Binding;

    @Nullable
    private GiftBannerView4Binding bannerView4Binding;

    @Nullable
    private GiftBannerView5Binding bannerView5Binding;

    @Nullable
    private GiftBannerView6Binding bannerView6Binding;
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
    private GlobalTipSvgaListener mListener;

    @Nullable
    private SVGAImageView mSVGAImageView;

    /* renamed from: parser$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy parser;

    public /* synthetic */ GlobalTipSvga2(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @SuppressLint({"SetTextI18n"})
    private final void changeLayoutShow(GiftBannerData globalBean, GiftBannerView1Binding binding) {
        String str;
        String maxLengthSuffix;
        String str2 = "";
        binding.contentText.setText("");
        int type = globalBean.getType();
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    binding.contentText.setText("");
                    return;
                }
                binding.contentText.setText(ResourcesKtxKt.getStringById(this, 2131952135));
                binding.contentText.setGravity(3);
                setRoomRocketSrc(globalBean.getBannerLevel(), binding);
                return;
            }
            String str3 = "x" + globalBean.getDiamond();
            binding.contentText.setText(ResourcesKtxKt.getStringById(this, 2131954505) + " " + str3);
            binding.contentText.setGravity(17);
            TextView textView = binding.contentText;
            Intrinsics.checkNotNullExpressionValue(textView, "contentText");
            ViewUtilitiesKt.setTargetTextColor(textView, str3, Color.parseColor("#ffffff"), Color.parseColor("#fff165"));
            ImageView imageView = binding.giftPic;
            Intrinsics.checkNotNullExpressionValue(imageView, "giftPic");
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_global_roulette), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            return;
        }
        String str4 = "x" + globalBean.getGiftNum();
        String receiverUserName = globalBean.getReceiverUserName();
        if (receiverUserName != null && (maxLengthSuffix = DataExternalKt.maxLengthSuffix(receiverUserName, 8, "...")) != null) {
            str2 = maxLengthSuffix;
        }
        SvipData receiveSvip = globalBean.getReceiveSvip();
        if (receiveSvip != null && receiveSvip.isMystery()) {
            String stringById = ResourcesKtxKt.getStringById(this, 2131953504);
            SvipData receiveSvip2 = globalBean.getReceiveSvip();
            if (receiveSvip2 != null) {
                str = receiveSvip2.mysteryNumber();
            } else {
                str = null;
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            str2 = DataExternalKt.maxLengthSuffix(format, 8, "...");
        }
        TextView textView2 = binding.contentText;
        String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131952905), Arrays.copyOf(new Object[]{str2, str4}, 2));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        textView2.setText(format2);
        TextView textView3 = binding.contentText;
        Intrinsics.checkNotNullExpressionValue(textView3, "contentText");
        ViewUtilitiesKt.setTargetTextColor(textView3, str4, Color.parseColor("#ffffff"), Color.parseColor("#fff165"));
        binding.contentText.setGravity(3);
        TextView textView4 = binding.contentText;
        Intrinsics.checkNotNullExpressionValue(textView4, "contentText");
        ViewUtilitiesKt.setTargetTextColor(textView4, str2, Color.parseColor("#ffffff"), Color.parseColor("#fff165"));
        ImageView imageView2 = binding.giftPic;
        Intrinsics.checkNotNullExpressionValue(imageView2, "giftPic");
        ImageKtxKt.loadImage$default(imageView2, ImageSizeKt.image100(globalBean.getGiftUrl()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
    }

    private final void configureLayoutParams(FrameLayout.LayoutParams params, int widthDp, int heightDp) {
        Dimens dimens = Dimens.INSTANCE;
        params.width = dimens.dpToPx(widthDp);
        params.height = dimens.dpToPx(heightDp);
        params.topMargin = this.mHeight;
        params.gravity = 49;
        setLayoutParams(params);
    }

    @SuppressLint({"SetTextI18n"})
    private final void countryMsg(GiftBannerData globalBean, GiftBannerView6Binding binding) {
        String str;
        String maxLengthSuffix;
        if (globalBean.getOtherData() instanceof UserProxy1.GlobalCountryMgrBanner) {
            Object otherData = globalBean.getOtherData();
            Intrinsics.checkNotNull(otherData, "null cannot be cast to non-null type userProxy.UserProxy1.GlobalCountryMgrBanner");
            final UserProxy1.GlobalCountryMgrBanner globalCountryMgrBanner = (UserProxy1.GlobalCountryMgrBanner) otherData;
            String str2 = "";
            this.mGroupId = "";
            final SVGAImageView sVGAImageView = binding.countrySVGA;
            final long j = 800;
            sVGAImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.GlobalTipSvga2$countryMsg$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(sVGAImageView) > j || (sVGAImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(sVGAImageView, currentTimeMillis);
                        SVGAImageView sVGAImageView2 = sVGAImageView;
                        AppService service = AppController.INSTANCE.getService();
                        if (service != null) {
                            String externalId = globalCountryMgrBanner.getUser().getExternalId();
                            Intrinsics.checkNotNullExpressionValue(externalId, "getExternalId(...)");
                            service.openPersonPage(externalId);
                        }
                    }
                }
            });
            String svgaUrl = getSvgaUrl(globalBean);
            SVGAImageView sVGAImageView2 = binding.countrySVGA;
            Intrinsics.checkNotNullExpressionValue(sVGAImageView2, "countrySVGA");
            playSVGA(svgaUrl, sVGAImageView2);
            QMUIRadiusImageView qMUIRadiusImageView = binding.avatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
            UserProxy.User user = globalCountryMgrBanner.getUser();
            if (user != null) {
                str = user.getAvatar();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            String nick = globalCountryMgrBanner.getUser().getNick();
            if (nick != null && (maxLengthSuffix = DataExternalKt.maxLengthSuffix(nick, 8, "...")) != null) {
                str2 = maxLengthSuffix;
            }
            binding.nickName.setText(str2 + " " + ResourcesKtxKt.getStringById(this, 2131954179));
            TextView textView = binding.nickName;
            Intrinsics.checkNotNullExpressionValue(textView, "nickName");
            ViewUtilitiesKt.setTargetTextColor(textView, str2, Color.parseColor("#FFAD65"), Color.parseColor("#FFF165"));
            binding.content.setText(ResourcesKtxKt.getStringById(this, 2131952306));
        }
    }

    private final void enterAnimator() {
        if (this.isAnimation) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<GlobalTipSvga2, Float>) View.TRANSLATION_X, Dimens.INSTANCE.getScreenWidth(), 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.GlobalTipSvga2$enterAnimator$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                GlobalTipSvga2.this.isAnimation = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                GlobalTipSvga2.this.isAnimation = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                GlobalTipSvga2.this.isAnimation = true;
            }
        });
        ofFloat.start();
    }

    private final SVGAParser getParser() {
        return (SVGAParser) this.parser.getValue();
    }

    private final String getSvgaUrl(GiftBannerData data) {
        Integer bannerType = data.getBannerType();
        if (bannerType != null && bannerType.intValue() == 0) {
            if (data.getNobleLevel() == 7) {
                return "svga/noble_7.svga";
            }
            if (data.getNobleLevel() == 8) {
                return "svga/noble_8.svga";
            }
            if (data.getNobleLevel() == 9) {
                return "svga/noble_9.svga";
            }
            if (data.getNobleLevel() >= 10) {
                return "svga/noble_10.svga";
            }
            Integer bannerLevel = data.getBannerLevel();
            if (bannerLevel != null && bannerLevel.intValue() == 1) {
                return "svga/global_tip1.svga";
            }
            if (bannerLevel != null && bannerLevel.intValue() == 2) {
                return "svga/global_tip2.svga";
            }
            if (bannerLevel == null || bannerLevel.intValue() != 3) {
                return "svga/global_tip1.svga";
            }
            return "svga/global_tip3.svga";
        }
        if (bannerType != null && bannerType.intValue() == 1) {
            Integer cpLevel = data.getCpLevel();
            if (cpLevel != null && cpLevel.intValue() == 1) {
                return "svga/cp_banner1.svga";
            }
            if (cpLevel != null && cpLevel.intValue() == 2) {
                return "svga/cp_banner2.svga";
            }
            if (cpLevel != null && cpLevel.intValue() == 3) {
                return "svga/cp_banner3.svga";
            }
            if (cpLevel != null && cpLevel.intValue() == 4) {
                return "svga/cp_banner4.svga";
            }
            if (cpLevel != null && cpLevel.intValue() == 5) {
                return "svga/cp_banner5.svga";
            }
            if (cpLevel != null && cpLevel.intValue() == 6) {
                return "svga/cp_banner6.svga";
            }
            if (cpLevel == null) {
                return "svga/cp_banner7.svga";
            }
            cpLevel.intValue();
            return "svga/cp_banner7.svga";
        }
        if (bannerType != null && bannerType.intValue() == 3) {
            Integer cpLevel2 = data.getCpLevel();
            if (cpLevel2 != null && cpLevel2.intValue() == 1) {
                return "svga/soul_banner1.svga";
            }
            if (cpLevel2 != null && cpLevel2.intValue() == 2) {
                return "svga/soul_banner2.svga";
            }
            if (cpLevel2 != null && cpLevel2.intValue() == 3) {
                return "svga/soul_banner3.svga";
            }
            if (cpLevel2 != null && cpLevel2.intValue() == 4) {
                return "svga/soul_banner4.svga";
            }
            if (cpLevel2 != null && cpLevel2.intValue() == 5) {
                return "svga/soul_banner5.svga";
            }
            if (cpLevel2 != null && cpLevel2.intValue() == 6) {
                return "svga/soul_banner6.svga";
            }
            if (cpLevel2 == null) {
                return "svga/soul_banner7.svga";
            }
            cpLevel2.intValue();
            return "svga/soul_banner7.svga";
        }
        if (bannerType != null && bannerType.intValue() == 4) {
            Integer cpLevel3 = data.getCpLevel();
            if (cpLevel3 != null && cpLevel3.intValue() == 1) {
                return "svga/bestie_banner1.svga";
            }
            if (cpLevel3 != null && cpLevel3.intValue() == 2) {
                return "svga/bestie_banner2.svga";
            }
            if (cpLevel3 != null && cpLevel3.intValue() == 3) {
                return "svga/bestie_banner3.svga";
            }
            if (cpLevel3 != null && cpLevel3.intValue() == 4) {
                return "svga/bestie_banner4.svga";
            }
            if (cpLevel3 != null && cpLevel3.intValue() == 5) {
                return "svga/bestie_banner5.svga";
            }
            if (cpLevel3 != null && cpLevel3.intValue() == 6) {
                return "svga/bestie_banner6.svga";
            }
            if (cpLevel3 == null) {
                return "svga/bestie_banner7.svga";
            }
            cpLevel3.intValue();
            return "svga/bestie_banner7.svga";
        }
        if (bannerType != null && bannerType.intValue() == 5) {
            Integer cpLevel4 = data.getCpLevel();
            if (cpLevel4 != null && cpLevel4.intValue() == 1) {
                return "svga/brother_banner1.svga";
            }
            if (cpLevel4 != null && cpLevel4.intValue() == 2) {
                return "svga/brother_banner2.svga";
            }
            if (cpLevel4 != null && cpLevel4.intValue() == 3) {
                return "svga/brother_banner3.svga";
            }
            if (cpLevel4 != null && cpLevel4.intValue() == 4) {
                return "svga/brother_banner4.svga";
            }
            if (cpLevel4 != null && cpLevel4.intValue() == 5) {
                return "svga/brother_banner5.svga";
            }
            if (cpLevel4 != null && cpLevel4.intValue() == 6) {
                return "svga/brother_banner6.svga";
            }
            if (cpLevel4 == null) {
                return "svga/brother_banner7.svga";
            }
            cpLevel4.intValue();
            return "svga/brother_banner7.svga";
        }
        if (bannerType != null && bannerType.intValue() == 2) {
            return "svga/cp_new.svga";
        }
        if (bannerType != null && bannerType.intValue() == 100) {
            return "svga/cp_upgrades.svga";
        }
        if (bannerType != null && bannerType.intValue() == 101) {
            Object otherData = data.getOtherData();
            Intrinsics.checkNotNull(otherData, "null cannot be cast to non-null type userProxy.UserProxy1.SvipUpgrade");
            switch (((UserProxy1.SvipUpgrade) otherData).getSvipLevel()) {
                case 3:
                    return "svga/gift_svip3.svga";
                case 4:
                    return "svga/gift_svip4.svga";
                case 5:
                    return "svga/gift_svip5.svga";
                case 6:
                    return "svga/gift_svip6.svga";
                case 7:
                    return "svga/gift_svip7.svga";
                case 8:
                    return "svga/gift_svip8.svga";
                case 9:
                    return "svga/gift_svip9.svga";
                case 10:
                    return "svga/gift_svip10.svga";
                case 11:
                default:
                    return "svga/gift_svip11.svga";
            }
        }
        if (bannerType != null && bannerType.intValue() == 102) {
            return "svga/country_msg.svga";
        }
        if (bannerType == null || bannerType.intValue() != 103) {
            return "svga/global_tip1.svga";
        }
        return "svga/pk_banner.svga";
    }

    private final void initSVGA(SVGAImageView svgaView) {
        SVGACallback sVGACallback = new SVGACallback() { // from class: com.qiahao.nextvideo.ui.reusable.views.GlobalTipSvga2$initSVGA$1
            public void onFinished() {
                GlobalTipSvga2.this.hide();
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
        try {
            Context context = this.mContext;
            if (context instanceof Activity) {
                activity = (Activity) context;
            } else {
                activity = null;
            }
            if (activity == null || activity.isDestroyed()) {
                return false;
            }
            if (activity.isFinishing()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private final void leaveAnimator() {
        if (this.isAnimation) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, (Property<GlobalTipSvga2, Float>) View.TRANSLATION_X, 0.0f, -Dimens.INSTANCE.getScreenWidth());
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addListener(new GlobalTipSvga2$leaveAnimator$1$1(this));
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SVGAParser parser_delegate$lambda$0() {
        return SVGAParser.Companion.shareParser();
    }

    private final void pkBanner(GiftBannerData globalBean, GiftBannerView1Binding binding) {
        int i;
        String str;
        if (globalBean.getOtherData() instanceof UserProxy1.GroupPkWinBanner) {
            Object otherData = globalBean.getOtherData();
            Intrinsics.checkNotNull(otherData, "null cannot be cast to non-null type userProxy.UserProxy1.GroupPkWinBanner");
            UserProxy1.GroupPkWinBanner groupPkWinBanner = (UserProxy1.GroupPkWinBanner) otherData;
            this.mGroupId = groupPkWinBanner.getGroupId();
            Integer bannerLevel = globalBean.getBannerLevel();
            if (bannerLevel != null) {
                i = bannerLevel.intValue();
            } else {
                i = 1;
            }
            setIdBackGroup(i, binding, globalBean.getNobleLevel());
            String svgaUrl = getSvgaUrl(globalBean);
            SVGAImageView sVGAImageView = binding.defaultSVGA;
            Intrinsics.checkNotNullExpressionValue(sVGAImageView, "defaultSVGA");
            playSVGA(svgaUrl, sVGAImageView);
            final ConstraintLayout constraintLayout = binding.contentClick;
            final long j = 800;
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.GlobalTipSvga2$pkBanner$$inlined$singleClick$default$1
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
            ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.image100(groupPkWinBanner.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            ImageView imageView = binding.giftPic;
            Intrinsics.checkNotNullExpressionValue(imageView, "giftPic");
            ImageKtxKt.loadImage$default(imageView, ImageSizeKt.image100(groupPkWinBanner.getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            binding.userName.setTextColor(Color.parseColor("#FFF165"));
            binding.contentText.setTextColor(Color.parseColor("#FFF165"));
            binding.contentText.setText(ResourcesKtxKt.getStringById(this, 2131953650));
            TextView textView = binding.userName;
            String nick = groupPkWinBanner.getNick();
            if (nick != null) {
                str = DataExternalKt.maxLengthSuffix(nick, 8, "...");
            } else {
                str = null;
            }
            textView.setText(str);
            TextView textView2 = binding.userCode;
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{groupPkWinBanner.getCode()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView2.setText(format);
        }
    }

    private final void playNetworkSVGA(String url, final SVGAImageView svgaView) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        getParser().decodeFromURL(new URL(url), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.reusable.views.GlobalTipSvga2$playNetworkSVGA$1
            public void onComplete(SVGAVideoEntity videoItem) {
                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                svgaView.stopAnimation(true);
                svgaView.setImageDrawable(new SVGADrawable(videoItem));
                svgaView.startAnimation((SVGARange) null, true);
            }

            public void onError() {
            }
        });
    }

    private final void playSVGA(String url, final SVGAImageView svgaView) {
        getParser().decodeFromAssets(url, new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.reusable.views.GlobalTipSvga2$playSVGA$1
            public void onComplete(SVGAVideoEntity videoItem) {
                Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                svgaView.stopAnimation(true);
                svgaView.setImageDrawable(new SVGADrawable(videoItem));
                svgaView.startAnimation((SVGARange) null, true);
            }

            public void onError() {
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    private final void refreshCp(GiftBannerData globalBean, GiftBannerView2Binding binding) {
        String str;
        int i;
        int i2;
        String maxLengthSuffix;
        String str2 = "";
        if (TextUtils.isEmpty(globalBean.getCustomEffectUrl())) {
            String svgaUrl = getSvgaUrl(globalBean);
            SVGAImageView sVGAImageView = binding.cpGiftSVGA;
            Intrinsics.checkNotNullExpressionValue(sVGAImageView, "cpGiftSVGA");
            playSVGA(svgaUrl, sVGAImageView);
        } else {
            String customEffectUrl = globalBean.getCustomEffectUrl();
            if (customEffectUrl == null) {
                customEffectUrl = "";
            }
            SVGAImageView sVGAImageView2 = binding.cpGiftSVGA;
            Intrinsics.checkNotNullExpressionValue(sVGAImageView2, "cpGiftSVGA");
            playNetworkSVGA(customEffectUrl, sVGAImageView2);
        }
        final SVGAImageView sVGAImageView3 = binding.cpGiftSVGA;
        final long j = 800;
        sVGAImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.GlobalTipSvga2$refreshCp$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(sVGAImageView3) > j || (sVGAImageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(sVGAImageView3, currentTimeMillis);
                    SVGAImageView sVGAImageView4 = sVGAImageView3;
                    this.toRoom();
                }
            }
        });
        QMUIRadiusImageView qMUIRadiusImageView = binding.leftAvatar1;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "leftAvatar1");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(globalBean.getSendAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        QMUIRadiusImageView qMUIRadiusImageView2 = binding.rightAvatar1;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "rightAvatar1");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(globalBean.getReceiveUserAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        TextView textView = binding.name1;
        String sendUserName = globalBean.getSendUserName();
        Drawable drawable = null;
        if (sendUserName != null) {
            str = DataExternalKt.maxLengthSuffix(sendUserName, 8, "...");
        } else {
            str = null;
        }
        textView.setText(str);
        TextView textView2 = binding.id1;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        String sendCode = globalBean.getSendCode();
        if (sendCode == null) {
            sendCode = "";
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{sendCode}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView2.setText(format);
        binding.giftNumber1.setText("x" + globalBean.getGiftNum());
        Integer bannerType = globalBean.getBannerType();
        if (bannerType != null) {
            i = bannerType.intValue();
        } else {
            i = 0;
        }
        if (i != 1) {
            i2 = 3;
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        i2 = 0;
                    } else {
                        i2 = 4;
                    }
                }
            } else {
                i2 = 2;
            }
        } else {
            i2 = 1;
        }
        RelationTypeUtils relationTypeUtils = RelationTypeUtils.INSTANCE;
        String relationIDColor = relationTypeUtils.getRelationIDColor(globalBean.getCpLevel(), i2);
        binding.id1.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, relationIDColor, relationIDColor, 8, (GradientDrawable.Orientation) null, 8, (Object) null));
        String receiverUserName = globalBean.getReceiverUserName();
        if (receiverUserName != null && (maxLengthSuffix = DataExternalKt.maxLengthSuffix(receiverUserName, 8, "...")) != null) {
            str2 = maxLengthSuffix;
        }
        ImageView imageView = binding.gift1;
        Intrinsics.checkNotNullExpressionValue(imageView, "gift1");
        ImageKtxKt.loadImage$default(imageView, ImageSizeKt.image100(globalBean.getGiftUrl()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        ImageView imageView2 = binding.cpModel1;
        Integer relationMedal$default = RelationTypeUtils.getRelationMedal$default(relationTypeUtils, globalBean.getCpLevel(), false, i2, 2, (Object) null);
        if (relationMedal$default != null) {
            drawable = androidx.core.content.a.getDrawable(binding.cpModel1.getContext(), relationMedal$default.intValue());
        }
        imageView2.setImageDrawable(drawable);
        TextView textView3 = binding.content1;
        String format2 = String.format(ResourcesKtxKt.getStringById(this, relationTypeUtils.relationText(i2)), Arrays.copyOf(new Object[]{str2}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
        textView3.setText(format2);
        TextView textView4 = binding.content1;
        Intrinsics.checkNotNullExpressionValue(textView4, "content1");
        ViewUtilitiesKt.setTargetTextColor(textView4, str2, Color.parseColor("#ffffff"), Color.parseColor("#fff165"));
    }

    private final void refreshCpUpgrades(GiftBannerData globalBean, GiftBannerView3Binding binding) {
        String str;
        String str2;
        String str3;
        String str4;
        Drawable drawable;
        String nick;
        String nick2;
        if (globalBean.getOtherData() instanceof UserProxy1.CpUpgrade) {
            Object otherData = globalBean.getOtherData();
            Intrinsics.checkNotNull(otherData, "null cannot be cast to non-null type userProxy.UserProxy1.CpUpgrade");
            UserProxy1.CpUpgrade cpUpgrade = (UserProxy1.CpUpgrade) otherData;
            this.mGroupId = cpUpgrade.getGroupId();
            final SVGAImageView sVGAImageView = binding.cpUpgradesSVGA;
            final long j = 800;
            sVGAImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.GlobalTipSvga2$refreshCpUpgrades$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(sVGAImageView) > j || (sVGAImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(sVGAImageView, currentTimeMillis);
                        SVGAImageView sVGAImageView2 = sVGAImageView;
                        this.toRoom();
                    }
                }
            });
            SVGAImageView sVGAImageView2 = binding.cpUpgradesSVGA;
            Intrinsics.checkNotNullExpressionValue(sVGAImageView2, "cpUpgradesSVGA");
            playSVGA("svga/cp_upgrades.svga", sVGAImageView2);
            QMUIRadiusImageView qMUIRadiusImageView = binding.leftAvatar2;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "leftAvatar2");
            UserProxy.User user1 = cpUpgrade.getUser1();
            if (user1 != null) {
                str = user1.getAvatar();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            QMUIRadiusImageView qMUIRadiusImageView2 = binding.rightAvatar2;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "rightAvatar2");
            UserProxy.User user2 = cpUpgrade.getUser2();
            if (user2 != null) {
                str2 = user2.getAvatar();
            } else {
                str2 = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(str2), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            TextView textView = binding.leftName2;
            UserProxy.User user12 = cpUpgrade.getUser1();
            if (user12 != null && (nick2 = user12.getNick()) != null) {
                str3 = DataExternalKt.maxLengthSuffix(nick2, 8, "...");
            } else {
                str3 = null;
            }
            textView.setText(str3);
            TextView textView2 = binding.rightName2;
            UserProxy.User user22 = cpUpgrade.getUser2();
            if (user22 != null && (nick = user22.getNick()) != null) {
                str4 = DataExternalKt.maxLengthSuffix(nick, 8, "...");
            } else {
                str4 = null;
            }
            textView2.setText(str4);
            ImageView imageView = binding.model2;
            RelationTypeUtils relationTypeUtils = RelationTypeUtils.INSTANCE;
            Integer relationMedal$default = RelationTypeUtils.getRelationMedal$default(relationTypeUtils, Integer.valueOf(cpUpgrade.getCpLevel()), false, 0, 6, (Object) null);
            if (relationMedal$default != null) {
                drawable = androidx.core.content.a.getDrawable(binding.model2.getContext(), relationMedal$default.intValue());
            } else {
                drawable = null;
            }
            imageView.setImageDrawable(drawable);
            String relationTitle$default = RelationTypeUtils.getRelationTitle$default(relationTypeUtils, Integer.valueOf(cpUpgrade.getCpLevel()), 0, 2, (Object) null);
            if (relationTitle$default == null) {
                relationTitle$default = "";
            }
            TextView textView3 = binding.content2;
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131952401), Arrays.copyOf(new Object[]{relationTitle$default}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView3.setText(format);
            TextView textView4 = binding.content2;
            Intrinsics.checkNotNullExpressionValue(textView4, "content2");
            ViewUtilitiesKt.setTargetTextColor(textView4, relationTitle$default, Color.parseColor("#ffffff"), Color.parseColor("#fff165"));
        }
    }

    private final void refreshDefaultGift(GiftBannerData globalBean, GiftBannerView1Binding binding) {
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
            String svgaUrl = getSvgaUrl(globalBean);
            SVGAImageView sVGAImageView = binding.defaultSVGA;
            Intrinsics.checkNotNullExpressionValue(sVGAImageView, "defaultSVGA");
            playSVGA(svgaUrl, sVGAImageView);
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
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.GlobalTipSvga2$refreshDefaultGift$$inlined$singleClick$default$1
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
        String str3 = null;
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
                str3 = svip2.mysteryNumber();
            }
            String format2 = String.format(stringById2, Arrays.copyOf(new Object[]{str3}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            textView3.setText(format2);
            binding.userCode.setVisibility(8);
        }
        changeLayoutShow(globalBean, binding);
    }

    private final void refreshNewCp(GiftBannerData globalBean, GiftBannerView4Binding binding) {
        String str;
        SVGAImageView sVGAImageView = binding.cpNewSVGA;
        Intrinsics.checkNotNullExpressionValue(sVGAImageView, "cpNewSVGA");
        playSVGA("svga/cp_new.svga", sVGAImageView);
        final SVGAImageView sVGAImageView2 = binding.cpNewSVGA;
        final long j = 800;
        sVGAImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.GlobalTipSvga2$refreshNewCp$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(sVGAImageView2) > j || (sVGAImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(sVGAImageView2, currentTimeMillis);
                    SVGAImageView sVGAImageView3 = sVGAImageView2;
                    this.toRoom();
                }
            }
        });
        QMUIRadiusImageView qMUIRadiusImageView = binding.leftAvatar3;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "leftAvatar3");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(globalBean.getSendAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        QMUIRadiusImageView qMUIRadiusImageView2 = binding.rightAvatar3;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "rightAvatar3");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(globalBean.getReceiveUserAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        TextView textView = binding.leftName3;
        String sendUserName = globalBean.getSendUserName();
        String str2 = null;
        if (sendUserName != null) {
            str = DataExternalKt.maxLengthSuffix(sendUserName, 8, "...");
        } else {
            str = null;
        }
        textView.setText(str);
        TextView textView2 = binding.rightName3;
        String receiverUserName = globalBean.getReceiverUserName();
        if (receiverUserName != null) {
            str2 = DataExternalKt.maxLengthSuffix(receiverUserName, 8, "...");
        }
        textView2.setText(str2);
    }

    private final void refreshSVIPUpgrades(GiftBannerData globalBean, GiftBannerView5Binding binding) {
        String str;
        Drawable drawable;
        if (globalBean.getOtherData() instanceof UserProxy1.SvipUpgrade) {
            Object otherData = globalBean.getOtherData();
            Intrinsics.checkNotNull(otherData, "null cannot be cast to non-null type userProxy.UserProxy1.SvipUpgrade");
            UserProxy1.SvipUpgrade svipUpgrade = (UserProxy1.SvipUpgrade) otherData;
            this.mGroupId = svipUpgrade.getGroupId();
            final SVGAImageView sVGAImageView = binding.svipUpgradesSVGA;
            final long j = 800;
            sVGAImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.reusable.views.GlobalTipSvga2$refreshSVIPUpgrades$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(sVGAImageView) > j || (sVGAImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(sVGAImageView, currentTimeMillis);
                        SVGAImageView sVGAImageView2 = sVGAImageView;
                        this.toRoom();
                    }
                }
            });
            String svgaUrl = getSvgaUrl(globalBean);
            SVGAImageView sVGAImageView2 = binding.svipUpgradesSVGA;
            Intrinsics.checkNotNullExpressionValue(sVGAImageView2, "svipUpgradesSVGA");
            playSVGA(svgaUrl, sVGAImageView2);
            QMUIRadiusImageView qMUIRadiusImageView = binding.avatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
            UserProxy.User user = svipUpgrade.getUser();
            String str2 = null;
            if (user != null) {
                str = user.getAvatar();
            } else {
                str = null;
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            Integer svipType = svipTypeUtils.getSvipType(Integer.valueOf(svipUpgrade.getSvipLevel()));
            if (svipType != null) {
                int intValue = svipType.intValue();
                ImageView imageView = binding.svipType;
                Context context = imageView.getContext();
                if (context != null) {
                    drawable = androidx.core.content.a.getDrawable(context, intValue);
                } else {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
            }
            TextView textView = binding.nickName;
            String nick = svipUpgrade.getUser().getNick();
            if (nick != null) {
                str2 = DataExternalKt.maxLengthSuffix(nick, 8, "...");
            }
            textView.setText(str2);
            Integer svipMedal = svipTypeUtils.getSvipMedal(Integer.valueOf(svipUpgrade.getSvipLevel()));
            if (svipMedal != null) {
                binding.model.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), svipMedal.intValue()));
            }
            String str3 = "SVIP" + svipUpgrade.getSvipLevel();
            TextView textView2 = binding.content;
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131954214), Arrays.copyOf(new Object[]{str3}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView2.setText(format);
            TextView textView3 = binding.content;
            Intrinsics.checkNotNullExpressionValue(textView3, "content");
            ViewUtilitiesKt.setTargetTextColor(textView3, str3, Color.parseColor("#ffffff"), Color.parseColor("#fff165"));
        }
    }

    @SuppressLint({"SetTextI18n"})
    private final void refreshView(FrameLayout.LayoutParams mLayoutParams) {
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        if (!meetingRoomManager.getMReceiverGlobalGiftSvgaList().isEmpty()) {
            GiftBannerData giftBannerData = meetingRoomManager.getMReceiverGlobalGiftSvgaList().get(0);
            Intrinsics.checkNotNullExpressionValue(giftBannerData, "get(...)");
            GiftBannerData giftBannerData2 = giftBannerData;
            this.mGroupId = giftBannerData2.getGroupId();
            meetingRoomManager.getMReceiverGlobalGiftSvgaList().remove(0);
            Integer bannerType = giftBannerData2.getBannerType();
            if (bannerType != null && bannerType.intValue() == 0) {
                if (this.bannerView1Binding == null) {
                    removeAllViews();
                    GiftBannerView1Binding inflate = GiftBannerView1Binding.inflate(LayoutInflater.from(this.mContext), this, true);
                    Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
                    this.bannerView1Binding = inflate;
                    SVGAImageView sVGAImageView = inflate.defaultSVGA;
                    Intrinsics.checkNotNullExpressionValue(sVGAImageView, "defaultSVGA");
                    initSVGA(sVGAImageView);
                }
                GiftBannerView1Binding giftBannerView1Binding = this.bannerView1Binding;
                Intrinsics.checkNotNull(giftBannerView1Binding);
                giftBannerView1Binding.defaultLayout.setVisibility(0);
                configureLayoutParams(mLayoutParams, 231, 59);
                refreshDefaultGift(giftBannerData2, giftBannerView1Binding);
                return;
            }
            if ((bannerType == null || bannerType.intValue() != 1) && ((bannerType == null || bannerType.intValue() != 3) && ((bannerType == null || bannerType.intValue() != 4) && (bannerType == null || bannerType.intValue() != 5)))) {
                if (bannerType != null && bannerType.intValue() == 100) {
                    if (this.bannerView3Binding == null) {
                        removeAllViews();
                        GiftBannerView3Binding inflate2 = GiftBannerView3Binding.inflate(LayoutInflater.from(this.mContext), this, true);
                        Intrinsics.checkNotNullExpressionValue(inflate2, "inflate(...)");
                        this.bannerView3Binding = inflate2;
                        SVGAImageView sVGAImageView2 = inflate2.cpUpgradesSVGA;
                        Intrinsics.checkNotNullExpressionValue(sVGAImageView2, "cpUpgradesSVGA");
                        initSVGA(sVGAImageView2);
                    }
                    GiftBannerView3Binding giftBannerView3Binding = this.bannerView3Binding;
                    Intrinsics.checkNotNull(giftBannerView3Binding);
                    configureLayoutParams(mLayoutParams, 279, 73);
                    refreshCpUpgrades(giftBannerData2, giftBannerView3Binding);
                    return;
                }
                if (bannerType != null && bannerType.intValue() == 2) {
                    if (this.bannerView4Binding == null) {
                        removeAllViews();
                        GiftBannerView4Binding inflate3 = GiftBannerView4Binding.inflate(LayoutInflater.from(this.mContext), this, true);
                        Intrinsics.checkNotNullExpressionValue(inflate3, "inflate(...)");
                        this.bannerView4Binding = inflate3;
                        SVGAImageView sVGAImageView3 = inflate3.cpNewSVGA;
                        Intrinsics.checkNotNullExpressionValue(sVGAImageView3, "cpNewSVGA");
                        initSVGA(sVGAImageView3);
                    }
                    GiftBannerView4Binding giftBannerView4Binding = this.bannerView4Binding;
                    Intrinsics.checkNotNull(giftBannerView4Binding);
                    configureLayoutParams(mLayoutParams, 279, 73);
                    refreshNewCp(giftBannerData2, giftBannerView4Binding);
                    return;
                }
                if (bannerType != null && bannerType.intValue() == 101) {
                    if (this.bannerView5Binding == null) {
                        removeAllViews();
                        GiftBannerView5Binding inflate4 = GiftBannerView5Binding.inflate(LayoutInflater.from(this.mContext), this, true);
                        Intrinsics.checkNotNullExpressionValue(inflate4, "inflate(...)");
                        this.bannerView5Binding = inflate4;
                        SVGAImageView sVGAImageView4 = inflate4.svipUpgradesSVGA;
                        Intrinsics.checkNotNullExpressionValue(sVGAImageView4, "svipUpgradesSVGA");
                        initSVGA(sVGAImageView4);
                    }
                    GiftBannerView5Binding giftBannerView5Binding = this.bannerView5Binding;
                    Intrinsics.checkNotNull(giftBannerView5Binding);
                    configureLayoutParams(mLayoutParams, 232, 56);
                    refreshSVIPUpgrades(giftBannerData2, giftBannerView5Binding);
                    return;
                }
                if (bannerType != null && bannerType.intValue() == 102) {
                    if (this.bannerView6Binding == null) {
                        removeAllViews();
                        GiftBannerView6Binding inflate5 = GiftBannerView6Binding.inflate(LayoutInflater.from(this.mContext), this, true);
                        Intrinsics.checkNotNullExpressionValue(inflate5, "inflate(...)");
                        this.bannerView6Binding = inflate5;
                        SVGAImageView sVGAImageView5 = inflate5.countrySVGA;
                        Intrinsics.checkNotNullExpressionValue(sVGAImageView5, "countrySVGA");
                        initSVGA(sVGAImageView5);
                    }
                    GiftBannerView6Binding giftBannerView6Binding = this.bannerView6Binding;
                    Intrinsics.checkNotNull(giftBannerView6Binding);
                    configureLayoutParams(mLayoutParams, 241, 58);
                    countryMsg(giftBannerData2, giftBannerView6Binding);
                    return;
                }
                if (bannerType != null && bannerType.intValue() == 103) {
                    if (this.bannerView1Binding == null) {
                        removeAllViews();
                        GiftBannerView1Binding inflate6 = GiftBannerView1Binding.inflate(LayoutInflater.from(this.mContext), this, true);
                        Intrinsics.checkNotNullExpressionValue(inflate6, "inflate(...)");
                        this.bannerView1Binding = inflate6;
                        SVGAImageView sVGAImageView6 = inflate6.defaultSVGA;
                        Intrinsics.checkNotNullExpressionValue(sVGAImageView6, "defaultSVGA");
                        initSVGA(sVGAImageView6);
                    }
                    GiftBannerView1Binding giftBannerView1Binding2 = this.bannerView1Binding;
                    Intrinsics.checkNotNull(giftBannerView1Binding2);
                    giftBannerView1Binding2.defaultLayout.setVisibility(0);
                    configureLayoutParams(mLayoutParams, 231, 59);
                    pkBanner(giftBannerData2, giftBannerView1Binding2);
                    return;
                }
                return;
            }
            if (this.bannerView2Binding == null) {
                removeAllViews();
                GiftBannerView2Binding inflate7 = GiftBannerView2Binding.inflate(LayoutInflater.from(this.mContext), this, true);
                Intrinsics.checkNotNullExpressionValue(inflate7, "inflate(...)");
                this.bannerView2Binding = inflate7;
                SVGAImageView sVGAImageView7 = inflate7.cpGiftSVGA;
                Intrinsics.checkNotNullExpressionValue(sVGAImageView7, "cpGiftSVGA");
                initSVGA(sVGAImageView7);
            }
            GiftBannerView2Binding giftBannerView2Binding = this.bannerView2Binding;
            Intrinsics.checkNotNull(giftBannerView2Binding);
            configureLayoutParams(mLayoutParams, 279, 73);
            refreshCp(giftBannerData2, giftBannerView2Binding);
            return;
        }
        hideImmediate();
    }

    private final void setIdBackGroup(int bannerLevel, GiftBannerView1Binding binding, int nobleLevel) {
        int i = R.drawable.shape_global_id_tip1;
        if (bannerLevel != 1) {
            if (bannerLevel != 2) {
                if (bannerLevel == 3) {
                    i = R.drawable.shape_global_id_tip3;
                }
            } else {
                i = R.drawable.shape_global_id_tip2;
            }
        }
        if (nobleLevel >= 7 && nobleLevel < 10) {
            i = R.drawable.shape_global_id_noble7;
        } else if (nobleLevel >= 10) {
            i = R.drawable.shape_global_id_noble10;
        }
        binding.userCode.setBackgroundResource(i);
    }

    static /* synthetic */ void setIdBackGroup$default(GlobalTipSvga2 globalTipSvga2, int i, GiftBannerView1Binding giftBannerView1Binding, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        globalTipSvga2.setIdBackGroup(i, giftBannerView1Binding, i2);
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
    public static final Unit show$lambda$2$lambda$1(GlobalTipSvga2 globalTipSvga2, int i, int i2) {
        if (HiloUtils.INSTANCE.getActivity(globalTipSvga2.mContext) instanceof RoomActivity) {
            globalTipSvga2.mHeight = i;
        } else {
            globalTipSvga2.mHeight = i + UiKtxKt.toPX(40);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toRoom() {
        GlobalTipSvgaListener globalTipSvgaListener;
        if (!this.isAnimation && this.mGroupId.length() > 0 && (globalTipSvgaListener = this.mListener) != null) {
            globalTipSvgaListener.openRoom(this.mGroupId, 1);
        }
    }

    @NotNull
    public final String getMGroupId() {
        return this.mGroupId;
    }

    public final int getMHeight() {
        return this.mHeight;
    }

    @Nullable
    public final GlobalTipSvgaListener getMListener() {
        return this.mListener;
    }

    public final void hide() {
        if (!this.isShow || !isContextValid()) {
            return;
        }
        try {
            leaveAnimator();
        } catch (Exception unused) {
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
            } catch (Exception unused) {
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
        SVGAImageView sVGAImageView = this.mSVGAImageView;
        if (sVGAImageView != null) {
            sVGAImageView.clear();
        }
        this.mCallBack = null;
        this.bannerView1Binding = null;
        this.bannerView2Binding = null;
        this.bannerView3Binding = null;
        this.bannerView4Binding = null;
        this.bannerView5Binding = null;
        this.bannerView6Binding = null;
    }

    public final void setMGroupId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mGroupId = str;
    }

    public final void setMHeight(int i) {
        this.mHeight = i;
    }

    public final void setMListener(@Nullable GlobalTipSvgaListener globalTipSvgaListener) {
        this.mListener = globalTipSvgaListener;
    }

    public final void setShow(boolean z) {
        this.isShow = z;
    }

    public final void show() {
        if (this.isShow) {
            return;
        }
        this.isShow = true;
        try {
            if (!isContextValid()) {
                this.isShow = false;
                return;
            }
            MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
            if (!meetingRoomManager.getMReceiverGlobalGiftSvgaList().isEmpty() && !meetingRoomManager.getMReceiverGlobalGiftSvgaList().get(0).checkSupportType()) {
                meetingRoomManager.getMReceiverGlobalGiftSvgaList().remove(0);
                this.isShow = false;
                show();
                return;
            }
            Object obj = this.mContext;
            if ((obj instanceof HiloBaseActivity) && ((HiloBaseActivity) obj).getContainer() != null) {
                FrameLayout container = ((HiloBaseActivity) this.mContext).getContainer();
                if (container != null) {
                    container.addView(this);
                }
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                FrameLayout container2 = ((HiloBaseActivity) this.mContext).getContainer();
                if (container2 != null) {
                    ((HiloBaseActivity) this.mContext).getStatusBarTopOrBottom(container2, new Function2() { // from class: com.qiahao.nextvideo.ui.reusable.views.g
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit show$lambda$2$lambda$1;
                            show$lambda$2$lambda$1 = GlobalTipSvga2.show$lambda$2$lambda$1(GlobalTipSvga2.this, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
                            return show$lambda$2$lambda$1;
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
    public GlobalTipSvga2(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "mContext");
        this.mContext = context;
        this.mGroupId = "";
        this.parser = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.reusable.views.f
            public final Object invoke() {
                SVGAParser parser_delegate$lambda$0;
                parser_delegate$lambda$0 = GlobalTipSvga2.parser_delegate$lambda$0();
                return parser_delegate$lambda$0;
            }
        });
    }
}
