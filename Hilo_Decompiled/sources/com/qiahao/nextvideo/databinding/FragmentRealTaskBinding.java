package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentRealTaskBinding extends ViewDataBinding {
    public final ImageView arrow;
    public final RecyclerView dailyTasksRecycler;
    public final FrameLayout endLayout;
    public final TextView goddess;
    public final RecyclerView growthTasksRecycler;
    public final LinearLayoutCompat linearLayout;
    public final ConstraintLayout realConstraint;
    public final View realLine;
    public final TextView realPerson;
    public final ImageView realPersonIcon;
    public final TextView realText;
    public final NestedScrollView scrollView;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentRealTaskBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView, FrameLayout frameLayout, TextView textView, RecyclerView recyclerView2, LinearLayoutCompat linearLayoutCompat, ConstraintLayout constraintLayout, View view2, TextView textView2, ImageView imageView2, TextView textView3, NestedScrollView nestedScrollView) {
        super(obj, view, i);
        this.arrow = imageView;
        this.dailyTasksRecycler = recyclerView;
        this.endLayout = frameLayout;
        this.goddess = textView;
        this.growthTasksRecycler = recyclerView2;
        this.linearLayout = linearLayoutCompat;
        this.realConstraint = constraintLayout;
        this.realLine = view2;
        this.realPerson = textView2;
        this.realPersonIcon = imageView2;
        this.realText = textView3;
        this.scrollView = nestedScrollView;
    }

    public static FragmentRealTaskBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentRealTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentRealTaskBinding bind(View view, Object obj) {
        return (FragmentRealTaskBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_real_task);
    }

    @Deprecated
    public static FragmentRealTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentRealTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_real_task, viewGroup, z, obj);
    }

    public static FragmentRealTaskBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentRealTaskBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentRealTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_real_task, (ViewGroup) null, false, obj);
    }
}
