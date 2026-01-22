package com.qiahao.nextvideo.ui.store;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.data.store.BagCarromData;
import com.qiahao.nextvideo.databinding.ItemCarromBagChildBinding;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/ui/store/CarromBagChildAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/store/BagCarromData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemCarromBagChildBinding;", "layout", "", "<init>", "(I)V", "mSelectId", "", "getMSelectId", "()Ljava/lang/String;", "setMSelectId", "(Ljava/lang/String;)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CarromBagChildAdapter extends BaseQuickAdapter<BagCarromData, BaseDataBindingHolder<ItemCarromBagChildBinding>> {

    @NotNull
    private String mSelectId;

    public CarromBagChildAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        this.mSelectId = "";
    }

    @NotNull
    public final String getMSelectId() {
        return this.mSelectId;
    }

    public final void setMSelectId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mSelectId = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemCarromBagChildBinding> holder, @NotNull BagCarromData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemCarromBagChildBinding");
        ItemCarromBagChildBinding itemCarromBagChildBinding = (ItemCarromBagChildBinding) dataBinding;
        ImageView imageView = itemCarromBagChildBinding.imag;
        Intrinsics.checkNotNullExpressionValue(imageView, "imag");
        ImageKtxKt.loadImage$default(imageView, ImageSizeKt.image100(item.getPicUrl()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231930, 2131231930, (c5.g) null, 40958, (Object) null);
        Long timeLeft = item.getTimeLeft();
        if ((timeLeft != null ? timeLeft.longValue() : 0L) > 0) {
            TextView textView = itemCarromBagChildBinding.title;
            Long timeLeft2 = item.getTimeLeft();
            textView.setText(DateTimeUtilityKt.timeQuantumFormat(timeLeft2 != null ? timeLeft2.longValue() : 0L));
            itemCarromBagChildBinding.timeIcon.setVisibility(0);
        } else {
            itemCarromBagChildBinding.title.setText(String.valueOf(item.getName()));
            itemCarromBagChildBinding.timeIcon.setVisibility(8);
        }
        if (Intrinsics.areEqual(item.bagAndResId(), this.mSelectId)) {
            itemCarromBagChildBinding.backContent.setBackground(ShapeUtil.createShapeStroke$default(ShapeUtil.INSTANCE, "#8829FE", 12, 1.0f, false, "#ffffff", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
        } else {
            itemCarromBagChildBinding.backContent.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 12, (GradientDrawable.Orientation) null, 8, (Object) null));
        }
        itemCarromBagChildBinding.isUsing.setVisibility(Intrinsics.areEqual(item.getUsing(), Boolean.TRUE) ? 0 : 8);
    }
}
