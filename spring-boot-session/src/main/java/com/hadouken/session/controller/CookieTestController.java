package com.hadouken.session.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hadouken.common.utils.CookieUtils;

/**
 * @author hadouken-pe@gmail.com
 * @date 2021-03-23 11:16:42
 */
@RestController
@RequestMapping("/cookie")
public class CookieTestController {

    /**
     * @param cookieName
     * @param cookieValue
     * @param response
     * @return
     */
    @RequestMapping("/setCookie")
    public Map<String, Object> setCookie(String cookieName, String cookieValue, HttpServletResponse response) {
        CookieUtils.addCookie(cookieName, cookieValue, "baidu.com", "/", -1, false,
                CookieUtils.SameSite.None, response);
        return Map.of("msg", "Set Cookie Success.");
    }

    /**
     * @param cookieName
     * @param cookieValue
     * @param response
     * @return
     */
    @RequestMapping("/addCookie")
    public Map<String, Object> addCookie(String cookieName, String cookieValue, HttpServletResponse response) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setDomain("baidu.com");
        cookie.setPath("/");
        cookie.setMaxAge(-1);
        cookie.setSecure(false);
        cookie.setVersion(1);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return Map.of("msg", "Cookie种植成功");
    }

    /**
     * @param cookieName
     * @param request
     * @return
     */
    @RequestMapping("/getCookie")
    public Map<String, Object> getCookie(String cookieName, HttpServletRequest request) {
        String cookie = CookieUtils.getCookie(request, cookieName);
        return Map.of("msg", cookie);
    }
}
