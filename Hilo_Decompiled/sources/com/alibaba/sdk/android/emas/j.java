package com.alibaba.sdk.android.emas;

import android.content.Context;
import android.os.Looper;
import com.alibaba.sdk.android.tbrest.SendService;
import com.alibaba.sdk.android.tbrest.request.BizRequest;
import com.alibaba.sdk.android.tbrest.request.UrlWrapper;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadPoolExecutor f٦٤١٧a = new ThreadPoolExecutor(3, 3, 10, TimeUnit.SECONDS, new LinkedBlockingQueue(10), new a());

    /* renamed from: a, reason: collision with other field name */
    private PreSendHandler f١٥a;

    /* renamed from: b, reason: collision with root package name */
    private final EmasSender f٦٤١٨b;
    private final e mDiskCacheManager;

    /* renamed from: d, reason: collision with root package name */
    private boolean f٦٤١٩d = false;

    /* renamed from: f, reason: collision with root package name */
    private int f٦٤٢٠f = 0;
    private final SendService mSendService = new SendService();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a implements RejectedExecutionHandler {
        private a() {
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (runnable instanceof b) {
                ((b) runnable).f();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final f f٦٤٢٢a;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f٦٤٢٣d;

        /* renamed from: f, reason: collision with root package name */
        private final int f٦٤٢٤f;

        public b(f fVar, boolean z10, int i10) {
            this.f٦٤٢٢a = fVar;
            this.f٦٤٢٣d = z10;
            this.f٦٤٢٤f = i10;
        }

        private boolean a() {
            return (this.f٦٤٢٣d || !j.this.f٦٤١٨b.isBackground()) && j.f٦٤١٧a.getQueue().size() <= this.f٦٤٢٤f;
        }

        private boolean b() {
            return this.f٦٤٢٢a.a() == d.DISK_CACHE;
        }

        private void d(f fVar) {
            if (j.this.mDiskCacheManager == null) {
                return;
            }
            if (fVar.a() == d.DISK_CACHE) {
                j.this.mDiskCacheManager.remove(fVar);
            }
            if (a()) {
                LogUtil.d("SendManager trying send disk cache.");
                f fVar2 = j.this.mDiskCacheManager.get();
                if (fVar2 != null) {
                    LogUtil.d("SendManager sending disk cache.");
                    j.this.c(fVar2);
                    return;
                } else {
                    LogUtil.d("SendManager disk cache is empty.");
                    return;
                }
            }
            LogUtil.d("SendManager finish send. background: " + j.this.f٦٤١٨b.isBackground() + ", queue size: " + j.f٦٤١٧a.getQueue().size() + ", limit: " + this.f٦٤٢٤f);
        }

        public void f() {
            if (j.this.mDiskCacheManager != null) {
                if (!b()) {
                    LogUtil.d("SendManager send queue fill, write into disk cache.");
                    Runnable runnable = new Runnable() { // from class: com.alibaba.sdk.android.emas.j.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            j.this.mDiskCacheManager.add(b.this.m٢٥٩b());
                        }
                    };
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        new Thread(runnable).start();
                        return;
                    } else {
                        runnable.run();
                        return;
                    }
                }
                LogUtil.d("SendManager send queue fill, already in disk cache. do nothing.");
                return;
            }
            LogUtil.d("SendManager send queue fill, disk cache not open, discard.");
        }

        @Override // java.lang.Runnable
        public void run() {
            List<g> list;
            byte[] bArr;
            if (this.f٦٤٢٢a.a() == d.DISK_CACHE) {
                LogUtil.d("SendManager send disk log, location:" + this.f٦٤٢٢a.getLocation());
            }
            if (j.this.f١٥a != null) {
                list = j.this.f١٥a.onHandlePreSend(this.f٦٤٢٢a.m٢٥٣a(), this.f٦٤٢٢a.a());
            } else {
                list = this.f٦٤٢٢a.m٢٥٣a();
            }
            if (list != null && !list.isEmpty()) {
                try {
                    bArr = BizRequest.getPackRequest(j.this.mSendService.context, j.this.mSendService, a(list));
                } catch (Exception e10) {
                    LogUtil.w("SendManager pack request failed", e10);
                    if (j.this.mDiskCacheManager != null) {
                        j.this.mDiskCacheManager.b(this.f٦٤٢٢a);
                    }
                    bArr = null;
                }
                if (bArr != null) {
                    if (UrlWrapper.sendRequest(j.this.mSendService, j.this.mSendService.host, bArr).isSuccess()) {
                        d(this.f٦٤٢٢a);
                        return;
                    } else if (j.this.mDiskCacheManager != null) {
                        LogUtil.d("SendManager request failed. put into cache.");
                        j.this.mDiskCacheManager.add(this.f٦٤٢٢a);
                        return;
                    } else {
                        LogUtil.d("SendManager request failed. do nothing.");
                        return;
                    }
                }
                LogUtil.d("SendManager pack requst is null.");
                d(this.f٦٤٢٢a);
                return;
            }
            d(this.f٦٤٢٢a);
        }

        /* renamed from: b, reason: collision with other method in class */
        public f m٢٥٩b() {
            return this.f٦٤٢٢a;
        }

        private Map<String, String> a(List<g> list) {
            HashMap hashMap = new HashMap();
            for (g gVar : list) {
                StringBuilder sb = (StringBuilder) hashMap.get(gVar.f٦٤١٣i);
                if (sb == null) {
                    hashMap.put(gVar.f٦٤١٣i, new StringBuilder(gVar.f٦٤١٢h));
                } else {
                    sb.append((char) 1);
                    sb.append(gVar.f٦٤١٢h);
                }
            }
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry : hashMap.entrySet()) {
                hashMap2.put(entry.getKey(), ((StringBuilder) entry.getValue()).toString());
            }
            return hashMap2;
        }
    }

    public j(EmasSender emasSender, e eVar) {
        this.f٦٤١٨b = emasSender;
        this.mDiskCacheManager = eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(f fVar) {
        f٦٤١٧a.execute(new b(fVar, this.f٦٤١٩d, this.f٦٤٢٠f));
    }

    public void b(g gVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(gVar);
        a(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.mDiskCacheManager != null && f٦٤١٧a.getQueue().isEmpty()) {
            new Thread(new Runnable() { // from class: com.alibaba.sdk.android.emas.j.1
                @Override // java.lang.Runnable
                public void run() {
                    f fVar;
                    j.this.mDiskCacheManager.clear();
                    if (j.f٦٤١٧a.getQueue().size() <= j.this.f٦٤٢٠f && (fVar = j.this.mDiskCacheManager.get()) != null) {
                        j.this.c(fVar);
                    }
                }
            }).start();
        }
    }

    public void init(Context context, String str, String str2, String str3, String str4, String str5) {
        this.mSendService.init(context.getApplicationContext(), str, str2, str3, str4, str5);
    }

    public void openHttp(boolean z10) {
        this.mSendService.openHttp = Boolean.valueOf(z10);
    }

    public void setHost(String str) {
        this.mSendService.changeHost(str);
    }

    public void setUserNick(String str) {
        this.mSendService.userNick = str;
    }

    public void a(String str) {
        this.mSendService.appSecret = str;
    }

    public void a(PreSendHandler preSendHandler) {
        this.f١٥a = preSendHandler;
    }

    public void a(boolean z10) {
        this.f٦٤١٩d = z10;
    }

    public void a(int i10) {
        if (i10 >= 10) {
            this.f٦٤٢٠f = 9;
        } else {
            this.f٦٤٢٠f = i10;
        }
    }

    public void a(List<g> list) {
        c(new f(list));
    }

    /* renamed from: a, reason: collision with other method in class */
    public SendService m٢٥٨a() {
        return this.mSendService;
    }
}
