package com.qiahao.nextvideo.ui.cp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.opensource.svgaplayer.SVGAImageView;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.cp.CpLevel;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RelationTypeUtils;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.cp.CpListData;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.FragmentCpChildBinding;
import com.qiahao.nextvideo.databinding.IncludeCpItemBinding;
import com.qiahao.nextvideo.ui.cp.CpSpaceActivity;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010%\u001a\u00020\u0006H\u0014J\b\u0010&\u001a\u00020\rH\u0016J\b\u0010'\u001a\u00020\rH\u0002J\u0018\u0010(\u001a\u00020\r2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010*H\u0003J\"\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020\u00142\b\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u00020\u0006H\u0002J\b\u00100\u001a\u00020\rH\u0002J\b\u00101\u001a\u00020\rH\u0002J\b\u00102\u001a\u00020\rH\u0016J\b\u00103\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R7\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\r\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0013j\b\u0012\u0004\u0012\u00020\u0014`\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010 \u001a\u00020!8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b\"\u0010#¨\u00064"}, d2 = {"Lcom/qiahao/nextvideo/ui/cp/CpChildFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentCpChildBinding;", "<init>", "()V", "fragmentType", "", "fragmentPeriod", "", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "getListener", "()Lkotlin/jvm/functions/Function1;", "setListener", "(Lkotlin/jvm/functions/Function1;)V", "topThreeData", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/cp/CpListData;", "Lkotlin/collections/ArrayList;", "getTopThreeData", "()Ljava/util/ArrayList;", "setTopThreeData", "(Ljava/util/ArrayList;)V", "mAdapter", "Lcom/qiahao/nextvideo/ui/cp/CpRankAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/cp/CpRankAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/cp/CpRankViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/cp/CpRankViewModel;", "viewModel$delegate", "getLayoutResId", "onInitialize", "initData", "refreshTop", "data", "", "refreshTopView", "cpBean", "topBinding", "Lcom/qiahao/nextvideo/databinding/IncludeCpItemBinding;", "position", "initView", "initAdapter", "onResume", "onPause", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCpChildFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CpChildFragment.kt\ncom/qiahao/nextvideo/ui/cp/CpChildFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,270:1\n1#2:271\n61#3,9:272\n61#3,9:281\n61#3,9:290\n*S KotlinDebug\n*F\n+ 1 CpChildFragment.kt\ncom/qiahao/nextvideo/ui/cp/CpChildFragment\n*L\n135#1:272,9\n140#1:281,9\n145#1:290,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpChildFragment extends BaseBindingFragment<FragmentCpChildBinding> {
    private int fragmentType;

    @Nullable
    private Function1<? super Integer, Unit> listener;

    @NotNull
    private String fragmentPeriod = "";

    @NotNull
    private ArrayList<CpListData> topThreeData = new ArrayList<>();

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.cp.c
        public final Object invoke() {
            CpRankAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = CpChildFragment.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.cp.d
        public final Object invoke() {
            CpRankViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = CpChildFragment.viewModel_delegate$lambda$1(CpChildFragment.this);
            return viewModel_delegate$lambda$1;
        }
    });

    private final void initAdapter() {
        SmartRefreshLayout smartRefreshLayout;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        RecyclerView recyclerView;
        getMAdapter().setMRelationType(getViewModel().getMRelationShip());
        FragmentCpChildBinding fragmentCpChildBinding = (FragmentCpChildBinding) getBinding();
        if (fragmentCpChildBinding != null && (recyclerView = fragmentCpChildBinding.recyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
        }
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            footLoading.setRootBackgroundColor(2131101214);
            FragmentCpChildBinding fragmentCpChildBinding2 = (FragmentCpChildBinding) getBinding();
            if (fragmentCpChildBinding2 != null && (smartRefreshLayout3 = fragmentCpChildBinding2.refreshLayout) != null) {
                smartRefreshLayout3.setRefreshFooter(footLoading);
            }
        }
        FragmentCpChildBinding fragmentCpChildBinding3 = (FragmentCpChildBinding) getBinding();
        if (fragmentCpChildBinding3 != null && (smartRefreshLayout2 = fragmentCpChildBinding3.refreshLayout) != null) {
            smartRefreshLayout2.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.cp.e
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    CpChildFragment.initAdapter$lambda$28(CpChildFragment.this, fVar);
                }
            });
        }
        FragmentCpChildBinding fragmentCpChildBinding4 = (FragmentCpChildBinding) getBinding();
        if (fragmentCpChildBinding4 != null && (superStatusView = fragmentCpChildBinding4.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpChildFragment$initAdapter$4
                public void onRetry(IStatusView statusView, Status status) {
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    CpChildFragment.this.getViewModel().getCpListData().resetPage();
                    CpChildFragment.this.getViewModel().getCpRank();
                }
            });
        }
        FragmentCpChildBinding fragmentCpChildBinding5 = (FragmentCpChildBinding) getBinding();
        if (fragmentCpChildBinding5 != null && (smartRefreshLayout = fragmentCpChildBinding5.refreshLayout) != null) {
            smartRefreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.cp.f
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    CpChildFragment.initAdapter$lambda$29(CpChildFragment.this, fVar);
                }
            });
        }
        getMAdapter().addChildClickViewIds(new int[]{2131362014, 2131362015, 2131363784});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.cp.g
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                CpChildFragment.initAdapter$lambda$34(CpChildFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$28(CpChildFragment cpChildFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        cpChildFragment.getViewModel().getCpListData().resetPage();
        cpChildFragment.getViewModel().getCpRank();
        Function1<? super Integer, Unit> function1 = cpChildFragment.listener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(cpChildFragment.fragmentType));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$29(CpChildFragment cpChildFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        cpChildFragment.getViewModel().getCpRank();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAdapter$lambda$34(CpChildFragment cpChildFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String externalId;
        String externalId2;
        int i2;
        Context context;
        String str;
        String externalId3;
        String str2;
        String externalId4;
        Integer level;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (HiloUtils.INSTANCE.notFastClick()) {
            CpListData cpListData = (CpListData) cpChildFragment.getMAdapter().getData().get(i);
            String str3 = "";
            switch (view.getId()) {
                case 2131362014:
                    if (UserStore.INSTANCE.getShared().checkSvipAndWealth() && cpChildFragment.getContext() != null) {
                        BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                        User user1 = cpListData.getUser1();
                        if (user1 != null && (externalId = user1.getExternalId()) != null) {
                            str3 = externalId;
                        }
                        baseControlUtils.openPersonPage(str3);
                        return;
                    }
                    return;
                case 2131362015:
                    if (UserStore.INSTANCE.getShared().checkSvipAndWealth() && cpChildFragment.getContext() != null) {
                        BaseControlUtils baseControlUtils2 = BaseControlUtils.INSTANCE;
                        User user2 = cpListData.getUser2();
                        if (user2 != null && (externalId2 = user2.getExternalId()) != null) {
                            str3 = externalId2;
                        }
                        baseControlUtils2.openPersonPage(str3);
                        return;
                    }
                    return;
                case 2131363784:
                    CpLevel cpLevel = cpListData.getCpLevel();
                    if (cpLevel != null && (level = cpLevel.getLevel()) != null) {
                        i2 = level.intValue();
                    } else {
                        i2 = 0;
                    }
                    int i3 = 1;
                    if (i2 > 0 && Intrinsics.areEqual(cpChildFragment.getViewModel().getMRelationShip(), CpFragment.FRAGMENT_CP)) {
                        Context context2 = cpChildFragment.getContext();
                        if (context2 != null) {
                            CpSpaceActivity.Companion companion = CpSpaceActivity.INSTANCE;
                            User user12 = cpListData.getUser1();
                            if (user12 == null || (str2 = user12.getExternalId()) == null) {
                                str2 = "";
                            }
                            User user22 = cpListData.getUser2();
                            if (user22 != null && (externalId4 = user22.getExternalId()) != null) {
                                str3 = externalId4;
                            }
                            Integer type = cpListData.getType();
                            if (type != null) {
                                i3 = type.intValue();
                            }
                            companion.startActivity(context2, str2, str3, i3);
                            return;
                        }
                        return;
                    }
                    if (!Intrinsics.areEqual(cpChildFragment.getViewModel().getMRelationShip(), CpFragment.FRAGMENT_CP) && (context = cpChildFragment.getContext()) != null) {
                        CpSpaceActivity.Companion companion2 = CpSpaceActivity.INSTANCE;
                        User user13 = cpListData.getUser1();
                        if (user13 == null || (str = user13.getExternalId()) == null) {
                            str = "";
                        }
                        User user23 = cpListData.getUser2();
                        if (user23 != null && (externalId3 = user23.getExternalId()) != null) {
                            str3 = externalId3;
                        }
                        Integer type2 = cpListData.getType();
                        if (type2 != null) {
                            i3 = type2.intValue();
                        }
                        companion2.startActivity(context, str, str3, i3);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final void initData() {
        getViewModel().getCpList().observe(this, new CpChildFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.a
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = CpChildFragment.initData$lambda$4(CpChildFragment.this, (List) obj);
                return initData$lambda$4;
            }
        }));
        getViewModel().getError().observe(this, new CpChildFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.cp.b
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = CpChildFragment.initData$lambda$5(CpChildFragment.this, (Throwable) obj);
                return initData$lambda$5;
            }
        }));
        getViewModel().getCpRank();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(CpChildFragment cpChildFragment, List list) {
        SuperStatusView superStatusView;
        int i;
        SuperStatusView superStatusView2;
        List list2;
        SuperStatusView superStatusView3;
        if (cpChildFragment.getViewModel().getCpListData().isOnePage()) {
            cpChildFragment.topThreeData.clear();
            cpChildFragment.refreshTop(list);
            CpRankAdapter mAdapter = cpChildFragment.getMAdapter();
            if (list != null) {
                i = list.size();
            } else {
                i = 0;
            }
            List list3 = null;
            if (i > 3) {
                if (list != null) {
                    list2 = list.subList(0, 3);
                } else {
                    list2 = null;
                }
                if (list2 != null) {
                    cpChildFragment.topThreeData.addAll(list2);
                }
                FragmentCpChildBinding fragmentCpChildBinding = (FragmentCpChildBinding) cpChildFragment.getBinding();
                if (fragmentCpChildBinding != null && (superStatusView3 = fragmentCpChildBinding.statusView) != null) {
                    superStatusView3.showContent();
                }
                if (list != null) {
                    list3 = list.subList(3, list.size());
                }
            } else {
                if (list != null) {
                    cpChildFragment.topThreeData.addAll(list);
                }
                FragmentCpChildBinding fragmentCpChildBinding2 = (FragmentCpChildBinding) cpChildFragment.getBinding();
                if (fragmentCpChildBinding2 != null && (superStatusView2 = fragmentCpChildBinding2.statusView) != null) {
                    superStatusView2.showEmpty();
                }
            }
            mAdapter.setList(list3);
        } else {
            CpRankAdapter mAdapter2 = cpChildFragment.getMAdapter();
            Intrinsics.checkNotNull(list);
            mAdapter2.addData(list);
            FragmentCpChildBinding fragmentCpChildBinding3 = (FragmentCpChildBinding) cpChildFragment.getBinding();
            if (fragmentCpChildBinding3 != null && (superStatusView = fragmentCpChildBinding3.statusView) != null) {
                superStatusView.showContent();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$5(CpChildFragment cpChildFragment, Throwable th) {
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        FragmentCpChildBinding fragmentCpChildBinding = (FragmentCpChildBinding) cpChildFragment.getBinding();
        if (fragmentCpChildBinding != null && (smartRefreshLayout3 = fragmentCpChildBinding.refreshLayout) != null) {
            smartRefreshLayout3.finishRefresh();
        }
        FragmentCpChildBinding fragmentCpChildBinding2 = (FragmentCpChildBinding) cpChildFragment.getBinding();
        if (fragmentCpChildBinding2 != null && (smartRefreshLayout2 = fragmentCpChildBinding2.refreshLayout) != null) {
            smartRefreshLayout2.finishLoadMore();
        }
        FragmentCpChildBinding fragmentCpChildBinding3 = (FragmentCpChildBinding) cpChildFragment.getBinding();
        if (fragmentCpChildBinding3 != null && (smartRefreshLayout = fragmentCpChildBinding3.refreshLayout) != null) {
            smartRefreshLayout.setNoMoreData(true);
        }
        FragmentCpChildBinding fragmentCpChildBinding4 = (FragmentCpChildBinding) cpChildFragment.getBinding();
        if (fragmentCpChildBinding4 != null && (superStatusView = fragmentCpChildBinding4.statusView) != null) {
            superStatusView.showEmpty();
        }
        cpChildFragment.topThreeData.clear();
        cpChildFragment.refreshTop(null);
        return Unit.INSTANCE;
    }

    private final void initView() {
        String str;
        int i;
        String str2;
        SmartRefreshLayout smartRefreshLayout;
        CpRankViewModel viewModel = getViewModel();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(CpFragment.FRAGMENT_TYPE_RELATION)) == null) {
            str = CpFragment.FRAGMENT_CP;
        }
        viewModel.setMRelationShip(str);
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            i = arguments2.getInt("fragment_type");
        } else {
            i = 0;
        }
        this.fragmentType = i;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str2 = arguments3.getString("fragment_period")) == null) {
            str2 = "";
        }
        this.fragmentPeriod = str2;
        getViewModel().setMDateType(this.fragmentPeriod);
        BaseListData cpListData = getViewModel().getCpListData();
        FragmentCpChildBinding fragmentCpChildBinding = (FragmentCpChildBinding) getBinding();
        SuperStatusView superStatusView = null;
        if (fragmentCpChildBinding != null) {
            smartRefreshLayout = fragmentCpChildBinding.refreshLayout;
        } else {
            smartRefreshLayout = null;
        }
        FragmentCpChildBinding fragmentCpChildBinding2 = (FragmentCpChildBinding) getBinding();
        if (fragmentCpChildBinding2 != null) {
            superStatusView = fragmentCpChildBinding2.statusView;
        }
        cpListData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CpRankAdapter mAdapter_delegate$lambda$0() {
        return new CpRankAdapter();
    }

    @SuppressLint({"SetTextI18n"})
    private final void refreshTop(List<CpListData> data) {
        int i;
        IncludeCpItemBinding includeCpItemBinding;
        View root;
        int i2;
        IncludeCpItemBinding includeCpItemBinding2;
        View root2;
        int i3;
        IncludeCpItemBinding includeCpItemBinding3;
        View root3;
        CpListData cpListData;
        IncludeCpItemBinding includeCpItemBinding4;
        View root4;
        CpListData cpListData2;
        IncludeCpItemBinding includeCpItemBinding5;
        IncludeCpItemBinding includeCpItemBinding6;
        View root5;
        CpListData cpListData3;
        IncludeCpItemBinding includeCpItemBinding7;
        IncludeCpItemBinding includeCpItemBinding8;
        View root6;
        if (data != null) {
            i = data.size();
        } else {
            i = 0;
        }
        IncludeCpItemBinding includeCpItemBinding9 = null;
        if (i >= 1) {
            if (data != null) {
                cpListData3 = data.get(0);
            } else {
                cpListData3 = null;
            }
            Intrinsics.checkNotNull(cpListData3);
            FragmentCpChildBinding fragmentCpChildBinding = (FragmentCpChildBinding) getBinding();
            if (fragmentCpChildBinding != null) {
                includeCpItemBinding7 = fragmentCpChildBinding.top1;
            } else {
                includeCpItemBinding7 = null;
            }
            refreshTopView(cpListData3, includeCpItemBinding7, 1);
            FragmentCpChildBinding fragmentCpChildBinding2 = (FragmentCpChildBinding) getBinding();
            if (fragmentCpChildBinding2 != null && (includeCpItemBinding8 = fragmentCpChildBinding2.top1) != null && (root6 = includeCpItemBinding8.getRoot()) != null) {
                root6.setVisibility(0);
            }
        } else {
            FragmentCpChildBinding fragmentCpChildBinding3 = (FragmentCpChildBinding) getBinding();
            if (fragmentCpChildBinding3 != null && (includeCpItemBinding = fragmentCpChildBinding3.top1) != null && (root = includeCpItemBinding.getRoot()) != null) {
                root.setVisibility(8);
            }
        }
        if (data != null) {
            i2 = data.size();
        } else {
            i2 = 0;
        }
        if (i2 >= 2) {
            if (data != null) {
                cpListData2 = data.get(1);
            } else {
                cpListData2 = null;
            }
            Intrinsics.checkNotNull(cpListData2);
            FragmentCpChildBinding fragmentCpChildBinding4 = (FragmentCpChildBinding) getBinding();
            if (fragmentCpChildBinding4 != null) {
                includeCpItemBinding5 = fragmentCpChildBinding4.top2;
            } else {
                includeCpItemBinding5 = null;
            }
            refreshTopView(cpListData2, includeCpItemBinding5, 2);
            FragmentCpChildBinding fragmentCpChildBinding5 = (FragmentCpChildBinding) getBinding();
            if (fragmentCpChildBinding5 != null && (includeCpItemBinding6 = fragmentCpChildBinding5.top2) != null && (root5 = includeCpItemBinding6.getRoot()) != null) {
                root5.setVisibility(0);
            }
        } else {
            FragmentCpChildBinding fragmentCpChildBinding6 = (FragmentCpChildBinding) getBinding();
            if (fragmentCpChildBinding6 != null && (includeCpItemBinding2 = fragmentCpChildBinding6.top2) != null && (root2 = includeCpItemBinding2.getRoot()) != null) {
                root2.setVisibility(8);
            }
        }
        if (data != null) {
            i3 = data.size();
        } else {
            i3 = 0;
        }
        if (i3 >= 3) {
            if (data != null) {
                cpListData = data.get(2);
            } else {
                cpListData = null;
            }
            Intrinsics.checkNotNull(cpListData);
            FragmentCpChildBinding fragmentCpChildBinding7 = (FragmentCpChildBinding) getBinding();
            if (fragmentCpChildBinding7 != null) {
                includeCpItemBinding9 = fragmentCpChildBinding7.top3;
            }
            refreshTopView(cpListData, includeCpItemBinding9, 3);
            FragmentCpChildBinding fragmentCpChildBinding8 = (FragmentCpChildBinding) getBinding();
            if (fragmentCpChildBinding8 != null && (includeCpItemBinding4 = fragmentCpChildBinding8.top3) != null && (root4 = includeCpItemBinding4.getRoot()) != null) {
                root4.setVisibility(0);
                return;
            }
            return;
        }
        FragmentCpChildBinding fragmentCpChildBinding9 = (FragmentCpChildBinding) getBinding();
        if (fragmentCpChildBinding9 != null && (includeCpItemBinding3 = fragmentCpChildBinding9.top3) != null && (root3 = includeCpItemBinding3.getRoot()) != null) {
            root3.setVisibility(8);
        }
    }

    private final void refreshTopView(CpListData cpBean, IncludeCpItemBinding topBinding, final int position) {
        ImageView imageView;
        Drawable drawable;
        ImageView imageView2;
        Drawable drawable2;
        int i;
        String str;
        int i2;
        String nick;
        NickTextView nickTextView;
        int i3;
        NobleInfo noble;
        Integer level;
        SvipData svip;
        int i4;
        NickTextView nickTextView2;
        SvipData svip2;
        String nick2;
        String nick3;
        NickTextView nickTextView3;
        int i5;
        int i6;
        NobleInfo noble2;
        Integer level2;
        SvipData svip3;
        int i7;
        NickTextView nickTextView4;
        SvipData svip4;
        CharSequence charSequence;
        String nick4;
        String nick5;
        HiloImageView hiloImageView;
        String str2;
        HiloImageView hiloImageView2;
        String str3;
        ImageView imageView3;
        Integer num;
        int i8;
        Drawable drawable3;
        HiloImageView hiloImageView3;
        String str4;
        HiloImageView hiloImageView4;
        String str5;
        final SVGAImageView sVGAImageView;
        final HiloImageView hiloImageView5;
        final HiloImageView hiloImageView6;
        ImageView imageView4;
        Drawable drawable4;
        ImageView imageView5;
        Drawable drawable5;
        ImageView imageView6;
        Drawable drawable6;
        ImageView imageView7;
        Drawable drawable7;
        CharSequence charSequence2 = null;
        if (position != 1) {
            if (position != 2) {
                if (position == 3) {
                    if (topBinding != null && (imageView7 = topBinding.bg1) != null) {
                        Context context = getContext();
                        if (context != null) {
                            drawable7 = androidx.core.content.a.getDrawable(context, R.drawable.icon_cp_rank_top3);
                        } else {
                            drawable7 = null;
                        }
                        imageView7.setImageDrawable(drawable7);
                    }
                    if (topBinding != null && (imageView6 = topBinding.bg2) != null) {
                        Context context2 = getContext();
                        if (context2 != null) {
                            drawable6 = androidx.core.content.a.getDrawable(context2, R.drawable.icon_cp_rank_top3);
                        } else {
                            drawable6 = null;
                        }
                        imageView6.setImageDrawable(drawable6);
                    }
                }
            } else {
                if (topBinding != null && (imageView5 = topBinding.bg1) != null) {
                    Context context3 = getContext();
                    if (context3 != null) {
                        drawable5 = androidx.core.content.a.getDrawable(context3, R.drawable.icon_cp_rank_top2);
                    } else {
                        drawable5 = null;
                    }
                    imageView5.setImageDrawable(drawable5);
                }
                if (topBinding != null && (imageView4 = topBinding.bg2) != null) {
                    Context context4 = getContext();
                    if (context4 != null) {
                        drawable4 = androidx.core.content.a.getDrawable(context4, R.drawable.icon_cp_rank_top3);
                    } else {
                        drawable4 = null;
                    }
                    imageView4.setImageDrawable(drawable4);
                }
            }
        } else {
            if (topBinding != null && (imageView2 = topBinding.bg1) != null) {
                Context context5 = getContext();
                if (context5 != null) {
                    drawable2 = androidx.core.content.a.getDrawable(context5, R.drawable.icon_cp_rank_top1);
                } else {
                    drawable2 = null;
                }
                imageView2.setImageDrawable(drawable2);
            }
            if (topBinding != null && (imageView = topBinding.bg2) != null) {
                Context context6 = getContext();
                if (context6 != null) {
                    drawable = androidx.core.content.a.getDrawable(context6, R.drawable.icon_cp_rank_top1);
                } else {
                    drawable = null;
                }
                imageView.setImageDrawable(drawable);
            }
        }
        if (topBinding != null && (hiloImageView6 = topBinding.avatar1) != null) {
            final long j = 800;
            hiloImageView6.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpChildFragment$refreshTopView$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str6;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(hiloImageView6) > j || (hiloImageView6 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(hiloImageView6, currentTimeMillis);
                        HiloImageView hiloImageView7 = hiloImageView6;
                        if (this.getTopThreeData().size() >= position && UserStore.INSTANCE.getShared().checkSvipAndWealth()) {
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            User user1 = this.getTopThreeData().get(position - 1).getUser1();
                            if (user1 == null || (str6 = user1.getExternalId()) == null) {
                                str6 = "";
                            }
                            baseControlUtils.openPersonPage(str6);
                        }
                    }
                }
            });
        }
        if (topBinding != null && (hiloImageView5 = topBinding.avatar2) != null) {
            final long j2 = 800;
            hiloImageView5.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpChildFragment$refreshTopView$$inlined$singleClick$default$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str6;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(hiloImageView5) > j2 || (hiloImageView5 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(hiloImageView5, currentTimeMillis);
                        HiloImageView hiloImageView7 = hiloImageView5;
                        if (this.getTopThreeData().size() >= position && UserStore.INSTANCE.getShared().checkSvipAndWealth()) {
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            User user2 = this.getTopThreeData().get(position - 1).getUser2();
                            if (user2 == null || (str6 = user2.getExternalId()) == null) {
                                str6 = "";
                            }
                            baseControlUtils.openPersonPage(str6);
                        }
                    }
                }
            });
        }
        if (topBinding != null && (sVGAImageView = topBinding.heartBg) != null) {
            final long j3 = 800;
            sVGAImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.cp.CpChildFragment$refreshTopView$$inlined$singleClick$default$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i9;
                    Context context7;
                    String str6;
                    String externalId;
                    String str7;
                    String externalId2;
                    Integer level3;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(sVGAImageView) > j3 || (sVGAImageView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(sVGAImageView, currentTimeMillis);
                        SVGAImageView sVGAImageView2 = sVGAImageView;
                        if (this.getTopThreeData().size() >= position) {
                            int i10 = 1;
                            CpLevel cpLevel = this.getTopThreeData().get(position - 1).getCpLevel();
                            if (cpLevel != null && (level3 = cpLevel.getLevel()) != null) {
                                i9 = level3.intValue();
                            } else {
                                i9 = 0;
                            }
                            String str8 = "";
                            if (i9 > 0 && Intrinsics.areEqual(this.getViewModel().getMRelationShip(), CpFragment.FRAGMENT_CP)) {
                                Context context8 = this.getContext();
                                if (context8 != null) {
                                    CpSpaceActivity.Companion companion = CpSpaceActivity.INSTANCE;
                                    User user1 = this.getTopThreeData().get(position - 1).getUser1();
                                    if (user1 == null || (str7 = user1.getExternalId()) == null) {
                                        str7 = "";
                                    }
                                    User user2 = this.getTopThreeData().get(position - 1).getUser2();
                                    if (user2 != null && (externalId2 = user2.getExternalId()) != null) {
                                        str8 = externalId2;
                                    }
                                    Integer type = this.getTopThreeData().get(position - 1).getType();
                                    if (type != null) {
                                        i10 = type.intValue();
                                    }
                                    companion.startActivity(context8, str7, str8, i10);
                                    return;
                                }
                                return;
                            }
                            if (!Intrinsics.areEqual(this.getViewModel().getMRelationShip(), CpFragment.FRAGMENT_CP) && (context7 = this.getContext()) != null) {
                                CpSpaceActivity.Companion companion2 = CpSpaceActivity.INSTANCE;
                                User user12 = this.getTopThreeData().get(position - 1).getUser1();
                                if (user12 == null || (str6 = user12.getExternalId()) == null) {
                                    str6 = "";
                                }
                                User user22 = this.getTopThreeData().get(position - 1).getUser2();
                                if (user22 != null && (externalId = user22.getExternalId()) != null) {
                                    str8 = externalId;
                                }
                                Integer type2 = this.getTopThreeData().get(position - 1).getType();
                                if (type2 != null) {
                                    i10 = type2.intValue();
                                }
                                companion2.startActivity(context7, str6, str8, i10);
                            }
                        }
                    }
                }
            });
        }
        if (topBinding != null && (hiloImageView4 = topBinding.avatar1) != null) {
            User user1 = cpBean.getUser1();
            if (user1 != null) {
                str5 = user1.getAvatar();
            } else {
                str5 = null;
            }
            HiloImageView.loadImage$default(hiloImageView4, ImageSizeKt.image100(str5), 0, 0, 6, (Object) null);
        }
        String str6 = "";
        if (topBinding != null && (hiloImageView3 = topBinding.avatar1) != null) {
            User user12 = cpBean.getUser1();
            if (user12 == null || (str4 = user12.getExternalId()) == null) {
                str4 = "";
            }
            hiloImageView3.setTag(str4);
        }
        if (topBinding != null && (imageView3 = topBinding.medal) != null) {
            RelationTypeUtils relationTypeUtils = RelationTypeUtils.INSTANCE;
            CpLevel cpLevel = cpBean.getCpLevel();
            if (cpLevel != null) {
                num = cpLevel.getLevel();
            } else {
                num = null;
            }
            Integer type = cpBean.getType();
            if (type != null) {
                i8 = type.intValue();
            } else {
                i8 = 1;
            }
            Integer relationMedal = relationTypeUtils.getRelationMedal(num, true, i8);
            if (relationMedal != null) {
                int intValue = relationMedal.intValue();
                Context context7 = getContext();
                if (context7 != null) {
                    drawable3 = androidx.core.content.a.getDrawable(context7, intValue);
                    imageView3.setImageDrawable(drawable3);
                }
            }
            drawable3 = null;
            imageView3.setImageDrawable(drawable3);
        }
        if (topBinding != null && (hiloImageView2 = topBinding.avatar2) != null) {
            User user2 = cpBean.getUser2();
            if (user2 != null) {
                str3 = user2.getAvatar();
            } else {
                str3 = null;
            }
            HiloImageView.loadImage$default(hiloImageView2, ImageSizeKt.image100(str3), 0, 0, 6, (Object) null);
        }
        if (topBinding != null && (hiloImageView = topBinding.avatar2) != null) {
            User user22 = cpBean.getUser2();
            if (user22 == null || (str2 = user22.getExternalId()) == null) {
                str2 = "";
            }
            hiloImageView.setTag(str2);
        }
        User user13 = cpBean.getUser1();
        int i9 = 0;
        if (user13 != null && (nick5 = user13.getNick()) != null) {
            i = nick5.length();
        } else {
            i = 0;
        }
        if (i > 12) {
            User user14 = cpBean.getUser1();
            if (user14 != null && (nick4 = user14.getNick()) != null) {
                charSequence = nick4.subSequence(0, 11);
            } else {
                charSequence = null;
            }
            str = ((Object) charSequence) + "...";
        } else {
            User user15 = cpBean.getUser1();
            if (user15 != null) {
                str = user15.getNick();
            } else {
                str = null;
            }
        }
        Context context8 = getContext();
        if (context8 != null) {
            int color = androidx.core.content.a.getColor(context8, 2131101214);
            UserService.Companion companion = UserService.INSTANCE;
            User user16 = cpBean.getUser1();
            if (user16 != null && (svip4 = user16.getSvip()) != null) {
                i7 = svip4.getSvipLevel();
            } else {
                i7 = 0;
            }
            int nobleColor = companion.getNobleColor(i7, color);
            if (topBinding != null && (nickTextView4 = topBinding.userName1) != null) {
                nickTextView4.setTextColor(nobleColor);
            }
        }
        if (topBinding != null && (nickTextView3 = topBinding.userName1) != null) {
            User user17 = cpBean.getUser1();
            if (user17 != null && (svip3 = user17.getSvip()) != null) {
                i5 = svip3.getSvipLevel();
            } else {
                i5 = 0;
            }
            User user18 = cpBean.getUser1();
            if (user18 != null && (noble2 = user18.getNoble()) != null && (level2 = noble2.getLevel()) != null) {
                i6 = level2.intValue();
            } else {
                i6 = 0;
            }
            nickTextView3.setSVipAndNoble(str, i5, i6);
        }
        User user23 = cpBean.getUser2();
        if (user23 != null && (nick3 = user23.getNick()) != null) {
            i2 = nick3.length();
        } else {
            i2 = 0;
        }
        if (i2 > 12) {
            User user24 = cpBean.getUser2();
            if (user24 != null && (nick2 = user24.getNick()) != null) {
                charSequence2 = nick2.subSequence(0, 11);
            }
            str6 = ((Object) charSequence2) + "...";
        } else {
            User user25 = cpBean.getUser2();
            if (user25 != null && (nick = user25.getNick()) != null) {
                str6 = nick;
            }
        }
        Context context9 = getContext();
        if (context9 != null) {
            int color2 = androidx.core.content.a.getColor(context9, 2131101214);
            UserService.Companion companion2 = UserService.INSTANCE;
            User user26 = cpBean.getUser2();
            if (user26 != null && (svip2 = user26.getSvip()) != null) {
                i4 = svip2.getSvipLevel();
            } else {
                i4 = 0;
            }
            int nobleColor2 = companion2.getNobleColor(i4, color2);
            if (topBinding != null && (nickTextView2 = topBinding.userName2) != null) {
                nickTextView2.setTextColor(nobleColor2);
            }
        }
        if (topBinding != null && (nickTextView = topBinding.userName2) != null) {
            User user27 = cpBean.getUser2();
            if (user27 != null && (svip = user27.getSvip()) != null) {
                i3 = svip.getSvipLevel();
            } else {
                i3 = 0;
            }
            User user28 = cpBean.getUser2();
            if (user28 != null && (noble = user28.getNoble()) != null && (level = noble.getLevel()) != null) {
                i9 = level.intValue();
            }
            nickTextView.setSVipAndNoble(str6, i3, i9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CpRankViewModel viewModel_delegate$lambda$1(CpChildFragment cpChildFragment) {
        return new ViewModelProvider(cpChildFragment).get(CpRankViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_cp_child;
    }

    @Nullable
    public final Function1<Integer, Unit> getListener() {
        return this.listener;
    }

    @NotNull
    public final CpRankAdapter getMAdapter() {
        return (CpRankAdapter) this.mAdapter.getValue();
    }

    @NotNull
    public final ArrayList<CpListData> getTopThreeData() {
        return this.topThreeData;
    }

    @NotNull
    public final CpRankViewModel getViewModel() {
        return (CpRankViewModel) this.viewModel.getValue();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initAdapter();
        initData();
    }

    public void onPause() {
        IncludeCpItemBinding includeCpItemBinding;
        SVGAImageView sVGAImageView;
        IncludeCpItemBinding includeCpItemBinding2;
        SVGAImageView sVGAImageView2;
        IncludeCpItemBinding includeCpItemBinding3;
        SVGAImageView sVGAImageView3;
        super/*com.qiahao.base_common.common.BaseFragment*/.onPause();
        FragmentCpChildBinding fragmentCpChildBinding = (FragmentCpChildBinding) getBinding();
        if (fragmentCpChildBinding != null && (includeCpItemBinding3 = fragmentCpChildBinding.top1) != null && (sVGAImageView3 = includeCpItemBinding3.heartBg) != null) {
            sVGAImageView3.stopAnimation();
        }
        FragmentCpChildBinding fragmentCpChildBinding2 = (FragmentCpChildBinding) getBinding();
        if (fragmentCpChildBinding2 != null && (includeCpItemBinding2 = fragmentCpChildBinding2.top2) != null && (sVGAImageView2 = includeCpItemBinding2.heartBg) != null) {
            sVGAImageView2.stopAnimation();
        }
        FragmentCpChildBinding fragmentCpChildBinding3 = (FragmentCpChildBinding) getBinding();
        if (fragmentCpChildBinding3 != null && (includeCpItemBinding = fragmentCpChildBinding3.top3) != null && (sVGAImageView = includeCpItemBinding.heartBg) != null) {
            sVGAImageView.stopAnimation();
        }
    }

    public void onResume() {
        IncludeCpItemBinding includeCpItemBinding;
        SVGAImageView sVGAImageView;
        IncludeCpItemBinding includeCpItemBinding2;
        SVGAImageView sVGAImageView2;
        IncludeCpItemBinding includeCpItemBinding3;
        SVGAImageView sVGAImageView3;
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        FragmentCpChildBinding fragmentCpChildBinding = (FragmentCpChildBinding) getBinding();
        if (fragmentCpChildBinding != null && (includeCpItemBinding3 = fragmentCpChildBinding.top1) != null && (sVGAImageView3 = includeCpItemBinding3.heartBg) != null) {
            sVGAImageView3.startAnimation();
        }
        FragmentCpChildBinding fragmentCpChildBinding2 = (FragmentCpChildBinding) getBinding();
        if (fragmentCpChildBinding2 != null && (includeCpItemBinding2 = fragmentCpChildBinding2.top2) != null && (sVGAImageView2 = includeCpItemBinding2.heartBg) != null) {
            sVGAImageView2.startAnimation();
        }
        FragmentCpChildBinding fragmentCpChildBinding3 = (FragmentCpChildBinding) getBinding();
        if (fragmentCpChildBinding3 != null && (includeCpItemBinding = fragmentCpChildBinding3.top3) != null && (sVGAImageView = includeCpItemBinding.heartBg) != null) {
            sVGAImageView.startAnimation();
        }
    }

    public final void setListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.listener = function1;
    }

    public final void setTopThreeData(@NotNull ArrayList<CpListData> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.topThreeData = arrayList;
    }
}
