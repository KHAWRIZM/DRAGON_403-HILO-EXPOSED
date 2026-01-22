package com.google.protobuf;

import com.google.protobuf.n;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class h2 {

    /* renamed from: b, reason: collision with root package name */
    private static final Logger f١١٠٩٨b = Logger.getLogger(h2.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final Map f١١٠٩٩a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final h2 f١١١٠٠a = new h2(Collections.emptyMap());
    }

    h2(Map map) {
        this.f١١٠٩٩a = map;
    }

    public static h2 c() {
        return a.f١١١٠٠a;
    }

    private static String d(String str) {
        String[] split = str.split("/");
        if (split.length != 1) {
            return split[split.length - 1];
        }
        throw new k0("Invalid type url found: " + str);
    }

    public n.b a(String str) {
        return (n.b) this.f١١٠٩٩a.get(str);
    }

    public final n.b b(String str) {
        return a(d(str));
    }
}
