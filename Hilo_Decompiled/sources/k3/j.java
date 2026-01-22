package k3;

import com.qiahao.base_common.room.roomDao.DownloadFileDao;
import com.qiahao.base_common.room.roomModel.DownloadFile;
import com.qiahao.hilo_message.activity.MediaDetailActivity;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public final class j extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public MediaDetailActivity f١٥٤٩٥a;

    /* renamed from: b, reason: collision with root package name */
    public int f١٥٤٩٦b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MediaDetailActivity f١٥٤٩٧c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(MediaDetailActivity mediaDetailActivity, Continuation continuation) {
        super(2, continuation);
        this.f١٥٤٩٧c = mediaDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new j(this.f١٥٤٩٧c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new j(this.f١٥٤٩٧c, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MediaDetailActivity mediaDetailActivity;
        DownloadFileDao downloadFileDao;
        String str;
        String str2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.f١٥٤٩٦b;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mediaDetailActivity = this.f١٥٤٩٥a;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            mediaDetailActivity = this.f١٥٤٩٧c;
            downloadFileDao = mediaDetailActivity.getDownloadFileDao();
            str = this.f١٥٤٩٧c.videoUrl;
            if (str == null) {
                str = "";
            }
            this.f١٥٤٩٥a = mediaDetailActivity;
            this.f١٥٤٩٦b = 1;
            obj = downloadFileDao.getDownloadFileByUrl(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        DownloadFile downloadFile = (DownloadFile) obj;
        if (downloadFile != null) {
            str2 = downloadFile.getLocalPath();
        } else {
            str2 = null;
        }
        mediaDetailActivity.downloadPath = str2;
        this.f١٥٤٩٧c.isShowingOriginal = true;
        MainCoroutineDispatcher main = Dispatchers.getMain();
        i iVar = new i(this.f١٥٤٩٧c, null);
        this.f١٥٤٩٥a = null;
        this.f١٥٤٩٦b = 2;
        if (BuildersKt.withContext(main, iVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
