package com.qiahao.nextvideo.ui.peopleCertification;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.network.interceptors.HiloException;
import com.qiahao.base_common.network.model.ApiResponse;
import com.qiahao.base_common.path.AppController;
import com.qiahao.base_common.support.AppService;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.RxUtilsKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.model.PurchaseFeeDetailsX;
import com.qiahao.nextvideo.data.model.SuperLikeConfiguration;
import com.qiahao.nextvideo.data.model.SuperLikeData;
import com.qiahao.nextvideo.data.service.PurchaseService;
import com.qiahao.nextvideo.databinding.DialogSuperLikeBinding;
import com.qiahao.nextvideo.network.AppServer;
import com.qiahao.nextvideo.network.ServerApi;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\u000e\u001a\u00020\rH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lcom/qiahao/nextvideo/ui/peopleCertification/SuperLikeDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogSuperLikeBinding;", "Landroid/content/Context;", "context", "Lcom/qiahao/nextvideo/data/model/SuperLikeData;", "data", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/model/SuperLikeData;)V", "", "initView", "()V", "callLike", "", "getLayoutResId", "()I", "", "isNeedFullScreen", "()Z", "onInitialize", "dismiss", "Lcom/qiahao/nextvideo/data/model/SuperLikeData;", "getData", "()Lcom/qiahao/nextvideo/data/model/SuperLikeData;", "Lkotlin/Function0;", "mListener", "Lkotlin/jvm/functions/Function0;", "getMListener", "()Lkotlin/jvm/functions/Function0;", "setMListener", "(Lkotlin/jvm/functions/Function0;)V", "Lnd/a;", "mCompositeDisposable", "Lnd/a;", "getMCompositeDisposable", "()Lnd/a;", "setMCompositeDisposable", "(Lnd/a;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSuperLikeDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SuperLikeDialog.kt\ncom/qiahao/nextvideo/ui/peopleCertification/SuperLikeDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,90:1\n61#2,9:91\n61#2,9:100\n*S KotlinDebug\n*F\n+ 1 SuperLikeDialog.kt\ncom/qiahao/nextvideo/ui/peopleCertification/SuperLikeDialog\n*L\n48#1:91,9\n54#1:100,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SuperLikeDialog extends BaseBindingDialog<DialogSuperLikeBinding> {

    @NotNull
    private final SuperLikeData data;

    @NotNull
    private nd.a mCompositeDisposable;

    @Nullable
    private Function0<Unit> mListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuperLikeDialog(@NotNull Context context, @NotNull SuperLikeData superLikeData) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(superLikeData, "data");
        this.data = superLikeData;
        this.mCompositeDisposable = new nd.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void callLike() {
        Number number;
        SuperLikeConfiguration superLike;
        Integer gold;
        User user = UserStore.INSTANCE.getShared().getUser();
        int i = 0;
        if (user == null || (number = user.getPinkDiamondNum()) == null) {
            number = 0;
        }
        long longValue = number.longValue();
        PurchaseFeeDetailsX purchaseFeeDetail = PurchaseService.INSTANCE.getShared().getPurchaseFeeDetail();
        if (purchaseFeeDetail != null && (superLike = purchaseFeeDetail.getSuperLike()) != null && (gold = superLike.getGold()) != null) {
            i = gold.intValue();
        }
        if (longValue < i) {
            AppService service = AppController.INSTANCE.getService();
            if (service != null) {
                service.openGemStore();
                return;
            }
            return;
        }
        ServerApi apis = AppServer.INSTANCE.getApis();
        String externalId = this.data.getExternalId();
        if (externalId == null) {
            externalId = "";
        }
        RxUtilsKt.addTo(RxUtilsKt.observeOnMainThread$default(apis.superLike(externalId), new Function1() { // from class: com.qiahao.nextvideo.ui.peopleCertification.l
            public final Object invoke(Object obj) {
                Unit callLike$lambda$2;
                callLike$lambda$2 = SuperLikeDialog.callLike$lambda$2(SuperLikeDialog.this, (ApiResponse) obj);
                return callLike$lambda$2;
            }
        }, new Function1() { // from class: com.qiahao.nextvideo.ui.peopleCertification.m
            public final Object invoke(Object obj) {
                Unit callLike$lambda$3;
                callLike$lambda$3 = SuperLikeDialog.callLike$lambda$3(SuperLikeDialog.this, (Throwable) obj);
                return callLike$lambda$3;
            }
        }, (Function0) null, false, 12, (Object) null), this.mCompositeDisposable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit callLike$lambda$2(SuperLikeDialog superLikeDialog, ApiResponse apiResponse) {
        double d;
        Intrinsics.checkNotNullParameter(apiResponse, "it");
        UserStore shared = UserStore.INSTANCE.getShared();
        Double d2 = (Double) apiResponse.getData();
        if (d2 != null) {
            d = d2.doubleValue();
        } else {
            d = 0.0d;
        }
        UserStore.refreshDiamondOrGem$default(shared, 0.0d, d, 1, null);
        Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, superLikeDialog.getContext(), ResourcesKtxKt.getStringById(superLikeDialog, 2131954177), false, 4, (Object) null);
        if (normal$default != null) {
            normal$default.show();
        }
        Function0<Unit> function0 = superLikeDialog.mListener;
        if (function0 != null) {
            function0.invoke();
        }
        superLikeDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit callLike$lambda$3(SuperLikeDialog superLikeDialog, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(th, "it");
        if (th instanceof HiloException) {
            HiloToasty.Companion companion = HiloToasty.Companion;
            Context context = superLikeDialog.getContext();
            String errorMessage = ((HiloException) th).getErrorMessage();
            if (errorMessage == null) {
                str = ResourcesKtxKt.getStringById(superLikeDialog, 2131952667);
            } else {
                str = errorMessage;
            }
            Toast normal$default = HiloToasty.Companion.normal$default(companion, context, str, false, 4, (Object) null);
            if (normal$default != null) {
                normal$default.show();
            }
        }
        return Unit.INSTANCE;
    }

    private final void initView() {
        int i;
        SuperLikeConfiguration superLike;
        Integer originalGold;
        SuperLikeConfiguration superLike2;
        Integer gold;
        ((DialogSuperLikeBinding) getBinding()).sendBtn.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#FEC429", "#FD0592", 30, (GradientDrawable.Orientation) null, 8, (Object) null));
        final ImageView imageView = ((DialogSuperLikeBinding) getBinding()).close;
        final long j = 800;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.peopleCertification.SuperLikeDialog$initView$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
        QMUIRadiusImageView qMUIRadiusImageView = ((DialogSuperLikeBinding) getBinding()).avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, this.data.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        TextView textView = ((DialogSuperLikeBinding) getBinding()).diamondOne;
        PurchaseService.Companion companion = PurchaseService.INSTANCE;
        PurchaseFeeDetailsX purchaseFeeDetail = companion.getShared().getPurchaseFeeDetail();
        int i2 = 0;
        if (purchaseFeeDetail != null && (superLike2 = purchaseFeeDetail.getSuperLike()) != null && (gold = superLike2.getGold()) != null) {
            i = gold.intValue();
        } else {
            i = 0;
        }
        textView.setText(String.valueOf(i));
        TextView textView2 = ((DialogSuperLikeBinding) getBinding()).diamondTwo;
        PurchaseFeeDetailsX purchaseFeeDetail2 = companion.getShared().getPurchaseFeeDetail();
        if (purchaseFeeDetail2 != null && (superLike = purchaseFeeDetail2.getSuperLike()) != null && (originalGold = superLike.getOriginalGold()) != null) {
            i2 = originalGold.intValue();
        }
        textView2.setText(String.valueOf(i2));
        final ConstraintLayout constraintLayout = ((DialogSuperLikeBinding) getBinding()).sendBtn;
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.peopleCertification.SuperLikeDialog$initView$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(constraintLayout) > j || (constraintLayout instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(constraintLayout, currentTimeMillis);
                    ConstraintLayout constraintLayout2 = constraintLayout;
                    this.callLike();
                }
            }
        });
        setBackgroundDimAmount(0.8f);
    }

    public void dismiss() {
        super.dismiss();
        this.mCompositeDisposable.d();
    }

    @NotNull
    public final SuperLikeData getData() {
        return this.data;
    }

    protected int getLayoutResId() {
        return R.layout.dialog_super_like;
    }

    @NotNull
    public final nd.a getMCompositeDisposable() {
        return this.mCompositeDisposable;
    }

    @Nullable
    public final Function0<Unit> getMListener() {
        return this.mListener;
    }

    protected boolean isNeedFullScreen() {
        return true;
    }

    public void onInitialize() {
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        initView();
    }

    public final void setMCompositeDisposable(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompositeDisposable = aVar;
    }

    public final void setMListener(@Nullable Function0<Unit> function0) {
        this.mListener = function0;
    }
}
