package com.qiahao.nextvideo.ui.home.group.my;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.makeramen.roundedimageview.RoundedImageView;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.oudi.utils.ktx.StringKtxKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.data.model.HotGroupBean;
import com.qiahao.nextvideo.databinding.ItemMyGroupBinding;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.io.File;
import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u00152\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0002H\u0002J \u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0016\u0010\u0013\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\u0014\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/group/my/MyGroupRelationAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/HotGroupBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemMyGroupBinding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "bean", "showAvatar", "binding", "createCircleView", "avatar", "", "sex", "onViewRecycled", "onViewAttachedToWindow", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class MyGroupRelationAdapter extends BaseQuickAdapter<HotGroupBean, BaseDataBindingHolder<ItemMyGroupBinding>> {

    @NotNull
    private static final String TAG = "GroupRelationAdapter";

    public MyGroupRelationAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    private final void createCircleView(ItemMyGroupBinding binding, String avatar, int sex) {
        AppCompatImageView circleImageView = new CircleImageView(binding.userAvatarList.getContext());
        binding.userAvatarList.addView(circleImageView);
        ViewGroup.LayoutParams layoutParams = circleImageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        Dimens dimens = Dimens.INSTANCE;
        layoutParams2.height = dimens.dpToPx(27);
        layoutParams2.width = dimens.dpToPx(27);
        layoutParams2.setMarginEnd(dimens.dpToPx(9));
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        fill.setWidth(dimens.dpToPx(27));
        fill.setHeight(dimens.dpToPx(27));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind$default(circleImageView, companion.displayUserAvatarImage(avatar, fill), null, 2, null);
    }

    private final void showAvatar(ItemMyGroupBinding binding, HotGroupBean bean) {
        binding.userAvatarList.removeAllViews();
        int size = bean.getMicUsers().size();
        for (int i = 0; i < size; i++) {
            createCircleView(binding, bean.getMicUsers().get(i).getAvatar(), bean.getMicUsers().get(i).getSex());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemMyGroupBinding> holder, @NotNull final HotGroupBean bean) {
        int i;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(bean, "bean");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemMyGroupBinding");
        final ItemMyGroupBinding itemMyGroupBinding = (ItemMyGroupBinding) dataBinding;
        if (!TextUtils.isEmpty(bean.getName())) {
            itemMyGroupBinding.groupName.setText(bean.getName());
        }
        if (!TextUtils.isEmpty(bean.getNotification())) {
            itemMyGroupBinding.groupAnnounce.setText(bean.getNotification());
        }
        ImageView imageView5 = itemMyGroupBinding.iconCount;
        Intrinsics.checkNotNullExpressionValue(imageView5, "iconCount");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        ViewUtilitiesKt.bind(imageView5, companion.countryTag(bean.getCountryIcon()));
        RoundedImageView roundedImageView = itemMyGroupBinding.roomAvatar;
        Intrinsics.checkNotNullExpressionValue(roundedImageView, "roomAvatar");
        String faceUrl = bean.getFaceUrl();
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(69));
        fill.setHeight(dimens.dpToPx(69));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind(roundedImageView, companion.displayImage(faceUrl, fill));
        itemMyGroupBinding.roomSvga.setVisibility(8);
        itemMyGroupBinding.roomSvga.setTag(null);
        itemMyGroupBinding.roomImageHead.setVisibility(8);
        itemMyGroupBinding.roomImageHead.setTag(null);
        String groupHeadwear = bean.getGroupHeadwear();
        if (groupHeadwear != null && groupHeadwear.length() > 0) {
            String groupHeadwear2 = bean.getGroupHeadwear();
            if (groupHeadwear2 != null && StringKtxKt.checkEndSVGA(groupHeadwear2)) {
                SVGAParser.Companion.shareParser().decodeFromURL(new URL(bean.getGroupHeadwear()), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.home.group.my.MyGroupRelationAdapter$convert$2
                    public void onComplete(SVGAVideoEntity videoItem) {
                        Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                        ItemMyGroupBinding.this.roomSvga.setVisibility(0);
                        ItemMyGroupBinding.this.roomSvga.setTag(bean.getGroupHeadwear());
                        ItemMyGroupBinding.this.roomSvga.stopAnimation(true);
                        ItemMyGroupBinding.this.roomSvga.setImageDrawable(new SVGADrawable(videoItem));
                        ItemMyGroupBinding.this.roomSvga.startAnimation();
                    }

                    public void onError() {
                    }
                });
            } else {
                itemMyGroupBinding.roomImageHead.setVisibility(0);
                itemMyGroupBinding.roomImageHead.setTag(bean.getGroupHeadwear());
                ImageView imageView6 = itemMyGroupBinding.roomImageHead;
                Intrinsics.checkNotNullExpressionValue(imageView6, "roomImageHead");
                String groupHeadwear3 = bean.getGroupHeadwear();
                if (groupHeadwear3 == null) {
                    groupHeadwear3 = "";
                }
                ImageKtxKt.loadImage$default(imageView6, groupHeadwear3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            }
        }
        itemMyGroupBinding.personNumber.setText(String.valueOf(bean.getGroupInUserDuration()));
        if (bean.getMicUsers().isEmpty()) {
            itemMyGroupBinding.userAvatarList.setVisibility(4);
            itemMyGroupBinding.onMicNumber.setVisibility(4);
        } else {
            itemMyGroupBinding.userAvatarList.setVisibility(0);
            showAvatar(itemMyGroupBinding, bean);
            if (bean.getRoomUserCount() > 0) {
                itemMyGroupBinding.onMicNumber.setVisibility(0);
                itemMyGroupBinding.onMicNumber.setText(String.valueOf(bean.getRoomUserCount()));
            } else {
                itemMyGroupBinding.onMicNumber.setVisibility(4);
            }
        }
        itemMyGroupBinding.rocket1.setVisibility(8);
        itemMyGroupBinding.rocket2.setVisibility(8);
        itemMyGroupBinding.rocket3.setVisibility(8);
        itemMyGroupBinding.rocket4.setVisibility(8);
        itemMyGroupBinding.rocket5.setVisibility(8);
        Integer maxStage = bean.getMaxStage();
        int intValue = maxStage != null ? maxStage.intValue() : -1;
        if (intValue <= 2 || intValue - 2 >= 4) {
            i = 0;
        }
        while (i < 5) {
            if (i == 0) {
                imageView4 = itemMyGroupBinding.rocket1;
            } else if (i == 1) {
                imageView4 = itemMyGroupBinding.rocket2;
            } else if (i == 2) {
                imageView4 = itemMyGroupBinding.rocket3;
            } else if (i != 3) {
                imageView4 = i != 4 ? null : itemMyGroupBinding.rocket5;
            } else {
                imageView4 = itemMyGroupBinding.rocket4;
            }
            if (imageView4 != null) {
                imageView4.setVisibility(i <= intValue ? 0 : 8);
            }
            i++;
        }
        itemMyGroupBinding.llRocket.setVisibility(intValue > -1 ? 0 : 8);
        String gameTypeIcon = bean.getGameTypeIcon();
        if (gameTypeIcon != null && gameTypeIcon.length() > 0) {
            ItemMyGroupBinding itemMyGroupBinding2 = (ItemMyGroupBinding) holder.getDataBinding();
            if (itemMyGroupBinding2 != null && (imageView3 = itemMyGroupBinding2.gameImage) != null) {
                imageView3.setVisibility(0);
            }
            ItemMyGroupBinding itemMyGroupBinding3 = (ItemMyGroupBinding) holder.getDataBinding();
            if (itemMyGroupBinding3 == null || (imageView2 = itemMyGroupBinding3.gameImage) == null) {
                return;
            }
            ImageKtxKt.loadImage$default(imageView2, bean.getGameTypeIcon(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            return;
        }
        ItemMyGroupBinding itemMyGroupBinding4 = (ItemMyGroupBinding) holder.getDataBinding();
        if (itemMyGroupBinding4 == null || (imageView = itemMyGroupBinding4.gameImage) == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemMyGroupBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemMyGroupBinding");
        ItemMyGroupBinding itemMyGroupBinding = (ItemMyGroupBinding) dataBinding;
        ImageView imageView = itemMyGroupBinding.roomImageHead;
        Intrinsics.checkNotNullExpressionValue(imageView, "roomImageHead");
        ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        itemMyGroupBinding.roomImageHead.setTag(null);
        itemMyGroupBinding.roomImageHead.setVisibility(8);
        itemMyGroupBinding.roomSvga.stopAnimation(true);
        itemMyGroupBinding.roomSvga.setTag(null);
        itemMyGroupBinding.roomSvga.setVisibility(8);
    }

    public void onViewAttachedToWindow(@NotNull BaseDataBindingHolder<ItemMyGroupBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super.onViewAttachedToWindow(holder);
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemMyGroupBinding");
        final ItemMyGroupBinding itemMyGroupBinding = (ItemMyGroupBinding) dataBinding;
        Object tag = itemMyGroupBinding.roomSvga.getTag();
        String str = tag instanceof String ? (String) tag : null;
        if (str != null && StringKtxKt.checkEndSVGA(str)) {
            SVGAParser.Companion.shareParser().decodeFromURL(new URL(str), new SVGAParser.ParseCompletion() { // from class: com.qiahao.nextvideo.ui.home.group.my.MyGroupRelationAdapter$onViewAttachedToWindow$1
                public void onComplete(SVGAVideoEntity videoItem) {
                    Intrinsics.checkNotNullParameter(videoItem, "videoItem");
                    ItemMyGroupBinding.this.roomSvga.setVisibility(0);
                    ItemMyGroupBinding.this.roomSvga.stopAnimation(true);
                    ItemMyGroupBinding.this.roomSvga.setImageDrawable(new SVGADrawable(videoItem));
                    ItemMyGroupBinding.this.roomSvga.startAnimation();
                }

                public void onError() {
                }
            });
        } else {
            ImageView imageView = itemMyGroupBinding.roomImageHead;
            Intrinsics.checkNotNullExpressionValue(imageView, "roomImageHead");
            ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            itemMyGroupBinding.roomImageHead.setTag(null);
            itemMyGroupBinding.roomImageHead.setVisibility(8);
        }
        Object tag2 = itemMyGroupBinding.roomImageHead.getTag();
        String str2 = tag2 instanceof String ? (String) tag2 : null;
        if (str2 != null && str2.length() > 0) {
            ImageView imageView2 = itemMyGroupBinding.roomImageHead;
            Intrinsics.checkNotNullExpressionValue(imageView2, "roomImageHead");
            ImageKtxKt.loadImage$default(imageView2, str2, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
            itemMyGroupBinding.roomImageHead.setVisibility(0);
            return;
        }
        itemMyGroupBinding.roomImageHead.setVisibility(8);
    }
}
