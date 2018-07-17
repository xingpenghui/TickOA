package com.feri.common.util;

import java.util.Date;
import java.util.Properties;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.feri.common.vo.EmailMsg;

/*
 * 基于JDK实现邮件发送
 * 主要是实现激活码的发送
 * */
public class EmailUtils {
	public static void sendEmail(EmailMsg msg){
		//邮箱
		String myAccount = "lx_teach@163.com";
		//授权码
		String myPass = "java168";
		//邮箱服务器
		String SMTPHost = "smtp.163.com";
		//设置属性信息
		Properties prop = new Properties();
		//设置协议
		prop.setProperty("mail.transport.protocol", "smtp");
		//邮件服务器
		prop.setProperty("mail.smtp.host", SMTPHost);
		//认证
		prop.setProperty("mail.smtp.auth", "true");
		//1、创建会话
		Session session = Session.getDefaultInstance(prop);
		//设置是否需要调试
		session.setDebug(false);
		//2、创建发送信息
		MimeMessage message = createMsg(session,myAccount,msg);
		//4发送信息操作
		try {
			
			Transport tran = session.getTransport();
			//连接
			tran.connect(myAccount, myPass);
			//发送消息 
			tran.sendMessage(message, message.getAllRecipients());
			//关闭
			tran.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//生成邮件消息
	private static MimeMessage createMsg(Session session, String myAccount, EmailMsg msg) {
		//创建消息对象
		MimeMessage message = new MimeMessage(session);
		//设置
		try {
			//3.1发送方
			message.setFrom(new InternetAddress(myAccount, "千锋OA系统", "utf-8"));
			//3.2设置接收方
			/*
			 * MimeMessage.RecipientType.TO 
			 * MimeMessage.RecipientType.CC 
			 * MimeMessage.RecipientType.BCC 
			 * */
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(msg.getEmail(), "会员", "utf-8"));
			//3.3 设置主题
			message.setSubject(msg.getTitle(),"utf-8");
			//获取本机的ip地址
//			String ip = Inet4Address.getLocalHost().getHostAddress();
//			String url = "http://"+ip+":8080/Millet_Shopping/activate?e="+ Base64Utils.encode(user.getEmail())+"&c="+Base64Utils.encode(user.getActivatecode());
			//设置正文信息
			message.setContent(msg.getContent(),"text/html;charset=utf-8");
			//设置日期
			message.setSentDate(new Date());
			//保存
			message.saveChanges();
		} catch (Exception e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
}
