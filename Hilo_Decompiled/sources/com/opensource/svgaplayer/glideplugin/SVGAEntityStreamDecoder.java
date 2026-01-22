package com.opensource.svgaplayer.glideplugin;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.proto.MovieEntity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m4.i;
import m4.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p4.b;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J1\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001aR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAEntityStreamDecoder;", "Lcom/opensource/svgaplayer/glideplugin/AbsSVGAEntityDecoder;", "Lm4/k;", "Ljava/io/InputStream;", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "", "cachePath", "Lp4/b;", "arrayPool", "<init>", "(Ljava/lang/String;Lp4/b;)V", "source", "", "inflate", "(Ljava/io/InputStream;)[B", "Lm4/i;", "options", "", "handles", "(Ljava/io/InputStream;Lm4/i;)Z", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Lcom/opensource/svgaplayer/glideplugin/SVGAEntityResource;", "decode", "(Ljava/io/InputStream;IILm4/i;)Lcom/opensource/svgaplayer/glideplugin/SVGAEntityResource;", "Ljava/lang/String;", "Lp4/b;", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAEntityStreamDecoder extends AbsSVGAEntityDecoder implements k {

    @NotNull
    private final b arrayPool;

    @NotNull
    private final String cachePath;

    public SVGAEntityStreamDecoder(@NotNull String cachePath, @NotNull b arrayPool) {
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        Intrinsics.checkNotNullParameter(arrayPool, "arrayPool");
        this.cachePath = cachePath;
        this.arrayPool = arrayPool;
    }

    private final byte[] inflate(InputStream source) {
        try {
            byte[] bArr = (byte[]) this.arrayPool.c(65536, byte[].class);
            Inflater inflater = new Inflater();
            try {
                InflaterInputStream inflaterInputStream = new InflaterInputStream(source, inflater);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = inflaterInputStream.read(bArr);
                    if (read <= 0) {
                        return byteArrayOutputStream.toByteArray();
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } finally {
                this.arrayPool.put(bArr);
                inflater.end();
            }
        } catch (Throwable th) {
            handleError(th);
            return null;
        }
    }

    @Override // m4.k
    @Nullable
    public SVGAEntityResource decode(@NotNull InputStream source, int width, int height, @NotNull i options) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        byte[] inflate = inflate(source);
        if (inflate == null) {
            return null;
        }
        Object decode = MovieEntity.ADAPTER.decode(inflate);
        Intrinsics.checkNotNullExpressionValue(decode, "ADAPTER.decode(bytesOrigin)");
        SVGAVideoEntity sVGAVideoEntity = new SVGAVideoEntity((MovieEntity) decode, new File(this.cachePath));
        SVGAMovieAudioHelper.INSTANCE.setupAudios(sVGAVideoEntity);
        return new SVGAEntityResource(sVGAVideoEntity, inflate.length);
    }

    @Override // m4.k
    public boolean handles(@NotNull InputStream source, @NotNull i options) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(options, "options");
        byte[] readHeadAsBytes = readHeadAsBytes(source);
        return readHeadAsBytes != null && isZLibFormat(readHeadAsBytes);
    }
}
