package com.qiahao.nextvideo.ui.friends;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.ContactsLikeEachItem;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemContactLikeEachOtherBinding;
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

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/friends/FriendsListAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/ContactsLikeEachItem;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemContactLikeEachOtherBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FriendsListAdapter extends BaseQuickAdapter<ContactsLikeEachItem, BaseDataBindingHolder<ItemContactLikeEachOtherBinding>> {
    public FriendsListAdapter() {
        super(R.layout.item_contact_like_each_other, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemContactLikeEachOtherBinding> holder, @NotNull ContactsLikeEachItem item) {
        Integer level;
        Integer level2;
        Integer level3;
        Integer level4;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemContactLikeEachOtherBinding itemContactLikeEachOtherBinding = (ItemContactLikeEachOtherBinding) holder.getDataBinding();
        if (itemContactLikeEachOtherBinding != null) {
            if (!TextUtils.isEmpty(item.getUserBase().getNick())) {
                itemContactLikeEachOtherBinding.userName.setText(item.getUserBase().getNick());
            }
            NobleInfo noble = item.getUserBase().getNoble();
            int i = 0;
            if (((noble == null || (level4 = noble.getLevel()) == null) ? 0 : level4.intValue()) > 0) {
                TextView textView = itemContactLikeEachOtherBinding.userName;
                UserService.Companion companion = UserService.INSTANCE;
                NobleInfo noble2 = item.getUserBase().getNoble();
                textView.setTextColor(UserService.Companion.getNobleColor$default(companion, (noble2 == null || (level3 = noble2.getLevel()) == null) ? 0 : level3.intValue(), 0, 2, null));
            } else {
                itemContactLikeEachOtherBinding.userName.setTextColor(Color.parseColor("#333333"));
            }
            GenderAgeTextView genderAgeTextView = itemContactLikeEachOtherBinding.ageTextView;
            Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
            Resources resources = getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, item.getUserBase().getSex() == 1 ? R.drawable.icon_boy : R.drawable.icon_girl, 0));
            itemContactLikeEachOtherBinding.ageTextView.setBackgroundResource(item.getUserBase().getSex() == 1 ? R.drawable.bg_age_male : R.drawable.bg_age_female);
            AppCompatTextView appCompatTextView = itemContactLikeEachOtherBinding.ageTextView;
            GroupService.Companion companion2 = GroupService.INSTANCE;
            Long birthday = item.getUserBase().getBirthday();
            appCompatTextView.setText(companion2.changeAge(birthday != null ? birthday.longValue() : 0L));
            CircleImageView circleImageView = itemContactLikeEachOtherBinding.userAvatarCimageView;
            Intrinsics.checkNotNullExpressionValue(circleImageView, "userAvatarCimageView");
            ImageUIModel.Companion companion3 = ImageUIModel.INSTANCE;
            String avatar = item.getUserBase().getAvatar();
            ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
            Dimens dimens = Dimens.INSTANCE;
            lfit.setWidth(dimens.dpToPx(46));
            lfit.setHeight(dimens.dpToPx(46));
            Unit unit = Unit.INSTANCE;
            ViewUtilitiesKt.bind$default(circleImageView, companion3.displayUserAvatarImage(avatar, lfit), null, 2, null);
            ImageView imageView = itemContactLikeEachOtherBinding.countryImage;
            Intrinsics.checkNotNullExpressionValue(imageView, "countryImage");
            ViewUtilitiesKt.bind(imageView, new ImageUIModel(item.getUserBase().getCountryIcon(), null, null, null, 0, 0, null, 126, null));
            HiloGradeView.setLevelBg$default(itemContactLikeEachOtherBinding.wealthLevel, item.getUserBase().getWealthUserGrade(), false, true, false, 10, (Object) null);
            HiloGradeView.setLevelBg$default(itemContactLikeEachOtherBinding.charmLevel, item.getUserBase().getCharmUserGrade(), true, false, false, 12, (Object) null);
            HiloGradeView.setLevelBg$default(itemContactLikeEachOtherBinding.activityLevel, item.getUserBase().getActivityUserGrade(), false, false, true, 6, (Object) null);
            itemContactLikeEachOtherBinding.onlineStatus.setVisibility(companion2.userIsOnline(item.getOnLineStatus()) ? 0 : 8);
            itemContactLikeEachOtherBinding.iconVip.setVisibility(item.getUserBase().isVip() ? 0 : 8);
            ImageView imageView2 = itemContactLikeEachOtherBinding.iconVip;
            Intrinsics.checkNotNullExpressionValue(imageView2, "iconVip");
            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, 2131233624, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            NobleInfo noble3 = item.getUserBase().getNoble();
            if (((noble3 == null || (level2 = noble3.getLevel()) == null) ? 0 : level2.intValue()) > 0) {
                itemContactLikeEachOtherBinding.iconVip.setVisibility(8);
                itemContactLikeEachOtherBinding.iconNoble.setVisibility(0);
                ImageView imageView3 = itemContactLikeEachOtherBinding.iconNoble;
                Context context = getContext();
                UserService.Companion companion4 = UserService.INSTANCE;
                NobleInfo noble4 = item.getUserBase().getNoble();
                if (noble4 != null && (level = noble4.getLevel()) != null) {
                    i = level.intValue();
                }
                imageView3.setImageDrawable(androidx.core.content.a.getDrawable(context, companion4.getNobleDrawableRes(i)));
                return;
            }
            itemContactLikeEachOtherBinding.iconNoble.setVisibility(8);
        }
    }
}
