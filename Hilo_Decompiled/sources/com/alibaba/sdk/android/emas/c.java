package com.alibaba.sdk.android.emas;

import com.alibaba.sdk.android.tbrest.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c implements Cache<g> {

    /* renamed from: a, reason: collision with root package name */
    private final int f٦٤٠١a;

    /* renamed from: a, reason: collision with other field name */
    private List<g> f٩a;

    /* renamed from: b, reason: collision with root package name */
    private final int f٦٤٠٢b;

    /* renamed from: c, reason: collision with root package name */
    private int f٦٤٠٣c = 0;
    private final j mSendManager;

    public c(j jVar, int i10, int i11) {
        this.f٦٤٠١a = i10;
        this.f٦٤٠٢b = i11;
        this.mSendManager = jVar;
    }

    private void b() {
        this.mSendManager.a(this.f٩a);
        this.f٩a = null;
        this.f٦٤٠٣c = 0;
    }

    @Override // com.alibaba.sdk.android.emas.Cache
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public g get() {
        return null;
    }

    @Override // com.alibaba.sdk.android.emas.Cache
    public void clear() {
    }

    public synchronized void flush() {
        List<g> list = this.f٩a;
        if (list != null && !list.isEmpty()) {
            LogUtil.d("CacheManager flush. immediately send.");
            b();
        }
    }

    @Override // com.alibaba.sdk.android.emas.Cache
    /* renamed from: a, reason: collision with other method in class and merged with bridge method [inline-methods] */
    public boolean remove(g gVar) {
        return false;
    }

    @Override // com.alibaba.sdk.android.emas.Cache
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public synchronized void add(g gVar) {
        try {
            if (this.f٩a == null) {
                this.f٩a = new ArrayList();
            }
            this.f٩a.add(gVar);
            this.f٦٤٠٣c += gVar.length();
            if (this.f٩a.size() >= this.f٦٤٠١a || this.f٦٤٠٣c >= this.f٦٤٠٢b) {
                LogUtil.d("CacheManager satisfy limit. immediately send. size: " + this.f٩a.size() + ", current capacity: " + this.f٦٤٠٣c);
                b();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
