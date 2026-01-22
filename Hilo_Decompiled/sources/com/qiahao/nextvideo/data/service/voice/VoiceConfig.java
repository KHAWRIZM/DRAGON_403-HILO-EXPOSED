package com.qiahao.nextvideo.data.service.voice;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/qiahao/nextvideo/data/service/voice/VoiceConfig;", "", "isLooping", "", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class VoiceConfig {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final boolean isLooping;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/qiahao/nextvideo/data/service/voice/VoiceConfig$Companion;", "", "<init>", "()V", "init", "Lcom/qiahao/nextvideo/data/service/voice/VoiceConfig;", "isLooping", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ VoiceConfig init$default(Companion companion, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.init(z);
        }

        @NotNull
        public final VoiceConfig init(boolean isLooping) {
            return new VoiceConfig(isLooping);
        }

        private Companion() {
        }
    }

    public VoiceConfig(boolean z) {
        this.isLooping = z;
    }

    public static /* synthetic */ VoiceConfig copy$default(VoiceConfig voiceConfig, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = voiceConfig.isLooping;
        }
        return voiceConfig.copy(z);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIsLooping() {
        return this.isLooping;
    }

    @NotNull
    public final VoiceConfig copy(boolean isLooping) {
        return new VoiceConfig(isLooping);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof VoiceConfig) && this.isLooping == ((VoiceConfig) other).isLooping;
    }

    public int hashCode() {
        return q2.a.a(this.isLooping);
    }

    public final boolean isLooping() {
        return this.isLooping;
    }

    @NotNull
    public String toString() {
        return "VoiceConfig(isLooping=" + this.isLooping + ")";
    }
}
