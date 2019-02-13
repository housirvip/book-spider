package vip.housir.bookspider.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vip.housir.bookspider.entity.Rule;
import vip.housir.bookspider.mapper.DomainMapper;
import vip.housir.bookspider.mapper.RuleMapper;
import vip.housir.bookspider.service.RuleService;

import java.util.List;

/**
 * @author housirvip
 */
@Service
@RequiredArgsConstructor
public class RuleServiceImpl implements RuleService {

    private final DomainMapper domainMapper;
    private final RuleMapper ruleMapper;

    @Override
    public Rule oneById(Integer id) {

        return ruleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Rule> allByDomainId(Integer domainId) {

        return ruleMapper.selectAllByDomainId(domainId);
    }
}
