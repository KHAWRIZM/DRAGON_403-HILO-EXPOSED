package oe;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
class c {

    /* renamed from: e, reason: collision with root package name */
    private static final ExecutorService f١٦٨١٦e = Executors.newCachedThreadPool();

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference f١٦٨١٧a;

    /* renamed from: b, reason: collision with root package name */
    private final oe.b f١٦٨١٨b;

    /* renamed from: c, reason: collision with root package name */
    private final Bitmap f١٦٨١٩c;

    /* renamed from: d, reason: collision with root package name */
    private final b f١٦٨٢٠d;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    class a implements Runnable {

        /* renamed from: oe.c$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        class RunnableC٠٢٠٧a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Context f١٦٨٢٢a;

            RunnableC٠٢٠٧a(Context context) {
                this.f١٦٨٢٢a = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f١٦٨٢٠d.a(oe.a.a(this.f١٦٨٢٢a, c.this.f١٦٨١٩c, c.this.f١٦٨١٨b));
            }
        }

        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = (Context) c.this.f١٦٨١٧a.get();
            if (c.this.f١٦٨٢٠d != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC٠٢٠٧a(context));
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface b {
        void a(Bitmap bitmap);
    }

    public c(Context context, Bitmap bitmap, oe.b bVar, b bVar2) {
        this.f١٦٨١٨b = bVar;
        this.f١٦٨٢٠d = bVar2;
        this.f١٦٨١٧a = new WeakReference(context);
        this.f١٦٨١٩c = bitmap;
    }

    public void e() {
        f١٦٨١٦e.execute(new a());
    }
}
