package com.alibaba.sdk.android.push.common.a;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public enum a {
    CHANNEL_SERVICE("com.taobao.accs.ChannelService", "service", true),
    KERNEL_SERVICE("com.taobao.accs.ChannelService$KernelService", "service", true),
    ACCS_JOB_SERVICE("com.taobao.accs.internal.AccsJobService", "service", true),
    MSG_DISTRIBUTE_SERVICE("com.taobao.accs.data.MsgDistributeService", "service", true),
    EVENT_RECEIVER("com.taobao.accs.EventReceiver", "receiver", false),
    SERVICE_RECEIVER("com.taobao.accs.ServiceReceiver", "receiver", true),
    AGOO_SERVICE("org.android.agoo.accs.AgooService", "service", true),
    ALIYUN_PUSH_INTENT_SERVICE("com.aliyun.ams.emas.push.AgooInnerService", "service", true),
    MSG_SERVICE("com.aliyun.ams.emas.push.MsgService", "service", true);


    /* renamed from: j, reason: collision with root package name */
    private final String f٦٥٧٨j;

    /* renamed from: k, reason: collision with root package name */
    private final String f٦٥٧٩k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f٦٥٨٠l;

    a(String str, String str2, boolean z10) {
        this.f٦٥٧٨j = str;
        this.f٦٥٧٩k = str2;
        this.f٦٥٨٠l = z10;
    }

    public String a() {
        return this.f٦٥٧٨j;
    }

    public String b() {
        return this.f٦٥٧٩k;
    }

    public boolean c() {
        return this.f٦٥٨٠l;
    }
}
