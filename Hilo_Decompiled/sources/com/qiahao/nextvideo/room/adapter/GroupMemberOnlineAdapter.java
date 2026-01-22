package com.qiahao.nextvideo.room.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.RideBean;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.MemberBean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemGroupMemberOnlineBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0002¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/GroupMemberOnlineAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/MemberBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGroupMemberOnlineBinding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "item", "showOnlineStatus", "textView", "Landroid/widget/TextView;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupMemberOnlineAdapter extends BaseQuickAdapter<MemberBean, BaseDataBindingHolder<ItemGroupMemberOnlineBinding>> {
    public GroupMemberOnlineAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public final void showOnlineStatus(@NotNull TextView textView, @NotNull MemberBean item) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        Intrinsics.checkNotNullParameter(item, "item");
        textView.setVisibility(8);
        if (item.getInRoom()) {
            textView.setVisibility(0);
            textView.setTextColor(Color.parseColor("#f9ff48"));
            textView.setBackground(getContext().getDrawable(R.drawable.bg_group_online));
            textView.setText(getContext().getText(2131952939));
            return;
        }
        if (GroupService.INSTANCE.userIsOnline(item.getOnlineStatus())) {
            textView.setVisibility(0);
            textView.setTextColor(Color.parseColor("#35e42b"));
            textView.setBackground(getContext().getDrawable(R.drawable.bg_user_online));
            textView.setText(getContext().getText(2131953583));
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGroupMemberOnlineBinding> holder, @NotNull MemberBean item) {
        Integer level;
        Integer level2;
        Integer level3;
        Integer level4;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupMemberOnlineBinding");
        ItemGroupMemberOnlineBinding itemGroupMemberOnlineBinding = (ItemGroupMemberOnlineBinding) dataBinding;
        if (!TextUtils.isEmpty(item.getNick())) {
            NobleInfo noble = item.getNoble();
            if (((noble == null || (level4 = noble.getLevel()) == null) ? 0 : level4.intValue()) > 0) {
                TextView textView = itemGroupMemberOnlineBinding.userName;
                UserService.Companion companion = UserService.INSTANCE;
                NobleInfo noble2 = item.getNoble();
                textView.setTextColor(UserService.Companion.getNobleColor$default(companion, (noble2 == null || (level3 = noble2.getLevel()) == null) ? 0 : level3.intValue(), 0, 2, null));
            } else {
                itemGroupMemberOnlineBinding.userName.setTextColor(Color.parseColor("#ffffff"));
            }
            itemGroupMemberOnlineBinding.userName.setText(item.getNick());
        }
        GenderAgeTextView genderAgeTextView = itemGroupMemberOnlineBinding.ageTextView;
        Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, item.getSex() == 1 ? R.drawable.icon_boy : R.drawable.icon_girl, 0));
        itemGroupMemberOnlineBinding.ageTextView.setBackgroundResource(item.getSex() == 1 ? R.drawable.bg_age_male : R.drawable.bg_age_female);
        AppCompatTextView appCompatTextView = itemGroupMemberOnlineBinding.ageTextView;
        Integer isShowAge = item.isShowAge();
        appCompatTextView.setText((isShowAge != null ? isShowAge.intValue() : 1) == 1 ? GroupService.INSTANCE.changeAge(item.getBirthday()) : "");
        CircleImageView circleImageView = itemGroupMemberOnlineBinding.userAvatarCimageView;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "userAvatarCimageView");
        ImageUIModel.Companion companion2 = ImageUIModel.INSTANCE;
        String avatar = item.getAvatar();
        ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        lfit.setWidth(dimens.dpToPx(42));
        lfit.setHeight(dimens.dpToPx(42));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind$default(circleImageView, companion2.displayUserAvatarImage(avatar, lfit), null, 2, null);
        ImageView imageView = itemGroupMemberOnlineBinding.countryImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "countryImage");
        ImageKtxKt.loadImage$default(imageView, item.getCountryIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        HiloGradeView.setLevelBg$default(itemGroupMemberOnlineBinding.wealthLevel, item.getWealthUserGrade(), false, true, false, 10, (Object) null);
        HiloGradeView.setLevelBg$default(itemGroupMemberOnlineBinding.charmLevel, item.getCharmUserGrade(), true, false, false, 12, (Object) null);
        TextView textView2 = itemGroupMemberOnlineBinding.onlineStatus;
        Intrinsics.checkNotNullExpressionValue(textView2, "onlineStatus");
        showOnlineStatus(textView2, item);
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        int roomUserRole = meetingRoomManager.getRoomUserRole(item.getExternalId());
        if (roomUserRole > 1) {
            itemGroupMemberOnlineBinding.userTag.setVisibility(0);
            ImageView imageView2 = itemGroupMemberOnlineBinding.userTag;
            Intrinsics.checkNotNullExpressionValue(imageView2, "userTag");
            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(meetingRoomManager.getLevelRes(roomUserRole)), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
        } else {
            itemGroupMemberOnlineBinding.userTag.setVisibility(8);
        }
        if (item.isVip()) {
            itemGroupMemberOnlineBinding.iconVip.setVisibility(0);
            ImageView imageView3 = itemGroupMemberOnlineBinding.iconVip;
            Intrinsics.checkNotNullExpressionValue(imageView3, "iconVip");
            ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, 2131233624, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
        } else {
            itemGroupMemberOnlineBinding.iconVip.setVisibility(8);
        }
        NobleInfo noble3 = item.getNoble();
        if (((noble3 == null || (level2 = noble3.getLevel()) == null) ? 0 : level2.intValue()) > 0) {
            itemGroupMemberOnlineBinding.iconVip.setVisibility(8);
            itemGroupMemberOnlineBinding.iconNoble.setVisibility(0);
            ImageView imageView4 = itemGroupMemberOnlineBinding.iconNoble;
            Context context = itemGroupMemberOnlineBinding.getRoot().getContext();
            UserService.Companion companion3 = UserService.INSTANCE;
            NobleInfo noble4 = item.getNoble();
            imageView4.setImageDrawable(a.getDrawable(context, companion3.getNobleDrawableRes((noble4 == null || (level = noble4.getLevel()) == null) ? 0 : level.intValue())));
        } else {
            itemGroupMemberOnlineBinding.iconNoble.setVisibility(8);
        }
        RideBean ride = item.getRide();
        if (ride != null) {
            if (ride.getId() != 0) {
                String picUrl = ride.getPicUrl();
                if (!(picUrl == null || picUrl.length() == 0)) {
                    itemGroupMemberOnlineBinding.imagMounts.setVisibility(0);
                    ImageView imageView5 = itemGroupMemberOnlineBinding.imagMounts;
                    Intrinsics.checkNotNullExpressionValue(imageView5, "imagMounts");
                    String picUrl2 = ride.getPicUrl();
                    Intrinsics.checkNotNull(picUrl2);
                    lfit.setWidth(dimens.dpToPx(86));
                    lfit.setHeight(dimens.dpToPx(60));
                    ImageUIModel displayUserAvatarImage = companion2.displayUserAvatarImage(picUrl2, lfit);
                    displayUserAvatarImage.setPlaceholder(null);
                    ViewUtilitiesKt.bind(imageView5, displayUserAvatarImage);
                } else {
                    itemGroupMemberOnlineBinding.imagMounts.setVisibility(8);
                }
            } else {
                itemGroupMemberOnlineBinding.imagMounts.setVisibility(8);
            }
        }
        SvipData svip = item.getSvip();
        if (svip == null || !svip.isMystery()) {
            return;
        }
        TextView textView3 = itemGroupMemberOnlineBinding.userName;
        String format = String.format(ResourcesKtxKt.getStringById(this, 2131953504), Arrays.copyOf(new Object[]{svip.mysteryNumber()}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView3.setText(format);
        AppCompatImageView appCompatImageView = itemGroupMemberOnlineBinding.userAvatarCimageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatarCimageView");
        ImageKtxKt.loadImage$default(appCompatImageView, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
        itemGroupMemberOnlineBinding.imagMounts.setVisibility(8);
        itemGroupMemberOnlineBinding.iconVip.setVisibility(8);
        itemGroupMemberOnlineBinding.iconNoble.setVisibility(8);
        itemGroupMemberOnlineBinding.llLevel.setVisibility(8);
    }
}
