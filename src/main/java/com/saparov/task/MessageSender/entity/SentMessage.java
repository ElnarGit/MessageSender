package com.saparov.task.MessageSender.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "sent_messages")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SentMessage {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "message")
	private String message;
	
	@Column(name = "sent_date")
	@CreationTimestamp
	private Date sendDate;
	
	@Column(name = "response_code")
	private int responseCode;
}
