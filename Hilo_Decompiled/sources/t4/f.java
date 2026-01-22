package t4;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.io.InputStream;
import t4.n;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class f implements n {

    /* renamed from: a, reason: collision with root package name */
    private final Context f١٨٠٤١a;

    /* renamed from: b, reason: collision with root package name */
    private final e f١٨٠٤٢b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class a implements o, e {

        /* renamed from: a, reason: collision with root package name */
        private final Context f١٨٠٤٣a;

        a(Context context) {
            this.f١٨٠٤٣a = context;
        }

        @Override // t4.f.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void close(AssetFileDescriptor assetFileDescriptor) {
            assetFileDescriptor.close();
        }

        @Override // t4.o
        public n build(r rVar) {
            return new f(this.f١٨٠٤٣a, this);
        }

        @Override // t4.f.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public AssetFileDescriptor a(Resources.Theme theme, Resources resources, int i10) {
            return resources.openRawResourceFd(i10);
        }

        @Override // t4.f.e
        public Class getDataClass() {
            return AssetFileDescriptor.class;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class c implements o, e {

        /* renamed from: a, reason: collision with root package name */
        private final Context f١٨٠٤٥a;

        c(Context context) {
            this.f١٨٠٤٥a = context;
        }

        @Override // t4.f.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void close(InputStream inputStream) {
            inputStream.close();
        }

        @Override // t4.o
        public n build(r rVar) {
            return new f(this.f١٨٠٤٥a, this);
        }

        @Override // t4.f.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public InputStream a(Resources.Theme theme, Resources resources, int i10) {
            return resources.openRawResource(i10);
        }

        @Override // t4.f.e
        public Class getDataClass() {
            return InputStream.class;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface e {
        Object a(Resources.Theme theme, Resources resources, int i10);

        void close(Object obj);

        Class getDataClass();
    }

    f(Context context, e eVar) {
        this.f١٨٠٤١a = context.getApplicationContext();
        this.f١٨٠٤٢b = eVar;
    }

    public static o a(Context context) {
        return new a(context);
    }

    public static o c(Context context) {
        return new b(context);
    }

    public static o e(Context context) {
        return new c(context);
    }

    @Override // t4.n
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public n.a buildLoadData(Integer num, int i10, int i11, m4.i iVar) {
        Resources resources;
        Resources.Theme theme = (Resources.Theme) iVar.a(com.bumptech.glide.load.resource.drawable.k.f٧٤٦٤b);
        if (theme != null) {
            resources = theme.getResources();
        } else {
            resources = this.f١٨٠٤١a.getResources();
        }
        return new n.a(new e5.d(num), new d(theme, resources, this.f١٨٠٤٢b, num.intValue()));
    }

    @Override // t4.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean handles(Integer num) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class d implements com.bumptech.glide.load.data.d {

        /* renamed from: a, reason: collision with root package name */
        private final Resources.Theme f١٨٠٤٦a;

        /* renamed from: b, reason: collision with root package name */
        private final Resources f١٨٠٤٧b;

        /* renamed from: c, reason: collision with root package name */
        private final e f١٨٠٤٨c;

        /* renamed from: d, reason: collision with root package name */
        private final int f١٨٠٤٩d;

        /* renamed from: e, reason: collision with root package name */
        private Object f١٨٠٥٠e;

        d(Resources.Theme theme, Resources resources, e eVar, int i10) {
            this.f١٨٠٤٦a = theme;
            this.f١٨٠٤٧b = resources;
            this.f١٨٠٤٨c = eVar;
            this.f١٨٠٤٩d = i10;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
            Object obj = this.f١٨٠٥٠e;
            if (obj != null) {
                try {
                    this.f١٨٠٤٨c.close(obj);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public Class getDataClass() {
            return this.f١٨٠٤٨c.getDataClass();
        }

        @Override // com.bumptech.glide.load.data.d
        public m4.a getDataSource() {
            return m4.a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void loadData(com.bumptech.glide.f fVar, d.a aVar) {
            try {
                Object a10 = this.f١٨٠٤٨c.a(this.f١٨٠٤٦a, this.f١٨٠٤٧b, this.f١٨٠٤٩d);
                this.f١٨٠٥٠e = a10;
                aVar.onDataReady(a10);
            } catch (Resources.NotFoundException e10) {
                aVar.onLoadFailed(e10);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class b implements o, e {

        /* renamed from: a, reason: collision with root package name */
        private final Context f١٨٠٤٤a;

        b(Context context) {
            this.f١٨٠٤٤a = context;
        }

        @Override // t4.o
        public n build(r rVar) {
            return new f(this.f١٨٠٤٤a, this);
        }

        @Override // t4.f.e
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Drawable a(Resources.Theme theme, Resources resources, int i10) {
            return com.bumptech.glide.load.resource.drawable.h.a(this.f١٨٠٤٤a, i10, theme);
        }

        @Override // t4.f.e
        public Class getDataClass() {
            return Drawable.class;
        }

        @Override // t4.f.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void close(Drawable drawable) {
        }
    }
}
