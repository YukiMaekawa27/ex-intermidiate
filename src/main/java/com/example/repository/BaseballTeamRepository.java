package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.BaseballTeam;

/**
 * 野球チームテーブルを操作するリポジトリ.
 * 
 * @author yuki
 *
 */
@Repository
public class BaseballTeamRepository {
	
	private static final RowMapper<BaseballTeam> BASEBALL_ROW_MAPPER = (rs, i) -> {
		BaseballTeam baseballTeam = new BaseballTeam();
		baseballTeam.setId(rs.getInt("id"));
		baseballTeam.setLeagueName(rs.getString("league_name"));
		baseballTeam.setTeamName(rs.getString("team_name"));
		baseballTeam.setHeadquarters(rs.getString("headquarters"));
		baseballTeam.setInauguration(rs.getString("inauguration"));
		baseballTeam.setHistory(rs.getString("history"));
		return baseballTeam;
	};
	
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * 全チーム情報を検索するメソッド.
	 * 
	 * @return 全野球チームリスト
	 */
	public List<BaseballTeam> findAll(){
		String sql = "select id,league_name,team_name,headquarters,inauguration,history from teams order by inauguration;";
		
		List<BaseballTeam> baseballTeamList = template.query(sql, BASEBALL_ROW_MAPPER);
		
		return baseballTeamList;
	}
	
	/**
	 * IDから野球チームを検索するメソッド
	 * 
	 * @param チームID
	 * @return 野球チーム
	 */
	public BaseballTeam load(Integer id) {
		String sql = "select id,league_name,team_name,headquarters,inauguration,history from teams where id=:id";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		
		BaseballTeam baseballTeam = template.queryForObject(sql, param, BASEBALL_ROW_MAPPER);
		return baseballTeam;
	}

}
