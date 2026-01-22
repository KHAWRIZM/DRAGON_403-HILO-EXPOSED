package anet.channel.strategy.dispatch;

import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.util.ALog;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {
    public static final String TAG = "awcn.AmdcThreadPoolExecutor";

    /* renamed from: b, reason: collision with root package name */
    private static Random f٤٩٩٣b = new Random();

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Object> f٤٩٩٤a;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: anet.channel.strategy.dispatch.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class RunnableC٠٠٦٣a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private Map<String, Object> f٤٩٩٦b;

        RunnableC٠٠٦٣a(Map<String, Object> map) {
            this.f٤٩٩٦b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map<String, Object> map;
            try {
                Map<String, Object> map2 = this.f٤٩٩٦b;
                if (map2 == null) {
                    synchronized (a.class) {
                        map = a.this.f٤٩٩٤a;
                        a.this.f٤٩٩٤a = null;
                    }
                    map2 = map;
                }
                if (!NetworkStatusHelper.isConnected()) {
                    return;
                }
                if (GlobalAppRuntimeInfo.getEnv() != map2.get("Env")) {
                    ALog.w(a.TAG, "task's env changed", null, new Object[0]);
                } else {
                    b.a(d.a(map2));
                }
            } catch (Exception e10) {
                ALog.e(a.TAG, "exec amdc task failed.", null, e10, new Object[0]);
            }
        }

        RunnableC٠٠٦٣a() {
        }
    }

    public void a(Map<String, Object> map) {
        try {
            map.put("Env", GlobalAppRuntimeInfo.getEnv());
            synchronized (this) {
                try {
                    Map<String, Object> map2 = this.f٤٩٩٤a;
                    if (map2 == null) {
                        this.f٤٩٩٤a = map;
                        int nextInt = f٤٩٩٣b.nextInt(3000) + 2000;
                        ALog.i(TAG, "merge amdc request", null, "delay", Integer.valueOf(nextInt));
                        anet.channel.strategy.utils.a.a(new RunnableC٠٠٦٣a(), nextInt);
                    } else {
                        Set set = (Set) map2.get(DispatchConstants.HOSTS);
                        Set set2 = (Set) map.get(DispatchConstants.HOSTS);
                        if (map.get("Env") != this.f٤٩٩٤a.get("Env")) {
                            this.f٤٩٩٤a = map;
                        } else if (set.size() + set2.size() <= 40) {
                            set2.addAll(set);
                            this.f٤٩٩٤a = map;
                        } else {
                            anet.channel.strategy.utils.a.a(new RunnableC٠٠٦٣a(map));
                        }
                    }
                } finally {
                }
            }
        } catch (Exception unused) {
        }
    }
}
