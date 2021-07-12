package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

public interface RoleMapper {

    /*
        查询所有角色&条件进行查询
     */
    public List<Role> findAllRole(Role role);

    /*
        新建角色
     */
    public void saveRole(Role role);

    /*
        通过id查询角色
     */
    public Role findRoleById(int id);

    /*
        修改角色信息
     */
    public void updateRole(Role role);

    /*
        根据角色id查询该角色关联的菜单信息id
     */
    public List<Integer> findMenuByRoleId(Integer roleId);

    /*
        根据roleId清空中间表的关联关系
     */
    public void deleteRoleContextMenu(Integer rid);

    /*
        为角色分配菜单信息
     */
    public void roleContextMenu(Role_menu_relation role_menu_relation);

    /*
        删除角色
     */
    public void deleteRole(Integer roleId);

    /*
        根据角色id查询角色拥有的资源信息
    */
    public List<Resource> findResourceByRoleId(Integer id);

    /**
     * 查询该角色的拥有的资源分类
     */
    public List<ResourceCategory> findResourceCategoryByRoleId(Integer roleId);

    /**
     *  根据角色ID 删除角色与资源的关联关系
     */
    public void deleteResourceByRoleId(Integer roleId);

    /**
     * 为角色分配资源
     */
    public void saveResourceToRoleId(RoleResourceRelation roleResourceRelation);



}
