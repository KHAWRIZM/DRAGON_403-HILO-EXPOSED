package com.opensource.svgaplayer;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.http.HttpResponseCache;
import android.os.Handler;
import android.os.Looper;
import anet.channel.request.Request;
import com.amazonaws.services.s3.Headers;
import com.facebook.login.LoginLogger;
import com.google.android.gms.appinvite.PreviewActivity;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.glideplugin.UtilKt;
import com.opensource.svgaplayer.proto.MovieEntity;
import com.opensource.svgaplayer.utils.log.LogUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 <2\u00020\u0001:\u0004<=>?B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J$\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0002JB\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0012J.\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0012J \u0010 \u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J,\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0012H\u0002J\u0012\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020)H\u0002J\u000e\u0010+\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0003J$\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020.2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0002J(\u0010/\u001a\u00020\u00102\n\u00100\u001a\u000601j\u0002`22\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u00103\u001a\u00020\u001e2\u0006\u00104\u001a\u00020)H\u0002J,\u00105\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0007J\u001a\u00105\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u001a\u00105\u001a\u00020\u00102\u0006\u00106\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u0012\u00107\u001a\u0004\u0018\u00010)2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0016\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020\r2\u0006\u0010:\u001a\u00020\rJ\u0018\u0010;\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0012H\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/opensource/svgaplayer/SVGAParser;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fileDownloader", "Lcom/opensource/svgaplayer/SVGAParser$FileDownloader;", "getFileDownloader", "()Lcom/opensource/svgaplayer/SVGAParser$FileDownloader;", "setFileDownloader", "(Lcom/opensource/svgaplayer/SVGAParser$FileDownloader;)V", "mContext", "mFrameHeight", "", "mFrameWidth", "decodeFromAssets", "", "name", "", "callback", "Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;", "playCallback", "Lcom/opensource/svgaplayer/SVGAParser$PlayCallback;", "decodeFromCacheKey", "cacheKey", "alias", "decodeFromInputStream", "inputStream", "Ljava/io/InputStream;", "closeInputStream", "", "decodeFromSVGAFileCacheKey", "decodeFromURL", "Lkotlin/Function0;", "url", "Ljava/net/URL;", "ensureUnzipSafety", "outputFile", "Ljava/io/File;", "dstDirPath", "inflate", "", "byteArray", "init", "invokeCompleteCallback", "videoItem", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "invokeErrorCallback", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isZipFile", "bytes", "parse", "assetsName", "readAsBytes", "setFrameSize", "frameWidth", "frameHeight", "unzip", "Companion", "FileDownloader", "ParseCompletion", "PlayCallback", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nSVGAParser.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SVGAParser.kt\ncom/opensource/svgaplayer/SVGAParser\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,584:1\n1#2:585\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAParser {

    @NotNull
    private static final String TAG = "SVGAParser";

    @NotNull
    private FileDownloader fileDownloader;

    @Nullable
    private Context mContext;
    private volatile int mFrameHeight;
    private volatile int mFrameWidth;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final AtomicInteger threadNum = new AtomicInteger(0);

    @NotNull
    private static SVGAParser mShareParser = new SVGAParser(null);
    private static ExecutorService threadPoolExecutor = Executors.newCachedThreadPool(new ThreadFactory() { // from class: com.opensource.svgaplayer.h
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            Thread threadPoolExecutor$lambda$31;
            threadPoolExecutor$lambda$31 = SVGAParser.threadPoolExecutor$lambda$31(runnable);
            return threadPoolExecutor$lambda$31;
        }
    });

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/opensource/svgaplayer/SVGAParser$Companion;", "", "()V", "TAG", "", "mShareParser", "Lcom/opensource/svgaplayer/SVGAParser;", "threadNum", "Ljava/util/concurrent/atomic/AtomicInteger;", "threadPoolExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getThreadPoolExecutor$lib_svga_release", "()Ljava/util/concurrent/ExecutorService;", "setThreadPoolExecutor$lib_svga_release", "(Ljava/util/concurrent/ExecutorService;)V", "setThreadPoolExecutor", "", "executor", "Ljava/util/concurrent/ThreadPoolExecutor;", "shareParser", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ExecutorService getThreadPoolExecutor$lib_svga_release() {
            return SVGAParser.threadPoolExecutor;
        }

        public final void setThreadPoolExecutor(@NotNull ThreadPoolExecutor executor) {
            Intrinsics.checkNotNullParameter(executor, "executor");
            setThreadPoolExecutor$lib_svga_release(executor);
        }

        public final void setThreadPoolExecutor$lib_svga_release(ExecutorService executorService) {
            SVGAParser.threadPoolExecutor = executorService;
        }

        @NotNull
        public final SVGAParser shareParser() {
            return SVGAParser.mShareParser;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J`\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0\u000f2%\u0010\u0014\u001a!\u0012\u0017\u0012\u00150\u0015j\u0002`\u0016¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000b0\u000fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/opensource/svgaplayer/SVGAParser$FileDownloader;", "", "()V", "noCache", "", "getNoCache", "()Z", "setNoCache", "(Z)V", "resume", "Lkotlin/Function0;", "", "url", "Ljava/net/URL;", "complete", "Lkotlin/Function1;", "Ljava/io/InputStream;", "Lkotlin/ParameterName;", "name", "inputStream", LoginLogger.EVENT_EXTRAS_FAILURE, "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static class FileDownloader {
        private boolean noCache;

        public static final void resume$lambda$4(FileDownloader this$0, URL url, Function1 failure, Ref.BooleanRef cancelled, Function1 complete) {
            HttpURLConnection httpURLConnection;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(url, "$url");
            Intrinsics.checkNotNullParameter(failure, "$failure");
            Intrinsics.checkNotNullParameter(cancelled, "$cancelled");
            Intrinsics.checkNotNullParameter(complete, "$complete");
            try {
                LogUtils logUtils = LogUtils.INSTANCE;
                logUtils.info(SVGAParser.TAG, "================ svga file download start ================");
                if (HttpResponseCache.getInstalled() == null && !this$0.noCache) {
                    logUtils.error(SVGAParser.TAG, "SVGAParser can not handle cache before install HttpResponseCache. see https://github.com/yyued/SVGAPlayer-Android#cache");
                    logUtils.error(SVGAParser.TAG, "在配置 HttpResponseCache 前 SVGAParser 无法缓存. 查看 https://github.com/yyued/SVGAPlayer-Android#cache ");
                }
                URLConnection openConnection = url.openConnection();
                if (openConnection instanceof HttpURLConnection) {
                    httpURLConnection = (HttpURLConnection) openConnection;
                } else {
                    httpURLConnection = null;
                }
                if (httpURLConnection != null) {
                    httpURLConnection.setConnectTimeout(20000);
                    httpURLConnection.setRequestMethod(Request.Method.GET);
                    httpURLConnection.setRequestProperty(Headers.CONNECTION, PreviewActivity.ON_CLICK_LISTENER_CLOSE);
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                if (cancelled.element) {
                                    LogUtils.INSTANCE.warn(SVGAParser.TAG, "================ svga file download canceled ================");
                                    break;
                                }
                                int read = inputStream.read(bArr, 0, 4096);
                                if (read == -1) {
                                    break;
                                } else {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                            }
                            if (cancelled.element) {
                                LogUtils.INSTANCE.warn(SVGAParser.TAG, "================ svga file download canceled ================");
                                CloseableKt.closeFinally(byteArrayOutputStream, null);
                                CloseableKt.closeFinally(inputStream, null);
                                return;
                            }
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            try {
                                LogUtils.INSTANCE.info(SVGAParser.TAG, "================ svga file download complete ================");
                                complete.invoke(byteArrayInputStream);
                                Unit unit = Unit.INSTANCE;
                                CloseableKt.closeFinally(byteArrayInputStream, null);
                                CloseableKt.closeFinally(byteArrayOutputStream, null);
                                CloseableKt.closeFinally(inputStream, null);
                            } finally {
                            }
                        } finally {
                        }
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(inputStream, th);
                            throw th2;
                        }
                    }
                }
            } catch (Exception e10) {
                LogUtils logUtils2 = LogUtils.INSTANCE;
                logUtils2.error(SVGAParser.TAG, "================ svga file download fail ================");
                logUtils2.error(SVGAParser.TAG, "error: " + e10.getMessage());
                e10.printStackTrace();
                failure.invoke(e10);
            }
        }

        public final boolean getNoCache() {
            return this.noCache;
        }

        @NotNull
        public Function0<Unit> resume(@NotNull final URL url, @NotNull final Function1<? super InputStream, Unit> complete, @NotNull final Function1<? super Exception, Unit> r12) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(complete, "complete");
            Intrinsics.checkNotNullParameter(r12, "failure");
            final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            Function0<Unit> function0 = new Function0<Unit>() { // from class: com.opensource.svgaplayer.SVGAParser$FileDownloader$resume$cancelBlock$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Ref.BooleanRef.this.element = true;
                }
            };
            SVGAParser.INSTANCE.getThreadPoolExecutor$lib_svga_release().execute(new Runnable() { // from class: com.opensource.svgaplayer.m
                @Override // java.lang.Runnable
                public final void run() {
                    SVGAParser.FileDownloader.resume$lambda$4(SVGAParser.FileDownloader.this, url, r12, booleanRef, complete);
                }
            });
            return function0;
        }

        public final void setNoCache(boolean z10) {
            this.noCache = z10;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcom/opensource/svgaplayer/SVGAParser$ParseCompletion;", "", "onComplete", "", "videoItem", "Lcom/opensource/svgaplayer/SVGAVideoEntity;", "onError", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface ParseCompletion {
        void onComplete(@NotNull SVGAVideoEntity videoItem);

        void onError();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u0007"}, d2 = {"Lcom/opensource/svgaplayer/SVGAParser$PlayCallback;", "", "onPlay", "", "file", "", "Ljava/io/File;", "lib_svga_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface PlayCallback {
        void onPlay(@NotNull List<? extends File> file);
    }

    public SVGAParser(@Nullable Context context) {
        Context context2;
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        this.mContext = context2;
        SVGACache.INSTANCE.onCreate(context);
        this.fileDownloader = new FileDownloader();
    }

    public static /* synthetic */ void decodeFromAssets$default(SVGAParser sVGAParser, String str, ParseCompletion parseCompletion, PlayCallback playCallback, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            playCallback = null;
        }
        sVGAParser.decodeFromAssets(str, parseCompletion, playCallback);
    }

    public static final void decodeFromAssets$lambda$1(SVGAParser this$0, String name, ParseCompletion parseCompletion, PlayCallback playCallback) {
        AssetManager assets;
        InputStream open;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(name, "$name");
        try {
            Context context = this$0.mContext;
            if (context != null && (assets = context.getAssets()) != null && (open = assets.open(name)) != null) {
                this$0.decodeFromInputStream(open, SVGACache.INSTANCE.buildCacheKey("file:///assets/" + name), parseCompletion, true, playCallback, name);
            }
        } catch (Exception e10) {
            this$0.invokeErrorCallback(e10, parseCompletion, name);
        }
    }

    private final void decodeFromCacheKey(String cacheKey, ParseCompletion callback, String alias) {
        FileInputStream fileInputStream;
        LogUtils logUtils = LogUtils.INSTANCE;
        logUtils.info(TAG, "================ decode " + alias + " from cache ================");
        StringBuilder sb = new StringBuilder();
        sb.append("decodeFromCacheKey called with cacheKey : ");
        sb.append(cacheKey);
        logUtils.debug(TAG, sb.toString());
        if (this.mContext == null) {
            logUtils.error(TAG, "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return;
        }
        try {
            File buildCacheDir = SVGACache.INSTANCE.buildCacheDir(cacheKey);
            File file = new File(buildCacheDir, UtilKt.movieBinary);
            if (!file.isFile()) {
                file = null;
            }
            if (file != null) {
                try {
                    logUtils.info(TAG, "binary change to entity");
                    fileInputStream = new FileInputStream(file);
                    try {
                        logUtils.info(TAG, "binary change to entity success");
                        Object decode = MovieEntity.ADAPTER.decode(fileInputStream);
                        Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
                        invokeCompleteCallback(new SVGAVideoEntity((MovieEntity) decode, buildCacheDir, this.mFrameWidth, this.mFrameHeight), callback, alias);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileInputStream, null);
                    } finally {
                    }
                } catch (Exception e10) {
                    LogUtils.INSTANCE.error(TAG, "binary change to entity fail", e10);
                    buildCacheDir.delete();
                    file.delete();
                    throw e10;
                }
            }
            File file2 = new File(buildCacheDir, UtilKt.movieSpec);
            if (!file2.isFile()) {
                file2 = null;
            }
            if (file2 != null) {
                try {
                    logUtils.info(TAG, "spec change to entity");
                    fileInputStream = new FileInputStream(file2);
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[2048];
                            while (true) {
                                int read = fileInputStream.read(bArr, 0, 2048);
                                if (read == -1) {
                                    JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                                    LogUtils.INSTANCE.info(TAG, "spec change to entity success");
                                    invokeCompleteCallback(new SVGAVideoEntity(jSONObject, buildCacheDir, this.mFrameWidth, this.mFrameHeight), callback, alias);
                                    Unit unit2 = Unit.INSTANCE;
                                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                                    CloseableKt.closeFinally(fileInputStream, null);
                                    return;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            }
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                CloseableKt.closeFinally(byteArrayOutputStream, th);
                                throw th2;
                            }
                        }
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                } catch (Exception e11) {
                    LogUtils.INSTANCE.error(TAG, alias + " movie.spec change to entity fail", e11);
                    buildCacheDir.delete();
                    file2.delete();
                    throw e11;
                }
            }
        } catch (Exception e12) {
            invokeErrorCallback(e12, callback, alias);
        }
    }

    public static /* synthetic */ void decodeFromInputStream$default(SVGAParser sVGAParser, InputStream inputStream, String str, ParseCompletion parseCompletion, boolean z10, PlayCallback playCallback, String str2, int i10, Object obj) {
        boolean z11;
        PlayCallback playCallback2;
        String str3;
        if ((i10 & 8) != 0) {
            z11 = false;
        } else {
            z11 = z10;
        }
        if ((i10 & 16) != 0) {
            playCallback2 = null;
        } else {
            playCallback2 = playCallback;
        }
        if ((i10 & 32) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        sVGAParser.decodeFromInputStream(inputStream, str, parseCompletion, z11, playCallback2, str3);
    }

    public static final void decodeFromInputStream$lambda$14(SVGAParser this$0, InputStream inputStream, final ParseCompletion parseCompletion, final String str, boolean z10, final String cacheKey, PlayCallback playCallback) {
        LogUtils logUtils;
        String str2;
        StringBuilder sb;
        int i10;
        boolean z11;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(inputStream, "$inputStream");
        Intrinsics.checkNotNullParameter(cacheKey, "$cacheKey");
        try {
            try {
                final byte[] readAsBytes = this$0.readAsBytes(inputStream);
                Unit unit = null;
                if (readAsBytes != null) {
                    if (this$0.isZipFile(readAsBytes)) {
                        LogUtils logUtils2 = LogUtils.INSTANCE;
                        logUtils2.info(TAG, "decode from zip file");
                        SVGACache sVGACache = SVGACache.INSTANCE;
                        if (sVGACache.buildCacheDir(cacheKey).exists()) {
                            z11 = SVGAParserKt.isUnzipping;
                            if (z11) {
                            }
                            this$0.decodeFromCacheKey(cacheKey, parseCompletion, str);
                        }
                        i10 = SVGAParserKt.fileLock;
                        synchronized (Integer.valueOf(i10)) {
                            if (!sVGACache.buildCacheDir(cacheKey).exists()) {
                                SVGAParserKt.isUnzipping = true;
                                logUtils2.info(TAG, "no cached, prepare to unzip");
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readAsBytes);
                                try {
                                    this$0.unzip(byteArrayInputStream, cacheKey);
                                    SVGAParserKt.isUnzipping = false;
                                    logUtils2.info(TAG, "unzip success");
                                    Unit unit2 = Unit.INSTANCE;
                                    CloseableKt.closeFinally(byteArrayInputStream, null);
                                } finally {
                                }
                            }
                            Unit unit3 = Unit.INSTANCE;
                        }
                        this$0.decodeFromCacheKey(cacheKey, parseCompletion, str);
                    } else {
                        if (!SVGACache.INSTANCE.isDefaultCache()) {
                            threadPoolExecutor.execute(new Runnable() { // from class: com.opensource.svgaplayer.l
                                @Override // java.lang.Runnable
                                public final void run() {
                                    SVGAParser.decodeFromInputStream$lambda$14$lambda$13$lambda$11(cacheKey, readAsBytes);
                                }
                            });
                        }
                        LogUtils logUtils3 = LogUtils.INSTANCE;
                        logUtils3.info(TAG, "inflate start");
                        byte[] inflate = this$0.inflate(readAsBytes);
                        if (inflate != null) {
                            logUtils3.info(TAG, "inflate complete");
                            Object decode = MovieEntity.ADAPTER.decode(inflate);
                            Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
                            final SVGAVideoEntity sVGAVideoEntity = new SVGAVideoEntity((MovieEntity) decode, new File(cacheKey), this$0.mFrameWidth, this$0.mFrameHeight);
                            logUtils3.info(TAG, "SVGAVideoEntity prepare start");
                            sVGAVideoEntity.prepare$lib_svga_release(new Function0<Unit>() { // from class: com.opensource.svgaplayer.SVGAParser$decodeFromInputStream$1$1$3$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Unit invoke() {
                                    invoke2();
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2() {
                                    LogUtils.INSTANCE.info("SVGAParser", "SVGAVideoEntity prepare success");
                                    SVGAParser.this.invokeCompleteCallback(sVGAVideoEntity, parseCompletion, str);
                                }
                            }, playCallback);
                            unit = Unit.INSTANCE;
                        }
                        if (unit == null) {
                            this$0.invokeErrorCallback(new Exception("inflate(bytes) cause exception"), parseCompletion, str);
                        }
                    }
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    this$0.invokeErrorCallback(new Exception("readAsBytes(inputStream) cause exception"), parseCompletion, str);
                }
                if (z10) {
                    inputStream.close();
                }
                logUtils = LogUtils.INSTANCE;
                str2 = TAG;
                sb = new StringBuilder();
            } catch (Throwable th) {
                if (z10) {
                    inputStream.close();
                }
                LogUtils.INSTANCE.info(TAG, "================ decode " + str + " from input stream end ================");
                throw th;
            }
        } catch (Exception e10) {
            this$0.invokeErrorCallback(e10, parseCompletion, str);
            if (z10) {
                inputStream.close();
            }
            logUtils = LogUtils.INSTANCE;
            str2 = TAG;
            sb = new StringBuilder();
        } catch (OutOfMemoryError e11) {
            String message = e11.getMessage();
            if (message == null) {
                message = "OutOfMemoryError";
            }
            this$0.invokeErrorCallback(new Exception(message), parseCompletion, str);
            if (z10) {
                inputStream.close();
            }
            logUtils = LogUtils.INSTANCE;
            str2 = TAG;
            sb = new StringBuilder();
        }
        sb.append("================ decode ");
        sb.append(str);
        sb.append(" from input stream end ================");
        logUtils.info(str2, sb.toString());
    }

    public static final void decodeFromInputStream$lambda$14$lambda$13$lambda$11(String cacheKey, byte[] bytes) {
        File file;
        Intrinsics.checkNotNullParameter(cacheKey, "$cacheKey");
        Intrinsics.checkNotNullParameter(bytes, "$bytes");
        File buildSvgaFile = SVGACache.INSTANCE.buildSvgaFile(cacheKey);
        try {
            if (!buildSvgaFile.exists()) {
                file = buildSvgaFile;
            } else {
                file = null;
            }
            if (file != null) {
                file.createNewFile();
            }
            new FileOutputStream(buildSvgaFile).write(bytes);
        } catch (Exception e10) {
            LogUtils.INSTANCE.error(TAG, "create cache file fail.", e10);
            buildSvgaFile.delete();
        }
    }

    public static /* synthetic */ void decodeFromSVGAFileCacheKey$default(SVGAParser sVGAParser, String str, ParseCompletion parseCompletion, PlayCallback playCallback, String str2, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        sVGAParser.decodeFromSVGAFileCacheKey(str, parseCompletion, playCallback, str2);
    }

    public static final void decodeFromSVGAFileCacheKey$lambda$6(final String str, String cacheKey, SVGAParser this$0, final ParseCompletion parseCompletion, PlayCallback playCallback) {
        LogUtils logUtils;
        StringBuilder sb;
        Unit unit;
        Unit unit2;
        Intrinsics.checkNotNullParameter(cacheKey, "$cacheKey");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            try {
                LogUtils logUtils2 = LogUtils.INSTANCE;
                logUtils2.info(TAG, "================ decode " + str + " from svga cachel file to entity ================");
                FileInputStream fileInputStream = new FileInputStream(SVGACache.INSTANCE.buildSvgaFile(cacheKey));
                try {
                    byte[] readAsBytes = this$0.readAsBytes(fileInputStream);
                    if (readAsBytes != null) {
                        if (this$0.isZipFile(readAsBytes)) {
                            this$0.decodeFromCacheKey(cacheKey, parseCompletion, str);
                        } else {
                            logUtils2.info(TAG, "inflate start");
                            byte[] inflate = this$0.inflate(readAsBytes);
                            if (inflate != null) {
                                logUtils2.info(TAG, "inflate complete");
                                Object decode = MovieEntity.ADAPTER.decode(inflate);
                                Intrinsics.checkNotNullExpressionValue(decode, "decode(...)");
                                final SVGAVideoEntity sVGAVideoEntity = new SVGAVideoEntity((MovieEntity) decode, new File(cacheKey), this$0.mFrameWidth, this$0.mFrameHeight);
                                logUtils2.info(TAG, "SVGAVideoEntity prepare start");
                                sVGAVideoEntity.prepare$lib_svga_release(new Function0<Unit>() { // from class: com.opensource.svgaplayer.SVGAParser$decodeFromSVGAFileCacheKey$1$1$1$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public /* bridge */ /* synthetic */ Unit invoke() {
                                        invoke2();
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2() {
                                        LogUtils.INSTANCE.info("SVGAParser", "SVGAVideoEntity prepare success");
                                        SVGAParser.this.invokeCompleteCallback(sVGAVideoEntity, parseCompletion, str);
                                    }
                                }, playCallback);
                                unit2 = Unit.INSTANCE;
                            } else {
                                unit2 = null;
                            }
                            if (unit2 == null) {
                                this$0.invokeErrorCallback(new Exception("inflate(bytes) cause exception"), parseCompletion, str);
                            }
                        }
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        this$0.invokeErrorCallback(new Exception("readAsBytes(inputStream) cause exception"), parseCompletion, str);
                    }
                    Unit unit3 = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    logUtils2.info(TAG, "================ decode " + str + " from svga cachel file to entity end ================");
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(fileInputStream, th);
                        throw th2;
                    }
                }
            } catch (Exception e10) {
                this$0.invokeErrorCallback(e10, parseCompletion, str);
                logUtils = LogUtils.INSTANCE;
                sb = new StringBuilder();
                sb.append("================ decode ");
                sb.append(str);
                sb.append(" from svga cachel file to entity end ================");
                logUtils.info(TAG, sb.toString());
            } catch (OutOfMemoryError e11) {
                String message = e11.getMessage();
                if (message == null) {
                    message = "OutOfMemoryError";
                }
                this$0.invokeErrorCallback(new Exception(message), parseCompletion, str);
                logUtils = LogUtils.INSTANCE;
                sb = new StringBuilder();
                sb.append("================ decode ");
                sb.append(str);
                sb.append(" from svga cachel file to entity end ================");
                logUtils.info(TAG, sb.toString());
            }
        } catch (Throwable th3) {
            LogUtils.INSTANCE.info(TAG, "================ decode " + str + " from svga cachel file to entity end ================");
            throw th3;
        }
    }

    public static /* synthetic */ Function0 decodeFromURL$default(SVGAParser sVGAParser, URL url, ParseCompletion parseCompletion, PlayCallback playCallback, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            playCallback = null;
        }
        return sVGAParser.decodeFromURL(url, parseCompletion, playCallback);
    }

    public static final void decodeFromURL$lambda$2(SVGAParser this$0, String cacheKey, ParseCompletion parseCompletion, String urlPath, PlayCallback playCallback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cacheKey, "$cacheKey");
        Intrinsics.checkNotNullParameter(urlPath, "$urlPath");
        if (SVGACache.INSTANCE.isDefaultCache()) {
            this$0.decodeFromCacheKey(cacheKey, parseCompletion, urlPath);
        } else {
            this$0.decodeFromSVGAFileCacheKey(cacheKey, parseCompletion, playCallback, urlPath);
        }
    }

    private final void ensureUnzipSafety(File outputFile, String dstDirPath) {
        String canonicalPath = new File(dstDirPath).getCanonicalPath();
        String canonicalPath2 = outputFile.getCanonicalPath();
        Intrinsics.checkNotNull(canonicalPath2);
        Intrinsics.checkNotNull(canonicalPath);
        if (StringsKt.startsWith$default(canonicalPath2, canonicalPath, false, 2, (Object) null)) {
            return;
        }
        throw new IOException("Found Zip Path Traversal Vulnerability with " + canonicalPath);
    }

    private final byte[] inflate(byte[] byteArray) {
        Inflater inflater = new Inflater();
        inflater.setInput(byteArray, 0, byteArray.length);
        byte[] bArr = new byte[2048];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int inflate = inflater.inflate(bArr, 0, 2048);
                if (inflate <= 0) {
                    inflater.end();
                    byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    return byteArray2;
                }
                byteArrayOutputStream.write(bArr, 0, inflate);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(byteArrayOutputStream, th);
                    throw th2;
                }
            }
        }
    }

    public final void invokeCompleteCallback(final SVGAVideoEntity videoItem, final ParseCompletion callback, final String alias) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.opensource.svgaplayer.j
            @Override // java.lang.Runnable
            public final void run() {
                SVGAParser.invokeCompleteCallback$lambda$15(alias, callback, videoItem);
            }
        });
    }

    public static final void invokeCompleteCallback$lambda$15(String str, ParseCompletion parseCompletion, SVGAVideoEntity videoItem) {
        Intrinsics.checkNotNullParameter(videoItem, "$videoItem");
        LogUtils.INSTANCE.info(TAG, "================ " + str + " parser complete ================");
        if (parseCompletion != null) {
            parseCompletion.onComplete(videoItem);
        }
    }

    public final void invokeErrorCallback(Exception e10, final ParseCompletion callback, String alias) {
        e10.printStackTrace();
        LogUtils logUtils = LogUtils.INSTANCE;
        logUtils.error(TAG, "================ " + alias + " parser error ================");
        StringBuilder sb = new StringBuilder();
        sb.append(alias);
        sb.append(" parse error");
        logUtils.error(TAG, sb.toString(), e10);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.opensource.svgaplayer.f
            @Override // java.lang.Runnable
            public final void run() {
                SVGAParser.invokeErrorCallback$lambda$16(SVGAParser.ParseCompletion.this);
            }
        });
    }

    public static final void invokeErrorCallback$lambda$16(ParseCompletion parseCompletion) {
        if (parseCompletion != null) {
            parseCompletion.onError();
        }
    }

    private final boolean isZipFile(byte[] bytes) {
        if (bytes.length <= 4 || bytes[0] != 80 || bytes[1] != 75 || bytes[2] != 3 || bytes[3] != 4) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void parse$default(SVGAParser sVGAParser, InputStream inputStream, String str, ParseCompletion parseCompletion, boolean z10, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        sVGAParser.parse(inputStream, str, parseCompletion, z10);
    }

    private final byte[] readAsBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = inputStream.read(bArr, 0, 2048);
                if (read <= 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream, null);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(byteArrayOutputStream, th);
                throw th2;
            }
        }
    }

    public static final Thread threadPoolExecutor$lambda$31(Runnable runnable) {
        return new Thread(runnable, "SVGAParser-Thread-" + threadNum.getAndIncrement());
    }

    private final void unzip(InputStream inputStream, String cacheKey) {
        LogUtils.INSTANCE.info(TAG, "================ unzip prepare ================");
        File buildCacheDir = SVGACache.INSTANCE.buildCacheDir(cacheKey);
        buildCacheDir.mkdirs();
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(zipInputStream, null);
                            CloseableKt.closeFinally(bufferedInputStream, null);
                            return;
                        }
                        Intrinsics.checkNotNull(nextEntry);
                        String name = nextEntry.getName();
                        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                        if (!StringsKt.contains$default((CharSequence) name, (CharSequence) "../", false, 2, (Object) null)) {
                            String name2 = nextEntry.getName();
                            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                            if (!StringsKt.contains$default((CharSequence) name2, (CharSequence) "/", false, 2, (Object) null)) {
                                File file = new File(buildCacheDir, nextEntry.getName());
                                String absolutePath = buildCacheDir.getAbsolutePath();
                                Intrinsics.checkNotNullExpressionValue(absolutePath, "getAbsolutePath(...)");
                                ensureUnzipSafety(file, absolutePath);
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
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
                                    LogUtils.INSTANCE.error(TAG, "================ unzip complete ================");
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
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    CloseableKt.closeFinally(bufferedInputStream, th5);
                    throw th6;
                }
            }
        } catch (Exception e10) {
            LogUtils logUtils = LogUtils.INSTANCE;
            logUtils.error(TAG, "================ unzip error ================");
            logUtils.error(TAG, "error", e10);
            SVGACache sVGACache = SVGACache.INSTANCE;
            String absolutePath2 = buildCacheDir.getAbsolutePath();
            Intrinsics.checkNotNullExpressionValue(absolutePath2, "getAbsolutePath(...)");
            sVGACache.clearDir$lib_svga_release(absolutePath2);
            buildCacheDir.delete();
            throw e10;
        }
    }

    public final void decodeFromAssets(@NotNull String name, @Nullable ParseCompletion callback) {
        Intrinsics.checkNotNullParameter(name, "name");
        decodeFromAssets(name, callback, null);
    }

    public final void decodeFromInputStream(@NotNull final InputStream inputStream, @NotNull final String cacheKey, @Nullable final ParseCompletion callback, final boolean closeInputStream, @Nullable final PlayCallback playCallback, @Nullable final String alias) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        if (this.mContext == null) {
            LogUtils.INSTANCE.error(TAG, "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return;
        }
        LogUtils.INSTANCE.info(TAG, "================ decode " + alias + " from input stream ================");
        threadPoolExecutor.execute(new Runnable() { // from class: com.opensource.svgaplayer.i
            @Override // java.lang.Runnable
            public final void run() {
                SVGAParser.decodeFromInputStream$lambda$14(SVGAParser.this, inputStream, callback, alias, closeInputStream, cacheKey, playCallback);
            }
        });
    }

    public final void decodeFromSVGAFileCacheKey(@NotNull final String cacheKey, @Nullable final ParseCompletion callback, @Nullable final PlayCallback playCallback, @Nullable final String alias) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        threadPoolExecutor.execute(new Runnable() { // from class: com.opensource.svgaplayer.e
            @Override // java.lang.Runnable
            public final void run() {
                SVGAParser.decodeFromSVGAFileCacheKey$lambda$6(alias, cacheKey, this, callback, playCallback);
            }
        });
    }

    @Nullable
    public final Function0<Unit> decodeFromURL(@NotNull URL url, @Nullable ParseCompletion callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        return decodeFromURL(url, callback, null);
    }

    @NotNull
    public final FileDownloader getFileDownloader() {
        return this.fileDownloader;
    }

    public final void init(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        SVGACache.INSTANCE.onCreate(applicationContext);
    }

    @Deprecated(message = "This method has been deprecated from 2.4.0.", replaceWith = @ReplaceWith(expression = "this.decodeFromAssets(assetsName, callback)", imports = {}))
    public final void parse(@NotNull String assetsName, @Nullable ParseCompletion callback) {
        Intrinsics.checkNotNullParameter(assetsName, "assetsName");
        decodeFromAssets(assetsName, callback, null);
    }

    public final void setFileDownloader(@NotNull FileDownloader fileDownloader) {
        Intrinsics.checkNotNullParameter(fileDownloader, "<set-?>");
        this.fileDownloader = fileDownloader;
    }

    public final void setFrameSize(int frameWidth, int frameHeight) {
        this.mFrameWidth = frameWidth;
        this.mFrameHeight = frameHeight;
    }

    public final void decodeFromAssets(@NotNull final String name, @Nullable final ParseCompletion callback, @Nullable final PlayCallback playCallback) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.mContext == null) {
            LogUtils.INSTANCE.error(TAG, "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return;
        }
        LogUtils.INSTANCE.info(TAG, "================ decode " + name + " from assets ================");
        threadPoolExecutor.execute(new Runnable() { // from class: com.opensource.svgaplayer.k
            @Override // java.lang.Runnable
            public final void run() {
                SVGAParser.decodeFromAssets$lambda$1(SVGAParser.this, name, callback, playCallback);
            }
        });
    }

    @Nullable
    public final Function0<Unit> decodeFromURL(@NotNull final URL url, @Nullable final ParseCompletion callback, @Nullable final PlayCallback playCallback) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.mContext == null) {
            LogUtils.INSTANCE.error(TAG, "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return null;
        }
        final String url2 = url.toString();
        Intrinsics.checkNotNullExpressionValue(url2, "toString(...)");
        LogUtils logUtils = LogUtils.INSTANCE;
        logUtils.info(TAG, "================ decode from url: " + url2 + " ================");
        SVGACache sVGACache = SVGACache.INSTANCE;
        final String buildCacheKey = sVGACache.buildCacheKey(url);
        if (sVGACache.isCached(buildCacheKey)) {
            logUtils.info(TAG, "this url cached");
            threadPoolExecutor.execute(new Runnable() { // from class: com.opensource.svgaplayer.g
                @Override // java.lang.Runnable
                public final void run() {
                    SVGAParser.decodeFromURL$lambda$2(SVGAParser.this, buildCacheKey, callback, url2, playCallback);
                }
            });
            return null;
        }
        logUtils.info(TAG, "no cached, prepare to download");
        return this.fileDownloader.resume(url, new Function1<InputStream, Unit>() { // from class: com.opensource.svgaplayer.SVGAParser$decodeFromURL$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InputStream inputStream) {
                invoke2(inputStream);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InputStream it) {
                Intrinsics.checkNotNullParameter(it, "it");
                SVGAParser.this.decodeFromInputStream(it, buildCacheKey, callback, false, playCallback, url2);
            }
        }, new Function1<Exception, Unit>() { // from class: com.opensource.svgaplayer.SVGAParser$decodeFromURL$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                invoke2(exc);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Exception it) {
                Intrinsics.checkNotNullParameter(it, "it");
                LogUtils.INSTANCE.error("SVGAParser", "================ svga file: " + url + " download fail ================");
                this.invokeErrorCallback(it, callback, url2);
            }
        });
    }

    @Deprecated(message = "This method has been deprecated from 2.4.0.", replaceWith = @ReplaceWith(expression = "this.decodeFromURL(url, callback)", imports = {}))
    public final void parse(@NotNull URL url, @Nullable ParseCompletion callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        decodeFromURL(url, callback, null);
    }

    @Deprecated(message = "This method has been deprecated from 2.4.0.", replaceWith = @ReplaceWith(expression = "this.decodeFromInputStream(inputStream, cacheKey, callback, closeInputStream)", imports = {}))
    public final void parse(@NotNull InputStream inputStream, @NotNull String cacheKey, @Nullable ParseCompletion callback, boolean closeInputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        decodeFromInputStream$default(this, inputStream, cacheKey, callback, closeInputStream, null, null, 32, null);
    }
}
