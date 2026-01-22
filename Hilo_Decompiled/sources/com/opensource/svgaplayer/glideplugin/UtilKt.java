package com.opensource.svgaplayer.glideplugin;

import com.bumptech.glide.i;
import com.bumptech.glide.j;
import com.opensource.svgaplayer.SVGADrawable;
import com.opensource.svgaplayer.SVGAVideoEntity;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00060\u00060\u0001*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0005\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\f\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\f\u0010\u000b\"\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\"\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bumptech/glide/j;", "Lcom/bumptech/glide/i;", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "kotlin.jvm.PlatformType", "asSVGA", "(Lcom/bumptech/glide/j;)Lcom/bumptech/glide/i;", "Lcom/opensource/svgaplayer/SVGADrawable;", "asSVGADrawable", "Ljava/io/File;", "", "isSVGAUnZipFile", "(Ljava/io/File;)Z", "isSVGACacheFile", "", "movieBinary", "Ljava/lang/String;", "movieSpec", "glideplugin_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class UtilKt {

    @NotNull
    public static final String movieBinary = "movie.binary";

    @NotNull
    public static final String movieSpec = "movie.spec";

    @NotNull
    public static final i asSVGA(@NotNull j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        i a10 = jVar.a(SVGAVideoEntity.class);
        Intrinsics.checkNotNullExpressionValue(a10, "`as`(SVGAVideoEntity::class.java)");
        return a10;
    }

    @NotNull
    public static final i asSVGADrawable(@NotNull j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<this>");
        i a10 = jVar.a(SVGADrawable.class);
        Intrinsics.checkNotNullExpressionValue(a10, "`as`(SVGADrawable::class.java)");
        return a10;
    }

    public static final boolean isSVGACacheFile(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                boolean readHeadAsSVGA = SVGACacheFileHandler.INSTANCE.readHeadAsSVGA(fileInputStream);
                CloseableKt.closeFinally(fileInputStream, null);
                return readHeadAsSVGA;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public static final boolean isSVGAUnZipFile(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return isSVGAUnZipFile$hasChild(file, movieBinary, movieSpec);
    }

    private static final boolean isSVGAUnZipFile$hasChild(File file, String... strArr) {
        Set set;
        if (!file.isDirectory()) {
            return false;
        }
        String[] list = file.list();
        if (list == null) {
            set = null;
        } else {
            set = ArraysKt.toSet(list);
        }
        if (set == null) {
            set = SetsKt.emptySet();
        }
        int length = strArr.length;
        int i10 = 0;
        while (i10 < length) {
            String str = strArr[i10];
            i10++;
            if (set.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
