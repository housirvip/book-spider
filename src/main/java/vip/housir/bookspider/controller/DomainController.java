package vip.housir.bookspider.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.housir.bookspider.entity.Domain;
import vip.housir.bookspider.entity.KeyValue;
import vip.housir.bookspider.service.DomainService;
import vip.housir.bookspider.service.RuleService;
import vip.housir.bookspider.utils.JsonUtils;

/**
 * @author housirvip
 */
@RestController
@RequestMapping(value = "/domain")
@RequiredArgsConstructor
public class DomainController {

    private final DomainService domainService;

    private final RuleService ruleService;

    @GetMapping(value = "/{id}")
    public Domain add(@PathVariable Integer id) {

        Domain domain = domainService.oneById(id);
        domain.setRules(ruleService.allByDomainId(id));
        domain.getRules().forEach(rule -> {
            rule.setPatterns(JsonUtils.convertToList(rule.getPattern(), KeyValue.class));
            rule.setPattern(null);
        });

        return domain;
    }
}
