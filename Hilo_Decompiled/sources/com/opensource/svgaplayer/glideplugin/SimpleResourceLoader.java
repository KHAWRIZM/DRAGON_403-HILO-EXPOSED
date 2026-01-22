package com.opensource.svgaplayer.glideplugin;

import android.content.res.Resources;
import android.net.Uri;
import com.bumptech.glide.f;
import com.bumptech.glide.load.data.d;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import m4.a;
import m4.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t4.n;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SimpleResourceLoader;", "Lt4/n;", "", "Ljava/io/InputStream;", "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", DeviceRequestsHelper.DEVICE_INFO_MODEL, "Landroid/net/Uri;", "getResourceUri", "(Landroid/content/res/Resources;I)Landroid/net/Uri;", "", "handles", "(I)Z", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Lm4/i;", "options", "Lt4/n$a;", "buildLoadData", "(IIILm4/i;)Lt4/n$a;", "Landroid/content/res/Resources;", "SimpleFetcher", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
final class SimpleResourceLoader implements n {

    @NotNull
    private final Resources resources;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ'\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00132\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/opensource/svgaplayer/glideplugin/SimpleResourceLoader$SimpleFetcher;", "Lcom/bumptech/glide/load/data/d;", "Ljava/io/InputStream;", "Landroid/content/res/Resources;", "resources", "", DeviceRequestsHelper.DEVICE_INFO_MODEL, "<init>", "(Landroid/content/res/Resources;I)V", "Ljava/lang/Class;", "getDataClass", "()Ljava/lang/Class;", "", "cleanup", "()V", "Lm4/a;", "getDataSource", "()Lm4/a;", "cancel", "Lcom/bumptech/glide/f;", "priority", "Lcom/bumptech/glide/load/data/d$a;", "callback", "loadData", "(Lcom/bumptech/glide/f;Lcom/bumptech/glide/load/data/d$a;)V", "Landroid/content/res/Resources;", "I", "glideplugin_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class SimpleFetcher implements d {
        private final int model;

        @NotNull
        private final Resources resources;

        public SimpleFetcher(@NotNull Resources resources, int i10) {
            Intrinsics.checkNotNullParameter(resources, "resources");
            this.resources = resources;
            this.model = i10;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cleanup() {
        }

        @Override // com.bumptech.glide.load.data.d
        @NotNull
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.data.d
        @NotNull
        public a getDataSource() {
            return a.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void loadData(@NotNull f priority, @NotNull d.a callback) {
            Intrinsics.checkNotNullParameter(priority, "priority");
            Intrinsics.checkNotNullParameter(callback, "callback");
            try {
                callback.onDataReady(this.resources.openRawResource(this.model));
            } catch (Exception e10) {
                callback.onLoadFailed(e10);
            }
        }
    }

    public SimpleResourceLoader(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.resources = resources;
    }

    private final Uri getResourceUri(Resources resources, int model) {
        try {
            return Uri.parse("android.resource://" + ((Object) resources.getResourcePackageName(model)) + '/' + ((Object) resources.getResourceTypeName(model)) + '/' + ((Object) resources.getResourceEntryName(model)));
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    @Override // t4.n
    public /* bridge */ /* synthetic */ n.a buildLoadData(Object obj, int i10, int i11, i iVar) {
        return buildLoadData(((Number) obj).intValue(), i10, i11, iVar);
    }

    @Override // t4.n
    public /* bridge */ /* synthetic */ boolean handles(Object obj) {
        return handles(((Number) obj).intValue());
    }

    @Nullable
    public n.a buildLoadData(int model, int width, int height, @NotNull i options) {
        Intrinsics.checkNotNullParameter(options, "options");
        Uri resourceUri = getResourceUri(this.resources, model);
        if (resourceUri == null) {
            return null;
        }
        return new n.a(new e5.d(resourceUri), new SimpleFetcher(this.resources, model));
    }

    public boolean handles(int model) {
        try {
            String resourceTypeName = this.resources.getResourceTypeName(model);
            Intrinsics.checkNotNullExpressionValue(resourceTypeName, "resources.getResourceTypeName(model)");
            return StringsKt.contains$default((CharSequence) resourceTypeName, (CharSequence) "raw", false, 2, (Object) null);
        } catch (Exception unused) {
            return false;
        }
    }
}
