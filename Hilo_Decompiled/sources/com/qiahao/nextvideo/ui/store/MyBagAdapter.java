package com.qiahao.nextvideo.ui.store;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.MyBagBean;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.databinding.ItemMyBagBinding;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u0002H\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/MyBagAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/base_common/model/MyBagBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemMyBagBinding;", "layout", "", "<init>", "(I)V", "selectData", "getSelectData", "()Lcom/qiahao/base_common/model/MyBagBean;", "setSelectData", "(Lcom/qiahao/base_common/model/MyBagBean;)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MyBagAdapter extends BaseQuickAdapter<MyBagBean, BaseDataBindingHolder<ItemMyBagBinding>> {

    @Nullable
    private MyBagBean selectData;

    public MyBagAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    @Nullable
    public final MyBagBean getSelectData() {
        return this.selectData;
    }

    public final void setSelectData(@Nullable MyBagBean myBagBean) {
        this.selectData = myBagBean;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemMyBagBinding> holder, @NotNull MyBagBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemMyBagBinding");
        ItemMyBagBinding itemMyBagBinding = (ItemMyBagBinding) dataBinding;
        ImageView imageView = itemMyBagBinding.picGoods;
        Intrinsics.checkNotNullExpressionValue(imageView, "picGoods");
        ImageKtxKt.loadImage$default(imageView, item.getPicUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231930, 2131231930, (c5.g) null, 40958, (Object) null);
        MyBagBean myBagBean = this.selectData;
        if (myBagBean != null && myBagBean.getId() == item.getId()) {
            itemMyBagBinding.backContent.setBackground(ShapeUtil.createShapeStroke$default(ShapeUtil.INSTANCE, "#8829FE", 12, 1.0f, false, "#ffffff", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
        } else {
            itemMyBagBinding.backContent.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 12, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        if (item.getUsing()) {
            itemMyBagBinding.isUsing.setVisibility(0);
        } else {
            itemMyBagBinding.isUsing.setVisibility(8);
        }
        itemMyBagBinding.textTime.setText(DateTimeUtilityKt.timeQuantumFormat(item.getTimeLeft()));
    }
}
