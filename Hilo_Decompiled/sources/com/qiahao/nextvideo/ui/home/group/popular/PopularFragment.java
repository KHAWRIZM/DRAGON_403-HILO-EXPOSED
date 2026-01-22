package com.qiahao.nextvideo.ui.home.group.popular;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.cache.MMKVToLocalCache;
import com.qiahao.nextvideo.data.model.DialogItemData;
import com.qiahao.nextvideo.data.model.GroupTopBannerBean;
import com.qiahao.nextvideo.data.model.HotGroupBean;
import com.qiahao.nextvideo.data.model.HotGroupListBean;
import com.qiahao.nextvideo.data.model.MultiHotGroupBean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.FragmentPopularBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.room.manager.GroupEvent;
import com.qiahao.nextvideo.ui.base.BlockOrReportDialog;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.zhpan.bannerview.BannerViewPager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\u0004J\u001d\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000f\u0010\u0004J'\u0010\u0014\u001a\u00020\u00052\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\u0004J\u000f\u0010\u001a\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u0004R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u001b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00104\u001a\u0002008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010 \u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/group/popular/PopularFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentPopularBinding;", "<init>", "()V", "", "initData", "initView", "showCache", "", "Lcom/qiahao/nextvideo/data/model/GroupTopBannerBean;", "activityIngResponseBean", "setBannerData", "(Ljava/util/List;)V", "getAdvertisingData", "getPopularList", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/model/MultiHotGroupBean;", "Lkotlin/collections/ArrayList;", "list", "judgeIsAddMatchGroup", "(Ljava/util/ArrayList;)V", "", "getLayoutResId", "()I", "onInitialize", "onDestroyView", "Lcom/zhpan/bannerview/BannerViewPager;", "mViewPager", "Lcom/zhpan/bannerview/BannerViewPager;", "Lcom/qiahao/nextvideo/ui/home/group/popular/GroupTopBannerPagerAdapter;", "topBannerPagerAdapter$delegate", "Lkotlin/Lazy;", "getTopBannerPagerAdapter", "()Lcom/qiahao/nextvideo/ui/home/group/popular/GroupTopBannerPagerAdapter;", "topBannerPagerAdapter", "matchVideoPage", "Lcom/qiahao/nextvideo/data/model/MultiHotGroupBean;", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "setCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/base_common/model/BaseListData;", "baseData", "Lcom/qiahao/base_common/model/BaseListData;", "Lcom/qiahao/nextvideo/ui/home/group/popular/MultiItemPopularGroupAdapter;", "mPopularGroupAdapter$delegate", "getMPopularGroupAdapter", "()Lcom/qiahao/nextvideo/ui/home/group/popular/MultiItemPopularGroupAdapter;", "mPopularGroupAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPopularFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PopularFragment.kt\ncom/qiahao/nextvideo/ui/home/group/popular/PopularFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,263:1\n1#2:264\n1563#3:265\n1634#3,3:266\n*S KotlinDebug\n*F\n+ 1 PopularFragment.kt\ncom/qiahao/nextvideo/ui/home/group/popular/PopularFragment\n*L\n212#1:265\n212#1:266,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PopularFragment extends BaseBindingFragment<FragmentPopularBinding> {

    @NotNull
    private final BaseListData baseData;

    /* renamed from: mPopularGroupAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mPopularGroupAdapter;
    private BannerViewPager<GroupTopBannerBean> mViewPager;

    /* renamed from: topBannerPagerAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy topBannerPagerAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.group.popular.b
        public final Object invoke() {
            GroupTopBannerPagerAdapter groupTopBannerPagerAdapter;
            groupTopBannerPagerAdapter = PopularFragment.topBannerPagerAdapter_delegate$lambda$0();
            return groupTopBannerPagerAdapter;
        }
    });

    @NotNull
    private MultiHotGroupBean matchVideoPage = MultiHotGroupBean.INSTANCE.newMultiHotGroupBean(0, 2);

    @NotNull
    private nd.a compositeDisposable = new nd.a();

    public PopularFragment() {
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(20);
        this.baseData = baseListData;
        this.mPopularGroupAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.group.popular.c
            public final Object invoke() {
                MultiItemPopularGroupAdapter mPopularGroupAdapter_delegate$lambda$2;
                mPopularGroupAdapter_delegate$lambda$2 = PopularFragment.mPopularGroupAdapter_delegate$lambda$2();
                return mPopularGroupAdapter_delegate$lambda$2;
            }
        });
    }

    private final void getAdvertisingData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().getGroupTopBanner(), new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.popular.f
            public final Object invoke(Object obj) {
                Unit advertisingData$lambda$14;
                advertisingData$lambda$14 = PopularFragment.getAdvertisingData$lambda$14(PopularFragment.this, (ApiResponse) obj);
                return advertisingData$lambda$14;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.popular.g
            public final Object invoke(Object obj) {
                Unit advertisingData$lambda$15;
                advertisingData$lambda$15 = PopularFragment.getAdvertisingData$lambda$15((Throwable) obj);
                return advertisingData$lambda$15;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getAdvertisingData$lambda$14(PopularFragment popularFragment, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        List<GroupTopBannerBean> list = (List) apiResponse.getData();
        if (list != null) {
            MMKVToLocalCache.INSTANCE.savePopularBannerCache(list);
            popularFragment.setBannerData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getAdvertisingData$lambda$15(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MultiItemPopularGroupAdapter getMPopularGroupAdapter() {
        return (MultiItemPopularGroupAdapter) this.mPopularGroupAdapter.getValue();
    }

    private final void getPopularList() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(GroupService.INSTANCE.getInstance().getPopularViewList(this.baseData.nextPage(), this.baseData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.popular.d
            public final Object invoke(Object obj) {
                Unit popularList$lambda$18;
                popularList$lambda$18 = PopularFragment.getPopularList$lambda$18(PopularFragment.this, (ApiResponse) obj);
                return popularList$lambda$18;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.home.group.popular.e
            public final Object invoke(Object obj) {
                Unit popularList$lambda$19;
                popularList$lambda$19 = PopularFragment.getPopularList$lambda$19(PopularFragment.this, (Throwable) obj);
                return popularList$lambda$19;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPopularList$lambda$18(PopularFragment popularFragment, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        HotGroupListBean hotGroupListBean = (HotGroupListBean) apiResponse.getData();
        if (hotGroupListBean != null) {
            List<HotGroupBean> data = hotGroupListBean.getData();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(data, 10));
            Iterator<T> it = data.iterator();
            while (it.hasNext()) {
                arrayList.add(MultiHotGroupBean.INSTANCE.newMultiHotGroupBean((HotGroupBean) it.next()));
            }
            List mutableList = CollectionsKt.toMutableList(arrayList);
            Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.nextvideo.data.model.MultiHotGroupBean>");
            ArrayList<MultiHotGroupBean> arrayList2 = (ArrayList) mutableList;
            ArrayList<String> blockRoomIdList = GroupService.INSTANCE.getInstance().getBlockRoomIdList();
            if (blockRoomIdList != null) {
                Iterator<MultiHotGroupBean> it2 = arrayList2.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    if (blockRoomIdList.contains(it2.next().getGroupId())) {
                        it2.remove();
                    }
                }
            }
            if (popularFragment.baseData.isOnePage()) {
                MMKVToLocalCache.INSTANCE.saveNewGroupPopularCache(arrayList2);
                popularFragment.judgeIsAddMatchGroup(arrayList2);
                popularFragment.getMPopularGroupAdapter().setList(arrayList2);
            } else {
                popularFragment.getMPopularGroupAdapter().addData(arrayList2);
            }
            popularFragment.baseData.setList(arrayList2);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit getPopularList$lambda$19(PopularFragment popularFragment, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        popularFragment.baseData.requestError();
        return Unit.INSTANCE;
    }

    private final GroupTopBannerPagerAdapter getTopBannerPagerAdapter() {
        return (GroupTopBannerPagerAdapter) this.topBannerPagerAdapter.getValue();
    }

    @SuppressLint({"CheckResult"})
    private final void initData() {
        this.baseData.resetPage();
        getPopularList();
        getAdvertisingData();
        nd.c l = GroupService.INSTANCE.getMGroupEventProcessorObservable().l(new pd.g() { // from class: com.qiahao.nextvideo.ui.home.group.popular.PopularFragment$initData$1
            public final void accept(GroupEvent groupEvent) {
                MultiItemPopularGroupAdapter mPopularGroupAdapter;
                MultiItemPopularGroupAdapter mPopularGroupAdapter2;
                Intrinsics.checkNotNullParameter(groupEvent, "it");
                if (groupEvent.getMEventId() == 14) {
                    mPopularGroupAdapter = PopularFragment.this.getMPopularGroupAdapter();
                    int i = 0;
                    int i2 = -1;
                    for (T t : mPopularGroupAdapter.getData()) {
                        int i3 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (Intrinsics.areEqual(((MultiHotGroupBean) t).getGroupId(), groupEvent.getMGroupId())) {
                            i2 = i;
                        }
                        i = i3;
                    }
                    if (i2 != -1) {
                        mPopularGroupAdapter2 = PopularFragment.this.getMPopularGroupAdapter();
                        mPopularGroupAdapter2.removeAt(i2);
                    }
                }
            }
        });
        Intrinsics.checkNotNullExpressionValue(l, "subscribe(...)");
        RxUtilsKt.addTo(l, this.compositeDisposable);
    }

    private final void initView() {
        SmartRefreshLayout smartRefreshLayout;
        SuperStatusView superStatusView;
        BannerViewPager<GroupTopBannerBean> bannerViewPager;
        RecyclerView recyclerView;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        BaseListData baseListData = this.baseData;
        FragmentPopularBinding fragmentPopularBinding = (FragmentPopularBinding) getBinding();
        BannerViewPager<GroupTopBannerBean> bannerViewPager2 = null;
        if (fragmentPopularBinding != null) {
            smartRefreshLayout = fragmentPopularBinding.refreshLayout;
        } else {
            smartRefreshLayout = null;
        }
        FragmentPopularBinding fragmentPopularBinding2 = (FragmentPopularBinding) getBinding();
        if (fragmentPopularBinding2 != null) {
            superStatusView = fragmentPopularBinding2.statusView;
        } else {
            superStatusView = null;
        }
        baseListData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView);
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentPopularBinding fragmentPopularBinding3 = (FragmentPopularBinding) getBinding();
            if (fragmentPopularBinding3 != null && (smartRefreshLayout4 = fragmentPopularBinding3.refreshLayout) != null) {
                smartRefreshLayout4.setRefreshFooter(footLoading);
            }
        }
        FragmentPopularBinding fragmentPopularBinding4 = (FragmentPopularBinding) getBinding();
        if (fragmentPopularBinding4 != null) {
            bannerViewPager = fragmentPopularBinding4.bannerView;
        } else {
            bannerViewPager = null;
        }
        Intrinsics.checkNotNull(bannerViewPager, "null cannot be cast to non-null type com.zhpan.bannerview.BannerViewPager<com.qiahao.nextvideo.data.model.GroupTopBannerBean>");
        this.mViewPager = bannerViewPager;
        if (bannerViewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            bannerViewPager = null;
        }
        GroupTopBannerPagerAdapter topBannerPagerAdapter = getTopBannerPagerAdapter();
        topBannerPagerAdapter.setOnChildClickListener(new TopBannerPagerAdapterListener() { // from class: com.qiahao.nextvideo.ui.home.group.popular.PopularFragment$initView$3$1
            @Override // com.qiahao.nextvideo.ui.home.group.popular.TopBannerPagerAdapterListener
            public void click(GroupTopBannerBean data) {
                AppService service;
                Intrinsics.checkNotNullParameter(data, "data");
                if (data.getH5Url().length() > 0) {
                    NavigationHelper.jump$default(NavigationHelper.INSTANCE, data.getActionUrl(), (SuperCallBack) null, 2, (Object) null);
                } else if (data.getGroupId().length() > 0 && (service = AppController.INSTANCE.getService()) != null) {
                    service.joinLive(data.getGroupId());
                }
            }
        });
        bannerViewPager.G(topBannerPagerAdapter);
        BannerViewPager<GroupTopBannerBean> bannerViewPager3 = this.mViewPager;
        if (bannerViewPager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            bannerViewPager2 = bannerViewPager3;
        }
        bannerViewPager2.g();
        FragmentPopularBinding fragmentPopularBinding5 = (FragmentPopularBinding) getBinding();
        if (fragmentPopularBinding5 != null && (smartRefreshLayout3 = fragmentPopularBinding5.refreshLayout) != null) {
            smartRefreshLayout3.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.home.group.popular.h
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    PopularFragment.initView$lambda$6(PopularFragment.this, fVar);
                }
            });
        }
        FragmentPopularBinding fragmentPopularBinding6 = (FragmentPopularBinding) getBinding();
        if (fragmentPopularBinding6 != null && (smartRefreshLayout2 = fragmentPopularBinding6.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.home.group.popular.i
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    PopularFragment.initView$lambda$7(PopularFragment.this, fVar);
                }
            });
        }
        getMPopularGroupAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.group.popular.j
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                PopularFragment.initView$lambda$8(PopularFragment.this, baseQuickAdapter, view, i);
            }
        });
        getMPopularGroupAdapter().setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.qiahao.nextvideo.ui.home.group.popular.k
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                boolean initView$lambda$9;
                initView$lambda$9 = PopularFragment.initView$lambda$9(PopularFragment.this, baseQuickAdapter, view, i);
                return initView$lambda$9;
            }
        });
        FragmentPopularBinding fragmentPopularBinding7 = (FragmentPopularBinding) getBinding();
        if (fragmentPopularBinding7 != null && (recyclerView = fragmentPopularBinding7.recyclerView) != null) {
            recyclerView.setAdapter(getMPopularGroupAdapter());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(PopularFragment popularFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        popularFragment.initData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(PopularFragment popularFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        popularFragment.getPopularList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(PopularFragment popularFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        MultiHotGroupBean multiHotGroupBean = (MultiHotGroupBean) popularFragment.getMPopularGroupAdapter().getData().get(i);
        int itemType = multiHotGroupBean.getItemType();
        if (itemType != 1) {
            if (itemType == 2) {
                cf.c.c().l(new VideoEvent("HOME_PAGE_MATCH", new Object()));
            }
        } else {
            if (HiloUtils.INSTANCE.isFastClick()) {
                return;
            }
            StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, multiHotGroupBean.getGroupId(), multiHotGroupBean.getCode(), multiHotGroupBean.getFaceUrl(), multiHotGroupBean.getName(), Boolean.valueOf(multiHotGroupBean.getHasPassWord()), multiHotGroupBean.getCountryIcon(), multiHotGroupBean.getIntroduction(), multiHotGroupBean.getNotification(), 0, 0, null, 0, false, 7936, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean initView$lambda$9(PopularFragment popularFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        MultiHotGroupBean multiHotGroupBean = (MultiHotGroupBean) popularFragment.getMPopularGroupAdapter().getData().get(i);
        ArrayList textList$default = BlockOrReportDialog.Companion.getTextList$default(BlockOrReportDialog.INSTANCE, BlockOrReportDialog.ROOM_LIST_REPORT_AND_DELETE, false, false, false, 14, null);
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && user.isOfficialStaff()) {
            textList$default.add(new DialogItemData(ResourcesKtxKt.getStringById(popularFragment, 2131953554), 100));
        }
        AppRequestUtils.roomReportOrBlack$default(AppRequestUtils.INSTANCE, multiHotGroupBean.getGroupId(), null, textList$default, 2, null);
        return true;
    }

    private final void judgeIsAddMatchGroup(ArrayList<MultiHotGroupBean> list) {
        if (this.baseData.isOnePage() && !list.contains(this.matchVideoPage)) {
            if (list.size() > 11) {
                list.add(11, this.matchVideoPage);
            } else {
                list.add(this.matchVideoPage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MultiItemPopularGroupAdapter mPopularGroupAdapter_delegate$lambda$2() {
        return new MultiItemPopularGroupAdapter();
    }

    private final void setBannerData(List<GroupTopBannerBean> activityIngResponseBean) {
        Context context = getContext();
        if (context != null) {
            BannerViewPager<GroupTopBannerBean> bannerViewPager = this.mViewPager;
            BannerViewPager<GroupTopBannerBean> bannerViewPager2 = null;
            if (bannerViewPager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                bannerViewPager = null;
            }
            bannerViewPager.L(4).P(4).N(dd.a.a(6.0f)).K(dd.a.a(6.0f)).M(androidx.core.content.a.getColor(context, 2131100055), androidx.core.content.a.getColor(context, 2131100060)).O(dd.a.a(6.0f), dd.a.a(10.0f));
            BannerViewPager<GroupTopBannerBean> bannerViewPager3 = this.mViewPager;
            if (bannerViewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            } else {
                bannerViewPager2 = bannerViewPager3;
            }
            bannerViewPager2.C(activityIngResponseBean);
        }
    }

    private final void showCache() {
        List<MultiHotGroupBean> newChatPopularCache = MMKVToLocalCache.INSTANCE.getNewChatPopularCache();
        if (newChatPopularCache != null) {
            List mutableList = CollectionsKt.toMutableList(newChatPopularCache);
            Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.nextvideo.data.model.MultiHotGroupBean>");
            ArrayList arrayList = (ArrayList) mutableList;
            ArrayList<String> blockRoomIdList = GroupService.INSTANCE.getInstance().getBlockRoomIdList();
            if (blockRoomIdList != null) {
                Iterator it = arrayList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    if (blockRoomIdList.contains(((MultiHotGroupBean) it.next()).getGroupId())) {
                        it.remove();
                    }
                }
            }
            getMPopularGroupAdapter().setList(arrayList);
        }
        List<GroupTopBannerBean> popularBannerCache = MMKVToLocalCache.INSTANCE.getPopularBannerCache();
        if (popularBannerCache != null) {
            setBannerData(popularBannerCache);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GroupTopBannerPagerAdapter topBannerPagerAdapter_delegate$lambda$0() {
        return new GroupTopBannerPagerAdapter();
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    protected int getLayoutResId() {
        return R.layout.fragment_popular;
    }

    public void onDestroyView() {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        getMPopularGroupAdapter().setOnItemClickListener((OnItemClickListener) null);
        getMPopularGroupAdapter().setOnItemLongClickListener((OnItemLongClickListener) null);
        FragmentPopularBinding fragmentPopularBinding = (FragmentPopularBinding) getBinding();
        if (fragmentPopularBinding != null && (smartRefreshLayout2 = fragmentPopularBinding.refreshLayout) != null) {
            smartRefreshLayout2.setOnRefreshListener(null);
        }
        FragmentPopularBinding fragmentPopularBinding2 = (FragmentPopularBinding) getBinding();
        if (fragmentPopularBinding2 != null && (smartRefreshLayout = fragmentPopularBinding2.refreshLayout) != null) {
            smartRefreshLayout.setOnLoadMoreListener(null);
        }
        this.compositeDisposable.d();
        this.baseData.destroy();
        super.onDestroyView();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        showCache();
        initData();
    }

    public final void setCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.compositeDisposable = aVar;
    }
}
