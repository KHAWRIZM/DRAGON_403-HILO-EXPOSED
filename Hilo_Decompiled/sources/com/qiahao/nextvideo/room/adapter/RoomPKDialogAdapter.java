package com.qiahao.nextvideo.room.adapter;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupDetailBean;
import com.qiahao.nextvideo.data.room.RoomCurrentPK;
import com.qiahao.nextvideo.databinding.ItemCurrentlyPkBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/RoomPKDialogAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/room/RoomCurrentPK;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemCurrentlyPkBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomPKDialogAdapter extends BaseQuickAdapter<RoomCurrentPK, BaseDataBindingHolder<ItemCurrentlyPkBinding>> {
    public RoomPKDialogAdapter() {
        super(R.layout.item_currently_pk, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemCurrentlyPkBinding> holder, @NotNull RoomCurrentPK item) {
        String faceUrl;
        String faceUrl2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemCurrentlyPkBinding");
        ItemCurrentlyPkBinding itemCurrentlyPkBinding = (ItemCurrentlyPkBinding) dataBinding;
        ImageView imageView = itemCurrentlyPkBinding.centerBg;
        Intrinsics.checkNotNullExpressionValue(imageView, "centerBg");
        ImageKtxKt.toHorizontalMirror(imageView, R.drawable.pk_item_button_bg);
        QMUIRadiusImageView qMUIRadiusImageView = itemCurrentlyPkBinding.leftAvatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "leftAvatar");
        GroupDetailBean inviteGroup = item.getInviteGroup();
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, (inviteGroup == null || (faceUrl2 = inviteGroup.getFaceUrl()) == null) ? "" : faceUrl2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        TextView textView = itemCurrentlyPkBinding.leftName;
        GroupDetailBean inviteGroup2 = item.getInviteGroup();
        textView.setText(inviteGroup2 != null ? inviteGroup2.getName() : null);
        TextView textView2 = itemCurrentlyPkBinding.leftId;
        GroupDetailBean inviteGroup3 = item.getInviteGroup();
        textView2.setText(inviteGroup3 != null ? inviteGroup3.getCode() : null);
        QMUIRadiusImageView qMUIRadiusImageView2 = itemCurrentlyPkBinding.rightAvatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "rightAvatar");
        GroupDetailBean receiveGroup = item.getReceiveGroup();
        ImageKtxKt.loadImage$default(qMUIRadiusImageView2, (receiveGroup == null || (faceUrl = receiveGroup.getFaceUrl()) == null) ? "" : faceUrl, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        TextView textView3 = itemCurrentlyPkBinding.rightName;
        GroupDetailBean receiveGroup2 = item.getReceiveGroup();
        textView3.setText(receiveGroup2 != null ? receiveGroup2.getName() : null);
        TextView textView4 = itemCurrentlyPkBinding.rightId;
        GroupDetailBean receiveGroup3 = item.getReceiveGroup();
        textView4.setText(receiveGroup3 != null ? receiveGroup3.getCode() : null);
        itemCurrentlyPkBinding.diamond.setText(NumberUtilsKt.rankNumberFormat(item.getTotalPoints()));
    }
}
