package com.qhqc.core.basic.uiframe.ui.dialogfragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.qhqc.core.basic.R;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0003J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H&J&\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/BasicDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "options", "Lcom/qhqc/core/basic/uiframe/ui/dialogfragment/DialogOptions;", "getAnimationStyles", "", "gravity", "getDialogTag", "", "getOptions", "onCreateDefView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "show", "", "mContext", "Landroid/content/Context;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "fragment", "Landroidx/fragment/app/Fragment;", "manager", "Landroidx/fragment/app/FragmentManager;", "showSafe", ViewHierarchyConstants.TAG_KEY, "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public abstract class BasicDialogFragment extends DialogFragment {

    @NotNull
    private DialogOptions options = new DialogOptions();

    private final int getAnimationStyles(int gravity) {
        if (gravity != 48) {
            if (gravity != 80) {
                if (gravity != 8388611) {
                    if (gravity != 8388613) {
                        return R.style.basic_dialog_fragment_anim_center;
                    }
                    return R.style.basic_dialog_fragment_anim_end;
                }
                return R.style.basic_dialog_fragment_anim_start;
            }
            return R.style.basic_dialog_fragment_anim_bottom;
        }
        return R.style.basic_dialog_fragment_anim_top;
    }

    @Nullable
    public String getDialogTag() {
        return getClass().getSimpleName();
    }

    @NotNull
    public DialogOptions getOptions() {
        return new DialogOptions();
    }

    @NotNull
    public abstract View onCreateDefView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Window window;
        int i10;
        View decorView;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.options = getOptions();
        Dialog dialog = getDialog();
        WindowManager.LayoutParams layoutParams = null;
        if (dialog != null) {
            window = dialog.getWindow();
        } else {
            window = null;
        }
        if (window != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
        }
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.setPadding(0, 0, 0, 0);
        }
        if (window != null) {
            layoutParams = window.getAttributes();
        }
        if (layoutParams != null) {
            layoutParams.gravity = this.options.getGravity();
        }
        int i11 = -2;
        if (layoutParams != null) {
            if (this.options.getIsWidthMatch()) {
                i10 = -1;
            } else {
                i10 = -2;
            }
            layoutParams.width = i10;
        }
        if (layoutParams != null) {
            if (this.options.getIsHeightMatch()) {
                i11 = -1;
            }
            layoutParams.height = i11;
        }
        if (layoutParams != null) {
            layoutParams.dimAmount = this.options.getDimAmount();
        }
        if (window != null) {
            window.setAttributes(layoutParams);
        }
        if (window != null) {
            window.setWindowAnimations(getAnimationStyles(this.options.getGravity()));
        }
        return onCreateDefView(inflater, container, savedInstanceState);
    }

    public void show(@NotNull FragmentManager manager) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        super.show(manager, getDialogTag());
    }

    public final void showSafe(@NotNull FragmentManager manager, @Nullable String tag) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        try {
            Field declaredField = getClass().getDeclaredField("mDismissed");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.FALSE);
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        } catch (NoSuchFieldException e11) {
            e11.printStackTrace();
        }
        try {
            Field declaredField2 = DialogFragment.class.getDeclaredField("mShownByMe");
            declaredField2.setAccessible(true);
            declaredField2.set(this, Boolean.TRUE);
        } catch (IllegalAccessException e12) {
            e12.printStackTrace();
        } catch (NoSuchFieldException e13) {
            e13.printStackTrace();
        }
        FragmentTransaction beginTransaction = manager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
        beginTransaction.add(this, tag);
        beginTransaction.commitAllowingStateLoss();
    }

    public void show(@NotNull AppCompatActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        show(supportFragmentManager);
    }

    public void show(@Nullable Fragment fragment) {
        if (fragment != null) {
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "getChildFragmentManager(...)");
            show(childFragmentManager);
        }
    }

    public void show(@Nullable Context mContext) {
        if (mContext instanceof AppCompatActivity) {
            show((AppCompatActivity) mContext);
        }
    }
}
