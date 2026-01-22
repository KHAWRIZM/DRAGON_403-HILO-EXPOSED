package com.qiahao.nextvideo.data.foodie;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R.\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019j\n\u0012\u0004\u0012\u00020\u001a\u0018\u0001`\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Lcom/qiahao/nextvideo/data/foodie/FoodieRecordBean;", "Lcom/chad/library/adapter/base/entity/MultiItemEntity;", "<init>", "()V", "round", "", "getRound", "()Ljava/lang/Integer;", "setRound", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "winFoodieId", "getWinFoodieId", "setWinFoodieId", "createTime", "", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "winDiamond", "getWinDiamond", "setWinDiamond", "list", "Ljava/util/ArrayList;", "Lcom/qiahao/nextvideo/data/foodie/Bet;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "itemType", "getItemType", "()I", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class FoodieRecordBean implements MultiItemEntity {

    @Nullable
    private ArrayList<Bet> list;

    @Nullable
    private Integer round = 0;

    @Nullable
    private Integer winFoodieId = 0;

    @Nullable
    private Long createTime = 0L;

    @Nullable
    private Long winDiamond = 0L;

    @Nullable
    public final Long getCreateTime() {
        return this.createTime;
    }

    public int getItemType() {
        int i;
        ArrayList<Bet> arrayList = this.list;
        if (arrayList != null) {
            i = arrayList.size();
        } else {
            i = 0;
        }
        if (i <= 3) {
            return 0;
        }
        return 1;
    }

    @Nullable
    public final ArrayList<Bet> getList() {
        return this.list;
    }

    @Nullable
    public final Integer getRound() {
        return this.round;
    }

    @Nullable
    public final Long getWinDiamond() {
        return this.winDiamond;
    }

    @Nullable
    public final Integer getWinFoodieId() {
        return this.winFoodieId;
    }

    public final void setCreateTime(@Nullable Long l) {
        this.createTime = l;
    }

    public final void setList(@Nullable ArrayList<Bet> arrayList) {
        this.list = arrayList;
    }

    public final void setRound(@Nullable Integer num) {
        this.round = num;
    }

    public final void setWinDiamond(@Nullable Long l) {
        this.winDiamond = l;
    }

    public final void setWinFoodieId(@Nullable Integer num) {
        this.winFoodieId = num;
    }
}
