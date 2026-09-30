package webseite.com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // =========================================================
    // 1. CONFIGURACIÓN DE SEGURIDAD
    // =========================================================
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http

            // ⚠️ CSRF DESACTIVADO (necesario porque no pones el token en los forms)
            .csrf(csrf -> csrf.disable())

            .authorizeHttpRequests(auth -> auth

                // =============================================
                // 🌐 RUTAS PÚBLICAS (sin login)
                // =============================================
                .requestMatchers(
                    "/", "/principal", "/home", "/inicio",

                    "/politica-privacidad",
                    "/acceso-denegado",

                    // Login / logout
                    "/login", "/logout",

                    // Blog y AutoCAD públicos
                    "/blog", "/blog/**",
                    "/autocad/**", "/AutoCad/**",

                    // Registro de usuario nuevo
                    "/usuario/registrar",
                    "/usuario/guardar",
                    "/api/register",

                    // Recursos estáticos
                    "/css/**", "/js/**",
                    "/img/**", "/images/**",
                    "/assets/**", "/lib/**",
                    "/fonts/**", "/webjars/**",
                    "/favicon.ico",
                    "/contactform/**",

                    // Error
                    "/error"
                ).permitAll()


                // =============================================
                // 🔒 SOLO ADMIN
                // =============================================
                .requestMatchers(
                    "/usuario/listar",
                    "/usuario/nuevo",
                    "/usuario/editar/**",
                    "/usuario/eliminar/**"
                ).hasRole("ADMIN")


                // =============================================
                // 🔒 ADMIN Y USER
                // =============================================
                .requestMatchers(
                    "/clientes/**", "/cliente/**",
                    "/proyecto/**", "/proyectos/**",
                    "/orden/**", "/ordenes/**",
                    "/detalleorden/**",
                    "/galeria/**",
                    "/perfil/**"
                ).hasAnyRole("ADMIN", "USER")


                // =============================================
                // 🔒 CUALQUIER OTRA RUTA
                // =============================================
                .anyRequest().authenticated()
            )


            // =============================================
            // LOGIN
            // =============================================
            .formLogin(login -> login
                .loginPage("/principal")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/principal", true)
                .failureUrl("/principal?error=true")
                .permitAll()
            )


            // =============================================
            // LOGOUT
            // =============================================
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/principal?logout=true")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            )


            // =============================================
            // ACCESO DENEGADO
            // =============================================
            .exceptionHandling(ex -> ex
                .accessDeniedPage("/acceso-denegado")
            );

        return http.build();
    }


    // =========================================================
    // 2. CONTRASEÑAS
    // =========================================================
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // =========================================================
    // 3. USUARIOS EN MEMORIA (TEMPORAL)
    // =========================================================
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

        // ADMIN
        UserDetails admin = User.builder()
                .username("admin@revilla.com")
                .password(passwordEncoder.encode("Admin123"))
                .roles("ADMIN")
                .build();

        // USER
        UserDetails usuario = User.builder()
                .username("usuario@revilla.com")
                .password(passwordEncoder.encode("Usuario123"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, usuario);
    }
}