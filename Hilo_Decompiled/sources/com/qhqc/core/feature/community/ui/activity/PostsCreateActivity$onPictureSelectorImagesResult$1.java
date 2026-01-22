package com.qhqc.core.feature.community.ui.activity;

import com.luck.picture.lib.entity.LocalMedia;
import com.qhqc.core.feature.bean.community.PostsCreateMediaBean;
import com.qhqc.core.feature.community.ui.adapter.PostsCreatePicAdapter;
import com.qhqc.core.feature.util.Md5Util;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.qhqc.core.feature.community.ui.activity.PostsCreateActivity$onPictureSelectorImagesResult$1", f = "PostsCreateActivity.kt", i = {}, l = {217, 238}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
final class PostsCreateActivity$onPictureSelectorImagesResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ArrayList<PostsCreateMediaBean> $list;
    final /* synthetic */ List<LocalMedia> $result;
    int label;
    final /* synthetic */ PostsCreateActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qhqc.core.feature.community.ui.activity.PostsCreateActivity$onPictureSelectorImagesResult$1$1", f = "PostsCreateActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nPostsCreateActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PostsCreateActivity.kt\ncom/qhqc/core/feature/community/ui/activity/PostsCreateActivity$onPictureSelectorImagesResult$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,265:1\n1863#2,2:266\n*S KotlinDebug\n*F\n+ 1 PostsCreateActivity.kt\ncom/qhqc/core/feature/community/ui/activity/PostsCreateActivity$onPictureSelectorImagesResult$1$1\n*L\n219#1:266,2\n*E\n"})
    /* renamed from: com.qhqc.core.feature.community.ui.activity.PostsCreateActivity$onPictureSelectorImagesResult$1$1, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<PostsCreateMediaBean> $list;
        final /* synthetic */ List<LocalMedia> $result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(List<LocalMedia> list, ArrayList<PostsCreateMediaBean> arrayList, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$result = list;
            this.$list = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$result, this.$list, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                try {
                    List<LocalMedia> list = this.$result;
                    ArrayList<PostsCreateMediaBean> arrayList = this.$list;
                    for (LocalMedia localMedia : list) {
                        String availablePath = localMedia.getAvailablePath();
                        int width = localMedia.getWidth();
                        int height = localMedia.getHeight();
                        long size = localMedia.getSize();
                        Md5Util md5Util = Md5Util.INSTANCE;
                        String availablePath2 = localMedia.getAvailablePath();
                        Intrinsics.checkNotNullExpressionValue(availablePath2, "getAvailablePath(...)");
                        arrayList.add(new PostsCreateMediaBean(0, availablePath, width, height, size, md5Util.getPathMD5(availablePath2), null, null, false, 449, null));
                    }
                    if (this.$list.size() < 9) {
                        this.$list.add(new PostsCreateMediaBean(0, null, 0, 0, 0L, null, null, null, true, KotlinVersion.MAX_COMPONENT_VALUE, null));
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.qhqc.core.feature.community.ui.activity.PostsCreateActivity$onPictureSelectorImagesResult$1$2", f = "PostsCreateActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.qhqc.core.feature.community.ui.activity.PostsCreateActivity$onPictureSelectorImagesResult$1$2, reason: invalid class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes3.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<PostsCreateMediaBean> $list;
        int label;
        final /* synthetic */ PostsCreateActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(PostsCreateActivity postsCreateActivity, ArrayList<PostsCreateMediaBean> arrayList, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = postsCreateActivity;
            this.$list = arrayList;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$list, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PostsCreatePicAdapter mPicAdapter;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                mPicAdapter = this.this$0.getMPicAdapter();
                mPicAdapter.setList(this.$list);
                this.this$0.checkSendBtn();
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostsCreateActivity$onPictureSelectorImagesResult$1(List<LocalMedia> list, ArrayList<PostsCreateMediaBean> arrayList, PostsCreateActivity postsCreateActivity, Continuation<? super PostsCreateActivity$onPictureSelectorImagesResult$1> continuation) {
        super(2, continuation);
        this.$result = list;
        this.$list = arrayList;
        this.this$0 = postsCreateActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PostsCreateActivity$onPictureSelectorImagesResult$1(this.$result, this.$list, this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            CoroutineDispatcher io2 = Dispatchers.getIO();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$result, this.$list, null);
            this.label = 1;
            if (BuildersKt.withContext(io2, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        MainCoroutineDispatcher main = Dispatchers.getMain();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, this.$list, null);
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PostsCreateActivity$onPictureSelectorImagesResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
