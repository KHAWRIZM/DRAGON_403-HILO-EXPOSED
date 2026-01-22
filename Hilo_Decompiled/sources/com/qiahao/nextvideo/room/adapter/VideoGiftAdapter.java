package com.qiahao.nextvideo.room.adapter;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemVideoGiftBinding;
import com.qiahao.nextvideo.utilities.animation.AnimationUtility;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/VideoGiftAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/base_common/model/GiftData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemVideoGiftBinding;", "<init>", "()V", "selectPosition", "", "getSelectPosition", "()I", "setSelectPosition", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class VideoGiftAdapter extends BaseQuickAdapter<GiftData, BaseDataBindingHolder<ItemVideoGiftBinding>> {
    private int selectPosition;

    public VideoGiftAdapter() {
        super(R.layout.item_video_gift, (List) null, 2, (DefaultConstructorMarker) null);
        this.selectPosition = -1;
    }

    public final int getSelectPosition() {
        return this.selectPosition;
    }

    public final void setSelectPosition(int i) {
        this.selectPosition = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemVideoGiftBinding> holder, @NotNull GiftData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemVideoGiftBinding");
        ItemVideoGiftBinding itemVideoGiftBinding = (ItemVideoGiftBinding) dataBinding;
        AppCompatImageView appCompatImageView = itemVideoGiftBinding.image;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "image");
        String iconUrl = item.getIconUrl();
        if (iconUrl == null) {
            iconUrl = "";
        }
        ImageKtxKt.loadImage$default(appCompatImageView, iconUrl, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        itemVideoGiftBinding.diamondImage.setImageDrawable(a.getDrawable(getContext(), R.drawable.gift_group_chat_diamond));
        itemVideoGiftBinding.diamond.setText(String.valueOf((int) item.getDiamondNum()));
        itemVideoGiftBinding.giftName.setText(item.getName());
        if (item.isMedal()) {
            itemVideoGiftBinding.iconMedal.setVisibility(0);
        } else {
            itemVideoGiftBinding.iconMedal.setVisibility(8);
        }
        if (item.isWeek()) {
            itemVideoGiftBinding.iconWeek.setVisibility(0);
        } else {
            itemVideoGiftBinding.iconWeek.setVisibility(8);
        }
        if (this.selectPosition == holder.getAdapterPosition()) {
            itemVideoGiftBinding.background.setVisibility(0);
            AnimationUtility.INSTANCE.giftSelect(itemVideoGiftBinding.image);
        } else {
            itemVideoGiftBinding.background.setVisibility(8);
        }
    }
}
