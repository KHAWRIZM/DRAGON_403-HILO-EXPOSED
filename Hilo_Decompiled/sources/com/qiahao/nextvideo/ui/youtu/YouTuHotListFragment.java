package com.qiahao.nextvideo.ui.youtu;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.model.youtube.YouTuBeData;
import com.qiahao.nextvideo.databinding.FragmentYouTuHotListBinding;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010!\u001a\u00020\"H\u0014J\b\u0010#\u001a\u00020\u000bH\u0016J\b\u0010$\u001a\u00020\u000bH\u0002J\b\u0010%\u001a\u00020\u000bH\u0002R9\u0010\u0005\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001f¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/ui/youtu/YouTuHotListFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentYouTuHotListBinding;", "<init>", "()V", "mListener", "Lkotlin/Function1;", "Lcom/qiahao/nextvideo/data/model/youtube/YouTuBeData;", "Lkotlin/ParameterName;", "name", "data", "", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "mDismiss", "Lkotlin/Function0;", "getMDismiss", "()Lkotlin/jvm/functions/Function0;", "setMDismiss", "(Lkotlin/jvm/functions/Function0;)V", "mViewModel", "Lcom/qiahao/nextvideo/ui/youtu/YouTuViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/ui/youtu/YouTuViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mAdapter", "Lcom/qiahao/nextvideo/ui/youtu/YouTuHotAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/youtu/YouTuHotAdapter;", "mAdapter$delegate", "getLayoutResId", "", "onInitialize", "initData", "initView", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nYouTuHotListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 YouTuHotListFragment.kt\ncom/qiahao/nextvideo/ui/youtu/YouTuHotListFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,84:1\n1#2:85\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class YouTuHotListFragment extends BaseBindingFragment<FragmentYouTuHotListBinding> {

    @Nullable
    private Function0<Unit> mDismiss;

    @Nullable
    private Function1<? super YouTuBeData, Unit> mListener;

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.youtu.c
        public final Object invoke() {
            YouTuViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = YouTuHotListFragment.mViewModel_delegate$lambda$0(YouTuHotListFragment.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.youtu.d
        public final Object invoke() {
            YouTuHotAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = YouTuHotListFragment.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    private final void initData() {
        getMViewModel().getHotList().observe(this, new YouTuHotListFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.e
            public final Object invoke(Object obj) {
                Unit initData$lambda$2;
                initData$lambda$2 = YouTuHotListFragment.initData$lambda$2(YouTuHotListFragment.this, (ArrayList) obj);
                return initData$lambda$2;
            }
        }));
        getMViewModel().getMException().observe(this, new YouTuHotListFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.f
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = YouTuHotListFragment.initData$lambda$3(YouTuHotListFragment.this, (Pair) obj);
                return initData$lambda$3;
            }
        }));
        getMViewModel().hotYouTuList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$2(YouTuHotListFragment youTuHotListFragment, ArrayList arrayList) {
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout;
        SuperStatusView superStatusView2;
        youTuHotListFragment.getMAdapter().setList(arrayList);
        if (arrayList.isEmpty()) {
            FragmentYouTuHotListBinding fragmentYouTuHotListBinding = (FragmentYouTuHotListBinding) youTuHotListFragment.getBinding();
            if (fragmentYouTuHotListBinding != null && (superStatusView2 = fragmentYouTuHotListBinding.statusView) != null) {
                superStatusView2.showEmpty();
            }
        } else {
            FragmentYouTuHotListBinding fragmentYouTuHotListBinding2 = (FragmentYouTuHotListBinding) youTuHotListFragment.getBinding();
            if (fragmentYouTuHotListBinding2 != null && (superStatusView = fragmentYouTuHotListBinding2.statusView) != null) {
                superStatusView.showContent();
            }
        }
        FragmentYouTuHotListBinding fragmentYouTuHotListBinding3 = (FragmentYouTuHotListBinding) youTuHotListFragment.getBinding();
        if (fragmentYouTuHotListBinding3 != null && (smartRefreshLayout = fragmentYouTuHotListBinding3.refreshLayout) != null) {
            smartRefreshLayout.finishRefresh();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(YouTuHotListFragment youTuHotListFragment, Pair pair) {
        FragmentYouTuHotListBinding fragmentYouTuHotListBinding;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout;
        if (Intrinsics.areEqual(pair.getFirst(), YouTuViewModel.TYPE_HOT_LIST)) {
            FragmentYouTuHotListBinding fragmentYouTuHotListBinding2 = (FragmentYouTuHotListBinding) youTuHotListFragment.getBinding();
            if (fragmentYouTuHotListBinding2 != null && (smartRefreshLayout = fragmentYouTuHotListBinding2.refreshLayout) != null) {
                smartRefreshLayout.finishRefresh();
            }
            if (pair.getSecond() instanceof HiloException) {
                HiloToasty.Companion companion = HiloToasty.Companion;
                Context context = youTuHotListFragment.getContext();
                Object second = pair.getSecond();
                Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
                String errorMessage = ((HiloException) second).getErrorMessage();
                if (errorMessage == null) {
                    errorMessage = ResourcesKtxKt.getStringById(youTuHotListFragment, 2131952667);
                }
                HiloToasty.Companion.normal$default(companion, context, errorMessage, false, 4, (Object) null);
                if (youTuHotListFragment.getMAdapter().getData().isEmpty() && (fragmentYouTuHotListBinding = (FragmentYouTuHotListBinding) youTuHotListFragment.getBinding()) != null && (superStatusView = fragmentYouTuHotListBinding.statusView) != null) {
                    superStatusView.showEmpty();
                }
            }
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        RecyclerView recyclerView;
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SuperStatusView superStatusView;
        SuperStatusView superStatusView2;
        SuperStatusView superStatusView3;
        SuperStatusView superStatusView4;
        FragmentYouTuHotListBinding fragmentYouTuHotListBinding = (FragmentYouTuHotListBinding) getBinding();
        if (fragmentYouTuHotListBinding != null && (superStatusView4 = fragmentYouTuHotListBinding.statusView) != null) {
            superStatusView4.addStatus(Status.Empty.INSTANCE, R.layout.room_list_empty);
        }
        FragmentYouTuHotListBinding fragmentYouTuHotListBinding2 = (FragmentYouTuHotListBinding) getBinding();
        if (fragmentYouTuHotListBinding2 != null && (superStatusView3 = fragmentYouTuHotListBinding2.statusView) != null) {
            superStatusView3.addStatus(Status.Error.INSTANCE, R.layout.room_list_empty);
        }
        FragmentYouTuHotListBinding fragmentYouTuHotListBinding3 = (FragmentYouTuHotListBinding) getBinding();
        if (fragmentYouTuHotListBinding3 != null && (superStatusView2 = fragmentYouTuHotListBinding3.statusView) != null) {
            superStatusView2.addStatus(Status.Loading.INSTANCE, 2131558549);
        }
        FragmentYouTuHotListBinding fragmentYouTuHotListBinding4 = (FragmentYouTuHotListBinding) getBinding();
        if (fragmentYouTuHotListBinding4 != null && (superStatusView = fragmentYouTuHotListBinding4.statusView) != null) {
            superStatusView.addStatus(Status.NoNetwork.INSTANCE, R.layout.gift_status_empty);
        }
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            footLoading.setRootBackgroundColor(2131101214);
            FragmentYouTuHotListBinding fragmentYouTuHotListBinding5 = (FragmentYouTuHotListBinding) getBinding();
            if (fragmentYouTuHotListBinding5 != null && (smartRefreshLayout2 = fragmentYouTuHotListBinding5.refreshLayout) != null) {
                smartRefreshLayout2.setRefreshFooter(footLoading);
            }
        }
        FragmentYouTuHotListBinding fragmentYouTuHotListBinding6 = (FragmentYouTuHotListBinding) getBinding();
        if (fragmentYouTuHotListBinding6 != null && (smartRefreshLayout = fragmentYouTuHotListBinding6.refreshLayout) != null) {
            smartRefreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.youtu.a
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    YouTuHotListFragment.initView$lambda$7(YouTuHotListFragment.this, fVar);
                }
            });
        }
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.youtu.b
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YouTuHotListFragment.initView$lambda$8(YouTuHotListFragment.this, baseQuickAdapter, view, i);
            }
        });
        FragmentYouTuHotListBinding fragmentYouTuHotListBinding7 = (FragmentYouTuHotListBinding) getBinding();
        if (fragmentYouTuHotListBinding7 != null && (recyclerView = fragmentYouTuHotListBinding7.recyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(YouTuHotListFragment youTuHotListFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        youTuHotListFragment.getMViewModel().hotYouTuList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(YouTuHotListFragment youTuHotListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        YouTuBeData youTuBeData = (YouTuBeData) youTuHotListFragment.getMAdapter().getData().get(i);
        Function1<? super YouTuBeData, Unit> function1 = youTuHotListFragment.mListener;
        if (function1 != null) {
            function1.invoke(youTuBeData);
        }
        Function0<Unit> function0 = youTuHotListFragment.mDismiss;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YouTuHotAdapter mAdapter_delegate$lambda$1() {
        return new YouTuHotAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YouTuViewModel mViewModel_delegate$lambda$0(YouTuHotListFragment youTuHotListFragment) {
        return new ViewModelProvider(youTuHotListFragment).get(YouTuViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_you_tu_hot_list;
    }

    @NotNull
    public final YouTuHotAdapter getMAdapter() {
        return (YouTuHotAdapter) this.mAdapter.getValue();
    }

    @Nullable
    public final Function0<Unit> getMDismiss() {
        return this.mDismiss;
    }

    @Nullable
    public final Function1<YouTuBeData, Unit> getMListener() {
        return this.mListener;
    }

    @NotNull
    public final YouTuViewModel getMViewModel() {
        return (YouTuViewModel) this.mViewModel.getValue();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }

    public final void setMDismiss(@Nullable Function0<Unit> function0) {
        this.mDismiss = function0;
    }

    public final void setMListener(@Nullable Function1<? super YouTuBeData, Unit> function1) {
        this.mListener = function1;
    }
}
