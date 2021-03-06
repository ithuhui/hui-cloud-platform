package com.hui.cloud.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * <code>PermissionFilter</code>
 * <desc>
 * 描述：
 * <desc/>
 * Creation Time: 2019/10/7 14:37.
 *
 * @author Gary.Hu
 */
public class PermissionFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //1.通过JWT获取用户ID

        //2.通过用户ID处查询Redis的权限

        //3. 判断是否有该权限
        return null;
    }
}
