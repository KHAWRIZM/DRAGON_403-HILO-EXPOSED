package com.qhqc.core.basic.aws;

import com.facebook.share.internal.ShareConstants;
import com.qhqc.core.basic.router.provider.BasicModuleApp;
import com.qhqc.core.basic.utils.TimeUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/qhqc/core/basic/aws/S3Configs;", "", "()V", "mName", "", "mType", "Lcom/qhqc/core/basic/aws/S3Configs$Type;", "projectDirectory", "savePath", "getFileNameByType", "type", "getKey", "getType", "setName", "uploadName", "setType", "setUploadPath", "path", "Builder", "Type", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
public final class S3Configs {

    @Nullable
    private String mName;

    @NotNull
    private Type mType;

    @NotNull
    private final String projectDirectory;

    @Nullable
    private String savePath;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/qhqc/core/basic/aws/S3Configs$Builder;", "", "()V", "mName", "", "mUploadPath", "build", "Lcom/qhqc/core/basic/aws/S3Configs;", "type", "Lcom/qhqc/core/basic/aws/S3Configs$Type;", "setName", "value", "setUploadPath", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Builder {

        @NotNull
        private String mName = "";

        @NotNull
        private String mUploadPath = "";

        @NotNull
        public final S3Configs build(@NotNull Type type) {
            Intrinsics.checkNotNullParameter(type, "type");
            S3Configs s3Configs = new S3Configs(null);
            s3Configs.setType(type);
            if (StringsKt.trim((CharSequence) this.mName).toString().length() > 0) {
                s3Configs.setName(this.mName);
            }
            if (StringsKt.trim((CharSequence) this.mUploadPath).toString().length() > 0) {
                s3Configs.setUploadPath(this.mUploadPath);
            }
            return s3Configs;
        }

        @NotNull
        public final Builder setName(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.mName = value;
            return this;
        }

        @NotNull
        public final Builder setUploadPath(@NotNull String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.mUploadPath = value;
            return this;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/qhqc/core/basic/aws/S3Configs$Type;", "", "(Ljava/lang/String;I)V", ShareConstants.IMAGE_URL, ShareConstants.VIDEO_URL, "AUDIO", "GIF", "LOG", "ZIP", "basic_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type IMAGE = new Type(ShareConstants.IMAGE_URL, 0);
        public static final Type VIDEO = new Type(ShareConstants.VIDEO_URL, 1);
        public static final Type AUDIO = new Type("AUDIO", 2);
        public static final Type GIF = new Type("GIF", 3);
        public static final Type LOG = new Type("LOG", 4);
        public static final Type ZIP = new Type("ZIP", 5);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{IMAGE, VIDEO, AUDIO, GIF, LOG, ZIP};
        }

        static {
            Type[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Type(String str, int i10) {
        }

        @NotNull
        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            try {
                iArr[Type.IMAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Type.VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Type.AUDIO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Type.GIF.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Type.LOG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Type.ZIP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ S3Configs(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final String getFileNameByType(Type type) {
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                TimeUtils timeUtils = TimeUtils.INSTANCE;
                return timeUtils.getNowDateWithLocale("yyyy/MM/dd/") + BasicModuleApp.INSTANCE.userAuth().getUid() + "/" + timeUtils.getNowUnixTime() + ".png";
            case 2:
                TimeUtils timeUtils2 = TimeUtils.INSTANCE;
                return timeUtils2.getNowDateWithLocale("yyyy/MM/dd/") + BasicModuleApp.INSTANCE.userAuth().getUid() + "/" + timeUtils2.getNowUnixTime() + ".mp4";
            case 3:
                TimeUtils timeUtils3 = TimeUtils.INSTANCE;
                return timeUtils3.getNowDateWithLocale("yyyy/MM/dd/") + BasicModuleApp.INSTANCE.userAuth().getUid() + "/" + timeUtils3.getNowUnixTime() + ".aac";
            case 4:
                TimeUtils timeUtils4 = TimeUtils.INSTANCE;
                return timeUtils4.getNowDateWithLocale("yyyy/MM/dd/") + BasicModuleApp.INSTANCE.userAuth().getUid() + "/" + timeUtils4.getNowUnixTime() + ".gif";
            case 5:
                TimeUtils timeUtils5 = TimeUtils.INSTANCE;
                return timeUtils5.getNowDateWithLocale("yyyy/MM/dd/") + BasicModuleApp.INSTANCE.userAuth().getUid() + "/" + timeUtils5.getNowUnixTime() + ".log";
            case 6:
                TimeUtils timeUtils6 = TimeUtils.INSTANCE;
                return timeUtils6.getNowDateWithLocale("yyyy/MM/dd/") + BasicModuleApp.INSTANCE.userAuth().getUid() + "/" + timeUtils6.getNowUnixTime() + ".zip";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final String getKey() {
        return this.projectDirectory + "/" + this.savePath + this.mName;
    }

    @NotNull
    /* renamed from: getType, reason: from getter */
    public final Type getMType() {
        return this.mType;
    }

    @NotNull
    public final S3Configs setName(@NotNull String uploadName) {
        Intrinsics.checkNotNullParameter(uploadName, "uploadName");
        this.mName = uploadName;
        return this;
    }

    @NotNull
    public final S3Configs setType(@NotNull Type type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.mType = type;
        this.mName = getFileNameByType(type);
        return this;
    }

    @NotNull
    public final S3Configs setUploadPath(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.savePath = path;
        return this;
    }

    private S3Configs() {
        BasicModuleApp basicModuleApp = BasicModuleApp.INSTANCE;
        this.projectDirectory = basicModuleApp.projectDirectory();
        this.savePath = "image/";
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        this.mName = timeUtils.getNowDateWithLocale("yyyy/MM/dd/") + basicModuleApp.userAuth().getUid() + "/" + timeUtils.getNowUnixTime() + ".png";
        this.mType = Type.IMAGE;
    }
}
