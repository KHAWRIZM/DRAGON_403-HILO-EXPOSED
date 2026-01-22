package androidx.databinding;

import androidx.databinding.i;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a implements i {
    private transient o mCallbacks;

    @Override // androidx.databinding.i
    public void addOnPropertyChangedCallback(i.a aVar) {
        synchronized (this) {
            try {
                if (this.mCallbacks == null) {
                    this.mCallbacks = new o();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.mCallbacks.a(aVar);
    }

    public void notifyChange() {
        synchronized (this) {
            try {
                o oVar = this.mCallbacks;
                if (oVar == null) {
                    return;
                }
                oVar.d(this, 0, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void notifyPropertyChanged(int i10) {
        synchronized (this) {
            try {
                o oVar = this.mCallbacks;
                if (oVar == null) {
                    return;
                }
                oVar.d(this, i10, null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.databinding.i
    public void removeOnPropertyChangedCallback(i.a aVar) {
        synchronized (this) {
            try {
                o oVar = this.mCallbacks;
                if (oVar == null) {
                    return;
                }
                oVar.i(aVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
