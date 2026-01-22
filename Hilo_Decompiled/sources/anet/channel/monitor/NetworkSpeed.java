package anet.channel.monitor;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum NetworkSpeed {
    Slow("弱网络", 1),
    Fast("强网络", 5);


    /* renamed from: a, reason: collision with root package name */
    private final String f٤٨٠٤a;

    /* renamed from: b, reason: collision with root package name */
    private final int f٤٨٠٥b;

    NetworkSpeed(String str, int i10) {
        this.f٤٨٠٤a = str;
        this.f٤٨٠٥b = i10;
    }

    public static NetworkSpeed valueOfCode(int i10) {
        if (i10 == 1) {
            return Slow;
        }
        return Fast;
    }

    public int getCode() {
        return this.f٤٨٠٥b;
    }

    public String getDesc() {
        return this.f٤٨٠٤a;
    }
}
