package com.qiahao.nextvideo.ui.home;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.utils.DateTimeUtilityKt;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.GlobalBroadCastBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemGlobalBroadcastHistoryBinding;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/GlobalBroadCastHistoryAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/GlobalBroadCastBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGlobalBroadcastHistoryBinding;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "item", "updateViewShow", "binding", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GlobalBroadCastHistoryAdapter extends BaseQuickAdapter<GlobalBroadCastBean, BaseDataBindingHolder<ItemGlobalBroadcastHistoryBinding>> {

    @NotNull
    private static final String TAG = "GlobalBroadCastHistoryA";

    public GlobalBroadCastHistoryAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    private final void updateViewShow(GlobalBroadCastBean item, ItemGlobalBroadcastHistoryBinding binding) {
        int i;
        Integer level;
        NobleInfo noble = item.getUser().getNoble();
        if (noble != null && (level = noble.getLevel()) != null) {
            i = level.intValue();
        } else {
            i = 0;
        }
        switch (i) {
            case 1:
            case 2:
                binding.bgContent.setBackgroundResource(R.drawable.bg_item_global_broadcast_history);
                binding.broadCastText.setTextColor(Color.parseColor("#171717"));
                binding.userName.setTextColor(Color.parseColor("#999999"));
                binding.createTime.setTextColor(Color.parseColor("#999999"));
                break;
            case 3:
                binding.bgContent.setBackgroundResource(R.drawable.bg_item_global_broadcast_history_v3);
                binding.broadCastText.setTextColor(Color.parseColor("#ffffff"));
                binding.userName.setTextColor(Color.parseColor("#ffffff"));
                binding.createTime.setTextColor(Color.parseColor("#ffffff"));
                break;
            case 4:
                binding.bgContent.setBackgroundResource(R.drawable.bg_item_global_broadcast_history_v4);
                binding.broadCastText.setTextColor(Color.parseColor("#ffffff"));
                binding.userName.setTextColor(Color.parseColor("#ffffff"));
                binding.createTime.setTextColor(Color.parseColor("#ffffff"));
                break;
            case 5:
                binding.bgContent.setBackgroundResource(R.drawable.bg_item_global_broadcast_history_v5);
                binding.broadCastText.setTextColor(Color.parseColor("#fa5200"));
                binding.userName.setTextColor(Color.parseColor("#fa5200"));
                binding.createTime.setTextColor(Color.parseColor("#fa5200"));
                break;
            case 6:
                binding.bgContent.setBackgroundResource(R.drawable.bg_item_global_broadcast_history_v6);
                binding.broadCastText.setTextColor(Color.parseColor("#ffea3c"));
                binding.userName.setTextColor(Color.parseColor("#ffea3c"));
                binding.createTime.setTextColor(Color.parseColor("#ffea3c"));
                break;
            case 7:
                binding.bgContent.setBackgroundResource(R.drawable.bg_item_global_broadcast_history_v7);
                binding.broadCastText.setTextColor(Color.parseColor("#ffea3c"));
                binding.userName.setTextColor(Color.parseColor("#ffea3c"));
                binding.createTime.setTextColor(Color.parseColor("#ffea3c"));
                break;
            case 8:
                binding.bgContent.setBackgroundResource(R.drawable.bg_item_global_broadcast_history_v8);
                binding.broadCastText.setTextColor(Color.parseColor("#ffea3c"));
                binding.userName.setTextColor(Color.parseColor("#ffea3c"));
                binding.createTime.setTextColor(Color.parseColor("#ffea3c"));
                break;
            case 9:
                binding.bgContent.setBackgroundResource(R.drawable.bg_item_global_broadcast_history9);
                binding.broadCastText.setTextColor(Color.parseColor("#925D03"));
                binding.userName.setTextColor(Color.parseColor("#925D03"));
                binding.createTime.setTextColor(Color.parseColor("#925D03"));
                break;
            case 10:
                binding.bgContent.setBackgroundResource(R.drawable.bg_item_global_broadcast_history10);
                binding.broadCastText.setTextColor(Color.parseColor("#8B4908"));
                binding.userName.setTextColor(Color.parseColor("#8B4908"));
                binding.createTime.setTextColor(Color.parseColor("#8B4908"));
                break;
            default:
                if (i > 10) {
                    binding.bgContent.setBackgroundResource(R.drawable.bg_item_global_broadcast_history10);
                    binding.broadCastText.setTextColor(Color.parseColor("#8B4908"));
                    binding.userName.setTextColor(Color.parseColor("#8B4908"));
                    binding.createTime.setTextColor(Color.parseColor("#8B4908"));
                    break;
                } else {
                    binding.bgContent.setBackgroundResource(R.drawable.bg_item_global_broadcast_history);
                    binding.broadCastText.setTextColor(Color.parseColor("#171717"));
                    binding.userName.setTextColor(Color.parseColor("#999999"));
                    binding.createTime.setTextColor(Color.parseColor("#999999"));
                    break;
                }
        }
        if (i > 0) {
            binding.iconVip1.setVisibility(8);
            binding.iconNoble.setVisibility(0);
            binding.iconNoble.setImageDrawable(androidx.core.content.a.getDrawable(getContext(), UserService.INSTANCE.getNobleDrawableRes(i)));
            return;
        }
        binding.iconNoble.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemGlobalBroadcastHistoryBinding> holder, @NotNull GlobalBroadCastBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGlobalBroadcastHistoryBinding");
        ItemGlobalBroadcastHistoryBinding itemGlobalBroadcastHistoryBinding = (ItemGlobalBroadcastHistoryBinding) dataBinding;
        CircleImageView circleImageView = itemGlobalBroadcastHistoryBinding.userAvatar;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "userAvatar");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        String avatar = item.getUser().getAvatar();
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(39));
        fill.setHeight(dimens.dpToPx(39));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind$default(circleImageView, companion.displayUserAvatarImage(avatar, fill), null, 2, null);
        ImageView imageView = itemGlobalBroadcastHistoryBinding.countryImage;
        Intrinsics.checkNotNullExpressionValue(imageView, "countryImage");
        ImageKtxKt.loadImage$default(imageView, item.getUser().getCountryImage(), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65534, (Object) null);
        itemGlobalBroadcastHistoryBinding.broadCastText.setText(item.getMsg());
        itemGlobalBroadcastHistoryBinding.createTime.setText(DateTimeUtilityKt.getGroupDateString(getContext(), item.getCreatedTime()));
        TextView textView = itemGlobalBroadcastHistoryBinding.userName;
        String name = item.getUser().getName();
        if (name == null) {
            name = "";
        }
        textView.setText(name);
        itemGlobalBroadcastHistoryBinding.iconVip1.setVisibility(Intrinsics.areEqual(item.getUser().isVip(), Boolean.TRUE) ? 0 : 8);
        ImageView imageView2 = itemGlobalBroadcastHistoryBinding.iconVip1;
        Intrinsics.checkNotNullExpressionValue(imageView2, "iconVip1");
        ImageKtxKt.loadImage$default(imageView2, (String) null, (Uri) null, (File) null, 2131233624, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        ImageView imageView3 = itemGlobalBroadcastHistoryBinding.sex;
        Intrinsics.checkNotNullExpressionValue(imageView3, "sex");
        Integer sex = item.getUser().getSex();
        ImageKtxKt.loadImage$default(imageView3, (String) null, (Uri) null, (File) null, Integer.valueOf((sex != null && sex.intValue() == 1) ? R.drawable.icon_boy : R.drawable.icon_girl), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        ImageView imageView4 = itemGlobalBroadcastHistoryBinding.sex;
        Integer sex2 = item.getUser().getSex();
        imageView4.setBackgroundResource((sex2 != null && sex2.intValue() == 1) ? R.drawable.bg_age_male : R.drawable.bg_age_female);
        itemGlobalBroadcastHistoryBinding.f٦٢top.setVisibility(item.isPinned() ? 0 : 8);
        updateViewShow(item, itemGlobalBroadcastHistoryBinding);
    }
}
