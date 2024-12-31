package com.example.test1.service.implement;

import com.example.test1.POJO.Elderly;
import com.example.test1.mapper.ElderlyMapper;
import com.example.test1.service.ElderlyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ElderlyServiceImplement implements ElderlyService {
    @Autowired
    private ElderlyMapper elderlyMapper;
    @Override
    public List<Elderly> getElderly(){
        return elderlyMapper.getElderly();
    }
    @Override
    public void addElderly(Elderly elderly){
        elderlyMapper.addElderly(elderly);
    }
    @Override
    public void deleteElderly(String name){
        elderlyMapper.deleteElderly(name);
    }
    public List<Elderly> searchElderly(String name){
        return elderlyMapper.searchElderly(name);
    }
}
