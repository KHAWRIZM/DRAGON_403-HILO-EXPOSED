package com.qiahao.nextvideo.ui.foodie.adapter;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.foodie.FoodieDrawResult;
import com.qiahao.nextvideo.databinding.ItemChatRoomFoodieRankingBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/adapter/FoodieRankingAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/foodie/FoodieDrawResult;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemChatRoomFoodieRankingBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieRankingAdapter extends BaseQuickAdapter<FoodieDrawResult, BaseDataBindingHolder<ItemChatRoomFoodieRankingBinding>> {
    public FoodieRankingAdapter() {
        super(R.layout.item_chat_room_foodie_ranking, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemChatRoomFoodieRankingBinding> holder, @NotNull FoodieDrawResult item) {
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemChatRoomFoodieRankingBinding");
        ItemChatRoomFoodieRankingBinding itemChatRoomFoodieRankingBinding = (ItemChatRoomFoodieRankingBinding) dataBinding;
        int adapterPosition = holder.getAdapterPosition();
        if (adapterPosition == 0) {
            itemChatRoomFoodieRankingBinding.ivRank.setVisibility(0);
            itemChatRoomFoodieRankingBinding.ivRank.setImageDrawable(a.getDrawable(getContext(), R.drawable.ic_fd_rank_1));
            itemChatRoomFoodieRankingBinding.tvRank.setVisibility(8);
        } else if (adapterPosition == 1) {
            itemChatRoomFoodieRankingBinding.ivRank.setVisibility(0);
            itemChatRoomFoodieRankingBinding.ivRank.setImageDrawable(a.getDrawable(getContext(), R.drawable.ic_fd_rank_2));
            itemChatRoomFoodieRankingBinding.tvRank.setVisibility(8);
        } else if (adapterPosition != 2) {
            itemChatRoomFoodieRankingBinding.tvRank.setVisibility(0);
            itemChatRoomFoodieRankingBinding.ivRank.setVisibility(8);
            itemChatRoomFoodieRankingBinding.tvRank.setText(String.valueOf(holder.getAdapterPosition() + 1));
        } else {
            itemChatRoomFoodieRankingBinding.ivRank.setVisibility(0);
            itemChatRoomFoodieRankingBinding.ivRank.setImageDrawable(a.getDrawable(getContext(), R.drawable.ic_fd_rank_3));
            itemChatRoomFoodieRankingBinding.tvRank.setVisibility(8);
        }
        QMUIRadiusImageView qMUIRadiusImageView = itemChatRoomFoodieRankingBinding.civAvatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "civAvatar");
        User user = item.getUser();
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, user != null ? user.getAvatar() : null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (g) null, 49150, (Object) null);
        TextView textView = itemChatRoomFoodieRankingBinding.tvNickName;
        User user2 = item.getUser();
        if (user2 == null || (str = user2.getNick()) == null) {
            str = "";
        }
        textView.setText(str);
        itemChatRoomFoodieRankingBinding.tvGold.setText("***");
    }
}
