package anet.channel.entity;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum ENV {
    ONLINE(0),
    PREPARE(1),
    TEST(2);

    private int envMode;

    ENV(int i10) {
        this.envMode = i10;
    }

    public int getEnvMode() {
        return this.envMode;
    }

    public void setEnvMode(int i10) {
        this.envMode = i10;
    }

    public static ENV valueOf(int i10) {
        if (i10 == 1) {
            return PREPARE;
        }
        if (i10 != 2) {
            return ONLINE;
        }
        return TEST;
    }
}
