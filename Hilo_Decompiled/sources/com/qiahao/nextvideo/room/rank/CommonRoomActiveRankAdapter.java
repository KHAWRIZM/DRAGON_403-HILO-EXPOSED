package com.qiahao.nextvideo.room.rank;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.room.RoomActiveData;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemRoomActiveNormalRankBinding;
import com.qiahao.nextvideo.databinding.ItemRoomActiveTopRankBinding;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u000fB\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0015J\u0016\u0010\r\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0016\u0010\u000e\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/room/rank/CommonRoomActiveRankAdapter;", "Lcom/chad/library/adapter/base/BaseMultiItemQuickAdapter;", "Lcom/qiahao/nextvideo/data/room/RoomActiveData;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemRoomActiveNormalRankBinding;", "data", "", "<init>", "(Ljava/util/List;)V", "convert", "", "holder", "item", "onViewAttachedToWindow", "onViewRecycled", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CommonRoomActiveRankAdapter extends BaseMultiItemQuickAdapter<RoomActiveData, BaseDataBindingHolder<ItemRoomActiveNormalRankBinding>> {
    public static final int POSITION_OHTER = 2;
    public static final int POSITION_ONE = 1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonRoomActiveRankAdapter(@NotNull List<RoomActiveData> list) {
        super(list);
        Intrinsics.checkNotNullParameter(list, "data");
        addItemType(1, R.layout.item_room_active_top_rank);
        addItemType(2, R.layout.item_room_active_normal_rank);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x04bc, code lost:
    
        if (r4.isVip() == true) goto L٢٢٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:253:0x04ac, code lost:
    
        if (r2 != null) goto L٢١٧;
     */
    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void convert(@NotNull BaseDataBindingHolder<ItemRoomActiveNormalRankBinding> holder, @NotNull RoomActiveData item) {
        int i;
        int i2;
        CharSequence charSequence;
        String nick;
        int i3;
        NobleInfo noble;
        Integer level;
        SvipData svip;
        NobleInfo noble2;
        Integer level2;
        NobleInfo noble3;
        Integer level3;
        NobleInfo noble4;
        Integer level4;
        String nick2;
        String nick3;
        Long birthday;
        Integer isShowAge;
        String avatar;
        String str;
        long j;
        String str2;
        String str3;
        int i4;
        int i5;
        NobleInfo noble5;
        Integer level5;
        NobleInfo noble6;
        Integer level6;
        Long birthday2;
        Integer isShowAge2;
        String avatar2;
        NobleInfo noble7;
        Integer level7;
        SvipData svip2;
        NobleInfo noble8;
        Integer level8;
        long j2;
        String nick4;
        String nick5;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        String str4 = "";
        if (holder.getItemViewType() == 1) {
            ViewDataBinding dataBinding = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomActiveTopRankBinding");
            ItemRoomActiveTopRankBinding itemRoomActiveTopRankBinding = (ItemRoomActiveTopRankBinding) dataBinding;
            User userBase = item.getUserBase();
            if (((userBase == null || (nick5 = userBase.getNick()) == null) ? 0 : nick5.length()) > 20) {
                User userBase2 = item.getUserBase();
                str2 = ((Object) ((userBase2 == null || (nick4 = userBase2.getNick()) == null) ? null : nick4.subSequence(0, 19))) + "...";
            } else {
                User userBase3 = item.getUserBase();
                if (userBase3 == null || (str2 = userBase3.getNick()) == null) {
                    str2 = "";
                }
            }
            Long num = item.getNum();
            if ((num != null ? num.longValue() : 0L) >= 60) {
                TextView textView = itemRoomActiveTopRankBinding.time;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                Locale locale = Locale.US;
                Long num2 = item.getNum();
                if (num2 != null) {
                    str3 = "vip";
                    j2 = num2.longValue();
                } else {
                    str3 = "vip";
                    j2 = 0;
                }
                String format = String.format(locale, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(j2 / 60.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format + " " + ResourcesKtxKt.getStringById(this, 2131953634));
            } else {
                str3 = "vip";
                TextView textView2 = itemRoomActiveTopRankBinding.time;
                Long num3 = item.getNum();
                String l = num3 != null ? num3.toString() : null;
                textView2.setText(l + " " + ResourcesKtxKt.getStringById(this, 2131953635));
            }
            NickTextView nickTextView = itemRoomActiveTopRankBinding.name;
            UserService.Companion companion = UserService.INSTANCE;
            User userBase4 = item.getUserBase();
            nickTextView.setTextColor(companion.getNobleColor((userBase4 == null || (noble8 = userBase4.getNoble()) == null || (level8 = noble8.getLevel()) == null) ? 0 : level8.intValue(), Color.parseColor("#333333")));
            NickTextView nickTextView2 = itemRoomActiveTopRankBinding.name;
            User userBase5 = item.getUserBase();
            int svipLevel = (userBase5 == null || (svip2 = userBase5.getSvip()) == null) ? 0 : svip2.getSvipLevel();
            User userBase6 = item.getUserBase();
            nickTextView2.setSVipAndNoble(str2, svipLevel, (userBase6 == null || (noble7 = userBase6.getNoble()) == null || (level7 = noble7.getLevel()) == null) ? 0 : level7.intValue());
            HiloImageView hiloImageView = itemRoomActiveTopRankBinding.avatar;
            User userBase7 = item.getUserBase();
            HiloImageView.loadImage$default(hiloImageView, (userBase7 == null || (avatar2 = userBase7.getAvatar()) == null) ? "" : avatar2, 0, 0, 6, (Object) null);
            GenderAgeTextView genderAgeTextView = itemRoomActiveTopRankBinding.ageTextView;
            Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
            Resources resources = getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            User userBase8 = item.getUserBase();
            if (userBase8 != null && userBase8.getSex() == 1) {
                i4 = 0;
                i5 = R.drawable.icon_boy;
            } else {
                i4 = 0;
                i5 = R.drawable.icon_girl;
            }
            ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, i5, i4));
            GenderAgeTextView genderAgeTextView2 = itemRoomActiveTopRankBinding.ageTextView;
            User userBase9 = item.getUserBase();
            genderAgeTextView2.setBackgroundResource(userBase9 != null && userBase9.getSex() == 1 ? R.drawable.bg_age_male : R.drawable.bg_age_female);
            AppCompatTextView appCompatTextView = itemRoomActiveTopRankBinding.ageTextView;
            User userBase10 = item.getUserBase();
            if (((userBase10 == null || (isShowAge2 = userBase10.isShowAge()) == null) ? 1 : isShowAge2.intValue()) == 1) {
                GroupService.Companion companion2 = GroupService.INSTANCE;
                User userBase11 = item.getUserBase();
                if (userBase11 != null && (birthday2 = userBase11.getBirthday()) != null) {
                    r24 = birthday2.longValue();
                }
                str4 = companion2.changeAge(r24);
            }
            appCompatTextView.setText(str4);
            itemRoomActiveTopRankBinding.ageTextView.setVisibility(0);
            ShineTextView shineTextView = itemRoomActiveTopRankBinding.f٦٤id;
            String stringById = ResourcesKtxKt.getStringById(this, 2131953102);
            User userBase12 = item.getUserBase();
            String format2 = String.format(stringById, Arrays.copyOf(new Object[]{userBase12 != null ? userBase12.getCode() : null}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            shineTextView.setNobleLevel(format2);
            ImageView imageView = itemRoomActiveTopRankBinding.vip;
            User userBase13 = item.getUserBase();
            imageView.setVisibility(userBase13 != null && userBase13.isVip() ? 0 : 8);
            ImageView imageView2 = itemRoomActiveTopRankBinding.vip;
            Intrinsics.checkNotNullExpressionValue(imageView2, str3);
            ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, 2131233624, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            User userBase14 = item.getUserBase();
            if (((userBase14 == null || (noble6 = userBase14.getNoble()) == null || (level6 = noble6.getLevel()) == null) ? 0 : level6.intValue()) > 0) {
                itemRoomActiveTopRankBinding.vip.setVisibility(8);
                itemRoomActiveTopRankBinding.noble.setVisibility(0);
                ImageView imageView3 = itemRoomActiveTopRankBinding.noble;
                Context context = getContext();
                User userBase15 = item.getUserBase();
                imageView3.setImageDrawable(androidx.core.content.a.getDrawable(context, companion.getNobleDrawableRes((userBase15 == null || (noble5 = userBase15.getNoble()) == null || (level5 = noble5.getLevel()) == null) ? 0 : level5.intValue())));
                return;
            }
            itemRoomActiveTopRankBinding.noble.setVisibility(8);
            return;
        }
        if (holder.getItemViewType() == 2) {
            ViewDataBinding dataBinding2 = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding2, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomActiveNormalRankBinding");
            ItemRoomActiveNormalRankBinding itemRoomActiveNormalRankBinding = (ItemRoomActiveNormalRankBinding) dataBinding2;
            itemRoomActiveNormalRankBinding.position.setText(String.valueOf(holder.getAdapterPosition() + 1));
            Long num4 = item.getNum();
            if ((num4 != null ? num4.longValue() : 0L) >= 60) {
                TextView textView3 = itemRoomActiveNormalRankBinding.time;
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                Locale locale2 = Locale.US;
                Long num5 = item.getNum();
                if (num5 != null) {
                    long longValue = num5.longValue();
                    str = "%.1f";
                    j = longValue;
                } else {
                    str = "%.1f";
                    j = 0;
                }
                String format3 = String.format(locale2, str, Arrays.copyOf(new Object[]{Double.valueOf(j / 60.0d)}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
                textView3.setText(format3 + " " + ResourcesKtxKt.getStringById(this, 2131953634));
            } else {
                TextView textView4 = itemRoomActiveNormalRankBinding.time;
                Long num6 = item.getNum();
                String l2 = num6 != null ? num6.toString() : null;
                textView4.setText(l2 + " " + ResourcesKtxKt.getStringById(this, 2131953635));
            }
            HiloImageView hiloImageView2 = itemRoomActiveNormalRankBinding.avatar;
            User userBase16 = item.getUserBase();
            HiloImageView.loadImage$default(hiloImageView2, (userBase16 == null || (avatar = userBase16.getAvatar()) == null) ? "" : avatar, 2131231655, 0, 4, (Object) null);
            GenderAgeTextView genderAgeTextView3 = itemRoomActiveNormalRankBinding.ageTextView;
            Intrinsics.checkNotNullExpressionValue(genderAgeTextView3, "ageTextView");
            Resources resources2 = getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
            User userBase17 = item.getUserBase();
            if (userBase17 != null && userBase17.getSex() == 1) {
                i = 0;
                i2 = R.drawable.icon_boy;
            } else {
                i = 0;
                i2 = R.drawable.icon_girl;
            }
            ViewUtilitiesKt.setDrawableLeft(genderAgeTextView3, ResourceUtilsKt.getDrawable(resources2, i2, i));
            GenderAgeTextView genderAgeTextView4 = itemRoomActiveNormalRankBinding.ageTextView;
            User userBase18 = item.getUserBase();
            genderAgeTextView4.setBackgroundResource(userBase18 != null && userBase18.getSex() == 1 ? R.drawable.bg_age_male : R.drawable.bg_age_female);
            AppCompatTextView appCompatTextView2 = itemRoomActiveNormalRankBinding.ageTextView;
            User userBase19 = item.getUserBase();
            if (((userBase19 == null || (isShowAge = userBase19.isShowAge()) == null) ? 1 : isShowAge.intValue()) == 1) {
                GroupService.Companion companion3 = GroupService.INSTANCE;
                User userBase20 = item.getUserBase();
                charSequence = companion3.changeAge((userBase20 == null || (birthday = userBase20.getBirthday()) == null) ? 0L : birthday.longValue());
            } else {
                charSequence = "";
            }
            appCompatTextView2.setText(charSequence);
            itemRoomActiveNormalRankBinding.ageTextView.setVisibility(0);
            ShineTextView shineTextView2 = itemRoomActiveNormalRankBinding.userId;
            String stringById2 = ResourcesKtxKt.getStringById(this, 2131953102);
            User userBase21 = item.getUserBase();
            String format4 = String.format(stringById2, Arrays.copyOf(new Object[]{userBase21 != null ? userBase21.getCode() : null}, 1));
            Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
            shineTextView2.setNobleLevel(format4);
            User userBase22 = item.getUserBase();
            if (((userBase22 == null || (nick3 = userBase22.getNick()) == null) ? 0 : nick3.length()) > 12) {
                User userBase23 = item.getUserBase();
                if (userBase23 != null && (nick2 = userBase23.getNick()) != null) {
                    r23 = nick2.subSequence(0, 11);
                }
                str4 = ((Object) r23) + "...";
            } else {
                User userBase24 = item.getUserBase();
                if (userBase24 != null) {
                    nick = userBase24.getNick();
                }
            }
            nick = str4;
            ImageView imageView4 = itemRoomActiveNormalRankBinding.vip;
            User userBase25 = item.getUserBase();
            boolean z = userBase25 != null;
            imageView4.setVisibility(z ? 0 : 8);
            ImageView imageView5 = itemRoomActiveNormalRankBinding.vip;
            Intrinsics.checkNotNullExpressionValue(imageView5, "vip");
            ImageKtxKt.loadImage$default(imageView5, (String) null, (Uri) null, (File) null, 2131233624, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            User userBase26 = item.getUserBase();
            if (((userBase26 == null || (noble4 = userBase26.getNoble()) == null || (level4 = noble4.getLevel()) == null) ? 0 : level4.intValue()) > 0) {
                itemRoomActiveNormalRankBinding.vip.setVisibility(8);
                i3 = 0;
                itemRoomActiveNormalRankBinding.noble.setVisibility(0);
                ImageView imageView6 = itemRoomActiveNormalRankBinding.noble;
                Context context2 = getContext();
                UserService.Companion companion4 = UserService.INSTANCE;
                User userBase27 = item.getUserBase();
                imageView6.setImageDrawable(androidx.core.content.a.getDrawable(context2, companion4.getNobleDrawableRes((userBase27 == null || (noble3 = userBase27.getNoble()) == null || (level3 = noble3.getLevel()) == null) ? 0 : level3.intValue())));
            } else {
                i3 = 0;
                itemRoomActiveNormalRankBinding.noble.setVisibility(8);
            }
            HiloGradeView hiloGradeView = itemRoomActiveNormalRankBinding.charmLevel;
            User userBase28 = item.getUserBase();
            HiloGradeView.setLevelBg$default(hiloGradeView, userBase28 != null ? userBase28.getCharmUserGrade() : 0L, true, false, false, 12, (Object) null);
            HiloGradeView hiloGradeView2 = itemRoomActiveNormalRankBinding.wealthLevel;
            User userBase29 = item.getUserBase();
            HiloGradeView.setLevelBg$default(hiloGradeView2, userBase29 != null ? userBase29.getWealthUserGrade() : 0L, false, true, false, 10, (Object) null);
            NickTextView nickTextView3 = itemRoomActiveNormalRankBinding.name;
            UserService.Companion companion5 = UserService.INSTANCE;
            User userBase30 = item.getUserBase();
            nickTextView3.setTextColor(companion5.getNobleColor((userBase30 == null || (noble2 = userBase30.getNoble()) == null || (level2 = noble2.getLevel()) == null) ? 0 : level2.intValue(), Color.parseColor("#333333")));
            NickTextView nickTextView4 = itemRoomActiveNormalRankBinding.name;
            User userBase31 = item.getUserBase();
            int svipLevel2 = (userBase31 == null || (svip = userBase31.getSvip()) == null) ? 0 : svip.getSvipLevel();
            User userBase32 = item.getUserBase();
            if (userBase32 != null && (noble = userBase32.getNoble()) != null && (level = noble.getLevel()) != null) {
                i3 = level.intValue();
            }
            nickTextView4.setSVipAndNoble(nick, svipLevel2, i3);
        }
    }

    public void onViewRecycled(@NotNull BaseDataBindingHolder<ItemRoomActiveNormalRankBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*androidx.recyclerview.widget.RecyclerView.Adapter*/.onViewRecycled(holder);
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 1) {
            ViewDataBinding dataBinding = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomActiveTopRankBinding");
            ItemRoomActiveTopRankBinding itemRoomActiveTopRankBinding = (ItemRoomActiveTopRankBinding) dataBinding;
            itemRoomActiveTopRankBinding.name.startOrStopAnim(false);
            itemRoomActiveTopRankBinding.f٦٤id.stopAnimation();
            return;
        }
        if (itemViewType != 2) {
            return;
        }
        ViewDataBinding dataBinding2 = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding2, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomActiveNormalRankBinding");
        ItemRoomActiveNormalRankBinding itemRoomActiveNormalRankBinding = (ItemRoomActiveNormalRankBinding) dataBinding2;
        itemRoomActiveNormalRankBinding.name.startOrStopAnim(false);
        itemRoomActiveNormalRankBinding.userId.stopAnimation();
    }

    public void onViewAttachedToWindow(@NotNull BaseDataBindingHolder<ItemRoomActiveNormalRankBinding> holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        super/*com.chad.library.adapter.base.BaseQuickAdapter*/.onViewAttachedToWindow(holder);
        int itemViewType = holder.getItemViewType();
        if (itemViewType == 1) {
            ViewDataBinding dataBinding = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomActiveTopRankBinding");
            ((ItemRoomActiveTopRankBinding) dataBinding).name.startOrStopAnim(true);
        } else {
            if (itemViewType != 2) {
                return;
            }
            ViewDataBinding dataBinding2 = holder.getDataBinding();
            Intrinsics.checkNotNull(dataBinding2, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomActiveNormalRankBinding");
            ((ItemRoomActiveNormalRankBinding) dataBinding2).name.startOrStopAnim(true);
        }
    }
}
