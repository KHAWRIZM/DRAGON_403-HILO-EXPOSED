package com.qiahao.nextvideo.ui.home;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.oudi.core.callback.SuperCallBack;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.common.BaseBindingDialog;
import com.qiahao.base_common.navigation.NavigationHelper;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.OpenScreenBean;
import com.qiahao.nextvideo.databinding.DialogDailyOperatingBinding;
import com.qiahao.nextvideo.room.StartRoomUtils;
import com.qiahao.nextvideo.utilities.FastClickOneUtils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\"\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/DailyOperatingDialog;", "Lcom/qiahao/base_common/common/BaseBindingDialog;", "Lcom/qiahao/nextvideo/databinding/DialogDailyOperatingBinding;", "Landroid/content/Context;", "context", "Lcom/qiahao/nextvideo/data/model/OpenScreenBean;", "openScreenBean", "<init>", "(Landroid/content/Context;Lcom/qiahao/nextvideo/data/model/OpenScreenBean;)V", "", "getLayoutResId", "()I", "", "onInitialize", "()V", "dismiss", "mCurrentContext", "Landroid/content/Context;", "getMCurrentContext", "()Landroid/content/Context;", "setMCurrentContext", "(Landroid/content/Context;)V", "mOpenScreenBean", "Lcom/qiahao/nextvideo/data/model/OpenScreenBean;", "getMOpenScreenBean", "()Lcom/qiahao/nextvideo/data/model/OpenScreenBean;", "setMOpenScreenBean", "(Lcom/qiahao/nextvideo/data/model/OpenScreenBean;)V", "Lnd/a;", "mCompose", "Lnd/a;", "getMCompose", "()Lnd/a;", "setMCompose", "(Lnd/a;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nDailyOperatingDialog.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DailyOperatingDialog.kt\ncom/qiahao/nextvideo/ui/home/DailyOperatingDialog\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,61:1\n61#2,9:62\n61#2,9:71\n*S KotlinDebug\n*F\n+ 1 DailyOperatingDialog.kt\ncom/qiahao/nextvideo/ui/home/DailyOperatingDialog\n*L\n39#1:62,9\n51#1:71,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DailyOperatingDialog extends BaseBindingDialog<DialogDailyOperatingBinding> {

    @NotNull
    private nd.a mCompose;

    @NotNull
    private Context mCurrentContext;

    @Nullable
    private OpenScreenBean mOpenScreenBean;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DailyOperatingDialog(@NotNull Context context, @NotNull OpenScreenBean openScreenBean) {
        super(context, R.style.CommonDialogStyle);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(openScreenBean, "openScreenBean");
        this.mCompose = new nd.a();
        this.mCurrentContext = context;
        this.mOpenScreenBean = openScreenBean;
    }

    public void dismiss() {
        this.mCompose.dispose();
        super.dismiss();
    }

    protected int getLayoutResId() {
        return R.layout.dialog_daily_operating;
    }

    @NotNull
    public final nd.a getMCompose() {
        return this.mCompose;
    }

    @NotNull
    public final Context getMCurrentContext() {
        return this.mCurrentContext;
    }

    @Nullable
    public final OpenScreenBean getMOpenScreenBean() {
        return this.mOpenScreenBean;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onInitialize() {
        String str;
        super/*com.oudi.core.component.SuperDialog*/.onInitialize();
        setCanceledOnTouchOutside(false);
        RoundedImageView roundedImageView = ((DialogDailyOperatingBinding) getBinding()).imgPic;
        Intrinsics.checkNotNullExpressionValue(roundedImageView, "imgPic");
        OpenScreenBean openScreenBean = this.mOpenScreenBean;
        if (openScreenBean != null) {
            str = openScreenBean.getBannerUrl();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(roundedImageView, ImageSizeKt.imageSize(str, UiKtxKt.toPX(300)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231930, 2131231930, (c5.g) null, 40958, (Object) null);
        final RoundedImageView roundedImageView2 = ((DialogDailyOperatingBinding) getBinding()).imgPic;
        final long j = 800;
        roundedImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.DailyOperatingDialog$onInitialize$$inlined$singleClick$default$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                String h5Url;
                String h5Url2;
                String groupId;
                String str2;
                String groupId2;
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(roundedImageView2) > j || (roundedImageView2 instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(roundedImageView2, currentTimeMillis);
                    RoundedImageView roundedImageView3 = roundedImageView2;
                    OpenScreenBean mOpenScreenBean = this.getMOpenScreenBean();
                    String str3 = "";
                    if (mOpenScreenBean != null && (groupId = mOpenScreenBean.getGroupId()) != null && groupId.length() > 0) {
                        if (FastClickOneUtils.INSTANCE.isFastClick()) {
                            StartRoomUtils startRoomUtils = StartRoomUtils.INSTANCE;
                            OpenScreenBean mOpenScreenBean2 = this.getMOpenScreenBean();
                            if (mOpenScreenBean2 == null || (groupId2 = mOpenScreenBean2.getGroupId()) == null) {
                                str2 = "";
                            } else {
                                str2 = groupId2;
                            }
                            StartRoomUtils.startRoom$default(startRoomUtils, str2, null, null, null, null, null, null, null, 0, 0, null, 0, false, 8190, null);
                            this.dismiss();
                            return;
                        }
                        return;
                    }
                    OpenScreenBean mOpenScreenBean3 = this.getMOpenScreenBean();
                    if (mOpenScreenBean3 != null && (h5Url = mOpenScreenBean3.getH5Url()) != null && h5Url.length() > 0) {
                        NavigationHelper navigationHelper = NavigationHelper.INSTANCE;
                        OpenScreenBean mOpenScreenBean4 = this.getMOpenScreenBean();
                        if (mOpenScreenBean4 != null && (h5Url2 = mOpenScreenBean4.getH5Url()) != null) {
                            str3 = h5Url2;
                        }
                        NavigationHelper.jump$default(navigationHelper, str3, (SuperCallBack) null, 2, (Object) null);
                        this.dismiss();
                    }
                }
            }
        });
        final ImageView imageView = ((DialogDailyOperatingBinding) getBinding()).dismissView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.DailyOperatingDialog$onInitialize$$inlined$singleClick$default$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                    ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                    this.dismiss();
                }
            }
        });
    }

    public final void setMCompose(@NotNull nd.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.mCompose = aVar;
    }

    public final void setMCurrentContext(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.mCurrentContext = context;
    }

    public final void setMOpenScreenBean(@Nullable OpenScreenBean openScreenBean) {
        this.mOpenScreenBean = openScreenBean;
    }
}
