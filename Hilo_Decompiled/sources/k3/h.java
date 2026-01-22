package k3;

import android.text.TextUtils;
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
public final class h extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public MediaDetailActivity f١٥٤٩١a;

    /* renamed from: b, reason: collision with root package name */
    public int f١٥٤٩٢b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MediaDetailActivity f١٥٤٩٣c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(MediaDetailActivity mediaDetailActivity, Continuation continuation) {
        super(2, continuation);
        this.f١٥٤٩٣c = mediaDetailActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new h(this.f١٥٤٩٣c, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return new h(this.f١٥٤٩٣c, (Continuation) obj2).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MediaDetailActivity mediaDetailActivity;
        DownloadFileDao downloadFileDao;
        String str;
        String str2;
        String str3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = this.f١٥٤٩٢b;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mediaDetailActivity = this.f١٥٤٩١a;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            mediaDetailActivity = this.f١٥٤٩٣c;
            downloadFileDao = mediaDetailActivity.getDownloadFileDao();
            str = this.f١٥٤٩٣c.mUrl;
            this.f١٥٤٩١a = mediaDetailActivity;
            this.f١٥٤٩٢b = 1;
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
        str3 = this.f١٥٤٩٣c.downloadPath;
        if (!TextUtils.isEmpty(str3)) {
            this.f١٥٤٩٣c.isShowingOriginal = true;
        }
        MainCoroutineDispatcher main = Dispatchers.getMain();
        g gVar = new g(this.f١٥٤٩٣c, null);
        this.f١٥٤٩١a = null;
        this.f١٥٤٩٢b = 2;
        if (BuildersKt.withContext(main, gVar, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
