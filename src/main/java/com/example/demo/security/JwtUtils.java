package com.example.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {

	private static final Logger LOG = LoggerFactory.getLogger(JwtUtils.class);

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey("gfdiofjoaisdjfioadjfioasdjfoiajdfioasjf1221221212aosidjf8af98adf8asdhusdhusdhauihdfudshfuiadhfaishfdaisuhfuiashfiuhdsffasdf").parseClaimsJwt(authToken); // este valida. Si pasa, retorna un true
			return true;

		} catch (Exception e) {
			LOG.error("ERROOOR", e);
		}
		return false;
	}
	
	public String getuserNameFromjwtToken(String token) {
		return Jwts.parser().setSigningKey("gfdiofjoaisdjfioadjfioasdjfoiajdfioasjf1221221212aosidjf8af98adf8asdhusdhusdhauihdfudshfuiadhfaishfdaisuhfuiashfiuhdsffasdf").parseClaimsJwt(token).getBody().getSubject();
		
	}
}