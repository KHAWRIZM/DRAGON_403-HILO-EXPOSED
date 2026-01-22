package com.qiahao.nextvideo.ui.home.discover;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemDiscoverCountryBinding;
import com.qiahao.nextvideo.ui.edition.country.CountryCellUIModel;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/DiscoverCountryAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/ui/edition/country/CountryCellUIModel;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemDiscoverCountryBinding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DiscoverCountryAdapter extends BaseQuickAdapter<CountryCellUIModel, BaseDataBindingHolder<ItemDiscoverCountryBinding>> {
    public DiscoverCountryAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemDiscoverCountryBinding> holder, @NotNull CountryCellUIModel item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemDiscoverCountryBinding");
        ItemDiscoverCountryBinding itemDiscoverCountryBinding = (ItemDiscoverCountryBinding) dataBinding;
        itemDiscoverCountryBinding.constraint.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#F7F7F7", "#F7F7F7", 8, (GradientDrawable.Orientation) null, 8, (Object) null));
        if (!TextUtils.isEmpty(item.getName())) {
            itemDiscoverCountryBinding.shortCountyName.setText(item.getName());
            ImageView imageView = itemDiscoverCountryBinding.countryPic;
            Intrinsics.checkNotNullExpressionValue(imageView, "countryPic");
            ImageKtxKt.loadImage$default(imageView, ImageSizeKt.imageSize(item.getPictureImageUIModel().getImageUrl(), UiKtxKt.toPX(48), UiKtxKt.toPX(30)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            return;
        }
        itemDiscoverCountryBinding.shortCountyName.setText(getContext().getString(2131953418));
        ImageView imageView2 = itemDiscoverCountryBinding.countryPic;
        Intrinsics.checkNotNullExpressionValue(imageView2, "countryPic");
        ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_more1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
    }
}
