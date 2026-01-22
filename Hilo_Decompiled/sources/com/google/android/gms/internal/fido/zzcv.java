package com.google.android.gms.internal.fido;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class zzcv extends zzck {
    static final zzcv zzc;
    final transient zzcc zzd;

    static {
        int i10 = zzcc.zzd;
        zzc = new zzcv(zzct.zza, zzcq.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcv(zzcc zzccVar, Comparator comparator) {
        super(comparator);
        this.zzd = zzccVar;
    }

    @Override // com.google.android.gms.internal.fido.zzck, java.util.NavigableSet
    public final Object ceiling(Object obj) {
        zzcc zzccVar = this.zzd;
        int zzv = zzv(obj, true);
        if (zzv == zzccVar.size()) {
            return null;
        }
        return this.zzd.get(zzv);
    }

    @Override // com.google.android.gms.internal.fido.zzby, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            try {
                if (Collections.binarySearch(this.zzd, obj, ((zzck) this).zza) >= 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        if (collection instanceof zzcp) {
            collection = ((zzcp) collection).zza();
        }
        if (zzdb.zza(((zzck) this).zza, collection) && collection.size() > 1) {
            zzdd listIterator = this.zzd.listIterator(0);
            Iterator it = collection.iterator();
            if (!listIterator.hasNext()) {
                return false;
            }
            Object next = it.next();
            E next2 = listIterator.next();
            while (true) {
                try {
                    int compare = ((zzck) this).zza.compare(next2, next);
                    if (compare < 0) {
                        if (!listIterator.hasNext()) {
                            return false;
                        }
                        next2 = listIterator.next();
                    } else {
                        if (compare != 0) {
                            break;
                        }
                        if (!it.hasNext()) {
                            return true;
                        }
                        next = it.next();
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
        } else {
            return super.containsAll(collection);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.fido.zzcf, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (this.zzd.size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (zzdb.zza(((zzck) this).zza, set)) {
            Iterator it = set.iterator();
            try {
                zzdd listIterator = this.zzd.listIterator(0);
                while (listIterator.hasNext()) {
                    E next = listIterator.next();
                    Object next2 = it.next();
                    if (next2 == null || ((zzck) this).zza.compare(next, next2) != 0) {
                        return false;
                    }
                }
                return true;
            } catch (ClassCastException | NoSuchElementException unused) {
                return false;
            }
        }
        return containsAll(set);
    }

    @Override // com.google.android.gms.internal.fido.zzck, java.util.SortedSet
    public final Object first() {
        if (!isEmpty()) {
            return this.zzd.get(0);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.gms.internal.fido.zzck, java.util.NavigableSet
    public final Object floor(Object obj) {
        int zzu = zzu(obj, true) - 1;
        if (zzu == -1) {
            return null;
        }
        return this.zzd.get(zzu);
    }

    @Override // com.google.android.gms.internal.fido.zzck, java.util.NavigableSet
    public final Object higher(Object obj) {
        zzcc zzccVar = this.zzd;
        int zzv = zzv(obj, false);
        if (zzv == zzccVar.size()) {
            return null;
        }
        return this.zzd.get(zzv);
    }

    @Override // com.google.android.gms.internal.fido.zzck, com.google.android.gms.internal.fido.zzcf, com.google.android.gms.internal.fido.zzby, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzd.listIterator(0);
    }

    @Override // com.google.android.gms.internal.fido.zzck, java.util.SortedSet
    public final Object last() {
        if (!isEmpty()) {
            return this.zzd.get(r0.size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.gms.internal.fido.zzck, java.util.NavigableSet
    public final Object lower(Object obj) {
        int zzu = zzu(obj, false) - 1;
        if (zzu == -1) {
            return null;
        }
        return this.zzd.get(zzu);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzd.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.fido.zzby
    public final int zza(Object[] objArr, int i10) {
        return this.zzd.zza(objArr, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.fido.zzby
    public final int zzb() {
        return this.zzd.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.fido.zzby
    public final int zzc() {
        return this.zzd.zzc();
    }

    @Override // com.google.android.gms.internal.fido.zzck, com.google.android.gms.internal.fido.zzcf, com.google.android.gms.internal.fido.zzby
    /* renamed from: zzd */
    public final zzdc iterator() {
        return this.zzd.listIterator(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.fido.zzby
    public final Object[] zze() {
        return this.zzd.zze();
    }

    @Override // com.google.android.gms.internal.fido.zzck
    final zzck zzf() {
        Comparator reverseOrder = Collections.reverseOrder(((zzck) this).zza);
        if (isEmpty()) {
            return zzck.zzs(reverseOrder);
        }
        return new zzcv(this.zzd.zzf(), reverseOrder);
    }

    @Override // com.google.android.gms.internal.fido.zzcf
    public final zzcc zzi() {
        return this.zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.fido.zzck
    public final zzck zzo(Object obj, boolean z10) {
        return zzw(0, zzu(obj, z10));
    }

    @Override // com.google.android.gms.internal.fido.zzck
    final zzck zzq(Object obj, boolean z10, Object obj2, boolean z11) {
        return zzr(obj, z10).zzo(obj2, z11);
    }

    @Override // com.google.android.gms.internal.fido.zzck
    final zzck zzr(Object obj, boolean z10) {
        return zzw(zzv(obj, z10), this.zzd.size());
    }

    @Override // com.google.android.gms.internal.fido.zzck, java.util.NavigableSet
    /* renamed from: zzt */
    public final zzdc descendingIterator() {
        return this.zzd.zzf().listIterator(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzu(Object obj, boolean z10) {
        obj.getClass();
        int binarySearch = Collections.binarySearch(this.zzd, obj, ((zzck) this).zza);
        if (binarySearch >= 0) {
            if (z10) {
                return binarySearch + 1;
            }
            return binarySearch;
        }
        return ~binarySearch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzv(Object obj, boolean z10) {
        obj.getClass();
        int binarySearch = Collections.binarySearch(this.zzd, obj, ((zzck) this).zza);
        if (binarySearch >= 0) {
            if (z10) {
                return binarySearch;
            }
            return binarySearch + 1;
        }
        return ~binarySearch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzcv zzw(int i10, int i11) {
        if (i10 == 0) {
            if (i11 != this.zzd.size()) {
                i10 = 0;
            } else {
                return this;
            }
        }
        if (i10 < i11) {
            zzcc zzccVar = this.zzd;
            return new zzcv(zzccVar.subList(i10, i11), ((zzck) this).zza);
        }
        return zzck.zzs(((zzck) this).zza);
    }
}
