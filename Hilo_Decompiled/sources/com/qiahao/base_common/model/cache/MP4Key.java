package com.qiahao.base_common.model.cache;

import androidx.annotation.Keep;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Keep
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/qiahao/base_common/model/cache/MP4Key;", "", "<init>", "()V", "NOBLE_10_MP4", "", "NOBLE_10_RIGHT_MP4", "NICK_FIRE_MP4", "NICK_FIRE_RIGHT_MP4", "base_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class MP4Key {

    @NotNull
    public static final MP4Key INSTANCE = new MP4Key();

    @NotNull
    public static final String NICK_FIRE_MP4 = "mp4/nick_fire.mp4";

    @NotNull
    public static final String NICK_FIRE_RIGHT_MP4 = "mp4/nick_fire_right.mp4";

    @NotNull
    public static final String NOBLE_10_MP4 = "mp4/noble10.mp4";

    @NotNull
    public static final String NOBLE_10_RIGHT_MP4 = "mp4/noble_right10.mp4";

    private MP4Key() {
    }
}
