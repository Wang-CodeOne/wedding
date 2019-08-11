package com.xcy.wedding.service;

import com.xcy.wedding.pojo.Address;

public interface addressService {
    public int adOUpAddress(Address add);

    public boolean selectByJW(Address address);

    public String selectByAid(Address address);
}
