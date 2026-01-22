package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.strange;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.base_common.utils.ShapeUtil;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloStrangeMessagePlayTipBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.MessageEmptyBaseHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/strange/StrangePlayTipMessageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/MessageEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloStrangeMessagePlayTipBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStrangePlayTipMessageHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 StrangePlayTipMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/strange/StrangePlayTipMessageHolder\n+ 2 Color.kt\nandroidx/core/graphics/ColorKt\n*L\n1#1,40:1\n439#2:41\n439#2:42\n439#2:43\n439#2:44\n*S KotlinDebug\n*F\n+ 1 StrangePlayTipMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/strange/StrangePlayTipMessageHolder\n*L\n30#1:41\n31#1:42\n34#1:43\n35#1:44\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class StrangePlayTipMessageHolder extends MessageEmptyBaseHolder<HiloStrangeMessagePlayTipBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StrangePlayTipMessageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable TUIMessageBean msg, int position) {
        TextView textView;
        TextView textView2;
        ConstraintLayout constraintLayout;
        TextView textView3;
        TextView textView4;
        ConstraintLayout constraintLayout2;
        super.layoutViews(msg, position);
        TextView textView5 = this.chatTimeText;
        if (textView5 != null) {
            textView5.setVisibility(8);
        }
        if (checkStrange()) {
            HiloStrangeMessagePlayTipBinding binding = getBinding();
            if (binding != null && (constraintLayout2 = binding.allContent) != null) {
                constraintLayout2.setBackground(ShapeUtil.createShape$default(ShapeUtil.INSTANCE, "#19FFFFFF", "#19FFFFFF", 8, (GradientDrawable.Orientation) null, 8, (Object) null));
            }
            HiloStrangeMessagePlayTipBinding binding2 = getBinding();
            if (binding2 != null && (textView4 = binding2.title) != null) {
                textView4.setTextColor(Color.parseColor("#ffffff"));
            }
            HiloStrangeMessagePlayTipBinding binding3 = getBinding();
            if (binding3 != null && (textView3 = binding3.content) != null) {
                textView3.setTextColor(Color.parseColor("#DDDDDD"));
                return;
            }
            return;
        }
        HiloStrangeMessagePlayTipBinding binding4 = getBinding();
        if (binding4 != null && (constraintLayout = binding4.allContent) != null) {
            constraintLayout.setBackground(ShapeUtil.createShapeStroke$default(ShapeUtil.INSTANCE, "#EEEEEE", 8, 1.0f, false, "#FFFFFF", (String) null, (GradientDrawable.Orientation) null, 104, (Object) null));
        }
        HiloStrangeMessagePlayTipBinding binding5 = getBinding();
        if (binding5 != null && (textView2 = binding5.title) != null) {
            textView2.setTextColor(Color.parseColor("#333333"));
        }
        HiloStrangeMessagePlayTipBinding binding6 = getBinding();
        if (binding6 != null && (textView = binding6.content) != null) {
            textView.setTextColor(Color.parseColor("#666666"));
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.MessageEmptyBaseHolder
    @NotNull
    public HiloStrangeMessagePlayTipBinding inflateViewBinding() {
        HiloStrangeMessagePlayTipBinding inflate = HiloStrangeMessagePlayTipBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
