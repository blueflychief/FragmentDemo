package com.example.administrator.fragmentdemo.utils.crash;

import android.content.Context;

import com.example.administrator.fragmentdemo.utils.crash.log.CrashCatcher;
import com.example.administrator.fragmentdemo.utils.crash.reporter.AbstractCrashHandler;
import com.example.administrator.fragmentdemo.utils.crash.reporter.mailreporter.CrashEmailReporter;
import com.example.administrator.fragmentdemo.utils.DateUtil;
import com.example.administrator.fragmentdemo.utils.LogUtil;

import java.io.File;

public class CrashHandler {
    private static final CrashHandler instance = new CrashHandler();

    private AbstractCrashHandler mReporter;

    private String mLogName;

    private CrashHandler() {
    }

    public static CrashHandler getInstance() {
        return instance;
    }

    /**
     * @param context
     * @param reveiver_email
     * @param sender_email
     * @param send_pwd
     * @param smtp_host
     * @param host_port
     * @return
     */
    public CrashHandler setReciverInfo(Context context, String reveiver_email, String sender_email, String send_pwd, String smtp_host, int host_port) {
        CrashEmailReporter reporter = new CrashEmailReporter(context);
        reporter.setReceiver(reveiver_email);
        reporter.setSender(sender_email);
        reporter.setSendPassword(send_pwd);
        reporter.setSMTPHost(smtp_host);
        reporter.setPort(String.valueOf(host_port));
        setCrashReporter(reporter);
        init(context);
        return this;
    }

    /**
     * 设置报告处理。
     *
     * @param reporter
     * @return
     */
    public CrashHandler setCrashReporter(AbstractCrashHandler reporter) {
        mReporter = reporter;
        return this;
    }

    /**
     * 设置日志文件名。
     *
     * @param name
     * @return
     */
    public CrashHandler setLogFileName(String name) {
        mLogName = name;
        return this;
    }

    public void init(Context mContext) {
        if (mLogName == null) {
            mLogName = DateUtil.getCurrentTime() + "_Crash.log";
        }
        File logFile = getLogFile(mContext, mLogName);
        CrashCatcher.getInstance().init(logFile, mReporter);
        Thread.setDefaultUncaughtExceptionHandler(CrashCatcher.getInstance());
        LogUtil.d("CrashHandler_init success: " + Thread.getDefaultUncaughtExceptionHandler().getClass());
    }

    protected static final File getLogFile(Context context, String name) {
        return new File(context.getFilesDir(), name);
    }

}