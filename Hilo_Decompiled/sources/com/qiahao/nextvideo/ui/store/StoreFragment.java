package com.qiahao.nextvideo.ui.store;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.RelationStoreData;
import com.qiahao.base_common.model.StoreBean;
import com.qiahao.base_common.model.common.User;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.FragmentStoreBinding;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0002J\b\u0010!\u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020\u001fH\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00188FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001a¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/StoreFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentStoreBinding;", "<init>", "()V", "mListener", "Lcom/qiahao/nextvideo/ui/store/StoreListener;", "getMListener", "()Lcom/qiahao/nextvideo/ui/store/StoreListener;", "setMListener", "(Lcom/qiahao/nextvideo/ui/store/StoreListener;)V", "viewModel", "Lcom/qiahao/nextvideo/ui/store/StoreViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/store/StoreViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "mSelectBean", "Lcom/qiahao/base_common/model/StoreBean;", "getMSelectBean", "()Lcom/qiahao/base_common/model/StoreBean;", "setMSelectBean", "(Lcom/qiahao/base_common/model/StoreBean;)V", "mAdapter", "Lcom/qiahao/nextvideo/ui/store/StoreAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/store/StoreAdapter;", "mAdapter$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "onResume", "onDestroy", "refreshSelect", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStoreFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StoreFragment.kt\ncom/qiahao/nextvideo/ui/store/StoreFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,143:1\n1#2:144\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class StoreFragment extends BaseBindingFragment<FragmentStoreBinding> {
    public static final int CARD_TYPE = 3;
    public static final int CARROM_TYPE = 2;
    public static final int HEAD_WEAR_TYPE = 0;
    public static final int MOUNTS_TYPE = 1;

    @NotNull
    public static final String STORE_TYPE = "STORE_TYPE";

    @Nullable
    private StoreListener mListener;

    @Nullable
    private StoreBean mSelectBean;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.store.c2
        public final Object invoke() {
            StoreViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = StoreFragment.viewModel_delegate$lambda$0(StoreFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.store.d2
        public final Object invoke() {
            StoreAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = StoreFragment.mAdapter_delegate$lambda$1(StoreFragment.this);
            return mAdapter_delegate$lambda$1;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final StoreViewModel getViewModel() {
        return (StoreViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getStoreList().observe(this, new StoreFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.store.b2
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = StoreFragment.initData$lambda$3(StoreFragment.this, (List) obj);
                return initData$lambda$3;
            }
        }));
        getViewModel().getStoreListData().resetPage();
        getViewModel().m٨٦getStoreList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(StoreFragment storeFragment, List list) {
        long j;
        if (storeFragment.getViewModel().getStoreListData().isOnePage()) {
            if (list != null && !list.isEmpty()) {
                StoreAdapter mAdapter = storeFragment.getMAdapter();
                Long id2 = ((StoreBean) list.get(0)).getId();
                if (id2 != null) {
                    j = id2.longValue();
                } else {
                    j = 0;
                }
                mAdapter.setMSelectId(j);
                storeFragment.mSelectBean = (StoreBean) list.get(0);
            }
            storeFragment.getMAdapter().setList(list);
            if (storeFragment.isResumed()) {
                storeFragment.refreshSelect();
            }
        } else if (list != null) {
            storeFragment.getMAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        int i;
        SmartRefreshLayout smartRefreshLayout;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        StoreViewModel viewModel = getViewModel();
        Bundle arguments = getArguments();
        if (arguments != null) {
            i = arguments.getInt(STORE_TYPE);
        } else {
            i = 0;
        }
        viewModel.setType(i);
        BaseListData storeListData = getViewModel().getStoreListData();
        FragmentStoreBinding fragmentStoreBinding = (FragmentStoreBinding) getBinding();
        SuperStatusView superStatusView2 = null;
        if (fragmentStoreBinding != null) {
            smartRefreshLayout = fragmentStoreBinding.refreshLayout;
        } else {
            smartRefreshLayout = null;
        }
        FragmentStoreBinding fragmentStoreBinding2 = (FragmentStoreBinding) getBinding();
        if (fragmentStoreBinding2 != null) {
            superStatusView2 = fragmentStoreBinding2.statusView;
        }
        storeListData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView2);
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentStoreBinding fragmentStoreBinding3 = (FragmentStoreBinding) getBinding();
            if (fragmentStoreBinding3 != null && (smartRefreshLayout4 = fragmentStoreBinding3.refreshLayout) != null) {
                smartRefreshLayout4.setRefreshFooter(footLoading);
            }
        }
        FragmentStoreBinding fragmentStoreBinding4 = (FragmentStoreBinding) getBinding();
        if (fragmentStoreBinding4 != null && (smartRefreshLayout3 = fragmentStoreBinding4.refreshLayout) != null) {
            smartRefreshLayout3.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.store.e2
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    StoreFragment.initView$lambda$6(StoreFragment.this, fVar);
                }
            });
        }
        FragmentStoreBinding fragmentStoreBinding5 = (FragmentStoreBinding) getBinding();
        if (fragmentStoreBinding5 != null && (smartRefreshLayout2 = fragmentStoreBinding5.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.store.f2
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    StoreFragment.initView$lambda$7(StoreFragment.this, fVar);
                }
            });
        }
        FragmentStoreBinding fragmentStoreBinding6 = (FragmentStoreBinding) getBinding();
        if (fragmentStoreBinding6 != null && (superStatusView = fragmentStoreBinding6.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.store.StoreFragment$initView$5
                public void onRetry(IStatusView statusView, Status status) {
                    StoreViewModel viewModel2;
                    StoreViewModel viewModel3;
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    viewModel2 = StoreFragment.this.getViewModel();
                    viewModel2.getStoreListData().resetPage();
                    viewModel3 = StoreFragment.this.getViewModel();
                    viewModel3.m٨٦getStoreList();
                }
            });
        }
        FragmentStoreBinding fragmentStoreBinding7 = (FragmentStoreBinding) getBinding();
        if (fragmentStoreBinding7 != null && (recyclerView2 = fragmentStoreBinding7.recyclerView) != null) {
            recyclerView2.setAdapter(getMAdapter());
        }
        FragmentStoreBinding fragmentStoreBinding8 = (FragmentStoreBinding) getBinding();
        if (fragmentStoreBinding8 != null && (recyclerView = fragmentStoreBinding8.recyclerView) != null) {
            recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.qiahao.nextvideo.ui.store.StoreFragment$initView$6
                public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                    Intrinsics.checkNotNullParameter(outRect, "outRect");
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(state, "state");
                    super.getItemOffsets(outRect, view, parent, state);
                    outRect.top = UiKtxKt.toPX(10);
                }
            });
        }
        getMAdapter().addChildClickViewIds(new int[]{R.id.play_icon, R.id.back_content});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.store.g2
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i2) {
                StoreFragment.initView$lambda$9(StoreFragment.this, baseQuickAdapter, view, i2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(StoreFragment storeFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        storeFragment.getViewModel().getStoreListData().resetPage();
        storeFragment.getViewModel().m٨٦getStoreList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(StoreFragment storeFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        storeFragment.getViewModel().m٨٦getStoreList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(StoreFragment storeFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        long j;
        String str;
        String str2;
        String str3;
        String avatar;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        StoreBean storeBean = (StoreBean) storeFragment.getMAdapter().getItem(i);
        if (view.getId() == 2131364276) {
            User user = UserStore.INSTANCE.getShared().getUser();
            if (user == null || (avatar = user.getAvatar()) == null) {
                str = "";
            } else {
                str = avatar;
            }
            Context context = storeFragment.getContext();
            if (context != null) {
                String picUrl = storeBean.getPicUrl();
                if (picUrl == null) {
                    str2 = "";
                } else {
                    str2 = picUrl;
                }
                String effectUrl = storeBean.getEffectUrl();
                if (effectUrl == null) {
                    str3 = "";
                } else {
                    str3 = effectUrl;
                }
                new StorePreviewDialog(context, str2, str3, 1, str, null, 32, null).show();
                return;
            }
            return;
        }
        long mSelectId = storeFragment.getMAdapter().getMSelectId();
        Long id2 = storeBean.getId();
        if (id2 != null && mSelectId == id2.longValue()) {
            return;
        }
        StoreAdapter mAdapter = storeFragment.getMAdapter();
        Long id3 = storeBean.getId();
        if (id3 != null) {
            j = id3.longValue();
        } else {
            j = 0;
        }
        mAdapter.setMSelectId(j);
        storeFragment.mSelectBean = storeBean;
        storeFragment.getMAdapter().notifyDataSetChanged();
        storeFragment.refreshSelect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StoreAdapter mAdapter_delegate$lambda$1(StoreFragment storeFragment) {
        return new StoreAdapter(R.layout.item_store, storeFragment.getViewModel().getType());
    }

    private final void refreshSelect() {
        StoreListener storeListener;
        StoreListener storeListener2;
        StoreBean storeBean;
        StoreListener storeListener3;
        int i;
        Integer maxNum;
        Integer curNum;
        int type = getViewModel().getType();
        if (type != 0) {
            if (type != 1) {
                if (type == 3 && (storeBean = this.mSelectBean) != null && (storeListener3 = this.mListener) != null) {
                    RelationStoreData relationStoreData = getViewModel().getRelationStoreData();
                    int i2 = 0;
                    if (relationStoreData != null && (curNum = relationStoreData.getCurNum()) != null) {
                        i = curNum.intValue();
                    } else {
                        i = 0;
                    }
                    RelationStoreData relationStoreData2 = getViewModel().getRelationStoreData();
                    if (relationStoreData2 != null && (maxNum = relationStoreData2.getMaxNum()) != null) {
                        i2 = maxNum.intValue();
                    }
                    storeListener3.relationCardClick(storeBean, i, i2);
                    return;
                }
                return;
            }
            StoreBean storeBean2 = this.mSelectBean;
            if (storeBean2 != null && (storeListener2 = this.mListener) != null) {
                storeListener2.mountsItemClick(storeBean2);
                return;
            }
            return;
        }
        StoreBean storeBean3 = this.mSelectBean;
        if (storeBean3 != null && (storeListener = this.mListener) != null) {
            storeListener.headWearItemClick(storeBean3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StoreViewModel viewModel_delegate$lambda$0(StoreFragment storeFragment) {
        return new ViewModelProvider(storeFragment).get(StoreViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_store;
    }

    @NotNull
    public final StoreAdapter getMAdapter() {
        return (StoreAdapter) this.mAdapter.getValue();
    }

    @Nullable
    public final StoreListener getMListener() {
        return this.mListener;
    }

    @Nullable
    public final StoreBean getMSelectBean() {
        return this.mSelectBean;
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        this.mListener = null;
        getViewModel().getStoreListData().destroy();
    }

    public void onInitialize() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        initView();
        initData();
    }

    public void onResume() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onResume();
        refreshSelect();
    }

    public final void setMListener(@Nullable StoreListener storeListener) {
        this.mListener = storeListener;
    }

    public final void setMSelectBean(@Nullable StoreBean storeBean) {
        this.mSelectBean = storeBean;
    }
}
