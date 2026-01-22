package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.luck.picture.lib.widget.SquareRelativeLayout;
import com.qiahao.nextvideo.R;
import j3.a;
import j3.b;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class CellGridFilesUploadPreviewBinding implements a {
    public final AppCompatImageView fiv;
    public final AppCompatImageView ivDel;
    private final SquareRelativeLayout rootView;
    public final TextView tvDuration;

    private CellGridFilesUploadPreviewBinding(SquareRelativeLayout squareRelativeLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView) {
        this.rootView = squareRelativeLayout;
        this.fiv = appCompatImageView;
        this.ivDel = appCompatImageView2;
        this.tvDuration = textView;
    }

    public static CellGridFilesUploadPreviewBinding bind(View view) {
        int i = R.id.fiv;
        AppCompatImageView a = b.a(view, R.id.fiv);
        if (a != null) {
            i = R.id.iv_del;
            AppCompatImageView a2 = b.a(view, R.id.iv_del);
            if (a2 != null) {
                i = 2131365418;
                TextView textView = (TextView) b.a(view, 2131365418);
                if (textView != null) {
                    return new CellGridFilesUploadPreviewBinding((SquareRelativeLayout) view, a, a2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static CellGridFilesUploadPreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CellGridFilesUploadPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.cell_grid_files_upload_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public SquareRelativeLayout getRoot() {
        return this.rootView;
    }
}
