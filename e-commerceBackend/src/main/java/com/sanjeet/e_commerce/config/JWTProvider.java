package com.sanjeet.e_commerce.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JWTProvider {
    SecretKey key= Keys.hmacShaKeyFor(JWTConstant.SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    public String generateTokenAuthentication(Authentication auth){
        String jwt= Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+846000000))//one day
                .claim("email",auth.getName())
                .signWith(key).compact();
        return jwt;
    }
    public String getEmailFromToken(String jwt){
        jwt=jwt.split(" ")[1];
        Claims claims=Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
        String email=String.valueOf(claims.get("email"));
        return email;
    }
}
