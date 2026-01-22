package com.qiahao.nextvideo.room.game;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemSheepWinBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import userProxy.UserProxy;
import userProxy.UserProxy1;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/game/SheepEndAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "LuserProxy/UserProxy1$SheepGamePlayer;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemSheepWinBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SheepEndAdapter extends BaseQuickAdapter<UserProxy1.SheepGamePlayer, BaseDataBindingHolder<ItemSheepWinBinding>> {
    public SheepEndAdapter() {
        super(R.layout.item_sheep_win, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemSheepWinBinding> holder, @NotNull UserProxy1.SheepGamePlayer item) {
        TextView textView;
        QMUIRadiusImageView qMUIRadiusImageView;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        switch (item.getRank()) {
            case 1:
                ItemSheepWinBinding itemSheepWinBinding = (ItemSheepWinBinding) holder.getDataBinding();
                if (itemSheepWinBinding != null && (imageView3 = itemSheepWinBinding.rankImage) != null) {
                    imageView3.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_one));
                    break;
                }
                break;
            case 2:
                ItemSheepWinBinding itemSheepWinBinding2 = (ItemSheepWinBinding) holder.getDataBinding();
                if (itemSheepWinBinding2 != null && (imageView4 = itemSheepWinBinding2.rankImage) != null) {
                    imageView4.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_two_default));
                    break;
                }
                break;
            case 3:
                ItemSheepWinBinding itemSheepWinBinding3 = (ItemSheepWinBinding) holder.getDataBinding();
                if (itemSheepWinBinding3 != null && (imageView5 = itemSheepWinBinding3.rankImage) != null) {
                    imageView5.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_three));
                    break;
                }
                break;
            case 4:
                ItemSheepWinBinding itemSheepWinBinding4 = (ItemSheepWinBinding) holder.getDataBinding();
                if (itemSheepWinBinding4 != null && (imageView6 = itemSheepWinBinding4.rankImage) != null) {
                    imageView6.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_four));
                    break;
                }
                break;
            case 5:
                ItemSheepWinBinding itemSheepWinBinding5 = (ItemSheepWinBinding) holder.getDataBinding();
                if (itemSheepWinBinding5 != null && (imageView7 = itemSheepWinBinding5.rankImage) != null) {
                    imageView7.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_five));
                    break;
                }
                break;
            case 6:
                ItemSheepWinBinding itemSheepWinBinding6 = (ItemSheepWinBinding) holder.getDataBinding();
                if (itemSheepWinBinding6 != null && (imageView8 = itemSheepWinBinding6.rankImage) != null) {
                    imageView8.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.ludo_end_six));
                    break;
                }
                break;
        }
        ItemSheepWinBinding itemSheepWinBinding7 = (ItemSheepWinBinding) holder.getDataBinding();
        if (itemSheepWinBinding7 != null && (imageView2 = itemSheepWinBinding7.bg) != null) {
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), item.getIsWin() ? R.drawable.ludo_end_win_bg : R.drawable.ludo_end_lose_bg));
        }
        ItemSheepWinBinding itemSheepWinBinding8 = (ItemSheepWinBinding) holder.getDataBinding();
        if (itemSheepWinBinding8 != null && (imageView = itemSheepWinBinding8.avatarBorder) != null) {
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), item.getIsWin() ? R.drawable.ludo_end_win : R.drawable.ludo_end_lose));
        }
        ItemSheepWinBinding itemSheepWinBinding9 = (ItemSheepWinBinding) holder.getDataBinding();
        if (itemSheepWinBinding9 != null && (qMUIRadiusImageView = itemSheepWinBinding9.avatar) != null) {
            UserProxy.User user = item.getUser();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, user != null ? user.getAvatar() : null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
        }
        ItemSheepWinBinding itemSheepWinBinding10 = (ItemSheepWinBinding) holder.getDataBinding();
        if (itemSheepWinBinding10 == null || (textView = itemSheepWinBinding10.nickName) == null) {
            return;
        }
        UserProxy.User user2 = item.getUser();
        textView.setText(user2 != null ? user2.getNick() : null);
    }
}
