package com.qiahao.nextvideo.ui.purchase;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemDiamondPurchaseBinding;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/purchase/WalletDiamondAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/ui/purchase/DiamondCellUIModel;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemDiamondPurchaseBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WalletDiamondAdapter extends BaseQuickAdapter<DiamondCellUIModel, BaseDataBindingHolder<ItemDiamondPurchaseBinding>> {
    public WalletDiamondAdapter() {
        super(R.layout.item_diamond_purchase, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemDiamondPurchaseBinding> holder, @NotNull DiamondCellUIModel item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemDiamondPurchaseBinding");
        ItemDiamondPurchaseBinding itemDiamondPurchaseBinding = (ItemDiamondPurchaseBinding) dataBinding;
        AppCompatImageView appCompatImageView = itemDiamondPurchaseBinding.diamondImg;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "diamondImg");
        ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, Integer.valueOf(item.getDiamondImageRes()), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
        itemDiamondPurchaseBinding.diamondPriceText.setText(item.getPrice());
        itemDiamondPurchaseBinding.diamondText.setText(item.getDescription());
        LinearLayout linearLayout = itemDiamondPurchaseBinding.linearLayout;
        Integer extraAmount = item.getExtraAmount();
        linearLayout.setVisibility((extraAmount != null ? extraAmount.intValue() : 0) <= 0 ? 8 : 0);
        itemDiamondPurchaseBinding.diamond.setText("+" + item.getExtraAmount());
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            itemDiamondPurchaseBinding.linearLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, getContext(), 2131099949, 2131099941, 10, 0, 10, 0, (GradientDrawable.Orientation) null, 128, (Object) null));
        } else {
            itemDiamondPurchaseBinding.linearLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, getContext(), 2131099949, 2131099941, 0, 10, 0, 10, (GradientDrawable.Orientation) null, 128, (Object) null));
        }
    }
}
