package m4;

import java.io.IOException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class e extends IOException {
    private static final long serialVersionUID = 1;

    /* renamed from: a, reason: collision with root package name */
    private final int f١٥٩٧١a;

    public e(int i10) {
        this("Http request failed", i10);
    }

    public e(String str, int i10) {
        this(str, i10, null);
    }

    public e(String str, int i10, Throwable th) {
        super(str + ", status code: " + i10, th);
        this.f١٥٩٧١a = i10;
    }
}
