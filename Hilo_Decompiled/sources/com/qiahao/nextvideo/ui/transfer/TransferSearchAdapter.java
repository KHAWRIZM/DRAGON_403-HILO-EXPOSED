package com.qiahao.nextvideo.ui.transfer;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemTransferSearchBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/TransferSearchAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/base_common/model/common/User;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemTransferSearchBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TransferSearchAdapter extends BaseQuickAdapter<User, BaseDataBindingHolder<ItemTransferSearchBinding>> {
    public TransferSearchAdapter() {
        super(R.layout.item_transfer_search, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemTransferSearchBinding> holder, @NotNull User item) {
        ImageView imageView;
        TextView textView;
        ImageView imageView2;
        ImageView imageView3;
        TextView textView2;
        QMUIRadiusImageView qMUIRadiusImageView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemTransferSearchBinding itemTransferSearchBinding = (ItemTransferSearchBinding) holder.getDataBinding();
        if (itemTransferSearchBinding != null && (qMUIRadiusImageView = itemTransferSearchBinding.avatar) != null) {
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, item.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
        ItemTransferSearchBinding itemTransferSearchBinding2 = (ItemTransferSearchBinding) holder.getDataBinding();
        if (itemTransferSearchBinding2 != null && (textView2 = itemTransferSearchBinding2.nickName) != null) {
            String nick = item.getNick();
            if (nick == null) {
                nick = "";
            }
            textView2.setText(nick);
        }
        SvipData svip = item.getSvip();
        if ((svip != null ? svip.getSvipLevel() : 0) > 0) {
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            SvipData svip2 = item.getSvip();
            Integer svipType = svipTypeUtils.getSvipType(svip2 != null ? Integer.valueOf(svip2.getSvipLevel()) : null);
            if (svipType != null) {
                int intValue = svipType.intValue();
                ItemTransferSearchBinding itemTransferSearchBinding3 = (ItemTransferSearchBinding) holder.getDataBinding();
                if (itemTransferSearchBinding3 != null && (imageView3 = itemTransferSearchBinding3.svipType) != null) {
                    imageView3.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), intValue));
                }
                ItemTransferSearchBinding itemTransferSearchBinding4 = (ItemTransferSearchBinding) holder.getDataBinding();
                if (itemTransferSearchBinding4 != null && (imageView2 = itemTransferSearchBinding4.svipType) != null) {
                    imageView2.setVisibility(0);
                }
            }
        } else {
            ItemTransferSearchBinding itemTransferSearchBinding5 = (ItemTransferSearchBinding) holder.getDataBinding();
            if (itemTransferSearchBinding5 != null && (imageView = itemTransferSearchBinding5.svipType) != null) {
                imageView.setVisibility(8);
            }
        }
        ItemTransferSearchBinding itemTransferSearchBinding6 = (ItemTransferSearchBinding) holder.getDataBinding();
        if (itemTransferSearchBinding6 == null || (textView = itemTransferSearchBinding6.userId) == null) {
            return;
        }
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{item.getCode()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
    }
}
