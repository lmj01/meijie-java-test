package com.meijie.mjapp.logic;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class mjPasswordEncode implements PasswordEncoder {
	
	final String salt = "mydefaultsaltcode";
	
	@Override
	public String encode(CharSequence rawPassword) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] bytes = md5.digest((rawPassword.toString()+salt).getBytes(StandardCharsets.UTF_8));
			return new String(bytes, StandardCharsets.UTF_8);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		if (rawPassword != null && encodedPassword != null) {
			return encode(rawPassword).equals(encodedPassword);
		}
		return false;
	}

}
