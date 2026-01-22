package com.qiahao.nextvideo.ui.rank;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.MedalInfo;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.MySupportBean;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemRankBinding;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/SupportRankAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/MySupportBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemRankBinding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class SupportRankAdapter extends BaseQuickAdapter<MySupportBean, BaseDataBindingHolder<ItemRankBinding>> {
    public SupportRankAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemRankBinding> holder, @NotNull MySupportBean item) {
        String name;
        Integer level;
        Integer level2;
        Integer level3;
        Integer level4;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRankBinding");
        ItemRankBinding itemRankBinding = (ItemRankBinding) dataBinding;
        itemRankBinding.listPosition.setText(String.valueOf(holder.getAdapterPosition() + 4));
        itemRankBinding.ageTextView.setVisibility(8);
        HiloImageView.loadImage$default(itemRankBinding.userAvatarCimageView, ImageSizeKt.image100(item.getUser().getAvatar()), 0, 0, 6, (Object) null);
        itemRankBinding.userId.setText(getContext().getString(2131953102, item.getUser().getCode()));
        NobleInfo noble = item.getUser().getNoble();
        if (((noble == null || (level4 = noble.getLevel()) == null) ? 0 : level4.intValue()) > 0) {
            NickTextView nickTextView = itemRankBinding.userName;
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = item.getUser().getNoble();
            nickTextView.setTextColor(UserService.Companion.getNobleColor$default(companion, (noble2 == null || (level3 = noble2.getLevel()) == null) ? 0 : level3.intValue(), 0, 2, null));
        } else {
            itemRankBinding.userName.setTextColor(Color.parseColor("#333333"));
        }
        NickTextView nickTextView2 = itemRankBinding.userName;
        String name2 = item.getUser().getName();
        CharSequence charSequence = "";
        if ((name2 != null ? name2.length() : 0) > 20) {
            String name3 = item.getUser().getName();
            name = ((Object) (name3 != null ? name3.subSequence(0, 19) : null)) + "...";
        } else {
            name = item.getUser().getName();
            if (name == null) {
                name = "";
            }
        }
        nickTextView2.setText(name);
        GenderAgeTextView genderAgeTextView = itemRankBinding.ageTextView;
        Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        Integer sex = item.getUser().getSex();
        ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, (sex != null && sex.intValue() == 1) ? R.drawable.icon_boy : R.drawable.icon_girl, 0));
        GenderAgeTextView genderAgeTextView2 = itemRankBinding.ageTextView;
        Integer sex2 = item.getUser().getSex();
        genderAgeTextView2.setBackgroundResource((sex2 != null && sex2.intValue() == 1) ? R.drawable.bg_age_male : R.drawable.bg_age_female);
        AppCompatTextView appCompatTextView = itemRankBinding.ageTextView;
        Integer isShowAge = item.getUser().isShowAge();
        if ((isShowAge != null ? isShowAge.intValue() : 1) == 1) {
            GroupService.Companion companion2 = GroupService.INSTANCE;
            Long birthday = item.getUser().getBirthday();
            charSequence = companion2.changeAge(birthday != null ? birthday.longValue() : 0L);
        }
        appCompatTextView.setText(charSequence);
        itemRankBinding.ageTextView.setVisibility(0);
        itemRankBinding.diamond.setText(NumberUtilsKt.rankNumberFormat(item.getScore()));
        ImageView imageView = itemRankBinding.iconVip;
        Boolean isVip = item.getUser().isVip();
        Boolean bool = Boolean.TRUE;
        imageView.setVisibility(Intrinsics.areEqual(isVip, bool) ? 0 : 8);
        NobleInfo noble3 = item.getUser().getNoble();
        if (((noble3 == null || (level2 = noble3.getLevel()) == null) ? 0 : level2.intValue()) > 0) {
            itemRankBinding.iconNoble.setVisibility(0);
            ImageView imageView2 = itemRankBinding.iconNoble;
            Context context = getContext();
            UserService.Companion companion3 = UserService.INSTANCE;
            NobleInfo noble4 = item.getUser().getNoble();
            imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, companion3.getNobleDrawableRes((noble4 == null || (level = noble4.getLevel()) == null) ? 0 : level.intValue())));
            itemRankBinding.iconVip.setVisibility(8);
        } else {
            itemRankBinding.iconNoble.setVisibility(8);
        }
        itemRankBinding.line.setVisibility(0);
        if (item.getUser().getMedalInfo() == null) {
            itemRankBinding.llMedal.setVisibility(8);
        } else {
            itemRankBinding.llMedal.setVisibility(0);
            MedalGridLayout medalGridLayout = itemRankBinding.llMedal;
            List<MedalInfo> medalInfo = item.getUser().getMedalInfo();
            Intrinsics.checkNotNull(medalInfo);
            List mutableList = CollectionsKt.toMutableList(medalInfo);
            Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
            medalGridLayout.setDataAndLayoutView((ArrayList) mutableList, 6);
        }
        if (Intrinsics.areEqual(item.getUser().isPrettyCode(), bool)) {
            ShineTextView shineTextView = itemRankBinding.userId;
            Intrinsics.checkNotNullExpressionValue(shineTextView, TUIConstants.TUILive.USER_ID);
            Resources resources2 = getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
            Dimens dimens = Dimens.INSTANCE;
            ViewUtilitiesKt.setDrawableLeft(shineTextView, ResourceUtilsKt.getDrawable(resources2, 2131232463, dimens.dpToPx(4)));
            itemRankBinding.userId.setCompoundDrawablePadding(dimens.dpToPx(4));
        } else {
            ShineTextView shineTextView2 = itemRankBinding.userId;
            Intrinsics.checkNotNullExpressionValue(shineTextView2, TUIConstants.TUILive.USER_ID);
            ViewUtilitiesKt.setDrawableLeft(shineTextView2, null);
        }
        if (item.getUser().getWealthUserGrade() > -1) {
            HiloGradeView.setLevelBg$default(itemRankBinding.wealthLevel, item.getUser().getWealthUserGrade(), false, true, false, 10, (Object) null);
            itemRankBinding.wealthLevel.setVisibility(0);
        }
        if (item.getUser().getCharmUserGrade() > -1) {
            HiloGradeView.setLevelBg$default(itemRankBinding.charmLevel, item.getUser().getCharmUserGrade(), true, false, false, 12, (Object) null);
            itemRankBinding.charmLevel.setVisibility(0);
        }
        SvipData svip = item.getUser().getSvip();
        if ((svip != null ? svip.getSvipLevel() : 0) > 0) {
            itemRankBinding.iconNoble.setVisibility(8);
            itemRankBinding.iconVip.setVisibility(8);
            itemRankBinding.svip.setVisibility(0);
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            SvipData svip2 = item.getUser().getSvip();
            Integer svipMedal = svipTypeUtils.getSvipMedal(svip2 != null ? Integer.valueOf(svip2.getSvipLevel()) : null);
            if (svipMedal != null) {
                itemRankBinding.svip.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), svipMedal.intValue()));
            }
        } else {
            itemRankBinding.svip.setVisibility(8);
        }
        SvipData svip3 = item.getUser().getSvip();
        if (svip3 != null && svip3.isRankStealth()) {
            HiloImageView.loadImage$default(itemRankBinding.userAvatarCimageView, Integer.valueOf(R.drawable.svip_hide_heard), 0, 0, 6, (Object) null);
            itemRankBinding.userId.setVisibility(8);
            itemRankBinding.userName.setText(ResourcesKtxKt.getStringById(this, 2131954197));
            itemRankBinding.iconNoble.setVisibility(8);
            itemRankBinding.iconVip.setVisibility(8);
            itemRankBinding.svip.setVisibility(8);
            itemRankBinding.ageTextView.setVisibility(8);
            itemRankBinding.wealthLevel.setVisibility(8);
            itemRankBinding.charmLevel.setVisibility(8);
            itemRankBinding.llMedal.setVisibility(8);
            return;
        }
        itemRankBinding.userId.setVisibility(0);
    }
}
