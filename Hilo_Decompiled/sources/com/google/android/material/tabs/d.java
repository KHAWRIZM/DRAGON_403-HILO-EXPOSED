package com.google.android.material.tabs;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final TabLayout f١٠٠٥٩a;

    /* renamed from: b, reason: collision with root package name */
    private final ViewPager2 f١٠٠٦٠b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f١٠٠٦١c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f١٠٠٦٢d;

    /* renamed from: e, reason: collision with root package name */
    private final b f١٠٠٦٣e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView.Adapter f١٠٠٦٤f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f١٠٠٦٥g;

    /* renamed from: h, reason: collision with root package name */
    private c f١٠٠٦٦h;

    /* renamed from: i, reason: collision with root package name */
    private TabLayout.d f١٠٠٦٧i;

    /* renamed from: j, reason: collision with root package name */
    private RecyclerView.AdapterDataObserver f١٠٠٦٨j;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private class a extends RecyclerView.AdapterDataObserver {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            d.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i10, int i11) {
            d.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i10, int i11) {
            d.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i10, int i11, int i12) {
            d.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i10, int i11) {
            d.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i10, int i11, Object obj) {
            d.this.b();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        void a(TabLayout.f fVar, int i10);
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class c extends ViewPager2.OnPageChangeCallback {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f١٠٠٧٠a;

        /* renamed from: b, reason: collision with root package name */
        private int f١٠٠٧١b;

        /* renamed from: c, reason: collision with root package name */
        private int f١٠٠٧٢c;

        c(TabLayout tabLayout) {
            this.f١٠٠٧٠a = new WeakReference(tabLayout);
            a();
        }

        void a() {
            this.f١٠٠٧٢c = 0;
            this.f١٠٠٧١b = 0;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i10) {
            this.f١٠٠٧١b = this.f١٠٠٧٢c;
            this.f١٠٠٧٢c = i10;
            TabLayout tabLayout = (TabLayout) this.f١٠٠٧٠a.get();
            if (tabLayout != null) {
                tabLayout.updateViewPagerScrollState(this.f١٠٠٧٢c);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i10, float f10, int i11) {
            boolean z10;
            boolean z11;
            TabLayout tabLayout = (TabLayout) this.f١٠٠٧٠a.get();
            if (tabLayout != null) {
                int i12 = this.f١٠٠٧٢c;
                if (i12 == 2 && this.f١٠٠٧١b != 1) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (i12 == 2 && this.f١٠٠٧١b == 0) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                tabLayout.setScrollPosition(i10, f10, z10, z11, false);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i10) {
            boolean z10;
            TabLayout tabLayout = (TabLayout) this.f١٠٠٧٠a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i10 && i10 < tabLayout.getTabCount()) {
                int i11 = this.f١٠٠٧٢c;
                if (i11 != 0 && (i11 != 2 || this.f١٠٠٧١b != 0)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                tabLayout.selectTab(tabLayout.getTabAt(i10), z10);
            }
        }
    }

    /* renamed from: com.google.android.material.tabs.d$d, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static class C٠١٢٠d implements TabLayout.d {

        /* renamed from: a, reason: collision with root package name */
        private final ViewPager2 f١٠٠٧٣a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f١٠٠٧٤b;

        C٠١٢٠d(ViewPager2 viewPager2, boolean z10) {
            this.f١٠٠٧٣a = viewPager2;
            this.f١٠٠٧٤b = z10;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(TabLayout.f fVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(TabLayout.f fVar) {
            this.f١٠٠٧٣a.setCurrentItem(fVar.g(), this.f١٠٠٧٤b);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(TabLayout.f fVar) {
        }
    }

    public d(TabLayout tabLayout, ViewPager2 viewPager2, b bVar) {
        this(tabLayout, viewPager2, true, bVar);
    }

    public void a() {
        if (!this.f١٠٠٦٥g) {
            RecyclerView.Adapter adapter = this.f١٠٠٦٠b.getAdapter();
            this.f١٠٠٦٤f = adapter;
            if (adapter != null) {
                this.f١٠٠٦٥g = true;
                c cVar = new c(this.f١٠٠٥٩a);
                this.f١٠٠٦٦h = cVar;
                this.f١٠٠٦٠b.registerOnPageChangeCallback(cVar);
                C٠١٢٠d r12 = new C٠١٢٠d(this.f١٠٠٦٠b, this.f١٠٠٦٢d);
                this.f١٠٠٦٧i = r12;
                this.f١٠٠٥٩a.addOnTabSelectedListener((TabLayout.d) r12);
                if (this.f١٠٠٦١c) {
                    a aVar = new a();
                    this.f١٠٠٦٨j = aVar;
                    this.f١٠٠٦٤f.registerAdapterDataObserver(aVar);
                }
                b();
                this.f١٠٠٥٩a.setScrollPosition(this.f١٠٠٦٠b.getCurrentItem(), DownloadProgress.UNKNOWN_PROGRESS, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    void b() {
        this.f١٠٠٥٩a.removeAllTabs();
        RecyclerView.Adapter adapter = this.f١٠٠٦٤f;
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            for (int i10 = 0; i10 < itemCount; i10++) {
                TabLayout.f newTab = this.f١٠٠٥٩a.newTab();
                this.f١٠٠٦٣e.a(newTab, i10);
                this.f١٠٠٥٩a.addTab(newTab, false);
            }
            if (itemCount > 0) {
                int min = Math.min(this.f١٠٠٦٠b.getCurrentItem(), this.f١٠٠٥٩a.getTabCount() - 1);
                if (min != this.f١٠٠٥٩a.getSelectedTabPosition()) {
                    TabLayout tabLayout = this.f١٠٠٥٩a;
                    tabLayout.selectTab(tabLayout.getTabAt(min));
                }
            }
        }
    }

    public d(TabLayout tabLayout, ViewPager2 viewPager2, boolean z10, b bVar) {
        this(tabLayout, viewPager2, z10, true, bVar);
    }

    public d(TabLayout tabLayout, ViewPager2 viewPager2, boolean z10, boolean z11, b bVar) {
        this.f١٠٠٥٩a = tabLayout;
        this.f١٠٠٦٠b = viewPager2;
        this.f١٠٠٦١c = z10;
        this.f١٠٠٦٢d = z11;
        this.f١٠٠٦٣e = bVar;
    }
}
