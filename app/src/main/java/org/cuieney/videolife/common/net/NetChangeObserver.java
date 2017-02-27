package org.cuieney.videolife.common.net;


import javax.inject.Inject;

public class NetChangeObserver {

    @Inject
    public NetChangeObserver( ) {
    }

    /**
     * 网络连接连接时调用
     */
    public void onConnect(NetWorkUtil.NetType type) {
    }

    /**
     * 当前没有网络连接
     */
    public void onDisConnect() {

    }
}
