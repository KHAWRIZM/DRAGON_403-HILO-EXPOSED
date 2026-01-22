package v4;

import android.os.Build;
import android.os.ParcelFileDescriptor;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class d0 implements m4.k {

    /* renamed from: a, reason: collision with root package name */
    private final u f١٨٤٨٥a;

    public d0(u uVar) {
        this.f١٨٤٨٥a = uVar;
    }

    private boolean c(ParcelFileDescriptor parcelFileDescriptor) {
        String str = Build.MANUFACTURER;
        if ((!"HUAWEI".equalsIgnoreCase(str) && !"HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912) {
            return true;
        }
        return false;
    }

    @Override // m4.k
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public o4.v decode(ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, m4.i iVar) {
        return this.f١٨٤٨٥a.d(parcelFileDescriptor, i10, i11, iVar);
    }

    @Override // m4.k
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public boolean handles(ParcelFileDescriptor parcelFileDescriptor, m4.i iVar) {
        if (c(parcelFileDescriptor) && this.f١٨٤٨٥a.o(parcelFileDescriptor)) {
            return true;
        }
        return false;
    }
}
