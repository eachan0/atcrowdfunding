package com.atguigu.crowd.gateway.filter;

import com.atguigu.crowd.common.constant.AccessConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月14日
 * @desc LoginFilter
 */
@Slf4j
@Component
public class LoginFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();
        String path = request.getPath().value();
        boolean contains = AccessConst.PASS_RES_SET.contains(path);
        if (contains) {
            return chain.filter(exchange);
        }
        boolean judge = AccessConst.judgeCurrentServletPathWetherStaticResource(path);
        if (judge) {
            return chain.filter(exchange);
        }

        return chain.filter(exchange);
        /*List<HttpCookie> loginacct = request.getCookies().get("loginacct");
        if (!CollectionUtils.isEmpty(loginacct)){
            String value = loginacct.get(0).getValue();
            String s = template.opsForValue().get("user:" + value);
            if (StringUtils.hasText(s)){
                MemberVO memberVO = JSON.parseObject(s, MemberVO.class);
                if (memberVO!=null){
                    return chain.filter(exchange);
                }
            }
        }*/

//        session.getAttributes().put(AppConst.ATTR_NAME_MESSAGE, AppConst.MESSAGE_ACCESS_FORBIDEN);
        /*ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.SEE_OTHER);
        response.getHeaders().set("Location", "http://www.crowd.com/auth/member/login/page");
        return exchange.getResponse().setComplete();*/

        /*return exchange.getSession().flatMap(session -> {
            Object member = session.getAttribute(AppConst.ATTR_NAME_LOGIN_MEMBER);
            if (member == null) {
                session.getAttributes().put(AppConst.ATTR_NAME_MESSAGE, AppConst.MESSAGE_ACCESS_FORBIDEN);
                ServerHttpResponse response = exchange.getResponse();
                response.setStatusCode(HttpStatus.SEE_OTHER);
                response.getHeaders().set("Location", "http://www.crowd.com/auth/member/login/page");
                return exchange.getResponse().setComplete();
            }
            return chain.filter(exchange);
        }).then();*/
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
