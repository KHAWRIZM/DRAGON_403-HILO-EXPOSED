package anet.channel.strategy;

import anet.channel.util.HttpConstant;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f٤٩٨١a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private boolean f٤٩٨٢b = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static c f٤٩٨٣a = new c();

        private a() {
        }
    }

    public void a(boolean z10) {
        this.f٤٩٨٢b = z10;
    }

    public void b(String str) {
        this.f٤٩٨١a.put(str, HttpConstant.HTTP);
    }

    public String a(String str) {
        if (!this.f٤٩٨٢b) {
            return null;
        }
        String str2 = this.f٤٩٨١a.get(str);
        if (str2 != null) {
            return str2;
        }
        this.f٤٩٨١a.put(str, HttpConstant.HTTPS);
        return HttpConstant.HTTPS;
    }
}
