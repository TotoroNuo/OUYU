package com.ouyu.Utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.UUID;

/**
 * @author a1315
 */
public class JwtUtil {
    /**
     * 过期时间
     */
    private static final long TIME = 1000 * 60 * 60 * 24;
    /**
     * 签名
     */
    private static final String SIGNATURE = "admin";

    /**
     * 创建token
     */
    public static String createToken(String userName, String userPassword) {
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                /**header*/
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                /**payload*/
                .claim("userName", userName)
                .claim("userPassword", userPassword)
                /**主题*/
                .setSubject("access-admin")
                /**过期时间*/
                .setExpiration(new Date(System.currentTimeMillis() + TIME))
                .setId(UUID.randomUUID().toString())
                /**signature签名*/
                .signWith(SignatureAlgorithm.HS256, SIGNATURE)
                /**拼装*/
                .compact();
        return jwtToken;
    }

    /**
     * 检查token是否有效
     */
    public static boolean checkToken( String token) {
        if (token == null) {
            return false;
        }
        try {
            Jwt<Header, Claims> parseClaimsJwt = Jwts.parser().setSigningKey(SIGNATURE).parseClaimsJwt(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
