package com.qiahao.nextvideo.room.rank;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemGroupNormalRankBinding;
import com.qiahao.nextvideo.databinding.ItemGroupTopRankBinding;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u0015B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0015J\u0016\u0010\u0013\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\u0014\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/room/rank/GroupCommonRankAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/qiahao/nextvideo/room/rank/GroupCommonRankEntity;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGroupNormalRankBinding;", "data", "", "<init>", "(Ljava/util/List;)V", "mDateType", "", "getMDateType", "()Ljava/lang/String;", "setMDateType", "(Ljava/lang/String;)V", "convert", "", "holder", "item", "onViewAttachedToWindow", "onViewRecycled", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupCommonRankAdapter extends BaseMultiItemQuickAdapter<GroupCommonRankEntity, BaseDataBindingHolder<ItemGroupNormalRankBinding>> {
    public static final int POSITION_OHTER = 2;
    public static final int POSITION_ONE = 1;

    @NotNull
    private String mDateType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupCommonRankAdapter(@NotNull List<GroupCommonRankEntity> list) {
        super(list);
        Intrinsics.checkNotNullParameter(list, "data");
        this.mDateType = "day";
        addItemType(1, R.layout.item_group_top_rank);
        addItemType(2, R.layout.item_group_normal_rank);
    }

    @NotNull
    public final String getMDateType() {
        return this.mDateType;
    }

    public final void setMDateType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.mDateType = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemGroupNormalRankBinding> holder, @NotNull GroupCommonRankEntity item) {
        String name;
        Integer level;
        Integer level2;
        Integer level3;
        Integer level4;
        String name2;
        Integer level5;
        Integer level6;
        Integer level7;
        Integer level8;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        int i = 0;
        if (holder.getItemViewType() == 1) {
            ViewDataBinding dataBinding = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupTopRankBinding");
            ItemGroupTopRankBinding itemGroupTopRankBinding = (ItemGroupTopRankBinding) dataBinding;
            itemGroupTopRankBinding.top1Diamond.setVisibility(Intrinsics.areEqual(this.mDateType, "day") ? 0 : 8);
            itemGroupTopRankBinding.top1DiamondIcon.setVisibility(Intrinsics.areEqual(this.mDateType, "day") ? 0 : 8);
            if (item.getName().length() > 20) {
                name2 = ((Object) item.getName().subSequence(0, 19)) + "...";
            } else {
                name2 = item.getName();
            }
            NickTextView nickTextView = itemGroupTopRankBinding.top1Name;
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble = item.getNoble();
            nickTextView.setTextColor(companion.getNobleColor((noble == null || (level8 = noble.getLevel()) == null) ? 0 : level8.intValue(), Color.parseColor("#333333")));
            NickTextView nickTextView2 = itemGroupTopRankBinding.top1Name;
            SvipData svip = item.getSvip();
            int svipLevel = svip != null ? svip.getSvipLevel() : 0;
            NobleInfo noble2 = item.getNoble();
            nickTextView2.setSVipAndNoble(name2, svipLevel, (noble2 == null || (level7 = noble2.getLevel()) == null) ? 0 : level7.intValue());
            HiloImageView hiloImageView = itemGroupTopRankBinding.top1Avatar;
            String faceUrl = item.getFaceUrl();
            HiloImageView.loadImage$default(hiloImageView, faceUrl == null ? "" : faceUrl, 0, 0, 6, (Object) null);
            GenderAgeTextView genderAgeTextView = itemGroupTopRankBinding.ageTextView;
            Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
            Resources resources = getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, item.getSex() == 1 ? R.drawable.icon_boy : R.drawable.icon_girl, 0));
            itemGroupTopRankBinding.ageTextView.setBackgroundResource(item.getSex() == 1 ? R.drawable.bg_age_male : R.drawable.bg_age_female);
            AppCompatTextView appCompatTextView = itemGroupTopRankBinding.ageTextView;
            Integer isShowAge = item.getIsShowAge();
            appCompatTextView.setText((isShowAge != null ? isShowAge.intValue() : 1) == 1 ? GroupService.INSTANCE.changeAge(item.getBirthday()) : "");
            itemGroupTopRankBinding.ageTextView.setVisibility(0);
            ShineTextView shineTextView = itemGroupTopRankBinding.top1Id;
            String format = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{item.getId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            shineTextView.setNobleLevel(format);
            itemGroupTopRankBinding.top1Diamond.setText(NumberUtilsKt.rankNumberFormat(item.getDiamond()));
            itemGroupTopRankBinding.iconVip1.setVisibility(item.getIsVip() ? 0 : 8);
            ImageView imageView = itemGroupTopRankBinding.iconVip1;
            Intrinsics.checkNotNullExpressionValue(imageView, "iconVip1");
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, 2131233624, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            NobleInfo noble3 = item.getNoble();
            if (((noble3 == null || (level6 = noble3.getLevel()) == null) ? 0 : level6.intValue()) > 0) {
                itemGroupTopRankBinding.iconVip1.setVisibility(8);
                itemGroupTopRankBinding.iconNoble.setVisibility(0);
                ImageView imageView2 = itemGroupTopRankBinding.iconNoble;
                Context context = getContext();
                NobleInfo noble4 = item.getNoble();
                if (noble4 != null && (level5 = noble4.getLevel()) != null) {
                    i = level5.intValue();
                }
                imageView2.setImageDrawable(androidx.core.content.a.getDrawable(context, companion.getNobleDrawableRes(i)));
                return;
            }
            itemGroupTopRankBinding.iconNoble.setVisibility(8);
            return;
        }
        if (holder.getItemViewType() == 2) {
            ViewDataBinding dataBinding2 = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding2, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupNormalRankBinding");
            ItemGroupNormalRankBinding itemGroupNormalRankBinding = (ItemGroupNormalRankBinding) dataBinding2;
            itemGroupNormalRankBinding.llDiamond.setVisibility(Intrinsics.areEqual(this.mDateType, "day") ? 0 : 8);
            itemGroupNormalRankBinding.listPosition.setText(String.valueOf(holder.getAdapterPosition() + 1));
            HiloImageView hiloImageView2 = itemGroupNormalRankBinding.userAvatarCimageView;
            String faceUrl2 = item.getFaceUrl();
            HiloImageView.loadImage$default(hiloImageView2, faceUrl2 == null ? "" : faceUrl2, 0, 0, 6, (Object) null);
            GenderAgeTextView genderAgeTextView2 = itemGroupNormalRankBinding.ageTextView;
            Intrinsics.checkNotNullExpressionValue(genderAgeTextView2, "ageTextView");
            Resources resources2 = getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
            ViewUtilitiesKt.setDrawableLeft(genderAgeTextView2, ResourceUtilsKt.getDrawable(resources2, item.getSex() == 1 ? R.drawable.icon_boy : R.drawable.icon_girl, 0));
            itemGroupNormalRankBinding.ageTextView.setBackgroundResource(item.getSex() == 1 ? R.drawable.bg_age_male : R.drawable.bg_age_female);
            AppCompatTextView appCompatTextView2 = itemGroupNormalRankBinding.ageTextView;
            Integer isShowAge2 = item.getIsShowAge();
            appCompatTextView2.setText((isShowAge2 != null ? isShowAge2.intValue() : 1) == 1 ? GroupService.INSTANCE.changeAge(item.getBirthday()) : "");
            itemGroupNormalRankBinding.ageTextView.setVisibility(0);
            ShineTextView shineTextView2 = itemGroupNormalRankBinding.userId;
            String format2 = String.format(ResourcesKtxKt.getStringById(this, 2131953102), Arrays.copyOf(new Object[]{item.getId()}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            shineTextView2.setNobleLevel(format2);
            if (item.getName().length() > 20) {
                name = ((Object) item.getName().subSequence(0, 19)) + "...";
            } else {
                name = item.getName();
            }
            NickTextView nickTextView3 = itemGroupNormalRankBinding.userName;
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble5 = item.getNoble();
            nickTextView3.setTextColor(companion2.getNobleColor((noble5 == null || (level4 = noble5.getLevel()) == null) ? 0 : level4.intValue(), Color.parseColor("#333333")));
            NickTextView nickTextView4 = itemGroupNormalRankBinding.userName;
            SvipData svip2 = item.getSvip();
            int svipLevel2 = svip2 != null ? svip2.getSvipLevel() : 0;
            NobleInfo noble6 = item.getNoble();
            nickTextView4.setSVipAndNoble(name, svipLevel2, (noble6 == null || (level3 = noble6.getLevel()) == null) ? 0 : level3.intValue());
            itemGroupNormalRankBinding.diamond.setText(NumberUtilsKt.rankNumberFormat(item.getDiamond()));
            itemGroupNormalRankBinding.iconVip.setVisibility(item.getIsVip() ? 0 : 8);
            NobleInfo noble7 = item.getNoble();
            if (((noble7 == null || (level2 = noble7.getLevel()) == null) ? 0 : level2.intValue()) > 0) {
                itemGroupNormalRankBinding.iconVip.setVisibility(8);
                itemGroupNormalRankBinding.iconNoble.setVisibility(0);
                ImageView imageView3 = itemGroupNormalRankBinding.iconNoble;
                Context context2 = getContext();
                NobleInfo noble8 = item.getNoble();
                if (noble8 != null && (level = noble8.getLevel()) != null) {
                    i = level.intValue();
                }
                imageView3.setImageDrawable(androidx.core.content.a.getDrawable(context2, companion2.getNobleDrawableRes(i)));
                return;
            }
            itemGroupNormalRankBinding.iconNoble.setVisibility(8);
        }
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemGroupNormalRankBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 1) {
            ViewDataBinding dataBinding = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupTopRankBinding");
            ItemGroupTopRankBinding itemGroupTopRankBinding = (ItemGroupTopRankBinding) dataBinding;
            itemGroupTopRankBinding.top1Name.startOrStopAnim(false);
            itemGroupTopRankBinding.top1Id.stopAnimation();
            return;
        }
        if (itemViewType != 2) {
            return;
        }
        ViewDataBinding dataBinding2 = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding2, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupNormalRankBinding");
        ItemGroupNormalRankBinding itemGroupNormalRankBinding = (ItemGroupNormalRankBinding) dataBinding2;
        itemGroupNormalRankBinding.userName.startOrStopAnim(false);
        itemGroupNormalRankBinding.userId.stopAnimation();
    }

    public void onViewAttachedToWindow(@NotNull BaseDataBindingHolder<ItemGroupNormalRankBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*com.chad.library.adapter.base.BaseQuickAdapter*/.onViewAttachedToWindow(holder);
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 1) {
            ViewDataBinding dataBinding = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupTopRankBinding");
            ((ItemGroupTopRankBinding) dataBinding).top1Name.startOrStopAnim(true);
        } else {
            if (itemViewType != 2) {
                return;
            }
            ViewDataBinding dataBinding2 = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding2, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupNormalRankBinding");
            ((ItemGroupNormalRankBinding) dataBinding2).userName.startOrStopAnim(true);
        }
    }
}
