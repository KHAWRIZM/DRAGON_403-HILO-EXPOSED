package com.qiahao.nextvideo.ui.home.discover;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemCountryBinding;
import com.qiahao.nextvideo.ui.edition.country.CountryCellUIModel;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/CountryAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/ui/edition/country/CountryCellUIModel;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemCountryBinding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "item", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CountryAdapter extends BaseQuickAdapter<CountryCellUIModel, BaseDataBindingHolder<ItemCountryBinding>> {

    @NotNull
    private static final String TAG = "DiscoverCountryAdapter";

    public CountryAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemCountryBinding> holder, @NotNull CountryCellUIModel item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemCountryBinding");
        ItemCountryBinding itemCountryBinding = (ItemCountryBinding) dataBinding;
        Log.d(TAG, "convert: ");
        if (!TextUtils.isEmpty(item.getName())) {
            itemCountryBinding.shortCountyName.setText(item.getName());
            if (TextUtils.isEmpty(item.getPictureImageUIModel().getImageUrl())) {
                return;
            }
            ImageView imageView = itemCountryBinding.countryPic;
            Intrinsics.checkNotNullExpressionValue(imageView, "countryPic");
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            String imageUrl = item.getPictureImageUIModel().getImageUrl();
            ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
            Dimens dimens = Dimens.INSTANCE;
            fill.setWidth(dimens.dpToPx(30));
            fill.setHeight(dimens.dpToPx(20));
            Unit unit = Unit.INSTANCE;
            ViewUtilitiesKt.bind(imageView, companion.displayImage(imageUrl, fill));
            return;
        }
        itemCountryBinding.shortCountyName.setText(getContext().getString(2131953418));
        ImageView imageView2 = itemCountryBinding.countryPic;
        Intrinsics.checkNotNullExpressionValue(imageView2, "countryPic");
        ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_more1), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
    }
}
