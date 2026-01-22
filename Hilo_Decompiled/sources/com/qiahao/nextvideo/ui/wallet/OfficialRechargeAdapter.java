package com.qiahao.nextvideo.ui.wallet;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.OfficialRechargeBean;
import com.qiahao.nextvideo.databinding.ItemOfficialRechargeBinding;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0015¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/OfficialRechargeAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/OfficialRechargeBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemOfficialRechargeBinding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class OfficialRechargeAdapter extends BaseQuickAdapter<OfficialRechargeBean, BaseDataBindingHolder<ItemOfficialRechargeBinding>> {
    public OfficialRechargeAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemOfficialRechargeBinding> holder, @NotNull OfficialRechargeBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemOfficialRechargeBinding");
        ItemOfficialRechargeBinding itemOfficialRechargeBinding = (ItemOfficialRechargeBinding) dataBinding;
        CircleImageView circleImageView = itemOfficialRechargeBinding.userAvatar;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "userAvatar");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        String avatar = item.getAvatar();
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(39));
        fill.setHeight(dimens.dpToPx(39));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind$default(circleImageView, companion.displayUserAvatarImage(avatar, fill), null, 2, null);
        itemOfficialRechargeBinding.userName.setText(item.getNick());
        ImageView imageView = itemOfficialRechargeBinding.sex;
        Intrinsics.checkNotNullExpressionValue(imageView, "sex");
        ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(item.getSex() == 1 ? R.drawable.icon_boy : R.drawable.icon_girl), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        itemOfficialRechargeBinding.sex.setBackgroundResource(item.getSex() == 1 ? R.drawable.bg_age_male : R.drawable.bg_age_female);
        ImageView imageView2 = itemOfficialRechargeBinding.countryPic;
        Intrinsics.checkNotNullExpressionValue(imageView2, "countryPic");
        String countryIcon = item.getCountryIcon();
        fill.setWidth(dimens.dpToPx(18));
        fill.setHeight(dimens.dpToPx(12));
        ViewUtilitiesKt.bind(imageView2, companion.displayImage(countryIcon, fill));
        itemOfficialRechargeBinding.countryName.setText(item.getCountry());
    }
}
