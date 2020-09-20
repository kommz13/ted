/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.goldencompany.airbnb.auth;

import com.goldencompany.airbnb.entity.Role;
import com.goldencompany.airbnb.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import java.security.Key;
import java.util.Date;
import java.util.List;

/**
 *
 * @author alex
 */
public class AuthController {

    public static String issueToken(User user) {
        Key key = KeyHolder.key;
        String username = user.getUsername();

        List<Role> roleList = user.getRoleList();

        String s = "";

        for (Role r : roleList) {
            if (s.isEmpty()) {
                s = r.getName();
            } else {
                s = s + "," + r.getName();
            }
        }

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        long expMillis = nowMillis + 300000L;
        Date exp = new Date(expMillis);

        String jws = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .claim("roles", s)
                .signWith(SignatureAlgorithm.HS512, key)
                .setExpiration(exp)
                .compact();
        return jws;
    }

    public static void validateTokenForExpiration(String token) throws Exception {

        Key key = KeyHolder.key;
        try {

            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            long nowMillis = System.currentTimeMillis();
            Date now = new Date(nowMillis);
            if (now.after(claims.getExpiration())) {
                throw new Exception();
            }
        } catch (SignatureException e) {
            throw e;
        }
    }
    
    public static void validateTokenForRole(String token, String role) throws Exception {

        Key key = KeyHolder.key;
        try {

            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            String s = claims.get("roles").toString();
            String [] roles = s.split(",");
            
            for (String r : roles) {
                if (r.equals(role)) {
                    return;
                }
            }
            
            throw new Exception();
            
        } catch (SignatureException e) {
            throw e;
        }
    }
}
