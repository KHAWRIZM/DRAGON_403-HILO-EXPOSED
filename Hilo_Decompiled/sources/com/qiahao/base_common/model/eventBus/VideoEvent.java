package com.qiahao.base_common.model.eventBus;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/qiahao/base_common/model/eventBus/VideoEvent;", "", "type", "", "data", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "getType", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Companion", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class VideoEvent {

    @NotNull
    public static final String ADD_TIME_1v1 = "add-time_1v1";

    @NotNull
    public static final String CLICK_MATCHING_FLOAT = "CLICK_MATCHING_FLOAT";

    @NotNull
    public static final String DEFAULT = "DEFAULT";

    @NotNull
    public static final String HAS_LIKE_YOU = "has_like_you";

    @NotNull
    public static final String HOME_PAGE_MATCH = "HOME_PAGE_MATCH";

    @NotNull
    public static final String LIKE_EACH_OTHER = "LIKE_EACH_OTHER";

    @NotNull
    public static final String MATCH_REFRESH_CARD = "MATCH_REFRESH_CARD";

    @NotNull
    public static final String MATCH_RESULT = "MATCH_RESULT";

    @NotNull
    public static final String MATCH_SHOW_RECHARGE = "MATCH_SHOW_RECHARGE";

    @NotNull
    public static final String NOTIFICATION_PERMISSION_TIPS = "NOTIFICATION_PERMISSION_TIPS";

    @NotNull
    public static final String PENDING = "PENDING";

    @NotNull
    public static final String SPECIFY_VIDEO_CALL_ANSWERED = "SPECIFY_VIDEO_CALL_ANSWERED";

    @NotNull
    public static final String SPECIFY_VIDEO_CALL_ANSWERED_PENDING = "SPECIFY_VIDEO_CALL_ANSWERED_PENDING";

    @NotNull
    public static final String SPECIFY_VIDEO_CALL_DIALED_PENDING = "SPECIFY_VIDEO_CALL_DIALED_PENDING";

    @NotNull
    public static final String SPECIFY_VIDEO_CALL_HANGUP = "SPECIFY_VIDEO_CALL_HANGUP";

    @NotNull
    public static final String SPECIFY_VIDEO_CALL_REFUSED = "SPECIFY_VIDEO_CALL_REFUSED";

    @NotNull
    public static final String STARTUP = "remote_first_frame";

    @NotNull
    public static final String STARTUP_MATCH = "remote_first_frame_match";

    @NotNull
    public static final String START_MATCH = "START_MATCH";

    @NotNull
    public static final String STOP = "STOP";

    @NotNull
    public static final String VIDEO_EFFECT = "video_effect";

    @NotNull
    public static final String VIDEO_IM_GIFT = "video_im_gift";

    @NotNull
    public static final String VIDEO_IM_INTERACTION = "video_im_interaction";

    @NotNull
    public static final String VIDEO_IM_TEXT = "video_im_text";

    @NotNull
    public static final String VIDEO_RESULT = "VIDEO_RESULT";

    @NotNull
    public static final String VIDEO_SETTING_CHANGE = "videoSettingChange";

    @Nullable
    private final Object data;

    @NotNull
    private final String type;

    public VideoEvent(@NotNull String type, @Nullable Object obj) {
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

    public /* synthetic */ VideoEvent(String str, Object obj, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? null : obj);
    }
}
