package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ViewTaskBinding extends ViewDataBinding {
    public final ViewTaskItemBinding dayLayout1;
    public final ViewTaskItemBinding dayLayout2;
    public final ViewTaskItemBinding dayLayout3;
    public final ViewTaskItemBinding dayLayout4;
    public final ViewTaskItemBinding dayLayout5;
    public final ViewTaskItemBinding dayLayout6;
    public final ViewTaskItemBinding dayLayout7;
    public final View line1;
    public final View line2;
    public final View line3;
    public final View line4;
    public final View line5;
    public final View line6;
    public final ConstraintLayout rootLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewTaskBinding(Object obj, View view, int i, ViewTaskItemBinding viewTaskItemBinding, ViewTaskItemBinding viewTaskItemBinding2, ViewTaskItemBinding viewTaskItemBinding3, ViewTaskItemBinding viewTaskItemBinding4, ViewTaskItemBinding viewTaskItemBinding5, ViewTaskItemBinding viewTaskItemBinding6, ViewTaskItemBinding viewTaskItemBinding7, View view2, View view3, View view4, View view5, View view6, View view7, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.dayLayout1 = viewTaskItemBinding;
        this.dayLayout2 = viewTaskItemBinding2;
        this.dayLayout3 = viewTaskItemBinding3;
        this.dayLayout4 = viewTaskItemBinding4;
        this.dayLayout5 = viewTaskItemBinding5;
        this.dayLayout6 = viewTaskItemBinding6;
        this.dayLayout7 = viewTaskItemBinding7;
        this.line1 = view2;
        this.line2 = view3;
        this.line3 = view4;
        this.line4 = view5;
        this.line5 = view6;
        this.line6 = view7;
        this.rootLayout = constraintLayout;
    }

    public static ViewTaskBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ViewTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ViewTaskBinding bind(View view, Object obj) {
        return (ViewTaskBinding) ViewDataBinding.bind(obj, view, R.layout.view_task);
    }

    @Deprecated
    public static ViewTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ViewTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_task, viewGroup, z, obj);
    }

    public static ViewTaskBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ViewTaskBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ViewTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_task, (ViewGroup) null, false, obj);
    }
}
