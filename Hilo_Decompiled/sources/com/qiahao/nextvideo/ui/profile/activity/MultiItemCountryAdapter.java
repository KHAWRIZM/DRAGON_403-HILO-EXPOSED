package com.qiahao.nextvideo.ui.profile.activity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.EditCountryData;
import com.qiahao.nextvideo.databinding.EditCountryBinding;
import com.qiahao.nextvideo.databinding.EditCountryTitleBinding;
import com.qiahao.nextvideo.databinding.ItemGroupPopular1Binding;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/profile/activity/MultiItemCountryAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/EditCountryData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGroupPopular1Binding;", "data", "", "<init>", "(Ljava/util/List;)V", "convert", "", "holder", "bean", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MultiItemCountryAdapter extends BaseMultiItemQuickAdapter<EditCountryData, BaseDataBindingHolder<ItemGroupPopular1Binding>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiItemCountryAdapter(@NotNull List<EditCountryData> list) {
        super(list);
        Intrinsics.checkNotNullParameter(list, "data");
        addItemType(0, R.layout.edit_country);
        addItemType(1, R.layout.edit_country_title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGroupPopular1Binding> holder, @NotNull EditCountryData bean) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(bean, "bean");
        int itemViewType = holder.getItemViewType();
        if (itemViewType != 0) {
            if (itemViewType != 1) {
                return;
            }
            ViewDataBinding dataBinding = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.EditCountryTitleBinding");
            ((EditCountryTitleBinding) dataBinding).countryTagTextView.setText(bean.getName());
            return;
        }
        ViewDataBinding dataBinding2 = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding2, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.EditCountryBinding");
        EditCountryBinding editCountryBinding = (EditCountryBinding) dataBinding2;
        editCountryBinding.countryNameTextView.setText(bean.getName());
        AppCompatImageView appCompatImageView = editCountryBinding.countryTagImageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "countryTagImageView");
        ImageKtxKt.loadImage$default(appCompatImageView, bean.getIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
    }
}
