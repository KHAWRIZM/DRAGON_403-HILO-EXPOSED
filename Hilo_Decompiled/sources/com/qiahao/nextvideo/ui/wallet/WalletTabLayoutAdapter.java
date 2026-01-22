package com.qiahao.nextvideo.ui.wallet;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.oudi.utils.ktx.UiKtxKt;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.databinding.TabLayoutTextBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/qiahao/nextvideo/ui/wallet/WalletTabLayoutAdapter;", "Lcom/oudi/widget/ViewPage2TabLayout$CustomTabAdapter;", "list", "", "", "<init>", "(Ljava/util/List;)V", "getList", "()Ljava/util/List;", "setList", "getTabView", "Landroid/view/View;", "context", "Landroid/content/Context;", "position", "", "onTabSelected", "", "tabView", "onTabUnSelected2", "selectPosition", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class WalletTabLayoutAdapter implements ViewPage2TabLayout.CustomTabAdapter {

    @NotNull
    private List<String> list;

    public WalletTabLayoutAdapter(@NotNull List<String> list) {
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
        TabLayoutTextBinding tabLayoutTextBinding = (TabLayoutTextBinding) androidx.databinding.g.h(LayoutInflater.from(context), R.layout.tab_layout_text, (ViewGroup) null, false);
        String str = (String) CollectionsKt.getOrNull(this.list, position);
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            tabLayoutTextBinding.textView.setPadding(UiKtxKt.toPX(14), 0, UiKtxKt.toPX(14), 0);
        }
        tabLayoutTextBinding.textView.setText(str);
        View root = tabLayoutTextBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onTabSelected(int position, @Nullable View tabView) {
        TextView textView;
        if (tabView != null && (textView = (TextView) tabView.findViewById(2131365073)) != null) {
            textView.setTextSize(15.0f);
            if (position != 0) {
                if (position != 1) {
                    if (position == 2) {
                        textView.setTextColor(androidx.core.content.a.getColor(textView.getContext(), 2131099872));
                        return;
                    }
                    return;
                }
                textView.setTextColor(androidx.core.content.a.getColor(textView.getContext(), 2131099872));
                return;
            }
            textView.setTextColor(androidx.core.content.a.getColor(textView.getContext(), 2131101214));
        }
    }

    public void onTabUnSelected2(int position, @Nullable View tabView, int selectPosition) {
        TextView textView;
        if (tabView != null && (textView = (TextView) tabView.findViewById(2131365073)) != null) {
            textView.setTextSize(15.0f);
            if (position != 0) {
                if (position != 1) {
                    if (position == 2) {
                        if (selectPosition != 0) {
                            if (selectPosition != 1) {
                                textView.setTextColor(Color.parseColor("#333333"));
                                return;
                            } else {
                                textView.setTextColor(Color.parseColor("#7f333333"));
                                return;
                            }
                        }
                        textView.setTextColor(Color.parseColor("#7fffffff"));
                        return;
                    }
                    return;
                }
                if (selectPosition != 0) {
                    if (selectPosition != 1) {
                        textView.setTextColor(Color.parseColor("#7f333333"));
                        return;
                    } else {
                        textView.setTextColor(Color.parseColor("#333333"));
                        return;
                    }
                }
                textView.setTextColor(Color.parseColor("#7fffffff"));
                return;
            }
            if (selectPosition != 0) {
                if (selectPosition != 1) {
                    textView.setTextColor(Color.parseColor("#7f333333"));
                    return;
                } else {
                    textView.setTextColor(Color.parseColor("#7f333333"));
                    return;
                }
            }
            textView.setTextColor(Color.parseColor("#ffffff"));
        }
    }

    public void onTabUnselected(int i, @Nullable View view) {
        ViewPage2TabLayout.CustomTabAdapter.DefaultImpls.onTabUnselected(this, i, view);
    }

    public final void setList(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.list = list;
    }
}
