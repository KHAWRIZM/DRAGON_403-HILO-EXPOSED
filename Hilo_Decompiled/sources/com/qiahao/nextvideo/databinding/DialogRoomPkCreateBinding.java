package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import androidx.recyclerview.widget.RecyclerView;
import com.oudi.core.status.SuperStatusView;
import com.oudi.widget.text.GradientTextView;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.view.PKSearchView;
import com.qmuiteam.qmui.widget.QMUIRadiusImageView;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class DialogRoomPkCreateBinding extends ViewDataBinding {
    public final TextView cancel;
    public final ImageView centerBg;
    public final ConstraintLayout constraint;
    public final TextView currentPK;
    public final ImageView helper;
    public final QMUIRadiusImageView leftAvatar;
    public final ImageView leftAvatarBg;
    public final TextView leftId;
    public final TextView leftName;
    public final View line;
    public final Group matchGroup;
    public final TextView matching;
    public final GradientTextView pkBrawl;
    public final PKSearchView pkSearch;
    public final RecyclerView recyclerView;
    public final SmartRefreshLayout refreshLayout;
    public final QMUIRadiusImageView rightAvatar;
    public final ImageView rightAvatarBg;
    public final TextView startMatch;
    public final SuperStatusView statusView;
    public final TextView title;
    public final ImageView topBg;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogRoomPkCreateBinding(Object obj, View view, int i, TextView textView, ImageView imageView, ConstraintLayout constraintLayout, TextView textView2, ImageView imageView2, QMUIRadiusImageView qMUIRadiusImageView, ImageView imageView3, TextView textView3, TextView textView4, View view2, Group group, TextView textView5, GradientTextView gradientTextView, PKSearchView pKSearchView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, QMUIRadiusImageView qMUIRadiusImageView2, ImageView imageView4, TextView textView6, SuperStatusView superStatusView, TextView textView7, ImageView imageView5) {
        super(obj, view, i);
        this.cancel = textView;
        this.centerBg = imageView;
        this.constraint = constraintLayout;
        this.currentPK = textView2;
        this.helper = imageView2;
        this.leftAvatar = qMUIRadiusImageView;
        this.leftAvatarBg = imageView3;
        this.leftId = textView3;
        this.leftName = textView4;
        this.line = view2;
        this.matchGroup = group;
        this.matching = textView5;
        this.pkBrawl = gradientTextView;
        this.pkSearch = pKSearchView;
        this.recyclerView = recyclerView;
        this.refreshLayout = smartRefreshLayout;
        this.rightAvatar = qMUIRadiusImageView2;
        this.rightAvatarBg = imageView4;
        this.startMatch = textView6;
        this.statusView = superStatusView;
        this.title = textView7;
        this.topBg = imageView5;
    }

    public static DialogRoomPkCreateBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static DialogRoomPkCreateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static DialogRoomPkCreateBinding bind(View view, Object obj) {
        return (DialogRoomPkCreateBinding) ViewDataBinding.bind(obj, view, R.layout.dialog_room_pk_create);
    }

    @Deprecated
    public static DialogRoomPkCreateBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogRoomPkCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_pk_create, viewGroup, z, obj);
    }

    public static DialogRoomPkCreateBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static DialogRoomPkCreateBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogRoomPkCreateBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_room_pk_create, (ViewGroup) null, false, obj);
    }
}
