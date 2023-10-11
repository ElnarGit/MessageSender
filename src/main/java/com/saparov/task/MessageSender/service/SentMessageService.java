package com.saparov.task.MessageSender.service;

import com.saparov.task.MessageSender.entity.SentMessage;
import com.saparov.task.MessageSender.exception.NotFoundException;
import com.saparov.task.MessageSender.repository.SentMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SentMessageService {
	private final SentMessageRepository sentMessageRepository;
	
	public List<SentMessage> getAllSentMessages(){
		return sentMessageRepository.findAll();
	}
	
	public SentMessage getSentMessagesById(Long id){
		return sentMessageRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("SentMessage not found with id: " + id));
	}
	
	@Transactional
	public SentMessage saveSentMessage(SentMessage sentMessage){
		return sentMessageRepository.save(sentMessage);
	}
	
	@Transactional
	public void deleteSentMessage(Long id){
		SentMessage sentMessage = getSentMessagesById(id);
		
		sentMessageRepository.delete(sentMessage);
	}
	
}
