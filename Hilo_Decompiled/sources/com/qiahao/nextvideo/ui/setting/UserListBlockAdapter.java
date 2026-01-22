package com.qiahao.nextvideo.ui.setting;

import android.content.res.Resources;
import android.text.TextUtils;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.BlockedInfo;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.ItemUserBlockBinding;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/setting/UserListBlockAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/BlockedInfo;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemUserBlockBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class UserListBlockAdapter extends BaseQuickAdapter<BlockedInfo, BaseDataBindingHolder<ItemUserBlockBinding>> {
    public UserListBlockAdapter() {
        super(R.layout.item_user_block, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemUserBlockBinding> holder, @NotNull BlockedInfo item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemUserBlockBinding");
        ItemUserBlockBinding itemUserBlockBinding = (ItemUserBlockBinding) dataBinding;
        if (!TextUtils.isEmpty(item.getUser().getAvatar())) {
            itemUserBlockBinding.userName.setText(item.getUser().getName());
        }
        GenderAgeTextView genderAgeTextView = itemUserBlockBinding.ageTextView;
        Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        Integer sex = item.getUser().getSex();
        ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, (sex != null && sex.intValue() == 1) ? R.drawable.icon_boy : R.drawable.icon_girl, 0));
        GenderAgeTextView genderAgeTextView2 = itemUserBlockBinding.ageTextView;
        Integer sex2 = item.getUser().getSex();
        genderAgeTextView2.setBackgroundResource((sex2 != null && sex2.intValue() == 1) ? R.drawable.bg_age_male : R.drawable.bg_age_female);
        AppCompatTextView appCompatTextView = itemUserBlockBinding.ageTextView;
        GroupService.Companion companion = GroupService.INSTANCE;
        Long birthday = item.getUser().getBirthday();
        appCompatTextView.setText(companion.changeAge(birthday != null ? birthday.longValue() : 0L));
        CircleImageView circleImageView = itemUserBlockBinding.userAvatarCimageView;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "userAvatarCimageView");
        ImageUIModel.Companion companion2 = ImageUIModel.INSTANCE;
        String avatar = item.getUser().getAvatar();
        ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        lfit.setWidth(dimens.dpToPx(42));
        lfit.setHeight(dimens.dpToPx(42));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind$default(circleImageView, companion2.displayUserAvatarImage(avatar, lfit), null, 2, null);
        itemUserBlockBinding.time.setText(com.qiahao.base_common.utils.f.h(item.getCreatedAt() * 1000, com.qiahao.base_common.utils.f.d));
    }
}
