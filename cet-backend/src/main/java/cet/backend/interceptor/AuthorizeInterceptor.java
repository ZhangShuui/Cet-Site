package cet.backend.interceptor;

import cet.backend.entity.user.AccountUser;
import cet.backend.mapper.UserMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class AuthorizeInterceptor implements HandlerInterceptor {
    @Resource
    UserMapper mapper;

    Logger logger = LoggerFactory.getLogger(getClass());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        User user = (User)authentication.getPrincipal();
        String username = user.getUsername();
        AccountUser account = mapper.findAccountUserByNameOrEmail(username);
        logger.info(account.toString());
        request.getSession().setAttribute("account", account);
        return true;
    }
}
