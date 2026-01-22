package anet.channel;

import android.text.TextUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    Map<String, Integer> f٤٦٩٤a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    Map<String, SessionInfo> f٤٦٩٥b = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SessionInfo sessionInfo) {
        if (sessionInfo != null) {
            if (!TextUtils.isEmpty(sessionInfo.host)) {
                this.f٤٦٩٥b.put(sessionInfo.host, sessionInfo);
                return;
            }
            throw new IllegalArgumentException("host cannot be null or empty");
        }
        throw new NullPointerException("info is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionInfo b(String str) {
        return this.f٤٦٩٥b.get(str);
    }

    public int c(String str) {
        Integer num;
        synchronized (this.f٤٦٩٤a) {
            num = this.f٤٦٩٤a.get(str);
        }
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionInfo a(String str) {
        return this.f٤٦٩٥b.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<SessionInfo> a() {
        return this.f٤٦٩٥b.values();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, int i10) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.f٤٦٩٤a) {
                this.f٤٦٩٤a.put(str, Integer.valueOf(i10));
            }
            return;
        }
        throw new IllegalArgumentException("host cannot be null or empty");
    }
}
