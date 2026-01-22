package com.qiahao.nextvideo.ui.gem;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.PurchaseDiamondDetail;
import com.qiahao.nextvideo.databinding.ItemGemBinding;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/gem/GemStoreAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/PurchaseDiamondDetail;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGemBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GemStoreAdapter extends BaseQuickAdapter<PurchaseDiamondDetail, BaseDataBindingHolder<ItemGemBinding>> {
    public GemStoreAdapter() {
        super(R.layout.item_gem, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGemBinding> holder, @NotNull PurchaseDiamondDetail item) {
        AppCompatTextView appCompatTextView;
        TextView textView;
        AppCompatTextView appCompatTextView2;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemGemBinding itemGemBinding = (ItemGemBinding) holder.getDataBinding();
        if (itemGemBinding != null && (imageView = itemGemBinding.gemIcon) != null) {
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, item.getResId(), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        }
        ItemGemBinding itemGemBinding2 = (ItemGemBinding) holder.getDataBinding();
        if (itemGemBinding2 != null && (appCompatTextView2 = itemGemBinding2.number) != null) {
            appCompatTextView2.setText(String.valueOf((int) item.getAmount()));
        }
        ItemGemBinding itemGemBinding3 = (ItemGemBinding) holder.getDataBinding();
        if (itemGemBinding3 != null && (textView = itemGemBinding3.rechargeText) != null) {
            textView.setText(item.getShowPrice());
        }
        ItemGemBinding itemGemBinding4 = (ItemGemBinding) holder.getDataBinding();
        if (itemGemBinding4 == null || (appCompatTextView = itemGemBinding4.title) == null) {
            return;
        }
        appCompatTextView.setText(item.getDiscount());
    }
}
