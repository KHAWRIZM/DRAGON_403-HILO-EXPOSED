package com.qiahao.nextvideo.ui.aristocracy;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.noble.NobleCard;
import com.qiahao.nextvideo.databinding.ItemAristocracyBagBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0015\u001a\u00020\u0002H\u0015J,\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0015\u001a\u00020\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/ui/aristocracy/AristocracyBagAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/noble/NobleCard;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemAristocracyBagBinding;", "<init>", "()V", "selectNoble", "getSelectNoble", "()Lcom/qiahao/nextvideo/data/noble/NobleCard;", "setSelectNoble", "(Lcom/qiahao/nextvideo/data/noble/NobleCard;)V", "selectPosition", "", "getSelectPosition", "()I", "setSelectPosition", "(I)V", "convert", "", "holder", "item", "payloads", "", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AristocracyBagAdapter extends BaseQuickAdapter<NobleCard, BaseDataBindingHolder<ItemAristocracyBagBinding>> {

    @Nullable
    private NobleCard selectNoble;
    private int selectPosition;

    public AristocracyBagAdapter() {
        super(R.layout.item_aristocracy_bag, (List) null, 2, (DefaultConstructorMarker) null);
        this.selectPosition = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$0(AristocracyBagAdapter aristocracyBagAdapter, NobleCard nobleCard, ItemAristocracyBagBinding itemAristocracyBagBinding) {
        Integer num;
        NobleCard nobleCard2 = aristocracyBagAdapter.selectNoble;
        if (nobleCard2 != null) {
            num = nobleCard2.getId();
        } else {
            num = null;
        }
        int i = 0;
        if (Intrinsics.areEqual(num, nobleCard.getId())) {
            itemAristocracyBagBinding.selectBg.setVisibility(0);
        } else {
            itemAristocracyBagBinding.selectBg.setVisibility(8);
        }
        ConstraintLayout.b layoutParams = itemAristocracyBagBinding.cardImage.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).height = (int) (((ViewGroup.MarginLayoutParams) bVar).width / 1.9d);
        itemAristocracyBagBinding.cardImage.setLayoutParams(bVar);
        QMUIRadiusImageView qMUIRadiusImageView = itemAristocracyBagBinding.cardImage;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "cardImage");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, nobleCard.getCardImg(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        itemAristocracyBagBinding.number.setText("x " + nobleCard.getNum());
        Integer isExclusive = nobleCard.isExclusive();
        if (isExclusive != null && isExclusive.intValue() == 1) {
            itemAristocracyBagBinding.exclusiveLayout.setVisibility(0);
            itemAristocracyBagBinding.dayLayout.setVisibility(8);
            TextView textView = itemAristocracyBagBinding.exclusiveNumber;
            Integer day = nobleCard.getDay();
            if (day != null) {
                i = day.intValue();
            }
            textView.setText(String.valueOf(i));
            return;
        }
        itemAristocracyBagBinding.exclusiveLayout.setVisibility(8);
        itemAristocracyBagBinding.dayLayout.setVisibility(0);
        TextView textView2 = itemAristocracyBagBinding.dayNumber;
        Integer day2 = nobleCard.getDay();
        if (day2 != null) {
            i = day2.intValue();
        }
        textView2.setText(String.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void convert$lambda$1(AristocracyBagAdapter aristocracyBagAdapter, NobleCard nobleCard, ItemAristocracyBagBinding itemAristocracyBagBinding) {
        Integer num;
        NobleCard nobleCard2 = aristocracyBagAdapter.selectNoble;
        if (nobleCard2 != null) {
            num = nobleCard2.getId();
        } else {
            num = null;
        }
        int i = 0;
        if (Intrinsics.areEqual(num, nobleCard.getId())) {
            itemAristocracyBagBinding.selectBg.setVisibility(0);
        } else {
            itemAristocracyBagBinding.selectBg.setVisibility(8);
        }
        ConstraintLayout.b layoutParams = itemAristocracyBagBinding.cardImage.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).height = (int) (((ViewGroup.MarginLayoutParams) bVar).width / 1.9d);
        itemAristocracyBagBinding.cardImage.setLayoutParams(bVar);
        QMUIRadiusImageView qMUIRadiusImageView = itemAristocracyBagBinding.cardImage;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "cardImage");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, nobleCard.getCardImg(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        itemAristocracyBagBinding.number.setText("x " + nobleCard.getNum());
        Integer isExclusive = nobleCard.isExclusive();
        if (isExclusive != null && isExclusive.intValue() == 1) {
            itemAristocracyBagBinding.exclusiveLayout.setVisibility(0);
            itemAristocracyBagBinding.dayLayout.setVisibility(8);
            TextView textView = itemAristocracyBagBinding.exclusiveNumber;
            Integer day = nobleCard.getDay();
            if (day != null) {
                i = day.intValue();
            }
            textView.setText(String.valueOf(i));
            return;
        }
        itemAristocracyBagBinding.exclusiveLayout.setVisibility(8);
        itemAristocracyBagBinding.dayLayout.setVisibility(0);
        TextView textView2 = itemAristocracyBagBinding.dayNumber;
        Integer day2 = nobleCard.getDay();
        if (day2 != null) {
            i = day2.intValue();
        }
        textView2.setText(String.valueOf(i));
    }

    @Nullable
    public final NobleCard getSelectNoble() {
        return this.selectNoble;
    }

    public final int getSelectPosition() {
        return this.selectPosition;
    }

    public final void setSelectNoble(@Nullable NobleCard nobleCard) {
        this.selectNoble = nobleCard;
    }

    public final void setSelectPosition(int i) {
        this.selectPosition = i;
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BaseDataBindingHolder<ItemAristocracyBagBinding>) baseViewHolder, (NobleCard) obj, (List<? extends Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemAristocracyBagBinding> holder, @NotNull final NobleCard item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemAristocracyBagBinding");
        final ItemAristocracyBagBinding itemAristocracyBagBinding = (ItemAristocracyBagBinding) dataBinding;
        itemAristocracyBagBinding.cardImage.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.aristocracy.k
            @Override // java.lang.Runnable
            public final void run() {
                AristocracyBagAdapter.convert$lambda$0(AristocracyBagAdapter.this, item, itemAristocracyBagBinding);
            }
        });
    }

    @SuppressLint({"SetTextI18n"})
    protected void convert(@NotNull BaseDataBindingHolder<ItemAristocracyBagBinding> holder, @NotNull final NobleCard item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemAristocracyBagBinding");
        final ItemAristocracyBagBinding itemAristocracyBagBinding = (ItemAristocracyBagBinding) dataBinding;
        itemAristocracyBagBinding.cardImage.post(new Runnable() { // from class: com.qiahao.nextvideo.ui.aristocracy.l
            @Override // java.lang.Runnable
            public final void run() {
                AristocracyBagAdapter.convert$lambda$1(AristocracyBagAdapter.this, item, itemAristocracyBagBinding);
            }
        });
    }
}
