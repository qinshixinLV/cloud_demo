package com.example.zuul4001.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ManagerFilter extends ZuulFilter {

    public String filterType() {
        return "pre";
    }

    public int filterOrder() {
        return 0;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() throws ZuulException {
        System.out.println("经过后台过滤器了！");
        RequestContext requestContext = RequestContext.getCurrentContext();
        //request域
        HttpServletRequest request = requestContext.getRequest();
        requestContext.setSendZuulResponse(true);//继续运行
        /*requestContext.setResponseStatusCode(403);
        requestContext.setResponseBody("权限不足");*/
        requestContext.getResponse().setContentType("text/html;charset=utf-8");
        return null;
    }

}
/**
 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过
 * 滤器类型，具体如下：
 * pre ：可以在请求被路由之前调用
 * route ：在路由请求时候被调用
 * post ：在route和error过滤器之后被调用
 * error ：处理请求时发生错误时被调用
 * filterOrder ：通过int值来定义过滤器的执行顺序
 * shouldFilter ：返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可
 * 实现过滤器的开关。在上例中，我们直接返回true，所以该过滤器总是生效
 * run ：过滤器的具体逻辑。
 */
