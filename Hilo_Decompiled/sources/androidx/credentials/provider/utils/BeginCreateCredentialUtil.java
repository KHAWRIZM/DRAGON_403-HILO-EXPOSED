package androidx.credentials.provider.utils;

import android.annotation.SuppressLint;
import android.app.slice.Slice;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.service.credentials.BeginCreateCredentialRequest;
import android.service.credentials.BeginCreateCredentialResponse;
import android.service.credentials.CallingAppInfo;
import androidx.annotation.RequiresApi;
import androidx.credentials.PasswordCredential;
import androidx.credentials.PublicKeyCredential;
import androidx.credentials.internal.FrameworkClassParsingException;
import androidx.credentials.provider.BeginCreateCustomCredentialRequest;
import androidx.credentials.provider.BeginCreatePasswordCredentialRequest;
import androidx.credentials.provider.BeginCreatePublicKeyCredentialRequest;
import androidx.credentials.provider.CreateEntry;
import androidx.credentials.provider.RemoteEntry;
import androidx.credentials.provider.utils.BeginCreateCredentialUtil;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(34)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/credentials/provider/utils/BeginCreateCredentialUtil;", "", "()V", "Companion", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class BeginCreateCredentialUtil {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\fJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\bJ\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0002J\u001a\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0003¨\u0006\u0019"}, d2 = {"Landroidx/credentials/provider/utils/BeginCreateCredentialUtil$Companion;", "", "()V", "convertToFrameworkRequest", "Landroid/service/credentials/BeginCreateCredentialRequest;", "request", "Landroidx/credentials/provider/BeginCreateCredentialRequest;", "convertToFrameworkResponse", "Landroid/service/credentials/BeginCreateCredentialResponse;", "response", "Landroidx/credentials/provider/BeginCreateCredentialResponse;", "convertToJetpackRequest", "convertToJetpackRequest$credentials_release", "convertToJetpackResponse", "frameworkResponse", "populateCreateEntries", "", "frameworkBuilder", "Landroid/service/credentials/BeginCreateCredentialResponse$Builder;", "createEntries", "", "Landroidx/credentials/provider/CreateEntry;", "populateRemoteEntry", "remoteEntry", "Landroidx/credentials/provider/RemoteEntry;", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nBeginCreateCredentialUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BeginCreateCredentialUtil.kt\nandroidx/credentials/provider/utils/BeginCreateCredentialUtil$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,154:1\n1855#2,2:155\n1#3:157\n*S KotlinDebug\n*F\n+ 1 BeginCreateCredentialUtil.kt\nandroidx/credentials/provider/utils/BeginCreateCredentialUtil$Companion\n*L\n108#1:155,2\n*E\n"})
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CreateEntry convertToJetpackResponse$lambda$5(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (CreateEntry) tmp0.invoke(obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean convertToJetpackResponse$lambda$6(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return ((Boolean) tmp0.invoke(obj)).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CreateEntry convertToJetpackResponse$lambda$7(Function1 tmp0, Object obj) {
            Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
            return (CreateEntry) tmp0.invoke(obj);
        }

        private final void populateCreateEntries(BeginCreateCredentialResponse.Builder frameworkBuilder, List<CreateEntry> createEntries) {
            Iterator<T> it = createEntries.iterator();
            while (it.hasNext()) {
                Slice slice = CreateEntry.INSTANCE.toSlice((CreateEntry) it.next());
                if (slice != null) {
                    frameworkBuilder.addCreateEntry(h.a(slice));
                }
            }
        }

        @SuppressLint({"MissingPermission"})
        private final void populateRemoteEntry(BeginCreateCredentialResponse.Builder frameworkBuilder, RemoteEntry remoteEntry) {
            if (remoteEntry == null) {
                return;
            }
            c.a();
            frameworkBuilder.setRemoteCreateEntry(b.a(RemoteEntry.INSTANCE.toSlice(remoteEntry)));
        }

        @NotNull
        public final BeginCreateCredentialRequest convertToFrameworkRequest(@NotNull androidx.credentials.provider.BeginCreateCredentialRequest request) {
            CallingAppInfo callingAppInfo;
            Intrinsics.checkNotNullParameter(request, "request");
            if (request.getCallingAppInfo() != null) {
                f.a();
                callingAppInfo = d.a(request.getCallingAppInfo().getPackageName(), request.getCallingAppInfo().getSigningInfo(), request.getCallingAppInfo().getOrigin());
            } else {
                callingAppInfo = null;
            }
            g.a();
            return e.a(request.getType(), request.getCandidateQueryData(), callingAppInfo);
        }

        @NotNull
        public final BeginCreateCredentialResponse convertToFrameworkResponse(@NotNull androidx.credentials.provider.BeginCreateCredentialResponse response) {
            BeginCreateCredentialResponse build;
            Intrinsics.checkNotNullParameter(response, "response");
            BeginCreateCredentialResponse.Builder a10 = i.a();
            populateCreateEntries(a10, response.getCreateEntries());
            populateRemoteEntry(a10, response.getRemoteEntry());
            build = a10.build();
            Intrinsics.checkNotNullExpressionValue(build, "frameworkBuilder.build()");
            return build;
        }

        @JvmStatic
        @NotNull
        public final androidx.credentials.provider.BeginCreateCredentialRequest convertToJetpackRequest$credentials_release(@NotNull BeginCreateCredentialRequest request) {
            String type;
            Bundle data;
            CallingAppInfo callingAppInfo;
            String packageName;
            SigningInfo signingInfo;
            String origin;
            String type2;
            Bundle data2;
            CallingAppInfo callingAppInfo2;
            androidx.credentials.provider.CallingAppInfo callingAppInfo3;
            String packageName2;
            SigningInfo signingInfo2;
            String origin2;
            String type3;
            Bundle data3;
            CallingAppInfo callingAppInfo4;
            androidx.credentials.provider.CallingAppInfo callingAppInfo5;
            String packageName3;
            SigningInfo signingInfo3;
            String origin3;
            Bundle data4;
            CallingAppInfo callingAppInfo6;
            androidx.credentials.provider.CallingAppInfo callingAppInfo7;
            String packageName4;
            SigningInfo signingInfo4;
            String origin4;
            Intrinsics.checkNotNullParameter(request, "request");
            androidx.credentials.provider.CallingAppInfo callingAppInfo8 = null;
            try {
                type2 = request.getType();
                int hashCode = type2.hashCode();
                if (hashCode != -543568185) {
                    if (hashCode == -95037569 && type2.equals(PublicKeyCredential.TYPE_PUBLIC_KEY_CREDENTIAL)) {
                        BeginCreatePublicKeyCredentialRequest.Companion companion = BeginCreatePublicKeyCredentialRequest.INSTANCE;
                        data4 = request.getData();
                        Intrinsics.checkNotNullExpressionValue(data4, "request.data");
                        callingAppInfo6 = request.getCallingAppInfo();
                        if (callingAppInfo6 != null) {
                            packageName4 = callingAppInfo6.getPackageName();
                            Intrinsics.checkNotNullExpressionValue(packageName4, "it.packageName");
                            signingInfo4 = callingAppInfo6.getSigningInfo();
                            Intrinsics.checkNotNullExpressionValue(signingInfo4, "it.signingInfo");
                            origin4 = callingAppInfo6.getOrigin();
                            callingAppInfo7 = new androidx.credentials.provider.CallingAppInfo(packageName4, signingInfo4, origin4);
                        } else {
                            callingAppInfo7 = null;
                        }
                        return companion.createFrom$credentials_release(data4, callingAppInfo7);
                    }
                } else if (type2.equals(PasswordCredential.TYPE_PASSWORD_CREDENTIAL)) {
                    BeginCreatePasswordCredentialRequest.Companion companion2 = BeginCreatePasswordCredentialRequest.INSTANCE;
                    data2 = request.getData();
                    Intrinsics.checkNotNullExpressionValue(data2, "request.data");
                    callingAppInfo2 = request.getCallingAppInfo();
                    if (callingAppInfo2 != null) {
                        packageName2 = callingAppInfo2.getPackageName();
                        Intrinsics.checkNotNullExpressionValue(packageName2, "it.packageName");
                        signingInfo2 = callingAppInfo2.getSigningInfo();
                        Intrinsics.checkNotNullExpressionValue(signingInfo2, "it.signingInfo");
                        origin2 = callingAppInfo2.getOrigin();
                        callingAppInfo3 = new androidx.credentials.provider.CallingAppInfo(packageName2, signingInfo2, origin2);
                    } else {
                        callingAppInfo3 = null;
                    }
                    return companion2.createFrom$credentials_release(data2, callingAppInfo3);
                }
                type3 = request.getType();
                Intrinsics.checkNotNullExpressionValue(type3, "request.type");
                data3 = request.getData();
                Intrinsics.checkNotNullExpressionValue(data3, "request.data");
                callingAppInfo4 = request.getCallingAppInfo();
                if (callingAppInfo4 != null) {
                    packageName3 = callingAppInfo4.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName3, "it.packageName");
                    signingInfo3 = callingAppInfo4.getSigningInfo();
                    Intrinsics.checkNotNullExpressionValue(signingInfo3, "it.signingInfo");
                    origin3 = callingAppInfo4.getOrigin();
                    callingAppInfo5 = new androidx.credentials.provider.CallingAppInfo(packageName3, signingInfo3, origin3);
                } else {
                    callingAppInfo5 = null;
                }
                return new BeginCreateCustomCredentialRequest(type3, data3, callingAppInfo5);
            } catch (FrameworkClassParsingException unused) {
                type = request.getType();
                Intrinsics.checkNotNullExpressionValue(type, "request.type");
                data = request.getData();
                Intrinsics.checkNotNullExpressionValue(data, "request.data");
                callingAppInfo = request.getCallingAppInfo();
                if (callingAppInfo != null) {
                    packageName = callingAppInfo.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageName, "it.packageName");
                    signingInfo = callingAppInfo.getSigningInfo();
                    Intrinsics.checkNotNullExpressionValue(signingInfo, "it.signingInfo");
                    origin = callingAppInfo.getOrigin();
                    callingAppInfo8 = new androidx.credentials.provider.CallingAppInfo(packageName, signingInfo, origin);
                }
                return new BeginCreateCustomCredentialRequest(type, data, callingAppInfo8);
            }
        }

        @NotNull
        public final androidx.credentials.provider.BeginCreateCredentialResponse convertToJetpackResponse(@NotNull BeginCreateCredentialResponse frameworkResponse) {
            List createEntries;
            Stream stream;
            Stream map;
            Stream filter;
            Stream map2;
            Collector list;
            Object collect;
            android.service.credentials.RemoteEntry remoteCreateEntry;
            RemoteEntry remoteEntry;
            Slice slice;
            Intrinsics.checkNotNullParameter(frameworkResponse, "frameworkResponse");
            createEntries = frameworkResponse.getCreateEntries();
            stream = createEntries.stream();
            final BeginCreateCredentialUtil$Companion$convertToJetpackResponse$1 beginCreateCredentialUtil$Companion$convertToJetpackResponse$1 = new Function1<android.service.credentials.CreateEntry, CreateEntry>() { // from class: androidx.credentials.provider.utils.BeginCreateCredentialUtil$Companion$convertToJetpackResponse$1
                @Nullable
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final CreateEntry invoke2(android.service.credentials.CreateEntry createEntry) {
                    Slice slice2;
                    CreateEntry.Companion companion = CreateEntry.INSTANCE;
                    slice2 = createEntry.getSlice();
                    Intrinsics.checkNotNullExpressionValue(slice2, "entry.slice");
                    return companion.fromSlice(slice2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ CreateEntry invoke(android.service.credentials.CreateEntry createEntry) {
                    return invoke2(w.a(createEntry));
                }
            };
            map = stream.map(new Function() { // from class: androidx.credentials.provider.utils.s
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    CreateEntry convertToJetpackResponse$lambda$5;
                    convertToJetpackResponse$lambda$5 = BeginCreateCredentialUtil.Companion.convertToJetpackResponse$lambda$5(Function1.this, obj);
                    return convertToJetpackResponse$lambda$5;
                }
            });
            final BeginCreateCredentialUtil$Companion$convertToJetpackResponse$2 beginCreateCredentialUtil$Companion$convertToJetpackResponse$2 = new Function1<CreateEntry, Boolean>() { // from class: androidx.credentials.provider.utils.BeginCreateCredentialUtil$Companion$convertToJetpackResponse$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@Nullable CreateEntry createEntry) {
                    return Boolean.valueOf(createEntry != null);
                }
            };
            filter = map.filter(new Predicate() { // from class: androidx.credentials.provider.utils.t
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean convertToJetpackResponse$lambda$6;
                    convertToJetpackResponse$lambda$6 = BeginCreateCredentialUtil.Companion.convertToJetpackResponse$lambda$6(Function1.this, obj);
                    return convertToJetpackResponse$lambda$6;
                }
            });
            final BeginCreateCredentialUtil$Companion$convertToJetpackResponse$3 beginCreateCredentialUtil$Companion$convertToJetpackResponse$3 = new Function1<CreateEntry, CreateEntry>() { // from class: androidx.credentials.provider.utils.BeginCreateCredentialUtil$Companion$convertToJetpackResponse$3
                @Override // kotlin.jvm.functions.Function1
                public final CreateEntry invoke(@Nullable CreateEntry createEntry) {
                    Intrinsics.checkNotNull(createEntry);
                    return createEntry;
                }
            };
            map2 = filter.map(new Function() { // from class: androidx.credentials.provider.utils.u
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    CreateEntry convertToJetpackResponse$lambda$7;
                    convertToJetpackResponse$lambda$7 = BeginCreateCredentialUtil.Companion.convertToJetpackResponse$lambda$7(Function1.this, obj);
                    return convertToJetpackResponse$lambda$7;
                }
            });
            list = Collectors.toList();
            collect = map2.collect(list);
            Intrinsics.checkNotNullExpressionValue(collect, "frameworkResponse.create…lect(Collectors.toList())");
            List list2 = (List) collect;
            remoteCreateEntry = frameworkResponse.getRemoteCreateEntry();
            if (remoteCreateEntry != null) {
                RemoteEntry.Companion companion = RemoteEntry.INSTANCE;
                slice = remoteCreateEntry.getSlice();
                Intrinsics.checkNotNullExpressionValue(slice, "it.slice");
                remoteEntry = companion.fromSlice(slice);
            } else {
                remoteEntry = null;
            }
            return new androidx.credentials.provider.BeginCreateCredentialResponse(list2, remoteEntry);
        }

        private Companion() {
        }
    }
}
