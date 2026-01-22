package androidx.databinding;

import androidx.lifecycle.LifecycleOwner;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class s extends WeakReference {

    /* renamed from: a, reason: collision with root package name */
    private final m f٣٢٢٦a;

    /* renamed from: b, reason: collision with root package name */
    protected final int f٣٢٢٧b;

    /* renamed from: c, reason: collision with root package name */
    private Object f٣٢٢٨c;

    public s(ViewDataBinding viewDataBinding, int i10, m mVar, ReferenceQueue referenceQueue) {
        super(viewDataBinding, referenceQueue);
        this.f٣٢٢٧b = i10;
        this.f٣٢٢٦a = mVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public ViewDataBinding a() {
        ViewDataBinding viewDataBinding = (ViewDataBinding) get();
        if (viewDataBinding == null) {
            e();
        }
        return viewDataBinding;
    }

    public Object b() {
        return this.f٣٢٢٨c;
    }

    public void c(LifecycleOwner lifecycleOwner) {
        this.f٣٢٢٦a.setLifecycleOwner(lifecycleOwner);
    }

    public void d(Object obj) {
        e();
        this.f٣٢٢٨c = obj;
        if (obj != null) {
            this.f٣٢٢٦a.addListener(obj);
        }
    }

    public boolean e() {
        boolean z10;
        Object obj = this.f٣٢٢٨c;
        if (obj != null) {
            this.f٣٢٢٦a.removeListener(obj);
            z10 = true;
        } else {
            z10 = false;
        }
        this.f٣٢٢٨c = null;
        return z10;
    }
}
