package com.herokuapp.issue_quest.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.herokuapp.issue_quest.domain.model.Quest;

/**
 * 
 * クエストのリポジトリ
 * 
 * @author k4h4shi
 *
 */
public interface QuestRepository extends JpaRepository<Quest, String> {
}
