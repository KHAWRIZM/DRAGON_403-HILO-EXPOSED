package com.qiahao.nextvideo.room.adapter;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.MicroBean;
import com.qiahao.nextvideo.data.model.MicroUserBean;
import com.qiahao.nextvideo.databinding.ItemPopupGiftMemberBinding;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/PopUpGiftMemberAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/MicroBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemPopupGiftMemberBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PopUpGiftMemberAdapter extends BaseQuickAdapter<MicroBean, BaseDataBindingHolder<ItemPopupGiftMemberBinding>> {
    public PopUpGiftMemberAdapter() {
        super(R.layout.item_popup_gift_member, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemPopupGiftMemberBinding> holder, @NotNull MicroBean item) {
        SvipData svip;
        SvipData svip2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemPopupGiftMemberBinding");
        ItemPopupGiftMemberBinding itemPopupGiftMemberBinding = (ItemPopupGiftMemberBinding) dataBinding;
        if (holder.getLayoutPosition() == 0) {
            itemPopupGiftMemberBinding.userName.setText(getContext().getString(2131952950));
            itemPopupGiftMemberBinding.userAvatarCimageView.setImageDrawable(a.getDrawable(getContext(), R.drawable.icon_gift_all_mic));
        } else if (holder.getLayoutPosition() == 1) {
            itemPopupGiftMemberBinding.userName.setText(getContext().getString(2131952004));
            itemPopupGiftMemberBinding.userAvatarCimageView.setImageDrawable(a.getDrawable(getContext(), R.drawable.icon_gift_all_room));
        } else {
            MicroUserBean user = item.getUser();
            if (user != null && (svip = user.getSvip()) != null && svip.isMystery()) {
                TextView textView = itemPopupGiftMemberBinding.userName;
                String stringById = ResourcesKtxKt.getStringById(this, 2131953504);
                MicroUserBean user2 = item.getUser();
                if (user2 != null && (svip2 = user2.getSvip()) != null) {
                    r5 = svip2.mysteryNumber();
                }
                String format = String.format(stringById, Arrays.copyOf(new Object[]{r5}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format);
                AppCompatImageView appCompatImageView = itemPopupGiftMemberBinding.userAvatarCimageView;
                Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatarCimageView");
                ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
                return;
            }
            TextView textView2 = itemPopupGiftMemberBinding.userName;
            MicroUserBean user3 = item.getUser();
            textView2.setText(user3 != null ? user3.getNick() : null);
            AppCompatImageView appCompatImageView2 = itemPopupGiftMemberBinding.userAvatarCimageView;
            Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "userAvatarCimageView");
            MicroUserBean user4 = item.getUser();
            ImageKtxKt.loadImage$default(appCompatImageView2, user4 != null ? user4.getAvatar() : null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        }
    }
}
