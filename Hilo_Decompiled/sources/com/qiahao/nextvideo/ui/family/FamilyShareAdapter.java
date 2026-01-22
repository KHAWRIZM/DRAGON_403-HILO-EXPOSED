package com.qiahao.nextvideo.ui.family;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.ContactsLikeEachItem;
import com.qiahao.nextvideo.databinding.ItemFamilyShareBinding;
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

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J,\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014J\u0016\u0010\u000e\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilyShareAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/ContactsLikeEachItem;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemFamilyShareBinding;", "<init>", "()V", "convert", "", "holder", "item", "payloads", "", "", "onViewRecycled", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilyShareAdapter extends BaseQuickAdapter<ContactsLikeEachItem, BaseDataBindingHolder<ItemFamilyShareBinding>> {
    public FamilyShareAdapter() {
        super(R.layout.item_family_share, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BaseDataBindingHolder<ItemFamilyShareBinding>) baseViewHolder, (ContactsLikeEachItem) obj, (List<? extends Object>) list);
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemFamilyShareBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        holder.getView(R.id.f١١id).stopAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemFamilyShareBinding> holder, @NotNull ContactsLikeEachItem item) {
        ShineTextView shineTextView;
        ShineTextView shineTextView2;
        ShineTextView shineTextView3;
        ShineTextView shineTextView4;
        TextView textView;
        QMUIRadiusImageView qMUIRadiusImageView;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemFamilyShareBinding itemFamilyShareBinding = (ItemFamilyShareBinding) holder.getDataBinding();
        if (itemFamilyShareBinding != null && (imageView = itemFamilyShareBinding.select) != null) {
            imageView.setSelected(item.getIsSelect());
        }
        ItemFamilyShareBinding itemFamilyShareBinding2 = (ItemFamilyShareBinding) holder.getDataBinding();
        if (itemFamilyShareBinding2 != null && (qMUIRadiusImageView = itemFamilyShareBinding2.userAvatarCimageView) != null) {
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(item.getUserBase().getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
        ItemFamilyShareBinding itemFamilyShareBinding3 = (ItemFamilyShareBinding) holder.getDataBinding();
        if (itemFamilyShareBinding3 != null && (textView = itemFamilyShareBinding3.userName) != null) {
            String nick = item.getUserBase().getNick();
            if (nick == null) {
                nick = "";
            }
            textView.setText(nick);
        }
        if (Intrinsics.areEqual(item.getUserBase().isPrettyCode(), Boolean.TRUE)) {
            ItemFamilyShareBinding itemFamilyShareBinding4 = (ItemFamilyShareBinding) holder.getDataBinding();
            if (itemFamilyShareBinding4 != null && (shineTextView4 = itemFamilyShareBinding4.f٥٩id) != null) {
                Resources resources = getContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                ViewUtilitiesKt.setDrawableLeft(shineTextView4, ResourceUtilsKt.getDrawable(resources, 2131232463, Dimens.INSTANCE.dpToPx(4)));
            }
            ItemFamilyShareBinding itemFamilyShareBinding5 = (ItemFamilyShareBinding) holder.getDataBinding();
            if (itemFamilyShareBinding5 != null && (shineTextView3 = itemFamilyShareBinding5.f٥٩id) != null) {
                shineTextView3.setCompoundDrawablePadding(Dimens.INSTANCE.dpToPx(4));
            }
        } else {
            ItemFamilyShareBinding itemFamilyShareBinding6 = (ItemFamilyShareBinding) holder.getDataBinding();
            if (itemFamilyShareBinding6 != null && (shineTextView = itemFamilyShareBinding6.f٥٩id) != null) {
                ViewUtilitiesKt.setDrawableLeft(shineTextView, null);
            }
        }
        ItemFamilyShareBinding itemFamilyShareBinding7 = (ItemFamilyShareBinding) holder.getDataBinding();
        if (itemFamilyShareBinding7 == null || (shineTextView2 = itemFamilyShareBinding7.f٥٩id) == null) {
            return;
        }
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{item.getUserBase().getCode()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        shineTextView2.setText(format);
    }

    protected void convert(@NotNull BaseDataBindingHolder<ItemFamilyShareBinding> holder, @NotNull ContactsLikeEachItem item, @NotNull List<? extends Object> payloads) {
        ShineTextView shineTextView;
        ShineTextView shineTextView2;
        ShineTextView shineTextView3;
        ShineTextView shineTextView4;
        TextView textView;
        QMUIRadiusImageView qMUIRadiusImageView;
        ImageView imageView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ItemFamilyShareBinding itemFamilyShareBinding = (ItemFamilyShareBinding) holder.getDataBinding();
        if (itemFamilyShareBinding != null && (imageView = itemFamilyShareBinding.select) != null) {
            imageView.setSelected(item.getIsSelect());
        }
        ItemFamilyShareBinding itemFamilyShareBinding2 = (ItemFamilyShareBinding) holder.getDataBinding();
        if (itemFamilyShareBinding2 != null && (qMUIRadiusImageView = itemFamilyShareBinding2.userAvatarCimageView) != null) {
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, item.getUserBase().getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
        ItemFamilyShareBinding itemFamilyShareBinding3 = (ItemFamilyShareBinding) holder.getDataBinding();
        if (itemFamilyShareBinding3 != null && (textView = itemFamilyShareBinding3.userName) != null) {
            String nick = item.getUserBase().getNick();
            if (nick == null) {
                nick = "";
            }
            textView.setText(nick);
        }
        if (Intrinsics.areEqual(item.getUserBase().isPrettyCode(), Boolean.TRUE)) {
            ItemFamilyShareBinding itemFamilyShareBinding4 = (ItemFamilyShareBinding) holder.getDataBinding();
            if (itemFamilyShareBinding4 != null && (shineTextView4 = itemFamilyShareBinding4.f٥٩id) != null) {
                Resources resources = getContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                ViewUtilitiesKt.setDrawableLeft(shineTextView4, ResourceUtilsKt.getDrawable(resources, 2131232463, Dimens.INSTANCE.dpToPx(4)));
            }
            ItemFamilyShareBinding itemFamilyShareBinding5 = (ItemFamilyShareBinding) holder.getDataBinding();
            if (itemFamilyShareBinding5 != null && (shineTextView3 = itemFamilyShareBinding5.f٥٩id) != null) {
                shineTextView3.setCompoundDrawablePadding(Dimens.INSTANCE.dpToPx(4));
            }
        } else {
            ItemFamilyShareBinding itemFamilyShareBinding6 = (ItemFamilyShareBinding) holder.getDataBinding();
            if (itemFamilyShareBinding6 != null && (shineTextView = itemFamilyShareBinding6.f٥٩id) != null) {
                ViewUtilitiesKt.setDrawableLeft(shineTextView, null);
            }
        }
        ItemFamilyShareBinding itemFamilyShareBinding7 = (ItemFamilyShareBinding) holder.getDataBinding();
        if (itemFamilyShareBinding7 == null || (shineTextView2 = itemFamilyShareBinding7.f٥٩id) == null) {
            return;
        }
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{item.getUserBase().getCode()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        shineTextView2.setText(format);
    }
}
