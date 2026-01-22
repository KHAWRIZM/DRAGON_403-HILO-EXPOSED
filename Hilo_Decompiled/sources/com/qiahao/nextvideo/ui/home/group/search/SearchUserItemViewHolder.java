package com.qiahao.nextvideo.ui.home.group.search;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.HiloApplication;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemSearchUserViewBinding;
import com.qiahao.nextvideo.ui.login.VerificationCodeFragment;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.ui.reusable.views.list.ViewHolder;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/group/search/SearchUserItemViewHolder;", "Lcom/qiahao/nextvideo/ui/reusable/views/list/ViewHolder;", "binding", "Lcom/qiahao/nextvideo/databinding/ItemSearchUserViewBinding;", "<init>", "(Lcom/qiahao/nextvideo/databinding/ItemSearchUserViewBinding;)V", "getBinding", "()Lcom/qiahao/nextvideo/databinding/ItemSearchUserViewBinding;", VerificationCodeFragment.TYPE_BIND, "", "bean", "Lcom/qiahao/base_common/model/common/User;", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SearchUserItemViewHolder extends ViewHolder {

    @NotNull
    private static final String TAG = "PopularViewItemListWrap";

    @NotNull
    private final ItemSearchUserViewBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SearchUserItemViewHolder(@NotNull ItemSearchUserViewBinding itemSearchUserViewBinding) {
        super(r0);
        Intrinsics.checkNotNullParameter(itemSearchUserViewBinding, "binding");
        View root = itemSearchUserViewBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        this.binding = itemSearchUserViewBinding;
    }

    public final void bind(@NotNull User bean) {
        int i;
        int i2;
        long j;
        int i3;
        int i4;
        Integer level;
        Integer level2;
        int i5;
        int i6;
        Integer level3;
        Integer level4;
        Intrinsics.checkNotNullParameter(bean, "bean");
        Log.d(TAG, "bind: ----");
        int i7 = 0;
        if (!TextUtils.isEmpty(bean.getNick())) {
            this.binding.userName.setText(bean.getNick());
            NobleInfo noble = bean.getNoble();
            if (noble != null && (level4 = noble.getLevel()) != null) {
                i5 = level4.intValue();
            } else {
                i5 = 0;
            }
            if (i5 > 0) {
                TextView textView = this.binding.userName;
                UserService.Companion companion = UserService.INSTANCE;
                NobleInfo noble2 = bean.getNoble();
                if (noble2 != null && (level3 = noble2.getLevel()) != null) {
                    i6 = level3.intValue();
                } else {
                    i6 = 0;
                }
                textView.setTextColor(UserService.Companion.getNobleColor$default(companion, i6, 0, 2, null));
            }
        }
        GenderAgeTextView genderAgeTextView = this.binding.ageTextView;
        Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
        Resources resources = HiloApplication.INSTANCE.getCONTEXT().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        if (bean.getSex() == 1) {
            i = R.drawable.icon_boy;
        } else {
            i = R.drawable.icon_girl;
        }
        ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, i, 0));
        GenderAgeTextView genderAgeTextView2 = this.binding.ageTextView;
        if (bean.getSex() == 1) {
            i2 = R.drawable.bg_age_male;
        } else {
            i2 = R.drawable.bg_age_female;
        }
        genderAgeTextView2.setBackgroundResource(i2);
        AppCompatTextView appCompatTextView = this.binding.ageTextView;
        GroupService.Companion companion2 = GroupService.INSTANCE;
        Long birthday = bean.getBirthday();
        if (birthday != null) {
            j = birthday.longValue();
        } else {
            j = 0;
        }
        appCompatTextView.setText(companion2.changeAge(j));
        CircleImageView circleImageView = this.binding.userAvatarCimageView;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "userAvatarCimageView");
        ImageUIModel.Companion companion3 = ImageUIModel.INSTANCE;
        String avatar = bean.getAvatar();
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(42));
        fill.setHeight(dimens.dpToPx(42));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind$default(circleImageView, companion3.displayUserAvatarImage(avatar, fill), null, 2, null);
        ImageView imageView = this.binding.countryImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "countryImage");
        ViewUtilitiesKt.bind(imageView, new ImageUIModel(bean.getCountryIcon(), null, null, null, 0, 0, null, 126, null));
        HiloGradeView.setLevelBg$default(this.binding.wealthLevel, bean.getWealthUserGrade(), false, true, false, 10, (Object) null);
        HiloGradeView.setLevelBg$default(this.binding.charmLevel, bean.getCharmUserGrade(), true, false, false, 12, (Object) null);
        ImageView imageView2 = this.binding.iconVip;
        if (bean.isVip()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        imageView2.setVisibility(i3);
        NobleInfo noble3 = bean.getNoble();
        if (noble3 != null && (level2 = noble3.getLevel()) != null) {
            i4 = level2.intValue();
        } else {
            i4 = 0;
        }
        if (i4 > 0) {
            this.binding.iconVip.setVisibility(8);
            this.binding.iconNoble.setVisibility(0);
            ItemSearchUserViewBinding itemSearchUserViewBinding = this.binding;
            ImageView imageView3 = itemSearchUserViewBinding.iconNoble;
            Context context = itemSearchUserViewBinding.getRoot().getContext();
            UserService.Companion companion4 = UserService.INSTANCE;
            NobleInfo noble4 = bean.getNoble();
            if (noble4 != null && (level = noble4.getLevel()) != null) {
                i7 = level.intValue();
            }
            imageView3.setImageDrawable(androidx.core.content.a.getDrawable(context, companion4.getNobleDrawableRes(i7)));
            return;
        }
        this.binding.iconNoble.setVisibility(8);
    }

    @NotNull
    public final ItemSearchUserViewBinding getBinding() {
        return this.binding;
    }
}
