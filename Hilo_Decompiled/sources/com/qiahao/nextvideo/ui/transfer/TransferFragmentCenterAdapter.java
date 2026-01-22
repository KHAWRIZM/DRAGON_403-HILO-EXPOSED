package com.qiahao.nextvideo.ui.transfer;

import android.annotation.SuppressLint;
import android.graphics.drawable.GradientDrawable;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.transfer.TransferRank;
import com.qiahao.nextvideo.databinding.ItemFragmentTransferCenterBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.message.MessageService;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/TransferFragmentCenterAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/transfer/TransferRank;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemFragmentTransferCenterBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TransferFragmentCenterAdapter extends BaseQuickAdapter<TransferRank, BaseDataBindingHolder<ItemFragmentTransferCenterBinding>> {
    public TransferFragmentCenterAdapter() {
        super(R.layout.item_fragment_transfer_center, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemFragmentTransferCenterBinding> holder, @NotNull TransferRank item) {
        String str;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemFragmentTransferCenterBinding");
        ItemFragmentTransferCenterBinding itemFragmentTransferCenterBinding = (ItemFragmentTransferCenterBinding) dataBinding;
        int layoutPosition = holder.getLayoutPosition();
        Integer rank = item.getRank();
        if (rank != null && layoutPosition == rank.intValue()) {
            itemFragmentTransferCenterBinding.constraintLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, getContext(), 2131101214, 2131101214, 0, 0, 5, 5, (GradientDrawable.Orientation) null, 128, (Object) null));
        } else {
            itemFragmentTransferCenterBinding.constraintLayout.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, getContext(), 2131101214, 2131101214, 0, 0, 0, 0, (GradientDrawable.Orientation) null, 128, (Object) null));
        }
        TextView textView = itemFragmentTransferCenterBinding.position;
        Integer rank2 = item.getRank();
        if (rank2 == null || (str = rank2.toString()) == null) {
            str = MessageService.MSG_DB_READY_REPORT;
        }
        textView.setText(str);
        TextView textView2 = itemFragmentTransferCenterBinding.f٦١id;
        String code = item.getCode();
        if (code == null) {
            code = "";
        }
        textView2.setText(code);
        TextView textView3 = itemFragmentTransferCenterBinding.sales;
        Long dollar = item.getDollar();
        long j = 100;
        textView3.setText(String.valueOf((dollar != null ? dollar.longValue() : 0L) / j));
        TextView textView4 = itemFragmentTransferCenterBinding.diamond;
        Long maxDollar = item.getMaxDollar();
        textView4.setText(NumberUtilsKt.rankNumberFormat((maxDollar != null ? maxDollar.longValue() : 0L) / j));
    }
}
