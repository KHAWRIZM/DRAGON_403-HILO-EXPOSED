package com.qiahao.nextvideo.ui.power;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.PowerUser;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.ItemPowerTeamMemberManagerBinding;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u0013B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/power/PowerTeamUserAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/PowerUser;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemPowerTeamMemberManagerBinding;", "layout", "", "<init>", "(I)V", "mIsPowerOwn", "", "getMIsPowerOwn", "()Z", "setMIsPowerOwn", "(Z)V", "convert", "", "holder", "item", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PowerTeamUserAdapter extends BaseQuickAdapter<PowerUser, BaseDataBindingHolder<ItemPowerTeamMemberManagerBinding>> {

    @NotNull
    private static final String TAG = "GroupMemberOnlineAdapte";
    private boolean mIsPowerOwn;

    public PowerTeamUserAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public final boolean getMIsPowerOwn() {
        return this.mIsPowerOwn;
    }

    public final void setMIsPowerOwn(boolean z) {
        this.mIsPowerOwn = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemPowerTeamMemberManagerBinding> holder, @NotNull PowerUser item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemPowerTeamMemberManagerBinding");
        ItemPowerTeamMemberManagerBinding itemPowerTeamMemberManagerBinding = (ItemPowerTeamMemberManagerBinding) dataBinding;
        Log.d(TAG, "bind: ----");
        if (!TextUtils.isEmpty(item.getNick())) {
            itemPowerTeamMemberManagerBinding.userName.setText(item.getNick());
        }
        GenderAgeTextView genderAgeTextView = itemPowerTeamMemberManagerBinding.ageTextView;
        Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, item.getSex() == 1 ? R.drawable.icon_boy : R.drawable.icon_girl, 0));
        itemPowerTeamMemberManagerBinding.ageTextView.setBackgroundResource(item.getSex() == 1 ? R.drawable.bg_age_male : R.drawable.bg_age_female);
        itemPowerTeamMemberManagerBinding.ageTextView.setText(Intrinsics.areEqual(item.isShowAge(), 1) ? GroupService.INSTANCE.changeAge(item.getBirthday()) : "");
        CircleImageView circleImageView = itemPowerTeamMemberManagerBinding.userAvatarCimageView;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "userAvatarCimageView");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        String avatar = item.getAvatar();
        ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        lfit.setWidth(dimens.dpToPx(46));
        lfit.setHeight(dimens.dpToPx(46));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind$default(circleImageView, companion.displayUserAvatarImage(avatar, lfit), null, 2, null);
        ImageView imageView = itemPowerTeamMemberManagerBinding.countryImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "countryImage");
        ViewUtilitiesKt.bind(imageView, new ImageUIModel(item.getCountryIcon(), null, null, null, 0, 0, null, 126, null));
        HiloGradeView.setLevelBg$default(itemPowerTeamMemberManagerBinding.wealthLevel, item.getWealthUserGrade(), false, true, false, 10, (Object) null);
        HiloGradeView.setLevelBg$default(itemPowerTeamMemberManagerBinding.charmLevel, item.getCharmUserGrade(), true, false, false, 12, (Object) null);
        HiloGradeView.setLevelBg$default(itemPowerTeamMemberManagerBinding.activityLevel, item.getActivityUserGrade(), false, false, true, 6, (Object) null);
        if (this.mIsPowerOwn) {
            itemPowerTeamMemberManagerBinding.powerMedal.setVisibility(0);
            ImageView imageView2 = itemPowerTeamMemberManagerBinding.powerMedal;
            Intrinsics.checkNotNullExpressionValue(imageView2, "powerMedal");
            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.ic_power_owner_tip), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            return;
        }
        itemPowerTeamMemberManagerBinding.powerMedal.setVisibility(8);
    }
}
