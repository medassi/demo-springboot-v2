package fr.medassi.democours;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.security.web.SecurityFilterChain;

import fr.medassi.democours.services.UtilisateurService;

@Configuration
public class WebSecurityConfig {

    private final UtilisateurService utilisateurService;

    public WebSecurityConfig(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(utilisateurService);
        authProvider.setPasswordEncoder(new BCryptPasswordEncoder(BCryptVersion.$2B));
        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/equipements/addOrdinateur", "/equipements/addImprimante").hasAuthority("ADMIN")
                        .requestMatchers("/equipements", "/equipements/**").hasAnyAuthority("ADMIN", "STANDARD")
                        .anyRequest().authenticated())
                .formLogin((form) -> form.permitAll())
                .logout(logout -> logout.permitAll());

        http.csrf(csrf -> csrf.ignoringRequestMatchers("/h2/**"));
        http.headers(headers -> headers.frameOptions(frame -> frame.sameOrigin()));
        return http.build();

    }

}
