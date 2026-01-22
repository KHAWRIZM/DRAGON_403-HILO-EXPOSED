package com.qiahao.nextvideo.ui.family;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.family.FamilyCenterMember;
import com.qiahao.nextvideo.databinding.ItemFamilyCenterMemberBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyCenterMembersAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/family/FamilyCenterMember;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemFamilyCenterMemberBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyCenterMembersAdapter extends BaseQuickAdapter<FamilyCenterMember, BaseDataBindingHolder<ItemFamilyCenterMemberBinding>> {
    public FamilyCenterMembersAdapter() {
        super(R.layout.item_family_center_member, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemFamilyCenterMemberBinding> holder, @NotNull FamilyCenterMember item) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        AppCompatImageView appCompatImageView3;
        AppCompatImageView appCompatImageView4;
        AppCompatImageView appCompatImageView5;
        AppCompatTextView appCompatTextView;
        QMUIRadiusImageView qMUIRadiusImageView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemFamilyCenterMemberBinding itemFamilyCenterMemberBinding = (ItemFamilyCenterMemberBinding) holder.getDataBinding();
        if (itemFamilyCenterMemberBinding != null && (qMUIRadiusImageView = itemFamilyCenterMemberBinding.avatar) != null) {
            User user = item.getUser();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(user != null ? user.getAvatar() : null), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
        ItemFamilyCenterMemberBinding itemFamilyCenterMemberBinding2 = (ItemFamilyCenterMemberBinding) holder.getDataBinding();
        if (itemFamilyCenterMemberBinding2 != null && (appCompatTextView = itemFamilyCenterMemberBinding2.name) != null) {
            User user2 = item.getUser();
            appCompatTextView.setText(user2 != null ? user2.getNick() : null);
        }
        Integer role = item.getRole();
        if ((role == null || role.intValue() != 0) && (role == null || role.intValue() != 1)) {
            if (role != null && role.intValue() == 3) {
                ItemFamilyCenterMemberBinding itemFamilyCenterMemberBinding3 = (ItemFamilyCenterMemberBinding) holder.getDataBinding();
                if (itemFamilyCenterMemberBinding3 != null && (appCompatImageView4 = itemFamilyCenterMemberBinding3.typeImage) != null) {
                    appCompatImageView4.setVisibility(0);
                }
                ItemFamilyCenterMemberBinding itemFamilyCenterMemberBinding4 = (ItemFamilyCenterMemberBinding) holder.getDataBinding();
                if (itemFamilyCenterMemberBinding4 == null || (appCompatImageView3 = itemFamilyCenterMemberBinding4.typeImage) == null) {
                    return;
                }
                appCompatImageView3.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.family_admin_icon));
                return;
            }
            if (role != null && role.intValue() == 2) {
                ItemFamilyCenterMemberBinding itemFamilyCenterMemberBinding5 = (ItemFamilyCenterMemberBinding) holder.getDataBinding();
                if (itemFamilyCenterMemberBinding5 != null && (appCompatImageView2 = itemFamilyCenterMemberBinding5.typeImage) != null) {
                    appCompatImageView2.setVisibility(0);
                }
                ItemFamilyCenterMemberBinding itemFamilyCenterMemberBinding6 = (ItemFamilyCenterMemberBinding) holder.getDataBinding();
                if (itemFamilyCenterMemberBinding6 == null || (appCompatImageView = itemFamilyCenterMemberBinding6.typeImage) == null) {
                    return;
                }
                appCompatImageView.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), R.drawable.family_own_icon));
                return;
            }
            return;
        }
        ItemFamilyCenterMemberBinding itemFamilyCenterMemberBinding7 = (ItemFamilyCenterMemberBinding) holder.getDataBinding();
        if (itemFamilyCenterMemberBinding7 == null || (appCompatImageView5 = itemFamilyCenterMemberBinding7.typeImage) == null) {
            return;
        }
        appCompatImageView5.setVisibility(4);
    }
}
