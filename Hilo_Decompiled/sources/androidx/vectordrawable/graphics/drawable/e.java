package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.core.content.res.k;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class e extends i implements Animatable {

    /* renamed from: b, reason: collision with root package name */
    private c f٤٣٩١b;

    /* renamed from: c, reason: collision with root package name */
    private Context f٤٣٩٢c;

    /* renamed from: d, reason: collision with root package name */
    private ArgbEvaluator f٤٣٩٣d;

    /* renamed from: e, reason: collision with root package name */
    d f٤٣٩٤e;

    /* renamed from: f, reason: collision with root package name */
    private Animator.AnimatorListener f٤٣٩٥f;

    /* renamed from: g, reason: collision with root package name */
    ArrayList f٤٣٩٦g;

    /* renamed from: h, reason: collision with root package name */
    final Drawable.Callback f٤٣٩٧h;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            e.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            e.this.scheduleSelf(runnable, j10);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            e.this.unscheduleSelf(runnable);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ArrayList arrayList = new ArrayList(e.this.f٤٣٩٦g);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((androidx.vectordrawable.graphics.drawable.b) arrayList.get(i10)).b(e.this);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ArrayList arrayList = new ArrayList(e.this.f٤٣٩٦g);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                ((androidx.vectordrawable.graphics.drawable.b) arrayList.get(i10)).c(e.this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        int f٤٤٠٠a;

        /* renamed from: b, reason: collision with root package name */
        j f٤٤٠١b;

        /* renamed from: c, reason: collision with root package name */
        AnimatorSet f٤٤٠٢c;

        /* renamed from: d, reason: collision with root package name */
        ArrayList f٤٤٠٣d;

        /* renamed from: e, reason: collision with root package name */
        androidx.collection.a f٤٤٠٤e;

        public c(Context context, c cVar, Drawable.Callback callback, Resources resources) {
            if (cVar != null) {
                this.f٤٤٠٠a = cVar.f٤٤٠٠a;
                j jVar = cVar.f٤٤٠١b;
                if (jVar != null) {
                    Drawable.ConstantState constantState = jVar.getConstantState();
                    if (resources != null) {
                        this.f٤٤٠١b = (j) constantState.newDrawable(resources);
                    } else {
                        this.f٤٤٠١b = (j) constantState.newDrawable();
                    }
                    j jVar2 = (j) this.f٤٤٠١b.mutate();
                    this.f٤٤٠١b = jVar2;
                    jVar2.setCallback(callback);
                    this.f٤٤٠١b.setBounds(cVar.f٤٤٠١b.getBounds());
                    this.f٤٤٠١b.h(false);
                }
                ArrayList arrayList = cVar.f٤٤٠٣d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f٤٤٠٣d = new ArrayList(size);
                    this.f٤٤٠٤e = new androidx.collection.a(size);
                    for (int i10 = 0; i10 < size; i10++) {
                        Animator animator = (Animator) cVar.f٤٤٠٣d.get(i10);
                        Animator clone = animator.clone();
                        String str = (String) cVar.f٤٤٠٤e.get(animator);
                        clone.setTarget(this.f٤٤٠١b.d(str));
                        this.f٤٤٠٣d.add(clone);
                        this.f٤٤٠٤e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f٤٤٠٢c == null) {
                this.f٤٤٠٢c = new AnimatorSet();
            }
            this.f٤٤٠٢c.playTogether(this.f٤٤٠٣d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f٤٤٠٠a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    e() {
        this(null, null, null);
    }

    public static e a(Context context, int i10) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            e eVar = new e(context);
            Drawable f10 = androidx.core.content.res.h.f(context.getResources(), i10, context.getTheme());
            eVar.f٤٤٠٨a = f10;
            f10.setCallback(eVar.f٤٣٩٧h);
            eVar.f٤٣٩٤e = new d(eVar.f٤٤٠٨a.getConstantState());
            return eVar;
        }
        try {
            XmlResourceParser xml = context.getResources().getXml(i10);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return b(context, context.getResources(), xml, asAttributeSet, context.getTheme());
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e10) {
            Log.e("AnimatedVDCompat", "parser error", e10);
            return null;
        } catch (XmlPullParserException e11) {
            Log.e("AnimatedVDCompat", "parser error", e11);
            return null;
        }
    }

    public static e b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        e eVar = new e(context);
        eVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return eVar;
    }

    private static void d(AnimatedVectorDrawable animatedVectorDrawable, androidx.vectordrawable.graphics.drawable.b bVar) {
        animatedVectorDrawable.registerAnimationCallback(bVar.a());
    }

    private void e() {
        Animator.AnimatorListener animatorListener = this.f٤٣٩٥f;
        if (animatorListener != null) {
            this.f٤٣٩١b.f٤٤٠٢c.removeListener(animatorListener);
            this.f٤٣٩٥f = null;
        }
    }

    private void f(String str, Animator animator) {
        animator.setTarget(this.f٤٣٩١b.f٤٤٠١b.d(str));
        c cVar = this.f٤٣٩١b;
        if (cVar.f٤٤٠٣d == null) {
            cVar.f٤٤٠٣d = new ArrayList();
            this.f٤٣٩١b.f٤٤٠٤e = new androidx.collection.a();
        }
        this.f٤٣٩١b.f٤٤٠٣d.add(animator);
        this.f٤٣٩١b.f٤٤٠٤e.put(animator, str);
    }

    private static boolean h(AnimatedVectorDrawable animatedVectorDrawable, androidx.vectordrawable.graphics.drawable.b bVar) {
        boolean unregisterAnimationCallback;
        unregisterAnimationCallback = animatedVectorDrawable.unregisterAnimationCallback(bVar.a());
        return unregisterAnimationCallback;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            h2.b.a(drawable, theme);
        }
    }

    public void c(androidx.vectordrawable.graphics.drawable.b bVar) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            d((AnimatedVectorDrawable) drawable, bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        if (this.f٤٣٩٦g == null) {
            this.f٤٣٩٦g = new ArrayList();
        }
        if (this.f٤٣٩٦g.contains(bVar)) {
            return;
        }
        this.f٤٣٩٦g.add(bVar);
        if (this.f٤٣٩٥f == null) {
            this.f٤٣٩٥f = new b();
        }
        this.f٤٣٩١b.f٤٤٠٢c.addListener(this.f٤٣٩٥f);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return h2.b.b(drawable);
        }
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f٤٣٩١b.f٤٤٠١b.draw(canvas);
        if (this.f٤٣٩١b.f٤٤٠٢c.isStarted()) {
            invalidateSelf();
        }
    }

    public boolean g(androidx.vectordrawable.graphics.drawable.b bVar) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            h((AnimatedVectorDrawable) drawable, bVar);
        }
        ArrayList arrayList = this.f٤٣٩٦g;
        if (arrayList != null && bVar != null) {
            boolean remove = arrayList.remove(bVar);
            if (this.f٤٣٩٦g.size() == 0) {
                e();
            }
            return remove;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return h2.b.d(drawable);
        }
        return this.f٤٣٩١b.f٤٤٠١b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f٤٣٩١b.f٤٤٠٠a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return h2.b.e(drawable);
        }
        return this.f٤٣٩١b.f٤٤٠١b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f٤٤٠٨a != null && Build.VERSION.SDK_INT >= 24) {
            return new d(this.f٤٤٠٨a.getConstantState());
        }
        return null;
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f٤٣٩١b.f٤٤٠١b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f٤٣٩١b.f٤٤٠١b.getIntrinsicWidth();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f٤٣٩١b.f٤٤٠١b.getOpacity();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            h2.b.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray k10 = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f٤٣٨١e);
                    int resourceId = k10.getResourceId(0, 0);
                    if (resourceId != 0) {
                        j b10 = j.b(resources, resourceId, theme);
                        b10.h(false);
                        b10.setCallback(this.f٤٣٩٧h);
                        j jVar = this.f٤٣٩١b.f٤٤٠١b;
                        if (jVar != null) {
                            jVar.setCallback(null);
                        }
                        this.f٤٣٩١b.f٤٤٠١b = b10;
                    }
                    k10.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.vectordrawable.graphics.drawable.a.f٤٣٨٢f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f٤٣٩٢c;
                        if (context != null) {
                            f(string, g.i(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f٤٣٩١b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return h2.b.h(drawable);
        }
        return this.f٤٣٩١b.f٤٤٠١b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f٤٣٩١b.f٤٤٠٢c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f٤٣٩١b.f٤٤٠١b.isStateful();
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f٤٣٩١b.f٤٤٠١b.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i10) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        return this.f٤٣٩١b.f٤٤٠١b.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f٤٣٩١b.f٤٤٠١b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.f٤٣٩١b.f٤٤٠١b.setAlpha(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            h2.b.j(drawable, z10);
        } else {
            this.f٤٣٩١b.f٤٤٠١b.setAutoMirrored(z10);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i10) {
        super.setChangingConfigurations(i10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i10, PorterDuff.Mode mode) {
        super.setColorFilter(i10, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f10, float f11) {
        super.setHotspot(f10, f11);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i10, int i11, int i12, int i13) {
        super.setHotspotBounds(i10, i11, i12, i13);
    }

    @Override // androidx.vectordrawable.graphics.drawable.i, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i10) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            h2.b.n(drawable, i10);
        } else {
            this.f٤٣٩١b.f٤٤٠١b.setTint(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            h2.b.o(drawable, colorStateList);
        } else {
            this.f٤٣٩١b.f٤٤٠١b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            h2.b.p(drawable, mode);
        } else {
            this.f٤٣٩١b.f٤٤٠١b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f٤٣٩١b.f٤٤٠١b.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else {
            if (this.f٤٣٩١b.f٤٤٠٢c.isStarted()) {
                return;
            }
            this.f٤٣٩١b.f٤٤٠٢c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f٤٣٩١b.f٤٤٠٢c.end();
        }
    }

    private e(Context context) {
        this(context, null, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f٤٤٠٨a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f٤٣٩١b.f٤٤٠١b.setColorFilter(colorFilter);
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    private static class d extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f٤٤٠٥a;

        public d(Drawable.ConstantState constantState) {
            this.f٤٤٠٥a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f٤٤٠٥a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f٤٤٠٥a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            e eVar = new e();
            Drawable newDrawable = this.f٤٤٠٥a.newDrawable();
            eVar.f٤٤٠٨a = newDrawable;
            newDrawable.setCallback(eVar.f٤٣٩٧h);
            return eVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            e eVar = new e();
            Drawable newDrawable = this.f٤٤٠٥a.newDrawable(resources);
            eVar.f٤٤٠٨a = newDrawable;
            newDrawable.setCallback(eVar.f٤٣٩٧h);
            return eVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            e eVar = new e();
            Drawable newDrawable = this.f٤٤٠٥a.newDrawable(resources, theme);
            eVar.f٤٤٠٨a = newDrawable;
            newDrawable.setCallback(eVar.f٤٣٩٧h);
            return eVar;
        }
    }

    private e(Context context, c cVar, Resources resources) {
        this.f٤٣٩٣d = null;
        this.f٤٣٩٥f = null;
        this.f٤٣٩٦g = null;
        a aVar = new a();
        this.f٤٣٩٧h = aVar;
        this.f٤٣٩٢c = context;
        if (cVar != null) {
            this.f٤٣٩١b = cVar;
        } else {
            this.f٤٣٩١b = new c(context, cVar, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
