package com.cloud.base.schedule.job.exception;

/**
 * 调度任务异常
 *
 * @author Jon_China
 * @create 2018/2/27
 */
public class QuartzTaskException extends RuntimeException {

    public QuartzTaskException() {
        super();
    }

    public QuartzTaskException(String message) {
        super(message);
    }

    public QuartzTaskException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuartzTaskException(Throwable cause) {
        super(cause);
    }
}
