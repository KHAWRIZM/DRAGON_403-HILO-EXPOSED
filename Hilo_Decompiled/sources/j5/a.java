package j5;

import android.os.Parcel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a {

    /* renamed from: j5.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class C٠١٧٣a extends RuntimeException {
        public C٠١٧٣a(String str) {
            super(str);
        }
    }

    public static int a(Parcel parcel, int i10) {
        c(parcel, i10);
        return parcel.readInt();
    }

    public static int b(Parcel parcel, int i10) {
        if ((i10 & (-65536)) != -65536) {
            return (i10 >> 16) & 65535;
        }
        return parcel.readInt();
    }

    private static void c(Parcel parcel, int i10) {
        int b10 = b(parcel, i10);
        if (b10 == 4) {
            return;
        }
        throw new C٠١٧٣a("Expected size 4 got " + b10 + " (0x" + Integer.toHexString(b10) + ")");
    }
}
