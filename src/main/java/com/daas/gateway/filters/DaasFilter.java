package com.daas.gateway.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @Author zzj
 * Created on 2020/6/12.
 */
@Component
@Slf4j
public class DaasFilter extends ZuulFilter {

    @Override
    public String filterType() {
        //filterType代表过滤类型  pre、post和error。分别代表前置过滤，后置过滤和异常过滤。
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        //filterOrder代表过滤器顺序
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //shouldFilter代表这个过滤器是否生效
        return true;
    }

    @Override
    public Object run(){
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        //此处处理业务逻辑
        log.info("filter url is:{}",uri);
        return null;
    }
}
