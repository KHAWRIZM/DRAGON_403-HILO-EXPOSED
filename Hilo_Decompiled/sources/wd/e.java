package wd;

import java.util.Objects;
import pd.o;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class e extends wd.a {

    /* renamed from: c, reason: collision with root package name */
    final o f١٨٧٤٥c;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class a extends de.a {

        /* renamed from: f, reason: collision with root package name */
        final o f١٨٧٤٦f;

        a(sd.c cVar, o oVar) {
            super(cVar);
            this.f١٨٧٤٦f = oVar;
        }

        @Override // sd.f
        public int a(int i10) {
            return f(i10);
        }

        @Override // sd.c
        public boolean c(Object obj) {
            if (this.f١٣٦٩٦d) {
                return false;
            }
            try {
                Object apply = this.f١٨٧٤٦f.apply(obj);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                return this.f١٣٦٩٣a.c(apply);
            } catch (Throwable th) {
                e(th);
                return true;
            }
        }

        public void onNext(Object obj) {
            if (this.f١٣٦٩٦d) {
                return;
            }
            if (this.f١٣٦٩٧e != 0) {
                this.f١٣٦٩٣a.onNext((Object) null);
                return;
            }
            try {
                Object apply = this.f١٨٧٤٦f.apply(obj);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                this.f١٣٦٩٣a.onNext(apply);
            } catch (Throwable th) {
                e(th);
            }
        }

        @Override // sd.j
        public Object poll() {
            Object poll = this.f١٣٦٩٥c.poll();
            if (poll != null) {
                Object apply = this.f١٨٧٤٦f.apply(poll);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                return apply;
            }
            return null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    static final class b extends de.b {

        /* renamed from: f, reason: collision with root package name */
        final o f١٨٧٤٧f;

        b(kf.b bVar, o oVar) {
            super(bVar);
            this.f١٨٧٤٧f = oVar;
        }

        @Override // sd.f
        public int a(int i10) {
            return f(i10);
        }

        public void onNext(Object obj) {
            if (this.f١٣٧٠١d) {
                return;
            }
            if (this.f١٣٧٠٢e != 0) {
                this.f١٣٦٩٨a.onNext((Object) null);
                return;
            }
            try {
                Object apply = this.f١٨٧٤٧f.apply(obj);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                this.f١٣٦٩٨a.onNext(apply);
            } catch (Throwable th) {
                e(th);
            }
        }

        @Override // sd.j
        public Object poll() {
            Object poll = this.f١٣٧٠٠c.poll();
            if (poll != null) {
                Object apply = this.f١٨٧٤٧f.apply(poll);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                return apply;
            }
            return null;
        }
    }

    public e(io.reactivex.rxjava3.core.h hVar, o oVar) {
        super(hVar);
        this.f١٨٧٤٥c = oVar;
    }

    @Override // io.reactivex.rxjava3.core.h
    protected void p(kf.b bVar) {
        if (bVar instanceof sd.c) {
            this.f١٨٧٣٨b.o(new a((sd.c) bVar, this.f١٨٧٤٥c));
        } else {
            this.f١٨٧٣٨b.o(new b(bVar, this.f١٨٧٤٥c));
        }
    }
}
