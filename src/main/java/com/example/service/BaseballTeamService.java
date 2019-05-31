package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.BaseballTeam;
import com.example.repository.BaseballTeamRepository;

/**
 * 野球チーム情報を表示させるクラス
 * 
 * @author yuki
 *
 */
@Service
@Transactional
public class BaseballTeamService {
	
	@Autowired
	private BaseballTeamRepository repository;
	
	/**
	 * 野球チーム一覧を表示させるメソッド.
	 * 
	 * @return 野球チーム一覧
	 */
	public List<BaseballTeam> showList(){
		return repository.findAll();
	}
	
	/**
	 *  野球チーム情報を一件表示させるメソッド.
	 * 
	 * @param チームID
	 * @return 野球チーム情報
	 */
	public BaseballTeam showDetail(Integer id) {
		return repository.load(id);
	}

}
