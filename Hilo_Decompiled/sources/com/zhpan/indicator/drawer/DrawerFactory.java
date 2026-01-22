package com.zhpan.indicator.drawer;

import com.zhpan.indicator.option.IndicatorOptions;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/zhpan/indicator/drawer/DrawerFactory;", "", "()V", "createDrawer", "Lcom/zhpan/indicator/drawer/IDrawer;", "indicatorOptions", "Lcom/zhpan/indicator/option/IndicatorOptions;", "indicator_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class DrawerFactory {
    public static final DrawerFactory INSTANCE = new DrawerFactory();

    private DrawerFactory() {
    }

    @NotNull
    public final IDrawer createDrawer(@NotNull IndicatorOptions indicatorOptions) {
        int indicatorStyle = indicatorOptions.getIndicatorStyle();
        if (indicatorStyle != 2) {
            if (indicatorStyle != 4) {
                return new CircleDrawer(indicatorOptions);
            }
            return new RoundRectDrawer(indicatorOptions);
        }
        return new DashDrawer(indicatorOptions);
    }
}
