package com.qiahao.nextvideo.room.adapter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.MemberBean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.ItemGroupMemberAdminBinding;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/GroupMemberAdminAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/MemberBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGroupMemberAdminBinding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupMemberAdminAdapter extends BaseQuickAdapter<MemberBean, BaseDataBindingHolder<ItemGroupMemberAdminBinding>> {
    public GroupMemberAdminAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGroupMemberAdminBinding> holder, @NotNull MemberBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupMemberAdminBinding");
        ItemGroupMemberAdminBinding itemGroupMemberAdminBinding = (ItemGroupMemberAdminBinding) dataBinding;
        if (!TextUtils.isEmpty(item.getNick())) {
            itemGroupMemberAdminBinding.userName.setText(item.getNick());
        }
        GenderAgeTextView genderAgeTextView = itemGroupMemberAdminBinding.ageTextView;
        Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, item.getSex() == 1 ? R.drawable.icon_boy : R.drawable.icon_girl, 0));
        itemGroupMemberAdminBinding.ageTextView.setBackgroundResource(item.getSex() == 1 ? R.drawable.bg_age_male : R.drawable.bg_age_female);
        AppCompatTextView appCompatTextView = itemGroupMemberAdminBinding.ageTextView;
        Integer isShowAge = item.isShowAge();
        appCompatTextView.setText((isShowAge != null ? isShowAge.intValue() : 1) == 1 ? GroupService.INSTANCE.changeAge(item.getBirthday()) : "");
        AppCompatImageView appCompatImageView = itemGroupMemberAdminBinding.userAvatarCimageView;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "userAvatarCimageView");
        ImageKtxKt.loadImage$default(appCompatImageView, item.getAvatar(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (g) null, 49150, (Object) null);
        ImageView imageView = itemGroupMemberAdminBinding.countryImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "countryImage");
        ImageKtxKt.loadImage$default(imageView, item.getCountryIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65534, (Object) null);
        HiloGradeView.setLevelBg$default(itemGroupMemberAdminBinding.wealthLevel, item.getWealthUserGrade(), false, true, false, 10, (Object) null);
        HiloGradeView.setLevelBg$default(itemGroupMemberAdminBinding.charmLevel, item.getCharmUserGrade(), true, false, false, 12, (Object) null);
        MeetingRoomManager meetingRoomManager = MeetingRoomManager.INSTANCE;
        int roomUserRole = meetingRoomManager.getRoomUserRole(item.getExternalId());
        if (roomUserRole > 1) {
            ImageView imageView2 = itemGroupMemberAdminBinding.userTag;
            Intrinsics.checkNotNullExpressionValue(imageView2, "userTag");
            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(meetingRoomManager.getLevelRes(roomUserRole)), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
        } else {
            itemGroupMemberAdminBinding.userTag.setVisibility(8);
        }
        if (item.isVip()) {
            itemGroupMemberAdminBinding.iconVip.setVisibility(0);
        } else {
            itemGroupMemberAdminBinding.iconVip.setVisibility(8);
        }
    }
}
