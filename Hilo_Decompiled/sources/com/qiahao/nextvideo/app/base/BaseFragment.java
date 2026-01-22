package com.qiahao.nextvideo.app.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\b\u001a\u00020\u00052\n\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u001a\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0016J,\u0010\t\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\u0012\u0010\u0016\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u0012\u0010#\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010$\u001a\u00020\u0005H\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\u0006\u0010(\u001a\u00020\u0005¨\u0006)"}, d2 = {"Lcom/qiahao/nextvideo/app/base/BaseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "restoreState", "forward", "fragment", "hide", "", "viewId", "", "name", "", "backward", "onAttach", "context", "Landroid/content/Context;", "onDetach", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setUserVisibleHint", "isVisibleToUser", "onStart", "onResume", "onSaveInstanceState", "outState", "onViewStateRestored", "onPause", "onStop", "onDestroyView", "onDestroy", "onBackPressed", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class BaseFragment extends Fragment {
    public void backward() {
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            fragmentManager.popBackStack();
        }
    }

    public void forward(@Nullable Fragment fragment, boolean hide) {
        forward(getId(), fragment, null, hide);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        restoreState(savedInstanceState);
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Log.v("BaseFragment", getClass().getName() + this + " onAttach()");
    }

    public final void onBackPressed() {
        backward();
    }

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("BaseFragment", getClass().getName() + this + " onCreate()");
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Log.v("BaseFragment", getClass().getName() + this + " onCreateView()");
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        Log.v("BaseFragment", getClass().getName() + this + " onDestroy()");
    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.v("BaseFragment", getClass().getName() + this + " onDestroyView()");
    }

    public void onDetach() {
        Log.v("BaseFragment", getClass().getName() + this + " onDetach()");
        super.onDetach();
    }

    public void onPause() {
        super.onPause();
        Log.v("BaseFragment", getClass().getName() + this + " onPause()");
    }

    public void onResume() {
        super.onResume();
        Log.v("BaseFragment", getClass().getName() + this + " onResume()");
    }

    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        Log.v("BaseFragment", getClass().getName() + this + " onSaveInstanceState()");
    }

    public void onStart() {
        super.onStart();
        Log.v("BaseFragment", getClass().getName() + this + " onStart()");
    }

    public void onStop() {
        super.onStop();
        Log.v("BaseFragment", getClass().getName() + this + " onStop()");
    }

    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.v("BaseFragment", getClass().getName() + this + " onViewStateRestored()");
    }

    protected void restoreState(@Nullable Bundle savedInstanceState) {
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.v("BaseFragment", getClass().getName() + this + " setUserVisibleHint(), isVisibleToUser:" + isVisibleToUser);
    }

    public void forward(int viewId, @Nullable Fragment fragment, @Nullable String name, boolean hide) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager != null ? fragmentManager.beginTransaction() : null;
        if (hide) {
            if (beginTransaction != null) {
                beginTransaction.hide(this);
            }
            if (beginTransaction != null) {
                Intrinsics.checkNotNull(fragment);
                beginTransaction.add(viewId, fragment);
            }
        } else if (beginTransaction != null) {
            Intrinsics.checkNotNull(fragment);
            beginTransaction.replace(viewId, fragment);
        }
        if (beginTransaction != null) {
            beginTransaction.addToBackStack(name);
        }
        if (beginTransaction != null) {
            beginTransaction.commitAllowingStateLoss();
        }
    }
}
