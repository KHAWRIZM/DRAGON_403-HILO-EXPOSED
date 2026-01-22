package com.qiahao.nextvideo.ui.home.chat;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.strange.StrangeItemData;
import com.qiahao.nextvideo.data.strange.StrangeUserData;
import com.qiahao.nextvideo.databinding.ItemStrangeListBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/StrangeListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/strange/StrangeItemData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemStrangeListBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class StrangeListAdapter extends BaseQuickAdapter<StrangeItemData, BaseDataBindingHolder<ItemStrangeListBinding>> {
    public StrangeListAdapter() {
        super(R.layout.item_strange_list, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemStrangeListBinding> holder, @NotNull StrangeItemData item) {
        User otherUser;
        User otherUser2;
        User otherUser3;
        User otherUser4;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemStrangeListBinding");
        ItemStrangeListBinding itemStrangeListBinding = (ItemStrangeListBinding) dataBinding;
        StrangeUserData strangeData = item.getStrangeData();
        String str = null;
        if (strangeData != null ? Intrinsics.areEqual(strangeData.getUnlock(), Boolean.TRUE) : false) {
            QMUIRadiusImageView qMUIRadiusImageView = itemStrangeListBinding.avatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
            StrangeUserData strangeData2 = item.getStrangeData();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, (strangeData2 == null || (otherUser4 = strangeData2.getOtherUser()) == null) ? null : otherUser4.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            TextView textView = itemStrangeListBinding.name;
            StrangeUserData strangeData3 = item.getStrangeData();
            if (strangeData3 != null && (otherUser3 = strangeData3.getOtherUser()) != null) {
                str = otherUser3.getNick();
            }
            textView.setText(str);
        } else {
            QMUIRadiusImageView qMUIRadiusImageView2 = itemStrangeListBinding.avatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "avatar");
            StrangeUserData strangeData4 = item.getStrangeData();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, (strangeData4 == null || (otherUser2 = strangeData4.getOtherUser()) == null) ? null : otherUser2.getMaskAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            TextView textView2 = itemStrangeListBinding.name;
            StrangeUserData strangeData5 = item.getStrangeData();
            if (strangeData5 != null && (otherUser = strangeData5.getOtherUser()) != null) {
                str = otherUser.getMaskNick();
            }
            textView2.setText(str);
        }
        TextView textView3 = itemStrangeListBinding.content;
        String lastMessageStr = item.getLastMessageStr();
        if (lastMessageStr == null) {
            lastMessageStr = "";
        }
        textView3.setText(lastMessageStr);
        itemStrangeListBinding.time.setText(DateTimeUtilityKt.getGroupDateString(getContext(), item.getLastMessageTime()));
        itemStrangeListBinding.onlineStatus.setVisibility(item.getUserStatus() == 2 ? 8 : 0);
        if (item.getUnRead() == 0) {
            itemStrangeListBinding.unreadText.setVisibility(8);
        } else if (item.getUnRead() <= 99) {
            itemStrangeListBinding.unreadText.setVisibility(0);
            itemStrangeListBinding.unreadText.setText(String.valueOf(item.getUnRead()));
        } else {
            itemStrangeListBinding.unreadText.setVisibility(0);
            itemStrangeListBinding.unreadText.setText(ResourcesKtxKt.getStringById(this, 2131952516));
        }
    }
}
