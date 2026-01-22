package anet.channel.session;

import android.content.Context;
import anet.channel.AwcnConfig;
import anet.channel.RequestCb;
import anet.channel.Session;
import anet.channel.entity.ConnType;
import anet.channel.request.Cancelable;
import anet.channel.request.Request;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.IConnStrategy;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anet.channel.util.HttpConstant;
import anet.channel.util.Utils;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class d extends Session {

    /* renamed from: w, reason: collision with root package name */
    private SSLSocketFactory f٤٩٠٧w;

    public d(Context context, anet.channel.entity.a aVar) {
        super(context, aVar);
        ConnType connType;
        if (this.f٤٦٢١k == null) {
            String str = this.f٤٦١٣c;
            if (str != null && str.startsWith(HttpConstant.HTTPS)) {
                connType = ConnType.HTTPS;
            } else {
                connType = ConnType.HTTP;
            }
            this.f٤٦٢٠j = connType;
            return;
        }
        if (AwcnConfig.isHttpsSniEnable() && this.f٤٦٢٠j.equals(ConnType.HTTPS)) {
            this.f٤٩٠٧w = new anet.channel.util.j(this.f٤٦١٤d);
        }
    }

    @Override // anet.channel.Session
    public void close() {
        notifyStatus(6, null);
    }

    @Override // anet.channel.Session
    public void connect() {
        try {
            IConnStrategy iConnStrategy = this.f٤٦٢١k;
            if (iConnStrategy != null && iConnStrategy.getIpSource() == 1) {
                notifyStatus(4, new anet.channel.entity.b(1));
                return;
            }
            Request.Builder redirectEnable = new Request.Builder().setUrl(this.f٤٦١٣c).setSeq(this.f٤٦٢٦p).setConnectTimeout((int) (this.f٤٦٢٨r * Utils.getNetworkTimeFactor())).setReadTimeout((int) (this.f٤٦٢٩s * Utils.getNetworkTimeFactor())).setRedirectEnable(false);
            SSLSocketFactory sSLSocketFactory = this.f٤٩٠٧w;
            if (sSLSocketFactory != null) {
                redirectEnable.setSslSocketFactory(sSLSocketFactory);
            }
            if (this.f٤٦٢٣m) {
                redirectEnable.addHeader("Host", this.f٤٦١٥e);
            }
            if (anet.channel.util.c.a() && anet.channel.strategy.utils.c.a(this.f٤٦١٥e)) {
                try {
                    this.f٤٦١٦f = anet.channel.util.c.a(this.f٤٦١٥e);
                } catch (Exception unused) {
                }
            }
            ALog.i("awcn.HttpSession", "HttpSession connect", null, "host", this.f٤٦١٣c, "ip", this.f٤٦١٦f, "port", Integer.valueOf(this.f٤٦١٧g));
            Request build = redirectEnable.build();
            build.setDnsOptimize(this.f٤٦١٦f, this.f٤٦١٧g);
            ThreadPoolExecutorFactory.submitPriorityTask(new e(this, build), ThreadPoolExecutorFactory.Priority.LOW);
        } catch (Throwable th) {
            ALog.e("awcn.HttpSession", "HTTP connect fail.", null, th, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // anet.channel.Session
    public Runnable getRecvTimeOutRunnable() {
        return null;
    }

    @Override // anet.channel.Session
    public boolean isAvailable() {
        if (this.f٤٦٢٤n == 4) {
            return true;
        }
        return false;
    }

    @Override // anet.channel.Session
    public Cancelable request(Request request, RequestCb requestCb) {
        RequestStatistic requestStatistic;
        anet.channel.request.b bVar = anet.channel.request.b.NULL;
        Request.Builder builder = null;
        if (request != null) {
            requestStatistic = request.f٤٨٤٤a;
        } else {
            requestStatistic = new RequestStatistic(this.f٤٦١٤d, null);
        }
        requestStatistic.setConnType(this.f٤٦٢٠j);
        if (requestStatistic.start == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            requestStatistic.reqStart = currentTimeMillis;
            requestStatistic.start = currentTimeMillis;
        }
        if (request != null && requestCb != null) {
            try {
                if (request.getSslSocketFactory() == null && this.f٤٩٠٧w != null) {
                    builder = request.newBuilder().setSslSocketFactory(this.f٤٩٠٧w);
                }
                if (this.f٤٦٢٣m) {
                    if (builder == null) {
                        builder = request.newBuilder();
                    }
                    builder.addHeader("Host", this.f٤٦١٥e);
                }
                if (builder != null) {
                    request = builder.build();
                }
                if (this.f٤٦١٦f == null) {
                    String host = request.getHttpUrl().host();
                    if (anet.channel.util.c.a() && anet.channel.strategy.utils.c.a(host)) {
                        try {
                            this.f٤٦١٦f = anet.channel.util.c.a(host);
                        } catch (Exception unused) {
                        }
                    }
                }
                request.setDnsOptimize(this.f٤٦١٦f, this.f٤٦١٧g);
                request.setUrlScheme(this.f٤٦٢٠j.isSSL());
                IConnStrategy iConnStrategy = this.f٤٦٢١k;
                if (iConnStrategy != null) {
                    request.f٤٨٤٤a.setIpInfo(iConnStrategy.getIpSource(), this.f٤٦٢١k.getIpType());
                } else {
                    request.f٤٨٤٤a.setIpInfo(1, 1);
                }
                request.f٤٨٤٤a.unit = this.f٤٦٢٢l;
                return new anet.channel.request.b(ThreadPoolExecutorFactory.submitPriorityTask(new f(this, request, requestCb, requestStatistic), anet.channel.util.h.a(request)), request.getSeq());
            } catch (Throwable th) {
                requestCb.onFinish(-101, ErrorConstant.formatMsg(-101, th.toString()), requestStatistic);
                return bVar;
            }
        }
        if (requestCb != null) {
            requestCb.onFinish(-102, ErrorConstant.getErrMsg(-102), requestStatistic);
        }
        return bVar;
    }

    @Override // anet.channel.Session
    public void close(boolean z10) {
        this.f٤٦٣٠t = false;
        close();
    }
}
