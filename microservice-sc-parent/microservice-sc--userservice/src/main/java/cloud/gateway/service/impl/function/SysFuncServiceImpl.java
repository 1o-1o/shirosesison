package cloud.gateway.service.impl.function;

import cloud.gateway.core.models.function.SysFunc;
import cloud.gateway.core.pagination.Page;
import cloud.gateway.core.repositories.function.SysFuncRepo;
import cloud.gateway.service.function.SysFuncService;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/8.
 */
@Service(version = "1.1.0.0")
public class SysFuncServiceImpl implements SysFuncService {

    @Autowired
    SysFuncRepo sysFuncRepo;

    @Override
    public void add(SysFunc bean) throws Exception {
        sysFuncRepo.add(bean);
    }

    @Override
    public void saveOrUpdate(SysFunc bean) throws Exception {
        sysFuncRepo.saveOrUpdate(bean);
    }

    @Override
    public void delete(SysFunc bean) throws Exception {
        sysFuncRepo.delete(bean);
    }

    @Override
    public void update(SysFunc bean) throws Exception {
        sysFuncRepo.update(bean);
    }

    @Override
    public SysFunc getById(String id) throws Exception {
        return sysFuncRepo.getByArgs("SysFunc",new String[]{"id"},new String[]{id});
    }

    @Override
    public Page<SysFunc> getListByPage(SysFunc obj, Page<SysFunc> page, String orderBySql) throws Exception {
        StringBuffer buffer = new StringBuffer();
        String selectHql = "select a from SysFunc a ";
        String countHql = "select count(*) from SysFunc a ";
        if(!StringUtils.isBlank(obj.getFunc_Code())){ //条件的拼接
            buffer.append("and a.func_Code = '"+obj.getFunc_Code()+"' ");
        }
        if(!StringUtils.isBlank(obj.getName())){
            buffer.append("and a.name like '%"+obj.getName()+"%' ");
        }
        if(!StringUtils.isBlank(obj.getPid())){
            buffer.append("and a.pid = '"+obj.getPid()+"' ");
        }
        if(!StringUtils.isBlank(obj.getDeleted())){
            buffer.append("and a.deleted = "+obj.getDeleted()+" ");
        }
        String cotentHql = buffer.toString();
        if(!StringUtils.isBlank(cotentHql)){ //如果有条件则截取拼接到
            selectHql = selectHql + "where "+cotentHql.substring(cotentHql.indexOf("a."));
            countHql = countHql + "where "+cotentHql.substring(cotentHql.indexOf("a."));
        }
        selectHql = selectHql+orderBySql;
        //默认必须传入page，如果不想分页，那传入一个大值也行
        Page<SysFunc> pageResponse =  sysFuncRepo.getListPageByHql(selectHql,countHql,page);
        return pageResponse;
    }

    @Override
    public List<SysFunc> getListByHql(SysFunc obj, String orderBySql) throws Exception {
        StringBuffer buffer = new StringBuffer();
        String selectHql = "select a from SysFunc a ";
        if(obj != null){
//            if(!StringUtils.isBlank(obj.getFunc_Code())){ //条件的拼接
//                buffer.append("and a.func_Code = '"+obj.getFunc_Code()+"' ");
//            }
            if(obj.getIds() != null && obj.getIds().size() != 0){
                String delString = "";
                for(String id:obj.getIds()){
                    delString +="'"+id+"',";
                }
                delString = delString.substring(0,delString.lastIndexOf(","));
                buffer.append(" and a.id in ("+delString+") ");
            }
//            if(!StringUtils.isBlank(obj.getName())){
//                buffer.append("and a.name like '%"+obj.getName()+"%' ");
//            }
//            if(!StringUtils.isBlank(obj.getPid())){
//                buffer.append("and a.pid = '"+obj.getPid()+"' ");
//            }
        }
        String cotentHql = buffer.toString();
        if(!StringUtils.isBlank(cotentHql)){ //如果有条件则截取拼接到
            selectHql = selectHql + "where "+cotentHql.substring(cotentHql.indexOf("a."));
        }
        selectHql = selectHql+orderBySql;
        return sysFuncRepo.getListByHql(selectHql);
    }

    @Override
    public List<Map<String, Object>> findAllBySql(SysFunc obj, Map<String, Object> paramMap) {
        return null;
    }

    @Override
    public List selectIdAndName() {
        String sql = "select id,name from SYS_FUNC";
        return sysFuncRepo.selectIdAndName(sql);
    }

