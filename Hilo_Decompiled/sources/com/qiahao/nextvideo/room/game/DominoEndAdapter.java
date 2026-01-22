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
import com.qiahao.nextvideo.databinding.ItemDominoWinBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/game/DominoEndAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/game/SUDGamePlayerAward;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemDominoWinBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DominoEndAdapter extends BaseQuickAdapter<SUDGamePlayerAward, BaseDataBindingHolder<ItemDominoWinBinding>> {
    public DominoEndAdapter() {
        super(R.layout.item_domino_win, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemDominoWinBinding> holder, @NotNull SUDGamePlayerAward item) {
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
                ItemDominoWinBinding itemDominoWinBinding = (ItemDominoWinBinding) holder.getDataBinding();
                if (itemDominoWinBinding != null && (imageView5 = itemDominoWinBinding.rankImage) != null) {
                    imageView5.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_one));
                    break;
                }
                break;
            case 2:
                ItemDominoWinBinding itemDominoWinBinding2 = (ItemDominoWinBinding) holder.getDataBinding();
                if (itemDominoWinBinding2 != null && (imageView6 = itemDominoWinBinding2.rankImage) != null) {
                    imageView6.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_two_default));
                    break;
                }
                break;
            case 3:
                ItemDominoWinBinding itemDominoWinBinding3 = (ItemDominoWinBinding) holder.getDataBinding();
                if (itemDominoWinBinding3 != null && (imageView7 = itemDominoWinBinding3.rankImage) != null) {
                    imageView7.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_three));
                    break;
                }
                break;
            case 4:
                ItemDominoWinBinding itemDominoWinBinding4 = (ItemDominoWinBinding) holder.getDataBinding();
                if (itemDominoWinBinding4 != null && (imageView8 = itemDominoWinBinding4.rankImage) != null) {
                    imageView8.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_four));
                    break;
                }
                break;
            case 5:
                ItemDominoWinBinding itemDominoWinBinding5 = (ItemDominoWinBinding) holder.getDataBinding();
                if (itemDominoWinBinding5 != null && (imageView9 = itemDominoWinBinding5.rankImage) != null) {
                    imageView9.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_five));
                    break;
                }
                break;
            case 6:
                ItemDominoWinBinding itemDominoWinBinding6 = (ItemDominoWinBinding) holder.getDataBinding();
                if (itemDominoWinBinding6 != null && (imageView10 = itemDominoWinBinding6.rankImage) != null) {
                    imageView10.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_six));
                    break;
                }
                break;
        }
        ItemDominoWinBinding itemDominoWinBinding7 = (ItemDominoWinBinding) holder.getDataBinding();
        if (itemDominoWinBinding7 != null && (imageView4 = itemDominoWinBinding7.bg) != null) {
            imageView4.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), Intrinsics.areEqual(item.isWin(), Boolean.TRUE) ? R.drawable.ludo_end_win_bg : R.drawable.ludo_end_lose_bg));
        }
        ItemDominoWinBinding itemDominoWinBinding8 = (ItemDominoWinBinding) holder.getDataBinding();
        if (itemDominoWinBinding8 != null && (imageView3 = itemDominoWinBinding8.avatarBorder) != null) {
            imageView3.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), Intrinsics.areEqual(item.isWin(), Boolean.TRUE) ? R.drawable.ludo_end_win : R.drawable.ludo_end_lose));
        }
        ItemDominoWinBinding itemDominoWinBinding9 = (ItemDominoWinBinding) holder.getDataBinding();
        if (itemDominoWinBinding9 != null && (qMUIRadiusImageView = itemDominoWinBinding9.avatar) != null) {
            User userTiny = item.getUserTiny();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, userTiny != null ? userTiny.getAvatar() : null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
        }
        ItemDominoWinBinding itemDominoWinBinding10 = (ItemDominoWinBinding) holder.getDataBinding();
        if (itemDominoWinBinding10 != null && (textView4 = itemDominoWinBinding10.nickName) != null) {
            User userTiny2 = item.getUserTiny();
            textView4.setText(userTiny2 != null ? userTiny2.getNick() : null);
        }
        if (item.getDiamond() > 0) {
            ItemDominoWinBinding itemDominoWinBinding11 = (ItemDominoWinBinding) holder.getDataBinding();
            if (itemDominoWinBinding11 != null && (textView3 = itemDominoWinBinding11.diamond) != null) {
                textView3.setVisibility(0);
            }
            ItemDominoWinBinding itemDominoWinBinding12 = (ItemDominoWinBinding) holder.getDataBinding();
            if (itemDominoWinBinding12 != null && (imageView2 = itemDominoWinBinding12.diamondImage) != null) {
                imageView2.setVisibility(0);
            }
            ItemDominoWinBinding itemDominoWinBinding13 = (ItemDominoWinBinding) holder.getDataBinding();
            if (itemDominoWinBinding13 == null || (textView2 = itemDominoWinBinding13.diamond) == null) {
                return;
            }
            textView2.setText("+" + item.getDiamond());
            return;
        }
        ItemDominoWinBinding itemDominoWinBinding14 = (ItemDominoWinBinding) holder.getDataBinding();
        if (itemDominoWinBinding14 != null && (textView = itemDominoWinBinding14.diamond) != null) {
            textView.setVisibility(8);
        }
        ItemDominoWinBinding itemDominoWinBinding15 = (ItemDominoWinBinding) holder.getDataBinding();
        if (itemDominoWinBinding15 == null || (imageView = itemDominoWinBinding15.diamondImage) == null) {
            return;
        }
        imageView.setVisibility(8);
    }
}
