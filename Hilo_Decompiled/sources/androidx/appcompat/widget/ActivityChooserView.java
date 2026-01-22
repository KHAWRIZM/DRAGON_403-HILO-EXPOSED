package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.core.view.d1;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ActivityChooserView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    final f f١٢٢٤a;

    /* renamed from: b, reason: collision with root package name */
    private final g f١٢٢٥b;

    /* renamed from: c, reason: collision with root package name */
    private final View f١٢٢٦c;

    /* renamed from: d, reason: collision with root package name */
    private final Drawable f١٢٢٧d;

    /* renamed from: e, reason: collision with root package name */
    final FrameLayout f١٢٢٨e;

    /* renamed from: f, reason: collision with root package name */
    private final ImageView f١٢٢٩f;

    /* renamed from: g, reason: collision with root package name */
    final FrameLayout f١٢٣٠g;

    /* renamed from: h, reason: collision with root package name */
    private final ImageView f١٢٣١h;

    /* renamed from: i, reason: collision with root package name */
    private final int f١٢٣٢i;

    /* renamed from: j, reason: collision with root package name */
    androidx.core.view.b f١٢٣٣j;

    /* renamed from: k, reason: collision with root package name */
    final DataSetObserver f١٢٣٤k;

    /* renamed from: l, reason: collision with root package name */
    private final ViewTreeObserver.OnGlobalLayoutListener f١٢٣٥l;

    /* renamed from: m, reason: collision with root package name */
    private f0 f١٢٣٦m;

    /* renamed from: n, reason: collision with root package name */
    PopupWindow.OnDismissListener f١٢٣٧n;

    /* renamed from: o, reason: collision with root package name */
    boolean f١٢٣٨o;

    /* renamed from: p, reason: collision with root package name */
    int f١٢٣٩p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f١٢٤٠q;

    /* renamed from: r, reason: collision with root package name */
    private int f١٢٤١r;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class InnerLayout extends LinearLayout {

        /* renamed from: a, reason: collision with root package name */
        private static final int[] f١٢٤٢a = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            p0 u10 = p0.u(context, attributeSet, f١٢٤٢a);
            setBackgroundDrawable(u10.g(0));
            u10.x();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a extends DataSetObserver {
        a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.f١٢٢٤a.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            super.onInvalidated();
            ActivityChooserView.this.f١٢٢٤a.notifyDataSetInvalidated();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (ActivityChooserView.this.b()) {
                if (!ActivityChooserView.this.isShown()) {
                    ActivityChooserView.this.getListPopupWindow().dismiss();
                    return;
                }
                ActivityChooserView.this.getListPopupWindow().show();
                androidx.core.view.b bVar = ActivityChooserView.this.f١٢٣٣j;
                if (bVar != null) {
                    bVar.j(true);
                }
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class c extends View.AccessibilityDelegate {
        c() {
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            m2.g0.V0(accessibilityNodeInfo).l0(true);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class d extends e0 {
        d(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.e0
        public androidx.appcompat.view.menu.o b() {
            return ActivityChooserView.this.getListPopupWindow();
        }

        @Override // androidx.appcompat.widget.e0
        protected boolean c() {
            ActivityChooserView.this.c();
            return true;
        }

        @Override // androidx.appcompat.widget.e0
        protected boolean d() {
            ActivityChooserView.this.a();
            return true;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class e extends DataSetObserver {
        e() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            super.onChanged();
            ActivityChooserView.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class f extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private int f١٢٤٨a = 4;

        /* renamed from: b, reason: collision with root package name */
        private boolean f١٢٤٩b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f١٢٥٠c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f١٢٥١d;

        f() {
        }

        public int a() {
            throw null;
        }

        public androidx.appcompat.widget.b b() {
            return null;
        }

        public ResolveInfo c() {
            throw null;
        }

        public int d() {
            throw null;
        }

        public boolean e() {
            return this.f١٢٤٩b;
        }

        public void f(androidx.appcompat.widget.b bVar) {
            ActivityChooserView.this.f١٢٢٤a.b();
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            throw null;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            int itemViewType = getItemViewType(i10);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.f١٢٤٩b) {
                throw null;
            }
            throw null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i10) {
            if (this.f١٢٥١d && i10 == getCount() - 1) {
                return 1;
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i10);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    if (view == null || view.getId() != 1) {
                        View inflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                        inflate.setId(1);
                        ((TextView) inflate.findViewById(androidx.appcompat.R.id.title)).setText(ActivityChooserView.this.getContext().getString(androidx.appcompat.R.string.abc_activity_chooser_view_see_all));
                        return inflate;
                    }
                    return view;
                }
                throw new IllegalArgumentException();
            }
            if (view == null || view.getId() != androidx.appcompat.R.id.list_item) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(androidx.appcompat.R.id.icon);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i10);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(androidx.appcompat.R.id.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.f١٢٤٩b && i10 == 0 && this.f١٢٥٠c) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class g implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {
        g() {
        }

        private void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.f١٢٣٧n;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.f١٢٣٠g) {
                if (view == activityChooserView.f١٢٢٨e) {
                    activityChooserView.f١٢٣٨o = false;
                    activityChooserView.d(activityChooserView.f١٢٣٩p);
                    return;
                }
                throw new IllegalArgumentException();
            }
            activityChooserView.a();
            ActivityChooserView.this.f١٢٢٤a.c();
            ActivityChooserView.this.f١٢٢٤a.b();
            throw null;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            androidx.core.view.b bVar = ActivityChooserView.this.f١٢٣٣j;
            if (bVar != null) {
                bVar.j(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            int itemViewType = ((f) adapterView.getAdapter()).getItemViewType(i10);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    ActivityChooserView.this.d(Integer.MAX_VALUE);
                    return;
                }
                throw new IllegalArgumentException();
            }
            ActivityChooserView.this.a();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.f١٢٣٨o) {
                if (i10 <= 0) {
                    return;
                }
                activityChooserView.f١٢٢٤a.b();
                throw null;
            }
            activityChooserView.f١٢٢٤a.e();
            ActivityChooserView.this.f١٢٢٤a.b();
            throw null;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view == activityChooserView.f١٢٣٠g) {
                if (activityChooserView.f١٢٢٤a.getCount() > 0) {
                    ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                    activityChooserView2.f١٢٣٨o = true;
                    activityChooserView2.d(activityChooserView2.f١٢٣٩p);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public boolean a() {
        if (b()) {
            getListPopupWindow().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f١٢٣٥l);
                return true;
            }
            return true;
        }
        return true;
    }

    public boolean b() {
        return getListPopupWindow().isShowing();
    }

    public boolean c() {
        if (b() || !this.f١٢٤٠q) {
            return false;
        }
        this.f١٢٣٨o = false;
        d(this.f١٢٣٩p);
        return true;
    }

    void d(int i10) {
        this.f١٢٢٤a.b();
        throw new IllegalStateException("No data model. Did you call #setDataModel?");
    }

    void e() {
        if (this.f١٢٢٤a.getCount() > 0) {
            this.f١٢٢٨e.setEnabled(true);
        } else {
            this.f١٢٢٨e.setEnabled(false);
        }
        int a10 = this.f١٢٢٤a.a();
        int d10 = this.f١٢٢٤a.d();
        if (a10 != 1 && (a10 <= 1 || d10 <= 0)) {
            this.f١٢٣٠g.setVisibility(8);
        } else {
            this.f١٢٣٠g.setVisibility(0);
            ResolveInfo c10 = this.f١٢٢٤a.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.f١٢٣١h.setImageDrawable(c10.loadIcon(packageManager));
            if (this.f١٢٤١r != 0) {
                this.f١٢٣٠g.setContentDescription(getContext().getString(this.f١٢٤١r, c10.loadLabel(packageManager)));
            }
        }
        if (this.f١٢٣٠g.getVisibility() == 0) {
            this.f١٢٢٦c.setBackgroundDrawable(this.f١٢٢٧d);
        } else {
            this.f١٢٢٦c.setBackgroundDrawable(null);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public androidx.appcompat.widget.b getDataModel() {
        this.f١٢٢٤a.b();
        return null;
    }

    f0 getListPopupWindow() {
        if (this.f١٢٣٦m == null) {
            f0 f0Var = new f0(getContext());
            this.f١٢٣٦m = f0Var;
            f0Var.l(this.f١٢٢٤a);
            this.f١٢٣٦m.B(this);
            this.f١٢٣٦m.H(true);
            this.f١٢٣٦m.setOnItemClickListener(this.f١٢٢٥b);
            this.f١٢٣٦m.setOnDismissListener(this.f١٢٢٥b);
        }
        return this.f١٢٣٦m;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f١٢٢٤a.b();
        this.f١٢٤٠q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f١٢٢٤a.b();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f١٢٣٥l);
        }
        if (b()) {
            a();
        }
        this.f١٢٤٠q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f١٢٢٦c.layout(0, 0, i12 - i10, i13 - i11);
        if (!b()) {
            a();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        View view = this.f١٢٢٦c;
        if (this.f١٢٣٠g.getVisibility() != 0) {
            i11 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11), 1073741824);
        }
        measureChild(view, i10, i11);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setActivityChooserModel(androidx.appcompat.widget.b bVar) {
        this.f١٢٢٤a.f(bVar);
        if (b()) {
            a();
            c();
        }
    }

    public void setDefaultActionButtonContentDescription(int i10) {
        this.f١٢٤١r = i10;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i10) {
        this.f١٢٢٩f.setContentDescription(getContext().getString(i10));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f١٢٢٩f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i10) {
        this.f١٢٣٩p = i10;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.f١٢٣٧n = onDismissListener;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setProvider(androidx.core.view.b bVar) {
        this.f١٢٣٣j = bVar;
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f١٢٣٤k = new a();
        this.f١٢٣٥l = new b();
        this.f١٢٣٩p = 4;
        int[] iArr = androidx.appcompat.R.styleable.ActivityChooserView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        d1.o0(this, context, iArr, attributeSet, obtainStyledAttributes, i10, 0);
        this.f١٢٣٩p = obtainStyledAttributes.getInt(androidx.appcompat.R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        g gVar = new g();
        this.f١٢٢٥b = gVar;
        View findViewById = findViewById(androidx.appcompat.R.id.activity_chooser_view_content);
        this.f١٢٢٦c = findViewById;
        this.f١٢٢٧d = findViewById.getBackground();
        FrameLayout frameLayout = (FrameLayout) findViewById(androidx.appcompat.R.id.default_activity_button);
        this.f١٢٣٠g = frameLayout;
        frameLayout.setOnClickListener(gVar);
        frameLayout.setOnLongClickListener(gVar);
        int i11 = androidx.appcompat.R.id.image;
        this.f١٢٣١h = (ImageView) frameLayout.findViewById(i11);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(androidx.appcompat.R.id.expand_activities_button);
        frameLayout2.setOnClickListener(gVar);
        frameLayout2.setAccessibilityDelegate(new c());
        frameLayout2.setOnTouchListener(new d(frameLayout2));
        this.f١٢٢٨e = frameLayout2;
        ImageView imageView = (ImageView) frameLayout2.findViewById(i11);
        this.f١٢٢٩f = imageView;
        imageView.setImageDrawable(drawable);
        f fVar = new f();
        this.f١٢٢٤a = fVar;
        fVar.registerDataSetObserver(new e());
        Resources resources = context.getResources();
        this.f١٢٣٢i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(androidx.appcompat.R.dimen.abc_config_prefDialogWidth));
    }
}
