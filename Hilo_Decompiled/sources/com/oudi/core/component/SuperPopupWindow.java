package com.oudi.core.component;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.R;
import com.oudi.core.common.LifecycleCleared;
import com.oudi.core.component.IComponent;
import com.oudi.utils.ktx.ContextKtxKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u001d\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0006\u0010\nB%\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\rB-\b\u0017\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\u000fB\u0013\b\u0016\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0006\u0010\u0012B\u0019\b\u0016\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\u0015B#\b\u0016\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f¢\u0006\u0004\b\u0006\u0010\u0016B+\b\u0016\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0006\u0010\u0019J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00112\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J!\u0010\u001d\u001a\u0004\u0018\u0001H\u001e\"\b\b\u0000\u0010\u001e*\u00020\u00112\u0006\u0010\u001f\u001a\u00020\fH\u0016¢\u0006\u0002\u0010 J\n\u0010!\u001a\u0004\u0018\u00010\u0005H\u0016J\r\u0010\"\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\fH\u0015J\n\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u001bH\u0016J*\u0010(\u001a\u00020\u001b2\b\u0010)\u001a\u0004\u0018\u00010\u00112\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\fH\u0016J*\u0010-\u001a\u00020\u001b2\b\u0010.\u001a\u0004\u0018\u00010\u00112\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\f2\u0006\u0010*\u001a\u00020\fH\u0016J\b\u00101\u001a\u00020\u001bH\u0016¨\u00062"}, d2 = {"Lcom/oudi/core/component/SuperPopupWindow;", "Lcom/oudi/core/component/IComponent;", "Landroid/widget/PopupWindow;", "Lcom/oudi/core/common/LifecycleCleared;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "contentView", "Landroid/view/View;", "(Landroid/view/View;)V", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "(II)V", "(Landroid/view/View;II)V", "focusable", "", "(Landroid/view/View;IIZ)V", "onCreate", "", "createView", "findViewById", "T", "id", "(I)Landroid/view/View;", "getContext", "getThemeRes", "()Ljava/lang/Integer;", "getLayoutResId", "getTargetLifecycle", "Landroidx/lifecycle/Lifecycle;", "onTargetCleared", "showAtLocation", "parent", "gravity", "x", "y", "showAsDropDown", "anchor", "xoff", "yoff", "dismiss", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class SuperPopupWindow extends PopupWindow implements IComponent, LifecycleCleared {
    public SuperPopupWindow(@Nullable Context context) {
        this(context, (AttributeSet) null);
    }

    @Override // com.oudi.core.common.LifecycleCleared
    public void bindLifecycleClear() {
        LifecycleCleared.DefaultImpls.bindLifecycleClear(this);
    }

    @Nullable
    public View createView(@Nullable Context context) {
        int layoutResId = getLayoutResId();
        if (layoutResId == -1 || context == null) {
            return null;
        }
        return LayoutInflater.from(context).inflate(layoutResId, (ViewGroup) null);
    }

    @Override // android.widget.PopupWindow
    public void dismiss() {
        super.dismiss();
        unBindLifecycleClear();
    }

    @Override // com.oudi.core.component.IComponent
    @Nullable
    public <T extends View> T findViewById(int id) {
        View contentView = getContentView();
        if (contentView != null) {
            return (T) contentView.findViewById(id);
        }
        return null;
    }

    @Override // com.oudi.core.common.LifecycleCleared
    @Nullable
    public Lifecycle.Event getClearEvent() {
        return LifecycleCleared.DefaultImpls.getClearEvent(this);
    }

    @Override // com.oudi.core.component.IComponent
    @Nullable
    public Context getContext() {
        View contentView = getContentView();
        if (contentView != null) {
            return contentView.getContext();
        }
        return null;
    }

    public int getLayoutResId() {
        return -1;
    }

    @Override // com.oudi.core.common.LifecycleCleared
    @Nullable
    public Lifecycle getTargetLifecycle() {
        return ContextKtxKt.asLifecycle(getContext());
    }

    @Override // com.oudi.core.component.IComponent
    @Nullable
    public final Integer getThemeRes() {
        return IComponent.DefaultImpls.getThemeRes(this);
    }

    @Override // com.oudi.core.common.LifecycleCleared
    public boolean isEnabledLifecycleClear() {
        return LifecycleCleared.DefaultImpls.isEnabledLifecycleClear(this);
    }

    public void onCreate(@Nullable Context context) {
        if (getContentView() == null) {
            setContentView(createView(context));
        }
        onInitializeBefore();
        onInitialize();
        onInitializeAfter();
    }

    @Override // com.oudi.core.component.IComponent
    public void onInitialize() {
        IComponent.DefaultImpls.onInitialize(this);
    }

    @Override // com.oudi.core.component.IComponent
    public void onInitializeAfter() {
        IComponent.DefaultImpls.onInitializeAfter(this);
    }

    @Override // com.oudi.core.component.IComponent
    public void onInitializeBefore() {
        IComponent.DefaultImpls.onInitializeBefore(this);
    }

    @Override // com.oudi.core.common.LifecycleCleared, androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        LifecycleCleared.DefaultImpls.onStateChanged(this, lifecycleOwner, event);
    }

    @Override // com.oudi.core.common.LifecycleCleared
    public void onTargetCleared() {
        dismiss();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(@Nullable View anchor, int xoff, int yoff, int gravity) {
        super.showAsDropDown(anchor, xoff, yoff, gravity);
        bindLifecycleClear();
    }

    @Override // android.widget.PopupWindow
    public void showAtLocation(@Nullable View parent, int gravity, int x10, int y10) {
        super.showAtLocation(parent, gravity, x10, y10);
        bindLifecycleClear();
    }

    @Override // com.oudi.core.common.LifecycleCleared
    public void unBindLifecycleClear() {
        LifecycleCleared.DefaultImpls.unBindLifecycleClear(this);
    }

    public SuperPopupWindow(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.popupWindowStyle);
    }

    public SuperPopupWindow(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    @SuppressLint({"NewApi"})
    public SuperPopupWindow(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        onCreate(context);
    }

    public SuperPopupWindow(@Nullable View view) {
        this(view, 0, 0);
    }

    public SuperPopupWindow(int i10, int i11) {
        this((View) null, i10, i11);
    }

    public SuperPopupWindow(@Nullable View view, int i10, int i11) {
        this(view, i10, i11, false);
    }

    public SuperPopupWindow(@Nullable View view, int i10, int i11, boolean z10) {
        super(view, i10, i11, z10);
        onCreate(view != null ? view.getContext() : null);
    }
}
