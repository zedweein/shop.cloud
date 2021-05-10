package shop.cloud.order.controller;

import com.alibaba.csp.sentinel.adapter.servlet.callback.RequestOriginParser;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * sentinel容错 “授权规则”
 */
//@Component
public class AuthRuleRequestParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest request) {
        String appType = request.getParameter("appType");
        if(StringUtils.isEmpty(appType)){
            throw new RuntimeException("appType is null");
        }
        return appType;
    }
}
