package com.google.common.collect;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class c0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Object obj, int i10) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb = new StringBuilder(20);
        sb.append("at index ");
        sb.append(i10);
        throw new NullPointerException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] b(Object... objArr) {
        c(objArr, objArr.length);
        return objArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] c(Object[] objArr, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            a(objArr[i11], i11);
        }
        return objArr;
    }

    public static Object[] d(Object[] objArr, int i10) {
        return e0.b(objArr, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] e(Object[] objArr, int i10, int i11, Object[] objArr2) {
        k8.h.m(i10, i10 + i11, objArr.length);
        if (objArr2.length < i11) {
            objArr2 = d(objArr2, i11);
        } else if (objArr2.length > i11) {
            objArr2[i11] = null;
        }
        System.arraycopy(objArr, i10, objArr2, 0, i11);
        return objArr2;
    }
}
