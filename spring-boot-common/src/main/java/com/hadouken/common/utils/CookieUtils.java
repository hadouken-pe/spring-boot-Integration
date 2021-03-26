package com.hadouken.common.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.util.Assert;
import org.springframework.web.util.WebUtils;

import com.google.common.base.Optional;
import com.hadouken.common.constant.Constants;

/**
 * @author hadouken-pe@gmail.com
 * @date 2021-03-26 18:06:26
 */
public class CookieUtils {

    /**
     * 获取cookie
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static String getCookie(HttpServletRequest request, String cookieName) {
        if (null == request || StringUtils.isEmpty(cookieName)) {
            return null;
        }
        Cookie cookie = WebUtils.getCookie(request, cookieName);
        return null == cookie ? null : cookie.getValue();
    }

    /**
     * 添加cookie
     *
     * @param domain      域名
     * @param path        路径
     * @param cookieName  cookie的名字
     * @param cookieValue cookie的值
     * @param maxAge      有效期(秒)
     * @param response
     */
    public static void addCookie(String domain, String path, String cookieName, String cookieValue, int maxAge,
                                 HttpServletResponse response) {
        addCookie(cookieName, cookieValue, domain, path, maxAge, false, null, response);
    }

    public static void addCookie(String cookieName, String cookieValue, String domain, String path,
                                 int maxAge, boolean secure, SameSite sameSite, HttpServletResponse response) {
        Cookie cookie = new Cookie(cookieName, cookieValue);
        if (StringUtils.isNotEmpty(domain)) {
            cookie.setDomain(domain);
        }
        cookie.setPath(path);
        cookie.setMaxAge(maxAge);
        cookie.setSecure(secure);

        String cookieAsString = toString(cookie, true, sameSite);
        response.addHeader(HttpHeaders.SET_COOKIE, cookieAsString);
    }

    /**
     * cookie转换成字符串
     *
     * @param cookie
     * @param httpOnly
     * @param sameSite
     * @return
     */
    public static String toString(Cookie cookie, boolean httpOnly, SameSite sameSite) {
        Assert.notNull(cookie, "cookie cannot null");
        StringBuilder cookieStrBuilder = new StringBuilder();

        // name && value
        Assert.notNull(cookie.getName(), "cookie name cannot null");
        String value = Optional.fromNullable(cookie.getValue()).or(StringUtils.EMPTY);
        cookieStrBuilder.append(cookie.getName()).append(Constants.EQUAL).append(value);

        // Domain
        if (StringUtils.isNotEmpty(cookie.getDomain())) {
            cookieStrBuilder.append(Constants.COLON).append(" Domain").append(Constants.EQUAL)
                    .append(cookie.getDomain());
        }

        // Path
        cookieStrBuilder.append(Constants.COLON).append(" Path").append(Constants.EQUAL).append(cookie.getPath());

        // Version
        if (cookie.getVersion() > 0) {
            cookieStrBuilder.append(Constants.COLON)
                    .append(" Version").append(Constants.EQUAL).append(cookie.getVersion());
        }

        // Comment
        if (StringUtils.isNotEmpty(cookie.getComment())) {
            cookieStrBuilder.append(Constants.COLON)
                    .append(" Comment").append(Constants.EQUAL).append(cookie.getComment());
        }

        // maxAge && Expires
        if (cookie.getMaxAge() >= 0) {
            cookieStrBuilder.append(Constants.COLON)
                    .append(" Max-Age").append(Constants.EQUAL).append(cookie.getMaxAge());
        }

        // HttpOnly
        if (httpOnly) {
            cookieStrBuilder.append(Constants.COLON).append(" HttpOnly");
        }

        // Secure
        if (cookie.getSecure()) {
            cookieStrBuilder.append(Constants.COLON).append(" Secure");
        }

        // SameSite
        if ((cookie.getSecure() && SameSite.None.equals(sameSite))
                || SameSite.Lax.equals(sameSite) || SameSite.Strict.equals(sameSite)) {
            cookieStrBuilder.append(Constants.COLON).append(" SameSite").append(Constants.EQUAL)
                    .append(sameSite.name());
        }
        return cookieStrBuilder.toString();
    }

    public static String toString(Cookie cookie, SameSite sameSite) {
        return toString(cookie, cookie.isHttpOnly(), sameSite);
    }

    public enum SameSite {
        None, Lax, Strict
    }

}