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
import com.qiahao.nextvideo.databinding.ItemUnoWinBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/game/UnoEndAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/game/SUDGamePlayerAward;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemUnoWinBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UnoEndAdapter extends BaseQuickAdapter<SUDGamePlayerAward, BaseDataBindingHolder<ItemUnoWinBinding>> {
    public UnoEndAdapter() {
        super(R.layout.item_uno_win, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemUnoWinBinding> holder, @NotNull SUDGamePlayerAward item) {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        ImageView imageView2;
        TextView textView3;
        TextView textView4;
        QMUIRadiusImageView qMUIRadiusImageView;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        ImageView imageView9;
        ImageView imageView10;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        switch (item.getRank()) {
            case 1:
                ItemUnoWinBinding itemUnoWinBinding = (ItemUnoWinBinding) holder.getDataBinding();
                if (itemUnoWinBinding != null && (imageView5 = itemUnoWinBinding.rankImage) != null) {
                    imageView5.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_one));
                    break;
                }
                break;
            case 2:
                ItemUnoWinBinding itemUnoWinBinding2 = (ItemUnoWinBinding) holder.getDataBinding();
                if (itemUnoWinBinding2 != null && (imageView6 = itemUnoWinBinding2.rankImage) != null) {
                    imageView6.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_two_default));
                    break;
                }
                break;
            case 3:
                ItemUnoWinBinding itemUnoWinBinding3 = (ItemUnoWinBinding) holder.getDataBinding();
                if (itemUnoWinBinding3 != null && (imageView7 = itemUnoWinBinding3.rankImage) != null) {
                    imageView7.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_three));
                    break;
                }
                break;
            case 4:
                ItemUnoWinBinding itemUnoWinBinding4 = (ItemUnoWinBinding) holder.getDataBinding();
                if (itemUnoWinBinding4 != null && (imageView8 = itemUnoWinBinding4.rankImage) != null) {
                    imageView8.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_four));
                    break;
                }
                break;
            case 5:
                ItemUnoWinBinding itemUnoWinBinding5 = (ItemUnoWinBinding) holder.getDataBinding();
                if (itemUnoWinBinding5 != null && (imageView9 = itemUnoWinBinding5.rankImage) != null) {
                    imageView9.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_five));
                    break;
                }
                break;
            case 6:
                ItemUnoWinBinding itemUnoWinBinding6 = (ItemUnoWinBinding) holder.getDataBinding();
                if (itemUnoWinBinding6 != null && (imageView10 = itemUnoWinBinding6.rankImage) != null) {
                    imageView10.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_six));
                    break;
                }
                break;
        }
        ItemUnoWinBinding itemUnoWinBinding7 = (ItemUnoWinBinding) holder.getDataBinding();
        if (itemUnoWinBinding7 != null && (imageView4 = itemUnoWinBinding7.bg) != null) {
            imageView4.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), Intrinsics.areEqual(item.isWin(), Boolean.TRUE) ? R.drawable.ludo_end_win_bg : R.drawable.ludo_end_lose_bg));
        }
        ItemUnoWinBinding itemUnoWinBinding8 = (ItemUnoWinBinding) holder.getDataBinding();
        if (itemUnoWinBinding8 != null && (imageView3 = itemUnoWinBinding8.avatarBorder) != null) {
            imageView3.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), Intrinsics.areEqual(item.isWin(), Boolean.TRUE) ? R.drawable.ludo_end_win : R.drawable.ludo_end_lose));
        }
        ItemUnoWinBinding itemUnoWinBinding9 = (ItemUnoWinBinding) holder.getDataBinding();
        if (itemUnoWinBinding9 != null && (qMUIRadiusImageView = itemUnoWinBinding9.avatar) != null) {
            User userTiny = item.getUserTiny();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, userTiny != null ? userTiny.getAvatar() : null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
        }
        ItemUnoWinBinding itemUnoWinBinding10 = (ItemUnoWinBinding) holder.getDataBinding();
        if (itemUnoWinBinding10 != null && (textView4 = itemUnoWinBinding10.nickName) != null) {
            User userTiny2 = item.getUserTiny();
            textView4.setText(userTiny2 != null ? userTiny2.getNick() : null);
        }
        if (item.getDiamond() > 0) {
            ItemUnoWinBinding itemUnoWinBinding11 = (ItemUnoWinBinding) holder.getDataBinding();
            if (itemUnoWinBinding11 != null && (textView3 = itemUnoWinBinding11.diamond) != null) {
                textView3.setVisibility(0);
            }
            ItemUnoWinBinding itemUnoWinBinding12 = (ItemUnoWinBinding) holder.getDataBinding();
            if (itemUnoWinBinding12 != null && (imageView2 = itemUnoWinBinding12.diamondImage) != null) {
                imageView2.setVisibility(0);
            }
            ItemUnoWinBinding itemUnoWinBinding13 = (ItemUnoWinBinding) holder.getDataBinding();
            if (itemUnoWinBinding13 == null || (textView2 = itemUnoWinBinding13.diamond) == null) {
                return;
            }
            textView2.setText("+" + item.getDiamond());
            return;
        }
        ItemUnoWinBinding itemUnoWinBinding14 = (ItemUnoWinBinding) holder.getDataBinding();
        if (itemUnoWinBinding14 != null && (textView = itemUnoWinBinding14.diamond) != null) {
            textView.setVisibility(8);
        }
        ItemUnoWinBinding itemUnoWinBinding15 = (ItemUnoWinBinding) holder.getDataBinding();
        if (itemUnoWinBinding15 == null || (imageView = itemUnoWinBinding15.diamondImage) == null) {
            return;
        }
        imageView.setVisibility(8);
    }
}
