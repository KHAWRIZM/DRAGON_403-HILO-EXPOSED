package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.b;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ActionMenuPresenter extends androidx.appcompat.view.menu.b implements b.a {
    c A;

    /* renamed from: B, reason: collision with root package name */
    private b f١١٧٨B;
    final e C;
    int D;

    /* renamed from: k, reason: collision with root package name */
    OverflowMenuButton f١١٧٩k;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f١١٨٠l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f١١٨١m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f١١٨٢n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f١١٨٣o;

    /* renamed from: p, reason: collision with root package name */
    private int f١١٨٤p;

    /* renamed from: q, reason: collision with root package name */
    private int f١١٨٥q;

    /* renamed from: r, reason: collision with root package name */
    private int f١١٨٦r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f١١٨٧s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f١١٨٨t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f١١٨٩u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f١١٩٠v;

    /* renamed from: w, reason: collision with root package name */
    private int f١١٩١w;

    /* renamed from: x, reason: collision with root package name */
    private final SparseBooleanArray f١١٩٢x;

    /* renamed from: y, reason: collision with root package name */
    d f١١٩٣y;

    /* renamed from: z, reason: collision with root package name */
    a f١١٩٤z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.a {

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a extends e0 {

            /* renamed from: j, reason: collision with root package name */
            final /* synthetic */ ActionMenuPresenter f١١٩٦j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.f١١٩٦j = actionMenuPresenter;
            }

            @Override // androidx.appcompat.widget.e0
            public androidx.appcompat.view.menu.o b() {
                d dVar = ActionMenuPresenter.this.f١١٩٣y;
                if (dVar == null) {
                    return null;
                }
                return dVar.c();
            }

            @Override // androidx.appcompat.widget.e0
            public boolean c() {
                ActionMenuPresenter.this.N();
                return true;
            }

            @Override // androidx.appcompat.widget.e0
            public boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.A != null) {
                    return false;
                }
                actionMenuPresenter.E();
                return true;
            }
        }

        public OverflowMenuButton(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            u0.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean c() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean e() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.N();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                h2.b.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public int f١١٩٨a;

        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
        class a implements Parcelable.Creator {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f١١٩٨a);
        }

        SavedState(Parcel parcel) {
            this.f١١٩٨a = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class a extends androidx.appcompat.view.menu.k {
        public a(Context context, androidx.appcompat.view.menu.q qVar, View view) {
            super(context, qVar, view, false, R.attr.actionOverflowMenuStyle);
            if (!((androidx.appcompat.view.menu.i) qVar.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.f١١٧٩k;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f٩٥٧i : view2);
            }
            i(ActionMenuPresenter.this.C);
        }

        @Override // androidx.appcompat.view.menu.k
        protected void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f١١٩٤z = null;
            actionMenuPresenter.D = 0;
            super.e();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.o a() {
            a aVar = ActionMenuPresenter.this.f١١٩٤z;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private d f١٢٠١a;

        public c(d dVar) {
            this.f١٢٠١a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f٩٥١c != null) {
                ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f٩٥١c.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f٩٥٧i;
            if (view != null && view.getWindowToken() != null && this.f١٢٠١a.l()) {
                ActionMenuPresenter.this.f١١٩٣y = this.f١٢٠١a;
            }
            ActionMenuPresenter.this.A = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class d extends androidx.appcompat.view.menu.k {
        public d(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z10) {
            super(context, gVar, view, z10, R.attr.actionOverflowMenuStyle);
            h(8388613);
            i(ActionMenuPresenter.this.C);
        }

        @Override // androidx.appcompat.view.menu.k
        protected void e() {
            if (((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f٩٥١c != null) {
                ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f٩٥١c.close();
            }
            ActionMenuPresenter.this.f١١٩٣y = null;
            super.e();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private class e implements l.a {
        e() {
        }

        @Override // androidx.appcompat.view.menu.l.a
        public void a(androidx.appcompat.view.menu.g gVar, boolean z10) {
            if (gVar instanceof androidx.appcompat.view.menu.q) {
                gVar.F().e(false);
            }
            l.a p10 = ActionMenuPresenter.this.p();
            if (p10 != null) {
                p10.a(gVar, z10);
            }
        }

        @Override // androidx.appcompat.view.menu.l.a
        public boolean b(androidx.appcompat.view.menu.g gVar) {
            if (gVar == ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f٩٥١c) {
                return false;
            }
            ActionMenuPresenter.this.D = ((androidx.appcompat.view.menu.q) gVar).getItem().getItemId();
            l.a p10 = ActionMenuPresenter.this.p();
            if (p10 == null) {
                return false;
            }
            return p10.b(gVar);
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
        this.f١١٩٢x = new SparseBooleanArray();
        this.C = new e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View C(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f٩٥٧i;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof m.a) && ((m.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean B() {
        return E() | F();
    }

    public Drawable D() {
        OverflowMenuButton overflowMenuButton = this.f١١٧٩k;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (this.f١١٨١m) {
            return this.f١١٨٠l;
        }
        return null;
    }

    public boolean E() {
        Object obj;
        c cVar = this.A;
        if (cVar != null && (obj = this.f٩٥٧i) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.A = null;
            return true;
        }
        d dVar = this.f١١٩٣y;
        if (dVar != null) {
            dVar.b();
            return true;
        }
        return false;
    }

    public boolean F() {
        a aVar = this.f١١٩٤z;
        if (aVar != null) {
            aVar.b();
            return true;
        }
        return false;
    }

    public boolean G() {
        if (this.A == null && !H()) {
            return false;
        }
        return true;
    }

    public boolean H() {
        d dVar = this.f١١٩٣y;
        if (dVar != null && dVar.d()) {
            return true;
        }
        return false;
    }

    public void I(Configuration configuration) {
        if (!this.f١١٨٧s) {
            this.f١١٨٦r = androidx.appcompat.view.a.b(this.f٩٥٠b).d();
        }
        androidx.appcompat.view.menu.g gVar = this.f٩٥١c;
        if (gVar != null) {
            gVar.N(true);
        }
    }

    public void J(boolean z10) {
        this.f١١٩٠v = z10;
    }

    public void K(ActionMenuView actionMenuView) {
        this.f٩٥٧i = actionMenuView;
        actionMenuView.b(this.f٩٥١c);
    }

    public void L(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.f١١٧٩k;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
        } else {
            this.f١١٨١m = true;
            this.f١١٨٠l = drawable;
        }
    }

    public void M(boolean z10) {
        this.f١١٨٢n = z10;
        this.f١١٨٣o = true;
    }

    public boolean N() {
        androidx.appcompat.view.menu.g gVar;
        if (this.f١١٨٢n && !H() && (gVar = this.f٩٥١c) != null && this.f٩٥٧i != null && this.A == null && !gVar.B().isEmpty()) {
            c cVar = new c(new d(this.f٩٥٠b, this.f٩٥١c, this.f١١٧٩k, true));
            this.A = cVar;
            ((View) this.f٩٥٧i).post(cVar);
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.l
    public void a(androidx.appcompat.view.menu.g gVar, boolean z10) {
        B();
        super.a(gVar, z10);
    }

    @Override // androidx.appcompat.view.menu.l
    public void d(Parcelable parcelable) {
        int i10;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i10 = ((SavedState) parcelable).f١١٩٨a) > 0 && (findItem = this.f٩٥١c.findItem(i10)) != null) {
            e((androidx.appcompat.view.menu.q) findItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.l
    public boolean e(androidx.appcompat.view.menu.q qVar) {
        boolean z10 = false;
        if (!qVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.q qVar2 = qVar;
        while (qVar2.j0() != this.f٩٥١c) {
            qVar2 = (androidx.appcompat.view.menu.q) qVar2.j0();
        }
        View C = C(qVar2.getItem());
        if (C == null) {
            return false;
        }
        this.D = qVar.getItem().getItemId();
        int size = qVar.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            MenuItem item = qVar.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i10++;
        }
        a aVar = new a(this.f٩٥٠b, qVar, C);
        this.f١١٩٤z = aVar;
        aVar.g(z10);
        this.f١١٩٤z.j();
        super.e(qVar);
        return true;
    }

    @Override // androidx.core.view.b.a
    public void f(boolean z10) {
        if (z10) {
            super.e(null);
            return;
        }
        androidx.appcompat.view.menu.g gVar = this.f٩٥١c;
        if (gVar != null) {
            gVar.e(false);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public Parcelable g() {
        SavedState savedState = new SavedState();
        savedState.f١١٩٨a = this.D;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.l
    public void h(boolean z10) {
        ArrayList arrayList;
        super.h(z10);
        ((View) this.f٩٥٧i).requestLayout();
        androidx.appcompat.view.menu.g gVar = this.f٩٥١c;
        boolean z11 = false;
        if (gVar != null) {
            ArrayList u10 = gVar.u();
            int size = u10.size();
            for (int i10 = 0; i10 < size; i10++) {
                androidx.core.view.b a10 = ((androidx.appcompat.view.menu.i) u10.get(i10)).a();
                if (a10 != null) {
                    a10.h(this);
                }
            }
        }
        androidx.appcompat.view.menu.g gVar2 = this.f٩٥١c;
        if (gVar2 != null) {
            arrayList = gVar2.B();
        } else {
            arrayList = null;
        }
        if (this.f١١٨٢n && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z11 = !((androidx.appcompat.view.menu.i) arrayList.get(0)).isActionViewExpanded();
            } else if (size2 > 0) {
                z11 = true;
            }
        }
        if (z11) {
            if (this.f١١٧٩k == null) {
                this.f١١٧٩k = new OverflowMenuButton(this.f٩٤٩a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f١١٧٩k.getParent();
            if (viewGroup != this.f٩٥٧i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f١١٧٩k);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f٩٥٧i;
                actionMenuView.addView(this.f١١٧٩k, actionMenuView.n());
            }
        } else {
            OverflowMenuButton overflowMenuButton = this.f١١٧٩k;
            if (overflowMenuButton != null) {
                Object parent = overflowMenuButton.getParent();
                Object obj = this.f٩٥٧i;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f١١٧٩k);
                }
            }
        }
        ((ActionMenuView) this.f٩٥٧i).setOverflowReserved(this.f١١٨٢n);
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean i() {
        ArrayList arrayList;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z10;
        boolean z11;
        ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.g gVar = actionMenuPresenter.f٩٥١c;
        View view = null;
        int i14 = 0;
        if (gVar != null) {
            arrayList = gVar.G();
            i10 = arrayList.size();
        } else {
            arrayList = null;
            i10 = 0;
        }
        int i15 = actionMenuPresenter.f١١٨٦r;
        int i16 = actionMenuPresenter.f١١٨٥q;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f٩٥٧i;
        boolean z12 = false;
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < i10; i19++) {
            androidx.appcompat.view.menu.i iVar = (androidx.appcompat.view.menu.i) arrayList.get(i19);
            if (iVar.o()) {
                i17++;
            } else if (iVar.n()) {
                i18++;
            } else {
                z12 = true;
            }
            if (actionMenuPresenter.f١١٩٠v && iVar.isActionViewExpanded()) {
                i15 = 0;
            }
        }
        if (actionMenuPresenter.f١١٨٢n && (z12 || i18 + i17 > i15)) {
            i15--;
        }
        int i20 = i15 - i17;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f١١٩٢x;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f١١٨٨t) {
            int i21 = actionMenuPresenter.f١١٩١w;
            i12 = i16 / i21;
            i11 = i21 + ((i16 % i21) / i12);
        } else {
            i11 = 0;
            i12 = 0;
        }
        int i22 = 0;
        int i23 = 0;
        while (i22 < i10) {
            androidx.appcompat.view.menu.i iVar2 = (androidx.appcompat.view.menu.i) arrayList.get(i22);
            if (iVar2.o()) {
                View q10 = actionMenuPresenter.q(iVar2, view, viewGroup);
                if (actionMenuPresenter.f١١٨٨t) {
                    i12 -= ActionMenuView.t(q10, i11, i12, makeMeasureSpec, i14);
                } else {
                    q10.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = q10.getMeasuredWidth();
                i16 -= measuredWidth;
                if (i23 == 0) {
                    i23 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.u(true);
                i13 = i10;
            } else if (iVar2.n()) {
                int groupId2 = iVar2.getGroupId();
                boolean z13 = sparseBooleanArray.get(groupId2);
                if ((i20 > 0 || z13) && i16 > 0 && (!actionMenuPresenter.f١١٨٨t || i12 > 0)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                boolean z14 = z10;
                i13 = i10;
                if (z10) {
                    View q11 = actionMenuPresenter.q(iVar2, null, viewGroup);
                    if (actionMenuPresenter.f١١٨٨t) {
                        int t10 = ActionMenuView.t(q11, i11, i12, makeMeasureSpec, 0);
                        i12 -= t10;
                        if (t10 == 0) {
                            z14 = false;
                        }
                    } else {
                        q11.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z15 = z14;
                    int measuredWidth2 = q11.getMeasuredWidth();
                    i16 -= measuredWidth2;
                    if (i23 == 0) {
                        i23 = measuredWidth2;
                    }
                    if (!actionMenuPresenter.f١١٨٨t ? i16 + i23 > 0 : i16 >= 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    z10 = z15 & z11;
                }
                if (z10 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z13) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i24 = 0; i24 < i22; i24++) {
                        androidx.appcompat.view.menu.i iVar3 = (androidx.appcompat.view.menu.i) arrayList.get(i24);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.l()) {
                                i20++;
                            }
                            iVar3.u(false);
                        }
                    }
                }
                if (z10) {
                    i20--;
                }
                iVar2.u(z10);
            } else {
                i13 = i10;
                iVar2.u(false);
                i22++;
                view = null;
                actionMenuPresenter = this;
                i10 = i13;
                i14 = 0;
            }
            i22++;
            view = null;
            actionMenuPresenter = this;
            i10 = i13;
            i14 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.l
    public void k(Context context, androidx.appcompat.view.menu.g gVar) {
        super.k(context, gVar);
        Resources resources = context.getResources();
        androidx.appcompat.view.a b10 = androidx.appcompat.view.a.b(context);
        if (!this.f١١٨٣o) {
            this.f١١٨٢n = b10.h();
        }
        if (!this.f١١٨٩u) {
            this.f١١٨٤p = b10.c();
        }
        if (!this.f١١٨٧s) {
            this.f١١٨٦r = b10.d();
        }
        int i10 = this.f١١٨٤p;
        if (this.f١١٨٢n) {
            if (this.f١١٧٩k == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.f٩٤٩a);
                this.f١١٧٩k = overflowMenuButton;
                if (this.f١١٨١m) {
                    overflowMenuButton.setImageDrawable(this.f١١٨٠l);
                    this.f١١٨٠l = null;
                    this.f١١٨١m = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f١١٧٩k.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i10 -= this.f١١٧٩k.getMeasuredWidth();
        } else {
            this.f١١٧٩k = null;
        }
        this.f١١٨٥q = i10;
        this.f١١٩١w = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.b
    public void m(androidx.appcompat.view.menu.i iVar, m.a aVar) {
        aVar.g(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f٩٥٧i);
        if (this.f١١٧٨B == null) {
            this.f١١٧٨B = new b();
        }
        actionMenuItemView.setPopupCallback(this.f١١٧٨B);
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean o(ViewGroup viewGroup, int i10) {
        if (viewGroup.getChildAt(i10) == this.f١١٧٩k) {
            return false;
        }
        return super.o(viewGroup, i10);
    }

    @Override // androidx.appcompat.view.menu.b
    public View q(androidx.appcompat.view.menu.i iVar, View view, ViewGroup viewGroup) {
        int i10;
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.j()) {
            actionView = super.q(iVar, view, viewGroup);
        }
        if (iVar.isActionViewExpanded()) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        actionView.setVisibility(i10);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.m r(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.m mVar = this.f٩٥٧i;
        androidx.appcompat.view.menu.m r10 = super.r(viewGroup);
        if (mVar != r10) {
            ((ActionMenuView) r10).setPresenter(this);
        }
        return r10;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean t(int i10, androidx.appcompat.view.menu.i iVar) {
        return iVar.l();
    }
}
