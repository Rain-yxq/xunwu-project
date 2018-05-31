package cn.rain.config;

import cn.rain.security.AuthProvider;
import cn.rain.security.LoginAuthFailHandler;
import cn.rain.security.LoginUrlEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * description:
 *
 * @author 任伟
 * @date 2018/5/31 10:40
 */
@SuppressWarnings("dep-ann")
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * http权限控制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置资源访问的权限
        http.authorizeRequests()
                // 允许任何人访问管理员登录入口
                .antMatchers("/admin/login").permitAll()
                // 允许任何人访问静态资源
                .antMatchers("/static/**").permitAll()
                // 允许任何人访问用户登录界面
                .antMatchers("/user/login").permitAll()
                // 仅允许管理员角色才能访问后台相关页面
                .antMatchers("/admin/**").hasRole("ADMIN")
                //允许用户和管理员角色访问用户相关页面
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                //允许用户和管理员角色访问用户相关接口页面
                .antMatchers("/api/user/**").hasAnyRole("ADMIN", "USER")
                .and()
                .formLogin()
                // 配置角色登录处理入口
                .loginProcessingUrl("/login")
                .failureHandler(authFailHandler())
                .and()
                .logout()
                // 配置登出的url
                .logoutUrl("/logout")
                // 配置登出成功后跳转的页面
                .logoutSuccessUrl("/logout/page")
                // 登出后删除JSESSIONID
                .deleteCookies("JSESSIONID")
                // 登出后是session会话失效
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(urlEntryPoint())
                .accessDeniedPage("/403");

        // 为了方便开发，先关掉此防御策略
        http.csrf().disable();
        // 使用同源策略
        http.headers().frameOptions().sameOrigin();
    }
    /**
     * 配置自定义认证策略
     */
    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // 在内存中配置管理员的用户名和密码
//        auth.inMemoryAuthentication().withUser("Rain").password("289443").roles("ADMIN").and();

        // 使用下面的自定义认证，并且擦除密码
        auth.authenticationProvider(authProvider()).eraseCredentials(true);
    }

    /**
     * 使用我们自定义的认证逻辑，从数据库读取用户并认证
     */
    @Bean
    public AuthProvider authProvider(){
        return new AuthProvider();
    }

    @Bean
    public LoginUrlEntryPoint urlEntryPoint(){
        return new LoginUrlEntryPoint("/user/login");
    }

    @Bean
    public LoginAuthFailHandler authFailHandler(){
        return new LoginAuthFailHandler(urlEntryPoint());
    }
}
