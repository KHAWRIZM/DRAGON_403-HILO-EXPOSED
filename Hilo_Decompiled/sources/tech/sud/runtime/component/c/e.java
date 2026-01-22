package tech.sud.runtime.component.c;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Process;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.android.agoo.common.AgooConstants;
import tech.sud.runtime.core.JNIShell;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes6.dex */
public class e {
    private long a;
    private ActivityManager d;
    private boolean f;
    private ScheduledExecutorService g;
    private final ComponentCallbacks2 h;
    private AtomicLong b = new AtomicLong(0);
    private int[] c = new int[1];
    private boolean e = false;

    public e(Context context) {
        this.a = 0L;
        this.f = false;
        ComponentCallbacks2 componentCallbacks2 = new ComponentCallbacks2() { // from class: tech.sud.runtime.component.c.e.1
            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
            }

            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int i) {
                e.this.a(i);
            }
        };
        this.h = componentCallbacks2;
        this.d = (ActivityManager) context.getSystemService(AgooConstants.OPEN_ACTIIVTY_NAME);
        int myPid = Process.myPid();
        boolean deviceIs64Bit = JNIShell.deviceIs64Bit();
        this.f = false;
        if (!deviceIs64Bit) {
            long b = b();
            this.a = b;
            if (b > 3000000) {
                this.a = 3000000L;
                this.f = true;
            }
            this.c[0] = myPid;
        }
        context.registerComponentCallbacks(componentCallbacks2);
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1);
        this.g = newScheduledThreadPool;
        newScheduledThreadPool.scheduleAtFixedRate(new Runnable() { // from class: tech.sud.runtime.component.c.e.2
            @Override // java.lang.Runnable
            public void run() {
                e.this.a(e.this.d.getProcessMemoryInfo(e.this.c)[0].getTotalPss());
            }
        }, 2L, 2L, TimeUnit.SECONDS);
    }

    private void c() {
        this.e = true;
    }

    private long b() {
        String readLine;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
            } while (!readLine.contains("MemTotal"));
            bufferedReader.close();
            String[] split = readLine.split(" kB")[0].split(" ");
            return Integer.parseInt(split[split.length - 1]);
        } catch (Exception unused) {
            tech.sud.runtime.component.h.f.d("Memory", "getTotalMemory failed");
            return 0L;
        }
    }

    public void a(Context context) {
        this.g.shutdown();
        try {
            context.unregisterComponentCallbacks(this.h);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a() {
        if (!this.e) {
            return this.f && this.b.get() >= this.a;
        }
        this.e = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        this.b.set(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        if (i == 5 || i == 10 || i == 15) {
            c();
        } else if (i == 40 || i == 60 || i == 80) {
            c();
        }
    }
}
