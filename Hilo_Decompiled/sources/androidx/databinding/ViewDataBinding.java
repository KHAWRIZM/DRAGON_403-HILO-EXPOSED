package androidx.databinding;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.a0;
import androidx.databinding.c;
import androidx.databinding.i;
import androidx.databinding.k;
import androidx.databinding.l;
import androidx.databinding.library.R;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class ViewDataBinding extends androidx.databinding.a implements j3.a {
    private static final int BINDING_NUMBER_START = 8;
    public static final String BINDING_TAG_PREFIX = "binding_";
    private static final int HALTED = 2;
    private static final int REBIND = 1;
    private static final int REBOUND = 3;
    protected final androidx.databinding.f mBindingComponent;
    private Choreographer mChoreographer;
    private ViewDataBinding mContainingBinding;
    private final Choreographer.FrameCallback mFrameCallback;
    private boolean mInLiveDataRegisterObserver;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected boolean mInStateFlowRegisterObserver;
    private boolean mIsExecutingPendingBindings;
    private LifecycleOwner mLifecycleOwner;
    private s[] mLocalFieldObservers;
    private k mOnStartListener;
    private boolean mPendingRebind;
    private androidx.databinding.c mRebindCallbacks;
    private boolean mRebindHalted;
    private final Runnable mRebindRunnable;
    private final View mRoot;
    private Handler mUIThreadHandler;
    static int SDK_INT = Build.VERSION.SDK_INT;
    private static final boolean USE_CHOREOGRAPHER = true;
    private static final androidx.databinding.d CREATE_PROPERTY_LISTENER = new a();
    private static final androidx.databinding.d CREATE_LIST_LISTENER = new b();
    private static final androidx.databinding.d CREATE_MAP_LISTENER = new c();
    private static final androidx.databinding.d CREATE_LIVE_DATA_LISTENER = new d();
    private static final c.a REBIND_NOTIFIER = new e();
    private static final ReferenceQueue<ViewDataBinding> sReferenceQueue = new ReferenceQueue<>();
    private static final View.OnAttachStateChangeListener ROOT_REATTACHED_LISTENER = new f();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements androidx.databinding.d {
        a() {
        }

        @Override // androidx.databinding.d
        public s a(ViewDataBinding viewDataBinding, int i10, ReferenceQueue referenceQueue) {
            return new o(viewDataBinding, i10, referenceQueue).c();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b implements androidx.databinding.d {
        b() {
        }

        @Override // androidx.databinding.d
        public s a(ViewDataBinding viewDataBinding, int i10, ReferenceQueue referenceQueue) {
            return new m(viewDataBinding, i10, referenceQueue).b();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class c implements androidx.databinding.d {
        c() {
        }

        @Override // androidx.databinding.d
        public s a(ViewDataBinding viewDataBinding, int i10, ReferenceQueue referenceQueue) {
            return new n(viewDataBinding, i10, referenceQueue).b();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class d implements androidx.databinding.d {
        d() {
        }

        @Override // androidx.databinding.d
        public s a(ViewDataBinding viewDataBinding, int i10, ReferenceQueue referenceQueue) {
            return new j(viewDataBinding, i10, referenceQueue).c();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class e extends c.a {
        e() {
        }

        @Override // androidx.databinding.c.a
        public /* bridge */ /* synthetic */ void a(Object obj, Object obj2, int i10, Object obj3) {
            a0.a(obj);
            b(null, (ViewDataBinding) obj2, i10, (Void) obj3);
        }

        public void b(androidx.databinding.n nVar, ViewDataBinding viewDataBinding, int i10, Void r42) {
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return;
                    } else {
                        throw null;
                    }
                }
                throw null;
            }
            throw null;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class f implements View.OnAttachStateChangeListener {
        f() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.getBinding(view).mRebindRunnable.run();
            view.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                ViewDataBinding.this.mPendingRebind = false;
            }
            ViewDataBinding.processReferenceQueue();
            if (!ViewDataBinding.this.mRoot.isAttachedToWindow()) {
                ViewDataBinding.this.mRoot.removeOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
                ViewDataBinding.this.mRoot.addOnAttachStateChangeListener(ViewDataBinding.ROOT_REATTACHED_LISTENER);
            } else {
                ViewDataBinding.this.executePendingBindings();
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class h implements Choreographer.FrameCallback {
        h() {
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j10) {
            ViewDataBinding.this.mRebindRunnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public final String[][] f٣٢٠٧a;

        /* renamed from: b, reason: collision with root package name */
        public final int[][] f٣٢٠٨b;

        /* renamed from: c, reason: collision with root package name */
        public final int[][] f٣٢٠٩c;

        public i(int i10) {
            this.f٣٢٠٧a = new String[i10];
            this.f٣٢٠٨b = new int[i10];
            this.f٣٢٠٩c = new int[i10];
        }

        public void a(int i10, String[] strArr, int[] iArr, int[] iArr2) {
            this.f٣٢٠٧a[i10] = strArr;
            this.f٣٢٠٨b[i10] = iArr;
            this.f٣٢٠٩c[i10] = iArr2;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class j implements Observer, androidx.databinding.m {

        /* renamed from: a, reason: collision with root package name */
        final s f٣٢١٠a;

        /* renamed from: b, reason: collision with root package name */
        WeakReference f٣٢١١b = null;

        public j(ViewDataBinding viewDataBinding, int i10, ReferenceQueue referenceQueue) {
            this.f٣٢١٠a = new s(viewDataBinding, i10, this, referenceQueue);
        }

        private LifecycleOwner b() {
            WeakReference weakReference = this.f٣٢١١b;
            if (weakReference == null) {
                return null;
            }
            return (LifecycleOwner) weakReference.get();
        }

        @Override // androidx.databinding.m
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void addListener(LiveData liveData) {
            LifecycleOwner b10 = b();
            if (b10 != null) {
                liveData.observe(b10, this);
            }
        }

        public s c() {
            return this.f٣٢١٠a;
        }

        @Override // androidx.databinding.m
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void removeListener(LiveData liveData) {
            liveData.removeObserver(this);
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(Object obj) {
            ViewDataBinding a10 = this.f٣٢١٠a.a();
            if (a10 != null) {
                s sVar = this.f٣٢١٠a;
                a10.handleFieldChange(sVar.f٣٢٢٧b, sVar.b(), 0);
            }
        }

        @Override // androidx.databinding.m
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
            LifecycleOwner b10 = b();
            LiveData liveData = (LiveData) this.f٣٢١٠a.b();
            if (liveData != null) {
                if (b10 != null) {
                    liveData.removeObserver(this);
                }
                if (lifecycleOwner != null) {
                    liveData.observe(lifecycleOwner, this);
                }
            }
            if (lifecycleOwner != null) {
                this.f٣٢١١b = new WeakReference(lifecycleOwner);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class k implements LifecycleObserver {

        /* renamed from: a, reason: collision with root package name */
        final WeakReference f٣٢١٢a;

        /* synthetic */ k(ViewDataBinding viewDataBinding, a aVar) {
            this(viewDataBinding);
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart() {
            ViewDataBinding viewDataBinding = (ViewDataBinding) this.f٣٢١٢a.get();
            if (viewDataBinding != null) {
                viewDataBinding.executePendingBindings();
            }
        }

        private k(ViewDataBinding viewDataBinding) {
            this.f٣٢١٢a = new WeakReference(viewDataBinding);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    protected static abstract class l extends i.a implements androidx.databinding.h {
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class m extends k.a implements androidx.databinding.m {

        /* renamed from: a, reason: collision with root package name */
        final s f٣٢١٣a;

        public m(ViewDataBinding viewDataBinding, int i10, ReferenceQueue referenceQueue) {
            this.f٣٢١٣a = new s(viewDataBinding, i10, this, referenceQueue);
        }

        public void a(androidx.databinding.k kVar) {
            kVar.P(this);
        }

        @Override // androidx.databinding.m
        public /* bridge */ /* synthetic */ void addListener(Object obj) {
            a0.a(obj);
            a(null);
        }

        public s b() {
            return this.f٣٢١٣a;
        }

        public void c(androidx.databinding.k kVar) {
            kVar.g(this);
        }

        @Override // androidx.databinding.m
        public /* bridge */ /* synthetic */ void removeListener(Object obj) {
            a0.a(obj);
            c(null);
        }

        @Override // androidx.databinding.m
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class n extends l.a implements androidx.databinding.m {

        /* renamed from: a, reason: collision with root package name */
        final s f٣٢١٤a;

        public n(ViewDataBinding viewDataBinding, int i10, ReferenceQueue referenceQueue) {
            this.f٣٢١٤a = new s(viewDataBinding, i10, this, referenceQueue);
        }

        public void a(androidx.databinding.l lVar) {
            lVar.a(this);
        }

        @Override // androidx.databinding.m
        public /* bridge */ /* synthetic */ void addListener(Object obj) {
            a0.a(obj);
            a(null);
        }

        public s b() {
            return this.f٣٢١٤a;
        }

        public void c(androidx.databinding.l lVar) {
            lVar.b(this);
        }

        @Override // androidx.databinding.m
        public /* bridge */ /* synthetic */ void removeListener(Object obj) {
            a0.a(obj);
            c(null);
        }

        @Override // androidx.databinding.m
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class o extends i.a implements androidx.databinding.m {

        /* renamed from: a, reason: collision with root package name */
        final s f٣٢١٥a;

        public o(ViewDataBinding viewDataBinding, int i10, ReferenceQueue referenceQueue) {
            this.f٣٢١٥a = new s(viewDataBinding, i10, this, referenceQueue);
        }

        @Override // androidx.databinding.i.a
        public void a(androidx.databinding.i iVar, int i10) {
            ViewDataBinding a10 = this.f٣٢١٥a.a();
            if (a10 == null || ((androidx.databinding.i) this.f٣٢١٥a.b()) != iVar) {
                return;
            }
            a10.handleFieldChange(this.f٣٢١٥a.f٣٢٢٧b, iVar, i10);
        }

        @Override // androidx.databinding.m
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void addListener(androidx.databinding.i iVar) {
            iVar.addOnPropertyChangedCallback(this);
        }

        public s c() {
            return this.f٣٢١٥a;
        }

        @Override // androidx.databinding.m
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void removeListener(androidx.databinding.i iVar) {
            iVar.removeOnPropertyChangedCallback(this);
        }

        @Override // androidx.databinding.m
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        }
    }

    protected ViewDataBinding(androidx.databinding.f fVar, View view, int i10) {
        this.mRebindRunnable = new g();
        this.mPendingRebind = false;
        this.mRebindHalted = false;
        this.mLocalFieldObservers = new s[i10];
        this.mRoot = view;
        if (Looper.myLooper() != null) {
            if (USE_CHOREOGRAPHER) {
                this.mChoreographer = Choreographer.getInstance();
                this.mFrameCallback = new h();
                return;
            } else {
                this.mFrameCallback = null;
                this.mUIThreadHandler = new Handler(Looper.myLooper());
                return;
            }
        }
        throw new IllegalStateException("DataBinding must be created in view's UI Thread");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static ViewDataBinding bind(Object obj, View view, int i10) {
        checkAndCastToBindingComponent(obj);
        return androidx.databinding.g.c(null, view, i10);
    }

    private static androidx.databinding.f checkAndCastToBindingComponent(Object obj) {
        if (obj == null) {
            return null;
        }
        throw new IllegalArgumentException("The provided bindingComponent parameter must be an instance of DataBindingComponent. See  https://issuetracker.google.com/issues/116541301 for details of why this parameter is not defined as DataBindingComponent");
    }

    private void executeBindingsInternal() {
        if (this.mIsExecutingPendingBindings) {
            requestRebind();
            return;
        }
        if (!hasPendingBindings()) {
            return;
        }
        this.mIsExecutingPendingBindings = true;
        this.mRebindHalted = false;
        androidx.databinding.c cVar = this.mRebindCallbacks;
        if (cVar != null) {
            cVar.d(this, 1, null);
            if (this.mRebindHalted) {
                this.mRebindCallbacks.d(this, 2, null);
            }
        }
        if (!this.mRebindHalted) {
            executeBindings();
            androidx.databinding.c cVar2 = this.mRebindCallbacks;
            if (cVar2 != null) {
                cVar2.d(this, 3, null);
            }
        }
        this.mIsExecutingPendingBindings = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void executeBindingsOn(ViewDataBinding viewDataBinding) {
        viewDataBinding.executeBindingsInternal();
    }

    private static int findIncludeIndex(String str, int i10, i iVar, int i11) {
        CharSequence subSequence = str.subSequence(str.indexOf(47) + 1, str.length() - 2);
        String[] strArr = iVar.f٣٢٠٧a[i11];
        int length = strArr.length;
        while (i10 < length) {
            if (TextUtils.equals(subSequence, strArr[i10])) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    private static int findLastMatching(ViewGroup viewGroup, int i10) {
        String str;
        String str2 = (String) viewGroup.getChildAt(i10).getTag();
        String substring = str2.substring(0, str2.length() - 1);
        int length = substring.length();
        int childCount = viewGroup.getChildCount();
        for (int i11 = i10 + 1; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt.getTag() instanceof String) {
                str = (String) childAt.getTag();
            } else {
                str = null;
            }
            if (str != null && str.startsWith(substring)) {
                if (str.length() == str2.length() && str.charAt(str.length() - 1) == '0') {
                    return i10;
                }
                if (isNumeric(str, length)) {
                    i10 = i11;
                }
            }
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ViewDataBinding getBinding(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(R.id.dataBinding);
        }
        return null;
    }

    public static int getBuildSdkInt() {
        return SDK_INT;
    }

    protected static int getColorFromResource(View view, int i10) {
        int color;
        if (Build.VERSION.SDK_INT >= 23) {
            color = view.getContext().getColor(i10);
            return color;
        }
        return view.getResources().getColor(i10);
    }

    protected static ColorStateList getColorStateListFromResource(View view, int i10) {
        ColorStateList colorStateList;
        if (Build.VERSION.SDK_INT >= 23) {
            colorStateList = view.getContext().getColorStateList(i10);
            return colorStateList;
        }
        return view.getResources().getColorStateList(i10);
    }

    protected static Drawable getDrawableFromResource(View view, int i10) {
        return view.getContext().getDrawable(i10);
    }

    protected static <K, T> T getFrom(Map<K, T> map, K k10) {
        if (map == null) {
            return null;
        }
        return map.get(k10);
    }

    protected static <T> T getFromArray(T[] tArr, int i10) {
        if (tArr == null || i10 < 0 || i10 >= tArr.length) {
            return null;
        }
        return tArr[i10];
    }

    protected static <T> T getFromList(List<T> list, int i10) {
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return null;
        }
        return list.get(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static <T extends ViewDataBinding> T inflateInternal(LayoutInflater layoutInflater, int i10, ViewGroup viewGroup, boolean z10, Object obj) {
        checkAndCastToBindingComponent(obj);
        return (T) androidx.databinding.g.i(layoutInflater, i10, viewGroup, z10, null);
    }

    private static boolean isNumeric(String str, int i10) {
        int length = str.length();
        if (length == i10) {
            return false;
        }
        while (i10 < length) {
            if (!Character.isDigit(str.charAt(i10))) {
                return false;
            }
            i10++;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object[] mapBindings(androidx.databinding.f fVar, View view, int i10, i iVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i10];
        mapBindings(fVar, view, objArr, iVar, sparseIntArray, true);
        return objArr;
    }

    protected static boolean parse(String str, boolean z10) {
        return str == null ? z10 : Boolean.parseBoolean(str);
    }

    private static int parseTagInt(String str, int i10) {
        int i11 = 0;
        while (i10 < str.length()) {
            i11 = (i11 * 10) + (str.charAt(i10) - '0');
            i10++;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void processReferenceQueue() {
        while (true) {
            Reference<? extends ViewDataBinding> poll = sReferenceQueue.poll();
            if (poll != null) {
                if (poll instanceof s) {
                    ((s) poll).e();
                }
            } else {
                return;
            }
        }
    }

    protected static int safeUnbox(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    protected static void setBindingInverseListener(ViewDataBinding viewDataBinding, androidx.databinding.h hVar, l lVar) {
        if (hVar != lVar && hVar != null) {
            a0.a(hVar);
            viewDataBinding.removeOnPropertyChangedCallback(null);
        }
    }

    protected static <T> void setTo(T[] tArr, int i10, T t10) {
        if (tArr == null || i10 < 0 || i10 >= tArr.length) {
            return;
        }
        tArr[i10] = t10;
    }

    public void addOnRebindCallback(androidx.databinding.n nVar) {
        if (this.mRebindCallbacks == null) {
            this.mRebindCallbacks = new androidx.databinding.c(REBIND_NOTIFIER);
        }
        this.mRebindCallbacks.a(nVar);
    }

    protected void ensureBindingComponentIsNotNull(Class<?> cls) {
        throw new IllegalStateException("Required DataBindingComponent is null in class " + getClass().getSimpleName() + ". A BindingAdapter in " + cls.getCanonicalName() + " is not static and requires an object to use, retrieved from the DataBindingComponent. If you don't use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static.");
    }

    protected abstract void executeBindings();

    public void executePendingBindings() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding == null) {
            executeBindingsInternal();
        } else {
            viewDataBinding.executePendingBindings();
        }
    }

    void forceExecuteBindings() {
        executeBindings();
    }

    public LifecycleOwner getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    protected Object getObservedField(int i10) {
        s sVar = this.mLocalFieldObservers[i10];
        if (sVar == null) {
            return null;
        }
        return sVar.b();
    }

    @Override // j3.a
    public View getRoot() {
        return this.mRoot;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void handleFieldChange(int i10, Object obj, int i11) {
        if (!this.mInLiveDataRegisterObserver && !this.mInStateFlowRegisterObserver && onFieldChange(i10, obj, i11)) {
            requestRebind();
        }
    }

    public abstract boolean hasPendingBindings();

    public abstract void invalidateAll();

    protected abstract boolean onFieldChange(int i10, Object obj, int i11);

    protected void registerTo(int i10, Object obj, androidx.databinding.d dVar) {
        if (obj == null) {
            return;
        }
        s sVar = this.mLocalFieldObservers[i10];
        if (sVar == null) {
            sVar = dVar.a(this, i10, sReferenceQueue);
            this.mLocalFieldObservers[i10] = sVar;
            LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
            if (lifecycleOwner != null) {
                sVar.c(lifecycleOwner);
            }
        }
        sVar.d(obj);
    }

    public void removeOnRebindCallback(androidx.databinding.n nVar) {
        androidx.databinding.c cVar = this.mRebindCallbacks;
        if (cVar != null) {
            cVar.i(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void requestRebind() {
        ViewDataBinding viewDataBinding = this.mContainingBinding;
        if (viewDataBinding != null) {
            viewDataBinding.requestRebind();
            return;
        }
        LifecycleOwner lifecycleOwner = this.mLifecycleOwner;
        if (lifecycleOwner != null && !lifecycleOwner.getLifecycle().getState().isAtLeast(Lifecycle.State.STARTED)) {
            return;
        }
        synchronized (this) {
            try {
                if (this.mPendingRebind) {
                    return;
                }
                this.mPendingRebind = true;
                if (USE_CHOREOGRAPHER) {
                    this.mChoreographer.postFrameCallback(this.mFrameCallback);
                } else {
                    this.mUIThreadHandler.post(this.mRebindRunnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setContainedBinding(ViewDataBinding viewDataBinding) {
        if (viewDataBinding != null) {
            viewDataBinding.mContainingBinding = this;
        }
    }

    public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner instanceof Fragment) {
            Log.w("DataBinding", "Setting the fragment as the LifecycleOwner might cause memory leaks because views lives shorter than the Fragment. Consider using Fragment's view lifecycle");
        }
        LifecycleOwner lifecycleOwner2 = this.mLifecycleOwner;
        if (lifecycleOwner2 == lifecycleOwner) {
            return;
        }
        if (lifecycleOwner2 != null) {
            lifecycleOwner2.getLifecycle().removeObserver(this.mOnStartListener);
        }
        this.mLifecycleOwner = lifecycleOwner;
        if (lifecycleOwner != null) {
            if (this.mOnStartListener == null) {
                this.mOnStartListener = new k(this, null);
            }
            lifecycleOwner.getLifecycle().addObserver(this.mOnStartListener);
        }
        for (s sVar : this.mLocalFieldObservers) {
            if (sVar != null) {
                sVar.c(lifecycleOwner);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRootTag(View view) {
        view.setTag(R.id.dataBinding, this);
    }

    public abstract boolean setVariable(int i10, Object obj);

    public void unbind() {
        for (s sVar : this.mLocalFieldObservers) {
            if (sVar != null) {
                sVar.e();
            }
        }
    }

    protected boolean unregisterFrom(int i10) {
        s sVar = this.mLocalFieldObservers[i10];
        if (sVar != null) {
            return sVar.e();
        }
        return false;
    }

    protected boolean updateLiveDataRegistration(int i10, LiveData<?> liveData) {
        this.mInLiveDataRegisterObserver = true;
        try {
            return updateRegistration(i10, liveData, CREATE_LIVE_DATA_LISTENER);
        } finally {
            this.mInLiveDataRegisterObserver = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean updateRegistration(int i10, Object obj, androidx.databinding.d dVar) {
        if (obj == null) {
            return unregisterFrom(i10);
        }
        s sVar = this.mLocalFieldObservers[i10];
        if (sVar == null) {
            registerTo(i10, obj, dVar);
            return true;
        }
        if (sVar.b() == obj) {
            return false;
        }
        unregisterFrom(i10);
        registerTo(i10, obj, dVar);
        return true;
    }

    protected static byte parse(String str, byte b10) {
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b10;
        }
    }

    protected static long safeUnbox(Long l10) {
        if (l10 == null) {
            return 0L;
        }
        return l10.longValue();
    }

    protected void setRootTag(View[] viewArr) {
        for (View view : viewArr) {
            view.setTag(R.id.dataBinding, this);
        }
    }

    protected static boolean getFromArray(boolean[] zArr, int i10) {
        if (zArr == null || i10 < 0 || i10 >= zArr.length) {
            return false;
        }
        return zArr[i10];
    }

    protected static <T> T getFromList(SparseArray<T> sparseArray, int i10) {
        if (sparseArray == null || i10 < 0) {
            return null;
        }
        return sparseArray.get(i10);
    }

    protected static Object[] mapBindings(androidx.databinding.f fVar, View[] viewArr, int i10, i iVar, SparseIntArray sparseIntArray) {
        Object[] objArr = new Object[i10];
        for (View view : viewArr) {
            mapBindings(fVar, view, objArr, iVar, sparseIntArray, true);
        }
        return objArr;
    }

    protected static short parse(String str, short s10) {
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s10;
        }
    }

    protected static short safeUnbox(Short sh) {
        if (sh == null) {
            return (short) 0;
        }
        return sh.shortValue();
    }

    protected static void setTo(boolean[] zArr, int i10, boolean z10) {
        if (zArr == null || i10 < 0 || i10 >= zArr.length) {
            return;
        }
        zArr[i10] = z10;
    }

    @TargetApi(16)
    protected static <T> T getFromList(LongSparseArray<T> longSparseArray, int i10) {
        if (longSparseArray == null || i10 < 0) {
            return null;
        }
        return longSparseArray.get(i10);
    }

    protected static int parse(String str, int i10) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    protected static byte safeUnbox(Byte b10) {
        if (b10 == null) {
            return (byte) 0;
        }
        return b10.byteValue();
    }

    protected static byte getFromArray(byte[] bArr, int i10) {
        if (bArr == null || i10 < 0 || i10 >= bArr.length) {
            return (byte) 0;
        }
        return bArr[i10];
    }

    protected static <T> T getFromList(androidx.collection.LongSparseArray<T> longSparseArray, int i10) {
        if (longSparseArray == null || i10 < 0) {
            return null;
        }
        return longSparseArray.get(i10);
    }

    protected static long parse(String str, long j10) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j10;
        }
    }

    protected static char safeUnbox(Character ch) {
        if (ch == null) {
            return (char) 0;
        }
        return ch.charValue();
    }

    protected static void setTo(byte[] bArr, int i10, byte b10) {
        if (bArr == null || i10 < 0 || i10 >= bArr.length) {
            return;
        }
        bArr[i10] = b10;
    }

    protected static boolean getFromList(SparseBooleanArray sparseBooleanArray, int i10) {
        if (sparseBooleanArray == null || i10 < 0) {
            return false;
        }
        return sparseBooleanArray.get(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0112 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void mapBindings(androidx.databinding.f fVar, View view, Object[] objArr, i iVar, SparseIntArray sparseIntArray, boolean z10) {
        boolean z11;
        int i10;
        int i11;
        int i12;
        boolean z12;
        int findIncludeIndex;
        int id;
        int i13;
        int i14;
        if (getBinding(view) != null) {
            return;
        }
        Object tag = view.getTag();
        String str = tag instanceof String ? (String) tag : null;
        if (z10 && str != null && str.startsWith("layout")) {
            int lastIndexOf = str.lastIndexOf(95);
            if (lastIndexOf > 0) {
                int i15 = lastIndexOf + 1;
                if (isNumeric(str, i15)) {
                    i14 = parseTagInt(str, i15);
                    if (objArr[i14] == null) {
                        objArr[i14] = view;
                    }
                    if (iVar == null) {
                        i14 = -1;
                    }
                    z11 = true;
                    i10 = i14;
                }
            }
            i14 = -1;
            z11 = false;
            i10 = i14;
        } else if (str == null || !str.startsWith(BINDING_TAG_PREFIX)) {
            z11 = false;
            i10 = -1;
        } else {
            int parseTagInt = parseTagInt(str, BINDING_NUMBER_START);
            if (objArr[parseTagInt] == null) {
                objArr[parseTagInt] = view;
            }
            if (iVar == null) {
                parseTagInt = -1;
            }
            i10 = parseTagInt;
            z11 = true;
        }
        if (!z11 && (id = view.getId()) > 0 && sparseIntArray != null && (i13 = sparseIntArray.get(id, -1)) >= 0 && objArr[i13] == null) {
            objArr[i13] = view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            int i16 = 0;
            int i17 = 0;
            while (i16 < childCount) {
                View childAt = viewGroup.getChildAt(i16);
                if (i10 >= 0 && (childAt.getTag() instanceof String)) {
                    String str2 = (String) childAt.getTag();
                    if (str2.endsWith("_0") && str2.startsWith("layout") && str2.indexOf(47) > 0 && (findIncludeIndex = findIncludeIndex(str2, i17, iVar, i10)) >= 0) {
                        int i18 = findIncludeIndex + 1;
                        int i19 = iVar.f٣٢٠٨b[i10][findIncludeIndex];
                        int i20 = iVar.f٣٢٠٩c[i10][findIncludeIndex];
                        int findLastMatching = findLastMatching(viewGroup, i16);
                        if (findLastMatching == i16) {
                            objArr[i19] = androidx.databinding.g.c(fVar, childAt, i20);
                            i11 = i16;
                            i12 = i18;
                        } else {
                            int i21 = findLastMatching - i16;
                            int i22 = i21 + 1;
                            View[] viewArr = new View[i22];
                            int i23 = 0;
                            while (i23 < i22) {
                                viewArr[i23] = viewGroup.getChildAt(i16 + i23);
                                i23++;
                                i18 = i18;
                            }
                            objArr[i19] = androidx.databinding.g.d(fVar, viewArr, i20);
                            i12 = i18;
                            i11 = i16 + i21;
                        }
                        z12 = true;
                        if (z12) {
                            mapBindings(fVar, childAt, objArr, iVar, sparseIntArray, false);
                        }
                        i16 = i11 + 1;
                        i17 = i12;
                    }
                }
                i11 = i16;
                i12 = i17;
                z12 = false;
                if (z12) {
                }
                i16 = i11 + 1;
                i17 = i12;
            }
        }
    }

    protected static float parse(String str, float f10) {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f10;
        }
    }

    protected static double safeUnbox(Double d10) {
        return d10 == null ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d10.doubleValue();
    }

    protected static short getFromArray(short[] sArr, int i10) {
        if (sArr == null || i10 < 0 || i10 >= sArr.length) {
            return (short) 0;
        }
        return sArr[i10];
    }

    protected static int getFromList(SparseIntArray sparseIntArray, int i10) {
        if (sparseIntArray == null || i10 < 0) {
            return 0;
        }
        return sparseIntArray.get(i10);
    }

    protected static double parse(String str, double d10) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d10;
        }
    }

    protected static float safeUnbox(Float f10) {
        return f10 == null ? DownloadProgress.UNKNOWN_PROGRESS : f10.floatValue();
    }

    protected static void setTo(short[] sArr, int i10, short s10) {
        if (sArr == null || i10 < 0 || i10 >= sArr.length) {
            return;
        }
        sArr[i10] = s10;
    }

    protected boolean updateRegistration(int i10, androidx.databinding.i iVar) {
        return updateRegistration(i10, iVar, CREATE_PROPERTY_LISTENER);
    }

    @TargetApi(18)
    protected static long getFromList(SparseLongArray sparseLongArray, int i10) {
        if (sparseLongArray == null || i10 < 0) {
            return 0L;
        }
        return sparseLongArray.get(i10);
    }

    protected static char parse(String str, char c10) {
        return (str == null || str.isEmpty()) ? c10 : str.charAt(0);
    }

    protected static boolean safeUnbox(Boolean bool) {
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    protected boolean updateRegistration(int i10, androidx.databinding.k kVar) {
        return updateRegistration(i10, kVar, CREATE_LIST_LISTENER);
    }

    protected static char getFromArray(char[] cArr, int i10) {
        if (cArr == null || i10 < 0 || i10 >= cArr.length) {
            return (char) 0;
        }
        return cArr[i10];
    }

    protected static void setTo(char[] cArr, int i10, char c10) {
        if (cArr == null || i10 < 0 || i10 >= cArr.length) {
            return;
        }
        cArr[i10] = c10;
    }

    protected boolean updateRegistration(int i10, androidx.databinding.l lVar) {
        return updateRegistration(i10, lVar, CREATE_MAP_LISTENER);
    }

    protected static int getFromArray(int[] iArr, int i10) {
        if (iArr == null || i10 < 0 || i10 >= iArr.length) {
            return 0;
        }
        return iArr[i10];
    }

    protected static void setTo(int[] iArr, int i10, int i11) {
        if (iArr == null || i10 < 0 || i10 >= iArr.length) {
            return;
        }
        iArr[i10] = i11;
    }

    protected static long getFromArray(long[] jArr, int i10) {
        if (jArr == null || i10 < 0 || i10 >= jArr.length) {
            return 0L;
        }
        return jArr[i10];
    }

    protected static void setTo(long[] jArr, int i10, long j10) {
        if (jArr == null || i10 < 0 || i10 >= jArr.length) {
            return;
        }
        jArr[i10] = j10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewDataBinding(Object obj, View view, int i10) {
        this((androidx.databinding.f) null, view, i10);
        checkAndCastToBindingComponent(obj);
    }

    protected static float getFromArray(float[] fArr, int i10) {
        return (fArr == null || i10 < 0 || i10 >= fArr.length) ? DownloadProgress.UNKNOWN_PROGRESS : fArr[i10];
    }

    protected static void setTo(float[] fArr, int i10, float f10) {
        if (fArr == null || i10 < 0 || i10 >= fArr.length) {
            return;
        }
        fArr[i10] = f10;
    }

    protected static double getFromArray(double[] dArr, int i10) {
        return (dArr == null || i10 < 0 || i10 >= dArr.length) ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : dArr[i10];
    }

    protected static void setTo(double[] dArr, int i10, double d10) {
        if (dArr == null || i10 < 0 || i10 >= dArr.length) {
            return;
        }
        dArr[i10] = d10;
    }

    protected static <T> void setTo(List<T> list, int i10, T t10) {
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return;
        }
        list.set(i10, t10);
    }

    protected static <T> void setTo(SparseArray<T> sparseArray, int i10, T t10) {
        if (sparseArray == null || i10 < 0 || i10 >= sparseArray.size()) {
            return;
        }
        sparseArray.put(i10, t10);
    }

    @TargetApi(16)
    protected static <T> void setTo(LongSparseArray<T> longSparseArray, int i10, T t10) {
        if (longSparseArray == null || i10 < 0 || i10 >= longSparseArray.size()) {
            return;
        }
        longSparseArray.put(i10, t10);
    }

    protected static <T> void setTo(androidx.collection.LongSparseArray<T> longSparseArray, int i10, T t10) {
        if (longSparseArray == null || i10 < 0 || i10 >= longSparseArray.size()) {
            return;
        }
        longSparseArray.put(i10, t10);
    }

    protected static void setTo(SparseBooleanArray sparseBooleanArray, int i10, boolean z10) {
        if (sparseBooleanArray == null || i10 < 0 || i10 >= sparseBooleanArray.size()) {
            return;
        }
        sparseBooleanArray.put(i10, z10);
    }

    protected static void setTo(SparseIntArray sparseIntArray, int i10, int i11) {
        if (sparseIntArray == null || i10 < 0 || i10 >= sparseIntArray.size()) {
            return;
        }
        sparseIntArray.put(i10, i11);
    }

    @TargetApi(18)
    protected static void setTo(SparseLongArray sparseLongArray, int i10, long j10) {
        if (sparseLongArray == null || i10 < 0 || i10 >= sparseLongArray.size()) {
            return;
        }
        sparseLongArray.put(i10, j10);
    }

    protected static <K, T> void setTo(Map<K, T> map, K k10, T t10) {
        if (map == null) {
            return;
        }
        map.put(k10, t10);
    }
}
