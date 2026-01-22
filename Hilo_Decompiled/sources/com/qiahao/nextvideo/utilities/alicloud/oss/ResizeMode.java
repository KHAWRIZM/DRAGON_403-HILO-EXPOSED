package com.qiahao.nextvideo.utilities.alicloud.oss;

import com.taobao.accs.common.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0014\u0015\u0016\u0017\u0018B+\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u0082\u0001\u0005\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode;", "", Constants.KEY_MODE, "", "width", "", "height", "limit", "<init>", "(Ljava/lang/String;III)V", "getWidth", "()I", "setWidth", "(I)V", "getHeight", "setHeight", "getLimit", "getUrl", "profilePictureUrl", "getCircleUrl", "LFIT", "MFIT", "FILL", "PAD", "FIXED", "Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode$FILL;", "Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode$FIXED;", "Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode$LFIT;", "Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode$MFIT;", "Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode$PAD;", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class ResizeMode {
    private int height;
    private final int limit;

    @NotNull
    private final String mode;
    private int width;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode$FILL;", "Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode;", "<init>", "()V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class FILL extends ResizeMode {

        @NotNull
        public static final FILL INSTANCE = new FILL();

        private FILL() {
            super("m_fill", 0, 0, 0, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode$FIXED;", "Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode;", "<init>", "()V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class FIXED extends ResizeMode {

        @NotNull
        public static final FIXED INSTANCE = new FIXED();

        private FIXED() {
            super("m_fixed", 0, 0, 0, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode$LFIT;", "Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode;", "<init>", "()V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class LFIT extends ResizeMode {

        @NotNull
        public static final LFIT INSTANCE = new LFIT();

        private LFIT() {
            super("m_lfit", 0, 0, 0, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode$MFIT;", "Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode;", "<init>", "()V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class MFIT extends ResizeMode {

        @NotNull
        public static final MFIT INSTANCE = new MFIT();

        private MFIT() {
            super("m_mfit", 0, 0, 0, 8, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode$PAD;", "Lcom/qiahao/nextvideo/utilities/alicloud/oss/ResizeMode;", "<init>", "()V", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static final class PAD extends ResizeMode {

        @NotNull
        public static final PAD INSTANCE = new PAD();

        private PAD() {
            super("m_pad", 0, 0, 0, 8, null);
        }
    }

    public /* synthetic */ ResizeMode(String str, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i3);
    }

    @Nullable
    public final String getCircleUrl(@Nullable String profilePictureUrl) {
        if (profilePictureUrl == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(profilePictureUrl);
        stringBuffer.append("?x-oss-process=image/resize");
        int i = this.width;
        if (i > 0) {
            stringBuffer.append(",w_" + i);
        }
        int i2 = this.height;
        if (i2 > 0) {
            stringBuffer.append(",h_" + i2 + ",");
        }
        if (this.height > 0) {
            stringBuffer.append(this.mode);
            stringBuffer.append("/format,png/rounded-corners,r_" + (this.height / 2));
        }
        return stringBuffer.toString();
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getLimit() {
        return this.limit;
    }

    @Nullable
    public final String getUrl(@Nullable String profilePictureUrl) {
        if (profilePictureUrl == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(profilePictureUrl);
        stringBuffer.append("?x-oss-process=image/resize,");
        stringBuffer.append(this.mode);
        int i = this.width;
        if (i > 0) {
            stringBuffer.append(",w_" + i);
        }
        int i2 = this.height;
        if (i2 > 0) {
            stringBuffer.append(",h_" + i2);
        }
        return stringBuffer.toString();
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    private ResizeMode(String str, int i, int i2, int i3) {
        this.mode = str;
        this.width = i;
        this.height = i2;
        this.limit = i3;
    }

    public /* synthetic */ ResizeMode(String str, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, (i4 & 8) != 0 ? 1 : i3, null);
    }
}
