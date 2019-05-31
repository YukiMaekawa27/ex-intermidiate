package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * ホテルのテーブルを操作するリポジトリ.
 * 
 * @author yuki
 *
 */
@Repository
public class HotelRepository {
	
	private final static RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) ->{
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/**
	 * ホテルの全件検索を行うメソッド.
	 * 
	 * @return 全ホテル情報が入ったリスト
	 */
	public List<Hotel> findAll(){
		String sql = "select id,area_name,hotel_name,address,nearest_station,price,parking from hotels order by price desc;";
		
		List<Hotel> hotelList = template.query(sql, HOTEL_ROW_MAPPER);
		return hotelList;
	}
	
	/**
	 * 価格からホテル検索を行うメソッド.
	 * 
	 * @param 価格
	 * @return 価格以下のホテルリスト
	 */
	public List<Hotel> findByPrice(Integer price){
		String sql = "select id,area_name,hotel_name,address,nearest_station,price,parking from hotels where price>=:price order by price desc;";
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		
		List<Hotel> hotelList = template.query(sql, param, HOTEL_ROW_MAPPER);
		return hotelList;
	}

}
