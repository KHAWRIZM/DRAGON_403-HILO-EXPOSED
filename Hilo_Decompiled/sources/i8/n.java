package i8;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.transition.PathMotion;
import android.transition.PatternPathMotion;
import android.transition.Transition;
import android.util.TypedValue;
import android.view.View;
import androidx.core.graphics.d0;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import f8.o;
import s7.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class n {

    /* renamed from: a, reason: collision with root package name */
    private static final RectF f١٤٧٨٨a = new RectF();

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a implements b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ RectF f١٤٧٨٩a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RectF f١٤٧٩٠b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f١٤٧٩١c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ float f١٤٧٩٢d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f١٤٧٩٣e;

        a(RectF rectF, RectF rectF2, float f10, float f11, float f12) {
            this.f١٤٧٨٩a = rectF;
            this.f١٤٧٩٠b = rectF2;
            this.f١٤٧٩١c = f10;
            this.f١٤٧٩٢d = f11;
            this.f١٤٧٩٣e = f12;
        }

        @Override // i8.n.b
        public f8.d a(f8.d dVar, f8.d dVar2) {
            return new f8.a(n.n(dVar.a(this.f١٤٧٨٩a), dVar2.a(this.f١٤٧٩٠b), this.f١٤٧٩١c, this.f١٤٧٩٢d, this.f١٤٧٩٣e));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface b {
        f8.d a(f8.d dVar, f8.d dVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float b(RectF rectF) {
        return rectF.width() * rectF.height();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o c(o oVar, final RectF rectF) {
        return oVar.z(new o.c() { // from class: i8.m
            @Override // f8.o.c
            public final f8.d a(f8.d dVar) {
                f8.d b10;
                b10 = f8.m.b(rectF, dVar);
                return b10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader d(int i10) {
        return new LinearGradient(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, i10, i10, Shader.TileMode.CLAMP);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object e(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View f(View view, int i10) {
        String resourceName = view.getResources().getResourceName(i10);
        while (view != null) {
            if (view.getId() == i10) {
                return view;
            }
            Object parent = view.getParent();
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static View g(View view, int i10) {
        View findViewById = view.findViewById(i10);
        if (findViewById != null) {
            return findViewById;
        }
        return f(view, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RectF h(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        return new RectF(iArr[0], iArr[1], view.getWidth() + r1, view.getHeight() + r0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RectF i(View view) {
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Rect j(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    private static boolean k(o oVar, RectF rectF) {
        if (oVar.r().a(rectF) == DownloadProgress.UNKNOWN_PROGRESS && oVar.t().a(rectF) == DownloadProgress.UNKNOWN_PROGRESS && oVar.l().a(rectF) == DownloadProgress.UNKNOWN_PROGRESS && oVar.j().a(rectF) == DownloadProgress.UNKNOWN_PROGRESS) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float m(float f10, float f11, float f12) {
        return f10 + (f12 * (f11 - f10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float n(float f10, float f11, float f12, float f13, float f14) {
        return o(f10, f11, f12, f13, f14, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float o(float f10, float f11, float f12, float f13, float f14, boolean z10) {
        if (z10 && (f14 < DownloadProgress.UNKNOWN_PROGRESS || f14 > 1.0f)) {
            return m(f10, f11, f14);
        }
        if (f14 < f12) {
            return f10;
        }
        if (f14 > f13) {
            return f11;
        }
        return m(f10, f11, (f14 - f12) / (f13 - f12));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(int i10, int i11, float f10, float f11, float f12) {
        if (f12 < f10) {
            return i10;
        }
        if (f12 > f11) {
            return i11;
        }
        return (int) m(i10, i11, (f12 - f10) / (f11 - f10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static o q(o oVar, o oVar2, RectF rectF, RectF rectF2, float f10, float f11, float f12) {
        if (f12 < f10) {
            return oVar;
        }
        if (f12 > f11) {
            return oVar2;
        }
        return x(oVar, oVar2, rectF, new a(rectF, rectF2, f10, f11, f12));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r(Transition transition, Context context, int i10) {
        int f10;
        if (i10 != 0 && transition.getDuration() == -1 && (f10 = a8.k.f(context, i10, -1)) != -1) {
            transition.setDuration(f10);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s(Transition transition, Context context, int i10, TimeInterpolator timeInterpolator) {
        if (i10 != 0 && transition.getInterpolator() == null) {
            transition.setInterpolator(a8.k.g(context, i10, timeInterpolator));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t(Transition transition, Context context, int i10) {
        PathMotion u10;
        if (i10 != 0 && (u10 = u(context, i10)) != null) {
            transition.setPathMotion(u10);
            return true;
        }
        return false;
    }

    static PathMotion u(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.type;
        if (i11 == 16) {
            int i12 = typedValue.data;
            if (i12 == 0) {
                return null;
            }
            if (i12 == 1) {
                return new i();
            }
            throw new IllegalArgumentException("Invalid motion path type: " + i12);
        }
        if (i11 == 3) {
            return new PatternPathMotion(d0.e(String.valueOf(typedValue.string)));
        }
        throw new IllegalArgumentException("Motion path theme attribute must either be an enum value or path data string");
    }

    private static int v(Canvas canvas, Rect rect, int i10) {
        RectF rectF = f١٤٧٨٨a;
        rectF.set(rect);
        return canvas.saveLayerAlpha(rectF, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(Canvas canvas, Rect rect, float f10, float f11, float f12, int i10, a.InterfaceC٠٢٢٨a r72) {
        if (i10 <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(f10, f11);
        canvas.scale(f12, f12);
        if (i10 < 255) {
            v(canvas, rect, i10);
        }
        r72.a(canvas);
        canvas.restoreToCount(save);
    }

    static o x(o oVar, o oVar2, RectF rectF, b bVar) {
        o oVar3;
        if (k(oVar, rectF)) {
            oVar3 = oVar;
        } else {
            oVar3 = oVar2;
        }
        return oVar3.w().F(bVar.a(oVar.r(), oVar2.r())).J(bVar.a(oVar.t(), oVar2.t())).w(bVar.a(oVar.j(), oVar2.j())).A(bVar.a(oVar.l(), oVar2.l())).m();
    }
}
