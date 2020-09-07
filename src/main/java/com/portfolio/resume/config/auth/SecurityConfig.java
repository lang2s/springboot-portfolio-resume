package com.portfolio.resume.config.auth;

import com.portfolio.resume.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity              //  Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private  final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable().headers().frameOptions().disable()
                    .and()
                        .authorizeRequests()     // url 권한관리 시작점
                            .antMatchers("/", "/css/**", "/images/**", "/js/**", "/lib/**", "/img/**", "/hello/**",
                                                            "/board/**", "/about/**", "/works/**", "/favicon.ico", "/h2-console/**", "/profile/**").permitAll()  // permitAll 전체열람 권한
                            .antMatchers("/api/board/**").hasRole(Role.USER.name())         // USER 권한을 가진 사람만 가능
                            .antMatchers("/*/**").hasRole(Role.ADMIN.name())                  // ADMIN 권한
                            .anyRequest().authenticated()           // 설정된 값 이외의 나머지 url 로그인한 사용자만
                    .and()
                        .logout()   // 로그아웃 기능 설정 시작점
                            .logoutSuccessUrl("/")              // 로그아웃 성공시 ("/") 주소로 이동
                    .and()
                        .oauth2Login()  // 로그인 기능 설정 시작점
                            .userInfoEndpoint() // 로그인 성공 후 사용자 정보를 가져올 때의 설정을 담당
                                .userService(customOAuth2UserService);  // UserService 인터페이스 구현체 등록
    }

}
