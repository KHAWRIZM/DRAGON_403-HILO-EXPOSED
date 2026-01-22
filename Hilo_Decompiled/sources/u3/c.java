package u3;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum c {
    JSON(".json"),
    ZIP(".zip"),
    GZIP(".gz");


    /* renamed from: a, reason: collision with root package name */
    public final String f١٨٢٣٣a;

    c(String str) {
        this.f١٨٢٣٣a = str;
    }

    public String c() {
        return ".temp" + this.f١٨٢٣٣a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f١٨٢٣٣a;
    }
}
