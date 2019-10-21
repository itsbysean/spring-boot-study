package net.groupadd.gateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;

/**
 * Created by itsbysean.
 */
@Component
@Slf4j
public class SimpleLoggingFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre"; // pre 사전 필터, route 원본으로 라우팅하기, post필터를 포스트라우팅, error 에러 처리
    }

    @Override
    public int filterOrder() {
        return 1; // 필터 우선순위
    }


    @Override
    public boolean shouldFilter() {
        return true; // 조건에 따른 필터 동작 여부, 해당 코드에서는 동작하기 위해서 true 리턴
    }

    @Override
    public Object run() { // 필터에 대한 로직을 구현하는 방식, 아래 예제는 단순하게 로깅용
        final RequestContext context = RequestContext.getCurrentContext();
        final HttpServletRequest request = context.getRequest();

        log.info(MessageFormat
                .format("Request Method : {0} \n URL : {1} ", request.getMethod(),
                        request.getRequestURI()));
        return null;
    }
}
