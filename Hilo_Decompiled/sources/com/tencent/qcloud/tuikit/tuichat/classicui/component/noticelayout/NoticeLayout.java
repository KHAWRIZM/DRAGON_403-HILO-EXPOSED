package com.tencent.qcloud.tuikit.tuichat.classicui.component.noticelayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class NoticeLayout extends RelativeLayout implements INoticeLayout {
    private boolean mAwaysShow;
    private TextView mContentExtraText;
    private TextView mContentText;
    private RelativeLayout mNoticeLayout;

    public NoticeLayout(Context context) {
        super(context);
        init();
    }

    private void init() {
        View.inflate(getContext(), R.layout.notice_layout, this);
        this.mNoticeLayout = (RelativeLayout) findViewById(R.id.notice_layout);
        this.mContentText = (TextView) findViewById(R.id.notice_content);
        this.mContentExtraText = (TextView) findViewById(R.id.notice_content_extra);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.noticelayout.INoticeLayout
    public void alwaysShow(boolean z) {
        this.mAwaysShow = z;
        if (z) {
            super.setVisibility(0);
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.noticelayout.INoticeLayout
    public TextView getContent() {
        return this.mContentText;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.noticelayout.INoticeLayout
    public TextView getContentExtra() {
        return this.mContentExtraText;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.noticelayout.INoticeLayout
    public RelativeLayout getParentLayout() {
        return this.mNoticeLayout;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.classicui.component.noticelayout.INoticeLayout
    public void setOnNoticeClickListener(View.OnClickListener onClickListener) {
        setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (this.mAwaysShow) {
            super.setVisibility(0);
        } else {
            super.setVisibility(i);
        }
    }

    public NoticeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public NoticeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }
}
