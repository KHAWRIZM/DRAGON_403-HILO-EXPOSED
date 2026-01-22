package y5;

import c6.c;
import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class a implements c6.b {

    /* renamed from: a, reason: collision with root package name */
    private c f١٩١٥٥a;

    public a(c cVar) {
        this.f١٩١٥٥a = cVar;
    }

    @Override // c6.b
    public int a() {
        return 1;
    }

    @Override // c6.c
    public boolean b(File file) {
        return this.f١٩١٥٥a.b(file);
    }

    @Override // c6.b
    public String c(String str, int i10) {
        return str + ".bak";
    }
}
