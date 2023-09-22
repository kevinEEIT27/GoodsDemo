package com.example.goodsdemo.controller;

import com.example.goodsdemo.login.AuthRequest;
import com.example.goodsdemo.servies.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {
	@Autowired
	private JWTService jwtService;

	@PostMapping("/login")
	public ResponseEntity<String> issueToken(@Valid @RequestBody AuthRequest request) {
		String token = jwtService.generateToken(request);
		HttpHeaders responseHttpHeaders = new HttpHeaders();
		responseHttpHeaders.set("Authorization", token);

		return ResponseEntity.ok().headers(responseHttpHeaders).body("Response with header");
	}

	@PostMapping("/parse")
	public ResponseEntity<Map<String, Object>> parseToken(@RequestBody Map<String, String> request) {
		String token = request.get("token");
		Map<String, Object> response = jwtService.parseToken(token);

		return ResponseEntity.ok(response);
	}
}
