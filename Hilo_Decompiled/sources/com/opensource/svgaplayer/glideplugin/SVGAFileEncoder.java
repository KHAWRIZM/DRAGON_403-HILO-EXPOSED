package com.opensource.svgaplayer.glideplugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import m4.d;
import m4.i;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAFileEncoder;", "Lm4/d;", "Ljava/io/File;", "<init>", "()V", "data", "file", "Lm4/i;", "options", "", "encode", "(Ljava/io/File;Ljava/io/File;Lm4/i;)Z", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAFileEncoder implements d {
    @Override // m4.d
    public boolean encode(@NotNull File data, @NotNull File file, @NotNull i options) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(options, "options");
        if (UtilKt.isSVGAUnZipFile(data)) {
            String path = data.getAbsolutePath();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                SVGACacheFileHandler.INSTANCE.writeHead(fileOutputStream);
                Intrinsics.checkNotNullExpressionValue(path, "path");
                byte[] bytes = path.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                fileOutputStream.write(bytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
                return true;
            } finally {
            }
        } else {
            if (UtilKt.isSVGACacheFile(data)) {
                FileChannel channel = new FileInputStream(data).getChannel();
                try {
                    FileChannel channel2 = new FileOutputStream(file).getChannel();
                    try {
                        channel2.transferFrom(channel, 0L, channel.size());
                        CloseableKt.closeFinally(channel2, null);
                        CloseableKt.closeFinally(channel, null);
                        return true;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(channel, th);
                        throw th2;
                    }
                }
            }
            return false;
        }
        return false;
    }
}
