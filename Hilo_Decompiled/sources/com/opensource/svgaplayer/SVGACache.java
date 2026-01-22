package com.opensource.svgaplayer;

import android.content.Context;
import com.luck.picture.lib.config.PictureMimeType;
import com.opensource.svgaplayer.utils.log.LogUtils;
import com.qiahao.base_common.model.eventBus.VideoEvent;
import com.qiahao.base_common.utils.PathHelper;
import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001 B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0018J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0010\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0018\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/opensource/svgaplayer/SVGACache;", "", "()V", "TAG", "", "cacheDir", "getCacheDir", "()Ljava/lang/String;", "type", "Lcom/opensource/svgaplayer/SVGACache$Type;", "buildAudioFile", "Ljava/io/File;", PictureMimeType.MIME_TYPE_PREFIX_AUDIO, "buildCacheDir", "cacheKey", "buildCacheKey", "url", "Ljava/net/URL;", "str", "buildSvgaFile", "clearCache", "", "clearDir", "path", "clearDir$lib_svga_release", "isCached", "", "isDefaultCache", "isInitialized", "onCreate", "context", "Landroid/content/Context;", "Type", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSVGACache.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SVGACache.kt\ncom/opensource/svgaplayer/SVGACache\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,119:1\n1#2:120\n13309#3,2:121\n*S KotlinDebug\n*F\n+ 1 SVGACache.kt\ncom/opensource/svgaplayer/SVGACache\n*L\n63#1:121,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGACache {

    @NotNull
    private static final String TAG = "SVGACache";

    @NotNull
    public static final SVGACache INSTANCE = new SVGACache();

    @NotNull
    private static Type type = Type.DEFAULT;

    @NotNull
    private static String cacheDir = "/";

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/opensource/svgaplayer/SVGACache$Type;", "", "(Ljava/lang/String;I)V", VideoEvent.DEFAULT, "FILE", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type DEFAULT = new Type(VideoEvent.DEFAULT, 0);
        public static final Type FILE = new Type("FILE", 1);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{DEFAULT, FILE};
        }

        static {
            Type[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Type(String str, int i10) {
        }

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    private SVGACache() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearCache$lambda$1() {
        SVGACache sVGACache = INSTANCE;
        sVGACache.clearDir$lib_svga_release(sVGACache.getCacheDir());
        LogUtils.INSTANCE.info(TAG, "Clear svga cache done!");
    }

    private final String getCacheDir() {
        if (!Intrinsics.areEqual(cacheDir, "/")) {
            File file = new File(cacheDir);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return cacheDir;
    }

    @NotNull
    public final File buildAudioFile(@NotNull String audio) {
        Intrinsics.checkNotNullParameter(audio, "audio");
        return new File(getCacheDir() + audio + PictureMimeType.MP3);
    }

    @NotNull
    public final File buildCacheDir(@NotNull String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        return new File(getCacheDir() + cacheKey + "/");
    }

    @NotNull
    public final String buildCacheKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        Charset forName = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
        byte[] bytes = str.getBytes(forName);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        Intrinsics.checkNotNull(digest);
        String str2 = "";
        for (byte b10 : digest) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            str2 = str2 + format;
        }
        return str2;
    }

    @NotNull
    public final File buildSvgaFile(@NotNull String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        return new File(getCacheDir() + cacheKey + PathHelper.SUFFIX_TYPE_SVGA);
    }

    public final void clearCache() {
        if (!isInitialized()) {
            LogUtils.INSTANCE.error(TAG, "SVGACache is not init!");
        } else {
            SVGAParser.INSTANCE.getThreadPoolExecutor$lib_svga_release().execute(new Runnable() { // from class: com.opensource.svgaplayer.a
                @Override // java.lang.Runnable
                public final void run() {
                    SVGACache.clearCache$lambda$1();
                }
            });
        }
    }

    public final void clearDir$lib_svga_release(@NotNull String path) {
        File[] listFiles;
        Intrinsics.checkNotNullParameter(path, "path");
        try {
            File file = new File(path);
            if (!file.exists()) {
                file = null;
            }
            if (file != null && (listFiles = file.listFiles()) != null) {
                Intrinsics.checkNotNull(listFiles);
                for (File file2 : listFiles) {
                    if (file2.exists()) {
                        if (file2.isDirectory()) {
                            SVGACache sVGACache = INSTANCE;
                            String absolutePath = file2.getAbsolutePath();
                            Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                            sVGACache.clearDir$lib_svga_release(absolutePath);
                        }
                        file2.delete();
                    }
                }
            }
        } catch (Exception e10) {
            LogUtils.INSTANCE.error(TAG, "Clear svga cache path: " + path + " fail", e10);
        }
    }

    public final boolean isCached(@NotNull String cacheKey) {
        File buildSvgaFile;
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        if (isDefaultCache()) {
            buildSvgaFile = buildCacheDir(cacheKey);
        } else {
            buildSvgaFile = buildSvgaFile(cacheKey);
        }
        return buildSvgaFile.exists();
    }

    public final boolean isDefaultCache() {
        if (type == Type.DEFAULT) {
            return true;
        }
        return false;
    }

    public final boolean isInitialized() {
        if (!Intrinsics.areEqual("/", getCacheDir()) && new File(getCacheDir()).exists()) {
            return true;
        }
        return false;
    }

    public final void onCreate(@Nullable Context context) {
        onCreate(context, Type.DEFAULT);
    }

    public final void onCreate(@Nullable Context context, @NotNull Type type2) {
        Intrinsics.checkNotNullParameter(type2, "type");
        if (isInitialized() || context == null) {
            return;
        }
        cacheDir = context.getCacheDir().getAbsolutePath() + "/svga/";
        File file = new File(getCacheDir());
        if (file.exists()) {
            file = null;
        }
        if (file != null) {
            file.mkdirs();
        }
        type = type2;
    }

    @NotNull
    public final String buildCacheKey(@NotNull URL url) {
        Intrinsics.checkNotNullParameter(url, "url");
        String url2 = url.toString();
        Intrinsics.checkNotNullExpressionValue(url2, "toString(...)");
        return buildCacheKey(url2);
    }
}
