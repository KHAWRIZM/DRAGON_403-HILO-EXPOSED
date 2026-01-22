package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzma;
import com.google.android.gms.internal.measurement.zzme;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class zzme<MessageType extends zzme<MessageType, BuilderType>, BuilderType extends zzma<MessageType, BuilderType>> extends zzkr<MessageType, BuilderType> {
    private static final Map zzd = new ConcurrentHashMap();
    private int zzb = -1;
    protected zzoi zzc = zzoi.zza();

    private final int zzc(zznw zznwVar) {
        return zznt.zza().zzb(getClass()).zze(this);
    }

    public static zzme zzco(Class cls) {
        Map map = zzd;
        zzme zzmeVar = (zzme) map.get(cls);
        if (zzmeVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzmeVar = (zzme) map.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (zzmeVar == null) {
            zzmeVar = (zzme) ((zzme) zzoo.zzc(cls)).zzl(6, null, null);
            if (zzmeVar != null) {
                map.put(cls, zzmeVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return zzmeVar;
    }

    public static void zzcp(Class cls, zzme zzmeVar) {
        zzmeVar.zzcg();
        zzd.put(cls, zzmeVar);
    }

    public static Object zzcq(zznl zznlVar, String str, Object[] objArr) {
        return new zznv(zznlVar, str, objArr);
    }

    public static Object zzcr(Method method, Object obj, Object... objArr) {
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

    public static zzml zzcs() {
        return zzmf.zzd();
    }

    public static zzmm zzct() {
        return zzmz.zze();
    }

    public static zzmm zzcu(zzmm zzmmVar) {
        int size = zzmmVar.size();
        return zzmmVar.zzg(size + size);
    }

    public static zzmn zzcv() {
        return zznu.zzd();
    }

    public static zzmn zzcw(zzmn zzmnVar) {
        int size = zzmnVar.size();
        return zzmnVar.zzg(size + size);
    }

    public static /* synthetic */ boolean zzcx(zzme zzmeVar, boolean z10) {
        return zzd(zzmeVar, false);
    }

    public static final boolean zzd(zzme zzmeVar, boolean z10) {
        zzme zzmeVar2;
        byte byteValue = ((Byte) zzmeVar.zzl(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzk = zznt.zza().zzb(zzmeVar.getClass()).zzk(zzmeVar);
        if (z10) {
            if (true != zzk) {
                zzmeVar2 = null;
            } else {
                zzmeVar2 = zzmeVar;
            }
            zzmeVar.zzl(2, zzmeVar2, null);
        }
        return zzk;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zznt.zza().zzb(getClass()).zzb(this, (zzme) obj);
    }

    public final int hashCode() {
        if (!zzcf()) {
            int i10 = this.zza;
            if (i10 == 0) {
                int zzci = zzci();
                this.zza = zzci;
                return zzci;
            }
            return i10;
        }
        return zzci();
    }

    public final String toString() {
        return zznn.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final void zzcB(zzll zzllVar) throws IOException {
        zznt.zza().zzb(getClass()).zzf(this, zzlm.zza(zzllVar));
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final /* synthetic */ zznk zzcC() {
        return (zzma) zzl(5, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zznm
    public final boolean zzcD() {
        return zzd(this, true);
    }

    @Override // com.google.android.gms.internal.measurement.zznm
    public final /* synthetic */ zznl zzcE() {
        return (zzme) zzl(6, null, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzkr
    public final int zzcd(zznw zznwVar) {
        if (zzcf()) {
            int zze = zznwVar.zze(this);
            if (zze >= 0) {
                return zze;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(zze).length() + 42);
            sb.append("serialized size must be non-negative, was ");
            sb.append(zze);
            throw new IllegalStateException(sb.toString());
        }
        int i10 = this.zzb & Integer.MAX_VALUE;
        if (i10 == Integer.MAX_VALUE) {
            int zze2 = zznwVar.zze(this);
            if (zze2 >= 0) {
                this.zzb = (this.zzb & Integer.MIN_VALUE) | zze2;
                return zze2;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(zze2).length() + 42);
            sb2.append("serialized size must be non-negative, was ");
            sb2.append(zze2);
            throw new IllegalStateException(sb2.toString());
        }
        return i10;
    }

    public final boolean zzcf() {
        return (this.zzb & Integer.MIN_VALUE) != 0;
    }

    public final void zzcg() {
        this.zzb &= Integer.MAX_VALUE;
    }

    public final zzme zzch() {
        return (zzme) zzl(4, null, null);
    }

    final int zzci() {
        return zznt.zza().zzb(getClass()).zzc(this);
    }

    public final void zzcj() {
        zznt.zza().zzb(getClass()).zzj(this);
        zzcg();
    }

    public final zzma zzck() {
        return (zzma) zzl(5, null, null);
    }

    public final zzma zzcl() {
        zzma zzmaVar = (zzma) zzl(5, null, null);
        zzmaVar.zzbd(this);
        return zzmaVar;
    }

    public final void zzcm(int i10) {
        this.zzb = (this.zzb & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.measurement.zznl
    public final int zzcn() {
        int i10;
        if (zzcf()) {
            i10 = zzc(null);
            if (i10 < 0) {
                StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 42);
                sb.append("serialized size must be non-negative, was ");
                sb.append(i10);
                throw new IllegalStateException(sb.toString());
            }
        } else {
            i10 = this.zzb & Integer.MAX_VALUE;
            if (i10 == Integer.MAX_VALUE) {
                i10 = zzc(null);
                if (i10 >= 0) {
                    this.zzb = (this.zzb & Integer.MIN_VALUE) | i10;
                } else {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 42);
                    sb2.append("serialized size must be non-negative, was ");
                    sb2.append(i10);
                    throw new IllegalStateException(sb2.toString());
                }
            }
        }
        return i10;
    }

    public abstract Object zzl(int i10, Object obj, Object obj2);
}
