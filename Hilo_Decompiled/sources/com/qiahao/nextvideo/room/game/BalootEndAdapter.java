package com.qiahao.nextvideo.room.game;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.game.SUDGamePlayerAward;
import com.qiahao.nextvideo.databinding.ItemLudoWinBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/game/BalootEndAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/game/SUDGamePlayerAward;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemLudoWinBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class BalootEndAdapter extends BaseQuickAdapter<SUDGamePlayerAward, BaseDataBindingHolder<ItemLudoWinBinding>> {
    public BalootEndAdapter() {
        super(R.layout.item_ludo_win, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemLudoWinBinding> holder, @NotNull SUDGamePlayerAward item) {
        ImageView imageView;
        ImageView imageView2;
        TextView textView;
        TextView textView2;
        ImageView imageView3;
        TextView textView3;
        TextView textView4;
        QMUIRadiusImageView qMUIRadiusImageView;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ItemLudoWinBinding itemLudoWinBinding;
        ImageView imageView8;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int rank = item.getRank();
        if (rank == 1) {
            ItemLudoWinBinding itemLudoWinBinding2 = (ItemLudoWinBinding) holder.getDataBinding();
            if (itemLudoWinBinding2 != null && (imageView = itemLudoWinBinding2.rankImage) != null) {
                imageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_one));
            }
        } else if (rank == 2) {
            ItemLudoWinBinding itemLudoWinBinding3 = (ItemLudoWinBinding) holder.getDataBinding();
            if (itemLudoWinBinding3 != null && (imageView6 = itemLudoWinBinding3.rankImage) != null) {
                imageView6.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_two));
            }
        } else if (rank == 3) {
            ItemLudoWinBinding itemLudoWinBinding4 = (ItemLudoWinBinding) holder.getDataBinding();
            if (itemLudoWinBinding4 != null && (imageView7 = itemLudoWinBinding4.rankImage) != null) {
                imageView7.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_three));
            }
        } else if (rank == 4 && (itemLudoWinBinding = (ItemLudoWinBinding) holder.getDataBinding()) != null && (imageView8 = itemLudoWinBinding.rankImage) != null) {
            imageView8.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_four));
        }
        ItemLudoWinBinding itemLudoWinBinding5 = (ItemLudoWinBinding) holder.getDataBinding();
        if (itemLudoWinBinding5 != null && (imageView5 = itemLudoWinBinding5.bg) != null) {
            imageView5.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), Intrinsics.areEqual(item.isWin(), Boolean.TRUE) ? R.drawable.ludo_end_win_bg : R.drawable.ludo_end_lose_bg));
        }
        ItemLudoWinBinding itemLudoWinBinding6 = (ItemLudoWinBinding) holder.getDataBinding();
        if (itemLudoWinBinding6 != null && (imageView4 = itemLudoWinBinding6.avatarBorder) != null) {
            imageView4.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), Intrinsics.areEqual(item.isWin(), Boolean.TRUE) ? R.drawable.ludo_end_win : R.drawable.ludo_end_lose));
        }
        ItemLudoWinBinding itemLudoWinBinding7 = (ItemLudoWinBinding) holder.getDataBinding();
        if (itemLudoWinBinding7 != null && (qMUIRadiusImageView = itemLudoWinBinding7.avatar) != null) {
            User userTiny = item.getUserTiny();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, userTiny != null ? userTiny.getAvatar() : null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
        }
        ItemLudoWinBinding itemLudoWinBinding8 = (ItemLudoWinBinding) holder.getDataBinding();
        if (itemLudoWinBinding8 != null && (textView4 = itemLudoWinBinding8.nickName) != null) {
            User userTiny2 = item.getUserTiny();
            textView4.setText(userTiny2 != null ? userTiny2.getNick() : null);
        }
        if (item.getDiamond() > 0) {
            ItemLudoWinBinding itemLudoWinBinding9 = (ItemLudoWinBinding) holder.getDataBinding();
            if (itemLudoWinBinding9 != null && (textView3 = itemLudoWinBinding9.diamond) != null) {
                textView3.setVisibility(0);
            }
            ItemLudoWinBinding itemLudoWinBinding10 = (ItemLudoWinBinding) holder.getDataBinding();
            if (itemLudoWinBinding10 != null && (imageView3 = itemLudoWinBinding10.diamondImage) != null) {
                imageView3.setVisibility(0);
            }
            ItemLudoWinBinding itemLudoWinBinding11 = (ItemLudoWinBinding) holder.getDataBinding();
            if (itemLudoWinBinding11 == null || (textView2 = itemLudoWinBinding11.diamond) == null) {
                return;
            }
            textView2.setText("+" + item.getDiamond());
            return;
        }
        ItemLudoWinBinding itemLudoWinBinding12 = (ItemLudoWinBinding) holder.getDataBinding();
        if (itemLudoWinBinding12 != null && (textView = itemLudoWinBinding12.diamond) != null) {
            textView.setVisibility(8);
        }
        ItemLudoWinBinding itemLudoWinBinding13 = (ItemLudoWinBinding) holder.getDataBinding();
        if (itemLudoWinBinding13 == null || (imageView2 = itemLudoWinBinding13.diamondImage) == null) {
            return;
        }
        imageView2.setVisibility(8);
    }
}
