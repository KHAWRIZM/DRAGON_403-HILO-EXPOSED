package com.qiahao.nextvideo.room.luckyfruit;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.LuckyFruitRankBean;
import com.qiahao.nextvideo.databinding.ItemGroupLuckyBoxRankingBinding;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/room/luckyfruit/LuckyFruitRankingAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/LuckyFruitRankBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGroupLuckyBoxRankingBinding;", "layoutResId", "", "<init>", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyFruitRankingAdapter extends BaseQuickAdapter<LuckyFruitRankBean, BaseDataBindingHolder<ItemGroupLuckyBoxRankingBinding>> {
    public LuckyFruitRankingAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGroupLuckyBoxRankingBinding> holder, @NotNull LuckyFruitRankBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupLuckyBoxRankingBinding");
        ItemGroupLuckyBoxRankingBinding itemGroupLuckyBoxRankingBinding = (ItemGroupLuckyBoxRankingBinding) dataBinding;
        int adapterPosition = holder.getAdapterPosition();
        if (adapterPosition == 0) {
            itemGroupLuckyBoxRankingBinding.topPositionImageView.setVisibility(0);
            itemGroupLuckyBoxRankingBinding.topPositionText.setVisibility(8);
            ImageView imageView = itemGroupLuckyBoxRankingBinding.topPositionImageView;
            Intrinsics.checkNotNullExpressionValue(imageView, "topPositionImageView");
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_fruit_rank_top1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            CircleImageView circleImageView = itemGroupLuckyBoxRankingBinding.circleAvatar;
            circleImageView.setBorderColor(Color.parseColor("#ffdd21"));
            circleImageView.setBorderWidth(Dimens.INSTANCE.dpToPx(1));
        } else if (adapterPosition == 1) {
            itemGroupLuckyBoxRankingBinding.topPositionImageView.setVisibility(0);
            itemGroupLuckyBoxRankingBinding.topPositionText.setVisibility(8);
            ImageView imageView2 = itemGroupLuckyBoxRankingBinding.topPositionImageView;
            Intrinsics.checkNotNullExpressionValue(imageView2, "topPositionImageView");
            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_fruit_rank_top2), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            CircleImageView circleImageView2 = itemGroupLuckyBoxRankingBinding.circleAvatar;
            circleImageView2.setBorderColor(Color.parseColor("#d0f7ff"));
            circleImageView2.setBorderWidth(Dimens.INSTANCE.dpToPx(1));
        } else if (adapterPosition != 2) {
            itemGroupLuckyBoxRankingBinding.topPositionImageView.setVisibility(8);
            itemGroupLuckyBoxRankingBinding.topPositionText.setVisibility(0);
            itemGroupLuckyBoxRankingBinding.topPositionText.setText(String.valueOf(holder.getAdapterPosition() + 1));
            itemGroupLuckyBoxRankingBinding.circleAvatar.setBorderWidth(Dimens.INSTANCE.dpToPx(0));
        } else {
            itemGroupLuckyBoxRankingBinding.topPositionImageView.setVisibility(0);
            itemGroupLuckyBoxRankingBinding.topPositionText.setVisibility(8);
            ImageView imageView3 = itemGroupLuckyBoxRankingBinding.topPositionImageView;
            Intrinsics.checkNotNullExpressionValue(imageView3, "topPositionImageView");
            ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_fruit_rank_top3), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            CircleImageView circleImageView3 = itemGroupLuckyBoxRankingBinding.circleAvatar;
            circleImageView3.setBorderColor(Color.parseColor("#ffa657"));
            circleImageView3.setBorderWidth(Dimens.INSTANCE.dpToPx(1));
        }
        CircleImageView circleImageView4 = itemGroupLuckyBoxRankingBinding.circleAvatar;
        Intrinsics.checkNotNullExpressionValue(circleImageView4, "circleAvatar");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        String avatar = item.getUser().getAvatar();
        if (avatar == null) {
            avatar = "";
        }
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(39));
        fill.setHeight(dimens.dpToPx(39));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind$default(circleImageView4, companion.displayUserAvatarImage(avatar, fill), null, 2, null);
        TextView textView = itemGroupLuckyBoxRankingBinding.nickName;
        String name = item.getUser().getName();
        if (name == null) {
            name = "";
        }
        textView.setText(name);
        TextView textView2 = itemGroupLuckyBoxRankingBinding.f٦٣id;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        String code = item.getUser().getCode();
        String format = String.format(stringById, Arrays.copyOf(new Object[]{code != null ? code : ""}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView2.setText(format);
    }
}
