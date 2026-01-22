package com.alibaba.sdk.android.ams.common.util;

import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class c {
    public static Map<String, String> a(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.put(DispatchConstants.SIGN, com.alibaba.sdk.android.ams.common.b.c.a().a(hashMap, "TMP_SEED_KEY"));
        return hashMap;
    }
}
