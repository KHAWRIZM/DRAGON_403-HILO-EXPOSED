package b1;

import java.util.Collection;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c extends d {

    /* renamed from: a, reason: collision with root package name */
    private boolean f٥٣٣١a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f٥٣٣٢b;

    /* renamed from: c, reason: collision with root package name */
    private Timer f٥٣٣٣c;

    /* renamed from: d, reason: collision with root package name */
    private TimerTask f٥٣٣٤d;

    /* renamed from: e, reason: collision with root package name */
    private int f٥٣٣٥e = 60;

    /* renamed from: f, reason: collision with root package name */
    private boolean f٥٣٣٦f = false;

    public void b() {
        if (this.f٥٣٣٥e <= 0) {
            return;
        }
        this.f٥٣٣٦f = true;
        Timer timer = this.f٥٣٣٣c;
        if (timer != null) {
            timer.cancel();
            this.f٥٣٣٣c = null;
        }
        TimerTask timerTask = this.f٥٣٣٤d;
        if (timerTask != null) {
            timerTask.cancel();
            this.f٥٣٣٤d = null;
        }
        this.f٥٣٣٣c = new Timer("WebSocketTimer");
        a aVar = new a(this);
        this.f٥٣٣٤d = aVar;
        Timer timer2 = this.f٥٣٣٣c;
        long j10 = this.f٥٣٣٥e * 1000;
        timer2.scheduleAtFixedRate(aVar, j10, j10);
    }

    public abstract Collection c();

    public boolean d() {
        return this.f٥٣٣١a;
    }

    public boolean e() {
        return this.f٥٣٣٢b;
    }

    public void a() {
        Timer timer = this.f٥٣٣٣c;
        if (timer == null && this.f٥٣٣٤d == null) {
            return;
        }
        this.f٥٣٣٦f = false;
        if (timer != null) {
            timer.cancel();
            this.f٥٣٣٣c = null;
        }
        TimerTask timerTask = this.f٥٣٣٤d;
        if (timerTask != null) {
            timerTask.cancel();
            this.f٥٣٣٤d = null;
        }
    }

    public void a(boolean z10) {
        this.f٥٣٣١a = z10;
    }

    public void b(boolean z10) {
        this.f٥٣٣٢b = z10;
    }
}
