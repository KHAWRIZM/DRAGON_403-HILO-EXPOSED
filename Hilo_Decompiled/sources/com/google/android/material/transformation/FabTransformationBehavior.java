package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.circularreveal.c;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinVersion;
import p7.h;
import p7.i;
import p7.j;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c, reason: collision with root package name */
    private final Rect f١٠٣٤٨c;

    /* renamed from: d, reason: collision with root package name */
    private final RectF f١٠٣٤٩d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f١٠٣٥٠e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f١٠٣٥١f;

    /* renamed from: g, reason: collision with root package name */
    private float f١٠٣٥٢g;

    /* renamed from: h, reason: collision with root package name */
    private float f١٠٣٥٣h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f١٠٣٥٤a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f١٠٣٥٥b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f١٠٣٥٦c;

        a(boolean z10, View view, View view2) {
            this.f١٠٣٥٤a = z10;
            this.f١٠٣٥٥b = view;
            this.f١٠٣٥٦c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f١٠٣٥٤a) {
                this.f١٠٣٥٥b.setVisibility(4);
                this.f١٠٣٥٦c.setAlpha(1.0f);
                this.f١٠٣٥٦c.setVisibility(0);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f١٠٣٥٤a) {
                this.f١٠٣٥٥b.setVisibility(0);
                this.f١٠٣٥٦c.setAlpha(DownloadProgress.UNKNOWN_PROGRESS);
                this.f١٠٣٥٦c.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f١٠٣٥٨a;

        b(View view) {
            this.f١٠٣٥٨a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f١٠٣٥٨a.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.circularreveal.c f١٠٣٦٠a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Drawable f١٠٣٦١b;

        c(com.google.android.material.circularreveal.c cVar, Drawable drawable) {
            this.f١٠٣٦٠a = cVar;
            this.f١٠٣٦١b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f١٠٣٦٠a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f١٠٣٦٠a.setCircularRevealOverlayDrawable(this.f١٠٣٦١b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.circularreveal.c f١٠٣٦٣a;

        d(com.google.android.material.circularreveal.c cVar) {
            this.f١٠٣٦٣a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c.e revealInfo = this.f١٠٣٦٣a.getRevealInfo();
            revealInfo.f٨٨٠٢c = Float.MAX_VALUE;
            this.f١٠٣٦٣a.setRevealInfo(revealInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public h f١٠٣٦٥a;

        /* renamed from: b, reason: collision with root package name */
        public j f١٠٣٦٦b;
    }

    public FabTransformationBehavior() {
        this.f١٠٣٤٨c = new Rect();
        this.f١٠٣٤٩d = new RectF();
        this.f١٠٣٥٠e = new RectF();
        this.f١٠٣٥١f = new int[2];
    }

    private ViewGroup Q(View view) {
        View findViewById = view.findViewById(R.id.mtrl_child_content_container);
        if (findViewById != null) {
            return l0(findViewById);
        }
        if (!(view instanceof TransformationChildLayout) && !(view instanceof TransformationChildCard)) {
            return l0(view);
        }
        return l0(((ViewGroup) view).getChildAt(0));
    }

    private void R(View view, e eVar, i iVar, i iVar2, float f10, float f11, float f12, float f13, RectF rectF) {
        float Y = Y(eVar, iVar, f10, f12);
        float Y2 = Y(eVar, iVar2, f11, f13);
        Rect rect = this.f١٠٣٤٨c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f١٠٣٤٩d;
        rectF2.set(rect);
        RectF rectF3 = this.f١٠٣٥٠e;
        Z(view, rectF3);
        rectF3.offset(Y, Y2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void S(View view, RectF rectF) {
        Z(view, rectF);
        rectF.offset(this.f١٠٣٥٢g, this.f١٠٣٥٣h);
    }

    private Pair T(float f10, float f11, boolean z10, e eVar) {
        i h10;
        i h11;
        if (f10 != DownloadProgress.UNKNOWN_PROGRESS && f11 != DownloadProgress.UNKNOWN_PROGRESS) {
            if ((z10 && f11 < DownloadProgress.UNKNOWN_PROGRESS) || (!z10 && f11 > DownloadProgress.UNKNOWN_PROGRESS)) {
                h10 = eVar.f١٠٣٦٥a.h("translationXCurveUpwards");
                h11 = eVar.f١٠٣٦٥a.h("translationYCurveUpwards");
            } else {
                h10 = eVar.f١٠٣٦٥a.h("translationXCurveDownwards");
                h11 = eVar.f١٠٣٦٥a.h("translationYCurveDownwards");
            }
        } else {
            h10 = eVar.f١٠٣٦٥a.h("translationXLinear");
            h11 = eVar.f١٠٣٦٥a.h("translationYLinear");
        }
        return new Pair(h10, h11);
    }

    private float U(View view, View view2, j jVar) {
        RectF rectF = this.f١٠٣٤٩d;
        RectF rectF2 = this.f١٠٣٥٠e;
        S(view, rectF);
        Z(view2, rectF2);
        rectF2.offset(-W(view, view2, jVar), DownloadProgress.UNKNOWN_PROGRESS);
        return rectF.centerX() - rectF2.left;
    }

    private float V(View view, View view2, j jVar) {
        RectF rectF = this.f١٠٣٤٩d;
        RectF rectF2 = this.f١٠٣٥٠e;
        S(view, rectF);
        Z(view2, rectF2);
        rectF2.offset(DownloadProgress.UNKNOWN_PROGRESS, -X(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float W(View view, View view2, j jVar) {
        float centerX;
        float centerX2;
        float f10;
        RectF rectF = this.f١٠٣٤٩d;
        RectF rectF2 = this.f١٠٣٥٠e;
        S(view, rectF);
        Z(view2, rectF2);
        int i10 = jVar.f١٦٩٦٦a & 7;
        if (i10 != 1) {
            if (i10 != 3) {
                if (i10 != 5) {
                    f10 = DownloadProgress.UNKNOWN_PROGRESS;
                    return f10 + jVar.f١٦٩٦٧b;
                }
                centerX = rectF2.right;
                centerX2 = rectF.right;
            } else {
                centerX = rectF2.left;
                centerX2 = rectF.left;
            }
        } else {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        }
        f10 = centerX - centerX2;
        return f10 + jVar.f١٦٩٦٧b;
    }

    private float X(View view, View view2, j jVar) {
        float centerY;
        float centerY2;
        float f10;
        RectF rectF = this.f١٠٣٤٩d;
        RectF rectF2 = this.f١٠٣٥٠e;
        S(view, rectF);
        Z(view2, rectF2);
        int i10 = jVar.f١٦٩٦٦a & 112;
        if (i10 != 16) {
            if (i10 != 48) {
                if (i10 != 80) {
                    f10 = DownloadProgress.UNKNOWN_PROGRESS;
                    return f10 + jVar.f١٦٩٦٨c;
                }
                centerY = rectF2.bottom;
                centerY2 = rectF.bottom;
            } else {
                centerY = rectF2.top;
                centerY2 = rectF.top;
            }
        } else {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        }
        f10 = centerY - centerY2;
        return f10 + jVar.f١٦٩٦٨c;
    }

    private float Y(e eVar, i iVar, float f10, float f11) {
        long c10 = iVar.c();
        long d10 = iVar.d();
        i h10 = eVar.f١٠٣٦٥a.h("expansion");
        return p7.a.a(f10, f11, iVar.e().getInterpolation(((float) (((h10.c() + h10.d()) + 17) - c10)) / ((float) d10)));
    }

    private void Z(View view, RectF rectF) {
        rectF.set(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f١٠٣٥١f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void a0(View view, View view2, boolean z10, boolean z11, e eVar, List list, List list2) {
        ObjectAnimator ofFloat;
        if (!(view2 instanceof ViewGroup)) {
            return;
        }
        boolean z12 = view2 instanceof com.google.android.material.circularreveal.c;
        ViewGroup Q = Q(view2);
        if (Q == null) {
            return;
        }
        if (z10) {
            if (!z11) {
                p7.d.f١٦٩٥٣a.set(Q, Float.valueOf(DownloadProgress.UNKNOWN_PROGRESS));
            }
            ofFloat = ObjectAnimator.ofFloat(Q, (Property<ViewGroup, Float>) p7.d.f١٦٩٥٣a, 1.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(Q, (Property<ViewGroup, Float>) p7.d.f١٦٩٥٣a, DownloadProgress.UNKNOWN_PROGRESS);
        }
        eVar.f١٠٣٦٥a.h("contentFade").a(ofFloat);
        list.add(ofFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void b0(View view, View view2, boolean z10, boolean z11, e eVar, List list, List list2) {
        ObjectAnimator ofInt;
        if (!(view2 instanceof com.google.android.material.circularreveal.c)) {
            return;
        }
        com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
        int j02 = j0(view);
        int i10 = 16777215 & j02;
        if (z10) {
            if (!z11) {
                cVar.setCircularRevealScrimColor(j02);
            }
            ofInt = ObjectAnimator.ofInt(cVar, (Property<com.google.android.material.circularreveal.c, Integer>) c.d.f٨٧٩٩a, i10);
        } else {
            ofInt = ObjectAnimator.ofInt(cVar, (Property<com.google.android.material.circularreveal.c, Integer>) c.d.f٨٧٩٩a, j02);
        }
        ofInt.setEvaluator(p7.c.b());
        eVar.f١٠٣٦٥a.h("color").a(ofInt);
        list.add(ofInt);
    }

    private void c0(View view, View view2, boolean z10, e eVar, List list) {
        float W = W(view, view2, eVar.f١٠٣٦٦b);
        float X = X(view, view2, eVar.f١٠٣٦٦b);
        Pair T = T(W, X, z10, eVar);
        i iVar = (i) T.first;
        i iVar2 = (i) T.second;
        Property property = View.TRANSLATION_X;
        if (!z10) {
            W = this.f١٠٣٥٢g;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, W);
        Property property2 = View.TRANSLATION_Y;
        if (!z10) {
            X = this.f١٠٣٥٣h;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, X);
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private void d0(View view, View view2, boolean z10, boolean z11, e eVar, List list, List list2) {
        ObjectAnimator ofFloat;
        float elevation = view2.getElevation() - view.getElevation();
        if (z10) {
            if (!z11) {
                view2.setTranslationZ(-elevation);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, DownloadProgress.UNKNOWN_PROGRESS);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        eVar.f١٠٣٦٥a.h("elevation").a(ofFloat);
        list.add(ofFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void e0(View view, View view2, boolean z10, boolean z11, e eVar, float f10, float f11, List list, List list2) {
        Animator animator;
        if (!(view2 instanceof com.google.android.material.circularreveal.c)) {
            return;
        }
        com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
        float U = U(view, view2, eVar.f١٠٣٦٦b);
        float V = V(view, view2, eVar.f١٠٣٦٦b);
        ((FloatingActionButton) view).h(this.f١٠٣٤٨c);
        float width = this.f١٠٣٤٨c.width() / 2.0f;
        i h10 = eVar.f١٠٣٦٥a.h("expansion");
        if (z10) {
            if (!z11) {
                cVar.setRevealInfo(new c.e(U, V, width));
            }
            if (z11) {
                width = cVar.getRevealInfo().f٨٨٠٢c;
            }
            animator = com.google.android.material.circularreveal.a.a(cVar, U, V, z7.a.c(U, V, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, f10, f11));
            animator.addListener(new d(cVar));
            h0(view2, h10.c(), (int) U, (int) V, width, list);
        } else {
            float f12 = cVar.getRevealInfo().f٨٨٠٢c;
            Animator a10 = com.google.android.material.circularreveal.a.a(cVar, U, V, width);
            int i10 = (int) U;
            int i11 = (int) V;
            h0(view2, h10.c(), i10, i11, f12, list);
            g0(view2, h10.c(), h10.d(), eVar.f١٠٣٦٥a.i(), i10, i11, width, list);
            animator = a10;
        }
        h10.a(animator);
        list.add(animator);
        list2.add(com.google.android.material.circularreveal.a.b(cVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void f0(View view, View view2, boolean z10, boolean z11, e eVar, List list, List list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof com.google.android.material.circularreveal.c) && (view instanceof ImageView)) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z10) {
                if (!z11) {
                    drawable.setAlpha(KotlinVersion.MAX_COMPONENT_VALUE);
                }
                ofInt = ObjectAnimator.ofInt(drawable, (Property<Drawable, Integer>) p7.e.f١٦٩٥٤a, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, (Property<Drawable, Integer>) p7.e.f١٦٩٥٤a, KotlinVersion.MAX_COMPONENT_VALUE);
            }
            ofInt.addUpdateListener(new b(view2));
            eVar.f١٠٣٦٥a.h("iconFade").a(ofInt);
            list.add(ofInt);
            list2.add(new c(cVar, drawable));
        }
    }

    private void g0(View view, long j10, long j11, long j12, int i10, int i11, float f10, List list) {
        long j13 = j10 + j11;
        if (j13 < j12) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
            createCircularReveal.setStartDelay(j13);
            createCircularReveal.setDuration(j12 - j13);
            list.add(createCircularReveal);
        }
    }

    private void h0(View view, long j10, int i10, int i11, float f10, List list) {
        if (j10 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i10, i11, f10, f10);
            createCircularReveal.setStartDelay(0L);
            createCircularReveal.setDuration(j10);
            list.add(createCircularReveal);
        }
    }

    private void i0(View view, View view2, boolean z10, boolean z11, e eVar, List list, List list2, RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float W = W(view, view2, eVar.f١٠٣٦٦b);
        float X = X(view, view2, eVar.f١٠٣٦٦b);
        Pair T = T(W, X, z10, eVar);
        i iVar = (i) T.first;
        i iVar2 = (i) T.second;
        if (z10) {
            if (!z11) {
                view2.setTranslationX(-W);
                view2.setTranslationY(-X);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, DownloadProgress.UNKNOWN_PROGRESS);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, DownloadProgress.UNKNOWN_PROGRESS);
            R(view2, eVar, iVar, iVar2, -W, -X, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -W);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -X);
        }
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private int j0(View view) {
        ColorStateList backgroundTintList = view.getBackgroundTintList();
        if (backgroundTintList != null) {
            return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup l0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet P(View view, View view2, boolean z10, boolean z11) {
        e k02 = k0(view2.getContext(), z10);
        if (z10) {
            this.f١٠٣٥٢g = view.getTranslationX();
            this.f١٠٣٥٣h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        d0(view, view2, z10, z11, k02, arrayList, arrayList2);
        RectF rectF = this.f١٠٣٤٩d;
        i0(view, view2, z10, z11, k02, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        c0(view, view2, z10, k02, arrayList);
        f0(view, view2, z10, z11, k02, arrayList, arrayList2);
        e0(view, view2, z10, z11, k02, width, height, arrayList, arrayList2);
        b0(view, view2, z10, z11, k02, arrayList, arrayList2);
        a0(view, view2, z10, z11, k02, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        p7.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z10, view2, view));
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i10));
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() != 8) {
            if (!(view2 instanceof FloatingActionButton)) {
                return false;
            }
            int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
            if (expandedComponentIdHint != 0 && expandedComponentIdHint != view.getId()) {
                return false;
            }
            return true;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    protected abstract e k0(Context context, boolean z10);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void m(CoordinatorLayout.f fVar) {
        if (fVar.f٢٥٦٧h == 0) {
            fVar.f٢٥٦٧h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f١٠٣٤٨c = new Rect();
        this.f١٠٣٤٩d = new RectF();
        this.f١٠٣٥٠e = new RectF();
        this.f١٠٣٥١f = new int[2];
    }
}
