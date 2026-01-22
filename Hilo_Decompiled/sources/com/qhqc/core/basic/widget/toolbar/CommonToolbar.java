package com.qhqc.core.basic.widget.toolbar;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.a;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qhqc.core.basic.widget.databinding.BasicWidgetLayoutCommonToolbarBinding;
import com.qhqc.core.basic.widget.toolbar.CommonToolbar;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001dB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u0001H\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\bJ\u001c\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\bJ\u0010\u0010\u0019\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\bR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/qhqc/core/basic/widget/toolbar/CommonToolbar;", "Landroidx/appcompat/widget/Toolbar;", "Lcom/qhqc/core/basic/widget/toolbar/ICommonToolbar;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mBinding", "Lcom/qhqc/core/basic/widget/databinding/BasicWidgetLayoutCommonToolbarBinding;", "getRootView", "Landroid/view/ViewGroup;", "getToolbar", "setBackIcon", "", "res", "setMenuView", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "setToolbarBackgroundColor", "color", "setToolbarTitle", "charSequence", "", "strRes", "Builder", "basic_widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class CommonToolbar extends Toolbar implements ICommonToolbar {

    @NotNull
    private final BasicWidgetLayoutCommonToolbarBinding mBinding;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010\u000f\u001a\u00020\u00002\b\b\u0001\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\tJ\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/qhqc/core/basic/widget/toolbar/CommonToolbar$Builder;", "", "()V", "mBackIconRes", "", "mBackgroundColor", "mMenuView", "Landroid/view/View;", "mTitle", "", "mTitleRes", "build", "Lcom/qhqc/core/basic/widget/toolbar/CommonToolbar;", "activity", "Landroid/app/Activity;", "setBackIcon", "res", "setBackgroundColor", "color", "setMenuView", ViewHierarchyConstants.VIEW_KEY, "setTitle", "charSequence", "basic_widget_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Builder {
        private int mBackIconRes;
        private int mBackgroundColor = -1;

        @Nullable
        private View mMenuView;

        @Nullable
        private CharSequence mTitle;
        private int mTitleRes;

        @NotNull
        public final CommonToolbar build(@NotNull Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            CommonToolbar commonToolbar = new CommonToolbar(activity, null, 0, 6, null);
            int i10 = this.mBackIconRes;
            if (i10 != 0) {
                commonToolbar.setBackIcon(i10);
            }
            CharSequence charSequence = this.mTitle;
            if (charSequence != null && charSequence.length() != 0) {
                commonToolbar.setToolbarTitle(this.mTitle);
            }
            int i11 = this.mTitleRes;
            if (i11 != 0) {
                commonToolbar.setToolbarTitle(i11);
            }
            View view = this.mMenuView;
            if (view != null) {
                CommonToolbar.setMenuView$default(commonToolbar, view, null, 2, null);
            }
            commonToolbar.setToolbarBackgroundColor(this.mBackgroundColor);
            return commonToolbar;
        }

        @NotNull
        public final Builder setBackIcon(int res) {
            this.mBackIconRes = res;
            return this;
        }

        @NotNull
        public final Builder setBackgroundColor(int color) {
            this.mBackgroundColor = color;
            return this;
        }

        @NotNull
        public final Builder setMenuView(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.mMenuView = view;
            return this;
        }

        @NotNull
        public final Builder setTitle(int res) {
            this.mTitleRes = res;
            return this;
        }

        @NotNull
        public final Builder setTitle(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "charSequence");
            this.mTitle = charSequence;
            return this;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommonToolbar(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void lambda$1$lambda$0(Context context, View view) {
        Activity activity;
        Intrinsics.checkNotNullParameter(context, "$context");
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBackIcon$lambda$2(CommonToolbar this$0, View view) {
        Activity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    public static /* synthetic */ void setMenuView$default(CommonToolbar commonToolbar, View view, ViewGroup.LayoutParams layoutParams, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            layoutParams = null;
        }
        commonToolbar.setMenuView(view, layoutParams);
    }

    @Override // android.view.View
    @NotNull
    public ViewGroup getRootView() {
        return this;
    }

    @Override // com.qhqc.core.basic.widget.toolbar.ICommonToolbar
    @NotNull
    public Toolbar getToolbar() {
        return this;
    }

    public final void setBackIcon(int res) {
        this.mBinding.mIvBack.setImageDrawable(a.getDrawable(getContext(), res));
        this.mBinding.mIvBack.setOnClickListener(new View.OnClickListener() { // from class: ya.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonToolbar.setBackIcon$lambda$2(CommonToolbar.this, view);
            }
        });
    }

    public final void setMenuView(@Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            this.mBinding.mMenuContainer.removeAllViews();
            return;
        }
        if (view.getParent() != null) {
            return;
        }
        this.mBinding.mMenuContainer.removeAllViews();
        LinearLayoutCompat linearLayoutCompat = this.mBinding.mMenuContainer;
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        linearLayoutCompat.addView(view, layoutParams);
    }

    public final void setToolbarBackgroundColor(int color) {
        this.mBinding.mViewStatus.setBackgroundColor(color);
    }

    public final void setToolbarTitle(@Nullable CharSequence charSequence) {
        this.mBinding.mTvTitle.setText(charSequence);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommonToolbar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void setToolbarTitle(int strRes) {
        this.mBinding.mTvTitle.setText(strRes);
    }

    public /* synthetic */ CommonToolbar(Context context, AttributeSet attributeSet, int i10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CommonToolbar(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        Intrinsics.checkNotNullParameter(context, "context");
        BasicWidgetLayoutCommonToolbarBinding inflate = BasicWidgetLayoutCommonToolbarBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mBinding = inflate;
        inflate.mIvBack.setOnClickListener(new View.OnClickListener() { // from class: ya.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommonToolbar.lambda$1$lambda$0(context, view);
            }
        });
    }
}
