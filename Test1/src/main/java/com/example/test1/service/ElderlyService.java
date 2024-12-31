package com.example.test1.service;

import com.example.test1.POJO.Elderly;

import java.util.List;

public interface ElderlyService {

    public List<Elderly> getElderly();

    public void addElderly(Elderly elderly);
    public void deleteElderly(String name);
    public List<Elderly> searchElderly(String name);
}
