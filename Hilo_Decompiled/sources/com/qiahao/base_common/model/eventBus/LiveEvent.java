package com.qiahao.base_common.model.eventBus;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/qiahao/base_common/model/eventBus/LiveEvent;", "", "type", "", "data", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "getType", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class LiveEvent {

    @NotNull
    public static final String CLICK_ENVELOPE = "click_envelope";

    @NotNull
    public static final String EXIT_ROOM = "EXIT_ROOM";

    @NotNull
    public static final String JOIN_MATCH_GAME = "join_match_game";

    @NotNull
    public static final String LOCAL_MUTE = "local_mute";

    @NotNull
    public static final String OPEN_GAME = "open_game";

    @NotNull
    public static final String OPEN_LUCKY_BOX = "open_lucky_box";

    @NotNull
    public static final String OPEN_LUCKY_FRUIT = "open_lucky_fruit";

    @NotNull
    public static final String REFRESH_DIAMOND_GAME_ICON = "REFRESH_DIAMOND_GAME_ICON";

    @NotNull
    public static final String REFRESH_SUB_ACTIVITY = "refreshSubActivity";

    @NotNull
    public static final String SHOW_ANIMATION = "isShow";

    @NotNull
    public static final String SUB_ACTIVITY = "subscribActivity";

    @NotNull
    public static final String TWO_SUB_ACTIVITY = "two_subscribActivity";

    @Nullable
    private final Object data;

    @NotNull
    private final String type;

    public LiveEvent(@NotNull String type, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.type = type;
        this.data = obj;
    }

    @Nullable
    public final Object getData() {
        return this.data;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public /* synthetic */ LiveEvent(String str, Object obj, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : obj);
    }
}
