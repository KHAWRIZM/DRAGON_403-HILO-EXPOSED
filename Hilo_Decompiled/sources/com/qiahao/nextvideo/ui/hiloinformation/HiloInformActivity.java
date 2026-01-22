package com.qiahao.nextvideo.ui.hiloinformation;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Checkable;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.lifecycle.ViewModelProvider;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.core.loading.ILoading;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.HiloInformationCellUIModel;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ActivityHiloInformationBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.ui.family.FamilyApplicationActivity;
import com.qiahao.nextvideo.ui.family.FamilyCenterActivity;
import com.qiahao.nextvideo.ui.home.chat.activity.ChatActivity;
import com.qiahao.nextvideo.ui.im.MessageProvide;
import com.qiahao.nextvideo.ui.rank.SupportGiftRankActivity;
import com.qiahao.nextvideo.ui.store.MyBagActivity;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018J\b\u0010\u0019\u001a\u00020\u0013H\u0014R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/ui/hiloinformation/HiloInformActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityHiloInformationBinding;", "<init>", "()V", "mAdapter", "Lcom/qiahao/nextvideo/ui/hiloinformation/HiloInformAdapter;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/hiloinformation/HiloInformAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "viewModel", "Lcom/qiahao/nextvideo/ui/hiloinformation/HiloInformViewModel;", "getViewModel", "()Lcom/qiahao/nextvideo/ui/hiloinformation/HiloInformViewModel;", "viewModel$delegate", "getLayoutResId", "", "onInitialize", "", "initData", "initView", "onOpenUserProfile", SupportGiftRankActivity.EXTERNAL_ID, "", "onResume", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nHiloInformActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 HiloInformActivity.kt\ncom/qiahao/nextvideo/ui/hiloinformation/HiloInformActivity\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,172:1\n61#2,9:173\n1#3:182\n*S KotlinDebug\n*F\n+ 1 HiloInformActivity.kt\ncom/qiahao/nextvideo/ui/hiloinformation/HiloInformActivity\n*L\n92#1:173,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloInformActivity extends HiloBaseBindingActivity<ActivityHiloInformationBinding> {
    public static final int ACTIVITY_FAMILY = 5;
    public static final int ACTIVITY_FAMILY_APPLY = 6;
    public static final int ACTIVITY_H5 = 1;
    public static final int ACTIVITY_MY_BAG = 4;
    public static final int ACTIVITY_NAVIGATION = 7;
    public static final int ACTIVITY_ROOM = 3;
    public static final int ACTIVITY_USER = 2;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.hiloinformation.i
        public final Object invoke() {
            HiloInformAdapter mAdapter_delegate$lambda$0;
            mAdapter_delegate$lambda$0 = HiloInformActivity.mAdapter_delegate$lambda$0();
            return mAdapter_delegate$lambda$0;
        }
    });

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.hiloinformation.j
        public final Object invoke() {
            HiloInformViewModel viewModel_delegate$lambda$1;
            viewModel_delegate$lambda$1 = HiloInformActivity.viewModel_delegate$lambda$1(HiloInformActivity.this);
            return viewModel_delegate$lambda$1;
        }
    });

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/hiloinformation/HiloInformActivity$Companion;", "", "<init>", "()V", "ACTIVITY_H5", "", "ACTIVITY_USER", "ACTIVITY_ROOM", "ACTIVITY_MY_BAG", "ACTIVITY_FAMILY", "ACTIVITY_FAMILY_APPLY", "ACTIVITY_NAVIGATION", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) HiloInformActivity.class));
        }

        private Companion() {
        }
    }

    private final void initData() {
        MessageProvide.INSTANCE.clearUnreadMessageCount("Hilo_Information");
        getViewModel().getHiloInfoList().observe(this, new HiloInformActivity$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.qiahao.nextvideo.ui.hiloinformation.a
            public final Object invoke(Object obj) {
                Unit initData$lambda$2;
                initData$lambda$2 = HiloInformActivity.initData$lambda$2(HiloInformActivity.this, (ArrayList) obj);
                return initData$lambda$2;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initData$lambda$2(HiloInformActivity hiloInformActivity, ArrayList arrayList) {
        if (hiloInformActivity.getViewModel().getHiloInfoData().isOnePage()) {
            hiloInformActivity.getMAdapter().setList(arrayList);
        } else {
            HiloInformAdapter mAdapter = hiloInformActivity.getMAdapter();
            Intrinsics.checkNotNull(arrayList);
            mAdapter.addData(arrayList);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        View view = ((ActivityHiloInformationBinding) getBinding()).bar;
        Intrinsics.checkNotNullExpressionValue(view, "bar");
        getStatusBarTopOrBottom(view, new Function2() { // from class: com.qiahao.nextvideo.ui.hiloinformation.b
            public final Object invoke(Object obj, Object obj2) {
                Unit initView$lambda$3;
                initView$lambda$3 = HiloInformActivity.initView$lambda$3(HiloInformActivity.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue());
                return initView$lambda$3;
            }
        });
        final AppCompatImageView appCompatImageView = ((ActivityHiloInformationBinding) getBinding()).backImageView;
        final long j = 800;
        appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.hiloinformation.HiloInformActivity$initView$$inlined$singleClick$default$1
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
        ((ActivityHiloInformationBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.hiloinformation.c
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                HiloInformActivity.initView$lambda$5(HiloInformActivity.this, fVar);
            }
        });
        ((ActivityHiloInformationBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.hiloinformation.d
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                HiloInformActivity.initView$lambda$6(HiloInformActivity.this, fVar);
            }
        });
        ((ActivityHiloInformationBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading((Context) this));
        ((ActivityHiloInformationBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.hiloinformation.HiloInformActivity$initView$5
            public void onRetry(IStatusView statusView, Status status) {
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                HiloInformActivity.this.getViewModel().getHiloInfoData().resetPage();
                HiloInformActivity.this.getViewModel().getHiloInfo();
            }
        });
        getViewModel().getHiloInfoData().registerStatusLayoutAndRefreshLayout(((ActivityHiloInformationBinding) getBinding()).refreshLayout, ((ActivityHiloInformationBinding) getBinding()).statusView);
        ((ActivityHiloInformationBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        getMAdapter().setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.hiloinformation.e
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view2, int i) {
                HiloInformActivity.initView$lambda$7(HiloInformActivity.this, baseQuickAdapter, view2, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit initView$lambda$3(HiloInformActivity hiloInformActivity, int i, int i2) {
        hiloInformActivity.getBinding().bar.setLayoutParams(new LinearLayoutCompat.a(-2, i));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(HiloInformActivity hiloInformActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        hiloInformActivity.getViewModel().getHiloInfoData().resetPage();
        hiloInformActivity.getViewModel().getHiloInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$6(HiloInformActivity hiloInformActivity, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        hiloInformActivity.getViewModel().getHiloInfo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initView$lambda$7(HiloInformActivity hiloInformActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        HiloInformationCellUIModel hiloInformationCellUIModel = (HiloInformationCellUIModel) hiloInformActivity.getMAdapter().getData().get(i);
        switch (hiloInformationCellUIModel.getActionType()) {
            case 1:
            case 7:
                String actionUrl = hiloInformationCellUIModel.getActionUrl();
                if (actionUrl != null && actionUrl.length() != 0) {
                    NavigationHelper.jump$default(NavigationHelper.INSTANCE, hiloInformationCellUIModel.getActionUrl(), (SuperCallBack) null, 2, (Object) null);
                    return;
                }
                return;
            case 2:
                String actionUrl2 = hiloInformationCellUIModel.getActionUrl();
                if (actionUrl2 != null && actionUrl2.length() != 0) {
                    hiloInformActivity.onOpenUserProfile(hiloInformationCellUIModel.getActionUrl());
                    return;
                }
                return;
            case 3:
                String actionUrl3 = hiloInformationCellUIModel.getActionUrl();
                if (actionUrl3 != null && actionUrl3.length() != 0 && FastClickOneUtils.INSTANCE.isFastClick()) {
                    StartRoomUtils.startRoom$default(StartRoomUtils.INSTANCE, hiloInformationCellUIModel.getActionUrl(), null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
                    return;
                }
                return;
            case 4:
                MyBagActivity.INSTANCE.start(hiloInformActivity);
                return;
            case 5:
                String actionUrl4 = hiloInformationCellUIModel.getActionUrl();
                if (actionUrl4 != null && actionUrl4.length() != 0) {
                    FamilyCenterActivity.INSTANCE.startActivity(hiloInformActivity, Long.parseLong(hiloInformationCellUIModel.getActionUrl()));
                    return;
                }
                return;
            case 6:
                FamilyApplicationActivity.INSTANCE.startActivity(hiloInformActivity);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HiloInformAdapter mAdapter_delegate$lambda$0() {
        return new HiloInformAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onOpenUserProfile$lambda$10(HiloInformActivity hiloInformActivity, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        HiloToasty.Companion companion = HiloToasty.Companion;
        String localizedMessage = th.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = hiloInformActivity.getString(2131952667);
            Intrinsics.checkNotNullExpressionValue(localizedMessage, "getString(...)");
        }
        Toast normal$default = HiloToasty.Companion.normal$default(companion, hiloInformActivity, localizedMessage, false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onOpenUserProfile$lambda$11(HiloInformActivity hiloInformActivity) {
        ILoading.DefaultImpls.dismissLoading$default(hiloInformActivity, (Integer) null, 1, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit onOpenUserProfile$lambda$9(HiloInformActivity hiloInformActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "user");
        User user = (User) apiResponse.getData();
        if (user != null) {
            ChatActivity.Companion.start$default(ChatActivity.INSTANCE, hiloInformActivity, user, false, 4, null);
        }
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void start(@NotNull Context context) {
        INSTANCE.start(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HiloInformViewModel viewModel_delegate$lambda$1(HiloInformActivity hiloInformActivity) {
        return new ViewModelProvider(hiloInformActivity).get(HiloInformViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_hilo_information;
    }

    @NotNull
    public final HiloInformAdapter getMAdapter() {
        return (HiloInformAdapter) this.mAdapter.getValue();
    }

    @NotNull
    public final HiloInformViewModel getViewModel() {
        return (HiloInformViewModel) this.viewModel.getValue();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        initView();
        initData();
    }

    public final void onOpenUserProfile(@NotNull String externalId) {
        String str;
        Intrinsics.checkNotNullParameter(externalId, SupportGiftRankActivity.EXTERNAL_ID);
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getExternalId()) == null) {
            str = "";
        }
        if (!Intrinsics.areEqual(externalId, str) && !Intrinsics.areEqual(externalId, "")) {
            ILoading.DefaultImpls.showLoading$default(this, (Integer) null, (CharSequence) null, 3, (Object) null);
            RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.fetchUserDetail$default(UserService.INSTANCE.getShared(), externalId, null, 2, null), new Function1() { // from class: com.qiahao.nextvideo.ui.hiloinformation.f
                public final Object invoke(Object obj) {
                    Unit onOpenUserProfile$lambda$9;
                    onOpenUserProfile$lambda$9 = HiloInformActivity.onOpenUserProfile$lambda$9(HiloInformActivity.this, (ApiResponse) obj);
                    return onOpenUserProfile$lambda$9;
                }
            }, new Function1() { // from class: com.qiahao.nextvideo.ui.hiloinformation.g
                public final Object invoke(Object obj) {
                    Unit onOpenUserProfile$lambda$10;
                    onOpenUserProfile$lambda$10 = HiloInformActivity.onOpenUserProfile$lambda$10(HiloInformActivity.this, (Throwable) obj);
                    return onOpenUserProfile$lambda$10;
                }
            }, new Function0() { // from class: com.qiahao.nextvideo.ui.hiloinformation.h
                public final Object invoke() {
                    Unit onOpenUserProfile$lambda$11;
                    onOpenUserProfile$lambda$11 = HiloInformActivity.onOpenUserProfile$lambda$11(HiloInformActivity.this);
                    return onOpenUserProfile$lambda$11;
                }
            }, false, 8, (Object) null), getViewModel().getMCompositeDisposable());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onResume() {
        super.onResume();
        getViewModel().getHiloInfo();
    }
}
