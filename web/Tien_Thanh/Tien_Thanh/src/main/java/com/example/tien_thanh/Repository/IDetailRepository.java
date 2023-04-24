package com.example.tien_thanh.Repository;


import com.example.tien_thanh.model.Detail;

import java.util.List;
public interface IDetailRepository {
    List<Detail> displayDetail();
    void addNewDetail(Detail detail);
    void editDetail(Detail detail);
    void deleteDetail(String id);
    Detail finDetailByid(String id);
    List listFinDetailSimilarById(String id);
    Detail finDetailByName(String id);
    List listFinDetailSimilarByName(String id);

}
