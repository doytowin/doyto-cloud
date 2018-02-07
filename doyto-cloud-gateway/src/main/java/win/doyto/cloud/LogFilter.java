package win.doyto.cloud;

import javax.servlet.http.HttpServletRequest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

/**
 * LogFilter
 *
 * @author f0rb on 2017-03-23.
 */
@Slf4j
public class LogFilter extends ZuulFilter {

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
        //HttpServletResponse response = ctx.getResponse();

        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        return null;
    }

}