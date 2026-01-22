package com.alibaba.sdk.android.push.f;

import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static final AmsLogger f٦٦٥٧c = AmsLogger.getLogger("MPS:SyncTool");

    /* renamed from: a, reason: collision with root package name */
    Lock f٦٦٥٨a;

    /* renamed from: b, reason: collision with root package name */
    Condition f٦٦٥٩b;

    public b() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f٦٦٥٨a = reentrantLock;
        this.f٦٦٥٩b = reentrantLock.newCondition();
    }

    public void a() {
        this.f٦٦٥٨a.lock();
        try {
            this.f٦٦٥٩b.signal();
        } finally {
            this.f٦٦٥٨a.unlock();
        }
    }

    public void a(int i10) {
        this.f٦٦٥٨a.lock();
        try {
            try {
                this.f٦٦٥٩b.await(i10, TimeUnit.SECONDS);
            } catch (InterruptedException e10) {
                f٦٦٥٧c.e("await error:", e10);
            }
        } finally {
            this.f٦٦٥٨a.unlock();
        }
    }
}
