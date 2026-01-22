package com.qiahao.nextvideo.room.redEnvelope;

import android.annotation.SuppressLint;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.room.EnvelopeRecordData;
import com.qiahao.nextvideo.databinding.ItemRedEnvelopeRecordBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeRecordAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/room/EnvelopeRecordData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemRedEnvelopeRecordBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RedEnvelopeRecordAdapter extends BaseQuickAdapter<EnvelopeRecordData, BaseDataBindingHolder<ItemRedEnvelopeRecordBinding>> {
    public RedEnvelopeRecordAdapter() {
        super(R.layout.item_red_envelope_record, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemRedEnvelopeRecordBinding> holder, @NotNull EnvelopeRecordData item) {
        StringBuilder sb2;
        StringBuilder sb3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRedEnvelopeRecordBinding");
        ItemRedEnvelopeRecordBinding itemRedEnvelopeRecordBinding = (ItemRedEnvelopeRecordBinding) dataBinding;
        itemRedEnvelopeRecordBinding.title.setText(item.getMsg());
        TextView textView = itemRedEnvelopeRecordBinding.time;
        Long unixTime = item.getUnixTime();
        textView.setText(com.qiahao.base_common.utils.f.h((unixTime != null ? unixTime.longValue() : 0L) * 1000, com.qiahao.base_common.utils.f.e));
        Integer type = item.getType();
        if (type != null && type.intValue() == 1) {
            itemRedEnvelopeRecordBinding.diamond.setVisibility(8);
            itemRedEnvelopeRecordBinding.diamondImg.setVisibility(8);
            itemRedEnvelopeRecordBinding.arrowText.setVisibility(0);
            itemRedEnvelopeRecordBinding.arrowImg.setVisibility(0);
            TextView textView2 = itemRedEnvelopeRecordBinding.arrowText;
            boolean rightToLeftDirection = HiloUtils.INSTANCE.getRightToLeftDirection();
            Integer diamond = item.getDiamond();
            if (rightToLeftDirection) {
                sb3 = new StringBuilder();
                sb3.append(diamond);
                sb3.append("-");
            } else {
                sb3 = new StringBuilder();
                sb3.append("-");
                sb3.append(diamond);
            }
            textView2.setText(sb3.toString());
            return;
        }
        TextView textView3 = itemRedEnvelopeRecordBinding.diamond;
        boolean rightToLeftDirection2 = HiloUtils.INSTANCE.getRightToLeftDirection();
        Integer diamond2 = item.getDiamond();
        if (rightToLeftDirection2) {
            sb2 = new StringBuilder();
            sb2.append(diamond2);
            sb2.append("+");
        } else {
            sb2 = new StringBuilder();
            sb2.append("+");
            sb2.append(diamond2);
        }
        textView3.setText(sb2.toString());
        itemRedEnvelopeRecordBinding.diamond.setVisibility(0);
        itemRedEnvelopeRecordBinding.diamondImg.setVisibility(0);
        itemRedEnvelopeRecordBinding.arrowImg.setVisibility(8);
        itemRedEnvelopeRecordBinding.arrowText.setVisibility(8);
    }
}
