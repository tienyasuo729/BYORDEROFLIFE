package com.example.tien_thanh.Service;

import com.example.tien_thanh.model.CCCD;

import java.util.List;

public interface ICccdService {
    List<CCCD> displayCCCD();
    void addNewCCCD(CCCD cccd);
    void editCCCD(CCCD cccd);
    void deleteCCCD(String id);
    CCCD findCccdByid(String id);
    List<CCCD> listFindCccdSimilarById(String id);
    CCCD findCccdByName(String id);
    List<CCCD> listFindCccdSimilarByName(String id);
}
