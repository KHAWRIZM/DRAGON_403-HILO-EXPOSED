package com.pierfrancescosoffritti.androidyoutubeplayer.core.player.options;

import android.content.Context;
import com.amazonaws.mobileconnectors.s3.transferutility.TransferTable;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\r\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "", "playerOptions", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "toString", "", "getOrigin", "getOrigin$core_release", "Companion", "Builder", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class IFramePlayerOptions {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final JSONObject playerOptions;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000bJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u000bJ\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u000bH\u0007J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0012H\u0002J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u000bH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions$Builder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "builderOptions", "Lorg/json/JSONObject;", "build", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", Builder.CONTROLS, "", Builder.AUTO_PLAY, Builder.MUTE, Builder.REL, "ivLoadPolicy", "langPref", RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE, "", "ccLoadPolicy", "origin", Builder.LIST, Builder.LIST_TYPE, "fullscreen", Builder.FS, Builder.START, "startSeconds", Builder.END, "endSeconds", "modestBranding", "addString", "", TransferTable.COLUMN_KEY, "value", "addInt", "Companion", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Builder {

        @NotNull
        private static final String AUTO_PLAY = "autoplay";

        @NotNull
        private static final String CC_LANG_PREF = "cc_lang_pref";

        @NotNull
        private static final String CC_LOAD_POLICY = "cc_load_policy";

        @NotNull
        private static final String CONTROLS = "controls";

        @NotNull
        private static final String ENABLE_JS_API = "enablejsapi";

        @NotNull
        private static final String END = "end";

        @NotNull
        private static final String FS = "fs";

        @NotNull
        private static final String IV_LOAD_POLICY = "iv_load_policy";

        @NotNull
        private static final String LIST = "list";

        @NotNull
        private static final String LIST_TYPE = "listType";

        @NotNull
        private static final String MUTE = "mute";

        @NotNull
        public static final String ORIGIN = "origin";

        @NotNull
        private static final String REL = "rel";

        @NotNull
        private static final String START = "start";

        @NotNull
        private final JSONObject builderOptions;

        public Builder(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.builderOptions = new JSONObject();
            addInt(AUTO_PLAY, 0);
            addInt(MUTE, 0);
            addInt(CONTROLS, 0);
            addInt(ENABLE_JS_API, 1);
            addInt(FS, 0);
            addString("origin", "https://" + context.getPackageName());
            addInt(REL, 0);
            addInt(IV_LOAD_POLICY, 3);
            addInt(CC_LOAD_POLICY, 0);
        }

        private final void addInt(String key, int value) {
            try {
                this.builderOptions.put(key, value);
            } catch (JSONException unused) {
                throw new RuntimeException("Illegal JSON value " + key + ": " + value);
            }
        }

        private final void addString(String key, String value) {
            try {
                this.builderOptions.put(key, value);
            } catch (JSONException unused) {
                throw new RuntimeException("Illegal JSON value " + key + ": " + value);
            }
        }

        @NotNull
        public final Builder autoplay(int controls) {
            addInt(AUTO_PLAY, controls);
            return this;
        }

        @NotNull
        public final IFramePlayerOptions build() {
            return new IFramePlayerOptions(this.builderOptions, null);
        }

        @NotNull
        public final Builder ccLoadPolicy(int ccLoadPolicy) {
            addInt(CC_LOAD_POLICY, ccLoadPolicy);
            return this;
        }

        @NotNull
        public final Builder controls(int controls) {
            addInt(CONTROLS, controls);
            return this;
        }

        @NotNull
        public final Builder end(int endSeconds) {
            addInt(END, endSeconds);
            return this;
        }

        @NotNull
        public final Builder fullscreen(int fs) {
            addInt(FS, fs);
            return this;
        }

        @NotNull
        public final Builder ivLoadPolicy(int ivLoadPolicy) {
            addInt(IV_LOAD_POLICY, ivLoadPolicy);
            return this;
        }

        @NotNull
        public final Builder langPref(@NotNull String languageCode) {
            Intrinsics.checkNotNullParameter(languageCode, "languageCode");
            addString(CC_LANG_PREF, languageCode);
            return this;
        }

        @NotNull
        public final Builder list(@NotNull String list) {
            Intrinsics.checkNotNullParameter(list, "list");
            addString(LIST, list);
            return this;
        }

        @NotNull
        public final Builder listType(@NotNull String listType) {
            Intrinsics.checkNotNullParameter(listType, "listType");
            addString(LIST_TYPE, listType);
            return this;
        }

        @Deprecated(message = "Deprecated and will have no effect")
        @NotNull
        public final Builder modestBranding(int modestBranding) {
            return this;
        }

        @NotNull
        public final Builder mute(int controls) {
            addInt(MUTE, controls);
            return this;
        }

        @NotNull
        public final Builder origin(@NotNull String origin) {
            Intrinsics.checkNotNullParameter(origin, "origin");
            addString("origin", origin);
            return this;
        }

        @NotNull
        public final Builder rel(int rel) {
            addInt(REL, rel);
            return this;
        }

        @NotNull
        public final Builder start(int startSeconds) {
            addInt(START, startSeconds);
            return this;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions$Companion;", "", "<init>", "()V", "getDefault", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/options/IFramePlayerOptions;", "context", "Landroid/content/Context;", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final IFramePlayerOptions getDefault(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Builder(context).controls(1).build();
        }

        private Companion() {
        }
    }

    public /* synthetic */ IFramePlayerOptions(JSONObject jSONObject, DefaultConstructorMarker defaultConstructorMarker) {
        this(jSONObject);
    }

    @NotNull
    public final String getOrigin$core_release() {
        String string = this.playerOptions.getString("origin");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    @NotNull
    public String toString() {
        String jSONObject = this.playerOptions.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        return jSONObject;
    }

    private IFramePlayerOptions(JSONObject jSONObject) {
        this.playerOptions = jSONObject;
    }
}
