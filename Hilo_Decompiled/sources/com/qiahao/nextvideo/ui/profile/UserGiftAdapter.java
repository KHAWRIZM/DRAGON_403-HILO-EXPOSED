package com.qiahao.nextvideo.ui.profile;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.ReceivedGift;
import com.qiahao.nextvideo.databinding.ItemUserGiftBinding;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/UserGiftAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/ReceivedGift;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemUserGiftBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UserGiftAdapter extends BaseQuickAdapter<ReceivedGift, BaseDataBindingHolder<ItemUserGiftBinding>> {
    public UserGiftAdapter() {
        super(R.layout.item_user_gift, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemUserGiftBinding> holder, @NotNull ReceivedGift item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemUserGiftBinding");
        ItemUserGiftBinding itemUserGiftBinding = (ItemUserGiftBinding) dataBinding;
        itemUserGiftBinding.rootContainer.setBackground(ShapeUtil.createShapeStroke$default(ShapeUtil.INSTANCE, "#F6F5F5", 8, 0.5f, false, "#ffffff", (String) null, (GradientDrawable.Orientation) null, 96, (Object) null));
        AppCompatImageView appCompatImageView = itemUserGiftBinding.image;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "image");
        ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.imageSize(item.getIcon(), UiKtxKt.toPX(100)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, 2131232497, 2131232497, (g) null, 40958, (Object) null);
        itemUserGiftBinding.giftNum.setText("x" + item.getCount());
    }
}
