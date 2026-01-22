package x;

import java.net.SocketException;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public String f١٨٨٤٩a;

    /* renamed from: b, reason: collision with root package name */
    public final g0.b f١٨٨٥٠b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f١٨٨٥١c;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f١٨٨٥٢d;

    /* renamed from: e, reason: collision with root package name */
    public volatile boolean f١٨٨٥٣e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f١٨٨٥٤f;

    /* renamed from: g, reason: collision with root package name */
    public volatile boolean f١٨٨٥٥g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f١٨٨٥٦h;

    /* renamed from: i, reason: collision with root package name */
    public volatile Exception f١٨٨٥٧i;

    public i(g0.b bVar) {
        this.f١٨٨٥٠b = bVar;
    }

    public final g0.b a() {
        g0.b bVar = this.f١٨٨٥٠b;
        if (bVar != null) {
            return bVar;
        }
        throw new IllegalArgumentException();
    }

    public final void b(Exception exc) {
        if (!this.f١٨٨٥٢d) {
            if (exc instanceof z.g) {
                this.f١٨٨٥١c = true;
                this.f١٨٨٥٧i = exc;
                return;
            }
            if (exc instanceof z.b) {
                this.f١٨٨٥٣e = true;
                this.f١٨٨٥٧i = exc;
                return;
            }
            if (exc == z.e.f١٩٣٢٨a) {
                this.f١٨٨٥٥g = true;
                return;
            }
            if (exc instanceof z.f) {
                this.f١٨٨٥٦h = true;
                this.f١٨٨٥٧i = exc;
            } else if (exc != z.d.f١٩٣٢٧a) {
                this.f١٨٨٥٤f = true;
                this.f١٨٨٥٧i = exc;
                if (!(exc instanceof SocketException)) {
                    Objects.toString(exc);
                }
            }
        }
    }

    public final boolean c() {
        if (!this.f١٨٨٥١c && !this.f١٨٨٥٢d && !this.f١٨٨٥٣e && !this.f١٨٨٥٤f && !this.f١٨٨٥٥g && !this.f١٨٨٥٦h) {
            return false;
        }
        return true;
    }
}
