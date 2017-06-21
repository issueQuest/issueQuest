package com.k4h4shi.issueQuest.domain.repository;

import com.k4h4shi.issueQuest.domain.model.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * クエストのリポジトリ
 * 
 * @author k4h4shi
 *
 */
public interface QuestRepository extends JpaRepository<Quest, String> {
}
