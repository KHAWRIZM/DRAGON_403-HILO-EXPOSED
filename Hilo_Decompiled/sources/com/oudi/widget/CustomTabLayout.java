package com.oudi.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.oudi.utils.log.ILog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0003)*+B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u001b\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0006\u0010\nB#\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0006\u0010\rJ\u001f\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0013\u001a\u00020\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010\u001fJ\u0019\u0010!\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b!\u0010\u001fR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\"R\"\u0010#\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/oudi/widget/CustomTabLayout;", "Lcom/google/android/material/tabs/TabLayout;", "Lcom/google/android/material/tabs/TabLayout$d;", "Lcom/oudi/utils/log/ILog;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Lcom/oudi/widget/CustomTabLayout$CustomTabAdapter;", "adapter", "", "setupWithViewPager", "(Landroidx/viewpager/widget/ViewPager;Lcom/oudi/widget/CustomTabLayout$CustomTabAdapter;)V", "", "autoRefresh", "(Landroidx/viewpager/widget/ViewPager;ZLcom/oudi/widget/CustomTabLayout$CustomTabAdapter;)V", "setCustomTabAdapter", "(Lcom/oudi/widget/CustomTabLayout$CustomTabAdapter;)V", "setCustomTabUnSelect", "()V", "Lcom/google/android/material/tabs/TabLayout$f;", "tab", "onTabSelected", "(Lcom/google/android/material/tabs/TabLayout$f;)V", "onTabUnselected", "onTabReselected", "Lcom/oudi/widget/CustomTabLayout$CustomTabAdapter;", "reSetTab", "Z", "getReSetTab", "()Z", "setReSetTab", "(Z)V", "CustomTabAdapter", "StandardTextTabAdapter", "CustomTextTabAdapter", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CustomTabLayout extends TabLayout implements TabLayout.d, ILog {

    @Nullable
    private CustomTabAdapter adapter;
    private boolean reSetTab;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\"\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"Lcom/oudi/widget/CustomTabLayout$CustomTabAdapter;", "", "getTabView", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "", "onTabSelected", "", "tabView", "onTabUnselected", "onTabUnSelected2", "selectPosition", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface CustomTabAdapter {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
        public static final class DefaultImpls {
            public static void onTabSelected(@NotNull CustomTabAdapter customTabAdapter, int i10, @Nullable View view) {
            }

            public static void onTabUnSelected2(@NotNull CustomTabAdapter customTabAdapter, int i10, @Nullable View view, int i11) {
            }

            public static void onTabUnselected(@NotNull CustomTabAdapter customTabAdapter, int i10, @Nullable View view) {
            }
        }

        @Nullable
        View getTabView(@NotNull Context context, int position);

        void onTabSelected(int position, @Nullable View tabView);

        void onTabUnSelected2(int position, @Nullable View tabView, int selectPosition);

        void onTabUnselected(int position, @Nullable View tabView);
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B;\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/oudi/widget/CustomTabLayout$CustomTextTabAdapter;", "Lcom/oudi/widget/CustomTabLayout$StandardTextTabAdapter;", "Lcom/oudi/utils/log/ILog;", "titles", "", "", "selectedTextAppearance", "", "unSelectedTextAppearance", "selectedStrokeWidth", "", "unSelectedStrokeWidth", "<init>", "(Ljava/util/List;IIFF)V", "getTabView", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "onTabSelected", "", "tabView", "onTabUnselected", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class CustomTextTabAdapter extends StandardTextTabAdapter implements ILog {
        private final float selectedStrokeWidth;
        private final float unSelectedStrokeWidth;

        public /* synthetic */ CustomTextTabAdapter(List list, int i10, int i11, float f10, float f11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, i10, i11, f10, (i12 & 16) != 0 ? f10 : f11);
        }

        @Override // com.oudi.widget.CustomTabLayout.StandardTextTabAdapter, com.oudi.widget.CustomTabLayout.CustomTabAdapter
        @Nullable
        public View getTabView(@NotNull Context context, int position) {
            Intrinsics.checkNotNullParameter(context, "context");
            View tabView = super.getTabView(context, position);
            Intrinsics.checkNotNull(tabView, "null cannot be cast to non-null type com.oudi.widget.CustomTextView");
            ((CustomTextView) tabView).setStrokeWidth(this.unSelectedStrokeWidth);
            return tabView;
        }

        @Override // com.oudi.widget.CustomTabLayout.StandardTextTabAdapter, com.oudi.widget.CustomTabLayout.CustomTabAdapter
        public void onTabSelected(int position, @Nullable View tabView) {
            super.onTabSelected(position, tabView);
            Intrinsics.checkNotNull(tabView, "null cannot be cast to non-null type com.oudi.widget.CustomTextView");
            ((CustomTextView) tabView).setStrokeWidth(this.selectedStrokeWidth);
        }

        @Override // com.oudi.widget.CustomTabLayout.StandardTextTabAdapter, com.oudi.widget.CustomTabLayout.CustomTabAdapter
        public void onTabUnselected(int position, @Nullable View tabView) {
            super.onTabUnselected(position, tabView);
            Intrinsics.checkNotNull(tabView, "null cannot be cast to non-null type com.oudi.widget.CustomTextView");
            ((CustomTextView) tabView).setStrokeWidth(this.unSelectedStrokeWidth);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomTextTabAdapter(@NotNull List<String> titles, int i10, int i11, float f10, float f11) {
            super(titles, i10, i11);
            Intrinsics.checkNotNullParameter(titles, "titles");
            this.selectedStrokeWidth = f10;
            this.unSelectedStrokeWidth = f11;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011H\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\b\u001a\u00020\u0007X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/oudi/widget/CustomTabLayout$StandardTextTabAdapter;", "Lcom/oudi/widget/CustomTabLayout$CustomTabAdapter;", "Lcom/oudi/utils/log/ILog;", "titles", "", "", "selectedTextAppearance", "", "unSelectedTextAppearance", "<init>", "(Ljava/util/List;II)V", "getTitles", "()Ljava/util/List;", "getSelectedTextAppearance", "()I", "getUnSelectedTextAppearance", "getTabView", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "onTabSelected", "", "tabView", "onTabUnselected", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class StandardTextTabAdapter implements CustomTabAdapter, ILog {
        private final int selectedTextAppearance;

        @NotNull
        private final List<String> titles;
        private final int unSelectedTextAppearance;

        public StandardTextTabAdapter(@NotNull List<String> titles, int i10, int i11) {
            Intrinsics.checkNotNullParameter(titles, "titles");
            this.titles = titles;
            this.selectedTextAppearance = i10;
            this.unSelectedTextAppearance = i11;
        }

        @Override // com.oudi.utils.log.ILog
        @NotNull
        public String getLogTag() {
            return ILog.DefaultImpls.getLogTag(this);
        }

        public final int getSelectedTextAppearance() {
            return this.selectedTextAppearance;
        }

        @Override // com.oudi.widget.CustomTabLayout.CustomTabAdapter
        @Nullable
        public View getTabView(@NotNull Context context, int position) {
            Intrinsics.checkNotNullParameter(context, "context");
            String str = (String) CollectionsKt.getOrNull(this.titles, position);
            if (str == null) {
                return null;
            }
            CustomTextView customTextView = new CustomTextView(context);
            customTextView.setText(str);
            customTextView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            customTextView.setIncludeFontPadding(false);
            androidx.core.widget.l.m(customTextView, this.unSelectedTextAppearance);
            return customTextView;
        }

        @NotNull
        public final List<String> getTitles() {
            return this.titles;
        }

        public final int getUnSelectedTextAppearance() {
            return this.unSelectedTextAppearance;
        }

        @Override // com.oudi.utils.log.ILog
        public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
            ILog.DefaultImpls.logD(this, str, str2, z10);
        }

        @Override // com.oudi.utils.log.ILog
        public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
            ILog.DefaultImpls.logE(this, str, str2, z10);
        }

        @Override // com.oudi.utils.log.ILog
        public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
            ILog.DefaultImpls.logI(this, str, str2, z10);
        }

        @Override // com.oudi.utils.log.ILog
        public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
            ILog.DefaultImpls.logV(this, str, str2, z10);
        }

        @Override // com.oudi.utils.log.ILog
        public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
            ILog.DefaultImpls.logW(this, str, str2, z10);
        }

        @Override // com.oudi.widget.CustomTabLayout.CustomTabAdapter
        public void onTabSelected(int position, @Nullable View tabView) {
            CustomTextView customTextView;
            if (tabView instanceof CustomTextView) {
                customTextView = (CustomTextView) tabView;
            } else {
                customTextView = null;
            }
            if (customTextView != null) {
                int i10 = this.selectedTextAppearance;
                if (i10 != this.unSelectedTextAppearance) {
                    androidx.core.widget.l.m(customTextView, i10);
                }
                if (!customTextView.isSelected()) {
                    customTextView.setSelected(true);
                }
            }
        }

        @Override // com.oudi.widget.CustomTabLayout.CustomTabAdapter
        public void onTabUnSelected2(int i10, @Nullable View view, int i11) {
            CustomTabAdapter.DefaultImpls.onTabUnSelected2(this, i10, view, i11);
        }

        @Override // com.oudi.widget.CustomTabLayout.CustomTabAdapter
        public void onTabUnselected(int position, @Nullable View tabView) {
            CustomTextView customTextView;
            if (tabView instanceof CustomTextView) {
                customTextView = (CustomTextView) tabView;
            } else {
                customTextView = null;
            }
            if (customTextView != null) {
                int i10 = this.selectedTextAppearance;
                int i11 = this.unSelectedTextAppearance;
                if (i10 != i11) {
                    androidx.core.widget.l.m(customTextView, i11);
                }
                if (customTextView.isSelected()) {
                    customTextView.setSelected(false);
                }
            }
        }

        @Override // com.oudi.utils.log.ILog
        public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
            ILog.DefaultImpls.logE(this, str, th, str2, z10);
        }

        @Override // com.oudi.utils.log.ILog
        public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
            ILog.DefaultImpls.logE(this, th, str, z10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTabLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    public final boolean getReSetTab() {
        return this.reSetTab;
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logW(this, str, str2, z10);
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabReselected(@Nullable TabLayout.f tab) {
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabSelected(@NotNull TabLayout.f tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        if (this.reSetTab) {
            setCustomTabUnSelect();
        }
        CustomTabAdapter customTabAdapter = this.adapter;
        if (customTabAdapter != null) {
            customTabAdapter.onTabSelected(tab.g(), tab.e());
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabUnselected(@NotNull TabLayout.f tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        CustomTabAdapter customTabAdapter = this.adapter;
        if (customTabAdapter != null) {
            customTabAdapter.onTabUnselected(tab.g(), tab.e());
        }
    }

    public final void setCustomTabAdapter(@NotNull CustomTabAdapter adapter) {
        View view;
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.adapter = adapter;
        int tabCount = getTabCount();
        for (int i10 = 0; i10 < tabCount; i10++) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            View tabView = adapter.getTabView(context, i10);
            TabLayout.f tabAt = getTabAt(i10);
            if (tabAt != null) {
                tabAt.o(tabView);
            }
        }
        addOnTabSelectedListener((TabLayout.d) this);
        if (getSelectedTabPosition() >= 0) {
            int selectedTabPosition = getSelectedTabPosition();
            TabLayout.f tabAt2 = getTabAt(getSelectedTabPosition());
            if (tabAt2 != null) {
                view = tabAt2.e();
            } else {
                view = null;
            }
            adapter.onTabSelected(selectedTabPosition, view);
        }
    }

    public final void setCustomTabUnSelect() {
        View view;
        CustomTabAdapter customTabAdapter = this.adapter;
        if (customTabAdapter != null) {
            int tabCount = getTabCount();
            for (int i10 = 0; i10 < tabCount; i10++) {
                TabLayout.f tabAt = getTabAt(i10);
                if (tabAt != null) {
                    view = tabAt.e();
                } else {
                    view = null;
                }
                customTabAdapter.onTabUnSelected2(i10, view, getSelectedTabPosition());
            }
        }
    }

    public final void setReSetTab(boolean z10) {
        this.reSetTab = z10;
    }

    public final void setupWithViewPager(@Nullable ViewPager viewPager, @NotNull CustomTabAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        setupWithViewPager(viewPager);
        setCustomTabAdapter(adapter);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }

    public final void setupWithViewPager(@Nullable ViewPager viewPager, boolean autoRefresh, @NotNull CustomTabAdapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        setupWithViewPager(viewPager, autoRefresh);
        setCustomTabAdapter(adapter);
    }
}
