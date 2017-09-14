package com.youfchen.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.youfchen.entity.UserEntity;
import com.youfchen.repository.UserRepository;

public class MyShiroRealm extends AuthorizingRealm {
	
	@Autowired
	UserRepository userRepository;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		SimpleAuthorizationInfo simpleAuthenticationInfo = new SimpleAuthorizationInfo();
		UserEntity userEntity = (UserEntity) principalCollection.getPrimaryPrincipal();
		simpleAuthenticationInfo.addRole(userEntity.getRole());
		return simpleAuthenticationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token.getCredentials();
		UserEntity userEntity = userRepository.findByUsername(usernamePasswordToken.getUsername());
		if (userEntity == null) {
			return null;
		}
		return new SimpleAuthenticationInfo(userEntity, userEntity.getPassword(), getName());
	}

}
