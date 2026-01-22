package com.bumptech.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.load.data.d;
import java.io.IOException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b implements d {

    /* renamed from: a, reason: collision with root package name */
    private final String f٧٤٣٠a;

    /* renamed from: b, reason: collision with root package name */
    private final AssetManager f٧٤٣١b;

    /* renamed from: c, reason: collision with root package name */
    private Object f٧٤٣٢c;

    public b(AssetManager assetManager, String str) {
        this.f٧٤٣١b = assetManager;
        this.f٧٤٣٠a = str;
    }

    protected abstract void a(Object obj);

    protected abstract Object b(AssetManager assetManager, String str);

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.d
    public void cleanup() {
        Object obj = this.f٧٤٣٢c;
        if (obj == null) {
            return;
        }
        try {
            a(obj);
        } catch (IOException unused) {
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public m4.a getDataSource() {
        return m4.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public void loadData(com.bumptech.glide.f fVar, d.a aVar) {
        try {
            Object b10 = b(this.f٧٤٣١b, this.f٧٤٣٠a);
            this.f٧٤٣٢c = b10;
            aVar.onDataReady(b10);
        } catch (IOException e10) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e10);
            }
            aVar.onLoadFailed(e10);
        }
    }
}
