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
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.CountryIDView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.UserStore;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemRank1Binding;
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
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0014J\u0016\u0010\u0014\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\u0015\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/CommonRankAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/ui/rank/CommonRankViewModel;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemRank1Binding;", "layout", "", "mLevelType", "mDateType", "", "<init>", "(IILjava/lang/String;)V", "getMLevelType", "()I", "getMDateType", "()Ljava/lang/String;", "convert", "", "holder", "item", "onViewAttachedToWindow", "onViewRecycled", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCommonRankAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CommonRankAdapter.kt\ncom/qiahao/nextvideo/ui/rank/CommonRankAdapter\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,230:1\n439#2:231\n*S KotlinDebug\n*F\n+ 1 CommonRankAdapter.kt\ncom/qiahao/nextvideo/ui/rank/CommonRankAdapter\n*L\n146#1:231\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommonRankAdapter extends BaseQuickAdapter<CommonRankViewModel, BaseDataBindingHolder<ItemRank1Binding>> {

    @NotNull
    private final String mDateType;
    private final int mLevelType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonRankAdapter(int i, int i2, @NotNull String str) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "mDateType");
        this.mLevelType = i2;
        this.mDateType = str;
    }

    @NotNull
    public final String getMDateType() {
        return this.mDateType;
    }

    public final int getMLevelType() {
        return this.mLevelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemRank1Binding> holder, @NotNull CommonRankViewModel item) {
        String name;
        Integer level;
        Integer level2;
        Integer level3;
        Integer level4;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRank1Binding");
        ItemRank1Binding itemRank1Binding = (ItemRank1Binding) dataBinding;
        itemRank1Binding.listPosition.setText(String.valueOf(holder.getAdapterPosition() + 4));
        itemRank1Binding.llDiamond.setVisibility(Intrinsics.areEqual(this.mDateType, "day") ? 0 : 8);
        if (this.mLevelType == 2) {
            HiloImageView.loadImage$default(itemRank1Binding.userAvatarCimageView, ImageSizeKt.image100(item.getFaceUrl()), 0, 0, 6, (Object) null);
            itemRank1Binding.ageTextView.setVisibility(8);
            if (item.getMedalInfo() == null) {
                itemRank1Binding.llMedal.setVisibility(8);
            } else {
                itemRank1Binding.llMedal.setVisibility(0);
                MedalGridLayout medalGridLayout = itemRank1Binding.llMedal;
                List mutableList = CollectionsKt.toMutableList(item.getMedalInfo());
                Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
                medalGridLayout.setDataAndLayoutView((ArrayList) mutableList, 6);
            }
        } else {
            HiloImageView.loadImage$default(itemRank1Binding.userAvatarCimageView, ImageSizeKt.image100(item.getFaceUrl()), 0, 0, 6, (Object) null);
            GenderAgeTextView genderAgeTextView = itemRank1Binding.ageTextView;
            Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
            Resources resources = getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, item.getSex() == 1 ? R.drawable.icon_boy : R.drawable.icon_girl, 0));
            itemRank1Binding.ageTextView.setBackgroundResource(item.getSex() == 1 ? R.drawable.bg_age_male : R.drawable.bg_age_female);
            AppCompatTextView appCompatTextView = itemRank1Binding.ageTextView;
            Integer isShowAge = item.isShowAge();
            appCompatTextView.setText((isShowAge != null ? isShowAge.intValue() : 1) == 1 ? GroupService.INSTANCE.changeAge(item.getBirthday()) : "");
            itemRank1Binding.ageTextView.setVisibility(0);
            if (item.getMedalInfo() == null) {
                itemRank1Binding.llMedal.setVisibility(8);
            } else {
                itemRank1Binding.llMedal.setVisibility(0);
                MedalGridLayout medalGridLayout2 = itemRank1Binding.llMedal;
                List mutableList2 = CollectionsKt.toMutableList(item.getMedalInfo());
                Intrinsics.checkNotNull(mutableList2, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
                medalGridLayout2.setDataAndLayoutView((ArrayList) mutableList2, 6);
            }
            CountryIDView countryIDView = itemRank1Binding.userId;
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{item.getId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            Integer idFrameType = item.getIdFrameType();
            int intValue = idFrameType != null ? idFrameType.intValue() : 0;
            int color = androidx.core.content.a.getColor(getContext(), 2131099909);
            Boolean isPrettyCode = item.isPrettyCode();
            countryIDView.refreshText(format, intValue, color, isPrettyCode != null ? isPrettyCode.booleanValue() : false);
            if (item.getWealthUserGrade() > -1) {
                HiloGradeView.setLevelBg$default(itemRank1Binding.wealthLevel, item.getWealthUserGrade(), false, true, false, 10, (Object) null);
                itemRank1Binding.wealthLevel.setVisibility(0);
            }
            if (item.getCharmUserGrade() > -1) {
                HiloGradeView.setLevelBg$default(itemRank1Binding.charmLevel, item.getCharmUserGrade(), true, false, false, 12, (Object) null);
                itemRank1Binding.charmLevel.setVisibility(0);
            }
        }
        if (item.getName().length() > 20) {
            name = ((Object) item.getName().subSequence(0, 19)) + "...";
        } else {
            name = item.getName();
        }
        NickTextView nickTextView = itemRank1Binding.userName;
        UserService.Companion companion = UserService.INSTANCE;
        NobleInfo noble = item.getNoble();
        nickTextView.setTextColor(companion.getNobleColor((noble == null || (level4 = noble.getLevel()) == null) ? 0 : level4.intValue(), Color.parseColor("#333333")));
        NickTextView nickTextView2 = itemRank1Binding.userName;
        SvipData svip = item.getSvip();
        int svipLevel = svip != null ? svip.getSvipLevel() : 0;
        NobleInfo noble2 = item.getNoble();
        nickTextView2.setSVipAndNoble(name, svipLevel, (noble2 == null || (level3 = noble2.getLevel()) == null) ? 0 : level3.intValue());
        itemRank1Binding.diamond.setText(NumberUtilsKt.rankNumberFormat(item.getDiamond()));
        itemRank1Binding.iconVip.setVisibility(item.isVip() ? 0 : 8);
        NobleInfo noble3 = item.getNoble();
        if (((noble3 == null || (level2 = noble3.getLevel()) == null) ? 0 : level2.intValue()) > 0) {
            itemRank1Binding.iconNoble.setVisibility(0);
            itemRank1Binding.iconVip.setVisibility(8);
            ImageView imageView = itemRank1Binding.iconNoble;
            Context context = getContext();
            NobleInfo noble4 = item.getNoble();
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, companion.getNobleDrawableRes((noble4 == null || (level = noble4.getLevel()) == null) ? 0 : level.intValue())));
        } else {
            itemRank1Binding.iconNoble.setVisibility(8);
        }
        SvipData svip2 = item.getSvip();
        if ((svip2 != null ? svip2.getSvipLevel() : 0) > 0) {
            itemRank1Binding.iconNoble.setVisibility(8);
            itemRank1Binding.iconVip.setVisibility(8);
            itemRank1Binding.svip.setVisibility(0);
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            SvipData svip3 = item.getSvip();
            Integer svipMedal = svipTypeUtils.getSvipMedal(svip3 != null ? Integer.valueOf(svip3.getSvipLevel()) : null);
            if (svipMedal != null) {
                itemRank1Binding.svip.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), svipMedal.intValue()));
            }
        } else {
            itemRank1Binding.svip.setVisibility(8);
        }
        SvipData svip4 = item.getSvip();
        if (svip4 != null && svip4.isRankStealth()) {
            HiloImageView.loadImage$default(itemRank1Binding.userAvatarCimageView, Integer.valueOf(R.drawable.svip_hide_heard), 0, 0, 6, (Object) null);
            itemRank1Binding.userId.setVisibility(8);
            NickTextView nickTextView3 = itemRank1Binding.userName;
            nickTextView3.setDefault(androidx.core.content.a.getColor(nickTextView3.getContext(), 2131099872));
            itemRank1Binding.userName.setText(ResourcesKtxKt.getStringById(this, 2131954197));
            itemRank1Binding.iconNoble.setVisibility(8);
            itemRank1Binding.iconVip.setVisibility(8);
            itemRank1Binding.svip.setVisibility(8);
            itemRank1Binding.ageTextView.setVisibility(8);
            itemRank1Binding.wealthLevel.setVisibility(8);
            itemRank1Binding.charmLevel.setVisibility(8);
            itemRank1Binding.llMedal.setVisibility(8);
            return;
        }
        itemRank1Binding.userId.setVisibility(UserStore.INSTANCE.getShared().checkSvipAndWealth() ? 0 : 8);
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemRank1Binding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        CountryIDView view = holder.getView(R.id.user_id);
        view.setDefaultColor(androidx.core.content.a.getColor(view.getContext(), 2131099918));
        holder.getView(2131365557).startOrStopAnim(false);
    }

    public void onViewAttachedToWindow(@NotNull BaseDataBindingHolder<ItemRank1Binding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        holder.getView(R.id.user_id).reShowSVGA();
        holder.getView(2131365557).startOrStopAnim(true);
    }
}
