package com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import c5.g;
import com.bumptech.glide.request.target.j;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomOrderMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import m4.a;
import o4.q;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class CustomOrderMessageHolder extends MessageContentHolder {
    public static final String TAG = "CustomOrderMessageHolder";
    private TextView contentView;
    private ImageView imageView;
    private TextView priceView;
    private TextView titleView;

    public CustomOrderMessageHolder(View view) {
        super(view);
        this.imageView = (ImageView) view.findViewById(R.id.content_image_iv);
        this.titleView = (TextView) view.findViewById(R.id.order_title);
        this.contentView = (TextView) view.findViewById(R.id.order_description);
        this.priceView = (TextView) view.findViewById(R.id.order_price);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.custom_order_message_layout;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.MessageContentHolder
    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        final String str5;
        if (tUIMessageBean instanceof CustomOrderMessageBean) {
            CustomOrderMessageBean customOrderMessageBean = (CustomOrderMessageBean) tUIMessageBean;
            str = customOrderMessageBean.getTitle();
            str3 = customOrderMessageBean.getDescription();
            str4 = customOrderMessageBean.getPrice();
            str5 = customOrderMessageBean.getLink();
            str2 = customOrderMessageBean.getImageUrl();
        } else {
            str = "";
            str2 = "";
            str3 = str2;
            str4 = str3;
            str5 = str4;
        }
        GlideEngine.loadCornerImageWithoutPlaceHolder(this.imageView, str2, new g() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.CustomOrderMessageHolder.1
            public boolean onLoadFailed(q qVar, Object obj, j jVar, boolean z) {
                TUIChatLog.e(CustomOrderMessageHolder.TAG, "onLoadFailed e=" + qVar);
                return false;
            }

            public boolean onResourceReady(Object obj, Object obj2, j jVar, a aVar, boolean z) {
                return false;
            }
        }, ScreenUtil.dip2px(4.0f));
        this.titleView.setText(str);
        this.contentView.setText(str3);
        this.priceView.setText(str4);
        this.msgContentFrame.setClickable(true);
        this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.minimalistui.widget.message.viewholder.CustomOrderMessageHolder.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str5));
                intent.addFlags(268435456);
                ServiceInitializer.getAppContext().startActivity(intent);
            }
        });
    }
}
