package m2;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.amazonaws.services.s3.internal.Constants;
import com.liulishuo.okdownload.DownloadTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import m2.j0;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class g0 {

    /* renamed from: d, reason: collision with root package name */
    private static int f١٥٩٢١d;

    /* renamed from: a, reason: collision with root package name */
    private final AccessibilityNodeInfo f١٥٩٢٢a;

    /* renamed from: b, reason: collision with root package name */
    public int f١٥٩٢٣b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f١٥٩٢٤c = -1;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class a {
        public static final a A;

        /* renamed from: B, reason: collision with root package name */
        public static final a f١٥٩٢٥B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;
        public static final a Q;
        public static final a R;
        public static final a S;
        public static final a T;
        public static final a U;
        public static final a V;

        /* renamed from: e, reason: collision with root package name */
        public static final a f١٥٩٢٦e = new a(1, null);

        /* renamed from: f, reason: collision with root package name */
        public static final a f١٥٩٢٧f = new a(2, null);

        /* renamed from: g, reason: collision with root package name */
        public static final a f١٥٩٢٨g = new a(4, null);

        /* renamed from: h, reason: collision with root package name */
        public static final a f١٥٩٢٩h = new a(8, null);

        /* renamed from: i, reason: collision with root package name */
        public static final a f١٥٩٣٠i = new a(16, null);

        /* renamed from: j, reason: collision with root package name */
        public static final a f١٥٩٣١j = new a(32, null);

        /* renamed from: k, reason: collision with root package name */
        public static final a f١٥٩٣٢k = new a(64, null);

        /* renamed from: l, reason: collision with root package name */
        public static final a f١٥٩٣٣l = new a(128, null);

        /* renamed from: m, reason: collision with root package name */
        public static final a f١٥٩٣٤m = new a(256, (CharSequence) null, j0.b.class);

        /* renamed from: n, reason: collision with root package name */
        public static final a f١٥٩٣٥n = new a(512, (CharSequence) null, j0.b.class);

        /* renamed from: o, reason: collision with root package name */
        public static final a f١٥٩٣٦o = new a(1024, (CharSequence) null, j0.c.class);

        /* renamed from: p, reason: collision with root package name */
        public static final a f١٥٩٣٧p = new a(2048, (CharSequence) null, j0.c.class);

        /* renamed from: q, reason: collision with root package name */
        public static final a f١٥٩٣٨q = new a(4096, null);

        /* renamed from: r, reason: collision with root package name */
        public static final a f١٥٩٣٩r = new a(8192, null);

        /* renamed from: s, reason: collision with root package name */
        public static final a f١٥٩٤٠s = new a(DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE, null);

        /* renamed from: t, reason: collision with root package name */
        public static final a f١٥٩٤١t = new a(32768, null);

        /* renamed from: u, reason: collision with root package name */
        public static final a f١٥٩٤٢u = new a(65536, null);

        /* renamed from: v, reason: collision with root package name */
        public static final a f١٥٩٤٣v = new a(anetwork.channel.unified.e.MAX_RSP_BUFFER_LENGTH, (CharSequence) null, j0.g.class);

        /* renamed from: w, reason: collision with root package name */
        public static final a f١٥٩٤٤w = new a(262144, null);

        /* renamed from: x, reason: collision with root package name */
        public static final a f١٥٩٤٥x = new a(anet.channel.bytes.a.MAX_POOL_SIZE, null);

        /* renamed from: y, reason: collision with root package name */
        public static final a f١٥٩٤٦y = new a(Constants.MB, null);

        /* renamed from: z, reason: collision with root package name */
        public static final a f١٥٩٤٧z = new a(2097152, (CharSequence) null, j0.h.class);

        /* renamed from: a, reason: collision with root package name */
        final Object f١٥٩٤٨a;

        /* renamed from: b, reason: collision with root package name */
        private final int f١٥٩٤٩b;

        /* renamed from: c, reason: collision with root package name */
        private final Class f١٥٩٥٠c;

        /* renamed from: d, reason: collision with root package name */
        protected final j0 f١٥٩٥١d;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction20;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction21;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction22;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction23;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction24;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction25;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction26;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction27;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction28;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction29;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction30;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction31;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction32;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction33;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction34;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction35;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction36;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction37;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction38;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction39;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction40;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction41;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction42;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction43 = null;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 23) {
                accessibilityAction42 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
                accessibilityAction = accessibilityAction42;
            } else {
                accessibilityAction = null;
            }
            A = new a(accessibilityAction, R.id.accessibilityActionShowOnScreen, null, null, null);
            if (i10 >= 23) {
                accessibilityAction41 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
                accessibilityAction2 = accessibilityAction41;
            } else {
                accessibilityAction2 = null;
            }
            f١٥٩٢٥B = new a(accessibilityAction2, R.id.accessibilityActionScrollToPosition, null, null, j0.e.class);
            if (i10 >= 23) {
                accessibilityAction40 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
                accessibilityAction3 = accessibilityAction40;
            } else {
                accessibilityAction3 = null;
            }
            C = new a(accessibilityAction3, R.id.accessibilityActionScrollUp, null, null, null);
            if (i10 >= 23) {
                accessibilityAction39 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
                accessibilityAction4 = accessibilityAction39;
            } else {
                accessibilityAction4 = null;
            }
            D = new a(accessibilityAction4, R.id.accessibilityActionScrollLeft, null, null, null);
            if (i10 >= 23) {
                accessibilityAction38 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
                accessibilityAction5 = accessibilityAction38;
            } else {
                accessibilityAction5 = null;
            }
            E = new a(accessibilityAction5, R.id.accessibilityActionScrollDown, null, null, null);
            if (i10 >= 23) {
                accessibilityAction37 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
                accessibilityAction6 = accessibilityAction37;
            } else {
                accessibilityAction6 = null;
            }
            F = new a(accessibilityAction6, R.id.accessibilityActionScrollRight, null, null, null);
            if (i10 >= 29) {
                accessibilityAction36 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
                accessibilityAction7 = accessibilityAction36;
            } else {
                accessibilityAction7 = null;
            }
            G = new a(accessibilityAction7, R.id.accessibilityActionPageUp, null, null, null);
            if (i10 >= 29) {
                accessibilityAction35 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
                accessibilityAction8 = accessibilityAction35;
            } else {
                accessibilityAction8 = null;
            }
            H = new a(accessibilityAction8, R.id.accessibilityActionPageDown, null, null, null);
            if (i10 >= 29) {
                accessibilityAction34 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
                accessibilityAction9 = accessibilityAction34;
            } else {
                accessibilityAction9 = null;
            }
            I = new a(accessibilityAction9, R.id.accessibilityActionPageLeft, null, null, null);
            if (i10 >= 29) {
                accessibilityAction33 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
                accessibilityAction10 = accessibilityAction33;
            } else {
                accessibilityAction10 = null;
            }
            J = new a(accessibilityAction10, R.id.accessibilityActionPageRight, null, null, null);
            if (i10 >= 23) {
                accessibilityAction32 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;
                accessibilityAction11 = accessibilityAction32;
            } else {
                accessibilityAction11 = null;
            }
            K = new a(accessibilityAction11, R.id.accessibilityActionContextClick, null, null, null);
            if (i10 >= 24) {
                accessibilityAction31 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
                accessibilityAction12 = accessibilityAction31;
            } else {
                accessibilityAction12 = null;
            }
            L = new a(accessibilityAction12, R.id.accessibilityActionSetProgress, null, null, j0.f.class);
            if (i10 >= 26) {
                accessibilityAction30 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
                accessibilityAction13 = accessibilityAction30;
            } else {
                accessibilityAction13 = null;
            }
            M = new a(accessibilityAction13, R.id.accessibilityActionMoveWindow, null, null, j0.d.class);
            if (i10 >= 28) {
                accessibilityAction29 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
                accessibilityAction14 = accessibilityAction29;
            } else {
                accessibilityAction14 = null;
            }
            N = new a(accessibilityAction14, R.id.accessibilityActionShowTooltip, null, null, null);
            if (i10 >= 28) {
                accessibilityAction28 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
                accessibilityAction15 = accessibilityAction28;
            } else {
                accessibilityAction15 = null;
            }
            O = new a(accessibilityAction15, R.id.accessibilityActionHideTooltip, null, null, null);
            if (i10 >= 30) {
                accessibilityAction27 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
                accessibilityAction16 = accessibilityAction27;
            } else {
                accessibilityAction16 = null;
            }
            P = new a(accessibilityAction16, R.id.accessibilityActionPressAndHold, null, null, null);
            if (i10 >= 30) {
                accessibilityAction26 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
                accessibilityAction17 = accessibilityAction26;
            } else {
                accessibilityAction17 = null;
            }
            Q = new a(accessibilityAction17, R.id.accessibilityActionImeEnter, null, null, null);
            if (i10 >= 32) {
                accessibilityAction25 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
                accessibilityAction18 = accessibilityAction25;
            } else {
                accessibilityAction18 = null;
            }
            R = new a(accessibilityAction18, R.id.ALT, null, null, null);
            if (i10 >= 32) {
                accessibilityAction24 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
                accessibilityAction19 = accessibilityAction24;
            } else {
                accessibilityAction19 = null;
            }
            S = new a(accessibilityAction19, R.id.CTRL, null, null, null);
            if (i10 >= 32) {
                accessibilityAction23 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
                accessibilityAction20 = accessibilityAction23;
            } else {
                accessibilityAction20 = null;
            }
            T = new a(accessibilityAction20, R.id.FUNCTION, null, null, null);
            if (i10 >= 33) {
                accessibilityAction22 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
                accessibilityAction21 = accessibilityAction22;
            } else {
                accessibilityAction21 = null;
            }
            U = new a(accessibilityAction21, R.id.KEYCODE_0, null, null, null);
            if (i10 >= 34) {
                accessibilityAction43 = d.a();
            }
            V = new a(accessibilityAction43, R.id.KEYCODE_3D_MODE, null, null, null);
        }

        public a(int i10, CharSequence charSequence) {
            this(null, i10, charSequence, null, null);
        }

        public a a(CharSequence charSequence, j0 j0Var) {
            return new a(null, this.f١٥٩٤٩b, charSequence, j0Var, this.f١٥٩٥٠c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f١٥٩٤٨a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f١٥٩٤٨a).getLabel();
        }

        public boolean d(View view, Bundle bundle) {
            String name;
            if (this.f١٥٩٥١d != null) {
                Class cls = this.f١٥٩٥٠c;
                if (cls != null) {
                    try {
                        androidx.appcompat.app.a0.a(cls.getDeclaredConstructor(null).newInstance(null));
                        throw null;
                    } catch (Exception e10) {
                        Class cls2 = this.f١٥٩٥٠c;
                        if (cls2 == null) {
                            name = Constants.NULL_VERSION_ID;
                        } else {
                            name = cls2.getName();
                        }
                        Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + name, e10);
                    }
                }
                return this.f١٥٩٥١d.perform(view, null);
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f١٥٩٤٨a;
            if (obj2 == null) {
                if (aVar.f١٥٩٤٨a != null) {
                    return false;
                }
                return true;
            }
            if (!obj2.equals(aVar.f١٥٩٤٨a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            Object obj = this.f١٥٩٤٨a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String j10 = g0.j(this.f١٥٩٤٩b);
            if (j10.equals("ACTION_UNKNOWN") && c() != null) {
                j10 = c().toString();
            }
            sb.append(j10);
            return sb.toString();
        }

        public a(int i10, CharSequence charSequence, j0 j0Var) {
            this(null, i10, charSequence, j0Var, null);
        }

        a(Object obj) {
            this(obj, 0, null, null, null);
        }

        private a(int i10, CharSequence charSequence, Class cls) {
            this(null, i10, charSequence, null, cls);
        }

        a(Object obj, int i10, CharSequence charSequence, j0 j0Var, Class cls) {
            this.f١٥٩٤٩b = i10;
            this.f١٥٩٥١d = j0Var;
            if (obj == null) {
                this.f١٥٩٤٨a = new AccessibilityNodeInfo.AccessibilityAction(i10, charSequence);
            } else {
                this.f١٥٩٤٨a = obj;
            }
            this.f١٥٩٥٠c = cls;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class b {
        public static CharSequence a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c {
        public static String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class d {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        final Object f١٥٩٥٢a;

        e(Object obj) {
            this.f١٥٩٥٢a = obj;
        }

        public static e a(int i10, int i11, boolean z10) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10));
        }

        public static e b(int i10, int i11, boolean z10, int i12) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10, i12));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        final Object f١٥٩٥٣a;

        f(Object obj) {
            this.f١٥٩٥٣a = obj;
        }

        public static f a(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
            return new f(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, z10, z11));
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        final Object f١٥٩٥٤a;

        g(Object obj) {
            this.f١٥٩٥٤a = obj;
        }

        public static g a(int i10, float f10, float f11, float f12) {
            return new g(AccessibilityNodeInfo.RangeInfo.obtain(i10, f10, f11, f12));
        }
    }

    private g0(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f١٥٩٢٢a = accessibilityNodeInfo;
    }

    private SparseArray A(View view) {
        return (SparseArray) view.getTag(androidx.core.R.id.tag_accessibility_clickable_spans);
    }

    private boolean G() {
        return !h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    private int H(ClickableSpan clickableSpan, SparseArray sparseArray) {
        if (sparseArray != null) {
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray.valueAt(i10)).get())) {
                    return sparseArray.keyAt(i10);
                }
            }
        }
        int i11 = f١٥٩٢١d;
        f١٥٩٢١d = i11 + 1;
        return i11;
    }

    public static g0 V0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new g0(accessibilityNodeInfo);
    }

    public static g0 a0() {
        return V0(AccessibilityNodeInfo.obtain());
    }

    public static g0 b0(View view) {
        return V0(AccessibilityNodeInfo.obtain(view));
    }

    public static g0 c0(g0 g0Var) {
        return V0(AccessibilityNodeInfo.obtain(g0Var.f١٥٩٢٢a));
    }

    private void e(ClickableSpan clickableSpan, Spanned spanned, int i10) {
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i10));
    }

    private void g() {
        this.f١٥٩٢٢a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f١٥٩٢٢a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f١٥٩٢٢a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f١٥٩٢٢a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    private void g0(View view) {
        SparseArray A = A(view);
        if (A != null) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < A.size(); i10++) {
                if (((WeakReference) A.valueAt(i10)).get() == null) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                A.remove(((Integer) arrayList.get(i11)).intValue());
            }
        }
    }

    private List h(String str) {
        ArrayList<Integer> integerArrayList = this.f١٥٩٢٢a.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            this.f١٥٩٢٢a.getExtras().putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    private void i0(int i10, boolean z10) {
        Bundle v10 = v();
        if (v10 != null) {
            int i11 = v10.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i10);
            if (!z10) {
                i10 = 0;
            }
            v10.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i10 | i11);
        }
    }

    static String j(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                switch (i10) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case 256:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case 512:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case 8192:
                        return "ACTION_SCROLL_BACKWARD";
                    case DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE /* 16384 */:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case anetwork.channel.unified.e.MAX_RSP_BUFFER_LENGTH /* 131072 */:
                        return "ACTION_SET_SELECTION";
                    case 262144:
                        return "ACTION_EXPAND";
                    case anet.channel.bytes.a.MAX_POOL_SIZE /* 524288 */:
                        return "ACTION_COLLAPSE";
                    case 2097152:
                        return "ACTION_SET_TEXT";
                    case R.id.accessibilityActionMoveWindow:
                        return "ACTION_MOVE_WINDOW";
                    case R.id.KEYCODE_3D_MODE:
                        return "ACTION_SCROLL_IN_DIRECTION";
                    default:
                        switch (i10) {
                            case R.id.accessibilityActionShowOnScreen:
                                return "ACTION_SHOW_ON_SCREEN";
                            case R.id.accessibilityActionScrollToPosition:
                                return "ACTION_SCROLL_TO_POSITION";
                            case R.id.accessibilityActionScrollUp:
                                return "ACTION_SCROLL_UP";
                            case R.id.accessibilityActionScrollLeft:
                                return "ACTION_SCROLL_LEFT";
                            case R.id.accessibilityActionScrollDown:
                                return "ACTION_SCROLL_DOWN";
                            case R.id.accessibilityActionScrollRight:
                                return "ACTION_SCROLL_RIGHT";
                            case R.id.accessibilityActionContextClick:
                                return "ACTION_CONTEXT_CLICK";
                            case R.id.accessibilityActionSetProgress:
                                return "ACTION_SET_PROGRESS";
                            default:
                                switch (i10) {
                                    case R.id.accessibilityActionShowTooltip:
                                        return "ACTION_SHOW_TOOLTIP";
                                    case R.id.accessibilityActionHideTooltip:
                                        return "ACTION_HIDE_TOOLTIP";
                                    case R.id.accessibilityActionPageUp:
                                        return "ACTION_PAGE_UP";
                                    case R.id.accessibilityActionPageDown:
                                        return "ACTION_PAGE_DOWN";
                                    case R.id.accessibilityActionPageLeft:
                                        return "ACTION_PAGE_LEFT";
                                    case R.id.accessibilityActionPageRight:
                                        return "ACTION_PAGE_RIGHT";
                                    case R.id.accessibilityActionPressAndHold:
                                        return "ACTION_PRESS_AND_HOLD";
                                    default:
                                        switch (i10) {
                                            case R.id.accessibilityActionImeEnter:
                                                return "ACTION_IME_ENTER";
                                            case R.id.ALT:
                                                return "ACTION_DRAG_START";
                                            case R.id.CTRL:
                                                return "ACTION_DRAG_DROP";
                                            case R.id.FUNCTION:
                                                return "ACTION_DRAG_CANCEL";
                                            default:
                                                return "ACTION_UNKNOWN";
                                        }
                                }
                        }
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    private boolean l(int i10) {
        Bundle v10 = v();
        if (v10 == null || (v10.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i10) != i10) {
            return false;
        }
        return true;
    }

    public static ClickableSpan[] r(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray y(View view) {
        SparseArray A = A(view);
        if (A == null) {
            SparseArray sparseArray = new SparseArray();
            view.setTag(androidx.core.R.id.tag_accessibility_clickable_spans, sparseArray);
            return sparseArray;
        }
        return A;
    }

    public void A0(View view) {
        this.f١٥٩٢٢a.setLabelFor(view);
    }

    public CharSequence B() {
        if (Build.VERSION.SDK_INT >= 30) {
            return b.a(this.f١٥٩٢٢a);
        }
        return this.f١٥٩٢٢a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public void B0(boolean z10) {
        this.f١٥٩٢٢a.setLongClickable(z10);
    }

    public CharSequence C() {
        if (G()) {
            List h10 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List h11 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List h12 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List h13 = h("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            SpannableString spannableString = new SpannableString(TextUtils.substring(this.f١٥٩٢٢a.getText(), 0, this.f١٥٩٢٢a.getText().length()));
            for (int i10 = 0; i10 < h10.size(); i10++) {
                spannableString.setSpan(new m2.a(((Integer) h13.get(i10)).intValue(), this, v().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) h10.get(i10)).intValue(), ((Integer) h11.get(i10)).intValue(), ((Integer) h12.get(i10)).intValue());
            }
            return spannableString;
        }
        return this.f١٥٩٢٢a.getText();
    }

    public void C0(int i10) {
        this.f١٥٩٢٢a.setMaxTextLength(i10);
    }

    public CharSequence D() {
        CharSequence tooltipText;
        if (Build.VERSION.SDK_INT >= 28) {
            tooltipText = this.f١٥٩٢٢a.getTooltipText();
            return tooltipText;
        }
        return this.f١٥٩٢٢a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public void D0(int i10) {
        this.f١٥٩٢٢a.setMovementGranularities(i10);
    }

    public String E() {
        if (Build.VERSION.SDK_INT >= 33) {
            return c.a(this.f١٥٩٢٢a);
        }
        return this.f١٥٩٢٢a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public void E0(CharSequence charSequence) {
        this.f١٥٩٢٢a.setPackageName(charSequence);
    }

    public String F() {
        return this.f١٥٩٢٢a.getViewIdResourceName();
    }

    public void F0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f١٥٩٢٢a.setPaneTitle(charSequence);
        } else {
            this.f١٥٩٢٢a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void G0(View view) {
        this.f١٥٩٢٣b = -1;
        this.f١٥٩٢٢a.setParent(view);
    }

    public void H0(View view, int i10) {
        this.f١٥٩٢٣b = i10;
        this.f١٥٩٢٢a.setParent(view, i10);
    }

    public boolean I() {
        if (Build.VERSION.SDK_INT >= 34) {
            return d.d(this.f١٥٩٢٢a);
        }
        return l(64);
    }

    public void I0(g gVar) {
        this.f١٥٩٢٢a.setRangeInfo((AccessibilityNodeInfo.RangeInfo) gVar.f١٥٩٥٤a);
    }

    public boolean J() {
        return this.f١٥٩٢٢a.isAccessibilityFocused();
    }

    public void J0(CharSequence charSequence) {
        this.f١٥٩٢٢a.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", charSequence);
    }

    public boolean K() {
        return this.f١٥٩٢٢a.isCheckable();
    }

    public void K0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f١٥٩٢٢a.setScreenReaderFocusable(z10);
        } else {
            i0(1, z10);
        }
    }

    public boolean L() {
        return this.f١٥٩٢٢a.isChecked();
    }

    public void L0(boolean z10) {
        this.f١٥٩٢٢a.setScrollable(z10);
    }

    public boolean M() {
        return this.f١٥٩٢٢a.isClickable();
    }

    public void M0(boolean z10) {
        this.f١٥٩٢٢a.setSelected(z10);
    }

    public boolean N() {
        boolean isContextClickable;
        if (Build.VERSION.SDK_INT >= 23) {
            isContextClickable = this.f١٥٩٢٢a.isContextClickable();
            return isContextClickable;
        }
        return false;
    }

    public void N0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f١٥٩٢٢a.setShowingHintText(z10);
        } else {
            i0(4, z10);
        }
    }

    public boolean O() {
        return this.f١٥٩٢٢a.isEnabled();
    }

    public void O0(View view) {
        this.f١٥٩٢٤c = -1;
        this.f١٥٩٢٢a.setSource(view);
    }

    public boolean P() {
        return this.f١٥٩٢٢a.isFocusable();
    }

    public void P0(View view, int i10) {
        this.f١٥٩٢٤c = i10;
        this.f١٥٩٢٢a.setSource(view, i10);
    }

    public boolean Q() {
        return this.f١٥٩٢٢a.isFocused();
    }

    public void Q0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.b(this.f١٥٩٢٢a, charSequence);
        } else {
            this.f١٥٩٢٢a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public boolean R() {
        return l(67108864);
    }

    public void R0(CharSequence charSequence) {
        this.f١٥٩٢٢a.setText(charSequence);
    }

    public boolean S() {
        boolean isImportantForAccessibility;
        if (Build.VERSION.SDK_INT >= 24) {
            isImportantForAccessibility = this.f١٥٩٢٢a.isImportantForAccessibility();
            return isImportantForAccessibility;
        }
        return true;
    }

    public void S0(View view) {
        this.f١٥٩٢٢a.setTraversalAfter(view);
    }

    public boolean T() {
        return this.f١٥٩٢٢a.isLongClickable();
    }

    public void T0(boolean z10) {
        this.f١٥٩٢٢a.setVisibleToUser(z10);
    }

    public boolean U() {
        return this.f١٥٩٢٢a.isPassword();
    }

    public AccessibilityNodeInfo U0() {
        return this.f١٥٩٢٢a;
    }

    public boolean V() {
        return this.f١٥٩٢٢a.isScrollable();
    }

    public boolean W() {
        return this.f١٥٩٢٢a.isSelected();
    }

    public boolean X() {
        boolean isShowingHintText;
        if (Build.VERSION.SDK_INT >= 26) {
            isShowingHintText = this.f١٥٩٢٢a.isShowingHintText();
            return isShowingHintText;
        }
        return l(4);
    }

    public boolean Y() {
        if (Build.VERSION.SDK_INT >= 33) {
            return c.b(this.f١٥٩٢٢a);
        }
        return l(8388608);
    }

    public boolean Z() {
        return this.f١٥٩٢٢a.isVisibleToUser();
    }

    public void a(int i10) {
        this.f١٥٩٢٢a.addAction(i10);
    }

    public void b(a aVar) {
        this.f١٥٩٢٢a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f١٥٩٤٨a);
    }

    public void c(View view) {
        this.f١٥٩٢٢a.addChild(view);
    }

    public void d(View view, int i10) {
        this.f١٥٩٢٢a.addChild(view, i10);
    }

    public boolean d0(int i10, Bundle bundle) {
        return this.f١٥٩٢٢a.performAction(i10, bundle);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f١٥٩٢٢a;
        if (accessibilityNodeInfo == null) {
            if (g0Var.f١٥٩٢٢a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(g0Var.f١٥٩٢٢a)) {
            return false;
        }
        if (this.f١٥٩٢٤c == g0Var.f١٥٩٢٤c && this.f١٥٩٢٣b == g0Var.f١٥٩٢٣b) {
            return true;
        }
        return false;
    }

    public void f(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            g();
            g0(view);
            ClickableSpan[] r10 = r(charSequence);
            if (r10 != null && r10.length > 0) {
                v().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", androidx.core.R.id.accessibility_action_clickable_span);
                SparseArray y10 = y(view);
                for (int i10 = 0; i10 < r10.length; i10++) {
                    int H = H(r10[i10], y10);
                    y10.put(H, new WeakReference(r10[i10]));
                    e(r10[i10], (Spanned) charSequence, H);
                }
            }
        }
    }

    public boolean f0(a aVar) {
        return this.f١٥٩٢٢a.removeAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f١٥٩٤٨a);
    }

    public void h0(boolean z10) {
        this.f١٥٩٢٢a.setAccessibilityFocused(z10);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f١٥٩٢٢a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public List i() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f١٥٩٢٢a.getActionList();
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new a(actionList.get(i10)));
        }
        return arrayList;
    }

    public void j0(Rect rect) {
        this.f١٥٩٢٢a.setBoundsInParent(rect);
    }

    public int k() {
        return this.f١٥٩٢٢a.getActions();
    }

    public void k0(Rect rect) {
        this.f١٥٩٢٢a.setBoundsInScreen(rect);
    }

    public void l0(boolean z10) {
        this.f١٥٩٢٢a.setCanOpenPopup(z10);
    }

    public void m(Rect rect) {
        this.f١٥٩٢٢a.getBoundsInParent(rect);
    }

    public void m0(boolean z10) {
        this.f١٥٩٢٢a.setCheckable(z10);
    }

    public void n(Rect rect) {
        this.f١٥٩٢٢a.getBoundsInScreen(rect);
    }

    public void n0(boolean z10) {
        this.f١٥٩٢٢a.setChecked(z10);
    }

    public void o(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.b(this.f١٥٩٢٢a, rect);
            return;
        }
        Rect rect2 = (Rect) this.f١٥٩٢٢a.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void o0(CharSequence charSequence) {
        this.f١٥٩٢٢a.setClassName(charSequence);
    }

    public int p() {
        return this.f١٥٩٢٢a.getChildCount();
    }

    public void p0(boolean z10) {
        this.f١٥٩٢٢a.setClickable(z10);
    }

    public CharSequence q() {
        return this.f١٥٩٢٢a.getClassName();
    }

    public void q0(Object obj) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f١٥٩٢٢a;
        if (obj == null) {
            collectionInfo = null;
        } else {
            collectionInfo = (AccessibilityNodeInfo.CollectionInfo) ((e) obj).f١٥٩٥٢a;
        }
        accessibilityNodeInfo.setCollectionInfo(collectionInfo);
    }

    public void r0(Object obj) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f١٥٩٢٢a;
        if (obj == null) {
            collectionItemInfo = null;
        } else {
            collectionItemInfo = (AccessibilityNodeInfo.CollectionItemInfo) ((f) obj).f١٥٩٥٣a;
        }
        accessibilityNodeInfo.setCollectionItemInfo(collectionItemInfo);
    }

    public CharSequence s() {
        if (Build.VERSION.SDK_INT >= 34) {
            return d.c(this.f١٥٩٢٢a);
        }
        return this.f١٥٩٢٢a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public void s0(CharSequence charSequence) {
        this.f١٥٩٢٢a.setContentDescription(charSequence);
    }

    public CharSequence t() {
        return this.f١٥٩٢٢a.getContentDescription();
    }

    public void t0(boolean z10) {
        this.f١٥٩٢٢a.setDismissable(z10);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        m(rect);
        sb.append("; boundsInParent: " + rect);
        n(rect);
        sb.append("; boundsInScreen: " + rect);
        o(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(z());
        sb.append("; className: ");
        sb.append(q());
        sb.append("; text: ");
        sb.append(C());
        sb.append("; error: ");
        sb.append(u());
        sb.append("; maxTextLength: ");
        sb.append(w());
        sb.append("; stateDescription: ");
        sb.append(B());
        sb.append("; contentDescription: ");
        sb.append(t());
        sb.append("; tooltipText: ");
        sb.append(D());
        sb.append("; viewIdResName: ");
        sb.append(F());
        sb.append("; uniqueId: ");
        sb.append(E());
        sb.append("; checkable: ");
        sb.append(K());
        sb.append("; checked: ");
        sb.append(L());
        sb.append("; focusable: ");
        sb.append(P());
        sb.append("; focused: ");
        sb.append(Q());
        sb.append("; selected: ");
        sb.append(W());
        sb.append("; clickable: ");
        sb.append(M());
        sb.append("; longClickable: ");
        sb.append(T());
        sb.append("; contextClickable: ");
        sb.append(N());
        sb.append("; enabled: ");
        sb.append(O());
        sb.append("; password: ");
        sb.append(U());
        sb.append("; scrollable: " + V());
        sb.append("; containerTitle: ");
        sb.append(s());
        sb.append("; granularScrollingSupported: ");
        sb.append(R());
        sb.append("; importantForAccessibility: ");
        sb.append(S());
        sb.append("; visible: ");
        sb.append(Z());
        sb.append("; isTextSelectable: ");
        sb.append(Y());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(I());
        sb.append("; [");
        List i10 = i();
        for (int i11 = 0; i11 < i10.size(); i11++) {
            a aVar = (a) i10.get(i11);
            String j10 = j(aVar.b());
            if (j10.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                j10 = aVar.c().toString();
            }
            sb.append(j10);
            if (i11 != i10.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public CharSequence u() {
        return this.f١٥٩٢٢a.getError();
    }

    public void u0(boolean z10) {
        this.f١٥٩٢٢a.setEnabled(z10);
    }

    public Bundle v() {
        return this.f١٥٩٢٢a.getExtras();
    }

    public void v0(CharSequence charSequence) {
        this.f١٥٩٢٢a.setError(charSequence);
    }

    public int w() {
        return this.f١٥٩٢٢a.getMaxTextLength();
    }

    public void w0(boolean z10) {
        this.f١٥٩٢٢a.setFocusable(z10);
    }

    public int x() {
        return this.f١٥٩٢٢a.getMovementGranularities();
    }

    public void x0(boolean z10) {
        this.f١٥٩٢٢a.setFocused(z10);
    }

    public void y0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f١٥٩٢٢a.setHeading(z10);
        } else {
            i0(2, z10);
        }
    }

    public CharSequence z() {
        return this.f١٥٩٢٢a.getPackageName();
    }

    public void z0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f١٥٩٢٢a.setHintText(charSequence);
        } else {
            this.f١٥٩٢٢a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public void e0() {
    }
}
