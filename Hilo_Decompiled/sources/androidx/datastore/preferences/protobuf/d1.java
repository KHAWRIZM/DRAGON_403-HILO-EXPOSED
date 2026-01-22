package androidx.datastore.preferences.protobuf;

import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d1 extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;

    /* renamed from: a, reason: collision with root package name */
    private final List f٣٢٨٣a;

    public d1(j0 j0Var) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f٣٢٨٣a = null;
    }

    public v a() {
        return new v(getMessage());
    }
}
