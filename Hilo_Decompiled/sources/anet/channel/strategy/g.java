package anet.channel.strategy;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.strategy.c;
import anet.channel.strategy.dispatch.AmdcRuntimeInfo;
import anet.channel.strategy.dispatch.DispatchEvent;
import anet.channel.strategy.dispatch.HttpDispatcher;
import anet.channel.strategy.l;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import anet.channel.util.StringUtils;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g implements IStrategyInstance, HttpDispatcher.IDispatchEventListener {

    /* renamed from: a, reason: collision with root package name */
    boolean f٥٠٠٤a = false;

    /* renamed from: b, reason: collision with root package name */
    StrategyInfoHolder f٥٠٠٥b = null;

    /* renamed from: c, reason: collision with root package name */
    long f٥٠٠٦c = 0;

    /* renamed from: d, reason: collision with root package name */
    CopyOnWriteArraySet<IStrategyListener> f٥٠٠٧d = new CopyOnWriteArraySet<>();

    /* renamed from: e, reason: collision with root package name */
    private IStrategyFilter f٥٠٠٨e = new h(this);

    @Override // anet.channel.strategy.IStrategyInstance
    public void forceRefreshStrategy(String str) {
        if (!a() && !TextUtils.isEmpty(str)) {
            ALog.i("awcn.StrategyCenter", "force refresh strategy", null, "host", str);
            this.f٥٠٠٥b.d().a(str, true);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getCNameByHost(String str) {
        if (!a() && !TextUtils.isEmpty(str)) {
            return this.f٥٠٠٥b.d().getCnameByHost(str);
        }
        return null;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getClientIp() {
        if (a()) {
            return "";
        }
        return this.f٥٠٠٥b.d().f٤٩٧٠b;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public List<IConnStrategy> getConnStrategyListByHost(String str) {
        return getConnStrategyListByHost(str, this.f٥٠٠٨e);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getFormalizeUrl(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        if (parse == null) {
            ALog.e("awcn.StrategyCenter", "url is invalid.", null, "URL", str);
            return null;
        }
        String urlString = parse.urlString();
        try {
            String schemeByHost = getSchemeByHost(parse.host(), parse.scheme());
            if (!schemeByHost.equalsIgnoreCase(parse.scheme())) {
                urlString = StringUtils.concatString(schemeByHost, CertificateUtil.DELIMITER, str.substring(str.indexOf("//")));
            }
            if (ALog.isPrintLog(1)) {
                ALog.d("awcn.StrategyCenter", "", null, "raw", StringUtils.simplifyString(str, 128), "ret", StringUtils.simplifyString(urlString, 128));
            }
        } catch (Exception e10) {
            ALog.e("awcn.StrategyCenter", "getFormalizeUrl failed", null, e10, "raw", str);
        }
        return urlString;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    @Deprecated
    public String getSchemeByHost(String str) {
        return getSchemeByHost(str, null);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getUnitByHost(String str) {
        if (a()) {
            return null;
        }
        return this.f٥٠٠٥b.f٤٩٥٩b.b(str);
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void initialize(Context context) {
        if (!this.f٥٠٠٤a && context != null) {
            try {
                ALog.i("awcn.StrategyCenter", "StrategyCenter initialize started.", null, new Object[0]);
                AmdcRuntimeInfo.setContext(context);
                m.a(context);
                HttpDispatcher.getInstance().addListener(this);
                this.f٥٠٠٥b = StrategyInfoHolder.a();
                this.f٥٠٠٤a = true;
                ALog.i("awcn.StrategyCenter", "StrategyCenter initialize finished.", null, new Object[0]);
            } catch (Exception e10) {
                ALog.e("awcn.StrategyCenter", "StrategyCenter initialize failed.", null, e10, new Object[0]);
            }
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void notifyConnEvent(String str, IConnStrategy iConnStrategy, ConnEvent connEvent) {
        if (!a() && iConnStrategy != null && (iConnStrategy instanceof IPConnStrategy)) {
            IPConnStrategy iPConnStrategy = (IPConnStrategy) iConnStrategy;
            if (iPConnStrategy.f٤٩٤٥b == 1) {
                this.f٥٠٠٥b.f٤٩٦٠c.a(str, iConnStrategy, connEvent);
            } else if (iPConnStrategy.f٤٩٤٥b == 0) {
                this.f٥٠٠٥b.d().a(str, iConnStrategy, connEvent);
            }
        }
    }

    @Override // anet.channel.strategy.dispatch.HttpDispatcher.IDispatchEventListener
    public void onEvent(DispatchEvent dispatchEvent) {
        if (dispatchEvent.eventType == 1 && this.f٥٠٠٥b != null) {
            ALog.d("awcn.StrategyCenter", "receive amdc event", null, new Object[0]);
            l.d a10 = l.a((JSONObject) dispatchEvent.extraObject);
            if (a10 == null) {
                return;
            }
            this.f٥٠٠٥b.a(a10);
            saveData();
            Iterator<IStrategyListener> it = this.f٥٠٠٧d.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onStrategyUpdated(a10);
                } catch (Exception e10) {
                    ALog.e("awcn.StrategyCenter", "onStrategyUpdated failed", null, e10, new Object[0]);
                }
            }
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void registerListener(IStrategyListener iStrategyListener) {
        ALog.e("awcn.StrategyCenter", "registerListener", null, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, this.f٥٠٠٧d);
        if (iStrategyListener != null) {
            this.f٥٠٠٧d.add(iStrategyListener);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void saveData() {
        ALog.i("awcn.StrategyCenter", "saveData", null, new Object[0]);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f٥٠٠٦c > 30000) {
            this.f٥٠٠٦c = currentTimeMillis;
            anet.channel.strategy.utils.a.a(new i(this), 500L);
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public synchronized void switchEnv() {
        m.a();
        HttpDispatcher.getInstance().switchENV();
        StrategyInfoHolder strategyInfoHolder = this.f٥٠٠٥b;
        if (strategyInfoHolder != null) {
            strategyInfoHolder.b();
            this.f٥٠٠٥b = StrategyInfoHolder.a();
        }
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public void unregisterListener(IStrategyListener iStrategyListener) {
        ALog.e("awcn.StrategyCenter", "unregisterListener", null, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, this.f٥٠٠٧d);
        this.f٥٠٠٧d.remove(iStrategyListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        if (this.f٥٠٠٥b != null) {
            return false;
        }
        ALog.w("StrategyCenter not initialized", null, "isInitialized", Boolean.valueOf(this.f٥٠٠٤a));
        return true;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public List<IConnStrategy> getConnStrategyListByHost(String str, IStrategyFilter iStrategyFilter) {
        if (!TextUtils.isEmpty(str) && !a()) {
            String cnameByHost = this.f٥٠٠٥b.d().getCnameByHost(str);
            if (!TextUtils.isEmpty(cnameByHost)) {
                str = cnameByHost;
            }
            List queryByHost = this.f٥٠٠٥b.d().queryByHost(str);
            if (queryByHost.isEmpty()) {
                queryByHost = this.f٥٠٠٥b.f٤٩٦٠c.a(str);
            }
            if (!queryByHost.isEmpty() && iStrategyFilter != null) {
                boolean z10 = !AwcnConfig.isIpv6Enable() || (AwcnConfig.isIpv6BlackListEnable() && this.f٥٠٠٥b.d().a(str, AwcnConfig.getIpv6BlackListTtl()));
                ListIterator<IConnStrategy> listIterator = queryByHost.listIterator();
                while (listIterator.hasNext()) {
                    IConnStrategy next = listIterator.next();
                    if (!iStrategyFilter.accept(next)) {
                        listIterator.remove();
                    } else if (z10 && anet.channel.strategy.utils.c.b(next.getIp())) {
                        listIterator.remove();
                    }
                }
                if (ALog.isPrintLog(1)) {
                    ALog.d("getConnStrategyListByHost", null, "host", str, "result", queryByHost);
                }
                return queryByHost;
            }
            ALog.d("getConnStrategyListByHost", null, "host", str, "result", queryByHost);
            return queryByHost;
        }
        return Collections.EMPTY_LIST;
    }

    @Override // anet.channel.strategy.IStrategyInstance
    public String getSchemeByHost(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (a()) {
            return str2;
        }
        String a10 = this.f٥٠٠٥b.f٤٩٥٩b.a(str);
        if (a10 != null || TextUtils.isEmpty(str2)) {
            str2 = a10;
        }
        if (str2 == null && (str2 = c.a.f٤٩٨٣a.a(str)) == null) {
            str2 = HttpConstant.HTTP;
        }
        ALog.d("awcn.StrategyCenter", "getSchemeByHost", null, "host", str, "scheme", str2);
        return str2;
    }
}
