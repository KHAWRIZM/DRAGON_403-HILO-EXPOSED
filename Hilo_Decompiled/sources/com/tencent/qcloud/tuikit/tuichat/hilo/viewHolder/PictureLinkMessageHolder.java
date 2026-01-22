package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder;

import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.im.PictureLinkMessage;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessagePictureLinkBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.PictureLinkMessageBean;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/PictureLinkMessageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/HiloMessageContentHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloMessagePictureLinkBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutVariableViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPictureLinkMessageHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PictureLinkMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/PictureLinkMessageHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,52:1\n61#2,9:53\n*S KotlinDebug\n*F\n+ 1 PictureLinkMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/PictureLinkMessageHolder\n*L\n43#1:53,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class PictureLinkMessageHolder extends HiloMessageContentHolder<HiloMessagePictureLinkBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureLinkMessageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void layoutVariableViews$lambda$0(PictureLinkMessageHolder pictureLinkMessageHolder, TUIMessageBean tUIMessageBean) {
        ViewGroup.LayoutParams layoutParams;
        float f;
        float f2;
        HiloMessagePictureLinkBinding binding;
        HiloMessagePictureLinkBinding binding2;
        QMUIRadiusImageView qMUIRadiusImageView;
        QMUIRadiusImageView qMUIRadiusImageView2;
        float f3;
        float f4;
        Float imgHeight;
        Float imgWidth;
        Float imgWidth2;
        Float imgHeight2;
        QMUIRadiusImageView qMUIRadiusImageView3;
        HiloMessagePictureLinkBinding binding3 = pictureLinkMessageHolder.getBinding();
        String str = null;
        if (binding3 != null && (qMUIRadiusImageView3 = binding3.image) != null) {
            layoutParams = qMUIRadiusImageView3.getLayoutParams();
        } else {
            layoutParams = null;
        }
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        PictureLinkMessageBean pictureLinkMessageBean = (PictureLinkMessageBean) tUIMessageBean;
        PictureLinkMessage messageData = pictureLinkMessageBean.getMessageData();
        float f5 = 0.0f;
        if (messageData != null && (imgHeight2 = messageData.getImgHeight()) != null) {
            f = imgHeight2.floatValue();
        } else {
            f = 0.0f;
        }
        if (f > 0.0f) {
            PictureLinkMessage messageData2 = pictureLinkMessageBean.getMessageData();
            if (messageData2 != null && (imgWidth2 = messageData2.getImgWidth()) != null) {
                f3 = imgWidth2.floatValue();
            } else {
                f3 = 0.0f;
            }
            if (f3 > 0.0f) {
                PictureLinkMessage messageData3 = pictureLinkMessageBean.getMessageData();
                if (messageData3 != null && (imgWidth = messageData3.getImgWidth()) != null) {
                    f5 = imgWidth.floatValue();
                }
                PictureLinkMessage messageData4 = pictureLinkMessageBean.getMessageData();
                if (messageData4 != null && (imgHeight = messageData4.getImgHeight()) != null) {
                    f4 = imgHeight.floatValue();
                } else {
                    f4 = 1.0f;
                }
                f2 = f5 / f4;
                ((ViewGroup.MarginLayoutParams) bVar).height = (int) (UiKtxKt.toPX(265) / f2);
                binding = pictureLinkMessageHolder.getBinding();
                if (binding != null && (qMUIRadiusImageView2 = binding.image) != null) {
                    qMUIRadiusImageView2.setLayoutParams(bVar);
                }
                binding2 = pictureLinkMessageHolder.getBinding();
                if (binding2 == null && (qMUIRadiusImageView = binding2.image) != null) {
                    PictureLinkMessage messageData5 = pictureLinkMessageBean.getMessageData();
                    if (messageData5 != null) {
                        str = messageData5.getImage();
                    }
                    ImageKtxKt.loadImage$default(qMUIRadiusImageView, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.group_placeholde), (c5.g) null, 49150, (Object) null);
                    return;
                }
            }
        }
        f2 = 3.5810812f;
        ((ViewGroup.MarginLayoutParams) bVar).height = (int) (UiKtxKt.toPX(265) / f2);
        binding = pictureLinkMessageHolder.getBinding();
        if (binding != null) {
            qMUIRadiusImageView2.setLayoutParams(bVar);
        }
        binding2 = pictureLinkMessageHolder.getBinding();
        if (binding2 == null) {
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(@Nullable final TUIMessageBean msg, int position) {
        TextView textView;
        final View root;
        TextView textView2;
        int i;
        String actionUrl;
        QMUIRadiusImageView qMUIRadiusImageView;
        TextView textView3;
        String str;
        TextView textView4;
        if (msg instanceof PictureLinkMessageBean) {
            if (checkStrange()) {
                HiloMessagePictureLinkBinding binding = getBinding();
                if (binding != null && (textView4 = binding.title) != null) {
                    textView4.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.white));
                }
            } else {
                HiloMessagePictureLinkBinding binding2 = getBinding();
                if (binding2 != null && (textView = binding2.title) != null) {
                    textView.setTextColor(androidx.core.content.a.getColor(((RecyclerView.ViewHolder) this).itemView.getContext(), R.color.color_333333));
                }
            }
            HiloMessagePictureLinkBinding binding3 = getBinding();
            String str2 = "";
            if (binding3 != null && (textView3 = binding3.title) != null) {
                PictureLinkMessage messageData = ((PictureLinkMessageBean) msg).getMessageData();
                if (messageData == null || (str = messageData.getText()) == null) {
                    str = "";
                }
                textView3.setText(str);
            }
            HiloMessagePictureLinkBinding binding4 = getBinding();
            if (binding4 != null && (qMUIRadiusImageView = binding4.image) != null) {
                qMUIRadiusImageView.post(new Runnable() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        PictureLinkMessageHolder.layoutVariableViews$lambda$0(PictureLinkMessageHolder.this, msg);
                    }
                });
            }
            HiloMessagePictureLinkBinding binding5 = getBinding();
            if (binding5 != null && (textView2 = binding5.go) != null) {
                PictureLinkMessage messageData2 = ((PictureLinkMessageBean) msg).getMessageData();
                if (messageData2 != null && (actionUrl = messageData2.getActionUrl()) != null) {
                    str2 = actionUrl;
                }
                if (TextUtils.isEmpty(str2)) {
                    i = 8;
                } else {
                    i = 0;
                }
                textView2.setVisibility(i);
            }
            HiloMessagePictureLinkBinding binding6 = getBinding();
            if (binding6 != null && (root = binding6.getRoot()) != null) {
                final long j = 800;
                root.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.PictureLinkMessageHolder$layoutVariableViews$$inlined$singleClick$default$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        String str3;
                        String actionUrl2;
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(root) > j || (root instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(root, currentTimeMillis);
                            PictureLinkMessage messageData3 = ((PictureLinkMessageBean) msg).getMessageData();
                            String str4 = "";
                            if (messageData3 == null || (str3 = messageData3.getActionUrl()) == null) {
                                str3 = "";
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                                PictureLinkMessage messageData4 = ((PictureLinkMessageBean) msg).getMessageData();
                                if (messageData4 != null && (actionUrl2 = messageData4.getActionUrl()) != null) {
                                    str4 = actionUrl2;
                                }
                                baseControlUtils.openCommonLink(str4);
                            }
                        }
                    }
                });
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.HiloMessageContentHolder
    @NotNull
    public HiloMessagePictureLinkBinding inflateViewBinding() {
        HiloMessagePictureLinkBinding inflate = HiloMessagePictureLinkBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
