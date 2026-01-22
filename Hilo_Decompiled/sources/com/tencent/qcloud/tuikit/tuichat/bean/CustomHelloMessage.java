package com.tencent.qcloud.tuikit.tuichat.bean;

import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class CustomHelloMessage implements Serializable {
    public static final int CUSTOM_HELLO_ACTION_ID = 3;
    public String businessID = TUIChatConstants.BUSINESS_ID_CUSTOM_HELLO;
    public String text = ServiceInitializer.getAppContext().getString(R.string.welcome_tip);
    public String link = "https://cloud.tencent.com/document/product/269/3794";
    public int version = 0;
}
