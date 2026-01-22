package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.LikeMessage;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.ShapeUtil;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageLikeBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.LikeMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMCheckDataListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomLikeMessageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/MessageEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloMessageLikeBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomLikeMessageHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomLikeMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomLikeMessageHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,110:1\n61#2,9:111\n*S KotlinDebug\n*F\n+ 1 CustomLikeMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomLikeMessageHolder\n*L\n95#1:111,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class CustomLikeMessageHolder extends MessageEmptyBaseHolder<HiloMessageLikeBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomLikeMessageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutViews$lambda$1(TUIMessageBean tUIMessageBean, View view) {
        BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
        String sender = ((LikeMessageBean) tUIMessageBean).getSender();
        Intrinsics.checkNotNullExpressionValue(sender, "getSender(...)");
        baseControlUtils.openPersonPage(sender);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0074, code lost:
    
        if (r2 == null) goto L٣٢;
     */
    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutViews(@Nullable final TUIMessageBean msg, int position) {
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        UserIconView userIconView;
        LikeMessage messageData;
        TextView textView3;
        Integer giftType;
        UserIconView userIconView2;
        UserIconView userIconView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        UserIconView userIconView4;
        final UserIconView userIconView5;
        TextView textView7;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        LinearLayout linearLayout2;
        UserIconView userIconView6;
        LikeMessage messageData2;
        TextView textView12;
        Integer giftType2;
        UserIconView userIconView7;
        UserIconView userIconView8;
        String str;
        UserIconView userIconView9;
        UserIconView userIconView10;
        LinearLayout linearLayout3;
        super.layoutViews(msg, position);
        if (msg instanceof LikeMessageBean) {
            HiloMessageLikeBinding binding = getBinding();
            ViewGroup.LayoutParams layoutParams = (binding == null || (linearLayout3 = binding.msgContentLl) == null) ? null : linearLayout3.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            if (this.properties.getAvatarRadius() != 0) {
                HiloMessageLikeBinding binding2 = getBinding();
                if (binding2 != null && (userIconView10 = binding2.leftUserIconView) != null) {
                    userIconView10.setRadius(this.properties.getAvatarRadius());
                }
                HiloMessageLikeBinding binding3 = getBinding();
                if (binding3 != null && (userIconView9 = binding3.rightUserIconView) != null) {
                    userIconView9.setRadius(this.properties.getAvatarRadius());
                }
            }
            ArrayList arrayList = new ArrayList();
            if (checkStrange()) {
                IMCheckDataListener iMCheckDataListener = this.onItemDateListener;
                if (iMCheckDataListener != null) {
                    str = iMCheckDataListener.checkString(((LikeMessageBean) msg).isSelf() ? "avatarMy" : "avatarReceive");
                }
                str = "";
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            } else {
                String faceUrl = ((LikeMessageBean) msg).getFaceUrl();
                Intrinsics.checkNotNullExpressionValue(faceUrl, "getFaceUrl(...)");
                arrayList.add(faceUrl);
            }
            LikeMessageBean likeMessageBean = (LikeMessageBean) msg;
            if (likeMessageBean.isSelf()) {
                bVar.G = 1.0f;
                HiloMessageLikeBinding binding4 = getBinding();
                if (binding4 != null && (userIconView8 = binding4.leftUserIconView) != null) {
                    userIconView8.setVisibility(4);
                }
                HiloMessageLikeBinding binding5 = getBinding();
                if (binding5 != null && (userIconView7 = binding5.rightUserIconView) != null) {
                    userIconView7.setVisibility(0);
                }
                LikeMessage messageData3 = likeMessageBean.getMessageData();
                if ((messageData3 != null ? messageData3.getGiftType() : null) != null && ((messageData2 = likeMessageBean.getMessageData()) == null || (giftType2 = messageData2.getGiftType()) == null || giftType2.intValue() != 0)) {
                    HiloMessageLikeBinding binding6 = getBinding();
                    if (binding6 != null && (textView12 = binding6.messageContainer) != null) {
                        textView12.setVisibility(8);
                    }
                } else {
                    HiloMessageLikeBinding binding7 = getBinding();
                    if (binding7 != null && (textView11 = binding7.messageContainer) != null) {
                        textView11.setText(ResourcesKtxKt.getStringById(this, R.string.super_like_tip));
                    }
                    HiloMessageLikeBinding binding8 = getBinding();
                    if (binding8 != null && (textView10 = binding8.messageContainer) != null) {
                        textView10.setVisibility(0);
                    }
                }
                HiloMessageLikeBinding binding9 = getBinding();
                if (binding9 != null && (userIconView6 = binding9.rightUserIconView) != null) {
                    userIconView6.setIconUrls(arrayList);
                }
                HiloMessageLikeBinding binding10 = getBinding();
                if (binding10 != null && (linearLayout2 = binding10.msgContentLl) != null) {
                    linearLayout2.setBackground(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), checkStrange() ? R.drawable.strange_bubble_right : R.drawable.rc_ic_bubble_right1));
                }
            } else {
                bVar.G = 0.0f;
                HiloMessageLikeBinding binding11 = getBinding();
                if (binding11 != null && (userIconView3 = binding11.leftUserIconView) != null) {
                    userIconView3.setVisibility(0);
                }
                HiloMessageLikeBinding binding12 = getBinding();
                if (binding12 != null && (userIconView2 = binding12.rightUserIconView) != null) {
                    userIconView2.setVisibility(4);
                }
                LikeMessage messageData4 = likeMessageBean.getMessageData();
                if ((messageData4 != null ? messageData4.getGiftType() : null) != null && ((messageData = likeMessageBean.getMessageData()) == null || (giftType = messageData.getGiftType()) == null || giftType.intValue() != 0)) {
                    HiloMessageLikeBinding binding13 = getBinding();
                    if (binding13 != null && (textView3 = binding13.messageContainer) != null) {
                        textView3.setVisibility(8);
                    }
                } else {
                    HiloMessageLikeBinding binding14 = getBinding();
                    if (binding14 != null && (textView2 = binding14.messageContainer) != null) {
                        textView2.setText(ResourcesKtxKt.getStringById(this, R.string.super_like_tip));
                    }
                    HiloMessageLikeBinding binding15 = getBinding();
                    if (binding15 != null && (textView = binding15.messageContainer) != null) {
                        textView.setVisibility(0);
                    }
                }
                HiloMessageLikeBinding binding16 = getBinding();
                if (binding16 != null && (userIconView = binding16.leftUserIconView) != null) {
                    userIconView.setIconUrls(arrayList);
                }
                HiloMessageLikeBinding binding17 = getBinding();
                if (binding17 != null && (linearLayout = binding17.msgContentLl) != null) {
                    linearLayout.setBackground(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), checkStrange() ? R.drawable.strange_bubble_left : R.drawable.rc_ic_bubble_left1));
                }
            }
            if (checkStrange()) {
                HiloMessageLikeBinding binding18 = getBinding();
                if (binding18 != null && (textView9 = binding18.messageContainer) != null) {
                    textView9.setBackground(ShapeUtil.INSTANCE.createShape("#2B2839", "#2B2839", 11, GradientDrawable.Orientation.LEFT_RIGHT));
                }
                HiloMessageLikeBinding binding19 = getBinding();
                if (binding19 != null && (textView8 = binding19.messageContainer) != null) {
                    textView8.setPadding(18, 2, 18, 4);
                }
                HiloMessageLikeBinding binding20 = getBinding();
                if (binding20 != null && (textView7 = binding20.messageContainer) != null) {
                    textView7.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.configColor80White));
                }
            } else {
                HiloMessageLikeBinding binding21 = getBinding();
                if (binding21 != null && (textView6 = binding21.messageContainer) != null) {
                    textView6.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.color_666666));
                }
                HiloMessageLikeBinding binding22 = getBinding();
                if (binding22 != null && (textView5 = binding22.messageContainer) != null) {
                    textView5.setBackground(null);
                }
                HiloMessageLikeBinding binding23 = getBinding();
                if (binding23 != null && (textView4 = binding23.messageContainer) != null) {
                    textView4.setPadding(0, 0, 0, 0);
                }
            }
            HiloMessageLikeBinding binding24 = getBinding();
            if (binding24 != null && (userIconView5 = binding24.leftUserIconView) != null) {
                final long j = 800;
                userIconView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomLikeMessageHolder$layoutViews$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(userIconView5) > j || (userIconView5 instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(userIconView5, currentTimeMillis);
                            if (this.checkStrange()) {
                                Toast normal$default = HiloToasty.Companion.normal$default(HiloToasty.Companion, ((RecyclerView.ViewHolder) this).itemView.getContext(), ResourcesKtxKt.getStringById(this, R.string.strange_click_avatar_tip), false, 4, (Object) null);
                                if (normal$default != null) {
                                    normal$default.show();
                                    return;
                                }
                                return;
                            }
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            String sender = ((LikeMessageBean) msg).getSender();
                            Intrinsics.checkNotNullExpressionValue(sender, "getSender(...)");
                            baseControlUtils.openPersonPage(sender);
                        }
                    }
                });
            }
            HiloMessageLikeBinding binding25 = getBinding();
            if (binding25 == null || (userIconView4 = binding25.rightUserIconView) == null) {
                return;
            }
            userIconView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CustomLikeMessageHolder.layoutViews$lambda$1(TUIMessageBean.this, view);
                }
            });
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.MessageEmptyBaseHolder
    @NotNull
    public HiloMessageLikeBinding inflateViewBinding() {
        HiloMessageLikeBinding inflate = HiloMessageLikeBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
