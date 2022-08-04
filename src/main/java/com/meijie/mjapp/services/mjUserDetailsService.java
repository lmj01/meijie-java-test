package com.meijie.mjapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.meijie.mjapp.logic.mjPasswordEncode;
import com.meijie.mjapp.logic.mjUserDetails;

/**
 * 实现这个接口后，默认配置的用户名就失效了
 * @author meiji
 *
 */
@Service
public class mjUserDetailsService implements UserDetailsService {
	
	@Autowired
	mjPasswordEncode passwordEncode;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 这里设置了，就不需要配置属性了
		mjUserDetails mjUserDetails = new mjUserDetails();
		mjUserDetails.setUsername("meijie");
		mjUserDetails.setPassword(passwordEncode.encode("123456"));
		return mjUserDetails;
	}

}
