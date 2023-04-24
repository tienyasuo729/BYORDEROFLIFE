package com.example.tien_thanh.Service;

import com.example.tien_thanh.model.Detail;

import java.util.List;
public interface IDetailService {
    List<Detail> displayDetail();
    void addNewDetail(Detail detail);
    void editDetail(Detail detail);
    void deleteDetail(String id);
    Detail finDetailByid(String id);
    List listFinDetailSimilarById(String id);
    Detail finDetailByName(String id);
    List listFinDetailSimilarByName(String id);
}
