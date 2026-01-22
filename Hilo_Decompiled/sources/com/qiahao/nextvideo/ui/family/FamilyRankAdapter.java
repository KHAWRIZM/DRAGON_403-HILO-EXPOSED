package com.qiahao.nextvideo.ui.family;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.polygon.PolygonImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.family.FamilyRankItem;
import com.qiahao.nextvideo.databinding.ItemFamilyRankBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyRankAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/family/FamilyRankItem;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemFamilyRankBinding;", "<init>", "()V", "type", "", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyRankAdapter extends BaseQuickAdapter<FamilyRankItem, BaseDataBindingHolder<ItemFamilyRankBinding>> {

    @NotNull
    private String type;

    public FamilyRankAdapter() {
        super(R.layout.item_family_rank, (List) null, 2, (DefaultConstructorMarker) null);
        this.type = "day";
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemFamilyRankBinding> holder, @NotNull FamilyRankItem item) {
        TextView textView;
        PolygonImageView polygonImageView;
        LinearLayout linearLayout;
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding;
        TextView textView2;
        TextView textView3;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemFamilyRankBinding itemFamilyRankBinding = (ItemFamilyRankBinding) holder.getDataBinding();
        if (itemFamilyRankBinding != null && (textView3 = itemFamilyRankBinding.userName) != null) {
            String name = item.getName();
            if (name == null) {
                name = "";
            }
            textView3.setText(name);
        }
        if (itemFamilyRankBinding != null && (textView2 = itemFamilyRankBinding.diamond) != null) {
            Long exp = item.getExp();
            textView2.setText(NumberUtilsKt.rankNumberFormat(exp != null ? exp.longValue() : 0L));
        }
        if (itemFamilyRankBinding != null && (includeFamilyNamePlateBinding = itemFamilyRankBinding.namePlate) != null) {
            Integer grade = item.getGrade();
            int intValue = grade != null ? grade.intValue() : -1;
            String nameplate = item.getNameplate();
            AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding, intValue, nameplate == null ? "" : nameplate, 0, 4, (Object) null);
        }
        if (itemFamilyRankBinding != null && (linearLayout = itemFamilyRankBinding.llDiamond) != null) {
            linearLayout.setVisibility(Intrinsics.areEqual(this.type, "day") ? 0 : 8);
        }
        if (itemFamilyRankBinding != null && (polygonImageView = itemFamilyRankBinding.avatar) != null) {
            ImageKtxKt.loadImage$default(polygonImageView, ImageSizeKt.image200(item.getIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
        if (itemFamilyRankBinding == null || (textView = itemFamilyRankBinding.position) == null) {
            return;
        }
        Integer rank = item.getRank();
        textView.setText(rank != null ? rank.toString() : null);
    }
}
