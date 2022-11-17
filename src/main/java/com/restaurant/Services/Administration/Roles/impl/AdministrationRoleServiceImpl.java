package com.restaurant.Services.Administration.Roles.impl;

import com.restaurant.Dao.Roles.RoleDao;
import com.restaurant.Dto.Administration.Roles.RoleDto;
import com.restaurant.Mappers.Administration.Roles.RoleMapper;
import com.restaurant.Models.Role;
import com.restaurant.Services.Administration.Roles.AdministrationRoleService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;

public class AdministrationRoleServiceImpl implements AdministrationRoleService {

    private final RoleMapper mapper
            = Mappers.getMapper(RoleMapper.class);

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<RoleDto> getRoles ( ) {
        roleDao.findAll (Sort.by ("id"));
        return mapper.modelsToDtos ((List<Role>) roleDao.findAll ());
    }

    @Override
    public RoleDto getRoleForView ( Integer id ) {

        return mapper.modelToDto (roleDao.findById (id).orElse (null));
    }

    @Override
    public RoleDto getRoleForEdit ( Integer id ) {
        if(id!=null) {
            return mapper.modelToDto (roleDao.findById(id).orElse(new Role ()));
        }else{
            return mapper.modelToDto(new Role ());
        }
    }

    @Override
    public RoleDto saveRole ( RoleDto role ) {
        Role newRole = mapper.dtoToModel (role);
        newRole = roleDao.save(newRole);
        return mapper.modelToDto (newRole);
    }

    @Override
    public Boolean deleteRole ( Integer id ) {
        Role role = roleDao.findById(id).orElse(null);
        if(role!=null){
            roleDao.delete(role);
        }else{
            return false;
        }
        return true;
    }
}
