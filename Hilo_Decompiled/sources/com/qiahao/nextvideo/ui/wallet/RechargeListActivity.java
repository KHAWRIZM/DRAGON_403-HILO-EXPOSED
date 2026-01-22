package com.qiahao.nextvideo.ui.wallet;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.HiloBaseBindingActivity;
import com.qiahao.nextvideo.data.model.DealerListBean;
import com.qiahao.nextvideo.data.model.OfficialRechargeBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ActivityRechargeListBinding;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import com.tencent.qcloud.tuicore.component.CustomLinearLayoutManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0005J\u0017\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0014¢\u0006\u0004\b\u000f\u0010\u0005R\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/RechargeListActivity;", "Lcom/qiahao/nextvideo/app/base/HiloBaseBindingActivity;", "Lcom/qiahao/nextvideo/databinding/ActivityRechargeListBinding;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "", "getLayoutResId", "()I", "", "onInitialize", "Landroid/view/View;", "v", "onClick", "(Landroid/view/View;)V", "onDestroy", "Lnd/a;", "compositeDisposable", "Lnd/a;", "getCompositeDisposable", "()Lnd/a;", "Lcom/qiahao/nextvideo/ui/wallet/OfficialRechargeAdapter;", "mOfficialRechargeAdapter$delegate", "Lkotlin/Lazy;", "getMOfficialRechargeAdapter", "()Lcom/qiahao/nextvideo/ui/wallet/OfficialRechargeAdapter;", "mOfficialRechargeAdapter", "", "mOfficialExtraId", "Ljava/lang/String;", "getMOfficialExtraId", "()Ljava/lang/String;", "setMOfficialExtraId", "(Ljava/lang/String;)V", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RechargeListActivity extends HiloBaseBindingActivity<ActivityRechargeListBinding> implements View.OnClickListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final nd.a compositeDisposable = new nd.a();

    /* renamed from: mOfficialRechargeAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mOfficialRechargeAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.wallet.i0
        public final Object invoke() {
            OfficialRechargeAdapter mOfficialRechargeAdapter_delegate$lambda$3;
            mOfficialRechargeAdapter_delegate$lambda$3 = RechargeListActivity.mOfficialRechargeAdapter_delegate$lambda$3(RechargeListActivity.this);
            return mOfficialRechargeAdapter_delegate$lambda$3;
        }
    });

    @NotNull
    private String mOfficialExtraId = "";

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/RechargeListActivity$Companion;", "", "<init>", "()V", "start", "", "context", "Landroid/content/Context;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void start(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, (Class<?>) RechargeListActivity.class));
        }

        private Companion() {
        }
    }

    private final OfficialRechargeAdapter getMOfficialRechargeAdapter() {
        return (OfficialRechargeAdapter) this.mOfficialRechargeAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OfficialRechargeAdapter mOfficialRechargeAdapter_delegate$lambda$3(final RechargeListActivity rechargeListActivity) {
        OfficialRechargeAdapter officialRechargeAdapter = new OfficialRechargeAdapter(R.layout.item_official_recharge);
        officialRechargeAdapter.addChildClickViewIds(new int[]{2131365536});
        officialRechargeAdapter.setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.g0
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RechargeListActivity.mOfficialRechargeAdapter_delegate$lambda$3$lambda$2$lambda$0(baseQuickAdapter, view, i);
            }
        });
        officialRechargeAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.qiahao.nextvideo.ui.wallet.h0
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                RechargeListActivity.mOfficialRechargeAdapter_delegate$lambda$3$lambda$2$lambda$1(RechargeListActivity.this, baseQuickAdapter, view, i);
            }
        });
        return officialRechargeAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOfficialRechargeAdapter_delegate$lambda$3$lambda$2$lambda$0(BaseQuickAdapter baseQuickAdapter, View view, int i) {
        AppService service;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "adapter");
        Intrinsics.checkNotNullParameter(view, "view");
        Object item = baseQuickAdapter.getItem(i);
        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.qiahao.nextvideo.data.model.OfficialRechargeBean");
        OfficialRechargeBean officialRechargeBean = (OfficialRechargeBean) item;
        if (view.getId() == 2131365536 && FastClickOneUtils.INSTANCE.isFastClick() && (service = AppController.INSTANCE.getService()) != null) {
            service.openPersonPage(officialRechargeBean.getExternalId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mOfficialRechargeAdapter_delegate$lambda$3$lambda$2$lambda$1(RechargeListActivity rechargeListActivity, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        AppService service;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        OfficialRechargeBean officialRechargeBean = (OfficialRechargeBean) rechargeListActivity.getMOfficialRechargeAdapter().getItem(i);
        if (FastClickOneUtils.INSTANCE.isFastClick() && (service = AppController.INSTANCE.getService()) != null) {
            service.toChat(officialRechargeBean.getExternalId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$6(RechargeListActivity rechargeListActivity, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        DealerListBean dealerListBean = (DealerListBean) apiResponse.getData();
        if (dealerListBean != null) {
            rechargeListActivity.mOfficialExtraId = dealerListBean.getOfficial();
            if (!dealerListBean.getDls().isEmpty()) {
                rechargeListActivity.getMOfficialRechargeAdapter().setList(dealerListBean.getDls());
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitialize$lambda$7(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        return Unit.INSTANCE;
    }

    @JvmStatic
    public static final void start(@NotNull Context context) {
        INSTANCE.start(context);
    }

    @NotNull
    public final nd.a getCompositeDisposable() {
        return this.compositeDisposable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public int getLayoutResId() {
        return R.layout.activity_recharge_list;
    }

    @NotNull
    public final String getMOfficialExtraId() {
        return this.mOfficialExtraId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v) {
        AppService service;
        Intrinsics.checkNotNullParameter(v, "v");
        int id2 = v.getId();
        if (id2 != 2131362039) {
            if (id2 == 2131362299 && this.mOfficialExtraId.length() > 0 && (service = AppController.INSTANCE.getService()) != null) {
                service.toChat(this.mOfficialExtraId);
                return;
            }
            return;
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qiahao.nextvideo.app.base.HiloBaseBindingActivity, com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.compositeDisposable.d();
    }

    @Override // com.qiahao.nextvideo.app.base.HiloBaseActivity
    public void onInitialize() {
        super.onInitialize();
        Toolbar toolbar = getBinding().toolbar;
        Intrinsics.checkNotNullExpressionValue(toolbar, "toolbar");
        setStatusBarTopOrBottom(toolbar, false);
        RecyclerView recyclerView = getBinding().recyclerView;
        recyclerView.setLayoutManager(new CustomLinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(getMOfficialRechargeAdapter());
        getBinding().setClick(this);
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(UserService.INSTANCE.getShared().getDealerList(), new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.e0
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$6;
                onInitialize$lambda$6 = RechargeListActivity.onInitialize$lambda$6(RechargeListActivity.this, (ApiResponse) obj);
                return onInitialize$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.wallet.f0
            public final Object invoke(Object obj) {
                Unit onInitialize$lambda$7;
                onInitialize$lambda$7 = RechargeListActivity.onInitialize$lambda$7((Throwable) obj);
                return onInitialize$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), this.compositeDisposable);
    }

    public final void setMOfficialExtraId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mOfficialExtraId = str;
    }
}
