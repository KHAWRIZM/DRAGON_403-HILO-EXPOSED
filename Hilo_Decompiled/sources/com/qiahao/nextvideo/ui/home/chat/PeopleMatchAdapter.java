package com.qiahao.nextvideo.ui.home.chat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.qiahao.base_common.AllModuleServiceManager;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.service.BaseService;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.game.MatchRecent;
import com.qiahao.nextvideo.databinding.ItemPeopleMatchBinding;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0014J,\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0014J\u0016\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0002R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/chat/PeopleMatchAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/game/MatchRecent;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemPeopleMatchBinding;", "<init>", "()V", "baseService", "Lcom/qiahao/base_common/service/BaseService;", "getBaseService", "()Lcom/qiahao/base_common/service/BaseService;", "setBaseService", "(Lcom/qiahao/base_common/service/BaseService;)V", "convert", "", "holder", "item", "payloads", "", "", "refresh", "binding", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PeopleMatchAdapter extends BaseQuickAdapter<MatchRecent, BaseDataBindingHolder<ItemPeopleMatchBinding>> {

    @Nullable
    private BaseService baseService;

    public PeopleMatchAdapter() {
        super(R.layout.item_people_match, (List) null, 2, (DefaultConstructorMarker) null);
        this.baseService = AllModuleServiceManager.Companion.get().getAppService();
    }

    @Nullable
    public final BaseService getBaseService() {
        return this.baseService;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void refresh(@NotNull ItemPeopleMatchBinding binding, @NotNull MatchRecent item) {
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        int i3;
        CharSequence charSequence;
        Long l;
        Long l2;
        NobleInfo nobleInfo;
        User user;
        long j;
        User user2;
        int i4;
        int i5;
        int i6;
        Integer isShowAge;
        Intrinsics.checkNotNullParameter(binding, "binding");
        Intrinsics.checkNotNullParameter(item, "item");
        AppCompatImageView appCompatImageView = binding.avatar;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "avatar");
        User user3 = item.getUser();
        Boolean bool = null;
        if (user3 != null) {
            str = user3.getAvatar();
        } else {
            str = null;
        }
        ImageKtxKt.loadImage$default(appCompatImageView, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        TextView textView = binding.userName;
        User user4 = item.getUser();
        if (user4 != null) {
            str2 = user4.getNick();
        } else {
            str2 = null;
        }
        textView.setText(str2);
        ImageView imageView = binding.gameIcon;
        Intrinsics.checkNotNullExpressionValue(imageView, "gameIcon");
        ImageKtxKt.loadImage$default(imageView, ImageSizeKt.image100(item.getGameIcon()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        ImageView imageView2 = binding.countryImage;
        Intrinsics.checkNotNullExpressionValue(imageView2, "countryImage");
        User user5 = item.getUser();
        if (user5 != null) {
            str3 = user5.getCountryIcon();
        } else {
            str3 = null;
        }
        ImageKtxKt.loadImage$default(imageView2, str3, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        GenderAgeTextView genderAgeTextView = binding.ageTextView;
        Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        User user6 = item.getUser();
        if (user6 != null && user6.getSex() == 1) {
            i = R.drawable.icon_boy;
        } else {
            i = R.drawable.icon_girl;
        }
        ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, i, 0));
        GenderAgeTextView genderAgeTextView2 = binding.ageTextView;
        User user7 = item.getUser();
        if (user7 != null && user7.getSex() == 1) {
            i2 = R.drawable.bg_age_male;
        } else {
            i2 = R.drawable.bg_age_female;
        }
        genderAgeTextView2.setBackgroundResource(i2);
        AppCompatTextView appCompatTextView = binding.ageTextView;
        User user8 = item.getUser();
        if (user8 != null && (isShowAge = user8.isShowAge()) != null) {
            i3 = isShowAge.intValue();
        } else {
            i3 = 1;
        }
        if (i3 == 1) {
            User user9 = item.getUser();
            if (user9 != null) {
                charSequence = user9.getAge();
            } else {
                charSequence = null;
            }
        } else {
            charSequence = "";
        }
        appCompatTextView.setText(charSequence);
        User user10 = item.getUser();
        if (user10 != null) {
            l = Long.valueOf(user10.getWealthUserGrade());
        } else {
            l = null;
        }
        if (l != null) {
            binding.wealthLevel.setVisibility(0);
            HiloGradeView.setLevelBg$default(binding.wealthLevel, l.longValue(), false, true, false, 10, (Object) null);
        }
        User user11 = item.getUser();
        if (user11 != null) {
            l2 = Long.valueOf(user11.getCharmUserGrade());
        } else {
            l2 = null;
        }
        if (l2 != null) {
            binding.charmLevel.setVisibility(0);
            HiloGradeView.setLevelBg$default(binding.charmLevel, l2.longValue(), true, false, false, 12, (Object) null);
        }
        User user12 = item.getUser();
        if (user12 != null) {
            nobleInfo = user12.getNoble();
        } else {
            nobleInfo = null;
        }
        if (nobleInfo != null) {
            Integer level = nobleInfo.getLevel();
            if (level != null) {
                i4 = level.intValue();
            } else {
                i4 = 0;
            }
            if (i4 > 0) {
                binding.iconNoble.setVisibility(0);
                ImageView imageView3 = binding.iconNoble;
                Context context = getContext();
                BaseService baseService = this.baseService;
                if (baseService != null) {
                    Integer level2 = nobleInfo.getLevel();
                    if (level2 != null) {
                        i6 = level2.intValue();
                    } else {
                        i6 = 0;
                    }
                    i5 = baseService.getNobleDrawableRes(i6);
                } else {
                    i5 = 0;
                }
                imageView3.setImageDrawable(androidx.core.content.a.getDrawable(context, i5));
                HiloGradeView hiloGradeView = binding.activityLevel;
                user = item.getUser();
                if (user == null) {
                    j = user.getActivityUserGrade();
                } else {
                    j = 0;
                }
                HiloGradeView.setLevelBg$default(hiloGradeView, j, false, false, true, 6, (Object) null);
                user2 = item.getUser();
                if (user2 != null) {
                    bool = Boolean.valueOf(user2.isVip());
                }
                if (bool == null && bool.booleanValue()) {
                    binding.iconVip.setVisibility(0);
                    return;
                } else {
                    binding.iconVip.setVisibility(8);
                }
            }
        }
        binding.iconNoble.setVisibility(8);
        HiloGradeView hiloGradeView2 = binding.activityLevel;
        user = item.getUser();
        if (user == null) {
        }
        HiloGradeView.setLevelBg$default(hiloGradeView2, j, false, false, true, 6, (Object) null);
        user2 = item.getUser();
        if (user2 != null) {
        }
        if (bool == null) {
        }
        binding.iconVip.setVisibility(8);
    }

    public final void setBaseService(@Nullable BaseService baseService) {
        this.baseService = baseService;
    }

    public /* bridge */ /* synthetic */ void convert(BaseViewHolder baseViewHolder, Object obj, List list) {
        convert((BaseDataBindingHolder<ItemPeopleMatchBinding>) baseViewHolder, (MatchRecent) obj, (List<? extends Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemPeopleMatchBinding> holder, @NotNull MatchRecent item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemPeopleMatchBinding");
        refresh((ItemPeopleMatchBinding) dataBinding, item);
    }

    protected void convert(@NotNull BaseDataBindingHolder<ItemPeopleMatchBinding> holder, @NotNull MatchRecent item, @NotNull List<? extends Object> payloads) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.convert(holder, item, payloads);
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemPeopleMatchBinding");
        refresh((ItemPeopleMatchBinding) dataBinding, item);
    }
}
