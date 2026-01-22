package com.qiahao.nextvideo.room.luckybox;

import android.widget.ImageButton;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.data.model.RewardLuckyBoxBean;
import com.qiahao.nextvideo.databinding.ItemGroupLuckyBoxBigRewardBinding;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxBigRewardAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/RewardLuckyBoxBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGroupLuckyBoxBigRewardBinding;", "layoutResId", "", "<init>", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyBoxBigRewardAdapter extends BaseQuickAdapter<RewardLuckyBoxBean, BaseDataBindingHolder<ItemGroupLuckyBoxBigRewardBinding>> {
    public LuckyBoxBigRewardAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGroupLuckyBoxBigRewardBinding> holder, @NotNull RewardLuckyBoxBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupLuckyBoxBigRewardBinding");
        ImageButton imageButton = ((ItemGroupLuckyBoxBigRewardBinding) dataBinding).image;
        Intrinsics.checkNotNullExpressionValue(imageButton, "image");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        String picUrl = item.getPicUrl();
        ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        lfit.setWidth(dimens.dpToPx(82));
        lfit.setHeight(dimens.dpToPx(82));
        Unit unit = Unit.INSTANCE;
        ImageUIModel displayImage = companion.displayImage(picUrl, lfit);
        displayImage.setPlaceholder(2131232497);
        ViewUtilitiesKt.bind(imageButton, displayImage);
    }
}
