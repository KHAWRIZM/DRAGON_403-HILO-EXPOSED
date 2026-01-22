package com.qiahao.nextvideo.data.foodie;

import com.qiahao.nextvideo.ui.foodie.FoodieItemView;
import com.qiahao.nextvideo.ui.foodie.FoodieUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/qiahao/nextvideo/data/foodie/FoodieItem;", "", "position", "", "type", "view", "Lcom/qiahao/nextvideo/ui/foodie/FoodieItemView;", "betBean", "Lcom/qiahao/nextvideo/data/foodie/FoodieBetBean;", "<init>", "(IILcom/qiahao/nextvideo/ui/foodie/FoodieItemView;Lcom/qiahao/nextvideo/data/foodie/FoodieBetBean;)V", "getPosition", "()I", "setPosition", "(I)V", "getType", "setType", "getView", "()Lcom/qiahao/nextvideo/ui/foodie/FoodieItemView;", "setView", "(Lcom/qiahao/nextvideo/ui/foodie/FoodieItemView;)V", "getBetBean", "()Lcom/qiahao/nextvideo/data/foodie/FoodieBetBean;", "setBetBean", "(Lcom/qiahao/nextvideo/data/foodie/FoodieBetBean;)V", "getIcon", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieItem {

    @Nullable
    private FoodieBetBean betBean;
    private int position;
    private int type;

    @NotNull
    private FoodieItemView view;

    public FoodieItem(int i, int i2, @NotNull FoodieItemView foodieItemView, @Nullable FoodieBetBean foodieBetBean) {
        Intrinsics.checkNotNullParameter(foodieItemView, "view");
        this.position = i;
        this.type = i2;
        this.view = foodieItemView;
        this.betBean = foodieBetBean;
    }

    @Nullable
    public final FoodieBetBean getBetBean() {
        return this.betBean;
    }

    @NotNull
    public final String getIcon() {
        return FoodieUtil.INSTANCE.getFoodieIcon(this.type);
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final FoodieItemView getView() {
        return this.view;
    }

    public final void setBetBean(@Nullable FoodieBetBean foodieBetBean) {
        this.betBean = foodieBetBean;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setView(@NotNull FoodieItemView foodieItemView) {
        Intrinsics.checkNotNullParameter(foodieItemView, "<set-?>");
        this.view = foodieItemView;
    }

    public /* synthetic */ FoodieItem(int i, int i2, FoodieItemView foodieItemView, FoodieBetBean foodieBetBean, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, foodieItemView, (i3 & 8) != 0 ? null : foodieBetBean);
    }
}
