package androidx.media;

import android.text.TextUtils;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
class j implements f {

    /* renamed from: a, reason: collision with root package name */
    private String f٣٩٧٠a;

    /* renamed from: b, reason: collision with root package name */
    private int f٣٩٧١b;

    /* renamed from: c, reason: collision with root package name */
    private int f٣٩٧٢c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(String str, int i10, int i11) {
        this.f٣٩٧٠a = str;
        this.f٣٩٧١b = i10;
        this.f٣٩٧٢c = i11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (TextUtils.equals(this.f٣٩٧٠a, jVar.f٣٩٧٠a) && this.f٣٩٧١b == jVar.f٣٩٧١b && this.f٣٩٧٢c == jVar.f٣٩٧٢c) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return androidx.core.util.f.b(this.f٣٩٧٠a, Integer.valueOf(this.f٣٩٧١b), Integer.valueOf(this.f٣٩٧٢c));
    }
}
