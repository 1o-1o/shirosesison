package cloud.gateway.service;

import cloud.gateway.core.models.User;

/**
 * Created by JAVA on 2017/9/12.
 */
public interface LoginService {

    public void lastLoginTime(User user);
}
