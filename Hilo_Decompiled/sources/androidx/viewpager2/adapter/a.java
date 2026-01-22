package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.app.a0;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.view.d1;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class a extends RecyclerView.Adapter implements androidx.viewpager2.adapter.c {
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";
    f mFragmentEventDispatcher;
    final FragmentManager mFragmentManager;
    private g mFragmentMaxLifecycleEnforcer;
    final LongSparseArray<Fragment> mFragments;
    private boolean mHasStaleFragments;
    boolean mIsInGracePeriod;
    private final LongSparseArray<Integer> mItemIdToViewHolder;
    final Lifecycle mLifecycle;
    private final LongSparseArray<Fragment.SavedState> mSavedStates;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.viewpager2.adapter.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class C٠٠٥٨a implements LifecycleEventObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.viewpager2.adapter.b f٤٥٤١a;

        C٠٠٥٨a(androidx.viewpager2.adapter.b bVar) {
            this.f٤٥٤١a = bVar;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (a.this.shouldDelayFragmentTransactions()) {
                return;
            }
            lifecycleOwner.getLifecycle().removeObserver(this);
            if (d1.U(this.f٤٥٤١a.b())) {
                a.this.placeFragmentInViewHolder(this.f٤٥٤١a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b extends FragmentManager.FragmentLifecycleCallbacks {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Fragment f٤٥٤٣a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ FrameLayout f٤٥٤٤b;

        b(Fragment fragment, FrameLayout frameLayout) {
            this.f٤٥٤٣a = fragment;
            this.f٤٥٤٤b = frameLayout;
        }

        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, View view, Bundle bundle) {
            if (fragment == this.f٤٥٤٣a) {
                fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                a.this.addViewToContainer(view, this.f٤٥٤٤b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.mIsInGracePeriod = false;
            aVar.gcFragments();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d implements LifecycleEventObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f٤٥٤٧a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Runnable f٤٥٤٨b;

        d(Handler handler, Runnable runnable) {
            this.f٤٥٤٧a = handler;
            this.f٤٥٤٨b = runnable;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_DESTROY) {
                this.f٤٥٤٧a.removeCallbacks(this.f٤٥٤٨b);
                lifecycleOwner.getLifecycle().removeObserver(this);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static abstract class e extends RecyclerView.AdapterDataObserver {
        private e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i10, int i11) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i10, int i11, int i12) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i10, int i11) {
            onChanged();
        }

        /* synthetic */ e(C٠٠٥٨a r12) {
            this();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i10, int i11, Object obj) {
            onChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        private List f٤٥٥٠a = new CopyOnWriteArrayList();

        f() {
        }

        public List a(Fragment fragment, Lifecycle.State state) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f٤٥٥٠a.iterator();
            if (!it.hasNext()) {
                return arrayList;
            }
            a0.a(it.next());
            throw null;
        }

        public void b(List list) {
            Iterator it = list.iterator();
            if (!it.hasNext()) {
                return;
            }
            a0.a(it.next());
            throw null;
        }

        public List c(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f٤٥٥٠a.iterator();
            if (!it.hasNext()) {
                return arrayList;
            }
            a0.a(it.next());
            throw null;
        }

        public List d(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f٤٥٥٠a.iterator();
            if (!it.hasNext()) {
                return arrayList;
            }
            a0.a(it.next());
            throw null;
        }

        public List e(Fragment fragment) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f٤٥٥٠a.iterator();
            if (!it.hasNext()) {
                return arrayList;
            }
            a0.a(it.next());
            throw null;
        }

        public void f(h hVar) {
            this.f٤٥٥٠a.add(hVar);
        }

        public void g(h hVar) {
            this.f٤٥٥٠a.remove(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class g {

        /* renamed from: a, reason: collision with root package name */
        private ViewPager2.OnPageChangeCallback f٤٥٥١a;

        /* renamed from: b, reason: collision with root package name */
        private RecyclerView.AdapterDataObserver f٤٥٥٢b;

        /* renamed from: c, reason: collision with root package name */
        private LifecycleEventObserver f٤٥٥٣c;

        /* renamed from: d, reason: collision with root package name */
        private ViewPager2 f٤٥٥٤d;

        /* renamed from: e, reason: collision with root package name */
        private long f٤٥٥٥e = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: androidx.viewpager2.adapter.a$g$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class C٠٠٥٩a extends ViewPager2.OnPageChangeCallback {
            C٠٠٥٩a() {
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i10) {
                g.this.d(false);
            }

            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i10) {
                g.this.d(false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class b extends e {
            b() {
                super(null);
            }

            @Override // androidx.viewpager2.adapter.a.e, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                g.this.d(true);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        public class c implements LifecycleEventObserver {
            c() {
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                g.this.d(false);
            }
        }

        g() {
        }

        private ViewPager2 a(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        void b(RecyclerView recyclerView) {
            this.f٤٥٥٤d = a(recyclerView);
            C٠٠٥٩a r22 = new C٠٠٥٩a();
            this.f٤٥٥١a = r22;
            this.f٤٥٥٤d.registerOnPageChangeCallback(r22);
            b bVar = new b();
            this.f٤٥٥٢b = bVar;
            a.this.registerAdapterDataObserver(bVar);
            c cVar = new c();
            this.f٤٥٥٣c = cVar;
            a.this.mLifecycle.addObserver(cVar);
        }

        void c(RecyclerView recyclerView) {
            a(recyclerView).unregisterOnPageChangeCallback(this.f٤٥٥١a);
            a.this.unregisterAdapterDataObserver(this.f٤٥٥٢b);
            a.this.mLifecycle.removeObserver(this.f٤٥٥٣c);
            this.f٤٥٥٤d = null;
        }

        void d(boolean z10) {
            int currentItem;
            Fragment fragment;
            boolean z11;
            if (a.this.shouldDelayFragmentTransactions() || this.f٤٥٥٤d.getScrollState() != 0 || a.this.mFragments.isEmpty() || a.this.getItemCount() == 0 || (currentItem = this.f٤٥٥٤d.getCurrentItem()) >= a.this.getItemCount()) {
                return;
            }
            long itemId = a.this.getItemId(currentItem);
            if ((itemId != this.f٤٥٥٥e || z10) && (fragment = a.this.mFragments.get(itemId)) != null && fragment.isAdded()) {
                this.f٤٥٥٥e = itemId;
                FragmentTransaction beginTransaction = a.this.mFragmentManager.beginTransaction();
                ArrayList arrayList = new ArrayList();
                Fragment fragment2 = null;
                for (int i10 = 0; i10 < a.this.mFragments.size(); i10++) {
                    long keyAt = a.this.mFragments.keyAt(i10);
                    Fragment valueAt = a.this.mFragments.valueAt(i10);
                    if (valueAt.isAdded()) {
                        if (keyAt != this.f٤٥٥٥e) {
                            Lifecycle.State state = Lifecycle.State.STARTED;
                            beginTransaction.setMaxLifecycle(valueAt, state);
                            arrayList.add(a.this.mFragmentEventDispatcher.a(valueAt, state));
                        } else {
                            fragment2 = valueAt;
                        }
                        if (keyAt == this.f٤٥٥٥e) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        valueAt.setMenuVisibility(z11);
                    }
                }
                if (fragment2 != null) {
                    Lifecycle.State state2 = Lifecycle.State.RESUMED;
                    beginTransaction.setMaxLifecycle(fragment2, state2);
                    arrayList.add(a.this.mFragmentEventDispatcher.a(fragment2, state2));
                }
                if (!beginTransaction.isEmpty()) {
                    beginTransaction.commitNow();
                    Collections.reverse(arrayList);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a.this.mFragmentEventDispatcher.b((List) it.next());
                    }
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static abstract class h {
    }

    public a(FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    private static String a(String str, long j10) {
        return str + j10;
    }

    private void b(int i10) {
        long itemId = getItemId(i10);
        if (!this.mFragments.containsKey(itemId)) {
            Fragment createFragment = createFragment(i10);
            createFragment.setInitialSavedState(this.mSavedStates.get(itemId));
            this.mFragments.put(itemId, createFragment);
        }
    }

    private boolean c(long j10) {
        View view;
        if (this.mItemIdToViewHolder.containsKey(j10)) {
            return true;
        }
        Fragment fragment = this.mFragments.get(j10);
        if (fragment != null && (view = fragment.getView()) != null && view.getParent() != null) {
            return true;
        }
        return false;
    }

    private static boolean d(String str, String str2) {
        if (str.startsWith(str2) && str.length() > str2.length()) {
            return true;
        }
        return false;
    }

    private Long e(int i10) {
        Long l10 = null;
        for (int i11 = 0; i11 < this.mItemIdToViewHolder.size(); i11++) {
            if (this.mItemIdToViewHolder.valueAt(i11).intValue() == i10) {
                if (l10 == null) {
                    l10 = Long.valueOf(this.mItemIdToViewHolder.keyAt(i11));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l10;
    }

    private static long f(String str, String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void g(long j10) {
        ViewParent parent;
        Fragment fragment = this.mFragments.get(j10);
        if (fragment == null) {
            return;
        }
        if (fragment.getView() != null && (parent = fragment.getView().getParent()) != null) {
            ((FrameLayout) parent).removeAllViews();
        }
        if (!containsItem(j10)) {
            this.mSavedStates.remove(j10);
        }
        if (!fragment.isAdded()) {
            this.mFragments.remove(j10);
            return;
        }
        if (shouldDelayFragmentTransactions()) {
            this.mHasStaleFragments = true;
            return;
        }
        if (fragment.isAdded() && containsItem(j10)) {
            List e10 = this.mFragmentEventDispatcher.e(fragment);
            Fragment.SavedState saveFragmentInstanceState = this.mFragmentManager.saveFragmentInstanceState(fragment);
            this.mFragmentEventDispatcher.b(e10);
            this.mSavedStates.put(j10, saveFragmentInstanceState);
        }
        List d10 = this.mFragmentEventDispatcher.d(fragment);
        try {
            this.mFragmentManager.beginTransaction().remove(fragment).commitNow();
            this.mFragments.remove(j10);
        } finally {
            this.mFragmentEventDispatcher.b(d10);
        }
    }

    private void h() {
        Handler handler = new Handler(Looper.getMainLooper());
        c cVar = new c();
        this.mLifecycle.addObserver(new d(handler, cVar));
        handler.postDelayed(cVar, 10000L);
    }

    private void i(Fragment fragment, FrameLayout frameLayout) {
        this.mFragmentManager.registerFragmentLifecycleCallbacks(new b(fragment, frameLayout), false);
    }

    void addViewToContainer(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() <= 1) {
            if (view.getParent() == frameLayout) {
                return;
            }
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public boolean containsItem(long j10) {
        if (j10 >= 0 && j10 < getItemCount()) {
            return true;
        }
        return false;
    }

    public abstract Fragment createFragment(int i10);

    void gcFragments() {
        if (this.mHasStaleFragments && !shouldDelayFragmentTransactions()) {
            ArraySet arraySet = new ArraySet();
            for (int i10 = 0; i10 < this.mFragments.size(); i10++) {
                long keyAt = this.mFragments.keyAt(i10);
                if (!containsItem(keyAt)) {
                    arraySet.add(Long.valueOf(keyAt));
                    this.mItemIdToViewHolder.remove(keyAt);
                }
            }
            if (!this.mIsInGracePeriod) {
                this.mHasStaleFragments = false;
                for (int i11 = 0; i11 < this.mFragments.size(); i11++) {
                    long keyAt2 = this.mFragments.keyAt(i11);
                    if (!c(keyAt2)) {
                        arraySet.add(Long.valueOf(keyAt2));
                    }
                }
            }
            Iterator<E> it = arraySet.iterator();
            while (it.hasNext()) {
                g(((Long) it.next()).longValue());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        boolean z10;
        if (this.mFragmentMaxLifecycleEnforcer == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        androidx.core.util.h.a(z10);
        g gVar = new g();
        this.mFragmentMaxLifecycleEnforcer = gVar;
        gVar.b(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.c(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(androidx.viewpager2.adapter.b bVar) {
        return true;
    }

    void placeFragmentInViewHolder(androidx.viewpager2.adapter.b bVar) {
        Fragment fragment = this.mFragments.get(bVar.getItemId());
        if (fragment != null) {
            FrameLayout b10 = bVar.b();
            View view = fragment.getView();
            if (!fragment.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            }
            if (fragment.isAdded() && view == null) {
                i(fragment, b10);
                return;
            }
            if (fragment.isAdded() && view.getParent() != null) {
                if (view.getParent() != b10) {
                    addViewToContainer(view, b10);
                    return;
                }
                return;
            }
            if (fragment.isAdded()) {
                addViewToContainer(view, b10);
                return;
            }
            if (!shouldDelayFragmentTransactions()) {
                i(fragment, b10);
                List c10 = this.mFragmentEventDispatcher.c(fragment);
                try {
                    fragment.setMenuVisibility(false);
                    this.mFragmentManager.beginTransaction().add(fragment, "f" + bVar.getItemId()).setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitNow();
                    this.mFragmentMaxLifecycleEnforcer.d(false);
                    return;
                } finally {
                    this.mFragmentEventDispatcher.b(c10);
                }
            }
            if (this.mFragmentManager.isDestroyed()) {
                return;
            }
            this.mLifecycle.addObserver(new C٠٠٥٨a(bVar));
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public void registerFragmentTransactionCallback(h hVar) {
        this.mFragmentEventDispatcher.f(hVar);
    }

    @Override // androidx.viewpager2.adapter.c
    public final void restoreState(Parcelable parcelable) {
        if (this.mSavedStates.isEmpty() && this.mFragments.isEmpty()) {
            Bundle bundle = (Bundle) parcelable;
            if (bundle.getClassLoader() == null) {
                bundle.setClassLoader(getClass().getClassLoader());
            }
            for (String str : bundle.keySet()) {
                if (d(str, KEY_PREFIX_FRAGMENT)) {
                    this.mFragments.put(f(str, KEY_PREFIX_FRAGMENT), this.mFragmentManager.getFragment(bundle, str));
                } else if (d(str, KEY_PREFIX_STATE)) {
                    long f10 = f(str, KEY_PREFIX_STATE);
                    Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                    if (containsItem(f10)) {
                        this.mSavedStates.put(f10, savedState);
                    }
                } else {
                    throw new IllegalArgumentException("Unexpected key in savedState: " + str);
                }
            }
            if (!this.mFragments.isEmpty()) {
                this.mHasStaleFragments = true;
                this.mIsInGracePeriod = true;
                gcFragments();
                h();
                return;
            }
            return;
        }
        throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
    }

    @Override // androidx.viewpager2.adapter.c
    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.mFragments.size() + this.mSavedStates.size());
        for (int i10 = 0; i10 < this.mFragments.size(); i10++) {
            long keyAt = this.mFragments.keyAt(i10);
            Fragment fragment = this.mFragments.get(keyAt);
            if (fragment != null && fragment.isAdded()) {
                this.mFragmentManager.putFragment(bundle, a(KEY_PREFIX_FRAGMENT, keyAt), fragment);
            }
        }
        for (int i11 = 0; i11 < this.mSavedStates.size(); i11++) {
            long keyAt2 = this.mSavedStates.keyAt(i11);
            if (containsItem(keyAt2)) {
                bundle.putParcelable(a(KEY_PREFIX_STATE, keyAt2), this.mSavedStates.get(keyAt2));
            }
        }
        return bundle;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void setHasStableIds(boolean z10) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    boolean shouldDelayFragmentTransactions() {
        return this.mFragmentManager.isStateSaved();
    }

    public void unregisterFragmentTransactionCallback(h hVar) {
        this.mFragmentEventDispatcher.g(hVar);
    }

    public a(Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(androidx.viewpager2.adapter.b bVar, int i10) {
        long itemId = bVar.getItemId();
        int id = bVar.b().getId();
        Long e10 = e(id);
        if (e10 != null && e10.longValue() != itemId) {
            g(e10.longValue());
            this.mItemIdToViewHolder.remove(e10.longValue());
        }
        this.mItemIdToViewHolder.put(itemId, Integer.valueOf(id));
        b(i10);
        if (d1.U(bVar.b())) {
            placeFragmentInViewHolder(bVar);
        }
        gcFragments();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final androidx.viewpager2.adapter.b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        return androidx.viewpager2.adapter.b.a(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(androidx.viewpager2.adapter.b bVar) {
        placeFragmentInViewHolder(bVar);
        gcFragments();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(androidx.viewpager2.adapter.b bVar) {
        Long e10 = e(bVar.b().getId());
        if (e10 != null) {
            g(e10.longValue());
            this.mItemIdToViewHolder.remove(e10.longValue());
        }
    }

    public a(FragmentManager fragmentManager, Lifecycle lifecycle) {
        this.mFragments = new LongSparseArray<>();
        this.mSavedStates = new LongSparseArray<>();
        this.mItemIdToViewHolder = new LongSparseArray<>();
        this.mFragmentEventDispatcher = new f();
        this.mIsInGracePeriod = false;
        this.mHasStaleFragments = false;
        this.mFragmentManager = fragmentManager;
        this.mLifecycle = lifecycle;
        super.setHasStableIds(true);
    }
}
