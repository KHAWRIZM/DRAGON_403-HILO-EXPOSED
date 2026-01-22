package com.qiahao.nextvideo.room.view;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GroupTopBannerBean;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ5\u0010\u0013\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/room/view/GroupBannerPagerAdapter;", "Lcom/zhpan/bannerview/e;", "Lcom/qiahao/nextvideo/data/model/GroupTopBannerBean;", "<init>", "()V", "", "viewType", "getLayoutId", "(I)I", "Lcom/qiahao/nextvideo/room/view/GroupBannerPagerAdapterListener;", "adListener", "", "setOnChildClickListener", "(Lcom/qiahao/nextvideo/room/view/GroupBannerPagerAdapterListener;)V", "Lcom/zhpan/bannerview/f;", "holder", "data", "position", "pageSize", "bindData", "(Lcom/zhpan/bannerview/f;Lcom/qiahao/nextvideo/data/model/GroupTopBannerBean;II)V", "groupBannerPagerAdapterListener", "Lcom/qiahao/nextvideo/room/view/GroupBannerPagerAdapterListener;", "getGroupBannerPagerAdapterListener", "()Lcom/qiahao/nextvideo/room/view/GroupBannerPagerAdapterListener;", "setGroupBannerPagerAdapterListener", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupBannerPagerAdapter extends com.zhpan.bannerview.e {

    @NotNull
    private static final String TAG = "AdvertisingView";
    public GroupBannerPagerAdapterListener groupBannerPagerAdapterListener;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindData$lambda$0(GroupBannerPagerAdapter groupBannerPagerAdapter, GroupTopBannerBean groupTopBannerBean, View view) {
        groupBannerPagerAdapter.getGroupBannerPagerAdapterListener().click(groupTopBannerBean);
    }

    @NotNull
    public final GroupBannerPagerAdapterListener getGroupBannerPagerAdapterListener() {
        GroupBannerPagerAdapterListener groupBannerPagerAdapterListener = this.groupBannerPagerAdapterListener;
        if (groupBannerPagerAdapterListener != null) {
            return groupBannerPagerAdapterListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("groupBannerPagerAdapterListener");
        return null;
    }

    @Override // com.zhpan.bannerview.e
    public int getLayoutId(int viewType) {
        return R.layout.item_advertising_pic;
    }

    public final void setGroupBannerPagerAdapterListener(@NotNull GroupBannerPagerAdapterListener groupBannerPagerAdapterListener) {
        Intrinsics.checkNotNullParameter(groupBannerPagerAdapterListener, "<set-?>");
        this.groupBannerPagerAdapterListener = groupBannerPagerAdapterListener;
    }

    public final void setOnChildClickListener(@NotNull GroupBannerPagerAdapterListener adListener) {
        Intrinsics.checkNotNullParameter(adListener, "adListener");
        setGroupBannerPagerAdapterListener(adListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhpan.bannerview.e
    public void bindData(@NotNull com.zhpan.bannerview.f holder, @NotNull final GroupTopBannerBean data, int position, int pageSize) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        AppCompatImageView findViewById = ((RecyclerView.ViewHolder) holder).itemView.findViewById(R.id.ad_image_view);
        Intrinsics.checkNotNull(findViewById);
        ImageKtxKt.loadImage$default(findViewById, ImageSizeKt.image100(data.getBannerUrl()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.room.view.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GroupBannerPagerAdapter.bindData$lambda$0(GroupBannerPagerAdapter.this, data, view);
            }
        });
    }
}
