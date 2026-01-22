package com.qiahao.nextvideo.ui.rank;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.github.siyamed.shapeimageview.mask.PorterShapeImageView;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupPowerWeekBean;
import com.qiahao.nextvideo.databinding.ItemPowerRankBinding;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/PowerRankAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/GroupPowerWeekBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemPowerRankBinding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PowerRankAdapter extends BaseQuickAdapter<GroupPowerWeekBean, BaseDataBindingHolder<ItemPowerRankBinding>> {
    public PowerRankAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemPowerRankBinding> holder, @NotNull GroupPowerWeekBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemPowerRankBinding");
        ItemPowerRankBinding itemPowerRankBinding = (ItemPowerRankBinding) dataBinding;
        itemPowerRankBinding.top1AllView.setVisibility(8);
        itemPowerRankBinding.top2AllView.setVisibility(8);
        itemPowerRankBinding.top3AllView.setVisibility(8);
        int adapterPosition = holder.getAdapterPosition();
        if (adapterPosition == 0) {
            ImageView imageView = itemPowerRankBinding.userAvatarIrregularViewBg;
            Intrinsics.checkNotNullExpressionValue(imageView, "userAvatarIrregularViewBg");
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_power_rank_1_bg), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        } else if (adapterPosition == 1) {
            ImageView imageView2 = itemPowerRankBinding.userAvatarIrregularViewBg;
            Intrinsics.checkNotNullExpressionValue(imageView2, "userAvatarIrregularViewBg");
            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_power_rank_2_bg), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        } else if (adapterPosition != 2) {
            itemPowerRankBinding.listPosition.setTextColor(Color.parseColor("#999999"));
            itemPowerRankBinding.roomName.setTextColor(Color.parseColor("#333333"));
            ImageView imageView3 = itemPowerRankBinding.userAvatarIrregularViewBg;
            Intrinsics.checkNotNullExpressionValue(imageView3, "userAvatarIrregularViewBg");
            ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_power_rank_4_bg), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        } else {
            ImageView imageView4 = itemPowerRankBinding.userAvatarIrregularViewBg;
            Intrinsics.checkNotNullExpressionValue(imageView4, "userAvatarIrregularViewBg");
            ImageKtxKt.loadImage$default(imageView4, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_power_rank_3_bg), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        }
        itemPowerRankBinding.listPosition.setText(String.valueOf(holder.getAdapterPosition() + 1));
        itemPowerRankBinding.roomName.setText(item.getName());
        PorterShapeImageView porterShapeImageView = itemPowerRankBinding.userAvatarIrregularView;
        Intrinsics.checkNotNullExpressionValue(porterShapeImageView, "userAvatarIrregularView");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        String faceUrl = item.getFaceUrl();
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(40));
        fill.setHeight(dimens.dpToPx(40));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind(porterShapeImageView, companion.displayImage(faceUrl, fill));
        itemPowerRankBinding.diamond.setText("***");
        itemPowerRankBinding.numberMember.setText(String.valueOf(item.getUserN()));
    }
}
