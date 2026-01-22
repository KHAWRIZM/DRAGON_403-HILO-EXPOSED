package com.oudi.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.oudi.utils.ICleared;
import com.oudi.utils.log.ILog;
import com.oudi.widget.IconTextView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002:\u0002@AB\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001d\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB%\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fB-\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\u000eJ\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\u000bH\u0014J\u0010\u0010,\u001a\u00020)2\u0006\u0010-\u001a\u00020.H\u0014J\u0010\u0010/\u001a\u00020)2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u00100\u001a\u00020)2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u000e\u00101\u001a\u00020)2\u0006\u0010\u0012\u001a\u00020\u0013J\b\u00102\u001a\u0004\u0018\u00010\u0013J\b\u00103\u001a\u0004\u0018\u00010\u0011J7\u00104\u001a\u00020)2*\u00105\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u000b0706\"\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u000b07¢\u0006\u0002\u00109J\u000e\u0010:\u001a\u00020)2\u0006\u0010;\u001a\u00020\u000bJ\u000e\u0010<\u001a\u00020)2\u0006\u0010\u0014\u001a\u00020\u000bJ\b\u0010=\u001a\u00020)H\u0002J\u0012\u0010>\u001a\u0004\u0018\u00010#2\u0006\u0010?\u001a\u000208H\u0002R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001b\u001a\u0004\b\u001e\u0010\u001fR+\u0010!\u001a\u0012\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020#`$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b%\u0010&¨\u0006B"}, d2 = {"Lcom/oudi/widget/IconTextView;", "Landroid/view/View;", "Lcom/oudi/utils/log/ILog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "dividerWidth", "content", "", "adapter", "Lcom/oudi/widget/IconTextView$Adapter;", "gravity", "maxIconHeight", "paintFlagsDrawFilter", "Landroid/graphics/PaintFlagsDrawFilter;", "getPaintFlagsDrawFilter", "()Landroid/graphics/PaintFlagsDrawFilter;", "paintFlagsDrawFilter$delegate", "Lkotlin/Lazy;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "paint$delegate", "bitmaps", "Ljava/util/ArrayList;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/ArrayList;", "getBitmaps", "()Ljava/util/ArrayList;", "bitmaps$delegate", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "onDraw", "canvas", "Landroid/graphics/Canvas;", "setContent", "setAdapter", "setAdapterIfNotSet", "getAdapter", "getContent", "setResAdapter", "pairs", "", "Lkotlin/Pair;", "", "([Lkotlin/Pair;)V", "setDividerWidth", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "setGravity", "checkReLayout", "getBitmap", "char", "Adapter", "LocalResAdapter", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nIconTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 IconTextView.kt\ncom/oudi/widget/IconTextView\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,271:1\n1863#2,2:272\n1863#2,2:274\n13458#3,2:276\n*S KotlinDebug\n*F\n+ 1 IconTextView.kt\ncom/oudi/widget/IconTextView\n*L\n65#1:272,2\n86#1:274,2\n117#1:276,2\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public class IconTextView extends View implements ILog {

    @Nullable
    private Adapter adapter;

    /* renamed from: bitmaps$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy bitmaps;

    @Nullable
    private String content;
    private int dividerWidth;
    private int gravity;
    private int maxIconHeight;

    /* renamed from: paint$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy paint;

    /* renamed from: paintFlagsDrawFilter$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy paintFlagsDrawFilter;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/oudi/widget/IconTextView$Adapter;", "", "getBitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "item", "", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public interface Adapter {
        @Nullable
        Bitmap getBitmap(@NotNull Context context, char item);
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u0004\u0010\nB%\b\u0016\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\u0004\u0010\rJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\bH\u0016J\u0017\u0010\"\u001a\u0004\u0018\u00010\t2\u0006\u0010!\u001a\u00020\bH\u0014¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020%H\u0016R&\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014RC\u0010\u0015\u001a*\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\u0016j\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017`\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"}, d2 = {"Lcom/oudi/widget/IconTextView$LocalResAdapter;", "Lcom/oudi/widget/IconTextView$Adapter;", "Lcom/oudi/utils/ICleared;", "Lcom/oudi/utils/log/ILog;", "<init>", "()V", "list", "", "", "", "(Ljava/util/Map;)V", "enableCache", "", "(Ljava/util/Map;Z)V", "getList", "()Ljava/util/Map;", "setList", "getEnableCache", "()Z", "setEnableCache", "(Z)V", "bitmapCache", "Ljava/util/HashMap;", "Ljava/lang/ref/SoftReference;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", "getBitmapCache", "()Ljava/util/HashMap;", "bitmapCache$delegate", "Lkotlin/Lazy;", "getBitmap", "context", "Landroid/content/Context;", "item", "getDrawableResId", "(C)Ljava/lang/Integer;", "onCleared", "", "lib_widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static class LocalResAdapter implements Adapter, ICleared, ILog {

        /* renamed from: bitmapCache$delegate, reason: from kotlin metadata */
        @NotNull
        private final Lazy bitmapCache;
        private boolean enableCache;

        @NotNull
        private Map<Character, Integer> list;

        public LocalResAdapter() {
            this(new HashMap());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final HashMap bitmapCache_delegate$lambda$0() {
            return new HashMap();
        }

        private final HashMap<Character, SoftReference<Bitmap>> getBitmapCache() {
            return (HashMap) this.bitmapCache.getValue();
        }

        @Override // com.oudi.widget.IconTextView.Adapter
        @Nullable
        public Bitmap getBitmap(@NotNull Context context, char item) {
            Bitmap bitmap;
            Intrinsics.checkNotNullParameter(context, "context");
            if (this.enableCache) {
                SoftReference<Bitmap> softReference = getBitmapCache().get(Character.valueOf(item));
                if (softReference != null) {
                    bitmap = softReference.get();
                } else {
                    bitmap = null;
                }
                if (bitmap != null && !bitmap.isRecycled()) {
                    return bitmap;
                }
            }
            Integer drawableResId = getDrawableResId(item);
            if (drawableResId != null) {
                try {
                    Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), drawableResId.intValue());
                    if (this.enableCache) {
                        getBitmapCache().put(Character.valueOf(item), new SoftReference<>(decodeResource));
                    }
                    return decodeResource;
                } catch (Exception e10) {
                    e10.printStackTrace();
                    ILog.DefaultImpls.logE$default(this, "LocalResAdapter-getBitmap()", e10, null, true, 4, null);
                }
            }
            return null;
        }

        @Nullable
        public Integer getDrawableResId(char item) {
            return this.list.get(Character.valueOf(item));
        }

        public final boolean getEnableCache() {
            return this.enableCache;
        }

        @NotNull
        public final Map<Character, Integer> getList() {
            return this.list;
        }

        @Override // com.oudi.utils.log.ILog
        @NotNull
        public String getLogTag() {
            return ILog.DefaultImpls.getLogTag(this);
        }

        @Override // com.oudi.utils.log.ILog
        public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
            ILog.DefaultImpls.logD(this, str, str2, z10);
        }

        @Override // com.oudi.utils.log.ILog
        public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
            ILog.DefaultImpls.logE(this, str, str2, z10);
        }

        @Override // com.oudi.utils.log.ILog
        public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
            ILog.DefaultImpls.logI(this, str, str2, z10);
        }

        @Override // com.oudi.utils.log.ILog
        public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
            ILog.DefaultImpls.logV(this, str, str2, z10);
        }

        @Override // com.oudi.utils.log.ILog
        public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
            ILog.DefaultImpls.logW(this, str, str2, z10);
        }

        @Override // com.oudi.utils.ICleared
        public void onCleared() {
            ICleared.DefaultImpls.onCleared(this);
            getBitmapCache().clear();
        }

        public final void setEnableCache(boolean z10) {
            this.enableCache = z10;
        }

        public final void setList(@NotNull Map<Character, Integer> map) {
            Intrinsics.checkNotNullParameter(map, "<set-?>");
            this.list = map;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public LocalResAdapter(@NotNull Map<Character, Integer> list) {
            this(list, true);
            Intrinsics.checkNotNullParameter(list, "list");
        }

        @Override // com.oudi.utils.log.ILog
        public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
            ILog.DefaultImpls.logE(this, str, th, str2, z10);
        }

        public LocalResAdapter(@NotNull Map<Character, Integer> list, boolean z10) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.list = new HashMap();
            this.enableCache = true;
            this.bitmapCache = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.o
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    HashMap bitmapCache_delegate$lambda$0;
                    bitmapCache_delegate$lambda$0 = IconTextView.LocalResAdapter.bitmapCache_delegate$lambda$0();
                    return bitmapCache_delegate$lambda$0;
                }
            });
            this.list = list;
            this.enableCache = z10;
        }

        @Override // com.oudi.utils.log.ILog
        public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
            ILog.DefaultImpls.logE(this, th, str, z10);
        }
    }

    public IconTextView(@Nullable Context context) {
        super(context);
        this.gravity = 80;
        this.paintFlagsDrawFilter = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PaintFlagsDrawFilter paintFlagsDrawFilter_delegate$lambda$0;
                paintFlagsDrawFilter_delegate$lambda$0 = IconTextView.paintFlagsDrawFilter_delegate$lambda$0();
                return paintFlagsDrawFilter_delegate$lambda$0;
            }
        });
        this.paint = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Paint paint_delegate$lambda$2;
                paint_delegate$lambda$2 = IconTextView.paint_delegate$lambda$2();
                return paint_delegate$lambda$2;
            }
        });
        this.bitmaps = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ArrayList bitmaps_delegate$lambda$3;
                bitmaps_delegate$lambda$3 = IconTextView.bitmaps_delegate$lambda$3();
                return bitmaps_delegate$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList bitmaps_delegate$lambda$3() {
        return new ArrayList();
    }

    private final void checkReLayout() {
        String str = this.content;
        if (str == null || str.length() == 0) {
            requestLayout();
        }
    }

    private final Bitmap getBitmap(char r42) {
        Adapter adapter = getAdapter();
        if (adapter != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            return adapter.getBitmap(context, r42);
        }
        return null;
    }

    private final ArrayList<Bitmap> getBitmaps() {
        return (ArrayList) this.bitmaps.getValue();
    }

    private final Paint getPaint() {
        return (Paint) this.paint.getValue();
    }

    private final PaintFlagsDrawFilter getPaintFlagsDrawFilter() {
        return (PaintFlagsDrawFilter) this.paintFlagsDrawFilter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaintFlagsDrawFilter paintFlagsDrawFilter_delegate$lambda$0() {
        return new PaintFlagsDrawFilter(0, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Paint paint_delegate$lambda$2() {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        return paint;
    }

    @Nullable
    public final Adapter getAdapter() {
        return this.adapter;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    @Override // com.oudi.utils.log.ILog
    @NotNull
    public String getLogTag() {
        return ILog.DefaultImpls.getLogTag(this);
    }

    @Override // com.oudi.utils.log.ILog
    public void logD(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logD(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logI(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logI(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logV(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logV(this, str, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logW(@NotNull String str, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logW(this, str, str2, z10);
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        int i10;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.setDrawFilter(getPaintFlagsDrawFilter());
        float paddingStart = getPaddingStart();
        for (Bitmap bitmap : getBitmaps()) {
            if (bitmap.isRecycled()) {
                ILog.DefaultImpls.logE$default((ILog) this, "onDraw() isRecycled:true", (String) null, false, 6, (Object) null);
                return;
            }
            int height = bitmap.getHeight();
            float paddingTop = getPaddingTop();
            int i11 = this.maxIconHeight;
            if (height < i11) {
                int i12 = this.gravity;
                if (i12 != 16 && i12 != 17) {
                    if (i12 == 80 || i12 == 8388613) {
                        i10 = i11 - height;
                    }
                } else {
                    i10 = (i11 - height) / 2;
                }
                paddingTop += i10;
            }
            canvas.drawBitmap(bitmap, paddingStart, paddingTop, getPaint());
            paddingStart += bitmap.getWidth() + this.dividerWidth;
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i10 = 0;
        int i11 = 0;
        for (Bitmap bitmap : getBitmaps()) {
            i11 += bitmap.getWidth();
            if (bitmap.getHeight() > i10) {
                i10 = bitmap.getHeight();
            }
        }
        this.maxIconHeight = i10;
        int size = getBitmaps().size();
        if (size > 1) {
            i11 += (size - 1) * this.dividerWidth;
        }
        setMeasuredDimension(getPaddingEnd() + getPaddingStart() + i11, getPaddingBottom() + getPaddingTop() + i10);
    }

    public final void setAdapter(@Nullable Adapter adapter) {
        this.adapter = adapter;
    }

    public final void setAdapterIfNotSet(@NotNull Adapter adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        if (getAdapter() == null) {
            setAdapter(adapter);
        }
    }

    public final void setContent(@Nullable String content) {
        if (Intrinsics.areEqual(this.content, content)) {
            return;
        }
        this.content = content;
        getBitmaps().clear();
        if (content != null) {
            char[] charArray = content.toCharArray();
            Intrinsics.checkNotNullExpressionValue(charArray, "toCharArray(...)");
            if (charArray != null) {
                for (char c10 : charArray) {
                    Bitmap bitmap = getBitmap(c10);
                    if (bitmap == null) {
                        this.content = null;
                        getBitmaps().clear();
                        return;
                    }
                    getBitmaps().add(bitmap);
                }
            }
        }
        requestLayout();
    }

    public final void setDividerWidth(int width) {
        this.dividerWidth = width;
        checkReLayout();
    }

    public final void setGravity(int gravity) {
        this.gravity = gravity;
        invalidate();
    }

    public final void setResAdapter(@NotNull Pair<Character, Integer>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        setAdapter(new LocalResAdapter(MapsKt.toMap(pairs), true));
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull String str, @NotNull Throwable th, @NotNull String str2, boolean z10) {
        ILog.DefaultImpls.logE(this, str, th, str2, z10);
    }

    @Override // com.oudi.utils.log.ILog
    public void logE(@NotNull Throwable th, @NotNull String str, boolean z10) {
        ILog.DefaultImpls.logE(this, th, str, z10);
    }

    public IconTextView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gravity = 80;
        this.paintFlagsDrawFilter = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PaintFlagsDrawFilter paintFlagsDrawFilter_delegate$lambda$0;
                paintFlagsDrawFilter_delegate$lambda$0 = IconTextView.paintFlagsDrawFilter_delegate$lambda$0();
                return paintFlagsDrawFilter_delegate$lambda$0;
            }
        });
        this.paint = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Paint paint_delegate$lambda$2;
                paint_delegate$lambda$2 = IconTextView.paint_delegate$lambda$2();
                return paint_delegate$lambda$2;
            }
        });
        this.bitmaps = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ArrayList bitmaps_delegate$lambda$3;
                bitmaps_delegate$lambda$3 = IconTextView.bitmaps_delegate$lambda$3();
                return bitmaps_delegate$lambda$3;
            }
        });
    }

    public IconTextView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.gravity = 80;
        this.paintFlagsDrawFilter = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PaintFlagsDrawFilter paintFlagsDrawFilter_delegate$lambda$0;
                paintFlagsDrawFilter_delegate$lambda$0 = IconTextView.paintFlagsDrawFilter_delegate$lambda$0();
                return paintFlagsDrawFilter_delegate$lambda$0;
            }
        });
        this.paint = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Paint paint_delegate$lambda$2;
                paint_delegate$lambda$2 = IconTextView.paint_delegate$lambda$2();
                return paint_delegate$lambda$2;
            }
        });
        this.bitmaps = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ArrayList bitmaps_delegate$lambda$3;
                bitmaps_delegate$lambda$3 = IconTextView.bitmaps_delegate$lambda$3();
                return bitmaps_delegate$lambda$3;
            }
        });
    }

    public IconTextView(@Nullable Context context, @Nullable AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.gravity = 80;
        this.paintFlagsDrawFilter = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PaintFlagsDrawFilter paintFlagsDrawFilter_delegate$lambda$0;
                paintFlagsDrawFilter_delegate$lambda$0 = IconTextView.paintFlagsDrawFilter_delegate$lambda$0();
                return paintFlagsDrawFilter_delegate$lambda$0;
            }
        });
        this.paint = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Paint paint_delegate$lambda$2;
                paint_delegate$lambda$2 = IconTextView.paint_delegate$lambda$2();
                return paint_delegate$lambda$2;
            }
        });
        this.bitmaps = LazyKt.lazy(new Function0() { // from class: com.oudi.widget.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ArrayList bitmaps_delegate$lambda$3;
                bitmaps_delegate$lambda$3 = IconTextView.bitmaps_delegate$lambda$3();
                return bitmaps_delegate$lambda$3;
            }
        });
    }
}
