package com.gana.backend.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import java.io.IOException;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	private final String fromEmail = "noreply@yourdomain.com";

	public void sendEmail(String to, String subject, String text, MultipartFile attachment)
			throws MessagingException, IOException {

		if (!isValidEmail(to)) {
			throw new IllegalArgumentException("Invalid email address: " + to);
		}

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom(fromEmail);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(text, true);

		if (attachment != null && !attachment.isEmpty()) {
			helper.addAttachment(attachment.getOriginalFilename(), new ByteArrayResource(attachment.getBytes()));
		}

		javaMailSender.send(mimeMessage);
		System.out.println("Mail sent");
	}

	private boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		return pattern.matcher(email).matches();
	}
}
