package com.restaurant.Services.Administration.Users.impl;

import com.restaurant.Dao.Roles.RoleDao;
import com.restaurant.Dao.Users.UsersDao;
import com.restaurant.Dto.Administration.Roles.RoleDto;
import com.restaurant.Dto.Administration.Users.UserEditDto;
import com.restaurant.Dto.Administration.Users.UserRolesDto;
import com.restaurant.Dto.Administration.Users.UserViewDto;
import com.restaurant.Dto.Auth.UserSingUpDto;
import com.restaurant.Mappers.Administration.Roles.RoleMapper;
import com.restaurant.Mappers.Administration.Users.UserMapper;
import com.restaurant.Mappers.Administration.Users.UserRolesMapper;
import com.restaurant.Models.Role;
import com.restaurant.Models.User;
import com.restaurant.Models.UserRoles;
import com.restaurant.Services.Administration.Users.AdministrationUserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class AdministrationUserServiceImpl implements AdministrationUserService {

    private final UserMapper mapper
            = Mappers.getMapper(UserMapper.class);
    private final UserRolesMapper userRolesMapper
            = Mappers.getMapper(UserRolesMapper.class);
    @Autowired
    private UsersDao usersDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<UserViewDto> getUsersForTable() {
        return mapper.modelsToDtoViews((List<User>) usersDao.findAll());
    }

    @Override
    public UserViewDto getUserForView(Integer id) {
        return mapper.modelToDtoView(usersDao.findById(id).orElse(null));
    }

    @Override
    public UserEditDto getUserForEdit(Integer id) {
        if(id!=null) {
            return mapper.modelToDtoEdit(usersDao.findById(id).orElse(new User()));
        }else{
            return mapper.modelToDtoEdit(new User());
        }
    }

    @Override
    public UserEditDto saveUser(UserEditDto user) {
        User newUser = mapper.userDtoEditToModel(user);
        newUser = usersDao.save(newUser);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        newUser.setPassword(passwordEncoder.encode("123"));
        return mapper.modelToDtoEdit(newUser);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        User user = usersDao.findById(id).orElse(null);
        if(user!=null){
            usersDao.delete(user);
        }else{
            return false;
        }
        return true;
    }

    @Override
    public List<UserRolesDto> registerUser ( UserSingUpDto userSingUpDto ) {
        User newUser =  mapper.userSingUpToModel (userSingUpDto);
        Role role = roleDao.findById (1).get ();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        UserRoles newUserRole = new UserRoles ();
        newUserRole.setUser (newUser);
        newUserRole.setRole (role);
        newUserRole.setCanView (true);
        newUser.getRoles ().add (newUserRole);
        usersDao.save (newUser);
        return userRolesMapper.modelToUsersRolesDto (newUser.getRoles ()).stream().collect (Collectors.toList ());
    }

}
