package com.qiahao.base_common.wedgit.overlayView;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.model.overlay.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016¨\u0006\u000e"}, d2 = {"Lcom/qiahao/base_common/wedgit/overlayView/CommonLayer;", "Lcom/qiahao/base_common/wedgit/overlayView/BaseLayer;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "providePainter", "Lcom/qiahao/base_common/wedgit/overlayView/CommonPainter;", "withImage", "imgSrc", "", "onShow", "", "onDismiss", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CommonLayer extends BaseLayer {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonLayer(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.qiahao.base_common.wedgit.overlayView.BaseLayer
    public void onDismiss() {
    }

    @Override // com.qiahao.base_common.wedgit.overlayView.BaseLayer
    public void onShow() {
    }

    @Override // com.qiahao.base_common.wedgit.overlayView.BaseLayer, com.qiahao.base_common.wedgit.overlayView.ILayer
    @NotNull
    public BaseLayer withImage(int imgSrc) {
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(UiKtxKt.toPX(368), -2);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(layoutParams);
        imageView.setAdjustViewBounds(true);
        imageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), imgSrc));
        withView(imageView, UiKtxKt.toPX(10), 0, Location.TO_BOTTOM, Location.ALIGN_PARENT_RIGHT);
        return this;
    }

    @Override // com.qiahao.base_common.wedgit.overlayView.BaseLayer
    @NotNull
    public CommonPainter providePainter() {
        return new CommonPainter();
    }
}
