package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class c {
    public static Size a(List<Size> list, k kVar, int i, int i2) {
        double d;
        Size size = new Size(i, i2);
        LiteavLog.i("CameraSupervisor", "preview wanted: " + size + " cameraRotation:" + kVar);
        if (list == null) {
            LiteavLog.e("CameraSupervisor", "findBestMatchedPreviewSize getPreviewSizes null");
            return size;
        }
        if (kVar == k.ROTATION_90 || kVar == k.ROTATION_270) {
            size.swap();
        }
        double aspectRatio = size.aspectRatio();
        Size size2 = new Size(640, 640);
        int i3 = size.width;
        int i4 = size2.width;
        if (i3 <= i4 && size.height <= size2.height) {
            size2.set(size);
        } else {
            int i5 = size.height;
            if (i3 > i5) {
                size2.height = (i4 * i5) / i3;
            } else {
                size2.width = (size2.height * i3) / i5;
            }
        }
        ArrayList<Size> arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        long j = Long.MAX_VALUE;
        for (Size size3 : list) {
            sb2.append(size3);
            sb2.append(", ");
            long round = (size3.width < size2.width || size3.height < size2.height) ? Long.MAX_VALUE : Math.round(Math.abs(size3.aspectRatio() - aspectRatio) * 10.0d);
            if (round < j) {
                arrayList.clear();
                arrayList.add(size3);
                j = round;
            } else if (round == j) {
                arrayList.add(size3);
            }
        }
        LiteavLog.i("CameraSupervisor", "support preview size list: ".concat(String.valueOf(sb2)));
        Collections.sort(arrayList, d.a());
        Size size4 = (Size) arrayList.get(0);
        int area = size.getArea() * 1000;
        double d2 = Double.MAX_VALUE;
        for (Size size5 : arrayList) {
            LiteavLog.i("CameraSupervisor", "size in same buck ".concat(String.valueOf(size5)));
            if (aspectRatio > size5.aspectRatio()) {
                int i6 = size5.width;
                d = ((i6 * i6) * 1000) / aspectRatio;
            } else {
                int i7 = size5.height;
                d = i7 * i7 * aspectRatio * 1000.0d;
            }
            double d3 = area;
            if (d / d3 >= 0.9d) {
                double d4 = d - d3;
                if (Math.abs(d4) < d2) {
                    d2 = Math.abs(d4);
                    size4 = size5;
                }
            }
        }
        LiteavLog.i("CameraSupervisor", "best match preview size ".concat(String.valueOf(size4)));
        return new Size(size4.width, size4.height);
    }

    public static com.tencent.liteav.videoproducer.a.a a(com.tencent.liteav.videoproducer.a.a[] aVarArr, int i, boolean z) {
        if (aVarArr != null && aVarArr.length != 0) {
            int i2 = 0;
            for (com.tencent.liteav.videoproducer.a.a aVar : aVarArr) {
                LiteavLog.i("CameraSupervisor", "supported fps range: ".concat(String.valueOf(aVar)));
            }
            if (!z) {
                Arrays.sort(aVarArr, e.a());
                int length = aVarArr.length;
                while (i2 < length) {
                    com.tencent.liteav.videoproducer.a.a aVar2 = aVarArr[i2];
                    if (aVar2.a >= i) {
                        return aVar2;
                    }
                    i2++;
                }
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (com.tencent.liteav.videoproducer.a.a aVar3 : aVarArr) {
                if (aVar3.a < aVar3.b) {
                    arrayList.add(aVar3);
                }
            }
            com.tencent.liteav.videoproducer.a.a[] aVarArr2 = (com.tencent.liteav.videoproducer.a.a[]) arrayList.toArray(new com.tencent.liteav.videoproducer.a.a[0]);
            Arrays.sort(aVarArr2, f.a());
            int length2 = aVarArr2.length;
            while (i2 < length2) {
                com.tencent.liteav.videoproducer.a.a aVar4 = aVarArr2[i2];
                if (i <= aVar4.b) {
                    return aVar4;
                }
                i2++;
            }
            if (aVarArr2.length > 0) {
                return aVarArr2[aVarArr2.length - 1];
            }
        }
        return null;
    }
}
