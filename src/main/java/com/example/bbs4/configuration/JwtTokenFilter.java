package com.example.bbs4.configuration;

import com.example.bbs4.service.UserService;
import com.example.bbs4.utils.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@RequiredArgsConstructor
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

    private final UserService userService;
    private final String secretKey;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //필터 조건 걸기
        String header = request.getHeader(HttpHeaders.AUTHORIZATION); // 토큰선언
        log.info("header:{}", header);

        //조건: Authorization 이 header 에 없거나, Bearer 로 시작하지 않는 경우 리턴
        if((header == null) || !header.startsWith("Bearer ")){
            log.error("Token 이 없거나 잘못되었습니다.");
            filterChain.doFilter(request,response);
            return;
        }

        //header 가 잘 존재할 경우 token 분리하기
        String token;
        try{
            token = header.split(" ")[1]; // Bearer ... (이런식으로 토큰이 생성되기 때문에 Bearer 빼고 분리)
        } catch (Exception e){
            log.error("Token 추출에 실패하였습니다.");
            filterChain.doFilter(request,response);
            return;
        }

        if(JwtTokenUtil.isExpired(token, secretKey)){ // if문 사용하기 위해서 boolean 타입으로 메소드를 선언한 것
            log.error("Token이 만료되었습니다.");
            filterChain.doFilter(request,response);
            return;
        }

        // Claims은 Object 타입으로 들어가는데 꺼낼 때는 String 타입으로 저장해야 한다.
        String userName = JwtTokenUtil.openToken(token,secretKey).get("userName").toString();
        log.info("userName:{}", userName);

        String userRole = JwtTokenUtil.openToken(token,secretKey).get("userRole").toString();
        log.info("userRole:{}", userRole);

        // 권한부여 (아무조건 없이)
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userName, null, List.of(new SimpleGrantedAuthority(userRole)));

        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}


