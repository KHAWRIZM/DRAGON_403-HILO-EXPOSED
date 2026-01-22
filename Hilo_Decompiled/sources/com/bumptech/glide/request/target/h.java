package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class h extends c {

    /* renamed from: b, reason: collision with root package name */
    private static final Handler f٧٥٤٠b = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.j f٧٥٤١a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((h) message.obj).a();
                return true;
            }
            return false;
        }
    }

    private h(com.bumptech.glide.j jVar, int i10, int i11) {
        super(i10, i11);
        this.f٧٥٤١a = jVar;
    }

    public static h b(com.bumptech.glide.j jVar, int i10, int i11) {
        return new h(jVar, i10, i11);
    }

    void a() {
        this.f٧٥٤١a.f(this);
    }

    @Override // com.bumptech.glide.request.target.j
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.j
    public void onResourceReady(Object obj, d5.b bVar) {
        c5.d request = getRequest();
        if (request != null && request.g()) {
            f٧٥٤٠b.obtainMessage(1, this).sendToTarget();
        }
    }
}
