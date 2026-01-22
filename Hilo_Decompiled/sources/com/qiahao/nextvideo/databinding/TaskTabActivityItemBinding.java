package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class TaskTabActivityItemBinding extends ViewDataBinding {
    public final View bg;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public TaskTabActivityItemBinding(Object obj, View view, int i, View view2, TextView textView) {
        super(obj, view, i);
        this.bg = view2;
        this.title = textView;
    }

    public static TaskTabActivityItemBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static TaskTabActivityItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static TaskTabActivityItemBinding bind(View view, Object obj) {
        return (TaskTabActivityItemBinding) ViewDataBinding.bind(obj, view, R.layout.task_tab_activity_item);
    }

    @Deprecated
    public static TaskTabActivityItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (TaskTabActivityItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.task_tab_activity_item, viewGroup, z, obj);
    }

    public static TaskTabActivityItemBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static TaskTabActivityItemBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (TaskTabActivityItemBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.task_tab_activity_item, (ViewGroup) null, false, obj);
    }
}
