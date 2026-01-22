package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogJoinedLevelBinding extends ViewDataBinding {
    public final LinearLayout bgRoot;
    public final TextView cancelButton;
    public final TextView confirmButton;
    public final View joinPublic;
    public final View joinedLevel;
    public final EditText levelEdit;
    public final LinearLayout llLevelEdit;
    protected View.OnClickListener mClick;
    public final LinearLayout radioGroup;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogJoinedLevelBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, View view2, View view3, EditText editText, LinearLayout linearLayout2, LinearLayout linearLayout3, TextView textView3) {
        super(obj, view, i);
        this.bgRoot = linearLayout;
        this.cancelButton = textView;
        this.confirmButton = textView2;
        this.joinPublic = view2;
        this.joinedLevel = view3;
        this.levelEdit = editText;
        this.llLevelEdit = linearLayout2;
        this.radioGroup = linearLayout3;
        this.title = textView3;
    }

    public static DialogJoinedLevelBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogJoinedLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogJoinedLevelBinding bind(View view, Object obj) {
        return (DialogJoinedLevelBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_joined_level);
    }

    @Deprecated
    public static DialogJoinedLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogJoinedLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_joined_level, viewGroup, z, obj);
    }

    public static DialogJoinedLevelBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogJoinedLevelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogJoinedLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_joined_level, (ViewGroup) null, false, obj);
    }
}
