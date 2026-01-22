package c6;

import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class d extends a {

    /* renamed from: a, reason: collision with root package name */
    private long f٥٩٢٧a;

    /* renamed from: b, reason: collision with root package name */
    private int f٥٩٢٨b;

    public d(long j10, int i10) {
        this.f٥٩٢٧a = j10;
        this.f٥٩٢٨b = i10;
    }

    @Override // c6.b
    public int a() {
        return this.f٥٩٢٨b;
    }

    @Override // c6.c
    public boolean b(File file) {
        if (file.length() > this.f٥٩٢٧a) {
            return true;
        }
        return false;
    }
}
