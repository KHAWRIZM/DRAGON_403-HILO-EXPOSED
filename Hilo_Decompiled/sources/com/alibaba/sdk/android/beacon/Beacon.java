package com.alibaba.sdk.android.beacon;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.KotlinVersion;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class Beacon {

    /* renamed from: a, reason: collision with root package name */
    private int f٦٣٣٨a;

    /* renamed from: a, reason: collision with other field name */
    private final HandlerThread f٠a;

    /* renamed from: a, reason: collision with other field name */
    private final c f١a;

    /* renamed from: a, reason: collision with other field name */
    private final List<OnUpdateListener> f٢a;

    /* renamed from: b, reason: collision with root package name */
    private final List<OnServiceErrListener> f٦٣٣٩b;
    private final boolean isStartPoll;
    private final String mAppKey;
    private final String mAppSecret;
    private final Map<String, String> mExtras;
    private Handler mHandler;
    private final long mLoopInterval;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public final class BeaconHandler extends Handler {
        static final int MSG_ADD_ERR_LISTENER = 6;
        static final int MSG_ADD_UPDATE_LISTENER = 4;
        static final int MSG_ERR_CALLBACK = 7;
        static final int MSG_REMOVE_UPDATE_LISTENER = 5;
        static final int MSG_START = 0;
        static final int MSG_START_POLLING = 2;
        static final int MSG_STOP_POLLING = 3;
        static final int MSG_UPDATE = 1;

        BeaconHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                switch (message.what) {
                    case 0:
                        Beacon.this.c((Context) message.obj);
                        break;
                    case 1:
                        Beacon.this.d((Context) message.obj);
                        break;
                    case 2:
                        Beacon.this.e((Context) message.obj);
                        break;
                    case 3:
                        Beacon.this.b();
                        break;
                    case 4:
                        Beacon.this.a((OnUpdateListener) message.obj);
                        break;
                    case 5:
                        Beacon.this.b((OnUpdateListener) message.obj);
                        break;
                    case 6:
                        Beacon.this.a((OnServiceErrListener) message.obj);
                        break;
                    case 7:
                        Beacon.this.b((Error) message.obj);
                        break;
                }
            } catch (Exception e10) {
                b.a("beacon", e10.getMessage(), e10);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class Builder {
        String mAppKey;
        String mAppSecret;
        Map<String, String> mExtras = new HashMap();
        long mLoopInterval = 300000;
        boolean isStartPoll = false;
        boolean isLogEnabled = true;

        public Builder appKey(String str) {
            this.mAppKey = str.trim();
            return this;
        }

        public Builder appSecret(String str) {
            this.mAppSecret = str.trim();
            return this;
        }

        public Beacon build() {
            return new Beacon(this);
        }

        public Builder extras(Map<String, String> map) {
            this.mExtras.putAll(map);
            return this;
        }

        public Builder logEnabled(boolean z10) {
            this.isLogEnabled = z10;
            return this;
        }

        public Builder loopInterval(long j10) {
            if (j10 < 60000) {
                this.mLoopInterval = 60000L;
            } else {
                this.mLoopInterval = j10;
            }
            return this;
        }

        public Builder startPoll(boolean z10) {
            this.isStartPoll = z10;
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class Config {
        public final String key;
        public final String value;

        public Config(String str, String str2) {
            this.key = str;
            this.value = str2;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class Error {
        public final String errCode;
        public final String errMsg;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Error(String str, String str2) {
            this.errCode = str;
            this.errMsg = str2;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface OnServiceErrListener {
        void onErr(Error error);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface OnUpdateListener {
        void onUpdate(List<Config> list);
    }

    private Beacon(Builder builder) {
        this.f٢a = new ArrayList();
        this.f٦٣٣٩b = new ArrayList();
        this.f٦٣٣٨a = KotlinVersion.MAX_COMPONENT_VALUE;
        this.mAppKey = builder.mAppKey;
        this.mAppSecret = builder.mAppSecret;
        this.mExtras = builder.mExtras;
        this.mLoopInterval = builder.mLoopInterval;
        this.isStartPoll = builder.isStartPoll;
        b.setLogEnabled(builder.isLogEnabled);
        this.f١a = new c(this);
        HandlerThread handlerThread = new HandlerThread("Beacon Daemon");
        this.f٠a = handlerThread;
        handlerThread.start();
        a();
    }

    private void a() {
        this.mHandler = new BeaconHandler(this.f٠a.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.mHandler.getLooper().quitSafely();
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Context context) {
        if (this.isStartPoll) {
            b(context);
            this.f٦٣٣٨a = 1;
        } else {
            this.f٦٣٣٨a = 1;
            a(context);
            stop();
            this.f٦٣٣٨a = KotlinVersion.MAX_COMPONENT_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        this.f١a.m٢٤٨a(context, this.mAppKey, this.mAppSecret, this.mExtras);
        List<Config> a10 = this.f١a.a();
        Iterator<OnUpdateListener> it = this.f٢a.iterator();
        while (it.hasNext()) {
            it.next().onUpdate(a10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context) {
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
        }
        a(context);
        this.mHandler.sendEmptyMessageDelayed(2, this.mLoopInterval);
    }

    private boolean isStarted() {
        return this.f٦٣٣٨a == 1;
    }

    public static void setPrepare(boolean z10) {
        a.f٦٣٤٠a = z10;
    }

    public void addServiceErrListener(OnServiceErrListener onServiceErrListener) {
        Message obtain = Message.obtain();
        obtain.what = 6;
        obtain.obj = onServiceErrListener;
        this.mHandler.sendMessage(obtain);
    }

    public void addUpdateListener(OnUpdateListener onUpdateListener) {
        Message obtain = Message.obtain();
        obtain.what = 4;
        obtain.obj = onUpdateListener;
        this.mHandler.sendMessage(obtain);
    }

    public List<Config> getConfigs() {
        return this.f١a.a();
    }

    public void setLogEnabled(boolean z10) {
        b.setLogEnabled(z10);
    }

    public void start(Context context) {
        if (isStarted()) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = 0;
        obtain.obj = context;
        this.mHandler.sendMessage(obtain);
    }

    public void stop() {
        if (isStarted()) {
            Message obtain = Message.obtain();
            obtain.what = 3;
            this.mHandler.sendMessage(obtain);
        }
    }

    private void a(Context context) {
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = context;
        this.mHandler.sendMessage(obtain);
    }

    private void b(Context context) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.obj = context;
        this.mHandler.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Error error) {
        Iterator<OnServiceErrListener> it = this.f٦٣٣٩b.iterator();
        while (it.hasNext()) {
            it.next().onErr(error);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Error error) {
        Message obtain = Message.obtain();
        obtain.what = 7;
        obtain.obj = error;
        this.mHandler.sendMessage(obtain);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(OnServiceErrListener onServiceErrListener) {
        this.f٦٣٣٩b.add(onServiceErrListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(OnUpdateListener onUpdateListener) {
        this.f٢a.remove(onUpdateListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(OnUpdateListener onUpdateListener) {
        this.f٢a.add(onUpdateListener);
    }
}
