package com.qiahao.nextvideo.ui.home.discover;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.oudi.utils.ktx.ResourcesKtxKt;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/qiahao/nextvideo/ui/home/discover/ActivitiesTabLayoutAdapter;", "Lcom/oudi/widget/ViewPage2TabLayout$CustomTabAdapter;", "list", "", "", "<init>", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "setList", "getTabView", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "", "onTabSelected", "", "tabView", "onTabUnselected", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class ActivitiesTabLayoutAdapter implements ViewPage2TabLayout.CustomTabAdapter {

    @NotNull
    private List<String> list;

    public ActivitiesTabLayoutAdapter(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
    }

    @NotNull
    public final List<String> getList() {
        return this.list;
    }

    @NotNull
    public View getTabView(@NotNull Context context, int position) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.tab_layout_text, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        TextView textView = (TextView) inflate.findViewById(2131365073);
        String str = (String) CollectionsKt.getOrNull(this.list, position);
        if (str == null) {
            str = "";
        }
        textView.setText(str);
        onTabUnselected(position, textView);
        return inflate;
    }

    public void onTabSelected(int position, @Nullable View tabView) {
        TextView textView;
        ViewPage2TabLayout.CustomTabAdapter.DefaultImpls.onTabSelected(this, position, tabView);
        if (tabView != null && (textView = (TextView) tabView.findViewById(2131365073)) != null) {
            textView.setTextSize(UiKtxKt.getPx(15));
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setTextColor(ResourcesKtxKt.getColorById(context, 2131099872));
            textView.setTypeface(Typeface.defaultFromStyle(1));
        }
    }

    public void onTabUnSelected2(int i, @Nullable View view, int i2) {
        ViewPage2TabLayout.CustomTabAdapter.DefaultImpls.onTabUnSelected2(this, i, view, i2);
    }

    public void onTabUnselected(int position, @Nullable View tabView) {
        TextView textView;
        ViewPage2TabLayout.CustomTabAdapter.DefaultImpls.onTabUnselected(this, position, tabView);
        if (tabView != null && (textView = (TextView) tabView.findViewById(2131365073)) != null) {
            textView.setTextSize(UiKtxKt.getPx(15));
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView.setTextColor(ResourcesKtxKt.getColorById(context, 2131099917));
            textView.setTypeface(Typeface.defaultFromStyle(0));
        }
    }

    public final void setList(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.list = list;
    }
}
