package anet.channel.strategy;

import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ConnEvent {
    public boolean isSuccess = false;
    public long connTime = LongCompanionObject.MAX_VALUE;
    public boolean isAccs = false;

    public String toString() {
        if (this.isSuccess) {
            return "ConnEvent#Success";
        }
        return "ConnEvent#Fail";
    }
}
