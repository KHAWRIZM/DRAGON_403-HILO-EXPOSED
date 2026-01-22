package com.qiahao.nextvideo.room.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import androidx.core.content.a;
import androidx.databinding.ViewDataBinding;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.utils.SvipTypeUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.data.model.CurrentRoomOnlineBean;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.databinding.ItemRoomOnlineMemberBinding;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014¨\u0006\r"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/GroupMemberRoomOnlineAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/CurrentRoomOnlineBean;", "Lcom/chad/library/adapter/base/viewholder/BaseDataBindingHolder;", "Lcom/qiahao/nextvideo/databinding/ItemRoomOnlineMemberBinding;", "layoutRes", "", "<init>", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nGroupMemberRoomOnlineAdapter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 GroupMemberRoomOnlineAdapter.kt\ncom/qiahao/nextvideo/room/adapter/GroupMemberRoomOnlineAdapter\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,62:1\n1#2:63\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupMemberRoomOnlineAdapter extends BaseQuickAdapter<CurrentRoomOnlineBean, BaseDataBindingHolder<ItemRoomOnlineMemberBinding>> {
    public GroupMemberRoomOnlineAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseDataBindingHolder<ItemRoomOnlineMemberBinding> holder, @NotNull CurrentRoomOnlineBean item) {
        Integer level;
        Integer level2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        ViewDataBinding dataBinding = holder.getDataBinding();
        Intrinsics.checkNotNull(dataBinding, "null cannot be cast to non-null type com.qiahao.nextvideo.databinding.ItemRoomOnlineMemberBinding");
        ItemRoomOnlineMemberBinding itemRoomOnlineMemberBinding = (ItemRoomOnlineMemberBinding) dataBinding;
        QMUIRadiusImageView qMUIRadiusImageView = itemRoomOnlineMemberBinding.avatarCircle;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView, "avatarCircle");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(item.getAvatar()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, 2131231655, (g) null, 49150, (Object) null);
        if (Intrinsics.areEqual(item.isVip(), Boolean.TRUE)) {
            itemRoomOnlineMemberBinding.iconVip.setVisibility(0);
        } else {
            itemRoomOnlineMemberBinding.iconVip.setVisibility(8);
        }
        NobleInfo noble = item.getNoble();
        if (((noble == null || (level2 = noble.getLevel()) == null) ? 0 : level2.intValue()) > 0) {
            itemRoomOnlineMemberBinding.iconVip.setVisibility(8);
            itemRoomOnlineMemberBinding.iconNoble.setVisibility(0);
            ImageView imageView = itemRoomOnlineMemberBinding.iconNoble;
            Context context = getContext();
            UserService.Companion companion = UserService.INSTANCE;
            NobleInfo noble2 = item.getNoble();
            imageView.setImageDrawable(a.getDrawable(context, companion.getNobleDrawableRes((noble2 == null || (level = noble2.getLevel()) == null) ? 0 : level.intValue())));
        } else {
            itemRoomOnlineMemberBinding.iconNoble.setVisibility(4);
        }
        SvipData svip = item.getSvip();
        if ((svip != null ? svip.getSvipLevel() : 0) > 0) {
            itemRoomOnlineMemberBinding.iconVip.setVisibility(8);
            itemRoomOnlineMemberBinding.iconNoble.setVisibility(8);
            itemRoomOnlineMemberBinding.iconSvip.setVisibility(0);
            SvipTypeUtils svipTypeUtils = SvipTypeUtils.INSTANCE;
            SvipData svip2 = item.getSvip();
            Integer svipMedal = svipTypeUtils.getSvipMedal(svip2 != null ? Integer.valueOf(svip2.getSvipLevel()) : null);
            if (svipMedal != null) {
                itemRoomOnlineMemberBinding.iconSvip.setImageDrawable(a.getDrawable(itemRoomOnlineMemberBinding.getRoot().getContext(), svipMedal.intValue()));
            }
        } else {
            itemRoomOnlineMemberBinding.iconSvip.setVisibility(8);
        }
        SvipData svip3 = item.getSvip();
        if (svip3 == null || !svip3.isMystery()) {
            return;
        }
        QMUIRadiusImageView qMUIRadiusImageView2 = itemRoomOnlineMemberBinding.avatarCircle;
        Intrinsics.checkNotNullExpressionValue(qMUIRadiusImageView2, "avatarCircle");
        ImageKtxKt.loadImage$default(qMUIRadiusImageView2, (String) null, (Uri) null, (File) null, 2131232937, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
        itemRoomOnlineMemberBinding.iconSvip.setVisibility(8);
        itemRoomOnlineMemberBinding.iconVip.setVisibility(8);
        itemRoomOnlineMemberBinding.iconNoble.setVisibility(8);
    }
}
