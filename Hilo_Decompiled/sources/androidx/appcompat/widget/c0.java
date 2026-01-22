package androidx.appcompat.widget;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public abstract class c0 {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f١٤٧٢a = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    private static final int[] f١٤٧٣b = new int[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Rect f١٤٧٤c = new Rect();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final boolean f١٤٧٥a;

        /* renamed from: b, reason: collision with root package name */
        private static final Method f١٤٧٦b;

        /* renamed from: c, reason: collision with root package name */
        private static final Field f١٤٧٧c;

        /* renamed from: d, reason: collision with root package name */
        private static final Field f١٤٧٨d;

        /* renamed from: e, reason: collision with root package name */
        private static final Field f١٤٧٩e;

        /* renamed from: f, reason: collision with root package name */
        private static final Field f١٤٨٠f;

        /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
        static {
            Method method;
            Field field;
            Field field2;
            Field field3;
            Field field4;
            boolean z10;
            Class<?> cls;
            try {
                cls = Class.forName("android.graphics.Insets");
                method = Drawable.class.getMethod("getOpticalInsets", null);
                try {
                    field = cls.getField(ViewHierarchyConstants.DIMENSION_LEFT_KEY);
                } catch (ClassNotFoundException unused) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z10 = false;
                    if (!z10) {
                    }
                } catch (NoSuchFieldException unused2) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z10 = false;
                    if (!z10) {
                    }
                } catch (NoSuchMethodException unused3) {
                    field = null;
                    field2 = field;
                    field3 = field2;
                    field4 = null;
                    z10 = false;
                    if (!z10) {
                    }
                }
            } catch (ClassNotFoundException unused4) {
                method = null;
                field = null;
            } catch (NoSuchFieldException unused5) {
                method = null;
                field = null;
            } catch (NoSuchMethodException unused6) {
                method = null;
                field = null;
            }
            try {
                field2 = cls.getField(ViewHierarchyConstants.DIMENSION_TOP_KEY);
                try {
                    field3 = cls.getField("right");
                } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused7) {
                    field3 = null;
                }
                try {
                    field4 = cls.getField("bottom");
                    z10 = true;
                } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException unused8) {
                    field4 = null;
                    z10 = false;
                    if (!z10) {
                    }
                }
            } catch (ClassNotFoundException unused9) {
                field2 = null;
                field3 = field2;
                field4 = null;
                z10 = false;
                if (!z10) {
                }
            } catch (NoSuchFieldException unused10) {
                field2 = null;
                field3 = field2;
                field4 = null;
                z10 = false;
                if (!z10) {
                }
            } catch (NoSuchMethodException unused11) {
                field2 = null;
                field3 = field2;
                field4 = null;
                z10 = false;
                if (!z10) {
                }
            }
            if (!z10) {
                f١٤٧٦b = method;
                f١٤٧٧c = field;
                f١٤٧٨d = field2;
                f١٤٧٩e = field3;
                f١٤٨٠f = field4;
                f١٤٧٥a = true;
                return;
            }
            f١٤٧٦b = null;
            f١٤٧٧c = null;
            f١٤٧٨d = null;
            f١٤٧٩e = null;
            f١٤٨٠f = null;
            f١٤٧٥a = false;
        }

        static Rect a(Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && f١٤٧٥a) {
                try {
                    Object invoke = f١٤٧٦b.invoke(drawable, null);
                    if (invoke != null) {
                        return new Rect(f١٤٧٧c.getInt(invoke), f١٤٧٨d.getInt(invoke), f١٤٧٩e.getInt(invoke), f١٤٨٠f.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return c0.f١٤٧٤c;
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    static class b {
        static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    public static boolean a(Drawable drawable) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29 && i10 < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            c(drawable);
        }
    }

    private static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state != null && state.length != 0) {
            drawable.setState(f١٤٧٣b);
        } else {
            drawable.setState(f١٤٧٢a);
        }
        drawable.setState(state);
    }

    public static Rect d(Drawable drawable) {
        int i10;
        int i11;
        int i12;
        int i13;
        if (Build.VERSION.SDK_INT >= 29) {
            Insets a10 = b.a(drawable);
            i10 = a10.left;
            i11 = a10.top;
            i12 = a10.right;
            i13 = a10.bottom;
            return new Rect(i10, i11, i12, i13);
        }
        return a.a(h2.b.q(drawable));
    }

    public static PorterDuff.Mode e(int i10, PorterDuff.Mode mode) {
        if (i10 != 3) {
            if (i10 != 5) {
                if (i10 != 9) {
                    switch (i10) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}
