package com.qiahao.nextvideo.room.luckybox;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Property;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemGroupLuckyBoxBinding;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/room/luckybox/LuckyBoxRewardAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGroupLuckyBoxBinding;", "layoutResId", "", "<init>", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class LuckyBoxRewardAdapter extends BaseQuickAdapter<String, BaseDataBindingHolder<ItemGroupLuckyBoxBinding>> {
    public LuckyBoxRewardAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$3(ItemGroupLuckyBoxBinding itemGroupLuckyBoxBinding) {
        itemGroupLuckyBoxBinding.image.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(itemGroupLuckyBoxBinding.image, (Property<ImageButton, Float>) View.SCALE_X, 0.0f, 1.2f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(itemGroupLuckyBoxBinding.image, (Property<ImageButton, Float>) View.SCALE_Y, 0.0f, 1.2f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(300L);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGroupLuckyBoxBinding> holder, @NotNull String item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupLuckyBoxBinding");
        final ItemGroupLuckyBoxBinding itemGroupLuckyBoxBinding = (ItemGroupLuckyBoxBinding) dataBinding;
        if (item.length() == 0) {
            ImageButton imageButton = itemGroupLuckyBoxBinding.image;
            Intrinsics.checkNotNullExpressionValue(imageButton, "image");
            ImageKtxKt.loadImage$default(imageButton, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_lucky_box_fail), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        } else {
            ImageButton imageButton2 = itemGroupLuckyBoxBinding.image;
            Intrinsics.checkNotNullExpressionValue(imageButton2, "image");
            ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
            ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
            Dimens dimens = Dimens.INSTANCE;
            lfit.setWidth(dimens.dpToPx(58));
            lfit.setHeight(dimens.dpToPx(58));
            Unit unit = Unit.INSTANCE;
            ImageUIModel displayImage = companion.displayImage(item, lfit);
            displayImage.setPlaceholder(2131232497);
            ViewUtilitiesKt.bind(imageButton2, displayImage);
        }
        itemGroupLuckyBoxBinding.image.setVisibility(4);
        itemGroupLuckyBoxBinding.image.postDelayed(new Runnable() { // from class: com.qiahao.nextvideo.room.luckybox.v
            @Override // java.lang.Runnable
            public final void run() {
                LuckyBoxRewardAdapter.convert$lambda$3(ItemGroupLuckyBoxBinding.this);
            }
        }, 200 * (holder.getAdapterPosition() + 1));
    }
}
