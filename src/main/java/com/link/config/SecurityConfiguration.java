package com.link.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {
    /**
     * 스프링 시큐리티 규칙을 무시하는 url
     * @return
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web) -> web.ignoring().requestMatchers("/resources/**","/js/**","/css/**","/img/**");
    }


    /**
     * @param http
     * @return
     * @throws Exception
     * 스프링 시큐리티 규칙
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrfConfig) -> csrfConfig.disable())
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/login*/**").permitAll()
                        .requestMatchers("/logout/**").permitAll()
                        .requestMatchers("/myPage").hasRole("USER")
                        .requestMatchers("/join/**").permitAll()
                        .anyRequest().authenticated()
                )
                .logout((logoutConfig)-> logoutConfig.logoutSuccessUrl("/logout"))
                .httpBasic(withDefaults());
        return http.build();
    }
}
