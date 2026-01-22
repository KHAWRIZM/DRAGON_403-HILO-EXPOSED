package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.viewpager2.widget.ViewPager2;
import com.makeramen.roundedimageview.RoundedImageView;
import com.opensource.svgaplayer.SVGAImageView;
import com.oudi.widget.ViewPage2TabLayout;
import com.qiahao.base_common.wedgit.shineText.NickTextView;
import com.qiahao.base_common.wedgit.shineText.ShineTextView;
import com.qiahao.nextvideo.R;
import com.tencent.qcloud.tuicore.component.RoundCornerImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRoomInfo2Binding extends ViewDataBinding {
    public final RoundCornerImageView bgGroupPic;
    public final TextView close;
    public final ImageView countPic;
    public final ShineTextView groupId;
    public final NickTextView groupName;
    public final RoundedImageView groupPic;
    protected View.OnClickListener mClick;
    public final AppCompatImageView reportImageView;
    public final ImageView roomImageHead;
    public final SVGAImageView roomSvga;
    public final ImageView svip;
    public final ViewPage2TabLayout tabLayout;
    public final ViewPager2 viewPage;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRoomInfo2Binding(Object obj, View view, int i, RoundCornerImageView roundCornerImageView, TextView textView, ImageView imageView, ShineTextView shineTextView, NickTextView nickTextView, RoundedImageView roundedImageView, AppCompatImageView appCompatImageView, ImageView imageView2, SVGAImageView sVGAImageView, ImageView imageView3, ViewPage2TabLayout viewPage2TabLayout, ViewPager2 viewPager2) {
        super(obj, view, i);
        this.bgGroupPic = roundCornerImageView;
        this.close = textView;
        this.countPic = imageView;
        this.groupId = shineTextView;
        this.groupName = nickTextView;
        this.groupPic = roundedImageView;
        this.reportImageView = appCompatImageView;
        this.roomImageHead = imageView2;
        this.roomSvga = sVGAImageView;
        this.svip = imageView3;
        this.tabLayout = viewPage2TabLayout;
        this.viewPage = viewPager2;
    }

    public static DialogRoomInfo2Binding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRoomInfo2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    public View.OnClickListener getClick() {
        return this.mClick;
    }

    public abstract void setClick(View.OnClickListener onClickListener);

    @Deprecated
    public static DialogRoomInfo2Binding bind(View view, Object obj) {
        return (DialogRoomInfo2Binding) ViewDataBinding.bind(obj, view, R.layout.dialog_room_info2);
    }

    @Deprecated
    public static DialogRoomInfo2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRoomInfo2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_info2, viewGroup, z, obj);
    }

    public static DialogRoomInfo2Binding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRoomInfo2Binding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRoomInfo2Binding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_info2, (ViewGroup) null, false, obj);
    }
}
