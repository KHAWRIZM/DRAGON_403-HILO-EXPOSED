package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.UiKtxKt;
import com.qiahao.base_common.model.im.TextAndImageMessage;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.tencent.qcloud.tuicore.component.gatherimage.UserIconView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageImageTextBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.TextAndImageMessageBean;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomTextImageMessageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/MessageEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloMessageImageTextBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomTextImageMessageHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomTextImageMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomTextImageMessageHolder\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,58:1\n299#2,2:59\n299#2,2:61\n*S KotlinDebug\n*F\n+ 1 CustomTextImageMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomTextImageMessageHolder\n*L\n36#1:59,2\n43#1:61,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class CustomTextImageMessageHolder extends MessageEmptyBaseHolder<HiloMessageImageTextBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTextImageMessageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutViews$lambda$0(CustomTextImageMessageHolder customTextImageMessageHolder, TUIMessageBean tUIMessageBean) {
        ViewGroup.LayoutParams layoutParams;
        float f;
        float f2;
        HiloMessageImageTextBinding binding;
        HiloMessageImageTextBinding binding2;
        HiloMessageImageTextBinding binding3;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        float f3;
        float f4;
        Float imgHeight;
        Float imgWidth;
        Float imgWidth2;
        Float imgHeight2;
        ImageView imageView4;
        HiloMessageImageTextBinding binding4 = customTextImageMessageHolder.getBinding();
        String str = null;
        if (binding4 != null && (imageView4 = binding4.image) != null) {
            layoutParams = imageView4.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        TextAndImageMessageBean textAndImageMessageBean = (TextAndImageMessageBean) tUIMessageBean;
        TextAndImageMessage messageData = textAndImageMessageBean.getMessageData();
        float f5 = 0.0f;
        if (messageData != null && (imgHeight2 = messageData.getImgHeight()) != null) {
            f = imgHeight2.floatValue();
        } else {
            f = 0.0f;
        }
        if (f > 0.0f) {
            TextAndImageMessage messageData2 = textAndImageMessageBean.getMessageData();
            if (messageData2 != null && (imgWidth2 = messageData2.getImgWidth()) != null) {
                f3 = imgWidth2.floatValue();
            } else {
                f3 = 0.0f;
            }
            if (f3 > 0.0f) {
                TextAndImageMessage messageData3 = textAndImageMessageBean.getMessageData();
                if (messageData3 != null && (imgWidth = messageData3.getImgWidth()) != null) {
                    f5 = imgWidth.floatValue();
                }
                TextAndImageMessage messageData4 = textAndImageMessageBean.getMessageData();
                if (messageData4 != null && (imgHeight = messageData4.getImgHeight()) != null) {
                    f4 = imgHeight.floatValue();
                } else {
                    f4 = 1.0f;
                }
                f2 = f5 / f4;
                layoutParams2.height = (int) (UiKtxKt.toPX(220) / f2);
                binding = customTextImageMessageHolder.getBinding();
                if (binding != null && (imageView3 = binding.image) != null) {
                    imageView3.setLayoutParams(layoutParams2);
                }
                binding2 = customTextImageMessageHolder.getBinding();
                if (binding2 != null && (imageView2 = binding2.image) != null) {
                    imageView2.setVisibility(0);
                }
                binding3 = customTextImageMessageHolder.getBinding();
                if (binding3 == null && (imageView = binding3.image) != null) {
                    TextAndImageMessage messageData5 = textAndImageMessageBean.getMessageData();
                    if (messageData5 != null) {
                        str = messageData5.getImgUrl();
                    }
                    ImageKtxKt.loadImage$default(imageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.group_placeholde), (c5.g) null, 49150, (Object) null);
                    return;
                }
            }
        }
        f2 = 2.3404255f;
        layoutParams2.height = (int) (UiKtxKt.toPX(220) / f2);
        binding = customTextImageMessageHolder.getBinding();
        if (binding != null) {
            imageView3.setLayoutParams(layoutParams2);
        }
        binding2 = customTextImageMessageHolder.getBinding();
        if (binding2 != null) {
            imageView2.setVisibility(0);
        }
        binding3 = customTextImageMessageHolder.getBinding();
        if (binding3 == null) {
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable final TUIMessageBean msg, int position) {
        UserIconView userIconView;
        UserIconView userIconView2;
        LinearLayout linearLayout;
        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout2;
        int i;
        LinearLayout linearLayout3;
        int i2;
        ImageView imageView2;
        TextView textView2;
        String str;
        TextView textView3;
        super.layoutViews(msg, position);
        if (msg instanceof TextAndImageMessageBean) {
            HiloMessageImageTextBinding binding = getBinding();
            String str2 = null;
            if (binding != null) {
                userIconView = binding.leftUserIconView;
            } else {
                userIconView = null;
            }
            HiloMessageImageTextBinding binding2 = getBinding();
            if (binding2 != null) {
                userIconView2 = binding2.rightUserIconView;
            } else {
                userIconView2 = null;
            }
            HiloMessageImageTextBinding binding3 = getBinding();
            if (binding3 != null) {
                linearLayout = binding3.msgContentLl;
            } else {
                linearLayout = null;
            }
            setUserAvatar(msg, userIconView, userIconView2, linearLayout);
            if (checkStrange()) {
                HiloMessageImageTextBinding binding4 = getBinding();
                if (binding4 != null && (textView3 = binding4.tvContent) != null) {
                    textView3.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.white));
                }
            } else {
                HiloMessageImageTextBinding binding5 = getBinding();
                if (binding5 != null && (textView = binding5.tvContent) != null) {
                    textView.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.color_333333));
                }
            }
            HiloMessageImageTextBinding binding6 = getBinding();
            if (binding6 != null && (textView2 = binding6.tvContent) != null) {
                TextAndImageMessage messageData = ((TextAndImageMessageBean) msg).getMessageData();
                if (messageData != null) {
                    str = messageData.getContent();
                } else {
                    str = null;
                }
                textView2.setText(str);
            }
            TextAndImageMessageBean textAndImageMessageBean = (TextAndImageMessageBean) msg;
            TextAndImageMessage messageData2 = textAndImageMessageBean.getMessageData();
            if (messageData2 != null) {
                str2 = messageData2.getImgUrl();
            }
            if (str2 != null && str2.length() != 0) {
                HiloMessageImageTextBinding binding7 = getBinding();
                if (binding7 != null && (imageView2 = binding7.image) != null) {
                    imageView2.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.e
                        @Override // java.lang.Runnable
                        public final void run() {
                            CustomTextImageMessageHolder.layoutViews$lambda$0(CustomTextImageMessageHolder.this, msg);
                        }
                    });
                }
            } else {
                HiloMessageImageTextBinding binding8 = getBinding();
                if (binding8 != null && (imageView = binding8.image) != null) {
                    imageView.setVisibility(8);
                }
            }
            if (textAndImageMessageBean.isSelf()) {
                HiloMessageImageTextBinding binding9 = getBinding();
                if (binding9 != null && (linearLayout3 = binding9.msgContentLl) != null) {
                    Context context = ((RecyclerView.ViewHolder) this).itemView.getContext();
                    if (checkStrange()) {
                        i2 = R.drawable.strange_bubble_right;
                    } else {
                        i2 = R.drawable.rc_ic_bubble_right1;
                    }
                    linearLayout3.setBackground(androidx.core.content.a.getDrawable(context, i2));
                    return;
                }
                return;
            }
            HiloMessageImageTextBinding binding10 = getBinding();
            if (binding10 != null && (linearLayout2 = binding10.msgContentLl) != null) {
                Context context2 = ((RecyclerView.ViewHolder) this).itemView.getContext();
                if (checkStrange()) {
                    i = R.drawable.strange_bubble_left;
                } else {
                    i = R.drawable.rc_ic_bubble_left1;
                }
                linearLayout2.setBackground(androidx.core.content.a.getDrawable(context2, i));
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.MessageEmptyBaseHolder
    @NotNull
    public HiloMessageImageTextBinding inflateViewBinding() {
        HiloMessageImageTextBinding inflate = HiloMessageImageTextBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
