package com.oudi.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.oudi.utils.log.ILog;
import com.oudi.widget.ViewPage2TabLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002:\u0002)*B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001cR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/oudi/widget/ViewPage2TabLayout;", "Lcom/google/android/material/tabs/TabLayout;", "Lcom/google/android/material/tabs/TabLayout$d;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lcom/oudi/widget/ViewPage2TabLayout$CustomTabAdapter;", "adapter", "", "setCustomTabAdapter", "(Lcom/oudi/widget/ViewPage2TabLayout$CustomTabAdapter;)V", "position", "setCustomTabUnSelect", "(I)V", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "setViewPager2", "(Landroidx/viewpager2/widget/ViewPager2;Lcom/oudi/widget/ViewPage2TabLayout$CustomTabAdapter;)V", "Lcom/google/android/material/tabs/TabLayout$f;", "tab", "onTabSelected", "(Lcom/google/android/material/tabs/TabLayout$f;)V", "onTabUnselected", "onTabReselected", "Lcom/oudi/widget/ViewPage2TabLayout$CustomTabAdapter;", "mViewPage", "Landroidx/viewpager2/widget/ViewPager2;", "", "reSetTab", "Z", "getReSetTab", "()Z", "setReSetTab", "(Z)V", "CustomTabAdapter", "StandardTextTabAdapter", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ViewPage2TabLayout extends TabLayout implements TabLayout.d {

    @Nullable
    private CustomTabAdapter adapter;

    @Nullable
    private ViewPager2 mViewPage;
    private boolean reSetTab;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016J\"\u0010\f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, d2 = {"Lcom/oudi/widget/ViewPage2TabLayout$CustomTabAdapter;", "", "getTabView", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "", "onTabSelected", "", "tabView", "onTabUnselected", "onTabUnSelected2", "selectPosition", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
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

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010#\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0094\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\n\u001a\u00020\tX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018¨\u0006$"}, d2 = {"Lcom/oudi/widget/ViewPage2TabLayout$StandardTextTabAdapter;", "Lcom/oudi/widget/ViewPage2TabLayout$CustomTabAdapter;", "Lcom/oudi/utils/log/ILog;", "titles", "", "", "selectColor", "unSelectColor", "selectSize", "", "unSelectSize", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;II)V", "getTitles", "()Ljava/util/List;", "getSelectColor", "()Ljava/lang/String;", "setSelectColor", "(Ljava/lang/String;)V", "getUnSelectColor", "setUnSelectColor", "getSelectSize", "()I", "setSelectSize", "(I)V", "getUnSelectSize", "setUnSelectSize", "getTabView", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "onTabSelected", "", "tabView", "onTabUnselected", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class StandardTextTabAdapter implements CustomTabAdapter, ILog {

        @Nullable
        private String selectColor;
        private int selectSize;

        @NotNull
        private final List<String> titles;

        @Nullable
        private String unSelectColor;
        private int unSelectSize;

        public StandardTextTabAdapter(@NotNull List<String> titles, @Nullable String str, @Nullable String str2, int i10, int i11) {
            Intrinsics.checkNotNullParameter(titles, "titles");
            this.titles = titles;
            this.selectColor = str;
            this.unSelectColor = str2;
            this.selectSize = i10;
            this.unSelectSize = i11;
        }

        @Override // com.oudi.utils.log.ILog
        @NotNull
        public String getLogTag() {
            return ILog.DefaultImpls.getLogTag(this);
        }

        @Nullable
        public String getSelectColor() {
            return this.selectColor;
        }

        public final int getSelectSize() {
            return this.selectSize;
        }

        @Override // com.oudi.widget.ViewPage2TabLayout.CustomTabAdapter
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
            try {
                String unSelectColor = getUnSelectColor();
                if (unSelectColor != null) {
                    customTextView.setTextColor(Color.parseColor(unSelectColor));
                    customTextView.setTextSize(2, this.unSelectSize);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            return customTextView;
        }

        @NotNull
        public final List<String> getTitles() {
            return this.titles;
        }

        @Nullable
        public String getUnSelectColor() {
            return this.unSelectColor;
        }

        public final int getUnSelectSize() {
            return this.unSelectSize;
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

        @Override // com.oudi.widget.ViewPage2TabLayout.CustomTabAdapter
        public void onTabSelected(int position, @Nullable View tabView) {
            CustomTextView customTextView;
            if (tabView instanceof CustomTextView) {
                customTextView = (CustomTextView) tabView;
            } else {
                customTextView = null;
            }
            if (customTextView != null) {
                try {
                    String selectColor = getSelectColor();
                    if (selectColor != null) {
                        customTextView.setTextColor(Color.parseColor(selectColor));
                        customTextView.setTextSize(2, this.selectSize);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                if (!customTextView.isSelected()) {
                    customTextView.setSelected(true);
                }
            }
        }

        @Override // com.oudi.widget.ViewPage2TabLayout.CustomTabAdapter
        public void onTabUnSelected2(int i10, @Nullable View view, int i11) {
            CustomTabAdapter.DefaultImpls.onTabUnSelected2(this, i10, view, i11);
        }

        @Override // com.oudi.widget.ViewPage2TabLayout.CustomTabAdapter
        public void onTabUnselected(int position, @Nullable View tabView) {
            CustomTextView customTextView;
            if (tabView instanceof CustomTextView) {
                customTextView = (CustomTextView) tabView;
            } else {
                customTextView = null;
            }
            if (customTextView != null) {
                try {
                    String unSelectColor = getUnSelectColor();
                    if (unSelectColor != null) {
                        customTextView.setTextColor(Color.parseColor(unSelectColor));
                        customTextView.setTextSize(2, this.unSelectSize);
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                if (customTextView.isSelected()) {
                    customTextView.setSelected(false);
                }
            }
        }

        public void setSelectColor(@Nullable String str) {
            this.selectColor = str;
        }

        public final void setSelectSize(int i10) {
            this.selectSize = i10;
        }

        public void setUnSelectColor(@Nullable String str) {
            this.unSelectColor = str;
        }

        public final void setUnSelectSize(int i10) {
            this.unSelectSize = i10;
        }

        @Override // com.oudi.utils.log.ILog
        public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
            ILog.DefaultImpls.logE(this, str, th, str2, z10);
        }

        @Override // com.oudi.utils.log.ILog
        public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
            ILog.DefaultImpls.logE(this, th, str, z10);
        }

        public /* synthetic */ StandardTextTabAdapter(List list, String str, String str2, int i10, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, (i12 & 2) != 0 ? null : str, (i12 & 4) != 0 ? null : str2, (i12 & 8) != 0 ? 15 : i10, (i12 & 16) != 0 ? 15 : i11);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPage2TabLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void setCustomTabAdapter(CustomTabAdapter adapter) {
        this.adapter = adapter;
        addOnTabSelectedListener((TabLayout.d) this);
    }

    private final void setCustomTabUnSelect(int position) {
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
                customTabAdapter.onTabUnSelected2(i10, view, position);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setViewPager2$lambda$0(CustomTabAdapter customTabAdapter, ViewPage2TabLayout viewPage2TabLayout, TabLayout.f tab, int i10) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        Context context = viewPage2TabLayout.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        tab.o(customTabAdapter.getTabView(context, i10));
    }

    public final boolean getReSetTab() {
        return this.reSetTab;
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabReselected(@Nullable TabLayout.f tab) {
    }

    @Override // com.google.android.material.tabs.TabLayout.c
    public void onTabSelected(@NotNull TabLayout.f tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        CustomTabAdapter customTabAdapter = this.adapter;
        if (customTabAdapter != null) {
            customTabAdapter.onTabSelected(tab.g(), tab.e());
        }
        if (this.reSetTab) {
            setCustomTabUnSelect(tab.g());
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

    public final void setReSetTab(boolean z10) {
        this.reSetTab = z10;
    }

    public final void setViewPager2(@NotNull ViewPager2 viewPager, @NotNull final CustomTabAdapter adapter) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.mViewPage = viewPager;
        setCustomTabAdapter(adapter);
        new com.google.android.material.tabs.d(this, viewPager, new d.b() { // from class: com.oudi.widget.b0
            @Override // com.google.android.material.tabs.d.b
            public final void a(TabLayout.f fVar, int i10) {
                ViewPage2TabLayout.setViewPager2$lambda$0(ViewPage2TabLayout.CustomTabAdapter.this, this, fVar, i10);
            }
        }).a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPage2TabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPage2TabLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
