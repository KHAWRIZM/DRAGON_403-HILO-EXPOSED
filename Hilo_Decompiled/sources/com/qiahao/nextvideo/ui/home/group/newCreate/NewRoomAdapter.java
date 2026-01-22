package com.qiahao.nextvideo.ui.home.group.newCreate;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.CornerMarkType;
import com.qiahao.nextvideo.data.model.NewRoomBean;
import com.qiahao.nextvideo.databinding.ItemNewRoomBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/group/newCreate/NewRoomAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/NewRoomBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemNewRoomBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class NewRoomAdapter extends BaseQuickAdapter<NewRoomBean, BaseDataBindingHolder<ItemNewRoomBinding>> {
    public NewRoomAdapter() {
        super(R.layout.item_new_room, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemNewRoomBinding> holder, @NotNull NewRoomBean item) {
        User user;
        User user2;
        User user3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemNewRoomBinding");
        ItemNewRoomBinding itemNewRoomBinding = (ItemNewRoomBinding) dataBinding;
        ConstraintLayout constraintLayout = itemNewRoomBinding.constraint;
        ShapeUtil shapeUtil = ShapeUtil.INSTANCE;
        constraintLayout.setBackground(ShapeUtil.createShape$default(shapeUtil, "#ffffff", "#ffffff", 8, (GradientDrawable.Orientation) null, 8, (Object) null));
        View view = itemNewRoomBinding.headTopBg;
        GradientDrawable.Orientation orientation = GradientDrawable.Orientation.TOP_BOTTOM;
        view.setBackground(shapeUtil.createShape("#7f000000", "#00000000", 8, 8, 0, 0, orientation));
        itemNewRoomBinding.headButtonBg.setBackground(ShapeUtil.createShape$default(shapeUtil, "#00000000", "#7f000000", 0, 0, 0, 0, orientation, 60, (Object) null));
        itemNewRoomBinding.number.setBackground(ShapeUtil.createShape$default(shapeUtil, "#33000000", "#33000000", 20, (GradientDrawable.Orientation) null, 8, (Object) null));
        int cornerMark = item.getCornerMark();
        if (cornerMark == CornerMarkType.HOT.getType()) {
            itemNewRoomBinding.hot.setVisibility(0);
            itemNewRoomBinding.hot.setImageResource(R.drawable.home_popular_hot_icon);
        } else if (cornerMark == CornerMarkType.NEW.getType()) {
            itemNewRoomBinding.hot.setVisibility(0);
            itemNewRoomBinding.hot.setImageResource(R.drawable.home_popular_new_icon);
        } else {
            itemNewRoomBinding.hot.setVisibility(8);
        }
        String gameTypeIcon = item.getGameTypeIcon();
        if (gameTypeIcon != null && gameTypeIcon.length() > 0) {
            itemNewRoomBinding.gameIcon.setVisibility(0);
            ImageView imageView = itemNewRoomBinding.gameIcon;
            Intrinsics.checkNotNullExpressionValue(imageView, "gameIcon");
            ImageKtxKt.loadImage$default(imageView, item.getGameTypeIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        } else {
            itemNewRoomBinding.gameIcon.setVisibility(8);
        }
        itemNewRoomBinding.oneAvatar.setVisibility(8);
        itemNewRoomBinding.twoAvatar.setVisibility(8);
        itemNewRoomBinding.threeAvatar.setVisibility(8);
        itemNewRoomBinding.number.setVisibility(8);
        String str = null;
        if (item.getMicUsers() != null && (!r1.isEmpty())) {
            itemNewRoomBinding.oneAvatar.setVisibility(0);
            itemNewRoomBinding.number.setVisibility(0);
            itemNewRoomBinding.number.setText(String.valueOf(item.getMicUserNum()));
            QMUIRadiusImageView qMUIRadiusImageView = itemNewRoomBinding.oneAvatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "oneAvatar");
            List<User> micUsers = item.getMicUsers();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100((micUsers == null || (user3 = micUsers.get(0)) == null) ? null : user3.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
        }
        List<User> micUsers2 = item.getMicUsers();
        if ((micUsers2 != null ? micUsers2.size() : 0) > 1) {
            itemNewRoomBinding.twoAvatar.setVisibility(0);
            QMUIRadiusImageView qMUIRadiusImageView2 = itemNewRoomBinding.twoAvatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "twoAvatar");
            List<User> micUsers3 = item.getMicUsers();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100((micUsers3 == null || (user2 = micUsers3.get(1)) == null) ? null : user2.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
        }
        List<User> micUsers4 = item.getMicUsers();
        if ((micUsers4 != null ? micUsers4.size() : 0) > 2) {
            itemNewRoomBinding.threeAvatar.setVisibility(0);
            QMUIRadiusImageView qMUIRadiusImageView3 = itemNewRoomBinding.threeAvatar;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView3, "threeAvatar");
            List<User> micUsers5 = item.getMicUsers();
            if (micUsers5 != null && (user = micUsers5.get(2)) != null) {
                str = user.getAvatar();
            }
            ImageKtxKt.loadImage$default(qMUIRadiusImageView3, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231655, 2131231655, (c5.g) null, 40958, (Object) null);
        }
        ImageView imageView2 = itemNewRoomBinding.countryIcon;
        Intrinsics.checkNotNullExpressionValue(imageView2, "countryIcon");
        ImageKtxKt.loadImage$default(imageView2, ImageSizeKt.imageSize(item.getCountryIcon(), UiKtxKt.toPX(22)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        itemNewRoomBinding.name.setText(item.getName());
        itemNewRoomBinding.des.setText(item.getIntroduction());
        AppCompatImageView appCompatImageView = itemNewRoomBinding.topBg;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "topBg");
        ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.imageSize(item.getFaceUrl(), UiKtxKt.toPX(200)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        itemNewRoomBinding.hotNumber.setText(String.valueOf(item.getGroupInUserDuration()));
    }
}
