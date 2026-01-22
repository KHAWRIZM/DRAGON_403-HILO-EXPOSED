package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.reply;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import c5.h;
import com.bumptech.glide.Glide;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.MessageRepliesBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import p4.d;
import v4.m;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ReplyPreviewView extends FrameLayout {
    private ImageView firstImg;
    private MessageRepliesBean messageRepliesBean;
    private TextView replyText;
    private ImageView secondImg;
    private ImageView thirdImg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class ReplyRingCircleCrop extends m {
        ReplyRingCircleCrop() {
        }

        protected Bitmap transform(d dVar, Bitmap bitmap, int i, int i2) {
            Bitmap f = dVar.f(i, i2, Bitmap.Config.ARGB_8888);
            int dip2px = ScreenUtil.dip2px(1.0f);
            int i3 = dip2px * 2;
            Bitmap transform = super.transform(dVar, bitmap, i - i3, i2 - i3);
            Canvas canvas = new Canvas(f);
            Paint paint = new Paint(3);
            paint.setColor(-1);
            float f2 = i / 2;
            float f3 = i2 / 2;
            canvas.drawCircle(f2, f3, r3 / 2, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(transform, (Rect) null, new Rect(dip2px, dip2px, i - dip2px, i2 - dip2px), paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
            canvas.drawCircle(f2, f3, f2, paint);
            return f;
        }
    }

    public ReplyPreviewView(Context context) {
        super(context);
        init(context);
    }

    private List<String> getReplyUserIconLt(List<MessageRepliesBean.ReplyBean> list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<MessageRepliesBean.ReplyBean> it = list.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(it.next().getSenderFaceUrl());
            if (linkedHashSet.size() >= 3) {
                break;
            }
        }
        return new ArrayList(linkedHashSet);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.chat_minimalist_reply_preview_layout, this);
        this.firstImg = (ImageView) findViewById(R.id.first_avatar);
        this.secondImg = (ImageView) findViewById(R.id.second_avatar);
        this.thirdImg = (ImageView) findViewById(R.id.third_avatar);
        this.replyText = (TextView) findViewById(R.id.reply_text);
    }

    private void loadAvatar(ImageView imageView, Object obj) {
        Glide.with(getContext()).p(obj).c().q0(new h().k0(new ReplyRingCircleCrop()).j(com.tencent.qcloud.tuicore.R.drawable.core_default_user_icon_light)).D0(imageView);
    }

    private void setView() {
        String str;
        MessageRepliesBean messageRepliesBean = this.messageRepliesBean;
        if (messageRepliesBean != null && messageRepliesBean.getRepliesSize() > 0) {
            setVisibility(0);
            this.firstImg.setVisibility(8);
            this.secondImg.setVisibility(8);
            this.thirdImg.setVisibility(8);
            this.replyText.setText(getResources().getString(R.string.chat_reply_num, Integer.valueOf(this.messageRepliesBean.getRepliesSize())));
            List<String> replyUserIconLt = getReplyUserIconLt(this.messageRepliesBean.getReplies());
            if (replyUserIconLt != null && !replyUserIconLt.isEmpty()) {
                String str2 = replyUserIconLt.get(0);
                String str3 = null;
                if (replyUserIconLt.size() > 1) {
                    str = replyUserIconLt.get(1);
                } else {
                    str = null;
                }
                if (replyUserIconLt.size() > 2) {
                    str3 = replyUserIconLt.get(2);
                }
                this.firstImg.setVisibility(0);
                loadAvatar(this.firstImg, str2);
                if (str != null) {
                    this.secondImg.setVisibility(0);
                    loadAvatar(this.secondImg, str);
                }
                if (replyUserIconLt.size() == 3 && str3 != null) {
                    this.thirdImg.setVisibility(0);
                    loadAvatar(this.thirdImg, str3);
                    return;
                } else {
                    if (replyUserIconLt.size() > 3) {
                        this.thirdImg.setVisibility(0);
                        loadAvatar(this.thirdImg, Integer.valueOf(R.drawable.chat_reply_more_icon));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        setVisibility(8);
    }

    public void setMessageRepliesBean(MessageRepliesBean messageRepliesBean) {
        this.messageRepliesBean = messageRepliesBean;
        setView();
    }

    public ReplyPreviewView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public ReplyPreviewView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    @RequiresApi(api = 21)
    public ReplyPreviewView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }
}
