package com.qiahao.nextvideo.ui.gem;

import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.network.model.UserCostDiamondsDetail;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemGemDetailsBinding;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/gem/GemDetailsAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/base_common/network/model/UserCostDiamondsDetail;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGemDetailsBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GemDetailsAdapter extends BaseQuickAdapter<UserCostDiamondsDetail, BaseDataBindingHolder<ItemGemDetailsBinding>> {
    public GemDetailsAdapter() {
        super(R.layout.item_gem_details, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGemDetailsBinding> holder, @NotNull UserCostDiamondsDetail item) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        String str = item.getOperationType() == 1 ? "+" : "-";
        ItemGemDetailsBinding itemGemDetailsBinding = (ItemGemDetailsBinding) holder.getDataBinding();
        if (itemGemDetailsBinding != null && (appCompatTextView3 = itemGemDetailsBinding.title) != null) {
            String desc = item.getDesc();
            if (desc == null) {
                desc = "";
            }
            appCompatTextView3.setText(desc);
        }
        ItemGemDetailsBinding itemGemDetailsBinding2 = (ItemGemDetailsBinding) holder.getDataBinding();
        if (itemGemDetailsBinding2 != null && (appCompatTextView2 = itemGemDetailsBinding2.time) != null) {
            appCompatTextView2.setText(DateTimeUtilityKt.getDateHmsInSecond$default(item.getCreatedAt(), (Locale) null, (String) null, 6, (Object) null));
        }
        ItemGemDetailsBinding itemGemDetailsBinding3 = (ItemGemDetailsBinding) holder.getDataBinding();
        if (itemGemDetailsBinding3 == null || (appCompatTextView = itemGemDetailsBinding3.number) == null) {
            return;
        }
        appCompatTextView.setText(str + item.getAmount() + " " + getContext().getString(2131952860));
    }
}
