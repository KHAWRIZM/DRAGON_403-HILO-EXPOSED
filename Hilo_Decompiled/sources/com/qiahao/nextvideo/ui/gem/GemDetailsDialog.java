package com.qiahao.nextvideo.ui.gem;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseActivity;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.app.base.FootLoading;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.databinding.DialogGemDetailsBinding;
import com.qiahao.nextvideo.network.AppServer;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000bR\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/qiahao/nextvideo/ui/gem/GemDetailsDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogGemDetailsBinding;", "Landroid/content/Context;", "context", "", "tag", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "", "requestData", "()V", "", "getLayoutResId", "()I", "onInitialize", "dismiss", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "Lcom/qiahao/base_common/model/BaseListData;", "baseListData", "Lcom/qiahao/base_common/model/BaseListData;", "getBaseListData", "()Lcom/qiahao/base_common/model/BaseListData;", "setBaseListData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/ui/gem/GemDetailsAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "getAdapter", "()Lcom/qiahao/nextvideo/ui/gem/GemDetailsAdapter;", "adapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGemDetailsDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GemDetailsDialog.kt\ncom/qiahao/nextvideo/ui/gem/GemDetailsDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,100:1\n61#2,9:101\n61#2,9:110\n1#3:119\n*S KotlinDebug\n*F\n+ 1 GemDetailsDialog.kt\ncom/qiahao/nextvideo/ui/gem/GemDetailsDialog\n*L\n42#1:101,9\n45#1:110,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GemDetailsDialog extends BaseBindingDialog<DialogGemDetailsBinding> {

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy adapter;

    @NotNull
    private BaseListData baseListData;

    @NotNull
    private nd.a mCompositeDisposable;

    @NotNull
    private String tag;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GemDetailsDialog(@NotNull Context context, @NotNull String str) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "tag");
        this.tag = str;
        this.baseListData = new BaseListData();
        this.mCompositeDisposable = new nd.a();
        this.adapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.ui.gem.e
            public final Object invoke() {
                GemDetailsAdapter adapter_delegate$lambda$0;
                adapter_delegate$lambda$0 = GemDetailsDialog.adapter_delegate$lambda$0();
                return adapter_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GemDetailsAdapter adapter_delegate$lambda$0() {
        return new GemDetailsAdapter();
    }

    private final GemDetailsAdapter getAdapter() {
        return (GemDetailsAdapter) this.adapter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$4(GemDetailsDialog gemDetailsDialog, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        gemDetailsDialog.baseListData.resetPage();
        gemDetailsDialog.requestData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$5(GemDetailsDialog gemDetailsDialog, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        gemDetailsDialog.requestData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestData() {
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(AppServer.INSTANCE.getApis().userDiamondsDetail(this.baseListData.nextPage(), this.baseListData.getPageSize(), 1), new Function1() { // from class: com.qiahao.nextvideo.ui.gem.c
            public final Object invoke(Object obj) {
                Unit requestData$lambda$7;
                requestData$lambda$7 = GemDetailsDialog.requestData$lambda$7(GemDetailsDialog.this, (ApiResponse) obj);
                return requestData$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.gem.d
            public final Object invoke(Object obj) {
                Unit requestData$lambda$8;
                requestData$lambda$8 = GemDetailsDialog.requestData$lambda$8(GemDetailsDialog.this, (Throwable) obj);
                return requestData$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestData$lambda$7(GemDetailsDialog gemDetailsDialog, ApiResponse apiResponse) {
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        gemDetailsDialog.baseListData.setList((List) apiResponse.getData());
        if (gemDetailsDialog.baseListData.isOnePage()) {
            gemDetailsDialog.getAdapter().setList((Collection) apiResponse.getData());
        } else {
            List list = (List) apiResponse.getData();
            if (list != null) {
                gemDetailsDialog.getAdapter().addData(list);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestData$lambda$8(GemDetailsDialog gemDetailsDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        gemDetailsDialog.baseListData.requestError();
        return Unit.INSTANCE;
    }

    public void dismiss() {
        super.dismiss();
        this.baseListData.destroy();
    }

    @NotNull
    public final BaseListData getBaseListData() {
        return this.baseListData;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_gem_details;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        String str;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        ((DialogGemDetailsBinding) getBinding()).recyclerView.setAdapter(getAdapter());
        final ImageView imageView = ((DialogGemDetailsBinding) getBinding()).close;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.gem.GemDetailsDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        final ImageView imageView2 = ((DialogGemDetailsBinding) getBinding()).back;
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.gem.GemDetailsDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView2) > j || (imageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView2, currentTimeMillis);
                    BaseActivity activity = HiloUtils.INSTANCE.getActivity(this.getContext());
                    if (activity != null) {
                        new GemStoreDialog().show(activity.getSupportFragmentManager(), this.getTag());
                    }
                    this.dismiss();
                }
            }
        });
        AppCompatTextView appCompatTextView = ((DialogGemDetailsBinding) getBinding()).gemNumber;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        User user = UserStore.INSTANCE.getShared().getUser();
        if (user == null || (str = user.getCode()) == null) {
            str = "";
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        appCompatTextView.setText(format);
        this.baseListData.registerStatusLayoutAndRefreshLayout(((DialogGemDetailsBinding) getBinding()).refreshLayout, ((DialogGemDetailsBinding) getBinding()).statusView);
        ((DialogGemDetailsBinding) getBinding()).refreshLayout.setRefreshFooter(new FootLoading(getContext()));
        ((DialogGemDetailsBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.ui.gem.a
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                GemDetailsDialog.onInitialize$lambda$4(GemDetailsDialog.this, fVar);
            }
        });
        ((DialogGemDetailsBinding) getBinding()).refreshLayout.setOnLoadMoreListener(new vc.e() { // from class: com.qiahao.nextvideo.ui.gem.b
            @Override // vc.e
            public final void onLoadMore(tc.f fVar) {
                GemDetailsDialog.onInitialize$lambda$5(GemDetailsDialog.this, fVar);
            }
        });
        ((DialogGemDetailsBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.ui.gem.GemDetailsDialog$onInitialize$5
            public void onRetry(IStatusView statusView, Status status) {
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                GemDetailsDialog.this.requestData();
            }
        });
        requestData();
    }

    public final void setBaseListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.baseListData = baseListData;
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tag = str;
    }

    public /* synthetic */ GemDetailsDialog(Context context, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? "" : str);
    }
}
