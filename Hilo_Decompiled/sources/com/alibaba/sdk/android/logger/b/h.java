package com.alibaba.sdk.android.logger.b;

import com.alibaba.sdk.android.logger.ILogger;
import com.alibaba.sdk.android.logger.LogLevel;
import com.amazonaws.services.s3.internal.Constants;
import java.util.ArrayList;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class h implements com.alibaba.sdk.android.logger.interceptor.d {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f٦٤٤٤a = {Constants.NULL_VERSION_ID};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f٦٤٤٥b = {"[]"};

    /* renamed from: c, reason: collision with root package name */
    private com.alibaba.sdk.android.logger.a.a f٦٤٤٦c;

    public h(com.alibaba.sdk.android.logger.a.a aVar) {
        this.f٦٤٤٦c = aVar;
    }

    @Override // com.alibaba.sdk.android.logger.interceptor.d
    public void a(LogLevel logLevel, String str, Object[] objArr, ILogger iLogger) {
        for (String str2 : a(a(objArr))) {
            iLogger.print(logLevel, str, str2);
        }
    }

    private String[] a(Object[] objArr) {
        if (objArr == null) {
            return f٦٤٤٤a;
        }
        if (objArr.length == 0) {
            return f٦٤٤٥b;
        }
        String[] strArr = new String[objArr.length];
        for (int i10 = 0; i10 < objArr.length; i10++) {
            strArr[i10] = this.f٦٤٤٦c.a(objArr[i10]);
        }
        return strArr;
    }

    private String[] a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        boolean z10 = true;
        for (String str : strArr) {
            if (str == null) {
                str = "";
            }
            if (z10) {
                z10 = false;
            } else {
                sb.append(" ");
            }
            if (str.contains("\n")) {
                String[] split = str.split("\n");
                for (int i10 = 0; i10 < split.length; i10++) {
                    sb.append(split[i10]);
                    if (i10 < split.length - 1) {
                        arrayList.add(sb.toString());
                        sb = new StringBuilder();
                    } else if (i10 == split.length - 1 && str.endsWith("\n")) {
                        arrayList.add(sb.toString());
                        sb = new StringBuilder();
                        z10 = true;
                    }
                }
            } else {
                sb.append(str);
            }
        }
        arrayList.add(sb.toString());
        return (String[]) arrayList.toArray(new String[0]);
    }
}
