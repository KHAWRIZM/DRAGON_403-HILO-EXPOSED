package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.m;
import androidx.core.view.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class i implements i2.b {
    private View A;

    /* renamed from: B, reason: collision with root package name */
    private androidx.core.view.b f١٠٤٦B;
    private MenuItem.OnActionExpandListener C;
    private ContextMenu.ContextMenuInfo E;

    /* renamed from: a, reason: collision with root package name */
    private final int f١٠٤٧a;

    /* renamed from: b, reason: collision with root package name */
    private final int f١٠٤٨b;

    /* renamed from: c, reason: collision with root package name */
    private final int f١٠٤٩c;

    /* renamed from: d, reason: collision with root package name */
    private final int f١٠٥٠d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f١٠٥١e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f١٠٥٢f;

    /* renamed from: g, reason: collision with root package name */
    private Intent f١٠٥٣g;

    /* renamed from: h, reason: collision with root package name */
    private char f١٠٥٤h;

    /* renamed from: j, reason: collision with root package name */
    private char f١٠٥٦j;

    /* renamed from: l, reason: collision with root package name */
    private Drawable f١٠٥٨l;

    /* renamed from: n, reason: collision with root package name */
    g f١٠٦٠n;

    /* renamed from: o, reason: collision with root package name */
    private q f١٠٦١o;

    /* renamed from: p, reason: collision with root package name */
    private Runnable f١٠٦٢p;

    /* renamed from: q, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f١٠٦٣q;

    /* renamed from: r, reason: collision with root package name */
    private CharSequence f١٠٦٤r;

    /* renamed from: s, reason: collision with root package name */
    private CharSequence f١٠٦٥s;

    /* renamed from: z, reason: collision with root package name */
    private int f١٠٧٢z;

    /* renamed from: i, reason: collision with root package name */
    private int f١٠٥٥i = 4096;

    /* renamed from: k, reason: collision with root package name */
    private int f١٠٥٧k = 4096;

    /* renamed from: m, reason: collision with root package name */
    private int f١٠٥٩m = 0;

    /* renamed from: t, reason: collision with root package name */
    private ColorStateList f١٠٦٦t = null;

    /* renamed from: u, reason: collision with root package name */
    private PorterDuff.Mode f١٠٦٧u = null;

    /* renamed from: v, reason: collision with root package name */
    private boolean f١٠٦٨v = false;

    /* renamed from: w, reason: collision with root package name */
    private boolean f١٠٦٩w = false;

    /* renamed from: x, reason: collision with root package name */
    private boolean f١٠٧٠x = false;

    /* renamed from: y, reason: collision with root package name */
    private int f١٠٧١y = 16;
    private boolean D = false;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements b.InterfaceC٠٠٢٧b {
        a() {
        }

        @Override // androidx.core.view.b.InterfaceC٠٠٢٧b
        public void onActionProviderVisibilityChanged(boolean z10) {
            i iVar = i.this;
            iVar.f١٠٦٠n.M(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, int i10, int i11, int i12, int i13, CharSequence charSequence, int i14) {
        this.f١٠٦٠n = gVar;
        this.f١٠٤٧a = i11;
        this.f١٠٤٨b = i10;
        this.f١٠٤٩c = i12;
        this.f١٠٥٠d = i13;
        this.f١٠٥١e = charSequence;
        this.f١٠٧٢z = i14;
    }

    private static void d(StringBuilder sb, int i10, int i11, String str) {
        if ((i10 & i11) == i11) {
            sb.append(str);
        }
    }

    private Drawable e(Drawable drawable) {
        if (drawable != null && this.f١٠٧٠x && (this.f١٠٦٨v || this.f١٠٦٩w)) {
            drawable = h2.b.r(drawable).mutate();
            if (this.f١٠٦٨v) {
                h2.b.o(drawable, this.f١٠٦٦t);
            }
            if (this.f١٠٦٩w) {
                h2.b.p(drawable, this.f١٠٦٧u);
            }
            this.f١٠٧٠x = false;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        if (this.f١٠٦٠n.K() && g() != 0) {
            return true;
        }
        return false;
    }

    public boolean B() {
        if ((this.f١٠٧٢z & 4) == 4) {
            return true;
        }
        return false;
    }

    @Override // i2.b
    public androidx.core.view.b a() {
        return this.f١٠٤٦B;
    }

    @Override // i2.b
    public i2.b b(androidx.core.view.b bVar) {
        androidx.core.view.b bVar2 = this.f١٠٤٦B;
        if (bVar2 != null) {
            bVar2.g();
        }
        this.A = null;
        this.f١٠٤٦B = bVar;
        this.f١٠٦٠n.N(true);
        androidx.core.view.b bVar3 = this.f١٠٤٦B;
        if (bVar3 != null) {
            bVar3.i(new a());
        }
        return this;
    }

    public void c() {
        this.f١٠٦٠n.L(this);
    }

    @Override // i2.b, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.f١٠٧٢z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionCollapse(this)) {
            return false;
        }
        return this.f١٠٦٠n.f(this);
    }

    @Override // i2.b, android.view.MenuItem
    public boolean expandActionView() {
        if (!j()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener != null && !onActionExpandListener.onMenuItemActionExpand(this)) {
            return false;
        }
        return this.f١٠٦٠n.m(this);
    }

    public int f() {
        return this.f١٠٥٠d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char g() {
        if (this.f١٠٦٠n.J()) {
            return this.f١٠٥٦j;
        }
        return this.f١٠٥٤h;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // i2.b, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        androidx.core.view.b bVar = this.f١٠٤٦B;
        if (bVar != null) {
            View c10 = bVar.c(this);
            this.A = c10;
            return c10;
        }
        return null;
    }

    @Override // i2.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f١٠٥٧k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f١٠٥٦j;
    }

    @Override // i2.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f١٠٦٤r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f١٠٤٨b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.f١٠٥٨l;
        if (drawable != null) {
            return e(drawable);
        }
        if (this.f١٠٥٩m != 0) {
            Drawable b10 = r1.a.b(this.f١٠٦٠n.w(), this.f١٠٥٩m);
            this.f١٠٥٩m = 0;
            this.f١٠٥٨l = b10;
            return e(b10);
        }
        return null;
    }

    @Override // i2.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f١٠٦٦t;
    }

    @Override // i2.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f١٠٦٧u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f١٠٥٣g;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f١٠٤٧a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // i2.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f١٠٥٥i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f١٠٥٤h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f١٠٤٩c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.f١٠٦١o;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f١٠٥١e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f١٠٥٢f;
        if (charSequence == null) {
            return this.f١٠٥١e;
        }
        return charSequence;
    }

    @Override // i2.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f١٠٦٥s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String h() {
        int i10;
        char g10 = g();
        if (g10 == 0) {
            return "";
        }
        Resources resources = this.f١٠٦٠n.w().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.f١٠٦٠n.w()).hasPermanentMenuKey()) {
            sb.append(resources.getString(R.string.abc_prepend_shortcut_label));
        }
        if (this.f١٠٦٠n.J()) {
            i10 = this.f١٠٥٧k;
        } else {
            i10 = this.f١٠٥٥i;
        }
        d(sb, i10, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
        d(sb, i10, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
        d(sb, i10, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
        d(sb, i10, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
        d(sb, i10, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
        d(sb, i10, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
        if (g10 != '\b') {
            if (g10 != '\n') {
                if (g10 != ' ') {
                    sb.append(g10);
                } else {
                    sb.append(resources.getString(R.string.abc_menu_space_shortcut_label));
                }
            } else {
                sb.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
            }
        } else {
            sb.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
        }
        return sb.toString();
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        if (this.f١٠٦١o != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence i(m.a aVar) {
        if (aVar != null && aVar.h()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // i2.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.f١٠٧١y & 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.f١٠٧١y & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        if ((this.f١٠٧١y & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        androidx.core.view.b bVar = this.f١٠٤٦B;
        if (bVar != null && bVar.f()) {
            if ((this.f١٠٧١y & 8) != 0 || !this.f١٠٤٦B.b()) {
                return false;
            }
            return true;
        }
        if ((this.f١٠٧١y & 8) != 0) {
            return false;
        }
        return true;
    }

    public boolean j() {
        androidx.core.view.b bVar;
        if ((this.f١٠٧٢z & 8) == 0) {
            return false;
        }
        if (this.A == null && (bVar = this.f١٠٤٦B) != null) {
            this.A = bVar.c(this);
        }
        if (this.A == null) {
            return false;
        }
        return true;
    }

    public boolean k() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.f١٠٦٣q;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        g gVar = this.f١٠٦٠n;
        if (gVar.h(gVar, this)) {
            return true;
        }
        Runnable runnable = this.f١٠٦٢p;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.f١٠٥٣g != null) {
            try {
                this.f١٠٦٠n.w().startActivity(this.f١٠٥٣g);
                return true;
            } catch (ActivityNotFoundException e10) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e10);
            }
        }
        androidx.core.view.b bVar = this.f١٠٤٦B;
        if (bVar != null && bVar.d()) {
            return true;
        }
        return false;
    }

    public boolean l() {
        if ((this.f١٠٧١y & 32) == 32) {
            return true;
        }
        return false;
    }

    public boolean m() {
        if ((this.f١٠٧١y & 4) != 0) {
            return true;
        }
        return false;
    }

    public boolean n() {
        if ((this.f١٠٧٢z & 1) == 1) {
            return true;
        }
        return false;
    }

    public boolean o() {
        if ((this.f١٠٧٢z & 2) == 2) {
            return true;
        }
        return false;
    }

    @Override // i2.b, android.view.MenuItem
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public i2.b setActionView(int i10) {
        Context w10 = this.f١٠٦٠n.w();
        setActionView(LayoutInflater.from(w10).inflate(i10, (ViewGroup) new LinearLayout(w10), false));
        return this;
    }

    @Override // i2.b, android.view.MenuItem
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public i2.b setActionView(View view) {
        int i10;
        this.A = view;
        this.f١٠٤٦B = null;
        if (view != null && view.getId() == -1 && (i10 = this.f١٠٤٧a) > 0) {
            view.setId(i10);
        }
        this.f١٠٦٠n.L(this);
        return this;
    }

    public void r(boolean z10) {
        this.D = z10;
        this.f١٠٦٠n.N(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(boolean z10) {
        int i10;
        int i11 = this.f١٠٧١y;
        int i12 = i11 & (-3);
        if (z10) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        int i13 = i10 | i12;
        this.f١٠٧١y = i13;
        if (i11 != i13) {
            this.f١٠٦٠n.N(false);
        }
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        if (this.f١٠٥٦j == c10) {
            return this;
        }
        this.f١٠٥٦j = Character.toLowerCase(c10);
        this.f١٠٦٠n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        int i10 = this.f١٠٧١y;
        int i11 = (z10 ? 1 : 0) | (i10 & (-2));
        this.f١٠٧١y = i11;
        if (i10 != i11) {
            this.f١٠٦٠n.N(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        if ((this.f١٠٧١y & 4) != 0) {
            this.f١٠٦٠n.Y(this);
        } else {
            s(z10);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        if (z10) {
            this.f١٠٧١y |= 16;
        } else {
            this.f١٠٧١y &= -17;
        }
        this.f١٠٦٠n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f١٠٥٩m = 0;
        this.f١٠٥٨l = drawable;
        this.f١٠٧٠x = true;
        this.f١٠٦٠n.N(false);
        return this;
    }

    @Override // i2.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f١٠٦٦t = colorStateList;
        this.f١٠٦٨v = true;
        this.f١٠٧٠x = true;
        this.f١٠٦٠n.N(false);
        return this;
    }

    @Override // i2.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f١٠٦٧u = mode;
        this.f١٠٦٩w = true;
        this.f١٠٧٠x = true;
        this.f١٠٦٠n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f١٠٥٣g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        if (this.f١٠٥٤h == c10) {
            return this;
        }
        this.f١٠٥٤h = c10;
        this.f١٠٦٠n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f١٠٦٣q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f١٠٥٤h = c10;
        this.f١٠٥٦j = Character.toLowerCase(c11);
        this.f١٠٦٠n.N(false);
        return this;
    }

    @Override // i2.b, android.view.MenuItem
    public void setShowAsAction(int i10) {
        int i11 = i10 & 3;
        if (i11 != 0 && i11 != 1 && i11 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.f١٠٧٢z = i10;
        this.f١٠٦٠n.L(this);
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f١٠٥١e = charSequence;
        this.f١٠٦٠n.N(false);
        q qVar = this.f١٠٦١o;
        if (qVar != null) {
            qVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f١٠٥٢f = charSequence;
        this.f١٠٦٠n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        if (y(z10)) {
            this.f١٠٦٠n.M(this);
        }
        return this;
    }

    public void t(boolean z10) {
        int i10;
        int i11 = this.f١٠٧١y & (-5);
        if (z10) {
            i10 = 4;
        } else {
            i10 = 0;
        }
        this.f١٠٧١y = i10 | i11;
    }

    public String toString() {
        CharSequence charSequence = this.f١٠٥١e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public void u(boolean z10) {
        if (z10) {
            this.f١٠٧١y |= 32;
        } else {
            this.f١٠٧١y &= -33;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.E = contextMenuInfo;
    }

    @Override // i2.b, android.view.MenuItem
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public i2.b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    public void x(q qVar) {
        this.f١٠٦١o = qVar;
        qVar.setHeaderTitle(getTitle());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean y(boolean z10) {
        int i10;
        int i11 = this.f١٠٧١y;
        int i12 = i11 & (-9);
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        int i13 = i10 | i12;
        this.f١٠٧١y = i13;
        if (i11 == i13) {
            return false;
        }
        return true;
    }

    public boolean z() {
        return this.f١٠٦٠n.C();
    }

    @Override // android.view.MenuItem
    public i2.b setContentDescription(CharSequence charSequence) {
        this.f١٠٦٤r = charSequence;
        this.f١٠٦٠n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public i2.b setTooltipText(CharSequence charSequence) {
        this.f١٠٦٥s = charSequence;
        this.f١٠٦٠n.N(false);
        return this;
    }

    @Override // i2.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        if (this.f١٠٥٦j == c10 && this.f١٠٥٧k == i10) {
            return this;
        }
        this.f١٠٥٦j = Character.toLowerCase(c10);
        this.f١٠٥٧k = KeyEvent.normalizeMetaState(i10);
        this.f١٠٦٠n.N(false);
        return this;
    }

    @Override // i2.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        if (this.f١٠٥٤h == c10 && this.f١٠٥٥i == i10) {
            return this;
        }
        this.f١٠٥٤h = c10;
        this.f١٠٥٥i = KeyEvent.normalizeMetaState(i10);
        this.f١٠٦٠n.N(false);
        return this;
    }

    @Override // i2.b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f١٠٥٤h = c10;
        this.f١٠٥٥i = KeyEvent.normalizeMetaState(i10);
        this.f١٠٥٦j = Character.toLowerCase(c11);
        this.f١٠٥٧k = KeyEvent.normalizeMetaState(i11);
        this.f١٠٦٠n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f١٠٥٨l = null;
        this.f١٠٥٩m = i10;
        this.f١٠٧٠x = true;
        this.f١٠٦٠n.N(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        return setTitle(this.f١٠٦٠n.w().getString(i10));
    }
}
