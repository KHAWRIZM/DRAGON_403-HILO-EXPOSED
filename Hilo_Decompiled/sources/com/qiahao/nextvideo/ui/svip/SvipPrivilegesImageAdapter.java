package com.qiahao.nextvideo.ui.svip;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.svip.SvipCardDetails;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemPrivilegesImageBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/svip/SvipPrivilegesImageAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/base_common/model/svip/SvipCardDetails;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemPrivilegesImageBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SvipPrivilegesImageAdapter extends BaseQuickAdapter<SvipCardDetails, BaseDataBindingHolder<ItemPrivilegesImageBinding>> {
    public SvipPrivilegesImageAdapter() {
        super(R.layout.item_privileges_image, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(ItemPrivilegesImageBinding itemPrivilegesImageBinding, SvipCardDetails svipCardDetails) {
        ConstraintLayout.b layoutParams = itemPrivilegesImageBinding.image.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).height = (itemPrivilegesImageBinding.image.getWidth() * svipCardDetails.getCardHeight()) / svipCardDetails.getCardWidth();
        itemPrivilegesImageBinding.image.setLayoutParams(bVar);
        QMUIRadiusImageView qMUIRadiusImageView = itemPrivilegesImageBinding.image;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "image");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, svipCardDetails.getCardUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemPrivilegesImageBinding> holder, @NotNull final SvipCardDetails item) {
        QMUIRadiusImageView qMUIRadiusImageView;
        QMUIRadiusImageView qMUIRadiusImageView2;
        QMUIRadiusImageView qMUIRadiusImageView3;
        TextView textView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        final ItemPrivilegesImageBinding itemPrivilegesImageBinding = (ItemPrivilegesImageBinding) holder.getDataBinding();
        if (itemPrivilegesImageBinding != null && (textView = itemPrivilegesImageBinding.title) != null) {
            String description = item.getDescription();
            if (description == null) {
                description = "";
            }
            textView.setText(description);
        }
        if (TextUtils.isEmpty(item.getCardUrl())) {
            if (itemPrivilegesImageBinding == null || (qMUIRadiusImageView = itemPrivilegesImageBinding.image) == null) {
                return;
            }
            qMUIRadiusImageView.setVisibility(8);
            return;
        }
        if (itemPrivilegesImageBinding != null && (qMUIRadiusImageView3 = itemPrivilegesImageBinding.image) != null) {
            qMUIRadiusImageView3.setVisibility(0);
        }
        if (itemPrivilegesImageBinding == null || (qMUIRadiusImageView2 = itemPrivilegesImageBinding.image) == null) {
            return;
        }
        qMUIRadiusImageView2.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.svip.g0
            @Override // java.lang.Runnable
            public final void run() {
                SvipPrivilegesImageAdapter.convert$lambda$0(ItemPrivilegesImageBinding.this, item);
            }
        });
    }
}
