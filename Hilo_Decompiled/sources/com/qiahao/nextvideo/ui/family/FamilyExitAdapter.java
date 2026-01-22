package com.qiahao.nextvideo.ui.family;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.family.FamilyApplicationData;
import com.qiahao.nextvideo.databinding.ItemFamilyExitBinding;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0016\u0010\u000b\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyExitAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/family/FamilyApplicationData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemFamilyExitBinding;", "<init>", "()V", "convert", "", "holder", "item", "onViewRecycled", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyExitAdapter extends BaseQuickAdapter<FamilyApplicationData, BaseDataBindingHolder<ItemFamilyExitBinding>> {
    public FamilyExitAdapter() {
        super(R.layout.item_family_exit, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemFamilyExitBinding> holder, @NotNull FamilyApplicationData item) {
        ShineTextView shineTextView;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        AppCompatTextView appCompatTextView4;
        AppCompatTextView appCompatTextView5;
        TextView textView;
        ShineTextView shineTextView2;
        String str;
        ShineTextView shineTextView3;
        ShineTextView shineTextView4;
        TextView textView2;
        String str2;
        QMUIRadiusImageView qMUIRadiusImageView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemFamilyExitBinding itemFamilyExitBinding = (ItemFamilyExitBinding) holder.getDataBinding();
        if (itemFamilyExitBinding != null && (qMUIRadiusImageView = itemFamilyExitBinding.userAvatarCimageView) != null) {
            User user = item.getUser();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(user != null ? user.getAvatar() : null), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
        ItemFamilyExitBinding itemFamilyExitBinding2 = (ItemFamilyExitBinding) holder.getDataBinding();
        if (itemFamilyExitBinding2 != null && (textView2 = itemFamilyExitBinding2.userName) != null) {
            User user2 = item.getUser();
            if (user2 == null || (str2 = user2.getNick()) == null) {
                str2 = "";
            }
            textView2.setText(str2);
        }
        User user3 = item.getUser();
        if (user3 != null ? Intrinsics.areEqual(user3.isPrettyCode(), Boolean.TRUE) : false) {
            ItemFamilyExitBinding itemFamilyExitBinding3 = (ItemFamilyExitBinding) holder.getDataBinding();
            if (itemFamilyExitBinding3 != null && (shineTextView4 = itemFamilyExitBinding3.userId) != null) {
                Resources resources = getContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                ViewUtilitiesKt.setDrawableLeft(shineTextView4, ResourceUtilsKt.getDrawable(resources, 2131232463, Dimens.INSTANCE.dpToPx(4)));
            }
            ItemFamilyExitBinding itemFamilyExitBinding4 = (ItemFamilyExitBinding) holder.getDataBinding();
            if (itemFamilyExitBinding4 != null && (shineTextView3 = itemFamilyExitBinding4.userId) != null) {
                shineTextView3.setCompoundDrawablePadding(Dimens.INSTANCE.dpToPx(4));
            }
        } else {
            ItemFamilyExitBinding itemFamilyExitBinding5 = (ItemFamilyExitBinding) holder.getDataBinding();
            if (itemFamilyExitBinding5 != null && (shineTextView = itemFamilyExitBinding5.userId) != null) {
                ViewUtilitiesKt.setDrawableLeft(shineTextView, null);
            }
        }
        ItemFamilyExitBinding itemFamilyExitBinding6 = (ItemFamilyExitBinding) holder.getDataBinding();
        if (itemFamilyExitBinding6 != null && (shineTextView2 = itemFamilyExitBinding6.userId) != null) {
            String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
            User user4 = item.getUser();
            if (user4 == null || (str = user4.getCode()) == null) {
                str = "";
            }
            String format = String.format(stringById, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            shineTextView2.setText(format);
        }
        ItemFamilyExitBinding itemFamilyExitBinding7 = (ItemFamilyExitBinding) holder.getDataBinding();
        if (itemFamilyExitBinding7 != null && (textView = itemFamilyExitBinding7.time) != null) {
            Long time = item.getTime();
            textView.setText(com.qiahao.base_common.utils.f.h(time != null ? time.longValue() : 0L, com.qiahao.base_common.utils.f.e));
        }
        Integer quitType = item.getQuitType();
        if (quitType != null && quitType.intValue() == 1) {
            ItemFamilyExitBinding itemFamilyExitBinding8 = (ItemFamilyExitBinding) holder.getDataBinding();
            if (itemFamilyExitBinding8 != null && (appCompatTextView5 = itemFamilyExitBinding8.type) != null) {
                appCompatTextView5.setText(ResourcesKtxKt.getStringById(this, 2131954464));
            }
            ItemFamilyExitBinding itemFamilyExitBinding9 = (ItemFamilyExitBinding) holder.getDataBinding();
            if (itemFamilyExitBinding9 == null || (appCompatTextView4 = itemFamilyExitBinding9.type) == null) {
                return;
            }
            ViewUtilitiesKt.setDrawableLeft(appCompatTextView4, null);
            return;
        }
        ItemFamilyExitBinding itemFamilyExitBinding10 = (ItemFamilyExitBinding) holder.getDataBinding();
        if (itemFamilyExitBinding10 != null && (appCompatTextView3 = itemFamilyExitBinding10.type) != null) {
            String mgrName = item.getMgrName();
            appCompatTextView3.setText(mgrName != null ? mgrName : "");
        }
        ItemFamilyExitBinding itemFamilyExitBinding11 = (ItemFamilyExitBinding) holder.getDataBinding();
        if (itemFamilyExitBinding11 != null && (appCompatTextView2 = itemFamilyExitBinding11.type) != null) {
            Resources resources2 = getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(appCompatTextView2, ResourceUtilsKt.getDrawable(resources2, R.drawable.family_member_admin_icon, Dimens.INSTANCE.dpToPx(4)));
        }
        ItemFamilyExitBinding itemFamilyExitBinding12 = (ItemFamilyExitBinding) holder.getDataBinding();
        if (itemFamilyExitBinding12 == null || (appCompatTextView = itemFamilyExitBinding12.type) == null) {
            return;
        }
        appCompatTextView.setCompoundDrawablePadding(Dimens.INSTANCE.dpToPx(4));
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemFamilyExitBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        holder.getView(2131365528).stopAnimation();
    }
}
