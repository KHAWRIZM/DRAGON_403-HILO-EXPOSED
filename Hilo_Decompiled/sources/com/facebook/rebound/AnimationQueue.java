package com.facebook.rebound;

import com.facebook.rebound.ChoreographerCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
public class AnimationQueue {
    private boolean mRunning;
    private final Queue<Double> mPendingQueue = new LinkedList();
    private final Queue<Double> mAnimationQueue = new LinkedList();
    private final List<Callback> mCallbacks = new ArrayList();
    private final ArrayList<Double> mTempValues = new ArrayList<>();
    private final ChoreographerCompat mChoreographer = ChoreographerCompat.getInstance();
    private final ChoreographerCompat.FrameCallback mChoreographerCallback = new ChoreographerCompat.FrameCallback() { // from class: com.facebook.rebound.AnimationQueue.1
        @Override // com.facebook.rebound.ChoreographerCompat.FrameCallback
        public void doFrame(long j10) {
            AnimationQueue.this.onFrame(j10);
        }
    };

    /* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes2.dex */
    public interface Callback {
        void onFrame(Double d10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFrame(long j10) {
        int max;
        Double poll = this.mPendingQueue.poll();
        if (poll != null) {
            this.mAnimationQueue.offer(poll);
            max = 0;
        } else {
            max = Math.max(this.mCallbacks.size() - this.mAnimationQueue.size(), 0);
        }
        this.mTempValues.addAll(this.mAnimationQueue);
        int size = this.mTempValues.size();
        while (true) {
            size--;
            if (size <= -1) {
                break;
            }
            Double d10 = this.mTempValues.get(size);
            int size2 = ((this.mTempValues.size() - 1) - size) + max;
            if (this.mCallbacks.size() > size2) {
                this.mCallbacks.get(size2).onFrame(d10);
            }
        }
        this.mTempValues.clear();
        while (this.mAnimationQueue.size() + max >= this.mCallbacks.size()) {
            this.mAnimationQueue.poll();
        }
        if (this.mAnimationQueue.isEmpty() && this.mPendingQueue.isEmpty()) {
            this.mRunning = false;
        } else {
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        }
    }

    private void runIfIdle() {
        if (!this.mRunning) {
            this.mRunning = true;
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        }
    }

    public void addAllValues(Collection<Double> collection) {
        this.mPendingQueue.addAll(collection);
        runIfIdle();
    }

    public void addCallback(Callback callback) {
        this.mCallbacks.add(callback);
    }

    public void addValue(Double d10) {
        this.mPendingQueue.add(d10);
        runIfIdle();
    }

    public void clearCallbacks() {
        this.mCallbacks.clear();
    }

    public void clearValues() {
        this.mPendingQueue.clear();
    }

    public void removeCallback(Callback callback) {
        this.mCallbacks.remove(callback);
    }
}
