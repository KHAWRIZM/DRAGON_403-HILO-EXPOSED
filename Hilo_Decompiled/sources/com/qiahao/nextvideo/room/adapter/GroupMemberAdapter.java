package com.qiahao.nextvideo.room.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.a;
import c5.g;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.qiahao.base_common.model.common.NobleInfo;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.data.model.RoleMember;
import com.qiahao.nextvideo.data.service.GroupService;
import com.qiahao.nextvideo.data.service.UserService;
import com.qiahao.nextvideo.room.manager.MeetingRoomManager;
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
import o4.j;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0014¨\u0006\f"}, d2 = {"Lcom/qiahao/nextvideo/room/adapter/GroupMemberAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/qiahao/nextvideo/data/model/RoleMember;", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "layout", "", "<init>", "(I)V", "convert", "", "holder", "item", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class GroupMemberAdapter extends BaseQuickAdapter<RoleMember, BaseViewHolder> {
    public GroupMemberAdapter(int i) {
        super(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void convert(@NotNull BaseViewHolder holder, @NotNull RoleMember item) {
        ImageView imageView;
        int i;
        ImageView imageView2;
        int i2;
        Integer level;
        Integer level2;
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(item, "item");
        AppCompatImageView view = holder.getView(R.id.member_tag);
        View view2 = holder.getView(R.id.online_status);
        CircleImageView circleImageView = (CircleImageView) holder.getView(R.id.avatar_circle);
        ImageView imageView3 = (ImageView) holder.getView(2131363182);
        ImageView imageView4 = (ImageView) holder.getView(2131363173);
        ImageUIModel.Companion companion = ImageUIModel.INSTANCE;
        String avatar = item.getAvatar();
        ResizeMode.FILL fill = ResizeMode.FILL.INSTANCE;
        Dimens dimens = Dimens.INSTANCE;
        fill.setWidth(dimens.getMediumAvatarSize());
        fill.setHeight(dimens.getMediumAvatarSize());
        Unit unit = Unit.INSTANCE;
        ViewUtilitiesKt.bind$default(circleImageView, companion.displayUserAvatarImage(avatar, fill), null, 2, null);
        if (GroupService.INSTANCE.userIsOnline(item.getOnlineStatus())) {
            view2.setVisibility(0);
        } else {
            view2.setVisibility(8);
        }
        if (item.getRole() > 0) {
            view.setVisibility(0);
            imageView = imageView3;
            ImageKtxKt.loadImage$default(view, (String) null, (Uri) null, (File) null, Integer.valueOf(MeetingRoomManager.INSTANCE.getLevelRes(item.getRole())), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (g) null, 65527, (Object) null);
            i = 8;
        } else {
            imageView = imageView3;
            i = 8;
            view.setVisibility(8);
        }
        if (item.isVip()) {
            imageView2 = imageView;
            i2 = 0;
            imageView2.setVisibility(0);
            view.setVisibility(i);
        } else {
            imageView2 = imageView;
            i2 = 0;
            imageView2.setVisibility(i);
        }
        NobleInfo noble = item.getNoble();
        if (((noble == null || (level2 = noble.getLevel()) == null) ? 0 : level2.intValue()) > 0) {
            imageView2.setVisibility(i);
            imageView4.setVisibility(i2);
            Context context = getContext();
            UserService.Companion companion2 = UserService.INSTANCE;
            NobleInfo noble2 = item.getNoble();
            imageView4.setImageDrawable(a.getDrawable(context, companion2.getNobleDrawableRes((noble2 == null || (level = noble2.getLevel()) == null) ? 0 : level.intValue())));
            return;
        }
        imageView4.setVisibility(i);
    }
}
