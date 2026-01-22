package com.qiahao.nextvideo.ui.home.matching;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.SuperLikeData;
import com.qiahao.nextvideo.databinding.ItemHomeAuthenticationBinding;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/matching/HomeMatchUserAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/SuperLikeData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemHomeAuthenticationBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HomeMatchUserAdapter extends BaseQuickAdapter<SuperLikeData, BaseDataBindingHolder<ItemHomeAuthenticationBinding>> {
    public HomeMatchUserAdapter() {
        super(R.layout.item_home_authentication, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemHomeAuthenticationBinding> holder, @NotNull SuperLikeData item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemHomeAuthenticationBinding");
        ItemHomeAuthenticationBinding itemHomeAuthenticationBinding = (ItemHomeAuthenticationBinding) dataBinding;
        itemHomeAuthenticationBinding.newText.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#FA9756", "#EF2FE4", 10, (GradientDrawable.Orientation) null, 8, (Object) null));
        itemHomeAuthenticationBinding.online.setVisibility(item.isOnline() ? 0 : 8);
        itemHomeAuthenticationBinding.line.setVisibility(item.isOnline() ? 0 : 8);
        itemHomeAuthenticationBinding.newText.setVisibility(item.isNew() ? 0 : 4);
        QMUIRadiusImageView qMUIRadiusImageView = itemHomeAuthenticationBinding.avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, item.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        QMUIRadiusImageView qMUIRadiusImageView2 = itemHomeAuthenticationBinding.myAvatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "myAvatar");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView2, item.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        itemHomeAuthenticationBinding.nick.setText(item.getNick());
        GenderAgeTextView genderAgeTextView = itemHomeAuthenticationBinding.ageTextView;
        Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        Integer sex = item.getSex();
        ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, (sex != null && sex.intValue() == 1) ? R.drawable.icon_boy : R.drawable.icon_girl, 0));
        GenderAgeTextView genderAgeTextView2 = itemHomeAuthenticationBinding.ageTextView;
        Integer sex2 = item.getSex();
        genderAgeTextView2.setBackgroundResource((sex2 != null && sex2.intValue() == 1) ? R.drawable.bg_age_male : R.drawable.bg_age_female);
        itemHomeAuthenticationBinding.ageTextView.setText(item.getAge());
        itemHomeAuthenticationBinding.supperBtn.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), Intrinsics.areEqual(item.isMyLike(), Boolean.TRUE) ? R.drawable.people_super_im_icon : R.drawable.people_super_icon));
    }
}
