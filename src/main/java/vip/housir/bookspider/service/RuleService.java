package vip.housir.bookspider.service;

import vip.housir.bookspider.entity.Rule;

import java.util.List;

/**
 * @author housirvip
 */
public interface RuleService {

    /**
     * 根据主键，返回一条结果
     *
     * @param id Integer
     * @return Domain
     */
    Rule oneById(Integer id);

    /**
     * 根据主键，返回全部结果
     *
     * @param domainId Integer
     * @return List
     */
    List<Rule> allByDomainId(Integer domainId);
}
