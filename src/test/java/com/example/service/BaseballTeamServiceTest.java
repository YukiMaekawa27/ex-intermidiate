package com.example.service;

import static org.junit.Assert.*;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.BaseballTeam;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseballTeamServiceTest {

	@Autowired
	BaseballTeamService service;

	@Test
	public void testshowList() {
		List<BaseballTeam> baseballTeamList = service.showList();
		System.out.println(baseballTeamList);
		for (BaseballTeam baseballTeam : baseballTeamList) {
			if (baseballTeam.getTeamName().equals("読売ジャイアンツ")) {
			} else if (baseballTeam.getTeamName().equals("阪神タイガース")) {
			} else if (baseballTeam.getTeamName().equals("中日ドラゴンズ")) {
			} else if (baseballTeam.getTeamName().equals("横浜DeNAベイスターズ")) {
			} else if (baseballTeam.getTeamName().equals("広島東洋カープ")) {
			} else if (baseballTeam.getTeamName().equals("東京ヤクルトスワローズ")) {
			} else {
				fail("期待値ではありません");
			}
		}
	}
	@Test
		public void testshowDetail() {
			BaseballTeam baseballTeam = service.showDetail(1);
			assertThat("期待値じゃないです", baseballTeam.getTeamName(), is("読売ジャイアンツ"));
		}

	

}
