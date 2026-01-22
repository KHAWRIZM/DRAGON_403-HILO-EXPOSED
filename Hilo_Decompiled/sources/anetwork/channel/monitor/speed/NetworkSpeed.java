package anetwork.channel.monitor.speed;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum NetworkSpeed {
    Slow("弱网络", 1),
    Fast("强网络", 5);

    private final int code;
    private final String desc;

    NetworkSpeed(String str, int i10) {
        this.desc = str;
        this.code = i10;
    }

    public static NetworkSpeed valueOfCode(int i10) {
        if (i10 == 1) {
            return Slow;
        }
        return Fast;
    }

    public int getCode() {
        return this.code;
    }

    public String getDesc() {
        return this.desc;
    }
}
