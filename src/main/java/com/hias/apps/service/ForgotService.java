package com.hias.apps.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import com.hias.apps.repository.UserRepository;
import com.sendgrid.Email;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.hias.apps.domain.User;

@Service
public class ForgotService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private SendEmailService sendEmailService;

	@Autowired
	private EmailSenderService emailSenderService;

	public Map<String, String> forgotPassword(String email) {
		Optional<User> userExist = userRepository.findByEmail(email);
		Map<String, String> mapMessage = new HashMap<>();
		if (userExist.isPresent()) {
			String uuid = UUID.randomUUID().toString();
			userExist.get().setResetPassword(uuid);
			userExist.get().setReset(true);
			userRepository.save(userExist.get());
			try {
				SimpleMailMessage mailMessage = new SimpleMailMessage();
				Map<String, String> mapParam = new HashMap<String, String>();
				mailMessage.setTo(userExist.get().getEmail().toUpperCase());
				mailMessage.setTo(userExist.get().getUsername());
				mailMessage.setSubject("Reset Password Kamu!");
				mailMessage.setFrom("example@gmail.com");
				mailMessage.setText("Untuk reset password kamu, tolong klik akun ini : "
						+"https://hiashouse.com/changepassword?email="+email);
//				mapParam.put("username", userExist.get().getUsername().toUpperCase());
//				mapParam.put("linkValidate", "api-core-hias.herokuapp.com/forgot?id=" +uuid);
//				mapParam.put("uuid", "Click Here");
//				SimpleMailMessage mailMessage = new SimpleMailMessage();
//			            mailMessage.setTo(user.get().getEmail());
//			            mailMessage.setSubject("Lengkapi Pendaftara	n!");
//			            mailMessage.setFrom("norply@hiashouse.com");
//			            mailMessage.setText("Untuk mengonfirmasi akun Anda, silakan klik di sini : "
//			            +"https://hiashouse.com/thank-you?token="+confirmationToken.getConfirmationToken());
//
//			            userProfile = registerService.convertObjectUserProofile(user.get());
//			            emailSenderService.sendEmail(mailMessage);
				emailSenderService.sendEmail(mailMessage);
				mapMessage.put("200","forgot password has been sent");
//				mapMessage.put("200","forgot password has been sent");
			} catch (Exception e) {
				mapMessage.put("500",e.getMessage().toString());
			}
		}else {
			mapMessage.put("200","user doesn't exist");
		}
		return mapMessage;
	}
//	Map<String, String> mapParam = new HashMap<String, String>();
//				mapParam.put("username", userExist.get().getUsername().toUpperCase());
//				mapParam.put("linkValidate", "api-core-music.limu.tv/forgot?id=" +uuid);
//				mapParam.put("uuid", "Click Here");
//				sendEmailService.sendEmail("noreply@limu.tv", "Register Confirmation", userExist.get().getEmail(), "text",
//			"FORGOT", mapParam);
//				mapMessage.put("200","forgot password has been sent");

	public User getUserByResetId(String id) {
		Optional<User> optionalUser = userRepository.findByResetid(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}else {
			return null;
		}
	}
}

