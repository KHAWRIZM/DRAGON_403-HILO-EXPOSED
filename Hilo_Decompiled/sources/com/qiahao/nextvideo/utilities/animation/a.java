package com.qiahao.nextvideo.utilities.animation;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.trtc.hardwareearmonitor.honor.HonorResultCode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
public abstract class a implements ImmViewDispatcher {
    protected List<com.qiahao.nextvideo.utilities.animation.a.b> addedViewHolderList;
    private Context context;
    private final List<com.qiahao.nextvideo.utilities.animation.a.b> emptyViewHolderList;
    private final HandlerC٠٠٠٣a handler;
    private ViewGroup layout;
    protected QueueModel<Object> queueModel;
    protected int sumNumber;
    public boolean isBinding = false;
    private int DELAY_TIME = HonorResultCode.AUDIO_PLAY_SERVICE_SUCCESS;
    private boolean isDelayFix = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.qiahao.nextvideo.utilities.animation.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public static class HandlerC٠٠٠٣a extends Handler {
        private final WeakReference a;

        public HandlerC٠٠٠٣a(a aVar) {
            this.a = new WeakReference(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (this.a.get() == null) {
                return;
            }
            if (message.what != 0) {
                ((a) this.a.get()).f(message);
            } else {
                ((a) this.a.get()).c(message);
            }
        }
    }

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes4.dex */
    public abstract class b {
        protected View itemView;
        int tag;
        Object value;

        public b(View view) {
            this.itemView = view;
        }

        public abstract void bindView(Object obj, boolean z);

        public int getTag() {
            return this.tag;
        }

        public Object getValue() {
            return this.value;
        }

        public void setTag(int i) {
            this.tag = i;
        }

        public void setValue(Object obj, boolean z) {
            this.value = obj;
            bindView(obj, z);
        }
    }

    public a(Context context, int i) {
        HandlerC٠٠٠٣a r1 = new HandlerC٠٠٠٣a(this);
        this.handler = r1;
        this.sumNumber = i;
        this.context = context;
        this.addedViewHolderList = new ArrayList(i);
        this.emptyViewHolderList = new ArrayList(i);
        QueueModel<Object> queueModel = new QueueModel<>();
        this.queueModel = queueModel;
        queueModel.setHandler(r1);
        for (int i2 = 0; i2 < i; i2++) {
            this.queueModel.takeValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        Object obj = message.obj;
        if (this.isBinding) {
            d(obj);
        } else {
            this.queueModel.takeValue();
        }
    }

    private void d(Object obj) {
        Iterator<com.qiahao.nextvideo.utilities.animation.a.b> it = this.addedViewHolderList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (isSameView(bVar.value, obj)) {
                bVar.setValue(obj, true);
                e(bVar);
                return;
            }
        }
        if (!this.emptyViewHolderList.isEmpty()) {
            b bVar2 = this.emptyViewHolderList.get(0);
            add(bVar2);
            bVar2.setValue(obj, false);
        }
    }

    private void e(b bVar) {
        bVar.itemView.invalidate();
        this.queueModel.takeValue();
        resetTiming(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Message message) {
        b bVar = (b) message.obj;
        g(bVar);
        h(bVar);
        this.queueModel.takeValue();
    }

    private void g(b bVar) {
        ViewGroup viewGroup = this.layout;
        if (viewGroup != null) {
            viewGroup.removeView(bVar.itemView);
        }
        this.emptyViewHolderList.add(bVar);
        this.addedViewHolderList.remove(bVar);
        if (this.queueModel.getQueue().isEmpty()) {
            emptyQueue();
        }
    }

    private void h(b bVar) {
        this.handler.removeMessages(bVar.tag);
    }

    private void i(b bVar) {
        if (this.isDelayFix) {
            Message message = new Message();
            message.what = bVar.tag;
            message.obj = bVar;
            this.handler.sendMessageDelayed(message, this.DELAY_TIME);
        }
    }

    protected void add(com.qiahao.nextvideo.utilities.animation.a.b bVar) {
        if (this.layout != null && bVar.itemView.getParent() == null) {
            this.layout.addView(bVar.itemView);
        }
        this.addedViewHolderList.add(bVar);
        this.emptyViewHolderList.remove(bVar);
        i(bVar);
    }

    @Override // com.qiahao.nextvideo.utilities.animation.ImmViewDispatcher
    public void bind(Context context, ViewGroup viewGroup) {
        if (this.isBinding) {
            return;
        }
        this.context = context;
        this.layout = viewGroup;
        this.addedViewHolderList.clear();
        this.emptyViewHolderList.clear();
        int i = 0;
        while (i < this.sumNumber) {
            com.qiahao.nextvideo.utilities.animation.a.b createViewHolder = createViewHolder(viewGroup);
            i++;
            createViewHolder.setTag(i);
            this.emptyViewHolderList.add(createViewHolder);
        }
        this.isBinding = true;
    }

    public void clear() {
        this.emptyViewHolderList.clear();
        this.addedViewHolderList.clear();
        this.queueModel.clear();
        this.queueModel.getQueue().clear();
    }

    public void clearHandlerMessage() {
        if (this.handler != null) {
            for (int i = 0; i <= this.sumNumber + 1; i++) {
                this.handler.removeMessages(i);
            }
        }
    }

    public void clearQueue() {
        this.emptyViewHolderList.clear();
        this.addedViewHolderList.clear();
        this.queueModel.getQueue().clear();
    }

    public abstract b createViewHolder(ViewGroup viewGroup);

    public void emptyQueue() {
    }

    public Context getContext() {
        return this.context;
    }

    public QueueModel<Object> getQueueModel() {
        return this.queueModel;
    }

    protected abstract boolean isSameView(Object obj, Object obj2);

    protected void notifyRemoveView(com.qiahao.nextvideo.utilities.animation.a.b bVar) {
        Message message = new Message();
        message.what = bVar.tag;
        message.obj = bVar;
        this.handler.sendMessage(message);
    }

    public void offer(Object obj) {
        if (this.isBinding && obj != null) {
            this.queueModel.offer(obj);
        }
    }

    protected void resetTiming(com.qiahao.nextvideo.utilities.animation.a.b bVar) {
        h(bVar);
        i(bVar);
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setDELAY_TIME(int i) {
        this.DELAY_TIME = i;
    }

    public void setDelayFix(boolean z) {
        this.isDelayFix = z;
    }

    public void setQueueDelayTime(long j) {
        this.queueModel.setDelayTime(j);
    }

    @Override // com.qiahao.nextvideo.utilities.animation.ImmViewDispatcher
    public void unBind() {
        ViewGroup viewGroup = this.layout;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.layout = null;
        this.emptyViewHolderList.clear();
        this.addedViewHolderList.clear();
        this.queueModel.getQueue().clear();
        this.isBinding = false;
    }
}
