package com.amazonaws.mobile.config;

import android.content.Context;
import com.amazonaws.ClientConfiguration;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public interface AWSConfigurable {
    AWSConfigurable initialize(Context context) throws Exception;

    AWSConfigurable initialize(Context context, AWSConfiguration aWSConfiguration) throws Exception;

    AWSConfigurable initialize(Context context, AWSConfiguration aWSConfiguration, ClientConfiguration clientConfiguration) throws Exception;
}
