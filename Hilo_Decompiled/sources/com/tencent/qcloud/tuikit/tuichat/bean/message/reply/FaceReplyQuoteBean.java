package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.qcloud.tuikit.tuichat.bean.message.FaceMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FaceReplyQuoteBean extends TUIReplyQuoteBean {
    private byte[] data;
    private int index;

    public byte[] getData() {
        byte[] bArr = this.data;
        if (bArr != null) {
            return bArr;
        }
        return new byte[0];
    }

    public int getIndex() {
        return this.index;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean
    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof FaceMessageBean) {
            FaceMessageBean faceMessageBean = (FaceMessageBean) tUIMessageBean;
            this.data = faceMessageBean.getData();
            this.index = faceMessageBean.getIndex();
        }
    }
}
