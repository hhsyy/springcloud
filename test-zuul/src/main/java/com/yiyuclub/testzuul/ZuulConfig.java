package com.yiyuclub.testzuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Component
public class ZuulConfig extends ZuulFilter {

    /**
     * @return 过滤器类型
     *
     * - `pre`：请求在被路由之前执行
     * - `routing`：在路由请求时调用
     * - `post`：在routing和errror过滤器之后调用
     * - `error`：处理请求时发生错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    //有不同的zuulfilter，这里可设置优先级别，数值最低优先级越高
    @Override
    public int filterOrder() {
        return 1;
    }

    //是否执行该filter，默认为false，true为执行
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //该filter的具体实现方法
    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        String authorization = request.getHeader("Authorization");
        Optional<String> s = Optional.ofNullable(authorization);
        if(s.isPresent()){
            String info=  "没有认证，可重定向";
        }
        return null;
    }
}
