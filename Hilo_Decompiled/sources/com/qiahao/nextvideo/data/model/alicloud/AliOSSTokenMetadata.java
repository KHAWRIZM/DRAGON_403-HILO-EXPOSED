package com.qiahao.nextvideo.data.model.alicloud;

import com.qiahao.base_common.utils.g;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.c;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0003J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003JE\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006$"}, d2 = {"Lcom/qiahao/nextvideo/data/model/alicloud/AliOSSTokenMetadata;", "", "accessKeyId", "", "bucket", "securityToken", "endPoint", "accessKeySecret", "expiration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessKeyId", "()Ljava/lang/String;", "getBucket", "getSecurityToken", "getEndPoint", "getAccessKeySecret", "getExpiration", "getDecryptedAccessKeyId", "getDecryptedBucket", "getDecryptedSecurityToken", "getDecryptedEndPoint", "getDecryptedAccessKeySecret", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final /* data */ class AliOSSTokenMetadata {

    @NotNull
    @c("accessKeyId")
    private final String accessKeyId;

    @NotNull
    @c("accessKeySecret")
    private final String accessKeySecret;

    @NotNull
    @c("bucket")
    private final String bucket;

    @NotNull
    @c("endPoint")
    private final String endPoint;

    @NotNull
    @c("expiration")
    private final String expiration;

    @NotNull
    @c("securityToken")
    private final String securityToken;

    public AliOSSTokenMetadata() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ AliOSSTokenMetadata copy$default(AliOSSTokenMetadata aliOSSTokenMetadata, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = aliOSSTokenMetadata.accessKeyId;
        }
        if ((i & 2) != 0) {
            str2 = aliOSSTokenMetadata.bucket;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = aliOSSTokenMetadata.securityToken;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = aliOSSTokenMetadata.endPoint;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = aliOSSTokenMetadata.accessKeySecret;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = aliOSSTokenMetadata.expiration;
        }
        return aliOSSTokenMetadata.copy(str, str7, str8, str9, str10, str6);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getBucket() {
        return this.bucket;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getSecurityToken() {
        return this.securityToken;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final String getEndPoint() {
        return this.endPoint;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    @NotNull
    /* renamed from: component6, reason: from getter */
    public final String getExpiration() {
        return this.expiration;
    }

    @NotNull
    public final AliOSSTokenMetadata copy(@NotNull String accessKeyId, @NotNull String bucket, @NotNull String securityToken, @NotNull String endPoint, @NotNull String accessKeySecret, @NotNull String expiration) {
        Intrinsics.checkNotNullParameter(accessKeyId, "accessKeyId");
        Intrinsics.checkNotNullParameter(bucket, "bucket");
        Intrinsics.checkNotNullParameter(securityToken, "securityToken");
        Intrinsics.checkNotNullParameter(endPoint, "endPoint");
        Intrinsics.checkNotNullParameter(accessKeySecret, "accessKeySecret");
        Intrinsics.checkNotNullParameter(expiration, "expiration");
        return new AliOSSTokenMetadata(accessKeyId, bucket, securityToken, endPoint, accessKeySecret, expiration);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AliOSSTokenMetadata)) {
            return false;
        }
        AliOSSTokenMetadata aliOSSTokenMetadata = (AliOSSTokenMetadata) other;
        return Intrinsics.areEqual(this.accessKeyId, aliOSSTokenMetadata.accessKeyId) && Intrinsics.areEqual(this.bucket, aliOSSTokenMetadata.bucket) && Intrinsics.areEqual(this.securityToken, aliOSSTokenMetadata.securityToken) && Intrinsics.areEqual(this.endPoint, aliOSSTokenMetadata.endPoint) && Intrinsics.areEqual(this.accessKeySecret, aliOSSTokenMetadata.accessKeySecret) && Intrinsics.areEqual(this.expiration, aliOSSTokenMetadata.expiration);
    }

    @NotNull
    public final String getAccessKeyId() {
        return this.accessKeyId;
    }

    @NotNull
    public final String getAccessKeySecret() {
        return this.accessKeySecret;
    }

    @NotNull
    public final String getBucket() {
        return this.bucket;
    }

    @NotNull
    public final String getDecryptedAccessKeyId() {
        String c = g.c(this.accessKeyId, "484194d4d0f968a7", "484194d4d0f968a7");
        Intrinsics.checkNotNullExpressionValue(c, "decrypt(...)");
        return c;
    }

    @NotNull
    public final String getDecryptedAccessKeySecret() {
        String c = g.c(this.accessKeySecret, "484194d4d0f968a7", "484194d4d0f968a7");
        Intrinsics.checkNotNullExpressionValue(c, "decrypt(...)");
        return c;
    }

    @NotNull
    public final String getDecryptedBucket() {
        String c = g.c(this.bucket, "484194d4d0f968a7", "484194d4d0f968a7");
        Intrinsics.checkNotNullExpressionValue(c, "decrypt(...)");
        return c;
    }

    @NotNull
    public final String getDecryptedEndPoint() {
        String c = g.c(this.endPoint, "484194d4d0f968a7", "484194d4d0f968a7");
        Intrinsics.checkNotNullExpressionValue(c, "decrypt(...)");
        return c;
    }

    @NotNull
    public final String getDecryptedSecurityToken() {
        String c = g.c(this.securityToken, "484194d4d0f968a7", "484194d4d0f968a7");
        Intrinsics.checkNotNullExpressionValue(c, "decrypt(...)");
        return c;
    }

    @NotNull
    public final String getEndPoint() {
        return this.endPoint;
    }

    @NotNull
    public final String getExpiration() {
        return this.expiration;
    }

    @NotNull
    public final String getSecurityToken() {
        return this.securityToken;
    }

    public int hashCode() {
        return (((((((((this.accessKeyId.hashCode() * 31) + this.bucket.hashCode()) * 31) + this.securityToken.hashCode()) * 31) + this.endPoint.hashCode()) * 31) + this.accessKeySecret.hashCode()) * 31) + this.expiration.hashCode();
    }

    @NotNull
    public String toString() {
        return "ak: " + getDecryptedAccessKeyId() + "\nsk: " + getDecryptedAccessKeySecret() + "\nst: " + getDecryptedSecurityToken() + "\nbucket: " + getDecryptedBucket() + "\nendPoint: " + getDecryptedEndPoint() + "\nexpiration: " + this.expiration;
    }

    public AliOSSTokenMetadata(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "accessKeyId");
        Intrinsics.checkNotNullParameter(str2, "bucket");
        Intrinsics.checkNotNullParameter(str3, "securityToken");
        Intrinsics.checkNotNullParameter(str4, "endPoint");
        Intrinsics.checkNotNullParameter(str5, "accessKeySecret");
        Intrinsics.checkNotNullParameter(str6, "expiration");
        this.accessKeyId = str;
        this.bucket = str2;
        this.securityToken = str3;
        this.endPoint = str4;
        this.accessKeySecret = str5;
        this.expiration = str6;
    }

    public /* synthetic */ AliOSSTokenMetadata(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6);
    }
}
