package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.LinkMessage;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageLinkBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.LinkMessageBean;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomHiloLinkMessageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/HiloMessageContentHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloMessageLinkBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutVariableViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCustomHiloLinkMessageHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomHiloLinkMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomHiloLinkMessageHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n+ 3 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,76:1\n61#2,9:77\n299#3,2:86\n299#3,2:88\n*S KotlinDebug\n*F\n+ 1 CustomHiloLinkMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/CustomHiloLinkMessageHolder\n*L\n51#1:77,9\n63#1:86,2\n69#1:88,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class CustomHiloLinkMessageHolder extends HiloMessageContentHolder<HiloMessageLinkBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomHiloLinkMessageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(@Nullable final TUIMessageBean msg, int position) {
        String str;
        String str2;
        TextView textView;
        String str3;
        ImageView imageView;
        ViewGroup.LayoutParams layoutParams;
        float f;
        float f2;
        HiloMessageLinkBinding binding;
        HiloMessageLinkBinding binding2;
        HiloMessageLinkBinding binding3;
        ImageView imageView2;
        ImageView imageView3;
        ImageView imageView4;
        float f3;
        float f4;
        Float imgHeight;
        Float imgWidth;
        Float imgWidth2;
        Float imgHeight2;
        ImageView imageView5;
        TextView textView2;
        TextView textView3;
        final View root;
        if (msg instanceof LinkMessageBean) {
            LinkMessageBean linkMessageBean = (LinkMessageBean) msg;
            LinkMessage messageData = linkMessageBean.getMessageData();
            String str4 = null;
            if (messageData != null) {
                str = messageData.getContent();
            } else {
                str = null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            LinkMessage messageData2 = linkMessageBean.getMessageData();
            if (messageData2 != null) {
                str2 = messageData2.getLink();
            } else {
                str2 = null;
            }
            if (str2 != null && str2.length() != 0) {
                SpannableString spannableString = new SpannableString("Go >>");
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#9036ff")), 0, spannableString.length(), 33);
                spannableStringBuilder.append((CharSequence) " ").append((CharSequence) spannableString);
                HiloMessageLinkBinding binding4 = getBinding();
                if (binding4 != null && (root = binding4.getRoot()) != null) {
                    final long j = 800;
                    root.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.CustomHiloLinkMessageHolder$layoutVariableViews$$inlined$singleClick$default$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            String str5;
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                                ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                                BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                                LinkMessage messageData3 = ((LinkMessageBean) msg).getMessageData();
                                if (messageData3 == null || (str5 = messageData3.getLink()) == null) {
                                    str5 = "";
                                }
                                baseControlUtils.openH5(str5);
                            }
                        }
                    });
                }
            }
            if (checkStrange()) {
                HiloMessageLinkBinding binding5 = getBinding();
                if (binding5 != null && (textView3 = binding5.tvContent) != null) {
                    textView3.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.white));
                }
            } else {
                HiloMessageLinkBinding binding6 = getBinding();
                if (binding6 != null && (textView = binding6.tvContent) != null) {
                    textView.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.color_333333));
                }
            }
            HiloMessageLinkBinding binding7 = getBinding();
            if (binding7 != null && (textView2 = binding7.tvContent) != null) {
                textView2.setText(spannableStringBuilder);
            }
            LinkMessage messageData3 = linkMessageBean.getMessageData();
            if (messageData3 != null) {
                str3 = messageData3.getImgUrl();
            } else {
                str3 = null;
            }
            if (str3 != null && str3.length() != 0) {
                HiloMessageLinkBinding binding8 = getBinding();
                if (binding8 != null && (imageView5 = binding8.image) != null) {
                    layoutParams = imageView5.getLayoutParams();
                } else {
                    layoutParams = null;
                }
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                LinkMessage messageData4 = linkMessageBean.getMessageData();
                float f5 = 0.0f;
                if (messageData4 != null && (imgHeight2 = messageData4.getImgHeight()) != null) {
                    f = imgHeight2.floatValue();
                } else {
                    f = 0.0f;
                }
                if (f != 0.0f) {
                    LinkMessage messageData5 = linkMessageBean.getMessageData();
                    if (messageData5 != null && (imgWidth2 = messageData5.getImgWidth()) != null) {
                        f3 = imgWidth2.floatValue();
                    } else {
                        f3 = 0.0f;
                    }
                    if (f3 != 0.0f) {
                        LinkMessage messageData6 = linkMessageBean.getMessageData();
                        if (messageData6 != null && (imgWidth = messageData6.getImgWidth()) != null) {
                            f5 = imgWidth.floatValue();
                        }
                        LinkMessage messageData7 = linkMessageBean.getMessageData();
                        if (messageData7 != null && (imgHeight = messageData7.getImgHeight()) != null) {
                            f4 = imgHeight.floatValue();
                        } else {
                            f4 = 1.0f;
                        }
                        f2 = f5 / f4;
                        layoutParams2.height = (int) (UiKtxKt.toPX(220) / f2);
                        binding = getBinding();
                        if (binding != null && (imageView4 = binding.image) != null) {
                            imageView4.setLayoutParams(layoutParams2);
                        }
                        binding2 = getBinding();
                        if (binding2 != null && (imageView3 = binding2.image) != null) {
                            imageView3.setVisibility(0);
                        }
                        binding3 = getBinding();
                        if (binding3 == null && (imageView2 = binding3.image) != null) {
                            LinkMessage messageData8 = linkMessageBean.getMessageData();
                            if (messageData8 != null) {
                                str4 = messageData8.getImgUrl();
                            }
                            ImageKtxKt.loadImage$default(imageView2, str4, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.group_placeholde), (c5.g) null, 49150, (Object) null);
                            return;
                        }
                        return;
                    }
                }
                f2 = 2.3404255f;
                layoutParams2.height = (int) (UiKtxKt.toPX(220) / f2);
                binding = getBinding();
                if (binding != null) {
                    imageView4.setLayoutParams(layoutParams2);
                }
                binding2 = getBinding();
                if (binding2 != null) {
                    imageView3.setVisibility(0);
                }
                binding3 = getBinding();
                if (binding3 == null) {
                    return;
                } else {
                    return;
                }
            }
            HiloMessageLinkBinding binding9 = getBinding();
            if (binding9 != null && (imageView = binding9.image) != null) {
                imageView.setVisibility(8);
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.HiloMessageContentHolder
    @NotNull
    public HiloMessageLinkBinding inflateViewBinding() {
        HiloMessageLinkBinding inflate = HiloMessageLinkBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
