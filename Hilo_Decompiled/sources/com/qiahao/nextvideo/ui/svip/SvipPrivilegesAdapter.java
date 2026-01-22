package com.qiahao.nextvideo.ui.svip;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.opensource.svgaplayer.SVGAImageView;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.model.svip.SvipPrivilege;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.ItemSvipPrivilegesBinding;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/svip/SvipPrivilegesAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/base_common/model/svip/SvipPrivilege;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemSvipPrivilegesBinding;", "<init>", "()V", "mSelectPosition", "", "getMSelectPosition", "()I", "setMSelectPosition", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SvipPrivilegesAdapter extends BaseQuickAdapter<SvipPrivilege, BaseDataBindingHolder<ItemSvipPrivilegesBinding>> {
    private int mSelectPosition;

    public SvipPrivilegesAdapter() {
        super(R.layout.item_svip_privileges, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public final int getMSelectPosition() {
        return this.mSelectPosition;
    }

    public final void setMSelectPosition(int i) {
        this.mSelectPosition = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemSvipPrivilegesBinding> holder, @NotNull SvipPrivilege item) {
        SVGAImageView sVGAImageView;
        SVGAImageView sVGAImageView2;
        TextView textView;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        TextView textView2;
        ImageView imageView4;
        ImageView imageView5;
        SVGAImageView sVGAImageView3;
        SVGAImageView sVGAImageView4;
        ImageView imageView6;
        TextView textView3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemSvipPrivilegesBinding itemSvipPrivilegesBinding = (ItemSvipPrivilegesBinding) holder.getDataBinding();
        if (itemSvipPrivilegesBinding != null && (textView3 = itemSvipPrivilegesBinding.name) != null) {
            textView3.setText(item.getTitle());
        }
        ViewGroup.LayoutParams layoutParams = (itemSvipPrivilegesBinding == null || (imageView6 = itemSvipPrivilegesBinding.img) == null) ? null : imageView6.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
        if (this.mSelectPosition >= 10) {
            if (bVar != null) {
                ((ViewGroup.MarginLayoutParams) bVar).width = UiKtxKt.toPX(50);
            }
            if (bVar != null) {
                ((ViewGroup.MarginLayoutParams) bVar).height = UiKtxKt.toPX(50);
            }
            if (itemSvipPrivilegesBinding != null && (sVGAImageView4 = itemSvipPrivilegesBinding.svga) != null) {
                sVGAImageView4.setVisibility(0);
            }
            if (itemSvipPrivilegesBinding != null && (sVGAImageView3 = itemSvipPrivilegesBinding.svga) != null) {
                sVGAImageView3.startAnimation();
            }
        } else {
            if (bVar != null) {
                ((ViewGroup.MarginLayoutParams) bVar).width = UiKtxKt.toPX(42);
            }
            if (bVar != null) {
                ((ViewGroup.MarginLayoutParams) bVar).height = UiKtxKt.toPX(49);
            }
            if (itemSvipPrivilegesBinding != null && (sVGAImageView2 = itemSvipPrivilegesBinding.svga) != null) {
                sVGAImageView2.setVisibility(8);
            }
            if (itemSvipPrivilegesBinding != null && (sVGAImageView = itemSvipPrivilegesBinding.svga) != null) {
                sVGAImageView.stopAnimation();
            }
        }
        if (itemSvipPrivilegesBinding != null && (imageView5 = itemSvipPrivilegesBinding.img) != null) {
            imageView5.setLayoutParams(bVar);
        }
        if (item.isHasPrivilege()) {
            if (itemSvipPrivilegesBinding != null && (imageView4 = itemSvipPrivilegesBinding.img) != null) {
                ImageKtxKt.loadImage$default(imageView4, this.mSelectPosition >= 10 ? item.getActiveUrl2() : item.getActiveUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            if (itemSvipPrivilegesBinding != null && (textView2 = itemSvipPrivilegesBinding.name) != null) {
                textView2.setTextColor(androidx.core.content.a.getColor(getContext(), 2131100011));
            }
        } else {
            if (itemSvipPrivilegesBinding != null && (imageView = itemSvipPrivilegesBinding.img) != null) {
                ImageKtxKt.loadImage$default(imageView, this.mSelectPosition >= 10 ? item.getInActiveUrl2() : item.getInActiveUrl(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
            if (itemSvipPrivilegesBinding != null && (textView = itemSvipPrivilegesBinding.name) != null) {
                textView.setTextColor(androidx.core.content.a.getColor(getContext(), 2131099915));
            }
        }
        if (item.getCanSwitch() && item.getUserSwitch()) {
            if (itemSvipPrivilegesBinding == null || (imageView3 = itemSvipPrivilegesBinding.selectImage) == null) {
                return;
            }
            imageView3.setVisibility(0);
            return;
        }
        if (itemSvipPrivilegesBinding == null || (imageView2 = itemSvipPrivilegesBinding.selectImage) == null) {
            return;
        }
        imageView2.setVisibility(8);
    }
}
