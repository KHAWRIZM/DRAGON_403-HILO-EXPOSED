package com.qiahao.nextvideo.ui.task;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.utils.FragmentUtils;
import com.oudi.widget.ViewKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.RoomAndPersonalBannerBean;
import com.qiahao.nextvideo.databinding.ActivityRoomAndPersonalTaskBinding;
import com.zhpan.bannerview.BannerViewPager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0014J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\b\u0010\u001c\u001a\u00020\u001aH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\u0016\u0010\u001e\u001a\u00020\u001a2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00160 H\u0002J\b\u0010!\u001a\u00020\u001aH\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/ui/task/RoomTaskFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/ActivityRoomAndPersonalTaskBinding;", "<init>", "()V", "topBannerPagerAdapter", "Lcom/qiahao/nextvideo/ui/task/RoomPersonalTaskBannerPagerAdapter;", "getTopBannerPagerAdapter", "()Lcom/qiahao/nextvideo/ui/task/RoomPersonalTaskBannerPagerAdapter;", "topBannerPagerAdapter$delegate", "Lkotlin/Lazy;", "mFragments", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "Lkotlin/collections/ArrayList;", "viewModel", "Lcom/qiahao/nextvideo/ui/task/RoomAndPersonalTaskViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/task/RoomAndPersonalTaskViewModel;", "viewModel$delegate", "mViewPager", "Lcom/zhpan/bannerview/BannerViewPager;", "Lcom/qiahao/nextvideo/data/model/RoomAndPersonalBannerBean;", "getLayoutResId", "", "onInitialize", "", "initView", "initTabLayoutAndViewPager", "initObserver", "setBannerData", "activityIngResponseBean", "", "onDestroy", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomTaskFragment extends BaseBindingFragment<ActivityRoomAndPersonalTaskBinding> {

    @Nullable
    private BannerViewPager<RoomAndPersonalBannerBean> mViewPager;

    /* renamed from: topBannerPagerAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy topBannerPagerAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.task.i1
        public final Object invoke() {
            RoomPersonalTaskBannerPagerAdapter roomPersonalTaskBannerPagerAdapter;
            roomPersonalTaskBannerPagerAdapter = RoomTaskFragment.topBannerPagerAdapter_delegate$lambda$0();
            return roomPersonalTaskBannerPagerAdapter;
        }
    });

    @NotNull
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.task.j1
        public final Object invoke() {
            RoomAndPersonalTaskViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = RoomTaskFragment.viewModel_delegate$lambda$1(RoomTaskFragment.this);
            return viewModel_delegate$lambda$1;
        }
    });

    private final RoomPersonalTaskBannerPagerAdapter getTopBannerPagerAdapter() {
        return (RoomPersonalTaskBannerPagerAdapter) this.topBannerPagerAdapter.getValue();
    }

    private final RoomAndPersonalTaskViewModel getViewModel() {
        return (RoomAndPersonalTaskViewModel) this.viewModel.getValue();
    }

    private final void initObserver() {
        getViewModel().getPersonalAndRoomBanner().observe(this, new RoomTaskFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.task.k1
            public final Object invoke(Object obj) {
                Unit initObserver$lambda$12;
                initObserver$lambda$12 = RoomTaskFragment.initObserver$lambda$12(RoomTaskFragment.this, (List) obj);
                return initObserver$lambda$12;
            }
        }));
        getViewModel().m٩٠getPersonalAndRoomBanner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initObserver$lambda$12(RoomTaskFragment roomTaskFragment, List list) {
        if (list != null) {
            roomTaskFragment.setBannerData(list);
        }
        return Unit.INSTANCE;
    }

    private final void initTabLayoutAndViewPager() {
        ActivityRoomAndPersonalTaskBinding activityRoomAndPersonalTaskBinding = (ActivityRoomAndPersonalTaskBinding) getBinding();
        if (activityRoomAndPersonalTaskBinding != null) {
            if (this.mFragments.isEmpty()) {
                FragmentUtils fragmentUtils = FragmentUtils.INSTANCE;
                RoomAndPersonalTaskFragment findFragment = fragmentUtils.findFragment(getChildFragmentManager(), RoomAndPersonalTaskFragment.class);
                if (findFragment == null) {
                    findFragment = new RoomAndPersonalTaskFragment();
                    Bundle bundle = new Bundle();
                    bundle.putInt(RoomAndPersonalTaskFragment.TASK_TYPE, 1);
                    findFragment.setArguments(bundle);
                }
                this.mFragments.add(findFragment);
                RoomAndPersonalTaskFragment findFragment2 = fragmentUtils.findFragment(getChildFragmentManager(), RoomAndPersonalTaskFragment.class);
                if (findFragment2 == null) {
                    findFragment2 = new RoomAndPersonalTaskFragment();
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt(RoomAndPersonalTaskFragment.TASK_TYPE, 2);
                    findFragment2.setArguments(bundle2);
                }
                this.mFragments.add(findFragment2);
            }
            activityRoomAndPersonalTaskBinding.viewPager.setAdapter(new TaskViewPagerAdapter(this, this.mFragments));
            ViewPage2TabLayout viewPage2TabLayout = activityRoomAndPersonalTaskBinding.segmentTabLayout;
            ViewPager2 viewPager2 = activityRoomAndPersonalTaskBinding.viewPager;
            Intrinsics.checkNotNullExpressionValue(viewPager2, "viewPager");
            viewPage2TabLayout.setViewPager2(viewPager2, new RoomAndPersonalTaskTabAdapter());
            Intrinsics.checkNotNull(viewPage2TabLayout);
            ViewKtxKt.disableTooltipText(viewPage2TabLayout);
            activityRoomAndPersonalTaskBinding.viewPager.setCurrentItem(0);
        }
    }

    private final void initView() {
        ActivityRoomAndPersonalTaskBinding activityRoomAndPersonalTaskBinding = (ActivityRoomAndPersonalTaskBinding) getBinding();
        if (activityRoomAndPersonalTaskBinding != null) {
            ConstraintLayout constraintLayout = activityRoomAndPersonalTaskBinding.listContainer;
            ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
            constraintLayout.setBackground(ShapeUtil.createShape$default(shapeUtil, "#FFFFFF", "#FFFFFF", 16, 16, 0, 0, (GradientDrawable.Orientation) null, 112, (Object) null));
            activityRoomAndPersonalTaskBinding.segmentTabLayout.setBackground(ShapeUtil.createShape$default(shapeUtil, "#F5F6F7", "#F5F6F7", 32, (GradientDrawable.Orientation) null, 8, (Object) null));
            initTabLayoutAndViewPager();
            BannerViewPager<RoomAndPersonalBannerBean> bannerViewPager = activityRoomAndPersonalTaskBinding.bannerView;
            Intrinsics.checkNotNull(bannerViewPager, "null cannot be cast to non-null type com.zhpan.bannerview.BannerViewPager<com.qiahao.nextvideo.data.model.RoomAndPersonalBannerBean>");
            this.mViewPager = bannerViewPager;
            if (bannerViewPager != null) {
                RoomPersonalTaskBannerPagerAdapter topBannerPagerAdapter = getTopBannerPagerAdapter();
                topBannerPagerAdapter.setTopBannerPagerAdapterListener(new Function1() { // from class: com.qiahao.nextvideo.ui.task.l1
                    public final Object invoke(Object obj) {
                        Unit initView$lambda$4$lambda$3$lambda$2;
                        initView$lambda$4$lambda$3$lambda$2 = RoomTaskFragment.initView$lambda$4$lambda$3$lambda$2((RoomAndPersonalBannerBean) obj);
                        return initView$lambda$4$lambda$3$lambda$2;
                    }
                });
                bannerViewPager.G(topBannerPagerAdapter);
            }
            BannerViewPager<RoomAndPersonalBannerBean> bannerViewPager2 = this.mViewPager;
            if (bannerViewPager2 != null) {
                bannerViewPager2.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$4$lambda$3$lambda$2(RoomAndPersonalBannerBean roomAndPersonalBannerBean) {
        Intrinsics.checkNotNullParameter(roomAndPersonalBannerBean, "it");
        String url = roomAndPersonalBannerBean.getUrl();
        if (url != null && url.length() != 0) {
            NavigationHelper.jump$default(NavigationHelper.INSTANCE, roomAndPersonalBannerBean.getUrl(), (SuperCallBack) null, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }

    private final void setBannerData(List<RoomAndPersonalBannerBean> activityIngResponseBean) {
        BannerViewPager<RoomAndPersonalBannerBean> bannerViewPager = this.mViewPager;
        if (bannerViewPager != null) {
            bannerViewPager.C(activityIngResponseBean);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomPersonalTaskBannerPagerAdapter topBannerPagerAdapter_delegate$lambda$0() {
        return new RoomPersonalTaskBannerPagerAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RoomAndPersonalTaskViewModel viewModel_delegate$lambda$1(RoomTaskFragment roomTaskFragment) {
        return new ViewModelProvider(roomTaskFragment).get(RoomAndPersonalTaskViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.activity_room_and_personal_task;
    }

    public void onDestroy() {
        BannerViewPager<RoomAndPersonalBannerBean> bannerViewPager = this.mViewPager;
        if (bannerViewPager != null) {
            bannerViewPager.onDestroy();
        }
        this.mFragments.clear();
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initObserver();
    }
}
