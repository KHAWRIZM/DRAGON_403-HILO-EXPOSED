package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.room.view.PinEntryEditText;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogJoinLockRoomBinding extends ViewDataBinding {
    public final ImageView bgGroupPic;
    public final TextView close;
    public final ImageView countPic;
    public final TextView enterButton;
    public final TextView groupId;
    public final TextView groupName;
    public final RoundedImageView groupPic;
    public final View joinPassWordButtonBackGroup;
    public final LinearLayout llGroupName;
    public final LinearLayout llShowPassWord;
    protected View.OnClickListener mClick;
    public final PinEntryEditText password;
    public final AppCompatImageView reportImageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogJoinLockRoomBinding(Object obj, View view, int i, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, TextView textView3, TextView textView4, RoundedImageView roundedImageView, View view2, LinearLayout linearLayout, LinearLayout linearLayout2, PinEntryEditText pinEntryEditText, AppCompatImageView appCompatImageView) {
        super(obj, view, i);
        this.bgGroupPic = imageView;
        this.close = textView;
        this.countPic = imageView2;
        this.enterButton = textView2;
        this.groupId = textView3;
        this.groupName = textView4;
        this.groupPic = roundedImageView;
        this.joinPassWordButtonBackGroup = view2;
        this.llGroupName = linearLayout;
        this.llShowPassWord = linearLayout2;
        this.password = pinEntryEditText;
        this.reportImageView = appCompatImageView;
    }

    public static DialogJoinLockRoomBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogJoinLockRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogJoinLockRoomBinding bind(View view, Object obj) {
        return (DialogJoinLockRoomBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_join_lock_room);
    }

    @Deprecated
    public static DialogJoinLockRoomBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogJoinLockRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_join_lock_room, viewGroup, z, obj);
    }

    public static DialogJoinLockRoomBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogJoinLockRoomBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogJoinLockRoomBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_join_lock_room, (ViewGroup) null, false, obj);
    }
}
