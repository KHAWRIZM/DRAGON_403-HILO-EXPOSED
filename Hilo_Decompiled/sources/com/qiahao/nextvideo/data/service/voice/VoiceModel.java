package com.qiahao.nextvideo.data.service.voice;

import android.net.Uri;
import androidx.collection.c;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J5\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/qiahao/nextvideo/data/service/voice/VoiceModel;", "", AgooConstants.MESSAGE_ID, "", "url", "", "uri", "Landroid/net/Uri;", "voiceConfig", "Lcom/qiahao/nextvideo/data/service/voice/VoiceConfig;", "<init>", "(JLjava/lang/String;Landroid/net/Uri;Lcom/qiahao/nextvideo/data/service/voice/VoiceConfig;)V", "getId", "()J", "getUrl", "()Ljava/lang/String;", "getUri", "()Landroid/net/Uri;", "getVoiceConfig", "()Lcom/qiahao/nextvideo/data/service/voice/VoiceConfig;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class VoiceModel {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final long id;

    @Nullable
    private final Uri uri;

    @Nullable
    private final String url;

    @NotNull
    private final VoiceConfig voiceConfig;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006\u000e"}, d2 = {"Lcom/qiahao/nextvideo/data/service/voice/VoiceModel$Companion;", "", "<init>", "()V", "create", "Lcom/qiahao/nextvideo/data/service/voice/VoiceModel;", AgooConstants.MESSAGE_ID, "", "url", "", "voiceConfig", "Lcom/qiahao/nextvideo/data/service/voice/VoiceConfig;", "uri", "Landroid/net/Uri;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ VoiceModel create$default(Companion companion, long j, String str, VoiceConfig voiceConfig, int i, Object obj) {
            if ((i & 4) != 0) {
                voiceConfig = VoiceConfig.INSTANCE.init(false);
            }
            return companion.create(j, str, voiceConfig);
        }

        @NotNull
        public final VoiceModel create(long id2, @NotNull String url, @NotNull VoiceConfig voiceConfig) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(voiceConfig, "voiceConfig");
            return new VoiceModel(id2, url, null, voiceConfig);
        }

        private Companion() {
        }

        public static /* synthetic */ VoiceModel create$default(Companion companion, long j, Uri uri, VoiceConfig voiceConfig, int i, Object obj) {
            if ((i & 4) != 0) {
                voiceConfig = VoiceConfig.INSTANCE.init(false);
            }
            return companion.create(j, uri, voiceConfig);
        }

        @NotNull
        public final VoiceModel create(long id2, @NotNull Uri uri, @NotNull VoiceConfig voiceConfig) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(voiceConfig, "voiceConfig");
            return new VoiceModel(id2, null, uri, voiceConfig);
        }
    }

    public VoiceModel(long j, @Nullable String str, @Nullable Uri uri, @NotNull VoiceConfig voiceConfig) {
        Intrinsics.checkNotNullParameter(voiceConfig, "voiceConfig");
        this.id = j;
        this.url = str;
        this.uri = uri;
        this.voiceConfig = voiceConfig;
    }

    public static /* synthetic */ VoiceModel copy$default(VoiceModel voiceModel, long j, String str, Uri uri, VoiceConfig voiceConfig, int i, Object obj) {
        if ((i & 1) != 0) {
            j = voiceModel.id;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = voiceModel.url;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            uri = voiceModel.uri;
        }
        Uri uri2 = uri;
        if ((i & 8) != 0) {
            voiceConfig = voiceModel.voiceConfig;
        }
        return voiceModel.copy(j2, str2, uri2, voiceConfig);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Uri getUri() {
        return this.uri;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final VoiceConfig getVoiceConfig() {
        return this.voiceConfig;
    }

    @NotNull
    public final VoiceModel copy(long id2, @Nullable String url, @Nullable Uri uri, @NotNull VoiceConfig voiceConfig) {
        Intrinsics.checkNotNullParameter(voiceConfig, "voiceConfig");
        return new VoiceModel(id2, url, uri, voiceConfig);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VoiceModel)) {
            return false;
        }
        VoiceModel voiceModel = (VoiceModel) other;
        return this.id == voiceModel.id && Intrinsics.areEqual(this.url, voiceModel.url) && Intrinsics.areEqual(this.uri, voiceModel.uri) && Intrinsics.areEqual(this.voiceConfig, voiceModel.voiceConfig);
    }

    public final long getId() {
        return this.id;
    }

    @Nullable
    public final Uri getUri() {
        return this.uri;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final VoiceConfig getVoiceConfig() {
        return this.voiceConfig;
    }

    public int hashCode() {
        int a = c.a(this.id) * 31;
        String str = this.url;
        int hashCode = (a + (str == null ? 0 : str.hashCode())) * 31;
        Uri uri = this.uri;
        return ((hashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.voiceConfig.hashCode();
    }

    @NotNull
    public String toString() {
        return "VoiceModel(id=" + this.id + ", url=" + this.url + ", uri=" + this.uri + ", voiceConfig=" + this.voiceConfig + ")";
    }
}
