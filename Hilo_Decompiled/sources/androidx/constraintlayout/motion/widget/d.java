package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class d {

    /* renamed from: f, reason: collision with root package name */
    public static int f١٩٥١f = -1;

    /* renamed from: a, reason: collision with root package name */
    int f١٩٥٢a;

    /* renamed from: b, reason: collision with root package name */
    int f١٩٥٣b;

    /* renamed from: c, reason: collision with root package name */
    String f١٩٥٤c;

    /* renamed from: d, reason: collision with root package name */
    protected int f١٩٥٥d;

    /* renamed from: e, reason: collision with root package name */
    HashMap f١٩٥٦e;

    public d() {
        int i10 = f١٩٥١f;
        this.f١٩٥٢a = i10;
        this.f١٩٥٣b = i10;
        this.f١٩٥٤c = null;
    }

    public abstract void a(HashMap hashMap);

    public abstract d b();

    public d c(d dVar) {
        this.f١٩٥٢a = dVar.f١٩٥٢a;
        this.f١٩٥٣b = dVar.f١٩٥٣b;
        this.f١٩٥٤c = dVar.f١٩٥٤c;
        this.f١٩٥٥d = dVar.f١٩٥٥d;
        this.f١٩٥٦e = dVar.f١٩٥٦e;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(HashSet hashSet);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e(Context context, AttributeSet attributeSet);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(String str) {
        String str2 = this.f١٩٥٤c;
        if (str2 != null && str != null) {
            return str.matches(str2);
        }
        return false;
    }

    public void g(int i10) {
        this.f١٩٥٢a = i10;
    }

    public void h(HashMap hashMap) {
    }

    public d i(int i10) {
        this.f١٩٥٣b = i10;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return Boolean.parseBoolean(obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float k(Object obj) {
        if (obj instanceof Float) {
            return ((Float) obj).floatValue();
        }
        return Float.parseFloat(obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int l(Object obj) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return Integer.parseInt(obj.toString());
    }
}
