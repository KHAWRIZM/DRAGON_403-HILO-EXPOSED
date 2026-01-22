package com.therouter.router;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.android.agoo.common.AgooConstants;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0019\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001a\u0010\f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001a\u0010\t\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u000f\"\u0004\b#\u0010\u0011¨\u0006$"}, d2 = {"Lcom/therouter/router/AutowiredItem;", "", "type", "", "key", AgooConstants.MESSAGE_ID, "", "args", "className", "fieldName", "required", "", "description", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getArgs", "()Ljava/lang/String;", "setArgs", "(Ljava/lang/String;)V", "getClassName", "setClassName", "getDescription", "setDescription", "getFieldName", "setFieldName", "getId", "()I", "setId", "(I)V", "getKey", "setKey", "getRequired", "()Z", "setRequired", "(Z)V", "getType", "setType", "router_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes5.dex */
public final class AutowiredItem {

    @NotNull
    private String args;

    @NotNull
    private String className;

    @NotNull
    private String description;

    @NotNull
    private String fieldName;
    private int id;

    @NotNull
    private String key;
    private boolean required;

    @NotNull
    private String type;

    public AutowiredItem(@NotNull String str, @NotNull String str2, int i, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "key");
        Intrinsics.checkNotNullParameter(str3, "args");
        Intrinsics.checkNotNullParameter(str4, "className");
        Intrinsics.checkNotNullParameter(str5, "fieldName");
        Intrinsics.checkNotNullParameter(str6, "description");
        this.type = str;
        this.key = str2;
        this.id = i;
        this.args = str3;
        this.className = str4;
        this.fieldName = str5;
        this.required = z;
        this.description = str6;
    }

    @NotNull
    public final String getArgs() {
        return this.args;
    }

    @NotNull
    public final String getClassName() {
        return this.className;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getFieldName() {
        return this.fieldName;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public final boolean getRequired() {
        return this.required;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public final void setArgs(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.args = str;
    }

    public final void setClassName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.className = str;
    }

    public final void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void setFieldName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.fieldName = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setKey(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.key = str;
    }

    public final void setRequired(boolean z) {
        this.required = z;
    }

    public final void setType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }
}
