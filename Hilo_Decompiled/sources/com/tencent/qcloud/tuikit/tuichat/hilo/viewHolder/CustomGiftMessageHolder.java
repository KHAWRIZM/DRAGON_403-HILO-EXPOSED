package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder;

import android.graphics.Bitmap;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.BaseApplication;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.im.GiftMessage;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.HiloToasty;
import com.qiahao.base_common.utils.ShapeUtil;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageGiftBinding;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloViewMessageGiftBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.GiftMessageBean;
import com.tencent.qcloud.tuikit.tuichat.interfaces.IMCheckDataListener;
import java.io.File;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomGiftMessageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/MessageEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloMessageGiftBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomGiftMessageHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomGiftMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomGiftMessageHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,123:1\n61#2,9:124\n*S KotlinDebug\n*F\n+ 1 CustomGiftMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomGiftMessageHolder\n*L\n104#1:124,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class CustomGiftMessageHolder extends MessageEmptyBaseHolder<HiloMessageGiftBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomGiftMessageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutViews$lambda$2(TUIMessageBean tUIMessageBean, View view) {
        BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
        String sender = ((GiftMessageBean) tUIMessageBean).getSender();
        Intrinsics.checkNotNullExpressionValue(sender, "getSender(...)");
        baseControlUtils.openPersonPage(sender);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean layoutViews$lambda$3(CustomGiftMessageHolder customGiftMessageHolder, TUIMessageBean tUIMessageBean, int i, View view) {
        customGiftMessageHolder.showDialog(tUIMessageBean, i, view, false, true, false);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x007a, code lost:
    
        if (r3 == null) goto L٣٢;
     */
    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutViews(@Nullable final TUIMessageBean msg, final int position) {
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        UserIconView userIconView;
        GiftMessage messageData;
        TextView textView3;
        Integer giftType;
        UserIconView userIconView2;
        UserIconView userIconView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        LinearLayout linearLayout2;
        UserIconView userIconView4;
        final UserIconView userIconView5;
        HiloViewMessageGiftBinding hiloViewMessageGiftBinding;
        TextView textView7;
        String num;
        HiloViewMessageGiftBinding hiloViewMessageGiftBinding2;
        ImageView imageView;
        String giftData;
        TextView textView8;
        TextView textView9;
        TextView textView10;
        TextView textView11;
        TextView textView12;
        LinearLayout linearLayout3;
        UserIconView userIconView6;
        GiftMessage messageData2;
        TextView textView13;
        Integer giftType2;
        UserIconView userIconView7;
        UserIconView userIconView8;
        String str;
        UserIconView userIconView9;
        UserIconView userIconView10;
        LinearLayout linearLayout4;
        super.layoutViews(msg, position);
        if (msg instanceof GiftMessageBean) {
            HiloMessageGiftBinding binding = getBinding();
            ViewGroup.LayoutParams layoutParams = (binding == null || (linearLayout4 = binding.msgContentLl) == null) ? null : linearLayout4.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            if (this.properties.getAvatarRadius() != 0) {
                HiloMessageGiftBinding binding2 = getBinding();
                if (binding2 != null && (userIconView10 = binding2.leftUserIconView) != null) {
                    userIconView10.setRadius(this.properties.getAvatarRadius());
                }
                HiloMessageGiftBinding binding3 = getBinding();
                if (binding3 != null && (userIconView9 = binding3.rightUserIconView) != null) {
                    userIconView9.setRadius(this.properties.getAvatarRadius());
                }
            }
            ArrayList arrayList = new ArrayList();
            String str2 = "";
            if (checkStrange()) {
                IMCheckDataListener iMCheckDataListener = this.onItemDateListener;
                if (iMCheckDataListener != null) {
                    str = iMCheckDataListener.checkString(((GiftMessageBean) msg).isSelf() ? "avatarMy" : "avatarReceive");
                }
                str = "";
                if (!TextUtils.isEmpty(str)) {
                    arrayList.add(str);
                }
            } else {
                String faceUrl = ((GiftMessageBean) msg).getFaceUrl();
                Intrinsics.checkNotNullExpressionValue(faceUrl, "getFaceUrl(...)");
                arrayList.add(faceUrl);
            }
            GiftMessageBean giftMessageBean = (GiftMessageBean) msg;
            if (giftMessageBean.isSelf()) {
                bVar.G = 1.0f;
                HiloMessageGiftBinding binding4 = getBinding();
                if (binding4 != null && (userIconView8 = binding4.leftUserIconView) != null) {
                    userIconView8.setVisibility(4);
                }
                HiloMessageGiftBinding binding5 = getBinding();
                if (binding5 != null && (userIconView7 = binding5.rightUserIconView) != null) {
                    userIconView7.setVisibility(0);
                }
                GiftMessage messageData3 = giftMessageBean.getMessageData();
                if ((messageData3 != null ? messageData3.getGiftType() : null) != null && ((messageData2 = giftMessageBean.getMessageData()) == null || (giftType2 = messageData2.getGiftType()) == null || giftType2.intValue() != 0)) {
                    HiloMessageGiftBinding binding6 = getBinding();
                    if (binding6 != null && (textView13 = binding6.messageContainer) != null) {
                        textView13.setVisibility(8);
                    }
                } else {
                    HiloMessageGiftBinding binding7 = getBinding();
                    if (binding7 != null && (textView12 = binding7.messageContainer) != null) {
                        textView12.setText(ResourcesKtxKt.getStringById(this, R.string.sender_gift_out_time_tip));
                    }
                    HiloMessageGiftBinding binding8 = getBinding();
                    if (binding8 != null && (textView11 = binding8.messageContainer) != null) {
                        textView11.setVisibility(0);
                    }
                }
                HiloMessageGiftBinding binding9 = getBinding();
                if (binding9 != null && (userIconView6 = binding9.rightUserIconView) != null) {
                    userIconView6.setIconUrls(arrayList);
                }
                HiloMessageGiftBinding binding10 = getBinding();
                if (binding10 != null && (linearLayout3 = binding10.msgContentLl) != null) {
                    linearLayout3.setBackground(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), checkStrange() ? R.drawable.strange_bubble_right : R.drawable.rc_ic_bubble_right1));
                }
            } else {
                bVar.G = 0.0f;
                HiloMessageGiftBinding binding11 = getBinding();
                if (binding11 != null && (userIconView3 = binding11.leftUserIconView) != null) {
                    userIconView3.setVisibility(0);
                }
                HiloMessageGiftBinding binding12 = getBinding();
                if (binding12 != null && (userIconView2 = binding12.rightUserIconView) != null) {
                    userIconView2.setVisibility(4);
                }
                GiftMessage messageData4 = giftMessageBean.getMessageData();
                if ((messageData4 != null ? messageData4.getGiftType() : null) != null && ((messageData = giftMessageBean.getMessageData()) == null || (giftType = messageData.getGiftType()) == null || giftType.intValue() != 0)) {
                    HiloMessageGiftBinding binding13 = getBinding();
                    if (binding13 != null && (textView3 = binding13.messageContainer) != null) {
                        textView3.setVisibility(8);
                    }
                } else {
                    HiloMessageGiftBinding binding14 = getBinding();
                    if (binding14 != null && (textView2 = binding14.messageContainer) != null) {
                        textView2.setText(ResourcesKtxKt.getStringById(this, R.string.receiver_gift_out_time_tip));
                    }
                    HiloMessageGiftBinding binding15 = getBinding();
                    if (binding15 != null && (textView = binding15.messageContainer) != null) {
                        textView.setVisibility(0);
                    }
                }
                HiloMessageGiftBinding binding16 = getBinding();
                if (binding16 != null && (userIconView = binding16.leftUserIconView) != null) {
                    userIconView.setIconUrls(arrayList);
                }
                HiloMessageGiftBinding binding17 = getBinding();
                if (binding17 != null && (linearLayout = binding17.msgContentLl) != null) {
                    linearLayout.setBackground(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), checkStrange() ? R.drawable.strange_bubble_left : R.drawable.rc_ic_bubble_left1));
                }
            }
            if (checkStrange()) {
                HiloMessageGiftBinding binding18 = getBinding();
                if (binding18 != null && (textView10 = binding18.messageContainer) != null) {
                    textView10.setBackground(ShapeUtil.INSTANCE.createShape("#2B2839", "#2B2839", 11, GradientDrawable.Orientation.LEFT_RIGHT));
                }
                HiloMessageGiftBinding binding19 = getBinding();
                if (binding19 != null && (textView9 = binding19.messageContainer) != null) {
                    textView9.setPadding(18, 2, 18, 4);
                }
                HiloMessageGiftBinding binding20 = getBinding();
                if (binding20 != null && (textView8 = binding20.messageContainer) != null) {
                    textView8.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.configColor80White));
                }
            } else {
                HiloMessageGiftBinding binding21 = getBinding();
                if (binding21 != null && (textView6 = binding21.messageContainer) != null) {
                    textView6.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.color_666666));
                }
                HiloMessageGiftBinding binding22 = getBinding();
                if (binding22 != null && (textView5 = binding22.messageContainer) != null) {
                    textView5.setBackground(null);
                }
                HiloMessageGiftBinding binding23 = getBinding();
                if (binding23 != null && (textView4 = binding23.messageContainer) != null) {
                    textView4.setPadding(0, 0, 0, 0);
                }
            }
            GiftMessage messageData5 = giftMessageBean.getMessageData();
            GiftData giftData2 = (messageData5 == null || (giftData = messageData5.getGiftData()) == null) ? null : (GiftData) BaseApplication.Companion.getGSON().j(giftData, GiftData.class);
            HiloMessageGiftBinding binding24 = getBinding();
            if (binding24 != null && (hiloViewMessageGiftBinding2 = binding24.giftContent) != null && (imageView = hiloViewMessageGiftBinding2.giftPic) != null) {
                ImageKtxKt.loadImage$default(imageView, ImageSizeKt.image100(giftData2 != null ? giftData2.getIconUrl() : null), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.icon_default_gift), (c5.g) null, 49150, (Object) null);
            }
            HiloMessageGiftBinding binding25 = getBinding();
            if (binding25 != null && (hiloViewMessageGiftBinding = binding25.giftContent) != null && (textView7 = hiloViewMessageGiftBinding.giftNumber) != null) {
                if (giftData2 != null && (num = Integer.valueOf(giftData2.getNum()).toString()) != null) {
                    str2 = num;
                }
                textView7.setText(str2);
            }
            HiloMessageGiftBinding binding26 = getBinding();
            if (binding26 != null && (userIconView5 = binding26.leftUserIconView) != null) {
                final long j = 800;
                userIconView5.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomGiftMessageHolder$layoutViews$$inlined$singleClick$default$1
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
                            String sender = ((GiftMessageBean) msg).getSender();
                            Intrinsics.checkNotNullExpressionValue(sender, "getSender(...)");
                            baseControlUtils.openPersonPage(sender);
                        }
                    }
                });
            }
            HiloMessageGiftBinding binding27 = getBinding();
            if (binding27 != null && (userIconView4 = binding27.rightUserIconView) != null) {
                userIconView4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CustomGiftMessageHolder.layoutViews$lambda$2(TUIMessageBean.this, view);
                    }
                });
            }
            HiloMessageGiftBinding binding28 = getBinding();
            if (binding28 == null || (linearLayout2 = binding28.msgContentLl) == null) {
                return;
            }
            linearLayout2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.b
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean layoutViews$lambda$3;
                    layoutViews$lambda$3 = CustomGiftMessageHolder.layoutViews$lambda$3(CustomGiftMessageHolder.this, msg, position, view);
                    return layoutViews$lambda$3;
                }
            });
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.MessageEmptyBaseHolder
    @NotNull
    public HiloMessageGiftBinding inflateViewBinding() {
        HiloMessageGiftBinding inflate = HiloMessageGiftBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
