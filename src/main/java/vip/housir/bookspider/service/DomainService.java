package vip.housir.bookspider.service;

import vip.housir.bookspider.entity.Domain;

/**
 * @author housirvip
 */
public interface DomainService {

    /**
     * 根据主键，返回一条结果
     *
     * @param id Integer
     * @return Domain
     */
    Domain oneById(Integer id);
}