    @Override
    public List<String> selectAllLeafsByPid(List<String> idList,String pid) {
        String sql = "select id from SYS_FUNC where pid ='"+pid+"'";
        try {
            List<Map<String,Object>> result = sysFuncRepo.findAllBySql(sql,new HashMap<String,Object>());
            if(result == null || result.size() == 0){
                return idList;
            }
            for(Map<String,Object> map:result){
                String id = map.get("ID").toString();
                if(StringUtils.isBlank(id)){
                    continue;
                }
                idList = selectAllLeafsByPid(idList,id); //把它的叶子的id添加到集合中
                idList.add(id); //把它本身也添加进集合
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idList;
    }
    @Override
    public void deleteAllLeafsByIds(List<String> ids){
        if(ids != null && ids.size() != 0){
            String delString = "";
            for(String id:ids){
                delString +="'"+id+"',";
            }
            delString = delString.substring(0,delString.lastIndexOf(","));
            String sql = "delete from SYS_FUNC where id in ("+delString+")";
            try {
                sysFuncRepo.deleteSql(sql);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<String> selectAllLeafsByPidWithSql(String pid) {
        String sql ="select id from sys_func start with pid='"+pid+"' connect by prior id=pid";
        List<String> list = new ArrayList<>();
        try {
            List<Map<String,Object>> result = sysFuncRepo.findAllBySql(sql,new HashMap<String,Object>());
            if(result == null){
                return list;
            }
            for(Map<String,Object> map:result){
                String id = map.get("ID").toString();
                if(StringUtils.isBlank(id)){
                    continue;
                }
                list.add(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<SysFunc> selectSysFuncByUserName(Map<String,Object> map) {
        if(map == null || map.isEmpty()){
            return new ArrayList<SysFunc>();
        }
        String hql = "select  distinct f from User u,SysUserRoleR ur,Role r,SysFuncRoleR fr,SysFunc f where u.userid = ur.userId and ur.roleId=r.id " +
                "and r.id=fr.role_Id and fr.func_Id=f.id and u.deleted !=1  and u.username='"+map.get("username")+"' ";
        if(map.get("funcType") != null){
            hql += " and f.func_Type='"+map.get("funcType").toString()+"'";
        }
        if(map.get("siteId") != null){
            hql += " and f.siteId='"+map.get("siteId").toString()+"'";
        }
        String orderByStr = " order by f.func_Type,f.func_Seq";
        try {
            List<SysFunc> sysFuncs = sysFuncRepo.getListByHql(hql+orderByStr);
            return sysFuncs;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<SysFunc>();
        }
    }

    @Override
    public List<String> findByPid(String id) {
        String sql ="select id from  SYS_FUNC start with id='"+id+"' connect by prior pid=id";
        List<String> list = new ArrayList<>();
        try {
            List<Map<String,Object>> result = sysFuncRepo.findAllBySql(sql,new HashMap<String,Object>());
            if(result == null){
                return list;
            }
            for(Map<String,Object> map:result){
                String Id = map.get("ID").toString();
                if(StringUtils.isBlank(Id)){
                    continue;
                }
                list.add(Id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据用户名，到功能表上筛选出该用户的所有站点
     * @param map
     * @return
     */
    @Override
    public List<String> selectSiteIdByUserName(Map map) {
        List<String> result = new ArrayList<String>();
        if(map == null || map.isEmpty()){
            return result;
        }
        String sql = "select  distinct f.siteid from sys_user u,Sys_User_Role_R ur,sys_role r,Sys_Func_Role_R fr,Sys_Func f where u.user_id = ur.user_Id " +
                "and ur.role_Id=r.role_Id and r.role_Id=fr.role_Id and fr.func_Id=f.id and u.deleted !=1 and u.status =1 ";
        if(map.get("username") != null){
            sql += "and u.user_name='"+map.get("username")+"' ";
        }
        if(map.get("funcType") != null){
            sql += " and f.func_Type='"+map.get("funcType").toString()+"'";
        }
        if(map.get("siteId") != null){
            sql += " and f.siteid='"+map.get("siteId").toString()+"'";
        }
//        String orderByStr = " order by f.func_Type,f.func_Seq";
        try {
            List<Map<String,Object>> siteIdByArgs = sysFuncRepo.selectSiteIdByArgs(sql);
            if(siteIdByArgs != null && siteIdByArgs.size() != 0 ){
                for(Map<String,Object> funcMap:siteIdByArgs){
                    Object siteIdObj = funcMap.get("SITEID");
                    if(siteIdObj != null &&!StringUtils.isEmpty(siteIdObj.toString())){
                        result.add(siteIdObj.toString());
                    }
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        }
    }
}
