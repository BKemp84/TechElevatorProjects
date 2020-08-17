package com.techelevator.cities.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.cities.dao.CityDao;
import com.techelevator.cities.model.City;

@Component
public class JdbcCityDao  implements CityDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public JdbcCityDao() {
	}
	
	@Override
	public List<City> list() {
		List<City> cities = new ArrayList<City>();
		String sql = "SELECT * FROM city";
		
		SqlRowSet rows = jdbcTemplate.queryForRowSet(sql);
		while (rows.next()) {
			cities.add(mapRowToCity(rows));
		}
		
		return cities;
	}
	

	
	private City mapRowToCity(SqlRowSet results) {
		City theCity;
		theCity = new City();
		theCity.setId(results.getLong("id"));
		theCity.setName(results.getString("name"));
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));

		return theCity;
	}






}
