package com.feri.web.webservice;

import com.feri.common.vo.ResultVo;
import com.feri.domain.LoginLog;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2018/7/13 15:06
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface ThreeLoginService {
    @WebMethod
    ResultVo login(@WebParam(name = "username") String name, @WebParam(name="password") String password);
    @WebMethod
    List<LoginLog> loginLog(@WebParam(name = "name") String username);
}
