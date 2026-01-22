package androidx.emoji2.text;

import android.content.Context;
import androidx.core.os.y;
import androidx.emoji2.text.EmojiCompatInitializer;
import androidx.emoji2.text.f;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class EmojiCompatInitializer implements g3.a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a implements DefaultLifecycleObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Lifecycle f٣٥٨٦a;

        a(Lifecycle lifecycle) {
            this.f٣٥٨٦a = lifecycle;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.f.a(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.f.b(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.f.c(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onResume(LifecycleOwner lifecycleOwner) {
            EmojiCompatInitializer.this.c();
            this.f٣٥٨٦a.removeObserver(this);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.f.e(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.f.f(this, lifecycleOwner);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b extends f.c {
        protected b(Context context) {
            super(new c(context));
            b(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c implements f.h {

        /* renamed from: a, reason: collision with root package name */
        private final Context f٣٥٨٨a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class a extends f.i {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ f.i f٣٥٨٩a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ ThreadPoolExecutor f٣٥٩٠b;

            a(f.i iVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f٣٥٨٩a = iVar;
                this.f٣٥٩٠b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.f.i
            public void a(Throwable th) {
                try {
                    this.f٣٥٨٩a.a(th);
                } finally {
                    this.f٣٥٩٠b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.f.i
            public void b(n nVar) {
                try {
                    this.f٣٥٨٩a.b(nVar);
                } finally {
                    this.f٣٥٩٠b.shutdown();
                }
            }
        }

        c(Context context) {
            this.f٣٥٨٨a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.f.h
        public void a(final f.i iVar) {
            final ThreadPoolExecutor b10 = androidx.emoji2.text.c.b("EmojiCompatInitializer");
            b10.execute(new Runnable() { // from class: androidx.emoji2.text.g
                @Override // java.lang.Runnable
                public final void run() {
                    EmojiCompatInitializer.c.this.d(iVar, b10);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(f.i iVar, ThreadPoolExecutor threadPoolExecutor) {
            try {
                k a10 = androidx.emoji2.text.d.a(this.f٣٥٨٨a);
                if (a10 != null) {
                    a10.c(threadPoolExecutor);
                    a10.a().a(new a(iVar, threadPoolExecutor));
                    return;
                }
                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            } catch (Throwable th) {
                iVar.a(th);
                threadPoolExecutor.shutdown();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                y.a("EmojiCompat.EmojiCompatInitializer.run");
                if (f.i()) {
                    f.c().l();
                }
            } finally {
                y.b();
            }
        }
    }

    @Override // g3.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean create(Context context) {
        f.h(new b(context));
        b(context);
        return Boolean.TRUE;
    }

    void b(Context context) {
        Lifecycle lifecycle = ((LifecycleOwner) androidx.startup.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.addObserver(new a(lifecycle));
    }

    void c() {
        androidx.emoji2.text.c.d().postDelayed(new d(), 500L);
    }

    @Override // g3.a
    public List dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
