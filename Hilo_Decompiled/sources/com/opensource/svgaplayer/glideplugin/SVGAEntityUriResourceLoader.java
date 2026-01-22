package com.opensource.svgaplayer.glideplugin;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import com.bumptech.glide.f;
import com.bumptech.glide.load.data.d;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m4.a;
import m4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t4.n;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0018B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00112\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAEntityUriResourceLoader;", "Lt4/n;", "Landroid/net/Uri;", "Ljava/io/InputStream;", "Landroid/content/res/AssetFileDescriptor;", "actual", "<init>", "(Lt4/n;)V", DeviceRequestsHelper.DEVICE_INFO_MODEL, "", "handles", "(Landroid/net/Uri;)Z", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Lm4/i;", "options", "Lt4/n$a;", "buildLoadData", "(Landroid/net/Uri;IILm4/i;)Lt4/n$a;", "Lt4/n;", "", "schema", "Ljava/lang/String;", "Fetcher", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public final class SVGAEntityUriResourceLoader implements n {

    @NotNull
    private final n actual;

    @NotNull
    private final String schema;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\fJ'\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0014\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0014\u0010\u0010\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SVGAEntityUriResourceLoader$Fetcher;", "Lcom/bumptech/glide/load/data/d;", "Ljava/io/InputStream;", "Landroid/content/res/AssetFileDescriptor;", "actual", "<init>", "(Lcom/bumptech/glide/load/data/d;)V", "Ljava/lang/Class;", "getDataClass", "()Ljava/lang/Class;", "", "cleanup", "()V", "Lm4/a;", "getDataSource", "()Lm4/a;", "cancel", "Lcom/bumptech/glide/f;", "priority", "Lcom/bumptech/glide/load/data/d$a;", "callback", "loadData", "(Lcom/bumptech/glide/f;Lcom/bumptech/glide/load/data/d$a;)V", "Lcom/bumptech/glide/load/data/d;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Fetcher implements d {

        @NotNull
        private final d actual;

        @NotNull
        private final AtomicBoolean cancel;

        public Fetcher(@NotNull d actual) {
            Intrinsics.checkNotNullParameter(actual, "actual");
            this.actual = actual;
            this.cancel = new AtomicBoolean(false);
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
            this.cancel.set(true);
            this.actual.cancel();
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
            this.actual.cleanup();
        }

        @Override // com.bumptech.glide.load.data.d
        @NotNull
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.d
        @NotNull
        public a getDataSource() {
            a dataSource = this.actual.getDataSource();
            Intrinsics.checkNotNullExpressionValue(dataSource, "actual.dataSource");
            return dataSource;
        }

        @Override // com.bumptech.glide.load.data.d
        public void loadData(@NotNull f priority, @NotNull final d.a callback) {
            Intrinsics.checkNotNullParameter(priority, "priority");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (!this.cancel.get()) {
                this.actual.loadData(priority, new d.a() { // from class: com.opensource.svgaplayer.glideplugin.SVGAEntityUriResourceLoader$Fetcher$loadData$1
                    @Override // com.bumptech.glide.load.data.d.a
                    public void onLoadFailed(@NotNull Exception e10) {
                        Intrinsics.checkNotNullParameter(e10, "e");
                        d.a.this.onLoadFailed(e10);
                    }

                    @Override // com.bumptech.glide.load.data.d.a
                    public void onDataReady(@Nullable AssetFileDescriptor data) {
                        if (data == null) {
                            d.a.this.onLoadFailed(new NullPointerException("AssetFileDescriptor is null."));
                            return;
                        }
                        try {
                            d.a.this.onDataReady(data.createInputStream());
                        } catch (Exception e10) {
                            d.a.this.onLoadFailed(e10);
                        }
                    }
                });
            }
        }
    }

    public SVGAEntityUriResourceLoader(@NotNull n actual) {
        Intrinsics.checkNotNullParameter(actual, "actual");
        this.actual = actual;
        this.schema = "android.resource://";
    }

    @Override // t4.n
    @Nullable
    public n.a buildLoadData(@NotNull Uri model, int width, int height, @NotNull i options) {
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(options, "options");
        n.a buildLoadData = this.actual.buildLoadData(model, width, height, options);
        d dVar = buildLoadData == null ? null : buildLoadData.f١٨٠٨٦c;
        if (buildLoadData == null || dVar == null) {
            return null;
        }
        return new n.a(buildLoadData.f١٨٠٨٤a, new Fetcher(dVar));
    }

    @Override // t4.n
    public boolean handles(@NotNull Uri model) {
        Intrinsics.checkNotNullParameter(model, "model");
        return Intrinsics.areEqual(this.schema, model.getScheme()) && this.actual.handles(model);
    }
}
