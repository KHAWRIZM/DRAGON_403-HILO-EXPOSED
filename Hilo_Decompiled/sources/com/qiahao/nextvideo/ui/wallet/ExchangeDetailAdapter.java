package com.qiahao.nextvideo.ui.wallet;

import android.annotation.SuppressLint;
import android.graphics.Color;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.ExchangeDetailData;
import com.qiahao.nextvideo.databinding.ItemExchangeDetailBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/ExchangeDetailAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/ExchangeDetailData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemExchangeDetailBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ExchangeDetailAdapter extends BaseQuickAdapter<ExchangeDetailData, BaseDataBindingHolder<ItemExchangeDetailBinding>> {
    public ExchangeDetailAdapter() {
        super(R.layout.item_exchange_detail, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemExchangeDetailBinding> holder, @NotNull ExchangeDetailData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemExchangeDetailBinding");
        ItemExchangeDetailBinding itemExchangeDetailBinding = (ItemExchangeDetailBinding) dataBinding;
        itemExchangeDetailBinding.title.setText(item.getTitle());
        itemExchangeDetailBinding.time.setText(item.getTime());
        itemExchangeDetailBinding.number.setText(item.getNumber());
        if (item.isDiamond()) {
            itemExchangeDetailBinding.number.setTextColor(androidx.core.content.a.getColor(getContext(), 2131099840));
        } else {
            itemExchangeDetailBinding.number.setTextColor(Color.parseColor("#FFA800"));
        }
    }
}
