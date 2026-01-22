package anet.channel.monitor;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    protected long f٤٨٤١b;

    /* renamed from: c, reason: collision with root package name */
    private final double f٤٨٤٢c = 40.0d;

    /* renamed from: a, reason: collision with root package name */
    boolean f٤٨٤٠a = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٤٨٤٣d = true;

    public int a() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b() {
        if (!this.f٤٨٤٣d) {
            return false;
        }
        if (System.currentTimeMillis() - this.f٤٨٤١b > a() * 1000) {
            this.f٤٨٤٣d = false;
            return false;
        }
        return true;
    }

    public boolean a(double d10) {
        return d10 < 40.0d;
    }
}
