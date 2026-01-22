package x5;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final b f١٨٩٢٨a = c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class a extends b {

        /* renamed from: b, reason: collision with root package name */
        private static final Map f١٨٩٢٩b;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put(Bundle.class, new s5.a());
            hashMap.put(Intent.class, new s5.b());
            f١٨٩٢٩b = Collections.unmodifiableMap(hashMap);
        }

        a() {
        }

        @Override // x5.b
        Map a() {
            return f١٨٩٢٩b;
        }

        @Override // x5.b
        public void b(String str) {
            Log.e("XLog", str);
        }

        @Override // x5.b
        String e() {
            return System.lineSeparator();
        }

        @Override // x5.b
        public void f(String str) {
            Log.w("XLog", str);
        }
    }

    private static b c() {
        try {
            Class.forName("android.os.Build");
            return new a();
        } catch (ClassNotFoundException unused) {
            return new b();
        }
    }

    public static b d() {
        return f١٨٩٢٨a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map a() {
        return Collections.emptyMap();
    }

    public void b(String str) {
        System.out.println(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String e() {
        return System.lineSeparator();
    }

    public void f(String str) {
        System.out.println(str);
    }
}
