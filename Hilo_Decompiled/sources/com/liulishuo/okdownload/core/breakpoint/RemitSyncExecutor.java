package com.liulishuo.okdownload.core.breakpoint;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.liulishuo.okdownload.core.Util;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class RemitSyncExecutor implements Handler.Callback {
    private static final String TAG = "RemitSyncExecutor";
    static final int WHAT_REMOVE_FREE_BUNCH_ID = -1;
    static final int WHAT_REMOVE_FREE_ID = -2;
    static final int WHAT_REMOVE_INFO = -3;
    static final int WHAT_SYNC_BUNCH_ID = 0;
    private final RemitAgent agent;
    private final Set<Integer> freeToDBIdList;
    private final Handler handler;

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    interface RemitAgent {
        void removeInfo(int i10);

        void syncCacheToDB(int i10) throws IOException;

        void syncCacheToDB(List<Integer> list) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemitSyncExecutor(RemitAgent remitAgent) {
        this.agent = remitAgent;
        this.freeToDBIdList = new HashSet();
        HandlerThread handlerThread = new HandlerThread("OkDownload RemitHandoverToDB");
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), this);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != -3) {
            if (i10 != -2) {
                if (i10 != -1) {
                    if (i10 != 0) {
                        try {
                            this.agent.syncCacheToDB(i10);
                            this.freeToDBIdList.add(Integer.valueOf(i10));
                            Util.d(TAG, "sync info with id: " + i10);
                            return true;
                        } catch (IOException unused) {
                            Util.w(TAG, "sync cache to db failed for id: " + i10);
                            return true;
                        }
                    }
                    List<Integer> list = (List) message.obj;
                    try {
                        this.agent.syncCacheToDB(list);
                        this.freeToDBIdList.addAll(list);
                        Util.d(TAG, "sync bunch info with ids: " + list);
                        return true;
                    } catch (IOException unused2) {
                        Util.w(TAG, "sync info to db failed for ids: " + list);
                        return true;
                    }
                }
                List list2 = (List) message.obj;
                this.freeToDBIdList.removeAll(list2);
                Util.d(TAG, "remove free bunch ids " + list2);
                return true;
            }
            int i11 = message.arg1;
            this.freeToDBIdList.remove(Integer.valueOf(i11));
            Util.d(TAG, "remove free bunch id " + i11);
            return true;
        }
        int i12 = message.arg1;
        this.freeToDBIdList.remove(Integer.valueOf(i12));
        this.agent.removeInfo(i12);
        Util.d(TAG, "remove info " + i12);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFreeToDatabase(int i10) {
        return this.freeToDBIdList.contains(Integer.valueOf(i10));
    }

    public void postRemoveFreeId(int i10) {
        Message obtainMessage = this.handler.obtainMessage(-2);
        obtainMessage.arg1 = i10;
        this.handler.sendMessage(obtainMessage);
    }

    public void postRemoveFreeIds(List<Integer> list) {
        Message obtainMessage = this.handler.obtainMessage(-1);
        obtainMessage.obj = list;
        this.handler.sendMessage(obtainMessage);
    }

    public void postRemoveInfo(int i10) {
        Message obtainMessage = this.handler.obtainMessage(-3);
        obtainMessage.arg1 = i10;
        this.handler.sendMessage(obtainMessage);
    }

    public void postSync(int i10) {
        this.handler.sendEmptyMessage(i10);
    }

    public void postSyncInfoDelay(int i10, long j10) {
        this.handler.sendEmptyMessageDelayed(i10, j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removePostWithId(int i10) {
        this.handler.removeMessages(i10);
    }

    void removePostWithIds(int[] iArr) {
        for (int i10 : iArr) {
            this.handler.removeMessages(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void shutdown() {
        this.handler.getLooper().quit();
    }

    public void postSync(List<Integer> list) {
        Message obtainMessage = this.handler.obtainMessage(0);
        obtainMessage.obj = list;
        this.handler.sendMessage(obtainMessage);
    }

    RemitSyncExecutor(RemitAgent remitAgent, Handler handler, Set<Integer> set) {
        this.agent = remitAgent;
        this.handler = handler;
        this.freeToDBIdList = set;
    }
}
