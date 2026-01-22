package com.qiahao.nextvideo.ui.rank;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.common.MedalInfo;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.utils.image.HiloImageView;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.data.model.CpBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemCpRankBinding;
import com.qiahao.nextvideo.utilities.userproxy.NumberUtilsKt;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/qiahao/nextvideo/ui/rank/CpRankAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/CpBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemCpRankBinding;", "layout", "", "mDateType", "", "<init>", "(ILjava/lang/String;)V", "getMDateType", "()Ljava/lang/String;", "convert", "", "holder", "cpBean", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CpRankAdapter extends BaseQuickAdapter<CpBean, BaseDataBindingHolder<ItemCpRankBinding>> {

    @NotNull
    private final String mDateType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CpRankAdapter(int i, @NotNull String str) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "mDateType");
        this.mDateType = str;
    }

    @NotNull
    public final String getMDateType() {
        return this.mDateType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemCpRankBinding> holder, @NotNull CpBean cpBean) {
        String name;
        String name2;
        Integer level;
        Integer level2;
        Integer level3;
        Integer level4;
        Integer level5;
        Integer level6;
        Integer level7;
        Integer level8;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(cpBean, "cpBean");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemCpRankBinding");
        ItemCpRankBinding itemCpRankBinding = (ItemCpRankBinding) dataBinding;
        HiloImageView.loadImage$default(itemCpRankBinding.user1AvatarCimageView, ImageSizeKt.image100(cpBean.getUser_1().getAvatar()), 0, 0, 6, (Object) null);
        HiloImageView.loadImage$default(itemCpRankBinding.user2AvatarCimageView, ImageSizeKt.image100(cpBean.getUser_2().getAvatar()), 0, 0, 6, (Object) null);
        NobleInfo noble = cpBean.getUser_1().getNoble();
        if (((noble == null || (level8 = noble.getLevel()) == null) ? 0 : level8.intValue()) > 0) {
            TextView textView = itemCpRankBinding.user1Name;
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = cpBean.getUser_1().getNoble();
            textView.setTextColor(UserService.Companion.getNobleColor$default(companion, (noble2 == null || (level7 = noble2.getLevel()) == null) ? 0 : level7.intValue(), 0, 2, null));
        } else {
            itemCpRankBinding.user1Name.setTextColor(Color.parseColor("#333333"));
        }
        TextView textView2 = itemCpRankBinding.user1Name;
        String name3 = cpBean.getUser_1().getName();
        if ((name3 != null ? name3.length() : 0) > 7) {
            String name4 = cpBean.getUser_1().getName();
            name = ((Object) (name4 != null ? name4.subSequence(0, 7) : null)) + "...";
        } else {
            name = cpBean.getUser_1().getName();
        }
        textView2.setText(name);
        NobleInfo noble3 = cpBean.getUser_2().getNoble();
        if (((noble3 == null || (level6 = noble3.getLevel()) == null) ? 0 : level6.intValue()) > 0) {
            TextView textView3 = itemCpRankBinding.user2Name;
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble4 = cpBean.getUser_2().getNoble();
            textView3.setTextColor(UserService.Companion.getNobleColor$default(companion2, (noble4 == null || (level5 = noble4.getLevel()) == null) ? 0 : level5.intValue(), 0, 2, null));
        } else {
            itemCpRankBinding.user2Name.setTextColor(Color.parseColor("#333333"));
        }
        TextView textView4 = itemCpRankBinding.user2Name;
        String name5 = cpBean.getUser_2().getName();
        if ((name5 != null ? name5.length() : 0) > 7) {
            String name6 = cpBean.getUser_2().getName();
            name2 = ((Object) (name6 != null ? name6.subSequence(0, 7) : null)) + "...";
        } else {
            name2 = cpBean.getUser_2().getName();
        }
        textView4.setText(name2);
        itemCpRankBinding.cpValue.setText(NumberUtilsKt.rankNumberFormat(cpBean.getScore()));
        itemCpRankBinding.listPosition.setText(String.valueOf(holder.getAdapterPosition() + 4));
        Boolean isVip = cpBean.getUser_1().isVip();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(isVip, bool)) {
            itemCpRankBinding.iconVip1.setVisibility(0);
        } else {
            itemCpRankBinding.iconVip1.setVisibility(8);
        }
        NobleInfo noble5 = cpBean.getUser_1().getNoble();
        if (((noble5 == null || (level4 = noble5.getLevel()) == null) ? 0 : level4.intValue()) > 0) {
            itemCpRankBinding.iconVip1.setVisibility(8);
            itemCpRankBinding.iconNoble1.setVisibility(0);
            ImageView imageView = itemCpRankBinding.iconNoble1;
            Context context = getContext();
            UserService.Companion companion3 = UserService.INSTANCE;
            NobleInfo noble6 = cpBean.getUser_1().getNoble();
            imageView.setImageDrawable(androidx.core.content.a.getDrawable(context, companion3.getNobleDrawableRes((noble6 == null || (level3 = noble6.getLevel()) == null) ? 0 : level3.intValue())));
        } else {
            itemCpRankBinding.iconNoble1.setVisibility(8);
        }
        ImageView imageView2 = itemCpRankBinding.iconVip2;
        Intrinsics.checkNotNullExpressionValue(imageView2, "iconVip2");
        ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, 2131233624, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        if (Intrinsics.areEqual(cpBean.getUser_2().isVip(), bool)) {
            itemCpRankBinding.iconVip2.setVisibility(0);
        } else {
            itemCpRankBinding.iconVip2.setVisibility(8);
        }
        NobleInfo noble7 = cpBean.getUser_2().getNoble();
        if (((noble7 == null || (level2 = noble7.getLevel()) == null) ? 0 : level2.intValue()) > 0) {
            itemCpRankBinding.iconVip2.setVisibility(8);
            itemCpRankBinding.iconNoble2.setVisibility(0);
            ImageView imageView3 = itemCpRankBinding.iconNoble2;
            Context context2 = getContext();
            UserService.Companion companion4 = UserService.INSTANCE;
            NobleInfo noble8 = cpBean.getUser_2().getNoble();
            imageView3.setImageDrawable(androidx.core.content.a.getDrawable(context2, companion4.getNobleDrawableRes((noble8 == null || (level = noble8.getLevel()) == null) ? 0 : level.intValue())));
        } else {
            itemCpRankBinding.iconNoble2.setVisibility(8);
        }
        if (cpBean.getUser_1().getMedalInfo() != null) {
            itemCpRankBinding.user1Medal.setVisibility(0);
            MedalGridLayout medalGridLayout = itemCpRankBinding.user1Medal;
            List<MedalInfo> medalInfo = cpBean.getUser_1().getMedalInfo();
            Intrinsics.checkNotNull(medalInfo);
            List mutableList = CollectionsKt.toMutableList(medalInfo);
            Intrinsics.checkNotNull(mutableList, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
            medalGridLayout.setDataAndLayoutView((ArrayList) mutableList, 4);
        } else {
            itemCpRankBinding.user1Medal.setVisibility(8);
        }
        if (cpBean.getUser_2().getMedalInfo() != null) {
            itemCpRankBinding.user2Medal.setVisibility(0);
            MedalGridLayout medalGridLayout2 = itemCpRankBinding.user2Medal;
            List<MedalInfo> medalInfo2 = cpBean.getUser_2().getMedalInfo();
            Intrinsics.checkNotNull(medalInfo2);
            List mutableList2 = CollectionsKt.toMutableList(medalInfo2);
            Intrinsics.checkNotNull(mutableList2, "null cannot be cast to non-null type java.util.ArrayList<com.qiahao.base_common.model.common.MedalInfo>");
            medalGridLayout2.setDataAndLayoutView((ArrayList) mutableList2, 4);
            return;
        }
        itemCpRankBinding.user2Medal.setVisibility(8);
    }
}
