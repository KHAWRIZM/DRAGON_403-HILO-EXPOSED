package com.alibaba.sdk.android.emas;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.alibaba.sdk.android.emas.i;
import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class EmasSender {
    private static final int BUILD_REQ_DATA_DONE = 1;
    private static final String TAG = "EmasSender";
    private static Handler sHandler;
    private boolean mBackground;
    private c mCacheManager;
    private e mDiskCacheManager;
    private final ExecutorService mPackDataExecutor;
    private final j mSendManager;
    private final int mSingleLogLimitCapacity;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class Builder {
        private String appId;
        private String appKey;
        private String appSecret;
        private String appVersion;
        private String channel;
        private Application context;
        private String host;
        private boolean openHttp;
        private PreSendHandler preSendHandler;
        private String userNick;
        private String businessKey = "common";
        private boolean cache = true;
        private int cacheLimitCount = 20;
        private int singleLogLimitCapacity = 204800;
        private int cacheLimitCapacity = 2097152;
        private boolean diskCache = true;
        private int diskCacheLimitCount = 50;
        private int diskCacheLimitCapacity = 104857600;
        private int diskCacheLimitDay = 5;
        private boolean sendDiskCacheBackground = false;
        private int maxSendDiskCacheQueueCount = 0;

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public Builder appKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder appSecret(String str) {
            this.appSecret = str;
            return this;
        }

        public Builder appVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public EmasSender build() {
            return new EmasSender(this);
        }

        public Builder businessKey(String str) {
            this.businessKey = str;
            return this;
        }

        public Builder cache(boolean z10) {
            this.cache = z10;
            return this;
        }

        public Builder cacheLimitCount(int i10) {
            this.cacheLimitCount = i10;
            return this;
        }

        public Builder channel(String str) {
            this.channel = str;
            return this;
        }

        public Builder context(Application application) {
            this.context = application;
            return this;
        }

        public Builder diskCache(boolean z10) {
            this.diskCache = z10;
            return this;
        }

        public Builder diskCacheLimitCount(int i10) {
            this.diskCacheLimitCount = i10;
            return this;
        }

        public Builder diskCacheLimitDay(int i10) {
            this.diskCacheLimitDay = i10;
            return this;
        }

        public Builder host(String str) {
            this.host = str;
            return this;
        }

        public Builder openHttp(boolean z10) {
            this.openHttp = z10;
            return this;
        }

        public Builder preSendHandler(PreSendHandler preSendHandler) {
            this.preSendHandler = preSendHandler;
            return this;
        }

        public Builder setMaxSendDiskCacheQueueCount(int i10) {
            this.maxSendDiskCacheQueueCount = i10;
            return this;
        }

        public Builder setSendDiskCacheBackground(boolean z10) {
            this.sendDiskCacheBackground = z10;
            return this;
        }

        public Builder userNick(String str) {
            this.userNick = str;
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<EmasSender> f٦٣٩١a;

        public a(Looper looper, EmasSender emasSender) {
            super(looper);
            this.f٦٣٩١a = new WeakReference<>(emasSender);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 1) {
                try {
                    g gVar = (g) message.obj;
                    if (gVar == null) {
                        LogUtil.d("EmasSender EmasHandler singleLog is null");
                        return;
                    }
                    EmasSender emasSender = this.f٦٣٩١a.get();
                    if (emasSender == null) {
                        LogUtil.d("EmasSender EmasHandler weakRef sender get null");
                        return;
                    } else if (emasSender.mCacheManager != null) {
                        emasSender.mCacheManager.add(gVar);
                        return;
                    } else {
                        emasSender.mSendManager.b(gVar);
                        return;
                    }
                } catch (Exception unused) {
                    LogUtil.e("EmasSender EmasHandler error:");
                    return;
                }
            }
            LogUtil.e("EmasSender unknown msg");
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class b implements Runnable {

        /* renamed from: a, reason: collision with other field name */
        private final Map<String, String> f٥a;

        /* renamed from: b, reason: collision with root package name */
        private final long f٦٣٩٣b;

        /* renamed from: d, reason: collision with root package name */
        private final int f٦٣٩٤d;

        /* renamed from: d, reason: collision with other field name */
        private final String f٦d;

        /* renamed from: e, reason: collision with root package name */
        private final String f٦٣٩٥e;

        /* renamed from: f, reason: collision with root package name */
        private final String f٦٣٩٦f;

        /* renamed from: g, reason: collision with root package name */
        private final String f٦٣٩٧g;

        public b(long j10, String str, int i10, String str2, String str3, String str4, Map<String, String> map) {
            this.f٦٣٩٣b = j10;
            this.f٦d = str;
            this.f٦٣٩٤d = i10;
            this.f٦٣٩٥e = str2;
            this.f٦٣٩٦f = str3;
            this.f٦٣٩٧g = str4;
            this.f٥a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a10 = com.alibaba.sdk.android.tbrest.rest.e.a(EmasSender.this.mSendManager.m٢٥٨a(), EmasSender.this.mSendManager.m٢٥٨a().getAppKey(), this.f٦٣٩٣b, this.f٦d, this.f٦٣٩٤d, this.f٦٣٩٥e, this.f٦٣٩٦f, this.f٦٣٩٧g, this.f٥a);
            if (!TextUtils.isEmpty(a10)) {
                int length = a10.getBytes(Charset.forName("UTF-8")).length;
                if (length <= EmasSender.this.mSingleLogLimitCapacity) {
                    EmasSender.sHandler.obtainMessage(1, new g(String.valueOf(this.f٦٣٩٤d), a10, this.f٦٣٩٣b)).sendToTarget();
                    return;
                } else {
                    LogUtil.d("EmasSender send failed. build data is exceed limit. current length: " + length);
                    return;
                }
            }
            LogUtil.d("EmasSender send failed. build data is null.");
        }
    }

    public void changeHost(String str) {
        this.mSendManager.setHost(str);
    }

    public void flush() {
        c cVar = this.mCacheManager;
        if (cVar != null) {
            cVar.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBackground() {
        return this.mBackground;
    }

    public void openHttp(boolean z10) {
        this.mSendManager.openHttp(z10);
    }

    public void send(long j10, String str, int i10, String str2, String str3, String str4, Map<String, String> map) {
        if (!TextUtils.isEmpty(this.mSendManager.m٢٥٨a().getAppKey()) && !TextUtils.isEmpty(this.mSendManager.m٢٥٨a().getChangeHost())) {
            this.mPackDataExecutor.submit(new b(j10, str, i10, str2, str3, str4, map));
        } else {
            LogUtil.d("EmasSender send failed. appkey or host is empty.");
        }
    }

    public void setUserNick(String str) {
        this.mSendManager.setUserNick(str);
    }

    private EmasSender(Builder builder) {
        this.mBackground = false;
        this.mPackDataExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.alibaba.sdk.android.emas.EmasSender.1
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "EmasSenderPackDataThread");
            }
        });
        this.mSingleLogLimitCapacity = builder.singleLogLimitCapacity;
        if (builder.diskCache) {
            e eVar = new e(builder.context, builder.host, builder.appKey, builder.businessKey);
            this.mDiskCacheManager = eVar;
            eVar.a(builder.diskCacheLimitCount, builder.diskCacheLimitCapacity, builder.diskCacheLimitDay);
        }
        j jVar = new j(this, this.mDiskCacheManager);
        this.mSendManager = jVar;
        jVar.init(builder.context, builder.appId, builder.appKey, builder.appVersion, builder.channel, builder.userNick);
        jVar.setHost(builder.host);
        jVar.a(builder.appSecret);
        jVar.openHttp(builder.openHttp);
        jVar.a(builder.sendDiskCacheBackground);
        jVar.a(builder.maxSendDiskCacheQueueCount);
        jVar.a(builder.preSendHandler);
        jVar.e();
        if (builder.cache && builder.cacheLimitCount > 1) {
            this.mCacheManager = new c(jVar, builder.cacheLimitCount, builder.cacheLimitCapacity);
            i iVar = new i();
            iVar.a(new i.a() { // from class: com.alibaba.sdk.android.emas.EmasSender.2
                @Override // com.alibaba.sdk.android.emas.i.a
                public void c() {
                    EmasSender.this.mBackground = false;
                }

                @Override // com.alibaba.sdk.android.emas.i.a
                public void d() {
                    EmasSender.this.mBackground = true;
                    EmasSender.this.mCacheManager.flush();
                }
            });
            builder.context.registerActivityLifecycleCallbacks(iVar);
        }
        sHandler = new a(Looper.getMainLooper(), this);
    }
}
