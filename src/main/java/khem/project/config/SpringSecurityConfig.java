package khem.project.config;

import khem.project.Enum.PermitionEnum;
import khem.project.Enum.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passEncode;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/","/index.html","home").permitAll()
                // .antMatchers("/brands").hasRole("Sale")
                // .antMatchers(HttpMethod.POST,"/category").hasAuthority(PermitionEnum.ADMIN.getDescription())
                // .antMatchers(HttpMethod.GET,"/category").hasAuthority(PermitionEnum.UNSUBSCRIBE.getDescription())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

    }
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        User khim = new User("khim", passEncode.encode("Khim@1234"), Collections.emptyList());

        UserDetails tida = User.builder()
                .username("tida")
                .password(passEncode.encode("tida@1234"))
                // .roles("Sale")
                .authorities(RoleEnum.UserSubscriber.grantedAuthorities())
                .build();


        UserDetails dara = User.builder()
                .username("dara")
                .password(passEncode.encode("dara@1234"))
                .roles(PermitionEnum.UNSUBSCRIBE.getDescription())
                .authorities(RoleEnum.ADMIN.grantedAuthorities())
                .build();

        UserDetailsService userDetails = new InMemoryUserDetailsManager(khim,tida,dara);
        return userDetails;
    }
}
