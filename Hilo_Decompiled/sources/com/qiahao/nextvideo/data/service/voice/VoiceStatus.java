package com.qiahao.nextvideo.data.service.voice;

import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/qiahao/nextvideo/data/service/voice/VoiceStatus;", "", AgooConstants.MESSAGE_ID, "", "state", "Lcom/qiahao/nextvideo/data/service/voice/VoiceStatusState;", "progress", "", "<init>", "(JLcom/qiahao/nextvideo/data/service/voice/VoiceStatusState;F)V", "getId", "()J", "getState", "()Lcom/qiahao/nextvideo/data/service/voice/VoiceStatusState;", "getProgress", "()F", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class VoiceStatus {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final VoiceStatus IDLE = new VoiceStatus(-1, VoiceStatusState.NONE, 0.0f);
    private final long id;
    private final float progress;

    @NotNull
    private final VoiceStatusState state;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/data/service/voice/VoiceStatus$Companion;", "", "<init>", "()V", "IDLE", "Lcom/qiahao/nextvideo/data/service/voice/VoiceStatus;", "getIDLE", "()Lcom/qiahao/nextvideo/data/service/voice/VoiceStatus;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VoiceStatus getIDLE() {
            return VoiceStatus.IDLE;
        }

        private Companion() {
        }
    }

    public VoiceStatus(long j, @NotNull VoiceStatusState voiceStatusState, float f) {
        Intrinsics.checkNotNullParameter(voiceStatusState, "state");
        this.id = j;
        this.state = voiceStatusState;
        this.progress = f;
    }

    public static /* synthetic */ VoiceStatus copy$default(VoiceStatus voiceStatus, long j, VoiceStatusState voiceStatusState, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            j = voiceStatus.id;
        }
        if ((i & 2) != 0) {
            voiceStatusState = voiceStatus.state;
        }
        if ((i & 4) != 0) {
            f = voiceStatus.progress;
        }
        return voiceStatus.copy(j, voiceStatusState, f);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final VoiceStatusState getState() {
        return this.state;
    }

    /* renamed from: component3, reason: from getter */
    public final float getProgress() {
        return this.progress;
    }

    @NotNull
    public final VoiceStatus copy(long id2, @NotNull VoiceStatusState state, float progress) {
        Intrinsics.checkNotNullParameter(state, "state");
        return new VoiceStatus(id2, state, progress);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceStatus)) {
            return false;
        }
        VoiceStatus voiceStatus = (VoiceStatus) other;
        return this.id == voiceStatus.id && this.state == voiceStatus.state && Float.compare(this.progress, voiceStatus.progress) == 0;
    }

    public final long getId() {
        return this.id;
    }

    public final float getProgress() {
        return this.progress;
    }

    @NotNull
    public final VoiceStatusState getState() {
        return this.state;
    }

    public int hashCode() {
        return (((c.a(this.id) * 31) + this.state.hashCode()) * 31) + Float.floatToIntBits(this.progress);
    }

    @NotNull
    public String toString() {
        return "VoiceStatus(id=" + this.id + ", state=" + this.state + ", progress=" + this.progress + ")";
    }
}
