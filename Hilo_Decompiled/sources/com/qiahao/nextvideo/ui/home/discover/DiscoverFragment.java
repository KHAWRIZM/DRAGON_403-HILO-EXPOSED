package com.qiahao.nextvideo.ui.home.discover;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.family.FamilyRankItem;
import com.qiahao.nextvideo.data.model.AllRankTop3Bean;
import com.qiahao.nextvideo.data.model.CountryTop3ContributeAllBean;
import com.qiahao.nextvideo.data.model.CountryTop3ContributeBean;
import com.qiahao.nextvideo.data.model.CpTop3Bean;
import com.qiahao.nextvideo.data.model.GiftWallBean;
import com.qiahao.nextvideo.data.model.GroupTopBannerBean;
import com.qiahao.nextvideo.data.model.RankAvatarBean;
import com.qiahao.nextvideo.data.model.WeekPowerTop3Bean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.FragmentDiscoverBinding;
import com.qiahao.nextvideo.databinding.FragmentDiscoverHeadBinding;
import com.qiahao.nextvideo.databinding.ViewCpRankFlipperHolderBinding;
import com.qiahao.nextvideo.databinding.ViewGiftWallFlipperHolderBinding;
import com.qiahao.nextvideo.databinding.ViewPowerRankFlipperHolderBinding;
import com.qiahao.nextvideo.databinding.ViewRankFlipperHolderBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.manager.GroupEvent;
import com.qiahao.nextvideo.ui.cp.CpRankActivity;
import com.qiahao.nextvideo.ui.edition.country.CountryCellUIModel;
import com.qiahao.nextvideo.ui.family.FamilyRankActivity;
import com.qiahao.nextvideo.ui.home.GiftWallActivity;
import com.qiahao.nextvideo.ui.home.GlobalBroadActivity;
import com.qiahao.nextvideo.ui.home.discover.viewModel.DiscoverViewModel;
import com.qiahao.nextvideo.ui.rank.AllRankActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u00103\u001a\u000204H\u0014J\b\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000206H\u0007J\b\u00108\u001a\u000206H\u0002J\b\u00109\u001a\u000206H\u0002J\b\u0010:\u001a\u000206H\u0002J\b\u0010;\u001a\u000206H\u0002J\b\u0010<\u001a\u000206H\u0002J\b\u0010=\u001a\u000206H\u0002J\u0010\u0010>\u001a\u0002062\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u0002062\u0006\u0010?\u001a\u00020BH\u0002J\u001e\u0010C\u001a\u0002062\u0006\u0010D\u001a\u00020,2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020G0FH\u0002J\u0010\u0010H\u001a\u0002062\u0006\u0010?\u001a\u00020IH\u0002J\"\u0010J\u001a\u0002062\b\u0010K\u001a\u0004\u0018\u0001002\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020MH\u0002J\u0016\u0010O\u001a\u0002062\f\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0FH\u0002J\u0018\u0010R\u001a\u0002062\u0006\u0010S\u001a\u00020$2\u0006\u0010?\u001a\u00020QH\u0002J\b\u0010T\u001a\u000206H\u0002J\b\u0010U\u001a\u000206H\u0016J\b\u0010V\u001a\u000206H\u0016J\u0010\u0010W\u001a\u0002062\u0006\u0010X\u001a\u00020MH\u0002J\b\u0010Y\u001a\u000206H\u0016R\u001e\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u000e\u001a\u0004\b \u0010!R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/DiscoverFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentDiscoverBinding;", "<init>", "()V", "countryData", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/ui/edition/country/CountryCellUIModel;", "Lkotlin/collections/ArrayList;", "headBinding", "Lcom/qiahao/nextvideo/databinding/FragmentDiscoverHeadBinding;", "getHeadBinding", "()Lcom/qiahao/nextvideo/databinding/FragmentDiscoverHeadBinding;", "headBinding$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/home/discover/viewModel/DiscoverViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/home/discover/viewModel/DiscoverViewModel;", "viewModel$delegate", "mDiscoverCountryAdapter", "Lcom/qiahao/nextvideo/ui/home/discover/DiscoverCountryAdapter;", "getMDiscoverCountryAdapter", "()Lcom/qiahao/nextvideo/ui/home/discover/DiscoverCountryAdapter;", "mDiscoverCountryAdapter$delegate", "mDiscoverBannerAdapter", "Lcom/qiahao/nextvideo/ui/home/discover/DiscoverBannerAdapter;", "getMDiscoverBannerAdapter", "()Lcom/qiahao/nextvideo/ui/home/discover/DiscoverBannerAdapter;", "mDiscoverBannerAdapter$delegate", "mDiscoverActivityAdapter", "Lcom/qiahao/nextvideo/ui/home/discover/DiscoverActivityAdapter;", "getMDiscoverActivityAdapter", "()Lcom/qiahao/nextvideo/ui/home/discover/DiscoverActivityAdapter;", "mDiscoverActivityAdapter$delegate", "mFlipperGiftWall1Binding", "Lcom/qiahao/nextvideo/databinding/ViewGiftWallFlipperHolderBinding;", "mFlipperGiftWall2Binding", "mFlipperGiftWall3Binding", "mFlipperFamilyMonthBinding", "Lcom/qiahao/nextvideo/databinding/ViewPowerRankFlipperHolderBinding;", "mFlipperFamilyWeekBinding", "mFlipperFamilyDayBinding", "mFlipperFamilyBinding", "Lcom/qiahao/nextvideo/databinding/ViewRankFlipperHolderBinding;", "mFlipperCharmBinding", "mFlipperGroupBinding", "mFlipperDaily1Binding", "Lcom/qiahao/nextvideo/databinding/ViewCpRankFlipperHolderBinding;", "mFlipperDaily2Binding", "mFlipperDaily3Binding", "getLayoutResId", "", "onInitialize", "", "initView", "initData", "showCacheData", "initGiftWallFlipper", "initRankFlipper", "initPowerFlipper", "initCpFlipper", "fullPowerRankFlipperData", "it", "Lcom/qiahao/nextvideo/data/model/WeekPowerTop3Bean;", "fullAllRankFlipperData", "Lcom/qiahao/nextvideo/data/model/AllRankTop3Bean;", "showAvatar", "flipperFamilyBinding", "celebrity", "", "Lcom/qiahao/nextvideo/data/model/RankAvatarBean;", "fullCpRankFlipperData", "Lcom/qiahao/nextvideo/data/model/CpTop3Bean;", "showCpTopRankAvatar", "viewCpRankFlipperHolderBinding", "avatar1", "", "avatar2", "fullGiftWallFlipperData", "giftWallBeanList", "Lcom/qiahao/nextvideo/data/model/GiftWallBean;", "showGiftWallItemView", "viewGiftWallFlipperHolderBinding", "initRecyclerView", "onResume", "onPause", "openMeetingRoomForId", "groupId", "onDestroy", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDiscoverFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DiscoverFragment.kt\ncom/qiahao/nextvideo/ui/home/discover/DiscoverFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,770:1\n61#2,9:771\n61#2,9:780\n61#2,9:793\n61#2,9:803\n61#2,9:812\n61#2,9:821\n61#2,9:830\n1563#3:789\n1634#3,3:790\n1869#3,2:839\n1563#3:841\n1634#3,3:842\n1#4:802\n*S KotlinDebug\n*F\n+ 1 DiscoverFragment.kt\ncom/qiahao/nextvideo/ui/home/discover/DiscoverFragment\n*L\n127#1:771,9\n132#1:780,9\n330#1:793,9\n648#1:803,9\n692#1:812,9\n702#1:821,9\n719#1:830,9\n277#1:789\n277#1:790,3\n168#1:839,2\n185#1:841\n185#1:842,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DiscoverFragment extends BaseBindingFragment<FragmentDiscoverBinding> {

    @Nullable
    private ViewRankFlipperHolderBinding mFlipperCharmBinding;

    @Nullable
    private ViewCpRankFlipperHolderBinding mFlipperDaily1Binding;

    @Nullable
    private ViewCpRankFlipperHolderBinding mFlipperDaily2Binding;

    @Nullable
    private ViewCpRankFlipperHolderBinding mFlipperDaily3Binding;

    @Nullable
    private ViewRankFlipperHolderBinding mFlipperFamilyBinding;

    @Nullable
    private ViewPowerRankFlipperHolderBinding mFlipperFamilyDayBinding;

    @Nullable
    private ViewPowerRankFlipperHolderBinding mFlipperFamilyMonthBinding;

    @Nullable
    private ViewPowerRankFlipperHolderBinding mFlipperFamilyWeekBinding;

    @Nullable
    private ViewGiftWallFlipperHolderBinding mFlipperGiftWall1Binding;

    @Nullable
    private ViewGiftWallFlipperHolderBinding mFlipperGiftWall2Binding;

    @Nullable
    private ViewGiftWallFlipperHolderBinding mFlipperGiftWall3Binding;

    @Nullable
    private ViewRankFlipperHolderBinding mFlipperGroupBinding;

    @NotNull
    private ArrayList<CountryCellUIModel> countryData = new ArrayList<>();

    /* renamed from: headBinding$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy headBinding = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.discover.i1
        public final Object invoke() {
            FragmentDiscoverHeadBinding headBinding_delegate$lambda$0;
            headBinding_delegate$lambda$0 = DiscoverFragment.headBinding_delegate$lambda$0(DiscoverFragment.this);
            return headBinding_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.discover.j1
        public final Object invoke() {
            DiscoverViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = DiscoverFragment.viewModel_delegate$lambda$1(DiscoverFragment.this);
            return viewModel_delegate$lambda$1;
        }
    });

    /* renamed from: mDiscoverCountryAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDiscoverCountryAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.discover.k1
        public final Object invoke() {
            DiscoverCountryAdapter mDiscoverCountryAdapter_delegate$lambda$2;
            mDiscoverCountryAdapter_delegate$lambda$2 = DiscoverFragment.mDiscoverCountryAdapter_delegate$lambda$2();
            return mDiscoverCountryAdapter_delegate$lambda$2;
        }
    });

    /* renamed from: mDiscoverBannerAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDiscoverBannerAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.discover.l1
        public final Object invoke() {
            DiscoverBannerAdapter mDiscoverBannerAdapter_delegate$lambda$3;
            mDiscoverBannerAdapter_delegate$lambda$3 = DiscoverFragment.mDiscoverBannerAdapter_delegate$lambda$3();
            return mDiscoverBannerAdapter_delegate$lambda$3;
        }
    });

    /* renamed from: mDiscoverActivityAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mDiscoverActivityAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.discover.m1
        public final Object invoke() {
            DiscoverActivityAdapter mDiscoverActivityAdapter_delegate$lambda$4;
            mDiscoverActivityAdapter_delegate$lambda$4 = DiscoverFragment.mDiscoverActivityAdapter_delegate$lambda$4();
            return mDiscoverActivityAdapter_delegate$lambda$4;
        }
    });

    private final void fullAllRankFlipperData(AllRankTop3Bean it) {
        if (!it.getCelebrity().isEmpty()) {
            ViewRankFlipperHolderBinding viewRankFlipperHolderBinding = this.mFlipperFamilyBinding;
            Intrinsics.checkNotNull(viewRankFlipperHolderBinding);
            showAvatar(viewRankFlipperHolderBinding, it.getCelebrity());
        }
        if (!it.getCharm().isEmpty()) {
            ViewRankFlipperHolderBinding viewRankFlipperHolderBinding2 = this.mFlipperCharmBinding;
            Intrinsics.checkNotNull(viewRankFlipperHolderBinding2);
            showAvatar(viewRankFlipperHolderBinding2, it.getCharm());
        }
        if (!it.getGroup().isEmpty()) {
            ViewRankFlipperHolderBinding viewRankFlipperHolderBinding3 = this.mFlipperGroupBinding;
            Intrinsics.checkNotNull(viewRankFlipperHolderBinding3);
            showAvatar(viewRankFlipperHolderBinding3, it.getGroup());
        }
    }

    private final void fullCpRankFlipperData(CpTop3Bean it) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String avatar;
        int size = it.getWeek().size();
        String str12 = "";
        if (size != 0) {
            if (size != 1) {
                if (size != 2) {
                    if (size != 3) {
                        showCpTopRankAvatar(this.mFlipperDaily1Binding, "", "");
                        showCpTopRankAvatar(this.mFlipperDaily2Binding, "", "");
                        showCpTopRankAvatar(this.mFlipperDaily3Binding, "", "");
                    } else {
                        ViewCpRankFlipperHolderBinding viewCpRankFlipperHolderBinding = this.mFlipperDaily1Binding;
                        User user1 = it.getWeek().get(0).getUser1();
                        if (user1 == null || (str7 = user1.getAvatar()) == null) {
                            str7 = "";
                        }
                        User user2 = it.getWeek().get(0).getUser2();
                        if (user2 == null || (str8 = user2.getAvatar()) == null) {
                            str8 = "";
                        }
                        showCpTopRankAvatar(viewCpRankFlipperHolderBinding, str7, str8);
                        ViewCpRankFlipperHolderBinding viewCpRankFlipperHolderBinding2 = this.mFlipperDaily2Binding;
                        User user12 = it.getWeek().get(1).getUser1();
                        if (user12 == null || (str9 = user12.getAvatar()) == null) {
                            str9 = "";
                        }
                        User user22 = it.getWeek().get(1).getUser2();
                        if (user22 == null || (str10 = user22.getAvatar()) == null) {
                            str10 = "";
                        }
                        showCpTopRankAvatar(viewCpRankFlipperHolderBinding2, str9, str10);
                        ViewCpRankFlipperHolderBinding viewCpRankFlipperHolderBinding3 = this.mFlipperDaily3Binding;
                        User user13 = it.getWeek().get(2).getUser1();
                        if (user13 == null || (str11 = user13.getAvatar()) == null) {
                            str11 = "";
                        }
                        User user23 = it.getWeek().get(2).getUser2();
                        if (user23 != null && (avatar = user23.getAvatar()) != null) {
                            str12 = avatar;
                        }
                        showCpTopRankAvatar(viewCpRankFlipperHolderBinding3, str11, str12);
                    }
                } else {
                    ViewCpRankFlipperHolderBinding viewCpRankFlipperHolderBinding4 = this.mFlipperDaily1Binding;
                    User user14 = it.getWeek().get(0).getUser1();
                    if (user14 == null || (str3 = user14.getAvatar()) == null) {
                        str3 = "";
                    }
                    User user24 = it.getWeek().get(0).getUser2();
                    if (user24 == null || (str4 = user24.getAvatar()) == null) {
                        str4 = "";
                    }
                    showCpTopRankAvatar(viewCpRankFlipperHolderBinding4, str3, str4);
                    ViewCpRankFlipperHolderBinding viewCpRankFlipperHolderBinding5 = this.mFlipperDaily2Binding;
                    User user15 = it.getWeek().get(1).getUser1();
                    if (user15 == null || (str5 = user15.getAvatar()) == null) {
                        str5 = "";
                    }
                    User user25 = it.getWeek().get(1).getUser2();
                    if (user25 == null || (str6 = user25.getAvatar()) == null) {
                        str6 = "";
                    }
                    showCpTopRankAvatar(viewCpRankFlipperHolderBinding5, str5, str6);
                    showCpTopRankAvatar(this.mFlipperDaily3Binding, "", "");
                }
            } else {
                ViewCpRankFlipperHolderBinding viewCpRankFlipperHolderBinding6 = this.mFlipperDaily1Binding;
                User user16 = it.getWeek().get(0).getUser1();
                if (user16 == null || (str = user16.getAvatar()) == null) {
                    str = "";
                }
                User user26 = it.getWeek().get(0).getUser2();
                if (user26 == null || (str2 = user26.getAvatar()) == null) {
                    str2 = "";
                }
                showCpTopRankAvatar(viewCpRankFlipperHolderBinding6, str, str2);
                showCpTopRankAvatar(this.mFlipperDaily2Binding, "", "");
                showCpTopRankAvatar(this.mFlipperDaily3Binding, "", "");
            }
        } else {
            showCpTopRankAvatar(this.mFlipperDaily1Binding, "", "");
            showCpTopRankAvatar(this.mFlipperDaily2Binding, "", "");
            showCpTopRankAvatar(this.mFlipperDaily3Binding, "", "");
        }
        if (!getHeadBinding().cpRankFlipper.isFlipping()) {
            getHeadBinding().cpRankFlipper.startFlipping();
        }
    }

    private final void fullGiftWallFlipperData(List<GiftWallBean> giftWallBeanList) {
        if (!giftWallBeanList.isEmpty()) {
            ViewGiftWallFlipperHolderBinding viewGiftWallFlipperHolderBinding = this.mFlipperGiftWall1Binding;
            Intrinsics.checkNotNull(viewGiftWallFlipperHolderBinding);
            showGiftWallItemView(viewGiftWallFlipperHolderBinding, giftWallBeanList.get(0));
        }
        if (giftWallBeanList.size() > 1) {
            ViewGiftWallFlipperHolderBinding viewGiftWallFlipperHolderBinding2 = this.mFlipperGiftWall2Binding;
            Intrinsics.checkNotNull(viewGiftWallFlipperHolderBinding2);
            showGiftWallItemView(viewGiftWallFlipperHolderBinding2, giftWallBeanList.get(1));
        }
        if (giftWallBeanList.size() > 2) {
            ViewGiftWallFlipperHolderBinding viewGiftWallFlipperHolderBinding3 = this.mFlipperGiftWall3Binding;
            Intrinsics.checkNotNull(viewGiftWallFlipperHolderBinding3);
            showGiftWallItemView(viewGiftWallFlipperHolderBinding3, giftWallBeanList.get(2));
        }
        if (!getHeadBinding().giftWallFlipper.isFlipping()) {
            getHeadBinding().giftWallFlipper.startFlipping();
        }
    }

    private final void fullPowerRankFlipperData(WeekPowerTop3Bean it) {
        ViewPowerRankFlipperHolderBinding viewPowerRankFlipperHolderBinding;
        PolygonImageView polygonImageView;
        ViewPowerRankFlipperHolderBinding viewPowerRankFlipperHolderBinding2;
        PolygonImageView polygonImageView2;
        ViewPowerRankFlipperHolderBinding viewPowerRankFlipperHolderBinding3;
        PolygonImageView polygonImageView3;
        ViewPowerRankFlipperHolderBinding viewPowerRankFlipperHolderBinding4;
        PolygonImageView polygonImageView4;
        ViewPowerRankFlipperHolderBinding viewPowerRankFlipperHolderBinding5;
        PolygonImageView polygonImageView5;
        ViewPowerRankFlipperHolderBinding viewPowerRankFlipperHolderBinding6;
        PolygonImageView polygonImageView6;
        ViewPowerRankFlipperHolderBinding viewPowerRankFlipperHolderBinding7;
        PolygonImageView polygonImageView7;
        ViewPowerRankFlipperHolderBinding viewPowerRankFlipperHolderBinding8;
        PolygonImageView polygonImageView8;
        PolygonImageView polygonImageView9;
        List<FamilyRankItem> day = it.getDay();
        if (day != null && !day.isEmpty()) {
            ViewPowerRankFlipperHolderBinding viewPowerRankFlipperHolderBinding9 = this.mFlipperFamilyDayBinding;
            if (viewPowerRankFlipperHolderBinding9 != null && (polygonImageView9 = viewPowerRankFlipperHolderBinding9.top1Avatar) != null) {
                ImageKtxKt.loadImage$default(polygonImageView9, ImageSizeKt.image100(it.getDay().get(0).getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            if (it.getDay().size() > 1 && (viewPowerRankFlipperHolderBinding8 = this.mFlipperFamilyDayBinding) != null && (polygonImageView8 = viewPowerRankFlipperHolderBinding8.top2Avatar) != null) {
                ImageKtxKt.loadImage$default(polygonImageView8, ImageSizeKt.image100(it.getDay().get(1).getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            if (it.getDay().size() > 2 && (viewPowerRankFlipperHolderBinding7 = this.mFlipperFamilyDayBinding) != null && (polygonImageView7 = viewPowerRankFlipperHolderBinding7.top3Avatar) != null) {
                ImageKtxKt.loadImage$default(polygonImageView7, ImageSizeKt.image100(it.getDay().get(2).getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
        }
        List<FamilyRankItem> month = it.getMonth();
        if (month != null && !month.isEmpty()) {
            if (!it.getMonth().isEmpty() && (viewPowerRankFlipperHolderBinding6 = this.mFlipperFamilyWeekBinding) != null && (polygonImageView6 = viewPowerRankFlipperHolderBinding6.top1Avatar) != null) {
                ImageKtxKt.loadImage$default(polygonImageView6, ImageSizeKt.image100(it.getMonth().get(0).getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            if (it.getMonth().size() > 1 && (viewPowerRankFlipperHolderBinding5 = this.mFlipperFamilyWeekBinding) != null && (polygonImageView5 = viewPowerRankFlipperHolderBinding5.top2Avatar) != null) {
                ImageKtxKt.loadImage$default(polygonImageView5, ImageSizeKt.image100(it.getMonth().get(1).getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            if (it.getMonth().size() > 2 && (viewPowerRankFlipperHolderBinding4 = this.mFlipperFamilyWeekBinding) != null && (polygonImageView4 = viewPowerRankFlipperHolderBinding4.top3Avatar) != null) {
                ImageKtxKt.loadImage$default(polygonImageView4, ImageSizeKt.image100(it.getMonth().get(2).getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
        }
        List<FamilyRankItem> week = it.getWeek();
        if (week != null && !week.isEmpty()) {
            if (!it.getWeek().isEmpty() && (viewPowerRankFlipperHolderBinding3 = this.mFlipperFamilyMonthBinding) != null && (polygonImageView3 = viewPowerRankFlipperHolderBinding3.top1Avatar) != null) {
                ImageKtxKt.loadImage$default(polygonImageView3, ImageSizeKt.image100(it.getWeek().get(0).getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            if (it.getWeek().size() > 1 && (viewPowerRankFlipperHolderBinding2 = this.mFlipperFamilyMonthBinding) != null && (polygonImageView2 = viewPowerRankFlipperHolderBinding2.top2Avatar) != null) {
                ImageKtxKt.loadImage$default(polygonImageView2, ImageSizeKt.image100(it.getWeek().get(1).getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            if (it.getWeek().size() > 2 && (viewPowerRankFlipperHolderBinding = this.mFlipperFamilyMonthBinding) != null && (polygonImageView = viewPowerRankFlipperHolderBinding.top3Avatar) != null) {
                ImageKtxKt.loadImage$default(polygonImageView, ImageSizeKt.image100(it.getWeek().get(2).getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FragmentDiscoverHeadBinding getHeadBinding() {
        Object value = this.headBinding.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (FragmentDiscoverHeadBinding) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscoverActivityAdapter getMDiscoverActivityAdapter() {
        return (DiscoverActivityAdapter) this.mDiscoverActivityAdapter.getValue();
    }

    private final DiscoverBannerAdapter getMDiscoverBannerAdapter() {
        return (DiscoverBannerAdapter) this.mDiscoverBannerAdapter.getValue();
    }

    private final DiscoverCountryAdapter getMDiscoverCountryAdapter() {
        return (DiscoverCountryAdapter) this.mDiscoverCountryAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DiscoverViewModel getViewModel() {
        return (DiscoverViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FragmentDiscoverHeadBinding headBinding_delegate$lambda$0(DiscoverFragment discoverFragment) {
        return (FragmentDiscoverHeadBinding) androidx.databinding.g.h(LayoutInflater.from(discoverFragment.getContext()), R.layout.fragment_discover_head, (ViewGroup) null, false);
    }

    private final void initCpFlipper() {
        View view;
        View view2;
        getHeadBinding().llCp.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.g1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                DiscoverFragment.initCpFlipper$lambda$37(DiscoverFragment.this, view3);
            }
        });
        View view3 = null;
        this.mFlipperDaily1Binding = (ViewCpRankFlipperHolderBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_cp_rank_flipper_holder, (ViewGroup) null, false);
        this.mFlipperDaily2Binding = (ViewCpRankFlipperHolderBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_cp_rank_flipper_holder, (ViewGroup) null, false);
        this.mFlipperDaily3Binding = (ViewCpRankFlipperHolderBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_cp_rank_flipper_holder, (ViewGroup) null, false);
        ViewFlipper viewFlipper = getHeadBinding().cpRankFlipper;
        ViewCpRankFlipperHolderBinding viewCpRankFlipperHolderBinding = this.mFlipperDaily1Binding;
        if (viewCpRankFlipperHolderBinding != null) {
            view = viewCpRankFlipperHolderBinding.getRoot();
        } else {
            view = null;
        }
        viewFlipper.addView(view);
        ViewFlipper viewFlipper2 = getHeadBinding().cpRankFlipper;
        ViewCpRankFlipperHolderBinding viewCpRankFlipperHolderBinding2 = this.mFlipperDaily2Binding;
        if (viewCpRankFlipperHolderBinding2 != null) {
            view2 = viewCpRankFlipperHolderBinding2.getRoot();
        } else {
            view2 = null;
        }
        viewFlipper2.addView(view2);
        ViewFlipper viewFlipper3 = getHeadBinding().cpRankFlipper;
        ViewCpRankFlipperHolderBinding viewCpRankFlipperHolderBinding3 = this.mFlipperDaily3Binding;
        if (viewCpRankFlipperHolderBinding3 != null) {
            view3 = viewCpRankFlipperHolderBinding3.getRoot();
        }
        viewFlipper3.addView(view3);
        if (!getHeadBinding().cpRankFlipper.isFlipping()) {
            getHeadBinding().cpRankFlipper.startFlipping();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initCpFlipper$lambda$37(DiscoverFragment discoverFragment, View view) {
        Context context = discoverFragment.getContext();
        if (context != null) {
            CpRankActivity.INSTANCE.startActivity(context, 0);
        }
    }

    private final void initData() {
        getViewModel().getTop3Country().observe(this, new DiscoverFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.r1
            public final Object invoke(Object obj) {
                Unit initData$lambda$9;
                initData$lambda$9 = DiscoverFragment.initData$lambda$9(DiscoverFragment.this, (CountryTop3ContributeAllBean) obj);
                return initData$lambda$9;
            }
        }));
        getViewModel().getGiftWall().observe(this, new DiscoverFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.u1
            public final Object invoke(Object obj) {
                Unit initData$lambda$11;
                initData$lambda$11 = DiscoverFragment.initData$lambda$11(DiscoverFragment.this, (List) obj);
                return initData$lambda$11;
            }
        }));
        getViewModel().getActivityList().observe(this, new DiscoverFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.v1
            public final Object invoke(Object obj) {
                Unit initData$lambda$13;
                initData$lambda$13 = DiscoverFragment.initData$lambda$13(DiscoverFragment.this, (List) obj);
                return initData$lambda$13;
            }
        }));
        getViewModel().getTop7Country().observe(this, new DiscoverFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.w1
            public final Object invoke(Object obj) {
                Unit initData$lambda$15;
                initData$lambda$15 = DiscoverFragment.initData$lambda$15(DiscoverFragment.this, (List) obj);
                return initData$lambda$15;
            }
        }));
        getViewModel().getEventList().observe(this, new DiscoverFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.x1
            public final Object invoke(Object obj) {
                Unit initData$lambda$18;
                initData$lambda$18 = DiscoverFragment.initData$lambda$18(DiscoverFragment.this, (ArrayList) obj);
                return initData$lambda$18;
            }
        }));
        getViewModel().getAllRank().observe(this, new DiscoverFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.y1
            public final Object invoke(Object obj) {
                Unit initData$lambda$20;
                initData$lambda$20 = DiscoverFragment.initData$lambda$20(DiscoverFragment.this, (AllRankTop3Bean) obj);
                return initData$lambda$20;
            }
        }));
        getViewModel().getPowerRank().observe(this, new DiscoverFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.z1
            public final Object invoke(Object obj) {
                Unit initData$lambda$22;
                initData$lambda$22 = DiscoverFragment.initData$lambda$22(DiscoverFragment.this, (WeekPowerTop3Bean) obj);
                return initData$lambda$22;
            }
        }));
        getViewModel().getCpRank().observe(this, new DiscoverFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.a2
            public final Object invoke(Object obj) {
                Unit initData$lambda$24;
                initData$lambda$24 = DiscoverFragment.initData$lambda$24(DiscoverFragment.this, (CpTop3Bean) obj);
                return initData$lambda$24;
            }
        }));
        getViewModel().getMException().observe(this, new DiscoverFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.discover.b2
            public final Object invoke(Object obj) {
                Unit initData$lambda$25;
                initData$lambda$25 = DiscoverFragment.initData$lambda$25(DiscoverFragment.this, (Pair) obj);
                return initData$lambda$25;
            }
        }));
        showCacheData();
        getViewModel().getEventListData().resetPage();
        getHeadBinding().discoverBroadCast.initDataAndView();
        getViewModel().getTop3CountryUser();
        getViewModel().getTop7CountryUser();
        getViewModel().getGiftWallList();
        getViewModel().m٧٣getActivityList();
        getViewModel().getBannerListData();
        getViewModel().getRankFlipperData();
        getViewModel().getPowerRankFlipperData();
        getViewModel().getTop3CpRank();
        nd.c l = GroupService.INSTANCE.getMGroupEventProcessorObservable().l(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.discover.DiscoverFragment$initData$10
            public final void accept(GroupEvent groupEvent) {
                DiscoverActivityAdapter mDiscoverActivityAdapter;
                DiscoverActivityAdapter mDiscoverActivityAdapter2;
                FragmentDiscoverHeadBinding headBinding;
                FragmentDiscoverHeadBinding headBinding2;
                FragmentDiscoverHeadBinding headBinding3;
                FragmentDiscoverHeadBinding headBinding4;
                DiscoverActivityAdapter mDiscoverActivityAdapter3;
                Intrinsics.checkNotNullParameter(groupEvent, "it");
                if (groupEvent.getMEventId() == 14) {
                    mDiscoverActivityAdapter = DiscoverFragment.this.getMDiscoverActivityAdapter();
                    int i = -1;
                    int i2 = 0;
                    for (T t : mDiscoverActivityAdapter.getData()) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (Intrinsics.areEqual(((ActivityDetailData) t).getGroupId(), groupEvent.getMGroupId())) {
                            i = i2;
                        }
                        i2 = i3;
                    }
                    if (i != -1) {
                        mDiscoverActivityAdapter3 = DiscoverFragment.this.getMDiscoverActivityAdapter();
                        mDiscoverActivityAdapter3.removeAt(i);
                    }
                    mDiscoverActivityAdapter2 = DiscoverFragment.this.getMDiscoverActivityAdapter();
                    if (mDiscoverActivityAdapter2.getData().isEmpty()) {
                        headBinding3 = DiscoverFragment.this.getHeadBinding();
                        headBinding3.activityLayout.setVisibility(8);
                        headBinding4 = DiscoverFragment.this.getHeadBinding();
                        headBinding4.activityRecycler.setVisibility(8);
                        return;
                    }
                    headBinding = DiscoverFragment.this.getHeadBinding();
                    headBinding.activityLayout.setVisibility(0);
                    headBinding2 = DiscoverFragment.this.getHeadBinding();
                    headBinding2.activityRecycler.setVisibility(0);
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(l, "subscribe(...)");
        RxUtilsKt.addTo(l, getViewModel().getMCompositeDisposable());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$11(DiscoverFragment discoverFragment, List list) {
        if (list != null) {
            discoverFragment.fullGiftWallFlipperData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$13(DiscoverFragment discoverFragment, List list) {
        ArrayList arrayList = new ArrayList();
        ArrayList<String> blockRoomIdList = GroupService.INSTANCE.getInstance().getBlockRoomIdList();
        if (blockRoomIdList == null) {
            blockRoomIdList = new ArrayList<>();
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ActivityDetailData activityDetailData = (ActivityDetailData) it.next();
                if (!CollectionsKt.contains(blockRoomIdList, activityDetailData.getGroupId())) {
                    arrayList.add(activityDetailData);
                }
            }
        }
        discoverFragment.getMDiscoverActivityAdapter().setList(arrayList);
        if (arrayList.isEmpty()) {
            discoverFragment.getHeadBinding().activityLayout.setVisibility(8);
            discoverFragment.getHeadBinding().activityRecycler.setVisibility(8);
        } else {
            discoverFragment.getHeadBinding().activityLayout.setVisibility(0);
            discoverFragment.getHeadBinding().activityRecycler.setVisibility(0);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$15(DiscoverFragment discoverFragment, List list) {
        discoverFragment.countryData.clear();
        if (list != null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Boolean.valueOf(discoverFragment.countryData.add(CountryCellUIModel.INSTANCE.init((Country) it.next()))));
            }
        }
        discoverFragment.getMDiscoverCountryAdapter().setList(discoverFragment.countryData);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$18(DiscoverFragment discoverFragment, ArrayList arrayList) {
        SmartRefreshLayout smartRefreshLayout;
        int i;
        SmartRefreshLayout smartRefreshLayout2;
        int i2;
        SmartRefreshLayout smartRefreshLayout3;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout4;
        SmartRefreshLayout smartRefreshLayout5;
        FragmentDiscoverBinding fragmentDiscoverBinding = (FragmentDiscoverBinding) discoverFragment.getBinding();
        if (fragmentDiscoverBinding != null && (smartRefreshLayout5 = fragmentDiscoverBinding.refreshLayout) != null) {
            smartRefreshLayout5.finishRefresh();
        }
        FragmentDiscoverBinding fragmentDiscoverBinding2 = (FragmentDiscoverBinding) discoverFragment.getBinding();
        if (fragmentDiscoverBinding2 != null && (smartRefreshLayout4 = fragmentDiscoverBinding2.refreshLayout) != null) {
            smartRefreshLayout4.finishLoadMore();
        }
        FragmentDiscoverBinding fragmentDiscoverBinding3 = (FragmentDiscoverBinding) discoverFragment.getBinding();
        if (fragmentDiscoverBinding3 != null && (superStatusView = fragmentDiscoverBinding3.statusView) != null) {
            superStatusView.showContent();
        }
        discoverFragment.getHeadBinding().empty.getRoot().setVisibility(8);
        boolean z = true;
        if (discoverFragment.getViewModel().getEventListData().isOnePage()) {
            if (arrayList != null && arrayList.isEmpty()) {
                discoverFragment.getMDiscoverBannerAdapter().setList((Collection) null);
                discoverFragment.getHeadBinding().empty.getRoot().setVisibility(0);
                FragmentDiscoverBinding fragmentDiscoverBinding4 = (FragmentDiscoverBinding) discoverFragment.getBinding();
                if (fragmentDiscoverBinding4 != null && (smartRefreshLayout3 = fragmentDiscoverBinding4.refreshLayout) != null) {
                    smartRefreshLayout3.setNoMoreData(true);
                }
            } else {
                if (arrayList != null) {
                    MMKVToLocalCache.INSTANCE.saveDiscoverBannerCache(arrayList);
                }
                FragmentDiscoverBinding fragmentDiscoverBinding5 = (FragmentDiscoverBinding) discoverFragment.getBinding();
                if (fragmentDiscoverBinding5 != null && (smartRefreshLayout2 = fragmentDiscoverBinding5.refreshLayout) != null) {
                    if (arrayList != null) {
                        i2 = arrayList.size();
                    } else {
                        i2 = 0;
                    }
                    if (i2 >= discoverFragment.getViewModel().getEventListData().getPageSize()) {
                        z = false;
                    }
                    smartRefreshLayout2.setNoMoreData(z);
                }
                discoverFragment.getMDiscoverBannerAdapter().setList(arrayList);
            }
        } else {
            FragmentDiscoverBinding fragmentDiscoverBinding6 = (FragmentDiscoverBinding) discoverFragment.getBinding();
            if (fragmentDiscoverBinding6 != null && (smartRefreshLayout = fragmentDiscoverBinding6.refreshLayout) != null) {
                if (arrayList != null) {
                    i = arrayList.size();
                } else {
                    i = 0;
                }
                if (i >= discoverFragment.getViewModel().getEventListData().getPageSize()) {
                    z = false;
                }
                smartRefreshLayout.setNoMoreData(z);
            }
            if (arrayList != null) {
                discoverFragment.getMDiscoverBannerAdapter().addData(arrayList);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$20(DiscoverFragment discoverFragment, AllRankTop3Bean allRankTop3Bean) {
        if (allRankTop3Bean != null) {
            discoverFragment.fullAllRankFlipperData(allRankTop3Bean);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$22(DiscoverFragment discoverFragment, WeekPowerTop3Bean weekPowerTop3Bean) {
        if (weekPowerTop3Bean != null) {
            discoverFragment.fullPowerRankFlipperData(weekPowerTop3Bean);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$24(DiscoverFragment discoverFragment, CpTop3Bean cpTop3Bean) {
        if (cpTop3Bean != null) {
            discoverFragment.fullCpRankFlipperData(cpTop3Bean);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$25(DiscoverFragment discoverFragment, Pair pair) {
        String str;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        if (Intrinsics.areEqual(pair.getFirst(), DiscoverViewModel.EVENT_LIST)) {
            FragmentDiscoverBinding fragmentDiscoverBinding = (FragmentDiscoverBinding) discoverFragment.getBinding();
            if (fragmentDiscoverBinding != null && (smartRefreshLayout2 = fragmentDiscoverBinding.refreshLayout) != null) {
                smartRefreshLayout2.finishRefresh();
            }
            FragmentDiscoverBinding fragmentDiscoverBinding2 = (FragmentDiscoverBinding) discoverFragment.getBinding();
            if (fragmentDiscoverBinding2 != null && (smartRefreshLayout = fragmentDiscoverBinding2.refreshLayout) != null) {
                smartRefreshLayout.finishLoadMore();
            }
            FragmentDiscoverBinding fragmentDiscoverBinding3 = (FragmentDiscoverBinding) discoverFragment.getBinding();
            if (fragmentDiscoverBinding3 != null && (superStatusView = fragmentDiscoverBinding3.statusView) != null) {
                superStatusView.showContent();
            }
            if (discoverFragment.getViewModel().getEventListData().isOnePage()) {
                discoverFragment.getMDiscoverBannerAdapter().setList((Collection) null);
                discoverFragment.getHeadBinding().empty.getRoot().setVisibility(0);
            }
            if (pair.getSecond() instanceof HiloException) {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Context context = discoverFragment.getContext();
                Object second = pair.getSecond();
                Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
                String errorMessage = ((HiloException) second).getErrorMessage();
                if (errorMessage == null) {
                    str = ResourcesKtxKt.getStringById(discoverFragment, 2131952667);
                } else {
                    str = errorMessage;
                }
                Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$9(DiscoverFragment discoverFragment, CountryTop3ContributeAllBean countryTop3ContributeAllBean) {
        String str;
        List<CountryTop3ContributeBean> userDiamond;
        ImageView imageView = discoverFragment.getHeadBinding().countryImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "countryImage");
        if (countryTop3ContributeAllBean != null) {
            str = countryTop3ContributeAllBean.getCountryIcon();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(imageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231930, (c5.g) null, 49150, (Object) null);
        discoverFragment.getHeadBinding().countryBgTop1.setVisibility(8);
        discoverFragment.getHeadBinding().countryBgTop2.setVisibility(8);
        discoverFragment.getHeadBinding().countryBgTop3.setVisibility(8);
        if (countryTop3ContributeAllBean != null && (userDiamond = countryTop3ContributeAllBean.getUserDiamond()) != null && (!userDiamond.isEmpty())) {
            discoverFragment.getHeadBinding().countryBgTop1.setVisibility(0);
            discoverFragment.getHeadBinding().countryTop1.setVisibility(0);
            AppCompatImageView appCompatImageView = discoverFragment.getHeadBinding().countryTop1;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "countryTop1");
            ImageKtxKt.loadImage$default(appCompatImageView, countryTop3ContributeAllBean.getUserDiamond().get(0).getUser().getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
            if (countryTop3ContributeAllBean.getUserDiamond().size() > 1) {
                discoverFragment.getHeadBinding().countryBgTop2.setVisibility(0);
                discoverFragment.getHeadBinding().countryTop2.setVisibility(0);
                AppCompatImageView appCompatImageView2 = discoverFragment.getHeadBinding().countryTop2;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "countryTop2");
                ImageKtxKt.loadImage$default(appCompatImageView2, countryTop3ContributeAllBean.getUserDiamond().get(1).getUser().getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
            }
            if (countryTop3ContributeAllBean.getUserDiamond().size() > 2) {
                discoverFragment.getHeadBinding().countryBgTop3.setVisibility(0);
                discoverFragment.getHeadBinding().countryTop3.setVisibility(0);
                AppCompatImageView appCompatImageView3 = discoverFragment.getHeadBinding().countryTop3;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView3, "countryTop3");
                ImageKtxKt.loadImage$default(appCompatImageView3, countryTop3ContributeAllBean.getUserDiamond().get(2).getUser().getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
            }
        }
        return Unit.INSTANCE;
    }

    private final void initGiftWallFlipper() {
        View view;
        View view2;
        View view3 = null;
        this.mFlipperGiftWall1Binding = (ViewGiftWallFlipperHolderBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_gift_wall_flipper_holder, (ViewGroup) null, false);
        this.mFlipperGiftWall2Binding = (ViewGiftWallFlipperHolderBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_gift_wall_flipper_holder, (ViewGroup) null, false);
        this.mFlipperGiftWall3Binding = (ViewGiftWallFlipperHolderBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_gift_wall_flipper_holder, (ViewGroup) null, false);
        ViewFlipper viewFlipper = getHeadBinding().giftWallFlipper;
        ViewGiftWallFlipperHolderBinding viewGiftWallFlipperHolderBinding = this.mFlipperGiftWall1Binding;
        if (viewGiftWallFlipperHolderBinding != null) {
            view = viewGiftWallFlipperHolderBinding.getRoot();
        } else {
            view = null;
        }
        viewFlipper.addView(view);
        ViewFlipper viewFlipper2 = getHeadBinding().giftWallFlipper;
        ViewGiftWallFlipperHolderBinding viewGiftWallFlipperHolderBinding2 = this.mFlipperGiftWall2Binding;
        if (viewGiftWallFlipperHolderBinding2 != null) {
            view2 = viewGiftWallFlipperHolderBinding2.getRoot();
        } else {
            view2 = null;
        }
        viewFlipper2.addView(view2);
        ViewFlipper viewFlipper3 = getHeadBinding().giftWallFlipper;
        ViewGiftWallFlipperHolderBinding viewGiftWallFlipperHolderBinding3 = this.mFlipperGiftWall3Binding;
        if (viewGiftWallFlipperHolderBinding3 != null) {
            view3 = viewGiftWallFlipperHolderBinding3.getRoot();
        }
        viewFlipper3.addView(view3);
        if (!getHeadBinding().giftWallFlipper.isFlipping()) {
            getHeadBinding().giftWallFlipper.startFlipping();
        }
    }

    private final void initPowerFlipper() {
        View view;
        View view2;
        getHeadBinding().llPower.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.h1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                DiscoverFragment.initPowerFlipper$lambda$35(DiscoverFragment.this, view3);
            }
        });
        View view3 = null;
        this.mFlipperFamilyMonthBinding = (ViewPowerRankFlipperHolderBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_power_rank_flipper_holder, (ViewGroup) null, false);
        this.mFlipperFamilyWeekBinding = (ViewPowerRankFlipperHolderBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_power_rank_flipper_holder, (ViewGroup) null, false);
        this.mFlipperFamilyDayBinding = (ViewPowerRankFlipperHolderBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_power_rank_flipper_holder, (ViewGroup) null, false);
        ViewFlipper viewFlipper = getHeadBinding().powerRankFlipper;
        ViewPowerRankFlipperHolderBinding viewPowerRankFlipperHolderBinding = this.mFlipperFamilyMonthBinding;
        if (viewPowerRankFlipperHolderBinding != null) {
            view = viewPowerRankFlipperHolderBinding.getRoot();
        } else {
            view = null;
        }
        viewFlipper.addView(view);
        ViewFlipper viewFlipper2 = getHeadBinding().powerRankFlipper;
        ViewPowerRankFlipperHolderBinding viewPowerRankFlipperHolderBinding2 = this.mFlipperFamilyWeekBinding;
        if (viewPowerRankFlipperHolderBinding2 != null) {
            view2 = viewPowerRankFlipperHolderBinding2.getRoot();
        } else {
            view2 = null;
        }
        viewFlipper2.addView(view2);
        ViewFlipper viewFlipper3 = getHeadBinding().powerRankFlipper;
        ViewPowerRankFlipperHolderBinding viewPowerRankFlipperHolderBinding3 = this.mFlipperFamilyDayBinding;
        if (viewPowerRankFlipperHolderBinding3 != null) {
            view3 = viewPowerRankFlipperHolderBinding3.getRoot();
        }
        viewFlipper3.addView(view3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initPowerFlipper$lambda$35(DiscoverFragment discoverFragment, View view) {
        Context context = discoverFragment.getContext();
        if (context != null) {
            FamilyRankActivity.INSTANCE.startActivity(context);
        }
    }

    private final void initRankFlipper() {
        View view;
        View view2;
        final ConstraintLayout constraintLayout = getHeadBinding().llFamous;
        final long j = 800;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.DiscoverFragment$initRankFlipper$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    Context context = this.getContext();
                    if (context != null) {
                        AllRankActivity.Companion.start$default(AllRankActivity.INSTANCE, context, 0, 2, null);
                    }
                }
            }
        });
        View view3 = null;
        this.mFlipperFamilyBinding = (ViewRankFlipperHolderBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_rank_flipper_holder, (ViewGroup) null, false);
        this.mFlipperCharmBinding = (ViewRankFlipperHolderBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_rank_flipper_holder, (ViewGroup) null, false);
        this.mFlipperGroupBinding = (ViewRankFlipperHolderBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_rank_flipper_holder, (ViewGroup) null, false);
        ViewFlipper viewFlipper = getHeadBinding().allRankFlipper;
        ViewRankFlipperHolderBinding viewRankFlipperHolderBinding = this.mFlipperFamilyBinding;
        if (viewRankFlipperHolderBinding != null) {
            view = viewRankFlipperHolderBinding.getRoot();
        } else {
            view = null;
        }
        viewFlipper.addView(view);
        ViewFlipper viewFlipper2 = getHeadBinding().allRankFlipper;
        ViewRankFlipperHolderBinding viewRankFlipperHolderBinding2 = this.mFlipperCharmBinding;
        if (viewRankFlipperHolderBinding2 != null) {
            view2 = viewRankFlipperHolderBinding2.getRoot();
        } else {
            view2 = null;
        }
        viewFlipper2.addView(view2);
        ViewFlipper viewFlipper3 = getHeadBinding().allRankFlipper;
        ViewRankFlipperHolderBinding viewRankFlipperHolderBinding3 = this.mFlipperGroupBinding;
        if (viewRankFlipperHolderBinding3 != null) {
            view3 = viewRankFlipperHolderBinding3.getRoot();
        }
        viewFlipper3.addView(view3);
    }

    private final void initRecyclerView() {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        RecyclerView recyclerView;
        SmartRefreshLayout smartRefreshLayout3;
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentDiscoverBinding fragmentDiscoverBinding = (FragmentDiscoverBinding) getBinding();
            if (fragmentDiscoverBinding != null && (smartRefreshLayout3 = fragmentDiscoverBinding.refreshLayout) != null) {
                smartRefreshLayout3.setRefreshFooter(footLoading);
            }
        }
        FragmentDiscoverBinding fragmentDiscoverBinding2 = (FragmentDiscoverBinding) getBinding();
        if (fragmentDiscoverBinding2 != null && (recyclerView = fragmentDiscoverBinding2.eventRecycler) != null) {
            recyclerView.setAdapter(getMDiscoverBannerAdapter());
        }
        DiscoverBannerAdapter mDiscoverBannerAdapter = getMDiscoverBannerAdapter();
        View root = getHeadBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        BaseQuickAdapter.setHeaderView$default(mDiscoverBannerAdapter, root, 0, 0, 6, (Object) null);
        final ImageView imageView = getHeadBinding().empty.ivIcon;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.DiscoverFragment$initRecyclerView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiscoverViewModel viewModel;
                DiscoverViewModel viewModel2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    viewModel = this.getViewModel();
                    viewModel.getEventListData().resetPage();
                    viewModel2 = this.getViewModel();
                    viewModel2.getBannerListData();
                }
            }
        });
        FragmentDiscoverBinding fragmentDiscoverBinding3 = (FragmentDiscoverBinding) getBinding();
        if (fragmentDiscoverBinding3 != null && (smartRefreshLayout2 = fragmentDiscoverBinding3.refreshLayout) != null) {
            smartRefreshLayout2.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.home.discover.n1
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    DiscoverFragment.initRecyclerView$lambda$42(DiscoverFragment.this, fVar);
                }
            });
        }
        FragmentDiscoverBinding fragmentDiscoverBinding4 = (FragmentDiscoverBinding) getBinding();
        if (fragmentDiscoverBinding4 != null && (smartRefreshLayout = fragmentDiscoverBinding4.refreshLayout) != null) {
            smartRefreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.home.discover.o1
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    DiscoverFragment.initRecyclerView$lambda$43(DiscoverFragment.this, fVar);
                }
            });
        }
        RecyclerView recyclerView2 = getHeadBinding().discoverCountryRecycler;
        recyclerView2.setAdapter(getMDiscoverCountryAdapter());
        recyclerView2.setLayoutManager(new GridLayoutManager(recyclerView2.getContext(), 3));
        recyclerView2.setHasFixedSize(true);
        getHeadBinding().activityRecycler.setAdapter(getMDiscoverActivityAdapter());
        getMDiscoverActivityAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.p1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                DiscoverFragment.initRecyclerView$lambda$45(DiscoverFragment.this, baseQuickAdapter, view, i);
            }
        });
        getMDiscoverActivityAdapter().setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.q1
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                boolean initRecyclerView$lambda$46;
                initRecyclerView$lambda$46 = DiscoverFragment.initRecyclerView$lambda$46(DiscoverFragment.this, baseQuickAdapter, view, i);
                return initRecyclerView$lambda$46;
            }
        });
        final LinearLayout linearLayout = getHeadBinding().moreLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.DiscoverFragment$initRecyclerView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout) > j || (linearLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout, currentTimeMillis);
                    Context context2 = this.getContext();
                    if (context2 != null) {
                        context2.startActivity(new Intent(this.getContext(), (Class<?>) ActivitiesActivity.class));
                    }
                }
            }
        });
        final LinearLayout linearLayout2 = getHeadBinding().countryLayout;
        linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.DiscoverFragment$initRecyclerView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout2) > j || (linearLayout2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout2, currentTimeMillis);
                    Context context2 = this.getContext();
                    if (context2 != null) {
                        CountryDiscoverActivity.INSTANCE.start(context2);
                    }
                }
            }
        });
        getMDiscoverCountryAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.s1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                DiscoverFragment.initRecyclerView$lambda$51(DiscoverFragment.this, baseQuickAdapter, view, i);
            }
        });
        getMDiscoverBannerAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.t1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                DiscoverFragment.initRecyclerView$lambda$52(DiscoverFragment.this, baseQuickAdapter, view, i);
            }
        });
        final LinearLayout linearLayout3 = getHeadBinding().broadCastMore;
        linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.DiscoverFragment$initRecyclerView$$inlined$singleClick$default$4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout3) > j || (linearLayout3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(linearLayout3, currentTimeMillis);
                    Context context2 = this.getContext();
                    if (context2 != null) {
                        GlobalBroadActivity.INSTANCE.start(context2);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$42(DiscoverFragment discoverFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        discoverFragment.getViewModel().getEventListData().resetPage();
        discoverFragment.getHeadBinding().discoverBroadCast.initDataAndView();
        discoverFragment.getViewModel().getTop3CountryUser();
        discoverFragment.getViewModel().getTop7CountryUser();
        discoverFragment.getViewModel().getGiftWallList();
        discoverFragment.getViewModel().m٧٣getActivityList();
        discoverFragment.getViewModel().getBannerListData();
        discoverFragment.getViewModel().getRankFlipperData();
        discoverFragment.getViewModel().getPowerRankFlipperData();
        discoverFragment.getViewModel().getTop3CpRank();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$43(DiscoverFragment discoverFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        discoverFragment.getViewModel().getBannerListData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$45(DiscoverFragment discoverFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        ActivityDetailData activityDetailData = (ActivityDetailData) discoverFragment.getMDiscoverActivityAdapter().getData().get(i);
        StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
        String groupId = activityDetailData.getGroupId();
        if (groupId == null) {
            groupId = "";
        }
        StartRoomUtils.startRoom$default(startRoomUtils, groupId, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initRecyclerView$lambda$46(DiscoverFragment discoverFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        ActivityDetailData activityDetailData = (ActivityDetailData) discoverFragment.getMDiscoverActivityAdapter().getData().get(i);
        AppRequestUtils appRequestUtils = AppRequestUtils.INSTANCE;
        String groupId = activityDetailData.getGroupId();
        if (groupId == null) {
            groupId = "";
        }
        AppRequestUtils.roomReportOrBlack$default(appRequestUtils, groupId, null, null, 6, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$51(DiscoverFragment discoverFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        CountryCellUIModel countryCellUIModel = (CountryCellUIModel) discoverFragment.getMDiscoverCountryAdapter().getItem(i);
        Context context = discoverFragment.getContext();
        if (context != null) {
            CountryActivity.INSTANCE.start(context, countryCellUIModel.getName(), countryCellUIModel.getShortName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initRecyclerView$lambda$52(DiscoverFragment discoverFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        GroupTopBannerBean groupTopBannerBean = (GroupTopBannerBean) discoverFragment.getMDiscoverBannerAdapter().getItem(i);
        if (groupTopBannerBean.getH5Url().length() > 0) {
            NavigationHelper.jump$default(NavigationHelper.INSTANCE, groupTopBannerBean.getH5Url(), (SuperCallBack) null, 2, (Object) null);
        } else if (groupTopBannerBean.getGroupId().length() > 0) {
            discoverFragment.openMeetingRoomForId(groupTopBannerBean.getGroupId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiscoverActivityAdapter mDiscoverActivityAdapter_delegate$lambda$4() {
        return new DiscoverActivityAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiscoverBannerAdapter mDiscoverBannerAdapter_delegate$lambda$3() {
        return new DiscoverBannerAdapter(R.layout.item_discover_banner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiscoverCountryAdapter mDiscoverCountryAdapter_delegate$lambda$2() {
        return new DiscoverCountryAdapter(R.layout.item_discover_country);
    }

    private final void openMeetingRoomForId(String groupId) {
        if (HiloUtils.INSTANCE.isFastClick()) {
            return;
        }
        StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, groupId, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
    }

    private final void showAvatar(ViewRankFlipperHolderBinding flipperFamilyBinding, List<RankAvatarBean> celebrity) {
        if (!celebrity.isEmpty()) {
            QMUIRadiusImageView qMUIRadiusImageView = flipperFamilyBinding.top1Avatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "top1Avatar");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(celebrity.get(0).getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
        if (celebrity.size() > 1) {
            QMUIRadiusImageView qMUIRadiusImageView2 = flipperFamilyBinding.top2Avatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "top2Avatar");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(celebrity.get(1).getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
        if (celebrity.size() > 2) {
            QMUIRadiusImageView qMUIRadiusImageView3 = flipperFamilyBinding.top3Avatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView3, "top3Avatar");
            ImageKtxKt.loadImage$default(qMUIRadiusImageView3, ImageSizeKt.image100(celebrity.get(2).getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
    }

    private final void showCacheData() {
        List<Country> discoverTop7CountryCache = MMKVToLocalCache.INSTANCE.getDiscoverTop7CountryCache();
        if (discoverTop7CountryCache != null) {
            this.countryData.clear();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(discoverTop7CountryCache, 10));
            Iterator<T> it = discoverTop7CountryCache.iterator();
            while (it.hasNext()) {
                arrayList.add(Boolean.valueOf(this.countryData.add(CountryCellUIModel.INSTANCE.init((Country) it.next()))));
            }
            getMDiscoverCountryAdapter().setList(this.countryData);
        }
        MMKVToLocalCache.Companion companion = MMKVToLocalCache.INSTANCE;
        ArrayList<GroupTopBannerBean> discoverBannerCache = companion.getDiscoverBannerCache();
        if (discoverBannerCache != null) {
            getMDiscoverBannerAdapter().setList(discoverBannerCache);
        }
        AllRankTop3Bean popularRankFlipperCache = companion.getPopularRankFlipperCache();
        if (popularRankFlipperCache != null) {
            fullAllRankFlipperData(popularRankFlipperCache);
        }
        WeekPowerTop3Bean popularPowerFlipperCache = companion.getPopularPowerFlipperCache();
        if (popularPowerFlipperCache != null) {
            fullPowerRankFlipperData(popularPowerFlipperCache);
        }
        CpTop3Bean cpTop3Cache = companion.getCpTop3Cache();
        if (cpTop3Cache != null) {
            fullCpRankFlipperData(cpTop3Cache);
        }
    }

    private final void showCpTopRankAvatar(ViewCpRankFlipperHolderBinding viewCpRankFlipperHolderBinding, String avatar1, String avatar2) {
        QMUIRadiusImageView qMUIRadiusImageView;
        QMUIRadiusImageView qMUIRadiusImageView2;
        if (viewCpRankFlipperHolderBinding != null && (qMUIRadiusImageView2 = viewCpRankFlipperHolderBinding.userAvatar1) != null) {
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(avatar1), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
        if (viewCpRankFlipperHolderBinding != null && (qMUIRadiusImageView = viewCpRankFlipperHolderBinding.userAvatar2) != null) {
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(avatar2), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
    }

    private final void showGiftWallItemView(ViewGiftWallFlipperHolderBinding viewGiftWallFlipperHolderBinding, GiftWallBean it) {
        int i;
        int i2;
        int i3;
        int i4;
        Drawable drawable;
        Integer level;
        Integer level2;
        int i5;
        Integer level3;
        Integer level4;
        int i6 = 0;
        viewGiftWallFlipperHolderBinding.giftPicNumber.setVisibility(0);
        HiloImageView.loadImage$default(viewGiftWallFlipperHolderBinding.sendAvatar, ImageSizeKt.image100(it.getSendUser().getAvatar()), 0, 0, 6, (Object) null);
        ImageView imageView = viewGiftWallFlipperHolderBinding.sendIconVip;
        Boolean isVip = it.getSendUser().isVip();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(isVip, bool)) {
            i = 0;
        } else {
            i = 8;
        }
        imageView.setVisibility(i);
        ImageView imageView2 = viewGiftWallFlipperHolderBinding.receiverIconVip;
        if (Intrinsics.areEqual(it.getReceiveUser().isVip(), bool)) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        imageView2.setVisibility(i2);
        NobleInfo noble = it.getSendUser().getNoble();
        if (noble != null && (level4 = noble.getLevel()) != null) {
            i3 = level4.intValue();
        } else {
            i3 = 0;
        }
        if (i3 > 0) {
            viewGiftWallFlipperHolderBinding.sendIconVip.setVisibility(8);
            viewGiftWallFlipperHolderBinding.sendNoble.setVisibility(0);
            ImageView imageView3 = viewGiftWallFlipperHolderBinding.sendNoble;
            Context context = viewGiftWallFlipperHolderBinding.getRoot().getContext();
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = it.getSendUser().getNoble();
            if (noble2 != null && (level3 = noble2.getLevel()) != null) {
                i5 = level3.intValue();
            } else {
                i5 = 0;
            }
            imageView3.setImageDrawable(androidx.core.content.a.getDrawable(context, companion.getNobleDrawableRes(i5)));
        } else {
            viewGiftWallFlipperHolderBinding.sendNoble.setVisibility(8);
        }
        NobleInfo noble3 = it.getReceiveUser().getNoble();
        if (noble3 != null && (level2 = noble3.getLevel()) != null) {
            i4 = level2.intValue();
        } else {
            i4 = 0;
        }
        if (i4 > 0) {
            viewGiftWallFlipperHolderBinding.receiverIconVip.setVisibility(8);
            viewGiftWallFlipperHolderBinding.receiverNoble.setVisibility(0);
            ImageView imageView4 = viewGiftWallFlipperHolderBinding.receiverNoble;
            Context context2 = getContext();
            if (context2 != null) {
                UserService.Companion companion2 = UserService.INSTANCE;
                NobleInfo noble4 = it.getReceiveUser().getNoble();
                if (noble4 != null && (level = noble4.getLevel()) != null) {
                    i6 = level.intValue();
                }
                drawable = androidx.core.content.a.getDrawable(context2, companion2.getNobleDrawableRes(i6));
            } else {
                drawable = null;
            }
            imageView4.setImageDrawable(drawable);
        } else {
            viewGiftWallFlipperHolderBinding.receiverNoble.setVisibility(8);
        }
        HiloImageView.loadImage$default(viewGiftWallFlipperHolderBinding.receiverAvatar, ImageSizeKt.image100(it.getReceiveUser().getAvatar()), 0, 0, 6, (Object) null);
        ImageView imageView5 = viewGiftWallFlipperHolderBinding.giftPic;
        Intrinsics.checkNotNullExpressionValue(imageView5, "giftPic");
        ImageKtxKt.loadImage$default(imageView5, it.getGiftUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231930, (c5.g) null, 49150, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DiscoverViewModel viewModel_delegate$lambda$1(DiscoverFragment discoverFragment) {
        return new ViewModelProvider(discoverFragment).get(DiscoverViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_discover;
    }

    @SuppressLint({"CheckResult"})
    public final void initView() {
        String str;
        Country countryInfo;
        initRecyclerView();
        initGiftWallFlipper();
        initRankFlipper();
        initPowerFlipper();
        initCpFlipper();
        TextView textView = getHeadBinding().countryName;
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && (countryInfo = user.getCountryInfo()) != null) {
            str = countryInfo.getShortName();
        } else {
            str = null;
        }
        textView.setText(str);
        final ConstraintLayout constraintLayout = getHeadBinding().clCountry;
        final long j = 800;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.DiscoverFragment$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String str2;
                Country countryInfo2;
                String shortName;
                Country countryInfo3;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    UserStore.Companion companion = UserStore.INSTANCE;
                    User user2 = companion.getShared().getUser();
                    String str3 = "";
                    if (user2 == null || (countryInfo3 = user2.getCountryInfo()) == null || (str2 = countryInfo3.getName()) == null) {
                        str2 = "";
                    }
                    User user3 = companion.getShared().getUser();
                    if (user3 != null && (countryInfo2 = user3.getCountryInfo()) != null && (shortName = countryInfo2.getShortName()) != null) {
                        str3 = shortName;
                    }
                    Context context = this.getContext();
                    if (context != null) {
                        CountryActivity.INSTANCE.start(context, str2, str3);
                    }
                }
            }
        });
        final ConstraintLayout constraintLayout2 = getHeadBinding().constraintGift;
        constraintLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.discover.DiscoverFragment$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout2) > j || (constraintLayout2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout2, currentTimeMillis);
                    ConstraintLayout constraintLayout3 = constraintLayout2;
                    Context context = this.getContext();
                    if (context != null) {
                        GiftWallActivity.INSTANCE.start(context);
                    }
                }
            }
        });
    }

    public void onDestroy() {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        getMDiscoverCountryAdapter().setOnItemClickListener((OnItemClickListener) null);
        getMDiscoverBannerAdapter().setOnItemClickListener((OnItemClickListener) null);
        getMDiscoverActivityAdapter().setOnItemClickListener((OnItemClickListener) null);
        getMDiscoverActivityAdapter().setOnItemLongClickListener((OnItemLongClickListener) null);
        FragmentDiscoverBinding fragmentDiscoverBinding = (FragmentDiscoverBinding) getBinding();
        if (fragmentDiscoverBinding != null && (smartRefreshLayout2 = fragmentDiscoverBinding.refreshLayout) != null) {
            smartRefreshLayout2.setOnRefreshListener(null);
        }
        FragmentDiscoverBinding fragmentDiscoverBinding2 = (FragmentDiscoverBinding) getBinding();
        if (fragmentDiscoverBinding2 != null && (smartRefreshLayout = fragmentDiscoverBinding2.refreshLayout) != null) {
            smartRefreshLayout.setOnLoadMoreListener(null);
        }
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }

    public void onPause() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onPause();
        getHeadBinding().giftWallFlipper.stopFlipping();
        getHeadBinding().allRankFlipper.stopFlipping();
        getHeadBinding().powerRankFlipper.stopFlipping();
        getHeadBinding().cpRankFlipper.stopFlipping();
        getHeadBinding().discoverBroadCast.startOrStopAnimation(false);
    }

    public void onResume() {
        int i;
        int i2;
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        getHeadBinding().giftWallFlipper.startFlipping();
        getHeadBinding().allRankFlipper.startFlipping();
        getHeadBinding().powerRankFlipper.startFlipping();
        getHeadBinding().cpRankFlipper.startFlipping();
        getHeadBinding().discoverBroadCast.startOrStopAnimation(true);
        boolean booleanValue = ((Boolean) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "SHOW_COUNTRY_DISCOVER", Boolean.FALSE, (String) null, 4, (Object) null)).booleanValue();
        FrameLayout frameLayout = getHeadBinding().countryFrameLayout;
        int i3 = 8;
        if (booleanValue) {
            i = 0;
        } else {
            i = 8;
        }
        frameLayout.setVisibility(i);
        RecyclerView recyclerView = getHeadBinding().discoverCountryRecycler;
        if (booleanValue) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        recyclerView.setVisibility(i2);
        ConstraintLayout constraintLayout = getHeadBinding().clCountry;
        if (booleanValue) {
            i3 = 0;
        }
        constraintLayout.setVisibility(i3);
    }
}
