package vip.housir.bookspider.mapper;

import org.apache.ibatis.annotations.Mapper;
import vip.housir.bookspider.entity.Rule;

import java.util.List;

/**
 * @author housirvip
 */
@Mapper
public interface RuleMapper {
    /**
     * 通过主键删除
     *
     * @param id Integer
     * @return int 删除的行数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条记录返回值为 ID，对象中属性值为 null，则数据库赋值为 null
     *
     * @param record Rule
     * @return int
     */
    int insert(Rule record);

    /**
     * 插入一条记录返回值为 ID，对象中属性值为 null 则不赋值，取数据库默认值
     *
     * @param record Rule
     * @return int
     */
    int insertSelective(Rule record);

    /**
     * 根据主键查询记录，返回一条记录或者 null
     *
     * @param id Integer
     * @return Rule
     */
    Rule selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新记录，返回受影响的记录数
     * 对象中属性值为 null，则不赋值
     *
     * @param record Rule
     * @return int
     */
    int updateByPrimaryKeySelective(Rule record);

    /**
     * 根据主键更新记录，返回受影响的记录数
     * 对象中属性值为 null，则数据库赋值为 null
     *
     * @param record Rule
     * @return int
     */
    int updateByPrimaryKeyWithBLOBs(Rule record);

    /**
     * 根据主键更新记录，返回受影响的记录数
     * 对象中属性值为 null，则数据库赋值为 null
     *
     * @param record Rule
     * @return int
     */
    int updateByPrimaryKey(Rule record);

    /**
     * 根据 domainId 查询所有结果
     *
     * @param domainId Integer
     * @return List
     */
    List<Rule> selectAllByDomainId(Integer domainId);
}