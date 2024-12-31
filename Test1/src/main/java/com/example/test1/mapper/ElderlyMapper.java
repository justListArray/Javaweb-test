package com.example.test1.mapper;

import com.example.test1.POJO.Elderly;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ElderlyMapper {

    @Select("SELECT ID, image, name, age, room, disease, marriageStatus, phoneNumber FROM elderly")
    public List<Elderly> getElderly();

    @Insert("INSERT INTO elderly (ID, image, name, age, room, disease, marriageStatus, phoneNumber) VALUES (#{ID}, #{image}, #{name}, #{age}, #{room}, #{disease}, #{marriageStatus}, #{phoneNumber})")
    public void addElderly(Elderly elderly);
    @Delete("DELETE FROM elderly WHERE name = #{name}")
    public void deleteElderly(String name);
    @Select("SELECT ID, image, name, age, room, disease, marriageStatus, phoneNumber FROM elderly WHERE name = #{name}")
    public List<Elderly> searchElderly(String name);
}
