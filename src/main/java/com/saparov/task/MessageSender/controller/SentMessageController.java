package com.saparov.task.MessageSender.controller;

import com.saparov.task.MessageSender.entity.SentMessage;
import com.saparov.task.MessageSender.service.SentMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sent-messages")
public class SentMessageController {
	private final SentMessageService sentMessageService;
	
	@GetMapping
	public ResponseEntity<List<SentMessage>> getAllSentMessages(){
		List<SentMessage> sentMessages = sentMessageService.getAllSentMessages();
		return ResponseEntity.ok(sentMessages);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public SentMessage getSentMessagesById(@PathVariable Long id){
		return sentMessageService.getSentMessagesById(id);
	}
	
	@PostMapping
	public ResponseEntity<SentMessage> saveMessage(@RequestBody SentMessage sentMessage){
		SentMessage createSentMessage = sentMessageService.saveSentMessage(sentMessage);
		return ResponseEntity.status(HttpStatus.CREATED).body(createSentMessage);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteSentMessage(@PathVariable Long id){
		sentMessageService.deleteSentMessage(id);
		
		return "SentMessage deleted";
	}
}
