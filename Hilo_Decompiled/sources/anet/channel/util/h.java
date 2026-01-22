package anet.channel.util;

import anet.channel.request.Request;
import anet.channel.thread.ThreadPoolExecutorFactory;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Integer> f٥٠٨٨a;

    static {
        HashMap hashMap = new HashMap();
        f٥٠٨٨a = hashMap;
        hashMap.put("tpatch", 3);
        f٥٠٨٨a.put("so", 3);
        f٥٠٨٨a.put("json", 3);
        f٥٠٨٨a.put("html", 4);
        f٥٠٨٨a.put("htm", 4);
        f٥٠٨٨a.put("css", 5);
        f٥٠٨٨a.put("js", 5);
        f٥٠٨٨a.put("webp", 6);
        f٥٠٨٨a.put("png", 6);
        f٥٠٨٨a.put("jpg", 6);
        f٥٠٨٨a.put("do", 6);
        f٥٠٨٨a.put("zip", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
        f٥٠٨٨a.put("bin", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
        f٥٠٨٨a.put("apk", Integer.valueOf(ThreadPoolExecutorFactory.Priority.LOW));
    }

    public static int a(Request request) {
        Integer num;
        if (request != null) {
            if (request.getHeaders().containsKey(HttpConstant.X_PV)) {
                return 1;
            }
            String trySolveFileExtFromUrlPath = HttpHelper.trySolveFileExtFromUrlPath(request.getHttpUrl().path());
            if (trySolveFileExtFromUrlPath == null || (num = f٥٠٨٨a.get(trySolveFileExtFromUrlPath)) == null) {
                return 6;
            }
            return num.intValue();
        }
        throw new NullPointerException("url is null!");
    }
}
