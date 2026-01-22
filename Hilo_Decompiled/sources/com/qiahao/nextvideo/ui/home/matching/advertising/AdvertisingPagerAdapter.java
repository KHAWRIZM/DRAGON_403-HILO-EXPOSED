package com.qiahao.nextvideo.ui.home.matching.advertising;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.ActivityIngResponseBeanItem;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import com.zhpan.bannerview.e;
import com.zhpan.bannerview.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ5\u0010\u0013\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\t8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/matching/advertising/AdvertisingPagerAdapter;", "Lcom/zhpan/bannerview/e;", "Lcom/qiahao/nextvideo/data/model/ActivityIngResponseBeanItem;", "<init>", "()V", "", "viewType", "getLayoutId", "(I)I", "Lcom/qiahao/nextvideo/ui/home/matching/advertising/AdvertisingPagerAdapterListener;", "adListener", "", "setOnChildClickListener", "(Lcom/qiahao/nextvideo/ui/home/matching/advertising/AdvertisingPagerAdapterListener;)V", "Lcom/zhpan/bannerview/f;", "holder", "data", "position", "pageSize", "bindData", "(Lcom/zhpan/bannerview/f;Lcom/qiahao/nextvideo/data/model/ActivityIngResponseBeanItem;II)V", "advertisingPagerAdapterListener", "Lcom/qiahao/nextvideo/ui/home/matching/advertising/AdvertisingPagerAdapterListener;", "getAdvertisingPagerAdapterListener", "()Lcom/qiahao/nextvideo/ui/home/matching/advertising/AdvertisingPagerAdapterListener;", "setAdvertisingPagerAdapterListener", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AdvertisingPagerAdapter extends e {

    @NotNull
    private static final String TAG = "AdvertisingView";
    public AdvertisingPagerAdapterListener advertisingPagerAdapterListener;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindData$lambda$1(AdvertisingPagerAdapter advertisingPagerAdapter, ActivityIngResponseBeanItem activityIngResponseBeanItem, View view) {
        advertisingPagerAdapter.getAdvertisingPagerAdapterListener().click(activityIngResponseBeanItem);
    }

    @NotNull
    public final AdvertisingPagerAdapterListener getAdvertisingPagerAdapterListener() {
        AdvertisingPagerAdapterListener advertisingPagerAdapterListener = this.advertisingPagerAdapterListener;
        if (advertisingPagerAdapterListener != null) {
            return advertisingPagerAdapterListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("advertisingPagerAdapterListener");
        return null;
    }

    @Override // com.zhpan.bannerview.e
    public int getLayoutId(int viewType) {
        return R.layout.item_advertising_pic;
    }

    public final void setAdvertisingPagerAdapterListener(@NotNull AdvertisingPagerAdapterListener advertisingPagerAdapterListener) {
        Intrinsics.checkNotNullParameter(advertisingPagerAdapterListener, "<set-?>");
        this.advertisingPagerAdapterListener = advertisingPagerAdapterListener;
    }

    public final void setOnChildClickListener(@NotNull AdvertisingPagerAdapterListener adListener) {
        Intrinsics.checkNotNullParameter(adListener, "adListener");
        setAdvertisingPagerAdapterListener(adListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.zhpan.bannerview.e
    public void bindData(@NotNull f holder, @NotNull final ActivityIngResponseBeanItem data, int position, int pageSize) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(data, "data");
        AppCompatImageView findViewById = ((RecyclerView.ViewHolder) holder).itemView.findViewById(R.id.ad_image_view);
        if (findViewById != null) {
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            String iconUrl = data.getIconUrl();
            ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
            Dimens dimens = Dimens.INSTANCE;
            fill.setWidth(dimens.dpToPx(63));
            fill.setHeight(dimens.dpToPx(63));
            Unit unit = Unit.INSTANCE;
            ViewUtilitiesKt.bind$default(findViewById, companion.displayImage(iconUrl, fill), null, 2, null);
        }
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.qiahao.nextvideo.ui.home.matching.advertising.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AdvertisingPagerAdapter.bindData$lambda$1(AdvertisingPagerAdapter.this, data, view);
                }
            });
        }
    }
}
