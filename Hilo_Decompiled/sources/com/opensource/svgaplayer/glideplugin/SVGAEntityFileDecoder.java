package com.opensource.svgaplayer.glideplugin;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.proto.MovieEntity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import m4.i;
import m4.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import p4.b;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u000bJ\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u001a\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAEntityFileDecoder;", "Lm4/k;", "Ljava/io/File;", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "Lp4/b;", "arrayPool", "<init>", "(Lp4/b;)V", "source", "Lcom/opensource/svgaplayer/glideplugin/SVGAEntityResource;", "decodeUnZipFile", "(Ljava/io/File;)Lcom/opensource/svgaplayer/glideplugin/SVGAEntityResource;", "binaryFile", "parseBinaryFile", "(Ljava/io/File;Ljava/io/File;)Lcom/opensource/svgaplayer/glideplugin/SVGAEntityResource;", "jsonFile", "parseSpecFile", "decodeCacheFile", "Lm4/i;", "options", "", "handles", "(Ljava/io/File;Lm4/i;)Z", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "decode", "(Ljava/io/File;IILm4/i;)Lcom/opensource/svgaplayer/glideplugin/SVGAEntityResource;", "Lp4/b;", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAEntityFileDecoder implements k {

    @NotNull
    private final b arrayPool;

    public SVGAEntityFileDecoder(@NotNull b arrayPool) {
        Intrinsics.checkNotNullParameter(arrayPool, "arrayPool");
        this.arrayPool = arrayPool;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, java.lang.String] */
    private final SVGAEntityResource decodeCacheFile(File source) {
        byte[] bArr = (byte[]) this.arrayPool.c(65536, byte[].class);
        try {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            FileInputStream fileInputStream = new FileInputStream(source);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    if (SVGACacheFileHandler.INSTANCE.readHeadAsSVGA(fileInputStream)) {
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        Intrinsics.checkNotNullExpressionValue(byteArray, "byteBuffer.toByteArray()");
                        objectRef.element = new String(byteArray, Charsets.UTF_8);
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    CloseableKt.closeFinally(fileInputStream, null);
                    String str = (String) objectRef.element;
                    if (str != null) {
                        SVGAEntityResource decodeUnZipFile = decodeUnZipFile(new File(str));
                        this.arrayPool.put(bArr);
                        return decodeUnZipFile;
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(fileInputStream, th);
                    throw th2;
                }
            }
        } catch (Throwable unused) {
        }
        this.arrayPool.put(bArr);
        return null;
    }

    private final SVGAEntityResource decodeUnZipFile(File source) {
        File file = new File(source, UtilKt.movieBinary);
        File file2 = new File(source, UtilKt.movieSpec);
        if (file.isFile()) {
            return parseBinaryFile(source, file);
        }
        if (file2.isFile()) {
            return parseSpecFile(source, file2);
        }
        return null;
    }

    private final SVGAEntityResource parseBinaryFile(File source, File binaryFile) {
        try {
            FileInputStream fileInputStream = new FileInputStream(binaryFile);
            try {
                Object decode = MovieEntity.ADAPTER.decode(fileInputStream);
                Intrinsics.checkNotNullExpressionValue(decode, "ADAPTER.decode(it)");
                SVGAVideoEntity sVGAVideoEntity = new SVGAVideoEntity((MovieEntity) decode, source);
                SVGAMovieAudioHelper.INSTANCE.setupAudios(sVGAVideoEntity);
                SVGAEntityResource sVGAEntityResource = new SVGAEntityResource(sVGAVideoEntity, (int) source.getTotalSpace());
                CloseableKt.closeFinally(fileInputStream, null);
                return sVGAEntityResource;
            } finally {
            }
        } catch (Exception unused) {
            binaryFile.delete();
            return null;
        }
    }

    private final SVGAEntityResource parseSpecFile(File source, File jsonFile) {
        byte[] bArr = (byte[]) this.arrayPool.c(65536, byte[].class);
        try {
            FileInputStream fileInputStream = new FileInputStream(jsonFile);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            SVGAEntityResource sVGAEntityResource = new SVGAEntityResource(new SVGAVideoEntity(new JSONObject(byteArrayOutputStream.toString()), source), (int) source.getTotalSpace());
                            CloseableKt.closeFinally(byteArrayOutputStream, null);
                            CloseableKt.closeFinally(fileInputStream, null);
                            return sVGAEntityResource;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(byteArrayOutputStream, th);
                            throw th2;
                        }
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(fileInputStream, th3);
                    throw th4;
                }
            }
        } catch (Exception unused) {
            jsonFile.delete();
            return null;
        } finally {
            this.arrayPool.put(bArr);
        }
    }

    @Override // m4.k
    @Nullable
    public SVGAEntityResource decode(@NotNull File source, int width, int height, @NotNull i options) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        if (UtilKt.isSVGAUnZipFile(source)) {
            return decodeUnZipFile(source);
        }
        return decodeCacheFile(source);
    }

    @Override // m4.k
    public boolean handles(@NotNull File source, @NotNull i options) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        return UtilKt.isSVGAUnZipFile(source) || UtilKt.isSVGACacheFile(source);
    }
}
