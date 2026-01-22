package com.qiahao.base_common.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.luck.picture.lib.widget.MarqueeTextView;
import com.luck.picture.lib.widget.MediumBoldTextView;
import com.qiahao.base_common.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class PsTitleBarBinding implements a {
    public final ImageView psIvArrow;
    public final ImageView psIvDelete;
    public final ImageView psIvLeftBack;
    public final RelativeLayout psRlAlbumBg;
    public final View psRlAlbumClick;
    public final MediumBoldTextView psTvCancel;
    public final MarqueeTextView psTvTitle;
    public final RelativeLayout rlTitleBar;
    private final View rootView;
    public final View titleBarLine;
    public final View topStatusBar;

    private PsTitleBarBinding(View view, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout, View view2, MediumBoldTextView mediumBoldTextView, MarqueeTextView marqueeTextView, RelativeLayout relativeLayout2, View view3, View view4) {
        this.rootView = view;
        this.psIvArrow = imageView;
        this.psIvDelete = imageView2;
        this.psIvLeftBack = imageView3;
        this.psRlAlbumBg = relativeLayout;
        this.psRlAlbumClick = view2;
        this.psTvCancel = mediumBoldTextView;
        this.psTvTitle = marqueeTextView;
        this.rlTitleBar = relativeLayout2;
        this.titleBarLine = view3;
        this.topStatusBar = view4;
    }

    public static PsTitleBarBinding bind(View view) {
        View a10;
        View a11;
        View a12;
        int i10 = R.id.ps_iv_arrow;
        ImageView imageView = (ImageView) b.a(view, i10);
        if (imageView != null) {
            i10 = R.id.ps_iv_delete;
            ImageView imageView2 = (ImageView) b.a(view, i10);
            if (imageView2 != null) {
                i10 = R.id.ps_iv_left_back;
                ImageView imageView3 = (ImageView) b.a(view, i10);
                if (imageView3 != null) {
                    i10 = R.id.ps_rl_album_bg;
                    RelativeLayout relativeLayout = (RelativeLayout) b.a(view, i10);
                    if (relativeLayout != null && (a10 = b.a(view, (i10 = R.id.ps_rl_album_click))) != null) {
                        i10 = R.id.ps_tv_cancel;
                        MediumBoldTextView mediumBoldTextView = (MediumBoldTextView) b.a(view, i10);
                        if (mediumBoldTextView != null) {
                            i10 = R.id.ps_tv_title;
                            MarqueeTextView marqueeTextView = (MarqueeTextView) b.a(view, i10);
                            if (marqueeTextView != null) {
                                i10 = R.id.rl_title_bar;
                                RelativeLayout relativeLayout2 = (RelativeLayout) b.a(view, i10);
                                if (relativeLayout2 != null && (a11 = b.a(view, (i10 = R.id.title_bar_line))) != null && (a12 = b.a(view, (i10 = R.id.top_status_bar))) != null) {
                                    return new PsTitleBarBinding(view, imageView, imageView2, imageView3, relativeLayout, a10, mediumBoldTextView, marqueeTextView, relativeLayout2, a11, a12);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static PsTitleBarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.ps_title_bar, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @Override // j3.a
    public View getRoot() {
        return this.rootView;
    }
}
