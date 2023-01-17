package be.heh.projettrica.auth0;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig {

    private final LogoutHandler logoutHandler;

    public SecurityConfig(LogoutHandler logoutHandler) {
        this.logoutHandler = logoutHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().mvcMatchers("/addTournois").authenticated();
        //GET request to addTournois should be authenticated
        http.authorizeRequests().mvcMatchers("/addTournois").authenticated();
        //POST request to addTournois should be authenticated

        http.authorizeRequests().anyRequest().permitAll();
        // Any other request should be permitted
        http.cors().and().csrf().disable();
        return http
                .oauth2Login()
                .and().logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // match logout request
                .addLogoutHandler(logoutHandler) // add logout handler
                .and().build();
    }
}