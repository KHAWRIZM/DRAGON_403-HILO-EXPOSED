package com.qiahao.nextvideo.data.model;

import kotlin.Metadata;
import org.android.agoo.common.AgooConstants;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/qiahao/nextvideo/data/model/AutoInviteUserUpMicBean;", "", AgooConstants.MESSAGE_FLAG, "", "type", "", "diamondNum", "<init>", "(ZII)V", "getFlag", "()Z", "setFlag", "(Z)V", "getType", "()I", "setType", "(I)V", "getDiamondNum", "setDiamondNum", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class AutoInviteUserUpMicBean {
    private int diamondNum;
    private boolean flag;
    private int type;

    public AutoInviteUserUpMicBean(boolean z, int i, int i2) {
        this.flag = z;
        this.type = i;
        this.diamondNum = i2;
    }

    public final int getDiamondNum() {
        return this.diamondNum;
    }

    public final boolean getFlag() {
        return this.flag;
    }

    public final int getType() {
        return this.type;
    }

    public final void setDiamondNum(int i) {
        this.diamondNum = i;
    }

    public final void setFlag(boolean z) {
        this.flag = z;
    }

    public final void setType(int i) {
        this.type = i;
    }
}
