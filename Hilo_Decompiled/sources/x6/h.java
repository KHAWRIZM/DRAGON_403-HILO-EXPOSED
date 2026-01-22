package x6;

import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.qiahao.base_common.download.okDownload.DownloadProgress;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
abstract class h {

    /* renamed from: a, reason: collision with root package name */
    private static final String f١٨٩٥٢a = i.f١٨٩٥٣n;

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x005b. Please report as an issue. */
    public static Path a(String str) {
        char c10;
        int i10;
        boolean z10;
        boolean z11;
        char c11;
        Path path;
        RectF rectF;
        float f10;
        float f11;
        String str2 = str;
        int length = str.length();
        f fVar = new f(str2);
        fVar.h();
        Path path2 = new Path();
        RectF rectF2 = new RectF();
        float f12 = DownloadProgress.UNKNOWN_PROGRESS;
        char c12 = 'x';
        float f13 = DownloadProgress.UNKNOWN_PROGRESS;
        float f14 = DownloadProgress.UNKNOWN_PROGRESS;
        float f15 = DownloadProgress.UNKNOWN_PROGRESS;
        float f16 = DownloadProgress.UNKNOWN_PROGRESS;
        float f17 = DownloadProgress.UNKNOWN_PROGRESS;
        float f18 = DownloadProgress.UNKNOWN_PROGRESS;
        while (true) {
            int i11 = fVar.f١٨٩٤٧c;
            if (i11 < length) {
                char charAt = str2.charAt(i11);
                if (!Character.isDigit(charAt) && charAt != '.' && charAt != '-') {
                    fVar.a();
                    c10 = charAt;
                } else if (c12 == 'M') {
                    c10 = 'L';
                } else if (c12 == 'm') {
                    c10 = 'l';
                } else {
                    c10 = c12;
                }
                boolean z12 = true;
                path2.computeBounds(rectF2, true);
                switch (c10) {
                    case 'A':
                    case 'a':
                        float c13 = fVar.c();
                        float c14 = fVar.c();
                        float c15 = fVar.c();
                        int c16 = (int) fVar.c();
                        int c17 = (int) fVar.c();
                        float c18 = fVar.c();
                        float c19 = fVar.c();
                        if (c10 == 'a') {
                            c18 += f13;
                            c19 += f14;
                        }
                        i10 = length;
                        float f19 = c19;
                        float f20 = c18;
                        double d10 = f13;
                        double d11 = f14;
                        double d12 = f20;
                        double d13 = f19;
                        double d14 = c13;
                        char c20 = c10;
                        double d15 = c14;
                        double d16 = c15;
                        if (c16 == 1) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (c17 == 1) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        c11 = c20;
                        path = path2;
                        rectF = rectF2;
                        b(path2, d10, d11, d12, d13, d14, d15, d16, z10, z11);
                        f14 = f19;
                        f13 = f20;
                        z12 = false;
                        break;
                    case 'C':
                    case 'c':
                        float c21 = fVar.c();
                        float c22 = fVar.c();
                        float c23 = fVar.c();
                        float c24 = fVar.c();
                        float c25 = fVar.c();
                        float c26 = fVar.c();
                        if (c10 == 'c') {
                            c21 += f13;
                            c23 += f13;
                            c25 += f13;
                            c22 += f14;
                            c24 += f14;
                            c26 += f14;
                        }
                        f17 = c23;
                        f18 = c24;
                        float f21 = c26;
                        float f22 = c25;
                        path2.cubicTo(c21, c22, f17, f18, f22, f21);
                        i10 = length;
                        f13 = f22;
                        f14 = f21;
                        c11 = c10;
                        path = path2;
                        rectF = rectF2;
                        break;
                    case 'H':
                    case 'h':
                        float c27 = fVar.c();
                        if (c10 == 'h') {
                            path2.rLineTo(c27, f12);
                            f13 += c27;
                            i10 = length;
                            c11 = c10;
                            path = path2;
                            rectF = rectF2;
                            z12 = false;
                            break;
                        } else {
                            path2.lineTo(c27, f14);
                            i10 = length;
                            f13 = c27;
                            c11 = c10;
                            path = path2;
                            rectF = rectF2;
                            z12 = false;
                        }
                    case 'L':
                    case 'l':
                        float c28 = fVar.c();
                        float c29 = fVar.c();
                        if (c10 == 'l') {
                            path2.rLineTo(c28, c29);
                            f13 += c28;
                            f14 += c29;
                            i10 = length;
                            c11 = c10;
                            path = path2;
                            rectF = rectF2;
                            z12 = false;
                            break;
                        } else {
                            path2.lineTo(c28, c29);
                            i10 = length;
                            f13 = c28;
                            f14 = c29;
                            c11 = c10;
                            path = path2;
                            rectF = rectF2;
                            z12 = false;
                        }
                    case 'M':
                    case 'm':
                        float c30 = fVar.c();
                        float c31 = fVar.c();
                        if (c10 == 'm') {
                            path2.rMoveTo(c30, c31);
                            f13 += c30;
                            f14 += c31;
                        } else {
                            path2.moveTo(c30, c31);
                            f13 = c30;
                            f14 = c31;
                        }
                        i10 = length;
                        f15 = f13;
                        f16 = f14;
                        c11 = c10;
                        path = path2;
                        rectF = rectF2;
                        z12 = false;
                        break;
                    case 'Q':
                    case 'q':
                        float c32 = fVar.c();
                        float c33 = fVar.c();
                        float c34 = fVar.c();
                        float c35 = fVar.c();
                        if (c10 == 'q') {
                            c34 += f13;
                            c35 += f14;
                            c32 += f13;
                            c33 += f14;
                        }
                        f17 = c32;
                        f18 = c33;
                        f10 = c34;
                        f11 = c35;
                        path2.cubicTo(f13, f14, f17, f18, f10, f11);
                        i10 = length;
                        f13 = f10;
                        c11 = c10;
                        path = path2;
                        rectF = rectF2;
                        f14 = f11;
                        break;
                    case 'S':
                    case 's':
                        float c36 = fVar.c();
                        float c37 = fVar.c();
                        float c38 = fVar.c();
                        float c39 = fVar.c();
                        if (c10 == 's') {
                            c36 += f13;
                            c38 += f13;
                            c37 += f14;
                            c39 += f14;
                        }
                        float f23 = c36;
                        float f24 = c37;
                        float f25 = c38;
                        float f26 = c39;
                        path2.cubicTo((f13 * 2.0f) - f17, (f14 * 2.0f) - f18, f23, f24, f25, f26);
                        i10 = length;
                        f17 = f23;
                        c11 = c10;
                        path = path2;
                        rectF = rectF2;
                        f18 = f24;
                        f13 = f25;
                        f14 = f26;
                        break;
                    case 'T':
                    case 't':
                        float c40 = fVar.c();
                        float c41 = fVar.c();
                        if (c10 == 't') {
                            c40 += f13;
                            c41 += f14;
                        }
                        f10 = c40;
                        f11 = c41;
                        f17 = (f13 * 2.0f) - f17;
                        f18 = (2.0f * f14) - f18;
                        path2.cubicTo(f13, f14, f17, f18, f10, f11);
                        i10 = length;
                        f13 = f10;
                        c11 = c10;
                        path = path2;
                        rectF = rectF2;
                        f14 = f11;
                        break;
                    case 'V':
                    case 'v':
                        float c42 = fVar.c();
                        if (c10 == 'v') {
                            path2.rLineTo(f12, c42);
                            f14 += c42;
                            i10 = length;
                            c11 = c10;
                            path = path2;
                            rectF = rectF2;
                            z12 = false;
                            break;
                        } else {
                            path2.lineTo(f13, c42);
                            i10 = length;
                            f14 = c42;
                            c11 = c10;
                            path = path2;
                            rectF = rectF2;
                            z12 = false;
                        }
                    case 'Z':
                    case 'z':
                        path2.close();
                        i10 = length;
                        c11 = c10;
                        path = path2;
                        rectF = rectF2;
                        f13 = f15;
                        f14 = f16;
                        z12 = false;
                        break;
                    default:
                        Log.w(f١٨٩٥٢a, "Invalid path command: " + c10);
                        fVar.a();
                        i10 = length;
                        c11 = c10;
                        path = path2;
                        rectF = rectF2;
                        z12 = false;
                        break;
                }
                if (!z12) {
                    f17 = f13;
                    f18 = f14;
                }
                fVar.h();
                str2 = str;
                length = i10;
                c12 = c11;
                path2 = path;
                rectF2 = rectF;
                f12 = DownloadProgress.UNKNOWN_PROGRESS;
            } else {
                return path2;
            }
        }
    }

