package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.c0;
import androidx.appcompat.widget.p0;
import androidx.core.view.a0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    static final Class[] f٨٤١e;

    /* renamed from: f, reason: collision with root package name */
    static final Class[] f٨٤٢f;

    /* renamed from: a, reason: collision with root package name */
    final Object[] f٨٤٣a;

    /* renamed from: b, reason: collision with root package name */
    final Object[] f٨٤٤b;

    /* renamed from: c, reason: collision with root package name */
    Context f٨٤٥c;

    /* renamed from: d, reason: collision with root package name */
    private Object f٨٤٦d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: c, reason: collision with root package name */
        private static final Class[] f٨٤٧c = {MenuItem.class};

        /* renamed from: a, reason: collision with root package name */
        private Object f٨٤٨a;

        /* renamed from: b, reason: collision with root package name */
        private Method f٨٤٩b;

        public a(Object obj, String str) {
            this.f٨٤٨a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f٨٤٩b = cls.getMethod(str, f٨٤٧c);
            } catch (Exception e10) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e10);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f٨٤٩b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f٨٤٩b.invoke(this.f٨٤٨a, menuItem)).booleanValue();
                }
                this.f٨٤٩b.invoke(this.f٨٤٨a, menuItem);
                return true;
            } catch (Exception e10) {
                throw new RuntimeException(e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public class b {
        androidx.core.view.b A;

        /* renamed from: B, reason: collision with root package name */
        private CharSequence f٨٥٠B;
        private CharSequence C;
        private ColorStateList D = null;
        private PorterDuff.Mode E = null;

        /* renamed from: a, reason: collision with root package name */
        private Menu f٨٥١a;

        /* renamed from: b, reason: collision with root package name */
        private int f٨٥٢b;

        /* renamed from: c, reason: collision with root package name */
        private int f٨٥٣c;

        /* renamed from: d, reason: collision with root package name */
        private int f٨٥٤d;

        /* renamed from: e, reason: collision with root package name */
        private int f٨٥٥e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f٨٥٦f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f٨٥٧g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f٨٥٨h;

        /* renamed from: i, reason: collision with root package name */
        private int f٨٥٩i;

        /* renamed from: j, reason: collision with root package name */
        private int f٨٦٠j;

        /* renamed from: k, reason: collision with root package name */
        private CharSequence f٨٦١k;

        /* renamed from: l, reason: collision with root package name */
        private CharSequence f٨٦٢l;

        /* renamed from: m, reason: collision with root package name */
        private int f٨٦٣m;

        /* renamed from: n, reason: collision with root package name */
        private char f٨٦٤n;

        /* renamed from: o, reason: collision with root package name */
        private int f٨٦٥o;

        /* renamed from: p, reason: collision with root package name */
        private char f٨٦٦p;

        /* renamed from: q, reason: collision with root package name */
        private int f٨٦٧q;

        /* renamed from: r, reason: collision with root package name */
        private int f٨٦٨r;

        /* renamed from: s, reason: collision with root package name */
        private boolean f٨٦٩s;

        /* renamed from: t, reason: collision with root package name */
        private boolean f٨٧٠t;

        /* renamed from: u, reason: collision with root package name */
        private boolean f٨٧١u;

        /* renamed from: v, reason: collision with root package name */
        private int f٨٧٢v;

        /* renamed from: w, reason: collision with root package name */
        private int f٨٧٣w;

        /* renamed from: x, reason: collision with root package name */
        private String f٨٧٤x;

        /* renamed from: y, reason: collision with root package name */
        private String f٨٧٥y;

        /* renamed from: z, reason: collision with root package name */
        private String f٨٧٦z;

        public b(Menu menu) {
            this.f٨٥١a = menu;
            h();
        }

        private char c(String str) {
            if (str == null) {
                return (char) 0;
            }
            return str.charAt(0);
        }

        private Object e(String str, Class[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f٨٤٥c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e10) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e10);
                return null;
            }
        }

        private void i(MenuItem menuItem) {
            boolean z10;
            MenuItem enabled = menuItem.setChecked(this.f٨٦٩s).setVisible(this.f٨٧٠t).setEnabled(this.f٨٧١u);
            boolean z11 = false;
            if (this.f٨٦٨r >= 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            enabled.setCheckable(z10).setTitleCondensed(this.f٨٦٢l).setIcon(this.f٨٦٣m);
            int i10 = this.f٨٧٢v;
            if (i10 >= 0) {
                menuItem.setShowAsAction(i10);
            }
            if (this.f٨٧٦z != null) {
                if (!g.this.f٨٤٥c.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.b(), this.f٨٧٦z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.f٨٦٨r >= 2) {
                if (menuItem instanceof androidx.appcompat.view.menu.i) {
                    ((androidx.appcompat.view.menu.i) menuItem).t(true);
                } else if (menuItem instanceof MenuItemWrapperICS) {
                    ((MenuItemWrapperICS) menuItem).h(true);
                }
            }
            String str = this.f٨٧٤x;
            if (str != null) {
                menuItem.setActionView((View) e(str, g.f٨٤١e, g.this.f٨٤٣a));
                z11 = true;
            }
            int i11 = this.f٨٧٣w;
            if (i11 > 0) {
                if (!z11) {
                    menuItem.setActionView(i11);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            androidx.core.view.b bVar = this.A;
            if (bVar != null) {
                a0.a(menuItem, bVar);
            }
            a0.c(menuItem, this.f٨٥٠B);
            a0.g(menuItem, this.C);
            a0.b(menuItem, this.f٨٦٤n, this.f٨٦٥o);
            a0.f(menuItem, this.f٨٦٦p, this.f٨٦٧q);
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                a0.e(menuItem, mode);
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                a0.d(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f٨٥٨h = true;
            i(this.f٨٥١a.add(this.f٨٥٢b, this.f٨٥٩i, this.f٨٦٠j, this.f٨٦١k));
        }

        public SubMenu b() {
            this.f٨٥٨h = true;
            SubMenu addSubMenu = this.f٨٥١a.addSubMenu(this.f٨٥٢b, this.f٨٥٩i, this.f٨٦٠j, this.f٨٦١k);
            i(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f٨٥٨h;
        }

        public void f(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f٨٤٥c.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f٨٥٢b = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.f٨٥٣c = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f٨٥٤d = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f٨٥٥e = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f٨٥٦f = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.f٨٥٧g = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void g(AttributeSet attributeSet) {
            boolean z10;
            p0 u10 = p0.u(g.this.f٨٤٥c, attributeSet, R.styleable.MenuItem);
            this.f٨٥٩i = u10.n(R.styleable.MenuItem_android_id, 0);
            this.f٨٦٠j = (u10.k(R.styleable.MenuItem_android_menuCategory, this.f٨٥٣c) & (-65536)) | (u10.k(R.styleable.MenuItem_android_orderInCategory, this.f٨٥٤d) & 65535);
            this.f٨٦١k = u10.p(R.styleable.MenuItem_android_title);
            this.f٨٦٢l = u10.p(R.styleable.MenuItem_android_titleCondensed);
            this.f٨٦٣m = u10.n(R.styleable.MenuItem_android_icon, 0);
            this.f٨٦٤n = c(u10.o(R.styleable.MenuItem_android_alphabeticShortcut));
            this.f٨٦٥o = u10.k(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.f٨٦٦p = c(u10.o(R.styleable.MenuItem_android_numericShortcut));
            this.f٨٦٧q = u10.k(R.styleable.MenuItem_numericModifiers, 4096);
            int i10 = R.styleable.MenuItem_android_checkable;
            if (u10.s(i10)) {
                this.f٨٦٨r = u10.a(i10, false) ? 1 : 0;
            } else {
                this.f٨٦٨r = this.f٨٥٥e;
            }
            this.f٨٦٩s = u10.a(R.styleable.MenuItem_android_checked, false);
            this.f٨٧٠t = u10.a(R.styleable.MenuItem_android_visible, this.f٨٥٦f);
            this.f٨٧١u = u10.a(R.styleable.MenuItem_android_enabled, this.f٨٥٧g);
            this.f٨٧٢v = u10.k(R.styleable.MenuItem_showAsAction, -1);
            this.f٨٧٦z = u10.o(R.styleable.MenuItem_android_onClick);
            this.f٨٧٣w = u10.n(R.styleable.MenuItem_actionLayout, 0);
            this.f٨٧٤x = u10.o(R.styleable.MenuItem_actionViewClass);
            String o10 = u10.o(R.styleable.MenuItem_actionProviderClass);
            this.f٨٧٥y = o10;
            if (o10 != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10 && this.f٨٧٣w == 0 && this.f٨٧٤x == null) {
                this.A = (androidx.core.view.b) e(o10, g.f٨٤٢f, g.this.f٨٤٤b);
            } else {
                if (z10) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.A = null;
            }
            this.f٨٥٠B = u10.p(R.styleable.MenuItem_contentDescription);
            this.C = u10.p(R.styleable.MenuItem_tooltipText);
            int i11 = R.styleable.MenuItem_iconTintMode;
            if (u10.s(i11)) {
                this.E = c0.e(u10.k(i11, -1), this.E);
            } else {
                this.E = null;
            }
            int i12 = R.styleable.MenuItem_iconTint;
            if (u10.s(i12)) {
                this.D = u10.c(i12);
            } else {
                this.D = null;
            }
            u10.x();
            this.f٨٥٨h = false;
        }

        public void h() {
            this.f٨٥٢b = 0;
            this.f٨٥٣c = 0;
            this.f٨٥٤d = 0;
            this.f٨٥٥e = 0;
            this.f٨٥٦f = true;
            this.f٨٥٧g = true;
        }
    }

    static {
        Class[] clsArr = {Context.class};
        f٨٤١e = clsArr;
        f٨٤٢f = clsArr;
    }

    public g(Context context) {
        super(context);
        this.f٨٤٥c = context;
        Object[] objArr = {context};
        this.f٨٤٣a = objArr;
        this.f٨٤٤b = objArr;
    }

    private Object a(Object obj) {
        if (obj instanceof Activity) {
            return obj;
        }
        if (obj instanceof ContextWrapper) {
            return a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0048, code lost:
    
        if (r15 == 2) goto L٤١;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        if (r15 == 3) goto L٢٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        if (r7 == false) goto L٢٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        if (r15.equals(r8) == false) goto L٢٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
    
        r8 = null;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00b9, code lost:
    
        r15 = r13.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0062, code lost:
    
        if (r15.equals("group") == false) goto L٢٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        r0.h();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
    
        if (r15.equals("item") == false) goto L٣٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r0.d() != false) goto L٦٥;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        r15 = r0.A;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        if (r15 == null) goto L٣٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
    
        if (r15.a() == false) goto L٣٧;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007e, code lost:
    
        r0.b();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
    
        r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
    
        if (r15.equals("menu") == false) goto L٦٨;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008c, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008e, code lost:
    
        if (r7 == false) goto L٤٣;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
    
        r15 = r13.getName();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0099, code lost:
    
        if (r15.equals("group") == false) goto L٤٦;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009b, code lost:
    
        r0.f(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
    
        if (r15.equals("item") == false) goto L٤٩;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a5, code lost:
    
        r0.g(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ad, code lost:
    
        if (r15.equals("menu") == false) goto L٥٢;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00af, code lost:
    
        c(r13, r14, r0.b());
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b7, code lost:
    
        r8 = r15;
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c5, code lost:
    
        throw new java.lang.RuntimeException("Unexpected end of document");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00c6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003b, code lost:
    
        r8 = null;
        r6 = false;
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        if (r6 != false) goto L٦٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        if (r15 == 1) goto L٦١;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
    }

    Object b() {
        if (this.f٨٤٦d == null) {
            this.f٨٤٦d = a(this.f٨٤٥c);
        }
        return this.f٨٤٦d;
    }

    @Override // android.view.MenuInflater
    public void inflate(int i10, Menu menu) {
        if (!(menu instanceof i2.a)) {
            super.inflate(i10, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        boolean z10 = false;
        try {
            try {
                xmlResourceParser = this.f٨٤٥c.getResources().getLayout(i10);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
                if (menu instanceof androidx.appcompat.view.menu.g) {
                    androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) menu;
                    if (gVar.H()) {
                        gVar.i0();
                        z10 = true;
                    }
                }
                c(xmlResourceParser, asAttributeSet, menu);
                if (z10) {
                    ((androidx.appcompat.view.menu.g) menu).h0();
                }
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (IOException e10) {
                throw new InflateException("Error inflating menu XML", e10);
            } catch (XmlPullParserException e11) {
                throw new InflateException("Error inflating menu XML", e11);
            }
        } catch (Throwable th) {
            if (z10) {
                ((androidx.appcompat.view.menu.g) menu).h0();
            }
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
