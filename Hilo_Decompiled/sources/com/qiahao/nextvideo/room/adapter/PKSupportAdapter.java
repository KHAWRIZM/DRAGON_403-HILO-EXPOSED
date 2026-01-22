package com.qiahao.nextvideo.room.adapter;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.room.RoomPKUser;
import com.qiahao.nextvideo.databinding.ItemSupportPkBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/PKSupportAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/room/RoomPKUser;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemSupportPkBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PKSupportAdapter extends BaseQuickAdapter<RoomPKUser, BaseDataBindingHolder<ItemSupportPkBinding>> {
    public PKSupportAdapter() {
        super(R.layout.item_support_pk, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemSupportPkBinding> holder, @NotNull RoomPKUser item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemSupportPkBinding");
        ItemSupportPkBinding itemSupportPkBinding = (ItemSupportPkBinding) dataBinding;
        itemSupportPkBinding.position.setText(String.valueOf(holder.getLayoutPosition() + 1));
        int layoutPosition = holder.getLayoutPosition();
        if (layoutPosition == 0) {
            itemSupportPkBinding.position.setGradientColors(new int[]{Color.parseColor("#FFAF3B"), Color.parseColor("#FF711C")});
        } else if (layoutPosition == 1) {
            itemSupportPkBinding.position.setGradientColors(new int[]{Color.parseColor("#CFE8EC"), Color.parseColor("#478FC0")});
        } else if (layoutPosition != 2) {
            itemSupportPkBinding.position.setGradientColors(new int[]{Color.parseColor("#ffffff"), Color.parseColor("#ffffff")});
        } else {
            itemSupportPkBinding.position.setGradientColors(new int[]{Color.parseColor("#F3BCA7"), Color.parseColor("#A56950")});
        }
        QMUIRadiusImageView qMUIRadiusImageView = itemSupportPkBinding.avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, item.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        itemSupportPkBinding.name.setText(item.getNick());
        TextView textView = itemSupportPkBinding.diamond;
        Long score = item.getScore();
        textView.setText(NumberUtilsKt.rankNumberFormat(score != null ? score.longValue() : 0L));
    }
}
