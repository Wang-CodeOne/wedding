package com.xcy.wedding.service.impl;

import com.xcy.wedding.mapper.AddressMapper;
import com.xcy.wedding.pojo.Address;
import com.xcy.wedding.service.addressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class addressServiceImpl implements addressService {
    @Autowired
    AddressMapper addressMapper;
    @Override
    public int adOUpAddress(Address add) {
        //如果add在数据库中没有信息则直接插入，如果有信息，则判断是否相同，有一个不同不同则update信息，如果相同则不再进行任何操作
        Integer id = add.getId();
        String log = add.getLog();
        String lat = add.getLat();
        Address address = addressMapper.selectByPrimaryKey(id);
        if(address != null){
            if(log !=address.getLog() || lat !=address.getLat() ){
                //进行更新操作
                addressMapper.updateByPrimaryKey(add);

            }
            return 0;
        }
        //进行插入操作
        addressMapper.insert(add);
        return 1;
    }
}
