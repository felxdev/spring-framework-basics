package org.felix.springframework.basics.services;

import org.felix.springframework.basics.entities.Role;
import org.felix.springframework.basics.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(@Autowired RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role create(Role role) {
        return roleRepository.save(role);
    }

    public Role update(Integer roleId, Role role) {
        if (roleRepository.findById(roleId).isPresent()){
            return roleRepository.save(role);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("El rol con la id %s no se ha encontrado", roleId));
        }
    }
}
