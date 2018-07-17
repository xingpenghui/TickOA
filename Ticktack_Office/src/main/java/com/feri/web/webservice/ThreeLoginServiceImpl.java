package com.feri.web.webservice;

import com.feri.common.vo.ResultVo;
import com.feri.domain.LoginLog;
import com.feri.domain.User;
import com.feri.service.LoginLogService;
import com.feri.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/13 15:07
 */
@Service
public class ThreeLoginServiceImpl implements ThreeLoginService {
    @Autowired
    private UserService service;

    @Override
    public ResultVo login(String name, String password) {
        User user= service.queryByNo(name,password);
        if(user==null){
            return ResultVo.setERROR("用户名或密码不正确");
        }else{
            return ResultVo.setOK("登录成功");
        }
    }
    @Autowired
    private LoginLogService logService;
    @Override
    public List<LoginLog> loginLog(String username) {
        return logService.queryByNo(username);
    }

}
