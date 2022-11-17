package com.restaurant.Controllers.Administration.Roles;

import com.restaurant.Dto.Administration.Roles.RoleDto;
import com.restaurant.Services.Administration.Roles.AdministrationRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "api/v1/admin/roles")
public class RolesController {


    @Autowired
    private final AdministrationRoleService administrationRoleService;

    public RolesController ( AdministrationRoleService administrationRoleService) {
        this.administrationRoleService = administrationRoleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleDto>> index(){
        return new ResponseEntity<>(administrationRoleService.getRoles(),HttpStatus.OK);
    }

    @GetMapping("/create")
    public ResponseEntity<RoleDto> create(){
        return new ResponseEntity<>(administrationRoleService.getRoleForEdit (null),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleDto> store(@RequestBody RoleDto roleDto ){
        roleDto = administrationRoleService.saveRole (roleDto);
        return new ResponseEntity<>(roleDto,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDto> show(@PathVariable Integer id ){
        return new ResponseEntity<>(administrationRoleService.getRoleForView (id),HttpStatus.OK);
    }

    @GetMapping("/{id}/edit")
    public ResponseEntity<RoleDto> edit(@PathVariable Integer id ){
        return new ResponseEntity<>(administrationRoleService.getRoleForEdit (id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDto> update( @RequestBody RoleDto roleDto ){
        roleDto = administrationRoleService.saveRole (roleDto);
        return new ResponseEntity<>(roleDto,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete( @PathVariable Integer id ){
        String result = "Ошибка удаления";
        if(administrationRoleService.deleteRole (id)){
            result = "Удаление прошло успешно";
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
