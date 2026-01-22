package com.tencent.qcloud.tuikit.tuichat.classicui.component.noticelayout;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public interface INoticeLayout {
    void alwaysShow(boolean z);

    TextView getContent();

    TextView getContentExtra();

    RelativeLayout getParentLayout();

    void setOnNoticeClickListener(View.OnClickListener onClickListener);
}
