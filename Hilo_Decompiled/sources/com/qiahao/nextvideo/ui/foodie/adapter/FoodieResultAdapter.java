package com.qiahao.nextvideo.ui.foodie.adapter;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemChatRoomFoodieCircleResultBinding;
import com.qiahao.nextvideo.ui.foodie.FoodieUtil;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/foodie/adapter/FoodieResultAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemChatRoomFoodieCircleResultBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieResultAdapter extends BaseQuickAdapter<Integer, BaseDataBindingHolder<ItemChatRoomFoodieCircleResultBinding>> {
    public FoodieResultAdapter() {
        super(R.layout.item_chat_room_foodie_circle_result, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj) {
        convert((BaseDataBindingHolder<ItemChatRoomFoodieCircleResultBinding>) baseViewHolder, ((Number) obj).intValue());
    }

    protected void convert(@NotNull BaseDataBindingHolder<ItemChatRoomFoodieCircleResultBinding> holder, int item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemChatRoomFoodieCircleResultBinding");
        ItemChatRoomFoodieCircleResultBinding itemChatRoomFoodieCircleResultBinding = (ItemChatRoomFoodieCircleResultBinding) dataBinding;
        if (holder.getAdapterPosition() == 0) {
            itemChatRoomFoodieCircleResultBinding.tvNew.setVisibility(0);
        } else {
            itemChatRoomFoodieCircleResultBinding.tvNew.setVisibility(4);
        }
        ImageView imageView = itemChatRoomFoodieCircleResultBinding.ivResult;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivResult");
        ImageKtxKt.loadImage$default(imageView, FoodieUtil.INSTANCE.getFoodieIcon(item), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
    }
}
