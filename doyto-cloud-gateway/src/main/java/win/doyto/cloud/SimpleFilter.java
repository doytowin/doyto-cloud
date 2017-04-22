package win.doyto.cloud;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

/**
 * SimpleFilter
 *
 * @author f0rb on 2017-03-23.
 */
@Slf4j
public class SimpleFilter  extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    public boolean shouldFilter() {
        return true;
    }

    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();

        //response.addHeader("Access-Control-Allow-Credentials", "true");
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

        return null;
    }

}