package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.widget.CustomTabLayout;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.TaskView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class FragmentGoldTaskBinding extends ViewDataBinding {
    public final ConstraintLayout goldLayout;
    public final TextView goldText;
    public final View line;
    public final ImageView question;
    public final RecyclerView recyclerView;
    public final TextView signIn;
    public final TextView subTitle;
    public final CustomTabLayout tabLayout;
    public final ConstraintLayout taskLayout;
    public final TaskView taskView;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public FragmentGoldTaskBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, TextView textView, View view2, ImageView imageView, RecyclerView recyclerView, TextView textView2, TextView textView3, CustomTabLayout customTabLayout, ConstraintLayout constraintLayout2, TaskView taskView, TextView textView4) {
        super(obj, view, i);
        this.goldLayout = constraintLayout;
        this.goldText = textView;
        this.line = view2;
        this.question = imageView;
        this.recyclerView = recyclerView;
        this.signIn = textView2;
        this.subTitle = textView3;
        this.tabLayout = customTabLayout;
        this.taskLayout = constraintLayout2;
        this.taskView = taskView;
        this.title = textView4;
    }

    public static FragmentGoldTaskBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static FragmentGoldTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static FragmentGoldTaskBinding bind(View view, Object obj) {
        return (FragmentGoldTaskBinding) ViewDataBinding.bind(obj, view, R.layout.fragment_gold_task);
    }

    @Deprecated
    public static FragmentGoldTaskBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (FragmentGoldTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_gold_task, viewGroup, z, obj);
    }

    public static FragmentGoldTaskBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static FragmentGoldTaskBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (FragmentGoldTaskBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_gold_task, (ViewGroup) null, false, obj);
    }
}
