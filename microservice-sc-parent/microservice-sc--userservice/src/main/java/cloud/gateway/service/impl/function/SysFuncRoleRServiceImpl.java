package cloud.gateway.service.impl.function;

import cloud.gateway.core.models.function.SysFuncRoleR;
import cloud.gateway.core.pagination.Page;
import cloud.gateway.core.repositories.function.SysFuncRoleRRepo;
import cloud.gateway.service.function.SysFuncRoleRService;
import com.alibaba.dubbo.common.utils.StringUtils;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/9.
 */
@Service(version = "1.1.0.0")
public class SysFuncRoleRServiceImpl implements SysFuncRoleRService {
    @Autowired
    SysFuncRoleRRepo sysFuncRoleRRepo;
    @Override
    public void add(SysFuncRoleR bean) throws Exception {
        sysFuncRoleRRepo.add(bean);
    }

    @Override
    public void saveOrUpdate(SysFuncRoleR bean) throws Exception {

    }

    @Override
    public void delete(SysFuncRoleR bean) throws Exception {
        SysFuncRoleR roleR = new SysFuncRoleR();
        roleR.setId(bean.getId());
        sysFuncRoleRRepo.delete(roleR);
    }

    @Override
    public void update(SysFuncRoleR bean) throws Exception {
        sysFuncRoleRRepo.update(bean);
    }

    @Override
    public SysFuncRoleR getById(String id) throws Exception {
        return sysFuncRoleRRepo.getByArgs("SysFuncRoleR",new String[]{"id"},new String[]{id});
    }

    @Override
    public Page<SysFuncRoleR> getListByPage(SysFuncRoleR obj, Page<SysFuncRoleR> page, String orderBySql) throws Exception {
        StringBuffer buffer = new StringBuffer();
        String selectHql = "select a from SysFuncRoleR a ";
        String countHql = "select count(*) from SysFuncRoleR a ";
        if(!StringUtils.isBlank(obj.getFunc_Code())){ //条件的拼接
            buffer.append("and a.func_Code = '"+obj.getFunc_Code()+"' ");
        }
        if(!StringUtils.isBlank(obj.getFunc_Name())){
            buffer.append("and a.name like '%"+obj.getFunc_Name()+"%' ");
        }
        if(!StringUtils.isBlank(obj.getFunc_Id())){
            buffer.append("and a.id = '"+obj.getFunc_Id()+"' ");
        }
        if(!StringUtils.isBlank(obj.getRole_Id())){
            buffer.append("and a.role_Id = "+obj.getRole_Id()+" ");
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
        Page<SysFuncRoleR> pageResponse =  sysFuncRoleRRepo.getListPageByHql(selectHql,countHql,page);
        return pageResponse;
    }

    @Override
    public List<SysFuncRoleR> getListByHql(SysFuncRoleR obj, String orderBySql) throws Exception {
        StringBuffer buffer = new StringBuffer();
        String selectHql = "select a from SysFuncRoleR a ";
        if(!StringUtils.isBlank(obj.getRole_Id())){ //条件的拼接
            buffer.append("and a.role_Id = '"+obj.getRole_Id()+"' ");
        }
        if(!StringUtils.isBlank(obj.getFunc_Id())){
            buffer.append("and a.id = '"+obj.getFunc_Id()+"' ");
        }
        if(!StringUtils.isBlank(obj.getDeleted())){
            buffer.append("and a.deleted = "+obj.getDeleted()+" ");
        }
        if(!StringUtils.isBlank(obj.getAuthuser())){
            buffer.append("and a.authuser = "+obj.getAuthuser()+" ");
        }
        String cotentHql = buffer.toString();
        if(!StringUtils.isBlank(cotentHql)){ //如果有条件则截取拼接到
            selectHql = selectHql + "where "+cotentHql.substring(cotentHql.indexOf("a."));
        }
        selectHql = selectHql+orderBySql;
        List<SysFuncRoleR> sysUserOrgRS = sysFuncRoleRRepo.getListByHql(selectHql);
        return sysUserOrgRS;
    }

    @Override
    public List<Map<String, Object>> findAllBySql(SysFuncRoleR obj, Map<String, Object> paramMap) {
        return null;
    }

    @Override
    public boolean deleteFunRoleByRoleId(SysFuncRoleR bean) {
        String sql = "delete from SYS_FUNC_ROLE_R where ROLE_ID='"+bean.getRole_Id()+"'";
        try {
            sysFuncRoleRRepo.deleteSql(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
