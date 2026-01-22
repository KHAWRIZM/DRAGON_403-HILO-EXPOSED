package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.FaceReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FaceReplyQuoteView extends TUIReplyQuoteView {
    private final ImageView contentImage;

    public FaceReplyQuoteView(Context context) {
        super(context);
        this.contentImage = (ImageView) findViewById(R.id.content_image_iv);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.TUIReplyQuoteView
    public int getLayoutResourceId() {
        return R.layout.chat_reply_quote_face_layout;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.reply.TUIReplyQuoteView
    public void onDrawReplyQuote(TUIReplyQuoteBean tUIReplyQuoteBean) {
        FaceReplyQuoteBean faceReplyQuoteBean = (FaceReplyQuoteBean) tUIReplyQuoteBean;
        String str = new String(faceReplyQuoteBean.getData());
        ViewGroup.LayoutParams layoutParams = this.contentImage.getLayoutParams();
        if (layoutParams != null) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.reply_message_image_size);
            layoutParams.width = dimensionPixelSize;
            layoutParams.height = dimensionPixelSize;
            this.contentImage.setLayoutParams(layoutParams);
        }
        FaceManager.loadFace(faceReplyQuoteBean.getIndex(), str, this.contentImage);
    }
}
