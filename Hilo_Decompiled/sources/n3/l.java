package n3;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import s3.j;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class l implements m, j {

    /* renamed from: d, reason: collision with root package name */
    private final String f١٦٢٤٨d;

    /* renamed from: f, reason: collision with root package name */
    private final s3.j f١٦٢٥٠f;

    /* renamed from: a, reason: collision with root package name */
    private final Path f١٦٢٤٥a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final Path f١٦٢٤٦b = new Path();

    /* renamed from: c, reason: collision with root package name */
    private final Path f١٦٢٤٧c = new Path();

    /* renamed from: e, reason: collision with root package name */
    private final List f١٦٢٤٩e = new ArrayList();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f١٦٢٥١a;

        static {
            int[] iArr = new int[j.a.values().length];
            f١٦٢٥١a = iArr;
            try {
                iArr[j.a.MERGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f١٦٢٥١a[j.a.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f١٦٢٥١a[j.a.SUBTRACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f١٦٢٥١a[j.a.INTERSECT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f١٦٢٥١a[j.a.EXCLUDE_INTERSECTIONS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public l(s3.j jVar) {
        this.f١٦٢٤٨d = jVar.c();
        this.f١٦٢٥٠f = jVar;
    }

    private void a() {
        for (int i10 = 0; i10 < this.f١٦٢٤٩e.size(); i10++) {
            this.f١٦٢٤٧c.addPath(((m) this.f١٦٢٤٩e.get(i10)).getPath());
        }
    }

    private void c(Path.Op op) {
        this.f١٦٢٤٦b.reset();
        this.f١٦٢٤٥a.reset();
        for (int size = this.f١٦٢٤٩e.size() - 1; size >= 1; size--) {
            m mVar = (m) this.f١٦٢٤٩e.get(size);
            if (mVar instanceof d) {
                d dVar = (d) mVar;
                List k10 = dVar.k();
                for (int size2 = k10.size() - 1; size2 >= 0; size2--) {
                    Path path = ((m) k10.get(size2)).getPath();
                    path.transform(dVar.l());
                    this.f١٦٢٤٦b.addPath(path);
                }
            } else {
                this.f١٦٢٤٦b.addPath(mVar.getPath());
            }
        }
        m mVar2 = (m) this.f١٦٢٤٩e.get(0);
        if (mVar2 instanceof d) {
            d dVar2 = (d) mVar2;
            List k11 = dVar2.k();
            for (int i10 = 0; i10 < k11.size(); i10++) {
                Path path2 = ((m) k11.get(i10)).getPath();
                path2.transform(dVar2.l());
                this.f١٦٢٤٥a.addPath(path2);
            }
        } else {
            this.f١٦٢٤٥a.set(mVar2.getPath());
        }
        this.f١٦٢٤٧c.op(this.f١٦٢٤٥a, this.f١٦٢٤٦b, op);
    }

    @Override // n3.c
    public void b(List list, List list2) {
        for (int i10 = 0; i10 < this.f١٦٢٤٩e.size(); i10++) {
            ((m) this.f١٦٢٤٩e.get(i10)).b(list, list2);
        }
    }

    @Override // n3.j
    public void g(ListIterator listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            c cVar = (c) listIterator.previous();
            if (cVar instanceof m) {
                this.f١٦٢٤٩e.add((m) cVar);
                listIterator.remove();
            }
        }
    }

    @Override // n3.m
    public Path getPath() {
        this.f١٦٢٤٧c.reset();
        if (this.f١٦٢٥٠f.d()) {
            return this.f١٦٢٤٧c;
        }
        int i10 = a.f١٦٢٥١a[this.f١٦٢٥٠f.b().ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 == 5) {
                            c(Path.Op.XOR);
                        }
                    } else {
                        c(Path.Op.INTERSECT);
                    }
                } else {
                    c(Path.Op.REVERSE_DIFFERENCE);
                }
            } else {
                c(Path.Op.UNION);
            }
        } else {
            a();
        }
        return this.f١٦٢٤٧c;
    }
}
