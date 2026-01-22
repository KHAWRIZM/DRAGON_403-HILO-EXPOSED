package com.qiahao.nextvideo.ui.videocall;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.StatusKtxKtKt;
import com.oudi.core.status.SuperStatusView;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.model.VideoBaseData;
import com.qiahao.nextvideo.databinding.FragmentVideoRecordingBinding;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
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

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0013H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/ui/videocall/VideoRecordingFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentVideoRecordingBinding;", "<init>", "()V", "viewModel", "Lcom/qiahao/nextvideo/ui/videocall/VideoRecordingViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/videocall/VideoRecordingViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "adapter", "Lcom/qiahao/nextvideo/ui/videocall/VideoRecordingAdapter;", "getAdapter", "()Lcom/qiahao/nextvideo/ui/videocall/VideoRecordingAdapter;", "adapter$delegate", "getLayoutResId", "", "onInitialize", "", "getStatusView", "Lcom/oudi/core/status/IStatusView;", "initView", "initData", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVideoRecordingFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VideoRecordingFragment.kt\ncom/qiahao/nextvideo/ui/videocall/VideoRecordingFragment\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,153:1\n1#2:154\n1878#3,3:155\n*S KotlinDebug\n*F\n+ 1 VideoRecordingFragment.kt\ncom/qiahao/nextvideo/ui/videocall/VideoRecordingFragment\n*L\n142#1:155,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoRecordingFragment extends BaseBindingFragment<FragmentVideoRecordingBinding> {

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.k
        public final Object invoke() {
            VideoRecordingViewModel viewModel_delegate$lambda$0;
            viewModel_delegate$lambda$0 = VideoRecordingFragment.viewModel_delegate$lambda$0(VideoRecordingFragment.this);
            return viewModel_delegate$lambda$0;
        }
    });

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.videocall.l
        public final Object invoke() {
            VideoRecordingAdapter adapter_delegate$lambda$1;
            adapter_delegate$lambda$1 = VideoRecordingFragment.adapter_delegate$lambda$1();
            return adapter_delegate$lambda$1;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoRecordingAdapter adapter_delegate$lambda$1() {
        return new VideoRecordingAdapter();
    }

    private final VideoRecordingAdapter getAdapter() {
        return (VideoRecordingAdapter) this.adapter.getValue();
    }

    private final IStatusView getStatusView() {
        FragmentVideoRecordingBinding fragmentVideoRecordingBinding = (FragmentVideoRecordingBinding) getBinding();
        if (fragmentVideoRecordingBinding != null) {
            return fragmentVideoRecordingBinding.statusView;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoRecordingViewModel getViewModel() {
        return (VideoRecordingViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        SmartRefreshLayout smartRefreshLayout;
        getViewModel().getMatchList().observe(this, new VideoRecordingFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.q
            public final Object invoke(Object obj) {
                Unit initData$lambda$11;
                initData$lambda$11 = VideoRecordingFragment.initData$lambda$11(VideoRecordingFragment.this, (List) obj);
                return initData$lambda$11;
            }
        }));
        getViewModel().getMissList().observe(this, new VideoRecordingFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.r
            public final Object invoke(Object obj) {
                Unit initData$lambda$13;
                initData$lambda$13 = VideoRecordingFragment.initData$lambda$13(VideoRecordingFragment.this, (List) obj);
                return initData$lambda$13;
            }
        }));
        getViewModel().getExternalId().observe(this, new VideoRecordingFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.videocall.s
            public final Object invoke(Object obj) {
                Unit initData$lambda$15;
                initData$lambda$15 = VideoRecordingFragment.initData$lambda$15(VideoRecordingFragment.this, (String) obj);
                return initData$lambda$15;
            }
        }));
        FragmentVideoRecordingBinding fragmentVideoRecordingBinding = (FragmentVideoRecordingBinding) getBinding();
        if (fragmentVideoRecordingBinding != null && (smartRefreshLayout = fragmentVideoRecordingBinding.refreshLayout) != null) {
            smartRefreshLayout.autoRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$11(VideoRecordingFragment videoRecordingFragment, List list) {
        if (list != null) {
            if (videoRecordingFragment.getViewModel().getMatchBaseListData().isOnePage()) {
                videoRecordingFragment.getAdapter().setList(list);
            } else {
                videoRecordingFragment.getAdapter().addData(list);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$13(VideoRecordingFragment videoRecordingFragment, List list) {
        if (list != null) {
            if (videoRecordingFragment.getViewModel().getMissBaseListData().isOnePage()) {
                videoRecordingFragment.getAdapter().setList(list);
            } else {
                videoRecordingFragment.getAdapter().addData(list);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$15(VideoRecordingFragment videoRecordingFragment, String str) {
        int i = 0;
        for (Object obj : videoRecordingFragment.getAdapter().getData()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            VideoBaseData videoBaseData = (VideoBaseData) obj;
            if (Intrinsics.areEqual(videoBaseData.getExternalId(), str)) {
                VideoBaseData videoBaseData2 = (VideoBaseData) videoRecordingFragment.getAdapter().getData().get(i);
                Boolean isLike = videoBaseData.isLike();
                Boolean bool = Boolean.FALSE;
                videoBaseData2.setLike(Boolean.valueOf(Intrinsics.areEqual(isLike, bool)));
                videoRecordingFragment.getAdapter().notifyItemChanged(i, Boolean.valueOf(Intrinsics.areEqual(videoBaseData.isLike(), bool)));
            }
            i = i2;
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        TextView textView;
        TextView textView2;
        SmartRefreshLayout smartRefreshLayout;
        SuperStatusView superStatusView;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        SmartRefreshLayout smartRefreshLayout4;
        SmartRefreshLayout smartRefreshLayout5;
        RecyclerView recyclerView;
        SmartRefreshLayout smartRefreshLayout6;
        SmartRefreshLayout smartRefreshLayout7;
        FragmentVideoRecordingBinding fragmentVideoRecordingBinding = (FragmentVideoRecordingBinding) getBinding();
        SuperStatusView superStatusView2 = null;
        if (fragmentVideoRecordingBinding != null && (smartRefreshLayout7 = fragmentVideoRecordingBinding.refreshLayout) != null) {
            textView = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout7, Status.Empty.INSTANCE, 2131362075);
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setText(2131954441);
        }
        FragmentVideoRecordingBinding fragmentVideoRecordingBinding2 = (FragmentVideoRecordingBinding) getBinding();
        if (fragmentVideoRecordingBinding2 != null && (smartRefreshLayout6 = fragmentVideoRecordingBinding2.refreshLayout) != null) {
            textView2 = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout6, Status.Error.INSTANCE, 2131362075);
        } else {
            textView2 = null;
        }
        if (textView2 != null) {
            textView2.setText(2131954441);
        }
        FragmentVideoRecordingBinding fragmentVideoRecordingBinding3 = (FragmentVideoRecordingBinding) getBinding();
        if (fragmentVideoRecordingBinding3 != null && (recyclerView = fragmentVideoRecordingBinding3.recyclerView) != null) {
            recyclerView.setAdapter(getAdapter());
        }
        if (Intrinsics.areEqual(getViewModel().getFragmentType(), VideoRecordingActivity.TYPE_PAIR)) {
            BaseListData matchBaseListData = getViewModel().getMatchBaseListData();
            FragmentVideoRecordingBinding fragmentVideoRecordingBinding4 = (FragmentVideoRecordingBinding) getBinding();
            if (fragmentVideoRecordingBinding4 != null) {
                smartRefreshLayout5 = fragmentVideoRecordingBinding4.refreshLayout;
            } else {
                smartRefreshLayout5 = null;
            }
            FragmentVideoRecordingBinding fragmentVideoRecordingBinding5 = (FragmentVideoRecordingBinding) getBinding();
            if (fragmentVideoRecordingBinding5 != null) {
                superStatusView2 = fragmentVideoRecordingBinding5.statusView;
            }
            matchBaseListData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout5, superStatusView2);
        } else {
            BaseListData missBaseListData = getViewModel().getMissBaseListData();
            FragmentVideoRecordingBinding fragmentVideoRecordingBinding6 = (FragmentVideoRecordingBinding) getBinding();
            if (fragmentVideoRecordingBinding6 != null) {
                smartRefreshLayout = fragmentVideoRecordingBinding6.refreshLayout;
            } else {
                smartRefreshLayout = null;
            }
            FragmentVideoRecordingBinding fragmentVideoRecordingBinding7 = (FragmentVideoRecordingBinding) getBinding();
            if (fragmentVideoRecordingBinding7 != null) {
                superStatusView2 = fragmentVideoRecordingBinding7.statusView;
            }
            missBaseListData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView2);
        }
        Context context = getContext();
        if (context != null) {
            FootLoading footLoading = new FootLoading(context);
            FragmentVideoRecordingBinding fragmentVideoRecordingBinding8 = (FragmentVideoRecordingBinding) getBinding();
            if (fragmentVideoRecordingBinding8 != null && (smartRefreshLayout4 = fragmentVideoRecordingBinding8.refreshLayout) != null) {
                smartRefreshLayout4.setRefreshFooter(footLoading);
            }
        }
        FragmentVideoRecordingBinding fragmentVideoRecordingBinding9 = (FragmentVideoRecordingBinding) getBinding();
        if (fragmentVideoRecordingBinding9 != null && (smartRefreshLayout3 = fragmentVideoRecordingBinding9.refreshLayout) != null) {
            smartRefreshLayout3.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.videocall.m
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    VideoRecordingFragment.initView$lambda$4(VideoRecordingFragment.this, fVar);
                }
            });
        }
        FragmentVideoRecordingBinding fragmentVideoRecordingBinding10 = (FragmentVideoRecordingBinding) getBinding();
        if (fragmentVideoRecordingBinding10 != null && (smartRefreshLayout2 = fragmentVideoRecordingBinding10.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.videocall.n
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    VideoRecordingFragment.initView$lambda$5(VideoRecordingFragment.this, fVar);
                }
            });
        }
        FragmentVideoRecordingBinding fragmentVideoRecordingBinding11 = (FragmentVideoRecordingBinding) getBinding();
        if (fragmentVideoRecordingBinding11 != null && (superStatusView = fragmentVideoRecordingBinding11.statusView) != null) {
            superStatusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.VideoRecordingFragment$initView$5
                public void onRetry(IStatusView statusView, Status status) {
                    VideoRecordingViewModel viewModel;
                    Intrinsics.checkNotNullParameter(statusView, "statusView");
                    Intrinsics.checkNotNullParameter(status, "status");
                    viewModel = VideoRecordingFragment.this.getViewModel();
                    viewModel.requestHistory();
                }
            });
        }
        getAdapter().addChildClickViewIds(new int[]{R.id.likeImageView, R.id.videoImageView});
        getAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.o
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                VideoRecordingFragment.initView$lambda$8(VideoRecordingFragment.this, baseQuickAdapter, view, i);
            }
        });
        getAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.videocall.p
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                VideoRecordingFragment.initView$lambda$9(VideoRecordingFragment.this, baseQuickAdapter, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(VideoRecordingFragment videoRecordingFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        if (Intrinsics.areEqual(videoRecordingFragment.getViewModel().getFragmentType(), VideoRecordingActivity.TYPE_PAIR)) {
            videoRecordingFragment.getViewModel().getMatchBaseListData().resetPage();
        } else {
            videoRecordingFragment.getViewModel().getMissBaseListData().resetPage();
        }
        videoRecordingFragment.getViewModel().requestHistory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(VideoRecordingFragment videoRecordingFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        videoRecordingFragment.getViewModel().requestHistory();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(final VideoRecordingFragment videoRecordingFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Context context;
        String str;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        VideoBaseData videoBaseData = (VideoBaseData) videoRecordingFragment.getAdapter().getData().get(i);
        int id2 = view.getId();
        String str2 = "";
        if (id2 != 2131363487) {
            if (id2 == 2131365590 && HiloUtils.INSTANCE.notFastClick() && (context = videoRecordingFragment.getContext()) != null) {
                VideoCallMessage videoCallMessage = VideoCallMessage.INSTANCE;
                String externalId = videoBaseData.getExternalId();
                if (externalId == null) {
                    str = "";
                } else {
                    str = externalId;
                }
                VideoCallMessage.newStartVideo$default(videoCallMessage, context, str, new Function2() { // from class: com.qiahao.nextvideo.ui.videocall.j
                    public final Object invoke(Object obj, Object obj2) {
                        Unit initView$lambda$8$lambda$7$lambda$6;
                        initView$lambda$8$lambda$7$lambda$6 = VideoRecordingFragment.initView$lambda$8$lambda$7$lambda$6(VideoRecordingFragment.this, (String) obj, ((Boolean) obj2).booleanValue());
                        return initView$lambda$8$lambda$7$lambda$6;
                    }
                }, null, 8, null);
                return;
            }
            return;
        }
        VideoRecordingViewModel viewModel = videoRecordingFragment.getViewModel();
        String externalId2 = videoBaseData.getExternalId();
        if (externalId2 != null) {
            str2 = externalId2;
        }
        viewModel.like(str2, Intrinsics.areEqual(videoBaseData.isLike(), Boolean.TRUE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$8$lambda$7$lambda$6(VideoRecordingFragment videoRecordingFragment, String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, SupportGiftRankActivity.EXTERNAL_ID);
        videoRecordingFragment.getViewModel().like(str, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(VideoRecordingFragment videoRecordingFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        if (HiloUtils.INSTANCE.notFastClick()) {
            AppRequestUtils.openPersonPage$default(AppRequestUtils.INSTANCE, ((VideoBaseData) videoRecordingFragment.getAdapter().getData().get(i)).getExternalId(), false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VideoRecordingViewModel viewModel_delegate$lambda$0(VideoRecordingFragment videoRecordingFragment) {
        return new ViewModelProvider(videoRecordingFragment).get(VideoRecordingViewModel.class);
    }

    protected int getLayoutResId() {
        return R.layout.fragment_video_recording;
    }

    public void onInitialize() {
        String str;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        VideoRecordingViewModel viewModel = getViewModel();
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("fragment_type")) == null) {
            str = VideoRecordingActivity.TYPE_PAIR;
        }
        viewModel.setFragmentType(str);
        initView();
        initData();
    }
}
