package com.amazonaws.mobileconnectors.s3.transfermanager;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.event.ProgressListenerChain;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.mobileconnectors.s3.transfermanager.Transfer;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.CopyCallable;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.CopyImpl;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.CopyMonitor;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.DownloadImpl;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.DownloadMonitor;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.MultipleFileDownloadImpl;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.MultipleFileTransferMonitor;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.MultipleFileUploadImpl;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.S3ProgressListener;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.S3ProgressListenerChain;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferManagerUtils;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferProgressUpdatingListener;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.TransferStateChangeListener;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.UploadCallable;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.UploadImpl;
import com.amazonaws.mobileconnectors.s3.transfermanager.internal.UploadMonitor;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3EncryptionClient;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.model.AbortMultipartUploadRequest;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.GetObjectMetadataRequest;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ListMultipartUploadsRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.MultipartUpload;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.util.Mimetypes;
import com.amazonaws.util.VersionInfoUtils;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class TransferManager {
    private static final String DEFAULT_DELIMITER = "/";
    private TransferManagerConfiguration configuration;

    /* renamed from: s3, reason: collision with root package name */
    private final AmazonS3 f٦٩١٥s3;
    private final ExecutorService threadPool;
    private final ScheduledExecutorService timedThreadPool;
    private static final Log log = LogFactory.getLog(TransferManager.class);
    private static final String USER_AGENT = TransferManager.class.getName() + "/" + VersionInfoUtils.getVersion();
    private static final String USER_AGENT_MULTIPART = TransferManager.class.getName() + "_multipart/" + VersionInfoUtils.getVersion();
    private static final ThreadFactory daemonThreadFactory = new ThreadFactory() { // from class: com.amazonaws.mobileconnectors.s3.transfermanager.TransferManager.3
        final AtomicInteger threadCount = new AtomicInteger(0);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            int incrementAndGet = this.threadCount.incrementAndGet();
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            thread.setName("S3TransferManagerTimedThread-" + incrementAndGet);
            return thread;
        }
    };

    public TransferManager() {
        this(new AmazonS3Client(new DefaultAWSCredentialsProviderChain()));
    }

    public static <X extends AmazonWebServiceRequest> X appendMultipartUserAgent(X x10) {
        x10.getRequestClientOptions().appendUserAgent(USER_AGENT_MULTIPART);
        return x10;
    }

    public static <X extends AmazonWebServiceRequest> X appendSingleObjectUserAgent(X x10) {
        x10.getRequestClientOptions().appendUserAgent(USER_AGENT);
        return x10;
    }

    private void assertParameterNotNull(Object obj, String str) {
        if (obj != null) {
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    private Download doDownload(GetObjectRequest getObjectRequest, File file, TransferStateChangeListener transferStateChangeListener, S3ProgressListener s3ProgressListener, boolean z10) {
        long j10;
        appendSingleObjectUserAgent(getObjectRequest);
        String str = "Downloading from " + getObjectRequest.getBucketName() + "/" + getObjectRequest.getKey();
        TransferProgress transferProgress = new TransferProgress();
        S3ProgressListenerChain s3ProgressListenerChain = new S3ProgressListenerChain(new TransferProgressUpdatingListener(transferProgress), getObjectRequest.getGeneralProgressListener(), s3ProgressListener);
        getObjectRequest.setGeneralProgressListener(new ProgressListenerChain(new ProgressListenerChain.ProgressEventFilter() { // from class: com.amazonaws.mobileconnectors.s3.transfermanager.TransferManager.1
            @Override // com.amazonaws.event.ProgressListenerChain.ProgressEventFilter
            public ProgressEvent filter(ProgressEvent progressEvent) {
                if (progressEvent.getEventCode() == 4) {
                    progressEvent.setEventCode(0);
                }
                return progressEvent;
            }
        }, s3ProgressListenerChain));
        GetObjectMetadataRequest getObjectMetadataRequest = new GetObjectMetadataRequest(getObjectRequest.getBucketName(), getObjectRequest.getKey());
        if (getObjectRequest.getSSECustomerKey() != null) {
            getObjectMetadataRequest.setSSECustomerKey(getObjectRequest.getSSECustomerKey());
        }
        ObjectMetadata objectMetadata = this.f٦٩١٥s3.getObjectMetadata(getObjectMetadataRequest);
        DownloadImpl downloadImpl = new DownloadImpl(str, transferProgress, s3ProgressListenerChain, null, transferStateChangeListener, getObjectRequest, file);
        long contentLength = objectMetadata.getContentLength() - 1;
        if (getObjectRequest.getRange() != null && getObjectRequest.getRange().length == 2) {
            j10 = getObjectRequest.getRange()[0];
            contentLength = getObjectRequest.getRange()[1];
        } else {
            j10 = 0;
        }
        long j11 = (contentLength - j10) + 1;
        transferProgress.setTotalBytesToTransfer(j11);
        if (z10 && file.exists()) {
            long length = file.length();
            long j12 = j10 + length;
            getObjectRequest.setRange(j12, contentLength);
            transferProgress.updateProgress(Math.min(length, j11));
            j11 = (contentLength - j12) + 1;
        }
        if (j11 >= 0) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            downloadImpl.setMonitor(new DownloadMonitor(downloadImpl, submitDownloadTask(getObjectRequest, file, z10, countDownLatch, downloadImpl)));
            countDownLatch.countDown();
            return downloadImpl;
        }
        throw new IllegalArgumentException("Unable to determine the range for download operation.");
    }

    private Upload doUpload(PutObjectRequest putObjectRequest, TransferStateChangeListener transferStateChangeListener, S3ProgressListener s3ProgressListener, PersistableUpload persistableUpload) throws AmazonServiceException, AmazonClientException {
        String str;
        appendSingleObjectUserAgent(putObjectRequest);
        if (persistableUpload != null) {
            str = persistableUpload.getMultipartUploadId();
        } else {
            str = null;
        }
        String str2 = str;
        if (putObjectRequest.getMetadata() == null) {
            putObjectRequest.setMetadata(new ObjectMetadata());
        }
        ObjectMetadata metadata = putObjectRequest.getMetadata();
        File requestFile = TransferManagerUtils.getRequestFile(putObjectRequest);
        if (requestFile != null) {
            metadata.setContentLength(requestFile.length());
            if (metadata.getContentType() == null) {
                metadata.setContentType(Mimetypes.getInstance().getMimetype(requestFile));
            }
        } else if (str2 != null) {
            throw new IllegalArgumentException("Unable to resume the upload. No file specified.");
        }
        String str3 = "Uploading to " + putObjectRequest.getBucketName() + "/" + putObjectRequest.getKey();
        TransferProgress transferProgress = new TransferProgress();
        transferProgress.setTotalBytesToTransfer(TransferManagerUtils.getContentLength(putObjectRequest));
        S3ProgressListenerChain s3ProgressListenerChain = new S3ProgressListenerChain(new TransferProgressUpdatingListener(transferProgress), putObjectRequest.getGeneralProgressListener(), s3ProgressListener);
        putObjectRequest.setGeneralProgressListener(s3ProgressListenerChain);
        UploadImpl uploadImpl = new UploadImpl(str3, transferProgress, s3ProgressListenerChain, transferStateChangeListener);
        UploadMonitor uploadMonitor = new UploadMonitor(this, uploadImpl, this.threadPool, new UploadCallable(this, this.threadPool, uploadImpl, putObjectRequest, s3ProgressListenerChain, str2, transferProgress), putObjectRequest, s3ProgressListenerChain);
        uploadMonitor.setTimedThreadPool(this.timedThreadPool);
        uploadImpl.setMonitor(uploadMonitor);
        return uploadImpl;
    }

    private void listFiles(File file, List<File> list, boolean z10) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    if (z10) {
                        listFiles(file2, list, z10);
                    }
                } else {
                    list.add(file2);
                }
            }
        }
    }

    private void shutdown() {
        this.threadPool.shutdown();
        this.timedThreadPool.shutdown();
    }

    private Future<?> submitDownloadTask(final GetObjectRequest getObjectRequest, final File file, final boolean z10, final CountDownLatch countDownLatch, final DownloadImpl downloadImpl) {
        return this.threadPool.submit(new Callable<Object>() { // from class: com.amazonaws.mobileconnectors.s3.transfermanager.TransferManager.2
            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                try {
                    countDownLatch.await();
                    downloadImpl.setState(Transfer.TransferState.InProgress);
                    if (ServiceUtils.retryableDownloadS3ObjectToFile(file, new ServiceUtils.RetryableS3DownloadTask() { // from class: com.amazonaws.mobileconnectors.s3.transfermanager.TransferManager.2.1
                        @Override // com.amazonaws.services.s3.internal.ServiceUtils.RetryableS3DownloadTask
                        public S3Object getS3ObjectStream() {
                            S3Object object = TransferManager.this.f٦٩١٥s3.getObject(getObjectRequest);
                            downloadImpl.setS3Object(object);
                            return object;
                        }

                        @Override // com.amazonaws.services.s3.internal.ServiceUtils.RetryableS3DownloadTask
                        public boolean needIntegrityCheck() {
                            if (!ServiceUtils.skipMd5CheckPerRequest(getObjectRequest) && !(TransferManager.this.f٦٩١٥s3 instanceof AmazonS3EncryptionClient)) {
                                return true;
                            }
                            return false;
                        }
                    }, z10) == null) {
                        downloadImpl.setState(Transfer.TransferState.Canceled);
                        DownloadImpl downloadImpl2 = downloadImpl;
                        downloadImpl2.setMonitor(new DownloadMonitor(downloadImpl2, null));
                        return downloadImpl;
                    }
                    downloadImpl.setState(Transfer.TransferState.Completed);
                    return Boolean.TRUE;
                } catch (Throwable th) {
                    if (downloadImpl.getState() != Transfer.TransferState.Canceled) {
                        downloadImpl.setState(Transfer.TransferState.Failed);
                    }
                    if (th instanceof Exception) {
                        throw ((Exception) th);
                    }
                    throw ((Error) th);
                }
            }
        });
    }

    public void abortMultipartUploads(String str, Date date) throws AmazonServiceException, AmazonClientException {
        MultipartUploadListing listMultipartUploads = this.f٦٩١٥s3.listMultipartUploads((ListMultipartUploadsRequest) appendSingleObjectUserAgent(new ListMultipartUploadsRequest(str)));
        do {
            for (MultipartUpload multipartUpload : listMultipartUploads.getMultipartUploads()) {
                if (multipartUpload.getInitiated().compareTo(date) < 0) {
                    this.f٦٩١٥s3.abortMultipartUpload((AbortMultipartUploadRequest) appendSingleObjectUserAgent(new AbortMultipartUploadRequest(str, multipartUpload.getKey(), multipartUpload.getUploadId())));
                }
            }
            listMultipartUploads = this.f٦٩١٥s3.listMultipartUploads((ListMultipartUploadsRequest) appendSingleObjectUserAgent(new ListMultipartUploadsRequest(str).withUploadIdMarker(listMultipartUploads.getNextUploadIdMarker()).withKeyMarker(listMultipartUploads.getNextKeyMarker())));
        } while (listMultipartUploads.isTruncated());
    }

    public Copy copy(String str, String str2, String str3, String str4) throws AmazonServiceException, AmazonClientException {
        return copy(new CopyObjectRequest(str, str2, str3, str4));
    }

    public Download download(String str, String str2, File file) {
        return download(new GetObjectRequest(str, str2), file);
    }

    public MultipleFileDownload downloadDirectory(String str, String str2, File file) {
        if (str2 == null) {
            str2 = "";
        }
        String str3 = str2;
        LinkedList<S3ObjectSummary> linkedList = new LinkedList();
        Stack stack = new Stack();
        stack.add(str3);
        long j10 = 0;
        do {
            String str4 = (String) stack.pop();
            ObjectListing objectListing = null;
            do {
                if (objectListing == null) {
                    objectListing = this.f٦٩١٥s3.listObjects(new ListObjectsRequest().withBucketName(str).withDelimiter("/").withPrefix(str4));
                } else {
                    objectListing = this.f٦٩١٥s3.listNextBatchOfObjects(objectListing);
                }
                for (S3ObjectSummary s3ObjectSummary : objectListing.getObjectSummaries()) {
                    if (!s3ObjectSummary.getKey().equals(str4)) {
                        if (!objectListing.getCommonPrefixes().contains(s3ObjectSummary.getKey() + "/")) {
                            linkedList.add(s3ObjectSummary);
                            j10 += s3ObjectSummary.getSize();
                        }
                    }
                    log.debug("Skipping download for object " + s3ObjectSummary.getKey() + " since it is also a virtual directory");
                }
                stack.addAll(objectListing.getCommonPrefixes());
            } while (objectListing.isTruncated());
        } while (!stack.isEmpty());
        ProgressListenerChain progressListenerChain = new ProgressListenerChain(new ProgressListener[0]);
        TransferProgress transferProgress = new TransferProgress();
        transferProgress.setTotalBytesToTransfer(j10);
        MultipleFileTransferProgressUpdatingListener multipleFileTransferProgressUpdatingListener = new MultipleFileTransferProgressUpdatingListener(transferProgress, progressListenerChain);
        ArrayList arrayList = new ArrayList();
        MultipleFileDownloadImpl multipleFileDownloadImpl = new MultipleFileDownloadImpl("Downloading from " + str + "/" + str3, transferProgress, progressListenerChain, str3, str, arrayList);
        multipleFileDownloadImpl.setMonitor(new MultipleFileTransferMonitor(multipleFileDownloadImpl, arrayList));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        MultipleFileTransferStateChangeListener multipleFileTransferStateChangeListener = new MultipleFileTransferStateChangeListener(countDownLatch, multipleFileDownloadImpl);
        for (S3ObjectSummary s3ObjectSummary2 : linkedList) {
            File file2 = new File(file, s3ObjectSummary2.getKey());
            File parentFile = file2.getParentFile();
            if (!parentFile.exists() && !parentFile.mkdirs()) {
                throw new RuntimeException("Couldn't create parent directories for " + file2.getAbsolutePath());
            }
            arrayList.add((DownloadImpl) doDownload(new GetObjectRequest(s3ObjectSummary2.getBucketName(), s3ObjectSummary2.getKey()).withGeneralProgressListener((ProgressListener) multipleFileTransferProgressUpdatingListener), file2, multipleFileTransferStateChangeListener, null, false));
        }
        if (arrayList.isEmpty()) {
            multipleFileDownloadImpl.setState(Transfer.TransferState.Completed);
            return multipleFileDownloadImpl;
        }
        countDownLatch.countDown();
        return multipleFileDownloadImpl;
    }

    protected void finalize() throws Throwable {
        shutdown();
    }

    public AmazonS3 getAmazonS3Client() {
        return this.f٦٩١٥s3;
    }

    public TransferManagerConfiguration getConfiguration() {
        return this.configuration;
    }

    public Download resumeDownload(PersistableDownload persistableDownload) {
        assertParameterNotNull(persistableDownload, "PausedDownload is mandatory to resume a download.");
        GetObjectRequest getObjectRequest = new GetObjectRequest(persistableDownload.getBucketName(), persistableDownload.getKey(), persistableDownload.getVersionId());
        if (persistableDownload.getRange() != null && persistableDownload.getRange().length == 2) {
            long[] range = persistableDownload.getRange();
            getObjectRequest.setRange(range[0], range[1]);
        }
        getObjectRequest.setRequesterPays(persistableDownload.isRequesterPays());
        getObjectRequest.setResponseHeaders(persistableDownload.getResponseHeaders());
        return doDownload(getObjectRequest, new File(persistableDownload.getFile()), null, null, true);
    }

    public Upload resumeUpload(PersistableUpload persistableUpload) {
        assertParameterNotNull(persistableUpload, "PauseUpload is mandatory to resume a upload.");
        this.configuration.setMinimumUploadPartSize(persistableUpload.getPartSize());
        this.configuration.setMultipartUploadThreshold(persistableUpload.getMutlipartUploadThreshold());
        return doUpload(new PutObjectRequest(persistableUpload.getBucketName(), persistableUpload.getKey(), new File(persistableUpload.getFile())), null, null, persistableUpload);
    }

    public void setConfiguration(TransferManagerConfiguration transferManagerConfiguration) {
        this.configuration = transferManagerConfiguration;
    }

    public void shutdownNow() {
        shutdownNow(true);
    }

    public Upload upload(String str, String str2, InputStream inputStream, ObjectMetadata objectMetadata) throws AmazonServiceException, AmazonClientException {
        return upload(new PutObjectRequest(str, str2, inputStream, objectMetadata));
    }

    public MultipleFileUpload uploadDirectory(String str, String str2, File file, boolean z10) {
        return uploadDirectory(str, str2, file, z10, null);
    }

    public MultipleFileUpload uploadFileList(String str, String str2, File file, List<File> list) {
        return uploadFileList(str, str2, file, list, null);
    }

    public TransferManager(AWSCredentialsProvider aWSCredentialsProvider) {
        this(new AmazonS3Client(aWSCredentialsProvider));
    }

    public Copy copy(CopyObjectRequest copyObjectRequest) {
        return copy(copyObjectRequest, null);
    }

    public Download download(GetObjectRequest getObjectRequest, File file) {
        return doDownload(getObjectRequest, file, null, null, false);
    }

    public void shutdownNow(boolean z10) {
        this.threadPool.shutdownNow();
        this.timedThreadPool.shutdownNow();
        if (z10) {
            AmazonS3 amazonS3 = this.f٦٩١٥s3;
            if (amazonS3 instanceof AmazonS3Client) {
                ((AmazonS3Client) amazonS3).shutdown();
            }
        }
    }

    public Upload upload(String str, String str2, File file) throws AmazonServiceException, AmazonClientException {
        return upload(new PutObjectRequest(str, str2, file));
    }

    public MultipleFileUpload uploadDirectory(String str, String str2, File file, boolean z10, ObjectMetadataProvider objectMetadataProvider) {
        if (file != null && file.exists() && file.isDirectory()) {
            LinkedList linkedList = new LinkedList();
            listFiles(file, linkedList, z10);
            return uploadFileList(str, str2, file, linkedList, objectMetadataProvider);
        }
        throw new IllegalArgumentException("Must provide a directory to upload");
    }

    public MultipleFileUpload uploadFileList(String str, String str2, File file, List<File> list, ObjectMetadataProvider objectMetadataProvider) {
        String str3;
        String str4 = str2;
        ObjectMetadataProvider objectMetadataProvider2 = objectMetadataProvider;
        if (file != null && file.exists() && file.isDirectory()) {
            String str5 = "/";
            if (str4 != null && str2.length() != 0) {
                if (!str4.endsWith("/")) {
                    str4 = str4 + "/";
                }
            } else {
                str4 = "";
            }
            ProgressListenerChain progressListenerChain = new ProgressListenerChain(new ProgressListener[0]);
            TransferProgress transferProgress = new TransferProgress();
            MultipleFileTransferProgressUpdatingListener multipleFileTransferProgressUpdatingListener = new MultipleFileTransferProgressUpdatingListener(transferProgress, progressListenerChain);
            LinkedList linkedList = new LinkedList();
            MultipleFileUploadImpl multipleFileUploadImpl = new MultipleFileUploadImpl("Uploading etc", transferProgress, progressListenerChain, str4, str, linkedList);
            multipleFileUploadImpl.setMonitor(new MultipleFileTransferMonitor(multipleFileUploadImpl, linkedList));
            CountDownLatch countDownLatch = new CountDownLatch(1);
            MultipleFileTransferStateChangeListener multipleFileTransferStateChangeListener = new MultipleFileTransferStateChangeListener(countDownLatch, multipleFileUploadImpl);
            if (list != null && !list.isEmpty()) {
                int length = file.getAbsolutePath().length();
                if (!file.getAbsolutePath().endsWith(File.separator)) {
                    length++;
                }
                long j10 = 0;
                for (File file2 : list) {
                    if (file2.isFile()) {
                        j10 += file2.length();
                        String replaceAll = file2.getAbsolutePath().substring(length).replaceAll("\\\\", str5);
                        ObjectMetadata objectMetadata = new ObjectMetadata();
                        if (objectMetadataProvider2 != null) {
                            objectMetadataProvider2.provideObjectMetadata(file2, objectMetadata);
                        }
                        str3 = str5;
                        linkedList.add((UploadImpl) doUpload(new PutObjectRequest(str, str4 + replaceAll, file2).withMetadata(objectMetadata).withGeneralProgressListener((ProgressListener) multipleFileTransferProgressUpdatingListener), multipleFileTransferStateChangeListener, null, null));
                    } else {
                        str3 = str5;
                    }
                    objectMetadataProvider2 = objectMetadataProvider;
                    str5 = str3;
                }
                transferProgress.setTotalBytesToTransfer(j10);
            } else {
                multipleFileUploadImpl.setState(Transfer.TransferState.Completed);
            }
            countDownLatch.countDown();
            return multipleFileUploadImpl;
        }
        throw new IllegalArgumentException("Must provide a common base directory for uploaded files");
    }

    public TransferManager(AWSCredentials aWSCredentials) {
        this(new AmazonS3Client(aWSCredentials));
    }

    public Copy copy(CopyObjectRequest copyObjectRequest, TransferStateChangeListener transferStateChangeListener) throws AmazonServiceException, AmazonClientException {
        appendSingleObjectUserAgent(copyObjectRequest);
        assertParameterNotNull(copyObjectRequest.getSourceBucketName(), "The source bucket name must be specified when a copy request is initiated.");
        assertParameterNotNull(copyObjectRequest.getSourceKey(), "The source object key must be specified when a copy request is initiated.");
        assertParameterNotNull(copyObjectRequest.getDestinationBucketName(), "The destination bucket name must be specified when a copy request is initiated.");
        assertParameterNotNull(copyObjectRequest.getDestinationKey(), "The destination object key must be specified when a copy request is initiated.");
        String str = "Copying object from " + copyObjectRequest.getSourceBucketName() + "/" + copyObjectRequest.getSourceKey() + " to " + copyObjectRequest.getDestinationBucketName() + "/" + copyObjectRequest.getDestinationKey();
        ObjectMetadata objectMetadata = this.f٦٩١٥s3.getObjectMetadata(new GetObjectMetadataRequest(copyObjectRequest.getSourceBucketName(), copyObjectRequest.getSourceKey()).withSSECustomerKey(copyObjectRequest.getSourceSSECustomerKey()));
        TransferProgress transferProgress = new TransferProgress();
        transferProgress.setTotalBytesToTransfer(objectMetadata.getContentLength());
        ProgressListenerChain progressListenerChain = new ProgressListenerChain(new TransferProgressUpdatingListener(transferProgress));
        CopyImpl copyImpl = new CopyImpl(str, transferProgress, progressListenerChain, transferStateChangeListener);
        CopyMonitor copyMonitor = new CopyMonitor(this, copyImpl, this.threadPool, new CopyCallable(this, this.threadPool, copyImpl, copyObjectRequest, objectMetadata, progressListenerChain), copyObjectRequest, progressListenerChain);
        copyMonitor.setTimedThreadPool(this.timedThreadPool);
        copyImpl.setMonitor(copyMonitor);
        return copyImpl;
    }

    public Download download(GetObjectRequest getObjectRequest, File file, S3ProgressListener s3ProgressListener) {
        return doDownload(getObjectRequest, file, null, s3ProgressListener, false);
    }

    public Upload upload(PutObjectRequest putObjectRequest) throws AmazonServiceException, AmazonClientException {
        return doUpload(putObjectRequest, null, null, null);
    }

    public TransferManager(AmazonS3 amazonS3) {
        this(amazonS3, TransferManagerUtils.createDefaultExecutorService());
    }

    public Upload upload(PutObjectRequest putObjectRequest, S3ProgressListener s3ProgressListener) throws AmazonServiceException, AmazonClientException {
        return doUpload(putObjectRequest, null, s3ProgressListener, null);
    }

    public TransferManager(AmazonS3 amazonS3, ExecutorService executorService) {
        this.timedThreadPool = new ScheduledThreadPoolExecutor(1, daemonThreadFactory);
        this.f٦٩١٥s3 = amazonS3;
        this.threadPool = executorService;
        this.configuration = new TransferManagerConfiguration();
    }
}
