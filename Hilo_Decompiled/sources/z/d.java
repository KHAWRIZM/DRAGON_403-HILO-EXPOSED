package z;

import java.io.IOException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public static final d f١٩٣٢٧a = new d();

    public d() {
        super("Interrupted");
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        throw new IllegalAccessError("Stack is ignored for signal");
    }
}
