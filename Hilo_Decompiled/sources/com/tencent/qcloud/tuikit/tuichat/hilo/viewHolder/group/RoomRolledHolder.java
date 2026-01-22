package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.utils.Dimens;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.nextvideo.ui.family.FamilySettingFragment;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomRolledBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomRolledBean;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0002¨\u0006\u0013"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomRolledHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/HiloRoomContentHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomRolledBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "createRolledImageView", "rollerLinearLayout", "Landroid/widget/LinearLayout;", FamilySettingFragment.FAMILY_NUMBER, "getRollResource", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomRolledHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomRolledHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomRolledHolder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,71:1\n1#2:72\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomRolledHolder extends HiloRoomContentHolder<HiloRoomRolledBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomRolledHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    private final View createRolledImageView(LinearLayout rollerLinearLayout, int number) {
        ImageView imageView = new ImageView(((RecyclerView.ViewHolder) this).itemView.getContext());
        rollerLinearLayout.addView(imageView);
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        Dimens dimens = Dimens.INSTANCE;
        layoutParams2.width = dimens.dpToPx(14);
        layoutParams2.height = dimens.dpToPx(16);
        layoutParams2.setMarginStart(dimens.dpToPx(8));
        imageView.setLayoutParams(layoutParams2);
        ImageKtxKt.loadImage$default(imageView, (String) null, (Uri) null, (File) null, Integer.valueOf(getRollResource(number)), (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, (Integer) null, (c5.g) null, 65527, (Object) null);
        return imageView;
    }

    private final int getRollResource(int number) {
        switch (number) {
            case 0:
                return R.drawable.icon_dice0;
            case 1:
                return R.drawable.icon_dice1;
            case 2:
                return R.drawable.icon_dice2;
            case 3:
                return R.drawable.icon_dice3;
            case 4:
                return R.drawable.icon_dice4;
            case 5:
                return R.drawable.icon_dice5;
            case 6:
                return R.drawable.icon_dice6;
            case 7:
                return R.drawable.icon_dice7;
            case 8:
                return R.drawable.icon_dice8;
            case 9:
                return R.drawable.icon_dice9;
            default:
                return R.drawable.icon_dice0;
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable TUIMessageBean msg, int position) {
        int i;
        int i2;
        LinearLayout linearLayout;
        ArrayList dices;
        Integer num;
        ArrayList dices2;
        LinearLayout linearLayout2;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomRolledBean)) {
            return;
        }
        HiloRoomRolledBinding binding = getBinding();
        if (binding != null && (linearLayout2 = binding.rollerNumber) != null) {
            linearLayout2.removeAllViews();
        }
        RoomRolledBean roomRolledBean = (RoomRolledBean) msg;
        GroupRoomImCustomBean data = roomRolledBean.getData();
        if (data != null && (dices2 = data.getDices()) != null) {
            i = dices2.size();
        } else {
            i = 0;
        }
        for (int i3 = 0; i3 < i; i3++) {
            GroupRoomImCustomBean data2 = roomRolledBean.getData();
            if (data2 != null && (dices = data2.getDices()) != null && (num = (Integer) dices.get(i3)) != null) {
                i2 = num.intValue();
            } else {
                i2 = 0;
            }
            HiloRoomRolledBinding binding2 = getBinding();
            if (binding2 != null && (linearLayout = binding2.rollerNumber) != null) {
                createRolledImageView(linearLayout, i2);
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.HiloRoomContentHolder
    @NotNull
    public HiloRoomRolledBinding inflateViewBinding() {
        HiloRoomRolledBinding inflate = HiloRoomRolledBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
