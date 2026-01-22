package com.qiahao.nextvideo.ui.home.group.popular;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupTopBannerBean;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ5\u0010\u0013\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/group/popular/GroupTopBannerPagerAdapter;", "Lcom/zhpan/bannerview/e;", "Lcom/qiahao/nextvideo/data/model/GroupTopBannerBean;", "<init>", "()V", "", "viewType", "getLayoutId", "(I)I", "Lcom/qiahao/nextvideo/ui/home/group/popular/TopBannerPagerAdapterListener;", "adListener", "", "setOnChildClickListener", "(Lcom/qiahao/nextvideo/ui/home/group/popular/TopBannerPagerAdapterListener;)V", "Lcom/zhpan/bannerview/f;", "holder", "data", "position", "pageSize", "bindData", "(Lcom/zhpan/bannerview/f;Lcom/qiahao/nextvideo/data/model/GroupTopBannerBean;II)V", "topBannerPagerAdapterListener", "Lcom/qiahao/nextvideo/ui/home/group/popular/TopBannerPagerAdapterListener;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupTopBannerPagerAdapter extends com.zhpan.bannerview.e {
    private TopBannerPagerAdapterListener topBannerPagerAdapterListener;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindData$lambda$0(GroupTopBannerPagerAdapter groupTopBannerPagerAdapter, GroupTopBannerBean groupTopBannerBean, View view) {
        TopBannerPagerAdapterListener topBannerPagerAdapterListener = groupTopBannerPagerAdapter.topBannerPagerAdapterListener;
        if (topBannerPagerAdapterListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("topBannerPagerAdapterListener");
            topBannerPagerAdapterListener = null;
        }
        topBannerPagerAdapterListener.click(groupTopBannerBean);
    }

    @Override // com.zhpan.bannerview.e
    public int getLayoutId(int viewType) {
        return R.layout.item_advertising_pic;
    }

    public final void setOnChildClickListener(@NotNull TopBannerPagerAdapterListener adListener) {
        Intrinsics.checkNotNullParameter(adListener, "adListener");
        this.topBannerPagerAdapterListener = adListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhpan.bannerview.e
    public void bindData(@NotNull com.zhpan.bannerview.f holder, @NotNull final GroupTopBannerBean data, int position, int pageSize) {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        AppCompatImageView findViewById = ((RecyclerView.ViewHolder) holder).itemView.findViewById(R.id.ad_image_view);
        QMUIRadiusImageView findViewById2 = ((RecyclerView.ViewHolder) holder).itemView.findViewById(R.id.oneImage);
        QMUIRadiusImageView findViewById3 = ((RecyclerView.ViewHolder) holder).itemView.findViewById(R.id.twoImage1);
        QMUIRadiusImageView findViewById4 = ((RecyclerView.ViewHolder) holder).itemView.findViewById(R.id.twoImage2);
        QMUIRadiusImageView findViewById5 = ((RecyclerView.ViewHolder) holder).itemView.findViewById(R.id.threeImage1);
        QMUIRadiusImageView findViewById6 = ((RecyclerView.ViewHolder) holder).itemView.findViewById(R.id.threeImage2);
        QMUIRadiusImageView findViewById7 = ((RecyclerView.ViewHolder) holder).itemView.findViewById(R.id.threeImage3);
        Group findViewById8 = ((RecyclerView.ViewHolder) holder).itemView.findViewById(R.id.group3);
        findViewById2.setVisibility(8);
        findViewById3.setVisibility(8);
        findViewById4.setVisibility(8);
        findViewById8.setVisibility(8);
        if (findViewById != null) {
            imageView2 = findViewById4;
            imageView3 = findViewById3;
            imageView = findViewById2;
            ImageKtxKt.loadImage$default(findViewById, data.getBannerUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, Integer.valueOf(R.drawable.group_banner_placeholde), Integer.valueOf(R.drawable.group_banner_placeholde), (c5.g) null, 40958, (Object) null);
        } else {
            imageView = findViewById2;
            imageView2 = findViewById4;
            imageView3 = findViewById3;
        }
        int type = data.getType();
        if (type == 1) {
            imageView.setVisibility(0);
            ArrayList<String> avatars = data.getAvatars();
            if ((avatars != null ? avatars.size() : 0) > 0) {
                Intrinsics.checkNotNull(imageView);
                ArrayList<String> avatars2 = data.getAvatars();
                String image100 = ImageSizeKt.image100(avatars2 != null ? avatars2.get(0) : null);
                ImageKtxKt.loadImage$default(imageView, image100 == null ? "" : image100, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
        } else if (type == 2) {
            ImageView imageView4 = imageView3;
            imageView4.setVisibility(0);
            ImageView imageView5 = imageView2;
            imageView5.setVisibility(0);
            ArrayList<String> avatars3 = data.getAvatars();
            if ((avatars3 != null ? avatars3.size() : 0) > 0) {
                Intrinsics.checkNotNull(imageView4);
                ArrayList<String> avatars4 = data.getAvatars();
                String image1002 = ImageSizeKt.image100(avatars4 != null ? avatars4.get(0) : null);
                if (image1002 == null) {
                    image1002 = "";
                }
                ImageKtxKt.loadImage$default(imageView4, image1002, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
            ArrayList<String> avatars5 = data.getAvatars();
            if ((avatars5 != null ? avatars5.size() : 0) > 1) {
                Intrinsics.checkNotNull(imageView5);
                ArrayList<String> avatars6 = data.getAvatars();
                String image1003 = ImageSizeKt.image100(avatars6 != null ? avatars6.get(1) : null);
                ImageKtxKt.loadImage$default(imageView5, image1003 == null ? "" : image1003, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
        } else if (type == 3) {
            findViewById8.setVisibility(0);
            ArrayList<String> avatars7 = data.getAvatars();
            if ((avatars7 != null ? avatars7.size() : 0) > 0) {
                Intrinsics.checkNotNull(findViewById5);
                ArrayList<String> avatars8 = data.getAvatars();
                String image1004 = ImageSizeKt.image100(avatars8 != null ? avatars8.get(0) : null);
                ImageKtxKt.loadImage$default(findViewById5, image1004 == null ? "" : image1004, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
            ArrayList<String> avatars9 = data.getAvatars();
            if ((avatars9 != null ? avatars9.size() : 0) > 1) {
                Intrinsics.checkNotNull(findViewById6);
                ArrayList<String> avatars10 = data.getAvatars();
                String image1005 = ImageSizeKt.image100(avatars10 != null ? avatars10.get(1) : null);
                ImageKtxKt.loadImage$default(findViewById6, image1005 == null ? "" : image1005, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
            ArrayList<String> avatars11 = data.getAvatars();
            if ((avatars11 != null ? avatars11.size() : 0) > 2) {
                Intrinsics.checkNotNull(findViewById7);
                ArrayList<String> avatars12 = data.getAvatars();
                String image1006 = ImageSizeKt.image100(avatars12 != null ? avatars12.get(2) : null);
                ImageKtxKt.loadImage$default(findViewById7, image1006 == null ? "" : image1006, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
            }
        }
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.group.popular.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GroupTopBannerPagerAdapter.bindData$lambda$0(GroupTopBannerPagerAdapter.this, data, view);
                }
            });
        }
    }
}
