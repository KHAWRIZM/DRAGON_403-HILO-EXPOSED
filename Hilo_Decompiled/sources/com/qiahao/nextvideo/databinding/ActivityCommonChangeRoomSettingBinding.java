package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityCommonChangeRoomSettingBinding extends ViewDataBinding {
    public final FrameLayout activityMainContainer;
    public final AppCompatImageView backImageView;
    public final EditText etContent;
    protected View.OnClickListener mClick;
    protected Integer mNumber;
    protected String mTitle;
    public final AppCompatTextView save;
    public final TextView textNumber;
    public final Toolbar titleBar;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityCommonChangeRoomSettingBinding(Object obj, View view, int i, FrameLayout frameLayout, AppCompatImageView appCompatImageView, EditText editText, AppCompatTextView appCompatTextView, TextView textView, Toolbar toolbar) {
        super(obj, view, i);
        this.activityMainContainer = frameLayout;
        this.backImageView = appCompatImageView;
        this.etContent = editText;
        this.save = appCompatTextView;
        this.textNumber = textView;
        this.titleBar = toolbar;
    }

    public static ActivityCommonChangeRoomSettingBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityCommonChangeRoomSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public Integer getNumber() {
        return this.mNumber;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    public abstract void setNumber(Integer num);

    public abstract void setTitle(String str);

    @Deprecated
    public static ActivityCommonChangeRoomSettingBinding bind(View view, Object obj) {
        return (ActivityCommonChangeRoomSettingBinding) ViewDataBinding.bind(obj, view, R.layout.activity_common_change_room_setting);
    }

    @Deprecated
    public static ActivityCommonChangeRoomSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityCommonChangeRoomSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_common_change_room_setting, viewGroup, z, obj);
    }

    public static ActivityCommonChangeRoomSettingBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityCommonChangeRoomSettingBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityCommonChangeRoomSettingBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_common_change_room_setting, (ViewGroup) null, false, obj);
    }
}
