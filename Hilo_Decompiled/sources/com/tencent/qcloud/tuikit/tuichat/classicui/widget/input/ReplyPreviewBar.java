package com.tencent.qcloud.tuikit.tuichat.classicui.widget.input;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class ReplyPreviewBar extends RelativeLayout {
    public ReplyPreviewBar(Context context) {
        super(context);
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), R.layout.reply_preview_layout, this);
    }

    public ReplyPreviewBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initViews();
    }

    public ReplyPreviewBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initViews();
    }
}
