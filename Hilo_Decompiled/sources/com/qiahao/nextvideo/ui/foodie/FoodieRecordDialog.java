package com.qiahao.nextvideo.ui.foodie;

import android.content.Context;
import android.view.View;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.databinding.ViewFoodieRecordBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.ui.foodie.adapter.FoodieRecordAdapter;
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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\n¢\u0006\u0004\b\r\u0010\fJ\r\u0010\u000e\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/FoodieRecordDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/ViewFoodieRecordBinding;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "getLayoutResId", "()I", "", "onInitialize", "()V", "initView", "requestData", "dismiss", "Lcom/qiahao/base_common/model/BaseListData;", "listData", "Lcom/qiahao/base_common/model/BaseListData;", "getListData", "()Lcom/qiahao/base_common/model/BaseListData;", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/ui/foodie/adapter/FoodieRecordAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/foodie/adapter/FoodieRecordAdapter;", "mAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nFoodieRecordDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FoodieRecordDialog.kt\ncom/qiahao/nextvideo/ui/foodie/FoodieRecordDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,105:1\n1#2:106\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieRecordDialog extends BaseBindingDialog<ViewFoodieRecordBinding> {

    @NotNull
    private final BaseListData listData;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    @NotNull
    private nd.a mCompositeDisposable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FoodieRecordDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(20);
        this.listData = baseListData;
        this.mCompositeDisposable = new nd.a();
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.foodie.c1
            public final Object invoke() {
                FoodieRecordAdapter mAdapter_delegate$lambda$1;
                mAdapter_delegate$lambda$1 = FoodieRecordDialog.mAdapter_delegate$lambda$1();
                return mAdapter_delegate$lambda$1;
            }
        });
    }

    private final FoodieRecordAdapter getMAdapter() {
        return (FoodieRecordAdapter) this.mAdapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(FoodieRecordDialog foodieRecordDialog, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        foodieRecordDialog.listData.resetPage();
        foodieRecordDialog.requestData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(FoodieRecordDialog foodieRecordDialog, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        foodieRecordDialog.requestData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FoodieRecordAdapter mAdapter_delegate$lambda$1() {
        return new FoodieRecordAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestData$lambda$6(FoodieRecordDialog foodieRecordDialog, ApiResponse apiResponse) {
        List data;
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        foodieRecordDialog.listData.setList((ApiList) apiResponse.getData());
        if (foodieRecordDialog.listData.isOnePage()) {
            FoodieRecordAdapter mAdapter = foodieRecordDialog.getMAdapter();
            ApiList apiList = (ApiList) apiResponse.getData();
            if (apiList != null) {
                list = apiList.getData();
            } else {
                list = null;
            }
            mAdapter.setList(list);
        } else {
            ApiList apiList2 = (ApiList) apiResponse.getData();
            if (apiList2 != null && (data = apiList2.getData()) != null) {
                foodieRecordDialog.getMAdapter().addData(data);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestData$lambda$7(FoodieRecordDialog foodieRecordDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        foodieRecordDialog.listData.requestError();
        return Unit.INSTANCE;
    }

    public void dismiss() {
        super.dismiss();
        this.mCompositeDisposable.d();
        this.listData.destroy();
    }

    protected int getLayoutResId() {
        return R.layout.view_foodie_record;
    }

    @NotNull
    public final BaseListData getListData() {
        return this.listData;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void initView() {
        ((ViewFoodieRecordBinding) getBinding()).ivClose.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FoodieRecordDialog.this.dismiss();
            }
        });
        ((ViewFoodieRecordBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading(getContext()));
        ((ViewFoodieRecordBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        this.listData.registerStatusLayoutAndRefreshLayout(((ViewFoodieRecordBinding) getBinding()).refreshLayout, ((ViewFoodieRecordBinding) getBinding()).statusView);
        ((ViewFoodieRecordBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.foodie.a1
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                FoodieRecordDialog.initView$lambda$3(FoodieRecordDialog.this, fVar);
            }
        });
        ((ViewFoodieRecordBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.foodie.b1
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                FoodieRecordDialog.initView$lambda$4(FoodieRecordDialog.this, fVar);
            }
        });
        ((ViewFoodieRecordBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.foodie.FoodieRecordDialog$initView$4
            public void onRetry(IStatusView statusView, Status status) {
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                FoodieRecordDialog.this.getListData().resetPage();
                FoodieRecordDialog.this.requestData();
            }
        });
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        setSize(-1, -2);
        initView();
        requestData();
    }

    public final void requestData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().foodieRecord(this.listData.nextPage(), this.listData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.x0
            public final Object invoke(Object obj) {
                Unit requestData$lambda$6;
                requestData$lambda$6 = FoodieRecordDialog.requestData$lambda$6(FoodieRecordDialog.this, (ApiResponse) obj);
                return requestData$lambda$6;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.foodie.y0
            public final Object invoke(Object obj) {
                Unit requestData$lambda$7;
                requestData$lambda$7 = FoodieRecordDialog.requestData$lambda$7(FoodieRecordDialog.this, (Throwable) obj);
                return requestData$lambda$7;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }
}
