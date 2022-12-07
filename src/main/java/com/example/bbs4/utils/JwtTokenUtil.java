package com.example.bbs4.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtTokenUtil {

    public static Claims openToken(String token, String key){ // token 내용 확인하기
        // 어떤 토큰을 열고, 그 토큰을 열 key 는 무엇인지
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token)
                .getBody();
    }

    public static boolean isExpired(String token, String key){
        // 내용만료: true ,  만료되지 않았다면: false
        return openToken(token,key)
                .getExpiration()
                .before(new Date()); //  token 유효기간을 확인하였을 때 현 시점보다 이전인 경우 : true , 권한을 발급하면 안됨
    }

    public static String createToken (String userName, String key, Long expireTimeMs){
        Claims claims = Jwts.claims();
        claims.put("userName", userName);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }
}
