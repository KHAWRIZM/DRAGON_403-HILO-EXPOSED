package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.PinEntryEditText;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogPassWordLevelBinding extends ViewDataBinding {
    public final LinearLayout bgRoot;
    public final TextView cancelButton;
    public final TextView confirmButton;
    public final View joinPublic;
    public final View joinedPassWord;
    public final LinearLayout llPassWordEdit;
    protected View.OnClickListener mClick;
    public final PinEntryEditText password;
    public final LinearLayout radioGroup;
    public final TextView title;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogPassWordLevelBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, View view2, View view3, LinearLayout linearLayout2, PinEntryEditText pinEntryEditText, LinearLayout linearLayout3, TextView textView3) {
        super(obj, view, i);
        this.bgRoot = linearLayout;
        this.cancelButton = textView;
        this.confirmButton = textView2;
        this.joinPublic = view2;
        this.joinedPassWord = view3;
        this.llPassWordEdit = linearLayout2;
        this.password = pinEntryEditText;
        this.radioGroup = linearLayout3;
        this.title = textView3;
    }

    public static DialogPassWordLevelBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogPassWordLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogPassWordLevelBinding bind(View view, Object obj) {
        return (DialogPassWordLevelBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_pass_word_level);
    }

    @Deprecated
    public static DialogPassWordLevelBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogPassWordLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_pass_word_level, viewGroup, z, obj);
    }

    public static DialogPassWordLevelBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogPassWordLevelBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogPassWordLevelBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_pass_word_level, (ViewGroup) null, false, obj);
    }
}
