package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzcq extends zzbm implements zzcr {
    public zzcq() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzcr asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (queryLocalInterface instanceof zzcr) {
            return (zzcr) queryLocalInterface;
        }
        return new zzcp(iBinder);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0005. Please report as an issue. */
    @Override // com.google.android.gms.internal.measurement.zzbm
    protected final boolean zza(int i10, Parcel parcel, Parcel parcel2, int i11) throws RemoteException {
        zzcu zzcsVar;
        zzcu zzcuVar;
        zzcu zzcuVar2 = null;
        zzcx zzcxVar = null;
        zzcu zzcuVar3 = null;
        zzcu zzcuVar4 = null;
        zzcu zzcuVar5 = null;
        zzcu zzcuVar6 = null;
        zzda zzdaVar = null;
        zzda zzdaVar2 = null;
        zzda zzdaVar3 = null;
        zzcu zzcuVar7 = null;
        zzcu zzcuVar8 = null;
        zzcu zzcuVar9 = null;
        zzcu zzcuVar10 = null;
        zzcu zzcuVar11 = null;
        zzcu zzcuVar12 = null;
        zzdc zzdcVar = null;
        zzcu zzcuVar13 = null;
        zzcu zzcuVar14 = null;
        zzcu zzcuVar15 = null;
        zzcu zzcuVar16 = null;
        switch (i10) {
            case 1:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzdd zzddVar = (zzdd) zzbn.zzb(parcel, zzdd.CREATOR);
                long readLong = parcel.readLong();
                zzbn.zzf(parcel);
                initialize(asInterface, zzddVar, readLong);
                parcel2.writeNoException();
                return true;
            case 2:
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                Bundle bundle = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                boolean zza = zzbn.zza(parcel);
                boolean zza2 = zzbn.zza(parcel);
                long readLong2 = parcel.readLong();
                zzbn.zzf(parcel);
                logEvent(readString, readString2, bundle, zza, zza2, readLong2);
                parcel2.writeNoException();
                return true;
            case 3:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                Bundle bundle2 = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzcuVar = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface instanceof zzcu) {
                        zzcsVar = (zzcu) queryLocalInterface;
                    } else {
                        zzcsVar = new zzcs(readStrongBinder);
                    }
                    zzcuVar = zzcsVar;
                }
                long readLong3 = parcel.readLong();
                zzbn.zzf(parcel);
                logEventAndBundle(readString3, readString4, bundle2, zzcuVar, readLong3);
                parcel2.writeNoException();
                return true;
            case 4:
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                boolean zza3 = zzbn.zza(parcel);
                long readLong4 = parcel.readLong();
                zzbn.zzf(parcel);
                setUserProperty(readString5, readString6, asInterface2, zza3, readLong4);
                parcel2.writeNoException();
                return true;
            case 5:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                boolean zza4 = zzbn.zza(parcel);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface2 instanceof zzcu) {
                        zzcuVar2 = (zzcu) queryLocalInterface2;
                    } else {
                        zzcuVar2 = new zzcs(readStrongBinder2);
                    }
                }
                zzbn.zzf(parcel);
                getUserProperties(readString7, readString8, zza4, zzcuVar2);
                parcel2.writeNoException();
                return true;
            case 6:
                String readString9 = parcel.readString();
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface3 instanceof zzcu) {
                        zzcuVar16 = (zzcu) queryLocalInterface3;
                    } else {
                        zzcuVar16 = new zzcs(readStrongBinder3);
                    }
                }
                zzbn.zzf(parcel);
                getMaxUserProperties(readString9, zzcuVar16);
                parcel2.writeNoException();
                return true;
            case 7:
                String readString10 = parcel.readString();
                long readLong5 = parcel.readLong();
                zzbn.zzf(parcel);
                setUserId(readString10, readLong5);
                parcel2.writeNoException();
                return true;
            case 8:
                Bundle bundle3 = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                long readLong6 = parcel.readLong();
                zzbn.zzf(parcel);
                setConditionalUserProperty(bundle3, readLong6);
                parcel2.writeNoException();
                return true;
            case 9:
                String readString11 = parcel.readString();
                String readString12 = parcel.readString();
                Bundle bundle4 = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                zzbn.zzf(parcel);
                clearConditionalUserProperty(readString11, readString12, bundle4);
                parcel2.writeNoException();
                return true;
            case 10:
                String readString13 = parcel.readString();
                String readString14 = parcel.readString();
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface4 instanceof zzcu) {
                        zzcuVar15 = (zzcu) queryLocalInterface4;
                    } else {
                        zzcuVar15 = new zzcs(readStrongBinder4);
                    }
                }
                zzbn.zzf(parcel);
                getConditionalUserProperties(readString13, readString14, zzcuVar15);
                parcel2.writeNoException();
                return true;
            case 11:
                boolean zza5 = zzbn.zza(parcel);
                long readLong7 = parcel.readLong();
                zzbn.zzf(parcel);
                setMeasurementEnabled(zza5, readLong7);
                parcel2.writeNoException();
                return true;
            case 12:
                long readLong8 = parcel.readLong();
                zzbn.zzf(parcel);
                resetAnalyticsData(readLong8);
                parcel2.writeNoException();
                return true;
            case 13:
                long readLong9 = parcel.readLong();
                zzbn.zzf(parcel);
                setMinimumSessionDuration(readLong9);
                parcel2.writeNoException();
                return true;
            case 14:
                long readLong10 = parcel.readLong();
                zzbn.zzf(parcel);
                setSessionTimeoutDuration(readLong10);
                parcel2.writeNoException();
                return true;
            case 15:
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString15 = parcel.readString();
                String readString16 = parcel.readString();
                long readLong11 = parcel.readLong();
                zzbn.zzf(parcel);
                setCurrentScreen(asInterface3, readString15, readString16, readLong11);
                parcel2.writeNoException();
                return true;
            case 16:
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface5 instanceof zzcu) {
                        zzcuVar14 = (zzcu) queryLocalInterface5;
                    } else {
                        zzcuVar14 = new zzcs(readStrongBinder5);
                    }
                }
                zzbn.zzf(parcel);
                getCurrentScreenName(zzcuVar14);
                parcel2.writeNoException();
                return true;
            case 17:
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface6 instanceof zzcu) {
                        zzcuVar13 = (zzcu) queryLocalInterface6;
                    } else {
                        zzcuVar13 = new zzcs(readStrongBinder6);
                    }
                }
                zzbn.zzf(parcel);
                getCurrentScreenClass(zzcuVar13);
                parcel2.writeNoException();
                return true;
            case 18:
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    if (queryLocalInterface7 instanceof zzdc) {
                        zzdcVar = (zzdc) queryLocalInterface7;
                    } else {
                        zzdcVar = new zzdb(readStrongBinder7);
                    }
                }
                zzbn.zzf(parcel);
                setInstanceIdProvider(zzdcVar);
                parcel2.writeNoException();
                return true;
            case 19:
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface8 instanceof zzcu) {
                        zzcuVar12 = (zzcu) queryLocalInterface8;
                    } else {
                        zzcuVar12 = new zzcs(readStrongBinder8);
                    }
                }
                zzbn.zzf(parcel);
                getCachedAppInstanceId(zzcuVar12);
                parcel2.writeNoException();
                return true;
            case 20:
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface9 instanceof zzcu) {
                        zzcuVar11 = (zzcu) queryLocalInterface9;
                    } else {
                        zzcuVar11 = new zzcs(readStrongBinder9);
                    }
                }
                zzbn.zzf(parcel);
                getAppInstanceId(zzcuVar11);
                parcel2.writeNoException();
                return true;
            case 21:
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface10 instanceof zzcu) {
                        zzcuVar10 = (zzcu) queryLocalInterface10;
                    } else {
                        zzcuVar10 = new zzcs(readStrongBinder10);
                    }
                }
                zzbn.zzf(parcel);
                getGmpAppId(zzcuVar10);
                parcel2.writeNoException();
                return true;
            case 22:
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface11 instanceof zzcu) {
                        zzcuVar9 = (zzcu) queryLocalInterface11;
                    } else {
                        zzcuVar9 = new zzcs(readStrongBinder11);
                    }
                }
                zzbn.zzf(parcel);
                generateEventId(zzcuVar9);
                parcel2.writeNoException();
                return true;
            case 23:
                String readString17 = parcel.readString();
                long readLong12 = parcel.readLong();
                zzbn.zzf(parcel);
                beginAdUnitExposure(readString17, readLong12);
                parcel2.writeNoException();
                return true;
            case 24:
                String readString18 = parcel.readString();
                long readLong13 = parcel.readLong();
                zzbn.zzf(parcel);
                endAdUnitExposure(readString18, readLong13);
                parcel2.writeNoException();
                return true;
            case 25:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong14 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityStarted(asInterface4, readLong14);
                parcel2.writeNoException();
                return true;
            case 26:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong15 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityStopped(asInterface5, readLong15);
                parcel2.writeNoException();
                return true;
            case 27:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                Bundle bundle5 = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                long readLong16 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityCreated(asInterface6, bundle5, readLong16);
                parcel2.writeNoException();
                return true;
            case 28:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong17 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityDestroyed(asInterface7, readLong17);
                parcel2.writeNoException();
                return true;
            case 29:
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong18 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityPaused(asInterface8, readLong18);
                parcel2.writeNoException();
                return true;
            case 30:
                IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                long readLong19 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityResumed(asInterface9, readLong19);
                parcel2.writeNoException();
                return true;
            case 31:
                IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface12 instanceof zzcu) {
                        zzcuVar8 = (zzcu) queryLocalInterface12;
                    } else {
                        zzcuVar8 = new zzcs(readStrongBinder12);
                    }
                }
                long readLong20 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivitySaveInstanceState(asInterface10, zzcuVar8, readLong20);
                parcel2.writeNoException();
                return true;
            case 32:
                Bundle bundle6 = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface13 instanceof zzcu) {
                        zzcuVar7 = (zzcu) queryLocalInterface13;
                    } else {
                        zzcuVar7 = new zzcs(readStrongBinder13);
                    }
                }
                long readLong21 = parcel.readLong();
                zzbn.zzf(parcel);
                performAction(bundle6, zzcuVar7, readLong21);
                parcel2.writeNoException();
                return true;
            case 33:
                int readInt = parcel.readInt();
                String readString19 = parcel.readString();
                IObjectWrapper asInterface11 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface12 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface13 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbn.zzf(parcel);
                logHealthData(readInt, readString19, asInterface11, asInterface12, asInterface13);
                parcel2.writeNoException();
                return true;
            case 34:
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface14 instanceof zzda) {
                        zzdaVar3 = (zzda) queryLocalInterface14;
                    } else {
                        zzdaVar3 = new zzcy(readStrongBinder14);
                    }
                }
                zzbn.zzf(parcel);
                setEventInterceptor(zzdaVar3);
                parcel2.writeNoException();
                return true;
            case 35:
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface15 instanceof zzda) {
                        zzdaVar2 = (zzda) queryLocalInterface15;
                    } else {
                        zzdaVar2 = new zzcy(readStrongBinder15);
                    }
                }
                zzbn.zzf(parcel);
                registerOnMeasurementEventListener(zzdaVar2);
                parcel2.writeNoException();
                return true;
            case 36:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    if (queryLocalInterface16 instanceof zzda) {
                        zzdaVar = (zzda) queryLocalInterface16;
                    } else {
                        zzdaVar = new zzcy(readStrongBinder16);
                    }
                }
                zzbn.zzf(parcel);
                unregisterOnMeasurementEventListener(zzdaVar);
                parcel2.writeNoException();
                return true;
            case 37:
                HashMap zze = zzbn.zze(parcel);
                zzbn.zzf(parcel);
                initForTests(zze);
                parcel2.writeNoException();
                return true;
            case 38:
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface17 instanceof zzcu) {
                        zzcuVar6 = (zzcu) queryLocalInterface17;
                    } else {
                        zzcuVar6 = new zzcs(readStrongBinder17);
                    }
                }
                int readInt2 = parcel.readInt();
                zzbn.zzf(parcel);
                getTestFlag(zzcuVar6, readInt2);
                parcel2.writeNoException();
                return true;
            case 39:
                boolean zza6 = zzbn.zza(parcel);
                zzbn.zzf(parcel);
                setDataCollectionEnabled(zza6);
                parcel2.writeNoException();
                return true;
            case 40:
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface18 instanceof zzcu) {
                        zzcuVar5 = (zzcu) queryLocalInterface18;
                    } else {
                        zzcuVar5 = new zzcs(readStrongBinder18);
                    }
                }
                zzbn.zzf(parcel);
                isDataCollectionEnabled(zzcuVar5);
                parcel2.writeNoException();
                return true;
            case 41:
            case 47:
            case 49:
            default:
                return false;
            case 42:
                Bundle bundle7 = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                zzbn.zzf(parcel);
                setDefaultEventParameters(bundle7);
                parcel2.writeNoException();
                return true;
            case 43:
                long readLong22 = parcel.readLong();
                zzbn.zzf(parcel);
                clearMeasurementEnabled(readLong22);
                parcel2.writeNoException();
                return true;
            case 44:
                Bundle bundle8 = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                long readLong23 = parcel.readLong();
                zzbn.zzf(parcel);
                setConsent(bundle8, readLong23);
                parcel2.writeNoException();
                return true;
            case 45:
                Bundle bundle9 = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                long readLong24 = parcel.readLong();
                zzbn.zzf(parcel);
                setConsentThirdParty(bundle9, readLong24);
                parcel2.writeNoException();
                return true;
            case 46:
                IBinder readStrongBinder19 = parcel.readStrongBinder();
                if (readStrongBinder19 != null) {
                    IInterface queryLocalInterface19 = readStrongBinder19.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface19 instanceof zzcu) {
                        zzcuVar4 = (zzcu) queryLocalInterface19;
                    } else {
                        zzcuVar4 = new zzcs(readStrongBinder19);
                    }
                }
                zzbn.zzf(parcel);
                getSessionId(zzcuVar4);
                parcel2.writeNoException();
                return true;
            case 48:
                Intent intent = (Intent) zzbn.zzb(parcel, Intent.CREATOR);
                zzbn.zzf(parcel);
                setSgtmDebugInfo(intent);
                parcel2.writeNoException();
                return true;
            case 50:
                zzdf zzdfVar = (zzdf) zzbn.zzb(parcel, zzdf.CREATOR);
                String readString20 = parcel.readString();
                String readString21 = parcel.readString();
                long readLong25 = parcel.readLong();
                zzbn.zzf(parcel);
                setCurrentScreenByScionActivityInfo(zzdfVar, readString20, readString21, readLong25);
                parcel2.writeNoException();
                return true;
            case 51:
                zzdf zzdfVar2 = (zzdf) zzbn.zzb(parcel, zzdf.CREATOR);
                long readLong26 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityStartedByScionActivityInfo(zzdfVar2, readLong26);
                parcel2.writeNoException();
                return true;
            case 52:
                zzdf zzdfVar3 = (zzdf) zzbn.zzb(parcel, zzdf.CREATOR);
                long readLong27 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityStoppedByScionActivityInfo(zzdfVar3, readLong27);
                parcel2.writeNoException();
                return true;
            case 53:
                zzdf zzdfVar4 = (zzdf) zzbn.zzb(parcel, zzdf.CREATOR);
                Bundle bundle10 = (Bundle) zzbn.zzb(parcel, Bundle.CREATOR);
                long readLong28 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityCreatedByScionActivityInfo(zzdfVar4, bundle10, readLong28);
                parcel2.writeNoException();
                return true;
            case 54:
                zzdf zzdfVar5 = (zzdf) zzbn.zzb(parcel, zzdf.CREATOR);
                long readLong29 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityDestroyedByScionActivityInfo(zzdfVar5, readLong29);
                parcel2.writeNoException();
                return true;
            case 55:
                zzdf zzdfVar6 = (zzdf) zzbn.zzb(parcel, zzdf.CREATOR);
                long readLong30 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityPausedByScionActivityInfo(zzdfVar6, readLong30);
                parcel2.writeNoException();
                return true;
            case 56:
                zzdf zzdfVar7 = (zzdf) zzbn.zzb(parcel, zzdf.CREATOR);
                long readLong31 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivityResumedByScionActivityInfo(zzdfVar7, readLong31);
                parcel2.writeNoException();
                return true;
            case 57:
                zzdf zzdfVar8 = (zzdf) zzbn.zzb(parcel, zzdf.CREATOR);
                IBinder readStrongBinder20 = parcel.readStrongBinder();
                if (readStrongBinder20 != null) {
                    IInterface queryLocalInterface20 = readStrongBinder20.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    if (queryLocalInterface20 instanceof zzcu) {
                        zzcuVar3 = (zzcu) queryLocalInterface20;
                    } else {
                        zzcuVar3 = new zzcs(readStrongBinder20);
                    }
                }
                long readLong32 = parcel.readLong();
                zzbn.zzf(parcel);
                onActivitySaveInstanceStateByScionActivityInfo(zzdfVar8, zzcuVar3, readLong32);
                parcel2.writeNoException();
                return true;
            case 58:
                IBinder readStrongBinder21 = parcel.readStrongBinder();
                if (readStrongBinder21 != null) {
                    IInterface queryLocalInterface21 = readStrongBinder21.queryLocalInterface("com.google.android.gms.measurement.api.internal.IDynamiteUploadBatchesCallback");
                    if (queryLocalInterface21 instanceof zzcx) {
                        zzcxVar = (zzcx) queryLocalInterface21;
                    } else {
                        zzcxVar = new zzcv(readStrongBinder21);
                    }
                }
                zzbn.zzf(parcel);
                retrieveAndUploadBatches(zzcxVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
