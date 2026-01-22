package com.qiahao.nextvideo.room.record;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.room.RoomRecordData;
import com.qiahao.nextvideo.databinding.ItemRoomRecordBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/record/RoomRecordAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/room/RoomRecordData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemRoomRecordBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomRecordAdapter extends BaseQuickAdapter<RoomRecordData, BaseDataBindingHolder<ItemRoomRecordBinding>> {
    public RoomRecordAdapter() {
        super(R.layout.item_room_record, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemRoomRecordBinding> holder, @NotNull RoomRecordData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomRecordBinding");
        ItemRoomRecordBinding itemRoomRecordBinding = (ItemRoomRecordBinding) dataBinding;
        QMUIRadiusImageView qMUIRadiusImageView = itemRoomRecordBinding.avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        User beOperUser = item.getBeOperUser();
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, beOperUser != null ? beOperUser.getAvatar() : null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        TextView textView = itemRoomRecordBinding.name;
        User beOperUser2 = item.getBeOperUser();
        textView.setText(beOperUser2 != null ? beOperUser2.getNick() : null);
        TextView textView2 = itemRoomRecordBinding.f٦٥id;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        User beOperUser3 = item.getBeOperUser();
        String format = String.format(stringById, Arrays.copyOf(new Object[]{beOperUser3 != null ? beOperUser3.getCode() : null}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView2.setText(format);
        TextView textView3 = itemRoomRecordBinding.adminName;
        User operUser = item.getOperUser();
        textView3.setText(operUser != null ? operUser.getNick() : null);
        TextView textView4 = itemRoomRecordBinding.time;
        Long operTimeUnix = item.getOperTimeUnix();
        textView4.setText(com.qiahao.base_common.utils.f.h((operTimeUnix != null ? operTimeUnix.longValue() : 0L) * 1000, com.qiahao.base_common.utils.f.i));
    }
}
