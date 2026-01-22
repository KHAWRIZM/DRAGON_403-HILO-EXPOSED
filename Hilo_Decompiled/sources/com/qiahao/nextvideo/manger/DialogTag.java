package com.qiahao.nextvideo.manger;

import java.io.Serializable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0018B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0011\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0000H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/qiahao/nextvideo/manger/DialogTag;", "Ljava/io/Serializable;", "", "level", "", "clazz", "Ljava/lang/Class;", "<init>", "(ILjava/lang/Class;)V", "getLevel", "()I", "setLevel", "(I)V", "getClazz", "()Ljava/lang/Class;", "setClazz", "(Ljava/lang/Class;)V", "equals", "", "obj", "", "hashCode", "compareTo", "o", "Companion", "app_googleRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public final class DialogTag implements Serializable, Comparable<DialogTag> {
    public static final int CENTER_DIALOG = 2;
    public static final int HEIGHT_DIALOG = 3;
    public static final int LOW_DIALOG = 1;

    @NotNull
    private Class<?> clazz;
    private int level;

    public DialogTag(int i, @NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.level = i;
        this.clazz = cls;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DialogTag)) {
            return false;
        }
        DialogTag dialogTag = (DialogTag) obj;
        if (this.level == dialogTag.level && Intrinsics.areEqual(this.clazz.getName(), dialogTag.clazz.getName())) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Class<?> getClazz() {
        return this.clazz;
    }

    public final int getLevel() {
        return this.level;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.level), this.clazz.getName());
    }

    public final void setClazz(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<set-?>");
        this.clazz = cls;
    }

    public final void setLevel(int i) {
        this.level = i;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NotNull DialogTag o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return Integer.compare(this.level, o.level);
    }
}
