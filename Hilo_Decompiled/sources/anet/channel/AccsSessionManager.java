package anet.channel;

import android.content.Intent;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.strategy.IStrategyInstance;
import anet.channel.strategy.StrategyCenter;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.StringUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AccsSessionManager {

    /* renamed from: c, reason: collision with root package name */
    private static CopyOnWriteArraySet<ISessionListener> f٤٥٦٠c = new CopyOnWriteArraySet<>();

    /* renamed from: a, reason: collision with root package name */
    SessionCenter f٤٥٦١a;

    /* renamed from: b, reason: collision with root package name */
    Set<String> f٤٥٦٢b = Collections.EMPTY_SET;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccsSessionManager(SessionCenter sessionCenter) {
        this.f٤٥٦١a = null;
        this.f٤٥٦١a = sessionCenter;
    }

    private boolean b() {
        if ((GlobalAppRuntimeInfo.isAppBackground() && AwcnConfig.isAccsSessionCreateForbiddenInBg()) || !NetworkStatusHelper.isConnected()) {
            return false;
        }
        return true;
    }

    public synchronized void checkAndStartSession() {
        String str;
        try {
            Collection<SessionInfo> a10 = this.f٤٥٦١a.f٤٦٤٤g.a();
            Set<String> set = Collections.EMPTY_SET;
            if (!a10.isEmpty()) {
                set = new TreeSet<>();
            }
            for (SessionInfo sessionInfo : a10) {
                if (sessionInfo.isKeepAlive) {
                    IStrategyInstance strategyCenter = StrategyCenter.getInstance();
                    String str2 = sessionInfo.host;
                    if (sessionInfo.isAccs) {
                        str = HttpConstant.HTTPS;
                    } else {
                        str = HttpConstant.HTTP;
                    }
                    set.add(StringUtils.concatString(strategyCenter.getSchemeByHost(str2, str), HttpConstant.SCHEME_SPLIT, sessionInfo.host));
                }
            }
            for (String str3 : this.f٤٥٦٢b) {
                if (!set.contains(str3)) {
                    a(str3);
                }
            }
            if (!b()) {
                return;
            }
            for (String str4 : set) {
                try {
                    this.f٤٥٦١a.get(str4, ConnType.TypeLevel.SPDY, 0L);
                } catch (Exception unused) {
                    ALog.e("start session failed", null, "host", str4);
                }
            }
            this.f٤٥٦٢b = set;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void forceCloseSession(boolean z10) {
        try {
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.AccsSessionManager", "forceCloseSession", this.f٤٥٦١a.f٤٦٤٠c, "reCreate", Boolean.valueOf(z10));
            }
            Iterator<String> it = this.f٤٥٦٢b.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            if (z10) {
                checkAndStartSession();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void notifyListener(Intent intent) {
        ThreadPoolExecutorFactory.submitScheduledTask(new a(this, intent));
    }

    public void registerListener(ISessionListener iSessionListener) {
        if (iSessionListener != null) {
            f٤٥٦٠c.add(iSessionListener);
        }
    }

    public void unregisterListener(ISessionListener iSessionListener) {
        f٤٥٦٠c.remove(iSessionListener);
    }

    private void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ALog.d("awcn.AccsSessionManager", "closeSessions", this.f٤٥٦١a.f٤٦٤٠c, "host", str);
        this.f٤٥٦١a.a(str).b(false);
    }
}
