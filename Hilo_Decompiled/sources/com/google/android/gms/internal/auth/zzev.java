package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzet;
import com.google.android.gms.internal.auth.zzev;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzev<MessageType extends zzev<MessageType, BuilderType>, BuilderType extends zzet<MessageType, BuilderType>> extends zzdq<MessageType, BuilderType> {
    private static final Map zzb = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzha zzc = zzha.zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzev zzb(Class cls) {
        Map map = zzb;
        zzev zzevVar = (zzev) map.get(cls);
        if (zzevVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzevVar = (zzev) map.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (zzevVar == null) {
            zzevVar = (zzev) ((zzev) zzhj.zze(cls)).zzn(6, null, null);
            if (zzevVar != null) {
                map.put(cls, zzevVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzevVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
    
        if (r1 != false) goto L١٧;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzev zzd(zzev zzevVar, byte[] bArr) throws zzfb {
        byte byteValue;
        zzev zzevVar2;
        zzev zzo = zzo(zzevVar, bArr, 0, bArr.length, zzel.zza);
        if (zzo != null && (byteValue = ((Byte) zzo.zzn(1, null, null)).byteValue()) != 1) {
            if (byteValue != 0) {
                boolean zzi = zzgf.zza().zzb(zzo.getClass()).zzi(zzo);
                if (true != zzi) {
                    zzevVar2 = null;
                } else {
                    zzevVar2 = zzo;
                }
                zzo.zzn(2, zzevVar2, null);
            }
            zzfb zza = new zzgy(zzo).zza();
            zza.zze(zzo);
            throw zza;
        }
        return zzo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzez zzf() {
        return zzgg.zze();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzg(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object zzh(zzfx zzfxVar, String str, Object[] objArr) {
        return new zzgh(zzfxVar, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", objArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void zzk(Class cls, zzev zzevVar) {
        zzevVar.zzj();
        zzb.put(cls, zzevVar);
    }

    private static zzev zzo(zzev zzevVar, byte[] bArr, int i10, int i11, zzel zzelVar) throws zzfb {
        zzev zzc = zzevVar.zzc();
        try {
            zzgi zzb2 = zzgf.zza().zzb(zzc.getClass());
            zzb2.zzg(zzc, bArr, 0, i11, new zzdt(zzelVar));
            zzb2.zze(zzc);
            return zzc;
        } catch (zzfb e10) {
            e10.zze(zzc);
            throw e10;
        } catch (zzgy e11) {
            zzfb zza = e11.zza();
            zza.zze(zzc);
            throw zza;
        } catch (IOException e12) {
            if (e12.getCause() instanceof zzfb) {
                throw ((zzfb) e12.getCause());
            }
            zzfb zzfbVar = new zzfb(e12);
            zzfbVar.zze(zzc);
            throw zzfbVar;
        } catch (IndexOutOfBoundsException unused) {
            zzfb zzf = zzfb.zzf();
            zzf.zze(zzc);
            throw zzf;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzgf.zza().zzb(getClass()).zzh(this, (zzev) obj);
    }

    public final int hashCode() {
        if (!zzm()) {
            int i10 = this.zza;
            if (i10 == 0) {
                int zza = zza();
                this.zza = zza;
                return zza;
            }
            return i10;
        }
        return zza();
    }

    public final String toString() {
        return zzfz.zza(this, super.toString());
    }

    final int zza() {
        return zzgf.zza().zzb(getClass()).zza(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzev zzc() {
        return (zzev) zzn(4, null, null);
    }

    @Override // com.google.android.gms.internal.auth.zzfy
    public final /* synthetic */ zzfx zze() {
        return (zzev) zzn(6, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzi() {
        zzgf.zza().zzb(getClass()).zze(this);
        zzj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj() {
        this.zzd &= Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzl(int i10) {
        this.zzd = (this.zzd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzm() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object zzn(int i10, Object obj, Object obj2);
}
