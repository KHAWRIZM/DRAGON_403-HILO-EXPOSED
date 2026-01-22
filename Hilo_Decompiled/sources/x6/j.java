package x6;

import android.graphics.Matrix;
import android.util.Log;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f١٨٩٦٨a = i.class.getSimpleName();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Matrix a(String str) {
        int i10;
        Matrix matrix = new Matrix();
        while (true) {
            b(str, matrix);
            int indexOf = str.indexOf(")");
            if (indexOf <= 0 || str.length() <= (i10 = indexOf + 1)) {
                break;
            }
            str = str.substring(i10).replaceFirst("[\\s,]*", "");
        }
        return matrix;
    }

    private static void b(String str, Matrix matrix) {
        float f10;
        float f11;
        float f12;
        float f13;
        if (str.startsWith("matrix(")) {
            d b10 = d.b(str.substring(7));
            if (b10.f١٨٩٤٢a.size() == 6) {
                Matrix matrix2 = new Matrix();
                matrix2.setValues(new float[]{((Float) b10.f١٨٩٤٢a.get(0)).floatValue(), ((Float) b10.f١٨٩٤٢a.get(2)).floatValue(), ((Float) b10.f١٨٩٤٢a.get(4)).floatValue(), ((Float) b10.f١٨٩٤٢a.get(1)).floatValue(), ((Float) b10.f١٨٩٤٢a.get(3)).floatValue(), ((Float) b10.f١٨٩٤٢a.get(5)).floatValue(), DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, 1.0f});
                matrix.preConcat(matrix2);
                return;
            }
            return;
        }
        if (str.startsWith("translate(")) {
            d b11 = d.b(str.substring(10));
            if (b11.f١٨٩٤٢a.size() > 0) {
                float floatValue = ((Float) b11.f١٨٩٤٢a.get(0)).floatValue();
                if (b11.f١٨٩٤٢a.size() > 1) {
                    f13 = ((Float) b11.f١٨٩٤٢a.get(1)).floatValue();
                } else {
                    f13 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                matrix.preTranslate(floatValue, f13);
                return;
            }
            return;
        }
        if (str.startsWith("scale(")) {
            d b12 = d.b(str.substring(6));
            if (b12.f١٨٩٤٢a.size() > 0) {
                float floatValue2 = ((Float) b12.f١٨٩٤٢a.get(0)).floatValue();
                if (b12.f١٨٩٤٢a.size() > 1) {
                    f12 = ((Float) b12.f١٨٩٤٢a.get(1)).floatValue();
                } else {
                    f12 = floatValue2;
                }
                matrix.preScale(floatValue2, f12);
                return;
            }
            return;
        }
        if (str.startsWith("skewX(")) {
            if (d.b(str.substring(6)).f١٨٩٤٢a.size() > 0) {
                matrix.preSkew((float) Math.tan(((Float) r0.f١٨٩٤٢a.get(0)).floatValue()), DownloadProgress.UNKNOWN_PROGRESS);
                return;
            }
            return;
        }
        if (str.startsWith("skewY(")) {
            if (d.b(str.substring(6)).f١٨٩٤٢a.size() > 0) {
                matrix.preSkew(DownloadProgress.UNKNOWN_PROGRESS, (float) Math.tan(((Float) r0.f١٨٩٤٢a.get(0)).floatValue()));
                return;
            }
            return;
        }
        if (str.startsWith("rotate(")) {
            d b13 = d.b(str.substring(7));
            if (b13.f١٨٩٤٢a.size() > 0) {
                float floatValue3 = ((Float) b13.f١٨٩٤٢a.get(0)).floatValue();
                if (b13.f١٨٩٤٢a.size() > 2) {
                    f11 = ((Float) b13.f١٨٩٤٢a.get(1)).floatValue();
                    f10 = ((Float) b13.f١٨٩٤٢a.get(2)).floatValue();
                } else {
                    f10 = DownloadProgress.UNKNOWN_PROGRESS;
                    f11 = DownloadProgress.UNKNOWN_PROGRESS;
                }
                matrix.preTranslate(f11, f10);
                matrix.preRotate(floatValue3);
                matrix.preTranslate(-f11, -f10);
                return;
            }
            return;
        }
        Log.w(f١٨٩٦٨a, "Invalid transform (" + str + ")");
    }
}
