package com.airbnb.lottie;

import androidx.collection.ArraySet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class r0 {

    /* renamed from: a, reason: collision with root package name */
    private boolean f٦٢٨٨a = false;

    /* renamed from: b, reason: collision with root package name */
    private final Set f٦٢٨٩b = new ArraySet();

    /* renamed from: c, reason: collision with root package name */
    private final Map f٦٢٩٠c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private final Comparator f٦٢٩١d = new a();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements Comparator {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(androidx.core.util.g gVar, androidx.core.util.g gVar2) {
            float floatValue = ((Float) gVar.f٢٨٨٩b).floatValue();
            float floatValue2 = ((Float) gVar2.f٢٨٨٩b).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            if (floatValue > floatValue2) {
                return -1;
            }
            return 0;
        }
    }

    public void a(String str, float f10) {
        if (!this.f٦٢٨٨a) {
            return;
        }
        x3.j jVar = (x3.j) this.f٦٢٩٠c.get(str);
        if (jVar == null) {
            jVar = new x3.j();
            this.f٦٢٩٠c.put(str, jVar);
        }
        jVar.a(f10);
        if (str.equals("__container")) {
            Iterator it = this.f٦٢٨٩b.iterator();
            if (it.hasNext()) {
                androidx.appcompat.app.a0.a(it.next());
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z10) {
        this.f٦٢٨٨a = z10;
    }
}
