package com.qiahao.nextvideo.room.dialog;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.core.status.IStatusView;
import com.oudi.core.status.Status;
import com.oudi.core.status.StatusKtxKtKt;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.interfaceing.SelectInterface;
import com.qiahao.base_common.model.ApiList;
import com.qiahao.base_common.model.BaseListData;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.ui.dialog.ReportDialog;
import com.qiahao.base_common.ui.dialog.TipBlackDialog;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.databinding.DialogPkSupportBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qiahao.nextvideo.room.adapter.PKSupportAdapter;
import com.qiahao.nextvideo.ui.base.BlockOrReportDialog;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import java.io.File;
import java.util.Arrays;
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
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B%\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\rJ\r\u0010\u0014\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\rJ\r\u0010\u0015\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\rJ\u000f\u0010\u0016\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001a\u001a\u0004\b\b\u0010\u0012\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u00100\u001a\u00020+8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/qiahao/nextvideo/room/dialog/PKSupportDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogPkSupportBinding;", "Landroid/content/Context;", "context", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", AgooConstants.MESSAGE_BODY_GROUP, "", "isRed", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/model/GroupDetailBean;Z)V", "", "reportGroup", "()V", "", "getLayoutResId", "()I", "isBottomStyle", "()Z", "onInitialize", "showBlockTipDialog", "requestList", "dismiss", "Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "getGroup", "()Lcom/qiahao/nextvideo/data/model/GroupDetailBean;", "Z", "setRed", "(Z)V", "Lcom/qiahao/base_common/model/BaseListData;", "pkListData", "Lcom/qiahao/base_common/model/BaseListData;", "getPkListData", "()Lcom/qiahao/base_common/model/BaseListData;", "setPkListData", "(Lcom/qiahao/base_common/model/BaseListData;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "Lcom/qiahao/nextvideo/room/adapter/PKSupportAdapter;", "mAdapter$delegate", "Lkotlin/Lazy;", "getMAdapter", "()Lcom/qiahao/nextvideo/room/adapter/PKSupportAdapter;", "mAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPKSupportDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PKSupportDialog.kt\ncom/qiahao/nextvideo/room/dialog/PKSupportDialog\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,197:1\n1#2:198\n61#3,9:199\n*S KotlinDebug\n*F\n+ 1 PKSupportDialog.kt\ncom/qiahao/nextvideo/room/dialog/PKSupportDialog\n*L\n64#1:199,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PKSupportDialog extends BaseBindingDialog<DialogPkSupportBinding> {

    @Nullable
    private final GroupDetailBean group;
    private boolean isRed;

    /* renamed from: mAdapter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    @NotNull
    private nd.a mCompositeDisposable;

    @NotNull
    private BaseListData pkListData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PKSupportDialog(@NotNull Context context, @Nullable GroupDetailBean groupDetailBean, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.group = groupDetailBean;
        this.isRed = z;
        this.pkListData = new BaseListData();
        this.mCompositeDisposable = new nd.a();
        this.mAdapter = LazyKt.lazy(new Function0() { // from class: com.qiahao.nextvideo.room.dialog.n1
            public final Object invoke() {
                PKSupportAdapter mAdapter_delegate$lambda$0;
                mAdapter_delegate$lambda$0 = PKSupportDialog.mAdapter_delegate$lambda$0();
                return mAdapter_delegate$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PKSupportAdapter mAdapter_delegate$lambda$0() {
        return new PKSupportAdapter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInitialize$lambda$5(PKSupportDialog pKSupportDialog, tc.f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "it");
        pKSupportDialog.pkListData.resetPage();
        pKSupportDialog.requestList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void reportGroup() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        new ReportDialog(context).setListener(new PKSupportDialog$reportGroup$1(this)).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestList$lambda$7(PKSupportDialog pKSupportDialog, ApiResponse apiResponse) {
        List data;
        List list;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        pKSupportDialog.pkListData.setList((ApiList) apiResponse.getData());
        if (pKSupportDialog.pkListData.isOnePage()) {
            PKSupportAdapter mAdapter = pKSupportDialog.getMAdapter();
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
                pKSupportDialog.getMAdapter().addData(data);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestList$lambda$8(PKSupportDialog pKSupportDialog, Throwable th) {
        Intrinsics.checkNotNullParameter(th, "it");
        pKSupportDialog.pkListData.requestError();
        return Unit.INSTANCE;
    }

    public void dismiss() {
        super.dismiss();
        this.pkListData.destroy();
        this.mCompositeDisposable.d();
    }

    @Nullable
    public final GroupDetailBean getGroup() {
        return this.group;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_pk_support;
    }

    @NotNull
    public final PKSupportAdapter getMAdapter() {
        return (PKSupportAdapter) this.mAdapter.getValue();
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @NotNull
    public final BaseListData getPkListData() {
        return this.pkListData;
    }

    protected boolean isBottomStyle() {
        return true;
    }

    /* renamed from: isRed, reason: from getter */
    public final boolean getIsRed() {
        return this.isRed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        String str;
        String str2;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        if (this.isRed) {
            ((DialogPkSupportBinding) getBinding()).topImage.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.pk_support_red));
        } else {
            ((DialogPkSupportBinding) getBinding()).topImage.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.pk_support_blue));
        }
        SmartRefreshLayout smartRefreshLayout = ((DialogPkSupportBinding) getBinding()).refreshLayout;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout, "refreshLayout");
        TextView textView = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout, Status.Empty.INSTANCE, 2131362075);
        Context context = getContext();
        if (textView != null) {
            textView.setTextColor(androidx.core.content.a.getColor(context, 2131101214));
        }
        final ImageView imageView = ((DialogPkSupportBinding) getBinding()).reportButton;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.dialog.PKSupportDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    Context context2 = this.getContext();
                    Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                    BlockOrReportDialog blockOrReportDialog = new BlockOrReportDialog(context2, BlockOrReportDialog.Companion.getTextList$default(BlockOrReportDialog.INSTANCE, BlockOrReportDialog.REPORT_AND_BLOCK, false, false, false, 14, null));
                    final PKSupportDialog pKSupportDialog = this;
                    blockOrReportDialog.setMListener(new SelectInterface() { // from class: com.qiahao.nextvideo.room.dialog.PKSupportDialog$onInitialize$2$1$1
                        public void onSelect(int index) {
                            if (index == 0) {
                                PKSupportDialog.this.reportGroup();
                            } else if (index == 1) {
                                PKSupportDialog.this.showBlockTipDialog();
                            }
                        }
                    });
                    blockOrReportDialog.show();
                }
            }
        });
        SmartRefreshLayout smartRefreshLayout2 = ((DialogPkSupportBinding) getBinding()).refreshLayout;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout2, "refreshLayout");
        TextView textView2 = (TextView) StatusKtxKtKt.getStatusChildView(smartRefreshLayout2, Status.Error.INSTANCE, 2131362075);
        Context context2 = getContext();
        if (textView2 != null) {
            textView2.setTextColor(androidx.core.content.a.getColor(context2, 2131101214));
        }
        QMUIRadiusImageView qMUIRadiusImageView = ((DialogPkSupportBinding) getBinding()).avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        GroupDetailBean groupDetailBean = this.group;
        String str3 = null;
        if (groupDetailBean != null) {
            str = groupDetailBean.getFaceUrl();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        TextView textView3 = ((DialogPkSupportBinding) getBinding()).name;
        GroupDetailBean groupDetailBean2 = this.group;
        if (groupDetailBean2 != null) {
            str2 = groupDetailBean2.getName();
        } else {
            str2 = null;
        }
        textView3.setText(str2);
        TextView textView4 = ((DialogPkSupportBinding) getBinding()).f٥٤id;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        GroupDetailBean groupDetailBean3 = this.group;
        if (groupDetailBean3 != null) {
            str3 = groupDetailBean3.getCode();
        }
        String format = String.format(stringById, Arrays.copyOf(new Object[]{str3}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView4.setText(format);
        ConstraintLayout constraintLayout = ((DialogPkSupportBinding) getBinding()).constraint;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        constraintLayout.setBackground(ShapeUtil.createShape$default(shapeUtil, context3, 2131099865, 2131099855, 20, 20, 0, 0, (GradientDrawable.Orientation) null, 128, (Object) null));
        this.pkListData.registerStatusLayoutAndRefreshLayout(((DialogPkSupportBinding) getBinding()).refreshLayout, ((DialogPkSupportBinding) getBinding()).statusView);
        ((DialogPkSupportBinding) getBinding()).recyclerView.setAdapter(getMAdapter());
        ((DialogPkSupportBinding) getBinding()).refreshLayout.setOnRefreshListener(new vc.g() { // from class: com.qiahao.nextvideo.room.dialog.o1
            @Override // vc.g
            public final void onRefresh(tc.f fVar) {
                PKSupportDialog.onInitialize$lambda$5(PKSupportDialog.this, fVar);
            }
        });
        ((DialogPkSupportBinding) getBinding()).statusView.setOnRetryClickListener(new IStatusView.OnRetryClickListener() { // from class: com.qiahao.nextvideo.room.dialog.PKSupportDialog$onInitialize$5
            public void onRetry(IStatusView statusView, Status status) {
                Intrinsics.checkNotNullParameter(statusView, "statusView");
                Intrinsics.checkNotNullParameter(status, "status");
                PKSupportDialog.this.getPkListData().resetPage();
                PKSupportDialog.this.requestList();
            }
        });
        requestList();
    }

    public final void requestList() {
        String str;
        ServerApi apis = AppServer.INSTANCE.getApis();
        int nextPage = this.pkListData.nextPage();
        int pageSize = this.pkListData.getPageSize();
        GroupDetailBean groupDetailBean = this.group;
        if (groupDetailBean == null || (str = groupDetailBean.getGroupId()) == null) {
            str = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.supportRank(nextPage, pageSize, str), new Function1() { // from class: com.qiahao.nextvideo.room.dialog.l1
            public final Object invoke(Object obj) {
                Unit requestList$lambda$7;
                requestList$lambda$7 = PKSupportDialog.requestList$lambda$7(PKSupportDialog.this, (ApiResponse) obj);
                return requestList$lambda$7;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.room.dialog.m1
            public final Object invoke(Object obj) {
                Unit requestList$lambda$8;
                requestList$lambda$8 = PKSupportDialog.requestList$lambda$8(PKSupportDialog.this, (Throwable) obj);
                return requestList$lambda$8;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setPkListData(@NotNull BaseListData baseListData) {
        Intrinsics.checkNotNullParameter(baseListData, "<set-?>");
        this.pkListData = baseListData;
    }

    public final void setRed(boolean z) {
        this.isRed = z;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void showBlockTipDialog() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        new TipBlackDialog(context, (Integer) null, 2, (DefaultConstructorMarker) null).setTipContent(ResourcesKtxKt.getStringById(this, 2131952131)).setConfirmContent(ResourcesKtxKt.getStringById(this, 2131952331)).setDialogListener(new PKSupportDialog$showBlockTipDialog$1(this)).show();
    }

    public /* synthetic */ PKSupportDialog(Context context, GroupDetailBean groupDetailBean, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : groupDetailBean, (i & 4) != 0 ? false : z);
    }
}
