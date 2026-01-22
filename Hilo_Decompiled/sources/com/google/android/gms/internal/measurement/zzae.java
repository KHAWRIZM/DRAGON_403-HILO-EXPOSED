package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzae implements Iterable, zzao, zzak {
    final SortedMap zza;
    final Map zzb;

    public zzae() {
        this.zza = new TreeMap();
        this.zzb = new TreeMap();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzae)) {
            return false;
        }
        zzae zzaeVar = (zzae) obj;
        if (zzh() != zzaeVar.zzh()) {
            return false;
        }
        SortedMap sortedMap = this.zza;
        if (sortedMap.isEmpty()) {
            return zzaeVar.zza.isEmpty();
        }
        for (int intValue = ((Integer) sortedMap.firstKey()).intValue(); intValue <= ((Integer) sortedMap.lastKey()).intValue(); intValue++) {
            if (!zzl(intValue).equals(zzaeVar.zzl(intValue))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode() * 31;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzad(this);
    }

    public final String toString() {
        return zzs(",");
    }

    public final List zzb() {
        ArrayList arrayList = new ArrayList(zzh());
        for (int i10 = 0; i10 < zzh(); i10++) {
            arrayList.add(zzl(i10));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return zzs(",");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzcA(String str, zzg zzgVar, List list) {
        if (!"concat".equals(str) && !"every".equals(str) && !"filter".equals(str) && !"forEach".equals(str) && !"indexOf".equals(str) && !"join".equals(str) && !"lastIndexOf".equals(str) && !"map".equals(str) && !"pop".equals(str) && !"push".equals(str) && !"reduce".equals(str) && !"reduceRight".equals(str) && !"reverse".equals(str) && !"shift".equals(str) && !"slice".equals(str) && !"some".equals(str) && !"sort".equals(str) && !"splice".equals(str) && !"toString".equals(str) && !"unshift".equals(str)) {
            return b.a(this, new zzas(str), zzgVar, list);
        }
        return zzba.zza(str, this, zzgVar, list);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        SortedMap sortedMap = this.zza;
        if (sortedMap.size() == 1) {
            return zzl(0).zzd();
        }
        if (sortedMap.size() <= 0) {
            return Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        }
        return Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return new zzac(this, this.zza.keySet().iterator(), this.zzb.keySet().iterator());
    }

    public final Iterator zzg() {
        return this.zza.keySet().iterator();
    }

    public final int zzh() {
        SortedMap sortedMap = this.zza;
        if (sortedMap.isEmpty()) {
            return 0;
        }
        return ((Integer) sortedMap.lastKey()).intValue() + 1;
    }

    public final int zzi() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final boolean zzj(String str) {
        if (!"length".equals(str) && !this.zzb.containsKey(str)) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final zzao zzk(String str) {
        zzao zzaoVar;
        if ("length".equals(str)) {
            return new zzah(Double.valueOf(zzh()));
        }
        if (zzj(str) && (zzaoVar = (zzao) this.zzb.get(str)) != null) {
            return zzaoVar;
        }
        return zzao.zzf;
    }

    public final zzao zzl(int i10) {
        zzao zzaoVar;
        if (i10 < zzh()) {
            if (zzo(i10) && (zzaoVar = (zzao) this.zza.get(Integer.valueOf(i10))) != null) {
                return zzaoVar;
            }
            return zzao.zzf;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final void zzm(String str, zzao zzaoVar) {
        if (zzaoVar == null) {
            this.zzb.remove(str);
        } else {
            this.zzb.put(str, zzaoVar);
        }
    }

    public final void zzn(int i10, zzao zzaoVar) {
        if (i10 <= 32468) {
            if (i10 >= 0) {
                if (zzaoVar == null) {
                    this.zza.remove(Integer.valueOf(i10));
                    return;
                } else {
                    this.zza.put(Integer.valueOf(i10), zzaoVar);
                    return;
                }
            }
            StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 21);
            sb.append("Out of bounds index: ");
            sb.append(i10);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        throw new IllegalStateException("Array too large");
    }

    public final boolean zzo(int i10) {
        if (i10 >= 0) {
            SortedMap sortedMap = this.zza;
            if (i10 <= ((Integer) sortedMap.lastKey()).intValue()) {
                return sortedMap.containsKey(Integer.valueOf(i10));
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 21);
        sb.append("Out of bounds index: ");
        sb.append(i10);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void zzp() {
        this.zza.clear();
    }

    public final void zzq(int i10, zzao zzaoVar) {
        if (i10 >= 0) {
            if (i10 >= zzh()) {
                zzn(i10, zzaoVar);
                return;
            }
            SortedMap sortedMap = this.zza;
            for (int intValue = ((Integer) sortedMap.lastKey()).intValue(); intValue >= i10; intValue--) {
                Integer valueOf = Integer.valueOf(intValue);
                zzao zzaoVar2 = (zzao) sortedMap.get(valueOf);
                if (zzaoVar2 != null) {
                    zzn(intValue + 1, zzaoVar2);
                    sortedMap.remove(valueOf);
                }
            }
            zzn(i10, zzaoVar);
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i10).length() + 21);
        sb.append("Invalid value index: ");
        sb.append(i10);
        throw new IllegalArgumentException(sb.toString());
    }

    public final void zzr(int i10) {
        SortedMap sortedMap = this.zza;
        int intValue = ((Integer) sortedMap.lastKey()).intValue();
        if (i10 <= intValue && i10 >= 0) {
            sortedMap.remove(Integer.valueOf(i10));
            if (i10 == intValue) {
                int i11 = i10 - 1;
                Integer valueOf = Integer.valueOf(i11);
                if (!sortedMap.containsKey(valueOf) && i11 >= 0) {
                    sortedMap.put(valueOf, zzao.zzf);
                    return;
                }
                return;
            }
            while (true) {
                i10++;
                if (i10 <= ((Integer) sortedMap.lastKey()).intValue()) {
                    Integer valueOf2 = Integer.valueOf(i10);
                    zzao zzaoVar = (zzao) sortedMap.get(valueOf2);
                    if (zzaoVar != null) {
                        sortedMap.put(Integer.valueOf(i10 - 1), zzaoVar);
                        sortedMap.remove(valueOf2);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public final String zzs(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (!this.zza.isEmpty()) {
            int i10 = 0;
            while (true) {
                if (str == null) {
                    str2 = "";
                } else {
                    str2 = str;
                }
                if (i10 >= zzh()) {
                    break;
                }
                zzao zzl = zzl(i10);
                sb.append(str2);
                if (!(zzl instanceof zzat) && !(zzl instanceof zzam)) {
                    sb.append(zzl.zzc());
                }
                i10++;
            }
            sb.delete(0, str2.length());
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao zzt() {
        zzae zzaeVar = new zzae();
        for (Map.Entry entry : this.zza.entrySet()) {
            if (entry.getValue() instanceof zzak) {
                zzaeVar.zza.put((Integer) entry.getKey(), (zzao) entry.getValue());
            } else {
                zzaeVar.zza.put((Integer) entry.getKey(), ((zzao) entry.getValue()).zzt());
            }
        }
        return zzaeVar;
    }

    public zzae(List list) {
        this();
        if (list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                zzn(i10, (zzao) list.get(i10));
            }
        }
    }
}
