package com.example.eidopdrachtnovi.security;

        import com.example.eidopdrachtnovi.repositories.UserRepository;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.http.HttpMethod;
        import org.springframework.security.authentication.AuthenticationManager;
        import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
        import org.springframework.security.config.annotation.web.builders.HttpSecurity;
        import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
        import org.springframework.security.config.http.SessionCreationPolicy;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
        import org.springframework.security.crypto.password.PasswordEncoder;
        import org.springframework.security.web.SecurityFilterChain;
        import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {

    private final JwtService jwtService;
    private final UserRepository userRepository;

    public SecurityConfig(JwtService service, UserRepository userRepos) {
        this.jwtService = service;
        this.userRepository = userRepos;
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http, PasswordEncoder encoder, UserDetailsService udService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(udService)
                .passwordEncoder(encoder)
                .and()
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService(this.userRepository);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/users").permitAll()
                .requestMatchers(HttpMethod.POST, "/auth").permitAll()
                .requestMatchers(HttpMethod.POST,"/projects").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT,"/projects/{id}").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/projects/{id}").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET,"/projects").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET,"/projects/{id}").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET,"/projects/studio/{studioMember}").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST,"/deelopdrachtprint").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET,"/deelopdrachtprint").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET,"/deelopdrachtprint/{id}").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET,"/deelopdrachtprint/project/{projectId}").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET,"/deelopdrachtprint/status/{status}").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.PUT,"/deelopdrachtprint/{id}").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/deelopdrachtprint/{id}").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST,"/deelopdrachtdigital").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET,"/deelopdrachtdigital").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET,"/deelopdrachtdigital/{id}").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET,"/deelopdrachtdigital/project/{projectId}").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET,"/deelopdrachtdigital/status/{status}").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.PUT,"/deelopdrachtdigital/{id}").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/deelopdrachtdigital/{id}").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST,"/printshop").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PUT,"/printshop/{id}").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/printshop/{id}").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET,"/printshop").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.GET,"/printshop/{id}").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST,"/upload").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/download/{brandguide}").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers("/**").hasAnyAuthority("USER", "ADMIN")
                .anyRequest().denyAll()
                .and()
                .addFilterBefore(new JwtRequestFilter(jwtService, userDetailsService()), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }
}
