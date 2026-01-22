package com.alibaba.sdk.android.logger.a;

import android.util.Log;
import com.alibaba.sdk.android.logger.IObjectLogFormat;
import com.amazonaws.services.s3.internal.Constants;
import java.util.HashMap;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<Class, IObjectLogFormat> f٦٤٣١a = new HashMap<>();

    public String a(Object obj) {
        if (obj == null) {
            return Constants.NULL_VERSION_ID;
        }
        int i10 = 0;
        if (obj instanceof Object[]) {
            StringBuilder sb = new StringBuilder();
            Object[] objArr = (Object[]) obj;
            sb.append("[");
            while (i10 < objArr.length) {
                if (i10 != 0) {
                    sb.append(", ");
                }
                sb.append(a(objArr[i10]));
                i10++;
            }
            sb.append("]");
            return sb.toString();
        }
        if (obj instanceof short[]) {
            StringBuilder sb2 = new StringBuilder();
            short[] sArr = (short[]) obj;
            sb2.append("[");
            while (i10 < sArr.length) {
                if (i10 != 0) {
                    sb2.append(", ");
                }
                sb2.append((int) sArr[i10]);
                i10++;
            }
            sb2.append("]");
            return sb2.toString();
        }
        if (obj instanceof int[]) {
            StringBuilder sb3 = new StringBuilder();
            int[] iArr = (int[]) obj;
            sb3.append("[");
            while (i10 < iArr.length) {
                if (i10 != 0) {
                    sb3.append(", ");
                }
                sb3.append(iArr[i10]);
                i10++;
            }
            sb3.append("]");
            return sb3.toString();
        }
        if (obj instanceof long[]) {
            StringBuilder sb4 = new StringBuilder();
            long[] jArr = (long[]) obj;
            sb4.append("[");
            while (i10 < jArr.length) {
                if (i10 != 0) {
                    sb4.append(", ");
                }
                sb4.append(jArr[i10]);
                i10++;
            }
            sb4.append("]");
            return sb4.toString();
        }
        if (obj instanceof boolean[]) {
            StringBuilder sb5 = new StringBuilder();
            boolean[] zArr = (boolean[]) obj;
            sb5.append("[");
            while (i10 < zArr.length) {
                if (i10 != 0) {
                    sb5.append(", ");
                }
                sb5.append(zArr[i10]);
                i10++;
            }
            sb5.append("]");
            return sb5.toString();
        }
        if (obj instanceof char[]) {
            StringBuilder sb6 = new StringBuilder();
            char[] cArr = (char[]) obj;
            sb6.append("[");
            while (i10 < cArr.length) {
                if (i10 != 0) {
                    sb6.append(", ");
                }
                sb6.append(cArr[i10]);
                i10++;
            }
            sb6.append("]");
            return sb6.toString();
        }
        if (obj instanceof float[]) {
            StringBuilder sb7 = new StringBuilder();
            float[] fArr = (float[]) obj;
            sb7.append("[");
            while (i10 < fArr.length) {
                if (i10 != 0) {
                    sb7.append(", ");
                }
                sb7.append(fArr[i10]);
                i10++;
            }
            sb7.append("]");
            return sb7.toString();
        }
        if (obj instanceof double[]) {
            StringBuilder sb8 = new StringBuilder();
            double[] dArr = (double[]) obj;
            sb8.append("[");
            while (i10 < dArr.length) {
                if (i10 != 0) {
                    sb8.append(", ");
                }
                sb8.append(dArr[i10]);
                i10++;
            }
            sb8.append("]");
            return sb8.toString();
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof Throwable) {
                return Log.getStackTraceString((Throwable) obj);
            }
            IObjectLogFormat iObjectLogFormat = this.f٦٤٣١a.get(obj.getClass());
            return iObjectLogFormat != null ? iObjectLogFormat.format(obj) : obj.toString();
        }
        StringBuilder sb9 = new StringBuilder();
        byte[] bArr = (byte[]) obj;
        sb9.append("[");
        while (i10 < bArr.length) {
            if (i10 != 0) {
                sb9.append(", ");
            }
            sb9.append((int) bArr[i10]);
            i10++;
        }
        sb9.append("]");
        return sb9.toString();
    }

    public <T> void a(Class<T> cls, IObjectLogFormat<T> iObjectLogFormat) {
        this.f٦٤٣١a.put(cls, iObjectLogFormat);
    }
}
