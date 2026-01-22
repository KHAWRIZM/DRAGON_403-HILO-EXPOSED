package k2;

import android.graphics.Typeface;
import java.util.concurrent.Executor;
import k2.j;
import k2.l;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final l.c f١٥٤٢٩a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f١٥٤٣٠b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k2.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class RunnableC٠١٧٧a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l.c f١٥٤٣١a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Typeface f١٥٤٣٢b;

        RunnableC٠١٧٧a(l.c cVar, Typeface typeface) {
            this.f١٥٤٣١a = cVar;
            this.f١٥٤٣٢b = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f١٥٤٣١a.b(this.f١٥٤٣٢b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ l.c f١٥٤٣٤a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f١٥٤٣٥b;

        b(l.c cVar, int i10) {
            this.f١٥٤٣٤a = cVar;
            this.f١٥٤٣٥b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f١٥٤٣٤a.a(this.f١٥٤٣٥b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(l.c cVar, Executor executor) {
        this.f١٥٤٢٩a = cVar;
        this.f١٥٤٣٠b = executor;
    }

    private void a(int i10) {
        this.f١٥٤٣٠b.execute(new b(this.f١٥٤٢٩a, i10));
    }

    private void c(Typeface typeface) {
        this.f١٥٤٣٠b.execute(new RunnableC٠١٧٧a(this.f١٥٤٢٩a, typeface));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(j.e eVar) {
        if (eVar.a()) {
            c(eVar.f١٥٤٦٤a);
        } else {
            a(eVar.f١٥٤٦٥b);
        }
    }
}
