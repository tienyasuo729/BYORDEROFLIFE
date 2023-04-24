package com.example.tien_thanh.Repository;
import com.example.tien_thanh.model.CCCD;

import java.util.List;

public interface ICccdRepository {
    List<CCCD> displayCCCD();
    void addNewCCCD(CCCD cccd);
    void editCCCD(CCCD cccd);
    void deleteCCCD(String id);
    CCCD findCccdByid(String id);
    List<CCCD> listFindCccdSimilarById(String id);
    CCCD findCccdByName(String id);
    List<CCCD> listFindCccdSimilarByName(String id);

}
