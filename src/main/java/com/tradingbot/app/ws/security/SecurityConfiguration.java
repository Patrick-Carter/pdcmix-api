// package com.tradingbot.app.ws.security;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// import com.tradingbot.app.ws.repo.IUserRepo;
// import com.tradingbot.app.ws.service.UserService;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfiguration {

//     private final UserService userService;
//     private final BCryptPasswordEncoder bCryptPasswordEncoder;
//     private final IUserRepo userRepo;

//     public SecurityConfiguration
//     (
//         UserService userService, 
//         BCryptPasswordEncoder bCryptPasswordEncoder,
//         AuthenticationConfiguration authenticationConfiguration,
//         IUserRepo userRepo
//     ) {
//         this.userService = userService;
//         this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//         this.userRepo = userRepo;
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return bCryptPasswordEncoder;
//     }

//     @Bean
//     public UserDetailsService userDetailsService() {
//         return userService;
//     }

//     @Bean
//     public SecurityFilterChain configure(HttpSecurity http) throws Exception {

//         AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
//         authenticationManagerBuilder.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);

//         AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

//         http.csrf().disable().authorizeRequests()
//                 .antMatchers(HttpMethod.POST, SecurityConsts.SIGN_UP_URL).permitAll()
//                 .anyRequest().authenticated().and()
//                 .addFilter(new AuthenticationFilter(authenticationManager, userRepo))));

//         return http.build();
//     }
// }
