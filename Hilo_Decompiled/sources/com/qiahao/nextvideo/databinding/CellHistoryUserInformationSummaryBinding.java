package com.qiahao.nextvideo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.g;
import com.qiahao.nextvideo.R;
import com.qiahao.nextvideo.ui.reusable.views.CorneredImageView;
import com.qiahao.nextvideo.ui.reusable.views.GenderAgeTextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class CellHistoryUserInformationSummaryBinding extends ViewDataBinding {
    public final GenderAgeTextView ageTextView;
    public final AppCompatImageButton chatImageButton;
    public final AppCompatTextView countryProvinceTextView;
    public final AppCompatImageButton deleteImageView;
    public final AppCompatImageButton likedImageButton;
    public final AppCompatTextView matchingTimeTextView;
    public final AppCompatTextView nicknameTextView;
    public final AppCompatImageView reportImageView;
    public final CorneredImageView userProfilePictureCorneredImageView;
    public final AppCompatImageButton videoCallImageButton;
    public final AppCompatImageView vipSymbolImageView;

    /* JADX INFO: Access modifiers changed from: protected */
    public CellHistoryUserInformationSummaryBinding(Object obj, View view, int i, GenderAgeTextView genderAgeTextView, AppCompatImageButton appCompatImageButton, AppCompatTextView appCompatTextView, AppCompatImageButton appCompatImageButton2, AppCompatImageButton appCompatImageButton3, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatImageView appCompatImageView, CorneredImageView corneredImageView, AppCompatImageButton appCompatImageButton4, AppCompatImageView appCompatImageView2) {
        super(obj, view, i);
        this.ageTextView = genderAgeTextView;
        this.chatImageButton = appCompatImageButton;
        this.countryProvinceTextView = appCompatTextView;
        this.deleteImageView = appCompatImageButton2;
        this.likedImageButton = appCompatImageButton3;
        this.matchingTimeTextView = appCompatTextView2;
        this.nicknameTextView = appCompatTextView3;
        this.reportImageView = appCompatImageView;
        this.userProfilePictureCorneredImageView = corneredImageView;
        this.videoCallImageButton = appCompatImageButton4;
        this.vipSymbolImageView = appCompatImageView2;
    }

    public static CellHistoryUserInformationSummaryBinding bind(View view) {
        g.g();
        return bind(view, null);
    }

    public static CellHistoryUserInformationSummaryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        g.g();
        return inflate(layoutInflater, viewGroup, z, null);
    }

    @Deprecated
    public static CellHistoryUserInformationSummaryBinding bind(View view, Object obj) {
        return (CellHistoryUserInformationSummaryBinding) ViewDataBinding.bind(obj, view, R.layout.cell_history_user_information_summary);
    }

    @Deprecated
    public static CellHistoryUserInformationSummaryBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (CellHistoryUserInformationSummaryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_history_user_information_summary, viewGroup, z, obj);
    }

    public static CellHistoryUserInformationSummaryBinding inflate(LayoutInflater layoutInflater) {
        g.g();
        return inflate(layoutInflater, null);
    }

    @Deprecated
    public static CellHistoryUserInformationSummaryBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (CellHistoryUserInformationSummaryBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.cell_history_user_information_summary, (ViewGroup) null, false, obj);
    }
}
