package anetwork.channel.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface ParcelableBodyHandler extends IInterface {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class Stub extends Binder implements ParcelableBodyHandler {
        private static final String DESCRIPTOR = "anetwork.channel.aidl.ParcelableBodyHandler";
        static final int TRANSACTION_isCompleted = 2;
        static final int TRANSACTION_read = 1;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        private static class Proxy implements ParcelableBodyHandler {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f٥١١٤a;

            Proxy(IBinder iBinder) {
                this.f٥١١٤a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f٥١١٤a;
            }

            @Override // anetwork.channel.aidl.ParcelableBodyHandler
            public boolean isCompleted() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    boolean z10 = false;
                    this.f٥١١٤a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z10 = true;
                    }
                    return z10;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // anetwork.channel.aidl.ParcelableBodyHandler
            public int read(byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeByteArray(bArr);
                    this.f٥١١٤a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.readByteArray(bArr);
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ParcelableBodyHandler asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ParcelableBodyHandler)) {
                return (ParcelableBodyHandler) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 1598968902) {
                        return super.onTransact(i10, parcel, parcel2, i11);
                    }
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                boolean isCompleted = isCompleted();
                parcel2.writeNoException();
                parcel2.writeInt(isCompleted ? 1 : 0);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            byte[] createByteArray = parcel.createByteArray();
            int read = read(createByteArray);
            parcel2.writeNoException();
            parcel2.writeInt(read);
            parcel2.writeByteArray(createByteArray);
            return true;
        }
    }

    boolean isCompleted() throws RemoteException;

    int read(byte[] bArr) throws RemoteException;
}
