package com.qiahao.nextvideo.ui.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.databinding.ItemGemGameBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/webview/GemGameAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/GameConfiguration;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGemGameBinding;", "<init>", "()V", "mSelectPosition", "", "getMSelectPosition", "()I", "setMSelectPosition", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GemGameAdapter extends BaseQuickAdapter<GameConfiguration, BaseDataBindingHolder<ItemGemGameBinding>> {
    private int mSelectPosition;

    public GemGameAdapter() {
        super(R.layout.item_gem_game, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public final int getMSelectPosition() {
        return this.mSelectPosition;
    }

    public final void setMSelectPosition(int i) {
        this.mSelectPosition = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGemGameBinding> holder, @NotNull GameConfiguration item) {
        View view;
        QMUIRadiusImageView qMUIRadiusImageView;
        QMUIRadiusImageView qMUIRadiusImageView2;
        View view2;
        QMUIRadiusImageView qMUIRadiusImageView3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        if (this.mSelectPosition == holder.getLayoutPosition()) {
            ItemGemGameBinding itemGemGameBinding = (ItemGemGameBinding) holder.getDataBinding();
            if (itemGemGameBinding != null && (qMUIRadiusImageView3 = itemGemGameBinding.image) != null) {
                qMUIRadiusImageView3.setBorderWidth(UiKtxKt.toPX(1));
            }
            ItemGemGameBinding itemGemGameBinding2 = (ItemGemGameBinding) holder.getDataBinding();
            if (itemGemGameBinding2 != null && (view2 = itemGemGameBinding2.topView) != null) {
                view2.setVisibility(8);
            }
        } else {
            ItemGemGameBinding itemGemGameBinding3 = (ItemGemGameBinding) holder.getDataBinding();
            if (itemGemGameBinding3 != null && (qMUIRadiusImageView = itemGemGameBinding3.image) != null) {
                qMUIRadiusImageView.setBorderWidth(0);
            }
            ItemGemGameBinding itemGemGameBinding4 = (ItemGemGameBinding) holder.getDataBinding();
            if (itemGemGameBinding4 != null && (view = itemGemGameBinding4.topView) != null) {
                view.setVisibility(0);
            }
        }
        ItemGemGameBinding itemGemGameBinding5 = (ItemGemGameBinding) holder.getDataBinding();
        if (itemGemGameBinding5 == null || (qMUIRadiusImageView2 = itemGemGameBinding5.image) == null) {
            return;
        }
        ImageKtxKt.loadImage$default(qMUIRadiusImageView2, item.getBannerUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
    }
}
