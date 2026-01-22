package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.SwitchButton;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityCpMemorialEditBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatEditText editText;
    public final ImageView nameImg;
    public final ImageView notificationImg;
    public final TextView notificationText;
    public final TextView save;
    public final SwitchButton switchView;
    public final TextView time;
    public final ImageView timeImg;
    public final IncludeTitleBinding titleBar;
    public final ConstraintLayout topLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityCpMemorialEditBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatEditText appCompatEditText, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, SwitchButton switchButton, TextView textView3, ImageView imageView3, IncludeTitleBinding includeTitleBinding, ConstraintLayout constraintLayout) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.editText = appCompatEditText;
        this.nameImg = imageView;
        this.notificationImg = imageView2;
        this.notificationText = textView;
        this.save = textView2;
        this.switchView = switchButton;
        this.time = textView3;
        this.timeImg = imageView3;
        this.titleBar = includeTitleBinding;
        this.topLayout = constraintLayout;
    }

    public static ActivityCpMemorialEditBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityCpMemorialEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityCpMemorialEditBinding bind(View view, Object obj) {
        return (ActivityCpMemorialEditBinding) ViewDataBinding.bind(obj, view, R.layout.activity_cp_memorial_edit);
    }

    @Deprecated
    public static ActivityCpMemorialEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityCpMemorialEditBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_cp_memorial_edit, viewGroup, z, obj);
    }

    public static ActivityCpMemorialEditBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityCpMemorialEditBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityCpMemorialEditBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_cp_memorial_edit, (ViewGroup) null, false, obj);
    }
}
