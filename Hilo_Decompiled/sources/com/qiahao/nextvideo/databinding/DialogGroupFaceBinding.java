package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogGroupFaceBinding extends ViewDataBinding {
    public final RecyclerView faceRecycler;
    protected View.OnClickListener mClick;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogGroupFaceBinding(Object obj, View view, int i, RecyclerView recyclerView) {
        super(obj, view, i);
        this.faceRecycler = recyclerView;
    }

    public static DialogGroupFaceBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogGroupFaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogGroupFaceBinding bind(View view, Object obj) {
        return (DialogGroupFaceBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_group_face);
    }

    @Deprecated
    public static DialogGroupFaceBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogGroupFaceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_group_face, viewGroup, z, obj);
    }

    public static DialogGroupFaceBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogGroupFaceBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogGroupFaceBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_group_face, (ViewGroup) null, false, obj);
    }
}
