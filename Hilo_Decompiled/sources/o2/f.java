package o2;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final c f١٦٤٦٦a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private interface c {
        Object a();

        Uri b();

        Uri c();

        ClipDescription getDescription();

        void requestPermission();
    }

    public f(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f١٦٤٦٦a = new a(uri, clipDescription, uri2);
        } else {
            this.f١٦٤٦٦a = new b(uri, clipDescription, uri2);
        }
    }

    public static f f(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 25) {
            return null;
        }
        return new f(new a(obj));
    }

    public Uri a() {
        return this.f١٦٤٦٦a.b();
    }

    public ClipDescription b() {
        return this.f١٦٤٦٦a.getDescription();
    }

    public Uri c() {
        return this.f١٦٤٦٦a.c();
    }

    public void d() {
        this.f١٦٤٦٦a.requestPermission();
    }

    public Object e() {
        return this.f١٦٤٦٦a.a();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class a implements c {

        /* renamed from: a, reason: collision with root package name */
        final InputContentInfo f١٦٤٦٧a;

        a(Object obj) {
            this.f١٦٤٦٧a = (InputContentInfo) obj;
        }

        @Override // o2.f.c
        public Object a() {
            return this.f١٦٤٦٧a;
        }

        @Override // o2.f.c
        public Uri b() {
            return this.f١٦٤٦٧a.getContentUri();
        }

        @Override // o2.f.c
        public Uri c() {
            return this.f١٦٤٦٧a.getLinkUri();
        }

        @Override // o2.f.c
        public ClipDescription getDescription() {
            return this.f١٦٤٦٧a.getDescription();
        }

        @Override // o2.f.c
        public void requestPermission() {
            this.f١٦٤٦٧a.requestPermission();
        }

        a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f١٦٤٦٧a = new InputContentInfo(uri, clipDescription, uri2);
        }
    }

    private f(c cVar) {
        this.f١٦٤٦٦a = cVar;
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final Uri f١٦٤٦٨a;

        /* renamed from: b, reason: collision with root package name */
        private final ClipDescription f١٦٤٦٩b;

        /* renamed from: c, reason: collision with root package name */
        private final Uri f١٦٤٧٠c;

        b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.f١٦٤٦٨a = uri;
            this.f١٦٤٦٩b = clipDescription;
            this.f١٦٤٧٠c = uri2;
        }

        @Override // o2.f.c
        public Object a() {
            return null;
        }

        @Override // o2.f.c
        public Uri b() {
            return this.f١٦٤٦٨a;
        }

        @Override // o2.f.c
        public Uri c() {
            return this.f١٦٤٧٠c;
        }

        @Override // o2.f.c
        public ClipDescription getDescription() {
            return this.f١٦٤٦٩b;
        }

        @Override // o2.f.c
        public void requestPermission() {
        }
    }
}
