package com.techgatha;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;


//@Configuration
//@EnableWebFluxSecurity
public class MySecurityConfig {//extends WebSecurityConfigurerAdapter{

//    @Bean
//    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
//        serverHttpSecurity
//                .csrf().disable()
//                .authorizeExchange(exchange ->
//                        exchange.pathMatchers("/eureka/**")
//                                .permitAll()
//                                .anyExchange()
//                                .authenticated())
//                .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
//        return serverHttpSecurity.build();
//    }
//    
//    @Bean
//    public SecurityFilterChain springFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//        .authorizeRequests()
//        .antMatchers("/eureka/**").permitAll()
//        .anyRequest().authenticated()
//        .and().oauth2ResourceServer(oauth2 -> oauth2.jwt());
//        return http.build();
    //}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//        .authorizeRequests()
//        .antMatchers("/eureka/**").permitAll()
//        .anyRequest().authenticated()
//        .and().oauth2ResourceServer(oauth2 -> oauth2.jwt());
//         http.build();
//	}
}
