package com.qiahao.base_common.utils.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.LruCache;
import androidx.core.content.a;
import androidx.core.graphics.drawable.DrawableKt;
import c5.g;
import c5.h;
import com.alibaba.sdk.android.push.notification.CustomNotificationBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.i;
import com.bumptech.glide.integration.webp.decoder.p;
import com.bumptech.glide.k;
import com.bumptech.glide.request.target.c;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.liulishuo.okdownload.DownloadTask;
import com.qiahao.base_common.utils.HiloUtils;
import d5.b;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import o4.j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v4.g0;
import v4.l;
import v4.m;
import v4.y;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aí\u0001\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001d*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0014\b\u0002\u0010\u0017\u001a\u000e\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r2\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001bH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0091\u0001\u0010 \u001a\u0006\u0012\u0002\b\u00030\u001d*\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001bH\u0007¢\u0006\u0004\b \u0010!\u001a\u0085\u0001\u0010%\u001a\u00020$*\u00020\"2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b%\u0010&\u001a\u0085\u0001\u0010'\u001a\u00020$*\u00020\"2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b'\u0010&\u001aa\u0010(\u001a\u00020$*\u00020\"2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b(\u0010)\u001aÑ\u0001\u0010*\u001a\u00020$*\u00020\"2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\r2\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001b¢\u0006\u0004\b*\u0010+\u001a\u008b\u0001\u0010,\u001a\u00020$*\u00020\"2\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\u001a\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001b¢\u0006\u0004\b,\u0010-\u001a;\u00102\u001a\b\u0012\u0004\u0012\u00020\u00160\u001d2\u0006\u0010.\u001a\u00020\u00002\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u00072\u0010\u00101\u001a\f\u0012\u0006\b\u0001\u0012\u000200\u0018\u00010/H\u0002¢\u0006\u0004\b2\u00103\u001a\u0017\u00104\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b4\u00105\u001a\u001b\u00107\u001a\u00020$*\u00020\"2\b\b\u0001\u00106\u001a\u00020\u0007¢\u0006\u0004\b7\u00108\u001a\u001b\u00107\u001a\u00020$*\u00020\"2\b\u00106\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b7\u00109\u001a\u0019\u00107\u001a\u00020\u0016*\u00020\u00162\u0006\u0010.\u001a\u00020\u0000¢\u0006\u0004\b7\u0010:\u001a\u001b\u0010;\u001a\u00020$*\u00020\"2\b\b\u0001\u00106\u001a\u00020\u0007¢\u0006\u0004\b;\u00108\u001a\u001b\u00107\u001a\u00020$*\u00020<2\b\b\u0001\u00106\u001a\u00020\u0007¢\u0006\u0004\b7\u0010=\u001a\u001b\u0010;\u001a\u00020$*\u00020<2\b\b\u0001\u00106\u001a\u00020\u0007¢\u0006\u0004\b;\u0010=\u001a\u0011\u0010>\u001a\u00020\u0001*\u00020\u0001¢\u0006\u0004\b>\u00105\u001a\u0015\u00107\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t¢\u0006\u0004\b7\u0010@\u001a\u0015\u0010;\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t¢\u0006\u0004\b;\u0010@\u001a#\u00107\u001a\u00020$*\u00020\"2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u0001H\u0007¢\u0006\u0004\b7\u0010B\u001a3\u0010G\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010C\u001a\u00020\u00012\b\b\u0002\u0010E\u001a\u00020D2\b\b\u0002\u0010F\u001a\u00020\u0007¢\u0006\u0004\bG\u0010H\" \u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00160I8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010K¨\u0006L"}, d2 = {"Landroid/content/Context;", "", "url", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Ljava/io/File;", "file", "", "resId", "Landroid/graphics/Bitmap;", "bitmap", "Landroid/widget/ImageView$ScaleType;", "scaleType", "", "circle", "corners", "skipMemory", "Lo4/j;", "diskCacheStrategy", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Lcom/bumptech/glide/k;", "Landroid/graphics/drawable/Drawable;", "transition", "noTransform", "defaultImage", "errorImage", "Lc5/g;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/bumptech/glide/i;", "buildStandardGlide", "(Landroid/content/Context;Ljava/lang/String;Landroid/net/Uri;Ljava/io/File;Ljava/lang/Integer;Landroid/graphics/Bitmap;Landroid/widget/ImageView$ScaleType;ZIZLo4/j;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bumptech/glide/k;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lc5/g;)Lcom/bumptech/glide/i;", "buildSimpleGlide", "(Landroid/content/Context;Ljava/lang/String;Landroid/net/Uri;Ljava/io/File;ZILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lc5/g;)Lcom/bumptech/glide/i;", "Landroid/widget/ImageView;", "wh", "", "loadAvatar", "(Landroid/widget/ImageView;Ljava/lang/String;Landroid/net/Uri;Ljava/io/File;Ljava/lang/Integer;Landroid/widget/ImageView$ScaleType;ZILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "loadSquare", "loadGift", "(Landroid/widget/ImageView;Ljava/lang/String;Ljava/lang/Integer;Landroid/widget/ImageView$ScaleType;ZILjava/lang/Integer;Ljava/lang/Integer;)V", "loadImage", "(Landroid/widget/ImageView;Ljava/lang/String;Landroid/net/Uri;Ljava/io/File;Ljava/lang/Integer;Landroid/graphics/Bitmap;Landroid/widget/ImageView$ScaleType;ZIZLo4/j;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Lc5/g;)V", "loadSimpleImage", "(Landroid/widget/ImageView;Ljava/lang/String;Landroid/net/Uri;Ljava/io/File;ZILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lc5/g;)V", "context", "", "Lv4/g;", "transformation", "transformDrawable", "(Landroid/content/Context;Ljava/lang/Integer;[Lv4/g;)Lcom/bumptech/glide/i;", "transformUrl", "(Ljava/lang/String;)Ljava/lang/String;", CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE, "toHorizontalMirror", "(Landroid/widget/ImageView;I)V", "(Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;)V", "(Landroid/graphics/drawable/Drawable;Landroid/content/Context;)Landroid/graphics/drawable/Drawable;", "toVerticalMirror", "Landroid/view/View;", "(Landroid/view/View;I)V", "splicingAvatarUrl", "bmp", "(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;", "imageUrl", "(Landroid/widget/ImageView;Landroid/content/Context;Ljava/lang/String;)V", "filePath", "Landroid/graphics/Bitmap$CompressFormat;", "format", "quality", "saveBitmapToFile", "(Landroid/graphics/Bitmap;Ljava/lang/String;Landroid/graphics/Bitmap$CompressFormat;I)Ljava/lang/String;", "Landroidx/collection/LruCache;", "mirroredDrawableCache", "Landroidx/collection/LruCache;", "base_common_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nImageKtx.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageKtx.kt\ncom/qiahao/base_common/utils/image/ImageKtxKt\n+ 2 BitmapDrawable.kt\nandroidx/core/graphics/drawable/BitmapDrawableKt\n*L\n1#1,761:1\n27#2:762\n*S KotlinDebug\n*F\n+ 1 ImageKtx.kt\ncom/qiahao/base_common/utils/image/ImageKtxKt\n*L\n599#1:762\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class ImageKtxKt {

    @NotNull
    private static final LruCache<Integer, Drawable> mirroredDrawableCache = new LruCache<>(50);

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.net.Uri] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.bumptech.glide.j] */
    @SuppressLint({"CheckResult"})
    @NotNull
    public static final i buildSimpleGlide(@NotNull Context context, @Nullable String str, @Nullable Uri uri, @Nullable File file, boolean z10, int i10, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable g gVar) {
        v4.g gVar2;
        v4.g[] gVarArr;
        Intrinsics.checkNotNullParameter(context, "<this>");
        if (z10) {
            gVar2 = new m();
        } else if (i10 > 0) {
            gVar2 = new g0(i10);
        } else {
            gVar2 = null;
        }
        if (gVar2 != null) {
            gVarArr = new v4.g[]{gVar2};
        } else {
            gVarArr = null;
        }
        ?? with = Glide.with(context);
        if (str != null && str.length() != 0) {
            uri = transformUrl(str);
        } else if (uri == 0) {
            if (file != null) {
                uri = file;
            } else {
                uri = 0;
            }
        }
        i p10 = with.p(uri);
        if (gVarArr != null) {
            p10.n0((m4.m[]) Arrays.copyOf(gVarArr, gVarArr.length));
        }
        if (gVar != null) {
            p10.F0(gVar);
        }
        if (num3 != null) {
            p10.S0(transformDrawable(context, num3, gVarArr));
        }
        if (num4 != null) {
            p10.w0(transformDrawable(context, num4, gVarArr));
        }
        if (num != null && num2 != null) {
            p10.W(num.intValue(), num2.intValue());
        }
        Intrinsics.checkNotNullExpressionValue(p10, "apply(...)");
        return p10;
    }

    public static /* synthetic */ i buildSimpleGlide$default(Context context, String str, Uri uri, File file, boolean z10, int i10, Integer num, Integer num2, Integer num3, Integer num4, g gVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        if ((i11 & 2) != 0) {
            uri = null;
        }
        if ((i11 & 4) != 0) {
            file = null;
        }
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        if ((i11 & 16) != 0) {
            i10 = 0;
        }
        if ((i11 & 32) != 0) {
            num = null;
        }
        if ((i11 & 64) != 0) {
            num2 = null;
        }
        if ((i11 & 128) != 0) {
            num3 = null;
        }
        if ((i11 & 256) != 0) {
            num4 = num3;
        }
        if ((i11 & 512) != 0) {
            gVar = null;
        }
        return buildSimpleGlide(context, str, uri, file, z10, i10, num, num2, num3, num4, gVar);
    }

    @SuppressLint({"CheckResult"})
    @NotNull
    public static final i buildStandardGlide(@NotNull Context context, @Nullable String str, @Nullable Uri uri, @Nullable File file, @Nullable Integer num, @Nullable Bitmap bitmap, @Nullable ImageView.ScaleType scaleType, boolean z10, int i10, boolean z11, @Nullable j jVar, @Nullable Integer num2, @Nullable Integer num3, @Nullable k kVar, @Nullable Boolean bool, @Nullable Integer num4, @Nullable Integer num5, @Nullable g gVar) {
        v4.g yVar;
        v4.g[] gVarArr;
        Intrinsics.checkNotNullParameter(context, "<this>");
        int i11 = scaleType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[scaleType.ordinal()];
        if (i11 == 1) {
            yVar = new y();
        } else if (i11 == 2) {
            yVar = new l();
        } else if (i11 != 3) {
            yVar = new v4.k();
        } else {
            yVar = new v4.k();
        }
        if (z10) {
            m mVar = new m();
            gVarArr = new v4.g[]{yVar, mVar};
            yVar = mVar;
        } else if (i10 > 0) {
            g0 g0Var = new g0(i10);
            gVarArr = new v4.g[]{yVar, g0Var};
            yVar = g0Var;
        } else {
            gVarArr = new v4.g[]{yVar};
        }
        i p10 = Glide.with(context).p((str == null || str.length() == 0) ? uri == null ? num == null ? file == null ? bitmap == null ? null : bitmap : file : num : uri : transformUrl(str));
        p10.n0((m4.m[]) Arrays.copyOf(gVarArr, gVarArr.length));
        p10.U(com.bumptech.glide.integration.webp.decoder.m.class, new p(yVar));
        p10.h0(z11);
        p10.F0(gVar);
        if (num4 != null) {
            p10.S0(transformDrawable(context, num4, gVarArr));
        }
        if (num5 != null) {
            p10.w0(transformDrawable(context, num5, gVarArr));
        }
        if (num2 != null && num3 != null) {
            p10.W(num2.intValue(), num3.intValue());
        }
        if (jVar != null) {
            p10.g(jVar);
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            p10.h();
        }
        if (kVar != null) {
            p10.T0(kVar);
        }
        Intrinsics.checkNotNullExpressionValue(p10, "apply(...)");
        return p10;
    }

    public static /* synthetic */ i buildStandardGlide$default(Context context, String str, Uri uri, File file, Integer num, Bitmap bitmap, ImageView.ScaleType scaleType, boolean z10, int i10, boolean z11, j jVar, Integer num2, Integer num3, k kVar, Boolean bool, Integer num4, Integer num5, g gVar, int i11, Object obj) {
        String str2 = (i11 & 1) != 0 ? null : str;
        Uri uri2 = (i11 & 2) != 0 ? null : uri;
        File file2 = (i11 & 4) != 0 ? null : file;
        Integer num6 = (i11 & 8) != 0 ? null : num;
        Bitmap bitmap2 = (i11 & 16) != 0 ? null : bitmap;
        ImageView.ScaleType scaleType2 = (i11 & 32) != 0 ? null : scaleType;
        boolean z12 = (i11 & 64) != 0 ? false : z10;
        int i12 = (i11 & 128) != 0 ? 0 : i10;
        boolean z13 = (i11 & 256) == 0 ? z11 : false;
        j jVar2 = (i11 & 512) != 0 ? null : jVar;
        Integer num7 = (i11 & 1024) != 0 ? null : num2;
        Integer num8 = (i11 & 2048) != 0 ? null : num3;
        k kVar2 = (i11 & 4096) != 0 ? null : kVar;
        Boolean bool2 = (i11 & 8192) != 0 ? null : bool;
        Integer num9 = (i11 & DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE) != 0 ? null : num4;
        return buildStandardGlide(context, str2, uri2, file2, num6, bitmap2, scaleType2, z12, i12, z13, jVar2, num7, num8, kVar2, bool2, num9, (i11 & 32768) != 0 ? num9 : num5, (i11 & 65536) != 0 ? null : gVar);
    }

    public static final void loadAvatar(@NotNull ImageView imageView, @Nullable String str, @Nullable Uri uri, @Nullable File file, @Nullable Integer num, @Nullable ImageView.ScaleType scaleType, boolean z10, int i10, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        loadImage$default(imageView, str, uri, file, num, null, scaleType, z10, i10, false, null, num2, num2, null, num3, num4, null, 37648, null);
    }

    public static /* synthetic */ void loadAvatar$default(ImageView imageView, String str, Uri uri, File file, Integer num, ImageView.ScaleType scaleType, boolean z10, int i10, Integer num2, Integer num3, Integer num4, int i11, Object obj) {
        String str2;
        Uri uri2;
        File file2;
        Integer num5;
        ImageView.ScaleType scaleType2;
        boolean z11;
        int i12;
        Integer num6;
        Integer num7;
        if ((i11 & 1) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i11 & 2) != 0) {
            uri2 = null;
        } else {
            uri2 = uri;
        }
        if ((i11 & 4) != 0) {
            file2 = null;
        } else {
            file2 = file;
        }
        if ((i11 & 8) != 0) {
            num5 = null;
        } else {
            num5 = num;
        }
        if ((i11 & 16) != 0) {
            scaleType2 = ImageView.ScaleType.CENTER_CROP;
        } else {
            scaleType2 = scaleType;
        }
        if ((i11 & 32) != 0) {
            z11 = true;
        } else {
            z11 = z10;
        }
        if ((i11 & 64) != 0) {
            i12 = 0;
        } else {
            i12 = i10;
        }
        if ((i11 & 128) != 0) {
            num6 = null;
        } else {
            num6 = num2;
        }
        if ((i11 & 512) != 0) {
            num7 = num3;
        } else {
            num7 = num4;
        }
        loadAvatar(imageView, str2, uri2, file2, num5, scaleType2, z11, i12, num6, num3, num7);
    }

    public static final void loadGift(@NotNull ImageView imageView, @Nullable String str, @Nullable Integer num, @Nullable ImageView.ScaleType scaleType, boolean z10, int i10, @Nullable Integer num2, @Nullable Integer num3) {
        ImageView.ScaleType scaleType2;
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        AppCompatActivity activity2 = HiloUtils.INSTANCE.getActivity2(imageView.getContext());
        if (activity2 != null && !activity2.isFinishing() && !activity2.isDestroyed()) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            if (scaleType == null) {
                scaleType2 = imageView.getScaleType();
            } else {
                scaleType2 = scaleType;
            }
            buildStandardGlide$default(context, str, null, null, num, null, scaleType2, z10, i10, false, null, Integer.valueOf(imageView.getWidth()), Integer.valueOf(imageView.getHeight()), null, null, num2, num3, null, 78614, null).D0(imageView);
        }
    }

    public static /* synthetic */ void loadGift$default(ImageView imageView, String str, Integer num, ImageView.ScaleType scaleType, boolean z10, int i10, Integer num2, Integer num3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        if ((i11 & 2) != 0) {
            num = null;
        }
        if ((i11 & 4) != 0) {
            scaleType = null;
        }
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        if ((i11 & 16) != 0) {
            i10 = 0;
        }
        if ((i11 & 32) != 0) {
            num2 = null;
        }
        if ((i11 & 64) != 0) {
            num3 = num2;
        }
        loadGift(imageView, str, num, scaleType, z10, i10, num2, num3);
    }

    public static final void loadImage(@NotNull ImageView imageView, @Nullable String str, @Nullable Uri uri, @Nullable File file, @Nullable Integer num, @Nullable Bitmap bitmap, @Nullable ImageView.ScaleType scaleType, boolean z10, int i10, boolean z11, @Nullable j jVar, @Nullable Integer num2, @Nullable Integer num3, @Nullable Boolean bool, @Nullable Integer num4, @Nullable Integer num5, @Nullable g gVar) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        AppCompatActivity activity2 = HiloUtils.INSTANCE.getActivity2(imageView.getContext());
        if (activity2 == null || !(activity2.isFinishing() || activity2.isDestroyed())) {
            try {
                Context context = imageView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                Intrinsics.checkNotNull(buildStandardGlide$default(context, str, uri, file, num, bitmap, scaleType == null ? imageView.getScaleType() : scaleType, z10, i10, z11, jVar, num2, num3, null, bool, num4, num5, gVar, 4096, null).D0(imageView));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void loadImage$default(ImageView imageView, String str, Uri uri, File file, Integer num, Bitmap bitmap, ImageView.ScaleType scaleType, boolean z10, int i10, boolean z11, j jVar, Integer num2, Integer num3, Boolean bool, Integer num4, Integer num5, g gVar, int i11, Object obj) {
        String str2 = (i11 & 1) != 0 ? null : str;
        Uri uri2 = (i11 & 2) != 0 ? null : uri;
        File file2 = (i11 & 4) != 0 ? null : file;
        Integer num6 = (i11 & 8) != 0 ? null : num;
        Bitmap bitmap2 = (i11 & 16) != 0 ? null : bitmap;
        ImageView.ScaleType scaleType2 = (i11 & 32) != 0 ? null : scaleType;
        boolean z12 = (i11 & 64) != 0 ? false : z10;
        int i12 = (i11 & 128) != 0 ? 0 : i10;
        boolean z13 = (i11 & 256) == 0 ? z11 : false;
        j jVar2 = (i11 & 512) != 0 ? null : jVar;
        Integer num7 = (i11 & 1024) != 0 ? null : num2;
        Integer num8 = (i11 & 2048) != 0 ? null : num3;
        Boolean bool2 = (i11 & 4096) != 0 ? null : bool;
        Integer num9 = (i11 & 8192) != 0 ? null : num4;
        loadImage(imageView, str2, uri2, file2, num6, bitmap2, scaleType2, z12, i12, z13, jVar2, num7, num8, bool2, num9, (i11 & DownloadTask.Builder.DEFAULT_FLUSH_BUFFER_SIZE) != 0 ? num9 : num5, (i11 & 32768) != 0 ? null : gVar);
    }

    public static final void loadSimpleImage(@NotNull ImageView imageView, @Nullable String str, @Nullable Uri uri, @Nullable File file, boolean z10, int i10, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable g gVar) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        AppCompatActivity activity2 = HiloUtils.INSTANCE.getActivity2(imageView.getContext());
        if (activity2 != null && !activity2.isFinishing() && !activity2.isDestroyed()) {
            Context context = imageView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            buildSimpleGlide(context, str, uri, file, z10, i10, num, num2, num3, num4, gVar).D0(imageView);
        }
    }

    public static /* synthetic */ void loadSimpleImage$default(ImageView imageView, String str, Uri uri, File file, boolean z10, int i10, Integer num, Integer num2, Integer num3, Integer num4, g gVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        if ((i11 & 2) != 0) {
            uri = null;
        }
        if ((i11 & 4) != 0) {
            file = null;
        }
        if ((i11 & 8) != 0) {
            z10 = false;
        }
        if ((i11 & 16) != 0) {
            i10 = 0;
        }
        if ((i11 & 32) != 0) {
            num = null;
        }
        if ((i11 & 64) != 0) {
            num2 = null;
        }
        if ((i11 & 128) != 0) {
            num3 = null;
        }
        if ((i11 & 256) != 0) {
            num4 = num3;
        }
        if ((i11 & 512) != 0) {
            gVar = null;
        }
        loadSimpleImage(imageView, str, uri, file, z10, i10, num, num2, num3, num4, gVar);
    }

    public static final void loadSquare(@NotNull ImageView imageView, @Nullable String str, @Nullable Uri uri, @Nullable File file, @Nullable Integer num, @Nullable ImageView.ScaleType scaleType, boolean z10, int i10, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        loadImage$default(imageView, str, uri, file, num, null, scaleType, z10, i10, false, null, num2, num2, null, num3, num4, null, 37648, null);
    }

    public static /* synthetic */ void loadSquare$default(ImageView imageView, String str, Uri uri, File file, Integer num, ImageView.ScaleType scaleType, boolean z10, int i10, Integer num2, Integer num3, Integer num4, int i11, Object obj) {
        String str2;
        Uri uri2;
        File file2;
        Integer num5;
        ImageView.ScaleType scaleType2;
        boolean z11;
        int i12;
        Integer num6;
        Integer num7;
        if ((i11 & 1) != 0) {
            str2 = null;
        } else {
            str2 = str;
        }
        if ((i11 & 2) != 0) {
            uri2 = null;
        } else {
            uri2 = uri;
        }
        if ((i11 & 4) != 0) {
            file2 = null;
        } else {
            file2 = file;
        }
        if ((i11 & 8) != 0) {
            num5 = null;
        } else {
            num5 = num;
        }
        if ((i11 & 16) != 0) {
            scaleType2 = ImageView.ScaleType.CENTER_CROP;
        } else {
            scaleType2 = scaleType;
        }
        if ((i11 & 32) != 0) {
            z11 = false;
        } else {
            z11 = z10;
        }
        if ((i11 & 64) != 0) {
            i12 = 0;
        } else {
            i12 = i10;
        }
        if ((i11 & 128) != 0) {
            num6 = null;
        } else {
            num6 = num2;
        }
        if ((i11 & 512) != 0) {
            num7 = num3;
        } else {
            num7 = num4;
        }
        loadSquare(imageView, str2, uri2, file2, num5, scaleType2, z11, i12, num6, num3, num7);
    }

    @Nullable
    public static final String saveBitmapToFile(@NotNull Bitmap bitmap, @NotNull String filePath, @NotNull Bitmap.CompressFormat format, int i10) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(format, "format");
        try {
            File file = new File(filePath);
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                bitmap.compress(format, i10, fileOutputStream);
                fileOutputStream.flush();
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, null);
                return file.getAbsolutePath();
            } finally {
            }
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static /* synthetic */ String saveBitmapToFile$default(Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            compressFormat = Bitmap.CompressFormat.PNG;
        }
        if ((i11 & 8) != 0) {
            i10 = 90;
        }
        return saveBitmapToFile(bitmap, str, compressFormat, i10);
    }

    @NotNull
    public static final String splicingAvatarUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        stringBuffer.append("?x-oss-process=image/resize,");
        stringBuffer.append("w_200,");
        stringBuffer.append("h_200,");
        stringBuffer.append("limit_1,");
        stringBuffer.append("m_fill/format,");
        stringBuffer.append("png");
        String stringBuffer2 = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(stringBuffer2, "toString(...)");
        return stringBuffer2;
    }

    public static final void toHorizontalMirror(@NotNull ImageView imageView, int i10) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (imageView.getContext() == null) {
            return;
        }
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            LruCache<Integer, Drawable> lruCache = mirroredDrawableCache;
            Drawable drawable = lruCache.get(Integer.valueOf(i10));
            if (drawable == null) {
                Drawable drawable2 = a.getDrawable(imageView.getContext(), i10);
                Bitmap bitmap$default = drawable2 != null ? DrawableKt.toBitmap$default(drawable2, 0, 0, null, 7, null) : null;
                if (bitmap$default != null) {
                    int width = bitmap$default.getWidth();
                    int height = bitmap$default.getHeight();
                    Matrix matrix = new Matrix();
                    matrix.postScale(-1.0f, 1.0f);
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap$default, 0, 0, width, height, matrix, true);
                    Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(imageView.getContext().getResources(), createBitmap);
                    lruCache.put(Integer.valueOf(i10), bitmapDrawable);
                    drawable = bitmapDrawable;
                }
            }
            imageView.setImageDrawable(drawable);
            return;
        }
        imageView.setImageDrawable(a.getDrawable(imageView.getContext(), i10));
    }

    public static final void toVerticalMirror(@NotNull ImageView imageView, int i10) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (imageView.getContext() == null) {
            return;
        }
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            Drawable drawable = a.getDrawable(imageView.getContext(), i10);
            Bitmap bitmap$default = drawable != null ? DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null) : null;
            if (bitmap$default != null) {
                int width = bitmap$default.getWidth();
                int height = bitmap$default.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale(1.0f, -1.0f);
                imageView.setImageBitmap(Bitmap.createBitmap(bitmap$default, 0, 0, width, height, matrix, true));
                return;
            }
            return;
        }
        imageView.setImageDrawable(a.getDrawable(imageView.getContext(), i10));
    }

    private static final i transformDrawable(Context context, Integer num, v4.g[] gVarArr) {
        i o10 = Glide.with(context).o(num);
        Intrinsics.checkNotNullExpressionValue(o10, "load(...)");
        if (gVarArr != null) {
            o10.a(new h().n0((m4.m[]) Arrays.copyOf(gVarArr, gVarArr.length)));
        }
        return o10;
    }

    private static final String transformUrl(String str) {
        if (StringsKt.startsWith$default(str, "/", false, 2, (Object) null)) {
            return str;
        }
        if (!StringsKt.startsWith$default(str, "http://", false, 2, (Object) null) && !StringsKt.startsWith$default(str, "https://", false, 2, (Object) null)) {
            return "http://" + str;
        }
        return str;
    }

    public static final void toVerticalMirror(@NotNull View view, int i10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getContext() == null) {
            return;
        }
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            Drawable drawable = a.getDrawable(view.getContext(), i10);
            Bitmap bitmap$default = drawable != null ? DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null) : null;
            if (bitmap$default != null) {
                int width = bitmap$default.getWidth();
                int height = bitmap$default.getHeight();
                Matrix matrix = new Matrix();
                matrix.postScale(1.0f, -1.0f);
                view.setBackground(new BitmapDrawable(view.getContext().getResources(), Bitmap.createBitmap(bitmap$default, 0, 0, width, height, matrix, true)));
                return;
            }
            return;
        }
        view.setBackground(a.getDrawable(view.getContext(), i10));
    }

    public static final void toHorizontalMirror(@NotNull ImageView imageView, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        if (imageView.getContext() == null || drawable == null) {
            return;
        }
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            Bitmap bitmap$default = DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null);
            int width = bitmap$default.getWidth();
            int height = bitmap$default.getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(-1.0f, 1.0f);
            imageView.setImageBitmap(Bitmap.createBitmap(bitmap$default, 0, 0, width, height, matrix, true));
            return;
        }
        imageView.setImageDrawable(drawable);
    }

    @NotNull
    public static final Bitmap toVerticalMirror(@NotNull Bitmap bmp) {
        Intrinsics.checkNotNullParameter(bmp, "bmp");
        int width = bmp.getWidth();
        int height = bmp.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, -1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bmp, 0, 0, width, height, matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return createBitmap;
    }

    @NotNull
    public static final Drawable toHorizontalMirror(@NotNull Drawable drawable, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(drawable, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!HiloUtils.INSTANCE.getRightToLeftDirection()) {
            return drawable;
        }
        Bitmap horizontalMirror = toHorizontalMirror(DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null));
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        return new BitmapDrawable(resources, horizontalMirror);
    }

    public static final void toHorizontalMirror(@NotNull View view, int i10) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (view.getContext() == null) {
            return;
        }
        if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
            LruCache<Integer, Drawable> lruCache = mirroredDrawableCache;
            Drawable drawable = lruCache.get(Integer.valueOf(i10));
            if (drawable == null) {
                Drawable drawable2 = a.getDrawable(view.getContext(), i10);
                Bitmap bitmap$default = drawable2 != null ? DrawableKt.toBitmap$default(drawable2, 0, 0, null, 7, null) : null;
                if (bitmap$default != null) {
                    int width = bitmap$default.getWidth();
                    int height = bitmap$default.getHeight();
                    Matrix matrix = new Matrix();
                    matrix.postScale(-1.0f, 1.0f);
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap$default, 0, 0, width, height, matrix, true);
                    Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(view.getContext().getResources(), createBitmap);
                    lruCache.put(Integer.valueOf(i10), bitmapDrawable);
                    drawable = bitmapDrawable;
                }
            }
            view.setBackground(drawable);
            return;
        }
        view.setBackground(a.getDrawable(view.getContext(), i10));
    }

    @NotNull
    public static final Bitmap toHorizontalMirror(@NotNull Bitmap bmp) {
        Intrinsics.checkNotNullParameter(bmp, "bmp");
        int width = bmp.getWidth();
        int height = bmp.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(-1.0f, 1.0f);
        Bitmap createBitmap = Bitmap.createBitmap(bmp, 0, 0, width, height, matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return createBitmap;
    }

    @SuppressLint({"CheckResult"})
    public static final void toHorizontalMirror(@NotNull final ImageView imageView, @NotNull Context context, @NotNull String imageUrl) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(imageUrl, "imageUrl");
        try {
            Intrinsics.checkNotNull(((i) Glide.with(context).b().K0(imageUrl).h0(false)).a(new h().g(j.f١٦٦٤٠e)).A0(new c() { // from class: com.qiahao.base_common.utils.image.ImageKtxKt$toHorizontalMirror$4
                @Override // com.bumptech.glide.request.target.j
                public void onLoadCleared(Drawable placeholder) {
                }

                @Override // com.bumptech.glide.request.target.c, com.bumptech.glide.request.target.j
                public void onLoadFailed(Drawable errorDrawable) {
                    super.onLoadFailed(errorDrawable);
                }

                @Override // com.bumptech.glide.request.target.j
                public void onResourceReady(Bitmap resource, b transition) {
                    Intrinsics.checkNotNullParameter(resource, "resource");
                    if (HiloUtils.INSTANCE.getRightToLeftDirection()) {
                        resource = ImageKtxKt.toHorizontalMirror(resource);
                    }
                    imageView.setImageBitmap(resource);
                }
            }));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
