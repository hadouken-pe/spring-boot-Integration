package com.hadouken.common.constant;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

/**
 * @author hadouken-pe@gmail.com
 * @date 2021-03-26 18:06:26
 */
public class Constants {

    public static final String COMMA = ",";

    public static final String SHARP = "#";

    public static final String POINT = ".";

    public static final String EMPTY = "";

    public static final String PERCENT = "%";

    public static final String EQUAL = "=";

    public static final String COLON = ";";

    public static final String LINE = "-";

    public static final String UNDER_LINE = "_";

    public static final String S_RANDOM = "sRandom";

    public static final String TIMESTAMP = "timestamp";

    public static final String SIGN = "sign";

    public static final String APP_KEY = "appKey";

    public static final String SECRET_KEY = "secretKey";

    public static final String REQUEST_TRACING_CODE = "requestTracingCode";

    public static final String REQUEST_IP = "requestIp";

    public static final String REQUEST_PATH = "requestPath";

    public static final String JWT_API_TOKEN_ISSUER = "uuap";

    public static final String UUAP_CLIENT_VERSION_FLAG = "Uuap-Client-Version";

    public static final Splitter COMMA_SPLITTER = Splitter.on(COMMA).trimResults().omitEmptyStrings();

    public static final Splitter SHARP_SPLITTER = Splitter.on(SHARP).trimResults().omitEmptyStrings();

    public static final Joiner COMMA_JOINER = Joiner.on(COMMA).skipNulls();

    public static final Joiner EMPTY_JOINER = Joiner.on(EMPTY).skipNulls();

    public static final Joiner SHARP_JOINER = Joiner.on(SHARP).skipNulls();

    public static final Joiner LINE_JOINER = Joiner.on(LINE).skipNulls();

    public static final Joiner UNDER_LINE_JOINER = Joiner.on(UNDER_LINE).skipNulls();

    public static final CharMatcher LINE_CHAR_MATCHER = CharMatcher.anyOf(LINE);

    public static final String DEFAULT_URL_MAPPING = "/*";

    public static final String WEIYUN_HTTPS_FLAG = "X-Ssl-Header";

    public static final String X_USER_AGENT = "X-User-Agent";

    public static final String X_USER_IP = "X-User-IP";

    public static final String AUTH_PROXY_TICKET_PREFIX = "proxy::";

    public static final String AUTH_PROXY_TICKET_SEP = "::";

    public static final String VERSION_V2 = "v2";

    public static final String TRACING_ID = "tracingId";
}
