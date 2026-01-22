package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.core.graphics.q0;
import androidx.core.os.y;
import androidx.emoji2.text.f;
import androidx.emoji2.text.k;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import k2.l;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class k extends f.c {

    /* renamed from: k, reason: collision with root package name */
    private static final a f٣٦٥٤k = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {
        public Typeface a(Context context, l.b bVar) {
            return k2.l.a(context, null, new l.b[]{bVar});
        }

        public l.a b(Context context, k2.f fVar) {
            return k2.l.b(context, null, fVar);
        }

        public void c(Context context, ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b implements f.h {

        /* renamed from: a, reason: collision with root package name */
        private final Context f٣٦٥٥a;

        /* renamed from: b, reason: collision with root package name */
        private final k2.f f٣٦٥٦b;

        /* renamed from: c, reason: collision with root package name */
        private final a f٣٦٥٧c;

        /* renamed from: d, reason: collision with root package name */
        private final Object f٣٦٥٨d = new Object();

        /* renamed from: e, reason: collision with root package name */
        private Handler f٣٦٥٩e;

        /* renamed from: f, reason: collision with root package name */
        private Executor f٣٦٦٠f;

        /* renamed from: g, reason: collision with root package name */
        private ThreadPoolExecutor f٣٦٦١g;

        /* renamed from: h, reason: collision with root package name */
        f.i f٣٦٦٢h;

        /* renamed from: i, reason: collision with root package name */
        private ContentObserver f٣٦٦٣i;

        /* renamed from: j, reason: collision with root package name */
        private Runnable f٣٦٦٤j;

        b(Context context, k2.f fVar, a aVar) {
            androidx.core.util.h.h(context, "Context cannot be null");
            androidx.core.util.h.h(fVar, "FontRequest cannot be null");
            this.f٣٦٥٥a = context.getApplicationContext();
            this.f٣٦٥٦b = fVar;
            this.f٣٦٥٧c = aVar;
        }

        private void b() {
            synchronized (this.f٣٦٥٨d) {
                try {
                    this.f٣٦٦٢h = null;
                    ContentObserver contentObserver = this.f٣٦٦٣i;
                    if (contentObserver != null) {
                        this.f٣٦٥٧c.c(this.f٣٦٥٥a, contentObserver);
                        this.f٣٦٦٣i = null;
                    }
                    Handler handler = this.f٣٦٥٩e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f٣٦٦٤j);
                    }
                    this.f٣٦٥٩e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f٣٦٦١g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f٣٦٦٠f = null;
                    this.f٣٦٦١g = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private l.b e() {
            try {
                l.a b10 = this.f٣٦٥٧c.b(this.f٣٦٥٥a, this.f٣٦٥٦b);
                if (b10.e() == 0) {
                    l.b[] c10 = b10.c();
                    if (c10 != null && c10.length != 0) {
                        return c10[0];
                    }
                    throw new RuntimeException("fetchFonts failed (empty result)");
                }
                throw new RuntimeException("fetchFonts failed (" + b10.e() + ")");
            } catch (PackageManager.NameNotFoundException e10) {
                throw new RuntimeException("provider not found", e10);
            }
        }

        @Override // androidx.emoji2.text.f.h
        public void a(f.i iVar) {
            androidx.core.util.h.h(iVar, "LoaderCallback cannot be null");
            synchronized (this.f٣٦٥٨d) {
                this.f٣٦٦٢h = iVar;
            }
            d();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() {
            synchronized (this.f٣٦٥٨d) {
                try {
                    if (this.f٣٦٦٢h == null) {
                        return;
                    }
                    try {
                        l.b e10 = e();
                        int b10 = e10.b();
                        if (b10 == 2) {
                            synchronized (this.f٣٦٥٨d) {
                            }
                        }
                        if (b10 == 0) {
                            try {
                                y.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                Typeface a10 = this.f٣٦٥٧c.a(this.f٣٦٥٥a, e10);
                                ByteBuffer f10 = q0.f(this.f٣٦٥٥a, null, e10.d());
                                if (f10 != null && a10 != null) {
                                    n b11 = n.b(a10, f10);
                                    y.b();
                                    synchronized (this.f٣٦٥٨d) {
                                        try {
                                            f.i iVar = this.f٣٦٦٢h;
                                            if (iVar != null) {
                                                iVar.b(b11);
                                            }
                                        } finally {
                                        }
                                    }
                                    b();
                                    return;
                                }
                                throw new RuntimeException("Unable to open file.");
                            } catch (Throwable th) {
                                y.b();
                                throw th;
                            }
                        }
                        throw new RuntimeException("fetchFonts result is not OK. (" + b10 + ")");
                    } catch (Throwable th2) {
                        synchronized (this.f٣٦٥٨d) {
                            try {
                                f.i iVar2 = this.f٣٦٦٢h;
                                if (iVar2 != null) {
                                    iVar2.a(th2);
                                }
                                b();
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        void d() {
            synchronized (this.f٣٦٥٨d) {
                try {
                    if (this.f٣٦٦٢h == null) {
                        return;
                    }
                    if (this.f٣٦٦٠f == null) {
                        ThreadPoolExecutor b10 = c.b("emojiCompat");
                        this.f٣٦٦١g = b10;
                        this.f٣٦٦٠f = b10;
                    }
                    this.f٣٦٦٠f.execute(new Runnable() { // from class: androidx.emoji2.text.l
                        @Override // java.lang.Runnable
                        public final void run() {
                            k.b.this.c();
                        }
                    });
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void f(Executor executor) {
            synchronized (this.f٣٦٥٨d) {
                this.f٣٦٦٠f = executor;
            }
        }
    }

    public k(Context context, k2.f fVar) {
        super(new b(context, fVar, f٣٦٥٤k));
    }

    public k c(Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
