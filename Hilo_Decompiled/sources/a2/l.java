package a2;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class l extends c {

    /* renamed from: d, reason: collision with root package name */
    g f١٩٠d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(String str) {
        this.f١٢٢a = str;
        double[] dArr = new double[str.length() / 2];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i10 = 0;
        while (indexOf2 != -1) {
            dArr[i10] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i10++;
        }
        dArr[i10] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
        this.f١٩٠d = d(Arrays.copyOf(dArr, i10 + 1));
    }

    private static g d(double[] dArr) {
        int length = (dArr.length * 3) - 2;
        int length2 = dArr.length - 1;
        double d10 = 1.0d / length2;
        double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 1);
        double[] dArr3 = new double[length];
        for (int i10 = 0; i10 < dArr.length; i10++) {
            double d11 = dArr[i10];
            int i11 = i10 + length2;
            dArr2[i11][0] = d11;
            double d12 = i10 * d10;
            dArr3[i11] = d12;
            if (i10 > 0) {
                int i12 = (length2 * 2) + i10;
                dArr2[i12][0] = d11 + 1.0d;
                dArr3[i12] = d12 + 1.0d;
                int i13 = i10 - 1;
                dArr2[i13][0] = (d11 - 1.0d) - d10;
                dArr3[i13] = (d12 - 1.0d) - d10;
            }
        }
        g gVar = new g(dArr3, dArr2);
        PrintStream printStream = System.out;
        printStream.println(" 0 " + gVar.c(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0));
        printStream.println(" 1 " + gVar.c(1.0d, 0));
        return gVar;
    }

    @Override // a2.c
    public double a(double d10) {
        return this.f١٩٠d.c(d10, 0);
    }

    @Override // a2.c
    public double b(double d10) {
        return this.f١٩٠d.f(d10, 0);
    }
}
