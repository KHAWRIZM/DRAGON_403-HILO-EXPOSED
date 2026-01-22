package com.qiahao.nextvideo.ui.reusable.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001*B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bJ!\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u001b\u0010\u0014\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R%\u0010#\u001a\u0010\u0012\f\u0012\n \"*\u0004\u0018\u00010\u00160\u00160!8\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0011\u0010)\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/ViewSelector;", "Landroidx/viewpager/widget/ViewPager;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "commonInit", "Landroid/view/MotionEvent;", "event", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "", "Landroid/view/View;", "views", "setViews", "(Ljava/util/List;)V", "", "index", "smoothScroll", "setPageIndex", "(IZ)V", "allowUserInteraction", "Z", "getAllowUserInteraction", "()Z", "setAllowUserInteraction", "(Z)V", "Lla/c;", "kotlin.jvm.PlatformType", "onPageSelectedRelay", "Lla/c;", "getOnPageSelectedRelay", "()Lla/c;", "getCurrentPageIndex", "()I", "currentPageIndex", "ViewSelectorAdapter", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ViewSelector extends ViewPager {
    private boolean allowUserInteraction;

    @NotNull
    private final la.c onPageSelectedRelay;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0016\u0010\u0017R(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u0006¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/ui/reusable/views/ViewSelector$ViewSelectorAdapter;", "Landroidx/viewpager/widget/a;", "", "Landroid/view/View;", "views", "<init>", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "container", "", "position", "", "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "object", "", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "view", "", "isViewFromObject", "(Landroid/view/View;Ljava/lang/Object;)Z", "getCount", "()I", "Ljava/util/List;", "getViews", "()Ljava/util/List;", "setViews", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    private static final class ViewSelectorAdapter extends androidx.viewpager.widget.a {

        @NotNull
        private List<? extends View> views;

        public ViewSelectorAdapter(@NotNull List<? extends View> list) {
            Intrinsics.checkNotNullParameter(list, "views");
            this.views = list;
        }

        public void destroyItem(@NotNull ViewGroup container, int position, @NotNull Object object) {
            View view;
            Intrinsics.checkNotNullParameter(container, "container");
            Intrinsics.checkNotNullParameter(object, "object");
            if (object instanceof View) {
                view = (View) object;
            } else {
                view = null;
            }
            if (view != null) {
                container.removeView(view);
            }
        }

        public int getCount() {
            return this.views.size();
        }

        @NotNull
        public final List<View> getViews() {
            return this.views;
        }

        @NotNull
        public Object instantiateItem(@NotNull ViewGroup container, int position) {
            Intrinsics.checkNotNullParameter(container, "container");
            View view = this.views.get(position);
            container.addView(view, 0);
            return view;
        }

        public boolean isViewFromObject(@NotNull View view, @NotNull Object object) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(object, "object");
            return Intrinsics.areEqual(view, object);
        }

        public final void setViews(@NotNull List<? extends View> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.views = list;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewSelector(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.allowUserInteraction = true;
        la.c e = la.c.e();
        Intrinsics.checkNotNullExpressionValue(e, "create(...)");
        this.onPageSelectedRelay = e;
        commonInit(context, null);
    }

    private final void commonInit(Context context, AttributeSet attrs) {
        addOnPageChangeListener(new ViewPager.j() { // from class: com.qiahao.nextvideo.ui.reusable.views.ViewSelector$commonInit$1
            public void onPageScrollStateChanged(int state) {
            }

            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            public void onPageSelected(int position) {
                ViewSelector.this.getOnPageSelectedRelay().accept(Integer.valueOf(position));
            }
        });
    }

    public static /* synthetic */ void setPageIndex$default(ViewSelector viewSelector, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        viewSelector.setPageIndex(i, z);
    }

    public final boolean getAllowUserInteraction() {
        return this.allowUserInteraction;
    }

    public final int getCurrentPageIndex() {
        return getCurrentItem();
    }

    @NotNull
    public final la.c getOnPageSelectedRelay() {
        return this.onPageSelectedRelay;
    }

    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.allowUserInteraction) {
            return super.onInterceptTouchEvent(event);
        }
        return false;
    }

    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.allowUserInteraction) {
            return super.onTouchEvent(event);
        }
        return false;
    }

    public final void setAllowUserInteraction(boolean z) {
        this.allowUserInteraction = z;
    }

    public final void setPageIndex(int index, boolean smoothScroll) {
        setCurrentItem(index, smoothScroll);
    }

    public final void setViews(@NotNull List<? extends View> views) {
        Intrinsics.checkNotNullParameter(views, "views");
        setAdapter(new ViewSelectorAdapter(views));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewSelector(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.allowUserInteraction = true;
        la.c e = la.c.e();
        Intrinsics.checkNotNullExpressionValue(e, "create(...)");
        this.onPageSelectedRelay = e;
        commonInit(context, attributeSet);
    }
}
