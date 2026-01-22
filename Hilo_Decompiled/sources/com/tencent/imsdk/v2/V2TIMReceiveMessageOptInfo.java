package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.ReceiveMessageOptInfo;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class V2TIMReceiveMessageOptInfo implements Serializable {
    private ReceiveMessageOptInfo receiveMessageOptInfo = new ReceiveMessageOptInfo();

    public int getAllReceiveMessageOpt() {
        int receiveMessageOpt = this.receiveMessageOptInfo.getReceiveMessageOpt();
        if (receiveMessageOpt == 1) {
            return 0;
        }
        if (receiveMessageOpt == 3) {
            return 2;
        }
        if (receiveMessageOpt != 3) {
            return 0;
        }
        return 3;
    }

    public int getC2CReceiveMessageOpt() {
        int receiveMessageOpt = this.receiveMessageOptInfo.getReceiveMessageOpt();
        if (receiveMessageOpt == 1) {
            return 0;
        }
        if (receiveMessageOpt == 2) {
            return 1;
        }
        if (receiveMessageOpt != 3) {
            return 0;
        }
        return 2;
    }

    public long getDuration() {
        return this.receiveMessageOptInfo.getDuration();
    }

    ReceiveMessageOptInfo getReceiveMessageOptInfo() {
        return this.receiveMessageOptInfo;
    }

    public int getStartHour() {
        return this.receiveMessageOptInfo.getStartHour();
    }

    public int getStartMinute() {
        return this.receiveMessageOptInfo.getStartMinute();
    }

    public int getStartSecond() {
        return this.receiveMessageOptInfo.getStartSecond();
    }

    public long getStartTimeStamp() {
        return this.receiveMessageOptInfo.getStartTimeStamp();
    }

    public String getUserID() {
        return this.receiveMessageOptInfo.getUserID();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setC2CReceiveMessageOpt(int i) {
        this.receiveMessageOptInfo.setReceiveMessageOpt(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setReceiveMessageOptInfo(ReceiveMessageOptInfo receiveMessageOptInfo) {
        this.receiveMessageOptInfo = receiveMessageOptInfo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUserID(String str) {
        this.receiveMessageOptInfo.setUserID(str);
    }
}
