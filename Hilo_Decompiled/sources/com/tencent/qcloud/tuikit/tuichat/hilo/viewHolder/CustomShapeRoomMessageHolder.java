package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.InviteEnterRoomMessage;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageShareRoomBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.InviteEnterRoomMessageBean;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomShapeRoomMessageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/HiloMessageContentHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloMessageShareRoomBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutVariableViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomShapeRoomMessageHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomShapeRoomMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomShapeRoomMessageHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,35:1\n61#2,9:36\n*S KotlinDebug\n*F\n+ 1 CustomShapeRoomMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomShapeRoomMessageHolder\n*L\n28#1:36,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class CustomShapeRoomMessageHolder extends HiloMessageContentHolder<HiloMessageShareRoomBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomShapeRoomMessageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(@Nullable final TUIMessageBean msg, int position) {
        final View root;
        QMUIRadiusImageView qMUIRadiusImageView;
        String str;
        if (msg instanceof InviteEnterRoomMessageBean) {
            HiloMessageShareRoomBinding binding = getBinding();
            if (binding != null && (qMUIRadiusImageView = binding.imageRoomAvatar) != null) {
                InviteEnterRoomMessage messageData = ((InviteEnterRoomMessageBean) msg).getMessageData();
                if (messageData != null) {
                    str = messageData.getGroupFaceUrl();
                } else {
                    str = null;
                }
                ImageKtxKt.loadImage$default(qMUIRadiusImageView, ImageSizeKt.image100(str), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.group_placeholde), (c5.g) null, 49150, (Object) null);
            }
            HiloMessageShareRoomBinding binding2 = getBinding();
            if (binding2 != null && (root = binding2.getRoot()) != null) {
                final long j = 800;
                root.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomShapeRoomMessageHolder$layoutVariableViews$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        String str2;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            InviteEnterRoomMessage messageData2 = ((InviteEnterRoomMessageBean) msg).getMessageData();
                            if (messageData2 == null || (str2 = messageData2.getGroupId()) == null) {
                                str2 = "";
                            }
                            baseControlUtils.openRoom(str2);
                        }
                    }
                });
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.HiloMessageContentHolder
    @NotNull
    public HiloMessageShareRoomBinding inflateViewBinding() {
        HiloMessageShareRoomBinding inflate = HiloMessageShareRoomBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
