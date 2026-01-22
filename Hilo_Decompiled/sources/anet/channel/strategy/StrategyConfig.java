package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.l;
import anet.channel.strategy.utils.SerialLruCache;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class StrategyConfig implements Serializable {
    public static final String NO_RESULT = "No_Result";

    /* renamed from: a, reason: collision with root package name */
    private SerialLruCache<String, String> f٤٩٥٥a = null;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f٤٩٥٦b = null;

    /* renamed from: c, reason: collision with root package name */
    private transient StrategyInfoHolder f٤٩٥٧c = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StrategyConfig a() {
        StrategyConfig strategyConfig = new StrategyConfig();
        synchronized (this) {
            strategyConfig.f٤٩٥٥a = new SerialLruCache<>(this.f٤٩٥٥a, 256);
            strategyConfig.f٤٩٥٦b = new ConcurrentHashMap(this.f٤٩٥٦b);
            strategyConfig.f٤٩٥٧c = this.f٤٩٥٧c;
        }
        return strategyConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f٤٩٥٥a == null) {
            this.f٤٩٥٥a = new SerialLruCache<>(256);
        }
        if (this.f٤٩٥٦b == null) {
            this.f٤٩٥٦b = new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this) {
            str2 = this.f٤٩٥٦b.get(str);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(StrategyInfoHolder strategyInfoHolder) {
        this.f٤٩٥٧c = strategyInfoHolder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l.d dVar) {
        if (dVar.f٥٠٣٩b == null) {
            return;
        }
        synchronized (this) {
            TreeMap treeMap = null;
            int i10 = 0;
            while (true) {
                try {
                    l.b[] bVarArr = dVar.f٥٠٣٩b;
                    if (i10 >= bVarArr.length) {
                        break;
                    }
                    l.b bVar = bVarArr[i10];
                    if (bVar.f٥٠٣٣j) {
                        this.f٤٩٥٥a.remove(bVar.f٥٠٢٤a);
                    } else if (bVar.f٥٠٢٧d != null) {
                        if (treeMap == null) {
                            treeMap = new TreeMap();
                        }
                        treeMap.put(bVar.f٥٠٢٤a, bVar.f٥٠٢٧d);
                    } else {
                        if (!HttpConstant.HTTP.equalsIgnoreCase(bVar.f٥٠٢٦c) && !HttpConstant.HTTPS.equalsIgnoreCase(bVar.f٥٠٢٦c)) {
                            this.f٤٩٥٥a.put(bVar.f٥٠٢٤a, NO_RESULT);
                        } else {
                            this.f٤٩٥٥a.put(bVar.f٥٠٢٤a, bVar.f٥٠٢٦c);
                        }
                        if (!TextUtils.isEmpty(bVar.f٥٠٢٨e)) {
                            this.f٤٩٥٦b.put(bVar.f٥٠٢٤a, bVar.f٥٠٢٨e);
                        } else {
                            this.f٤٩٥٦b.remove(bVar.f٥٠٢٤a);
                        }
                    }
                    i10++;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (treeMap != null) {
                for (Map.Entry entry : treeMap.entrySet()) {
                    String str = (String) entry.getValue();
                    if (this.f٤٩٥٥a.containsKey(str)) {
                        this.f٤٩٥٥a.put(entry.getKey(), this.f٤٩٥٥a.get(str));
                    } else {
                        this.f٤٩٥٥a.put(entry.getKey(), NO_RESULT);
                    }
                }
            }
        }
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.StrategyConfig", "", null, "SchemeMap", this.f٤٩٥٥a.toString());
            ALog.d("awcn.StrategyConfig", "", null, "UnitMap", this.f٤٩٥٦b.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        String str2;
        if (TextUtils.isEmpty(str) || !anet.channel.strategy.utils.c.c(str)) {
            return null;
        }
        synchronized (this) {
            try {
                str2 = this.f٤٩٥٥a.get(str);
                if (str2 == null) {
                    this.f٤٩٥٥a.put(str, NO_RESULT);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (str2 == null) {
            this.f٤٩٥٧c.d().a(str, false);
        } else if (NO_RESULT.equals(str2)) {
            return null;
        }
        return str2;
    }
}
