package com.example.test_many_to_many.Repository.Impl;

import com.example.test_many_to_many.Connections.BaseRepository;
import com.example.test_many_to_many.Repository.IRoleRepository;
import com.example.test_many_to_many.model.Role;

import java.util.List;

public class RoleRepositoryImpl implements IRoleRepository {
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Role> display_role_by_id_user(int idUser) {
        return null;
    }
}
