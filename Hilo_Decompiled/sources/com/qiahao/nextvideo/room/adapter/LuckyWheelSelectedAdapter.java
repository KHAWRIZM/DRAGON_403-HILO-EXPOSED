package com.qiahao.nextvideo.room.adapter;

import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.GridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.LuckyWheelDiamondConfig;
import com.qiahao.nextvideo.databinding.ItemLuckyWheelSelectBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/LuckyWheelSelectedAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/LuckyWheelDiamondConfig;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemLuckyWheelSelectBinding;", "layout", "", "<init>", "(I)V", "selectId", "getSelectId", "()I", "setSelectId", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyWheelSelectedAdapter extends BaseQuickAdapter<LuckyWheelDiamondConfig, BaseDataBindingHolder<ItemLuckyWheelSelectBinding>> {
    private int selectId;

    public LuckyWheelSelectedAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public final int getSelectId() {
        return this.selectId;
    }

    public final void setSelectId(int i) {
        this.selectId = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemLuckyWheelSelectBinding> holder, @NotNull LuckyWheelDiamondConfig item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemLuckyWheelSelectBinding");
        ItemLuckyWheelSelectBinding itemLuckyWheelSelectBinding = (ItemLuckyWheelSelectBinding) dataBinding;
        Dimens dimens = Dimens.INSTANCE;
        int screenWidth = (((dimens.getScreenWidth() - dimens.dpToPx(68)) - dimens.dpToPx(34)) - dimens.dpToPx(28)) / 3;
        GridLayoutManager.LayoutParams layoutParams = itemLuckyWheelSelectBinding.bgContent.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
        GridLayoutManager.LayoutParams layoutParams2 = layoutParams;
        ((ViewGroup.MarginLayoutParams) layoutParams2).width = screenWidth;
        ((ViewGroup.MarginLayoutParams) layoutParams2).height = (screenWidth * 39) / 78;
        itemLuckyWheelSelectBinding.bgContent.setLayoutParams(layoutParams2);
        itemLuckyWheelSelectBinding.diamond.setText(String.valueOf(item.getEntranceFee()));
        if (this.selectId == item.getId()) {
            itemLuckyWheelSelectBinding.selectIcon.setVisibility(0);
            itemLuckyWheelSelectBinding.bgContent.setBackgroundResource(R.drawable.bg_lucky_wheel_selected);
        } else {
            itemLuckyWheelSelectBinding.bgContent.setBackgroundResource(R.drawable.bg_lucky_wheel_unselect);
            itemLuckyWheelSelectBinding.selectIcon.setVisibility(8);
        }
    }
}
