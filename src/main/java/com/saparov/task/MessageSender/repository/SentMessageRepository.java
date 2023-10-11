package com.saparov.task.MessageSender.repository;

import com.saparov.task.MessageSender.entity.SentMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentMessageRepository extends JpaRepository<SentMessage, Long> {
}
