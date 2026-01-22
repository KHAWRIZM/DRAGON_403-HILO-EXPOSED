package p7;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private long f١٦٩٦١a;

    /* renamed from: b, reason: collision with root package name */
    private long f١٦٩٦٢b;

    /* renamed from: c, reason: collision with root package name */
    private TimeInterpolator f١٦٩٦٣c;

    /* renamed from: d, reason: collision with root package name */
    private int f١٦٩٦٤d;

    /* renamed from: e, reason: collision with root package name */
    private int f١٦٩٦٥e;

    public i(long j10, long j11) {
        this.f١٦٩٦٣c = null;
        this.f١٦٩٦٤d = 0;
        this.f١٦٩٦٥e = 1;
        this.f١٦٩٦١a = j10;
        this.f١٦٩٦٢b = j11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i b(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), valueAnimator.getInterpolator());
        iVar.f١٦٩٦٤d = valueAnimator.getRepeatCount();
        iVar.f١٦٩٦٥e = valueAnimator.getRepeatMode();
        return iVar;
    }

    public void a(Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(f());
            valueAnimator.setRepeatMode(g());
        }
    }

    public long c() {
        return this.f١٦٩٦١a;
    }

    public long d() {
        return this.f١٦٩٦٢b;
    }

    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f١٦٩٦٣c;
        if (timeInterpolator == null) {
            return a.f١٦٩٤٨b;
        }
        return timeInterpolator;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (c() != iVar.c() || d() != iVar.d() || f() != iVar.f() || g() != iVar.g()) {
            return false;
        }
        return e().getClass().equals(iVar.e().getClass());
    }

    public int f() {
        return this.f١٦٩٦٤d;
    }

    public int g() {
        return this.f١٦٩٦٥e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + f()) * 31) + g();
    }

    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + f() + " repeatMode: " + g() + "}\n";
    }

    public i(long j10, long j11, TimeInterpolator timeInterpolator) {
        this.f١٦٩٦٤d = 0;
        this.f١٦٩٦٥e = 1;
        this.f١٦٩٦١a = j10;
        this.f١٦٩٦٢b = j11;
        this.f١٦٩٦٣c = timeInterpolator;
    }
}
