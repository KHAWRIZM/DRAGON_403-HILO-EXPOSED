package ma;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class a extends LiveData {

    /* renamed from: a, reason: collision with root package name */
    private final AtomicInteger f١٥٩٩٦a = new AtomicInteger(-1);

    /* renamed from: b, reason: collision with root package name */
    protected boolean f١٥٩٩٧b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ma.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class C٠١٨٩a implements Observer {

        /* renamed from: a, reason: collision with root package name */
        private final Observer f١٥٩٩٨a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٥٩٩٩b;

        public C٠١٨٩a(Observer observer, int i10) {
            this.f١٥٩٩٨a = observer;
            this.f١٥٩٩٩b = i10;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                return Objects.equals(this.f١٥٩٩٨a, ((C٠١٨٩a) obj).f١٥٩٩٨a);
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(this.f١٥٩٩٨a);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(Object obj) {
            if (a.this.f١٥٩٩٦a.get() > this.f١٥٩٩٩b) {
                if (obj != null || a.this.f١٥٩٩٧b) {
                    this.f١٥٩٩٨a.onChanged(obj);
                }
            }
        }
    }

    private C٠١٨٩a c(Observer observer, int i10) {
        return new C٠١٨٩a(observer, i10);
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(LifecycleOwner lifecycleOwner, Observer observer) {
        super.observe(lifecycleOwner, c(observer, this.f١٥٩٩٦a.get()));
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(Observer observer) {
        super.observeForever(c(observer, this.f١٥٩٩٦a.get()));
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(Observer observer) {
        if (observer.getClass().isAssignableFrom(C٠١٨٩a.class)) {
            super.removeObserver(observer);
        } else {
            super.removeObserver(c(observer, -1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void setValue(Object obj) {
        this.f١٥٩٩٦a.getAndIncrement();
        super.setValue(obj);
    }
}
