package com.qiahao.nextvideo.ui.family;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.family.FamilyWheelRecord;
import com.qiahao.nextvideo.databinding.DialogDailyRecordBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.therouter.TheRouter;
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

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0007¢\u0006\u0004\b\u0011\u0010\tJ\u000f\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\tR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020!8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/DailyRecordDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogDailyRecordBinding;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "initView", "()V", "", "getLayoutResId", "()I", "onInitialize", "", "isBottomStyle", "()Z", "requestData", "dismiss", "Lcom/qiahao/base_common/model/BaseListData;", "baseListData", "Lcom/qiahao/base_common/model/BaseListData;", "getBaseListData", "()Lcom/qiahao/base_common/model/BaseListData;", "setBaseListData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/ui/family/DailyRecordAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/ui/family/DailyRecordAdapter;", "mAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDailyRecordDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DailyRecordDialog.kt\ncom/qiahao/nextvideo/ui/family/DailyRecordDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,106:1\n61#2,9:107\n1#3:116\n*S KotlinDebug\n*F\n+ 1 DailyRecordDialog.kt\ncom/qiahao/nextvideo/ui/family/DailyRecordDialog\n*L\n50#1:107,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DailyRecordDialog extends BaseBindingDialog<DialogDailyRecordBinding> {

    @NotNull
    private BaseListData baseListData;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    @NotNull
    private nd.a mCompositeDisposable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyRecordDialog(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        BaseListData baseListData = new BaseListData();
        baseListData.setPageSize(20);
        this.baseListData = baseListData;
        this.mCompositeDisposable = new nd.a();
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.family.c
            public final Object invoke() {
                DailyRecordAdapter mAdapter_delegate$lambda$1;
                mAdapter_delegate$lambda$1 = DailyRecordDialog.mAdapter_delegate$lambda$1();
                return mAdapter_delegate$lambda$1;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        final ImageView imageView = ((DialogDailyRecordBinding) getBinding()).close;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.family.DailyRecordDialog$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        ((DialogDailyRecordBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        ((DialogDailyRecordBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading(getContext()));
        this.baseListData.registerStatusLayoutAndRefreshLayout(((DialogDailyRecordBinding) getBinding()).refreshLayout, ((DialogDailyRecordBinding) getBinding()).statusView);
        ((DialogDailyRecordBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.family.d
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                DailyRecordDialog.initView$lambda$3(DailyRecordDialog.this, fVar);
            }
        });
        ((DialogDailyRecordBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.family.e
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                DailyRecordDialog.initView$lambda$4(DailyRecordDialog.this, fVar);
            }
        });
        ((DialogDailyRecordBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.family.DailyRecordDialog$initView$4
            public void onRetry(IStatusView statusView, Status status) {
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                DailyRecordDialog.this.getBaseListData().resetPage();
                DailyRecordDialog.this.requestData();
            }
        });
        getMAdapter().addChildClickViewIds(new int[]{2131362013});
        getMAdapter().setOnItemChildClickListener(new OnItemChildClickListener() { // from class: com.qiahao.nextvideo.ui.family.f
            public final void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                DailyRecordDialog.initView$lambda$5(DailyRecordDialog.this, baseQuickAdapter, view, i);
            }
        });
        requestData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$3(DailyRecordDialog dailyRecordDialog, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        dailyRecordDialog.baseListData.resetPage();
        dailyRecordDialog.requestData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4(DailyRecordDialog dailyRecordDialog, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        dailyRecordDialog.requestData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$5(DailyRecordDialog dailyRecordDialog, BaseQuickAdapter baseQuickAdapter, View view, int i) {
        String str;
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "<unused var>");
        Intrinsics.checkNotNullParameter(view, "view");
        if (view.getId() == 2131362013) {
            FamilyWheelRecord familyWheelRecord = (FamilyWheelRecord) dailyRecordDialog.getMAdapter().getData().get(i);
            AppService appService = (AppService) TheRouter.get(AppService.class, new Object[0]);
            if (appService != null) {
                User user = familyWheelRecord.getUser();
                if (user == null || (str = user.getExternalId()) == null) {
                    str = "";
                }
                appService.openPersonPage(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DailyRecordAdapter mAdapter_delegate$lambda$1() {
        return new DailyRecordAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestData$lambda$7(DailyRecordDialog dailyRecordDialog, ApiResponse apiResponse) {
        List data;
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        dailyRecordDialog.baseListData.setList((ApiList) apiResponse.getData());
        if (dailyRecordDialog.baseListData.isOnePage()) {
            DailyRecordAdapter mAdapter = dailyRecordDialog.getMAdapter();
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
                dailyRecordDialog.getMAdapter().addData(data);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestData$lambda$8(DailyRecordDialog dailyRecordDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        dailyRecordDialog.baseListData.requestError();
        return Unit.INSTANCE;
    }

    public void dismiss() {
        super.dismiss();
        this.mCompositeDisposable.d();
        this.baseListData.destroy();
    }

    @NotNull
    public final BaseListData getBaseListData() {
        return this.baseListData;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_daily_record;
    }

    @NotNull
    public final DailyRecordAdapter getMAdapter() {
        return (DailyRecordAdapter) this.mAdapter.getValue();
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        initView();
    }

    public final void requestData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().familyWheelRecord(this.baseListData.nextPage(), this.baseListData.getPageSize()), new Function1() { // from class: com.qiahao.nextvideo.ui.family.a
            public final Object invoke(Object obj) {
                Unit requestData$lambda$7;
                requestData$lambda$7 = DailyRecordDialog.requestData$lambda$7(DailyRecordDialog.this, (ApiResponse) obj);
                return requestData$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.family.b
            public final Object invoke(Object obj) {
                Unit requestData$lambda$8;
                requestData$lambda$8 = DailyRecordDialog.requestData$lambda$8(DailyRecordDialog.this, (Throwable) obj);
                return requestData$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    public final void setBaseListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.baseListData = baseListData;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }
}
