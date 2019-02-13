package vip.housir.bookspider.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vip.housir.bookspider.entity.Domain;
import vip.housir.bookspider.mapper.DomainMapper;
import vip.housir.bookspider.service.DomainService;

/**
 * @author housirvip
 */
@Service
@RequiredArgsConstructor
public class DomainServiceImpl implements DomainService {

    private final DomainMapper domainMapper;

    @Override
    public Domain oneById(Integer id) {

        return domainMapper.selectByPrimaryKey(id);
    }
}
