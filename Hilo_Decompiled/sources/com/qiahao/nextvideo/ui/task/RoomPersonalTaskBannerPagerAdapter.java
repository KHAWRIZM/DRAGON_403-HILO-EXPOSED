package com.qiahao.nextvideo.ui.task;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.RoomAndPersonalBannerBean;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ5\u0010\u000f\u001a\u00020\u000e2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u000f\u0010\u0010R?\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/qiahao/nextvideo/ui/task/RoomPersonalTaskBannerPagerAdapter;", "Lcom/zhpan/bannerview/e;", "Lcom/qiahao/nextvideo/data/model/RoomAndPersonalBannerBean;", "<init>", "()V", "", "viewType", "getLayoutId", "(I)I", "Lcom/zhpan/bannerview/f;", "holder", "data", "position", "pageSize", "", "bindData", "(Lcom/zhpan/bannerview/f;Lcom/qiahao/nextvideo/data/model/RoomAndPersonalBannerBean;II)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "topBannerPagerAdapterListener", "Lkotlin/jvm/functions/Function1;", "getTopBannerPagerAdapterListener", "()Lkotlin/jvm/functions/Function1;", "setTopBannerPagerAdapterListener", "(Lkotlin/jvm/functions/Function1;)V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RoomPersonalTaskBannerPagerAdapter extends com.zhpan.bannerview.e {

    @Nullable
    private Function1<? super RoomAndPersonalBannerBean, Unit> topBannerPagerAdapterListener;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindData$lambda$0(RoomPersonalTaskBannerPagerAdapter roomPersonalTaskBannerPagerAdapter, RoomAndPersonalBannerBean roomAndPersonalBannerBean, View view) {
        Function1<? super RoomAndPersonalBannerBean, Unit> function1 = roomPersonalTaskBannerPagerAdapter.topBannerPagerAdapterListener;
        if (function1 != null) {
            function1.invoke(roomAndPersonalBannerBean);
        }
    }

    @Override // com.zhpan.bannerview.e
    public int getLayoutId(int viewType) {
        return R.layout.item_advertising_pic1;
    }

    @Nullable
    public final Function1<RoomAndPersonalBannerBean, Unit> getTopBannerPagerAdapterListener() {
        return this.topBannerPagerAdapterListener;
    }

    public final void setTopBannerPagerAdapterListener(@Nullable Function1<? super RoomAndPersonalBannerBean, Unit> function1) {
        this.topBannerPagerAdapterListener = function1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhpan.bannerview.e
    public void bindData(@NotNull com.zhpan.bannerview.f holder, @NotNull final RoomAndPersonalBannerBean data, int position, int pageSize) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        AppCompatImageView findViewById = ((RecyclerView.ViewHolder) holder).itemView.findViewById(R.id.ad_image_view);
        if (findViewById != null) {
            ImageKtxKt.loadImage$default(findViewById, ImageSizeKt.imageSize(data.getImage(), UiKtxKt.toPX(345)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, Integer.valueOf(R.drawable.group_banner_placeholde), Integer.valueOf(R.drawable.group_banner_placeholde), (c5.g) null, 40958, (Object) null);
        }
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.task.h1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomPersonalTaskBannerPagerAdapter.bindData$lambda$0(RoomPersonalTaskBannerPagerAdapter.this, data, view);
                }
            });
        }
    }
}
