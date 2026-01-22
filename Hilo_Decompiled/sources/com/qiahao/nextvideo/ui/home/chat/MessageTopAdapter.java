package com.qiahao.nextvideo.ui.home.chat;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.oudi.adapter.BaseMultiItemAdapter;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.medal.Sex;
import com.qiahao.nextvideo.data.model.MessageTopData;
import com.qiahao.nextvideo.data.model.PrivateRecordBean;
import com.qiahao.nextvideo.data.model.VideoBaseData;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/MessageTopAdapter;", "Lcom/oudi/adapter/BaseMultiItemAdapter;", "Lcom/qiahao/nextvideo/data/model/MessageTopData;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MessageTopAdapter extends BaseMultiItemAdapter<MessageTopData, BaseViewHolder> {
    public MessageTopAdapter() {
        super((List) null, 1, (DefaultConstructorMarker) null);
        addItemType(2, R.layout.item_chat_interactive);
        addItemType(1, R.layout.item_chat_banner);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseViewHolder holder, @NotNull MessageTopData item) {
        int i;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemType = item.getItemType();
        if (itemType == 1) {
            ArrayList<VideoBaseData> banner = item.getBanner();
            if (banner != null) {
                ((MessageBannerView) holder.getView(R.id.messageBanner)).refreshData(banner);
                return;
            }
            return;
        }
        if (itemType != 2) {
            return;
        }
        ImageView imageView = (ImageView) holder.getView(R.id.imgPic);
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        PrivateRecordBean item2 = item.getItem();
        String avatar = item2 != null ? item2.getAvatar() : null;
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(85));
        fill.setHeight(dimens.dpToPx(106));
        Unit unit = Unit.INSTANCE;
        ImageUIModel displayImage = companion.displayImage(avatar, fill);
        PrivateRecordBean item3 = item.getItem();
        Integer valueOf = item3 != null ? Integer.valueOf(item3.getSex()) : null;
        int code = Sex.BOY.getCode();
        if (valueOf != null && valueOf.intValue() == code) {
            i = R.drawable.bg_default_online_list_male_placeholder;
        } else {
            i = (valueOf != null && valueOf.intValue() == Sex.GIRL.getCode()) ? R.drawable.bg_default_online_list_female_placeholder : 2131231930;
        }
        displayImage.setPlaceholder(Integer.valueOf(i));
        ViewUtilitiesKt.bind(imageView, displayImage);
        ImageView imageView2 = (ImageView) holder.getView(2131365181);
        PrivateRecordBean item4 = item.getItem();
        Integer valueOf2 = item4 != null ? Integer.valueOf(item4.getRecordType()) : null;
        if (valueOf2 != null && valueOf2.intValue() == 1) {
            imageView2.setVisibility(0);
            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_chat_interactive_gift), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            return;
        }
        if (valueOf2 != null && valueOf2.intValue() == 2) {
            imageView2.setVisibility(0);
            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_chat_interactive_move), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        } else if (valueOf2 != null && valueOf2.intValue() == 3) {
            imageView2.setVisibility(0);
            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_chat_interactive_real), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        } else {
            imageView2.setVisibility(4);
        }
    }
}
