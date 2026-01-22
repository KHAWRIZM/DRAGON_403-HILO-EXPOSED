package anet.channel.heartbeat;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class HeartbeatManager {
    public static IHeartbeat getDefaultBackgroundAccsHeartbeat() {
        return new a();
    }

    public static IHeartbeat getDefaultHeartbeat() {
        return new b();
    }
}
