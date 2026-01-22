package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.ArrayList;
import java.util.List;
import p7.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class b implements f {

    /* renamed from: a, reason: collision with root package name */
    private final Context f٩٠٦٧a;

    /* renamed from: b, reason: collision with root package name */
    private final ExtendedFloatingActionButton f٩٠٦٨b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList f٩٠٦٩c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.a f٩٠٧٠d;

    /* renamed from: e, reason: collision with root package name */
    private h f٩٠٧١e;

    /* renamed from: f, reason: collision with root package name */
    private h f٩٠٧٢f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            return Float.valueOf(p7.a.a(DownloadProgress.UNKNOWN_PROGRESS, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.V.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f٩٠٦٨b.V.getDefaultColor()))));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f10) {
            int colorForState = extendedFloatingActionButton.V.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f٩٠٦٨b.V.getDefaultColor());
            ColorStateList valueOf = ColorStateList.valueOf(Color.argb((int) (p7.a.a(DownloadProgress.UNKNOWN_PROGRESS, Color.alpha(colorForState) / 255.0f, f10.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f10.floatValue() == 1.0f) {
                extendedFloatingActionButton.S(extendedFloatingActionButton.V);
            } else {
                extendedFloatingActionButton.S(valueOf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.a aVar) {
        this.f٩٠٦٨b = extendedFloatingActionButton;
        this.f٩٠٦٧a = extendedFloatingActionButton.getContext();
        this.f٩٠٧٠d = aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final void a(h hVar) {
        this.f٩٠٧٢f = hVar;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public h c() {
        return this.f٩٠٧٢f;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public void e() {
        this.f٩٠٧٠d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public void g() {
        this.f٩٠٧٠d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final List getListeners() {
        return this.f٩٠٦٩c;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public AnimatorSet h() {
        return k(l());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatorSet k(h hVar) {
        ArrayList arrayList = new ArrayList();
        if (hVar.j("opacity")) {
            arrayList.add(hVar.f("opacity", this.f٩٠٦٨b, View.ALPHA));
        }
        if (hVar.j("scale")) {
            arrayList.add(hVar.f("scale", this.f٩٠٦٨b, View.SCALE_Y));
            arrayList.add(hVar.f("scale", this.f٩٠٦٨b, View.SCALE_X));
        }
        if (hVar.j(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
            arrayList.add(hVar.f(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.f٩٠٦٨b, ExtendedFloatingActionButton.f٩٠١٦d0));
        }
        if (hVar.j(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
            arrayList.add(hVar.f(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.f٩٠٦٨b, ExtendedFloatingActionButton.f٩٠١٧e0));
        }
        if (hVar.j("paddingStart")) {
            arrayList.add(hVar.f("paddingStart", this.f٩٠٦٨b, ExtendedFloatingActionButton.f٩٠١٨f0));
        }
        if (hVar.j("paddingEnd")) {
            arrayList.add(hVar.f("paddingEnd", this.f٩٠٦٨b, ExtendedFloatingActionButton.f٩٠١٩g0));
        }
        if (hVar.j("labelOpacity")) {
            arrayList.add(hVar.f("labelOpacity", this.f٩٠٦٨b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        p7.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final h l() {
        h hVar = this.f٩٠٧٢f;
        if (hVar != null) {
            return hVar;
        }
        if (this.f٩٠٧١e == null) {
            this.f٩٠٧١e = h.d(this.f٩٠٦٧a, f());
        }
        return (h) androidx.core.util.h.g(this.f٩٠٧١e);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public void onAnimationStart(Animator animator) {
        this.f٩٠٧٠d.c(animator);
    }
}
