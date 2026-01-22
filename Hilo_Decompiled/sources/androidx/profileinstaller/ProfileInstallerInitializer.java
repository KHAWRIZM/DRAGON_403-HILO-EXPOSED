package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.profileinstaller.ProfileInstallerInitializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ProfileInstallerInitializer implements g3.a {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {
        public static Handler a(Looper looper) {
            Handler createAsync;
            createAsync = Handler.createAsync(looper);
            return createAsync;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Context context, long j10) {
        e(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(final Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new Runnable() { // from class: d3.f
            @Override // java.lang.Runnable
            public final void run() {
                androidx.profileinstaller.f.i(context);
            }
        });
    }

    @Override // g3.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b create(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new b();
        }
        final Context applicationContext = context.getApplicationContext();
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: d3.d
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j10) {
                ProfileInstallerInitializer.this.f(applicationContext, j10);
            }
        });
        return new b();
    }

    @Override // g3.a
    public List dependencies() {
        return Collections.emptyList();
    }

    void e(final Context context) {
        Handler handler;
        if (Build.VERSION.SDK_INT >= 28) {
            handler = a.a(Looper.getMainLooper());
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.postDelayed(new Runnable() { // from class: d3.e
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.i(context);
            }
        }, new Random().nextInt(Math.max(1000, 1)) + 5000);
    }
}
