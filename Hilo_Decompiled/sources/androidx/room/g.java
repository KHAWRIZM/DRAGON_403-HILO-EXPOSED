package androidx.room;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.f;
import kotlin.text.Typography;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface g extends IInterface {

    /* renamed from: d, reason: collision with root package name */
    public static final String f٤٠٥٦d = "androidx$room$IMultiInstanceInvalidationService".replace(Typography.dollar, '.');

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class a extends Binder implements g {
        static final int TRANSACTION_broadcastInvalidation = 3;
        static final int TRANSACTION_registerCallback = 1;
        static final int TRANSACTION_unregisterCallback = 2;

        /* renamed from: androidx.room.g$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        private static class C٠٠٥٤a implements g {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f٤٠٥٧a;

            C٠٠٥٤a(IBinder iBinder) {
                this.f٤٠٥٧a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f٤٠٥٧a;
            }

            @Override // androidx.room.g
            public void broadcastInvalidation(int i10, String[] strArr) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(g.f٤٠٥٦d);
                    obtain.writeInt(i10);
                    obtain.writeStringArray(strArr);
                    this.f٤٠٥٧a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // androidx.room.g
            public int registerCallback(f fVar, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(g.f٤٠٥٦d);
                    obtain.writeStrongInterface(fVar);
                    obtain.writeString(str);
                    this.f٤٠٥٧a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // androidx.room.g
            public void unregisterCallback(f fVar, int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(g.f٤٠٥٦d);
                    obtain.writeStrongInterface(fVar);
                    obtain.writeInt(i10);
                    this.f٤٠٥٧a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, g.f٤٠٥٦d);
        }

        public static g asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(g.f٤٠٥٦d);
            if (queryLocalInterface != null && (queryLocalInterface instanceof g)) {
                return (g) queryLocalInterface;
            }
            return new C٠٠٥٤a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            String str = g.f٤٠٥٦d;
            if (i10 >= 1 && i10 <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i10 == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    broadcastInvalidation(parcel.readInt(), parcel.createStringArray());
                } else {
                    unregisterCallback(f.a.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    parcel2.writeNoException();
                }
            } else {
                int registerCallback = registerCallback(f.a.asInterface(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(registerCallback);
            }
            return true;
        }
    }

    void broadcastInvalidation(int i10, String[] strArr);

    int registerCallback(f fVar, String str);

    void unregisterCallback(f fVar, int i10);
}
