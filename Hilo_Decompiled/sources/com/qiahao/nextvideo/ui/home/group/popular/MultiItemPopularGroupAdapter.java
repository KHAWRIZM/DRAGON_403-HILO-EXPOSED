package com.qiahao.nextvideo.ui.home.group.popular;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAImageView;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.StringKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.databinding.IncludeFamilyNamePlateBinding;
import com.qiahao.base_common.model.common.FamilyInfo;
import com.qiahao.base_common.utils.AppUtilitiesKt;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.CornerMarkType;
import com.qiahao.nextvideo.data.model.GroupMedalDetailBean;
import com.qiahao.nextvideo.data.model.MultiHotGroupBean;
import com.qiahao.nextvideo.databinding.ItemGroupPopular1Binding;
import com.qiahao.nextvideo.databinding.ItemGroupPopular2Binding;
import com.qiahao.nextvideo.databinding.ItemGroupPopular3Binding;
import com.qiahao.nextvideo.databinding.ItemGroupPopular4Binding;
import com.qiahao.nextvideo.ui.rank.GroupMedalAndPowerLayout;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u000e2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0016\u0010\u000b\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\f\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\r\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/group/popular/MultiItemPopularGroupAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/MultiHotGroupBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGroupPopular1Binding;", "<init>", "()V", "convert", "", "holder", "bean", "onViewAttachedToWindow", "onViewRecycled", "onViewDetachedFromWindow", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MultiItemPopularGroupAdapter extends BaseMultiItemQuickAdapter<MultiHotGroupBean, BaseDataBindingHolder<ItemGroupPopular1Binding>> {

    @NotNull
    private static final String TAG = "MultiItemPopularGroupAd";

    public MultiItemPopularGroupAdapter() {
        super((List) null, 1, (DefaultConstructorMarker) null);
        addItemType(1, R.layout.item_group_popular1);
        addItemType(2, R.layout.item_group_popular2);
        addItemType(3, R.layout.item_group_popular3);
        addItemType(4, R.layout.item_group_popular4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGroupPopular1Binding> holder, @NotNull final MultiHotGroupBean bean) {
        int i;
        ImageView imageView;
        String nameplate;
        Integer grade;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(bean, "bean");
        int itemViewType = holder.getItemViewType();
        if (itemViewType != 1) {
            if (itemViewType == 2) {
                ViewDataBinding dataBinding = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupPopular2Binding");
                ItemGroupPopular2Binding itemGroupPopular2Binding = (ItemGroupPopular2Binding) dataBinding;
                itemGroupPopular2Binding.matchNumber.setText(String.valueOf(bean.getMatchNumber()));
                itemGroupPopular2Binding.heartSvga.startAnimation();
                return;
            }
            if (itemViewType == 3) {
                ViewDataBinding dataBinding2 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding2, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupPopular3Binding");
                ItemGroupPopular3Binding itemGroupPopular3Binding = (ItemGroupPopular3Binding) dataBinding2;
                TextView textView = itemGroupPopular3Binding.ludoSubTitle;
                IntRange intRange = new IntRange(70000, 80000);
                Random.Default r4 = Random.Default;
                textView.setText(String.valueOf(RangesKt.random(intRange, r4)));
                itemGroupPopular3Binding.unoSubTitle.setText(String.valueOf(RangesKt.random(new IntRange(70000, 80000), r4)));
                itemGroupPopular3Binding.ludoSvga.startAnimation();
                itemGroupPopular3Binding.unoSvga.startAnimation();
                return;
            }
            if (itemViewType != 4) {
                return;
            }
            ViewDataBinding dataBinding3 = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding3, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupPopular4Binding");
            ItemGroupPopular4Binding itemGroupPopular4Binding = (ItemGroupPopular4Binding) dataBinding3;
            TextView textView2 = itemGroupPopular4Binding.sheepSubTitle;
            IntRange intRange2 = new IntRange(70000, 80000);
            Random.Default r42 = Random.Default;
            textView2.setText(String.valueOf(RangesKt.random(intRange2, r42)));
            itemGroupPopular4Binding.matchSubTitle.setText(String.valueOf(RangesKt.random(new IntRange(70000, 80000), r42)));
            itemGroupPopular4Binding.sheepSvga.startAnimation();
            itemGroupPopular4Binding.matchSvga.startAnimation();
            return;
        }
        ViewDataBinding dataBinding4 = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding4, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupPopular1Binding");
        final ItemGroupPopular1Binding itemGroupPopular1Binding = (ItemGroupPopular1Binding) dataBinding4;
        itemGroupPopular1Binding.constraint.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#ffffff", "#ffffff", 10, (GradientDrawable.Orientation) null, 8, (Object) null));
        if (!TextUtils.isEmpty(bean.getName())) {
            itemGroupPopular1Binding.groupName.setText(bean.getName());
        } else {
            itemGroupPopular1Binding.groupName.setText("");
        }
        if (!TextUtils.isEmpty(bean.getNotification())) {
            itemGroupPopular1Binding.groupAnnounce.setText(bean.getNotification());
        } else {
            itemGroupPopular1Binding.groupAnnounce.setText("");
        }
        ImageView imageView2 = itemGroupPopular1Binding.iconCount;
        Intrinsics.checkNotNullExpressionValue(imageView2, "iconCount");
        ImageKtxKt.loadImage$default(imageView2, ImageSizeKt.imageSize(bean.getCountryIcon(), UiKtxKt.toPX(30)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232548, (c5.g) null, 49150, (Object) null);
        RoundedImageView roundedImageView = itemGroupPopular1Binding.roomAvatar;
        Intrinsics.checkNotNullExpressionValue(roundedImageView, "roomAvatar");
        ImageKtxKt.loadImage$default(roundedImageView, ImageSizeKt.image200(bean.getFaceUrl()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231930, (c5.g) null, 49150, (Object) null);
        itemGroupPopular1Binding.roomSvga.setVisibility(8);
        itemGroupPopular1Binding.roomSvga.setTag(null);
        itemGroupPopular1Binding.roomImageHead.setVisibility(8);
        itemGroupPopular1Binding.roomImageHead.setTag(null);
        String groupHeadwear = bean.getGroupHeadwear();
        if (groupHeadwear != null && groupHeadwear.length() > 0) {
            String groupHeadwear2 = bean.getGroupHeadwear();
            if (groupHeadwear2 != null && StringKtxKt.checkEndSVGA(groupHeadwear2)) {
                SVGAParser.Companion.shareParser().decodeFromURL(new URL(bean.getGroupHeadwear()), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.home.group.popular.MultiItemPopularGroupAdapter$convert$1
                    public void onComplete(SVGAVideoEntity videoItem) {
                        Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                        ItemGroupPopular1Binding.this.roomSvga.setVisibility(0);
                        ItemGroupPopular1Binding.this.roomSvga.setTag(bean.getGroupHeadwear());
                        ItemGroupPopular1Binding.this.roomSvga.stopAnimation(true);
                        ItemGroupPopular1Binding.this.roomSvga.setImageDrawable(new SVGADrawable(videoItem));
                        ItemGroupPopular1Binding.this.roomSvga.startAnimation();
                    }

                    public void onError() {
                    }
                });
            } else {
                itemGroupPopular1Binding.roomImageHead.setVisibility(0);
                itemGroupPopular1Binding.roomImageHead.setTag(bean.getGroupHeadwear());
                SVGAImageView sVGAImageView = itemGroupPopular1Binding.roomImageHead;
                Intrinsics.checkNotNullExpressionValue(sVGAImageView, "roomImageHead");
                String groupHeadwear3 = bean.getGroupHeadwear();
                ImageKtxKt.loadImage$default(sVGAImageView, groupHeadwear3 == null ? "" : groupHeadwear3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
        }
        itemGroupPopular1Binding.personNumber.setText(String.valueOf(bean.getGroupInUserDuration()));
        IncludeFamilyNamePlateBinding includeFamilyNamePlateBinding = itemGroupPopular1Binding.familyNamePlate;
        Intrinsics.checkNotNullExpressionValue(includeFamilyNamePlateBinding, "familyNamePlate");
        FamilyInfo groupPower = bean.getGroupPower();
        int intValue = (groupPower == null || (grade = groupPower.getGrade()) == null) ? -1 : grade.intValue();
        FamilyInfo groupPower2 = bean.getGroupPower();
        AppUtilitiesKt.familyNamePlate$default(includeFamilyNamePlateBinding, intValue, (groupPower2 == null || (nameplate = groupPower2.getNameplate()) == null) ? "" : nameplate, 0, 4, (Object) null);
        GroupMedalAndPowerLayout groupMedalAndPowerLayout = itemGroupPopular1Binding.groupMedalAndPower;
        List<GroupMedalDetailBean> groupMedals = bean.getGroupMedals();
        groupMedalAndPowerLayout.setDataAndLayoutView("", (ArrayList) (groupMedals != null ? CollectionsKt.toMutableList(groupMedals) : null), 4);
        itemGroupPopular1Binding.rocket1.setVisibility(8);
        itemGroupPopular1Binding.rocket2.setVisibility(8);
        itemGroupPopular1Binding.rocket3.setVisibility(8);
        itemGroupPopular1Binding.rocket4.setVisibility(8);
        itemGroupPopular1Binding.rocket5.setVisibility(8);
        Integer maxStage = bean.getMaxStage();
        int intValue2 = maxStage != null ? maxStage.intValue() : -1;
        if (intValue2 <= 2 || intValue2 - 2 >= 4) {
            i = 0;
        }
        int cornerMark = bean.getCornerMark();
        if (cornerMark == CornerMarkType.HOT.getType()) {
            itemGroupPopular1Binding.hotIcon.setVisibility(0);
            itemGroupPopular1Binding.hotIcon.setImageResource(R.drawable.home_popular_hot_icon);
        } else if (cornerMark == CornerMarkType.NEW.getType()) {
            itemGroupPopular1Binding.hotIcon.setVisibility(0);
            itemGroupPopular1Binding.hotIcon.setImageResource(R.drawable.home_popular_new_icon);
        } else {
            itemGroupPopular1Binding.hotIcon.setVisibility(8);
        }
        while (i < 5) {
            if (i == 0) {
                imageView = itemGroupPopular1Binding.rocket1;
            } else if (i == 1) {
                imageView = itemGroupPopular1Binding.rocket2;
            } else if (i == 2) {
                imageView = itemGroupPopular1Binding.rocket3;
            } else if (i != 3) {
                imageView = i != 4 ? null : itemGroupPopular1Binding.rocket5;
            } else {
                imageView = itemGroupPopular1Binding.rocket4;
            }
            if (imageView != null) {
                imageView.setVisibility(i <= intValue2 ? 0 : 8);
            }
            i++;
        }
        itemGroupPopular1Binding.llRocket.setVisibility(intValue2 > -1 ? 0 : 8);
        String gameTypeIcon = bean.getGameTypeIcon();
        if (gameTypeIcon != null && gameTypeIcon.length() > 0) {
            itemGroupPopular1Binding.gameImage.setVisibility(0);
            ImageView imageView3 = itemGroupPopular1Binding.gameImage;
            Intrinsics.checkNotNullExpressionValue(imageView3, "gameImage");
            ImageKtxKt.loadImage$default(imageView3, bean.getGameTypeIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            return;
        }
        itemGroupPopular1Binding.gameImage.setVisibility(8);
    }

    public void onViewDetachedFromWindow(@NotNull BaseDataBindingHolder<ItemGroupPopular1Binding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewDetachedFromWindow(holder);
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 2) {
            try {
                ViewDataBinding dataBinding = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupPopular2Binding");
                ((ItemGroupPopular2Binding) dataBinding).heartSvga.stopAnimation(true);
                return;
            } catch (Exception unused) {
                Log.d(TAG, "onViewAttachedToWindow: 防止报错 虽然应该没有什么报错的机会");
                return;
            }
        }
        if (itemViewType == 3) {
            try {
                ViewDataBinding dataBinding2 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding2, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupPopular3Binding");
                ItemGroupPopular3Binding itemGroupPopular3Binding = (ItemGroupPopular3Binding) dataBinding2;
                itemGroupPopular3Binding.ludoSvga.stopAnimation(true);
                itemGroupPopular3Binding.unoSvga.stopAnimation(true);
                return;
            } catch (Exception unused2) {
                Log.d(TAG, "onViewAttachedToWindow: 防止报错 虽然应该没有什么报错的机会");
                return;
            }
        }
        if (itemViewType != 4) {
            return;
        }
        try {
            ViewDataBinding dataBinding3 = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding3, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupPopular4Binding");
            ItemGroupPopular4Binding itemGroupPopular4Binding = (ItemGroupPopular4Binding) dataBinding3;
            itemGroupPopular4Binding.sheepSvga.stopAnimation(true);
            itemGroupPopular4Binding.matchSvga.stopAnimation(true);
        } catch (Exception unused3) {
            Log.d(TAG, "onViewAttachedToWindow: 防止报错 虽然应该没有什么报错的机会");
        }
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemGroupPopular1Binding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        if (holder.getItemViewType() == 1) {
            ViewDataBinding dataBinding = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupPopular1Binding");
            ItemGroupPopular1Binding itemGroupPopular1Binding = (ItemGroupPopular1Binding) dataBinding;
            SVGAImageView sVGAImageView = itemGroupPopular1Binding.roomImageHead;
            Intrinsics.checkNotNullExpressionValue(sVGAImageView, "roomImageHead");
            ImageKtxKt.loadImage$default(sVGAImageView, (String) null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            itemGroupPopular1Binding.roomImageHead.setTag(null);
            itemGroupPopular1Binding.roomImageHead.setVisibility(8);
            itemGroupPopular1Binding.roomSvga.stopAnimation(true);
            itemGroupPopular1Binding.roomSvga.setTag(null);
            itemGroupPopular1Binding.roomSvga.setVisibility(8);
        }
    }

    public void onViewAttachedToWindow(@NotNull BaseDataBindingHolder<ItemGroupPopular1Binding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*com.chad.library.adapter.base.BaseQuickAdapter*/.onViewAttachedToWindow(holder);
        int itemViewType = holder.getItemViewType();
        if (itemViewType != 1) {
            if (itemViewType == 2) {
                try {
                    ViewDataBinding dataBinding = holder.getDataBinding();
                    Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupPopular2Binding");
                    ((ItemGroupPopular2Binding) dataBinding).heartSvga.startAnimation();
                    return;
                } catch (Exception unused) {
                    Log.d(TAG, "onViewAttachedToWindow: 防止报错 虽然应该没有什么报错的机会");
                    return;
                }
            }
            if (itemViewType == 3) {
                try {
                    ViewDataBinding dataBinding2 = holder.getDataBinding();
                    Intrinsics.checkNotNull(dataBinding2, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupPopular3Binding");
                    ItemGroupPopular3Binding itemGroupPopular3Binding = (ItemGroupPopular3Binding) dataBinding2;
                    itemGroupPopular3Binding.ludoSvga.startAnimation();
                    itemGroupPopular3Binding.unoSvga.startAnimation();
                    return;
                } catch (Exception unused2) {
                    Log.d(TAG, "onViewAttachedToWindow: 防止报错 虽然应该没有什么报错的机会");
                    return;
                }
            }
            if (itemViewType != 4) {
                return;
            }
            try {
                ViewDataBinding dataBinding3 = holder.getDataBinding();
                Intrinsics.checkNotNull(dataBinding3, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupPopular4Binding");
                ItemGroupPopular4Binding itemGroupPopular4Binding = (ItemGroupPopular4Binding) dataBinding3;
                itemGroupPopular4Binding.sheepSvga.startAnimation();
                itemGroupPopular4Binding.matchSvga.startAnimation();
                return;
            } catch (Exception unused3) {
                Log.d(TAG, "onViewAttachedToWindow: 防止报错 虽然应该没有什么报错的机会");
                return;
            }
        }
        try {
            ViewDataBinding dataBinding4 = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding4, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupPopular1Binding");
            final ItemGroupPopular1Binding itemGroupPopular1Binding = (ItemGroupPopular1Binding) dataBinding4;
            Object tag = itemGroupPopular1Binding.roomSvga.getTag();
            String str = tag instanceof String ? (String) tag : null;
            if (str != null && StringKtxKt.checkEndSVGA(str)) {
                SVGAParser.Companion.shareParser().decodeFromURL(new URL(str), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.home.group.popular.MultiItemPopularGroupAdapter$onViewAttachedToWindow$1
                    public void onComplete(SVGAVideoEntity videoItem) {
                        Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                        ItemGroupPopular1Binding.this.roomSvga.setVisibility(0);
                        ItemGroupPopular1Binding.this.roomSvga.stopAnimation(true);
                        ItemGroupPopular1Binding.this.roomSvga.setImageDrawable(new SVGADrawable(videoItem));
                        ItemGroupPopular1Binding.this.roomSvga.startAnimation();
                    }

                    public void onError() {
                    }
                });
            } else {
                SVGAImageView sVGAImageView = itemGroupPopular1Binding.roomImageHead;
                Intrinsics.checkNotNullExpressionValue(sVGAImageView, "roomImageHead");
                ImageKtxKt.loadImage$default(sVGAImageView, (String) null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                itemGroupPopular1Binding.roomImageHead.setTag(null);
                itemGroupPopular1Binding.roomImageHead.setVisibility(8);
            }
            Object tag2 = itemGroupPopular1Binding.roomImageHead.getTag();
            String str2 = tag2 instanceof String ? (String) tag2 : null;
            if (str2 != null && str2.length() > 0) {
                SVGAImageView sVGAImageView2 = itemGroupPopular1Binding.roomImageHead;
                Intrinsics.checkNotNullExpressionValue(sVGAImageView2, "roomImageHead");
                ImageKtxKt.loadImage$default(sVGAImageView2, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
                itemGroupPopular1Binding.roomImageHead.setVisibility(0);
                return;
            }
            itemGroupPopular1Binding.roomImageHead.setVisibility(8);
        } catch (Exception unused4) {
            Log.d(TAG, "onViewAttachedToWindow: 防止报错 虽然应该没有什么报错的机会");
        }
    }
}
