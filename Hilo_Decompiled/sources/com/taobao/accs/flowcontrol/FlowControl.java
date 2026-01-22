package com.taobao.accs.flowcontrol;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.base.TaoBaseService;
import com.taobao.accs.utl.ALog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public class FlowControl {
    public static final int DELAY_MAX = -1;
    public static final int DELAY_MAX_BRUSH = -1000;
    public static final int HIGH_FLOW_CTRL = 2;
    public static final int HIGH_FLOW_CTRL_BRUSH = 3;
    public static final int LOW_FLOW_CTRL = 1;
    public static final int NO_FLOW_CTRL = 0;
    public static final String SERVICE_ALL = "ALL";
    public static final String SERVICE_ALL_BRUSH = "ALL_BRUSH";
    public static final int STATUS_FLOW_CTRL_ALL = 420;
    public static final int STATUS_FLOW_CTRL_BRUSH = 422;
    public static final int STATUS_FLOW_CTRL_CUR = 421;
    private Context a;
    private FlowCtrlInfoHolder b;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class FlowControlInfo implements Serializable {
        private static final long serialVersionUID = -2259991484877844919L;
        public String bizId;
        public long delayTime;
        public long expireTime;
        public String serviceId;
        public long startTime;
        public int status;

        public FlowControlInfo(String str, String str2, int i, long j, long j2, long j3) {
            this.serviceId = str;
            this.bizId = str2;
            this.status = i;
            this.delayTime = j;
            this.expireTime = j2 <= 0 ? 0L : j2;
            this.startTime = j3 <= 0 ? 0L : j3;
        }

        public boolean isExpired() {
            if (System.currentTimeMillis() - (this.startTime + this.expireTime) > 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("flow ctrl serviceId:");
            stringBuffer.append(this.serviceId);
            stringBuffer.append(" bizId:");
            stringBuffer.append(this.bizId);
            stringBuffer.append(" status:");
            stringBuffer.append(this.status);
            stringBuffer.append(" delayTime:");
            stringBuffer.append(this.delayTime);
            stringBuffer.append(" startTime:");
            stringBuffer.append(this.startTime);
            stringBuffer.append(" expireTime:");
            stringBuffer.append(this.expireTime);
            return stringBuffer.toString();
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
    public static class FlowCtrlInfoHolder implements Serializable {
        private static final long serialVersionUID = 6307563052429742524L;
        Map<String, FlowControlInfo> flowCtrlMap = null;

        public FlowControlInfo get(String str, String str2) {
            if (this.flowCtrlMap == null) {
                return null;
            }
            if (!TextUtils.isEmpty(str2)) {
                str = str + "_" + str2;
            }
            return this.flowCtrlMap.get(str);
        }

        public void put(String str, String str2, FlowControlInfo flowControlInfo) {
            if (!TextUtils.isEmpty(str2)) {
                str = str + "_" + str2;
            }
            if (this.flowCtrlMap == null) {
                this.flowCtrlMap = new HashMap();
            }
            this.flowCtrlMap.put(str, flowControlInfo);
        }
    }

    public FlowControl(Context context) {
        this.a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0146 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(Map<Integer, String> map, String str) {
        long j;
        int i;
        long j2;
        FlowControlInfo flowControlInfo;
        if (map != null) {
            try {
                String str2 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_STATUS.ordinal()));
                String str3 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_DELAY.ordinal()));
                String str4 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_EXPIRE.ordinal()));
                String str5 = map.get(Integer.valueOf(TaoBaseService.ExtHeaderType.TYPE_BUSINESS.ordinal()));
                i = TextUtils.isEmpty(str2) ? 0 : Integer.valueOf(str2).intValue();
                try {
                    j = TextUtils.isEmpty(str3) ? 0L : Long.valueOf(str3).longValue();
                    try {
                        long longValue = TextUtils.isEmpty(str4) ? 0L : Long.valueOf(str4).longValue();
                        if ((i != 420 && i != 421 && i != 422) || !a(j, longValue)) {
                            return 0;
                        }
                        try {
                            synchronized (this) {
                                try {
                                    if (this.b == null) {
                                        this.b = new FlowCtrlInfoHolder();
                                    }
                                    if (i == 420) {
                                        j2 = j;
                                        flowControlInfo = new FlowControlInfo("ALL", "", i, j, longValue, System.currentTimeMillis());
                                        this.b.put("ALL", "", flowControlInfo);
                                    } else {
                                        j2 = j;
                                        if (i == 422) {
                                            flowControlInfo = new FlowControlInfo(SERVICE_ALL_BRUSH, "", i, j2, longValue, System.currentTimeMillis());
                                            this.b.put(SERVICE_ALL_BRUSH, "", flowControlInfo);
                                        } else if (i != 421 || TextUtils.isEmpty(str)) {
                                            flowControlInfo = null;
                                        } else {
                                            FlowControlInfo flowControlInfo2 = new FlowControlInfo(str, str5, i, j2, longValue, System.currentTimeMillis());
                                            this.b.put(str, str5, flowControlInfo2);
                                            flowControlInfo = flowControlInfo2;
                                        }
                                    }
                                    if (flowControlInfo != null) {
                                        ALog.e("FlowControl", "updateFlowCtrlInfo " + flowControlInfo.toString(), new Object[0]);
                                    }
                                    j = j2;
                                } catch (Throwable th) {
                                    th = th;
                                    long j3 = j;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        j = j3;
                                        ALog.e("FlowControl", "updateFlowCtrlInfo", th, new Object[0]);
                                        if (j <= 0) {
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    j = 0;
                }
            } catch (Throwable th6) {
                th = th6;
                j = 0;
                i = 0;
            }
        } else {
            j = 0;
            i = 0;
        }
        if (j <= 0) {
            return 1;
        }
        if (j == 0) {
            return 0;
        }
        return 422 == i ? 3 : 2;
    }

    private boolean a(long j, long j2) {
        if (j != 0 && j2 > 0) {
            return true;
        }
        ALog.e("FlowControl", "error flow ctrl info", new Object[0]);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
    
        if (r5.isExpired() != false) goto L٦٠;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0099, code lost:
    
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0097, code lost:
    
        if (r0.isExpired() != false) goto L٦٠;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004f A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:9:0x0013, B:11:0x0032, B:14:0x0039, B:16:0x0042, B:19:0x0049, B:21:0x004f, B:24:0x0056, B:26:0x005c, B:29:0x0063, B:49:0x008b, B:51:0x0099, B:52:0x009c, B:58:0x0093), top: B:8:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005c A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:9:0x0013, B:11:0x0032, B:14:0x0039, B:16:0x0042, B:19:0x0049, B:21:0x004f, B:24:0x0056, B:26:0x005c, B:29:0x0063, B:49:0x008b, B:51:0x0099, B:52:0x009c, B:58:0x0093), top: B:8:0x0013 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0093 A[Catch: all -> 0x003c, TryCatch #0 {all -> 0x003c, blocks: (B:9:0x0013, B:11:0x0032, B:14:0x0039, B:16:0x0042, B:19:0x0049, B:21:0x004f, B:24:0x0056, B:26:0x005c, B:29:0x0063, B:49:0x008b, B:51:0x0099, B:52:0x009c, B:58:0x0093), top: B:8:0x0013 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(String str, String str2) {
        long j;
        long j2;
        long j3;
        long j4;
        FlowCtrlInfoHolder flowCtrlInfoHolder = this.b;
        long j5 = 0;
        if (flowCtrlInfoHolder == null || flowCtrlInfoHolder.flowCtrlMap == null || TextUtils.isEmpty(str)) {
            return 0L;
        }
        synchronized (this) {
            try {
                FlowControlInfo flowControlInfo = this.b.get("ALL", null);
                FlowControlInfo flowControlInfo2 = this.b.get(SERVICE_ALL_BRUSH, null);
                FlowControlInfo flowControlInfo3 = this.b.get(str, null);
                FlowControlInfo flowControlInfo4 = this.b.get(str, str2);
                if (flowControlInfo != null && !flowControlInfo.isExpired()) {
                    j = flowControlInfo.delayTime;
                    if (flowControlInfo2 != null && !flowControlInfo2.isExpired()) {
                        j2 = flowControlInfo2.delayTime;
                        if (flowControlInfo3 != null && !flowControlInfo3.isExpired()) {
                            j3 = flowControlInfo3.delayTime;
                            if (flowControlInfo4 != null && !flowControlInfo4.isExpired()) {
                                j5 = flowControlInfo4.delayTime;
                            }
                            j4 = -1;
                            if (j != -1 && j5 != -1 && j3 != -1) {
                                if (j2 != -1) {
                                    j4 = -1000;
                                } else {
                                    long j6 = j > j5 ? j : j5;
                                    j4 = j6 > j3 ? j6 : j3;
                                }
                            }
                            if (flowControlInfo != null) {
                            }
                        }
                        j3 = 0;
                        if (flowControlInfo4 != null) {
                            j5 = flowControlInfo4.delayTime;
                        }
                        j4 = -1;
                        if (j != -1) {
                            if (j2 != -1) {
                            }
                        }
                        if (flowControlInfo != null) {
                        }
                    }
                    j2 = 0;
                    if (flowControlInfo3 != null) {
                        j3 = flowControlInfo3.delayTime;
                        if (flowControlInfo4 != null) {
                        }
                        j4 = -1;
                        if (j != -1) {
                        }
                        if (flowControlInfo != null) {
                        }
                    }
                    j3 = 0;
                    if (flowControlInfo4 != null) {
                    }
                    j4 = -1;
                    if (j != -1) {
                    }
                    if (flowControlInfo != null) {
                    }
                }
                j = 0;
                if (flowControlInfo2 != null) {
                    j2 = flowControlInfo2.delayTime;
                    if (flowControlInfo3 != null) {
                    }
                    j3 = 0;
                    if (flowControlInfo4 != null) {
                    }
                    j4 = -1;
                    if (j != -1) {
                    }
                    if (flowControlInfo != null) {
                    }
                }
                j2 = 0;
                if (flowControlInfo3 != null) {
                }
                j3 = 0;
                if (flowControlInfo4 != null) {
                }
                j4 = -1;
                if (j != -1) {
                }
                if (flowControlInfo != null) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ALog.e("FlowControl", "getFlowCtrlDelay service " + str + " biz " + str2 + " result:" + j4 + " global:" + j + " serviceDelay:" + j3 + " bidDelay:" + j5, new Object[0]);
        return j4;
    }

    private void a() {
        FlowCtrlInfoHolder flowCtrlInfoHolder = this.b;
        if (flowCtrlInfoHolder == null || flowCtrlInfoHolder.flowCtrlMap == null) {
            return;
        }
        synchronized (this) {
            try {
                Iterator<Map.Entry<String, FlowControlInfo>> it = this.b.flowCtrlMap.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue().isExpired()) {
                        it.remove();
                    }
                }
            } finally {
            }
        }
    }
}
