package vip.housir.bookspider.common;

import com.github.pagehelper.PageHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import vip.housir.bookspider.entity.PageDto;

/**
 * @author housirvip
 */
@Aspect
@Component
public class PageHelperAop {

    @Before("execution(public com.github.pagehelper.Page vip.housir.bookspider.service.*Service.page*(..))")
    public void doBefore(JoinPoint joinPoint) {

        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }

        PageDto pageDto = null;
        for (Object arg : args) {
            if (arg instanceof PageDto) {
                pageDto = (PageDto) arg;
            }
        }
        if (pageDto == null) {
            pageDto = new PageDto(Constant.PAGE_NUM_VALUE, Constant.PAGE_SIZE_VALUE);
        }
        if (pageDto.getPageNum() == null) {
            pageDto.setPageNum(Constant.PAGE_NUM_VALUE);
        }
        if (pageDto.getPageSize() == null) {
            pageDto.setPageSize(Constant.PAGE_SIZE_VALUE);
        }

        PageHelper.startPage(pageDto.getPageNum(), pageDto.getPageSize());
    }
}
