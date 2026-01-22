package com.qiahao.nextvideo.ui.foodie;

import android.content.Context;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ViewFoodieRankBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.foodie.adapter.FoodieRankingAdapter;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\fJ\r\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001f\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieRankDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/ViewFoodieRankBinding;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "getLayoutResId", "()I", "", "onInitialize", "()V", "", "isBottomStyle", "()Z", "initView", "requestData", "dismiss", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/ui/foodie/adapter/FoodieRankingAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/foodie/adapter/FoodieRankingAdapter;", "mAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieRankDialog extends BaseBindingDialog<ViewFoodieRankBinding> {

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    @NotNull
    private nd.a mCompositeDisposable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoodieRankDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCompositeDisposable = new nd.a();
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.foodie.t0
            public final Object invoke() {
                FoodieRankingAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = FoodieRankDialog.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
    }

    private final FoodieRankingAdapter getMAdapter() {
        return (FoodieRankingAdapter) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$1(FoodieRankDialog foodieRankDialog, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        foodieRankDialog.requestData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FoodieRankingAdapter mAdapter_delegate$lambda$0() {
        return new FoodieRankingAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestData$lambda$2(FoodieRankDialog foodieRankDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        ((ViewFoodieRankBinding) foodieRankDialog.getBinding()).refreshLayout.finishRefresh();
        Collection collection = (Collection) apiResponse.getData();
        if (collection != null && !collection.isEmpty()) {
            ((ViewFoodieRankBinding) foodieRankDialog.getBinding()).statusView.showContent();
        } else {
            ((ViewFoodieRankBinding) foodieRankDialog.getBinding()).statusView.showEmpty();
        }
        foodieRankDialog.getMAdapter().setList((Collection) apiResponse.getData());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestData$lambda$3(FoodieRankDialog foodieRankDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        ((ViewFoodieRankBinding) foodieRankDialog.getBinding()).refreshLayout.finishRefresh();
        ((ViewFoodieRankBinding) foodieRankDialog.getBinding()).statusView.showEmpty();
        return Unit.INSTANCE;
    }

    public void dismiss() {
        super.dismiss();
        this.mCompositeDisposable.d();
    }

    protected int getLayoutResId() {
        return R.layout.view_foodie_rank;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    public final void initView() {
        ((ViewFoodieRankBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        ((ViewFoodieRankBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.foodie.u0
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                FoodieRankDialog.initView$lambda$1(FoodieRankDialog.this, fVar);
            }
        });
        ((ViewFoodieRankBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieRankDialog$initView$2
            public void onRetry(IStatusView statusView, Status status) {
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                FoodieRankDialog.this.requestData();
            }
        });
    }

    protected boolean isBottomStyle() {
        return true;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        initView();
        requestData();
    }

    public final void requestData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().foodieRank(), new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.v0
            public final Object invoke(Object obj) {
                Unit requestData$lambda$2;
                requestData$lambda$2 = FoodieRankDialog.requestData$lambda$2(FoodieRankDialog.this, (ApiResponse) obj);
                return requestData$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.w0
            public final Object invoke(Object obj) {
                Unit requestData$lambda$3;
                requestData$lambda$3 = FoodieRankDialog.requestData$lambda$3(FoodieRankDialog.this, (Throwable) obj);
                return requestData$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }
}
