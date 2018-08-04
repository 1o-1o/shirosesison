package cloud.gateway.service.impl;

import cloud.gateway.core.models.Role;
import cloud.gateway.core.pagination.Page;
import cloud.gateway.core.repositories.RoleRepo;
import cloud.gateway.core.util.BeanUtils;
import cloud.gateway.service.RoleService;
import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Service(version="1.1.0.0")
public class RoleServiceImpl implements RoleService {

	Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private RoleRepo roleRepo;
	/*
        @Override
        public List<Role> findAll() {
            logger.debug("findAll :");
            try {
                 List<Role> list = roleRepo.getRoleList();
                 return list;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                logger.error("findAll :", e);
                return null;
            }
        }
        @Override
        public List<Role> findBySiteid(String siteid) {
            logger.debug("findAll :");
            try {
                 List<Role> list = roleRepo.getRoleListBySiteid(siteid);
                 return list;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                logger.error("findAll :", e);
                return null;
            }
        }
        *//*@Override
	public Role findById(Integer id) {
		logger.debug("findById :"+id);
		 try {
			Role role = null; ////roleRedisRepo.findRole(id.toString());// roleRepo.getRoleById(id.toString())
			if(role == null){
			    role = roleRepo.getRoleById(id.toString());
			    if(role != null){
			    	List<RoleResource> list = rpRepo.getResource(id);
			    	for(RoleResource rp : list){
			    		Resource p = null;//ResourceRedisRepo.findResource(rp.getResourceId().toString());缓存
			    		if(p==null){
			    			p = ResourceRepo.getResources(rp.getResourceId());
			    			if(p!=null)
			    				ResourceRedisRepo.saveResource(p);
			    		}
			    		if(p!=null)
			    			role.getResources().add(p);
			    	}
			    	roleRedisRepo.saveRole(role);
			    }			   

//				if(menuByRoleid != null && menuByRoleid.size()!=0){
//					for(Map<String, Object> map:menuByRoleid){
//						Resource Resource2 = new Resource();
//						Object Resource = map.get("Resource");
//						if(Resource != null)
//							Resource2.setResource(Resource.toString());						
//						Object available = map.get("AVAILABLE");
//						if(available != null)
//							Resource2.setAvailable(Integer.valueOf(available+""));
//						Object object = map.get("PARENTIDS");
//						if(object != null)
//							Resource2.setParentId(Integer.valueOf(object.toString()));
////						Object object2 = map.get("ORDERNUM");
//						Object object3 = map.get("PARENTID");
//						if(object3 != null)
//							Resource2.setParentId(Integer.valueOf(object3+""));
////						Object object4 = map.get("SITE_ID");
//						if(object4 != null)
//							Resource2.set
//						Object object5 = map.get("ID");
//						if(object5 != null)
//							Resource2.setId(Integer.valueOf(object5+""));
//						Object object6 = map.get("TYPE");
//						if(object6 != null)
//							Resource2.setType(object6+"");
//						Object object7 = map.get("URL");
//						Resource2.
//						Object object8 = map.get("NAME");
//					}
//				}
			}
			return role;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("findById :", e);
		}
		 
		return null;
	}*//*
	/*
	@Override
	public boolean deleteRoleResourceByRoleid(Integer roleid) {
		
		try {
			logger.debug("deleteRolePermisionByRoleid :"+roleid);
			rpRepo.doDelByRole(roleid);
			//更新相关的角色
			//roleRepo.doDelete(roleid);
			//roleRedisRepo.deleteRole(roleid.toString());
			return true;			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("deleteRolePermisionByRoleid :", e);
		}
		// TODO Auto-generated method stub
		return false;
	}
	*//*@Override
	public List<Resource> getResourceByRoleid(Integer roleid){
		logger.debug("getResourceByRoleid :"+roleid);
		try {
			Role role = findById(roleid);
			if(role !=null)
				return role.getResources();
		} catch (Exception e) {
			logger.error("getResourceByRoleid :", e);
		}
		return new ArrayList<Resource>();
	}*//*
	
	@Override
	public List<Map<String, Object>> getResource(Integer id) {
		logger.debug("getResource :"+id);
		List<Map<String, Object>> menuByRoleid = null;
		try {
			menuByRoleid = roleRepo.getMenuByRoleid(id.toString());
		} catch (Exception e) {
			logger.error("getResource :", e);
			return new ArrayList<Map<String, Object>>();
		}
		return menuByRoleid;
	}*/
	@Override
	public boolean save(Role bean) {

		try {
			logger.debug("save :"+bean);
			roleRepo.doAdd(bean);
			/*for(Resource p : bean.getResources()){
				RoleResource rp = new RoleResource();
				rp.setResourceId(p.getId());
				rp.setRoleId(bean.getId());
				rpRepo.doAdd(rp);
			}
			roleRedisRepo.saveRole(bean);*/
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("save :", e);
		}
		return false;
	}
	@Override
	public Role findRoleByRoleName(String roleName)throws Exception{
		Role role = roleRepo.findRoleByRoleName(roleName);
		if(BeanUtils.isBlank(role)){
			return null;
		}
		return role;
	}
	@Override
	public List<Object> findPage(String[] columns, String[] values,Integer page,Integer rows){
		Page<Role> pageUser = new Page<Role>(page, rows);

		try {
			List<Object> list = roleRepo.findPage(columns, values, pageUser);
			if(list.isEmpty()){
				return null;
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Object> getRoleList(Integer page, Integer rows){
		logger.debug("getRoleList :"+page+"--"+rows);
		Page<Role> p = new Page<Role>(page, rows);
		List<Role> list = new ArrayList<Role>();
		try {
			list = this.roleRepo.getRoleListPage(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("getRoleList :", e);
		}
		List<Object> o = new ArrayList<Object>();
		o.add(list);
		o.add(p);
		return o;
	}

	@Override
	public void add(Role bean) throws Exception {

	}

	@Override
	public void saveOrUpdate(Role bean) throws Exception {

	}

	@Override
	public void delete(Role bean) throws Exception {

	}

	@Override
	public void update(Role bean) throws Exception {

	}

	@Override
	public boolean update2(Role bean) {
		try {
			logger.debug("update :"+bean.getId());
			roleRepo.doUpdate(bean);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("update :", e);
		}
		return false;
	}

	@Override
	public Role getById(String id) throws Exception {
		return null;
	}

	@Override
	public Page<Role> getListByPage(Role obj, Page<Role> page, String orderBySql) throws Exception {
		StringBuffer buffer = new StringBuffer();
		String selectHql = "select a from Role a where a.deleted!=1 ";
		String countHql = "select count(*) from Role a where a.deleted!=1 ";

		if(obj != null){
			if(!StringUtils.isEmpty(obj.getRoleName())){
				buffer.append(" and a.roleName like '%"+obj.getRoleName()+"%' ");
			}
		}
		String cotentHql = buffer.toString();
		/*if(!StringUtils.isBlank(cotentHql)){ //如果有条件则截取拼接到
			selectHql = selectHql + "where "+cotentHql.substring(cotentHql.indexOf("a."));
			countHql = countHql + "where "+cotentHql.substring(cotentHql.indexOf("a."));
		}*/
		selectHql=selectHql+cotentHql+orderBySql;//查询
		countHql=countHql+cotentHql;//统计
		//默认必须传入page，如果不想分页，那传入一个大值也行
		Page<Role> pageResponse =  roleRepo.getListPageByHql(selectHql,countHql,page);
		return pageResponse;
	}

	@Override
	public List<Role> getListByHql(Role obj, String orderBySql) throws Exception {
		return null;
	}

	@Override
	public List<Map<String, Object>> findAllBySql(Role obj, Map<String, Object> paramMap) {
		return null;
	}
	@Override
	public Role findById(String id){
		try {
			Role role = roleRepo.getRoleById(id);
			return role;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean delete(String id) {

		logger.debug("delete :"+id);
		try {
			String[] split = id.split(",");
			if(split.length == 0){
				return false;
			}
			for(int i=0;i<split.length;i++){
				roleRepo.doDelete(split[i]);
			}
			return true;
		} catch (Exception e) {
			logger.error("userDelete"+"删除失败");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 查询所有角色
	 * @return
     */
	@Override
	public List<Role> findAll() {
		try {
			List<Role> list = roleRepo.getRoleList();
			if(list.size()==0 || list.isEmpty()){
				return null;
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据用户名和站点获取角色集合
	 * @param username
	 * @param siteId
	 * @return
	 */
	@Override
	public List<Role> getRolesByUserNameAndSiteId(String username, String siteId) {
		String hql = "select r from User u,SysUserRoleR ur,Role r where u.userid=ur.userId and ur.roleId=r.id ";
		if(!StringUtils.isEmpty(username)){
			hql += " and u.username='"+username+"'";
		}
		if(!StringUtils.isEmpty(siteId)){
			if(Integer.valueOf(siteId) !=0){
				hql += " and r.siteId="+siteId;
			}
		}
		String orderByStr = "";
		try {
			List<Role> roleList = roleRepo.getListByHql(hql+orderByStr);
			return roleList;
		} catch (Exception e) {
			e.printStackTrace();
			return new ArrayList<Role>();
		}
	}
}
