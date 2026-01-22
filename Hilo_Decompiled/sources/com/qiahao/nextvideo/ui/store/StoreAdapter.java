package com.qiahao.nextvideo.ui.store;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.StoreBean;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.databinding.ItemStoreBinding;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0014R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/StoreAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/base_common/model/StoreBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemStoreBinding;", "layout", "", "mType", "<init>", "(II)V", "getMType", "()I", "mSelectId", "", "getMSelectId", "()J", "setMSelectId", "(J)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class StoreAdapter extends BaseQuickAdapter<StoreBean, BaseDataBindingHolder<ItemStoreBinding>> {
    private long mSelectId;
    private final int mType;

    public StoreAdapter(int i, int i2) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        this.mType = i2;
    }

    public final long getMSelectId() {
        return this.mSelectId;
    }

    public final int getMType() {
        return this.mType;
    }

    public final void setMSelectId(long j) {
        this.mSelectId = j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemStoreBinding> holder, @NotNull StoreBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemStoreBinding");
        ItemStoreBinding itemStoreBinding = (ItemStoreBinding) dataBinding;
        int i = this.mType;
        if (i == 0) {
            ImageView imageView = itemStoreBinding.imagMounts;
            Intrinsics.checkNotNullExpressionValue(imageView, "imagMounts");
            ImageKtxKt.loadImage$default(imageView, item.getPicUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231930, (c5.g) null, 49150, (Object) null);
            itemStoreBinding.playIcon.setVisibility(8);
        } else if (i == 1) {
            ImageView imageView2 = itemStoreBinding.imagMounts;
            Intrinsics.checkNotNullExpressionValue(imageView2, "imagMounts");
            ImageKtxKt.loadImage$default(imageView2, item.getPicUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231930, (c5.g) null, 49150, (Object) null);
            String effectUrl = item.getEffectUrl();
            if (effectUrl != null && effectUrl.length() == 0) {
                itemStoreBinding.playIcon.setVisibility(8);
            } else {
                itemStoreBinding.playIcon.setVisibility(0);
            }
        } else if (i == 3) {
            ImageView imageView3 = itemStoreBinding.imagMounts;
            Intrinsics.checkNotNullExpressionValue(imageView3, "imagMounts");
            ImageKtxKt.loadImage$default(imageView3, item.getPicUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231930, (c5.g) null, 49150, (Object) null);
            itemStoreBinding.playIcon.setVisibility(8);
        }
        itemStoreBinding.diamond.setText(String.valueOf(item.getDiamondNum()));
        Long id2 = item.getId();
        long j = this.mSelectId;
        if (id2 != null && id2.longValue() == j) {
            itemStoreBinding.backContent.setBackground(ShapeUtil.createShapeStroke$default(ShapeUtil.INSTANCE, "#8829FE", 12, 1.0f, false, "#ffffff", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
        } else {
            itemStoreBinding.backContent.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 12, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
    }
}
