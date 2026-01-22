package com.qiahao.nextvideo.ui.firstCharge;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.firstCharge.FirstChargeAward;
import com.qiahao.nextvideo.data.model.GiftDateItem;
import com.qiahao.nextvideo.databinding.ItemFirstChargeBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/firstCharge/FirstChargeAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/firstCharge/FirstChargeAward;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemFirstChargeBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FirstChargeAdapter extends BaseQuickAdapter<FirstChargeAward, BaseDataBindingHolder<ItemFirstChargeBinding>> {
    public FirstChargeAdapter() {
        super(R.layout.item_first_charge, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemFirstChargeBinding> holder, @NotNull FirstChargeAward item) {
        Integer type;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemFirstChargeBinding");
        ItemFirstChargeBinding itemFirstChargeBinding = (ItemFirstChargeBinding) dataBinding;
        View view = itemFirstChargeBinding.bg;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        view.setBackground(ShapeUtil.createShapeStroke$default(shapeUtil, "#E7B3B3", 12, 1.0f, false, (String) null, (String) null, (GradientDrawable.Orientation) null, 120, (Object) null));
        ImageView imageView = itemFirstChargeBinding.gift;
        Intrinsics.checkNotNullExpressionValue(imageView, GiftDateItem.TYPE_GIFT);
        ImageKtxKt.loadImage$default(imageView, item.getPicUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231930, 2131231930, (g) null, 40958, (Object) null);
        TextView textView = itemFirstChargeBinding.day;
        Integer duration = item.getDuration();
        textView.setVisibility((duration != null ? duration.intValue() : 0) > 0 ? 0 : 8);
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            itemFirstChargeBinding.day.setBackground(ShapeUtil.createShape$default(shapeUtil, "#FF6F6F", "#F61EE4", 8, 0, 8, 0, (GradientDrawable.Orientation) null, 64, (Object) null));
        } else {
            itemFirstChargeBinding.day.setBackground(ShapeUtil.createShape$default(shapeUtil, "#FF6F6F", "#F61EE4", 0, 8, 0, 8, (GradientDrawable.Orientation) null, 64, (Object) null));
        }
        ConstraintLayout.b layoutParams = itemFirstChargeBinding.gift.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        Integer type2 = item.getType();
        if (type2 != null && type2.intValue() == 6) {
            ((ViewGroup.MarginLayoutParams) bVar).width = -1;
            ((ViewGroup.MarginLayoutParams) bVar).height = 0;
            bVar.I = "H,82:44";
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = UiKtxKt.toPX(12);
            itemFirstChargeBinding.gift.setLayoutParams(bVar);
        } else {
            ((ViewGroup.MarginLayoutParams) bVar).width = UiKtxKt.toPX(56);
            ((ViewGroup.MarginLayoutParams) bVar).height = UiKtxKt.toPX(56);
            bVar.I = "H,1:1";
            ((ViewGroup.MarginLayoutParams) bVar).topMargin = UiKtxKt.toPX(6);
            itemFirstChargeBinding.gift.setLayoutParams(bVar);
        }
        Integer type3 = item.getType();
        if ((type3 == null || type3.intValue() != 5) && ((type = item.getType()) == null || type.intValue() != 6)) {
            TextView textView2 = itemFirstChargeBinding.diamond;
            Long diamond = item.getDiamond();
            textView2.setText(NumberUtilsKt.rankNumberFormat(diamond != null ? diamond.longValue() : 0L));
            itemFirstChargeBinding.image.setVisibility(0);
        } else {
            itemFirstChargeBinding.diamond.setText(item.getName());
            itemFirstChargeBinding.image.setVisibility(8);
        }
        TextView textView3 = itemFirstChargeBinding.day;
        Integer duration2 = item.getDuration();
        String num = duration2 != null ? duration2.toString() : null;
        textView3.setText(num + ResourcesKtxKt.getStringById(this, 2131952501));
    }
}
