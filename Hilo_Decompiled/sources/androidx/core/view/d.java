package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Objects;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final f f٢٩٠١a;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final c f٢٩٠٢a;

        public a(ClipData clipData, int i10) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f٢٩٠٢a = new b(clipData, i10);
            } else {
                this.f٢٩٠٢a = new C٠٠٢٨d(clipData, i10);
            }
        }

        public d a() {
            return this.f٢٩٠٢a.build();
        }

        public a b(Bundle bundle) {
            this.f٢٩٠٢a.setExtras(bundle);
            return this;
        }

        public a c(int i10) {
            this.f٢٩٠٢a.setFlags(i10);
            return this;
        }

        public a d(Uri uri) {
            this.f٢٩٠٢a.a(uri);
            return this;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final ContentInfo.Builder f٢٩٠٣a;

        b(ClipData clipData, int i10) {
            this.f٢٩٠٣a = i.a(clipData, i10);
        }

        @Override // androidx.core.view.d.c
        public void a(Uri uri) {
            this.f٢٩٠٣a.setLinkUri(uri);
        }

        @Override // androidx.core.view.d.c
        public d build() {
            ContentInfo build;
            build = this.f٢٩٠٣a.build();
            return new d(new e(build));
        }

        @Override // androidx.core.view.d.c
        public void setExtras(Bundle bundle) {
            this.f٢٩٠٣a.setExtras(bundle);
        }

        @Override // androidx.core.view.d.c
        public void setFlags(int i10) {
            this.f٢٩٠٣a.setFlags(i10);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private interface c {
        void a(Uri uri);

        d build();

        void setExtras(Bundle bundle);

        void setFlags(int i10);
    }

    /* renamed from: androidx.core.view.d$d, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class C٠٠٢٨d implements c {

        /* renamed from: a, reason: collision with root package name */
        ClipData f٢٩٠٤a;

        /* renamed from: b, reason: collision with root package name */
        int f٢٩٠٥b;

        /* renamed from: c, reason: collision with root package name */
        int f٢٩٠٦c;

        /* renamed from: d, reason: collision with root package name */
        Uri f٢٩٠٧d;

        /* renamed from: e, reason: collision with root package name */
        Bundle f٢٩٠٨e;

        C٠٠٢٨d(ClipData clipData, int i10) {
            this.f٢٩٠٤a = clipData;
            this.f٢٩٠٥b = i10;
        }

        @Override // androidx.core.view.d.c
        public void a(Uri uri) {
            this.f٢٩٠٧d = uri;
        }

        @Override // androidx.core.view.d.c
        public d build() {
            return new d(new g(this));
        }

        @Override // androidx.core.view.d.c
        public void setExtras(Bundle bundle) {
            this.f٢٩٠٨e = bundle;
        }

        @Override // androidx.core.view.d.c
        public void setFlags(int i10) {
            this.f٢٩٠٦c = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class e implements f {

        /* renamed from: a, reason: collision with root package name */
        private final ContentInfo f٢٩٠٩a;

        e(ContentInfo contentInfo) {
            this.f٢٩٠٩a = androidx.core.view.c.a(androidx.core.util.h.g(contentInfo));
        }

        @Override // androidx.core.view.d.f
        public ContentInfo a() {
            return this.f٢٩٠٩a;
        }

        @Override // androidx.core.view.d.f
        public ClipData b() {
            ClipData clip;
            clip = this.f٢٩٠٩a.getClip();
            return clip;
        }

        @Override // androidx.core.view.d.f
        public int getFlags() {
            int flags;
            flags = this.f٢٩٠٩a.getFlags();
            return flags;
        }

        @Override // androidx.core.view.d.f
        public int getSource() {
            int source;
            source = this.f٢٩٠٩a.getSource();
            return source;
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f٢٩٠٩a + "}";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public interface f {
        ContentInfo a();

        ClipData b();

        int getFlags();

        int getSource();
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static final class g implements f {

        /* renamed from: a, reason: collision with root package name */
        private final ClipData f٢٩١٠a;

        /* renamed from: b, reason: collision with root package name */
        private final int f٢٩١١b;

        /* renamed from: c, reason: collision with root package name */
        private final int f٢٩١٢c;

        /* renamed from: d, reason: collision with root package name */
        private final Uri f٢٩١٣d;

        /* renamed from: e, reason: collision with root package name */
        private final Bundle f٢٩١٤e;

        g(C٠٠٢٨d r52) {
            this.f٢٩١٠a = (ClipData) androidx.core.util.h.g(r52.f٢٩٠٤a);
            this.f٢٩١١b = androidx.core.util.h.c(r52.f٢٩٠٥b, 0, 5, "source");
            this.f٢٩١٢c = androidx.core.util.h.f(r52.f٢٩٠٦c, 1);
            this.f٢٩١٣d = r52.f٢٩٠٧d;
            this.f٢٩١٤e = r52.f٢٩٠٨e;
        }

        @Override // androidx.core.view.d.f
        public ContentInfo a() {
            return null;
        }

        @Override // androidx.core.view.d.f
        public ClipData b() {
            return this.f٢٩١٠a;
        }

        @Override // androidx.core.view.d.f
        public int getFlags() {
            return this.f٢٩١٢c;
        }

        @Override // androidx.core.view.d.f
        public int getSource() {
            return this.f٢٩١١b;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append("ContentInfoCompat{clip=");
            sb.append(this.f٢٩١٠a.getDescription());
            sb.append(", source=");
            sb.append(d.e(this.f٢٩١١b));
            sb.append(", flags=");
            sb.append(d.a(this.f٢٩١٢c));
            String str2 = "";
            if (this.f٢٩١٣d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.f٢٩١٣d.toString().length() + ")";
            }
            sb.append(str);
            if (this.f٢٩١٤e != null) {
                str2 = ", hasExtras";
            }
            sb.append(str2);
            sb.append("}");
            return sb.toString();
        }
    }

    d(f fVar) {
        this.f٢٩٠١a = fVar;
    }

    static String a(int i10) {
        if ((i10 & 1) != 0) {
            return "FLAG_CONVERT_TO_PLAIN_TEXT";
        }
        return String.valueOf(i10);
    }

    static String e(int i10) {
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 != 5) {
                                return String.valueOf(i10);
                            }
                            return "SOURCE_PROCESS_TEXT";
                        }
                        return "SOURCE_AUTOFILL";
                    }
                    return "SOURCE_DRAG_AND_DROP";
                }
                return "SOURCE_INPUT_METHOD";
            }
            return "SOURCE_CLIPBOARD";
        }
        return "SOURCE_APP";
    }

    public static d g(ContentInfo contentInfo) {
        return new d(new e(contentInfo));
    }

    public ClipData b() {
        return this.f٢٩٠١a.b();
    }

    public int c() {
        return this.f٢٩٠١a.getFlags();
    }

    public int d() {
        return this.f٢٩٠١a.getSource();
    }

    public ContentInfo f() {
        ContentInfo a10 = this.f٢٩٠١a.a();
        Objects.requireNonNull(a10);
        return androidx.core.view.c.a(a10);
    }

    public String toString() {
        return this.f٢٩٠١a.toString();
    }
}
