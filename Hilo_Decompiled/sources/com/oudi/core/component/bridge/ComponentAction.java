package com.oudi.core.component.bridge;

import android.app.Activity;
import android.app.Dialog;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"Lcom/oudi/core/component/bridge/ComponentAction;", "", "<init>", "()V", "ShowLoading", "DismissLoading", "BuildDialog", "Toast", "Jump", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class ComponentAction {

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B.\u0012%\u0010\u0002\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003¢\u0006\u0004\b\t\u0010\nR0\u0010\u0002\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/oudi/core/component/bridge/ComponentAction$BuildDialog;", "Lcom/oudi/core/component/bridge/ComponentAction;", "build", "Lkotlin/Function1;", "Landroid/app/Activity;", "Lkotlin/ParameterName;", "name", "activity", "Landroid/app/Dialog;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "getBuild", "()Lkotlin/jvm/functions/Function1;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class BuildDialog extends ComponentAction {

        @NotNull
        private final Function1<Activity, Dialog> build;

        /* JADX WARN: Multi-variable type inference failed */
        public BuildDialog(@NotNull Function1<? super Activity, ? extends Dialog> build) {
            Intrinsics.checkNotNullParameter(build, "build");
            this.build = build;
        }

        @NotNull
        public final Function1<Activity, Dialog> getBuild() {
            return this.build;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/oudi/core/component/bridge/ComponentAction$DismissLoading;", "Lcom/oudi/core/component/bridge/ComponentAction;", "id", "", "<init>", "(Ljava/lang/Integer;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class DismissLoading extends ComponentAction {

        @Nullable
        private final Integer id;

        /* JADX WARN: Multi-variable type inference failed */
        public DismissLoading() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        public DismissLoading(@Nullable Integer num) {
            this.id = num;
        }

        public /* synthetic */ DismissLoading(Integer num, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? null : num);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/oudi/core/component/bridge/ComponentAction$Jump;", "Lcom/oudi/core/component/bridge/ComponentAction;", "path", "", ViewHierarchyConstants.TAG_KEY, "", "<init>", "(Ljava/lang/String;Ljava/lang/Object;)V", "getPath", "()Ljava/lang/String;", "getTag", "()Ljava/lang/Object;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Jump extends ComponentAction {

        @NotNull
        private final String path;

        @Nullable
        private final Object tag;

        public Jump(@NotNull String path, @Nullable Object obj) {
            Intrinsics.checkNotNullParameter(path, "path");
            this.path = path;
            this.tag = obj;
        }

        @NotNull
        public final String getPath() {
            return this.path;
        }

        @Nullable
        public final Object getTag() {
            return this.tag;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/oudi/core/component/bridge/ComponentAction$ShowLoading;", "Lcom/oudi/core/component/bridge/ComponentAction;", "id", "", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "<init>", "(Ljava/lang/Integer;Ljava/lang/CharSequence;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/CharSequence;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class ShowLoading extends ComponentAction {

        @Nullable
        private final Integer id;

        @Nullable
        private final CharSequence message;

        /* JADX WARN: Multi-variable type inference failed */
        public ShowLoading() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        @Nullable
        public final Integer getId() {
            return this.id;
        }

        @Nullable
        public final CharSequence getMessage() {
            return this.message;
        }

        public ShowLoading(@Nullable Integer num, @Nullable CharSequence charSequence) {
            this.id = num;
            this.message = charSequence;
        }

        public /* synthetic */ ShowLoading(Integer num, CharSequence charSequence, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? null : num, (i10 & 2) != 0 ? null : charSequence);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/oudi/core/component/bridge/ComponentAction$Toast;", "Lcom/oudi/core/component/bridge/ComponentAction;", ShareConstants.WEB_DIALOG_PARAM_MESSAGE, "", "<init>", "(Ljava/lang/CharSequence;)V", "getMessage", "()Ljava/lang/CharSequence;", "lib_core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public static final class Toast extends ComponentAction {

        @Nullable
        private final CharSequence message;

        public Toast(@Nullable CharSequence charSequence) {
            this.message = charSequence;
        }

        @Nullable
        public final CharSequence getMessage() {
            return this.message;
        }
    }
}
