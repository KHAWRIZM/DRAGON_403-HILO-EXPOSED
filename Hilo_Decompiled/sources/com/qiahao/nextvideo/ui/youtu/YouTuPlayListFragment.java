package com.qiahao.nextvideo.ui.youtu;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.Status;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingFragment;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.youtube.YouTuBeData;
import com.qiahao.nextvideo.databinding.FragmentYouTuPlayListBinding;
import com.qiahao.nextvideo.databinding.ViewYouTuMoreBinding;
import com.qiahao.nextvideo.room.adapter.YouTuAdapter;
import com.qiahao.nextvideo.room.dialog.YouTuLinkDialog;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.tencent.qcloud.tuicore.util.PopWindowUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010-\u001a\u00020.H\u0014J\b\u0010/\u001a\u00020\u000bH\u0016J\u0018\u00100\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00072\u0006\u00101\u001a\u000202H\u0002J\u0012\u00103\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u00104\u001a\u00020\u000bH\u0016R9\u0010\u0005\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010\"\u001a\u00020#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u001b\u0010(\u001a\u00020)8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b*\u0010+¨\u00065"}, d2 = {"Lcom/qiahao/nextvideo/ui/youtu/YouTuPlayListFragment;", "Lcom/qiahao/base_common/common/BaseBindingFragment;", "Lcom/qiahao/nextvideo/databinding/FragmentYouTuPlayListBinding;", "<init>", "()V", "mListener", "Lkotlin/Function1;", "Lcom/qiahao/nextvideo/data/model/youtube/YouTuBeData;", "Lkotlin/ParameterName;", "name", "data", "", "getMListener", "()Lkotlin/jvm/functions/Function1;", "setMListener", "(Lkotlin/jvm/functions/Function1;)V", "mDismiss", "Lkotlin/Function0;", "getMDismiss", "()Lkotlin/jvm/functions/Function0;", "setMDismiss", "(Lkotlin/jvm/functions/Function0;)V", "videoId", "", "getVideoId", "()Ljava/lang/String;", "setVideoId", "(Ljava/lang/String;)V", "popupWindow", "Landroid/widget/PopupWindow;", "getPopupWindow", "()Landroid/widget/PopupWindow;", "setPopupWindow", "(Landroid/widget/PopupWindow;)V", "mViewModel", "Lcom/qiahao/nextvideo/ui/youtu/YouTuViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/ui/youtu/YouTuViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mAdapter", "Lcom/qiahao/nextvideo/room/adapter/YouTuAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/room/adapter/YouTuAdapter;", "mAdapter$delegate", "getLayoutResId", "", "onInitialize", "showPopWindow", "view", "Landroid/view/View;", "getNextVideo", "onDestroy", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nYouTuPlayListFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 YouTuPlayListFragment.kt\ncom/qiahao/nextvideo/ui/youtu/YouTuPlayListFragment\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,173:1\n61#2,9:174\n61#2,9:183\n1878#3,3:192\n*S KotlinDebug\n*F\n+ 1 YouTuPlayListFragment.kt\ncom/qiahao/nextvideo/ui/youtu/YouTuPlayListFragment\n*L\n67#1:174,9\n141#1:183,9\n156#1:192,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class YouTuPlayListFragment extends BaseBindingFragment<FragmentYouTuPlayListBinding> {

    @Nullable
    private Function0<Unit> mDismiss;

    @Nullable
    private Function1<? super YouTuBeData, Unit> mListener;

    @Nullable
    private PopupWindow popupWindow;

    @Nullable
    private String videoId = "";

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.youtu.n
        public final Object invoke() {
            YouTuViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = YouTuPlayListFragment.mViewModel_delegate$lambda$0(YouTuPlayListFragment.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.youtu.o
        public final Object invoke() {
            YouTuAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = YouTuPlayListFragment.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    private final YouTuBeData getNextVideo(String videoId) {
        List data = getMAdapter().getData();
        if (data.size() != 0 && data.size() != 1) {
            int i = 0;
            int i2 = 0;
            for (Object obj : data) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                if (Intrinsics.areEqual(((YouTuBeData) obj).getVideoId(), videoId)) {
                    i = i2;
                }
                i2 = i3;
            }
            if (i == data.size() - 1) {
                return (YouTuBeData) data.get(0);
            }
            return (YouTuBeData) data.get(i + 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YouTuAdapter mAdapter_delegate$lambda$1() {
        return new YouTuAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YouTuViewModel mViewModel_delegate$lambda$0(YouTuPlayListFragment youTuPlayListFragment) {
        return new ViewModelProvider(youTuPlayListFragment).get(YouTuViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$10(YouTuPlayListFragment youTuPlayListFragment, Pair pair) {
        FragmentYouTuPlayListBinding fragmentYouTuPlayListBinding;
        SuperStatusView superStatusView;
        if (Intrinsics.areEqual((String) pair.getFirst(), YouTuViewModel.TYPE_DELETE) && (pair.getSecond() instanceof YouTuBeData)) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.youtube.YouTuBeData");
            youTuPlayListFragment.getMAdapter().remove((YouTuBeData) second);
            if (youTuPlayListFragment.getMAdapter().getData().isEmpty() && (fragmentYouTuPlayListBinding = (FragmentYouTuPlayListBinding) youTuPlayListFragment.getBinding()) != null && (superStatusView = fragmentYouTuPlayListBinding.statusView) != null) {
                superStatusView.showEmpty();
            }
            PopupWindow popupWindow = youTuPlayListFragment.popupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$11(YouTuPlayListFragment youTuPlayListFragment, Pair pair) {
        SuperStatusView superStatusView;
        String str = (String) pair.getFirst();
        if (Intrinsics.areEqual(str, YouTuViewModel.TYPE_ROOM_LIST)) {
            FragmentYouTuPlayListBinding fragmentYouTuPlayListBinding = (FragmentYouTuPlayListBinding) youTuPlayListFragment.getBinding();
            if (fragmentYouTuPlayListBinding != null && (superStatusView = fragmentYouTuPlayListBinding.statusView) != null) {
                superStatusView.showEmpty();
            }
        } else if (Intrinsics.areEqual(str, YouTuViewModel.TYPE_DELETE) && (pair.getSecond() instanceof HiloException)) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = youTuPlayListFragment.getContext();
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(youTuPlayListFragment, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
            PopupWindow popupWindow = youTuPlayListFragment.popupWindow;
            if (popupWindow != null) {
                popupWindow.dismiss();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$2(YouTuPlayListFragment youTuPlayListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        youTuPlayListFragment.showPopWindow((YouTuBeData) youTuPlayListFragment.getMAdapter().getData().get(i), view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$3(YouTuPlayListFragment youTuPlayListFragment, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        YouTuBeData youTuBeData = (YouTuBeData) youTuPlayListFragment.getMAdapter().getData().get(i);
        Function1<? super YouTuBeData, Unit> function1 = youTuPlayListFragment.mListener;
        if (function1 != null) {
            function1.invoke(youTuBeData);
        }
        Function0<Unit> function0 = youTuPlayListFragment.mDismiss;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$7(YouTuPlayListFragment youTuPlayListFragment, List list) {
        if (youTuPlayListFragment.getMViewModel().getRoomListBaseData().isOnePage()) {
            youTuPlayListFragment.getMAdapter().setList(list);
        } else {
            YouTuAdapter mAdapter = youTuPlayListFragment.getMAdapter();
            Intrinsics.checkNotNull(list);
            mAdapter.addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$8(YouTuPlayListFragment youTuPlayListFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        youTuPlayListFragment.getMViewModel().getRoomListBaseData().resetPage();
        youTuPlayListFragment.getMViewModel().roomYouTuList(MeetingRoomManager.INSTANCE.getMGroupId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$9(YouTuPlayListFragment youTuPlayListFragment, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        youTuPlayListFragment.getMViewModel().roomYouTuList(MeetingRoomManager.INSTANCE.getMGroupId());
    }

    private final void showPopWindow(final YouTuBeData data, View view) {
        ViewYouTuMoreBinding viewYouTuMoreBinding = (ViewYouTuMoreBinding) androidx.databinding.g.h(LayoutInflater.from(getContext()), R.layout.view_you_tu_more, (ViewGroup) null, false);
        viewYouTuMoreBinding.constraint.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 10, (GradientDrawable.Orientation) null, 8, (Object) null));
        this.popupWindow = PopWindowUtil.popupWindowAndShow(viewYouTuMoreBinding.getRoot(), view, UiKtxKt.getDp(120), UiKtxKt.getDp(45));
        final ConstraintLayout constraintLayout = viewYouTuMoreBinding.constraint;
        final long j = 800;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.youtu.YouTuPlayListFragment$showPopWindow$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    this.getMViewModel().deleteYouTuBeVideo(MeetingRoomManager.INSTANCE.getMGroupId(), data);
                }
            }
        });
    }

    protected int getLayoutResId() {
        return R.layout.fragment_you_tu_play_list;
    }

    @NotNull
    public final YouTuAdapter getMAdapter() {
        return (YouTuAdapter) this.mAdapter.getValue();
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

    @Nullable
    public final PopupWindow getPopupWindow() {
        return this.popupWindow;
    }

    @Nullable
    public final String getVideoId() {
        return this.videoId;
    }

    public void onDestroy() {
        super/*com.qiahao.base_common.common.BaseFragment*/.onDestroy();
        getMViewModel().getRoomListBaseData().destroy();
    }

    public void onInitialize() {
        SmartRefreshLayout smartRefreshLayout;
        SmartRefreshLayout smartRefreshLayout2;
        SmartRefreshLayout smartRefreshLayout3;
        final TextView textView;
        RecyclerView recyclerView;
        SuperStatusView superStatusView;
        SuperStatusView superStatusView2;
        SuperStatusView superStatusView3;
        SuperStatusView superStatusView4;
        TextView textView2;
        super/*com.qiahao.base_common.common.BaseFragment*/.onInitialize();
        FragmentYouTuPlayListBinding fragmentYouTuPlayListBinding = (FragmentYouTuPlayListBinding) getBinding();
        if (fragmentYouTuPlayListBinding != null && (textView2 = fragmentYouTuPlayListBinding.addVideo) != null) {
            textView2.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#7B10FF", "#A359FF", 16, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        FragmentYouTuPlayListBinding fragmentYouTuPlayListBinding2 = (FragmentYouTuPlayListBinding) getBinding();
        if (fragmentYouTuPlayListBinding2 != null && (superStatusView4 = fragmentYouTuPlayListBinding2.statusView) != null) {
            superStatusView4.addStatus(Status.Empty.INSTANCE, R.layout.room_list_empty);
        }
        FragmentYouTuPlayListBinding fragmentYouTuPlayListBinding3 = (FragmentYouTuPlayListBinding) getBinding();
        if (fragmentYouTuPlayListBinding3 != null && (superStatusView3 = fragmentYouTuPlayListBinding3.statusView) != null) {
            superStatusView3.addStatus(Status.Error.INSTANCE, R.layout.room_list_empty);
        }
        FragmentYouTuPlayListBinding fragmentYouTuPlayListBinding4 = (FragmentYouTuPlayListBinding) getBinding();
        if (fragmentYouTuPlayListBinding4 != null && (superStatusView2 = fragmentYouTuPlayListBinding4.statusView) != null) {
            superStatusView2.addStatus(Status.Loading.INSTANCE, 2131558549);
        }
        FragmentYouTuPlayListBinding fragmentYouTuPlayListBinding5 = (FragmentYouTuPlayListBinding) getBinding();
        if (fragmentYouTuPlayListBinding5 != null && (superStatusView = fragmentYouTuPlayListBinding5.statusView) != null) {
            superStatusView.addStatus(Status.NoNetwork.INSTANCE, R.layout.gift_status_empty);
        }
        getMAdapter().addChildClickViewIds(new int[]{R.id.more});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.youtu.g
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YouTuPlayListFragment.onInitialize$lambda$2(YouTuPlayListFragment.this, baseQuickAdapter, view, i);
            }
        });
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.youtu.h
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                YouTuPlayListFragment.onInitialize$lambda$3(YouTuPlayListFragment.this, baseQuickAdapter, view, i);
            }
        });
        FragmentYouTuPlayListBinding fragmentYouTuPlayListBinding6 = (FragmentYouTuPlayListBinding) getBinding();
        if (fragmentYouTuPlayListBinding6 != null && (recyclerView = fragmentYouTuPlayListBinding6.recyclerView) != null) {
            recyclerView.setAdapter(getMAdapter());
        }
        FragmentYouTuPlayListBinding fragmentYouTuPlayListBinding7 = (FragmentYouTuPlayListBinding) getBinding();
        if (fragmentYouTuPlayListBinding7 != null && (textView = fragmentYouTuPlayListBinding7.addVideo) != null) {
            final long j = 800;
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.youtu.YouTuPlayListFragment$onInitialize$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                        Context context = this.getContext();
                        if (context != null) {
                            YouTuLinkDialog youTuLinkDialog = new YouTuLinkDialog(context);
                            final YouTuPlayListFragment youTuPlayListFragment = this;
                            youTuLinkDialog.setListener(new Function1<YouTuBeData, Unit>() { // from class: com.qiahao.nextvideo.ui.youtu.YouTuPlayListFragment$onInitialize$3$1$1$1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((YouTuBeData) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(YouTuBeData youTuBeData) {
                                    SuperStatusView superStatusView5;
                                    Intrinsics.checkNotNullParameter(youTuBeData, "it");
                                    YouTuPlayListFragment.this.getMAdapter().addData(0, youTuBeData);
                                    FragmentYouTuPlayListBinding fragmentYouTuPlayListBinding8 = (FragmentYouTuPlayListBinding) YouTuPlayListFragment.this.getBinding();
                                    if (fragmentYouTuPlayListBinding8 == null || (superStatusView5 = fragmentYouTuPlayListBinding8.statusView) == null) {
                                        return;
                                    }
                                    superStatusView5.showContent();
                                }
                            });
                            youTuLinkDialog.show();
                        }
                    }
                }
            });
        }
        BaseListData roomListBaseData = getMViewModel().getRoomListBaseData();
        FragmentYouTuPlayListBinding fragmentYouTuPlayListBinding8 = (FragmentYouTuPlayListBinding) getBinding();
        SuperStatusView superStatusView5 = null;
        if (fragmentYouTuPlayListBinding8 != null) {
            smartRefreshLayout = fragmentYouTuPlayListBinding8.refreshLayout;
        } else {
            smartRefreshLayout = null;
        }
        FragmentYouTuPlayListBinding fragmentYouTuPlayListBinding9 = (FragmentYouTuPlayListBinding) getBinding();
        if (fragmentYouTuPlayListBinding9 != null) {
            superStatusView5 = fragmentYouTuPlayListBinding9.statusView;
        }
        roomListBaseData.registerStatusLayoutAndRefreshLayout(smartRefreshLayout, superStatusView5);
        getMViewModel().getRoomList().observe(this, new YouTuPlayListFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.i
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$7;
                onInitialize$lambda$7 = YouTuPlayListFragment.onInitialize$lambda$7(YouTuPlayListFragment.this, (List) obj);
                return onInitialize$lambda$7;
            }
        }));
        FragmentYouTuPlayListBinding fragmentYouTuPlayListBinding10 = (FragmentYouTuPlayListBinding) getBinding();
        if (fragmentYouTuPlayListBinding10 != null && (smartRefreshLayout3 = fragmentYouTuPlayListBinding10.refreshLayout) != null) {
            smartRefreshLayout3.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.youtu.j
                @Override // vc.g
                public final void onRefresh(tc.f fVar) {
                    YouTuPlayListFragment.onInitialize$lambda$8(YouTuPlayListFragment.this, fVar);
                }
            });
        }
        FragmentYouTuPlayListBinding fragmentYouTuPlayListBinding11 = (FragmentYouTuPlayListBinding) getBinding();
        if (fragmentYouTuPlayListBinding11 != null && (smartRefreshLayout2 = fragmentYouTuPlayListBinding11.refreshLayout) != null) {
            smartRefreshLayout2.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.youtu.k
                @Override // vc.e
                public final void onLoadMore(tc.f fVar) {
                    YouTuPlayListFragment.onInitialize$lambda$9(YouTuPlayListFragment.this, fVar);
                }
            });
        }
        getMViewModel().getMSuccess().observe(this, new YouTuPlayListFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.l
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$10;
                onInitialize$lambda$10 = YouTuPlayListFragment.onInitialize$lambda$10(YouTuPlayListFragment.this, (Pair) obj);
                return onInitialize$lambda$10;
            }
        }));
        getMViewModel().getMException().observe(this, new YouTuPlayListFragment$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.m
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$11;
                onInitialize$lambda$11 = YouTuPlayListFragment.onInitialize$lambda$11(YouTuPlayListFragment.this, (Pair) obj);
                return onInitialize$lambda$11;
            }
        }));
        getMViewModel().roomYouTuList(MeetingRoomManager.INSTANCE.getMGroupId());
    }

    public final void setMDismiss(@Nullable Function0<Unit> function0) {
        this.mDismiss = function0;
    }

    public final void setMListener(@Nullable Function1<? super YouTuBeData, Unit> function1) {
        this.mListener = function1;
    }

    public final void setPopupWindow(@Nullable PopupWindow popupWindow) {
        this.popupWindow = popupWindow;
    }

    public final void setVideoId(@Nullable String str) {
        this.videoId = str;
    }
}
