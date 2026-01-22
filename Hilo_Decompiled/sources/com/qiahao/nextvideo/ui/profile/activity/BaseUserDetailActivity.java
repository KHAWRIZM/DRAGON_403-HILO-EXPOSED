package com.qiahao.nextvideo.ui.profile.activity;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.google.android.gms.common.util.Strings;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGADynamicEntity;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.SpannableTextBuilder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qhqc.core.feature.community.ui.fragment.PostsSquareFragment;
import com.qiahao.base_common.adapter.CommonFragmentStatePagerAdapter;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.common.CountryManager;
import com.qiahao.base_common.model.common.HeadWearBean;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.RideBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.player.combination.queue.LightQueueCombinationPlayer;
import com.qiahao.base_common.player.vap.VapMediaSource;
import com.qiahao.base_common.player.video.VideoMediaSource;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.ViewUtilsKt;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.CountryIDView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import com.qiahao.nextvideo.data.model.UserPictureResponseBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ActivityUserDetailBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.ui.profile.PhotoViewPagerAdapter;
import com.qiahao.nextvideo.ui.profile.PhotoViewPagerBean;
import com.qiahao.nextvideo.ui.profile.PhotoViewSmallAdapter;
import com.qiahao.nextvideo.ui.profile.PhotoViewSmallAdapter1;
import com.qiahao.nextvideo.ui.profile.activity.UserInfoEditActivity;
import com.qiahao.nextvideo.utilities.DataExternalKt;
import com.qiahao.nextvideo.utilities.GiftHelp;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import com.zhpan.bannerview.BannerViewPager;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001tB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J+\u0010\u000f\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0012\u0010\u0004J\u000f\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\r\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\b\u0017\u0010\u0004J\u0019\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001f\u001a\u00020\u00052\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u0005H\u0014¢\u0006\u0004\b!\u0010\u0004J\u000f\u0010\"\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\"\u0010\u0004J\u000f\u0010#\u001a\u00020\u0005H\u0016¢\u0006\u0004\b#\u0010\u0004J\u000f\u0010$\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010\u0004J\u000f\u0010%\u001a\u00020\u0005H\u0016¢\u0006\u0004\b%\u0010\u0004R$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010.\u001a\u0004\u0018\u00010-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R0\u0010=\u001a\u0010\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u0005\u0018\u00010;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR&\u0010F\u001a\u0012\u0012\u0004\u0012\u00020D0Cj\b\u0012\u0004\u0012\u00020D`E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR2\u0010H\u001a\u0012\u0012\u0004\u0012\u00020\u001d0Cj\b\u0012\u0004\u0012\u00020\u001d`E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010G\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR$\u0010M\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010\u001bR(\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00070R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001e\u0010[\u001a\n\u0012\u0004\u0012\u00020Z\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\"\u0010^\u001a\u00020]8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u001b\u0010i\u001a\u00020d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR\u001b\u0010n\u001a\u00020j8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bk\u0010f\u001a\u0004\bl\u0010mR\u001b\u0010s\u001a\u00020o8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bp\u0010f\u001a\u0004\bq\u0010r¨\u0006u"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/activity/BaseUserDetailActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityUserDetailBinding;", "<init>", "()V", "", "initView", "", "svgaUrl", "playSvipSvga", "(Ljava/lang/String;)V", "getUserCarAndPlayer", "effectUrl", "senderAvatar", "receiverAvatar", "playCar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "playSvga", "initPhotoView", "", "getLayoutResId", "()I", "onInitialize", "getUserPhotoData", "Lcom/qiahao/base_common/model/common/User;", "user", "refreshView", "(Lcom/qiahao/base_common/model/common/User;)V", "", "Lcom/qiahao/nextvideo/data/model/UserPictureResponseBean;", "list", "updatePhotoViewData", "(Ljava/util/List;)V", "onResume", "onDestroy", "reportImageViewPressed", "chatImageViewPressed", "likedImageViewPressed", "Lcom/qiahao/nextvideo/ui/profile/activity/ProfileFragment;", "mProfileFragment", "Lcom/qiahao/nextvideo/ui/profile/activity/ProfileFragment;", "getMProfileFragment", "()Lcom/qiahao/nextvideo/ui/profile/activity/ProfileFragment;", "setMProfileFragment", "(Lcom/qiahao/nextvideo/ui/profile/activity/ProfileFragment;)V", "Lcom/qiahao/nextvideo/ui/profile/activity/PropsFragment;", "mPropsFragment", "Lcom/qiahao/nextvideo/ui/profile/activity/PropsFragment;", "getMPropsFragment", "()Lcom/qiahao/nextvideo/ui/profile/activity/PropsFragment;", "setMPropsFragment", "(Lcom/qiahao/nextvideo/ui/profile/activity/PropsFragment;)V", "Lcom/qhqc/core/feature/community/ui/fragment/PostsSquareFragment;", "momentFragment", "Lcom/qhqc/core/feature/community/ui/fragment/PostsSquareFragment;", "getMomentFragment", "()Lcom/qhqc/core/feature/community/ui/fragment/PostsSquareFragment;", "setMomentFragment", "(Lcom/qhqc/core/feature/community/ui/fragment/PostsSquareFragment;)V", "Lkotlin/Function1;", "", "showPostBtnOrNot", "Lkotlin/jvm/functions/Function1;", "getShowPostBtnOrNot", "()Lkotlin/jvm/functions/Function1;", "setShowPostBtnOrNot", "(Lkotlin/jvm/functions/Function1;)V", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "mFragmentList", "Ljava/util/ArrayList;", "picList", "getPicList", "()Ljava/util/ArrayList;", "setPicList", "(Ljava/util/ArrayList;)V", "uiModel", "Lcom/qiahao/base_common/model/common/User;", "getUiModel", "()Lcom/qiahao/base_common/model/common/User;", "setUiModel", "", "mTypeList", "[Ljava/lang/String;", "getMTypeList", "()[Ljava/lang/String;", "setMTypeList", "([Ljava/lang/String;)V", "Lcom/zhpan/bannerview/BannerViewPager;", "Lcom/qiahao/nextvideo/ui/profile/PhotoViewPagerBean;", "mViewPager", "Lcom/zhpan/bannerview/BannerViewPager;", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/ui/profile/PhotoViewPagerAdapter;", "photoViewPagerAdapter$delegate", "Lkotlin/Lazy;", "getPhotoViewPagerAdapter", "()Lcom/qiahao/nextvideo/ui/profile/PhotoViewPagerAdapter;", "photoViewPagerAdapter", "Lcom/qiahao/nextvideo/ui/profile/PhotoViewSmallAdapter;", "photoViewSmallAdapter$delegate", "getPhotoViewSmallAdapter", "()Lcom/qiahao/nextvideo/ui/profile/PhotoViewSmallAdapter;", "photoViewSmallAdapter", "Lcom/qiahao/nextvideo/ui/profile/PhotoViewSmallAdapter1;", "photoViewSmallAdapter1$delegate", "getPhotoViewSmallAdapter1", "()Lcom/qiahao/nextvideo/ui/profile/PhotoViewSmallAdapter1;", "photoViewSmallAdapter1", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nBaseUserDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BaseUserDetailActivity.kt\ncom/qiahao/nextvideo/ui/profile/activity/BaseUserDetailActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,754:1\n1#2:755\n61#3,9:756\n61#3,9:765\n61#3,9:774\n61#3,9:783\n61#3,9:792\n61#3,9:801\n61#3,9:810\n1869#4,2:819\n*S KotlinDebug\n*F\n+ 1 BaseUserDetailActivity.kt\ncom/qiahao/nextvideo/ui/profile/activity/BaseUserDetailActivity\n*L\n189#1:756,9\n262#1:765,9\n263#1:774,9\n264#1:783,9\n265#1:792,9\n266#1:801,9\n275#1:810,9\n704#1:819,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class BaseUserDetailActivity extends HiloBaseBindingActivity<ActivityUserDetailBinding> {

    @NotNull
    public static final String TAG = "UserInformation";

    @NotNull
    public static final String USER = "user";

    @Nullable
    private ProfileFragment mProfileFragment;

    @Nullable
    private PropsFragment mPropsFragment;

    @Nullable
    private BannerViewPager<PhotoViewPagerBean> mViewPager;

    @Nullable
    private PostsSquareFragment momentFragment;

    @Nullable
    private Function1<? super Boolean, Unit> showPostBtnOrNot;

    @Nullable
    private User uiModel;

    @NotNull
    private ArrayList<Fragment> mFragmentList = new ArrayList<>();

    @NotNull
    private ArrayList<UserPictureResponseBean> picList = new ArrayList<>();

    @NotNull
    private String[] mTypeList = {ResourcesKtxKt.getStringById(this, 2131953721), ResourcesKtxKt.getStringById(this, 2131953729), ResourcesKtxKt.getStringById(this, 2131953413)};

    @NotNull
    private nd.a compositeDisposable = new nd.a();

    /* renamed from: photoViewPagerAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy photoViewPagerAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.profile.activity.b
        public final Object invoke() {
            PhotoViewPagerAdapter photoViewPagerAdapter_delegate$lambda$0;
            photoViewPagerAdapter_delegate$lambda$0 = BaseUserDetailActivity.photoViewPagerAdapter_delegate$lambda$0();
            return photoViewPagerAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: photoViewSmallAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy photoViewSmallAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.profile.activity.c
        public final Object invoke() {
            PhotoViewSmallAdapter photoViewSmallAdapter_delegate$lambda$1;
            photoViewSmallAdapter_delegate$lambda$1 = BaseUserDetailActivity.photoViewSmallAdapter_delegate$lambda$1();
            return photoViewSmallAdapter_delegate$lambda$1;
        }
    });

    /* renamed from: photoViewSmallAdapter1$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy photoViewSmallAdapter1 = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.profile.activity.d
        public final Object invoke() {
            PhotoViewSmallAdapter1 photoViewSmallAdapter1_delegate$lambda$2;
            photoViewSmallAdapter1_delegate$lambda$2 = BaseUserDetailActivity.photoViewSmallAdapter1_delegate$lambda$2();
            return photoViewSmallAdapter1_delegate$lambda$2;
        }
    });

    private final PhotoViewPagerAdapter getPhotoViewPagerAdapter() {
        return (PhotoViewPagerAdapter) this.photoViewPagerAdapter.getValue();
    }

    private final PhotoViewSmallAdapter getPhotoViewSmallAdapter() {
        return (PhotoViewSmallAdapter) this.photoViewSmallAdapter.getValue();
    }

    private final PhotoViewSmallAdapter1 getPhotoViewSmallAdapter1() {
        return (PhotoViewSmallAdapter1) this.photoViewSmallAdapter1.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void getUserCarAndPlayer() {
        User user;
        RideBean ride;
        String senderAvatar;
        String str;
        User user2;
        User user3;
        RideBean ride2;
        User user4;
        String str2;
        User user5;
        User user6;
        RideBean ride3;
        String effectUrl;
        RideBean ride4;
        String effectUrl2;
        RideBean ride5;
        RideBean ride6;
        String receiverAvatar;
        RideBean ride7;
        String senderAvatar2;
        User user7;
        RideBean ride8;
        User user8 = this.uiModel;
        if (user8 == null || (ride8 = user8.getRide()) == null || ride8.getId() != 0) {
            try {
                User user9 = this.uiModel;
                String str3 = "";
                if (user9 == null || (ride7 = user9.getRide()) == null || (senderAvatar2 = ride7.getSenderAvatar()) == null || senderAvatar2.length() != 0 ? !((user = this.uiModel) == null || (ride = user.getRide()) == null || (senderAvatar = ride.getSenderAvatar()) == null) : !((user7 = this.uiModel) == null || (senderAvatar = user7.getAvatar()) == null)) {
                    str = senderAvatar;
                    user2 = this.uiModel;
                    if (user2 != null || (ride6 = user2.getRide()) == null || (receiverAvatar = ride6.getReceiverAvatar()) == null || receiverAvatar.length() != 0) {
                        user3 = this.uiModel;
                        if (user3 == null && (ride2 = user3.getRide()) != null) {
                            str3 = ride2.getReceiverAvatar();
                        } else {
                            str3 = null;
                        }
                        Intrinsics.checkNotNull(str3);
                    }
                    String str4 = str3;
                    user4 = this.uiModel;
                    if (user4 == null && (ride5 = user4.getRide()) != null) {
                        str2 = ride5.getEffectUrl();
                    } else {
                        str2 = null;
                    }
                    GiftDateItem chatToGift$default = DataExternalKt.chatToGift$default(str2, str, str4, null, null, null, null, 120, null);
                    user5 = this.uiModel;
                    if (user5 == null && (ride4 = user5.getRide()) != null && (effectUrl2 = ride4.getEffectUrl()) != null && StringKtxKt.checkEndSVGA(effectUrl2)) {
                        ((ActivityUserDetailBinding) getBinding()).queuePlayer.addQueue(GiftHelp.INSTANCE.getSVGAData(chatToGift$default));
                        return;
                    }
                    user6 = this.uiModel;
                    if (user6 == null && (ride3 = user6.getRide()) != null && (effectUrl = ride3.getEffectUrl()) != null && StringKtxKt.checkEndMP4(effectUrl)) {
                        GiftHelp.INSTANCE.getVAP2(chatToGift$default, LifecycleOwnerKt.getLifecycleScope(this), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.e
                            public final Object invoke(Object obj) {
                                Unit userCarAndPlayer$lambda$28;
                                userCarAndPlayer$lambda$28 = BaseUserDetailActivity.getUserCarAndPlayer$lambda$28(BaseUserDetailActivity.this, (VapMediaSource) obj);
                                return userCarAndPlayer$lambda$28;
                            }
                        }, this);
                        return;
                    }
                    return;
                }
                str = "";
                user2 = this.uiModel;
                if (user2 != null) {
                }
                user3 = this.uiModel;
                if (user3 == null) {
                }
                str3 = null;
                Intrinsics.checkNotNull(str3);
                String str42 = str3;
                user4 = this.uiModel;
                if (user4 == null) {
                }
                str2 = null;
                GiftDateItem chatToGift$default2 = DataExternalKt.chatToGift$default(str2, str, str42, null, null, null, null, 120, null);
                user5 = this.uiModel;
                if (user5 == null) {
                }
                user6 = this.uiModel;
                if (user6 == null) {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getUserCarAndPlayer$lambda$28(BaseUserDetailActivity baseUserDetailActivity, VapMediaSource vapMediaSource) {
        Intrinsics.checkNotNullParameter(vapMediaSource, "it");
        baseUserDetailActivity.getBinding().queuePlayer.addQueue(vapMediaSource);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getUserPhotoData$lambda$26(BaseUserDetailActivity baseUserDetailActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        baseUserDetailActivity.getBinding().refreshLayout.finishRefresh();
        List<UserPictureResponseBean> list = (List) apiResponse.getData();
        if (list != null) {
            baseUserDetailActivity.picList.clear();
            baseUserDetailActivity.picList.addAll(list);
            baseUserDetailActivity.updatePhotoViewData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit getUserPhotoData$lambda$27(BaseUserDetailActivity baseUserDetailActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        ((ActivityUserDetailBinding) baseUserDetailActivity.getBinding()).refreshLayout.finishRefresh();
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = baseUserDetailActivity.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(localizedMessage, "getString(...)");
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, baseUserDetailActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initPhotoView() {
        List list;
        int i;
        int i2;
        List medalInfo;
        List subList;
        List list2;
        boolean z;
        int i3;
        List medalInfo2;
        List medalInfo3;
        List medalInfo4;
        BannerViewPager<PhotoViewPagerBean> bannerViewPager = ((ActivityUserDetailBinding) getBinding()).viewpagerPhoto;
        Intrinsics.checkNotNull(bannerViewPager, "null cannot be cast to non-null type com.zhpan.bannerview.BannerViewPager<com.qiahao.nextvideo.ui.profile.PhotoViewPagerBean>");
        this.mViewPager = bannerViewPager;
        if (bannerViewPager != null) {
            bannerViewPager.G(getPhotoViewPagerAdapter());
            bannerViewPager.g();
        }
        RecyclerView recyclerView = ((ActivityUserDetailBinding) getBinding()).recyclerSmallPhoto;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(this, 0, false));
        recyclerView.setAdapter(getPhotoViewSmallAdapter());
        Intrinsics.checkNotNull(recyclerView);
        ViewUtilsKt.addItemDecoration(recyclerView, 8.0f, 2.0f);
        RecyclerView recyclerView2 = ((ActivityUserDetailBinding) getBinding()).recyclerSmallPhoto;
        User user = this.uiModel;
        List list3 = null;
        if (user != null) {
            list = user.getMedalInfo();
        } else {
            list = null;
        }
        int i4 = 8;
        if (list != null && !list.isEmpty()) {
            i = 0;
        } else {
            i = 8;
        }
        recyclerView2.setVisibility(i);
        PhotoViewSmallAdapter photoViewSmallAdapter = getPhotoViewSmallAdapter();
        User user2 = this.uiModel;
        if (user2 != null && (medalInfo4 = user2.getMedalInfo()) != null) {
            i2 = medalInfo4.size();
        } else {
            i2 = 0;
        }
        if (i2 <= 8) {
            User user3 = this.uiModel;
            if (user3 != null) {
                subList = user3.getMedalInfo();
            }
            subList = null;
        } else {
            User user4 = this.uiModel;
            if (user4 != null && (medalInfo = user4.getMedalInfo()) != null) {
                subList = medalInfo.subList(0, 8);
            }
            subList = null;
        }
        photoViewSmallAdapter.setList(subList);
        RecyclerView recyclerView3 = ((ActivityUserDetailBinding) getBinding()).recyclerSmallPhoto1;
        recyclerView3.setAdapter(getPhotoViewSmallAdapter1());
        Intrinsics.checkNotNull(recyclerView3);
        ViewUtilsKt.addItemDecoration(recyclerView3, 4.0f, 2.0f);
        RecyclerView recyclerView4 = ((ActivityUserDetailBinding) getBinding()).recyclerSmallPhoto1;
        User user5 = this.uiModel;
        if (user5 != null) {
            list2 = user5.getMedalInfo();
        } else {
            list2 = null;
        }
        if (list2 != null && !list2.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            i4 = 0;
        }
        recyclerView4.setVisibility(i4);
        PhotoViewSmallAdapter1 photoViewSmallAdapter1 = getPhotoViewSmallAdapter1();
        User user6 = this.uiModel;
        if (user6 != null && (medalInfo3 = user6.getMedalInfo()) != null) {
            i3 = medalInfo3.size();
        } else {
            i3 = 0;
        }
        if (i3 <= 10) {
            User user7 = this.uiModel;
            if (user7 != null) {
                list3 = user7.getMedalInfo();
            }
        } else {
            User user8 = this.uiModel;
            if (user8 != null && (medalInfo2 = user8.getMedalInfo()) != null) {
                list3 = medalInfo2.subList(0, 10);
            }
        }
        photoViewSmallAdapter1.setList(list3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        long j;
        User parcelableExtra = getIntent().getParcelableExtra("user");
        this.uiModel = parcelableExtra;
        if (parcelableExtra == null) {
            finish();
        }
        setStatusBarIconColor(false);
        FrameLayout frameLayout = ((ActivityUserDetailBinding) getBinding()).activityMainContainer;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "activityMainContainer");
        getStatusBarTopOrBottom(frameLayout, new Function2() { // from class: com.qiahao.nextvideo.ui.profile.activity.a
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$5;
                initView$lambda$5 = BaseUserDetailActivity.initView$lambda$5(BaseUserDetailActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$5;
            }
        });
        if (this.mProfileFragment == null) {
            Bundle bundle = new Bundle();
            bundle.putParcelable("user", this.uiModel);
            Fragment profileFragment = new ProfileFragment();
            profileFragment.setArguments(bundle);
            this.mProfileFragment = profileFragment;
            this.mFragmentList.add(profileFragment);
        }
        if (this.mPropsFragment == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("user", this.uiModel);
            Fragment propsFragment = new PropsFragment();
            propsFragment.setArguments(bundle2);
            propsFragment.setMListener(new Function3() { // from class: com.qiahao.nextvideo.ui.profile.activity.f
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit initView$lambda$9$lambda$8;
                    initView$lambda$9$lambda$8 = BaseUserDetailActivity.initView$lambda$9$lambda$8(BaseUserDetailActivity.this, (String) obj, (String) obj2, (String) obj3);
                    return initView$lambda$9$lambda$8;
                }
            });
            this.mPropsFragment = propsFragment;
            this.mFragmentList.add(propsFragment);
        }
        if (this.momentFragment == null) {
            PostsSquareFragment.Companion companion = PostsSquareFragment.Companion;
            User user = this.uiModel;
            if (user != null) {
                j = user.getId();
            } else {
                j = 0;
            }
            Fragment newInstance = companion.newInstance(3, j);
            this.momentFragment = newInstance;
            if (newInstance != null) {
                this.mFragmentList.add(newInstance);
            }
        }
        ConstraintLayout constraintLayout = ((ActivityUserDetailBinding) getBinding()).topWhiteBg;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        constraintLayout.setBackground(ShapeUtil.createShape$default(shapeUtil, "#ffffff", "#ffffff", 18, 18, 0, 0, (GradientDrawable.Orientation) null, 64, (Object) null));
        ((ActivityUserDetailBinding) getBinding()).photoBg.setBackground(ShapeUtil.createShape$default(shapeUtil, "#33000000", "#cc000000", 0, 0, 0, 0, GradientDrawable.Orientation.TOP_BOTTOM, 60, (Object) null));
        ViewPager viewPager = ((ActivityUserDetailBinding) getBinding()).viewPager;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        viewPager.setAdapter(new CommonFragmentStatePagerAdapter(supportFragmentManager, this.mFragmentList, (List) null, 4, (DefaultConstructorMarker) null));
        ((ActivityUserDetailBinding) getBinding()).viewPager.setOffscreenPageLimit(this.mFragmentList.size());
        ((ActivityUserDetailBinding) getBinding()).tabLayout.k(((ActivityUserDetailBinding) getBinding()).viewPager, this.mTypeList);
        ((ActivityUserDetailBinding) getBinding()).queuePlayer.autoGone(true);
        final LightQueueCombinationPlayer lightQueueCombinationPlayer = ((ActivityUserDetailBinding) getBinding()).queuePlayer;
        final long j2 = 800;
        lightQueueCombinationPlayer.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ActivityUserDetailBinding binding;
                ActivityUserDetailBinding binding2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(lightQueueCombinationPlayer) > j2 || (lightQueueCombinationPlayer instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(lightQueueCombinationPlayer, currentTimeMillis);
                    LightQueueCombinationPlayer lightQueueCombinationPlayer2 = lightQueueCombinationPlayer;
                    binding = this.getBinding();
                    if (!binding.queuePlayer.isPlayEnd()) {
                        binding2 = this.getBinding();
                        binding2.queuePlayer.stop(false);
                    }
                }
            }
        });
        ((ActivityUserDetailBinding) getBinding()).tabLayout.setOnTabSelectListener(new o6.b() { // from class: com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity$initView$8
            public void onTabReselect(int position) {
            }

            public void onTabSelect(int position) {
                ActivityUserDetailBinding binding;
                binding = BaseUserDetailActivity.this.getBinding();
                binding.viewPager.setCurrentItem(position);
            }
        });
        ((ActivityUserDetailBinding) getBinding()).viewPager.addOnPageChangeListener(new ViewPager.j() { // from class: com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity$initView$9
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                ActivityUserDetailBinding binding;
                ActivityUserDetailBinding binding2;
                boolean z;
                binding = BaseUserDetailActivity.this.getBinding();
                binding.tabLayout.setCurrentTab(position);
                binding2 = BaseUserDetailActivity.this.getBinding();
                SmartRefreshLayout smartRefreshLayout = binding2.refreshLayout;
                if (position != 2) {
                    z = true;
                } else {
                    z = false;
                }
                smartRefreshLayout.setEnabled(z);
                if (position == 2) {
                    Function1<Boolean, Unit> showPostBtnOrNot = BaseUserDetailActivity.this.getShowPostBtnOrNot();
                    if (showPostBtnOrNot != null) {
                        showPostBtnOrNot.invoke(Boolean.TRUE);
                        return;
                    }
                    return;
                }
                Function1<Boolean, Unit> showPostBtnOrNot2 = BaseUserDetailActivity.this.getShowPostBtnOrNot();
                if (showPostBtnOrNot2 != null) {
                    showPostBtnOrNot2.invoke(Boolean.FALSE);
                }
            }
        });
        ((ActivityUserDetailBinding) getBinding()).toolbar.addOnOffsetChangedListener(new AppBarLayout.h() { // from class: com.qiahao.nextvideo.ui.profile.activity.g
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                BaseUserDetailActivity.initView$lambda$13(BaseUserDetailActivity.this, appBarLayout, i);
            }
        });
        final AppCompatImageView appCompatImageView = ((ActivityUserDetailBinding) getBinding()).backImageView;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j2 || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        final AppCompatImageView appCompatImageView2 = ((ActivityUserDetailBinding) getBinding()).report;
        appCompatImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView2) > j2 || (appCompatImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView2, currentTimeMillis);
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    this.reportImageViewPressed();
                }
            }
        });
        final AppCompatImageView appCompatImageView3 = ((ActivityUserDetailBinding) getBinding()).likedImageButton;
        appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity$initView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView3) > j2 || (appCompatImageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView3, currentTimeMillis);
                    AppCompatImageView appCompatImageView4 = appCompatImageView3;
                    this.likedImageViewPressed();
                }
            }
        });
        final AppCompatImageView appCompatImageView4 = ((ActivityUserDetailBinding) getBinding()).chatImageButton;
        appCompatImageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity$initView$$inlined$singleClick$default$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView4) > j2 || (appCompatImageView4 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView4, currentTimeMillis);
                    AppCompatImageView appCompatImageView5 = appCompatImageView4;
                    this.chatImageViewPressed();
                }
            }
        });
        final AppCompatImageView appCompatImageView5 = ((ActivityUserDetailBinding) getBinding()).setting;
        appCompatImageView5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity$initView$$inlined$singleClick$default$6
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v0, types: [android.content.Context, com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity] */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView5) > j2 || (appCompatImageView5 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView5, currentTimeMillis);
                    AppCompatImageView appCompatImageView6 = appCompatImageView5;
                    User user2 = UserStore.INSTANCE.getShared().getUser();
                    if (user2 != null) {
                        UserInfoEditActivity.Companion companion2 = UserInfoEditActivity.Companion;
                        ?? r1 = this;
                        companion2.start(r1, user2, r1.getPicList());
                    }
                }
            }
        });
        ((ActivityUserDetailBinding) getBinding()).countryID.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.h
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean initView$lambda$20;
                initView$lambda$20 = BaseUserDetailActivity.initView$lambda$20(BaseUserDetailActivity.this, view);
                return initView$lambda$20;
            }
        });
        final AppCompatImageButton appCompatImageButton = ((ActivityUserDetailBinding) getBinding()).roomImageButton;
        appCompatImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity$initView$$inlined$singleClick$default$7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String currentRoom;
                SvipData svip;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageButton) > j2 || (appCompatImageButton instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageButton, currentTimeMillis);
                    AppCompatImageButton appCompatImageButton2 = appCompatImageButton;
                    User uiModel = this.getUiModel();
                    if (uiModel != null && (svip = uiModel.getSvip()) != null && svip.isNotFollow()) {
                        HiloToasty.Companion companion2 = HiloToasty.Companion;
                        BaseActivity baseActivity = this;
                        Toast normal$default = HiloToasty.Companion.normal$default(companion2, baseActivity, ResourcesKtxKt.getStringById(baseActivity, 2131954199), false, 4, (Object) null);
                        if (normal$default != null) {
                            normal$default.show();
                            return;
                        }
                        return;
                    }
                    User uiModel2 = this.getUiModel();
                    if (uiModel2 != null && (currentRoom = uiModel2.getCurrentRoom()) != null) {
                        StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, currentRoom, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
                    }
                }
            }
        });
        ((ActivityUserDetailBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.profile.activity.i
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                BaseUserDetailActivity.initView$lambda$23(BaseUserDetailActivity.this, fVar);
            }
        });
        initPhotoView();
        ((ActivityUserDetailBinding) getBinding()).viewPager.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.profile.activity.j
            @Override // java.lang.Runnable
            public final void run() {
                BaseUserDetailActivity.initView$lambda$24(BaseUserDetailActivity.this);
            }
        }, 1000L);
        getUserCarAndPlayer();
        getUserPhotoData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$13(BaseUserDetailActivity baseUserDetailActivity, AppBarLayout appBarLayout, int i) {
        float abs = Math.abs((i * 1.0f) / appBarLayout.getTotalScrollRange());
        ((ActivityUserDetailBinding) baseUserDetailActivity.getBinding()).margeTop.setAlpha(abs);
        ((ActivityUserDetailBinding) baseUserDetailActivity.getBinding()).title.setAlpha(abs);
        ((ActivityUserDetailBinding) baseUserDetailActivity.getBinding()).svipType1.setAlpha(abs);
        ((ActivityUserDetailBinding) baseUserDetailActivity.getBinding()).recyclerSmallPhoto1.setAlpha(abs);
        if (abs > 0.5d) {
            ((ActivityUserDetailBinding) baseUserDetailActivity.getBinding()).backImageView.setImageDrawable(androidx.core.content.a.getDrawable(baseUserDetailActivity, R.drawable.me_back));
            ((ActivityUserDetailBinding) baseUserDetailActivity.getBinding()).setting.setImageDrawable(androidx.core.content.a.getDrawable(baseUserDetailActivity, R.drawable.user_detail_setting_black));
            baseUserDetailActivity.setStatusBarIconColor(true);
        } else {
            ((ActivityUserDetailBinding) baseUserDetailActivity.getBinding()).backImageView.setImageDrawable(androidx.core.content.a.getDrawable(baseUserDetailActivity, 2131232457));
            ((ActivityUserDetailBinding) baseUserDetailActivity.getBinding()).setting.setImageDrawable(androidx.core.content.a.getDrawable(baseUserDetailActivity, R.drawable.user_detail_setting_white));
            baseUserDetailActivity.setStatusBarIconColor(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean initView$lambda$20(BaseUserDetailActivity baseUserDetailActivity, View view) {
        String code;
        Toast normal$default;
        User user = baseUserDetailActivity.uiModel;
        if (user != null && (code = user.getCode()) != null && StringKtxKt.copyToClipboard(code) && (normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, baseUserDetailActivity, ResourcesKtxKt.getStringById(baseUserDetailActivity, 2131952379), false, 4, (Object) null)) != null) {
            normal$default.show();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$23(BaseUserDetailActivity baseUserDetailActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        baseUserDetailActivity.getUserPhotoData();
        ProfileFragment profileFragment = baseUserDetailActivity.mProfileFragment;
        if (profileFragment != null) {
            profileFragment.refreshData();
        }
        PropsFragment propsFragment = baseUserDetailActivity.mPropsFragment;
        if (propsFragment != null) {
            propsFragment.refreshData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$24(BaseUserDetailActivity baseUserDetailActivity) {
        baseUserDetailActivity.refreshView(baseUserDetailActivity.uiModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$5(BaseUserDetailActivity baseUserDetailActivity, int i, int i2) {
        CollapsingToolbarLayout.c layoutParams = baseUserDetailActivity.getBinding().margeTop.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams");
        ((FrameLayout.LayoutParams) layoutParams).height = UiKtxKt.toPX(48) + i;
        ViewGroup.LayoutParams layoutParams2 = baseUserDetailActivity.getBinding().bar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams2).height = i;
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$9$lambda$8(BaseUserDetailActivity baseUserDetailActivity, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "effectUrl");
        baseUserDetailActivity.playCar(str, str2, str3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$39(BaseUserDetailActivity baseUserDetailActivity) {
        baseUserDetailActivity.refreshView(UserStore.INSTANCE.getShared().getUser());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PhotoViewPagerAdapter photoViewPagerAdapter_delegate$lambda$0() {
        return new PhotoViewPagerAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PhotoViewSmallAdapter1 photoViewSmallAdapter1_delegate$lambda$2() {
        return new PhotoViewSmallAdapter1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PhotoViewSmallAdapter photoViewSmallAdapter_delegate$lambda$1() {
        return new PhotoViewSmallAdapter();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void playCar(String effectUrl, String senderAvatar, String receiverAvatar) {
        User user;
        String str;
        String str2;
        if ((senderAvatar == null || senderAvatar.length() == 0) && ((user = this.uiModel) == null || (senderAvatar = user.getAvatar()) == null)) {
            str = "";
        } else {
            str = senderAvatar;
        }
        if (receiverAvatar == null || receiverAvatar.length() == 0) {
            str2 = "";
        } else {
            str2 = receiverAvatar;
        }
        try {
            GiftDateItem chatToGift$default = DataExternalKt.chatToGift$default(effectUrl, str, str2, null, null, null, null, 120, null);
            if (StringKtxKt.checkEndSVGA(effectUrl)) {
                ((ActivityUserDetailBinding) getBinding()).queuePlayer.addQueue(GiftHelp.INSTANCE.getSVGAData(chatToGift$default));
            } else if (StringKtxKt.checkEndMP4(effectUrl)) {
                GiftHelp.INSTANCE.getVAP2(chatToGift$default, LifecycleOwnerKt.getLifecycleScope(this), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.k
                    public final Object invoke(Object obj) {
                        Unit playCar$lambda$29;
                        playCar$lambda$29 = BaseUserDetailActivity.playCar$lambda$29(BaseUserDetailActivity.this, (VapMediaSource) obj);
                        return playCar$lambda$29;
                    }
                }, this);
            } else if (StringKtxKt.checkDefaultMP4(effectUrl)) {
                ((ActivityUserDetailBinding) getBinding()).queuePlayer.addQueue(new VideoMediaSource(StringKtxKt.urlMP4(effectUrl)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit playCar$lambda$29(BaseUserDetailActivity baseUserDetailActivity, VapMediaSource vapMediaSource) {
        Intrinsics.checkNotNullParameter(vapMediaSource, "it");
        baseUserDetailActivity.getBinding().queuePlayer.addQueue(vapMediaSource);
        return Unit.INSTANCE;
    }

    private final void playSvga(String svgaUrl) {
        if (TextUtils.isEmpty(svgaUrl)) {
            return;
        }
        try {
            SVGAParser.Companion.shareParser().decodeFromAssets(svgaUrl, new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity$playSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    ActivityUserDetailBinding binding;
                    ActivityUserDetailBinding binding2;
                    ActivityUserDetailBinding binding3;
                    ActivityUserDetailBinding binding4;
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    Drawable sVGADrawable = new SVGADrawable(videoItem, new SVGADynamicEntity());
                    binding = BaseUserDetailActivity.this.getBinding();
                    binding.countrySVGA.setVisibility(0);
                    binding2 = BaseUserDetailActivity.this.getBinding();
                    binding2.countrySVGA.stopAnimation(true);
                    binding3 = BaseUserDetailActivity.this.getBinding();
                    binding3.countrySVGA.setImageDrawable(sVGADrawable);
                    binding4 = BaseUserDetailActivity.this.getBinding();
                    binding4.countrySVGA.startAnimation();
                }

                public void onError() {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final void playSvipSvga(String svgaUrl) {
        if (TextUtils.isEmpty(svgaUrl)) {
            return;
        }
        try {
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(svgaUrl), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity$playSvipSvga$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    ActivityUserDetailBinding binding;
                    ActivityUserDetailBinding binding2;
                    ActivityUserDetailBinding binding3;
                    ActivityUserDetailBinding binding4;
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    Drawable sVGADrawable = new SVGADrawable(videoItem, new SVGADynamicEntity());
                    binding = BaseUserDetailActivity.this.getBinding();
                    binding.svipSVGA.setVisibility(0);
                    binding2 = BaseUserDetailActivity.this.getBinding();
                    binding2.svipSVGA.stopAnimation(true);
                    binding3 = BaseUserDetailActivity.this.getBinding();
                    binding3.svipSVGA.setImageDrawable(sVGADrawable);
                    binding4 = BaseUserDetailActivity.this.getBinding();
                    binding4.svipSVGA.startAnimation();
                }

                public void onError() {
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chatImageViewPressed() {
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_user_detail;
    }

    @Nullable
    public final ProfileFragment getMProfileFragment() {
        return this.mProfileFragment;
    }

    @Nullable
    public final PropsFragment getMPropsFragment() {
        return this.mPropsFragment;
    }

    @NotNull
    public final String[] getMTypeList() {
        return this.mTypeList;
    }

    @Nullable
    public final PostsSquareFragment getMomentFragment() {
        return this.momentFragment;
    }

    @NotNull
    public final ArrayList<UserPictureResponseBean> getPicList() {
        return this.picList;
    }

    @Nullable
    public final Function1<Boolean, Unit> getShowPostBtnOrNot() {
        return this.showPostBtnOrNot;
    }

    @Nullable
    public final User getUiModel() {
        return this.uiModel;
    }

    public final void getUserPhotoData() {
        String str;
        UserService shared = UserService.INSTANCE.getShared();
        User user = this.uiModel;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.fetchUserPhotos(str), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.m
            public final Object invoke(Object obj) {
                Unit userPhotoData$lambda$26;
                userPhotoData$lambda$26 = BaseUserDetailActivity.getUserPhotoData$lambda$26(BaseUserDetailActivity.this, (ApiResponse) obj);
                return userPhotoData$lambda$26;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.n
            public final Object invoke(Object obj) {
                Unit userPhotoData$lambda$27;
                userPhotoData$lambda$27 = BaseUserDetailActivity.getUserPhotoData$lambda$27(BaseUserDetailActivity.this, (Throwable) obj);
                return userPhotoData$lambda$27;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    public void likedImageViewPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        getBinding().queuePlayer.onCleared();
        getBinding().nobleBg.onCleared();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        String str;
        super.onResume();
        User user = this.uiModel;
        String str2 = null;
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        User user2 = UserStore.INSTANCE.getShared().getUser();
        if (user2 != null) {
            str2 = user2.getExternalId();
        }
        if (Intrinsics.areEqual(str, str2)) {
            getBinding().viewPager.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.ui.profile.activity.l
                @Override // java.lang.Runnable
                public final void run() {
                    BaseUserDetailActivity.onResume$lambda$39(BaseUserDetailActivity.this);
                }
            }, 1000L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"UseCompatLoadingForDrawables"})
    public final void refreshView(@Nullable final User user) {
        String str;
        String str2;
        int i;
        String str3;
        int i2;
        int i3;
        String str4;
        int i4;
        boolean z;
        String str5;
        String str6;
        int i5;
        CharSequence charSequence;
        Integer num;
        int i6;
        CharSequence charSequence2;
        int i7;
        long j;
        long j2;
        long j3;
        int i8;
        boolean z2;
        int i9;
        String str7;
        int i10;
        String str8;
        String str9;
        String str10;
        long j4;
        long j5;
        HeadWearBean headWearBean;
        int i11;
        boolean z3;
        boolean z4;
        String ornaments;
        NobleInfo noble;
        String ornaments2;
        ProfileFragment profileFragment;
        String str11;
        String str12;
        SvipData svip;
        SvipData svip2;
        String str13;
        boolean z5;
        String str14;
        String str15;
        String str16;
        boolean z6;
        String str17;
        Integer num2;
        SvipData svip3;
        SvipData svip4;
        CountryManager countryManager;
        Integer isShowAge;
        Country countryInfo;
        Boolean isPrettyCode;
        Integer idFrameType;
        NobleInfo noble2;
        Integer level;
        SvipData svip5;
        NobleInfo noble3;
        Integer level2;
        boolean z7 = true;
        this.uiModel = user;
        String str18 = null;
        if (user != null) {
            str = user.getExternalId();
        } else {
            str = null;
        }
        User user2 = UserStore.INSTANCE.getShared().getUser();
        if (user2 != null) {
            str2 = user2.getExternalId();
        } else {
            str2 = null;
        }
        boolean areEqual = Intrinsics.areEqual(str, str2);
        int i12 = 8;
        if (areEqual) {
            ((ActivityUserDetailBinding) getBinding()).setting.setVisibility(0);
            ((ActivityUserDetailBinding) getBinding()).report.setVisibility(8);
            ((ActivityUserDetailBinding) getBinding()).otherProfileView.setVisibility(8);
        } else {
            ((ActivityUserDetailBinding) getBinding()).setting.setVisibility(8);
            ((ActivityUserDetailBinding) getBinding()).report.setVisibility(0);
            ((ActivityUserDetailBinding) getBinding()).otherProfileView.setVisibility(0);
        }
        NickTextView nickTextView = ((ActivityUserDetailBinding) getBinding()).nicknameTextView;
        UserService.Companion companion = UserService.INSTANCE;
        if (user != null && (noble3 = user.getNoble()) != null && (level2 = noble3.getLevel()) != null) {
            i = level2.intValue();
        } else {
            i = 0;
        }
        nickTextView.setTextColor(companion.getNobleColor(i, Color.parseColor("#ffffff")));
        NickTextView nickTextView2 = ((ActivityUserDetailBinding) getBinding()).nicknameTextView;
        if (user != null) {
            str3 = user.getNick();
        } else {
            str3 = null;
        }
        if (user != null && (svip5 = user.getSvip()) != null) {
            i2 = svip5.getSvipLevel();
        } else {
            i2 = 0;
        }
        if (user != null && (noble2 = user.getNoble()) != null && (level = noble2.getLevel()) != null) {
            i3 = level.intValue();
        } else {
            i3 = 0;
        }
        nickTextView2.setSVipAndNoble(str3, i2, i3);
        CountryIDView countryIDView = ((ActivityUserDetailBinding) getBinding()).countryID;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        if (user != null) {
            str4 = user.getCode();
        } else {
            str4 = null;
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str4}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        if (user != null && (idFrameType = user.getIdFrameType()) != null) {
            i4 = idFrameType.intValue();
        } else {
            i4 = 0;
        }
        int color = androidx.core.content.a.getColor(this, 2131101214);
        if (user != null && (isPrettyCode = user.isPrettyCode()) != null) {
            z = isPrettyCode.booleanValue();
        } else {
            z = false;
        }
        countryIDView.refreshText(format, i4, color, z);
        AppCompatTextView appCompatTextView = ((ActivityUserDetailBinding) getBinding()).des;
        if (user != null) {
            str5 = user.getDescription();
        } else {
            str5 = null;
        }
        appCompatTextView.setText(str5);
        AppCompatImageView appCompatImageView = ((ActivityUserDetailBinding) getBinding()).countryFlagImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "countryFlagImageView");
        if (user != null && (countryInfo = user.getCountryInfo()) != null) {
            str6 = countryInfo.getIcon();
        } else {
            str6 = null;
        }
        ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.imageSize(str6, UiKtxKt.toPX(30)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        ImageView imageView = ((ActivityUserDetailBinding) getBinding()).newUser;
        if (user != null && user.getCornerMark() == 2) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        imageView.setVisibility(i5);
        AppCompatTextView appCompatTextView2 = ((ActivityUserDetailBinding) getBinding()).ageTextView;
        String str19 = "";
        if (user == null || (isShowAge = user.isShowAge()) == null || isShowAge.intValue() != 1) {
            charSequence = "";
        } else {
            charSequence = user.getAge();
        }
        appCompatTextView2.setText(charSequence);
        Resources resources = ((ActivityUserDetailBinding) getBinding()).getRoot().getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        if (user != null) {
            num = Integer.valueOf(user.getSex());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 2) {
            i6 = R.drawable.icon_girl;
        } else {
            i6 = R.drawable.icon_boy;
        }
        Drawable drawable = ResourceUtilsKt.getDrawable(resources, i6, 0);
        AppCompatTextView appCompatTextView3 = ((ActivityUserDetailBinding) getBinding()).ageTextView;
        if (user != null) {
            charSequence2 = user.getAge();
        } else {
            charSequence2 = null;
        }
        appCompatTextView3.setText(charSequence2);
        if (user != null && user.getSex() == 1) {
            i7 = R.drawable.bg_age_male;
        } else {
            i7 = R.drawable.bg_age_female;
        }
        appCompatTextView3.setBackgroundResource(i7);
        if (drawable != null) {
            appCompatTextView3.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        }
        HiloGradeView hiloGradeView = ((ActivityUserDetailBinding) getBinding()).wealthLevel;
        long j6 = 0;
        if (user != null) {
            j = user.getWealthUserGrade();
        } else {
            j = 0;
        }
        HiloGradeView.setLevelBg$default(hiloGradeView, j, false, true, false, 10, (Object) null);
        HiloGradeView hiloGradeView2 = ((ActivityUserDetailBinding) getBinding()).charmLevel;
        if (user != null) {
            j2 = user.getCharmUserGrade();
        } else {
            j2 = 0;
        }
        HiloGradeView.setLevelBg$default(hiloGradeView2, j2, true, false, false, 12, (Object) null);
        HiloGradeView hiloGradeView3 = ((ActivityUserDetailBinding) getBinding()).activityLevel;
        if (user != null) {
            j3 = user.getActivityUserGrade();
        } else {
            j3 = 0;
        }
        HiloGradeView.setLevelBg$default(hiloGradeView3, j3, false, false, true, 6, (Object) null);
        if (user != null && (countryManager = user.getCountryManager()) != null) {
            Integer role = countryManager.getRole();
            if (role != null && role.intValue() == 1) {
                playSvga("svga/country_admin.svga");
            } else {
                Integer role2 = countryManager.getRole();
                if (role2 != null && role2.intValue() == 2) {
                    playSvga("svga/country_aid.svga");
                }
            }
        }
        if (user != null && (svip4 = user.getSvip()) != null) {
            i8 = svip4.getSvipLevel();
        } else {
            i8 = 0;
        }
        if (i8 > 0) {
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            if (user != null && (svip3 = user.getSvip()) != null) {
                num2 = Integer.valueOf(svip3.getSvipLevel());
            } else {
                num2 = null;
            }
            Integer svipType = svipTypeUtils.getSvipType(num2);
            if (svipType != null) {
                int intValue = svipType.intValue();
                ((ActivityUserDetailBinding) getBinding()).svipType.setImageDrawable(androidx.core.content.a.getDrawable(((ActivityUserDetailBinding) getBinding()).getRoot().getContext(), intValue));
                ((ActivityUserDetailBinding) getBinding()).svipType1.setImageDrawable(androidx.core.content.a.getDrawable(((ActivityUserDetailBinding) getBinding()).getRoot().getContext(), intValue));
                ((ActivityUserDetailBinding) getBinding()).svipType.setVisibility(0);
                ((ActivityUserDetailBinding) getBinding()).svipType1.setVisibility(0);
            }
        } else {
            ((ActivityUserDetailBinding) getBinding()).svipType.setVisibility(8);
            ((ActivityUserDetailBinding) getBinding()).svipType1.setVisibility(8);
        }
        ImageView imageView2 = ((ActivityUserDetailBinding) getBinding()).iconVip;
        if (user != null && user.isVip()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            i9 = 0;
        } else {
            i9 = 8;
        }
        imageView2.setVisibility(i9);
        AppCompatTextView appCompatTextView4 = ((ActivityUserDetailBinding) getBinding()).des;
        if (user != null) {
            str7 = user.getDescription();
        } else {
            str7 = null;
        }
        if (Strings.isEmptyOrWhitespace(str7)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        appCompatTextView4.setVisibility(i10);
        AppCompatTextView appCompatTextView5 = ((ActivityUserDetailBinding) getBinding()).title;
        if (user == null || (str8 = user.getNick()) == null) {
            str8 = "";
        }
        appCompatTextView5.setText(str8);
        HiloImageView hiloImageView = ((ActivityUserDetailBinding) getBinding()).userAvatar;
        if (user != null) {
            str9 = user.getAvatar();
        } else {
            str9 = null;
        }
        String image200 = ImageSizeKt.image200(str9);
        if (image200 == null) {
            str10 = "";
        } else {
            str10 = image200;
        }
        HiloImageView.loadImage$default(hiloImageView, str10, 2131231655, 0, 4, (Object) null);
        SpannableTextBuilder spannableTextBuilder = new SpannableTextBuilder(((ActivityUserDetailBinding) getBinding()).fans);
        if (user != null) {
            j4 = user.getLikeCount();
        } else {
            j4 = 0;
        }
        SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(spannableTextBuilder, NumberUtilsKt.rankNumberFormat(j4), Integer.valueOf(androidx.core.content.a.getColor(this, 2131099872)), (Integer) null, 18, 1, (Boolean) null, (Function1) null, (Boolean) null, 228, (Object) null), " ", (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null), ResourcesKtxKt.getStringById(this, 2131952698), Integer.valueOf(androidx.core.content.a.getColor(this, 2131099918)), (Integer) null, 12, 1, (Boolean) null, (Function1) null, (Boolean) null, 228, (Object) null).apply();
        SpannableTextBuilder spannableTextBuilder2 = new SpannableTextBuilder(((ActivityUserDetailBinding) getBinding()).follow);
        if (user != null) {
            j5 = user.getILikeCount();
        } else {
            j5 = 0;
        }
        SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(spannableTextBuilder2, NumberUtilsKt.rankNumberFormat(j5), Integer.valueOf(androidx.core.content.a.getColor(this, 2131099872)), (Integer) null, 18, 1, (Boolean) null, (Function1) null, (Boolean) null, 228, (Object) null), " ", (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null), ResourcesKtxKt.getStringById(this, 2131952759), Integer.valueOf(androidx.core.content.a.getColor(this, 2131099918)), (Integer) null, 12, 1, (Boolean) null, (Function1) null, (Boolean) null, 228, (Object) null).apply();
        SpannableTextBuilder spannableTextBuilder3 = new SpannableTextBuilder(((ActivityUserDetailBinding) getBinding()).visitor);
        if (user != null) {
            j6 = user.getVisitCount();
        }
        SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(SpannableTextBuilder.appendText$default(spannableTextBuilder3, NumberUtilsKt.rankNumberFormat(j6), Integer.valueOf(androidx.core.content.a.getColor(this, 2131099872)), (Integer) null, 18, 1, (Boolean) null, (Function1) null, (Boolean) null, 228, (Object) null), " ", (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Boolean) null, (Function1) null, (Boolean) null, 254, (Object) null), ResourcesKtxKt.getStringById(this, 2131954460), Integer.valueOf(androidx.core.content.a.getColor(this, 2131099918)), (Integer) null, 12, 1, (Boolean) null, (Function1) null, (Boolean) null, 228, (Object) null).apply();
        if (user != null) {
            headWearBean = user.getHeadwear();
        } else {
            headWearBean = null;
        }
        if (headWearBean != null) {
            HeadWearBean headwear = user.getHeadwear();
            if (headwear != null) {
                str13 = headwear.getEffectUrl1();
            } else {
                str13 = null;
            }
            if (str13 != null && str13.length() != 0) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (z5) {
                HeadWearBean headwear2 = user.getHeadwear();
                if (headwear2 != null) {
                    str16 = headwear2.getPicUrl();
                } else {
                    str16 = null;
                }
                if (str16 != null && str16.length() != 0) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                if (!z6) {
                    ImageView imageView3 = ((ActivityUserDetailBinding) getBinding()).userHeadImg;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "userHeadImg");
                    HeadWearBean headwear3 = user.getHeadwear();
                    if (headwear3 != null) {
                        str17 = headwear3.getPicUrl();
                    } else {
                        str17 = null;
                    }
                    ImageKtxKt.loadImage$default(imageView3, ImageSizeKt.imageSize(str17, UiKtxKt.toPX(UserProxyUtility.cpUpgrades)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                }
            } else {
                HeadWearBean headwear4 = user.getHeadwear();
                if (headwear4 != null) {
                    str14 = headwear4.getEffectUrl1();
                } else {
                    str14 = null;
                }
                if (TextUtils.isEmpty(str14)) {
                    return;
                }
                try {
                    SVGAParser shareParser = SVGAParser.Companion.shareParser();
                    HeadWearBean headwear5 = user.getHeadwear();
                    if (headwear5 != null) {
                        str15 = headwear5.getEffectUrl1();
                    } else {
                        str15 = null;
                    }
                    shareParser.decodeFromURL(new URL(str15 + "?raw=true"), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.profile.activity.BaseUserDetailActivity$refreshView$4
                        public void onComplete(SVGAVideoEntity videoItem) {
                            ActivityUserDetailBinding binding;
                            ActivityUserDetailBinding binding2;
                            ActivityUserDetailBinding binding3;
                            String headwearIcon;
                            String str20;
                            Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                            SVGADynamicEntity sVGADynamicEntity = new SVGADynamicEntity();
                            HeadWearBean headwear6 = user.getHeadwear();
                            if (headwear6 != null && (headwearIcon = headwear6.getHeadwearIcon()) != null && StringKtxKt.isUrl(headwearIcon)) {
                                HeadWearBean headwear7 = user.getHeadwear();
                                if (headwear7 == null || (str20 = headwear7.getHeadwearIcon()) == null) {
                                    str20 = "";
                                }
                                DataExternalKt.setDynamicImageEntity$default(sVGADynamicEntity, str20, null, 2, null);
                            }
                            binding = this.getBinding();
                            binding.userHeadSvga.stopAnimation(true);
                            binding2 = this.getBinding();
                            binding2.userHeadSvga.setImageDrawable(new SVGADrawable(videoItem, sVGADynamicEntity));
                            binding3 = this.getBinding();
                            binding3.userHeadSvga.startAnimation();
                        }

                        public void onError() {
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        if (user != null && (svip2 = user.getSvip()) != null) {
            i11 = svip2.getSvipLevel();
        } else {
            i11 = 0;
        }
        if (i11 > 0) {
            if (user == null || (svip = user.getSvip()) == null || (str12 = svip.getMedalEffect()) == null) {
                str12 = "";
            }
            playSvipSvga(str12);
        } else {
            ((ActivityUserDetailBinding) getBinding()).svipSVGA.setVisibility(8);
        }
        AppCompatImageButton appCompatImageButton = ((ActivityUserDetailBinding) getBinding()).roomImageButton;
        if (user != null) {
            str18 = user.getCurrentRoom();
        }
        if (str18 != null && str18.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            UserStore shared = UserStore.INSTANCE.getShared();
            if (user == null || (str11 = user.getExternalId()) == null) {
                str11 = "";
            }
            if (!shared.isMySelf(str11)) {
                i12 = 0;
            }
        }
        appCompatImageButton.setVisibility(i12);
        ProfileFragment profileFragment2 = this.mProfileFragment;
        if (profileFragment2 != null && profileFragment2.isAdded()) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4 && (profileFragment = this.mProfileFragment) != null) {
            profileFragment.refreshView(user);
        }
        if (user == null || (noble = user.getNoble()) == null || (ornaments2 = noble.getOrnaments()) == null || !StringKtxKt.checkEndMP4(ornaments2)) {
            z7 = false;
        }
        if (z7) {
            LightQueueCombinationPlayer lightQueueCombinationPlayer = ((ActivityUserDetailBinding) getBinding()).nobleBg;
            NobleInfo noble4 = user.getNoble();
            if (noble4 != null && (ornaments = noble4.getOrnaments()) != null) {
                str19 = ornaments;
            }
            VapMediaSource vapMediaSource = new VapMediaSource(str19);
            vapMediaSource.setLoop();
            lightQueueCombinationPlayer.addQueue(vapMediaSource);
        }
    }

    public void reportImageViewPressed() {
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }

    public final void setMProfileFragment(@Nullable ProfileFragment profileFragment) {
        this.mProfileFragment = profileFragment;
    }

    public final void setMPropsFragment(@Nullable PropsFragment propsFragment) {
        this.mPropsFragment = propsFragment;
    }

    public final void setMTypeList(@NotNull String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "<set-?>");
        this.mTypeList = strArr;
    }

    public final void setMomentFragment(@Nullable PostsSquareFragment postsSquareFragment) {
        this.momentFragment = postsSquareFragment;
    }

    public final void setPicList(@NotNull ArrayList<UserPictureResponseBean> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.picList = arrayList;
    }

    public final void setShowPostBtnOrNot(@Nullable Function1<? super Boolean, Unit> function1) {
        this.showPostBtnOrNot = function1;
    }

    public final void setUiModel(@Nullable User user) {
        this.uiModel = user;
    }

    public final void updatePhotoViewData(@NotNull List<UserPictureResponseBean> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new PhotoViewPagerBean(((UserPictureResponseBean) it.next()).getPhoto_url()));
        }
        BannerViewPager<PhotoViewPagerBean> bannerViewPager = this.mViewPager;
        if (bannerViewPager != null) {
            bannerViewPager.C(arrayList);
        }
        getBinding().viewpagerPhoto.setCurrentItem(0);
        this.picList.clear();
        this.picList.addAll(list);
    }
}
