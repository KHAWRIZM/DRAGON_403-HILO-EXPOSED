package a4;

import android.app.NotificationManager;
import android.content.Context;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f٢٢٤a;

    /* renamed from: b, reason: collision with root package name */
    private static List f٢٢٥b;

    /* renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap f٢٢٦c = new ConcurrentHashMap();

    private a() {
        f٢٢٥b = new ArrayList();
    }

    public static a a() {
        if (f٢٢٤a == null) {
            f٢٢٤a = new a();
        }
        return f٢٢٤a;
    }

    private void f() {
        ConcurrentHashMap concurrentHashMap = f٢٢٦c;
        if (concurrentHashMap.isEmpty()) {
            return;
        }
        try {
            Iterator it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                List list = (List) ((Map.Entry) it.next()).getValue();
                if (list != null) {
                    list.clear();
                }
            }
            f٢٢٦c.clear();
        } catch (Exception unused) {
        }
    }

    public void b(int i10) {
        f٢٢٥b.add(Integer.valueOf(i10));
    }

    public void c(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(TransferService.INTENT_KEY_NOTIFICATION);
        while (!f٢٢٥b.isEmpty()) {
            notificationManager.cancel(((Integer) f٢٢٥b.get(r0.size() - 1)).intValue());
            f٢٢٥b.remove(r0.size() - 1);
        }
        f();
    }

    public void d(String str) {
        ConcurrentHashMap concurrentHashMap = f٢٢٦c;
        List list = (List) concurrentHashMap.get(str);
        if (list != null) {
            list.clear();
            concurrentHashMap.remove(str);
        }
    }

    public void e(String str, b4.a aVar) {
        ConcurrentHashMap concurrentHashMap = f٢٢٦c;
        List list = (List) concurrentHashMap.get(str);
        if (list != null && !list.isEmpty()) {
            list.add(aVar);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        concurrentHashMap.put(str, arrayList);
    }
}
