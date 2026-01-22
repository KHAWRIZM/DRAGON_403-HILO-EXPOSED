package com.opensource.svgaplayer.glideplugin;

import com.bumptech.glide.f;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.e;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.opensource.svgaplayer.glideplugin.SVGAEntityLoader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import m4.a;
import m4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t4.n;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\"B=\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\t¢\u0006\u0004\b\f\u0010\rJ7\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00028\u0000H$¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u000e\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001d\u0010\u001eR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001fR\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010 R&\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010!¨\u0006#"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAEntityLoader;", "", "MODEL", "Lt4/n;", "Ljava/io/File;", "Ljava/io/InputStream;", "actual", "", "cachePath", "Lkotlin/Function1;", "Lcom/bumptech/glide/load/data/e;", "obtainRewind", "<init>", "(Lt4/n;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", DeviceRequestsHelper.DEVICE_INFO_MODEL, "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Lm4/i;", "options", "Lt4/n$a;", "buildLoadData", "(Ljava/lang/Object;IILm4/i;)Lt4/n$a;", "", "handles", "(Ljava/lang/Object;)Z", "toStringKey", "(Ljava/lang/Object;)Ljava/lang/String;", "Lm4/f;", "toGlideKey", "(Ljava/lang/Object;)Lm4/f;", "Lt4/n;", "Ljava/lang/String;", "Lkotlin/jvm/functions/Function1;", "SVGAEntityFetcher", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public abstract class SVGAEntityLoader<MODEL> implements n {

    @NotNull
    private final n actual;

    @NotNull
    private final String cachePath;

    @NotNull
    private final Function1<InputStream, e> obtainRewind;

    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B?\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\t¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0013\u0010\u0012\u001a\u00020\u0011*\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0011H\u0017¢\u0006\u0004\b#\u0010\u001fJ'\u0010(\u001a\u00020\u00112\u0006\u0010%\u001a\u00020$2\u000e\u0010'\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00030&H\u0016¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010*R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010+R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010*R&\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001b\u00104\u001a\u00020\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103¨\u00065"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAEntityLoader$SVGAEntityFetcher;", "Lcom/opensource/svgaplayer/glideplugin/AbsSVGAEntityDecoder;", "Lcom/bumptech/glide/load/data/d;", "Ljava/io/File;", "", "modelKey", "Ljava/io/InputStream;", "fetcher", "cachePath", "Lkotlin/Function1;", "Lcom/bumptech/glide/load/data/e;", "obtainRewind", "<init>", "(Ljava/lang/String;Lcom/bumptech/glide/load/data/d;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "source", "decode", "(Ljava/io/InputStream;)Ljava/io/File;", "", "makeSureExist", "(Ljava/io/File;)V", "inputStream", "dir", "unzip", "(Ljava/io/InputStream;Ljava/io/File;)V", "str", "cacheKey", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/lang/Class;", "getDataClass", "()Ljava/lang/Class;", "cleanup", "()V", "Lm4/a;", "getDataSource", "()Lm4/a;", "cancel", "Lcom/bumptech/glide/f;", "priority", "Lcom/bumptech/glide/load/data/d$a;", "callback", "loadData", "(Lcom/bumptech/glide/f;Lcom/bumptech/glide/load/data/d$a;)V", "Ljava/lang/String;", "Lcom/bumptech/glide/load/data/d;", "Lkotlin/jvm/functions/Function1;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isCanceled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cacheDir$delegate", "Lkotlin/Lazy;", "getCacheDir", "()Ljava/io/File;", "cacheDir", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    private static final class SVGAEntityFetcher extends AbsSVGAEntityDecoder implements d {

        /* renamed from: cacheDir$delegate, reason: from kotlin metadata */
        @NotNull
        private final Lazy cacheDir;

        @NotNull
        private final String cachePath;

        @NotNull
        private final d fetcher;

        @NotNull
        private final AtomicBoolean isCanceled;

        @NotNull
        private final String modelKey;

        @NotNull
        private final Function1<InputStream, e> obtainRewind;

        /* JADX WARN: Multi-variable type inference failed */
        public SVGAEntityFetcher(@NotNull String modelKey, @NotNull d fetcher, @NotNull String cachePath, @NotNull Function1<? super InputStream, ? extends e> obtainRewind) {
            Intrinsics.checkNotNullParameter(modelKey, "modelKey");
            Intrinsics.checkNotNullParameter(fetcher, "fetcher");
            Intrinsics.checkNotNullParameter(cachePath, "cachePath");
            Intrinsics.checkNotNullParameter(obtainRewind, "obtainRewind");
            this.modelKey = modelKey;
            this.fetcher = fetcher;
            this.cachePath = cachePath;
            this.obtainRewind = obtainRewind;
            this.isCanceled = new AtomicBoolean();
            this.cacheDir = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<File>() { // from class: com.opensource.svgaplayer.glideplugin.SVGAEntityLoader$SVGAEntityFetcher$cacheDir$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final File invoke() {
                    String str;
                    String str2;
                    String cacheKey;
                    str = SVGAEntityLoader.SVGAEntityFetcher.this.cachePath;
                    SVGAEntityLoader.SVGAEntityFetcher sVGAEntityFetcher = SVGAEntityLoader.SVGAEntityFetcher.this;
                    str2 = sVGAEntityFetcher.modelKey;
                    cacheKey = sVGAEntityFetcher.cacheKey(str2);
                    return new File(str, cacheKey);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String cacheKey(String str) {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
            byte[] bytes = str.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            byte[] digest = messageDigest.digest();
            Intrinsics.checkNotNullExpressionValue(digest, "digest");
            int length = digest.length;
            String str2 = "";
            int i10 = 0;
            while (i10 < length) {
                byte b10 = digest[i10];
                i10++;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                str2 = Intrinsics.stringPlus(str2, format);
            }
            return str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final File decode(InputStream source) {
            String[] list;
            if (this.isCanceled.get()) {
                return null;
            }
            if (getCacheDir().isDirectory() && (list = getCacheDir().list()) != null && list.length != 0) {
                return getCacheDir();
            }
            e invoke = this.obtainRewind.invoke(source);
            try {
                Object a10 = invoke.a();
                Intrinsics.checkNotNullExpressionValue(a10, "rewind.rewindAndGet()");
                byte[] readHeadAsBytes = readHeadAsBytes((InputStream) a10);
                if (readHeadAsBytes != null && isZipFormat(readHeadAsBytes) && !this.isCanceled.get()) {
                    try {
                        makeSureExist(getCacheDir());
                        Object a11 = invoke.a();
                        Intrinsics.checkNotNullExpressionValue(a11, "rewind.rewindAndGet()");
                        unzip((InputStream) a11, getCacheDir());
                    } catch (Exception e10) {
                        FilesKt.deleteRecursively(getCacheDir());
                        e10.printStackTrace();
                    }
                    return getCacheDir();
                }
                return null;
            } finally {
                invoke.cleanup();
            }
        }

        private final File getCacheDir() {
            return (File) this.cacheDir.getValue();
        }

        private final void makeSureExist(File file) {
            if (file.exists()) {
                if (!file.isDirectory()) {
                    FilesKt.deleteRecursively(file);
                    file.mkdirs();
                    return;
                }
                return;
            }
            file.mkdirs();
        }

        private final void unzip(InputStream inputStream, File dir) {
            ZipInputStream zipInputStream = new ZipInputStream(inputStream);
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry == null) {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(zipInputStream, null);
                        return;
                    }
                    String name = nextEntry.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "zipItem.name");
                    if (!StringsKt.contains$default((CharSequence) name, (CharSequence) "../", false, 2, (Object) null)) {
                        String name2 = nextEntry.getName();
                        Intrinsics.checkNotNullExpressionValue(name2, "zipItem.name");
                        if (!StringsKt.contains$default((CharSequence) name2, (CharSequence) "/", false, 2, (Object) null)) {
                            FileOutputStream fileOutputStream = new FileOutputStream(new File(dir, nextEntry.getName()));
                            try {
                                byte[] bArr = new byte[2048];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    } else {
                                        fileOutputStream.write(bArr, 0, read);
                                    }
                                }
                                Unit unit2 = Unit.INSTANCE;
                                CloseableKt.closeFinally(fileOutputStream, null);
                                zipInputStream.closeEntry();
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    CloseableKt.closeFinally(fileOutputStream, th);
                                    throw th2;
                                }
                            }
                        }
                    }
                } catch (Throwable th3) {
                    try {
                        throw th3;
                    } catch (Throwable th4) {
                        CloseableKt.closeFinally(zipInputStream, th3);
                        throw th4;
                    }
                }
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.isCanceled.set(true);
            this.fetcher.cancel();
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
            this.fetcher.cleanup();
        }

        @Override // com.bumptech.glide.load.data.d
        @NotNull
        public Class<File> getDataClass() {
            return File.class;
        }

        @Override // com.bumptech.glide.load.data.d
        @NotNull
        public a getDataSource() {
            a dataSource = this.fetcher.getDataSource();
            Intrinsics.checkNotNullExpressionValue(dataSource, "fetcher.dataSource");
            return dataSource;
        }

        @Override // com.bumptech.glide.load.data.d
        public void loadData(@NotNull f priority, @NotNull final d.a callback) {
            Intrinsics.checkNotNullParameter(priority, "priority");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.fetcher.loadData(priority, new d.a() { // from class: com.opensource.svgaplayer.glideplugin.SVGAEntityLoader$SVGAEntityFetcher$loadData$1
                @Override // com.bumptech.glide.load.data.d.a
                public void onLoadFailed(@NotNull Exception e10) {
                    Intrinsics.checkNotNullParameter(e10, "e");
                    d.a.this.onLoadFailed(e10);
                }

                @Override // com.bumptech.glide.load.data.d.a
                public void onDataReady(@Nullable InputStream data) {
                    File decode;
                    if (data != null) {
                        try {
                            decode = this.decode(data);
                            if (decode != null && decode.isDirectory()) {
                                d.a.this.onDataReady(decode);
                                return;
                            } else {
                                d.a.this.onLoadFailed(new NullPointerException("The result of SVGAEntityFetcher is null."));
                                return;
                            }
                        } catch (Exception e10) {
                            d.a.this.onLoadFailed(e10);
                            return;
                        }
                    }
                    d.a.this.onLoadFailed(new NullPointerException("Data is null."));
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SVGAEntityLoader(@NotNull n actual, @NotNull String cachePath, @NotNull Function1<? super InputStream, ? extends e> obtainRewind) {
        Intrinsics.checkNotNullParameter(actual, "actual");
        Intrinsics.checkNotNullParameter(cachePath, "cachePath");
        Intrinsics.checkNotNullParameter(obtainRewind, "obtainRewind");
        this.actual = actual;
        this.cachePath = cachePath;
        this.obtainRewind = obtainRewind;
    }

    @Override // t4.n
    @Nullable
    public n.a buildLoadData(@NotNull MODEL model, int width, int height, @NotNull i options) {
        d dVar;
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(options, "options");
        n.a buildLoadData = this.actual.buildLoadData(model, width, height, options);
        if (buildLoadData == null) {
            dVar = null;
        } else {
            dVar = buildLoadData.f١٨٠٨٦c;
        }
        if (dVar == null) {
            return null;
        }
        return new n.a(toGlideKey(model), new SVGAEntityFetcher(toStringKey(model), dVar, this.cachePath, this.obtainRewind));
    }

    @Override // t4.n
    public boolean handles(@NotNull MODEL model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return this.actual.handles(model);
    }

    @NotNull
    protected m4.f toGlideKey(@NotNull MODEL model) {
        Intrinsics.checkNotNullParameter(model, "model");
        if (model instanceof m4.f) {
            return (m4.f) model;
        }
        return new e5.d(model);
    }

    @NotNull
    protected abstract String toStringKey(@NotNull MODEL model);
}
