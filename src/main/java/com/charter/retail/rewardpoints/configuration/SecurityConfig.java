package com.charter.retail.rewardpoints.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.charter.retail.rewardpoints.constants.RewardPointsConstants;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	Environment env;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/actuator/**")
				.permitAll().anyRequest().authenticated().and().httpBasic();
		return http.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser(env.getProperty(RewardPointsConstants.BASIC_AUTH_USERID))
				.password("{noop}" + env.getProperty(RewardPointsConstants.BASIC_AUTH_PASSWORD))
				.roles(RewardPointsConstants.USER_ROLE);
	}

}