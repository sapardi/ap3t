package com.jasoet.ap3t.service;

import com.jasoet.ap3t.domain.Group;
import com.jasoet.ap3t.domain.Role;
import com.jasoet.ap3t.domain.User;

import java.util.List;

public interface SpringSecurityService {

    public void save(Role role);

    public void delete(Role role);

    public Role findRole(String authority);

    public List<Role> findRoles();

    public Long countRoles();

    /*=================================================*/
    public void save(Group group);

    public void delete(Group group);

    public Group findGroup(Long id);

    public List<Group> findGroups();

    public Long countGroups();

    public List<Group> findGroupsByName(String name);

    public Long countGroupsByName(String name);


    /*=================================================*/
    public void save(User user);

    public void delete(User user);

    public User findUser(Long id);

    public List<User> findUsers();

    public Long countUsers();

    public User findUsersByUsername(String username);

    public Long countUsersByUsername(String username);


}
