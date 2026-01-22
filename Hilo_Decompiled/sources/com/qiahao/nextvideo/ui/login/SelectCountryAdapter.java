package com.qiahao.nextvideo.ui.login;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.oudi.adapter.BaseMultiItemAdapter;
import com.qiahao.base_common.model.common.Country;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.SelectCountryData;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView2;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0014¨\u0006\n"}, d2 = {"Lcom/qiahao/nextvideo/ui/login/SelectCountryAdapter;", "Lcom/oudi/adapter/BaseMultiItemAdapter;", "Lcom/qiahao/nextvideo/data/model/SelectCountryData;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SelectCountryAdapter extends BaseMultiItemAdapter<SelectCountryData, BaseViewHolder> {
    public SelectCountryAdapter() {
        super((List) null, 1, (DefaultConstructorMarker) null);
        addItemType(2, R.layout.item_select_country);
        addItemType(1, R.layout.item_select_country_title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseViewHolder holder, @NotNull SelectCountryData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int itemType = item.getItemType();
        if (itemType == 1) {
            Country country = item.getCountry();
            holder.setText(2131365189, country != null ? country.getName() : null);
            return;
        }
        if (itemType != 2) {
            return;
        }
        Country country2 = item.getCountry();
        holder.setText(2131364012, country2 != null ? country2.getName() : null);
        QMUIRadiusImageView2 viewOrNull = holder.getViewOrNull(2131363201);
        if (viewOrNull != null) {
            Country country3 = item.getCountry();
            ImageKtxKt.loadImage$default(viewOrNull, ImageSizeKt.image100(country3 != null ? country3.getIcon() : null), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        }
        Country country4 = item.getCountry();
        holder.setText(R.id.phoneNumber, "+" + (country4 != null ? country4.getAreaCode() : null));
    }
}
