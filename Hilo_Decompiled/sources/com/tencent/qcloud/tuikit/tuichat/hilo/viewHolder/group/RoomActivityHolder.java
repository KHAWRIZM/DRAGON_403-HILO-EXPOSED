package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.ActivityDetailData;
import com.qiahao.base_common.model.eventBus.LiveEvent;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.HiloUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qiahao.nextvideo.utilities.userproxy.UserProxyUtility;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloRoomActivityBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.group.RoomActivityBean;
import java.io.File;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¨\u0006\u0012"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomActivityHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloRoomActivityBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "refreshActivity", "data", "Lcom/qiahao/base_common/model/ActivityDetailData;", "binding", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nRoomActivityHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RoomActivityHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomActivityHolder\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,202:1\n1#2:203\n61#3,9:204\n*S KotlinDebug\n*F\n+ 1 RoomActivityHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/group/RoomActivityHolder\n*L\n58#1:204,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class RoomActivityHolder extends RoomEmptyBaseHolder<HiloRoomActivityBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomActivityHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutViews$lambda$3(TUIMessageBean tUIMessageBean, View view) {
        long j;
        boolean z;
        Long endAt;
        Long startAt;
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        if (hiloUtils.notFastClick()) {
            RoomActivityBean roomActivityBean = (RoomActivityBean) tUIMessageBean;
            ActivityDetailData activityData = roomActivityBean.getActivityData();
            long j2 = 0;
            if (activityData != null && (startAt = activityData.getStartAt()) != null) {
                j = startAt.longValue();
            } else {
                j = 0;
            }
            ActivityDetailData activityData2 = roomActivityBean.getActivityData();
            if (activityData2 != null && (endAt = activityData2.getEndAt()) != null) {
                j2 = endAt.longValue();
            }
            if (hiloUtils.checkActivityStart(j, j2) == 0) {
                ActivityDetailData activityData3 = roomActivityBean.getActivityData();
                if (activityData3 != null) {
                    z = Intrinsics.areEqual(activityData3.isSubscribe(), Boolean.TRUE);
                } else {
                    z = false;
                }
                if (z) {
                    cf.c.c().l(new LiveEvent("two_subscribActivity", roomActivityBean.getActivityData()));
                } else {
                    cf.c.c().l(new LiveEvent("subscribActivity", roomActivityBean.getActivityData()));
                }
            }
        }
    }

    private final void refreshActivity(ActivityDetailData data, HiloRoomActivityBinding binding) {
        long j;
        HiloUtils hiloUtils = HiloUtils.INSTANCE;
        Long startAt = data.getStartAt();
        long j2 = 0;
        if (startAt != null) {
            j = startAt.longValue();
        } else {
            j = 0;
        }
        Long endAt = data.getEndAt();
        if (endAt != null) {
            j2 = endAt.longValue();
        }
        int checkActivityStart = hiloUtils.checkActivityStart(j, j2);
        if (checkActivityStart != 0) {
            if (checkActivityStart != 1) {
                binding.interested.setBackground(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), R.drawable.shape_gradient_33ffffff_24dp));
                binding.interestedImage.setImageDrawable(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), R.drawable.activity_icon_subscribe));
                binding.interestedText.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.white));
                TextView textView = binding.interestedText;
                String format = String.format(ResourcesKtxKt.getStringById(this, R.string.activity_subscribed), Arrays.copyOf(new Object[]{Integer.valueOf(data.getPersonNum())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format);
                return;
            }
            binding.timeImage.setImageDrawable(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), R.drawable.discover_icon_start));
            binding.timeContent.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.color_ff9600));
            binding.interested.setBackground(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), R.drawable.shape_gradient_ff9600_ff7200_24dp));
            binding.interestedImage.setImageDrawable(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), R.drawable.discover_icon_online_white));
            binding.interestedText.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.white));
            TextView textView2 = binding.interestedText;
            String format2 = String.format(ResourcesKtxKt.getStringById(this, R.string.activity_now), Arrays.copyOf(new Object[]{Integer.valueOf(data.getPersonNum())}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            textView2.setText(format2);
            return;
        }
        binding.timeImage.setImageDrawable(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), R.drawable.discover_time_ash));
        binding.timeContent.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.color_7fffffff));
        if (Intrinsics.areEqual(data.isSubscribe(), Boolean.FALSE)) {
            binding.interested.setBackground(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), R.drawable.shape_gradient_b043ff_6f2df7_24dp));
            binding.interestedImage.setImageDrawable(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), R.drawable.activity_icon_subscribe));
            binding.interestedText.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.white));
            TextView textView3 = binding.interestedText;
            String format3 = String.format(ResourcesKtxKt.getStringById(this, R.string.activity_subscription), Arrays.copyOf(new Object[]{Integer.valueOf(data.getPersonNum())}, 1));
            Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
            textView3.setText(format3);
            return;
        }
        binding.interested.setBackground(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), R.drawable.shape_gradient_33ffffff_24dp));
        binding.interestedImage.setImageDrawable(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), R.drawable.activity_icon_subscribe));
        binding.interestedText.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.white));
        TextView textView4 = binding.interestedText;
        String format4 = String.format(ResourcesKtxKt.getStringById(this, R.string.activity_subscribed), Arrays.copyOf(new Object[]{Integer.valueOf(data.getPersonNum())}, 1));
        Intrinsics.checkNotNullExpressionValue(format4, "format(...)");
        textView4.setText(format4);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEmptyBaseHolder, com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable final TUIMessageBean msg, int position) {
        LinearLayout linearLayout;
        final View root;
        ImageView imageView;
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        long j;
        AppCompatTextView appCompatTextView3;
        ImageView imageView2;
        super.layoutViews(msg, position);
        if (!(msg instanceof RoomActivityBean)) {
            return;
        }
        RoomActivityBean roomActivityBean = (RoomActivityBean) msg;
        ActivityDetailData activityData = roomActivityBean.getActivityData();
        if (activityData != null) {
            activityData.setMessageId(roomActivityBean.getV2TIMMessage().getMsgID());
            HiloRoomActivityBinding binding = getBinding();
            if (binding != null && (imageView2 = binding.stateImage) != null) {
                imageView2.setImageDrawable(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), activityData.getActivityTypeIcon()));
            }
            HiloRoomActivityBinding binding2 = getBinding();
            if (binding2 != null && (appCompatTextView3 = binding2.stateContent) != null) {
                appCompatTextView3.setText(activityData.getActivityTypeText());
            }
            HiloRoomActivityBinding binding3 = getBinding();
            if (binding3 != null && (appCompatTextView2 = binding3.timeContent) != null) {
                HiloUtils hiloUtils = HiloUtils.INSTANCE;
                Long startAt = activityData.getStartAt();
                long j2 = 0;
                if (startAt != null) {
                    j = startAt.longValue();
                } else {
                    j = 0;
                }
                Long endAt = activityData.getEndAt();
                if (endAt != null) {
                    j2 = endAt.longValue();
                }
                appCompatTextView2.setText(hiloUtils.formatActivityTime(j, j2));
            }
            HiloRoomActivityBinding binding4 = getBinding();
            if (binding4 != null && (appCompatTextView = binding4.title) != null) {
                appCompatTextView.setText(activityData.getTheme());
            }
            HiloRoomActivityBinding binding5 = getBinding();
            if (binding5 != null && (imageView = binding5.image) != null) {
                String imageSize = ImageSizeKt.imageSize(activityData.getBanner(), UiKtxKt.toPX(UserProxyUtility.cpUpgrades));
                int i = R.drawable.group_placeholde;
                ImageKtxKt.loadImage$default(imageView, imageSize, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (o4.j) null, (Integer) null, (Integer) null, (Boolean) null, Integer.valueOf(i), Integer.valueOf(i), (c5.g) null, 40958, (Object) null);
            }
            HiloRoomActivityBinding binding6 = getBinding();
            if (binding6 != null) {
                refreshActivity(activityData, binding6);
            }
        }
        HiloRoomActivityBinding binding7 = getBinding();
        if (binding7 != null && (root = binding7.getRoot()) != null) {
            final long j3 = 800;
            root.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomActivityHolder$layoutViews$$inlined$singleClick$default$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j3 || (root instanceof Checkable)) {
                        ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                        BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                        ActivityDetailData activityData2 = ((RoomActivityBean) msg).getActivityData();
                        if (activityData2 == null || (str = activityData2.getId()) == null) {
                            str = "";
                        }
                        baseControlUtils.openActivityDetail(str);
                    }
                }
            });
        }
        HiloRoomActivityBinding binding8 = getBinding();
        if (binding8 != null && (linearLayout = binding8.interested) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomActivityHolder.layoutViews$lambda$3(TUIMessageBean.this, view);
                }
            });
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.group.RoomEmptyBaseHolder
    @NotNull
    public HiloRoomActivityBinding inflateViewBinding() {
        HiloRoomActivityBinding inflate = HiloRoomActivityBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
