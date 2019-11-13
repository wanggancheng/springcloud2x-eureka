package io.daocloud.huanan.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @author 王新和
 * @date 19-11-12
 * @since 1.0
 */

@EnableWebSecurity
@Configuration
public class WebSecurityConfig
        extends WebSecurityConfigurerAdapter
{
    @Value("${spring.security.basic.enabled}")
    private boolean enableSecurity;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (this.enableSecurity) {
            http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER);
            http.csrf().disable();
            ((HttpSecurity)((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)http.authorizeRequests().anyRequest()).authenticated().and()).httpBasic();
        } else {
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)((HttpSecurity)http.csrf().disable())
                    .authorizeRequests()
                    .anyRequest()).permitAll();
        }
    }
}
