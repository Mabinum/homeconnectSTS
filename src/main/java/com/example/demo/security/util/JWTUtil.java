package com.example.demo.security.util;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClaims;
import io.jsonwebtoken.impl.DefaultJws;
import lombok.extern.log4j.Log4j2;

// JWT 생성, 유효성 검증

@Log4j2
public class JWTUtil {

<<<<<<< HEAD
private String secretKey = "zerock12345678";
    
    //토큰 유효기간: 1month
    private long expire = 60 * 24* 30;
    
    //로그아웃된 토큰 리스트
    private Set<String> blacklist = new HashSet<>();
=======
	private String secretKey = "zerock12345678";

	// 토큰 유효기간: 1month
	private long expire = 60 * 24 * 30;
>>>>>>> branch 'develop' of https://github.com/Mabinum/homeconnectSTS.git

<<<<<<< HEAD
    //로그아웃시 블랙 리스트에 추가
    public void invalidateToken(String token) {
        blacklist.add(token);
    }

    // 블랙 리스트에 포함되어 있는지 확인
    public boolean isTokenInvalid(String token) {
        return blacklist.contains(token);
    }

    // 토큰을 생성하는 메소드
    public String generateToken(String content) throws Exception{
=======
	// 로그아웃된 토큰 리스트
	private Set<String> blacklist = new HashSet<>();
>>>>>>> branch 'develop' of https://github.com/Mabinum/homeconnectSTS.git

	// 로그아웃시 블랙 리스트에 추가
	public void invalidateToken(String token) {
		blacklist.add(token);
	}

<<<<<<< HEAD
    // 토큰에서 아이디를 추출하는 메소드
    public String validateAndExtract(String tokenStr)throws Exception {
=======
	// 블랙 리스트에 포함되어 있는지 확인
	public boolean isTokenInvalid(String token) {
		return blacklist.contains(token);
	}
>>>>>>> branch 'develop' of https://github.com/Mabinum/homeconnectSTS.git

<<<<<<< HEAD
        String contentValue = null;
        
        for(String token : blacklist) {
        	if(token.equals(tokenStr)) {
        		log.info("해당 토큰을 사용할 수 없습니다..");
        		return "";
        	}
        }
=======
	// 토큰을 생성하는 메소드
	public String generateToken(String content) throws Exception {
>>>>>>> branch 'develop' of https://github.com/Mabinum/homeconnectSTS.git

		return Jwts.builder().setIssuedAt(new Date())
				.setExpiration(Date.from(ZonedDateTime.now().plusMinutes(expire).toInstant())).claim("sub", content)
				.signWith(SignatureAlgorithm.HS256, secretKey.getBytes("UTF-8")).compact();
	}

	// 토큰에서 아이디를 추출하는 메소드
		public String validateAndExtract(String tokenStr) throws Exception {

			String contentValue = null;

			for (String token : blacklist) {
				if (token.equals(tokenStr)) {
					log.info("해당 토큰을 사용할 수 없습니다..");
					return "";
				}
			}

			try {
				DefaultJws defaultJws = (DefaultJws) Jwts.parser().setSigningKey(secretKey.getBytes("UTF-8"))
						.parseClaimsJws(tokenStr);

				log.info(defaultJws);

<<<<<<< HEAD
        }catch(Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            contentValue = null;
        }
        return contentValue;
    }
=======
				log.info(defaultJws.getBody().getClass());

				DefaultClaims claims = (DefaultClaims) defaultJws.getBody();

				log.info("------------------------");

				contentValue = claims.getSubject();

			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage());
				contentValue = null;
			}
			return contentValue;
		}
>>>>>>> branch 'develop' of https://github.com/Mabinum/homeconnectSTS.git


}
