package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.TimeInLineTextLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FaceMessageHolder extends MessageContentHolder {
    private static final int DEFAULT_FACE_MAX_SIZE = 80;
    private final ImageView contentImage;
    private final LinearLayout faceLayout;

    public FaceMessageHolder(View view) {
        super(view);
        this.contentImage = (ImageView) view.findViewById(R.id.face_image);
        this.timeInLineTextLayout = (TimeInLineTextLayout) view.findViewById(R.id.time_in_line_text);
        this.faceLayout = (LinearLayout) view.findViewById(R.id.face_message_content_layout);
    }

    private void performCustomFace(FaceMessageBean faceMessageBean) {
        String str;
        int dip2px = ScreenUtil.dip2px(80.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
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

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public void clearHighLightBackground() {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(null);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.minimalist_face_message_content_layout;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i) {
        performCustomFace((FaceMessageBean) tUIMessageBean);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder
    public void setGravity(boolean z) {
        this.faceLayout.setGravity(8388613);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public void setHighLightBackground(int i) {
        Drawable drawable = this.contentImage.getDrawable();
        if (drawable != null) {
            drawable.setColorFilter(i, PorterDuff.Mode.SRC_OVER);
        }
    }
}
