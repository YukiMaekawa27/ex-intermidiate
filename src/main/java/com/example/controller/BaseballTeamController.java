package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BaseballTeam;
import com.example.service.BaseballTeamService;

/**
 * 野球チーム情報パスの受け渡しを行うクラス.
 * 
 * @author yuki
 *
 */
@Controller
@RequestMapping("/baseball")
public class BaseballTeamController {
	
	@Autowired
	private BaseballTeamService service;
	
	/**
	 * 最初の画面を表示させるメソッド.
	 * 
	 * @param model　リクエストスコープ
	 * @return 野球チーム一覧を表示させる
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<BaseballTeam> baseballTeamList = service.showList();
		model.addAttribute("baseballTeamList", baseballTeamList);
//		System.out.println(baseballTeamList);
		return "baseballteamlist";
	}
	
	/**
	 * チーム詳細情報を表示させるメソッド.
	 * 
	 * @param チームID
	 * @param model
	 * @return チーム詳細を表示させる
	 */
	@RequestMapping("/showDetail")
	public String showDetail(Integer id, Model model) {
		BaseballTeam baseballTeam = service.showDetail(id);
		model.addAttribute("baseballTeam", baseballTeam);
		return "baseballteamDetail";
	}

}
