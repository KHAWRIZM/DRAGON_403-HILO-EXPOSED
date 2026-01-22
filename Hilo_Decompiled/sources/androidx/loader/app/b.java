package androidx.loader.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.y;
import androidx.loader.app.a;
import androidx.loader.content.b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import kotlin.reflect.KClass;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class b extends androidx.loader.app.a {

    /* renamed from: c, reason: collision with root package name */
    static boolean f٣٨٢٧c;

    /* renamed from: a, reason: collision with root package name */
    private final LifecycleOwner f٣٨٢٨a;

    /* renamed from: b, reason: collision with root package name */
    private final c f٣٨٢٩b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a extends MutableLiveData implements b.InterfaceC٠٠٤٦b {

        /* renamed from: a, reason: collision with root package name */
        private final int f٣٨٣٠a;

        /* renamed from: b, reason: collision with root package name */
        private final Bundle f٣٨٣١b;

        /* renamed from: c, reason: collision with root package name */
        private final androidx.loader.content.b f٣٨٣٢c;

        /* renamed from: d, reason: collision with root package name */
        private LifecycleOwner f٣٨٣٣d;

        /* renamed from: e, reason: collision with root package name */
        private C٠٠٤٤b f٣٨٣٤e;

        /* renamed from: f, reason: collision with root package name */
        private androidx.loader.content.b f٣٨٣٥f;

        a(int i10, Bundle bundle, androidx.loader.content.b bVar, androidx.loader.content.b bVar2) {
            this.f٣٨٣٠a = i10;
            this.f٣٨٣١b = bundle;
            this.f٣٨٣٢c = bVar;
            this.f٣٨٣٥f = bVar2;
            bVar.registerListener(i10, this);
        }

        @Override // androidx.loader.content.b.InterfaceC٠٠٤٦b
        public void a(androidx.loader.content.b bVar, Object obj) {
            if (b.f٣٨٢٧c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                setValue(obj);
                return;
            }
            if (b.f٣٨٢٧c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            postValue(obj);
        }

        androidx.loader.content.b b(boolean z10) {
            if (b.f٣٨٢٧c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f٣٨٣٢c.cancelLoad();
            this.f٣٨٣٢c.abandon();
            C٠٠٤٤b r02 = this.f٣٨٣٤e;
            if (r02 != null) {
                removeObserver(r02);
                if (z10) {
                    r02.c();
                }
            }
            this.f٣٨٣٢c.unregisterListener(this);
            if ((r02 != null && !r02.b()) || z10) {
                this.f٣٨٣٢c.reset();
                return this.f٣٨٣٥f;
            }
            return this.f٣٨٣٢c;
        }

        public void c(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f٣٨٣٠a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f٣٨٣١b);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f٣٨٣٢c);
            this.f٣٨٣٢c.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f٣٨٣٤e != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f٣٨٣٤e);
                this.f٣٨٣٤e.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(d().dataToString(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(hasActiveObservers());
        }

        androidx.loader.content.b d() {
            return this.f٣٨٣٢c;
        }

        void e() {
            LifecycleOwner lifecycleOwner = this.f٣٨٣٣d;
            C٠٠٤٤b r12 = this.f٣٨٣٤e;
            if (lifecycleOwner != null && r12 != null) {
                super.removeObserver(r12);
                observe(lifecycleOwner, r12);
            }
        }

        androidx.loader.content.b f(LifecycleOwner lifecycleOwner, a.InterfaceC٠٠٤٣a r42) {
            C٠٠٤٤b r02 = new C٠٠٤٤b(this.f٣٨٣٢c, r42);
            observe(lifecycleOwner, r02);
            C٠٠٤٤b r43 = this.f٣٨٣٤e;
            if (r43 != null) {
                removeObserver(r43);
            }
            this.f٣٨٣٣d = lifecycleOwner;
            this.f٣٨٣٤e = r02;
            return this.f٣٨٣٢c;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.LiveData
        public void onActive() {
            if (b.f٣٨٢٧c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f٣٨٣٢c.startLoading();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.LiveData
        public void onInactive() {
            if (b.f٣٨٢٧c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f٣٨٣٢c.stopLoading();
        }

        @Override // androidx.lifecycle.LiveData
        public void removeObserver(Observer observer) {
            super.removeObserver(observer);
            this.f٣٨٣٣d = null;
            this.f٣٨٣٤e = null;
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(Object obj) {
            super.setValue(obj);
            androidx.loader.content.b bVar = this.f٣٨٣٥f;
            if (bVar != null) {
                bVar.reset();
                this.f٣٨٣٥f = null;
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f٣٨٣٠a);
            sb.append(" : ");
            androidx.core.util.b.a(this.f٣٨٣٢c, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.loader.app.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class C٠٠٤٤b implements Observer {

        /* renamed from: a, reason: collision with root package name */
        private final androidx.loader.content.b f٣٨٣٦a;

        /* renamed from: b, reason: collision with root package name */
        private final a.InterfaceC٠٠٤٣a f٣٨٣٧b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f٣٨٣٨c = false;

        C٠٠٤٤b(androidx.loader.content.b bVar, a.InterfaceC٠٠٤٣a r32) {
            this.f٣٨٣٦a = bVar;
            this.f٣٨٣٧b = r32;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f٣٨٣٨c);
        }

        boolean b() {
            return this.f٣٨٣٨c;
        }

        void c() {
            if (this.f٣٨٣٨c) {
                if (b.f٣٨٢٧c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f٣٨٣٦a);
                }
                this.f٣٨٣٧b.onLoaderReset(this.f٣٨٣٦a);
            }
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(Object obj) {
            if (b.f٣٨٢٧c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f٣٨٣٦a + ": " + this.f٣٨٣٦a.dataToString(obj));
            }
            this.f٣٨٣٧b.onLoadFinished(this.f٣٨٣٦a, obj);
            this.f٣٨٣٨c = true;
        }

        public String toString() {
            return this.f٣٨٣٧b.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c extends ViewModel {

        /* renamed from: c, reason: collision with root package name */
        private static final ViewModelProvider.Factory f٣٨٣٩c = new a();

        /* renamed from: a, reason: collision with root package name */
        private SparseArrayCompat f٣٨٤٠a = new SparseArrayCompat();

        /* renamed from: b, reason: collision with root package name */
        private boolean f٣٨٤١b = false;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        static class a implements ViewModelProvider.Factory {
            a() {
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
                return y.b(this, cls, creationExtras);
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public /* synthetic */ ViewModel create(KClass kClass, CreationExtras creationExtras) {
                return y.c(this, kClass, creationExtras);
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            public ViewModel create(Class cls) {
                return new c();
            }
        }

        c() {
        }

        static c c(ViewModelStore viewModelStore) {
            return (c) new ViewModelProvider(viewModelStore, f٣٨٣٩c).get(c.class);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f٣٨٤٠a.size() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i10 = 0; i10 < this.f٣٨٤٠a.size(); i10++) {
                    a aVar = (a) this.f٣٨٤٠a.valueAt(i10);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f٣٨٤٠a.keyAt(i10));
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.c(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        void b() {
            this.f٣٨٤١b = false;
        }

        a d(int i10) {
            return (a) this.f٣٨٤٠a.get(i10);
        }

        boolean e() {
            return this.f٣٨٤١b;
        }

        void f() {
            int size = this.f٣٨٤٠a.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((a) this.f٣٨٤٠a.valueAt(i10)).e();
            }
        }

        void g(int i10, a aVar) {
            this.f٣٨٤٠a.put(i10, aVar);
        }

        void h() {
            this.f٣٨٤١b = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.lifecycle.ViewModel
        public void onCleared() {
            super.onCleared();
            int size = this.f٣٨٤٠a.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((a) this.f٣٨٤٠a.valueAt(i10)).b(true);
            }
            this.f٣٨٤٠a.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.f٣٨٢٨a = lifecycleOwner;
        this.f٣٨٢٩b = c.c(viewModelStore);
    }

    private androidx.loader.content.b e(int i10, Bundle bundle, a.InterfaceC٠٠٤٣a r52, androidx.loader.content.b bVar) {
        try {
            this.f٣٨٢٩b.h();
            androidx.loader.content.b onCreateLoader = r52.onCreateLoader(i10, bundle);
            if (onCreateLoader != null) {
                if (onCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
                }
                a aVar = new a(i10, bundle, onCreateLoader, bVar);
                if (f٣٨٢٧c) {
                    Log.v("LoaderManager", "  Created new loader " + aVar);
                }
                this.f٣٨٢٩b.g(i10, aVar);
                this.f٣٨٢٩b.b();
                return aVar.f(this.f٣٨٢٨a, r52);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.f٣٨٢٩b.b();
            throw th;
        }
    }

    @Override // androidx.loader.app.a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f٣٨٢٩b.a(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public androidx.loader.content.b c(int i10, Bundle bundle, a.InterfaceC٠٠٤٣a r72) {
        if (!this.f٣٨٢٩b.e()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                a d10 = this.f٣٨٢٩b.d(i10);
                if (f٣٨٢٧c) {
                    Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
                }
                if (d10 == null) {
                    return e(i10, bundle, r72, null);
                }
                if (f٣٨٢٧c) {
                    Log.v("LoaderManager", "  Re-using existing loader " + d10);
                }
                return d10.f(this.f٣٨٢٨a, r72);
            }
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.a
    public void d() {
        this.f٣٨٢٩b.f();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        androidx.core.util.b.a(this.f٣٨٢٨a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
