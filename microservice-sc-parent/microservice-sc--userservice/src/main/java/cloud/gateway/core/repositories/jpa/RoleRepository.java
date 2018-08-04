package cloud.gateway.core.repositories.jpa;


import cloud.gateway.core.dao.IJdbcDao;
import cloud.gateway.core.models.Role;
import cloud.gateway.core.pagination.Page;
import cloud.gateway.core.repositories.BaseRepo;
import cloud.gateway.core.repositories.RoleRepo;
import cloud.gateway.core.repositories.base.BaseDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class RoleRepository extends BaseDaoRepository<Role> implements RoleRepo {

	@Autowired 
	private BaseRepo<Role> baseService;
	
	@Autowired
	protected IJdbcDao jdbcDao;
	
	@Override
	public List<Role> getRoleListPage(Page<Role> page) throws Exception{
		List<Role> list = this.baseService.getListPage("Role", new String[]{}, new String[]{}, " order by createDate desc ", page);
		return list;
	}

	@Override
	public List<Role> getRoleListPage() throws Exception {
		List<Role> list = this.baseService.findByPage("Role", new String[]{}, new String[]{});
		return list;
	}

	@Override
	public void doAdd(Role role) throws Exception {
		this.baseService.add(role);
	}

	@Override
	public void doUpdate(Role role) throws Exception {
		this.baseService.update(role);
	}

	@Override
	public void doDelete(Role role) throws Exception {
		this.baseService.delete(role);
	}
	@Override
	public void doDelete(String id) throws Exception {
		String sql = "delete from SYS_ROLE where ROLE_ID=:id ";
		Map<String, Object> paramMap = new HashMap<String, Object>();  
	    paramMap.put("id", id);  
		this.jdbcDao.delete(sql, paramMap);
	}

	@Override
	public List<Role> getRoleList() throws Exception {
		List<Role> list = this.baseService.getAllList("Role");
		return list;
	}
	
	@Override
	public List<Role> getRoleListBySiteid(String site_id) throws Exception {
		List<Role> list = this.baseService.findByWhere("Role", new String[]{"siteid"}, new String[]{site_id});
		return list;
	}

	@Override
	public Role getRoleById(String id) throws Exception {
		return this.baseService.getUnique("Role", new String[]{"id","deleted"}, new String[]{id,"0"});
	}
	@Override
	public List<Map<String, Object>> getMenuByRoleid(String id) throws Exception {
		String sql = "select p.* from U_role r join u_role_permission rp on r.id=rp.role_id join (select * from u_permission where id<>1 and type='menu' and available='1') p on rp.resource_id=p.id where p.id<>1 and r.id=:id order by ordernum ";
		Map<String, Object> paramMap = new HashMap<String, Object>();  
		paramMap.put("id", id);
		
		List<Map<String, Object>> find = this.jdbcDao.findAll(sql, paramMap);
		return find;
	}

	@Override
	public Role findRoleByRoleName(String roleName) throws Exception {

		return this.baseService.getUnique("Role", new String[]{"roleName"}, new String[]{roleName});
	}
	@Override
	public List<Object> findPage(String[] columns, String[] values,Page<Role> page)throws Exception{

		List<Role> list = baseService.getListPage("Role", columns, values, page);
		if(list.size() == 0 || list.isEmpty()){
			return null;
		}

		List<Object> o = new ArrayList<Object>();
		o.add(list);
		return o;
	}

	@Override
	public Page<Role> getListPageByHql(String hql, String counthql, Page<Role> page) throws Exception {
		return baseService.getListPageByHql(hql,counthql,page);
	}


}
