package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.opensource.svgaplayer.SVGAImageView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.sheep.SheepFightBtn;
import com.qiahao.nextvideo.view.RatioConstraintLayout;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ActivityGameMatchLobbyBinding extends ViewDataBinding {
    public final QMUIRadiusImageView avatarBlue;
    public final QMUIRadiusImageView avatarRed;
    public final ImageView back;
    public final RatioConstraintLayout blueViews;
    public final SheepFightBtn btnFight;
    public final ImageView iconVs;
    public final TextView nameBlue;
    public final TextView nameRed;
    public final View pointBlue;
    public final View pointRed;
    public final ImageView readyRed;
    public final RatioConstraintLayout redViews;
    public final SVGAImageView svga;

    /* JADX INFO: Access modifiers changed from: protected */
    public ActivityGameMatchLobbyBinding(Object obj, View view, int i, QMUIRadiusImageView qMUIRadiusImageView, QMUIRadiusImageView qMUIRadiusImageView2, ImageView imageView, RatioConstraintLayout ratioConstraintLayout, SheepFightBtn sheepFightBtn, ImageView imageView2, TextView textView, TextView textView2, View view2, View view3, ImageView imageView3, RatioConstraintLayout ratioConstraintLayout2, SVGAImageView sVGAImageView) {
        super(obj, view, i);
        this.avatarBlue = qMUIRadiusImageView;
        this.avatarRed = qMUIRadiusImageView2;
        this.back = imageView;
        this.blueViews = ratioConstraintLayout;
        this.btnFight = sheepFightBtn;
        this.iconVs = imageView2;
        this.nameBlue = textView;
        this.nameRed = textView2;
        this.pointBlue = view2;
        this.pointRed = view3;
        this.readyRed = imageView3;
        this.redViews = ratioConstraintLayout2;
        this.svga = sVGAImageView;
    }

    public static ActivityGameMatchLobbyBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static ActivityGameMatchLobbyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static ActivityGameMatchLobbyBinding bind(View view, Object obj) {
        return (ActivityGameMatchLobbyBinding) ViewDataBinding.bind(obj, view, R.layout.activity_game_match_lobby);
    }

    @Deprecated
    public static ActivityGameMatchLobbyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (ActivityGameMatchLobbyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_game_match_lobby, viewGroup, z, obj);
    }

    public static ActivityGameMatchLobbyBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static ActivityGameMatchLobbyBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (ActivityGameMatchLobbyBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_game_match_lobby, (ViewGroup) null, false, obj);
    }
}
