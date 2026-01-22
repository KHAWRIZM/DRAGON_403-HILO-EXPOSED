package com.qiahao.nextvideo.ui.home.game;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.model.common.User;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.base_common.wedgit.HiloGradeView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.game.HomeGameUser;
import com.qiahao.nextvideo.data.model.GameConfiguration;
import com.qiahao.nextvideo.databinding.ItemHomeGameRoomBinding;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;
import com.qiahao.nextvideo.utilities.ResourceUtilsKt;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/game/HomeGameUserAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/game/HomeGameUser;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemHomeGameRoomBinding;", "<init>", "()V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class HomeGameUserAdapter extends BaseQuickAdapter<HomeGameUser, BaseDataBindingHolder<ItemHomeGameRoomBinding>> {
    public HomeGameUserAdapter() {
        super(R.layout.item_home_game_room, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemHomeGameRoomBinding> holder, @NotNull HomeGameUser item) {
        String str;
        SvipData svip;
        SvipData svip2;
        Integer isShowAge;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemHomeGameRoomBinding");
        ItemHomeGameRoomBinding itemHomeGameRoomBinding = (ItemHomeGameRoomBinding) dataBinding;
        itemHomeGameRoomBinding.constraint.setBackground(ShapeUtil.INSTANCE.createShape("#ffffff", "#ffffff", 10, GradientDrawable.Orientation.TOP_BOTTOM));
        QMUIRadiusImageView qMUIRadiusImageView = itemHomeGameRoomBinding.avatar;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatar");
        User user = item.getUser();
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(user != null ? user.getAvatar() : null), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (c5.g) null, 49150, (Object) null);
        TextView textView = itemHomeGameRoomBinding.name;
        User user2 = item.getUser();
        CharSequence charSequence = "";
        if (user2 == null || (str = user2.getNick()) == null) {
            str = "";
        }
        textView.setText(str);
        ImageView imageView = itemHomeGameRoomBinding.countryImg;
        Intrinsics.checkNotNullExpressionValue(imageView, "countryImg");
        User user3 = item.getUser();
        ImageKtxKt.loadImage$default(imageView, ImageSizeKt.imageSize(user3 != null ? user3.getCountryIcon() : null, UiKtxKt.toPX(48), UiKtxKt.toPX(30)), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        GenderAgeTextView genderAgeTextView = itemHomeGameRoomBinding.ageTextView;
        Intrinsics.checkNotNullExpressionValue(genderAgeTextView, "ageTextView");
        Resources resources = getContext().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        User user4 = item.getUser();
        ViewUtilitiesKt.setDrawableLeft(genderAgeTextView, ResourceUtilsKt.getDrawable(resources, (user4 == null || user4.getSex() != 1) ? R.drawable.icon_girl : R.drawable.icon_boy, 0));
        GenderAgeTextView genderAgeTextView2 = itemHomeGameRoomBinding.ageTextView;
        User user5 = item.getUser();
        genderAgeTextView2.setBackgroundResource((user5 == null || user5.getSex() != 1) ? R.drawable.bg_age_female : R.drawable.bg_age_male);
        AppCompatTextView appCompatTextView = itemHomeGameRoomBinding.ageTextView;
        User user6 = item.getUser();
        if (((user6 == null || (isShowAge = user6.isShowAge()) == null) ? 1 : isShowAge.intValue()) == 1) {
            User user7 = item.getUser();
            charSequence = user7 != null ? user7.getAge() : null;
        }
        appCompatTextView.setText(charSequence);
        User user8 = item.getUser();
        if (((user8 == null || (svip2 = user8.getSvip()) == null) ? 0 : svip2.getSvipLevel()) > 0) {
            itemHomeGameRoomBinding.svipType.setVisibility(0);
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            User user9 = item.getUser();
            Integer svipType = svipTypeUtils.getSvipType((user9 == null || (svip = user9.getSvip()) == null) ? null : Integer.valueOf(svip.getSvipLevel()));
            if (svipType != null) {
                itemHomeGameRoomBinding.svipType.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), svipType.intValue()));
            }
        } else {
            itemHomeGameRoomBinding.svipType.setVisibility(8);
        }
        HiloGradeView hiloGradeView = itemHomeGameRoomBinding.wealthLevel;
        User user10 = item.getUser();
        HiloGradeView.setLevelBg$default(hiloGradeView, user10 != null ? user10.getWealthUserGrade() : 0L, false, true, false, 10, (Object) null);
        ImageView imageView2 = itemHomeGameRoomBinding.gameIcon;
        GameConfiguration game = item.getGame();
        imageView2.setVisibility(TextUtils.isEmpty(game != null ? game.getIcon() : null) ? 8 : 0);
        ImageView imageView3 = itemHomeGameRoomBinding.gameIcon;
        Intrinsics.checkNotNullExpressionValue(imageView3, "gameIcon");
        GameConfiguration game2 = item.getGame();
        ImageKtxKt.loadImage$default(imageView3, ImageSizeKt.image100(game2 != null ? game2.getIcon() : null), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
    }
}
