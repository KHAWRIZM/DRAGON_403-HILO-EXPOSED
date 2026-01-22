package com.qiahao.nextvideo.ui.promoter;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.promote.PromoteRank;
import com.qiahao.nextvideo.databinding.ItemFragmentPromoterCenterBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0015¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/promoter/PromoterFragmentCenterAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/promote/PromoteRank;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemFragmentPromoterCenterBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PromoterFragmentCenterAdapter extends BaseQuickAdapter<PromoteRank, BaseDataBindingHolder<ItemFragmentPromoterCenterBinding>> {
    public PromoterFragmentCenterAdapter() {
        super(R.layout.item_fragment_promoter_center, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemFragmentPromoterCenterBinding> holder, @NotNull PromoteRank item) {
        String str;
        String num;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemFragmentPromoterCenterBinding");
        ItemFragmentPromoterCenterBinding itemFragmentPromoterCenterBinding = (ItemFragmentPromoterCenterBinding) dataBinding;
        itemFragmentPromoterCenterBinding.monthBg.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, getContext(), 2131101214, 2131101214, 5, (GradientDrawable.Orientation) null, false, 48, (Object) null));
        QMUIRadiusImageView qMUIRadiusImageView = itemFragmentPromoterCenterBinding.avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        User user = item.getUser();
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(user != null ? user.getAvatar() : null), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        TextView textView = itemFragmentPromoterCenterBinding.name;
        User user2 = item.getUser();
        String str2 = "";
        if (user2 == null || (str = user2.getNick()) == null) {
            str = "";
        }
        textView.setText(str);
        TextView textView2 = itemFragmentPromoterCenterBinding.f٦٠id;
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        User user3 = item.getUser();
        String format = String.format(stringById, Arrays.copyOf(new Object[]{user3 != null ? user3.getCode() : null}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView2.setText("(" + format + ")");
        itemFragmentPromoterCenterBinding.invite.title.setText(ResourcesKtxKt.getStringById(this, 2131954077));
        itemFragmentPromoterCenterBinding.pass.title.setText(ResourcesKtxKt.getStringById(this, 2131952270));
        itemFragmentPromoterCenterBinding.topUp.title.setText(ResourcesKtxKt.getStringById(this, 2131953850));
        TextView textView3 = itemFragmentPromoterCenterBinding.invite.number;
        Integer shareNum = item.getShareNum();
        if (shareNum != null && (num = shareNum.toString()) != null) {
            str2 = num;
        }
        textView3.setText(str2);
        itemFragmentPromoterCenterBinding.pass.number.setText(item.getClients());
        TextView textView4 = itemFragmentPromoterCenterBinding.topUp.number;
        Long dollar = item.getDollar();
        textView4.setText("$" + NumberUtilsKt.rankNumberFormat((dollar != null ? dollar.longValue() : 0L) / 100));
    }
}
