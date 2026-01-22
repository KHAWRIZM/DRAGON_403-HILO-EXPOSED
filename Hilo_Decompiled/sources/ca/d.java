package ca;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private static final List f٦٠١٨a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private static final Random f٦٠١٩b = new Random();

    public static synchronized int a(int i10) {
        int i11;
        int nextInt;
        synchronized (d.class) {
            while (true) {
                if (i10 > 20000) {
                    i11 = i10 - 10000;
                } else {
                    i11 = i10 / 2;
                }
                nextInt = f٦٠١٩b.nextInt(i10 - i11) + i11;
                if (nextInt != 1025) {
                    List list = f٦٠١٨a;
                    if (!list.contains(Integer.valueOf(nextInt))) {
                        list.add(Integer.valueOf(nextInt));
                    }
                }
            }
        }
        return nextInt;
    }

    public static synchronized void b(int i10) {
        synchronized (d.class) {
            f٦٠١٨a.remove(Integer.valueOf(i10));
        }
    }
}
