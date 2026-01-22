package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class zzlm implements zzou {
    private final zzll zza;

    private zzlm(zzll zzllVar) {
        byte[] bArr = zzmo.zzb;
        this.zza = zzllVar;
        zzllVar.zza = this;
    }

    public static zzlm zza(zzll zzllVar) {
        zzlm zzlmVar = zzllVar.zza;
        if (zzlmVar != null) {
            return zzlmVar;
        }
        return new zzlm(zzllVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzA(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (list instanceof zzmz) {
            zzmz zzmzVar = (zzmz) list;
            if (z10) {
                zzll zzllVar = this.zza;
                zzllVar.zza(i10, 2);
                int i12 = 0;
                for (int i13 = 0; i13 < zzmzVar.size(); i13++) {
                    zzmzVar.zzc(i13);
                    i12 += 8;
                }
                zzllVar.zzr(i12);
                while (i11 < zzmzVar.size()) {
                    zzllVar.zzu(zzmzVar.zzc(i11));
                    i11++;
                }
                return;
            }
            while (i11 < zzmzVar.size()) {
                this.zza.zzf(i10, zzmzVar.zzc(i11));
                i11++;
            }
            return;
        }
        if (z10) {
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i10, 2);
            int i14 = 0;
            for (int i15 = 0; i15 < list.size(); i15++) {
                ((Long) list.get(i15)).longValue();
                i14 += 8;
            }
            zzllVar2.zzr(i14);
            while (i11 < list.size()) {
                zzllVar2.zzu(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzf(i10, ((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzB(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (list instanceof zzlx) {
            zzlx zzlxVar = (zzlx) list;
            if (z10) {
                zzll zzllVar = this.zza;
                zzllVar.zza(i10, 2);
                int i12 = 0;
                for (int i13 = 0; i13 < zzlxVar.size(); i13++) {
                    zzlxVar.zze(i13);
                    i12 += 4;
                }
                zzllVar.zzr(i12);
                while (i11 < zzlxVar.size()) {
                    zzllVar.zzs(Float.floatToRawIntBits(zzlxVar.zze(i11)));
                    i11++;
                }
                return;
            }
            while (i11 < zzlxVar.size()) {
                this.zza.zzd(i10, Float.floatToRawIntBits(zzlxVar.zze(i11)));
                i11++;
            }
            return;
        }
        if (z10) {
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i10, 2);
            int i14 = 0;
            for (int i15 = 0; i15 < list.size(); i15++) {
                ((Float) list.get(i15)).floatValue();
                i14 += 4;
            }
            zzllVar2.zzr(i14);
            while (i11 < list.size()) {
                zzllVar2.zzs(Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzd(i10, Float.floatToRawIntBits(((Float) list.get(i11)).floatValue()));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzC(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (list instanceof zzln) {
            zzln zzlnVar = (zzln) list;
            if (z10) {
                zzll zzllVar = this.zza;
                zzllVar.zza(i10, 2);
                int i12 = 0;
                for (int i13 = 0; i13 < zzlnVar.size(); i13++) {
                    zzlnVar.zze(i13);
                    i12 += 8;
                }
                zzllVar.zzr(i12);
                while (i11 < zzlnVar.size()) {
                    zzllVar.zzu(Double.doubleToRawLongBits(zzlnVar.zze(i11)));
                    i11++;
                }
                return;
            }
            while (i11 < zzlnVar.size()) {
                this.zza.zzf(i10, Double.doubleToRawLongBits(zzlnVar.zze(i11)));
                i11++;
            }
            return;
        }
        if (z10) {
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i10, 2);
            int i14 = 0;
            for (int i15 = 0; i15 < list.size(); i15++) {
                ((Double) list.get(i15)).doubleValue();
                i14 += 8;
            }
            zzllVar2.zzr(i14);
            while (i11 < list.size()) {
                zzllVar2.zzu(Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzf(i10, Double.doubleToRawLongBits(((Double) list.get(i11)).doubleValue()));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzD(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (list instanceof zzmf) {
            zzmf zzmfVar = (zzmf) list;
            if (z10) {
                zzll zzllVar = this.zza;
                zzllVar.zza(i10, 2);
                int i12 = 0;
                for (int i13 = 0; i13 < zzmfVar.size(); i13++) {
                    i12 += zzll.zzA(zzmfVar.zzf(i13));
                }
                zzllVar.zzr(i12);
                while (i11 < zzmfVar.size()) {
                    zzllVar.zzq(zzmfVar.zzf(i11));
                    i11++;
                }
                return;
            }
            while (i11 < zzmfVar.size()) {
                this.zza.zzb(i10, zzmfVar.zzf(i11));
                i11++;
            }
            return;
        }
        if (z10) {
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i10, 2);
            int i14 = 0;
            for (int i15 = 0; i15 < list.size(); i15++) {
                i14 += zzll.zzA(((Integer) list.get(i15)).intValue());
            }
            zzllVar2.zzr(i14);
            while (i11 < list.size()) {
                zzllVar2.zzq(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzb(i10, ((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzE(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (list instanceof zzkx) {
            zzkx zzkxVar = (zzkx) list;
            if (z10) {
                zzll zzllVar = this.zza;
                zzllVar.zza(i10, 2);
                int i12 = 0;
                for (int i13 = 0; i13 < zzkxVar.size(); i13++) {
                    zzkxVar.zze(i13);
                    i12++;
                }
                zzllVar.zzr(i12);
                while (i11 < zzkxVar.size()) {
                    zzllVar.zzp(zzkxVar.zze(i11) ? (byte) 1 : (byte) 0);
                    i11++;
                }
                return;
            }
            while (i11 < zzkxVar.size()) {
                this.zza.zzg(i10, zzkxVar.zze(i11));
                i11++;
            }
            return;
        }
        if (z10) {
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i10, 2);
            int i14 = 0;
            for (int i15 = 0; i15 < list.size(); i15++) {
                ((Boolean) list.get(i15)).booleanValue();
                i14++;
            }
            zzllVar2.zzr(i14);
            while (i11 < list.size()) {
                zzllVar2.zzp(((Boolean) list.get(i11)).booleanValue() ? (byte) 1 : (byte) 0);
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzg(i10, ((Boolean) list.get(i11)).booleanValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzF(int i10, List list) throws IOException {
        int i11 = 0;
        if (list instanceof zzmw) {
            zzmw zzmwVar = (zzmw) list;
            while (i11 < list.size()) {
                Object zzc = zzmwVar.zzc();
                if (zzc instanceof String) {
                    this.zza.zzh(i10, (String) zzc);
                } else {
                    this.zza.zzi(i10, (zzlg) zzc);
                }
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzh(i10, (String) list.get(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzG(int i10, List list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.zza.zzi(i10, (zzlg) list.get(i11));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzH(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (list instanceof zzmf) {
            zzmf zzmfVar = (zzmf) list;
            if (z10) {
                zzll zzllVar = this.zza;
                zzllVar.zza(i10, 2);
                int i12 = 0;
                for (int i13 = 0; i13 < zzmfVar.size(); i13++) {
                    i12 += zzll.zzz(zzmfVar.zzf(i13));
                }
                zzllVar.zzr(i12);
                while (i11 < zzmfVar.size()) {
                    zzllVar.zzr(zzmfVar.zzf(i11));
                    i11++;
                }
                return;
            }
            while (i11 < zzmfVar.size()) {
                this.zza.zzc(i10, zzmfVar.zzf(i11));
                i11++;
            }
            return;
        }
        if (z10) {
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i10, 2);
            int i14 = 0;
            for (int i15 = 0; i15 < list.size(); i15++) {
                i14 += zzll.zzz(((Integer) list.get(i15)).intValue());
            }
            zzllVar2.zzr(i14);
            while (i11 < list.size()) {
                zzllVar2.zzr(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzc(i10, ((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzI(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (list instanceof zzmf) {
            zzmf zzmfVar = (zzmf) list;
            if (z10) {
                zzll zzllVar = this.zza;
                zzllVar.zza(i10, 2);
                int i12 = 0;
                for (int i13 = 0; i13 < zzmfVar.size(); i13++) {
                    zzmfVar.zzf(i13);
                    i12 += 4;
                }
                zzllVar.zzr(i12);
                while (i11 < zzmfVar.size()) {
                    zzllVar.zzs(zzmfVar.zzf(i11));
                    i11++;
                }
                return;
            }
            while (i11 < zzmfVar.size()) {
                this.zza.zzd(i10, zzmfVar.zzf(i11));
                i11++;
            }
            return;
        }
        if (z10) {
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i10, 2);
            int i14 = 0;
            for (int i15 = 0; i15 < list.size(); i15++) {
                ((Integer) list.get(i15)).intValue();
                i14 += 4;
            }
            zzllVar2.zzr(i14);
            while (i11 < list.size()) {
                zzllVar2.zzs(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzd(i10, ((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzJ(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (list instanceof zzmz) {
            zzmz zzmzVar = (zzmz) list;
            if (z10) {
                zzll zzllVar = this.zza;
                zzllVar.zza(i10, 2);
                int i12 = 0;
                for (int i13 = 0; i13 < zzmzVar.size(); i13++) {
                    zzmzVar.zzc(i13);
                    i12 += 8;
                }
                zzllVar.zzr(i12);
                while (i11 < zzmzVar.size()) {
                    zzllVar.zzu(zzmzVar.zzc(i11));
                    i11++;
                }
                return;
            }
            while (i11 < zzmzVar.size()) {
                this.zza.zzf(i10, zzmzVar.zzc(i11));
                i11++;
            }
            return;
        }
        if (z10) {
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i10, 2);
            int i14 = 0;
            for (int i15 = 0; i15 < list.size(); i15++) {
                ((Long) list.get(i15)).longValue();
                i14 += 8;
            }
            zzllVar2.zzr(i14);
            while (i11 < list.size()) {
                zzllVar2.zzu(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzf(i10, ((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzK(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (list instanceof zzmf) {
            zzmf zzmfVar = (zzmf) list;
            if (z10) {
                zzll zzllVar = this.zza;
                zzllVar.zza(i10, 2);
                int i12 = 0;
                for (int i13 = 0; i13 < zzmfVar.size(); i13++) {
                    int zzf = zzmfVar.zzf(i13);
                    i12 += zzll.zzz((zzf >> 31) ^ (zzf + zzf));
                }
                zzllVar.zzr(i12);
                while (i11 < zzmfVar.size()) {
                    int zzf2 = zzmfVar.zzf(i11);
                    zzllVar.zzr((zzf2 >> 31) ^ (zzf2 + zzf2));
                    i11++;
                }
                return;
            }
            while (i11 < zzmfVar.size()) {
                zzll zzllVar2 = this.zza;
                int zzf3 = zzmfVar.zzf(i11);
                zzllVar2.zzc(i10, (zzf3 >> 31) ^ (zzf3 + zzf3));
                i11++;
            }
            return;
        }
        if (z10) {
            zzll zzllVar3 = this.zza;
            zzllVar3.zza(i10, 2);
            int i14 = 0;
            for (int i15 = 0; i15 < list.size(); i15++) {
                int intValue = ((Integer) list.get(i15)).intValue();
                i14 += zzll.zzz((intValue >> 31) ^ (intValue + intValue));
            }
            zzllVar3.zzr(i14);
            while (i11 < list.size()) {
                int intValue2 = ((Integer) list.get(i11)).intValue();
                zzllVar3.zzr((intValue2 >> 31) ^ (intValue2 + intValue2));
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            zzll zzllVar4 = this.zza;
            int intValue3 = ((Integer) list.get(i11)).intValue();
            zzllVar4.zzc(i10, (intValue3 >> 31) ^ (intValue3 + intValue3));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzL(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (list instanceof zzmz) {
            zzmz zzmzVar = (zzmz) list;
            if (z10) {
                zzll zzllVar = this.zza;
                zzllVar.zza(i10, 2);
                int i12 = 0;
                for (int i13 = 0; i13 < zzmzVar.size(); i13++) {
                    long zzc = zzmzVar.zzc(i13);
                    i12 += zzll.zzA((zzc >> 63) ^ (zzc + zzc));
                }
                zzllVar.zzr(i12);
                while (i11 < zzmzVar.size()) {
                    long zzc2 = zzmzVar.zzc(i11);
                    zzllVar.zzt((zzc2 >> 63) ^ (zzc2 + zzc2));
                    i11++;
                }
                return;
            }
            while (i11 < zzmzVar.size()) {
                zzll zzllVar2 = this.zza;
                long zzc3 = zzmzVar.zzc(i11);
                zzllVar2.zze(i10, (zzc3 >> 63) ^ (zzc3 + zzc3));
                i11++;
            }
            return;
        }
        if (z10) {
            zzll zzllVar3 = this.zza;
            zzllVar3.zza(i10, 2);
            int i14 = 0;
            for (int i15 = 0; i15 < list.size(); i15++) {
                long longValue = ((Long) list.get(i15)).longValue();
                i14 += zzll.zzA((longValue >> 63) ^ (longValue + longValue));
            }
            zzllVar3.zzr(i14);
            while (i11 < list.size()) {
                long longValue2 = ((Long) list.get(i11)).longValue();
                zzllVar3.zzt((longValue2 >> 63) ^ (longValue2 + longValue2));
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            zzll zzllVar4 = this.zza;
            long longValue3 = ((Long) list.get(i11)).longValue();
            zzllVar4.zze(i10, (longValue3 >> 63) ^ (longValue3 + longValue3));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzM(int i10, zznd zzndVar, Map map) throws IOException {
        for (Map.Entry entry : map.entrySet()) {
            zzll zzllVar = this.zza;
            zzllVar.zza(i10, 2);
            zzllVar.zzr(zzne.zzc(zzndVar, entry.getKey(), entry.getValue()));
            zzne.zzb(zzllVar, zzndVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzb(int i10, int i11) throws IOException {
        this.zza.zzd(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzc(int i10, long j10) throws IOException {
        this.zza.zze(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzd(int i10, long j10) throws IOException {
        this.zza.zzf(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zze(int i10, float f10) throws IOException {
        this.zza.zzd(i10, Float.floatToRawIntBits(f10));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzf(int i10, double d10) throws IOException {
        this.zza.zzf(i10, Double.doubleToRawLongBits(d10));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzg(int i10, int i11) throws IOException {
        this.zza.zzb(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzh(int i10, long j10) throws IOException {
        this.zza.zze(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzi(int i10, int i11) throws IOException {
        this.zza.zzb(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzj(int i10, long j10) throws IOException {
        this.zza.zzf(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzk(int i10, int i11) throws IOException {
        this.zza.zzd(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzl(int i10, boolean z10) throws IOException {
        this.zza.zzg(i10, z10);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzm(int i10, String str) throws IOException {
        this.zza.zzh(i10, str);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzn(int i10, zzlg zzlgVar) throws IOException {
        this.zza.zzi(i10, zzlgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzo(int i10, int i11) throws IOException {
        this.zza.zzc(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzp(int i10, int i11) throws IOException {
        this.zza.zzc(i10, (i11 >> 31) ^ (i11 + i11));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzq(int i10, long j10) throws IOException {
        this.zza.zze(i10, (j10 >> 63) ^ (j10 + j10));
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzr(int i10, Object obj, zznw zznwVar) throws IOException {
        this.zza.zzl(i10, (zznl) obj, zznwVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzs(int i10, Object obj, zznw zznwVar) throws IOException {
        zzll zzllVar = this.zza;
        zzllVar.zza(i10, 3);
        zznwVar.zzf((zznl) obj, zzllVar.zza);
        zzllVar.zza(i10, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    @Deprecated
    public final void zzt(int i10) throws IOException {
        this.zza.zza(i10, 3);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    @Deprecated
    public final void zzu(int i10) throws IOException {
        this.zza.zza(i10, 4);
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzv(int i10, Object obj) throws IOException {
        if (obj instanceof zzlg) {
            this.zza.zzn(i10, (zzlg) obj);
        } else {
            this.zza.zzm(i10, (zznl) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzw(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (list instanceof zzmf) {
            zzmf zzmfVar = (zzmf) list;
            if (z10) {
                zzll zzllVar = this.zza;
                zzllVar.zza(i10, 2);
                int i12 = 0;
                for (int i13 = 0; i13 < zzmfVar.size(); i13++) {
                    i12 += zzll.zzA(zzmfVar.zzf(i13));
                }
                zzllVar.zzr(i12);
                while (i11 < zzmfVar.size()) {
                    zzllVar.zzq(zzmfVar.zzf(i11));
                    i11++;
                }
                return;
            }
            while (i11 < zzmfVar.size()) {
                this.zza.zzb(i10, zzmfVar.zzf(i11));
                i11++;
            }
            return;
        }
        if (z10) {
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i10, 2);
            int i14 = 0;
            for (int i15 = 0; i15 < list.size(); i15++) {
                i14 += zzll.zzA(((Integer) list.get(i15)).intValue());
            }
            zzllVar2.zzr(i14);
            while (i11 < list.size()) {
                zzllVar2.zzq(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzb(i10, ((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzx(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (list instanceof zzmf) {
            zzmf zzmfVar = (zzmf) list;
            if (z10) {
                zzll zzllVar = this.zza;
                zzllVar.zza(i10, 2);
                int i12 = 0;
                for (int i13 = 0; i13 < zzmfVar.size(); i13++) {
                    zzmfVar.zzf(i13);
                    i12 += 4;
                }
                zzllVar.zzr(i12);
                while (i11 < zzmfVar.size()) {
                    zzllVar.zzs(zzmfVar.zzf(i11));
                    i11++;
                }
                return;
            }
            while (i11 < zzmfVar.size()) {
                this.zza.zzd(i10, zzmfVar.zzf(i11));
                i11++;
            }
            return;
        }
        if (z10) {
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i10, 2);
            int i14 = 0;
            for (int i15 = 0; i15 < list.size(); i15++) {
                ((Integer) list.get(i15)).intValue();
                i14 += 4;
            }
            zzllVar2.zzr(i14);
            while (i11 < list.size()) {
                zzllVar2.zzs(((Integer) list.get(i11)).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zzd(i10, ((Integer) list.get(i11)).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzy(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (list instanceof zzmz) {
            zzmz zzmzVar = (zzmz) list;
            if (z10) {
                zzll zzllVar = this.zza;
                zzllVar.zza(i10, 2);
                int i12 = 0;
                for (int i13 = 0; i13 < zzmzVar.size(); i13++) {
                    i12 += zzll.zzA(zzmzVar.zzc(i13));
                }
                zzllVar.zzr(i12);
                while (i11 < zzmzVar.size()) {
                    zzllVar.zzt(zzmzVar.zzc(i11));
                    i11++;
                }
                return;
            }
            while (i11 < zzmzVar.size()) {
                this.zza.zze(i10, zzmzVar.zzc(i11));
                i11++;
            }
            return;
        }
        if (z10) {
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i10, 2);
            int i14 = 0;
            for (int i15 = 0; i15 < list.size(); i15++) {
                i14 += zzll.zzA(((Long) list.get(i15)).longValue());
            }
            zzllVar2.zzr(i14);
            while (i11 < list.size()) {
                zzllVar2.zzt(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zze(i10, ((Long) list.get(i11)).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzou
    public final void zzz(int i10, List list, boolean z10) throws IOException {
        int i11 = 0;
        if (list instanceof zzmz) {
            zzmz zzmzVar = (zzmz) list;
            if (z10) {
                zzll zzllVar = this.zza;
                zzllVar.zza(i10, 2);
                int i12 = 0;
                for (int i13 = 0; i13 < zzmzVar.size(); i13++) {
                    i12 += zzll.zzA(zzmzVar.zzc(i13));
                }
                zzllVar.zzr(i12);
                while (i11 < zzmzVar.size()) {
                    zzllVar.zzt(zzmzVar.zzc(i11));
                    i11++;
                }
                return;
            }
            while (i11 < zzmzVar.size()) {
                this.zza.zze(i10, zzmzVar.zzc(i11));
                i11++;
            }
            return;
        }
        if (z10) {
            zzll zzllVar2 = this.zza;
            zzllVar2.zza(i10, 2);
            int i14 = 0;
            for (int i15 = 0; i15 < list.size(); i15++) {
                i14 += zzll.zzA(((Long) list.get(i15)).longValue());
            }
            zzllVar2.zzr(i14);
            while (i11 < list.size()) {
                zzllVar2.zzt(((Long) list.get(i11)).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zza.zze(i10, ((Long) list.get(i11)).longValue());
            i11++;
        }
    }
}
