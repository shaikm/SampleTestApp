package com.dominion.mobile.ddsrefactortest;

import com.octo.android.robospice.SpiceManager;
import com.octo.android.robospice.SpiceService;
import com.octo.android.robospice.request.CachedSpiceRequest;

/**
 * Created by Mastan on 4/3/2017.
 */

public class SpiceManagerTest extends SpiceManager {
    private Exception ex;

    public SpiceManagerTest(Class<? extends SpiceService> spiceServiceClass) {
        super(spiceServiceClass);
    }

    @Override
    public void run() {
        try {
            super.run();
        } catch (Exception ex) {
            this.ex = ex;
        }
    }

    private CachedSpiceRequest<?> getNextRequest() {
        return requestQueue.peek();
    }

    public Exception getException(long timeout) throws InterruptedException {
        runner.join(timeout);
        return ex;
    }
}

