package uc;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public enum b {
    None(0, false, false, false, false, false),
    PullDownToRefresh(1, true, false, false, false, false),
    PullUpToLoad(2, true, false, false, false, false),
    PullDownCanceled(1, false, false, false, false, false),
    PullUpCanceled(2, false, false, false, false, false),
    ReleaseToRefresh(1, true, false, false, false, true),
    ReleaseToLoad(2, true, false, false, false, true),
    ReleaseToTwoLevel(1, true, false, false, true, true),
    TwoLevelReleased(1, false, false, false, true, false),
    RefreshReleased(1, false, false, false, false, false),
    LoadReleased(2, false, false, false, false, false),
    Refreshing(1, false, true, false, false, false),
    Loading(2, false, true, false, false, false),
    TwoLevel(1, false, true, false, true, false),
    RefreshFinish(1, false, false, true, false, false),
    LoadFinish(2, false, false, true, false, false),
    TwoLevelFinish(1, false, false, true, true, false);

    public final boolean a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    b(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        if (i == 1) {
            z6 = true;
        } else {
            z6 = false;
        }
        this.a = z6;
        this.b = i == 2;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.c = z4;
        this.g = z5;
    }

    public b c() {
        if (this.a && !this.c) {
            return values()[ordinal() + 1];
        }
        return this;
    }

    public b d() {
        if (this.b && !this.c) {
            return values()[ordinal() - 1];
        }
        return this;
    }
}
