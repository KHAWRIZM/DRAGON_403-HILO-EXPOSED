package anetwork.channel.unified;

import android.os.Looper;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.request.Request;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.statist.RequestStatistic;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.cache.Cache;
import anetwork.channel.cache.CacheManager;
import anetwork.channel.config.NetworkConfigCenter;
import anetwork.channel.interceptor.Callback;
import anetwork.channel.interceptor.Interceptor;
import anetwork.channel.interceptor.InterceptorManager;
import anetwork.channel.util.RequestConstant;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    protected j f٥٢٨٧a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements Interceptor.Chain {

        /* renamed from: b, reason: collision with root package name */
        private int f٥٢٨٩b;

        /* renamed from: c, reason: collision with root package name */
        private Request f٥٢٩٠c;

        /* renamed from: d, reason: collision with root package name */
        private Callback f٥٢٩١d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i10, Request request, Callback callback) {
            this.f٥٢٨٩b = i10;
            this.f٥٢٩٠c = request;
            this.f٥٢٩١d = callback;
        }

        @Override // anetwork.channel.interceptor.Interceptor.Chain
        public Callback callback() {
            return this.f٥٢٩١d;
        }

        @Override // anetwork.channel.interceptor.Interceptor.Chain
        public Future proceed(Request request, Callback callback) {
            Cache cache;
            IUnifiedTask eVar;
            if (k.this.f٥٢٨٧a.f٥٢٨٤d.get()) {
                ALog.i("anet.UnifiedRequestTask", "request canneled or timeout in processing interceptor", request.getSeq(), new Object[0]);
                return null;
            }
            if (this.f٥٢٨٩b < InterceptorManager.getSize()) {
                return InterceptorManager.getInterceptor(this.f٥٢٨٩b).intercept(new a(this.f٥٢٨٩b + 1, request, callback));
            }
            k.this.f٥٢٨٧a.f٥٢٨١a.a(request);
            k.this.f٥٢٨٧a.f٥٢٨٢b = callback;
            if (NetworkConfigCenter.isHttpCacheEnable()) {
                cache = CacheManager.getCache(k.this.f٥٢٨٧a.f٥٢٨١a.g(), k.this.f٥٢٨٧a.f٥٢٨١a.h());
            } else {
                cache = null;
            }
            j jVar = k.this.f٥٢٨٧a;
            if (cache != null) {
                eVar = new anetwork.channel.unified.a(jVar, cache);
            } else {
                eVar = new e(jVar, null, null);
            }
            jVar.f٥٢٨٥e = eVar;
            k.this.f٥٢٨٧a.f٥٢٨٥e.run();
            k.this.c();
            return null;
        }

        @Override // anetwork.channel.interceptor.Interceptor.Chain
        public Request request() {
            return this.f٥٢٩٠c;
        }
    }

    public k(anetwork.channel.entity.g gVar, anetwork.channel.entity.c cVar) {
        cVar.a(gVar.f٥٢٢٨e);
        this.f٥٢٨٧a = new j(gVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        this.f٥٢٨٧a.f٥٢٨٦f = ThreadPoolExecutorFactory.submitScheduledTask(new n(this), this.f٥٢٨٧a.f٥٢٨١a.b(), TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f٥٢٨٧a.f٥٢٨٤d.compareAndSet(false, true)) {
            ALog.e("anet.UnifiedRequestTask", "task cancelled", this.f٥٢٨٧a.f٥٢٨٣c, "URL", this.f٥٢٨٧a.f٥٢٨١a.f().simpleUrlString());
            RequestStatistic requestStatistic = this.f٥٢٨٧a.f٥٢٨١a.f٥٢٢٥b;
            if (requestStatistic.isDone.compareAndSet(false, true)) {
                requestStatistic.ret = 2;
                requestStatistic.statusCode = ErrorConstant.ERROR_REQUEST_CANCEL;
                requestStatistic.msg = ErrorConstant.getErrMsg(ErrorConstant.ERROR_REQUEST_CANCEL);
                requestStatistic.rspEnd = System.currentTimeMillis();
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_REQUEST_CANCEL, null, requestStatistic, null));
                if (requestStatistic.recDataSize > 102400) {
                    anet.channel.monitor.b.a().a(requestStatistic.sendStart, requestStatistic.rspEnd, requestStatistic.recDataSize);
                }
            }
            this.f٥٢٨٧a.b();
            this.f٥٢٨٧a.a();
            this.f٥٢٨٧a.f٥٢٨٢b.onFinish(new DefaultFinishEvent(ErrorConstant.ERROR_REQUEST_CANCEL, (String) null, this.f٥٢٨٧a.f٥٢٨١a.a()));
        }
    }

    public Future a() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f٥٢٨٧a.f٥٢٨١a.f٥٢٢٥b.reqServiceTransmissionEnd = currentTimeMillis;
        this.f٥٢٨٧a.f٥٢٨١a.f٥٢٢٥b.start = currentTimeMillis;
        anetwork.channel.entity.g gVar = this.f٥٢٨٧a.f٥٢٨١a;
        gVar.f٥٢٢٥b.isReqSync = gVar.c();
        this.f٥٢٨٧a.f٥٢٨١a.f٥٢٢٥b.isReqMain = Looper.myLooper() == Looper.getMainLooper();
        try {
            anetwork.channel.entity.g gVar2 = this.f٥٢٨٧a.f٥٢٨١a;
            gVar2.f٥٢٢٥b.netReqStart = Long.valueOf(gVar2.a(RequestConstant.KEY_REQ_START)).longValue();
        } catch (Exception unused) {
        }
        String a10 = this.f٥٢٨٧a.f٥٢٨١a.a(RequestConstant.KEY_TRACE_ID);
        if (!TextUtils.isEmpty(a10)) {
            this.f٥٢٨٧a.f٥٢٨١a.f٥٢٢٥b.traceId = a10;
        }
        String a11 = this.f٥٢٨٧a.f٥٢٨١a.a(RequestConstant.KEY_REQ_PROCESS);
        anetwork.channel.entity.g gVar3 = this.f٥٢٨٧a.f٥٢٨١a;
        RequestStatistic requestStatistic = gVar3.f٥٢٢٥b;
        requestStatistic.process = a11;
        requestStatistic.pTraceId = gVar3.a(RequestConstant.KEY_PARENT_TRACE_ID);
        j jVar = this.f٥٢٨٧a;
        ALog.e("anet.UnifiedRequestTask", "[traceId:" + a10 + "]start", jVar.f٥٢٨٣c, "bizId", jVar.f٥٢٨١a.a().getBizId(), "processFrom", a11, "url", this.f٥٢٨٧a.f٥٢٨١a.g());
        if (NetworkConfigCenter.isUrlInDegradeList(this.f٥٢٨٧a.f٥٢٨١a.f())) {
            b bVar = new b(this.f٥٢٨٧a);
            this.f٥٢٨٧a.f٥٢٨٥e = bVar;
            bVar.f٥٢٣٩a = new anet.channel.request.b(ThreadPoolExecutorFactory.submitBackupTask(new l(this)), this.f٥٢٨٧a.f٥٢٨١a.a().getSeq());
            c();
            return new d(this);
        }
        ThreadPoolExecutorFactory.submitPriorityTask(new m(this), ThreadPoolExecutorFactory.Priority.HIGH);
        return new d(this);
    }
}
