package org.felix.springframework.basics.controllers;

import org.felix.springframework.basics.entities.Role;
import org.felix.springframework.basics.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RolController {

    private final RoleService roleService;

    public RolController(@Autowired RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Role>> getRoles() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role){
        return new ResponseEntity<>(roleService.create(role), HttpStatus.CREATED);
    }

    @PutMapping("/update/{roleId}")
    public ResponseEntity<Role> updateRole(@PathVariable("roleId") Integer roleId, @RequestBody Role role){
        return new ResponseEntity<>(roleService.update(roleId, role), HttpStatus.ACCEPTED);
    }
}
