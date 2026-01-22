package c6;

import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class e implements c {

    /* renamed from: a, reason: collision with root package name */
    private long f٥٩٢٩a;

    public e(long j10) {
        this.f٥٩٢٩a = j10;
    }

    @Override // c6.c
    public boolean b(File file) {
        if (file.length() > this.f٥٩٢٩a) {
            return true;
        }
        return false;
    }
}
