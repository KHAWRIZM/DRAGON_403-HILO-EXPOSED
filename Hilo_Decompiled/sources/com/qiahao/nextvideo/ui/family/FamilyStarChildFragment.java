package com.qiahao.nextvideo.ui.family;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
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
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.family.FamilyStarData;
import com.qiahao.nextvideo.databinding.FragmentFamilyStarChildBinding;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001e\u001a\u00020\u0006H\u0014J\b\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020 H\u0002J\u0018\u0010\"\u001a\u00020 2\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010$H\u0003J\b\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020 H\u0002J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\rH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001b\u0010\u001c¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyStarChildFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentFamilyStarChildBinding;", "<init>", "()V", "fragmentType", "", "fragmentPeriod", "", "familyID", "", "topThreeData", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/family/FamilyStarData;", "Lkotlin/collections/ArrayList;", "getTopThreeData", "()Ljava/util/ArrayList;", "setTopThreeData", "(Ljava/util/ArrayList;)V", "mAdapter", "Lcom/qiahao/nextvideo/ui/family/FamilyStarAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/family/FamilyStarAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/family/FamilyRankViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/family/FamilyRankViewModel;", "viewModel$delegate", "getLayoutResId", "onInitialize", "", "initData", "refreshTop", "data", "", "initView", "initAdapter", "startUser", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilyStarChildFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilyStarChildFragment.kt\ncom/qiahao/nextvideo/ui/family/FamilyStarChildFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,292:1\n1#2:293\n61#3,9:294\n61#3,9:303\n61#3,9:312\n*S KotlinDebug\n*F\n+ 1 FamilyStarChildFragment.kt\ncom/qiahao/nextvideo/ui/family/FamilyStarChildFragment\n*L\n246#1:294,9\n251#1:303,9\n256#1:312,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyStarChildFragment extends BaseBindingFragment<FragmentFamilyStarChildBinding> {
    private long familyID;
    private int fragmentType;

    @NotNull
    private String fragmentPeriod = "";

    @NotNull
    private ArrayList<FamilyStarData> topThreeData = new ArrayList<>();

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.j4
        public final Object invoke() {
            FamilyStarAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = FamilyStarChildFragment.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.k4
        public final Object invoke() {
            FamilyRankViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = FamilyStarChildFragment.viewModel_delegate$lambda$1(FamilyStarChildFragment.this);
            return viewModel_delegate$lambda$1;
        }
    });

    private final void initAdapter() {
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout;
        RecyclerView recyclerView;
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding != null && (recyclerView = fragmentFamilyStarChildBinding.recyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
        }
        getMAdapter().setFragmentType(this.fragmentType);
        getMAdapter().setFragmentPeriod(this.fragmentPeriod);
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding2 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding2 != null && (smartRefreshLayout = fragmentFamilyStarChildBinding2.smartRefreshLayout) != null) {
            smartRefreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.family.h4
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    FamilyStarChildFragment.initAdapter$lambda$15(FamilyStarChildFragment.this, fVar);
                }
            });
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding3 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding3 != null && (superStatusView = fragmentFamilyStarChildBinding3.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyStarChildFragment$initAdapter$2
                public void onRetry(IStatusView statusView, Status status) {
                    String str;
                    long j;
                    int i;
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    FamilyRankViewModel viewModel = FamilyStarChildFragment.this.getViewModel();
                    str = FamilyStarChildFragment.this.fragmentPeriod;
                    j = FamilyStarChildFragment.this.familyID;
                    i = FamilyStarChildFragment.this.fragmentType;
                    viewModel.getFamilyStar(str, j, i);
                }
            });
        }
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.family.i4
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FamilyStarChildFragment.initAdapter$lambda$16(FamilyStarChildFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$15(FamilyStarChildFragment familyStarChildFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        familyStarChildFragment.getViewModel().getFamilyStar(familyStarChildFragment.fragmentPeriod, familyStarChildFragment.familyID, familyStarChildFragment.fragmentType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$16(FamilyStarChildFragment familyStarChildFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (HiloUtils.INSTANCE.notFastClick()) {
            familyStarChildFragment.startUser((FamilyStarData) familyStarChildFragment.getMAdapter().getData().get(i));
        }
    }

    private final void initData() {
        getViewModel().getFamilyStar().observe(this, new FamilyStarChildFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.f4
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = FamilyStarChildFragment.initData$lambda$4(FamilyStarChildFragment.this, (ApiList) obj);
                return initData$lambda$4;
            }
        }));
        getViewModel().getError().observe(this, new FamilyStarChildFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.g4
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = FamilyStarChildFragment.initData$lambda$5(FamilyStarChildFragment.this, (Throwable) obj);
                return initData$lambda$5;
            }
        }));
        getViewModel().getFamilyStar(this.fragmentPeriod, this.familyID, this.fragmentType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(FamilyStarChildFragment familyStarChildFragment, ApiList apiList) {
        List<FamilyStarData> list;
        int i;
        List data;
        List list2;
        List data2;
        List data3;
        List data4;
        familyStarChildFragment.topThreeData.clear();
        List list3 = null;
        if (apiList != null) {
            list = apiList.getData();
        } else {
            list = null;
        }
        familyStarChildFragment.refreshTop(list);
        FamilyStarAdapter mAdapter = familyStarChildFragment.getMAdapter();
        int i2 = 0;
        if (apiList != null && (data4 = apiList.getData()) != null) {
            i = data4.size();
        } else {
            i = 0;
        }
        if (i > 3) {
            if (apiList != null && (data3 = apiList.getData()) != null) {
                list2 = data3.subList(0, 3);
            } else {
                list2 = null;
            }
            if (list2 != null) {
                familyStarChildFragment.topThreeData.addAll(list2);
            }
            if (apiList != null && (data2 = apiList.getData()) != null) {
                List data5 = apiList.getData();
                if (data5 != null) {
                    i2 = data5.size();
                }
                list3 = data2.subList(3, i2);
            }
        } else if (apiList != null && (data = apiList.getData()) != null) {
            familyStarChildFragment.topThreeData.addAll(data);
        }
        mAdapter.setList(list3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(FamilyStarChildFragment familyStarChildFragment, Throwable th) {
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding = (FragmentFamilyStarChildBinding) familyStarChildFragment.getBinding();
        if (fragmentFamilyStarChildBinding != null && (smartRefreshLayout3 = fragmentFamilyStarChildBinding.smartRefreshLayout) != null) {
            smartRefreshLayout3.finishRefresh();
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding2 = (FragmentFamilyStarChildBinding) familyStarChildFragment.getBinding();
        if (fragmentFamilyStarChildBinding2 != null && (smartRefreshLayout2 = fragmentFamilyStarChildBinding2.smartRefreshLayout) != null) {
            smartRefreshLayout2.finishLoadMore();
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding3 = (FragmentFamilyStarChildBinding) familyStarChildFragment.getBinding();
        if (fragmentFamilyStarChildBinding3 != null && (smartRefreshLayout = fragmentFamilyStarChildBinding3.smartRefreshLayout) != null) {
            smartRefreshLayout.setNoMoreData(true);
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding4 = (FragmentFamilyStarChildBinding) familyStarChildFragment.getBinding();
        if (fragmentFamilyStarChildBinding4 != null && (superStatusView = fragmentFamilyStarChildBinding4.statusView) != null) {
            superStatusView.showEmpty();
        }
        familyStarChildFragment.topThreeData.clear();
        familyStarChildFragment.refreshTop(null);
        return Unit.INSTANCE;
    }

    private final void initView() {
        int i;
        String str;
        long j;
        ImageView imageView;
        ImageView imageView2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        final LinearLayout linearLayout4;
        final LinearLayout linearLayout5;
        final LinearLayout linearLayout6;
        ImageView imageView3;
        ImageView imageView4;
        LinearLayout linearLayout7;
        LinearLayout linearLayout8;
        LinearLayout linearLayout9;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        ImageView imageView9;
        LinearLayout linearLayout10;
        LinearLayout linearLayout11;
        LinearLayout linearLayout12;
        Bundle arguments = getArguments();
        if (arguments != null) {
            i = arguments.getInt("fragment_type");
        } else {
            i = 0;
        }
        this.fragmentType = i;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str = arguments2.getString("fragment_period")) == null) {
            str = "";
        }
        this.fragmentPeriod = str;
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            j = arguments3.getLong("familyID");
        } else {
            j = 0;
        }
        this.familyID = j;
        int i2 = this.fragmentType;
        Drawable drawable = null;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding = (FragmentFamilyStarChildBinding) getBinding();
                    if (fragmentFamilyStarChildBinding != null && (linearLayout12 = fragmentFamilyStarChildBinding.llDiamond1) != null) {
                        linearLayout12.setBackgroundResource(R.drawable.shape_fc4f6d_9dp);
                    }
                    FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding2 = (FragmentFamilyStarChildBinding) getBinding();
                    if (fragmentFamilyStarChildBinding2 != null && (linearLayout11 = fragmentFamilyStarChildBinding2.llDiamond2) != null) {
                        linearLayout11.setBackgroundResource(R.drawable.shape_fc4f6d_9dp);
                    }
                    FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding3 = (FragmentFamilyStarChildBinding) getBinding();
                    if (fragmentFamilyStarChildBinding3 != null && (linearLayout10 = fragmentFamilyStarChildBinding3.llDiamond3) != null) {
                        linearLayout10.setBackgroundResource(R.drawable.shape_fc4f6d_9dp);
                    }
                    FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding4 = (FragmentFamilyStarChildBinding) getBinding();
                    if (fragmentFamilyStarChildBinding4 != null && (imageView9 = fragmentFamilyStarChildBinding4.top3Platform) != null) {
                        ImageKtxKt.loadImage$default(imageView9, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_rank_charm_top), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                    }
                    FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding5 = (FragmentFamilyStarChildBinding) getBinding();
                    if (fragmentFamilyStarChildBinding5 != null && (imageView8 = fragmentFamilyStarChildBinding5.topBg) != null) {
                        Context context = getContext();
                        if (context != null) {
                            drawable = androidx.core.content.a.getDrawable(context, R.drawable.ic_family_charm_top_bg);
                        }
                        imageView8.setImageDrawable(drawable);
                    }
                }
            } else {
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding6 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding6 != null && (imageView7 = fragmentFamilyStarChildBinding6.diamondImage1) != null) {
                    imageView7.setVisibility(8);
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding7 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding7 != null && (imageView6 = fragmentFamilyStarChildBinding7.diamondImage2) != null) {
                    imageView6.setVisibility(8);
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding8 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding8 != null && (imageView5 = fragmentFamilyStarChildBinding8.diamondImage3) != null) {
                    imageView5.setVisibility(8);
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding9 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding9 != null && (linearLayout9 = fragmentFamilyStarChildBinding9.llDiamond1) != null) {
                    linearLayout9.setBackgroundResource(R.drawable.shape_2c65d6_9dp);
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding10 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding10 != null && (linearLayout8 = fragmentFamilyStarChildBinding10.llDiamond2) != null) {
                    linearLayout8.setBackgroundResource(R.drawable.shape_2c65d6_9dp);
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding11 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding11 != null && (linearLayout7 = fragmentFamilyStarChildBinding11.llDiamond3) != null) {
                    linearLayout7.setBackgroundResource(R.drawable.shape_2c65d6_9dp);
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding12 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding12 != null && (imageView4 = fragmentFamilyStarChildBinding12.top3Platform) != null) {
                    ImageKtxKt.loadImage$default(imageView4, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_rank_active_top), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding13 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding13 != null && (imageView3 = fragmentFamilyStarChildBinding13.topBg) != null) {
                    Context context2 = getContext();
                    if (context2 != null) {
                        drawable = androidx.core.content.a.getDrawable(context2, R.drawable.ic_family_active_top_bg);
                    }
                    imageView3.setImageDrawable(drawable);
                }
            }
        } else {
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding14 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding14 != null && (linearLayout3 = fragmentFamilyStarChildBinding14.llDiamond1) != null) {
                linearLayout3.setBackgroundResource(R.drawable.shape_ff8a00_9dp);
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding15 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding15 != null && (linearLayout2 = fragmentFamilyStarChildBinding15.llDiamond2) != null) {
                linearLayout2.setBackgroundResource(R.drawable.shape_ff8a00_9dp);
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding16 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding16 != null && (linearLayout = fragmentFamilyStarChildBinding16.llDiamond3) != null) {
                linearLayout.setBackgroundResource(R.drawable.shape_ff8a00_9dp);
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding17 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding17 != null && (imageView2 = fragmentFamilyStarChildBinding17.top3Platform) != null) {
                ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_rank_famous_top), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding18 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding18 != null && (imageView = fragmentFamilyStarChildBinding18.topBg) != null) {
                Context context3 = getContext();
                if (context3 != null) {
                    drawable = androidx.core.content.a.getDrawable(context3, R.drawable.ic_family_famous_top_bg);
                }
                imageView.setImageDrawable(drawable);
            }
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding19 = (FragmentFamilyStarChildBinding) getBinding();
        final long j2 = 800;
        if (fragmentFamilyStarChildBinding19 != null && (linearLayout6 = fragmentFamilyStarChildBinding19.llTop1) != null) {
            linearLayout6.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyStarChildFragment$initView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout6) > j2 || (linearLayout6 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(linearLayout6, currentTimeMillis);
                        if (this.getTopThreeData().size() >= 1) {
                            FamilyStarChildFragment familyStarChildFragment = this;
                            FamilyStarData familyStarData = familyStarChildFragment.getTopThreeData().get(0);
                            Intrinsics.checkNotNullExpressionValue(familyStarData, "get(...)");
                            familyStarChildFragment.startUser(familyStarData);
                        }
                    }
                }
            });
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding20 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding20 != null && (linearLayout5 = fragmentFamilyStarChildBinding20.llTop2) != null) {
            linearLayout5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyStarChildFragment$initView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout5) > j2 || (linearLayout5 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(linearLayout5, currentTimeMillis);
                        if (this.getTopThreeData().size() >= 2) {
                            FamilyStarChildFragment familyStarChildFragment = this;
                            FamilyStarData familyStarData = familyStarChildFragment.getTopThreeData().get(1);
                            Intrinsics.checkNotNullExpressionValue(familyStarData, "get(...)");
                            familyStarChildFragment.startUser(familyStarData);
                        }
                    }
                }
            });
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding21 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding21 != null && (linearLayout4 = fragmentFamilyStarChildBinding21.llTop3) != null) {
            linearLayout4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyStarChildFragment$initView$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(linearLayout4) > j2 || (linearLayout4 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(linearLayout4, currentTimeMillis);
                        if (this.getTopThreeData().size() >= 3) {
                            FamilyStarChildFragment familyStarChildFragment = this;
                            FamilyStarData familyStarData = familyStarChildFragment.getTopThreeData().get(2);
                            Intrinsics.checkNotNullExpressionValue(familyStarData, "get(...)");
                            familyStarChildFragment.startUser(familyStarData);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyStarAdapter mAdapter_delegate$lambda$0() {
        return new FamilyStarAdapter();
    }

    @SuppressLint({"SetTextI18n"})
    private final void refreshTop(List<FamilyStarData> data) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        int i;
        int i2;
        int i3;
        SuperStatusView superStatusView;
        SuperStatusView superStatusView2;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        FamilyStarData familyStarData;
        LinearLayout linearLayout;
        int i4;
        TextView textView;
        long j;
        Long score;
        boolean z;
        ShineTextView shineTextView;
        String str;
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding;
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding2;
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding3;
        ShineTextView shineTextView2;
        TextView textView2;
        AppCompatImageView appCompatImageView;
        String str2;
        User user;
        ShineTextView shineTextView3;
        ShineTextView shineTextView4;
        Drawable drawable;
        Resources resources;
        User user2;
        ShineTextView shineTextView5;
        String str3;
        User user3;
        LinearLayout linearLayout2;
        TextView textView3;
        long j2;
        Long score2;
        TextView textView4;
        User user4;
        String nick;
        FamilyStarData familyStarData2;
        LinearLayout linearLayout3;
        int i5;
        TextView textView5;
        long j3;
        Long score3;
        boolean z2;
        ShineTextView shineTextView6;
        ShineTextView shineTextView7;
        TextView textView6;
        AppCompatImageView appCompatImageView2;
        int i6;
        String str4;
        User user5;
        ShineTextView shineTextView8;
        ShineTextView shineTextView9;
        Drawable drawable2;
        Resources resources2;
        User user6;
        ShineTextView shineTextView10;
        String str5;
        User user7;
        LinearLayout linearLayout4;
        TextView textView7;
        long j4;
        Long score4;
        TextView textView8;
        String str6;
        User user8;
        FamilyStarData familyStarData3;
        LinearLayout linearLayout5;
        int i7;
        TextView textView9;
        long j5;
        Long score5;
        boolean z3;
        ShineTextView shineTextView11;
        ShineTextView shineTextView12;
        TextView textView10;
        AppCompatImageView appCompatImageView3;
        int i8;
        String str7;
        User user9;
        ShineTextView shineTextView13;
        ShineTextView shineTextView14;
        Drawable drawable3;
        Resources resources3;
        User user10;
        ShineTextView shineTextView15;
        String str8;
        User user11;
        LinearLayout linearLayout6;
        TextView textView11;
        long j6;
        Long score6;
        TextView textView12;
        String str9;
        User user12;
        String nick2;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        LinearLayout linearLayout7;
        ShineTextView shineTextView16;
        TextView textView13;
        LinearLayout linearLayout8;
        ShineTextView shineTextView17;
        TextView textView14;
        LinearLayout linearLayout9;
        ShineTextView shineTextView18;
        TextView textView15;
        int i9 = 0;
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding4 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding4 != null && (textView15 = fragmentFamilyStarChildBinding4.top1Name) != null) {
            textView15.setVisibility(8);
            Unit unit = Unit.INSTANCE;
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding5 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding5 != null && (shineTextView18 = fragmentFamilyStarChildBinding5.top1Id) != null) {
            shineTextView18.setVisibility(8);
            Unit unit2 = Unit.INSTANCE;
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding6 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding6 != null && (linearLayout9 = fragmentFamilyStarChildBinding6.llDiamond1) != null) {
            linearLayout9.setVisibility(8);
            Unit unit3 = Unit.INSTANCE;
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding7 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding7 != null && (textView14 = fragmentFamilyStarChildBinding7.top2Name) != null) {
            textView14.setVisibility(8);
            Unit unit4 = Unit.INSTANCE;
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding8 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding8 != null && (shineTextView17 = fragmentFamilyStarChildBinding8.top2Id) != null) {
            shineTextView17.setVisibility(8);
            Unit unit5 = Unit.INSTANCE;
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding9 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding9 != null && (linearLayout8 = fragmentFamilyStarChildBinding9.llDiamond2) != null) {
            linearLayout8.setVisibility(8);
            Unit unit6 = Unit.INSTANCE;
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding10 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding10 != null && (textView13 = fragmentFamilyStarChildBinding10.top3Name) != null) {
            textView13.setVisibility(8);
            Unit unit7 = Unit.INSTANCE;
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding11 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding11 != null && (shineTextView16 = fragmentFamilyStarChildBinding11.top3Id) != null) {
            shineTextView16.setVisibility(8);
            Unit unit8 = Unit.INSTANCE;
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding12 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding12 != null && (linearLayout7 = fragmentFamilyStarChildBinding12.llDiamond3) != null) {
            linearLayout7.setVisibility(8);
            Unit unit9 = Unit.INSTANCE;
        }
        if (this.fragmentType == 2) {
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding13 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding13 != null && (imageView6 = fragmentFamilyStarChildBinding13.diamondImage1) != null) {
                imageView6.setVisibility(8);
                Unit unit10 = Unit.INSTANCE;
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding14 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding14 != null && (imageView5 = fragmentFamilyStarChildBinding14.diamondImage2) != null) {
                imageView5.setVisibility(8);
                Unit unit11 = Unit.INSTANCE;
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding15 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding15 != null && (imageView4 = fragmentFamilyStarChildBinding15.diamondImage3) != null) {
                imageView4.setVisibility(8);
                Unit unit12 = Unit.INSTANCE;
            }
        } else {
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding16 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding16 != null && (imageView3 = fragmentFamilyStarChildBinding16.diamondImage1) != null) {
                imageView3.setVisibility(0);
                Unit unit13 = Unit.INSTANCE;
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding17 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding17 != null && (imageView2 = fragmentFamilyStarChildBinding17.diamondImage2) != null) {
                imageView2.setVisibility(0);
                Unit unit14 = Unit.INSTANCE;
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding18 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding18 != null && (imageView = fragmentFamilyStarChildBinding18.diamondImage3) != null) {
                imageView.setVisibility(0);
                Unit unit15 = Unit.INSTANCE;
            }
        }
        if (data != null) {
            i = data.size();
        } else {
            i = 0;
        }
        String str10 = "";
        if (i >= 1) {
            if (data != null) {
                familyStarData3 = data.get(0);
            } else {
                familyStarData3 = null;
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding19 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding19 != null && (textView12 = fragmentFamilyStarChildBinding19.top1Name) != null) {
                if (familyStarData3 == null || (user12 = familyStarData3.getUser()) == null || (nick2 = user12.getNick()) == null) {
                    str9 = "";
                } else {
                    str9 = nick2;
                }
                textView12.setText(str9);
                Unit unit16 = Unit.INSTANCE;
            }
            if (this.fragmentType == 2) {
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding20 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding20 != null && (textView11 = fragmentFamilyStarChildBinding20.top1Diamond) != null) {
                    if (familyStarData3 != null && (score6 = familyStarData3.getScore()) != null) {
                        j6 = score6.longValue();
                    } else {
                        j6 = 0;
                    }
                    textView11.setText(j6 + " min");
                    Unit unit17 = Unit.INSTANCE;
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding21 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding21 != null && (linearLayout6 = fragmentFamilyStarChildBinding21.llDiamond1) != null) {
                    linearLayout6.setVisibility(0);
                    Unit unit18 = Unit.INSTANCE;
                }
            } else {
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding22 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding22 != null && (textView9 = fragmentFamilyStarChildBinding22.top1Diamond) != null) {
                    if (familyStarData3 != null && (score5 = familyStarData3.getScore()) != null) {
                        j5 = score5.longValue();
                    } else {
                        j5 = 0;
                    }
                    textView9.setText(NumberUtilsKt.rankNumberFormat(j5));
                    Unit unit19 = Unit.INSTANCE;
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding23 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding23 != null && (linearLayout5 = fragmentFamilyStarChildBinding23.llDiamond1) != null) {
                    if (Intrinsics.areEqual(this.fragmentPeriod, "day")) {
                        i7 = 0;
                    } else {
                        i7 = 8;
                    }
                    linearLayout5.setVisibility(i7);
                    Unit unit20 = Unit.INSTANCE;
                }
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding24 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding24 != null && (shineTextView15 = fragmentFamilyStarChildBinding24.top1Id) != null) {
                String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
                if (familyStarData3 != null && (user11 = familyStarData3.getUser()) != null) {
                    str8 = user11.getCode();
                } else {
                    str8 = null;
                }
                String format = String.format(stringById, Arrays.copyOf(new Object[]{String.valueOf(str8)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                shineTextView15.setText(format);
                Unit unit21 = Unit.INSTANCE;
            }
            if (familyStarData3 != null && (user10 = familyStarData3.getUser()) != null) {
                z3 = Intrinsics.areEqual(user10.isPrettyCode(), Boolean.TRUE);
            } else {
                z3 = false;
            }
            if (z3) {
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding25 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding25 != null && (shineTextView14 = fragmentFamilyStarChildBinding25.top1Id) != null) {
                    Context context = getContext();
                    if (context != null && (resources3 = context.getResources()) != null) {
                        drawable3 = ResourceUtilsKt.getDrawable(resources3, 2131232463, Dimens.INSTANCE.dpToPx(4));
                    } else {
                        drawable3 = null;
                    }
                    ViewUtilitiesKt.setDrawableLeft(shineTextView14, drawable3);
                    Unit unit22 = Unit.INSTANCE;
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding26 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding26 != null && (shineTextView13 = fragmentFamilyStarChildBinding26.top1Id) != null) {
                    shineTextView13.setCompoundDrawablePadding(Dimens.INSTANCE.dpToPx(4));
                    Unit unit23 = Unit.INSTANCE;
                }
            } else {
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding27 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding27 != null && (shineTextView11 = fragmentFamilyStarChildBinding27.top1Id) != null) {
                    ViewUtilitiesKt.setDrawableLeft(shineTextView11, null);
                    Unit unit24 = Unit.INSTANCE;
                }
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding28 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding28 != null && (appCompatImageView3 = fragmentFamilyStarChildBinding28.top1Avatar) != null) {
                if (familyStarData3 != null && (user9 = familyStarData3.getUser()) != null) {
                    str7 = user9.getAvatar();
                    i8 = 2131232432;
                } else {
                    i8 = 2131232432;
                    str7 = null;
                }
                ImageKtxKt.loadImage$default(appCompatImageView3, str7, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(i8), (c5.g) null, 49150, (Object) null);
                Unit unit25 = Unit.INSTANCE;
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding29 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding29 != null && (textView10 = fragmentFamilyStarChildBinding29.top1Name) != null) {
                textView10.setVisibility(0);
                Unit unit26 = Unit.INSTANCE;
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding30 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding30 != null && (shineTextView12 = fragmentFamilyStarChildBinding30.top1Id) != null) {
                shineTextView12.setVisibility(0);
                Unit unit27 = Unit.INSTANCE;
            }
        }
        if (data != null) {
            i2 = data.size();
        } else {
            i2 = 0;
        }
        if (i2 >= 2) {
            if (data != null) {
                familyStarData2 = data.get(1);
            } else {
                familyStarData2 = null;
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding31 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding31 != null && (textView8 = fragmentFamilyStarChildBinding31.top2Name) != null) {
                if (familyStarData2 == null || (user8 = familyStarData2.getUser()) == null || (str6 = user8.getNick()) == null) {
                    str6 = "";
                }
                textView8.setText(str6);
                Unit unit28 = Unit.INSTANCE;
            }
            if (this.fragmentType == 2) {
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding32 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding32 != null && (textView7 = fragmentFamilyStarChildBinding32.top2Diamond) != null) {
                    if (familyStarData2 != null && (score4 = familyStarData2.getScore()) != null) {
                        j4 = score4.longValue();
                    } else {
                        j4 = 0;
                    }
                    textView7.setText(j4 + " min");
                    Unit unit29 = Unit.INSTANCE;
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding33 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding33 != null && (linearLayout4 = fragmentFamilyStarChildBinding33.llDiamond2) != null) {
                    linearLayout4.setVisibility(0);
                    Unit unit30 = Unit.INSTANCE;
                }
            } else {
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding34 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding34 != null && (textView5 = fragmentFamilyStarChildBinding34.top2Diamond) != null) {
                    if (familyStarData2 != null && (score3 = familyStarData2.getScore()) != null) {
                        j3 = score3.longValue();
                    } else {
                        j3 = 0;
                    }
                    textView5.setText(NumberUtilsKt.rankNumberFormat(j3));
                    Unit unit31 = Unit.INSTANCE;
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding35 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding35 != null && (linearLayout3 = fragmentFamilyStarChildBinding35.llDiamond2) != null) {
                    if (Intrinsics.areEqual(this.fragmentPeriod, "day")) {
                        i5 = 0;
                    } else {
                        i5 = 8;
                    }
                    linearLayout3.setVisibility(i5);
                    Unit unit32 = Unit.INSTANCE;
                }
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding36 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding36 != null && (shineTextView10 = fragmentFamilyStarChildBinding36.top2Id) != null) {
                String stringById2 = ResourcesKtxKt.getStringById(this, 2131953102);
                if (familyStarData2 != null && (user7 = familyStarData2.getUser()) != null) {
                    str5 = user7.getCode();
                } else {
                    str5 = null;
                }
                String format2 = String.format(stringById2, Arrays.copyOf(new Object[]{String.valueOf(str5)}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                shineTextView10.setText(format2);
                Unit unit33 = Unit.INSTANCE;
            }
            if (familyStarData2 != null && (user6 = familyStarData2.getUser()) != null) {
                z2 = Intrinsics.areEqual(user6.isPrettyCode(), Boolean.TRUE);
            } else {
                z2 = false;
            }
            if (z2) {
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding37 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding37 != null && (shineTextView9 = fragmentFamilyStarChildBinding37.top2Id) != null) {
                    Context context2 = getContext();
                    if (context2 != null && (resources2 = context2.getResources()) != null) {
                        drawable2 = ResourceUtilsKt.getDrawable(resources2, 2131232463, Dimens.INSTANCE.dpToPx(4));
                    } else {
                        drawable2 = null;
                    }
                    ViewUtilitiesKt.setDrawableLeft(shineTextView9, drawable2);
                    Unit unit34 = Unit.INSTANCE;
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding38 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding38 != null && (shineTextView8 = fragmentFamilyStarChildBinding38.top2Id) != null) {
                    shineTextView8.setCompoundDrawablePadding(Dimens.INSTANCE.dpToPx(4));
                    Unit unit35 = Unit.INSTANCE;
                }
            } else {
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding39 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding39 != null && (shineTextView6 = fragmentFamilyStarChildBinding39.top2Id) != null) {
                    ViewUtilitiesKt.setDrawableLeft(shineTextView6, null);
                    Unit unit36 = Unit.INSTANCE;
                }
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding40 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding40 != null && (appCompatImageView2 = fragmentFamilyStarChildBinding40.top2Avatar) != null) {
                if (familyStarData2 != null && (user5 = familyStarData2.getUser()) != null) {
                    str4 = user5.getAvatar();
                    i6 = 2131232432;
                } else {
                    i6 = 2131232432;
                    str4 = null;
                }
                ImageKtxKt.loadImage$default(appCompatImageView2, str4, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(i6), (c5.g) null, 49150, (Object) null);
                Unit unit37 = Unit.INSTANCE;
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding41 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding41 != null && (textView6 = fragmentFamilyStarChildBinding41.top2Name) != null) {
                textView6.setVisibility(0);
                Unit unit38 = Unit.INSTANCE;
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding42 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding42 != null && (shineTextView7 = fragmentFamilyStarChildBinding42.top2Id) != null) {
                shineTextView7.setVisibility(0);
                Unit unit39 = Unit.INSTANCE;
            }
        }
        if (data != null) {
            i3 = data.size();
        } else {
            i3 = 0;
        }
        if (i3 >= 3) {
            if (data != null) {
                familyStarData = data.get(2);
            } else {
                familyStarData = null;
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding43 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding43 != null && (textView4 = fragmentFamilyStarChildBinding43.top3Name) != null) {
                if (familyStarData != null && (user4 = familyStarData.getUser()) != null && (nick = user4.getNick()) != null) {
                    str10 = nick;
                }
                textView4.setText(str10);
                Unit unit40 = Unit.INSTANCE;
            }
            if (this.fragmentType == 2) {
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding44 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding44 != null && (textView3 = fragmentFamilyStarChildBinding44.top3Diamond) != null) {
                    if (familyStarData != null && (score2 = familyStarData.getScore()) != null) {
                        j2 = score2.longValue();
                    } else {
                        j2 = 0;
                    }
                    textView3.setText(j2 + " min");
                    Unit unit41 = Unit.INSTANCE;
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding45 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding45 != null && (linearLayout2 = fragmentFamilyStarChildBinding45.llDiamond3) != null) {
                    linearLayout2.setVisibility(0);
                    Unit unit42 = Unit.INSTANCE;
                }
            } else {
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding46 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding46 != null && (textView = fragmentFamilyStarChildBinding46.top3Diamond) != null) {
                    if (familyStarData != null && (score = familyStarData.getScore()) != null) {
                        j = score.longValue();
                    } else {
                        j = 0;
                    }
                    textView.setText(NumberUtilsKt.rankNumberFormat(j));
                    Unit unit43 = Unit.INSTANCE;
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding47 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding47 != null && (linearLayout = fragmentFamilyStarChildBinding47.llDiamond3) != null) {
                    if (Intrinsics.areEqual(this.fragmentPeriod, "day")) {
                        i4 = 0;
                    } else {
                        i4 = 8;
                    }
                    linearLayout.setVisibility(i4);
                    Unit unit44 = Unit.INSTANCE;
                }
            }
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding48 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding48 != null && (shineTextView5 = fragmentFamilyStarChildBinding48.top3Id) != null) {
                String stringById3 = ResourcesKtxKt.getStringById(this, 2131953102);
                if (familyStarData != null && (user3 = familyStarData.getUser()) != null) {
                    str3 = user3.getCode();
                } else {
                    str3 = null;
                }
                String format3 = String.format(stringById3, Arrays.copyOf(new Object[]{String.valueOf(str3)}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                shineTextView5.setText(format3);
                Unit unit45 = Unit.INSTANCE;
            }
            if (familyStarData != null && (user2 = familyStarData.getUser()) != null) {
                z = Intrinsics.areEqual(user2.isPrettyCode(), Boolean.TRUE);
            } else {
                z = false;
            }
            if (z) {
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding49 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding49 != null && (shineTextView4 = fragmentFamilyStarChildBinding49.top3Id) != null) {
                    Context context3 = getContext();
                    if (context3 != null && (resources = context3.getResources()) != null) {
                        drawable = ResourceUtilsKt.getDrawable(resources, 2131232463, Dimens.INSTANCE.dpToPx(4));
                    } else {
                        drawable = null;
                    }
                    ViewUtilitiesKt.setDrawableLeft(shineTextView4, drawable);
                    Unit unit46 = Unit.INSTANCE;
                }
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding50 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding50 != null && (shineTextView3 = fragmentFamilyStarChildBinding50.top3Id) != null) {
                    shineTextView3.setCompoundDrawablePadding(Dimens.INSTANCE.dpToPx(4));
                    Unit unit47 = Unit.INSTANCE;
                }
            } else {
                FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding51 = (FragmentFamilyStarChildBinding) getBinding();
                if (fragmentFamilyStarChildBinding51 != null && (shineTextView = fragmentFamilyStarChildBinding51.top3Id) != null) {
                    str = null;
                    ViewUtilitiesKt.setDrawableLeft(shineTextView, null);
                    Unit unit48 = Unit.INSTANCE;
                    fragmentFamilyStarChildBinding = (FragmentFamilyStarChildBinding) getBinding();
                    if (fragmentFamilyStarChildBinding != null && (appCompatImageView = fragmentFamilyStarChildBinding.top3Avatar) != null) {
                        if (familyStarData == null && (user = familyStarData.getUser()) != null) {
                            str2 = user.getAvatar();
                        } else {
                            str2 = str;
                        }
                        ImageKtxKt.loadImage$default(appCompatImageView, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
                        Unit unit49 = Unit.INSTANCE;
                    }
                    fragmentFamilyStarChildBinding2 = (FragmentFamilyStarChildBinding) getBinding();
                    if (fragmentFamilyStarChildBinding2 != null && (textView2 = fragmentFamilyStarChildBinding2.top3Name) != null) {
                        textView2.setVisibility(0);
                        Unit unit50 = Unit.INSTANCE;
                    }
                    fragmentFamilyStarChildBinding3 = (FragmentFamilyStarChildBinding) getBinding();
                    if (fragmentFamilyStarChildBinding3 != null && (shineTextView2 = fragmentFamilyStarChildBinding3.top3Id) != null) {
                        shineTextView2.setVisibility(0);
                        Unit unit51 = Unit.INSTANCE;
                    }
                }
            }
            str = null;
            fragmentFamilyStarChildBinding = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding != null) {
                if (familyStarData == null) {
                }
                str2 = str;
                ImageKtxKt.loadImage$default(appCompatImageView, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
                Unit unit492 = Unit.INSTANCE;
            }
            fragmentFamilyStarChildBinding2 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding2 != null) {
                textView2.setVisibility(0);
                Unit unit502 = Unit.INSTANCE;
            }
            fragmentFamilyStarChildBinding3 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding3 != null) {
                shineTextView2.setVisibility(0);
                Unit unit512 = Unit.INSTANCE;
            }
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding52 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding52 != null && (smartRefreshLayout3 = fragmentFamilyStarChildBinding52.smartRefreshLayout) != null) {
            smartRefreshLayout3.finishRefresh();
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding53 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding53 != null && (smartRefreshLayout2 = fragmentFamilyStarChildBinding53.smartRefreshLayout) != null) {
            smartRefreshLayout2.finishLoadMore();
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding54 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding54 != null && (smartRefreshLayout = fragmentFamilyStarChildBinding54.smartRefreshLayout) != null) {
            smartRefreshLayout.setNoMoreData(true);
        }
        if (data != null) {
            i9 = data.size();
        }
        if (i9 > 3) {
            FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding55 = (FragmentFamilyStarChildBinding) getBinding();
            if (fragmentFamilyStarChildBinding55 != null && (superStatusView2 = fragmentFamilyStarChildBinding55.statusView) != null) {
                superStatusView2.showContent();
                Unit unit52 = Unit.INSTANCE;
                return;
            }
            return;
        }
        FragmentFamilyStarChildBinding fragmentFamilyStarChildBinding56 = (FragmentFamilyStarChildBinding) getBinding();
        if (fragmentFamilyStarChildBinding56 != null && (superStatusView = fragmentFamilyStarChildBinding56.statusView) != null) {
            superStatusView.showEmpty();
            Unit unit53 = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startUser(FamilyStarData item) {
        String str;
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            User user = item.getUser();
            if (user == null || (str = user.getExternalId()) == null) {
                str = "";
            }
            service.openPersonPage(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyRankViewModel viewModel_delegate$lambda$1(FamilyStarChildFragment familyStarChildFragment) {
        return new ViewModelProvider(familyStarChildFragment).get(FamilyRankViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_family_star_child;
    }

    @NotNull
    public final FamilyStarAdapter getMAdapter() {
        return (FamilyStarAdapter) this.mAdapter.getValue();
    }

    @NotNull
    public final ArrayList<FamilyStarData> getTopThreeData() {
        return this.topThreeData;
    }

    @NotNull
    public final FamilyRankViewModel getViewModel() {
        return (FamilyRankViewModel) this.viewModel.getValue();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initAdapter();
        initData();
    }

    public final void setTopThreeData(@NotNull ArrayList<FamilyStarData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.topThreeData = arrayList;
    }
}
