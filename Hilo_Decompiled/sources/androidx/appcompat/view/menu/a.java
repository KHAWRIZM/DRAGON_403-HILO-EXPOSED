package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a implements i2.b {

    /* renamed from: a, reason: collision with root package name */
    private final int f٩٢٩a;

    /* renamed from: b, reason: collision with root package name */
    private final int f٩٣٠b;

    /* renamed from: c, reason: collision with root package name */
    private final int f٩٣١c;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f٩٣٢d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f٩٣٣e;

    /* renamed from: f, reason: collision with root package name */
    private Intent f٩٣٤f;

    /* renamed from: g, reason: collision with root package name */
    private char f٩٣٥g;

    /* renamed from: i, reason: collision with root package name */
    private char f٩٣٧i;

    /* renamed from: k, reason: collision with root package name */
    private Drawable f٩٣٩k;

    /* renamed from: l, reason: collision with root package name */
    private Context f٩٤٠l;

    /* renamed from: m, reason: collision with root package name */
    private MenuItem.OnMenuItemClickListener f٩٤١m;

    /* renamed from: n, reason: collision with root package name */
    private CharSequence f٩٤٢n;

    /* renamed from: o, reason: collision with root package name */
    private CharSequence f٩٤٣o;

    /* renamed from: h, reason: collision with root package name */
    private int f٩٣٦h = 4096;

    /* renamed from: j, reason: collision with root package name */
    private int f٩٣٨j = 4096;

    /* renamed from: p, reason: collision with root package name */
    private ColorStateList f٩٤٤p = null;

    /* renamed from: q, reason: collision with root package name */
    private PorterDuff.Mode f٩٤٥q = null;

    /* renamed from: r, reason: collision with root package name */
    private boolean f٩٤٦r = false;

    /* renamed from: s, reason: collision with root package name */
    private boolean f٩٤٧s = false;

    /* renamed from: t, reason: collision with root package name */
    private int f٩٤٨t = 16;

    public a(Context context, int i10, int i11, int i12, int i13, CharSequence charSequence) {
        this.f٩٤٠l = context;
        this.f٩٢٩a = i11;
        this.f٩٣٠b = i10;
        this.f٩٣١c = i13;
        this.f٩٣٢d = charSequence;
    }

    private void c() {
        Drawable drawable = this.f٩٣٩k;
        if (drawable != null) {
            if (this.f٩٤٦r || this.f٩٤٧s) {
                Drawable r10 = h2.b.r(drawable);
                this.f٩٣٩k = r10;
                Drawable mutate = r10.mutate();
                this.f٩٣٩k = mutate;
                if (this.f٩٤٦r) {
                    h2.b.o(mutate, this.f٩٤٤p);
                }
                if (this.f٩٤٧s) {
                    h2.b.p(this.f٩٣٩k, this.f٩٤٥q);
                }
            }
        }
    }

    @Override // i2.b
    public androidx.core.view.b a() {
        return null;
    }

    @Override // i2.b
    public i2.b b(androidx.core.view.b bVar) {
        throw new UnsupportedOperationException();
    }

    @Override // i2.b, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // i2.b, android.view.MenuItem
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public i2.b setActionView(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // i2.b, android.view.MenuItem
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public i2.b setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // i2.b, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // i2.b, android.view.MenuItem
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public i2.b setShowAsActionFlags(int i10) {
        setShowAsAction(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // i2.b, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // i2.b, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.f٩٣٨j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.f٩٣٧i;
    }

    @Override // i2.b, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.f٩٤٢n;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.f٩٣٠b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.f٩٣٩k;
    }

    @Override // i2.b, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.f٩٤٤p;
    }

    @Override // i2.b, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.f٩٤٥q;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f٩٣٤f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.f٩٢٩a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // i2.b, android.view.MenuItem
    public int getNumericModifiers() {
        return this.f٩٣٦h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.f٩٣٥g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.f٩٣١c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.f٩٣٢d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f٩٣٣e;
        if (charSequence == null) {
            return this.f٩٣٢d;
        }
        return charSequence;
    }

    @Override // i2.b, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.f٩٤٣o;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // i2.b, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        if ((this.f٩٤٨t & 1) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        if ((this.f٩٤٨t & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        if ((this.f٩٤٨t & 16) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        if ((this.f٩٤٨t & 8) == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10) {
        this.f٩٣٧i = Character.toLowerCase(c10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z10) {
        this.f٩٤٨t = (z10 ? 1 : 0) | (this.f٩٤٨t & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z10) {
        int i10;
        int i11 = this.f٩٤٨t & (-3);
        if (z10) {
            i10 = 2;
        } else {
            i10 = 0;
        }
        this.f٩٤٨t = i10 | i11;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z10) {
        int i10;
        int i11 = this.f٩٤٨t & (-17);
        if (z10) {
            i10 = 16;
        } else {
            i10 = 0;
        }
        this.f٩٤٨t = i10 | i11;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.f٩٣٩k = drawable;
        c();
        return this;
    }

    @Override // i2.b, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f٩٤٤p = colorStateList;
        this.f٩٤٦r = true;
        c();
        return this;
    }

    @Override // i2.b, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f٩٤٥q = mode;
        this.f٩٤٧s = true;
        c();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f٩٣٤f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c10) {
        this.f٩٣٥g = c10;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f٩٤١m = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11) {
        this.f٩٣٥g = c10;
        this.f٩٣٧i = Character.toLowerCase(c11);
        return this;
    }

    @Override // i2.b, android.view.MenuItem
    public void setShowAsAction(int i10) {
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.f٩٣٢d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f٩٣٣e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z10) {
        int i10 = 8;
        int i11 = this.f٩٤٨t & 8;
        if (z10) {
            i10 = 0;
        }
        this.f٩٤٨t = i11 | i10;
        return this;
    }

    @Override // i2.b, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c10, int i10) {
        this.f٩٣٧i = Character.toLowerCase(c10);
        this.f٩٣٨j = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public i2.b setContentDescription(CharSequence charSequence) {
        this.f٩٤٢n = charSequence;
        return this;
    }

    @Override // i2.b, android.view.MenuItem
    public MenuItem setNumericShortcut(char c10, int i10) {
        this.f٩٣٥g = c10;
        this.f٩٣٦h = KeyEvent.normalizeMetaState(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i10) {
        this.f٩٣٢d = this.f٩٤٠l.getResources().getString(i10);
        return this;
    }

    @Override // android.view.MenuItem
    public i2.b setTooltipText(CharSequence charSequence) {
        this.f٩٤٣o = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i10) {
        this.f٩٣٩k = androidx.core.content.a.getDrawable(this.f٩٤٠l, i10);
        c();
        return this;
    }

    @Override // i2.b, android.view.MenuItem
    public MenuItem setShortcut(char c10, char c11, int i10, int i11) {
        this.f٩٣٥g = c10;
        this.f٩٣٦h = KeyEvent.normalizeMetaState(i10);
        this.f٩٣٧i = Character.toLowerCase(c11);
        this.f٩٣٨j = KeyEvent.normalizeMetaState(i11);
        return this;
    }
}
