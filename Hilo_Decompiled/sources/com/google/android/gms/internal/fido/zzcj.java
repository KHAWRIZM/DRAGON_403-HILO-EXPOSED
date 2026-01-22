package com.google.android.gms.internal.fido;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzcj extends zzcd implements NavigableMap {
    private static final Comparator zzb;
    private static final zzcj zzc;
    private final transient zzcv zzd;
    private final transient zzcc zze;
    private final transient zzcj zzf;

    static {
        zzcq zzcqVar = zzcq.zza;
        zzb = zzcqVar;
        zzcv zzs = zzck.zzs(zzcqVar);
        int i10 = zzcc.zzd;
        zzc = new zzcj(zzs, zzct.zza, null);
    }

    zzcj(zzcv zzcvVar, zzcc zzccVar, zzcj zzcjVar) {
        this.zzd = zzcvVar;
        this.zze = zzccVar;
        this.zzf = zzcjVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzcj zzf(Map map) {
        boolean equals;
        final Comparator comparator = zzb;
        Comparator comparator2 = map.comparator();
        int i10 = 1;
        if (comparator2 == null) {
            equals = true;
        } else {
            equals = comparator.equals(comparator2);
        }
        Collection entrySet = map.entrySet();
        Map.Entry[] entryArr = zzcd.zza;
        if (!(entrySet instanceof Collection)) {
            Iterator it = entrySet.iterator();
            Collection arrayList = new ArrayList();
            it.getClass();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            entrySet = arrayList;
        }
        Map.Entry[] entryArr2 = (Map.Entry[]) entrySet.toArray(entryArr);
        int length = entryArr2.length;
        if (length != 0) {
            if (length != 1) {
                Object[] objArr = new Object[length];
                Object[] objArr2 = new Object[length];
                if (equals) {
                    for (int i11 = 0; i11 < length; i11++) {
                        Map.Entry entry = entryArr2[i11];
                        Objects.requireNonNull(entry);
                        Map.Entry entry2 = entry;
                        Object key = entry2.getKey();
                        Object value = entry2.getValue();
                        zzbv.zza(key, value);
                        objArr[i11] = key;
                        objArr2[i11] = value;
                    }
                } else {
                    Arrays.sort(entryArr2, 0, length, new Comparator() { // from class: com.google.android.gms.internal.fido.zzcg
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            Map.Entry entry3 = (Map.Entry) obj;
                            Map.Entry entry4 = (Map.Entry) obj2;
                            Objects.requireNonNull(entry3);
                            Objects.requireNonNull(entry4);
                            return comparator.compare(entry3.getKey(), entry4.getKey());
                        }
                    });
                    Map.Entry entry3 = entryArr2[0];
                    Objects.requireNonNull(entry3);
                    Map.Entry entry4 = entry3;
                    Object key2 = entry4.getKey();
                    objArr[0] = key2;
                    Object value2 = entry4.getValue();
                    objArr2[0] = value2;
                    zzbv.zza(objArr[0], value2);
                    while (i10 < length) {
                        Map.Entry entry5 = entryArr2[i10 - 1];
                        Objects.requireNonNull(entry5);
                        Map.Entry entry6 = entry5;
                        Map.Entry entry7 = entryArr2[i10];
                        Objects.requireNonNull(entry7);
                        Map.Entry entry8 = entry7;
                        Object key3 = entry8.getKey();
                        Object value3 = entry8.getValue();
                        zzbv.zza(key3, value3);
                        objArr[i10] = key3;
                        objArr2[i10] = value3;
                        if (comparator.compare(key2, key3) != 0) {
                            i10++;
                            key2 = key3;
                        } else {
                            throw new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(entry6) + " and " + String.valueOf(entry8));
                        }
                    }
                }
                return new zzcj(new zzcv(zzcc.zzh(objArr, length), comparator), zzcc.zzh(objArr2, length), null);
            }
            Map.Entry entry9 = entryArr2[0];
            Objects.requireNonNull(entry9);
            Map.Entry entry10 = entry9;
            return new zzcj(new zzcv(zzcc.zzj(entry10.getKey()), comparator), zzcc.zzj(entry10.getValue()), null);
        }
        return zzg(comparator);
    }

    static zzcj zzg(Comparator comparator) {
        if (zzcq.zza.equals(comparator)) {
            return zzc;
        }
        zzcv zzs = zzck.zzs(comparator);
        int i10 = zzcc.zzd;
        return new zzcj(zzs, zzct.zza, null);
    }

    private final zzcj zzl(int i10, int i11) {
        if (i10 == 0) {
            if (i11 != this.zze.size()) {
                i10 = 0;
            } else {
                return this;
            }
        }
        if (i10 == i11) {
            return zzg(((zzck) this.zzd).zza);
        }
        return new zzcj(this.zzd.zzw(i10, i11), this.zze.subList(i10, i11), null);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry ceilingEntry(Object obj) {
        return tailMap(obj, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public final Object ceilingKey(Object obj) {
        return zzco.zza(ceilingEntry(obj));
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return ((zzck) this.zzd).zza;
    }

    @Override // java.util.NavigableMap
    public final /* synthetic */ NavigableSet descendingKeySet() {
        return this.zzd.descendingSet();
    }

    @Override // java.util.NavigableMap
    public final /* bridge */ /* synthetic */ NavigableMap descendingMap() {
        zzcs zzbwVar;
        zzcj zzcjVar = this.zzf;
        if (zzcjVar == null) {
            if (isEmpty()) {
                Comparator comparator = ((zzck) this.zzd).zza;
                if (comparator instanceof zzcs) {
                    zzbwVar = (zzcs) comparator;
                } else {
                    zzbwVar = new zzbw(comparator);
                }
                return zzg(zzbwVar.zza());
            }
            return new zzcj((zzcv) this.zzd.descendingSet(), this.zze.zzf(), this);
        }
        return zzcjVar;
    }

    @Override // com.google.android.gms.internal.fido.zzcd, java.util.Map
    public final /* bridge */ /* synthetic */ Set entrySet() {
        return entrySet();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().zzi().get(0);
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return this.zzd.first();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry floorEntry(Object obj) {
        return headMap(obj, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public final Object floorKey(Object obj) {
        return zzco.zza(floorEntry(obj));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x000f, code lost:
    
        if (r4 < 0) goto L٤;
     */
    @Override // com.google.android.gms.internal.fido.zzcd, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(Object obj) {
        int binarySearch;
        zzcv zzcvVar = this.zzd;
        if (obj != null) {
            try {
                binarySearch = Collections.binarySearch(zzcvVar.zzd, obj, ((zzck) zzcvVar).zza);
            } catch (ClassCastException unused) {
            }
        }
        binarySearch = -1;
        if (binarySearch == -1) {
            return null;
        }
        return this.zze.get(binarySearch);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* synthetic */ SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap
    public final Map.Entry higherEntry(Object obj) {
        return tailMap(obj, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public final Object higherKey(Object obj) {
        return zzco.zza(higherEntry(obj));
    }

    @Override // com.google.android.gms.internal.fido.zzcd, java.util.Map
    public final /* synthetic */ Set keySet() {
        return this.zzd;
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().zzi().get(this.zze.size() - 1);
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return this.zzd.last();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry lowerEntry(Object obj) {
        return headMap(obj, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public final Object lowerKey(Object obj) {
        return zzco.zza(lowerEntry(obj));
    }

    @Override // java.util.NavigableMap
    public final /* synthetic */ NavigableSet navigableKeySet() {
        return this.zzd;
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final int size() {
        return this.zze.size();
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public final /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    @Override // com.google.android.gms.internal.fido.zzcd, java.util.Map
    public final /* synthetic */ Collection values() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.fido.zzcd
    /* renamed from: zza */
    public final zzby values() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.fido.zzcd
    final zzcf zzb() {
        if (isEmpty()) {
            return zzcu.zza;
        }
        return new zzci(this);
    }

    @Override // com.google.android.gms.internal.fido.zzcd
    /* renamed from: zzd */
    public final /* synthetic */ zzcf keySet() {
        return this.zzd;
    }

    @Override // java.util.NavigableMap
    /* renamed from: zzh, reason: merged with bridge method [inline-methods] */
    public final zzcj headMap(Object obj, boolean z10) {
        obj.getClass();
        return zzl(0, this.zzd.zzu(obj, z10));
    }

    @Override // java.util.NavigableMap
    /* renamed from: zzi, reason: merged with bridge method [inline-methods] */
    public final zzcj subMap(Object obj, boolean z10, Object obj2, boolean z11) {
        obj.getClass();
        obj2.getClass();
        if (((zzck) this.zzd).zza.compare(obj, obj2) <= 0) {
            return headMap(obj2, z11).tailMap(obj, z10);
        }
        throw new IllegalArgumentException(zzbo.zza("expected fromKey <= toKey but %s > %s", obj, obj2));
    }

    @Override // java.util.NavigableMap
    /* renamed from: zzj, reason: merged with bridge method [inline-methods] */
    public final zzcj tailMap(Object obj, boolean z10) {
        obj.getClass();
        return zzl(this.zzd.zzv(obj, z10), this.zze.size());
    }
}
