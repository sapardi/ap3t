package com.jasoet.ap3t.service.impl;

import com.jasoet.ap3t.domain.Group;
import com.jasoet.ap3t.domain.Role;
import com.jasoet.ap3t.domain.User;
import com.jasoet.ap3t.service.SpringSecurityService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


@Service("springSecurityService")
@Transactional
public class SpringSecurityServiceImpl implements SpringSecurityService {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void save(Role role) {
        sessionFactory.getCurrentSession().saveOrUpdate(role);
    }

    @Override
    public void delete(Role role) {
        if (role != null && role.getAuthority() != null) {
            sessionFactory.getCurrentSession().delete(role);
        }
    }

    @Override
    public Role findRole(String authority) {
        if (authority == null) return null;
        return (Role) sessionFactory.getCurrentSession().get(Role.class, authority);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Role> findRoles() {
        return sessionFactory.getCurrentSession().createQuery("from Role o order by o.authority").list();
    }

    @Override
    public Long countRoles() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Role o").uniqueResult();
    }


    @Override
    public void save(Group group) {
        sessionFactory.getCurrentSession().saveOrUpdate(group);
    }

    @Override
    public void delete(Group group) {
        if (group != null && group.getId() != null) {
            sessionFactory.getCurrentSession().delete(group);
        }
    }

    @Override
    public Group findGroup(Long id) {
        if (id == null) return null;
        return (Group) sessionFactory.getCurrentSession().get(Group.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Group> findGroups() {
        return sessionFactory.getCurrentSession().createQuery("from Group o order by o.name").list();
    }

    @Override
    public Long countGroups() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Group o").uniqueResult();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Group> findGroupsByName(String name) {
        if (!StringUtils.hasLength(name)) return new ArrayList<Group>();

        return sessionFactory.getCurrentSession().createQuery("from Group o where lower(o.name) like :name order by o.name")
                .setString("name", "%" + name.toLowerCase() + "%").list();
    }

    @Override
    public Long countGroupsByName(String name) {
        if (!StringUtils.hasText(name)) return 0L;
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from Group o where o.name like :name")
                .setString("name", "%" + name + "%").uniqueResult();
    }

    @Override
    public void save(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    @Override
    public void delete(User user) {
        if (user != null && user.getId() != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public User findUser(Long id) {
        if (id == null) return null;
        return (User) sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User o order by o.username").list();
    }

    @Override
    public Long countUsers() {
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from User o").uniqueResult();
    }

    @Override
    public User findUsersByUsername(String username) {
        if (!StringUtils.hasLength(username)) {
            return null;
        }

        return (User) sessionFactory.getCurrentSession().createQuery("from User o where o.username like :username")
                .setString("username", username).uniqueResult();
    }

    @Override
    public Long countUsersByUsername(String username) {
        if (!StringUtils.hasText(username)) return 0L;
        return (Long) sessionFactory.getCurrentSession().createQuery("select count(o) from User o where o.username like :username")
                .setString("username", "%" + username + "%").uniqueResult();
    }
}
