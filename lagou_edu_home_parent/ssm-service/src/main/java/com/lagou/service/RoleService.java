package com.lagou.service;

import com.lagou.domain.*;

import java.util.List;

public interface RoleService {

    /*
        查询所有角色
     */
    public List<Role> findAllRole(Role role);

    /*
        新增角色
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
    为角色分配菜单
 */
    public void roleContextMenu(RoleMenuVo roleMenuVo);

    /*
    删除角色
 */
    public void deleteRole(Integer roleId);

    /*
        根据角色id查询角色拥有的资源信息
    */
    public List<ResourceCategory> findResourceByRoleId(Integer id);

    public void roleContextResource(RoleResourceVo roleResourceVo);

}
