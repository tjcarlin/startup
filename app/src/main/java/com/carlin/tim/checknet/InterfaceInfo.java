package com.carlin.tim.checknet;

import java.net.InetAddress;
import java.util.LinkedList;

/**
 * Created by Tim on 5/1/2017.
 */

public class InterfaceInfo {
    private final LinkedList<InetAddress> mAddrs;

    private String mName;

    public InterfaceInfo() {
        this.mAddrs = new LinkedList<InetAddress>();
    }

    public void setName(String name) {
        this.mName = name;
    }

    public void addAddress(InetAddress addr) {
        this.mAddrs.add(addr);
    }
}
