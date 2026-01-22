package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.AllModuleServiceManager;
import com.qiahao.base_common.model.im.GroupRoomImCustomBean;
import com.qiahao.base_common.model.svip.SvipData;
import com.qiahao.base_common.service.BaseService;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.OnItemClickListener;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomUserEnterBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomUserEnterBean;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomUserEnterHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomUserEnterBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomUserEnterHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomUserEnterHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomUserEnterHolder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,43:1\n1#2:44\n61#3,9:45\n*S KotlinDebug\n*F\n+ 1 RoomUserEnterHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomUserEnterHolder\n*L\n33#1:45,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomUserEnterHolder extends RoomEmptyBaseHolder<HiloRoomUserEnterBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomUserEnterHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEmptyBaseHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable final TUIMessageBean msg, int position) {
        String str;
        TextView textView;
        TextView textView2;
        final NickTextView nickTextView;
        NickTextView nickTextView2;
        int i;
        int i2;
        Integer nobleLevel;
        SvipData svip;
        int i3;
        NickTextView nickTextView3;
        Integer nobleLevel2;
        SvipData svip2;
        String str2;
        SvipData svip3;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomUserEnterBean)) {
            return;
        }
        try {
            GroupRoomImCustomBean data = ((RoomUserEnterBean) msg).getData();
            if (data != null && (svip2 = data.getSvip()) != null && svip2.isMystery()) {
                String stringById = ResourcesKtxKt.getStringById(this, R.string.mystery_name);
                GroupRoomImCustomBean data2 = ((RoomUserEnterBean) msg).getData();
                if (data2 != null && (svip3 = data2.getSvip()) != null) {
                    str2 = svip3.mysteryNumber();
                } else {
                    str2 = null;
                }
                str = String.format(stringById, Arrays.copyOf(new Object[]{str2}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            } else {
                GroupRoomImCustomBean data3 = ((RoomUserEnterBean) msg).getData();
                if (data3 != null) {
                    str = data3.getNick();
                } else {
                    str = null;
                }
            }
            BaseService appService = AllModuleServiceManager.Companion.get().getAppService();
            if (appService != null) {
                GroupRoomImCustomBean data4 = ((RoomUserEnterBean) msg).getData();
                if (data4 != null && (nobleLevel2 = data4.getNobleLevel()) != null) {
                    i3 = nobleLevel2.intValue();
                } else {
                    i3 = 0;
                }
                int nobleColor$default = BaseService.getNobleColor$default(appService, i3, 0, 2, (Object) null);
                HiloRoomUserEnterBinding binding = getBinding();
                if (binding != null && (nickTextView3 = binding.nick) != null) {
                    nickTextView3.setTextColor(nobleColor$default);
                }
            }
            HiloRoomUserEnterBinding binding2 = getBinding();
            if (binding2 != null && (nickTextView2 = binding2.nick) != null) {
                GroupRoomImCustomBean data5 = ((RoomUserEnterBean) msg).getData();
                if (data5 != null && (svip = data5.getSvip()) != null) {
                    i = svip.getSvipLevel();
                } else {
                    i = 0;
                }
                GroupRoomImCustomBean data6 = ((RoomUserEnterBean) msg).getData();
                if (data6 != null && (nobleLevel = data6.getNobleLevel()) != null) {
                    i2 = nobleLevel.intValue();
                } else {
                    i2 = 0;
                }
                nickTextView2.setSVipAndNoble(str, i, i2);
            }
            HiloRoomUserEnterBinding binding3 = getBinding();
            if (binding3 != null && (nickTextView = binding3.nick) != null) {
                final long j = 800;
                nickTextView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomUserEnterHolder$layoutViews$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        OnItemClickListener onItemClickListener;
                        String str3;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(nickTextView) > j || (nickTextView instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(nickTextView, currentTimeMillis);
                            NickTextView nickTextView4 = nickTextView;
                            onItemClickListener = ((MessageBaseHolder) this).onItemClickListener;
                            if (onItemClickListener != null) {
                                GroupRoomImCustomBean data7 = ((RoomUserEnterBean) msg).getData();
                                if (data7 != null) {
                                    str3 = data7.getExternalId();
                                } else {
                                    str3 = null;
                                }
                                onItemClickListener.onType(5, str3);
                            }
                        }
                    }
                });
            }
            HiloRoomUserEnterBinding binding4 = getBinding();
            if (binding4 != null && (textView2 = binding4.contentText) != null) {
                textView2.setTextColor(-1);
            }
            HiloRoomUserEnterBinding binding5 = getBinding();
            if (binding5 != null && (textView = binding5.contentText) != null) {
                String format = String.format(ResourcesKtxKt.getStringById(this, R.string.nick_coming), Arrays.copyOf(new Object[]{""}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEmptyBaseHolder
    @NotNull
    public HiloRoomUserEnterBinding inflateViewBinding() {
        HiloRoomUserEnterBinding inflate = HiloRoomUserEnterBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
