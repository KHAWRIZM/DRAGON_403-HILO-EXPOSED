package com.qiahao.nextvideo.ui.transfer;

import android.annotation.SuppressLint;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.DealerDiamondConfig;
import com.qiahao.nextvideo.databinding.ItemFragmentTransferBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/transfer/TransferFragmentAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemFragmentTransferBinding;", "<init>", "()V", "mTransferType", "", "getMTransferType", "()I", "setMTransferType", "(I)V", "mSelect", "getMSelect", "()Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;", "setMSelect", "(Lcom/qiahao/nextvideo/data/model/DealerDiamondConfig;)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class TransferFragmentAdapter extends BaseQuickAdapter<DealerDiamondConfig, BaseDataBindingHolder<ItemFragmentTransferBinding>> {

    @Nullable
    private DealerDiamondConfig mSelect;
    private int mTransferType;

    public TransferFragmentAdapter() {
        super(R.layout.item_fragment_transfer, (List) null, 2, (DefaultConstructorMarker) null);
    }

    @Nullable
    public final DealerDiamondConfig getMSelect() {
        return this.mSelect;
    }

    public final int getMTransferType() {
        return this.mTransferType;
    }

    public final void setMSelect(@Nullable DealerDiamondConfig dealerDiamondConfig) {
        this.mSelect = dealerDiamondConfig;
    }

    public final void setMTransferType(int i) {
        this.mTransferType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemFragmentTransferBinding> holder, @NotNull DealerDiamondConfig item) {
        ConstraintLayout constraintLayout;
        ConstraintLayout constraintLayout2;
        TextView textView;
        TextView textView2;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemFragmentTransferBinding itemFragmentTransferBinding = (ItemFragmentTransferBinding) holder.getDataBinding();
        if (itemFragmentTransferBinding != null && (imageView = itemFragmentTransferBinding.icon) != null) {
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), this.mTransferType == 0 ? R.drawable.bill_diamond : 2131231913));
        }
        ItemFragmentTransferBinding itemFragmentTransferBinding2 = (ItemFragmentTransferBinding) holder.getDataBinding();
        if (itemFragmentTransferBinding2 != null && (textView2 = itemFragmentTransferBinding2.diamond) != null) {
            textView2.setText(String.valueOf(item.getDiamond()));
        }
        ItemFragmentTransferBinding itemFragmentTransferBinding3 = (ItemFragmentTransferBinding) holder.getDataBinding();
        if (itemFragmentTransferBinding3 != null && (textView = itemFragmentTransferBinding3.dollar) != null) {
            textView.setText("$ " + (item.getDollar() / 100.0f));
        }
        DealerDiamondConfig dealerDiamondConfig = this.mSelect;
        if (dealerDiamondConfig != null && dealerDiamondConfig.getId() == item.getId()) {
            ItemFragmentTransferBinding itemFragmentTransferBinding4 = (ItemFragmentTransferBinding) holder.getDataBinding();
            if (itemFragmentTransferBinding4 == null || (constraintLayout2 = itemFragmentTransferBinding4.constraintLayout) == null) {
                return;
            }
            constraintLayout2.setBackgroundResource(2131233559);
            return;
        }
        ItemFragmentTransferBinding itemFragmentTransferBinding5 = (ItemFragmentTransferBinding) holder.getDataBinding();
        if (itemFragmentTransferBinding5 == null || (constraintLayout = itemFragmentTransferBinding5.constraintLayout) == null) {
            return;
        }
        constraintLayout.setBackgroundResource(2131233561);
    }
}
