package com.qiahao.nextvideo.ui.youtu;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.youtube.WatchYouTuListData;
import com.qiahao.nextvideo.databinding.ItemWatchVideoBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/youtu/YouTuWatchAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/youtube/WatchYouTuListData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemWatchVideoBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class YouTuWatchAdapter extends BaseQuickAdapter<WatchYouTuListData, BaseDataBindingHolder<ItemWatchVideoBinding>> {
    public YouTuWatchAdapter() {
        super(R.layout.item_watch_video, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemWatchVideoBinding> holder, @NotNull WatchYouTuListData item) {
        User user;
        String avatar;
        User user2;
        String avatar2;
        User user3;
        String avatar3;
        User user4;
        String avatar4;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemWatchVideoBinding");
        ItemWatchVideoBinding itemWatchVideoBinding = (ItemWatchVideoBinding) dataBinding;
        itemWatchVideoBinding.number.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#F8F9FB", "#F8F9FB", 11, (GradientDrawable.Orientation) null, 8, (Object) null));
        QMUIRadiusImageView qMUIRadiusImageView = itemWatchVideoBinding.image;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "image");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, item.getPicUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        itemWatchVideoBinding.title.setText(item.getTitle());
        ArrayList<User> micUsers = item.getMicUsers();
        if ((micUsers != null ? micUsers.size() : 0) >= 1) {
            itemWatchVideoBinding.oneImage.setVisibility(0);
            itemWatchVideoBinding.number.setText(String.valueOf(item.getRoomUserCount()));
            itemWatchVideoBinding.number.setVisibility(0);
            QMUIRadiusImageView qMUIRadiusImageView2 = itemWatchVideoBinding.oneImage;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "oneImage");
            ArrayList<User> micUsers2 = item.getMicUsers();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, (micUsers2 == null || (user4 = micUsers2.get(0)) == null || (avatar4 = user4.getAvatar()) == null) ? "" : avatar4, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        } else {
            itemWatchVideoBinding.oneImage.setVisibility(8);
            itemWatchVideoBinding.number.setVisibility(4);
        }
        ArrayList<User> micUsers3 = item.getMicUsers();
        if ((micUsers3 != null ? micUsers3.size() : 0) >= 2) {
            itemWatchVideoBinding.twoImage.setVisibility(0);
            QMUIRadiusImageView qMUIRadiusImageView3 = itemWatchVideoBinding.twoImage;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView3, "twoImage");
            ArrayList<User> micUsers4 = item.getMicUsers();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView3, (micUsers4 == null || (user3 = micUsers4.get(1)) == null || (avatar3 = user3.getAvatar()) == null) ? "" : avatar3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        } else {
            itemWatchVideoBinding.twoImage.setVisibility(8);
        }
        ArrayList<User> micUsers5 = item.getMicUsers();
        if ((micUsers5 != null ? micUsers5.size() : 0) >= 3) {
            itemWatchVideoBinding.threeImage.setVisibility(0);
            QMUIRadiusImageView qMUIRadiusImageView4 = itemWatchVideoBinding.threeImage;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView4, "threeImage");
            ArrayList<User> micUsers6 = item.getMicUsers();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView4, (micUsers6 == null || (user2 = micUsers6.get(2)) == null || (avatar2 = user2.getAvatar()) == null) ? "" : avatar2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        } else {
            itemWatchVideoBinding.threeImage.setVisibility(8);
        }
        ArrayList<User> micUsers7 = item.getMicUsers();
        if ((micUsers7 != null ? micUsers7.size() : 0) >= 4) {
            itemWatchVideoBinding.fourImage.setVisibility(0);
            QMUIRadiusImageView qMUIRadiusImageView5 = itemWatchVideoBinding.fourImage;
            Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView5, "fourImage");
            ArrayList<User> micUsers8 = item.getMicUsers();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView5, (micUsers8 == null || (user = micUsers8.get(3)) == null || (avatar = user.getAvatar()) == null) ? "" : avatar, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            return;
        }
        itemWatchVideoBinding.fourImage.setVisibility(8);
    }
}
