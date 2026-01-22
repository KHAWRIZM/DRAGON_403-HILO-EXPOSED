package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public interface IGmsServiceBroker extends IInterface {

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static abstract class Stub extends Binder implements IGmsServiceBroker {
        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        @Override // android.os.IInterface
        @KeepForSdk
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public final boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
            IGmsCallbacks zzabVar;
            if (i10 > 0 && i10 <= 16777215) {
                parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                IBinder readStrongBinder = parcel.readStrongBinder();
                GetServiceRequest getServiceRequest = null;
                if (readStrongBinder == null) {
                    zzabVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                    if (queryLocalInterface instanceof IGmsCallbacks) {
                        zzabVar = (IGmsCallbacks) queryLocalInterface;
                    } else {
                        zzabVar = new zzab(readStrongBinder);
                    }
                }
                if (i10 == 46) {
                    if (parcel.readInt() != 0) {
                        getServiceRequest = GetServiceRequest.CREATOR.createFromParcel(parcel);
                    }
                    getService(zzabVar, getServiceRequest);
                    Preconditions.checkNotNull(parcel2);
                    parcel2.writeNoException();
                    return true;
                }
                if (i10 == 47) {
                    if (parcel.readInt() != 0) {
                        zzal.CREATOR.createFromParcel(parcel);
                    }
                    throw new UnsupportedOperationException();
                }
                parcel.readInt();
                if (i10 != 4) {
                    parcel.readString();
                    if (i10 != 1) {
                        if (i10 != 2 && i10 != 23 && i10 != 25 && i10 != 27) {
                            if (i10 != 30) {
                                if (i10 != 34) {
                                    if (i10 != 41 && i10 != 43 && i10 != 37 && i10 != 38) {
                                        switch (i10) {
                                            case 9:
                                                parcel.readString();
                                                parcel.createStringArray();
                                                parcel.readString();
                                                parcel.readStrongBinder();
                                                parcel.readString();
                                                if (parcel.readInt() != 0) {
                                                    break;
                                                }
                                                break;
                                            case 10:
                                                parcel.readString();
                                                parcel.createStringArray();
                                                break;
                                            case 19:
                                                parcel.readStrongBinder();
                                                if (parcel.readInt() != 0) {
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                } else {
                                    parcel.readString();
                                }
                            }
                            parcel.createStringArray();
                            parcel.readString();
                            if (parcel.readInt() != 0) {
                            }
                        }
                        if (parcel.readInt() != 0) {
                        }
                    } else {
                        parcel.readString();
                        parcel.createStringArray();
                        parcel.readString();
                        if (parcel.readInt() != 0) {
                        }
                    }
                }
                throw new UnsupportedOperationException();
            }
            return super.onTransact(i10, parcel, parcel2, i11);
        }
    }

    @KeepForSdk
    void getService(IGmsCallbacks iGmsCallbacks, GetServiceRequest getServiceRequest) throws RemoteException;
}
