package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import kotlin.text.Typography;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface f extends IInterface {

    /* renamed from: c, reason: collision with root package name */
    public static final String f٤٠٥٤c = "androidx$room$IMultiInstanceInvalidationCallback".replace(Typography.dollar, '.');

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class a extends Binder implements f {
        static final int TRANSACTION_onInvalidation = 1;

        /* renamed from: androidx.room.f$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        private static class C٠٠٥٣a implements f {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f٤٠٥٥a;

            C٠٠٥٣a(IBinder iBinder) {
                this.f٤٠٥٥a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f٤٠٥٥a;
            }

            @Override // androidx.room.f
            public void onInvalidation(String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(f.f٤٠٥٤c);
                    obtain.writeStringArray(strArr);
                    this.f٤٠٥٥a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, f.f٤٠٥٤c);
        }

        public static f asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f.f٤٠٥٤c);
            if (queryLocalInterface != null && (queryLocalInterface instanceof f)) {
                return (f) queryLocalInterface;
            }
            return new C٠٠٥٣a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            String str = f.f٤٠٥٤c;
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i10 != 1) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            onInvalidation(parcel.createStringArray());
            return true;
        }
    }

    void onInvalidation(String[] strArr);
}
