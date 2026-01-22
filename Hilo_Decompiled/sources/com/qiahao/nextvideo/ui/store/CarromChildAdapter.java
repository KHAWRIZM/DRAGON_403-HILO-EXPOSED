package com.qiahao.nextvideo.ui.store;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.data.store.StoreCarromData;
import com.qiahao.nextvideo.databinding.ItemCarromChildBinding;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0014R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/CarromChildAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/store/StoreCarromData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemCarromChildBinding;", "layout", "", "mType", "<init>", "(II)V", "getMType", "()I", "mSelectId", "", "getMSelectId", "()J", "setMSelectId", "(J)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CarromChildAdapter extends BaseQuickAdapter<StoreCarromData, BaseDataBindingHolder<ItemCarromChildBinding>> {
    private long mSelectId;
    private final int mType;

    public CarromChildAdapter(int i, int i2) {
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
    public void convert(@NotNull BaseDataBindingHolder<ItemCarromChildBinding> holder, @NotNull StoreCarromData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemCarromChildBinding");
        ItemCarromChildBinding itemCarromChildBinding = (ItemCarromChildBinding) dataBinding;
        ImageView imageView = itemCarromChildBinding.imag;
        Intrinsics.checkNotNullExpressionValue(imageView, "imag");
        ImageKtxKt.loadImage$default(imageView, ImageSizeKt.image100(item.getPicUrl()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231930, 2131231930, (c5.g) null, 40958, (Object) null);
        itemCarromChildBinding.title.setText(String.valueOf(item.getName()));
        Long id2 = item.getId();
        long j = this.mSelectId;
        if (id2 != null && id2.longValue() == j) {
            itemCarromChildBinding.bg.setBackground(ShapeUtil.createShapeStroke$default(ShapeUtil.INSTANCE, "#8829FE", 12, 1.0f, false, "#ffffff", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
        } else {
            itemCarromChildBinding.bg.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 12, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
    }
}
