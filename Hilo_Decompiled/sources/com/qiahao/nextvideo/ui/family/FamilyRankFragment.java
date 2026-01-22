package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.model.eventBus.EventBusKey;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.family.FamilyRankData;
import com.qiahao.nextvideo.data.family.FamilyRankItem;
import com.qiahao.nextvideo.databinding.FragmentFamilyRankBinding;
import com.qiahao.nextvideo.ui.family.FamilyCenterActivity;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010)\u001a\u00020*H\u0014J\b\u0010+\u001a\u00020$H\u0016J\b\u0010,\u001a\u00020$H\u0002J\u0012\u0010-\u001a\u00020$2\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\b\u00100\u001a\u00020$H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u00102\u001a\u00020*H\u0002J\u0010\u00103\u001a\u00020$2\u0006\u00104\u001a\u000205H\u0007J\b\u00106\u001a\u00020$H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR9\u0010\u001e\u001a!\u0012\u0015\u0012\u0013\u0018\u00010 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020$\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u00067"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyRankFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentFamilyRankBinding;", "<init>", "()V", "mAdapter", "Lcom/qiahao/nextvideo/ui/family/FamilyRankAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/family/FamilyRankAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/family/FamilyRankViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/family/FamilyRankViewModel;", "viewModel$delegate", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "topThreeData", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/family/FamilyRankItem;", "Lkotlin/collections/ArrayList;", "getTopThreeData", "()Ljava/util/ArrayList;", "setTopThreeData", "(Ljava/util/ArrayList;)V", "mListener", "Lkotlin/Function1;", "Lcom/qiahao/base_common/model/common/FamilyInfo;", "Lkotlin/ParameterName;", "name", "myFamily", "", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "getLayoutResId", "", "onInitialize", "initData", "refreshTop", "it", "Lcom/qiahao/nextvideo/data/family/FamilyRankData;", "initAdapter", "startFamilyCenter", "position", "onDisbandFamilyEvent", "event", "Lcom/qiahao/base_common/model/eventBus/EventBusKey;", "onResume", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFamilyRankFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FamilyRankFragment.kt\ncom/qiahao/nextvideo/ui/family/FamilyRankFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,236:1\n1#2:237\n61#3,9:238\n61#3,9:247\n61#3,9:256\n61#3,9:265\n61#3,9:274\n61#3,9:283\n*S KotlinDebug\n*F\n+ 1 FamilyRankFragment.kt\ncom/qiahao/nextvideo/ui/family/FamilyRankFragment\n*L\n161#1:238,9\n164#1:247,9\n168#1:256,9\n171#1:265,9\n175#1:274,9\n178#1:283,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyRankFragment extends BaseBindingFragment<FragmentFamilyRankBinding> {

    @Nullable
    private Function1<? super FamilyInfo, Unit> mListener;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.r2
        public final Object invoke() {
            FamilyRankAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = FamilyRankFragment.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.s2
        public final Object invoke() {
            FamilyRankViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = FamilyRankFragment.viewModel_delegate$lambda$1(FamilyRankFragment.this);
            return viewModel_delegate$lambda$1;
        }
    });

    @NotNull
    private String type = "day";

    @NotNull
    private ArrayList<FamilyRankItem> topThreeData = new ArrayList<>();

    private final void initAdapter() {
        String str;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout;
        final ImageView imageView;
        final ImageView imageView2;
        final ImageView imageView3;
        final ImageView imageView4;
        final ImageView imageView5;
        final ImageView imageView6;
        RecyclerView recyclerView;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("fragment_type")) == null) {
            str = "";
        }
        this.type = str;
        getMAdapter().setType(this.type);
        FragmentFamilyRankBinding fragmentFamilyRankBinding = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding != null && (recyclerView = fragmentFamilyRankBinding.recyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding2 = (FragmentFamilyRankBinding) getBinding();
        final long j = 800;
        if (fragmentFamilyRankBinding2 != null && (imageView6 = fragmentFamilyRankBinding2.rankHeader1) != null) {
            imageView6.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyRankFragment$initAdapter$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView6) > j || (imageView6 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView6, currentTimeMillis);
                        this.startFamilyCenter(0);
                    }
                }
            });
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding3 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding3 != null && (imageView5 = fragmentFamilyRankBinding3.rankBg1) != null) {
            imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyRankFragment$initAdapter$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView5) > j || (imageView5 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView5, currentTimeMillis);
                        this.startFamilyCenter(0);
                    }
                }
            });
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding4 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding4 != null && (imageView4 = fragmentFamilyRankBinding4.rankHeader2) != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyRankFragment$initAdapter$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView4) > j || (imageView4 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView4, currentTimeMillis);
                        this.startFamilyCenter(1);
                    }
                }
            });
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding5 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding5 != null && (imageView3 = fragmentFamilyRankBinding5.rankBg2) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyRankFragment$initAdapter$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView3) > j || (imageView3 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView3, currentTimeMillis);
                        this.startFamilyCenter(1);
                    }
                }
            });
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding6 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding6 != null && (imageView2 = fragmentFamilyRankBinding6.rankHeader3) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyRankFragment$initAdapter$$inlined$singleClick$default$5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                        this.startFamilyCenter(2);
                    }
                }
            });
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding7 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding7 != null && (imageView = fragmentFamilyRankBinding7.rankBg3) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyRankFragment$initAdapter$$inlined$singleClick$default$6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                        this.startFamilyCenter(2);
                    }
                }
            });
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding8 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding8 != null && (smartRefreshLayout = fragmentFamilyRankBinding8.smartRefreshLayout) != null) {
            smartRefreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.family.v2
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    FamilyRankFragment.initAdapter$lambda$13(FamilyRankFragment.this, fVar);
                }
            });
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding9 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding9 != null && (superStatusView = fragmentFamilyRankBinding9.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.family.FamilyRankFragment$initAdapter$8
                public void onRetry(IStatusView statusView, Status status) {
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    FamilyRankFragment.this.getViewModel().getFamilyRank(FamilyRankFragment.this.getType());
                }
            });
        }
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.family.w2
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                FamilyRankFragment.initAdapter$lambda$15(FamilyRankFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$13(FamilyRankFragment familyRankFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        familyRankFragment.getViewModel().getFamilyRank(familyRankFragment.type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$15(FamilyRankFragment familyRankFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        long j;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (HiloUtils.INSTANCE.notFastClick()) {
            FamilyRankItem familyRankItem = (FamilyRankItem) familyRankFragment.getMAdapter().getData().get(i);
            Context context = familyRankFragment.getContext();
            if (context != null) {
                FamilyCenterActivity.Companion companion = FamilyCenterActivity.INSTANCE;
                Long id2 = familyRankItem.getId();
                if (id2 != null) {
                    j = id2.longValue();
                } else {
                    j = 0;
                }
                companion.startActivity(context, j);
            }
        }
    }

    private final void initData() {
        getViewModel().getFamilyData().observe(this, new FamilyRankFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.t2
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = FamilyRankFragment.initData$lambda$4(FamilyRankFragment.this, (FamilyRankData) obj);
                return initData$lambda$4;
            }
        }));
        getViewModel().getError().observe(this, new FamilyRankFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.family.u2
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = FamilyRankFragment.initData$lambda$5(FamilyRankFragment.this, (Throwable) obj);
                return initData$lambda$5;
            }
        }));
        getViewModel().getFamilyRank(this.type);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit initData$lambda$4(FamilyRankFragment familyRankFragment, FamilyRankData familyRankData) {
        int i;
        List<FamilyRankItem> items;
        List<FamilyRankItem> list;
        Function1<? super FamilyInfo, Unit> function1;
        List<FamilyRankItem> list2;
        List<FamilyRankItem> items2;
        List<FamilyRankItem> items3;
        List<FamilyRankItem> items4;
        familyRankFragment.topThreeData.clear();
        familyRankFragment.refreshTop(familyRankData);
        FamilyRankAdapter mAdapter = familyRankFragment.getMAdapter();
        int i2 = 0;
        if (familyRankData != null && (items4 = familyRankData.getItems()) != null) {
            i = items4.size();
        } else {
            i = 0;
        }
        FamilyInfo familyInfo = null;
        if (i > 3) {
            if (familyRankData != null && (items3 = familyRankData.getItems()) != null) {
                list2 = items3.subList(0, 3);
            } else {
                list2 = null;
            }
            if (list2 != null) {
                familyRankFragment.topThreeData.addAll(list2);
            }
            if (familyRankData != null && (items2 = familyRankData.getItems()) != null) {
                List<FamilyRankItem> items5 = familyRankData.getItems();
                if (items5 != null) {
                    i2 = items5.size();
                }
                list = items2.subList(3, i2);
                mAdapter.setList(list);
                function1 = familyRankFragment.mListener;
                if (function1 != null) {
                    if (familyRankData != null) {
                        familyInfo = familyRankData.getMyGroupPower();
                    }
                    function1.invoke(familyInfo);
                }
                return Unit.INSTANCE;
            }
        } else if (familyRankData != null && (items = familyRankData.getItems()) != null) {
            familyRankFragment.topThreeData.addAll(items);
        }
        list = null;
        mAdapter.setList(list);
        function1 = familyRankFragment.mListener;
        if (function1 != null) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(FamilyRankFragment familyRankFragment, Throwable th) {
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        FragmentFamilyRankBinding fragmentFamilyRankBinding = (FragmentFamilyRankBinding) familyRankFragment.getBinding();
        if (fragmentFamilyRankBinding != null && (smartRefreshLayout3 = fragmentFamilyRankBinding.smartRefreshLayout) != null) {
            smartRefreshLayout3.finishRefresh();
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding2 = (FragmentFamilyRankBinding) familyRankFragment.getBinding();
        if (fragmentFamilyRankBinding2 != null && (smartRefreshLayout2 = fragmentFamilyRankBinding2.smartRefreshLayout) != null) {
            smartRefreshLayout2.finishLoadMore();
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding3 = (FragmentFamilyRankBinding) familyRankFragment.getBinding();
        if (fragmentFamilyRankBinding3 != null && (smartRefreshLayout = fragmentFamilyRankBinding3.smartRefreshLayout) != null) {
            smartRefreshLayout.setNoMoreData(true);
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding4 = (FragmentFamilyRankBinding) familyRankFragment.getBinding();
        if (fragmentFamilyRankBinding4 != null && (superStatusView = fragmentFamilyRankBinding4.statusView) != null) {
            superStatusView.showError();
        }
        Function1<? super FamilyInfo, Unit> function1 = familyRankFragment.mListener;
        if (function1 != null) {
            function1.invoke((Object) null);
        }
        familyRankFragment.topThreeData.clear();
        familyRankFragment.refreshTop(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyRankAdapter mAdapter_delegate$lambda$0() {
        return new FamilyRankAdapter();
    }

    private final void refreshTop(FamilyRankData it) {
        int i;
        int i2;
        int i3;
        SuperStatusView superStatusView;
        SuperStatusView superStatusView2;
        SuperStatusView superStatusView3;
        List<FamilyRankItem> items;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        FamilyRankItem familyRankItem;
        LinearLayout linearLayout;
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding;
        View root;
        TextView textView;
        TextView textView2;
        PolygonImageView polygonImageView;
        String str;
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding2;
        int i4;
        String str2;
        String nameplate;
        Integer grade;
        TextView textView3;
        Long exp;
        TextView textView4;
        String str3;
        List<FamilyRankItem> items2;
        List<FamilyRankItem> items3;
        FamilyRankItem familyRankItem2;
        LinearLayout linearLayout2;
        int i5;
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding3;
        View root2;
        TextView textView5;
        TextView textView6;
        PolygonImageView polygonImageView2;
        String str4;
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding4;
        int i6;
        String str5;
        String nameplate2;
        Integer grade2;
        TextView textView7;
        long j;
        Long exp2;
        TextView textView8;
        String str6;
        List<FamilyRankItem> items4;
        List<FamilyRankItem> items5;
        FamilyRankItem familyRankItem3;
        LinearLayout linearLayout3;
        int i7;
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding5;
        View root3;
        TextView textView9;
        TextView textView10;
        PolygonImageView polygonImageView3;
        String str7;
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding6;
        int i8;
        String str8;
        String nameplate3;
        Integer grade3;
        TextView textView11;
        long j2;
        Long exp3;
        TextView textView12;
        String str9;
        List<FamilyRankItem> items6;
        List<FamilyRankItem> items7;
        LinearLayout linearLayout4;
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding7;
        View root4;
        TextView textView13;
        TextView textView14;
        LinearLayout linearLayout5;
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding8;
        View root5;
        TextView textView15;
        TextView textView16;
        LinearLayout linearLayout6;
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding9;
        View root6;
        TextView textView17;
        TextView textView18;
        FragmentFamilyRankBinding fragmentFamilyRankBinding = (FragmentFamilyRankBinding) getBinding();
        int i9 = 8;
        if (fragmentFamilyRankBinding != null && (textView18 = fragmentFamilyRankBinding.rankName1) != null) {
            textView18.setVisibility(8);
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding2 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding2 != null && (textView17 = fragmentFamilyRankBinding2.rankNumber1) != null) {
            textView17.setVisibility(8);
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding3 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding3 != null && (includeFamilyNamePlateBinding9 = fragmentFamilyRankBinding3.rankNamePlate1) != null && (root6 = includeFamilyNamePlateBinding9.getRoot()) != null) {
            root6.setVisibility(8);
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding4 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding4 != null && (linearLayout6 = fragmentFamilyRankBinding4.rankNumberLayout1) != null) {
            linearLayout6.setVisibility(8);
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding5 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding5 != null && (textView16 = fragmentFamilyRankBinding5.rankName2) != null) {
            textView16.setVisibility(8);
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding6 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding6 != null && (textView15 = fragmentFamilyRankBinding6.rankNumber2) != null) {
            textView15.setVisibility(8);
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding7 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding7 != null && (includeFamilyNamePlateBinding8 = fragmentFamilyRankBinding7.rankNamePlate2) != null && (root5 = includeFamilyNamePlateBinding8.getRoot()) != null) {
            root5.setVisibility(8);
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding8 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding8 != null && (linearLayout5 = fragmentFamilyRankBinding8.rankNumberLayout2) != null) {
            linearLayout5.setVisibility(8);
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding9 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding9 != null && (textView14 = fragmentFamilyRankBinding9.rankName3) != null) {
            textView14.setVisibility(8);
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding10 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding10 != null && (textView13 = fragmentFamilyRankBinding10.rankNumber3) != null) {
            textView13.setVisibility(8);
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding11 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding11 != null && (includeFamilyNamePlateBinding7 = fragmentFamilyRankBinding11.rankNamePlate3) != null && (root4 = includeFamilyNamePlateBinding7.getRoot()) != null) {
            root4.setVisibility(8);
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding12 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding12 != null && (linearLayout4 = fragmentFamilyRankBinding12.rankNumberLayout3) != null) {
            linearLayout4.setVisibility(8);
        }
        int i10 = 0;
        if (it != null && (items7 = it.getItems()) != null) {
            i = items7.size();
        } else {
            i = 0;
        }
        long j3 = 0;
        TextView textView19 = null;
        if (i >= 1) {
            if (it != null && (items6 = it.getItems()) != null) {
                familyRankItem3 = items6.get(0);
            } else {
                familyRankItem3 = null;
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding13 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding13 != null && (textView12 = fragmentFamilyRankBinding13.rankName1) != null) {
                if (familyRankItem3 == null || (str9 = familyRankItem3.getName()) == null) {
                    str9 = "";
                }
                textView12.setText(str9);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding14 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding14 != null && (textView11 = fragmentFamilyRankBinding14.rankNumber1) != null) {
                if (familyRankItem3 != null && (exp3 = familyRankItem3.getExp()) != null) {
                    j2 = exp3.longValue();
                } else {
                    j2 = 0;
                }
                textView11.setText(NumberUtilsKt.rankNumberFormat(j2));
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding15 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding15 != null && (includeFamilyNamePlateBinding6 = fragmentFamilyRankBinding15.rankNamePlate1) != null) {
                if (familyRankItem3 != null && (grade3 = familyRankItem3.getGrade()) != null) {
                    i8 = grade3.intValue();
                } else {
                    i8 = -1;
                }
                if (familyRankItem3 == null || (nameplate3 = familyRankItem3.getNameplate()) == null) {
                    str8 = "";
                } else {
                    str8 = nameplate3;
                }
                AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding6, i8, str8, 0, 4, (Object) null);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding16 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding16 != null && (polygonImageView3 = fragmentFamilyRankBinding16.rankAvatar1) != null) {
                if (familyRankItem3 != null) {
                    str7 = familyRankItem3.getIcon();
                } else {
                    str7 = null;
                }
                ImageKtxKt.loadImage$default(polygonImageView3, ImageSizeKt.image200(str7), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding17 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding17 != null && (textView10 = fragmentFamilyRankBinding17.rankName1) != null) {
                textView10.setVisibility(0);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding18 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding18 != null && (textView9 = fragmentFamilyRankBinding18.rankNumber1) != null) {
                textView9.setVisibility(0);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding19 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding19 != null && (includeFamilyNamePlateBinding5 = fragmentFamilyRankBinding19.rankNamePlate1) != null && (root3 = includeFamilyNamePlateBinding5.getRoot()) != null) {
                root3.setVisibility(0);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding20 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding20 != null && (linearLayout3 = fragmentFamilyRankBinding20.rankNumberLayout1) != null) {
                if (Intrinsics.areEqual(this.type, "day")) {
                    i7 = 0;
                } else {
                    i7 = 8;
                }
                linearLayout3.setVisibility(i7);
            }
        }
        if (it != null && (items5 = it.getItems()) != null) {
            i2 = items5.size();
        } else {
            i2 = 0;
        }
        if (i2 >= 2) {
            if (it != null && (items4 = it.getItems()) != null) {
                familyRankItem2 = items4.get(1);
            } else {
                familyRankItem2 = null;
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding21 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding21 != null && (textView8 = fragmentFamilyRankBinding21.rankName2) != null) {
                if (familyRankItem2 == null || (str6 = familyRankItem2.getName()) == null) {
                    str6 = "";
                }
                textView8.setText(str6);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding22 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding22 != null && (textView7 = fragmentFamilyRankBinding22.rankNumber2) != null) {
                if (familyRankItem2 != null && (exp2 = familyRankItem2.getExp()) != null) {
                    j = exp2.longValue();
                } else {
                    j = 0;
                }
                textView7.setText(NumberUtilsKt.rankNumberFormat(j));
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding23 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding23 != null && (includeFamilyNamePlateBinding4 = fragmentFamilyRankBinding23.rankNamePlate2) != null) {
                if (familyRankItem2 != null && (grade2 = familyRankItem2.getGrade()) != null) {
                    i6 = grade2.intValue();
                } else {
                    i6 = -1;
                }
                if (familyRankItem2 == null || (nameplate2 = familyRankItem2.getNameplate()) == null) {
                    str5 = "";
                } else {
                    str5 = nameplate2;
                }
                AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding4, i6, str5, 0, 4, (Object) null);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding24 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding24 != null && (polygonImageView2 = fragmentFamilyRankBinding24.rankAvatar2) != null) {
                if (familyRankItem2 != null) {
                    str4 = familyRankItem2.getIcon();
                } else {
                    str4 = null;
                }
                ImageKtxKt.loadImage$default(polygonImageView2, ImageSizeKt.image200(str4), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding25 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding25 != null && (textView6 = fragmentFamilyRankBinding25.rankName2) != null) {
                textView6.setVisibility(0);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding26 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding26 != null && (textView5 = fragmentFamilyRankBinding26.rankNumber2) != null) {
                textView5.setVisibility(0);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding27 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding27 != null && (includeFamilyNamePlateBinding3 = fragmentFamilyRankBinding27.rankNamePlate2) != null && (root2 = includeFamilyNamePlateBinding3.getRoot()) != null) {
                root2.setVisibility(0);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding28 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding28 != null && (linearLayout2 = fragmentFamilyRankBinding28.rankNumberLayout2) != null) {
                if (Intrinsics.areEqual(this.type, "day")) {
                    i5 = 0;
                } else {
                    i5 = 8;
                }
                linearLayout2.setVisibility(i5);
            }
        }
        if (it != null && (items3 = it.getItems()) != null) {
            i3 = items3.size();
        } else {
            i3 = 0;
        }
        if (i3 >= 3) {
            if (it != null && (items2 = it.getItems()) != null) {
                familyRankItem = items2.get(2);
            } else {
                familyRankItem = null;
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding29 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding29 != null && (textView4 = fragmentFamilyRankBinding29.rankName3) != null) {
                if (familyRankItem == null || (str3 = familyRankItem.getName()) == null) {
                    str3 = "";
                }
                textView4.setText(str3);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding30 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding30 != null && (textView3 = fragmentFamilyRankBinding30.rankNumber3) != null) {
                if (familyRankItem != null && (exp = familyRankItem.getExp()) != null) {
                    j3 = exp.longValue();
                }
                textView3.setText(NumberUtilsKt.rankNumberFormat(j3));
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding31 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding31 != null && (includeFamilyNamePlateBinding2 = fragmentFamilyRankBinding31.rankNamePlate3) != null) {
                if (familyRankItem != null && (grade = familyRankItem.getGrade()) != null) {
                    i4 = grade.intValue();
                } else {
                    i4 = -1;
                }
                if (familyRankItem == null || (nameplate = familyRankItem.getNameplate()) == null) {
                    str2 = "";
                } else {
                    str2 = nameplate;
                }
                AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding2, i4, str2, 0, 4, (Object) null);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding32 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding32 != null && (polygonImageView = fragmentFamilyRankBinding32.rankAvatar3) != null) {
                if (familyRankItem != null) {
                    str = familyRankItem.getIcon();
                } else {
                    str = null;
                }
                ImageKtxKt.loadImage$default(polygonImageView, ImageSizeKt.image200(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding33 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding33 != null && (textView2 = fragmentFamilyRankBinding33.rankName3) != null) {
                textView2.setVisibility(0);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding34 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding34 != null && (textView = fragmentFamilyRankBinding34.rankNumber3) != null) {
                textView.setVisibility(0);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding35 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding35 != null && (includeFamilyNamePlateBinding = fragmentFamilyRankBinding35.rankNamePlate3) != null && (root = includeFamilyNamePlateBinding.getRoot()) != null) {
                root.setVisibility(0);
            }
            FragmentFamilyRankBinding fragmentFamilyRankBinding36 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding36 != null && (linearLayout = fragmentFamilyRankBinding36.rankNumberLayout3) != null) {
                if (Intrinsics.areEqual(this.type, "day")) {
                    i9 = 0;
                }
                linearLayout.setVisibility(i9);
            }
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding37 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding37 != null && (smartRefreshLayout3 = fragmentFamilyRankBinding37.smartRefreshLayout) != null) {
            smartRefreshLayout3.finishRefresh();
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding38 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding38 != null && (smartRefreshLayout2 = fragmentFamilyRankBinding38.smartRefreshLayout) != null) {
            smartRefreshLayout2.finishLoadMore();
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding39 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding39 != null && (smartRefreshLayout = fragmentFamilyRankBinding39.smartRefreshLayout) != null) {
            smartRefreshLayout.setNoMoreData(true);
        }
        if (it != null && (items = it.getItems()) != null) {
            i10 = items.size();
        }
        if (i10 > 3) {
            FragmentFamilyRankBinding fragmentFamilyRankBinding40 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding40 != null && (superStatusView3 = fragmentFamilyRankBinding40.statusView) != null) {
                superStatusView3.showContent();
            }
        } else {
            FragmentFamilyRankBinding fragmentFamilyRankBinding41 = (FragmentFamilyRankBinding) getBinding();
            if (fragmentFamilyRankBinding41 != null && (superStatusView = fragmentFamilyRankBinding41.statusView) != null) {
                superStatusView.showEmpty();
            }
        }
        FragmentFamilyRankBinding fragmentFamilyRankBinding42 = (FragmentFamilyRankBinding) getBinding();
        if (fragmentFamilyRankBinding42 != null && (superStatusView2 = fragmentFamilyRankBinding42.statusView) != null) {
            textView19 = (TextView) superStatusView2.findViewById(2131362075);
        }
        Context context = getContext();
        if (context != null && textView19 != null) {
            textView19.setTextColor(androidx.core.content.a.getColor(context, 2131101214));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startFamilyCenter(int position) {
        Context context;
        long j;
        if (this.topThreeData.size() > position && (context = getContext()) != null) {
            FamilyCenterActivity.Companion companion = FamilyCenterActivity.INSTANCE;
            Long id2 = this.topThreeData.get(position).getId();
            if (id2 != null) {
                j = id2.longValue();
            } else {
                j = 0;
            }
            companion.startActivity(context, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FamilyRankViewModel viewModel_delegate$lambda$1(FamilyRankFragment familyRankFragment) {
        return new ViewModelProvider(familyRankFragment).get(FamilyRankViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_family_rank;
    }

    @NotNull
    public final FamilyRankAdapter getMAdapter() {
        return (FamilyRankAdapter) this.mAdapter.getValue();
    }

    @Nullable
    public final Function1<FamilyInfo, Unit> getMListener() {
        return this.mListener;
    }

    @NotNull
    public final ArrayList<FamilyRankItem> getTopThreeData() {
        return this.topThreeData;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @NotNull
    public final FamilyRankViewModel getViewModel() {
        return (FamilyRankViewModel) this.viewModel.getValue();
    }

    @cf.m(threadMode = ThreadMode.MAIN)
    public final void onDisbandFamilyEvent(@NotNull EventBusKey event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event.getType(), "disband_family")) {
            getViewModel().getFamilyRank(this.type);
        }
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initAdapter();
        initData();
    }

    public void onResume() {
        FamilyInfo familyInfo;
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        Function1<? super FamilyInfo, Unit> function1 = this.mListener;
        if (function1 != null) {
            FamilyRankData familyRankData = (FamilyRankData) getViewModel().getFamilyData().getValue();
            if (familyRankData != null) {
                familyInfo = familyRankData.getMyGroupPower();
            } else {
                familyInfo = null;
            }
            function1.invoke(familyInfo);
        }
    }

    public final void setMListener(@Nullable Function1<? super FamilyInfo, Unit> function1) {
        this.mListener = function1;
    }

    public final void setTopThreeData(@NotNull ArrayList<FamilyRankItem> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.topThreeData = arrayList;
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }
}
