package com.qiahao.nextvideo.ui.profile.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.opensource.svgaplayer.SVGAImageView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.log.LogUtil;
import com.qiahao.base_common.AllModuleServiceManager;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.model.MedalBean;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.common.MedalInfo;
import com.qiahao.base_common.model.common.MyGameLevel;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.RelationUserData;
import com.qiahao.base_common.model.common.Special;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.service.BaseService;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.HiloResUtilsKt;
import com.qiahao.base_common.utils.RelationTypeUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.MySupportAllBean;
import com.qiahao.nextvideo.data.model.NobleBeanConfig;
import com.qiahao.nextvideo.data.service.OutPutOtherModuleService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.FragmentUserProfileBinding;
import com.qiahao.nextvideo.ui.cp.CpCertificateDialog;
import com.qiahao.nextvideo.ui.cp.CpSpaceActivity;
import com.qiahao.nextvideo.ui.family.FamilyCenterActivity;
import com.qiahao.nextvideo.ui.gameLevel.GameLevelActivity;
import com.qiahao.nextvideo.ui.home.medal.MedalManageActivity;
import com.qiahao.nextvideo.ui.profile.MedalAdapter;
import com.qiahao.nextvideo.ui.profile.NamePlateAdapter;
import com.qiahao.nextvideo.ui.profile.PicOrSvgaDialog;
import com.qiahao.nextvideo.ui.profile.RelationAdapter;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.store.StoreActivity;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.therouter.TheRouter;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0010\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0014\u0010\u0004J\u0017\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0019\u0010\u0004J\r\u0010\u001a\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u0004J\u000f\u0010\u001b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u0004R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010\u0018R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R&\u0010+\u001a\u0012\u0012\u0004\u0012\u00020)0(j\b\u0012\u0004\u0012\u00020)`*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00102\u001a\u00020-8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010/\u001a\u0004\b5\u00106R\u001b\u0010<\u001a\u0002088BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b9\u0010/\u001a\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/activity/ProfileFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentUserProfileBinding;", "<init>", "()V", "", "initView", "initRelationView", "requestRelation", "initCpView", "initSupport", "initMedalView", "Lcom/qiahao/nextvideo/data/service/OutPutOtherModuleService;", "outPutOtherModuleService", "medalEmptyGetNetSave", "(Lcom/qiahao/nextvideo/data/service/OutPutOtherModuleService;)V", "initNamePlate", "", "getLayoutResId", "()I", "onInitialize", "Lcom/qiahao/base_common/model/common/User;", "user", "refreshView", "(Lcom/qiahao/base_common/model/common/User;)V", "initFamily", "refreshData", "onDestroy", "uiModel", "Lcom/qiahao/base_common/model/common/User;", "getUiModel", "()Lcom/qiahao/base_common/model/common/User;", "setUiModel", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "Ljava/util/ArrayList;", "Lcom/qiahao/base_common/model/MedalBean;", "Lkotlin/collections/ArrayList;", "mMedalList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/profile/NamePlateAdapter;", "namePlateAdapter$delegate", "Lkotlin/Lazy;", "getNamePlateAdapter", "()Lcom/qiahao/nextvideo/ui/profile/NamePlateAdapter;", "namePlateAdapter", "Lcom/qiahao/nextvideo/ui/profile/MedalAdapter;", "medalAdapter$delegate", "getMedalAdapter", "()Lcom/qiahao/nextvideo/ui/profile/MedalAdapter;", "medalAdapter", "Lcom/qiahao/nextvideo/ui/profile/RelationAdapter;", "relationAdapter$delegate", "getRelationAdapter", "()Lcom/qiahao/nextvideo/ui/profile/RelationAdapter;", "relationAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nProfileFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProfileFragment.kt\ncom/qiahao/nextvideo/ui/profile/activity/ProfileFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,417:1\n61#2,9:418\n61#2,9:427\n61#2,9:437\n61#2,9:446\n61#2,9:455\n61#2,9:464\n61#2,9:473\n61#2,9:482\n61#2,9:491\n61#2,9:500\n1#3:436\n1869#4:509\n1869#4,2:510\n1870#4:512\n*S KotlinDebug\n*F\n+ 1 ProfileFragment.kt\ncom/qiahao/nextvideo/ui/profile/activity/ProfileFragment\n*L\n128#1:418,9\n131#1:427,9\n166#1:437,9\n233#1:446,9\n243#1:455,9\n252#1:464,9\n255#1:473,9\n285#1:482,9\n294#1:491,9\n304#1:500,9\n374#1:509\n377#1:510,2\n374#1:512\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ProfileFragment extends BaseBindingFragment<FragmentUserProfileBinding> {

    @Nullable
    private User uiModel;

    @NotNull
    private nd.a compositeDisposable = new nd.a();

    @NotNull
    private ArrayList<MedalBean> mMedalList = new ArrayList<>();

    /* renamed from: namePlateAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy namePlateAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.profile.activity.v0
        public final Object invoke() {
            NamePlateAdapter namePlateAdapter_delegate$lambda$0;
            namePlateAdapter_delegate$lambda$0 = ProfileFragment.namePlateAdapter_delegate$lambda$0();
            return namePlateAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: medalAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy medalAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.profile.activity.z0
        public final Object invoke() {
            MedalAdapter medalAdapter_delegate$lambda$1;
            medalAdapter_delegate$lambda$1 = ProfileFragment.medalAdapter_delegate$lambda$1();
            return medalAdapter_delegate$lambda$1;
        }
    });

    /* renamed from: relationAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy relationAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.profile.activity.a1
        public final Object invoke() {
            RelationAdapter relationAdapter_delegate$lambda$2;
            relationAdapter_delegate$lambda$2 = ProfileFragment.relationAdapter_delegate$lambda$2();
            return relationAdapter_delegate$lambda$2;
        }
    });

    private final MedalAdapter getMedalAdapter() {
        return (MedalAdapter) this.medalAdapter.getValue();
    }

    private final NamePlateAdapter getNamePlateAdapter() {
        return (NamePlateAdapter) this.namePlateAdapter.getValue();
    }

    private final RelationAdapter getRelationAdapter() {
        return (RelationAdapter) this.relationAdapter.getValue();
    }

    @SuppressLint({"SetTextI18n"})
    private final void initCpView() {
        final ConstraintLayout constraintLayout;
        final ImageView imageView;
        final LinearLayout linearLayout;
        final SVGAImageView sVGAImageView;
        ImageView imageView2;
        Integer num;
        Special cp;
        Special cp2;
        QMUIRadiusImageView qMUIRadiusImageView;
        TextView textView;
        int i;
        AppCompatImageView appCompatImageView;
        String str;
        String str2;
        AppCompatImageView appCompatImageView2;
        String str3;
        String str4;
        AppCompatTextView appCompatTextView;
        Integer num2;
        int i2;
        RelationUserData mRelationData;
        Integer maxNum;
        RelationUserData mRelationData2;
        ArrayList specialList;
        ConstraintLayout constraintLayout2;
        boolean z;
        LinearLayout linearLayout2;
        int i3;
        int i4;
        RelationUserData mRelationData3;
        ArrayList specialList2;
        FragmentUserProfileBinding fragmentUserProfileBinding = (FragmentUserProfileBinding) getBinding();
        int i5 = 8;
        if (fragmentUserProfileBinding != null && (linearLayout2 = fragmentUserProfileBinding.llCp) != null) {
            User user = this.uiModel;
            if (user != null && (mRelationData3 = user.getMRelationData()) != null && (specialList2 = mRelationData3.getSpecialList()) != null) {
                i3 = specialList2.size();
            } else {
                i3 = 0;
            }
            if (i3 > 0) {
                i4 = 0;
            } else {
                i4 = 8;
            }
            linearLayout2.setVisibility(i4);
        }
        FragmentUserProfileBinding fragmentUserProfileBinding2 = (FragmentUserProfileBinding) getBinding();
        if (fragmentUserProfileBinding2 != null && (constraintLayout2 = fragmentUserProfileBinding2.cpConstraint) != null) {
            User user2 = this.uiModel;
            if (user2 != null && !user2.checkCP()) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                i5 = 0;
            }
            constraintLayout2.setVisibility(i5);
        }
        FragmentUserProfileBinding fragmentUserProfileBinding3 = (FragmentUserProfileBinding) getBinding();
        Drawable drawable = null;
        if (fragmentUserProfileBinding3 != null && (appCompatTextView = fragmentUserProfileBinding3.cpText) != null) {
            String stringById = ResourcesKtxKt.getStringById(this, 2131953896);
            User user3 = this.uiModel;
            if (user3 != null && (mRelationData2 = user3.getMRelationData()) != null && (specialList = mRelationData2.getSpecialList()) != null) {
                num2 = Integer.valueOf(specialList.size());
            } else {
                num2 = null;
            }
            User user4 = this.uiModel;
            if (user4 != null && (mRelationData = user4.getMRelationData()) != null && (maxNum = mRelationData.getMaxNum()) != null) {
                i2 = maxNum.intValue();
            } else {
                i2 = 0;
            }
            appCompatTextView.setText(stringById + "(" + num2 + "/" + i2 + ")");
        }
        User user5 = this.uiModel;
        if (user5 != null && (cp2 = user5.getCP()) != null) {
            FragmentUserProfileBinding fragmentUserProfileBinding4 = (FragmentUserProfileBinding) getBinding();
            if (fragmentUserProfileBinding4 != null && (appCompatImageView2 = fragmentUserProfileBinding4.cpAvatar1) != null) {
                User user6 = this.uiModel;
                if (user6 != null) {
                    str3 = user6.getAvatar();
                } else {
                    str3 = null;
                }
                String image100 = ImageSizeKt.image100(str3);
                if (image100 == null) {
                    str4 = "";
                } else {
                    str4 = image100;
                }
                ImageKtxKt.loadImage$default(appCompatImageView2, str4, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
            FragmentUserProfileBinding fragmentUserProfileBinding5 = (FragmentUserProfileBinding) getBinding();
            if (fragmentUserProfileBinding5 != null && (appCompatImageView = fragmentUserProfileBinding5.cpAvatar2) != null) {
                User user7 = cp2.getUser();
                if (user7 != null) {
                    str = user7.getAvatar();
                } else {
                    str = null;
                }
                String image1002 = ImageSizeKt.image100(str);
                if (image1002 == null) {
                    str2 = "";
                } else {
                    str2 = image1002;
                }
                ImageKtxKt.loadImage$default(appCompatImageView, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
            FragmentUserProfileBinding fragmentUserProfileBinding6 = (FragmentUserProfileBinding) getBinding();
            if (fragmentUserProfileBinding6 != null && (textView = fragmentUserProfileBinding6.cpValue) != null) {
                String stringById2 = ResourcesKtxKt.getStringById(this, 2131952502);
                Integer days = cp2.getDays();
                if (days != null) {
                    i = days.intValue();
                } else {
                    i = 0;
                }
                String format = String.format(stringById2, Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format);
            }
            FragmentUserProfileBinding fragmentUserProfileBinding7 = (FragmentUserProfileBinding) getBinding();
            if (fragmentUserProfileBinding7 != null && (qMUIRadiusImageView = fragmentUserProfileBinding7.cpBg) != null) {
                ImageKtxKt.loadImage$default(qMUIRadiusImageView, cp2.getBackgroundImg(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, ImageView.ScaleType.FIT_XY, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65502, (Object) null);
            }
        }
        FragmentUserProfileBinding fragmentUserProfileBinding8 = (FragmentUserProfileBinding) getBinding();
        if (fragmentUserProfileBinding8 != null && (imageView2 = fragmentUserProfileBinding8.cpModel) != null) {
            RelationTypeUtils relationTypeUtils = RelationTypeUtils.INSTANCE;
            User user8 = this.uiModel;
            if (user8 != null && (cp = user8.getCP()) != null) {
                num = cp.getLevel();
            } else {
                num = null;
            }
            Integer relationMedal$default = RelationTypeUtils.getRelationMedal$default(relationTypeUtils, num, true, 0, 4, (Object) null);
            if (relationMedal$default != null) {
                int intValue = relationMedal$default.intValue();
                Context context = getContext();
                if (context != null) {
                    drawable = androidx.core.content.a.getDrawable(context, intValue);
                }
            }
            imageView2.setImageDrawable(drawable);
        }
        FragmentUserProfileBinding fragmentUserProfileBinding9 = (FragmentUserProfileBinding) getBinding();
        final long j = 800;
        if (fragmentUserProfileBinding9 != null && (sVGAImageView = fragmentUserProfileBinding9.ivCpHeart) != null) {
            sVGAImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.ProfileFragment$initCpView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    User uiModel;
                    Special cp3;
                    Context context2;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(sVGAImageView) > j || (sVGAImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(sVGAImageView, currentTimeMillis);
                        SVGAImageView sVGAImageView2 = sVGAImageView;
                        User uiModel2 = this.getUiModel();
                        if ((uiModel2 == null || uiModel2.checkCP()) && (uiModel = this.getUiModel()) != null && (cp3 = uiModel.getCP()) != null && (context2 = this.getContext()) != null) {
                            User uiModel3 = this.getUiModel();
                            Intrinsics.checkNotNull(uiModel3);
                            new CpCertificateDialog(context2, uiModel3, cp3).show();
                        }
                    }
                }
            });
        }
        FragmentUserProfileBinding fragmentUserProfileBinding10 = (FragmentUserProfileBinding) getBinding();
        if (fragmentUserProfileBinding10 != null && (linearLayout = fragmentUserProfileBinding10.cpCertificate) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.ProfileFragment$initCpView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str5;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout) > j || (linearLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(linearLayout, currentTimeMillis);
                        Context context2 = this.getContext();
                        if (context2 != null) {
                            CpSpaceActivity.Companion companion = CpSpaceActivity.INSTANCE;
                            User uiModel = this.getUiModel();
                            if (uiModel == null || (str5 = uiModel.getExternalId()) == null) {
                                str5 = "";
                            }
                            CpSpaceActivity.Companion.startActivity$default(companion, context2, str5, null, 1, 4, null);
                        }
                    }
                }
            });
        }
        FragmentUserProfileBinding fragmentUserProfileBinding11 = (FragmentUserProfileBinding) getBinding();
        if (fragmentUserProfileBinding11 != null && (imageView = fragmentUserProfileBinding11.cpHelp) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.ProfileFragment$initCpView$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        Context context2 = this.getContext();
                        if (context2 != null) {
                            StoreActivity.INSTANCE.start(context2, 2);
                        }
                    }
                }
            });
        }
        FragmentUserProfileBinding fragmentUserProfileBinding12 = (FragmentUserProfileBinding) getBinding();
        if (fragmentUserProfileBinding12 != null && (constraintLayout = fragmentUserProfileBinding12.cpConstraint) != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.ProfileFragment$initCpView$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str5;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                        ConstraintLayout constraintLayout3 = constraintLayout;
                        Context context2 = this.getContext();
                        if (context2 != null) {
                            CpSpaceActivity.Companion companion = CpSpaceActivity.INSTANCE;
                            User uiModel = this.getUiModel();
                            if (uiModel == null || (str5 = uiModel.getExternalId()) == null) {
                                str5 = "";
                            }
                            CpSpaceActivity.Companion.startActivity$default(companion, context2, str5, null, 1, 4, null);
                        }
                    }
                }
            });
        }
    }

    private final void initMedalView() {
        int i;
        Integer num;
        NobleInfo noble;
        NobleInfo noble2;
        Integer level;
        int i2;
        ConstraintLayout constraintLayout;
        List medalInfo;
        String str;
        MyGameLevel gameLevel;
        String medalUrl;
        String str2;
        MyGameLevel gameLevel2;
        String medalUrl2;
        MyGameLevel gameLevel3;
        Integer level2;
        BaseService appService = AllModuleServiceManager.Companion.get().getAppService();
        Intrinsics.checkNotNull(appService, "null cannot be cast to non-null type com.qiahao.nextvideo.data.service.OutPutOtherModuleService");
        OutPutOtherModuleService outPutOtherModuleService = (OutPutOtherModuleService) appService;
        this.mMedalList = outPutOtherModuleService.m٠getMedalList();
        ArrayList arrayList = new ArrayList();
        ArrayList<NobleBeanConfig> mNobleBeanConfigList = outPutOtherModuleService.getMNobleBeanConfigList();
        int i3 = 0;
        if (mNobleBeanConfigList.isEmpty()) {
            outPutOtherModuleService.initNobleBeanConfigList();
        } else {
            User user = this.uiModel;
            if (user != null && (noble2 = user.getNoble()) != null && (level = noble2.getLevel()) != null) {
                i = level.intValue();
            } else {
                i = 0;
            }
            if (i > 0) {
                Iterator<NobleBeanConfig> it = mNobleBeanConfigList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                NobleBeanConfig nobleBeanConfig = null;
                while (it.hasNext()) {
                    NobleBeanConfig next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    NobleBeanConfig nobleBeanConfig2 = next;
                    int level3 = nobleBeanConfig2.getLevel();
                    User user2 = this.uiModel;
                    if (user2 == null || (noble = user2.getNoble()) == null || (num = noble.getLevel()) == null) {
                        num = 0;
                    }
                    if (level3 == num.intValue()) {
                        nobleBeanConfig = nobleBeanConfig2;
                    }
                }
                if (nobleBeanConfig != null) {
                    arrayList.add(0, new MedalInfo(-1, nobleBeanConfig.getPicUrl(), "", (String) null, 8, (DefaultConstructorMarker) null));
                }
            }
        }
        User user3 = this.uiModel;
        if (user3 != null && (gameLevel3 = user3.getGameLevel()) != null && (level2 = gameLevel3.getLevel()) != null) {
            i2 = level2.intValue();
        } else {
            i2 = 0;
        }
        if (i2 > 0) {
            if (arrayList.size() > 0) {
                User user4 = this.uiModel;
                if (user4 == null || (gameLevel2 = user4.getGameLevel()) == null || (medalUrl2 = gameLevel2.getMedalUrl()) == null) {
                    str2 = "";
                } else {
                    str2 = medalUrl2;
                }
                arrayList.add(1, new MedalInfo(-1, str2, "", (String) null, 8, (DefaultConstructorMarker) null));
            } else {
                User user5 = this.uiModel;
                if (user5 == null || (gameLevel = user5.getGameLevel()) == null || (medalUrl = gameLevel.getMedalUrl()) == null) {
                    str = "";
                } else {
                    str = medalUrl;
                }
                arrayList.add(new MedalInfo(-1, str, "", (String) null, 8, (DefaultConstructorMarker) null));
            }
        }
        User user6 = this.uiModel;
        if (user6 != null && (medalInfo = user6.getMedalInfo()) != null) {
            arrayList.addAll(medalInfo);
        }
        getMedalAdapter().setList(arrayList);
        FragmentUserProfileBinding fragmentUserProfileBinding = (FragmentUserProfileBinding) getBinding();
        if (fragmentUserProfileBinding != null && (constraintLayout = fragmentUserProfileBinding.llMedal) != null) {
            if (arrayList.isEmpty()) {
                i3 = 8;
            }
            constraintLayout.setVisibility(i3);
        }
        medalEmptyGetNetSave(outPutOtherModuleService);
    }

    private final void initNamePlate() {
        String str;
        UserService shared = UserService.INSTANCE.getShared();
        User user = this.uiModel;
        if (user == null || (str = user.getCode()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.getNamePlateList(str), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.c1
            public final Object invoke(Object obj) {
                Unit initNamePlate$lambda$44;
                initNamePlate$lambda$44 = ProfileFragment.initNamePlate$lambda$44(ProfileFragment.this, (ApiResponse) obj);
                return initNamePlate$lambda$44;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.d1
            public final Object invoke(Object obj) {
                Unit initNamePlate$lambda$45;
                initNamePlate$lambda$45 = ProfileFragment.initNamePlate$lambda$45(ProfileFragment.this, (Throwable) obj);
                return initNamePlate$lambda$45;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initNamePlate$lambda$44(ProfileFragment profileFragment, ApiResponse apiResponse) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        Collection collection = (Collection) apiResponse.getData();
        if (collection != null && !collection.isEmpty()) {
            FragmentUserProfileBinding fragmentUserProfileBinding = (FragmentUserProfileBinding) profileFragment.getBinding();
            if (fragmentUserProfileBinding != null && (linearLayout2 = fragmentUserProfileBinding.nameLayout) != null) {
                linearLayout2.setVisibility(0);
            }
            profileFragment.getNamePlateAdapter().setList((Collection) apiResponse.getData());
        } else {
            FragmentUserProfileBinding fragmentUserProfileBinding2 = (FragmentUserProfileBinding) profileFragment.getBinding();
            if (fragmentUserProfileBinding2 != null && (linearLayout = fragmentUserProfileBinding2.nameLayout) != null) {
                linearLayout.setVisibility(8);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initNamePlate$lambda$45(ProfileFragment profileFragment, Throwable th) {
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(th, "it");
        FragmentUserProfileBinding fragmentUserProfileBinding = (FragmentUserProfileBinding) profileFragment.getBinding();
        if (fragmentUserProfileBinding != null && (linearLayout = fragmentUserProfileBinding.nameLayout) != null) {
            linearLayout.setVisibility(8);
        }
        return Unit.INSTANCE;
    }

    private final void initRelationView() {
        RecyclerView recyclerView;
        FragmentUserProfileBinding fragmentUserProfileBinding = (FragmentUserProfileBinding) getBinding();
        if (fragmentUserProfileBinding != null && (recyclerView = fragmentUserProfileBinding.relationRecycle) != null) {
            recyclerView.setAdapter(getRelationAdapter());
        }
        getRelationAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.b1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ProfileFragment.initRelationView$lambda$17(ProfileFragment.this, baseQuickAdapter, view, i);
            }
        });
        requestRelation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRelationView$lambda$17(ProfileFragment profileFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        String str2;
        int i2;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Special special = (Special) profileFragment.getRelationAdapter().getData().get(i);
        Context context = profileFragment.getContext();
        if (context != null) {
            CpSpaceActivity.Companion companion = CpSpaceActivity.INSTANCE;
            User user = profileFragment.uiModel;
            if (user == null || (str = user.getExternalId()) == null) {
                str = "";
            }
            User user2 = special.getUser();
            if (user2 != null) {
                str2 = user2.getExternalId();
            } else {
                str2 = null;
            }
            Integer type = special.getType();
            if (type != null) {
                i2 = type.intValue();
            } else {
                i2 = 0;
            }
            companion.startActivity(context, str, str2, i2);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private final void initSupport() {
        String str;
        UserService shared = UserService.INSTANCE.getShared();
        User user = this.uiModel;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.getRecentUserSendGift(1, 3, str), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.f1
            public final Object invoke(Object obj) {
                Unit initSupport$lambda$38;
                initSupport$lambda$38 = ProfileFragment.initSupport$lambda$38(ProfileFragment.this, (ApiResponse) obj);
                return initSupport$lambda$38;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.g1
            public final Object invoke(Object obj) {
                Unit initSupport$lambda$39;
                initSupport$lambda$39 = ProfileFragment.initSupport$lambda$39((Throwable) obj);
                return initSupport$lambda$39;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initSupport$lambda$38(final ProfileFragment profileFragment, ApiResponse apiResponse) {
        LinearLayout linearLayout;
        final AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        String str;
        ConstraintLayout constraintLayout;
        final AppCompatImageView appCompatImageView3;
        AppCompatImageView appCompatImageView4;
        String str2;
        ConstraintLayout constraintLayout2;
        final AppCompatImageView appCompatImageView5;
        AppCompatImageView appCompatImageView6;
        String str3;
        AppCompatTextView appCompatTextView;
        ConstraintLayout constraintLayout3;
        ConstraintLayout constraintLayout4;
        ConstraintLayout constraintLayout5;
        LinearLayout linearLayout2;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        final MySupportAllBean mySupportAllBean = (MySupportAllBean) apiResponse.getData();
        if (mySupportAllBean != null && !mySupportAllBean.getUserScores().isEmpty()) {
            FragmentUserProfileBinding fragmentUserProfileBinding = (FragmentUserProfileBinding) profileFragment.getBinding();
            if (fragmentUserProfileBinding != null && (linearLayout2 = fragmentUserProfileBinding.llSupport) != null) {
                linearLayout2.setVisibility(0);
            }
            FragmentUserProfileBinding fragmentUserProfileBinding2 = (FragmentUserProfileBinding) profileFragment.getBinding();
            if (fragmentUserProfileBinding2 != null && (constraintLayout5 = fragmentUserProfileBinding2.cpSupport1) != null) {
                constraintLayout5.setVisibility(0);
            }
            FragmentUserProfileBinding fragmentUserProfileBinding3 = (FragmentUserProfileBinding) profileFragment.getBinding();
            if (fragmentUserProfileBinding3 != null && (constraintLayout4 = fragmentUserProfileBinding3.cpSupport2) != null) {
                constraintLayout4.setVisibility(8);
            }
            FragmentUserProfileBinding fragmentUserProfileBinding4 = (FragmentUserProfileBinding) profileFragment.getBinding();
            if (fragmentUserProfileBinding4 != null && (constraintLayout3 = fragmentUserProfileBinding4.cpSupport3) != null) {
                constraintLayout3.setVisibility(8);
            }
            FragmentUserProfileBinding fragmentUserProfileBinding5 = (FragmentUserProfileBinding) profileFragment.getBinding();
            if (fragmentUserProfileBinding5 != null && (appCompatTextView = fragmentUserProfileBinding5.cpSupportTitle) != null) {
                appCompatTextView.setText(profileFragment.getString(2131954183) + "(" + mySupportAllBean.getTotal() + ")");
            }
            FragmentUserProfileBinding fragmentUserProfileBinding6 = (FragmentUserProfileBinding) profileFragment.getBinding();
            if (fragmentUserProfileBinding6 != null && (appCompatImageView6 = fragmentUserProfileBinding6.cpSupport1Avatar) != null) {
                String image100 = ImageSizeKt.image100(mySupportAllBean.getUserScores().get(0).getUser().getAvatar());
                if (image100 == null) {
                    str3 = "";
                } else {
                    str3 = image100;
                }
                ImageKtxKt.loadImage$default(appCompatImageView6, str3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
            }
            FragmentUserProfileBinding fragmentUserProfileBinding7 = (FragmentUserProfileBinding) profileFragment.getBinding();
            if (fragmentUserProfileBinding7 != null && (appCompatImageView5 = fragmentUserProfileBinding7.cpSupport1Avatar) != null) {
                final long j = 800;
                appCompatImageView5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.ProfileFragment$initSupport$lambda$38$lambda$37$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        String str4;
                        AppService appService;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView5) > j || (appCompatImageView5 instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(appCompatImageView5, currentTimeMillis);
                            User uiModel = profileFragment.getUiModel();
                            if (uiModel != null) {
                                str4 = uiModel.getExternalId();
                            } else {
                                str4 = null;
                            }
                            if (!Intrinsics.areEqual(str4, mySupportAllBean.getUserScores().get(0).getUser().getExternalId()) && (appService = (AppService) TheRouter.get(AppService.class, new Object[0])) != null) {
                                String externalId = mySupportAllBean.getUserScores().get(0).getUser().getExternalId();
                                if (externalId == null) {
                                    externalId = "";
                                }
                                appService.openPersonPage(externalId);
                            }
                        }
                    }
                });
            }
            if (mySupportAllBean.getUserScores().size() > 1) {
                FragmentUserProfileBinding fragmentUserProfileBinding8 = (FragmentUserProfileBinding) profileFragment.getBinding();
                if (fragmentUserProfileBinding8 != null && (constraintLayout2 = fragmentUserProfileBinding8.cpSupport2) != null) {
                    constraintLayout2.setVisibility(0);
                }
                FragmentUserProfileBinding fragmentUserProfileBinding9 = (FragmentUserProfileBinding) profileFragment.getBinding();
                if (fragmentUserProfileBinding9 != null && (appCompatImageView4 = fragmentUserProfileBinding9.cpSupport2Avatar) != null) {
                    String image1002 = ImageSizeKt.image100(mySupportAllBean.getUserScores().get(1).getUser().getAvatar());
                    if (image1002 == null) {
                        str2 = "";
                    } else {
                        str2 = image1002;
                    }
                    ImageKtxKt.loadImage$default(appCompatImageView4, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
                }
                FragmentUserProfileBinding fragmentUserProfileBinding10 = (FragmentUserProfileBinding) profileFragment.getBinding();
                if (fragmentUserProfileBinding10 != null && (appCompatImageView3 = fragmentUserProfileBinding10.cpSupport2Avatar) != null) {
                    final long j2 = 800;
                    appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.ProfileFragment$initSupport$lambda$38$lambda$37$$inlined$singleClick$default$2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            String str4;
                            AppService appService;
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView3) > j2 || (appCompatImageView3 instanceof Checkable)) {
                                ViewKtxKt.setLastClickTime(appCompatImageView3, currentTimeMillis);
                                User uiModel = profileFragment.getUiModel();
                                if (uiModel != null) {
                                    str4 = uiModel.getExternalId();
                                } else {
                                    str4 = null;
                                }
                                if (!Intrinsics.areEqual(str4, mySupportAllBean.getUserScores().get(1).getUser().getExternalId()) && (appService = (AppService) TheRouter.get(AppService.class, new Object[0])) != null) {
                                    String externalId = mySupportAllBean.getUserScores().get(1).getUser().getExternalId();
                                    if (externalId == null) {
                                        externalId = "";
                                    }
                                    appService.openPersonPage(externalId);
                                }
                            }
                        }
                    });
                }
            }
            if (mySupportAllBean.getUserScores().size() > 2) {
                FragmentUserProfileBinding fragmentUserProfileBinding11 = (FragmentUserProfileBinding) profileFragment.getBinding();
                if (fragmentUserProfileBinding11 != null && (constraintLayout = fragmentUserProfileBinding11.cpSupport3) != null) {
                    constraintLayout.setVisibility(0);
                }
                FragmentUserProfileBinding fragmentUserProfileBinding12 = (FragmentUserProfileBinding) profileFragment.getBinding();
                if (fragmentUserProfileBinding12 != null && (appCompatImageView2 = fragmentUserProfileBinding12.cpSupport3Avatar) != null) {
                    String image1003 = ImageSizeKt.image100(mySupportAllBean.getUserScores().get(2).getUser().getAvatar());
                    if (image1003 == null) {
                        str = "";
                    } else {
                        str = image1003;
                    }
                    ImageKtxKt.loadImage$default(appCompatImageView2, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
                }
                FragmentUserProfileBinding fragmentUserProfileBinding13 = (FragmentUserProfileBinding) profileFragment.getBinding();
                if (fragmentUserProfileBinding13 != null && (appCompatImageView = fragmentUserProfileBinding13.cpSupport3Avatar) != null) {
                    final long j3 = 800;
                    appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.ProfileFragment$initSupport$lambda$38$lambda$37$$inlined$singleClick$default$3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            String str4;
                            AppService appService;
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j3 || (appCompatImageView instanceof Checkable)) {
                                ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                                User uiModel = profileFragment.getUiModel();
                                if (uiModel != null) {
                                    str4 = uiModel.getExternalId();
                                } else {
                                    str4 = null;
                                }
                                if (!Intrinsics.areEqual(str4, mySupportAllBean.getUserScores().get(2).getUser().getExternalId()) && (appService = (AppService) TheRouter.get(AppService.class, new Object[0])) != null) {
                                    String externalId = mySupportAllBean.getUserScores().get(2).getUser().getExternalId();
                                    if (externalId == null) {
                                        externalId = "";
                                    }
                                    appService.openPersonPage(externalId);
                                }
                            }
                        }
                    });
                }
            }
            FragmentUserProfileBinding fragmentUserProfileBinding14 = (FragmentUserProfileBinding) profileFragment.getBinding();
            if (fragmentUserProfileBinding14 != null && (linearLayout = fragmentUserProfileBinding14.rankSupport) != null) {
                linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.y0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ProfileFragment.initSupport$lambda$38$lambda$37$lambda$36(ProfileFragment.this, view);
                    }
                });
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSupport$lambda$38$lambda$37$lambda$36(ProfileFragment profileFragment, View view) {
        String str;
        Context context = profileFragment.getContext();
        if (context != null) {
            SupportGiftRankActivity.Companion companion = SupportGiftRankActivity.INSTANCE;
            User user = profileFragment.uiModel;
            if (user == null || (str = user.getExternalId()) == null) {
                str = "";
            }
            companion.startActivity(str, context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initSupport$lambda$39(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    private final void initView() {
        User user;
        final TextView textView;
        final ConstraintLayout constraintLayout;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Bundle arguments = getArguments();
        if (arguments != null) {
            user = (User) arguments.getParcelable("user");
        } else {
            user = null;
        }
        this.uiModel = user;
        FragmentUserProfileBinding fragmentUserProfileBinding = (FragmentUserProfileBinding) getBinding();
        if (fragmentUserProfileBinding != null && (recyclerView2 = fragmentUserProfileBinding.namePlateRecycler) != null) {
            recyclerView2.setLayoutManager(new GridLayoutManager(recyclerView2.getContext(), 3, 1, false));
            recyclerView2.setHasFixedSize(true);
            recyclerView2.setNestedScrollingEnabled(false);
            recyclerView2.setAdapter(getNamePlateAdapter());
        }
        FragmentUserProfileBinding fragmentUserProfileBinding2 = (FragmentUserProfileBinding) getBinding();
        if (fragmentUserProfileBinding2 != null && (recyclerView = fragmentUserProfileBinding2.medalRecyclerView) != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 4, 1, false));
            recyclerView.setHasFixedSize(true);
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setAdapter(getMedalAdapter());
        }
        getMedalAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.h1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                ProfileFragment.initView$lambda$6(ProfileFragment.this, baseQuickAdapter, view, i);
            }
        });
        FragmentUserProfileBinding fragmentUserProfileBinding3 = (FragmentUserProfileBinding) getBinding();
        final long j = 800;
        if (fragmentUserProfileBinding3 != null && (constraintLayout = fragmentUserProfileBinding3.gameLevelLayout) != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.ProfileFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                        ConstraintLayout constraintLayout2 = constraintLayout;
                        Context context = this.getContext();
                        if (context != null) {
                            GameLevelActivity.INSTANCE.start(context);
                        }
                    }
                }
            });
        }
        FragmentUserProfileBinding fragmentUserProfileBinding4 = (FragmentUserProfileBinding) getBinding();
        if (fragmentUserProfileBinding4 != null && (textView = fragmentUserProfileBinding4.message) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.ProfileFragment$initView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            MedalManageActivity.INSTANCE.start(context);
                        }
                    }
                }
            });
        }
        initMedalView();
        initNamePlate();
        initFamily();
        initCpView();
        initRelationView();
        initSupport();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(ProfileFragment profileFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.base_common.model.common.MedalInfo");
        MedalInfo medalInfo = (MedalInfo) item;
        Context context = profileFragment.getContext();
        if (context != null) {
            String picUrl = medalInfo.getPicUrl();
            if (picUrl == null) {
                str = "";
            } else {
                str = picUrl;
            }
            String effectUrl = medalInfo.getEffectUrl();
            if (effectUrl == null) {
                str2 = "";
            } else {
                str2 = effectUrl;
            }
            new PicOrSvgaDialog(str, str2, 1, null, null, context, 24, null).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MedalAdapter medalAdapter_delegate$lambda$1() {
        return new MedalAdapter(R.layout.item_medal);
    }

    private final void medalEmptyGetNetSave(final OutPutOtherModuleService outPutOtherModuleService) {
        nd.c subscribe = io.reactivex.rxjava3.core.z.create(new io.reactivex.rxjava3.core.c0() { // from class: com.qiahao.nextvideo.ui.profile.activity.e1
            public final void a(io.reactivex.rxjava3.core.b0 b0Var) {
                ProfileFragment.medalEmptyGetNetSave$lambda$43(ProfileFragment.this, b0Var);
            }
        }).subscribeOn(ke.a.b()).observeOn(ke.a.b()).subscribe(new pd.g() { // from class: com.qiahao.nextvideo.ui.profile.activity.ProfileFragment$medalEmptyGetNetSave$2
            public final void accept(Boolean bool) {
                Intrinsics.checkNotNullParameter(bool, "it");
                if (bool.booleanValue()) {
                    OutPutOtherModuleService.this.initMedalList();
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "subscribe(...)");
        RxUtilsKt.addTo(subscribe, this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void medalEmptyGetNetSave$lambda$43(ProfileFragment profileFragment, io.reactivex.rxjava3.core.b0 b0Var) {
        List medalInfo;
        Intrinsics.checkNotNullParameter(b0Var, "it");
        if (profileFragment.mMedalList.isEmpty()) {
            b0Var.onNext(Boolean.TRUE);
            return;
        }
        User user = profileFragment.uiModel;
        if (user != null && (medalInfo = user.getMedalInfo()) != null) {
            Iterator it = medalInfo.iterator();
            while (it.hasNext()) {
                int id2 = ((MedalInfo) it.next()).getId();
                Iterator<T> it2 = profileFragment.mMedalList.iterator();
                boolean z = false;
                while (it2.hasNext()) {
                    if (((MedalBean) it2.next()).getMedalId() == id2) {
                        z = true;
                    }
                }
                if (!z) {
                    b0Var.onNext(Boolean.TRUE);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NamePlateAdapter namePlateAdapter_delegate$lambda$0() {
        return new NamePlateAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RelationAdapter relationAdapter_delegate$lambda$2() {
        return new RelationAdapter();
    }

    private final void requestRelation() {
        String str;
        UserService shared = UserService.INSTANCE.getShared();
        User user = this.uiModel;
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(shared.relationBack(str), new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.w0
            public final Object invoke(Object obj) {
                Unit requestRelation$lambda$18;
                requestRelation$lambda$18 = ProfileFragment.requestRelation$lambda$18(ProfileFragment.this, (ApiResponse) obj);
                return requestRelation$lambda$18;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.profile.activity.x0
            public final Object invoke(Object obj) {
                Unit requestRelation$lambda$19;
                requestRelation$lambda$19 = ProfileFragment.requestRelation$lambda$19((Throwable) obj);
                return requestRelation$lambda$19;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestRelation$lambda$18(ProfileFragment profileFragment, ApiResponse apiResponse) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        User user = profileFragment.uiModel;
        if (user != null) {
            user.setMRelationData((RelationUserData) apiResponse.getData());
        }
        RelationAdapter relationAdapter = profileFragment.getRelationAdapter();
        User user2 = profileFragment.uiModel;
        if (user2 != null) {
            arrayList = user2.getOtherRelation();
        } else {
            arrayList = null;
        }
        relationAdapter.setList(arrayList);
        profileFragment.initCpView();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestRelation$lambda$19(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        LogUtil.e$default(LogUtil.INSTANCE, "eTag", "1231", false, 4, (Object) null);
        return Unit.INSTANCE;
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_user_profile;
    }

    @Nullable
    public final User getUiModel() {
        return this.uiModel;
    }

    @SuppressLint({"SetTextI18n"})
    public final void initFamily() {
        Long l;
        ConstraintLayout constraintLayout;
        User user;
        final ConstraintLayout constraintLayout2;
        FamilyInfo groupPower;
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding;
        int i;
        ImageView imageView;
        ImageView imageView2;
        Context context;
        TextView textView;
        int i2;
        TextView textView2;
        PolygonImageView polygonImageView;
        ConstraintLayout constraintLayout3;
        FamilyInfo groupPower2;
        Long id2;
        FamilyInfo groupPower3;
        User user2 = this.uiModel;
        Drawable drawable = null;
        if (user2 != null && (groupPower3 = user2.getGroupPower()) != null) {
            l = groupPower3.getId();
        } else {
            l = null;
        }
        if (l != null && ((user = this.uiModel) == null || (groupPower2 = user.getGroupPower()) == null || (id2 = groupPower2.getId()) == null || id2.longValue() != 0)) {
            FragmentUserProfileBinding fragmentUserProfileBinding = (FragmentUserProfileBinding) getBinding();
            int i3 = 0;
            if (fragmentUserProfileBinding != null && (constraintLayout3 = fragmentUserProfileBinding.myFamilyLayout) != null) {
                constraintLayout3.setVisibility(0);
            }
            User user3 = this.uiModel;
            if (user3 != null && (groupPower = user3.getGroupPower()) != null) {
                FragmentUserProfileBinding fragmentUserProfileBinding2 = (FragmentUserProfileBinding) getBinding();
                if (fragmentUserProfileBinding2 != null && (polygonImageView = fragmentUserProfileBinding2.familyAvatar) != null) {
                    ImageKtxKt.loadImage$default(polygonImageView, ImageSizeKt.image100(groupPower.getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
                }
                FragmentUserProfileBinding fragmentUserProfileBinding3 = (FragmentUserProfileBinding) getBinding();
                if (fragmentUserProfileBinding3 != null && (textView2 = fragmentUserProfileBinding3.familyName) != null) {
                    textView2.setText(groupPower.getName());
                }
                FragmentUserProfileBinding fragmentUserProfileBinding4 = (FragmentUserProfileBinding) getBinding();
                if (fragmentUserProfileBinding4 != null && (textView = fragmentUserProfileBinding4.familyNumber) != null) {
                    Integer memberNum = groupPower.getMemberNum();
                    if (memberNum != null) {
                        i2 = memberNum.intValue();
                    } else {
                        i2 = 0;
                    }
                    Integer memberMax = groupPower.getMemberMax();
                    if (memberMax != null) {
                        i3 = memberMax.intValue();
                    }
                    textView.setText(i2 + "/" + i3);
                }
                FragmentUserProfileBinding fragmentUserProfileBinding5 = (FragmentUserProfileBinding) getBinding();
                if (fragmentUserProfileBinding5 != null && (imageView = fragmentUserProfileBinding5.heardBg) != null) {
                    Integer grade = groupPower.getGrade();
                    if (grade != null) {
                        int familyHeader = HiloResUtilsKt.familyHeader(grade.intValue());
                        FragmentUserProfileBinding fragmentUserProfileBinding6 = (FragmentUserProfileBinding) getBinding();
                        if (fragmentUserProfileBinding6 != null && (imageView2 = fragmentUserProfileBinding6.heardBg) != null && (context = imageView2.getContext()) != null) {
                            drawable = androidx.core.content.a.getDrawable(context, familyHeader);
                        }
                    }
                    imageView.setImageDrawable(drawable);
                }
                FragmentUserProfileBinding fragmentUserProfileBinding7 = (FragmentUserProfileBinding) getBinding();
                if (fragmentUserProfileBinding7 != null && (includeFamilyNamePlateBinding = fragmentUserProfileBinding7.familyNamePlate) != null) {
                    Integer grade2 = groupPower.getGrade();
                    if (grade2 != null) {
                        i = grade2.intValue();
                    } else {
                        i = -1;
                    }
                    String nameplate = groupPower.getNameplate();
                    if (nameplate == null) {
                        nameplate = "";
                    }
                    AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding, i, nameplate, 0, 4, (Object) null);
                }
            }
            FragmentUserProfileBinding fragmentUserProfileBinding8 = (FragmentUserProfileBinding) getBinding();
            if (fragmentUserProfileBinding8 != null && (constraintLayout2 = fragmentUserProfileBinding8.myFamilyLayout) != null) {
                final long j = 800;
                constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.profile.activity.ProfileFragment$initFamily$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        long j2;
                        FamilyInfo groupPower4;
                        Long id3;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout2) > j || (constraintLayout2 instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(constraintLayout2, currentTimeMillis);
                            ConstraintLayout constraintLayout4 = constraintLayout2;
                            Context context2 = this.getContext();
                            if (context2 != null) {
                                FamilyCenterActivity.Companion companion = FamilyCenterActivity.INSTANCE;
                                User uiModel = this.getUiModel();
                                if (uiModel != null && (groupPower4 = uiModel.getGroupPower()) != null && (id3 = groupPower4.getId()) != null) {
                                    j2 = id3.longValue();
                                } else {
                                    j2 = 0;
                                }
                                companion.startActivity(context2, j2);
                            }
                        }
                    }
                });
                return;
            }
            return;
        }
        FragmentUserProfileBinding fragmentUserProfileBinding9 = (FragmentUserProfileBinding) getBinding();
        if (fragmentUserProfileBinding9 != null && (constraintLayout = fragmentUserProfileBinding9.myFamilyLayout) != null) {
            constraintLayout.setVisibility(8);
        }
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        this.compositeDisposable.d();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
    }

    public final void refreshData() {
        requestRelation();
        initSupport();
    }

    public final void refreshView(@Nullable User user) {
        String str;
        String str2;
        Group group;
        MyGameLevel myGameLevel;
        ConstraintLayout constraintLayout;
        int i;
        ImageView imageView;
        TextView textView;
        String str3;
        ConstraintLayout constraintLayout2;
        Integer level;
        Group group2;
        this.uiModel = user;
        String str4 = null;
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
        if (Intrinsics.areEqual(str, str2)) {
            FragmentUserProfileBinding fragmentUserProfileBinding = (FragmentUserProfileBinding) getBinding();
            if (fragmentUserProfileBinding != null && (group2 = fragmentUserProfileBinding.messageGroup) != null) {
                group2.setVisibility(0);
            }
        } else {
            FragmentUserProfileBinding fragmentUserProfileBinding2 = (FragmentUserProfileBinding) getBinding();
            if (fragmentUserProfileBinding2 != null && (group = fragmentUserProfileBinding2.messageGroup) != null) {
                group.setVisibility(8);
            }
        }
        if (user != null) {
            myGameLevel = user.getGameLevel();
        } else {
            myGameLevel = null;
        }
        if (myGameLevel != null) {
            MyGameLevel gameLevel = user.getGameLevel();
            if (gameLevel != null && (level = gameLevel.getLevel()) != null) {
                i = level.intValue();
            } else {
                i = 0;
            }
            if (i > 0) {
                FragmentUserProfileBinding fragmentUserProfileBinding3 = (FragmentUserProfileBinding) getBinding();
                if (fragmentUserProfileBinding3 != null && (constraintLayout2 = fragmentUserProfileBinding3.gameLevelLayout) != null) {
                    constraintLayout2.setVisibility(0);
                }
                FragmentUserProfileBinding fragmentUserProfileBinding4 = (FragmentUserProfileBinding) getBinding();
                if (fragmentUserProfileBinding4 != null && (textView = fragmentUserProfileBinding4.gameLevelTitle) != null) {
                    MyGameLevel gameLevel2 = user.getGameLevel();
                    if (gameLevel2 != null) {
                        str3 = gameLevel2.getTitle();
                    } else {
                        str3 = null;
                    }
                    textView.setText(str3);
                }
                FragmentUserProfileBinding fragmentUserProfileBinding5 = (FragmentUserProfileBinding) getBinding();
                if (fragmentUserProfileBinding5 != null && (imageView = fragmentUserProfileBinding5.medalImg) != null) {
                    MyGameLevel gameLevel3 = user.getGameLevel();
                    if (gameLevel3 != null) {
                        str4 = gameLevel3.getMedalUrl();
                    }
                    ImageKtxKt.loadImage$default(imageView, ImageSizeKt.imageSize(str4, UiKtxKt.toPX(75)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                    return;
                }
                return;
            }
        }
        FragmentUserProfileBinding fragmentUserProfileBinding6 = (FragmentUserProfileBinding) getBinding();
        if (fragmentUserProfileBinding6 != null && (constraintLayout = fragmentUserProfileBinding6.gameLevelLayout) != null) {
            constraintLayout.setVisibility(8);
        }
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }

    public final void setUiModel(@Nullable User user) {
        this.uiModel = user;
    }
}
