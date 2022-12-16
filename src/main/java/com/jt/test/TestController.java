package com.jt.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@PostMapping("/queryUserList")
	public Map<String, Object> queryUserList(@RequestBody Map<String, Object> params) {
		log.info("---------------------queryUserList----start---------------------");
		Map<String, Object> result = new HashMap<String, Object>();
		String userId = (String) params.get("userId");
		List<Map<String, Object>> dataList = jdbcTemplate.queryForList("SELECT * FROM USER");
		result.put("userId", userId);
		result.put("code", 200);
		result.put("msg", "success");
		result.put("dataList", dataList);
		log.info("---------------------queryUserList----end---------------------");
		return result;
	}
}
