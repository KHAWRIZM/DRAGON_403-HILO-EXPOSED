package com.qiahao.nextvideo.ui.transfer;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.transfer.TransferRecordData;
import com.qiahao.nextvideo.databinding.ItemTransferRecordBinding;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/SecondRecordAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/transfer/TransferRecordData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemTransferRecordBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SecondRecordAdapter extends BaseQuickAdapter<TransferRecordData, BaseDataBindingHolder<ItemTransferRecordBinding>> {
    public SecondRecordAdapter() {
        super(R.layout.item_transfer_record, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemTransferRecordBinding> holder, @NotNull TransferRecordData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemTransferRecordBinding");
        ItemTransferRecordBinding itemTransferRecordBinding = (ItemTransferRecordBinding) dataBinding;
        TextView textView = itemTransferRecordBinding.title;
        String content = item.getContent();
        if (content == null) {
            content = "";
        }
        textView.setText(content);
        TextView textView2 = itemTransferRecordBinding.time;
        Long timeStamp = item.getTimeStamp();
        textView2.setText(com.qiahao.base_common.utils.f.h((timeStamp != null ? timeStamp.longValue() : 0L) * 1000, com.qiahao.base_common.utils.f.e));
        Long diamond = item.getDiamond();
        if ((diamond != null ? diamond.longValue() : 0L) >= 0) {
            itemTransferRecordBinding.diamond.setText("+" + item.getDiamond());
            itemTransferRecordBinding.diamond.setTextColor(androidx.core.content.a.getColor(getContext(), 2131099868));
        } else {
            itemTransferRecordBinding.diamond.setText(String.valueOf(item.getDiamond()));
            itemTransferRecordBinding.diamond.setTextColor(androidx.core.content.a.getColor(getContext(), 2131099995));
        }
        if (TextUtils.isEmpty(item.getPrCode())) {
            itemTransferRecordBinding.promoterIcon.setVisibility(8);
            itemTransferRecordBinding.promoterId.setVisibility(8);
            return;
        }
        itemTransferRecordBinding.promoterIcon.setVisibility(0);
        itemTransferRecordBinding.promoterId.setVisibility(0);
        TextView textView3 = itemTransferRecordBinding.promoterId;
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{item.getPrCode()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView3.setText(format);
    }
}
