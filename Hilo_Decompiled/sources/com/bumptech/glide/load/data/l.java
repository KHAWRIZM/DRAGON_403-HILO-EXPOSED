package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.data.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class l implements d {

    /* renamed from: a, reason: collision with root package name */
    private final Uri f٧٤٥٤a;

    /* renamed from: b, reason: collision with root package name */
    private final ContentResolver f٧٤٥٥b;

    /* renamed from: c, reason: collision with root package name */
    private Object f٧٤٥٦c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f٧٤٥٥b = contentResolver;
        this.f٧٤٥٤a = uri;
    }

    protected abstract void a(Object obj);

    protected abstract Object b(Uri uri, ContentResolver contentResolver);

    @Override // com.bumptech.glide.load.data.d
    public void cancel() {
    }

    @Override // com.bumptech.glide.load.data.d
    public void cleanup() {
        Object obj = this.f٧٤٥٦c;
        if (obj != null) {
            try {
                a(obj);
            } catch (IOException unused) {
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public m4.a getDataSource() {
        return m4.a.LOCAL;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void loadData(com.bumptech.glide.f fVar, d.a aVar) {
        try {
            Object b10 = b(this.f٧٤٥٤a, this.f٧٤٥٥b);
            this.f٧٤٥٦c = b10;
            aVar.onDataReady(b10);
        } catch (FileNotFoundException e10) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e10);
            }
            aVar.onLoadFailed(e10);
        }
    }
}
