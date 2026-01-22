package com.qiahao.nextvideo.ui.family;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.family.FamilyCenterMember;
import com.qiahao.nextvideo.databinding.ItemFamilySearchMemberBinding;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014J,\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0014J\u0016\u0010\u000e\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¨\u0006\u000f"}, d2 = {"Lcom/qiahao/nextvideo/ui/family/FamilySearchMemberAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/family/FamilyCenterMember;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemFamilySearchMemberBinding;", "<init>", "()V", "convert", "", "holder", "item", "payloads", "", "", "onViewRecycled", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FamilySearchMemberAdapter extends BaseQuickAdapter<FamilyCenterMember, BaseDataBindingHolder<ItemFamilySearchMemberBinding>> {
    public FamilySearchMemberAdapter() {
        super(R.layout.item_family_search_member, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BaseDataBindingHolder<ItemFamilySearchMemberBinding>) baseViewHolder, (FamilyCenterMember) obj, (List<? extends Object>) list);
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemFamilySearchMemberBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        holder.getView(R.id.user_id).stopAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemFamilySearchMemberBinding> holder, @NotNull FamilyCenterMember item) {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ShineTextView shineTextView;
        ShineTextView shineTextView2;
        ShineTextView shineTextView3;
        ShineTextView shineTextView4;
        HiloGradeView hiloGradeView;
        HiloGradeView hiloGradeView2;
        HiloGradeView hiloGradeView3;
        AppCompatTextView appCompatTextView;
        CharSequence charSequence;
        Integer isShowAge;
        GenderAgeTextView genderAgeTextView;
        GenderAgeTextView genderAgeTextView2;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        ImageView imageView2;
        SvipData svip;
        ImageView imageView3;
        SvipData svip2;
        TextView textView8;
        QMUIRadiusImageView qMUIRadiusImageView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding != null && (qMUIRadiusImageView = itemFamilySearchMemberBinding.userAvatarCimageView) != null) {
            User user = item.getUser();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(user != null ? user.getAvatar() : null), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding2 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding2 != null && (textView8 = itemFamilySearchMemberBinding2.userName) != null) {
            User user2 = item.getUser();
            textView8.setText(user2 != null ? user2.getNick() : null);
        }
        User user3 = item.getUser();
        if (((user3 == null || (svip2 = user3.getSvip()) == null) ? 0 : svip2.getSvipLevel()) > 0) {
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding3 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding3 != null && (imageView3 = itemFamilySearchMemberBinding3.svipType) != null) {
                imageView3.setVisibility(0);
            }
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            User user4 = item.getUser();
            Integer svipType = svipTypeUtils.getSvipType((user4 == null || (svip = user4.getSvip()) == null) ? null : Integer.valueOf(svip.getSvipLevel()));
            if (svipType != null) {
                int intValue = svipType.intValue();
                ItemFamilySearchMemberBinding itemFamilySearchMemberBinding4 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
                if (itemFamilySearchMemberBinding4 != null && (imageView2 = itemFamilySearchMemberBinding4.svipType) != null) {
                    imageView2.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), intValue));
                }
            }
        } else {
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding5 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding5 != null && (imageView = itemFamilySearchMemberBinding5.svipType) != null) {
                imageView.setVisibility(8);
            }
        }
        Integer role = item.getRole();
        if (role != null && role.intValue() == 2) {
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding6 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding6 != null && (textView7 = itemFamilySearchMemberBinding6.memberType) != null) {
                textView7.setVisibility(0);
            }
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding7 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding7 != null && (textView6 = itemFamilySearchMemberBinding7.memberType) != null) {
                textView6.setText(ResourcesKtxKt.getStringById(this, 2131953001));
            }
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding8 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding8 != null && (textView5 = itemFamilySearchMemberBinding8.memberType) != null) {
                textView5.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, getContext(), 2131100006, 2131100002, 7, GradientDrawable.Orientation.TOP_BOTTOM, false, 32, (Object) null));
            }
        } else if (role != null && role.intValue() == 3) {
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding9 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding9 != null && (textView4 = itemFamilySearchMemberBinding9.memberType) != null) {
                textView4.setVisibility(0);
            }
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding10 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding10 != null && (textView3 = itemFamilySearchMemberBinding10.memberType) != null) {
                textView3.setText(ResourcesKtxKt.getStringById(this, 2131952947));
            }
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding11 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding11 != null && (textView2 = itemFamilySearchMemberBinding11.memberType) != null) {
                textView2.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, getContext(), 2131099880, 2131099876, 7, GradientDrawable.Orientation.TOP_BOTTOM, false, 32, (Object) null));
            }
        } else {
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding12 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding12 != null && (textView = itemFamilySearchMemberBinding12.memberType) != null) {
                textView.setVisibility(8);
            }
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding13 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding13 != null && (genderAgeTextView2 = itemFamilySearchMemberBinding13.ageTextView) != null) {
            Resources resources = getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            User user5 = item.getUser();
            ViewUtilitiesKt.setDrawableLeft(genderAgeTextView2, ResourceUtilsKt.getDrawable(resources, user5 != null && user5.getSex() == 1 ? R.drawable.icon_boy : R.drawable.icon_girl, 0));
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding14 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding14 != null && (genderAgeTextView = itemFamilySearchMemberBinding14.ageTextView) != null) {
            User user6 = item.getUser();
            genderAgeTextView.setBackgroundResource(user6 != null && user6.getSex() == 1 ? R.drawable.bg_age_male : R.drawable.bg_age_female);
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding15 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding15 != null && (appCompatTextView = itemFamilySearchMemberBinding15.ageTextView) != null) {
            User user7 = item.getUser();
            if (((user7 == null || (isShowAge = user7.isShowAge()) == null) ? 1 : isShowAge.intValue()) == 1) {
                User user8 = item.getUser();
                charSequence = user8 != null ? user8.getAge() : null;
            } else {
                charSequence = "";
            }
            appCompatTextView.setText(charSequence);
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding16 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding16 != null && (hiloGradeView3 = itemFamilySearchMemberBinding16.wealthLevel) != null) {
            User user9 = item.getUser();
            HiloGradeView.setLevelBg$default(hiloGradeView3, user9 != null ? user9.getWealthUserGrade() : 0L, false, true, false, 10, (Object) null);
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding17 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding17 != null && (hiloGradeView2 = itemFamilySearchMemberBinding17.charmLevel) != null) {
            User user10 = item.getUser();
            HiloGradeView.setLevelBg$default(hiloGradeView2, user10 != null ? user10.getCharmUserGrade() : 0L, true, false, false, 12, (Object) null);
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding18 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding18 != null && (hiloGradeView = itemFamilySearchMemberBinding18.activityLevel) != null) {
            User user11 = item.getUser();
            HiloGradeView.setLevelBg$default(hiloGradeView, user11 != null ? user11.getActivityUserGrade() : 0L, false, false, true, 6, (Object) null);
        }
        User user12 = item.getUser();
        if (user12 != null ? Intrinsics.areEqual(user12.isPrettyCode(), Boolean.TRUE) : false) {
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding19 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding19 != null && (shineTextView4 = itemFamilySearchMemberBinding19.userId) != null) {
                Resources resources2 = getContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
                ViewUtilitiesKt.setDrawableLeft(shineTextView4, ResourceUtilsKt.getDrawable(resources2, 2131232463, Dimens.INSTANCE.dpToPx(4)));
            }
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding20 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding20 != null && (shineTextView3 = itemFamilySearchMemberBinding20.userId) != null) {
                shineTextView3.setCompoundDrawablePadding(Dimens.INSTANCE.dpToPx(4));
            }
        } else {
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding21 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding21 != null && (shineTextView = itemFamilySearchMemberBinding21.userId) != null) {
                ViewUtilitiesKt.setDrawableLeft(shineTextView, null);
            }
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding22 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding22 == null || (shineTextView2 = itemFamilySearchMemberBinding22.userId) == null) {
            return;
        }
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        User user13 = item.getUser();
        String format = String.format(stringById, Arrays.copyOf(new Object[]{user13 != null ? user13.getCode() : null}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        shineTextView2.setText(format);
    }

    protected void convert(@NotNull BaseDataBindingHolder<ItemFamilySearchMemberBinding> holder, @NotNull FamilyCenterMember item, @NotNull List<? extends Object> payloads) {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ShineTextView shineTextView;
        ShineTextView shineTextView2;
        ShineTextView shineTextView3;
        ShineTextView shineTextView4;
        HiloGradeView hiloGradeView;
        HiloGradeView hiloGradeView2;
        HiloGradeView hiloGradeView3;
        AppCompatTextView appCompatTextView;
        CharSequence charSequence;
        Integer isShowAge;
        GenderAgeTextView genderAgeTextView;
        GenderAgeTextView genderAgeTextView2;
        TextView textView5;
        TextView textView6;
        TextView textView7;
        ImageView imageView2;
        SvipData svip;
        ImageView imageView3;
        SvipData svip2;
        TextView textView8;
        QMUIRadiusImageView qMUIRadiusImageView;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding != null && (qMUIRadiusImageView = itemFamilySearchMemberBinding.userAvatarCimageView) != null) {
            User user = item.getUser();
            ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(user != null ? user.getAvatar() : null), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131232432, (c5.g) null, 49150, (Object) null);
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding2 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding2 != null && (textView8 = itemFamilySearchMemberBinding2.userName) != null) {
            User user2 = item.getUser();
            textView8.setText(user2 != null ? user2.getNick() : null);
        }
        User user3 = item.getUser();
        if (((user3 == null || (svip2 = user3.getSvip()) == null) ? 0 : svip2.getSvipLevel()) > 0) {
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding3 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding3 != null && (imageView3 = itemFamilySearchMemberBinding3.svipType) != null) {
                imageView3.setVisibility(0);
            }
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            User user4 = item.getUser();
            Integer svipType = svipTypeUtils.getSvipType((user4 == null || (svip = user4.getSvip()) == null) ? null : Integer.valueOf(svip.getSvipLevel()));
            if (svipType != null) {
                int intValue = svipType.intValue();
                ItemFamilySearchMemberBinding itemFamilySearchMemberBinding4 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
                if (itemFamilySearchMemberBinding4 != null && (imageView2 = itemFamilySearchMemberBinding4.svipType) != null) {
                    imageView2.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), intValue));
                }
            }
        } else {
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding5 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding5 != null && (imageView = itemFamilySearchMemberBinding5.svipType) != null) {
                imageView.setVisibility(8);
            }
        }
        Integer role = item.getRole();
        if (role != null && role.intValue() == 2) {
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding6 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding6 != null && (textView7 = itemFamilySearchMemberBinding6.memberType) != null) {
                textView7.setVisibility(0);
            }
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding7 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding7 != null && (textView6 = itemFamilySearchMemberBinding7.memberType) != null) {
                textView6.setText(ResourcesKtxKt.getStringById(this, 2131953001));
            }
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding8 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding8 != null && (textView5 = itemFamilySearchMemberBinding8.memberType) != null) {
                textView5.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, getContext(), 2131100006, 2131100002, 7, GradientDrawable.Orientation.TOP_BOTTOM, false, 32, (Object) null));
            }
        } else if (role != null && role.intValue() == 3) {
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding9 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding9 != null && (textView4 = itemFamilySearchMemberBinding9.memberType) != null) {
                textView4.setVisibility(0);
            }
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding10 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding10 != null && (textView3 = itemFamilySearchMemberBinding10.memberType) != null) {
                textView3.setText(ResourcesKtxKt.getStringById(this, 2131952947));
            }
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding11 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding11 != null && (textView2 = itemFamilySearchMemberBinding11.memberType) != null) {
                textView2.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, getContext(), 2131099880, 2131099876, 7, GradientDrawable.Orientation.TOP_BOTTOM, false, 32, (Object) null));
            }
        } else {
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding12 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding12 != null && (textView = itemFamilySearchMemberBinding12.memberType) != null) {
                textView.setVisibility(8);
            }
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding13 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding13 != null && (genderAgeTextView2 = itemFamilySearchMemberBinding13.ageTextView) != null) {
            Resources resources = getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            User user5 = item.getUser();
            ViewUtilitiesKt.setDrawableLeft(genderAgeTextView2, ResourceUtilsKt.getDrawable(resources, user5 != null && user5.getSex() == 1 ? R.drawable.icon_boy : R.drawable.icon_girl, 0));
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding14 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding14 != null && (genderAgeTextView = itemFamilySearchMemberBinding14.ageTextView) != null) {
            User user6 = item.getUser();
            genderAgeTextView.setBackgroundResource(user6 != null && user6.getSex() == 1 ? R.drawable.bg_age_male : R.drawable.bg_age_female);
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding15 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding15 != null && (appCompatTextView = itemFamilySearchMemberBinding15.ageTextView) != null) {
            User user7 = item.getUser();
            if (((user7 == null || (isShowAge = user7.isShowAge()) == null) ? 1 : isShowAge.intValue()) == 1) {
                User user8 = item.getUser();
                charSequence = user8 != null ? user8.getAge() : null;
            } else {
                charSequence = "";
            }
            appCompatTextView.setText(charSequence);
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding16 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding16 != null && (hiloGradeView3 = itemFamilySearchMemberBinding16.wealthLevel) != null) {
            User user9 = item.getUser();
            HiloGradeView.setLevelBg$default(hiloGradeView3, user9 != null ? user9.getWealthUserGrade() : 0L, false, true, false, 10, (Object) null);
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding17 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding17 != null && (hiloGradeView2 = itemFamilySearchMemberBinding17.charmLevel) != null) {
            User user10 = item.getUser();
            HiloGradeView.setLevelBg$default(hiloGradeView2, user10 != null ? user10.getCharmUserGrade() : 0L, true, false, false, 12, (Object) null);
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding18 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding18 != null && (hiloGradeView = itemFamilySearchMemberBinding18.activityLevel) != null) {
            User user11 = item.getUser();
            HiloGradeView.setLevelBg$default(hiloGradeView, user11 != null ? user11.getActivityUserGrade() : 0L, false, false, true, 6, (Object) null);
        }
        User user12 = item.getUser();
        if (user12 != null ? Intrinsics.areEqual(user12.isPrettyCode(), Boolean.TRUE) : false) {
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding19 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding19 != null && (shineTextView4 = itemFamilySearchMemberBinding19.userId) != null) {
                Resources resources2 = getContext().getResources();
                Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
                ViewUtilitiesKt.setDrawableLeft(shineTextView4, ResourceUtilsKt.getDrawable(resources2, 2131232463, Dimens.INSTANCE.dpToPx(4)));
            }
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding20 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding20 != null && (shineTextView3 = itemFamilySearchMemberBinding20.userId) != null) {
                shineTextView3.setCompoundDrawablePadding(Dimens.INSTANCE.dpToPx(4));
            }
        } else {
            ItemFamilySearchMemberBinding itemFamilySearchMemberBinding21 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
            if (itemFamilySearchMemberBinding21 != null && (shineTextView = itemFamilySearchMemberBinding21.userId) != null) {
                ViewUtilitiesKt.setDrawableLeft(shineTextView, null);
            }
        }
        ItemFamilySearchMemberBinding itemFamilySearchMemberBinding22 = (ItemFamilySearchMemberBinding) holder.getDataBinding();
        if (itemFamilySearchMemberBinding22 == null || (shineTextView2 = itemFamilySearchMemberBinding22.userId) == null) {
            return;
        }
        String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
        User user13 = item.getUser();
        String format = String.format(stringById, Arrays.copyOf(new Object[]{user13 != null ? user13.getCode() : null}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        shineTextView2.setText(format);
    }
}
