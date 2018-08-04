package cloud.gateway.core.repositories;

import cloud.gateway.core.models.SysDict;
import cloud.gateway.core.repositories.base.BaseDaoRepo;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/10.
 */
public interface SysDictRepo extends BaseDaoRepo<SysDict> {
    public List<SysDict> findAll() throws Exception;
    public List<SysDict> findByType(String type) throws Exception;
    public void doSave(SysDict dict) throws Exception;
    public void doUpdate(SysDict dict) throws Exception;
    public void doDelete(String id) throws Exception;
    SysDict findById(String id) throws Exception;
    List<SysDict> findByPid(String pid) throws Exception;
    public List<SysDict> findByXzdw(String xzdw, String type)throws Exception;

    /**
     *
     * @date: 2017年9月6日
     * @Author: yunpeng
     * @Email:
     * @param: xzdw type(XZDW)字段编码
     * @return:镇江市获取下级的行政区划
     */
    List<SysDict> findByXzdwAndXj(String xzdw, String type) throws Exception;
    /**
     *
     * @date: 2017年9月6日
     * @Author: yunpeng
     * @Email:
     * @param: xzdw type(XZDW)字段编码
     * @return:其他获取下级的行政区划
     */
    List<SysDict> findByXzdwAndXjdw(String xzdw, String type) throws Exception;
    List<SysDict> findByBjdwAndXjdw(String xzdw, String type) throws Exception;
    /**
     * 根据id查询所有子节点，不包含自己
     * @return
     */
    List<SysDict> getLinkageById(String id)throws Exception;
    /**
     * 根据id查询所有子节点，包含自己
     * @return
     */
    List<SysDict> getLinkage(String id)throws Exception;
    /**
     * 统计数量
     * @param pid
     * @return
     */
    Integer getCountBySql(String pid);
    /**
     * 统计全部数量
     * @param
     * @return
     */
    Integer getCount();
    /**
     * 根据id查询下一级所有菜单
     * @param pid
     * @return
     */
    List<SysDict> getByNote(String pid);
    /**
     * 根据id查询下一级所有菜单的数量
     * @param id
     * @return
     */
    Integer countByNote(String id);
    /**
     * 根据id查询所有父节点
     * @param id
     * @return
     */
    List<SysDict> findUpByid(String id);

    public List<SysDict> findByPid2(String pid) throws Exception;


    void importExecl(List<SysDict> list, Map map) throws Exception;
}
