package com.example.quan_ly_nhan_su.repository.impl;

import com.example.quan_ly_nhan_su.model.Job;
import com.example.quan_ly_nhan_su.repository.IJobRepository;

import java.util.ArrayList;
import java.util.List;

public class JobRepository implements IJobRepository {
    private BaseRepository baseRepository = new BaseRepository();
    private List<Job> jobList = new ArrayList<>();


}
