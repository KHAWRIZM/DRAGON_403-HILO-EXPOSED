package anet.channel.b;

import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import anetwork.channel.cache.Cache;
import com.taobao.alivfssdk.cache.AVFSCache;
import com.taobao.alivfssdk.cache.AVFSCacheConfig;
import com.taobao.alivfssdk.cache.AVFSCacheManager;
import com.taobao.alivfssdk.cache.IAVFSCache;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a implements Cache {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f٤٦٨٥a = true;

    /* renamed from: b, reason: collision with root package name */
    private static Object f٤٦٨٦b;

    /* renamed from: c, reason: collision with root package name */
    private static Object f٤٦٨٧c;

    /* renamed from: d, reason: collision with root package name */
    private static Object f٤٦٨٨d;

    static {
        try {
            Class.forName("com.taobao.alivfssdk.cache.AVFSCacheManager");
            f٤٦٨٦b = new b();
            f٤٦٨٧c = new c();
            f٤٦٨٨d = new d();
        } catch (ClassNotFoundException unused) {
            f٤٦٨٥a = false;
            ALog.w("anet.AVFSCacheImpl", "no alivfs sdk!", null, new Object[0]);
        }
    }

    private IAVFSCache b() {
        AVFSCache cacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache");
        if (cacheForModule != null) {
            return cacheForModule.getFileCache();
        }
        return null;
    }

    public void a() {
        AVFSCache cacheForModule;
        if (f٤٦٨٥a && (cacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache")) != null) {
            AVFSCacheConfig aVFSCacheConfig = new AVFSCacheConfig();
            aVFSCacheConfig.limitSize = 5242880L;
            aVFSCacheConfig.fileMemMaxSize = 1048576L;
            cacheForModule.moduleConfig(aVFSCacheConfig);
        }
    }

    @Override // anetwork.channel.cache.Cache
    public void clear() {
        if (!f٤٦٨٥a) {
            return;
        }
        try {
            IAVFSCache b10 = b();
            if (b10 != null) {
                b10.removeAllObject((IAVFSCache.OnAllObjectRemoveCallback) f٤٦٨٨d);
            }
        } catch (Exception e10) {
            ALog.e("anet.AVFSCacheImpl", "clear cache failed", null, e10, new Object[0]);
        }
    }

    @Override // anetwork.channel.cache.Cache
    public Cache.Entry get(String str) {
        if (!f٤٦٨٥a) {
            return null;
        }
        try {
            IAVFSCache b10 = b();
            if (b10 != null) {
                return (Cache.Entry) b10.objectForKey(StringUtils.md5ToHex(str));
            }
        } catch (Exception e10) {
            ALog.e("anet.AVFSCacheImpl", "get cache failed", null, e10, new Object[0]);
        }
        return null;
    }

    @Override // anetwork.channel.cache.Cache
    public void put(String str, Cache.Entry entry) {
        if (!f٤٦٨٥a) {
            return;
        }
        try {
            IAVFSCache b10 = b();
            if (b10 != null) {
                b10.setObjectForKey(StringUtils.md5ToHex(str), entry, (IAVFSCache.OnObjectSetCallback) f٤٦٨٦b);
            }
        } catch (Exception e10) {
            ALog.e("anet.AVFSCacheImpl", "put cache failed", null, e10, new Object[0]);
        }
    }

    @Override // anetwork.channel.cache.Cache
    public void remove(String str) {
        if (!f٤٦٨٥a) {
            return;
        }
        try {
            IAVFSCache b10 = b();
            if (b10 != null) {
                b10.removeObjectForKey(StringUtils.md5ToHex(str), (IAVFSCache.OnObjectRemoveCallback) f٤٦٨٧c);
            }
        } catch (Exception e10) {
            ALog.e("anet.AVFSCacheImpl", "remove cache failed", null, e10, new Object[0]);
        }
    }
}
