package com.qiahao.nextvideo.ui.home.onlinefeed;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.StatusKtxKtKt;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.oudi.utils.store.IStore;
import com.oudi.utils.store.MMKVStore;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.VideoBaseData;
import com.qiahao.nextvideo.databinding.ActivityGoddessBinding;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.videocall.VideoCallMessage;
import com.qiahao.nextvideo.ui.videocall.VideoRecordingActivity;
import com.qiahao.nextvideo.utilities.AppRequestUtils;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0002J\b\u0010\u0015\u001a\u00020\u000eH\u0014J\b\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/onlinefeed/GoddessActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityGoddessBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/home/onlinefeed/GoddessViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/home/onlinefeed/GoddessViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "getLayoutResId", "", "onInitialize", "", "mAdapter", "Lcom/qiahao/nextvideo/ui/home/onlinefeed/GoddessAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/home/onlinefeed/GoddessAdapter;", "mAdapter$delegate", "initView", "onResume", "initData", "getStatusView", "Lcom/oudi/core/status/IStatusView;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGoddessActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GoddessActivity.kt\ncom/qiahao/nextvideo/ui/home/onlinefeed/GoddessActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,171:1\n61#2,9:172\n61#2,9:181\n1878#3,3:190\n*S KotlinDebug\n*F\n+ 1 GoddessActivity.kt\ncom/qiahao/nextvideo/ui/home/onlinefeed/GoddessActivity\n*L\n53#1:172,9\n66#1:181,9\n155#1:190,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GoddessActivity extends HiloBaseBindingActivity<ActivityGoddessBinding> {

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.a
        public final Object invoke() {
            GoddessViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = GoddessActivity.viewModel_delegate$lambda$0(GoddessActivity.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.c
        public final Object invoke() {
            GoddessAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = GoddessActivity.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    private final GoddessAdapter getMAdapter() {
        return (GoddessAdapter) this.mAdapter.getValue();
    }

    private final IStatusView getStatusView() {
        SuperStatusView superStatusView = getBinding().statusView;
        Intrinsics.checkNotNullExpressionValue(superStatusView, "statusView");
        return superStatusView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GoddessViewModel getViewModel() {
        return (GoddessViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getGoddessList().observe(this, new GoddessActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.e
            public final Object invoke(Object obj) {
                Unit initData$lambda$12;
                initData$lambda$12 = GoddessActivity.initData$lambda$12(GoddessActivity.this, (List) obj);
                return initData$lambda$12;
            }
        }));
        getViewModel().getExternalId().observe(this, new GoddessActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.f
            public final Object invoke(Object obj) {
                Unit initData$lambda$14;
                initData$lambda$14 = GoddessActivity.initData$lambda$14(GoddessActivity.this, (String) obj);
                return initData$lambda$14;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$12(GoddessActivity goddessActivity, List list) {
        if (list != null) {
            if (goddessActivity.getViewModel().getGoddessBaseListData().isOnePage()) {
                goddessActivity.getMAdapter().setList(list);
            } else {
                goddessActivity.getMAdapter().addData(list);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$14(GoddessActivity goddessActivity, String str) {
        int i = 0;
        for (Object obj : goddessActivity.getMAdapter().getData()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            VideoBaseData videoBaseData = (VideoBaseData) obj;
            if (Intrinsics.areEqual(videoBaseData.getExternalId(), str)) {
                VideoBaseData videoBaseData2 = (VideoBaseData) goddessActivity.getMAdapter().getData().get(i);
                Boolean isLike = videoBaseData.isLike();
                Boolean bool = Boolean.FALSE;
                videoBaseData2.setLike(Boolean.valueOf(Intrinsics.areEqual(isLike, bool)));
                goddessActivity.getMAdapter().notifyItemChanged(i, Boolean.valueOf(Intrinsics.areEqual(videoBaseData.isLike(), bool)));
            }
            i = i2;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        final AppCompatImageView appCompatImageView = ((ActivityGoddessBinding) getBinding()).endImage;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.GoddessActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    NavigationHelper.jump$default(NavigationHelper.INSTANCE, (String) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "rankingPinkDiamondUrl", "", (String) null, 4, (Object) null), (SuperCallBack) null, 2, (Object) null);
                }
            }
        });
        View view = ((ActivityGoddessBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.g
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$3;
                initView$lambda$3 = GoddessActivity.initView$lambda$3(GoddessActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$3;
            }
        });
        ((ActivityGoddessBinding) getBinding()).backImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GoddessActivity.this.onBackPressed();
            }
        });
        final FrameLayout frameLayout = ((ActivityGoddessBinding) getBinding()).historyLayout;
        frameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.GoddessActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(frameLayout) > j || (frameLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(frameLayout, currentTimeMillis);
                    this.startActivity(new Intent((Context) this, (Class<?>) VideoRecordingActivity.class));
                }
            }
        });
        if (((Number) IStore.DefaultImpls.getValue$default(MMKVStore.INSTANCE, "video_miss_number", 0, (String) null, 4, (Object) null)).intValue() > 0) {
            ((ActivityGoddessBinding) getBinding()).redPoint.setVisibility(0);
        } else {
            ((ActivityGoddessBinding) getBinding()).redPoint.setVisibility(8);
        }
        ((ActivityGoddessBinding) getBinding()).title.setText(ResourcesKtxKt.toStringRes(2131953697));
        SmartRefreshLayout smartRefreshLayout = ((ActivityGoddessBinding) getBinding()).refreshLayout;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout, "refreshLayout");
        TextView textView = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout, Status.Empty.INSTANCE, 2131362075);
        if (textView != null) {
            textView.setText(2131954441);
        }
        SmartRefreshLayout smartRefreshLayout2 = ((ActivityGoddessBinding) getBinding()).refreshLayout;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout2, "refreshLayout");
        TextView textView2 = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout2, Status.Error.INSTANCE, 2131362075);
        if (textView2 != null) {
            textView2.setText(2131954441);
        }
        ((ActivityGoddessBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        ((ActivityGoddessBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        getViewModel().getGoddessBaseListData().registerStatusLayoutAndRefreshLayout(((ActivityGoddessBinding) getBinding()).refreshLayout, ((ActivityGoddessBinding) getBinding()).statusView);
        ((ActivityGoddessBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.i
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                GoddessActivity.initView$lambda$6(GoddessActivity.this, fVar);
            }
        });
        ((ActivityGoddessBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.j
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                GoddessActivity.initView$lambda$7(GoddessActivity.this, fVar);
            }
        });
        ((ActivityGoddessBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.GoddessActivity$initView$7
            public void onRetry(IStatusView statusView, Status status) {
                GoddessViewModel viewModel;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                viewModel = GoddessActivity.this.getViewModel();
                viewModel.requestGoddessHistory();
            }
        });
        getMAdapter().addChildClickViewIds(new int[]{R.id.videoImageView, R.id.likeImageView});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.k
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                GoddessActivity.initView$lambda$9(GoddessActivity.this, baseQuickAdapter, view2, i);
            }
        });
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.b
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                GoddessActivity.initView$lambda$10(GoddessActivity.this, baseQuickAdapter, view2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$10(GoddessActivity goddessActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (HiloUtils.INSTANCE.notFastClick()) {
            AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, ((VideoBaseData) goddessActivity.getMAdapter().getData().get(i)).getExternalId(), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$3(GoddessActivity goddessActivity, int i, int i2) {
        goddessActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(GoddessActivity goddessActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        goddessActivity.getViewModel().getGoddessBaseListData().resetPage();
        goddessActivity.getViewModel().requestGoddessHistory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$7(GoddessActivity goddessActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        goddessActivity.getViewModel().requestGoddessHistory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$9(final GoddessActivity goddessActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        VideoBaseData videoBaseData = (VideoBaseData) goddessActivity.getMAdapter().getData().get(i);
        int id2 = view.getId();
        String str2 = "";
        if (id2 != 2131363487) {
            if (id2 == 2131365590 && HiloUtils.INSTANCE.notFastClick()) {
                VideoCallMessage videoCallMessage = VideoCallMessage.INSTANCE;
                String externalId = videoBaseData.getExternalId();
                if (externalId == null) {
                    str = "";
                } else {
                    str = externalId;
                }
                VideoCallMessage.newStartVideo$default(videoCallMessage, goddessActivity, str, new Function2() { // from class: com.qiahao.nextvideo.ui.home.onlinefeed.d
                    public final Object invoke(Object obj, Object obj2) {
                        Unit initView$lambda$9$lambda$8;
                        initView$lambda$9$lambda$8 = GoddessActivity.initView$lambda$9$lambda$8(GoddessActivity.this, (String) obj, ((Boolean) obj2).booleanValue());
                        return initView$lambda$9$lambda$8;
                    }
                }, null, 8, null);
                return;
            }
            return;
        }
        GoddessViewModel viewModel = goddessActivity.getViewModel();
        String externalId2 = videoBaseData.getExternalId();
        if (externalId2 != null) {
            str2 = externalId2;
        }
        viewModel.like(str2, Intrinsics.areEqual(videoBaseData.isLike(), Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$9$lambda$8(GoddessActivity goddessActivity, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, SupportGiftRankActivity.EXTERNAL_ID);
        goddessActivity.getViewModel().like(str, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GoddessAdapter mAdapter_delegate$lambda$1() {
        return new GoddessAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GoddessViewModel viewModel_delegate$lambda$0(GoddessActivity goddessActivity) {
        return new ViewModelProvider(goddessActivity).get(GoddessViewModel.class);
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    protected int getLayoutResId() {
        return R.layout.activity_goddess;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    protected void onResume() {
        super.onResume();
        getViewModel().getGoddessBaseListData().resetPage();
        getBinding().refreshLayout.autoRefresh();
    }
}
