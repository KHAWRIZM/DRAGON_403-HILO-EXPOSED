package com.qiahao.nextvideo.room.luckybox;

import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.nextvideo.data.model.LuckyBoxRecordBean;
import com.qiahao.nextvideo.databinding.ItemGroupLuckyBoxWinningBinding;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxWinningRecordAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/LuckyBoxRecordBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGroupLuckyBoxWinningBinding;", "layoutResId", "", "<init>", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyBoxWinningRecordAdapter extends BaseQuickAdapter<LuckyBoxRecordBean, BaseDataBindingHolder<ItemGroupLuckyBoxWinningBinding>> {
    public LuckyBoxWinningRecordAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGroupLuckyBoxWinningBinding> holder, @NotNull LuckyBoxRecordBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupLuckyBoxWinningBinding");
        ItemGroupLuckyBoxWinningBinding itemGroupLuckyBoxWinningBinding = (ItemGroupLuckyBoxWinningBinding) dataBinding;
        itemGroupLuckyBoxWinningBinding.winDiamond.setText(item.getAwardN() + " " + getContext().getString(2131952567));
        itemGroupLuckyBoxWinningBinding.winTime.setText(String.valueOf(DateTimeUtilityKt.getDateInSecs$default(item.getCreatedTime(), (Locale) null, "MM-dd HH:mm", 2, (Object) null)));
    }
}
