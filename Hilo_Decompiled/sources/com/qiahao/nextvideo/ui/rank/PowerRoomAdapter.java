package com.qiahao.nextvideo.ui.rank;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.data.model.GroupMedalDetailBean;
import com.qiahao.nextvideo.data.model.PowerGroupMemberBean;
import com.qiahao.nextvideo.databinding.ItemPowerRoomBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/PowerRoomAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/PowerGroupMemberBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemPowerRoomBinding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "bean", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PowerRoomAdapter extends BaseQuickAdapter<PowerGroupMemberBean, BaseDataBindingHolder<ItemPowerRoomBinding>> {

    @NotNull
    private static final String TAG = "PowerRoomAdapter";

    public PowerRoomAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemPowerRoomBinding> holder, @NotNull PowerGroupMemberBean bean) {
        int i;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(bean, "bean");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemPowerRoomBinding");
        ItemPowerRoomBinding itemPowerRoomBinding = (ItemPowerRoomBinding) dataBinding;
        if (!TextUtils.isEmpty(bean.getName())) {
            itemPowerRoomBinding.groupName.setText(bean.getName());
        }
        if (!TextUtils.isEmpty(bean.getNotification())) {
            itemPowerRoomBinding.groupAnnounce.setText(bean.getNotification());
        }
        ImageView imageView2 = itemPowerRoomBinding.iconCount;
        Intrinsics.checkNotNullExpressionValue(imageView2, "iconCount");
        ImageKtxKt.loadImage$default(imageView2, ImageSizeKt.imageSize(bean.getCountryIcon(), UiKtxKt.toPX(22), UiKtxKt.toPX(14)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        RoundedImageView roundedImageView = itemPowerRoomBinding.roomAvatar;
        Intrinsics.checkNotNullExpressionValue(roundedImageView, "roomAvatar");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        String faceUrl = bean.getFaceUrl();
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(69));
        fill.setHeight(dimens.dpToPx(69));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind(roundedImageView, companion.displayImage(faceUrl, fill));
        itemPowerRoomBinding.personNumber.setText(String.valueOf(bean.getGroupInUserDuration()));
        GroupMedalAndPowerLayout groupMedalAndPowerLayout = itemPowerRoomBinding.groupMedalAndPower;
        List<GroupMedalDetailBean> groupMedals = bean.getGroupMedals();
        groupMedalAndPowerLayout.setDataAndLayoutView("", (ArrayList) (groupMedals != null ? CollectionsKt.toMutableList(groupMedals) : null), 6);
        if (bean.getSupportLevel() > 0) {
            int supportMedal = MeetingRoomManager.INSTANCE.getSupportMedal(bean.getSupportLevel());
            if (supportMedal == 0) {
                itemPowerRoomBinding.groupSupportMedal.setVisibility(8);
            } else {
                itemPowerRoomBinding.groupSupportMedal.setVisibility(0);
                ImageView imageView3 = itemPowerRoomBinding.groupSupportMedal;
                Intrinsics.checkNotNullExpressionValue(imageView3, "groupSupportMedal");
                ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(supportMedal), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            }
        } else {
            itemPowerRoomBinding.groupSupportMedal.setVisibility(8);
        }
        itemPowerRoomBinding.rocket1.setVisibility(8);
        itemPowerRoomBinding.rocket2.setVisibility(8);
        itemPowerRoomBinding.rocket3.setVisibility(8);
        itemPowerRoomBinding.rocket4.setVisibility(8);
        itemPowerRoomBinding.rocket5.setVisibility(8);
        Integer maxStage = bean.getMaxStage();
        int intValue = maxStage != null ? maxStage.intValue() : -1;
        if (intValue <= 2 || intValue - 2 >= 4) {
            i = 0;
        }
        while (i < 5) {
            if (i == 0) {
                imageView = itemPowerRoomBinding.rocket1;
            } else if (i == 1) {
                imageView = itemPowerRoomBinding.rocket2;
            } else if (i == 2) {
                imageView = itemPowerRoomBinding.rocket3;
            } else if (i != 3) {
                imageView = i != 4 ? null : itemPowerRoomBinding.rocket5;
            } else {
                imageView = itemPowerRoomBinding.rocket4;
            }
            if (imageView != null) {
                imageView.setVisibility(i <= intValue ? 0 : 8);
            }
            i++;
        }
        itemPowerRoomBinding.llRocket.setVisibility(intValue > -1 ? 0 : 8);
        String gameTypeIcon = bean.getGameTypeIcon();
        if (gameTypeIcon != null && gameTypeIcon.length() > 0) {
            itemPowerRoomBinding.gameImage.setVisibility(0);
            ImageView imageView4 = itemPowerRoomBinding.gameImage;
            Intrinsics.checkNotNullExpressionValue(imageView4, "gameImage");
            ImageKtxKt.loadImage$default(imageView4, bean.getGameTypeIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            return;
        }
        itemPowerRoomBinding.gameImage.setVisibility(8);
    }
}
