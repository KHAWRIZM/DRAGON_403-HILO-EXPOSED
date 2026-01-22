package com.qiahao.nextvideo.ui.gem;

import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.PurchaseDiamondDetail;
import com.qiahao.nextvideo.databinding.ItemGemExchangeBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/gem/GemExchangeAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/PurchaseDiamondDetail;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGemExchangeBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GemExchangeAdapter extends BaseQuickAdapter<PurchaseDiamondDetail, BaseDataBindingHolder<ItemGemExchangeBinding>> {
    public GemExchangeAdapter() {
        super(R.layout.item_gem_exchange, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGemExchangeBinding> holder, @NotNull PurchaseDiamondDetail item) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemGemExchangeBinding itemGemExchangeBinding = (ItemGemExchangeBinding) holder.getDataBinding();
        if (itemGemExchangeBinding != null && (textView2 = itemGemExchangeBinding.moneyNumber) != null) {
            textView2.setText(String.valueOf((int) item.getAmount()));
        }
        ItemGemExchangeBinding itemGemExchangeBinding2 = (ItemGemExchangeBinding) holder.getDataBinding();
        if (itemGemExchangeBinding2 == null || (textView = itemGemExchangeBinding2.rechargeText) == null) {
            return;
        }
        textView.setText(String.valueOf((int) item.getPrice()));
    }
}
