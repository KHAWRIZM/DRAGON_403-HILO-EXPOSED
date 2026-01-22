package j5;

import android.os.Parcel;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b {
    public static void a(Parcel parcel, int i10) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i10 - 4);
        parcel.writeInt(dataPosition - i10);
        parcel.setDataPosition(dataPosition);
    }

    public static void b(Parcel parcel, int i10, int i11) {
        d(parcel, i10);
        parcel.writeInt(i11);
    }

    public static int c(Parcel parcel, int i10) {
        parcel.writeInt(i10 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    private static void d(Parcel parcel, int i10) {
        parcel.writeInt(i10 | 262144);
    }
}
