package com.opensource.svgaplayer.entities;

import android.graphics.Path;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.opensource.svgaplayer.utils.SVGAPoint;
import com.qiahao.base_common.download.okDownload.DownloadProgress;
import java.util.Set;
import java.util.StringTokenizer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J \u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/opensource/svgaplayer/entities/SVGAPathEntity;", "", "originValue", "", "(Ljava/lang/String;)V", "cachedPath", "Landroid/graphics/Path;", "replacedValue", "buildPath", "", "toPath", "operate", "finalPath", FirebaseAnalytics.Param.METHOD, "args", "Ljava/util/StringTokenizer;", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAPathEntity {

    @Nullable
    private Path cachedPath;

    @NotNull
    private final String replacedValue;

    public SVGAPathEntity(@NotNull String originValue) {
        Intrinsics.checkNotNullParameter(originValue, "originValue");
        this.replacedValue = StringsKt.contains$default((CharSequence) originValue, (CharSequence) ",", false, 2, (Object) null) ? StringsKt.replace$default(originValue, ",", " ", false, 4, (Object) null) : originValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void operate(Path finalPath, String method, StringTokenizer args) {
        SVGAPoint sVGAPoint;
        int i10 = 0;
        float f10 = DownloadProgress.UNKNOWN_PROGRESS;
        float f11 = DownloadProgress.UNKNOWN_PROGRESS;
        float f12 = DownloadProgress.UNKNOWN_PROGRESS;
        float f13 = DownloadProgress.UNKNOWN_PROGRESS;
        float f14 = DownloadProgress.UNKNOWN_PROGRESS;
        float f15 = DownloadProgress.UNKNOWN_PROGRESS;
        while (args.hasMoreTokens()) {
            try {
                String nextToken = args.nextToken();
                Intrinsics.checkNotNull(nextToken);
                if (nextToken.length() != 0) {
                    if (i10 == 0) {
                        f10 = Float.parseFloat(nextToken);
                    }
                    if (i10 == 1) {
                        f11 = Float.parseFloat(nextToken);
                    }
                    if (i10 == 2) {
                        f12 = Float.parseFloat(nextToken);
                    }
                    if (i10 == 3) {
                        f13 = Float.parseFloat(nextToken);
                    }
                    if (i10 == 4) {
                        f14 = Float.parseFloat(nextToken);
                    }
                    if (i10 == 5) {
                        f15 = Float.parseFloat(nextToken);
                    }
                    i10++;
                }
            } catch (Exception unused) {
            }
        }
        float f16 = f10;
        float f17 = f11;
        float f18 = f12;
        float f19 = f13;
        SVGAPoint sVGAPoint2 = new SVGAPoint(DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS, DownloadProgress.UNKNOWN_PROGRESS);
        if (Intrinsics.areEqual(method, "M")) {
            finalPath.moveTo(f16, f17);
            sVGAPoint2 = new SVGAPoint(f16, f17, DownloadProgress.UNKNOWN_PROGRESS);
        } else if (Intrinsics.areEqual(method, "m")) {
            finalPath.rMoveTo(f16, f17);
            sVGAPoint = new SVGAPoint(sVGAPoint2.getX() + f16, sVGAPoint2.getY() + f17, DownloadProgress.UNKNOWN_PROGRESS);
            if (!Intrinsics.areEqual(method, "L")) {
                finalPath.lineTo(f16, f17);
            } else if (Intrinsics.areEqual(method, "l")) {
                finalPath.rLineTo(f16, f17);
            }
            if (!Intrinsics.areEqual(method, "C")) {
                finalPath.cubicTo(f16, f17, f18, f19, f14, f15);
            } else if (Intrinsics.areEqual(method, "c")) {
                finalPath.rCubicTo(f16, f17, f18, f19, f14, f15);
            }
            if (!Intrinsics.areEqual(method, "Q")) {
                finalPath.quadTo(f16, f17, f18, f19);
            } else if (Intrinsics.areEqual(method, "q")) {
                finalPath.rQuadTo(f16, f17, f18, f19);
            }
            if (!Intrinsics.areEqual(method, "H")) {
                finalPath.lineTo(f16, sVGAPoint.getY());
            } else if (Intrinsics.areEqual(method, "h")) {
                finalPath.rLineTo(f16, DownloadProgress.UNKNOWN_PROGRESS);
            }
            if (!Intrinsics.areEqual(method, "V")) {
                finalPath.lineTo(sVGAPoint.getX(), f16);
            } else if (Intrinsics.areEqual(method, "v")) {
                finalPath.rLineTo(DownloadProgress.UNKNOWN_PROGRESS, f16);
            }
            if (!Intrinsics.areEqual(method, "Z")) {
                finalPath.close();
                return;
            } else {
                if (Intrinsics.areEqual(method, "z")) {
                    finalPath.close();
                    return;
                }
                return;
            }
        }
        sVGAPoint = sVGAPoint2;
        if (!Intrinsics.areEqual(method, "L")) {
        }
        if (!Intrinsics.areEqual(method, "C")) {
        }
        if (!Intrinsics.areEqual(method, "Q")) {
        }
        if (!Intrinsics.areEqual(method, "H")) {
        }
        if (!Intrinsics.areEqual(method, "V")) {
        }
        if (!Intrinsics.areEqual(method, "Z")) {
        }
    }

    public final void buildPath(@NotNull Path toPath) {
        Set set;
        Intrinsics.checkNotNullParameter(toPath, "toPath");
        Path path = this.cachedPath;
        if (path != null) {
            toPath.set(path);
            return;
        }
        Path path2 = new Path();
        StringTokenizer stringTokenizer = new StringTokenizer(this.replacedValue, "MLHVCSQRAZmlhvcsqraz", true);
        String str = "";
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            Intrinsics.checkNotNull(nextToken);
            if (nextToken.length() != 0) {
                set = SVGAPathEntityKt.VALID_METHODS;
                if (set.contains(nextToken)) {
                    if (Intrinsics.areEqual(nextToken, "Z") || Intrinsics.areEqual(nextToken, "z")) {
                        operate(path2, nextToken, new StringTokenizer("", ""));
                    }
                    str = nextToken;
                } else {
                    operate(path2, str, new StringTokenizer(nextToken, " "));
                }
            }
        }
        this.cachedPath = path2;
        toPath.set(path2);
    }
}
