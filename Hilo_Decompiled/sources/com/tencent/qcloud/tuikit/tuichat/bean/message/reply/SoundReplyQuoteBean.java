package com.tencent.qcloud.tuikit.tuichat.bean.message.reply;

import com.tencent.imsdk.v2.V2TIMSoundElem;
import com.tencent.qcloud.tuikit.tuichat.bean.message.SoundMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class SoundReplyQuoteBean extends TUIReplyQuoteBean {
    private String dataPath;
    private V2TIMSoundElem soundElem;

    public int getDuring() {
        V2TIMSoundElem v2TIMSoundElem = this.soundElem;
        if (v2TIMSoundElem != null) {
            return v2TIMSoundElem.getDuration();
        }
        return 0;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.reply.TUIReplyQuoteBean
    public void onProcessReplyQuoteBean(TUIMessageBean tUIMessageBean) {
        if (tUIMessageBean instanceof SoundMessageBean) {
            this.dataPath = ((SoundMessageBean) tUIMessageBean).getDataPath();
            this.soundElem = tUIMessageBean.getV2TIMMessage().getSoundElem();
        }
    }
}
