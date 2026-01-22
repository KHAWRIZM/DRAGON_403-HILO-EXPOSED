package com.qhqc.core.feature.community.ui.adapter.stateview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.qhqc.core.basic.rvadapter.d;
import com.qhqc.core.feature.community.databinding.LayoutLoadingViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/qhqc/core/feature/community/ui/adapter/stateview/CommunityAdapterLoadingView;", "Lcom/qhqc/core/basic/rvadapter/d;", "<init>", "()V", "Landroid/content/Context;", "context", "Landroid/view/View;", "onCreateView", "(Landroid/content/Context;)Landroid/view/View;", "feature_community_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CommunityAdapterLoadingView implements d {
    @Override // com.qhqc.core.basic.rvadapter.IBasicAdapterStateView
    @NotNull
    public View onCreateView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        RelativeLayout root = LayoutLoadingViewBinding.inflate(LayoutInflater.from(context)).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }
}
