package com.qiahao.nextvideo.ui.home.discover;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.data.model.GroupMedalDetailBean;
import com.qiahao.nextvideo.data.model.HotGroupBean;
import com.qiahao.nextvideo.databinding.ItemGroupPopular1Binding;
import com.qiahao.nextvideo.ui.rank.GroupMedalAndPowerLayout;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/CountryGroupAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/HotGroupBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGroupPopular1Binding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "bean", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CountryGroupAdapter extends BaseQuickAdapter<HotGroupBean, BaseDataBindingHolder<ItemGroupPopular1Binding>> {

    @NotNull
    private static final String TAG = "CountryGroupAdapter";

    public CountryGroupAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGroupPopular1Binding> holder, @NotNull HotGroupBean bean) {
        int i;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        String nameplate;
        Integer grade;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(bean, "bean");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupPopular1Binding");
        ItemGroupPopular1Binding itemGroupPopular1Binding = (ItemGroupPopular1Binding) dataBinding;
        itemGroupPopular1Binding.constraint.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 10, (GradientDrawable.Orientation) null, 8, (Object) null));
        if (!TextUtils.isEmpty(bean.getName())) {
            itemGroupPopular1Binding.groupName.setText(bean.getName());
        } else {
            itemGroupPopular1Binding.groupName.setText("");
        }
        if (!TextUtils.isEmpty(bean.getNotification())) {
            itemGroupPopular1Binding.groupAnnounce.setText(bean.getNotification());
        } else {
            itemGroupPopular1Binding.groupAnnounce.setText("");
        }
        ImageView imageView5 = itemGroupPopular1Binding.iconCount;
        Intrinsics.checkNotNullExpressionValue(imageView5, "iconCount");
        ImageKtxKt.loadImage$default(imageView5, ImageSizeKt.imageSize(bean.getCountryIcon(), UiKtxKt.toPX(30)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232548, (c5.g) null, 49150, (Object) null);
        RoundedImageView roundedImageView = itemGroupPopular1Binding.roomAvatar;
        Intrinsics.checkNotNullExpressionValue(roundedImageView, "roomAvatar");
        ImageKtxKt.loadImage$default(roundedImageView, ImageSizeKt.image200(bean.getFaceUrl()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231930, (c5.g) null, 49150, (Object) null);
        itemGroupPopular1Binding.personNumber.setText(String.valueOf(bean.getGroupInUserDuration()));
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding = itemGroupPopular1Binding.familyNamePlate;
        Intrinsics.checkNotNullExpressionValue(includeFamilyNamePlateBinding, "familyNamePlate");
        FamilyInfo groupPower = bean.getGroupPower();
        int intValue = (groupPower == null || (grade = groupPower.getGrade()) == null) ? -1 : grade.intValue();
        FamilyInfo groupPower2 = bean.getGroupPower();
        AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding, intValue, (groupPower2 == null || (nameplate = groupPower2.getNameplate()) == null) ? "" : nameplate, 0, 4, (Object) null);
        GroupMedalAndPowerLayout groupMedalAndPowerLayout = itemGroupPopular1Binding.groupMedalAndPower;
        List<GroupMedalDetailBean> groupMedals = bean.getGroupMedals();
        groupMedalAndPowerLayout.setDataAndLayoutView("", (ArrayList) (groupMedals != null ? CollectionsKt.toMutableList(groupMedals) : null), 4);
        itemGroupPopular1Binding.rocket1.setVisibility(8);
        itemGroupPopular1Binding.rocket2.setVisibility(8);
        itemGroupPopular1Binding.rocket3.setVisibility(8);
        itemGroupPopular1Binding.rocket4.setVisibility(8);
        itemGroupPopular1Binding.rocket5.setVisibility(8);
        Integer maxStage = bean.getMaxStage();
        int intValue2 = maxStage != null ? maxStage.intValue() : -1;
        if (intValue2 <= 2 || intValue2 - 2 >= 4) {
            i = 0;
        }
        while (i < 5) {
            if (i == 0) {
                imageView4 = itemGroupPopular1Binding.rocket1;
            } else if (i == 1) {
                imageView4 = itemGroupPopular1Binding.rocket2;
            } else if (i == 2) {
                imageView4 = itemGroupPopular1Binding.rocket3;
            } else if (i != 3) {
                imageView4 = i != 4 ? null : itemGroupPopular1Binding.rocket5;
            } else {
                imageView4 = itemGroupPopular1Binding.rocket4;
            }
            if (imageView4 != null) {
                imageView4.setVisibility(i <= intValue2 ? 0 : 8);
            }
            i++;
        }
        itemGroupPopular1Binding.llRocket.setVisibility(intValue2 > -1 ? 0 : 8);
        String gameTypeIcon = bean.getGameTypeIcon();
        if (gameTypeIcon != null && gameTypeIcon.length() > 0) {
            ItemGroupPopular1Binding itemGroupPopular1Binding2 = (ItemGroupPopular1Binding) holder.getDataBinding();
            if (itemGroupPopular1Binding2 != null && (imageView3 = itemGroupPopular1Binding2.gameImage) != null) {
                imageView3.setVisibility(0);
            }
            ItemGroupPopular1Binding itemGroupPopular1Binding3 = (ItemGroupPopular1Binding) holder.getDataBinding();
            if (itemGroupPopular1Binding3 == null || (imageView2 = itemGroupPopular1Binding3.gameImage) == null) {
                return;
            }
            ImageKtxKt.loadImage$default(imageView2, bean.getGameTypeIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            return;
        }
        ItemGroupPopular1Binding itemGroupPopular1Binding4 = (ItemGroupPopular1Binding) holder.getDataBinding();
        if (itemGroupPopular1Binding4 == null || (imageView = itemGroupPopular1Binding4.gameImage) == null) {
            return;
        }
        imageView.setVisibility(8);
    }
}
