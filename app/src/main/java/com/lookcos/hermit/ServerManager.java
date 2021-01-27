package com.lookcos.hermit;

import android.content.Context;
import android.util.Log;

import com.yanzhenjie.andserver.AndServer;
import com.yanzhenjie.andserver.Server;

import java.util.concurrent.TimeUnit;


public class ServerManager {
    private static final String TAG = "ServerManager";
    private Server mServer;

    /**
     * Create server.
     */
    public ServerManager(Context context) {

        mServer = AndServer.webServer(context)
                .port(9999)
                .timeout(10, TimeUnit.SECONDS)
                .listener(new Server.ServerListener() {
                    @Override
                    public void onStarted() {
                        // TODO The server started successfully.
                        Log.d(TAG, "onStarted: ");
                    }

                    @Override
                    public void onStopped() {
                        // TODO The server has stopped.
                        Log.d(TAG, "onStarted: ");
                    }

                    @Override
                    public void onException(Exception e) {
                        Log.e(TAG, "onException: ",e );
                        // TODO An exception occurred while the server was starting.
                    }
                })
                .build();
    }

    /**
     * Start server.
     */
    public void startServer() {
        if (mServer.isRunning()) {
            // TODO The server is already up.
        } else {
            mServer.startup();
        }
    }

    /**
     * Stop server.
     */
    public void stopServer() {
        if (mServer.isRunning()) {
            mServer.shutdown();
        } else {
            Log.w("AndServer", "The server has not started yet.");
        }
    }
}

