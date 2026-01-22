package com.qiahao.nextvideo.ui.transfer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;
import com.flyco.tablayout.SlidingTabLayout;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.adapter.CommonFragmentStatePagerAdapter;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.transfer.TransferBanner;
import com.qiahao.nextvideo.data.transfer.TransferMonth;
import com.qiahao.nextvideo.data.transfer.TransferPeriod;
import com.qiahao.nextvideo.databinding.FragmentTransferCenterBinding;
import com.qiahao.nextvideo.databinding.IncludeTransferTextBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.zhpan.bannerview.BannerViewPager;
import java.util.ArrayList;
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
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0003J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\tj\b\u0012\u0004\u0012\u00020\u0006`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/TransferCenterFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentTransferCenterBinding;", "<init>", "()V", "mWeekFragment", "Lcom/qiahao/nextvideo/ui/transfer/TransferCenterDetailFragment;", "mMonthFragment", "mFragmentList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mType", "", "getMType", "()Ljava/lang/String;", "setMType", "(Ljava/lang/String;)V", "mViewModel", "Lcom/qiahao/nextvideo/ui/transfer/TransferCenterViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/ui/transfer/TransferCenterViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "bannerAdapter", "Lcom/qiahao/nextvideo/ui/transfer/TransferBannerAdapter;", "getBannerAdapter", "()Lcom/qiahao/nextvideo/ui/transfer/TransferBannerAdapter;", "bannerAdapter$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "initBanner", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTransferCenterFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TransferCenterFragment.kt\ncom/qiahao/nextvideo/ui/transfer/TransferCenterFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,148:1\n1#2:149\n1869#3,2:150\n*S KotlinDebug\n*F\n+ 1 TransferCenterFragment.kt\ncom/qiahao/nextvideo/ui/transfer/TransferCenterFragment\n*L\n62#1:150,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TransferCenterFragment extends BaseBindingFragment<FragmentTransferCenterBinding> {

    @NotNull
    public static final String CENTER_TYPE = "center_type";

    @NotNull
    public static final String TYPE_DIAMONDS = "diamonds";

    @NotNull
    public static final String TYPE_GOLDS = "golds";

    @Nullable
    private TransferCenterDetailFragment mMonthFragment;

    @Nullable
    private TransferCenterDetailFragment mWeekFragment;

    @NotNull
    private ArrayList<TransferCenterDetailFragment> mFragmentList = new ArrayList<>();

    @NotNull
    private String mType = TYPE_DIAMONDS;

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.f1
        public final Object invoke() {
            TransferCenterViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = TransferCenterFragment.mViewModel_delegate$lambda$0(TransferCenterFragment.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    /* renamed from: bannerAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy bannerAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.transfer.g1
        public final Object invoke() {
            TransferBannerAdapter bannerAdapter_delegate$lambda$1;
            bannerAdapter_delegate$lambda$1 = TransferCenterFragment.bannerAdapter_delegate$lambda$1();
            return bannerAdapter_delegate$lambda$1;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransferBannerAdapter bannerAdapter_delegate$lambda$1() {
        return new TransferBannerAdapter();
    }

    private final TransferBannerAdapter getBannerAdapter() {
        return (TransferBannerAdapter) this.bannerAdapter.getValue();
    }

    private final TransferCenterViewModel getMViewModel() {
        return (TransferCenterViewModel) this.mViewModel.getValue();
    }

    private final void initBanner() {
        final BannerViewPager bannerViewPager;
        FragmentTransferCenterBinding fragmentTransferCenterBinding = (FragmentTransferCenterBinding) getBinding();
        if (fragmentTransferCenterBinding != null) {
            bannerViewPager = fragmentTransferCenterBinding.banner;
        } else {
            bannerViewPager = null;
        }
        Intrinsics.checkNotNull(bannerViewPager, "null cannot be cast to non-null type com.zhpan.bannerview.BannerViewPager<com.qiahao.nextvideo.data.transfer.TransferBanner>");
        bannerViewPager.G(getBannerAdapter());
        bannerViewPager.T(new BannerViewPager.b() { // from class: com.qiahao.nextvideo.ui.transfer.e1
            @Override // com.zhpan.bannerview.BannerViewPager.b
            public final void a(View view, int i) {
                TransferCenterFragment.initBanner$lambda$12(BannerViewPager.this, view, i);
            }
        });
        bannerViewPager.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBanner$lambda$12(BannerViewPager bannerViewPager, View view, int i) {
        NavigationHelper.jump$default(NavigationHelper.INSTANCE, ((TransferBanner) bannerViewPager.getData().get(i)).getH5Url(), (SuperCallBack) null, 2, (Object) null);
    }

    @SuppressLint({"SetTextI18n"})
    private final void initData() {
        getMViewModel().getBannerData().observe(this, new TransferCenterFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.b1
            public final Object invoke(Object obj) {
                Unit initData$lambda$2;
                initData$lambda$2 = TransferCenterFragment.initData$lambda$2(TransferCenterFragment.this, (ArrayList) obj);
                return initData$lambda$2;
            }
        }));
        getMViewModel().getPeriod().observe(this, new TransferCenterFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.c1
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = TransferCenterFragment.initData$lambda$5(TransferCenterFragment.this, (TransferPeriod) obj);
                return initData$lambda$5;
            }
        }));
        getMViewModel().getTransferMonth().observe(this, new TransferCenterFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.transfer.d1
            public final Object invoke(Object obj) {
                Unit initData$lambda$6;
                initData$lambda$6 = TransferCenterFragment.initData$lambda$6(TransferCenterFragment.this, (TransferMonth) obj);
                return initData$lambda$6;
            }
        }));
        getMViewModel().transferBanners(!Intrinsics.areEqual(this.mType, TYPE_DIAMONDS) ? 1 : 0);
        getMViewModel().transferPeriod();
        getMViewModel().transferMonth(!Intrinsics.areEqual(this.mType, TYPE_DIAMONDS) ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$2(TransferCenterFragment transferCenterFragment, ArrayList arrayList) {
        BannerViewPager bannerViewPager;
        FragmentTransferCenterBinding fragmentTransferCenterBinding = (FragmentTransferCenterBinding) transferCenterFragment.getBinding();
        if (fragmentTransferCenterBinding != null && (bannerViewPager = fragmentTransferCenterBinding.banner) != null) {
            bannerViewPager.C(arrayList);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(TransferCenterFragment transferCenterFragment, TransferPeriod transferPeriod) {
        for (TransferCenterDetailFragment transferCenterDetailFragment : transferCenterFragment.mFragmentList) {
            if (transferPeriod != null) {
                transferCenterDetailFragment.refreshPeriodData(transferPeriod);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$6(TransferCenterFragment transferCenterFragment, TransferMonth transferMonth) {
        IncludeTransferTextBinding includeTransferTextBinding;
        TextView textView;
        String str;
        Integer clients;
        IncludeTransferTextBinding includeTransferTextBinding2;
        TextView textView2;
        Long totalC;
        IncludeTransferTextBinding includeTransferTextBinding3;
        TextView textView3;
        long j;
        Long dollar;
        FragmentTransferCenterBinding fragmentTransferCenterBinding = (FragmentTransferCenterBinding) transferCenterFragment.getBinding();
        long j2 = 0;
        if (fragmentTransferCenterBinding != null && (includeTransferTextBinding3 = fragmentTransferCenterBinding.sales) != null && (textView3 = includeTransferTextBinding3.number) != null) {
            if (transferMonth != null && (dollar = transferMonth.getDollar()) != null) {
                j = dollar.longValue();
            } else {
                j = 0;
            }
            textView3.setText("$" + NumberUtilsKt.rankNumberFormat(j / 100));
        }
        FragmentTransferCenterBinding fragmentTransferCenterBinding2 = (FragmentTransferCenterBinding) transferCenterFragment.getBinding();
        if (fragmentTransferCenterBinding2 != null && (includeTransferTextBinding2 = fragmentTransferCenterBinding2.diamonds) != null && (textView2 = includeTransferTextBinding2.number) != null) {
            if (transferMonth != null && (totalC = transferMonth.getTotalC()) != null) {
                j2 = totalC.longValue();
            }
            textView2.setText("$" + NumberUtilsKt.rankNumberFormat(j2 / 100));
        }
        FragmentTransferCenterBinding fragmentTransferCenterBinding3 = (FragmentTransferCenterBinding) transferCenterFragment.getBinding();
        if (fragmentTransferCenterBinding3 != null && (includeTransferTextBinding = fragmentTransferCenterBinding3.clients) != null && (textView = includeTransferTextBinding.number) != null) {
            if (transferMonth == null || (clients = transferMonth.getClients()) == null || (str = clients.toString()) == null) {
                str = MessageService.MSG_DB_READY_REPORT;
            }
            textView.setText(str);
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        String str;
        ViewPager viewPager;
        SlidingTabLayout slidingTabLayout;
        SlidingTabLayout slidingTabLayout2;
        SlidingTabLayout slidingTabLayout3;
        ViewPager viewPager2;
        ViewPager viewPager3;
        View view;
        Drawable drawable;
        View view2;
        IncludeTransferTextBinding includeTransferTextBinding;
        TextView textView;
        IncludeTransferTextBinding includeTransferTextBinding2;
        TextView textView2;
        IncludeTransferTextBinding includeTransferTextBinding3;
        TextView textView3;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(CENTER_TYPE)) == null) {
            str = TYPE_DIAMONDS;
        }
        this.mType = str;
        initBanner();
        FragmentTransferCenterBinding fragmentTransferCenterBinding = (FragmentTransferCenterBinding) getBinding();
        if (fragmentTransferCenterBinding != null && (includeTransferTextBinding3 = fragmentTransferCenterBinding.sales) != null && (textView3 = includeTransferTextBinding3.title) != null) {
            textView3.setText(ResourcesKtxKt.getStringById(this, 2131954300));
        }
        FragmentTransferCenterBinding fragmentTransferCenterBinding2 = (FragmentTransferCenterBinding) getBinding();
        if (fragmentTransferCenterBinding2 != null && (includeTransferTextBinding2 = fragmentTransferCenterBinding2.diamonds) != null && (textView2 = includeTransferTextBinding2.title) != null) {
            textView2.setText(ResourcesKtxKt.getStringById(this, 2131953850));
        }
        FragmentTransferCenterBinding fragmentTransferCenterBinding3 = (FragmentTransferCenterBinding) getBinding();
        if (fragmentTransferCenterBinding3 != null && (includeTransferTextBinding = fragmentTransferCenterBinding3.clients) != null && (textView = includeTransferTextBinding.title) != null) {
            textView.setText(ResourcesKtxKt.getStringById(this, 2131952270));
        }
        FragmentTransferCenterBinding fragmentTransferCenterBinding4 = (FragmentTransferCenterBinding) getBinding();
        if (fragmentTransferCenterBinding4 != null && (view2 = fragmentTransferCenterBinding4.thisView) != null) {
            view2.setBackground(ShapeUtil.INSTANCE.createShape("#8850f6", "#b043ff", 4, GradientDrawable.Orientation.TOP_BOTTOM));
        }
        FragmentTransferCenterBinding fragmentTransferCenterBinding5 = (FragmentTransferCenterBinding) getBinding();
        ViewPager viewPager4 = null;
        if (fragmentTransferCenterBinding5 != null && (view = fragmentTransferCenterBinding5.monthBg) != null) {
            Context context = getContext();
            if (context != null) {
                drawable = ShapeUtil.createShape$default(ShapeUtil.INSTANCE, context, 2131101214, 2131101214, 5, (GradientDrawable.Orientation) null, false, 48, (Object) null);
            } else {
                drawable = null;
            }
            view.setBackground(drawable);
        }
        if (this.mWeekFragment == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("transfer_type", 0);
            bundle.putString(CENTER_TYPE, this.mType);
            TransferCenterDetailFragment transferCenterDetailFragment = new TransferCenterDetailFragment();
            transferCenterDetailFragment.setArguments(bundle);
            this.mWeekFragment = transferCenterDetailFragment;
            this.mFragmentList.add(transferCenterDetailFragment);
        }
        if (this.mMonthFragment == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("transfer_type", 1);
            bundle2.putString(CENTER_TYPE, this.mType);
            TransferCenterDetailFragment transferCenterDetailFragment2 = new TransferCenterDetailFragment();
            transferCenterDetailFragment2.setArguments(bundle2);
            this.mMonthFragment = transferCenterDetailFragment2;
            this.mFragmentList.add(transferCenterDetailFragment2);
        }
        FragmentTransferCenterBinding fragmentTransferCenterBinding6 = (FragmentTransferCenterBinding) getBinding();
        if (fragmentTransferCenterBinding6 != null && (viewPager3 = fragmentTransferCenterBinding6.viewPager) != null) {
            viewPager3.setOffscreenPageLimit(2);
        }
        FragmentTransferCenterBinding fragmentTransferCenterBinding7 = (FragmentTransferCenterBinding) getBinding();
        if (fragmentTransferCenterBinding7 != null && (viewPager2 = fragmentTransferCenterBinding7.viewPager) != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            viewPager2.setAdapter(new CommonFragmentStatePagerAdapter(childFragmentManager, this.mFragmentList, (List) null, 4, (DefaultConstructorMarker) null));
        }
        String[] strArr = {ResourcesKtxKt.getStringById(this, 2131954482), ResourcesKtxKt.getStringById(this, 2131953415)};
        FragmentTransferCenterBinding fragmentTransferCenterBinding8 = (FragmentTransferCenterBinding) getBinding();
        if (fragmentTransferCenterBinding8 != null && (slidingTabLayout3 = fragmentTransferCenterBinding8.tabLayout) != null) {
            FragmentTransferCenterBinding fragmentTransferCenterBinding9 = (FragmentTransferCenterBinding) getBinding();
            if (fragmentTransferCenterBinding9 != null) {
                viewPager4 = fragmentTransferCenterBinding9.viewPager;
            }
            slidingTabLayout3.l(viewPager4, strArr);
        }
        FragmentTransferCenterBinding fragmentTransferCenterBinding10 = (FragmentTransferCenterBinding) getBinding();
        if (fragmentTransferCenterBinding10 != null && (slidingTabLayout2 = fragmentTransferCenterBinding10.tabLayout) != null) {
            slidingTabLayout2.setCurrentTab(0);
        }
        FragmentTransferCenterBinding fragmentTransferCenterBinding11 = (FragmentTransferCenterBinding) getBinding();
        if (fragmentTransferCenterBinding11 != null && (slidingTabLayout = fragmentTransferCenterBinding11.tabLayout) != null) {
            slidingTabLayout.setOnTabSelectListener(new o6.b() { // from class: com.qiahao.nextvideo.ui.transfer.TransferCenterFragment$initView$6
                public void onTabReselect(int position) {
                }

                public void onTabSelect(int position) {
                    ViewPager viewPager5;
                    FragmentTransferCenterBinding fragmentTransferCenterBinding12 = (FragmentTransferCenterBinding) TransferCenterFragment.this.getBinding();
                    if (fragmentTransferCenterBinding12 != null && (viewPager5 = fragmentTransferCenterBinding12.viewPager) != null) {
                        viewPager5.setCurrentItem(position);
                    }
                }
            });
        }
        FragmentTransferCenterBinding fragmentTransferCenterBinding12 = (FragmentTransferCenterBinding) getBinding();
        if (fragmentTransferCenterBinding12 != null && (viewPager = fragmentTransferCenterBinding12.viewPager) != null) {
            viewPager.addOnPageChangeListener(new ViewPager.j() { // from class: com.qiahao.nextvideo.ui.transfer.TransferCenterFragment$initView$7
                public void onPageScrollStateChanged(int state) {
                }

                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                public void onPageSelected(int position) {
                    SlidingTabLayout slidingTabLayout4;
                    FragmentTransferCenterBinding fragmentTransferCenterBinding13 = (FragmentTransferCenterBinding) TransferCenterFragment.this.getBinding();
                    if (fragmentTransferCenterBinding13 != null && (slidingTabLayout4 = fragmentTransferCenterBinding13.tabLayout) != null) {
                        slidingTabLayout4.setCurrentTab(position);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TransferCenterViewModel mViewModel_delegate$lambda$0(TransferCenterFragment transferCenterFragment) {
        return new ViewModelProvider(transferCenterFragment).get(TransferCenterViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_transfer_center;
    }

    @NotNull
    public final String getMType() {
        return this.mType;
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }

    public final void setMType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mType = str;
    }
}
