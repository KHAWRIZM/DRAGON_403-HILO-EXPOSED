package com.qiahao.nextvideo.room.redEnvelope;

import android.annotation.SuppressLint;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.room.EnvelopeRecordData;
import com.qiahao.nextvideo.databinding.ItemRedEnvelopeDetailBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/room/redEnvelope/RedEnvelopeDetailAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/room/EnvelopeRecordData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemRedEnvelopeDetailBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class RedEnvelopeDetailAdapter extends BaseQuickAdapter<EnvelopeRecordData, BaseDataBindingHolder<ItemRedEnvelopeDetailBinding>> {
    public RedEnvelopeDetailAdapter() {
        super(R.layout.item_red_envelope_detail, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemRedEnvelopeDetailBinding> holder, @NotNull EnvelopeRecordData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRedEnvelopeDetailBinding");
        ItemRedEnvelopeDetailBinding itemRedEnvelopeDetailBinding = (ItemRedEnvelopeDetailBinding) dataBinding;
        itemRedEnvelopeDetailBinding.diamond.setText("+" + item.getDiamond());
        itemRedEnvelopeDetailBinding.title.setText(item.getMsg());
        TextView textView = itemRedEnvelopeDetailBinding.time;
        Long unixTime = item.getUnixTime();
        textView.setText(com.qiahao.base_common.utils.f.h((unixTime != null ? unixTime.longValue() : 0L) * 1000, com.qiahao.base_common.utils.f.e));
    }
}
