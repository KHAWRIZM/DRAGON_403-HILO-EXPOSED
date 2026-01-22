package g9;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public enum b {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);


    /* renamed from: a, reason: collision with root package name */
    private final int[] f١٤٤٥٢a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٤٤٥٣b;

    b(int[] iArr, int i10) {
        this.f١٤٤٥٢a = iArr;
        this.f١٤٤٥٣b = i10;
    }

    public int a() {
        return this.f١٤٤٥٣b;
    }

    public int c(c cVar) {
        char c10;
        int f10 = cVar.f();
        if (f10 <= 9) {
            c10 = 0;
        } else if (f10 <= 26) {
            c10 = 1;
        } else {
            c10 = 2;
        }
        return this.f١٤٤٥٢a[c10];
    }
}
