package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FaceMessageHolder extends MessageContentHolder {
    private static final int DEFAULT_FACE_MAX_SIZE = 80;
    private final ImageView contentImage;
    private final TextView videoDurationText;
    private final ImageView videoPlayBtn;

    public FaceMessageHolder(View view) {
        super(view);
        this.contentImage = (ImageView) view.findViewById(R.id.content_image_iv);
        this.videoPlayBtn = (ImageView) view.findViewById(R.id.video_play_btn);
        this.videoDurationText = (TextView) view.findViewById(R.id.video_duration_tv);
    }

    private void performCustomFace(FaceMessageBean faceMessageBean) {
        String str;
        int dip2px = ScreenUtil.dip2px(80.0f);
        this.videoPlayBtn.setVisibility(8);
        this.videoDurationText.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        layoutParams.width = dip2px;
        layoutParams.height = dip2px;
        this.contentImage.setLayoutParams(layoutParams);
        if (faceMessageBean.getData() != null) {
            str = new String(faceMessageBean.getData());
        } else {
            str = null;
        }
        FaceManager.loadFace(faceMessageBean.getIndex(), str, this.contentImage);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void clearHighLightBackground() {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(null);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.message_adapter_content_image;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i) {
        performCustomFace((FaceMessageBean) tUIMessageBean);
        if (tUIMessageBean.getMessageReactBean() == null || tUIMessageBean.getMessageReactBean().getReactSize() <= 0) {
            this.msgArea.setBackground(null);
            this.msgArea.setPadding(0, 0, 0, 0);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder.MessageBaseHolder
    public void setHighLightBackground(int i) {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(i, PorterDuff.Mode.SRC_OVER);
        }
    }
}
