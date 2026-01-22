package y5;

import java.io.File;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {
    public static void a(File file, c6.b bVar) {
        String name = file.getName();
        String parent = file.getParent();
        int a10 = bVar.a();
        if (a10 > 0) {
            File file2 = new File(parent, bVar.c(name, a10));
            if (file2.exists()) {
                file2.delete();
            }
            for (int i10 = a10 - 1; i10 > 0; i10--) {
                File file3 = new File(parent, bVar.c(name, i10));
                if (file3.exists()) {
                    file3.renameTo(new File(parent, bVar.c(name, i10 + 1)));
                }
            }
            file.renameTo(new File(parent, bVar.c(name, 1)));
            return;
        }
        if (a10 == 0) {
            for (int i11 = 1; i11 < Integer.MAX_VALUE; i11++) {
                File file4 = new File(parent, bVar.c(name, i11));
                if (!file4.exists()) {
                    file.renameTo(file4);
                    return;
                }
            }
        }
    }

    public static void b(c6.b bVar) {
        int a10 = bVar.a();
        if (a10 >= 0) {
            if (a10 != Integer.MAX_VALUE) {
                return;
            }
            throw new IllegalArgumentException("Max backup index too big: " + a10);
        }
        throw new IllegalArgumentException("Max backup index should not be less than 0");
    }
}
