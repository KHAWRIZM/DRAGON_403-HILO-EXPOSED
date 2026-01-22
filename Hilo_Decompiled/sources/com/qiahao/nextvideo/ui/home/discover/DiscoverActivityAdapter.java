package com.qiahao.nextvideo.ui.home.discover;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemActivityBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/DiscoverActivityAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/base_common/model/ActivityDetailData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemActivityBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DiscoverActivityAdapter extends BaseQuickAdapter<ActivityDetailData, BaseDataBindingHolder<ItemActivityBinding>> {
    public DiscoverActivityAdapter() {
        super(R.layout.item_activity, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemActivityBinding> holder, @NotNull ActivityDetailData item) {
        AppCompatTextView appCompatTextView;
        ImageView imageView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        ImageView imageView2;
        QMUIRadiusImageView2 qMUIRadiusImageView2;
        AppCompatTextView appCompatTextView4;
        ImageView imageView3;
        AppCompatTextView appCompatTextView5;
        AppCompatTextView appCompatTextView6;
        ImageView imageView4;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemActivityBinding itemActivityBinding = (ItemActivityBinding) holder.getDataBinding();
        if (itemActivityBinding != null && (imageView4 = itemActivityBinding.image) != null) {
            ImageKtxKt.loadImage$default(imageView4, item.getBanner(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231930, 2131231930, (c5.g) null, 40958, (Object) null);
        }
        ItemActivityBinding itemActivityBinding2 = (ItemActivityBinding) holder.getDataBinding();
        if (itemActivityBinding2 != null && (appCompatTextView6 = itemActivityBinding2.title) != null) {
            appCompatTextView6.setText(item.getTheme());
        }
        ItemActivityBinding itemActivityBinding3 = (ItemActivityBinding) holder.getDataBinding();
        if (itemActivityBinding3 != null && (appCompatTextView5 = itemActivityBinding3.content) != null) {
            appCompatTextView5.setText(item.getGroupName());
        }
        ItemActivityBinding itemActivityBinding4 = (ItemActivityBinding) holder.getDataBinding();
        if (itemActivityBinding4 != null && (imageView3 = itemActivityBinding4.stateImage) != null) {
            imageView3.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), item.getActivityTypeIcon()));
        }
        ItemActivityBinding itemActivityBinding5 = (ItemActivityBinding) holder.getDataBinding();
        if (itemActivityBinding5 != null && (appCompatTextView4 = itemActivityBinding5.stateContent) != null) {
            appCompatTextView4.setText(item.getActivityTypeText());
        }
        ItemActivityBinding itemActivityBinding6 = (ItemActivityBinding) holder.getDataBinding();
        if (itemActivityBinding6 != null && (qMUIRadiusImageView2 = itemActivityBinding6.countryIcon) != null) {
            ImageKtxKt.loadImage$default(qMUIRadiusImageView2, ImageSizeKt.image100(item.getCountryIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        }
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        Long startAt = item.getStartAt();
        long longValue = startAt != null ? startAt.longValue() : 0L;
        Long endAt = item.getEndAt();
        if (hiloUtils.checkActivityStart(longValue, endAt != null ? endAt.longValue() : 0L) == 1) {
            ItemActivityBinding itemActivityBinding7 = (ItemActivityBinding) holder.getDataBinding();
            if (itemActivityBinding7 != null && (imageView2 = itemActivityBinding7.timeImage) != null) {
                imageView2.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), 2131231681));
            }
            ItemActivityBinding itemActivityBinding8 = (ItemActivityBinding) holder.getDataBinding();
            if (itemActivityBinding8 != null && (appCompatTextView3 = itemActivityBinding8.timeContent) != null) {
                appCompatTextView3.setTextColor(androidx.core.content.a.getColor(getContext(), 2131100001));
            }
        } else {
            ItemActivityBinding itemActivityBinding9 = (ItemActivityBinding) holder.getDataBinding();
            if (itemActivityBinding9 != null && (imageView = itemActivityBinding9.timeImage) != null) {
                imageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.discover_time));
            }
            ItemActivityBinding itemActivityBinding10 = (ItemActivityBinding) holder.getDataBinding();
            if (itemActivityBinding10 != null && (appCompatTextView = itemActivityBinding10.timeContent) != null) {
                appCompatTextView.setTextColor(androidx.core.content.a.getColor(getContext(), 2131101214));
            }
        }
        ItemActivityBinding itemActivityBinding11 = (ItemActivityBinding) holder.getDataBinding();
        if (itemActivityBinding11 == null || (appCompatTextView2 = itemActivityBinding11.timeContent) == null) {
            return;
        }
        Long startAt2 = item.getStartAt();
        long longValue2 = startAt2 != null ? startAt2.longValue() : 0L;
        Long endAt2 = item.getEndAt();
        appCompatTextView2.setText(hiloUtils.formatActivityTime(longValue2, endAt2 != null ? endAt2.longValue() : 0L));
    }
}
