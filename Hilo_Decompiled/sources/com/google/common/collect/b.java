package com.google.common.collect;

import java.util.NoSuchElementException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b extends m0 {

    /* renamed from: a, reason: collision with root package name */
    private EnumC٠١٢١b f١٠٣٧٥a = EnumC٠١٢١b.NOT_READY;

    /* renamed from: b, reason: collision with root package name */
    private Object f١٠٣٧٦b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٠٣٧٧a;

        static {
            int[] iArr = new int[EnumC٠١٢١b.values().length];
            f١٠٣٧٧a = iArr;
            try {
                iArr[EnumC٠١٢١b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٠٣٧٧a[EnumC٠١٢١b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.google.common.collect.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public enum EnumC٠١٢١b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    private boolean c() {
        this.f١٠٣٧٥a = EnumC٠١٢١b.FAILED;
        this.f١٠٣٧٦b = a();
        if (this.f١٠٣٧٥a != EnumC٠١٢١b.DONE) {
            this.f١٠٣٧٥a = EnumC٠١٢١b.READY;
            return true;
        }
        return false;
    }

    protected abstract Object a();

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object b() {
        this.f١٠٣٧٥a = EnumC٠١٢١b.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        boolean z10;
        if (this.f١٠٣٧٥a != EnumC٠١٢١b.FAILED) {
            z10 = true;
        } else {
            z10 = false;
        }
        k8.h.n(z10);
        int i10 = a.f١٠٣٧٧a[this.f١٠٣٧٥a.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 == 2) {
            return true;
        }
        return c();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            this.f١٠٣٧٥a = EnumC٠١٢١b.NOT_READY;
            Object a10 = b0.a(this.f١٠٣٧٦b);
            this.f١٠٣٧٦b = null;
            return a10;
        }
        throw new NoSuchElementException();
    }
}
