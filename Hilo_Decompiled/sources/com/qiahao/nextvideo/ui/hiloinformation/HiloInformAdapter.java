package com.qiahao.nextvideo.ui.hiloinformation;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.HiloInformationCellUIModel;
import com.qiahao.nextvideo.databinding.ItemHiloInformationBinding;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/hiloinformation/HiloInformAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/HiloInformationCellUIModel;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemHiloInformationBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HiloInformAdapter extends BaseQuickAdapter<HiloInformationCellUIModel, BaseDataBindingHolder<ItemHiloInformationBinding>> {
    public HiloInformAdapter() {
        super(R.layout.item_hilo_information, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(ItemHiloInformationBinding itemHiloInformationBinding, HiloInformationCellUIModel hiloInformationCellUIModel) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        itemHiloInformationBinding.imageView.setVisibility(0);
        Integer picWidth = hiloInformationCellUIModel.getPicWidth();
        if (picWidth != null) {
            i = picWidth.intValue();
        } else {
            i = 0;
        }
        if (i > 0) {
            Integer picHeight = hiloInformationCellUIModel.getPicHeight();
            if (picHeight != null) {
                i2 = picHeight.intValue();
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                ViewGroup.LayoutParams layoutParams = itemHiloInformationBinding.imageView.getLayoutParams();
                int width = itemHiloInformationBinding.imageView.getWidth();
                Integer picHeight2 = hiloInformationCellUIModel.getPicHeight();
                if (picHeight2 != null) {
                    i4 = picHeight2.intValue();
                }
                int i5 = width * i4;
                Integer picWidth2 = hiloInformationCellUIModel.getPicWidth();
                if (picWidth2 != null) {
                    i3 = picWidth2.intValue();
                } else {
                    i3 = 1;
                }
                layoutParams.height = i5 / i3;
                itemHiloInformationBinding.imageView.setLayoutParams(layoutParams);
            }
        }
        ImageView imageView = itemHiloInformationBinding.imageView;
        Intrinsics.checkNotNullExpressionValue(imageView, "imageView");
        ImageKtxKt.loadImage$default(imageView, ImageSizeKt.imageSize(hiloInformationCellUIModel.getImageUIModel().getImageUrl(), UiKtxKt.toPX(300)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, UiKtxKt.toPX(10), false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, 2131231930, 2131231930, (c5.g) null, 40830, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemHiloInformationBinding> holder, @NotNull final HiloInformationCellUIModel item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemHiloInformationBinding");
        final ItemHiloInformationBinding itemHiloInformationBinding = (ItemHiloInformationBinding) dataBinding;
        if (TextUtils.isEmpty(item.getImageUIModel().getImageUrl())) {
            itemHiloInformationBinding.imageView.setVisibility(8);
        } else {
            itemHiloInformationBinding.imageView.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.hiloinformation.k
                @Override // java.lang.Runnable
                public final void run() {
                    HiloInformAdapter.convert$lambda$0(ItemHiloInformationBinding.this, item);
                }
            });
        }
        itemHiloInformationBinding.subtitleTextView.setText(item.getSubtitle());
        if (item.getCreateTimeInDate() != null) {
            itemHiloInformationBinding.timeTextView.setVisibility(0);
            itemHiloInformationBinding.timeTextView.setText(item.getCreateTimeInDate());
        }
        itemHiloInformationBinding.titleTextView.setText(item.getTitle());
        String createTimeInDate = item.getCreateTimeInDate();
        if (createTimeInDate != null) {
            itemHiloInformationBinding.informationCreateDateTextView.setVisibility(8);
            itemHiloInformationBinding.informationCreateDateTextView.setText(createTimeInDate);
        }
        if (item.getActionType() == 0) {
            itemHiloInformationBinding.canJumpLine.setVisibility(8);
            itemHiloInformationBinding.canJump.setVisibility(8);
        } else {
            itemHiloInformationBinding.canJumpLine.setVisibility(0);
            itemHiloInformationBinding.canJump.setVisibility(0);
        }
    }
}
