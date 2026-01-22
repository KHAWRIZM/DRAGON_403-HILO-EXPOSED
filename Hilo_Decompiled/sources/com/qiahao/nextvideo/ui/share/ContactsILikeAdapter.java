package com.qiahao.nextvideo.ui.share;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.ILikeGuyItem;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.databinding.ItemContactLikeMeOtherBinding;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u001b2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u001bB#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bJ\u001e\u0010\u0018\u001a\u00020\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u001a\u001a\u00020\u0002H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\fR*\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/ui/share/ContactsILikeAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/ILikeGuyItem;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemContactLikeMeOtherBinding;", "layout", "", "isSelectAll", "", "isShowSelect", "<init>", "(IZZ)V", "()Z", "hasSelectList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getHasSelectList", "()Ljava/util/ArrayList;", "setHasSelectList", "(Ljava/util/ArrayList;)V", "setIsSelectAll", "", "selectAll", "convert", "holder", "item", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ContactsILikeAdapter extends BaseQuickAdapter<ILikeGuyItem, BaseDataBindingHolder<ItemContactLikeMeOtherBinding>> {

    @NotNull
    private static final String TAG = "ContactsLikeEachOtherAd";

    @NotNull
    private ArrayList<String> hasSelectList;
    private boolean isSelectAll;
    private final boolean isShowSelect;

    public ContactsILikeAdapter(int i, boolean z, boolean z2) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        this.isSelectAll = z;
        this.isShowSelect = z2;
        this.hasSelectList = new ArrayList<>();
    }

    @NotNull
    public final ArrayList<String> getHasSelectList() {
        return this.hasSelectList;
    }

    /* renamed from: isShowSelect, reason: from getter */
    public final boolean getIsShowSelect() {
        return this.isShowSelect;
    }

    public final void setHasSelectList(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.hasSelectList = arrayList;
    }

    public final void setIsSelectAll(boolean selectAll) {
        this.isSelectAll = selectAll;
        this.hasSelectList.clear();
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemContactLikeMeOtherBinding> holder, @NotNull ILikeGuyItem item) {
        Long birthday;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemContactLikeMeOtherBinding");
        ItemContactLikeMeOtherBinding itemContactLikeMeOtherBinding = (ItemContactLikeMeOtherBinding) dataBinding;
        Log.d(TAG, "bind: ----");
        User user = item.getUser();
        if (!TextUtils.isEmpty(user != null ? user.getNick() : null)) {
            TextView textView = itemContactLikeMeOtherBinding.userName;
            User user2 = item.getUser();
            textView.setText(user2 != null ? user2.getNick() : null);
        }
        GenderAgeTextView genderAgeTextView = itemContactLikeMeOtherBinding.ageTextView;
        Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        User user3 = item.getUser();
        ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, (user3 == null || user3.getSex() != 1) ? R.drawable.icon_girl : R.drawable.icon_boy, 0));
        GenderAgeTextView genderAgeTextView2 = itemContactLikeMeOtherBinding.ageTextView;
        User user4 = item.getUser();
        genderAgeTextView2.setBackgroundResource((user4 == null || user4.getSex() != 1) ? R.drawable.bg_age_female : R.drawable.bg_age_male);
        AppCompatTextView appCompatTextView = itemContactLikeMeOtherBinding.ageTextView;
        GroupService.Companion companion = GroupService.INSTANCE;
        User user5 = item.getUser();
        appCompatTextView.setText(companion.changeAge((user5 == null || (birthday = user5.getBirthday()) == null) ? 0L : birthday.longValue()));
        CircleImageView circleImageView = itemContactLikeMeOtherBinding.userAvatarCimageView;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "userAvatarCimageView");
        ImageUIModel.Companion companion2 = ImageUIModel.INSTANCE;
        User user6 = item.getUser();
        String avatar = user6 != null ? user6.getAvatar() : null;
        ResizeMode.LFIT lfit = ResizeMode.LFIT.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        lfit.setWidth(dimens.dpToPx(45));
        lfit.setHeight(dimens.dpToPx(45));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind$default(circleImageView, companion2.displayUserAvatarImage(avatar, lfit), null, 2, null);
        ImageView imageView = itemContactLikeMeOtherBinding.countryImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "countryImage");
        User user7 = item.getUser();
        ViewUtilitiesKt.bind(imageView, new ImageUIModel(user7 != null ? user7.getCountryIcon() : null, null, null, null, 0, 0, null, 126, null));
        HiloGradeView hiloGradeView = itemContactLikeMeOtherBinding.wealthLevel;
        User user8 = item.getUser();
        HiloGradeView.setLevelBg$default(hiloGradeView, user8 != null ? user8.getWealthUserGrade() : 0L, false, true, false, 10, (Object) null);
        HiloGradeView hiloGradeView2 = itemContactLikeMeOtherBinding.charmLevel;
        User user9 = item.getUser();
        HiloGradeView.setLevelBg$default(hiloGradeView2, user9 != null ? user9.getCharmUserGrade() : 0L, true, false, false, 12, (Object) null);
        HiloGradeView hiloGradeView3 = itemContactLikeMeOtherBinding.activityLevel;
        User user10 = item.getUser();
        HiloGradeView.setLevelBg$default(hiloGradeView3, user10 != null ? user10.getActivityUserGrade() : 0L, false, false, true, 6, (Object) null);
        if (this.isShowSelect) {
            itemContactLikeMeOtherBinding.iconSelection.setVisibility(0);
            if (this.isSelectAll) {
                ImageView imageView2 = itemContactLikeMeOtherBinding.iconSelection;
                Intrinsics.checkNotNullExpressionValue(imageView2, "iconSelection");
                ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_check_pre), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
            } else {
                ArrayList<String> arrayList = this.hasSelectList;
                User user11 = item.getUser();
                if (CollectionsKt.contains(arrayList, user11 != null ? user11.getExternalId() : null)) {
                    ImageView imageView3 = itemContactLikeMeOtherBinding.iconSelection;
                    Intrinsics.checkNotNullExpressionValue(imageView3, "iconSelection");
                    ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_check_pre), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                } else {
                    ImageView imageView4 = itemContactLikeMeOtherBinding.iconSelection;
                    Intrinsics.checkNotNullExpressionValue(imageView4, "iconSelection");
                    ImageKtxKt.loadImage$default(imageView4, (String) null, (Uri) null, (File) null, Integer.valueOf(R.drawable.icon_check_nor), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
                }
            }
        } else {
            itemContactLikeMeOtherBinding.iconSelection.setVisibility(8);
        }
        ImageView imageView5 = itemContactLikeMeOtherBinding.iconVip;
        User user12 = item.getUser();
        imageView5.setVisibility((user12 == null || !user12.isVip()) ? 8 : 0);
    }

    public /* synthetic */ ContactsILikeAdapter(int i, boolean z, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? true : z2);
    }
}
