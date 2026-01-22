package com.qiahao.nextvideo.ui.youtu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.oudi.core.status.Status;
import com.oudi.core.status.StatusKtxKtKt;
import com.oudi.core.status.SuperStatusView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.interfaceing.OnCommonDialogListener;
import com.qiahao.base_common.interfaceing.SelectInterface;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.ui.dialog.TipBlackDialog;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.DialogItemData;
import com.qiahao.nextvideo.data.model.youtube.WatchYouTuListData;
import com.qiahao.nextvideo.databinding.ActivityYouTuWatchBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.ui.base.BlockOrReportDialog;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/ui/youtu/YouTuWatchActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityYouTuWatchBinding;", "<init>", "()V", "mViewModel", "Lcom/qiahao/nextvideo/ui/youtu/YouTuViewModel;", "getMViewModel", "()Lcom/qiahao/nextvideo/ui/youtu/YouTuViewModel;", "mViewModel$delegate", "Lkotlin/Lazy;", "mAdapter", "Lcom/qiahao/nextvideo/ui/youtu/YouTuWatchAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/youtu/YouTuWatchAdapter;", "mAdapter$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "onDestroy", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nYouTuWatchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 YouTuWatchActivity.kt\ncom/qiahao/nextvideo/ui/youtu/YouTuWatchActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,191:1\n61#2,9:192\n61#2,9:201\n61#2,9:212\n61#2,9:221\n176#3,2:210\n*S KotlinDebug\n*F\n+ 1 YouTuWatchActivity.kt\ncom/qiahao/nextvideo/ui/youtu/YouTuWatchActivity\n*L\n104#1:192,9\n107#1:201,9\n120#1:212,9\n181#1:221,9\n113#1:210,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class YouTuWatchActivity extends HiloBaseBindingActivity<ActivityYouTuWatchBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: mViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mViewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.youtu.c0
        public final Object invoke() {
            YouTuViewModel mViewModel_delegate$lambda$0;
            mViewModel_delegate$lambda$0 = YouTuWatchActivity.mViewModel_delegate$lambda$0(YouTuWatchActivity.this);
            return mViewModel_delegate$lambda$0;
        }
    });

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.youtu.d0
        public final Object invoke() {
            YouTuWatchAdapter mAdapter_delegate$lambda$1;
            mAdapter_delegate$lambda$1 = YouTuWatchActivity.mAdapter_delegate$lambda$1();
            return mAdapter_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/youtu/YouTuWatchActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) YouTuWatchActivity.class));
        }

        private Companion() {
        }
    }

    private final YouTuWatchAdapter getMAdapter() {
        return (YouTuWatchAdapter) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final YouTuViewModel getMViewModel() {
        return (YouTuViewModel) this.mViewModel.getValue();
    }

    private final void initData() {
        getMViewModel().getWatchListBaseData().setPageSize(20);
        getMViewModel().getWatchListBaseData().registerStatusLayoutAndRefreshLayout(getBinding().refreshLayout, getBinding().statusView);
        getMViewModel().getWatchList().observe(this, new YouTuWatchActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.j0
            public final Object invoke(Object obj) {
                Unit initData$lambda$2;
                initData$lambda$2 = YouTuWatchActivity.initData$lambda$2(YouTuWatchActivity.this, (List) obj);
                return initData$lambda$2;
            }
        }));
        getMViewModel().getMException().observe(this, new YouTuWatchActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.k0
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = YouTuWatchActivity.initData$lambda$3(YouTuWatchActivity.this, (Pair) obj);
                return initData$lambda$3;
            }
        }));
        getMViewModel().getPosition().observe(this, new YouTuWatchActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.youtu.l0
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = YouTuWatchActivity.initData$lambda$4(YouTuWatchActivity.this, (Integer) obj);
                return initData$lambda$4;
            }
        }));
        getMViewModel().watchYouTuList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$2(YouTuWatchActivity youTuWatchActivity, List list) {
        int i;
        if (youTuWatchActivity.getMViewModel().getWatchListBaseData().isOnePage()) {
            youTuWatchActivity.getMAdapter().setList(list);
        } else {
            YouTuWatchAdapter mAdapter = youTuWatchActivity.getMAdapter();
            Intrinsics.checkNotNull(list);
            mAdapter.addData(list);
        }
        Group group = youTuWatchActivity.getBinding().myGroup;
        if (youTuWatchActivity.getMAdapter().getData().size() > 0) {
            i = 0;
        } else {
            i = 8;
        }
        group.setVisibility(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$3(YouTuWatchActivity youTuWatchActivity, Pair pair) {
        if (Intrinsics.areEqual((String) pair.getFirst(), YouTuViewModel.TYPE_NOT_RECOMMEND) && (pair.getSecond() instanceof HiloException)) {
            Object second = pair.getSecond();
            Intrinsics.checkNotNull(second, "null cannot be cast to non-null type com.qiahao.base_common.network.interceptors.HiloException");
            HiloToasty.Companion companion = HiloToasty.Companion;
            String errorMessage = ((HiloException) second).getErrorMessage();
            if (errorMessage == null) {
                errorMessage = ResourcesKtxKt.getStringById(youTuWatchActivity, 2131952667);
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, youTuWatchActivity, errorMessage, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(YouTuWatchActivity youTuWatchActivity, Integer num) {
        YouTuWatchAdapter mAdapter = youTuWatchActivity.getMAdapter();
        Intrinsics.checkNotNull(num);
        mAdapter.removeAt(num.intValue());
        if (youTuWatchActivity.getMAdapter().getData().isEmpty()) {
            youTuWatchActivity.getBinding().statusView.showEmpty();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        ((ActivityYouTuWatchBinding) getBinding()).myBg.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#3F98FF", "#89C9FF", 10, (GradientDrawable.Orientation) null, 8, (Object) null));
        View view = ((ActivityYouTuWatchBinding) getBinding()).titleLayout.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.youtu.e0
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$5;
                initView$lambda$5 = YouTuWatchActivity.initView$lambda$5(YouTuWatchActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$5;
            }
        });
        final AppCompatImageView appCompatImageView = ((ActivityYouTuWatchBinding) getBinding()).titleLayout.backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.youtu.YouTuWatchActivity$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView) > j || (appCompatImageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView, currentTimeMillis);
                    AppCompatImageView appCompatImageView2 = appCompatImageView;
                    this.finish();
                }
            }
        });
        final TextView textView = ((ActivityYouTuWatchBinding) getBinding()).myRoom;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.youtu.YouTuWatchActivity$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                String str;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView) > j || (textView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(textView, currentTimeMillis);
                    StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
                    User user = UserStore.INSTANCE.getShared().getUser();
                    if (user == null || (str = user.getGroupId()) == null) {
                        str = "";
                    }
                    StartRoomUtils.startRoom$default(startRoomUtils, str, null, null, null, null, null, null, null, 0, 13, null, 0, false, 7678, null);
                }
            }
        });
        ((ActivityYouTuWatchBinding) getBinding()).titleLayout.title.setText(ResourcesKtxKt.getStringById(this, 2131954474));
        ((ActivityYouTuWatchBinding) getBinding()).titleLayout.endImage.setVisibility(0);
        AppCompatImageView appCompatImageView2 = ((ActivityYouTuWatchBinding) getBinding()).titleLayout.endImage;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "endImage");
        int px = UiKtxKt.toPX(10);
        appCompatImageView2.setPadding(px, px, px, px);
        ((ActivityYouTuWatchBinding) getBinding()).titleLayout.endImage.setImageDrawable(androidx.core.content.a.getDrawable(this, R.drawable.you_tu_list_helper));
        final AppCompatImageView appCompatImageView3 = ((ActivityYouTuWatchBinding) getBinding()).titleLayout.endImage;
        appCompatImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.youtu.YouTuWatchActivity$initView$$inlined$singleClick$default$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(appCompatImageView3) > j || (appCompatImageView3 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(appCompatImageView3, currentTimeMillis);
                    AppCompatImageView appCompatImageView4 = appCompatImageView3;
                    new WatchHelperDialog(this).show();
                }
            }
        });
        SuperStatusView superStatusView = ((ActivityYouTuWatchBinding) getBinding()).statusView;
        Status.Empty empty = Status.Empty.INSTANCE;
        superStatusView.addStatus(empty, R.layout.video_emtry_layout);
        ((ActivityYouTuWatchBinding) getBinding()).statusView.addStatus(Status.Error.INSTANCE, R.layout.video_emtry_layout);
        ((ActivityYouTuWatchBinding) getBinding()).statusView.addStatus(Status.Loading.INSTANCE, 2131558549);
        ((ActivityYouTuWatchBinding) getBinding()).statusView.addStatus(Status.NoNetwork.INSTANCE, R.layout.gift_status_empty);
        SmartRefreshLayout smartRefreshLayout = ((ActivityYouTuWatchBinding) getBinding()).refreshLayout;
        FootLoading footLoading = new FootLoading((Context) this);
        footLoading.setRootBackgroundColor(2131101214);
        smartRefreshLayout.setRefreshFooter(footLoading);
        ((ActivityYouTuWatchBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.youtu.f0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                YouTuWatchActivity.initView$lambda$10(YouTuWatchActivity.this, baseQuickAdapter, view2, i);
            }
        });
        getMAdapter().setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.qiahao.nextvideo.ui.youtu.g0
            public final boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                boolean initView$lambda$13;
                initView$lambda$13 = YouTuWatchActivity.initView$lambda$13(YouTuWatchActivity.this, baseQuickAdapter, view2, i);
                return initView$lambda$13;
            }
        });
        ((ActivityYouTuWatchBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.youtu.h0
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                YouTuWatchActivity.initView$lambda$14(YouTuWatchActivity.this, fVar);
            }
        });
        ((ActivityYouTuWatchBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.youtu.i0
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                YouTuWatchActivity.initView$lambda$15(YouTuWatchActivity.this, fVar);
            }
        });
        SmartRefreshLayout smartRefreshLayout2 = ((ActivityYouTuWatchBinding) getBinding()).refreshLayout;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout2, "refreshLayout");
        final TextView textView2 = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout2, empty, 2131364922);
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.youtu.YouTuWatchActivity$initView$$inlined$singleClick$default$4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    String str;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(textView2) > j || (textView2 instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(textView2, currentTimeMillis);
                        StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
                        User user = UserStore.INSTANCE.getShared().getUser();
                        if (user == null || (str = user.getGroupId()) == null) {
                            str = "";
                        }
                        StartRoomUtils.startRoom$default(startRoomUtils, str, null, null, null, null, null, null, null, 0, 13, null, 0, false, 7678, null);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$10(YouTuWatchActivity youTuWatchActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        WatchYouTuListData watchYouTuListData = (WatchYouTuListData) youTuWatchActivity.getMAdapter().getData().get(i);
        StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
        String groupId = watchYouTuListData.getGroupId();
        if (groupId == null) {
            groupId = "";
        }
        StartRoomUtils.startRoom$default(startRoomUtils, groupId, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean initView$lambda$13(final YouTuWatchActivity youTuWatchActivity, BaseQuickAdapter baseQuickAdapter, View view, final int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user != null && user.isOfficialStaff()) {
            final WatchYouTuListData watchYouTuListData = (WatchYouTuListData) youTuWatchActivity.getMAdapter().getData().get(i);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new DialogItemData(ResourcesKtxKt.getStringById(arrayList, 2131953554), 100));
            final BlockOrReportDialog blockOrReportDialog = new BlockOrReportDialog(youTuWatchActivity, arrayList);
            blockOrReportDialog.setMListener(new SelectInterface() { // from class: com.qiahao.nextvideo.ui.youtu.YouTuWatchActivity$initView$7$1$1
                public void onSelect(int index) {
                    if (index == 100) {
                        Context context = BlockOrReportDialog.this.getContext();
                        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                        TipBlackDialog confirmContent = new TipBlackDialog(context, (Integer) null, 2, (DefaultConstructorMarker) null).setTipContent(ResourcesKtxKt.getStringById(this, 2131952339)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952331));
                        final YouTuWatchActivity youTuWatchActivity2 = youTuWatchActivity;
                        final WatchYouTuListData watchYouTuListData2 = watchYouTuListData;
                        final int i2 = i;
                        confirmContent.setDialogListener(new OnCommonDialogListener() { // from class: com.qiahao.nextvideo.ui.youtu.YouTuWatchActivity$initView$7$1$1$onSelect$1
                            public void cancel() {
                                OnCommonDialogListener.DefaultImpls.cancel(this);
                            }

                            public void confirm() {
                                YouTuViewModel mViewModel;
                                mViewModel = YouTuWatchActivity.this.getMViewModel();
                                mViewModel.notRecommendView(watchYouTuListData2, i2);
                            }
                        }).show();
                    }
                }
            });
            blockOrReportDialog.show();
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$14(YouTuWatchActivity youTuWatchActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        youTuWatchActivity.getMViewModel().getWatchListBaseData().resetPage();
        youTuWatchActivity.getMViewModel().watchYouTuList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$15(YouTuWatchActivity youTuWatchActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        youTuWatchActivity.getMViewModel().watchYouTuList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$5(YouTuWatchActivity youTuWatchActivity, int i, int i2) {
        youTuWatchActivity.getBinding().titleLayout.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YouTuWatchAdapter mAdapter_delegate$lambda$1() {
        return new YouTuWatchAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final YouTuViewModel mViewModel_delegate$lambda$0(YouTuWatchActivity youTuWatchActivity) {
        return new ViewModelProvider(youTuWatchActivity).get(YouTuViewModel.class);
    }

    @JvmStatic
    public static final void start(@NotNull Context context) {
        INSTANCE.start(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_you_tu_watch;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        getMViewModel().getWatchListBaseData().destroy();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }
}
