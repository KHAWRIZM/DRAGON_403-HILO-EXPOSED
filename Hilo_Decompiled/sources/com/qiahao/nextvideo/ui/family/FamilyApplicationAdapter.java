package com.qiahao.nextvideo.ui.family;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.family.FamilyApplicationData;
import com.qiahao.nextvideo.databinding.ItemFamilyApplicationBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J,\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyApplicationAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/family/FamilyApplicationData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemFamilyApplicationBinding;", "<init>", "()V", "convert", "", "holder", "item", "payloads", "", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyApplicationAdapter extends BaseQuickAdapter<FamilyApplicationData, BaseDataBindingHolder<ItemFamilyApplicationBinding>> {
    public FamilyApplicationAdapter() {
        super(R.layout.item_family_application, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BaseDataBindingHolder<ItemFamilyApplicationBinding>) baseViewHolder, (FamilyApplicationData) obj, (List<? extends Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemFamilyApplicationBinding> holder, @NotNull FamilyApplicationData item) {
        ItemFamilyApplicationBinding itemFamilyApplicationBinding;
        TextView textView;
        AppCompatTextView appCompatTextView;
        TextView textView2;
        Group group;
        Group group2;
        TextView textView3;
        TextView textView4;
        String str;
        QMUIRadiusImageView qMUIRadiusImageView;
        Group group3;
        Group group4;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Integer status = item.getStatus();
        if (status != null && status.intValue() == 0) {
            ItemFamilyApplicationBinding itemFamilyApplicationBinding2 = (ItemFamilyApplicationBinding) holder.getDataBinding();
            if (itemFamilyApplicationBinding2 != null && (group4 = itemFamilyApplicationBinding2.applyGroup) != null) {
                group4.setVisibility(0);
            }
            ItemFamilyApplicationBinding itemFamilyApplicationBinding3 = (ItemFamilyApplicationBinding) holder.getDataBinding();
            if (itemFamilyApplicationBinding3 != null && (group3 = itemFamilyApplicationBinding3.agreedGroup) != null) {
                group3.setVisibility(8);
            }
        } else {
            ItemFamilyApplicationBinding itemFamilyApplicationBinding4 = (ItemFamilyApplicationBinding) holder.getDataBinding();
            if (itemFamilyApplicationBinding4 != null && (group2 = itemFamilyApplicationBinding4.applyGroup) != null) {
                group2.setVisibility(8);
            }
            ItemFamilyApplicationBinding itemFamilyApplicationBinding5 = (ItemFamilyApplicationBinding) holder.getDataBinding();
            if (itemFamilyApplicationBinding5 != null && (group = itemFamilyApplicationBinding5.agreedGroup) != null) {
                group.setVisibility(0);
            }
            Integer status2 = item.getStatus();
            if (status2 != null && status2.intValue() == 1) {
                ItemFamilyApplicationBinding itemFamilyApplicationBinding6 = (ItemFamilyApplicationBinding) holder.getDataBinding();
                if (itemFamilyApplicationBinding6 != null && (textView2 = itemFamilyApplicationBinding6.agreed) != null) {
                    textView2.setText(ResourcesKtxKt.getStringById(this, 2131951995));
                }
            } else {
                Integer status3 = item.getStatus();
                if (status3 != null && status3.intValue() == 2 && (itemFamilyApplicationBinding = (ItemFamilyApplicationBinding) holder.getDataBinding()) != null && (textView = itemFamilyApplicationBinding.agreed) != null) {
                    textView.setText(ResourcesKtxKt.getStringById(this, 2131952688));
                }
            }
            ItemFamilyApplicationBinding itemFamilyApplicationBinding7 = (ItemFamilyApplicationBinding) holder.getDataBinding();
            if (itemFamilyApplicationBinding7 != null && (appCompatTextView = itemFamilyApplicationBinding7.memberType) != null) {
                appCompatTextView.setText(item.getMgrName());
            }
        }
        ItemFamilyApplicationBinding itemFamilyApplicationBinding8 = (ItemFamilyApplicationBinding) holder.getDataBinding();
        if (itemFamilyApplicationBinding8 != null && (qMUIRadiusImageView = itemFamilyApplicationBinding8.userAvatarCimageView) != null) {
            User user = item.getUser();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(user != null ? user.getAvatar() : null), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
        ItemFamilyApplicationBinding itemFamilyApplicationBinding9 = (ItemFamilyApplicationBinding) holder.getDataBinding();
        if (itemFamilyApplicationBinding9 != null && (textView4 = itemFamilyApplicationBinding9.userName) != null) {
            User user2 = item.getUser();
            if (user2 == null || (str = user2.getNick()) == null) {
                str = "";
            }
            textView4.setText(str);
        }
        ItemFamilyApplicationBinding itemFamilyApplicationBinding10 = (ItemFamilyApplicationBinding) holder.getDataBinding();
        if (itemFamilyApplicationBinding10 == null || (textView3 = itemFamilyApplicationBinding10.time) == null) {
            return;
        }
        Long time = item.getTime();
        textView3.setText(com.qiahao.base_common.utils.f.h(time != null ? time.longValue() : 0L, com.qiahao.base_common.utils.f.e));
    }

    protected void convert(@NotNull BaseDataBindingHolder<ItemFamilyApplicationBinding> holder, @NotNull FamilyApplicationData item, @NotNull List<? extends Object> payloads) {
        ItemFamilyApplicationBinding itemFamilyApplicationBinding;
        TextView textView;
        AppCompatTextView appCompatTextView;
        TextView textView2;
        Group group;
        Group group2;
        TextView textView3;
        TextView textView4;
        String str;
        QMUIRadiusImageView qMUIRadiusImageView;
        Group group3;
        Group group4;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        Integer status = item.getStatus();
        if (status != null && status.intValue() == 0) {
            ItemFamilyApplicationBinding itemFamilyApplicationBinding2 = (ItemFamilyApplicationBinding) holder.getDataBinding();
            if (itemFamilyApplicationBinding2 != null && (group4 = itemFamilyApplicationBinding2.applyGroup) != null) {
                group4.setVisibility(0);
            }
            ItemFamilyApplicationBinding itemFamilyApplicationBinding3 = (ItemFamilyApplicationBinding) holder.getDataBinding();
            if (itemFamilyApplicationBinding3 != null && (group3 = itemFamilyApplicationBinding3.agreedGroup) != null) {
                group3.setVisibility(8);
            }
        } else {
            ItemFamilyApplicationBinding itemFamilyApplicationBinding4 = (ItemFamilyApplicationBinding) holder.getDataBinding();
            if (itemFamilyApplicationBinding4 != null && (group2 = itemFamilyApplicationBinding4.applyGroup) != null) {
                group2.setVisibility(8);
            }
            ItemFamilyApplicationBinding itemFamilyApplicationBinding5 = (ItemFamilyApplicationBinding) holder.getDataBinding();
            if (itemFamilyApplicationBinding5 != null && (group = itemFamilyApplicationBinding5.agreedGroup) != null) {
                group.setVisibility(0);
            }
            Integer status2 = item.getStatus();
            if (status2 != null && status2.intValue() == 1) {
                ItemFamilyApplicationBinding itemFamilyApplicationBinding6 = (ItemFamilyApplicationBinding) holder.getDataBinding();
                if (itemFamilyApplicationBinding6 != null && (textView2 = itemFamilyApplicationBinding6.agreed) != null) {
                    textView2.setText(ResourcesKtxKt.getStringById(this, 2131951995));
                }
            } else {
                Integer status3 = item.getStatus();
                if (status3 != null && status3.intValue() == 2 && (itemFamilyApplicationBinding = (ItemFamilyApplicationBinding) holder.getDataBinding()) != null && (textView = itemFamilyApplicationBinding.agreed) != null) {
                    textView.setText(ResourcesKtxKt.getStringById(this, 2131952688));
                }
            }
            ItemFamilyApplicationBinding itemFamilyApplicationBinding7 = (ItemFamilyApplicationBinding) holder.getDataBinding();
            if (itemFamilyApplicationBinding7 != null && (appCompatTextView = itemFamilyApplicationBinding7.memberType) != null) {
                appCompatTextView.setText(item.getMgrName());
            }
        }
        ItemFamilyApplicationBinding itemFamilyApplicationBinding8 = (ItemFamilyApplicationBinding) holder.getDataBinding();
        if (itemFamilyApplicationBinding8 != null && (qMUIRadiusImageView = itemFamilyApplicationBinding8.userAvatarCimageView) != null) {
            User user = item.getUser();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, user != null ? user.getAvatar() : null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
        ItemFamilyApplicationBinding itemFamilyApplicationBinding9 = (ItemFamilyApplicationBinding) holder.getDataBinding();
        if (itemFamilyApplicationBinding9 != null && (textView4 = itemFamilyApplicationBinding9.userName) != null) {
            User user2 = item.getUser();
            if (user2 == null || (str = user2.getNick()) == null) {
                str = "";
            }
            textView4.setText(str);
        }
        ItemFamilyApplicationBinding itemFamilyApplicationBinding10 = (ItemFamilyApplicationBinding) holder.getDataBinding();
        if (itemFamilyApplicationBinding10 == null || (textView3 = itemFamilyApplicationBinding10.time) == null) {
            return;
        }
        Long time = item.getTime();
        textView3.setText(com.qiahao.base_common.utils.f.h(time != null ? time.longValue() : 0L, com.qiahao.base_common.utils.f.e));
    }
}
