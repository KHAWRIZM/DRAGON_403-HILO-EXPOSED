package com.qiahao.nextvideo.ui.home.discover;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemActivitiesDetailBinding;
import com.qiahao.nextvideo.ui.rank.MedalGridLayout;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0014J\u0016\u0010\u0014\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\u0015\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/ActivityDetailAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/base_common/model/common/User;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemActivitiesDetailBinding;", "<init>", "()V", "activityShowDiamonds", "", "getActivityShowDiamonds", "()Z", "setActivityShowDiamonds", "(Z)V", "showDiamond", "getShowDiamond", "setShowDiamond", "convert", "", "holder", "item", "onViewAttachedToWindow", "onViewRecycled", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ActivityDetailAdapter extends BaseQuickAdapter<User, BaseDataBindingHolder<ItemActivitiesDetailBinding>> {
    private boolean activityShowDiamonds;
    private boolean showDiamond;

    public ActivityDetailAdapter() {
        super(R.layout.item_activities_detail, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public final boolean getActivityShowDiamonds() {
        return this.activityShowDiamonds;
    }

    public final boolean getShowDiamond() {
        return this.showDiamond;
    }

    public final void setActivityShowDiamonds(boolean z) {
        this.activityShowDiamonds = z;
    }

    public final void setShowDiamond(boolean z) {
        this.showDiamond = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemActivitiesDetailBinding> holder, @NotNull User item) {
        TextView textView;
        LinearLayout linearLayout;
        MedalGridLayout medalGridLayout;
        MedalGridLayout medalGridLayout2;
        ShineTextView shineTextView;
        String nick;
        ImageView imageView;
        ImageView imageView2;
        ShineTextView shineTextView2;
        MedalGridLayout medalGridLayout3;
        HiloGradeView hiloGradeView;
        HiloGradeView hiloGradeView2;
        AppCompatTextView appCompatTextView;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        NickTextView nickTextView;
        NickTextView nickTextView2;
        ShineTextView shineTextView3;
        HiloImageView hiloImageView;
        ImageView imageView6;
        ImageView imageView7;
        ImageView imageView8;
        ImageView imageView9;
        ImageView imageView10;
        Integer level;
        ImageView imageView11;
        ImageView imageView12;
        Integer level2;
        ImageView imageView13;
        TextView textView2;
        NickTextView nickTextView3;
        Integer level3;
        NickTextView nickTextView4;
        ShineTextView shineTextView4;
        HiloGradeView hiloGradeView3;
        HiloGradeView hiloGradeView4;
        HiloGradeView hiloGradeView5;
        HiloGradeView hiloGradeView6;
        ShineTextView shineTextView5;
        ShineTextView shineTextView6;
        MedalGridLayout medalGridLayout4;
        AppCompatTextView appCompatTextView2;
        AppCompatTextView appCompatTextView3;
        GenderAgeTextView genderAgeTextView;
        GenderAgeTextView genderAgeTextView2;
        HiloImageView hiloImageView2;
        TextView textView3;
        TextView textView4;
        LinearLayout linearLayout2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        if (this.activityShowDiamonds) {
            ItemActivitiesDetailBinding itemActivitiesDetailBinding = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding != null && (linearLayout2 = itemActivitiesDetailBinding.llDiamond) != null) {
                linearLayout2.setVisibility(this.showDiamond ? 0 : 8);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding2 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding2 != null && (textView4 = itemActivitiesDetailBinding2.listPosition) != null) {
                textView4.setVisibility(0);
            }
        } else {
            ItemActivitiesDetailBinding itemActivitiesDetailBinding3 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding3 != null && (linearLayout = itemActivitiesDetailBinding3.llDiamond) != null) {
                linearLayout.setVisibility(8);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding4 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding4 != null && (textView = itemActivitiesDetailBinding4.listPosition) != null) {
                textView.setVisibility(8);
            }
        }
        ItemActivitiesDetailBinding itemActivitiesDetailBinding5 = (ItemActivitiesDetailBinding) holder.getDataBinding();
        if (itemActivitiesDetailBinding5 != null && (textView3 = itemActivitiesDetailBinding5.listPosition) != null) {
            textView3.setText(String.valueOf(holder.getAdapterPosition() + 1));
        }
        ItemActivitiesDetailBinding itemActivitiesDetailBinding6 = (ItemActivitiesDetailBinding) holder.getDataBinding();
        if (itemActivitiesDetailBinding6 != null && (hiloImageView2 = itemActivitiesDetailBinding6.userAvatarCimageView) != null) {
            HiloImageView.loadImage$default(hiloImageView2, ImageSizeKt.image100(item.getAvatar()), 0, 0, 6, (Object) null);
        }
        ItemActivitiesDetailBinding itemActivitiesDetailBinding7 = (ItemActivitiesDetailBinding) holder.getDataBinding();
        if (itemActivitiesDetailBinding7 != null && (genderAgeTextView2 = itemActivitiesDetailBinding7.ageTextView) != null) {
            Resources resources = getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(genderAgeTextView2, ResourceUtilsKt.getDrawable(resources, item.getSex() == 1 ? R.drawable.icon_boy : R.drawable.icon_girl, 0));
        }
        ItemActivitiesDetailBinding itemActivitiesDetailBinding8 = (ItemActivitiesDetailBinding) holder.getDataBinding();
        if (itemActivitiesDetailBinding8 != null && (genderAgeTextView = itemActivitiesDetailBinding8.ageTextView) != null) {
            genderAgeTextView.setBackgroundResource(item.getSex() == 1 ? R.drawable.bg_age_male : R.drawable.bg_age_female);
        }
        ItemActivitiesDetailBinding itemActivitiesDetailBinding9 = (ItemActivitiesDetailBinding) holder.getDataBinding();
        if (itemActivitiesDetailBinding9 != null && (appCompatTextView3 = itemActivitiesDetailBinding9.ageTextView) != null) {
            GroupService.Companion companion = GroupService.INSTANCE;
            Long birthday = item.getBirthday();
            appCompatTextView3.setText(companion.changeAge(birthday != null ? birthday.longValue() : 0L));
        }
        ItemActivitiesDetailBinding itemActivitiesDetailBinding10 = (ItemActivitiesDetailBinding) holder.getDataBinding();
        if (itemActivitiesDetailBinding10 != null && (appCompatTextView2 = itemActivitiesDetailBinding10.ageTextView) != null) {
            appCompatTextView2.setVisibility(0);
        }
        if (item.getMedalInfo() == null) {
            ItemActivitiesDetailBinding itemActivitiesDetailBinding11 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding11 != null && (medalGridLayout4 = itemActivitiesDetailBinding11.llMedal) != null) {
                medalGridLayout4.setVisibility(8);
            }
        } else {
            ItemActivitiesDetailBinding itemActivitiesDetailBinding12 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding12 != null && (medalGridLayout2 = itemActivitiesDetailBinding12.llMedal) != null) {
                medalGridLayout2.setVisibility(0);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding13 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding13 != null && (medalGridLayout = itemActivitiesDetailBinding13.llMedal) != null) {
                List medalInfo = item.getMedalInfo();
                List mutableList = medalInfo != null ? CollectionsKt.toMutableList(medalInfo) : null;
                Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
                medalGridLayout.setDataAndLayoutView((ArrayList) mutableList, 6);
            }
        }
        if (Intrinsics.areEqual(item.isPrettyCode(), Boolean.TRUE)) {
            ItemActivitiesDetailBinding itemActivitiesDetailBinding14 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding14 != null && (shineTextView6 = itemActivitiesDetailBinding14.userId) != null) {
                Resources resources2 = getContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
                ViewUtilitiesKt.setDrawableLeft(shineTextView6, ResourceUtilsKt.getDrawable(resources2, 2131232463, Dimens.INSTANCE.dpToPx(4)));
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding15 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding15 != null && (shineTextView5 = itemActivitiesDetailBinding15.userId) != null) {
                shineTextView5.setCompoundDrawablePadding(Dimens.INSTANCE.dpToPx(4));
            }
        } else {
            ItemActivitiesDetailBinding itemActivitiesDetailBinding16 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding16 != null && (shineTextView = itemActivitiesDetailBinding16.userId) != null) {
                ViewUtilitiesKt.setDrawableLeft(shineTextView, null);
            }
        }
        if (item.getWealthUserGrade() > -1) {
            ItemActivitiesDetailBinding itemActivitiesDetailBinding17 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding17 != null && (hiloGradeView6 = itemActivitiesDetailBinding17.wealthLevel) != null) {
                HiloGradeView.setLevelBg$default(hiloGradeView6, item.getWealthUserGrade(), false, true, false, 10, (Object) null);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding18 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding18 != null && (hiloGradeView5 = itemActivitiesDetailBinding18.wealthLevel) != null) {
                hiloGradeView5.setVisibility(0);
            }
        }
        if (item.getCharmUserGrade() > -1) {
            ItemActivitiesDetailBinding itemActivitiesDetailBinding19 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding19 != null && (hiloGradeView4 = itemActivitiesDetailBinding19.charmLevel) != null) {
                HiloGradeView.setLevelBg$default(hiloGradeView4, item.getCharmUserGrade(), true, false, false, 12, (Object) null);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding20 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding20 != null && (hiloGradeView3 = itemActivitiesDetailBinding20.charmLevel) != null) {
                hiloGradeView3.setVisibility(0);
            }
        }
        ItemActivitiesDetailBinding itemActivitiesDetailBinding21 = (ItemActivitiesDetailBinding) holder.getDataBinding();
        if (itemActivitiesDetailBinding21 != null && (shineTextView4 = itemActivitiesDetailBinding21.userId) != null) {
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{item.getCode()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            shineTextView4.setNobleLevel(format);
        }
        String nick2 = item.getNick();
        if ((nick2 != null ? nick2.length() : 0) > 20) {
            String nick3 = item.getNick();
            nick = ((Object) (nick3 != null ? nick3.subSequence(0, 19) : null)) + "...";
        } else {
            nick = item.getNick();
        }
        ItemActivitiesDetailBinding itemActivitiesDetailBinding22 = (ItemActivitiesDetailBinding) holder.getDataBinding();
        if (itemActivitiesDetailBinding22 != null && (nickTextView4 = itemActivitiesDetailBinding22.userName) != null) {
            UserService.Companion companion2 = UserService.INSTANCE;
            SvipData svip = item.getSvip();
            nickTextView4.setTextColor(companion2.getNobleColor(svip != null ? svip.getSvipLevel() : 0, Color.parseColor("#333333")));
        }
        ItemActivitiesDetailBinding itemActivitiesDetailBinding23 = (ItemActivitiesDetailBinding) holder.getDataBinding();
        if (itemActivitiesDetailBinding23 != null && (nickTextView3 = itemActivitiesDetailBinding23.userName) != null) {
            SvipData svip2 = item.getSvip();
            int svipLevel = svip2 != null ? svip2.getSvipLevel() : 0;
            NobleInfo noble = item.getNoble();
            nickTextView3.setSVipAndNoble(nick, svipLevel, (noble == null || (level3 = noble.getLevel()) == null) ? 0 : level3.intValue());
        }
        ItemActivitiesDetailBinding itemActivitiesDetailBinding24 = (ItemActivitiesDetailBinding) holder.getDataBinding();
        if (itemActivitiesDetailBinding24 != null && (textView2 = itemActivitiesDetailBinding24.diamond) != null) {
            Double diamond = item.getDiamond();
            textView2.setText(NumberUtilsKt.rankNumberFormat(diamond != null ? (long) diamond.doubleValue() : 0L));
        }
        ItemActivitiesDetailBinding itemActivitiesDetailBinding25 = (ItemActivitiesDetailBinding) holder.getDataBinding();
        if (itemActivitiesDetailBinding25 != null && (imageView13 = itemActivitiesDetailBinding25.iconVip) != null) {
            imageView13.setVisibility(item.isVip() ? 0 : 8);
        }
        NobleInfo noble2 = item.getNoble();
        if (((noble2 == null || (level2 = noble2.getLevel()) == null) ? 0 : level2.intValue()) > 0) {
            ItemActivitiesDetailBinding itemActivitiesDetailBinding26 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding26 != null && (imageView12 = itemActivitiesDetailBinding26.iconNoble) != null) {
                imageView12.setVisibility(0);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding27 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding27 != null && (imageView11 = itemActivitiesDetailBinding27.iconVip) != null) {
                imageView11.setVisibility(8);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding28 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding28 != null && (imageView10 = itemActivitiesDetailBinding28.iconNoble) != null) {
                Context context = getContext();
                UserService.Companion companion3 = UserService.INSTANCE;
                NobleInfo noble3 = item.getNoble();
                imageView10.setImageDrawable(androidx.core.content.a.getDrawable(context, companion3.getNobleDrawableRes((noble3 == null || (level = noble3.getLevel()) == null) ? 0 : level.intValue())));
            }
        } else {
            ItemActivitiesDetailBinding itemActivitiesDetailBinding29 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding29 != null && (imageView = itemActivitiesDetailBinding29.iconNoble) != null) {
                imageView.setVisibility(8);
            }
        }
        SvipData svip3 = item.getSvip();
        if ((svip3 != null ? svip3.getSvipLevel() : 0) > 0) {
            ItemActivitiesDetailBinding itemActivitiesDetailBinding30 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding30 != null && (imageView9 = itemActivitiesDetailBinding30.iconNoble) != null) {
                imageView9.setVisibility(8);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding31 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding31 != null && (imageView8 = itemActivitiesDetailBinding31.iconVip) != null) {
                imageView8.setVisibility(8);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding32 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding32 != null && (imageView7 = itemActivitiesDetailBinding32.svip) != null) {
                imageView7.setVisibility(0);
            }
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            SvipData svip4 = item.getSvip();
            Integer svipMedal = svipTypeUtils.getSvipMedal(svip4 != null ? Integer.valueOf(svip4.getSvipLevel()) : null);
            if (svipMedal != null) {
                int intValue = svipMedal.intValue();
                ItemActivitiesDetailBinding itemActivitiesDetailBinding33 = (ItemActivitiesDetailBinding) holder.getDataBinding();
                if (itemActivitiesDetailBinding33 != null && (imageView6 = itemActivitiesDetailBinding33.svip) != null) {
                    imageView6.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), intValue));
                }
            }
        } else {
            ItemActivitiesDetailBinding itemActivitiesDetailBinding34 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding34 != null && (imageView2 = itemActivitiesDetailBinding34.svip) != null) {
                imageView2.setVisibility(8);
            }
        }
        SvipData svip5 = item.getSvip();
        if (svip5 != null && svip5.isRankStealth()) {
            ItemActivitiesDetailBinding itemActivitiesDetailBinding35 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding35 != null && (hiloImageView = itemActivitiesDetailBinding35.userAvatarCimageView) != null) {
                HiloImageView.loadImage$default(hiloImageView, Integer.valueOf(R.drawable.svip_hide_heard), 0, 0, 6, (Object) null);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding36 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding36 != null && (shineTextView3 = itemActivitiesDetailBinding36.userId) != null) {
                shineTextView3.setVisibility(8);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding37 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding37 != null && (nickTextView2 = itemActivitiesDetailBinding37.userName) != null) {
                nickTextView2.setDefault(androidx.core.content.a.getColor(getContext(), 2131099872));
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding38 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding38 != null && (nickTextView = itemActivitiesDetailBinding38.userName) != null) {
                nickTextView.setText(ResourcesKtxKt.getStringById(this, 2131954197));
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding39 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding39 != null && (imageView5 = itemActivitiesDetailBinding39.iconNoble) != null) {
                imageView5.setVisibility(8);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding40 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding40 != null && (imageView4 = itemActivitiesDetailBinding40.iconVip) != null) {
                imageView4.setVisibility(8);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding41 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding41 != null && (imageView3 = itemActivitiesDetailBinding41.svip) != null) {
                imageView3.setVisibility(8);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding42 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding42 != null && (appCompatTextView = itemActivitiesDetailBinding42.ageTextView) != null) {
                appCompatTextView.setVisibility(8);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding43 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding43 != null && (hiloGradeView2 = itemActivitiesDetailBinding43.wealthLevel) != null) {
                hiloGradeView2.setVisibility(8);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding44 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding44 != null && (hiloGradeView = itemActivitiesDetailBinding44.charmLevel) != null) {
                hiloGradeView.setVisibility(8);
            }
            ItemActivitiesDetailBinding itemActivitiesDetailBinding45 = (ItemActivitiesDetailBinding) holder.getDataBinding();
            if (itemActivitiesDetailBinding45 == null || (medalGridLayout3 = itemActivitiesDetailBinding45.llMedal) == null) {
                return;
            }
            medalGridLayout3.setVisibility(8);
            return;
        }
        ItemActivitiesDetailBinding itemActivitiesDetailBinding46 = (ItemActivitiesDetailBinding) holder.getDataBinding();
        if (itemActivitiesDetailBinding46 == null || (shineTextView2 = itemActivitiesDetailBinding46.userId) == null) {
            return;
        }
        shineTextView2.setVisibility(0);
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemActivitiesDetailBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        holder.getView(R.id.user_id).stopAnimation();
        holder.getView(2131365557).startOrStopAnim(false);
    }

    public void onViewAttachedToWindow(@NotNull BaseDataBindingHolder<ItemActivitiesDetailBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        holder.getView(2131365557).startOrStopAnim(true);
    }
}
