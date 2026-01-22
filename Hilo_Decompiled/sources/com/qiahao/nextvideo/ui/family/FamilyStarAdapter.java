package com.qiahao.nextvideo.ui.family;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.family.FamilyStarData;
import com.qiahao.nextvideo.databinding.ItemFamilyStarBinding;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0016\u001a\u00020\u0002H\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyStarAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/family/FamilyStarData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemFamilyStarBinding;", "<init>", "()V", "fragmentType", "", "getFragmentType", "()I", "setFragmentType", "(I)V", "fragmentPeriod", "", "getFragmentPeriod", "()Ljava/lang/String;", "setFragmentPeriod", "(Ljava/lang/String;)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyStarAdapter extends BaseQuickAdapter<FamilyStarData, BaseDataBindingHolder<ItemFamilyStarBinding>> {

    @NotNull
    private String fragmentPeriod;
    private int fragmentType;

    public FamilyStarAdapter() {
        super(R.layout.item_family_star, (List) null, 2, (DefaultConstructorMarker) null);
        this.fragmentPeriod = "";
    }

    @NotNull
    public final String getFragmentPeriod() {
        return this.fragmentPeriod;
    }

    public final int getFragmentType() {
        return this.fragmentType;
    }

    public final void setFragmentPeriod(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fragmentPeriod = str;
    }

    public final void setFragmentType(int i) {
        this.fragmentType = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemFamilyStarBinding> holder, @NotNull FamilyStarData item) {
        ShineTextView shineTextView;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ImageView imageView2;
        ShineTextView shineTextView2;
        ShineTextView shineTextView3;
        ShineTextView shineTextView4;
        TextView textView5;
        QMUIRadiusImageView qMUIRadiusImageView;
        TextView textView6;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemFamilyStarBinding itemFamilyStarBinding = (ItemFamilyStarBinding) holder.getDataBinding();
        if (itemFamilyStarBinding != null && (textView6 = itemFamilyStarBinding.listPosition) != null) {
            textView6.setText(String.valueOf(holder.getAdapterPosition() + 4));
        }
        if (itemFamilyStarBinding != null && (qMUIRadiusImageView = itemFamilyStarBinding.userAvatarCimageView) != null) {
            User user = item.getUser();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(user != null ? user.getAvatar() : null), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
        if (itemFamilyStarBinding != null && (textView5 = itemFamilyStarBinding.userName) != null) {
            User user2 = item.getUser();
            textView5.setText(user2 != null ? user2.getNick() : null);
        }
        if (itemFamilyStarBinding != null && (shineTextView4 = itemFamilyStarBinding.userId) != null) {
            String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
            User user3 = item.getUser();
            String format = String.format(stringById, Arrays.copyOf(new Object[]{String.valueOf(user3 != null ? user3.getCode() : null)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            shineTextView4.setText(format);
        }
        User user4 = item.getUser();
        if (user4 != null ? Intrinsics.areEqual(user4.isPrettyCode(), Boolean.TRUE) : false) {
            if (itemFamilyStarBinding != null && (shineTextView3 = itemFamilyStarBinding.userId) != null) {
                Resources resources = getContext().getResources();
                ViewUtilitiesKt.setDrawableLeft(shineTextView3, resources != null ? ResourceUtilsKt.getDrawable(resources, 2131232463, Dimens.INSTANCE.dpToPx(4)) : null);
            }
            if (itemFamilyStarBinding != null && (shineTextView2 = itemFamilyStarBinding.userId) != null) {
                shineTextView2.setCompoundDrawablePadding(Dimens.INSTANCE.dpToPx(4));
            }
        } else if (itemFamilyStarBinding != null && (shineTextView = itemFamilyStarBinding.userId) != null) {
            ViewUtilitiesKt.setDrawableLeft(shineTextView, null);
        }
        if (this.fragmentType == 2) {
            if (itemFamilyStarBinding != null && (imageView2 = itemFamilyStarBinding.diamondImg) != null) {
                imageView2.setVisibility(8);
            }
        } else if (itemFamilyStarBinding != null && (imageView = itemFamilyStarBinding.diamondImg) != null) {
            imageView.setVisibility(Intrinsics.areEqual(this.fragmentPeriod, "day") ? 0 : 8);
        }
        if (this.fragmentType != 2) {
            if (itemFamilyStarBinding != null && (textView2 = itemFamilyStarBinding.diamond) != null) {
                Long score = item.getScore();
                textView2.setText(NumberUtilsKt.rankNumberFormat(score != null ? score.longValue() : 0L));
            }
            if (itemFamilyStarBinding == null || (textView = itemFamilyStarBinding.diamond) == null) {
                return;
            }
            textView.setVisibility(Intrinsics.areEqual(this.fragmentPeriod, "day") ? 0 : 8);
            return;
        }
        if (itemFamilyStarBinding != null && (textView4 = itemFamilyStarBinding.diamond) != null) {
            Long score2 = item.getScore();
            textView4.setText((score2 != null ? score2.longValue() : 0L) + " min");
        }
        if (itemFamilyStarBinding == null || (textView3 = itemFamilyStarBinding.diamond) == null) {
            return;
        }
        textView3.setVisibility(0);
    }
}
