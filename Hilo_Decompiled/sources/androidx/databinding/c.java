package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private List f٣٢١٦a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private long f٣٢١٧b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long[] f٣٢١٨c;

    /* renamed from: d, reason: collision with root package name */
    private int f٣٢١٩d;

    /* renamed from: e, reason: collision with root package name */
    private final a f٣٢٢٠e;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class a {
        public abstract void a(Object obj, Object obj2, int i10, Object obj3);
    }

    public c(a aVar) {
        this.f٣٢٢٠e = aVar;
    }

    private boolean c(int i10) {
        int i11;
        if (i10 < 64) {
            if (((1 << i10) & this.f٣٢١٧b) != 0) {
                return true;
            }
            return false;
        }
        long[] jArr = this.f٣٢١٨c;
        if (jArr == null || (i11 = (i10 / 64) - 1) >= jArr.length) {
            return false;
        }
        if (((1 << (i10 % 64)) & jArr[i11]) != 0) {
            return true;
        }
        return false;
    }

    private void e(Object obj, int i10, Object obj2, int i11, int i12, long j10) {
        long j11 = 1;
        while (i11 < i12) {
            if ((j10 & j11) == 0) {
                this.f٣٢٢٠e.a(this.f٣٢١٦a.get(i11), obj, i10, obj2);
            }
            j11 <<= 1;
            i11++;
        }
    }

    private void f(Object obj, int i10, Object obj2) {
        e(obj, i10, obj2, 0, Math.min(64, this.f٣٢١٦a.size()), this.f٣٢١٧b);
    }

    private void g(Object obj, int i10, Object obj2) {
        int length;
        int size = this.f٣٢١٦a.size();
        long[] jArr = this.f٣٢١٨c;
        if (jArr == null) {
            length = -1;
        } else {
            length = jArr.length - 1;
        }
        h(obj, i10, obj2, length);
        e(obj, i10, obj2, (length + 2) * 64, size, 0L);
    }

    private void h(Object obj, int i10, Object obj2, int i11) {
        if (i11 < 0) {
            f(obj, i10, obj2);
            return;
        }
        long j10 = this.f٣٢١٨c[i11];
        int i12 = (i11 + 1) * 64;
        int min = Math.min(this.f٣٢١٦a.size(), i12 + 64);
        h(obj, i10, obj2, i11 - 1);
        e(obj, i10, obj2, i12, min, j10);
    }

    private void j(int i10, long j10) {
        long j11 = Long.MIN_VALUE;
        for (int i11 = i10 + 63; i11 >= i10; i11--) {
            if ((j10 & j11) != 0) {
                this.f٣٢١٦a.remove(i11);
            }
            j11 >>>= 1;
        }
    }

    private void k(int i10) {
        if (i10 < 64) {
            this.f٣٢١٧b = (1 << i10) | this.f٣٢١٧b;
            return;
        }
        int i11 = (i10 / 64) - 1;
        long[] jArr = this.f٣٢١٨c;
        if (jArr == null) {
            this.f٣٢١٨c = new long[this.f٣٢١٦a.size() / 64];
        } else if (jArr.length <= i11) {
            long[] jArr2 = new long[this.f٣٢١٦a.size() / 64];
            long[] jArr3 = this.f٣٢١٨c;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.f٣٢١٨c = jArr2;
        }
        long j10 = 1 << (i10 % 64);
        long[] jArr4 = this.f٣٢١٨c;
        jArr4[i11] = j10 | jArr4[i11];
    }

    public synchronized void a(Object obj) {
        try {
            if (obj != null) {
                int lastIndexOf = this.f٣٢١٦a.lastIndexOf(obj);
                if (lastIndexOf >= 0) {
                    if (c(lastIndexOf)) {
                    }
                }
                this.f٣٢١٦a.add(obj);
            } else {
                throw new IllegalArgumentException("callback cannot be null");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public synchronized c clone() {
        c cVar;
        CloneNotSupportedException e10;
        try {
            cVar = (c) super.clone();
        } catch (CloneNotSupportedException e11) {
            cVar = null;
            e10 = e11;
        }
        try {
            cVar.f٣٢١٧b = 0L;
            cVar.f٣٢١٨c = null;
            cVar.f٣٢١٩d = 0;
            cVar.f٣٢١٦a = new ArrayList();
            int size = this.f٣٢١٦a.size();
            for (int i10 = 0; i10 < size; i10++) {
                if (!c(i10)) {
                    cVar.f٣٢١٦a.add(this.f٣٢١٦a.get(i10));
                }
            }
        } catch (CloneNotSupportedException e12) {
            e10 = e12;
            e10.printStackTrace();
            return cVar;
        }
        return cVar;
    }

    public synchronized void d(Object obj, int i10, Object obj2) {
        try {
            this.f٣٢١٩d++;
            g(obj, i10, obj2);
            int i11 = this.f٣٢١٩d - 1;
            this.f٣٢١٩d = i11;
            if (i11 == 0) {
                long[] jArr = this.f٣٢١٨c;
                if (jArr != null) {
                    for (int length = jArr.length - 1; length >= 0; length--) {
                        long j10 = this.f٣٢١٨c[length];
                        if (j10 != 0) {
                            j((length + 1) * 64, j10);
                            this.f٣٢١٨c[length] = 0;
                        }
                    }
                }
                long j11 = this.f٣٢١٧b;
                if (j11 != 0) {
                    j(0, j11);
                    this.f٣٢١٧b = 0L;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void i(Object obj) {
        try {
            if (this.f٣٢١٩d == 0) {
                this.f٣٢١٦a.remove(obj);
            } else {
                int lastIndexOf = this.f٣٢١٦a.lastIndexOf(obj);
                if (lastIndexOf >= 0) {
                    k(lastIndexOf);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
