package com.qiahao.nextvideo.view.planet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b \u0018\u0000 D2\u00020\u0001:\u0002CDB7\b\u0007\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0013\b\u0017\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\fJ\u0006\u0010\"\u001a\u00020#J\u0016\u0010'\u001a\u00020#2\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003J\u0013\u0010,\u001a\u0004\u0018\u00010\u00042\u0006\u0010-\u001a\u00020\u001eH\u0086\u0002J\u000e\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u0004J\u0006\u00100\u001a\u00020#J\u000e\u00101\u001a\u00020#2\u0006\u0010 \u001a\u00020!J\u0010\u00102\u001a\u00020#2\u0006\u0010 \u001a\u00020!H\u0002J \u00103\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u00104\u001a\u00020#H\u0002J\u0010\u00105\u001a\u00020#2\u0006\u0010/\u001a\u00020\u0004H\u0002J\u0006\u00106\u001a\u00020#J\u0010\u00107\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0004H\u0002J\u0010\u00108\u001a\u00020\b2\u0006\u00109\u001a\u00020\u0006H\u0002J\u0006\u0010:\u001a\u00020#J\u000e\u0010;\u001a\u00020#2\u0006\u0010/\u001a\u00020\u0004J\u0010\u0010<\u001a\u00020#2\u0006\u0010/\u001a\u00020\u0004H\u0002J\u000e\u0010=\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020\bJ\u000e\u0010@\u001a\u00020#2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010A\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u0006J\u000e\u0010B\u001a\u00020#2\u0006\u0010\u001c\u001a\u00020\u0006R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010%8F¢\u0006\u0006\u001a\u0004\b&\u0010\u0011R\u0013\u0010)\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006E"}, d2 = {"Lcom/qiahao/nextvideo/view/planet/PlanetCalculator;", "", "planetModels", "", "Lcom/qiahao/nextvideo/view/planet/PlanetModel;", "radius", "", "tagColorLight", "", "tagColorDark", "<init>", "(Ljava/util/List;F[F[F)V", "(F)V", "maxDelta", "minDelta", "planetModelCloud", "getPlanetModelCloud", "()Ljava/util/List;", "setPlanetModelCloud", "(Ljava/util/List;)V", "sinAngleX", "cosAngleX", "sinAngleY", "cosAngleY", "sinAngleZ", "cosAngleZ", "mAngleZ", "mAngleX", "mAngleY", "smallest", "", "largest", "isEvenly", "", "clear", "", "tagList", "", "getTagList", "setTagList", "list", "top", "getTop", "()Lcom/qiahao/nextvideo/view/planet/PlanetModel;", "get", "position", "indexOf", "planetModel", "reset", "create", "locationAll", "sineCosine", "updateAll", "initTag", "sortTagByScale", "getPercentage", "getColorFromGradient", "percentage", "update", "add", "location", "setRadius", "setTagColorLight", "tagColor", "setTagColorDark", "setAngleX", "setAngleY", "TagComparator", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPlanetCalculator.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PlanetCalculator.kt\ncom/qiahao/nextvideo/view/planet/PlanetCalculator\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,311:1\n1869#2,2:312\n1878#2,3:314\n*S KotlinDebug\n*F\n+ 1 PlanetCalculator.kt\ncom/qiahao/nextvideo/view/planet/PlanetCalculator\n*L\n93#1:312,2\n96#1:314,3\n*E\n"})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class PlanetCalculator {

    @NotNull
    private static final float[] DEFAULT_COLOR_DARK = {0.886f, 0.725f, 0.188f, 1.0f};

    @NotNull
    private static final float[] DEFAULT_COLOR_LIGHT = {0.3f, 0.3f, 0.3f, 1.0f};
    private static final float DEFAULT_RADIUS = 3.0f;
    private float cosAngleX;
    private float cosAngleY;
    private float cosAngleZ;
    private boolean isEvenly;
    private int largest;
    private float mAngleX;
    private float mAngleY;
    private final float mAngleZ;
    private float maxDelta;
    private float minDelta;

    @Nullable
    private List<PlanetModel> planetModelCloud;
    private float radius;
    private float sinAngleX;
    private float sinAngleY;
    private float sinAngleZ;
    private int smallest;

    @NotNull
    private float[] tagColorDark;

    @NotNull
    private float[] tagColorLight;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/qiahao/nextvideo/view/planet/PlanetCalculator$TagComparator;", "Ljava/util/Comparator;", "Lcom/qiahao/nextvideo/view/planet/PlanetModel;", "<init>", "()V", "compare", "", "planetModel1", "planetModel2", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class TagComparator implements Comparator<PlanetModel> {
        @Override // java.util.Comparator
        public int compare(@NotNull PlanetModel planetModel1, @NotNull PlanetModel planetModel2) {
            Intrinsics.checkNotNullParameter(planetModel1, "planetModel1");
            Intrinsics.checkNotNullParameter(planetModel2, "planetModel2");
            return planetModel1.getScale() > planetModel2.getScale() ? 1 : 0;
        }
    }

    @JvmOverloads
    public PlanetCalculator() {
        this(0.0f, 1, (DefaultConstructorMarker) null);
    }

    private final float[] getColorFromGradient(float percentage) {
        float[] fArr = this.tagColorDark;
        float f = fArr[0] * percentage;
        float f2 = 1.0f - percentage;
        float[] fArr2 = this.tagColorLight;
        return new float[]{1.0f, f + (fArr2[0] * f2), (fArr[1] * percentage) + (fArr2[1] * f2), (percentage * fArr[2]) + (f2 * fArr2[2])};
    }

    private final float getPercentage(PlanetModel planetModel) {
        int popularity = planetModel.getPopularity();
        int i = this.smallest;
        int i2 = this.largest;
        if (i == i2) {
            return 1.0f;
        }
        return (popularity - i) / (i2 - i);
    }

    private final void initTag(PlanetModel planetModel) {
        planetModel.setColorByArray(getColorFromGradient(getPercentage(planetModel)));
    }

    private final void location(PlanetModel planetModel) {
        double random = Math.random() * 3.141592653589793d;
        double random2 = Math.random() * 6.283185307179586d;
        planetModel.setLocX((int) (this.radius * Math.cos(random2) * Math.sin(random)));
        planetModel.setLocY((int) (this.radius * Math.sin(random2) * Math.sin(random)));
        planetModel.setLocZ((int) (this.radius * Math.cos(random)));
    }

    private final void locationAll(boolean isEvenly) {
        int i;
        double random;
        double random2;
        PlanetModel planetModel;
        PlanetModel planetModel2;
        PlanetModel planetModel3;
        List<PlanetModel> list = this.planetModelCloud;
        if (list != null) {
            i = list.size();
        } else {
            i = 0;
        }
        int i2 = i + 1;
        for (int i3 = 1; i3 < i2; i3++) {
            if (isEvenly) {
                random = Math.acos((((i3 * 2.0d) - 1.0d) / r5) - 1.0d);
                random2 = Math.sqrt(i * 3.141592653589793d) * random;
            } else {
                random = Math.random() * 3.141592653589793d;
                random2 = Math.random() * 6.283185307179586d;
            }
            List<PlanetModel> list2 = this.planetModelCloud;
            if (list2 != null && (planetModel3 = list2.get(i3 - 1)) != null) {
                planetModel3.setLocX((float) (this.radius * Math.cos(random2) * Math.sin(random)));
            }
            List<PlanetModel> list3 = this.planetModelCloud;
            if (list3 != null && (planetModel2 = list3.get(i3 - 1)) != null) {
                planetModel2.setLocY((float) (this.radius * Math.sin(random2) * Math.sin(random)));
            }
            List<PlanetModel> list4 = this.planetModelCloud;
            if (list4 != null && (planetModel = list4.get(i3 - 1)) != null) {
                planetModel.setLocZ((float) (this.radius * Math.cos(random)));
            }
        }
    }

    private final void sineCosine(float mAngleX, float mAngleY, float mAngleZ) {
        double d = mAngleX * 0.017453292519943295d;
        this.sinAngleX = (float) Math.sin(d);
        this.cosAngleX = (float) Math.cos(d);
        double d2 = mAngleY * 0.017453292519943295d;
        this.sinAngleY = (float) Math.sin(d2);
        this.cosAngleY = (float) Math.cos(d2);
        double d3 = mAngleZ * 0.017453292519943295d;
        this.sinAngleZ = (float) Math.sin(d3);
        this.cosAngleZ = (float) Math.cos(d3);
    }

    private final void updateAll() {
        int i;
        PlanetModel planetModel;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        List<PlanetModel> list = this.planetModelCloud;
        if (list != null) {
            i = list.size();
        } else {
            i = 0;
        }
        for (int i2 = 0; i2 < i; i2++) {
            List<PlanetModel> list2 = this.planetModelCloud;
            Float f6 = null;
            if (list2 != null) {
                planetModel = list2.get(i2);
            } else {
                planetModel = null;
            }
            if (planetModel != null) {
                f6 = Float.valueOf(planetModel.getLocX());
            }
            float f7 = 0.0f;
            if (planetModel != null) {
                f = planetModel.getLocY();
            } else {
                f = 0.0f;
            }
            float f8 = f * this.cosAngleX;
            if (planetModel != null) {
                f2 = planetModel.getLocZ();
            } else {
                f2 = 0.0f;
            }
            float f9 = f8 + (f2 * (-this.sinAngleX));
            if (planetModel != null) {
                f3 = planetModel.getLocY();
            } else {
                f3 = 0.0f;
            }
            float f10 = f3 * this.sinAngleX;
            if (planetModel != null) {
                f4 = planetModel.getLocZ();
            } else {
                f4 = 0.0f;
            }
            float f11 = f10 + (f4 * this.cosAngleX);
            if (f6 != null) {
                f5 = f6.floatValue();
            } else {
                f5 = 0.0f;
            }
            float f12 = (f5 * this.cosAngleY) + (this.sinAngleY * f11);
            if (f6 != null) {
                f7 = f6.floatValue();
            }
            float f13 = (f7 * (-this.sinAngleY)) + (this.cosAngleY * f11);
            float f14 = this.cosAngleZ;
            float f15 = this.sinAngleZ;
            float f16 = (f12 * f14) + ((-f15) * f9);
            float f17 = (f12 * f15) + (f9 * f14);
            if (planetModel != null) {
                planetModel.setLocX(f16);
            }
            if (planetModel != null) {
                planetModel.setLocY(f17);
            }
            if (planetModel != null) {
                planetModel.setLocZ(f13);
            }
            float f18 = 2 * this.radius;
            float f19 = f11 + f18;
            float f20 = f18 / f19;
            if (planetModel != null) {
                planetModel.setLoc2DX(f16);
            }
            if (planetModel != null) {
                planetModel.setLoc2DY(f17);
            }
            if (planetModel != null) {
                planetModel.setScale(f20);
            }
            this.maxDelta = RangesKt.coerceAtLeast(this.maxDelta, f19);
            float coerceAtMost = RangesKt.coerceAtMost(this.minDelta, f19);
            this.minDelta = coerceAtMost;
            float f21 = (f19 - coerceAtMost) / (this.maxDelta - coerceAtMost);
            if (planetModel != null) {
                planetModel.setAlpha(1 - f21);
            }
        }
        sortTagByScale();
    }

    public final void add(@NotNull PlanetModel planetModel) {
        Intrinsics.checkNotNullParameter(planetModel, "planetModel");
        initTag(planetModel);
        location(planetModel);
        List<PlanetModel> list = this.planetModelCloud;
        if (list != null) {
            list.add(planetModel);
        }
        updateAll();
    }

    public final void clear() {
        List<PlanetModel> list = this.planetModelCloud;
        if (list != null) {
            list.clear();
        }
    }

    public final void create(boolean isEvenly) {
        this.isEvenly = isEvenly;
        locationAll(isEvenly);
        sineCosine(this.mAngleX, this.mAngleY, this.mAngleZ);
        updateAll();
        this.smallest = 9999;
        int i = 0;
        this.largest = 0;
        List<PlanetModel> list = this.planetModelCloud;
        if (list != null) {
            for (PlanetModel planetModel : list) {
            }
        }
        List<PlanetModel> list2 = this.planetModelCloud;
        if (list2 != null) {
            for (Object obj : list2) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                PlanetModel planetModel2 = (PlanetModel) obj;
                this.largest = RangesKt.coerceAtLeast(this.largest, planetModel2.getPopularity());
                this.smallest = RangesKt.coerceAtMost(this.smallest, planetModel2.getPopularity());
                initTag(planetModel2);
                i = i2;
            }
        }
    }

    @Nullable
    public final PlanetModel get(int position) {
        List<PlanetModel> list = this.planetModelCloud;
        if (list != null) {
            return list.get(position);
        }
        return null;
    }

    @Nullable
    public final List<PlanetModel> getPlanetModelCloud() {
        return this.planetModelCloud;
    }

    @Nullable
    public final List<PlanetModel> getTagList() {
        return this.planetModelCloud;
    }

    @Nullable
    public final PlanetModel getTop() {
        int i;
        List<PlanetModel> list = this.planetModelCloud;
        if (list != null) {
            i = list.size();
        } else {
            i = 0;
        }
        return get(i - 1);
    }

    public final int indexOf(@NotNull PlanetModel planetModel) {
        Intrinsics.checkNotNullParameter(planetModel, "planetModel");
        List<PlanetModel> list = this.planetModelCloud;
        if (list != null) {
            return list.indexOf(planetModel);
        }
        return 0;
    }

    public final void reset() {
        create(this.isEvenly);
    }

    public final void setAngleX(float mAngleX) {
        this.mAngleX = mAngleX;
    }

    public final void setAngleY(float mAngleY) {
        this.mAngleY = mAngleY;
    }

    public final void setPlanetModelCloud(@Nullable List<PlanetModel> list) {
        this.planetModelCloud = list;
    }

    public final void setRadius(float radius) {
        this.radius = radius;
    }

    public final void setTagColorDark(@NotNull float[] tagColorDark) {
        Intrinsics.checkNotNullParameter(tagColorDark, "tagColorDark");
        this.tagColorDark = tagColorDark;
    }

    public final void setTagColorLight(@NotNull float[] tagColor) {
        Intrinsics.checkNotNullParameter(tagColor, "tagColor");
        this.tagColorLight = tagColor;
    }

    public final void setTagList(@Nullable List<PlanetModel> list) {
        this.planetModelCloud = list;
    }

    public final void sortTagByScale() {
        Collections.sort(this.planetModelCloud, new TagComparator());
    }

    public final void update() {
        if (Math.abs(this.mAngleX) > 0.1d || Math.abs(this.mAngleY) > 0.1d) {
            sineCosine(this.mAngleX, this.mAngleY, this.mAngleZ);
            updateAll();
        }
    }

    @JvmOverloads
    public PlanetCalculator(@Nullable List<PlanetModel> list) {
        this(list, 0.0f, null, null, 14, null);
    }

    @JvmOverloads
    public PlanetCalculator(@Nullable List<PlanetModel> list, float f) {
        this(list, f, null, null, 12, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PlanetCalculator(@Nullable List<PlanetModel> list, float f, @NotNull float[] fArr) {
        this(list, f, fArr, null, 8, null);
        Intrinsics.checkNotNullParameter(fArr, "tagColorLight");
    }

    @JvmOverloads
    public PlanetCalculator(@Nullable List<PlanetModel> list, float f, @NotNull float[] fArr, @NotNull float[] fArr2) {
        Intrinsics.checkNotNullParameter(fArr, "tagColorLight");
        Intrinsics.checkNotNullParameter(fArr2, "tagColorDark");
        this.maxDelta = Float.MIN_VALUE;
        this.minDelta = Float.MAX_VALUE;
        this.isEvenly = true;
        this.planetModelCloud = list;
        this.radius = f;
        this.tagColorLight = fArr;
        this.tagColorDark = fArr2;
    }

    public /* synthetic */ PlanetCalculator(List list, float f, float[] fArr, float[] fArr2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i & 2) != 0 ? DEFAULT_RADIUS : f, (i & 4) != 0 ? DEFAULT_COLOR_DARK : fArr, (i & 8) != 0 ? DEFAULT_COLOR_LIGHT : fArr2);
    }

    public /* synthetic */ PlanetCalculator(float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? DEFAULT_RADIUS : f);
    }

    @JvmOverloads
    public PlanetCalculator(float f) {
        this(new ArrayList(), f, null, null, 12, null);
    }
}