    private static void b(Path path, double d10, double d11, double d12, double d13, double d14, double d15, double d16, boolean z10, boolean z11) {
        double d17;
        double d18;
        double d19;
        double d20 = (d10 - d12) / 2.0d;
        double d21 = (d11 - d13) / 2.0d;
        double radians = Math.toRadians(d16 % 360.0d);
        double cos = Math.cos(radians);
        double sin = Math.sin(radians);
        double d22 = (cos * d20) + (sin * d21);
        double d23 = ((-sin) * d20) + (d21 * cos);
        double abs = Math.abs(d14);
        double abs2 = Math.abs(d15);
        double d24 = abs * abs;
        double d25 = abs2 * abs2;
        double d26 = d22 * d22;
        double d27 = d23 * d23;
        double d28 = (d26 / d24) + (d27 / d25);
        double d29 = 1.0d;
        if (d28 > 1.0d) {
            abs *= Math.sqrt(d28);
            abs2 *= Math.sqrt(d28);
            d24 = abs * abs;
            d25 = abs2 * abs2;
        }
        if (z10 == z11) {
            d17 = -1.0d;
        } else {
            d17 = 1.0d;
        }
        double d30 = d24 * d25;
        double d31 = d24 * d27;
        double d32 = d25 * d26;
        double d33 = ((d30 - d31) - d32) / (d31 + d32);
        if (d33 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d33 = 0.0d;
        }
        double sqrt = d17 * Math.sqrt(d33);
        double d34 = ((abs * d23) / abs2) * sqrt;
        double d35 = sqrt * (-((abs2 * d22) / abs));
        double d36 = ((d10 + d12) / 2.0d) + ((cos * d34) - (sin * d35));
        double d37 = ((d11 + d13) / 2.0d) + (sin * d34) + (cos * d35);
        double d38 = (d22 - d34) / abs;
        double d39 = (d23 - d35) / abs2;
        double d40 = ((-d22) - d34) / abs;
        double d41 = ((-d23) - d35) / abs2;
        double d42 = (d38 * d38) + (d39 * d39);
        double sqrt2 = Math.sqrt(d42);
        if (d39 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d18 = -1.0d;
        } else {
            d18 = 1.0d;
        }
        double degrees = Math.toDegrees(d18 * Math.acos(d38 / sqrt2));
        double sqrt3 = Math.sqrt(d42 * ((d40 * d40) + (d41 * d41)));
        double d43 = (d38 * d40) + (d39 * d41);
        if ((d38 * d41) - (d39 * d40) < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d29 = -1.0d;
        }
        double degrees2 = Math.toDegrees(d29 * Math.acos(d43 / sqrt3));
        if (!z11 && degrees2 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            d19 = 360.0d;
            degrees2 -= 360.0d;
        } else {
            d19 = 360.0d;
            if (z11 && degrees2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                degrees2 += 360.0d;
            }
        }
        path.addArc(new RectF((float) (d36 - abs), (float) (d37 - abs2), (float) (d36 + abs), (float) (d37 + abs2)), (float) (degrees % d19), (float) (degrees2 % d19));
    }
}
