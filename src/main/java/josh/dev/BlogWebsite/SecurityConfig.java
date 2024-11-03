package josh.dev.BlogWebsite;


import josh.dev.BlogWebsite.User.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsServiceImpl userDetails;
    private final JWtFilter jWtFilter;

    @Autowired
    public SecurityConfig(UserDetailsServiceImpl userDetails, JWtFilter jWtFilter) {
        this.userDetails = userDetails;
        this.jWtFilter = jWtFilter;
    }

@Bean
SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    return
    http.csrf(customizer -> customizer.disable()).
            authorizeHttpRequests(request -> request
                    .requestMatchers("user/register" , "user/login")
                    .permitAll()
                    .anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults()).
            sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(jWtFilter, UsernamePasswordAuthenticationFilter.class)
            .build();

    }

@Bean
public AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
    provider.setUserDetailsService(userDetails);
    return provider;
}
@Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
}


}
