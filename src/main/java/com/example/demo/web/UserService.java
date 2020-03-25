package com.example.demo.web;

import com.example.demo.web.domain.SysRole;
import com.example.demo.web.domain.SysUser;
import com.example.demo.web.domain.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author yg
 * description
 * 数据库初始化sql:
 * CREATE TABLE `sys_user` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT,
 *   `name` varchar(255) NOT NULL,
 *   `password` varchar(255) NOT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * CREATE TABLE `sys_role` (
 *   `id` int(11) NOT NULL,
 *   `name` varchar(255) NOT NULL,
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 * CREATE TABLE `sys_user_role` (
 *   `user_id` int(11) NOT NULL,
 *   `role_id` int(11) NOT NULL,
 *   PRIMARY KEY (`user_id`,`role_id`),
 *   KEY `fk_role_id` (`role_id`),
 *   CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
 *   CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 *
 * INSERT INTO `sys_role` VALUES ('1', 'ROLE_ADMIN');
 * INSERT INTO `sys_role` VALUES ('2', 'ROLE_USER');
 *
 * INSERT INTO `sys_user` VALUES ('1', 'admin', '123');
 * INSERT INTO `sys_user` VALUES ('2', 'jitwxs', '123');
 *
 * INSERT INTO `sys_user_role` VALUES ('1', '1');
 * INSERT INTO `sys_user_role` VALUES ('2', '2');
 *
 * date 2020/3/26
 */
@Service
public class UserService {

    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysRoleMapper roleMapper;
    @Autowired
    private SysUserRoleMapper userRoleMapper;


    public SysUser selectByUserId(Integer id) {
        return userMapper.selectById(id);
    }

    public SysUser selectByUserName(String name) {
        return userMapper.selectByName(name);
    }
    public SysRole selectByRoleId(Integer id){
        return roleMapper.selectById(id);
    }
    public List<SysUserRole> listByUserId(Integer userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
