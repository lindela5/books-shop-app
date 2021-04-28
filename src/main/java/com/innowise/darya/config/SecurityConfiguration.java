package com.innowise.darya.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfiguration(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    RestAuthEntryPoint restAuthEntryPoint;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/auth/login").permitAll()
//                .defaultSuccessUrl("/auth/success");
////                .and()
////                .logout()
////                .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "POST"))
////                .invalidateHttpSession(true)
////                .clearAuthentication(true)
////                .deleteCookies("JSESSIONID")
////                .logoutSuccessUrl("/auth/login");
//    }


    @Override
    protected void configure(final HttpSecurity http)
            throws Exception {
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()).
                and().csrf().
                disable().authorizeRequests()
                //...
                .antMatchers(
                        HttpMethod.GET,
                        "/index** ", "/static/** ** ", "/** .js", "/** .json", "/** .ico")
                .permitAll()
                .antMatchers("/book/**", "/section/**", "/auth/**")
                .permitAll()
//                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(restAuthEntryPoint)
                .and()
                .formLogin()
                //.loginPage("/login")
                .loginProcessingUrl("/login");
//                .defaultSuccessUrl("/",true)
//                .failureUrl("/index.html?error=true");
        //...
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}user").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}admin").roles("ADMIN");
//    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }
}
