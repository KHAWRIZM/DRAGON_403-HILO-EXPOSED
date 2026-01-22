package com.qiahao.nextvideo.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.data.model.GiftWallBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemGiftWallBinding;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/GiftWallAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/GiftWallBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGiftWallBinding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "item", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GiftWallAdapter extends BaseQuickAdapter<GiftWallBean, BaseDataBindingHolder<ItemGiftWallBinding>> {

    @NotNull
    private static final String TAG = "GlobalBroadCastHistoryA";

    public GiftWallAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGiftWallBinding> holder, @NotNull GiftWallBean item) {
        Integer level;
        Integer level2;
        Integer level3;
        Integer level4;
        Integer level5;
        Integer level6;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGiftWallBinding");
        ItemGiftWallBinding itemGiftWallBinding = (ItemGiftWallBinding) dataBinding;
        int i = 0;
        itemGiftWallBinding.giftPicNumber.setVisibility(0);
        HiloImageView.loadImage$default(itemGiftWallBinding.sendAvatar, ImageSizeKt.image100(item.getSendUser().getAvatar()), 0, 0, 6, (Object) null);
        ImageView imageView = itemGiftWallBinding.sendIconVip;
        Boolean isVip = item.getSendUser().isVip();
        Boolean bool = Boolean.TRUE;
        imageView.setVisibility(Intrinsics.areEqual(isVip, bool) ? 0 : 8);
        itemGiftWallBinding.receiverIconVip.setVisibility(Intrinsics.areEqual(item.getReceiveUser().isVip(), bool) ? 0 : 8);
        HiloImageView.loadImage$default(itemGiftWallBinding.receiverAvatar, ImageSizeKt.image100(item.getReceiveUser().getAvatar()), 0, 0, 6, (Object) null);
        ImageView imageView2 = itemGiftWallBinding.giftPic;
        Intrinsics.checkNotNullExpressionValue(imageView2, "giftPic");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        String giftUrl = item.getGiftUrl();
        ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        lfit.setWidth(dimens.dpToPx(49));
        lfit.setHeight(dimens.dpToPx(49));
        Unit unit = Unit.INSTANCE;
        ImageUIModel displayImage = companion.displayImage(giftUrl, lfit);
        displayImage.setPlaceholder(null);
        ViewUtilitiesKt.bind(imageView2, displayImage);
        NobleInfo noble = item.getSendUser().getNoble();
        if (((noble == null || (level6 = noble.getLevel()) == null) ? 0 : level6.intValue()) > 0) {
            TextView textView = itemGiftWallBinding.userName1;
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble2 = item.getSendUser().getNoble();
            textView.setTextColor(UserService.Companion.getNobleColor$default(companion2, (noble2 == null || (level5 = noble2.getLevel()) == null) ? 0 : level5.intValue(), 0, 2, null));
            itemGiftWallBinding.sendIconVip.setVisibility(8);
            itemGiftWallBinding.sendIconNoble.setVisibility(0);
            ImageView imageView3 = itemGiftWallBinding.sendIconNoble;
            Context context = getContext();
            NobleInfo noble3 = item.getSendUser().getNoble();
            imageView3.setImageDrawable(androidx.core.content.a.getDrawable(context, companion2.getNobleDrawableRes((noble3 == null || (level4 = noble3.getLevel()) == null) ? 0 : level4.intValue())));
        } else {
            itemGiftWallBinding.sendIconNoble.setVisibility(8);
            itemGiftWallBinding.userName1.setTextColor(Color.parseColor("#ffffff"));
        }
        NobleInfo noble4 = item.getReceiveUser().getNoble();
        if (((noble4 == null || (level3 = noble4.getLevel()) == null) ? 0 : level3.intValue()) > 0) {
            TextView textView2 = itemGiftWallBinding.userName2;
            UserService.Companion companion3 = UserService.INSTANCE;
            NobleInfo noble5 = item.getReceiveUser().getNoble();
            textView2.setTextColor(UserService.Companion.getNobleColor$default(companion3, (noble5 == null || (level2 = noble5.getLevel()) == null) ? 0 : level2.intValue(), 0, 2, null));
            itemGiftWallBinding.receiverIconVip.setVisibility(8);
            itemGiftWallBinding.receiverIconNoble.setVisibility(0);
            ImageView imageView4 = itemGiftWallBinding.receiverIconNoble;
            Context context2 = getContext();
            NobleInfo noble6 = item.getReceiveUser().getNoble();
            if (noble6 != null && (level = noble6.getLevel()) != null) {
                i = level.intValue();
            }
            imageView4.setImageDrawable(androidx.core.content.a.getDrawable(context2, companion3.getNobleDrawableRes(i)));
        } else {
            itemGiftWallBinding.userName2.setTextColor(Color.parseColor("#ffffff"));
            itemGiftWallBinding.receiverIconNoble.setVisibility(8);
        }
        itemGiftWallBinding.userName1.setText(item.getSendUser().getName());
        itemGiftWallBinding.userName2.setText(item.getReceiveUser().getName());
    }
}
