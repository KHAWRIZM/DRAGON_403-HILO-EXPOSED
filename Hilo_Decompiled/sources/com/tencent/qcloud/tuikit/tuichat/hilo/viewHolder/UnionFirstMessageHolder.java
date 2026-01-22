package com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.ViewKtxKt;
import com.qiahao.base_common.model.GiftData;
import com.qiahao.base_common.model.MultiGiftData;
import com.qiahao.base_common.model.im.PicBean;
import com.qiahao.base_common.model.im.TIMUnionFirstMessageForGift;
import com.qiahao.base_common.model.im.UnionFirstMessage;
import com.qiahao.base_common.support.BaseControlUtils;
import com.qiahao.base_common.utils.image.ImageKtxKt;
import com.qiahao.base_common.utils.image.ImageSizeKt;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.databinding.HiloMessageUnionFirstBinding;
import com.tencent.qcloud.tuikit.tuichat.hilo.bean.UnionFirstMessageBean;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J,\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J$\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0002¨\u0006\u001b"}, d2 = {"Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/UnionFirstMessageHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/MessageEmptyBaseHolder;", "Lcom/tencent/qcloud/tuikit/tuichat/databinding/HiloMessageUnionFirstBinding;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "inflateViewBinding", "layoutViews", "", "msg", "Lcom/tencent/qcloud/tuikit/tuichat/bean/message/TUIMessageBean;", "position", "", "showGiftItemAndOnClick", "giftTextView", "Landroid/widget/TextView;", "giftNumber", "giftId", "", "giftPic", "Landroid/widget/ImageView;", "getImageParams", "Landroid/view/ViewGroup$LayoutParams;", "params", "imgWidth", "imgHeight", "tuichat_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUnionFirstMessageHolder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UnionFirstMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/UnionFirstMessageHolder\n+ 2 ViewKtx.kt\ncom/oudi/utils/ktx/ViewKtxKt\n*L\n1#1,161:1\n61#2,9:162\n61#2,9:171\n61#2,9:180\n61#2,9:189\n*S KotlinDebug\n*F\n+ 1 UnionFirstMessageHolder.kt\ncom/tencent/qcloud/tuikit/tuichat/hilo/viewHolder/UnionFirstMessageHolder\n*L\n64#1:162,9\n69#1:171,9\n73#1:180,9\n78#1:189,9\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class UnionFirstMessageHolder extends MessageEmptyBaseHolder<HiloMessageUnionFirstBinding> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnionFirstMessageHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    private final ViewGroup.LayoutParams getImageParams(ViewGroup.LayoutParams params, int imgWidth, int imgHeight) {
        if (imgWidth != 0 && imgHeight != 0) {
            if (imgWidth > imgHeight) {
                if (params != null) {
                    params.width = 540;
                }
                if (params != null) {
                    params.height = (imgHeight * 540) / imgWidth;
                }
            } else {
                if (params != null) {
                    params.width = (imgWidth * 540) / imgHeight;
                }
                if (params != null) {
                    params.height = 540;
                }
            }
        }
        return params;
    }

    private final void showGiftItemAndOnClick(TextView giftTextView, int giftNumber, long giftId, ImageView giftPic) {
        MultiGiftData multiGiftData;
        ImageView imageView;
        final MultiGiftData multiGiftData2;
        String str;
        MultiGiftData findGiftByGiftId = BaseControlUtils.INSTANCE.findGiftByGiftId(giftId);
        if (findGiftByGiftId != null) {
            Integer num = null;
            if (giftPic != null) {
                GiftData giftData = findGiftByGiftId.getGiftData();
                if (giftData != null) {
                    str = giftData.getIconUrl();
                } else {
                    str = null;
                }
                multiGiftData = findGiftByGiftId;
                imageView = giftPic;
                ImageKtxKt.loadImage$default(giftPic, str, (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.icon_default_gift), (c5.g) null, 49150, (Object) null);
            } else {
                multiGiftData = findGiftByGiftId;
                imageView = giftPic;
            }
            if (imageView != null) {
                multiGiftData2 = multiGiftData;
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UnionFirstMessageHolder.showGiftItemAndOnClick$lambda$4(multiGiftData2, view);
                    }
                });
            } else {
                multiGiftData2 = multiGiftData;
            }
            if (giftTextView != null) {
                GiftData giftData2 = multiGiftData2.getGiftData();
                if (giftData2 != null) {
                    num = Integer.valueOf((int) giftData2.getDiamondNum());
                }
                giftTextView.setText(String.valueOf(num));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGiftItemAndOnClick$lambda$4(MultiGiftData multiGiftData, View view) {
        float f;
        BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
        double diamond = baseControlUtils.getDiamond();
        GiftData giftData = multiGiftData.getGiftData();
        if (giftData != null) {
            f = giftData.getDiamondNum();
        } else {
            f = 0.0f;
        }
        if (diamond < f * 1) {
            baseControlUtils.startWallet();
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void layoutViews(@Nullable final TUIMessageBean msg, int position) {
        List gifts;
        List gifts2;
        TIMUnionFirstMessageForGift tIMUnionFirstMessageForGift;
        List gifts3;
        TIMUnionFirstMessageForGift tIMUnionFirstMessageForGift2;
        List gifts4;
        List gifts5;
        TIMUnionFirstMessageForGift tIMUnionFirstMessageForGift3;
        List gifts6;
        TIMUnionFirstMessageForGift tIMUnionFirstMessageForGift4;
        List gifts7;
        List gifts8;
        TIMUnionFirstMessageForGift tIMUnionFirstMessageForGift5;
        List gifts9;
        TIMUnionFirstMessageForGift tIMUnionFirstMessageForGift6;
        List gifts10;
        List gifts11;
        TIMUnionFirstMessageForGift tIMUnionFirstMessageForGift7;
        List gifts12;
        TIMUnionFirstMessageForGift tIMUnionFirstMessageForGift8;
        final QMUIRadiusImageView qMUIRadiusImageView;
        final QMUIRadiusImageView qMUIRadiusImageView2;
        final QMUIRadiusImageView qMUIRadiusImageView3;
        final ImageView imageView;
        ImageView imageView2;
        PicBean pic;
        ImageView imageView3;
        PicBean pic2;
        PicBean pic3;
        ImageView imageView4;
        QMUIRadiusImageView qMUIRadiusImageView4;
        QMUIRadiusImageView qMUIRadiusImageView5;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        LinearLayout linearLayout;
        int i = 0;
        super.layoutViews(msg, position);
        if (msg instanceof UnionFirstMessageBean) {
            HiloMessageUnionFirstBinding binding = getBinding();
            if (binding != null && (linearLayout = binding.msgContentLl) != null) {
                linearLayout.setBackground(androidx.core.content.a.getDrawable(((RecyclerView.ViewHolder) this).itemView.getContext(), R.drawable.rc_ic_bubble_left1));
            }
            HiloMessageUnionFirstBinding binding2 = getBinding();
            if (binding2 != null && (textView4 = binding2.chatTimeTv) != null) {
                textView4.setVisibility(0);
            }
            HiloMessageUnionFirstBinding binding3 = getBinding();
            if (binding3 != null && (textView3 = binding3.chatTimeTv) != null) {
                textView3.setText(DateTimeUtil.getTimeFormatText(new Date(((UnionFirstMessageBean) msg).getMessageTime() * 1000)));
            }
            UnionFirstMessageBean unionFirstMessageBean = (UnionFirstMessageBean) msg;
            if (unionFirstMessageBean.getExtra() != null) {
                HiloMessageUnionFirstBinding binding4 = getBinding();
                TextView textView5 = binding4 != null ? binding4.msgBodyTv : null;
                UnionFirstMessage messageData = unionFirstMessageBean.getMessageData();
                FaceManager.handlerEmojiText(textView5, messageData != null ? messageData.getText() : null, false);
            }
            HiloMessageUnionFirstBinding binding5 = getBinding();
            if (binding5 != null && (textView2 = binding5.msgBodyTv) != null) {
                textView2.setTextSize(15.0f);
            }
            HiloMessageUnionFirstBinding binding6 = getBinding();
            if (binding6 != null && (textView = binding6.messageContainer) != null) {
                String format = String.format(ResourcesKtxKt.getStringById(this, R.string.auto_say_hi_send_gift), Arrays.copyOf(new Object[]{unionFirstMessageBean.getNickName()}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                textView.setText(format);
            }
            HiloMessageUnionFirstBinding binding7 = getBinding();
            if (binding7 != null && (qMUIRadiusImageView5 = binding7.leftUserIconView) != null) {
                ImageKtxKt.loadImage$default(qMUIRadiusImageView5, ImageSizeKt.image100(unionFirstMessageBean.getFaceUrl()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.group_placeholde), (c5.g) null, 49150, (Object) null);
            }
            HiloMessageUnionFirstBinding binding8 = getBinding();
            if (binding8 != null && (qMUIRadiusImageView4 = binding8.leftUserIconViews) != null) {
                ImageKtxKt.loadImage$default(qMUIRadiusImageView4, ImageSizeKt.image100(unionFirstMessageBean.getFaceUrl()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.group_placeholde), (c5.g) null, 49150, (Object) null);
            }
            UnionFirstMessage messageData2 = unionFirstMessageBean.getMessageData();
            final long j = 800;
            if ((messageData2 != null ? messageData2.getPic() : null) != null) {
                HiloMessageUnionFirstBinding binding9 = getBinding();
                if (binding9 != null && (imageView3 = binding9.contentImageIv) != null) {
                    HiloMessageUnionFirstBinding binding10 = getBinding();
                    ViewGroup.LayoutParams layoutParams = (binding10 == null || (imageView4 = binding10.contentImageIv) == null) ? null : imageView4.getLayoutParams();
                    UnionFirstMessage messageData3 = unionFirstMessageBean.getMessageData();
                    int width = (messageData3 == null || (pic3 = messageData3.getPic()) == null) ? 0 : pic3.getWidth();
                    UnionFirstMessage messageData4 = unionFirstMessageBean.getMessageData();
                    imageView3.setLayoutParams(getImageParams(layoutParams, width, (messageData4 == null || (pic2 = messageData4.getPic()) == null) ? 0 : pic2.getHeight()));
                }
                HiloMessageUnionFirstBinding binding11 = getBinding();
                if (binding11 != null && (imageView2 = binding11.contentImageIv) != null) {
                    UnionFirstMessage messageData5 = unionFirstMessageBean.getMessageData();
                    ImageKtxKt.loadImage$default(imageView2, ImageSizeKt.image100((messageData5 == null || (pic = messageData5.getPic()) == null) ? null : pic.getUrl()), (Uri) null, (File) null, (Integer) null, (Bitmap) null, (ImageView.ScaleType) null, false, 0, false, (j) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, Integer.valueOf(R.drawable.group_placeholde), (c5.g) null, 49150, (Object) null);
                }
                HiloMessageUnionFirstBinding binding12 = getBinding();
                if (binding12 != null && (imageView = binding12.contentImageIv) != null) {
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.UnionFirstMessageHolder$layoutViews$$inlined$singleClick$default$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            String str;
                            PicBean pic4;
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - ViewKtxKt.getLastClickTime(imageView) > j || (imageView instanceof Checkable)) {
                                ViewKtxKt.setLastClickTime(imageView, currentTimeMillis);
                                BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                                UnionFirstMessage messageData6 = ((UnionFirstMessageBean) msg).getMessageData();
                                if (messageData6 == null || (pic4 = messageData6.getPic()) == null || (str = pic4.getUrl()) == null) {
                                    str = "";
                                }
                                baseControlUtils.showPicOrSvgaDialog(str, "");
                            }
                        }
                    });
                }
            }
            HiloMessageUnionFirstBinding binding13 = getBinding();
            if (binding13 != null && (qMUIRadiusImageView3 = binding13.leftUserIconView) != null) {
                qMUIRadiusImageView3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.UnionFirstMessageHolder$layoutViews$$inlined$singleClick$default$2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView3) > j || (qMUIRadiusImageView3 instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(qMUIRadiusImageView3, currentTimeMillis);
                            QMUIRadiusImageView qMUIRadiusImageView6 = qMUIRadiusImageView3;
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            String userId = ((UnionFirstMessageBean) msg).getUserId();
                            Intrinsics.checkNotNullExpressionValue(userId, "getUserId(...)");
                            baseControlUtils.openPersonPage(userId);
                        }
                    }
                });
            }
            HiloMessageUnionFirstBinding binding14 = getBinding();
            if (binding14 != null && (qMUIRadiusImageView2 = binding14.leftUserIconViews) != null) {
                qMUIRadiusImageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.UnionFirstMessageHolder$layoutViews$$inlined$singleClick$default$3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView2) > j || (qMUIRadiusImageView2 instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(qMUIRadiusImageView2, currentTimeMillis);
                            QMUIRadiusImageView qMUIRadiusImageView6 = qMUIRadiusImageView2;
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            String userId = ((UnionFirstMessageBean) msg).getUserId();
                            Intrinsics.checkNotNullExpressionValue(userId, "getUserId(...)");
                            baseControlUtils.openPersonPage(userId);
                        }
                    }
                });
            }
            HiloMessageUnionFirstBinding binding15 = getBinding();
            if (binding15 != null && (qMUIRadiusImageView = binding15.rightUserIconView) != null) {
                qMUIRadiusImageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.UnionFirstMessageHolder$layoutViews$$inlined$singleClick$default$4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - ViewKtxKt.getLastClickTime(qMUIRadiusImageView) > j || (qMUIRadiusImageView instanceof Checkable)) {
                            ViewKtxKt.setLastClickTime(qMUIRadiusImageView, currentTimeMillis);
                            QMUIRadiusImageView qMUIRadiusImageView6 = qMUIRadiusImageView;
                            BaseControlUtils baseControlUtils = BaseControlUtils.INSTANCE;
                            baseControlUtils.openPersonPage(baseControlUtils.getExternalId());
                        }
                    }
                });
            }
            UnionFirstMessage messageData6 = unionFirstMessageBean.getMessageData();
            if (messageData6 == null || (gifts = messageData6.getGifts()) == null || !(!gifts.isEmpty())) {
                return;
            }
            HiloMessageUnionFirstBinding binding16 = getBinding();
            TextView textView6 = binding16 != null ? binding16.giftValue1 : null;
            UnionFirstMessage messageData7 = unionFirstMessageBean.getMessageData();
            int giftNum = (messageData7 == null || (gifts12 = messageData7.getGifts()) == null || (tIMUnionFirstMessageForGift8 = (TIMUnionFirstMessageForGift) gifts12.get(0)) == null) ? 0 : tIMUnionFirstMessageForGift8.getGiftNum();
            UnionFirstMessage messageData8 = unionFirstMessageBean.getMessageData();
            long giftId = (messageData8 == null || (gifts11 = messageData8.getGifts()) == null || (tIMUnionFirstMessageForGift7 = (TIMUnionFirstMessageForGift) gifts11.get(0)) == null) ? 0L : tIMUnionFirstMessageForGift7.getGiftId();
            HiloMessageUnionFirstBinding binding17 = getBinding();
            showGiftItemAndOnClick(textView6, giftNum, giftId, binding17 != null ? binding17.giftPic1 : null);
            UnionFirstMessage messageData9 = unionFirstMessageBean.getMessageData();
            if (((messageData9 == null || (gifts10 = messageData9.getGifts()) == null) ? 0 : gifts10.size()) > 1) {
                HiloMessageUnionFirstBinding binding18 = getBinding();
                TextView textView7 = binding18 != null ? binding18.giftValue2 : null;
                UnionFirstMessage messageData10 = unionFirstMessageBean.getMessageData();
                int giftNum2 = (messageData10 == null || (gifts9 = messageData10.getGifts()) == null || (tIMUnionFirstMessageForGift6 = (TIMUnionFirstMessageForGift) gifts9.get(1)) == null) ? 0 : tIMUnionFirstMessageForGift6.getGiftNum();
                UnionFirstMessage messageData11 = unionFirstMessageBean.getMessageData();
                long giftId2 = (messageData11 == null || (gifts8 = messageData11.getGifts()) == null || (tIMUnionFirstMessageForGift5 = (TIMUnionFirstMessageForGift) gifts8.get(1)) == null) ? 0L : tIMUnionFirstMessageForGift5.getGiftId();
                HiloMessageUnionFirstBinding binding19 = getBinding();
                showGiftItemAndOnClick(textView7, giftNum2, giftId2, binding19 != null ? binding19.giftPic2 : null);
            }
            UnionFirstMessage messageData12 = unionFirstMessageBean.getMessageData();
            if (((messageData12 == null || (gifts7 = messageData12.getGifts()) == null) ? 0 : gifts7.size()) > 2) {
                HiloMessageUnionFirstBinding binding20 = getBinding();
                TextView textView8 = binding20 != null ? binding20.giftValue3 : null;
                UnionFirstMessage messageData13 = unionFirstMessageBean.getMessageData();
                int giftNum3 = (messageData13 == null || (gifts6 = messageData13.getGifts()) == null || (tIMUnionFirstMessageForGift4 = (TIMUnionFirstMessageForGift) gifts6.get(2)) == null) ? 0 : tIMUnionFirstMessageForGift4.getGiftNum();
                UnionFirstMessage messageData14 = unionFirstMessageBean.getMessageData();
                long giftId3 = (messageData14 == null || (gifts5 = messageData14.getGifts()) == null || (tIMUnionFirstMessageForGift3 = (TIMUnionFirstMessageForGift) gifts5.get(2)) == null) ? 0L : tIMUnionFirstMessageForGift3.getGiftId();
                HiloMessageUnionFirstBinding binding21 = getBinding();
                showGiftItemAndOnClick(textView8, giftNum3, giftId3, binding21 != null ? binding21.giftPic3 : null);
            }
            UnionFirstMessage messageData15 = unionFirstMessageBean.getMessageData();
            if (((messageData15 == null || (gifts4 = messageData15.getGifts()) == null) ? 0 : gifts4.size()) > 3) {
                HiloMessageUnionFirstBinding binding22 = getBinding();
                TextView textView9 = binding22 != null ? binding22.giftValue4 : null;
                UnionFirstMessage messageData16 = unionFirstMessageBean.getMessageData();
                if (messageData16 != null && (gifts3 = messageData16.getGifts()) != null && (tIMUnionFirstMessageForGift2 = (TIMUnionFirstMessageForGift) gifts3.get(3)) != null) {
                    i = tIMUnionFirstMessageForGift2.getGiftNum();
                }
                UnionFirstMessage messageData17 = unionFirstMessageBean.getMessageData();
                long giftId4 = (messageData17 == null || (gifts2 = messageData17.getGifts()) == null || (tIMUnionFirstMessageForGift = (TIMUnionFirstMessageForGift) gifts2.get(3)) == null) ? 0L : tIMUnionFirstMessageForGift.getGiftId();
                HiloMessageUnionFirstBinding binding23 = getBinding();
                showGiftItemAndOnClick(textView9, i, giftId4, binding23 != null ? binding23.giftPic4 : null);
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.hilo.viewHolder.MessageEmptyBaseHolder
    @NotNull
    public HiloMessageUnionFirstBinding inflateViewBinding() {
        HiloMessageUnionFirstBinding inflate = HiloMessageUnionFirstBinding.inflate(LayoutInflater.from(((RecyclerView.ViewHolder) this).itemView.getContext()), this.msgContentFrame, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
