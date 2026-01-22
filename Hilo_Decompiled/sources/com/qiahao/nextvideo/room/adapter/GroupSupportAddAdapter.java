package com.qiahao.nextvideo.room.adapter;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.databinding.ViewDataBinding;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.nextvideo.data.model.MemberBean;
import com.qiahao.nextvideo.databinding.ItemGroupSupportBinding;
import com.qiahao.nextvideo.ui.reusable.CircleImageView;
import com.qiahao.nextvideo.ui.reusable.uimodels.ImageUIModel;
import com.qiahao.nextvideo.utilities.ViewUtilitiesKt;
import com.qiahao.nextvideo.utilities.alicloud.oss.ResizeMode;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \r2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0015¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/GroupSupportAddAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/MemberBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemGroupSupportBinding;", "layoutResId", "", "<init>", "(I)V", "convert", "", "holder", "item", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGroupSupportAddAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupSupportAddAdapter.kt\ncom/qiahao/nextvideo/room/adapter/GroupSupportAddAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,51:1\n1#2:52\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupSupportAddAdapter extends BaseQuickAdapter<MemberBean, BaseDataBindingHolder<ItemGroupSupportBinding>> {

    @NotNull
    private static final String TAG = "GroupSupportAddAdapter";

    public GroupSupportAddAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"SetTextI18n"})
    public void convert(@NotNull BaseDataBindingHolder<ItemGroupSupportBinding> holder, @NotNull MemberBean item) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemGroupSupportBinding");
        ItemGroupSupportBinding itemGroupSupportBinding = (ItemGroupSupportBinding) dataBinding;
        Log.d(TAG, "convert: ---");
        if (item.getCode().length() == 0) {
            itemGroupSupportBinding.emptyPosition.setText(String.valueOf(holder.getAdapterPosition() + 1));
            itemGroupSupportBinding.llOwner.setVisibility(8);
            itemGroupSupportBinding.llAdd.setVisibility(0);
            return;
        }
        itemGroupSupportBinding.llOwner.setVisibility(0);
        itemGroupSupportBinding.llAdd.setVisibility(8);
        itemGroupSupportBinding.position.setText(String.valueOf(holder.getAdapterPosition() + 1));
        CircleImageView circleImageView = itemGroupSupportBinding.ownerAvatar;
        Intrinsics.checkNotNullExpressionValue(circleImageView, "ownerAvatar");
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        String avatar = item.getAvatar();
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.dpToPx(38));
        fill.setHeight(dimens.dpToPx(38));
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind$default(circleImageView, companion.displayUserAvatarImage(avatar, fill), null, 2, null);
        if (!TextUtils.isEmpty(item.getNick())) {
            itemGroupSupportBinding.ownerName.setText(item.getNick());
        }
        itemGroupSupportBinding.ownerId.setText(getContext().getString(2131953102, item.getCode()));
    }
}
