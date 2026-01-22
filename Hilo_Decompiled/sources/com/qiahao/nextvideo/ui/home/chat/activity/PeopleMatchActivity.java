package com.qiahao.nextvideo.ui.home.chat.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Checkable;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.game.MatchRecent;
import com.qiahao.nextvideo.databinding.ActivityPeopleMatchBinding;
import com.qiahao.nextvideo.ui.home.chat.PeopleMatchAdapter;
import com.qiahao.nextvideo.ui.home.chat.PeopleMatchViewModel;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.videocall.VideoCallMessage;
import com.qiahao.nextvideo.ui.vip.VipViewDialog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/activity/PeopleMatchActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityPeopleMatchBinding;", "<init>", "()V", "mAdapter", "Lcom/qiahao/nextvideo/ui/home/chat/PeopleMatchAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/home/chat/PeopleMatchAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/home/chat/PeopleMatchViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/home/chat/PeopleMatchViewModel;", "viewModel$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "onPause", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPeopleMatchActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PeopleMatchActivity.kt\ncom/qiahao/nextvideo/ui/home/chat/activity/PeopleMatchActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n61#2,9:159\n1#3:168\n*S KotlinDebug\n*F\n+ 1 PeopleMatchActivity.kt\ncom/qiahao/nextvideo/ui/home/chat/activity/PeopleMatchActivity\n*L\n102#1:159,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PeopleMatchActivity extends HiloBaseBindingActivity<ActivityPeopleMatchBinding> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.r1
        public final Object invoke() {
            PeopleMatchAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = PeopleMatchActivity.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.s1
        public final Object invoke() {
            PeopleMatchViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = PeopleMatchActivity.viewModel_delegate$lambda$1(PeopleMatchActivity.this);
            return viewModel_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/activity/PeopleMatchActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) PeopleMatchActivity.class));
        }

        private Companion() {
        }
    }

    private final PeopleMatchAdapter getMAdapter() {
        return (PeopleMatchAdapter) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PeopleMatchViewModel getViewModel() {
        return (PeopleMatchViewModel) this.viewModel.getValue();
    }

    private final void initData() {
        getViewModel().getMatchList().observe(this, new PeopleMatchActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.y1
            public final Object invoke(Object obj) {
                Unit initData$lambda$3;
                initData$lambda$3 = PeopleMatchActivity.initData$lambda$3(PeopleMatchActivity.this, (List) obj);
                return initData$lambda$3;
            }
        }));
        getViewModel().getLikeData().observe(this, new PeopleMatchActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.z1
            public final Object invoke(Object obj) {
                Unit initData$lambda$4;
                initData$lambda$4 = PeopleMatchActivity.initData$lambda$4(PeopleMatchActivity.this, (MatchRecent) obj);
                return initData$lambda$4;
            }
        }));
        getViewModel().getError().observe(this, new PeopleMatchActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.a2
            public final Object invoke(Object obj) {
                Unit initData$lambda$5;
                initData$lambda$5 = PeopleMatchActivity.initData$lambda$5(PeopleMatchActivity.this, (Throwable) obj);
                return initData$lambda$5;
            }
        }));
        getViewModel().matchRecentList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$3(PeopleMatchActivity peopleMatchActivity, List list) {
        if (peopleMatchActivity.getViewModel().getBaseListData().isOnePage()) {
            peopleMatchActivity.getMAdapter().setList(list);
        } else if (list != null) {
            peopleMatchActivity.getMAdapter().addData(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$4(PeopleMatchActivity peopleMatchActivity, MatchRecent matchRecent) {
        if (peopleMatchActivity.getMAdapter().getData().size() > matchRecent.getPosition()) {
            List data = peopleMatchActivity.getMAdapter().getData();
            int position = matchRecent.getPosition();
            Intrinsics.checkNotNull(matchRecent);
            data.set(position, matchRecent);
            peopleMatchActivity.getMAdapter().notifyItemChanged(matchRecent.getPosition());
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit initData$lambda$5(PeopleMatchActivity peopleMatchActivity, Throwable th) {
        if (th instanceof HiloException) {
            HiloException hiloException = (HiloException) th;
            int code = hiloException.getCode();
            if (code != 9004) {
                if (code != 9005) {
                    HiloToasty.Companion companion = HiloToasty.Companion;
                    String errorMessage = hiloException.getErrorMessage();
                    if (errorMessage == null) {
                        errorMessage = ResourcesKtxKt.getStringById(peopleMatchActivity, 2131952667);
                    }
                    Toast normal$default = HiloToasty.Companion.normal$default(companion, peopleMatchActivity, errorMessage, false, 4, (Object) null);
                    if (normal$default != null) {
                        normal$default.show();
                    }
                } else {
                    Toast normal$default2 = HiloToasty.Companion.normal$default(HiloToasty.Companion, peopleMatchActivity, ResourcesKtxKt.getStringById(peopleMatchActivity, 2131953231), false, 4, (Object) null);
                    if (normal$default2 != null) {
                        normal$default2.show();
                    }
                }
            } else {
                new VipViewDialog(5, peopleMatchActivity).show();
            }
        } else {
            Toast normal$default3 = HiloToasty.Companion.normal$default(HiloToasty.Companion, peopleMatchActivity, ResourcesKtxKt.getStringById(peopleMatchActivity, 2131952667), false, 4, (Object) null);
            if (normal$default3 != null) {
                normal$default3.show();
            }
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        View view = getBinding().titleLayout.bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.t1
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$6;
                initView$lambda$6 = PeopleMatchActivity.initView$lambda$6(PeopleMatchActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$6;
            }
        });
        final AppCompatImageView appCompatImageView = getBinding().titleLayout.backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.PeopleMatchActivity$initView$$inlined$singleClick$default$1
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
        getBinding().titleLayout.title.setText(ResourcesKtxKt.getStringById(this, 2131953617));
        getViewModel().getBaseListData().registerStatusLayoutAndRefreshLayout(getBinding().refreshLayout, getBinding().statusView);
        getBinding().recyclerView.setAdapter(getMAdapter());
        getBinding().refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.u1
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                PeopleMatchActivity.initView$lambda$8(PeopleMatchActivity.this, fVar);
            }
        });
        getBinding().refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.v1
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                PeopleMatchActivity.initView$lambda$9(PeopleMatchActivity.this, fVar);
            }
        });
        getBinding().statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.PeopleMatchActivity$initView$5
            public void onRetry(IStatusView statusView, Status status) {
                PeopleMatchViewModel viewModel;
                PeopleMatchViewModel viewModel2;
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                viewModel = PeopleMatchActivity.this.getViewModel();
                viewModel.getBaseListData().resetPage();
                viewModel2 = PeopleMatchActivity.this.getViewModel();
                viewModel2.matchRecentList();
            }
        });
        getMAdapter().addChildClickViewIds(new int[]{R.id.like_call_button, R.id.video_call_button});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.w1
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                PeopleMatchActivity.initView$lambda$10(PeopleMatchActivity.this, baseQuickAdapter, view2, i);
            }
        });
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.home.chat.activity.x1
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                PeopleMatchActivity.initView$lambda$11(PeopleMatchActivity.this, baseQuickAdapter, view2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$10(PeopleMatchActivity peopleMatchActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        boolean z;
        String str;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        MatchRecent matchRecent = (MatchRecent) peopleMatchActivity.getMAdapter().getData().get(i);
        int id2 = view.getId();
        if (id2 != 2131363490) {
            if (id2 == 2131365597) {
                User user = matchRecent.getUser();
                boolean z2 = false;
                if (user != null) {
                    z = Intrinsics.areEqual(user.isLike(), Boolean.TRUE);
                } else {
                    z = false;
                }
                if (z) {
                    User user2 = matchRecent.getUser();
                    if (user2 != null) {
                        z2 = Intrinsics.areEqual(user2.isLikeMe(), Boolean.TRUE);
                    }
                    if (z2) {
                        VideoCallMessage videoCallMessage = VideoCallMessage.INSTANCE;
                        User user3 = matchRecent.getUser();
                        if (user3 == null || (str = user3.getExternalId()) == null) {
                            str = "";
                        }
                        VideoCallMessage.newStartVideo$default(videoCallMessage, peopleMatchActivity, str, null, null, 12, null);
                        return;
                    }
                }
                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, peopleMatchActivity, ResourcesKtxKt.getStringById(peopleMatchActivity, 2131953223), false, 4, (Object) null);
                if (normal$default != null) {
                    normal$default.show();
                    return;
                }
                return;
            }
            return;
        }
        peopleMatchActivity.getViewModel().likeUser(matchRecent, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$11(PeopleMatchActivity peopleMatchActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        MatchRecent matchRecent = (MatchRecent) peopleMatchActivity.getMAdapter().getData().get(i);
        AppService service = AppController.INSTANCE.getService();
        if (service != null) {
            User user = matchRecent.getUser();
            if (user == null || (str = user.getExternalId()) == null) {
                str = "";
            }
            service.openPersonPage(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$6(PeopleMatchActivity peopleMatchActivity, int i, int i2) {
        peopleMatchActivity.getBinding().titleLayout.bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$8(PeopleMatchActivity peopleMatchActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        peopleMatchActivity.getViewModel().getBaseListData().resetPage();
        peopleMatchActivity.getViewModel().matchRecentList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$9(PeopleMatchActivity peopleMatchActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        peopleMatchActivity.getViewModel().matchRecentList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PeopleMatchAdapter mAdapter_delegate$lambda$0() {
        return new PeopleMatchAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PeopleMatchViewModel viewModel_delegate$lambda$1(PeopleMatchActivity peopleMatchActivity) {
        return new ViewModelProvider(peopleMatchActivity).get(PeopleMatchViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_people_match;
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onPause() {
        super.onPause();
        MessageProvide messageProvide = MessageProvide.INSTANCE;
        messageProvide.setHasNewSystemMessage(true);
        messageProvide.displayData(MessageProvide.MESSAGE_DEFAULT);
    }
}
