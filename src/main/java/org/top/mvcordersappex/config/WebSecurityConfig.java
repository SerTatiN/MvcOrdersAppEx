package org.top.mvcordersappex.config;

/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;*/

// Класс конфигурации Spring Security
/*@Configuration
@EnableWebSecurity*/
public class WebSecurityConfig {
/*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/webjars/**").permitAll()
                        .requestMatchers("/client/*").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                //.logout((logout) -> logout.permitAll());
                .logout().logoutSuccessUrl("/logout");
        return http.build();
    }
//Провайдер работы с пользователями
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("qwerty")
                        .roles("USER")
                        .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("qwerty")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user,admin);
    }

//    @Bean
//    public WebSecurityCustomizer igno*/
}