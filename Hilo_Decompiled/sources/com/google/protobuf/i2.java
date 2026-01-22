package com.google.protobuf;

import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class i2 extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;

    /* renamed from: a, reason: collision with root package name */
    private final List f١١١٥٦a;

    public i2(e1 e1Var) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f١١١٥٦a = null;
    }

    private static String b(List list) {
        StringBuilder sb = new StringBuilder("Message missing required fields: ");
        Iterator it = list.iterator();
        boolean z10 = true;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z10) {
                z10 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public k0 a() {
        return new k0(getMessage());
    }

    public i2(List list) {
        super(b(list));
        this.f١١١٥٦a = list;
    }
}
