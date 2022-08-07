// package com.tradingbot.app.ws.security;

// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Date;

// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.AuthenticationException;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
// import org.springframework.security.core.userdetails.User;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.tradingbot.app.ws.SpringApplicationContext;
// import com.tradingbot.app.ws.io.entity.UserEntity;
// import com.tradingbot.app.ws.repo.IUserRepo;
// import com.tradingbot.app.ws.service.UserService;
// import com.tradingbot.app.ws.shared.dto.UserDto;
// import com.tradingbot.app.ws.ui.model.request.UserLoginReqModel;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;

// public class AuthenticationFilter extends BasicAuthenticationFilter {
//     private String contentType;
//     private IUserRepo userRepo;

//     public AuthenticationFilter(AuthenticationManager authenticationManager, IUserRepo userRepo) {
//         super(authenticationManager);
//         this.userRepo = userRepo;
//     }

//     @Override
//     protected void doFilterInternal(HttpServletRequest req,
//                                     HttpServletResponse res,
//                                     FilterChain chain) throws IOException, ServletException {
        
//         String header = req.getHeader(SecurityConsts.HEADER_STRING);
        
//         if (header == null || !header.startsWith(SecurityConsts.TOKEN_PREFIX)) {
//             chain.doFilter(req, res);
//             return;
//         }
        
//         UsernamePasswordAuthenticationToken authentication = getAuthentication(req);
//         SecurityContextHolder.getContext().setAuthentication(authentication);
//         chain.doFilter(req, res);
//     }   
    
//     private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
//         String token = request.getHeader(SecurityConsts.HEADER_STRING);
        
//         if (token != null) {
            
//             token = token.replace(SecurityConsts.TOKEN_PREFIX, "");
     
//             String user = Jwts.parser()
//                     .setSigningKey( SecurityConsts.getSecret() )
//                     .parseClaimsJws( token )
//                     .getBody()
//                     .getSubject();
            
//             if (user != null) {
//                 UserEntity userEntity = userRepo.findByEmail(user);
//                 return new UsernamePasswordAuthenticationToken(user, null, new UserPrincipal(userEntity).getAuthorities());
//             }
            
//             return null;
//         }
        
//         return null;
//     }
// }
