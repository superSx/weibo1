package com.core.dao;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.core.domin.Blog;
@Service
public class BlogDao extends BaseDao<Blog>{
	public static final String MSG_ID="msgId";
	public static final String MSG_TIME="msgTime";
	public static final String MSG_FROM="msgFrom";
	public static final String MSG_TO="msgTo";
	public static final String MSG_CONTENT="msgContent";
	public static final String MSG_TYPE="msgType";
	public static final String MSG_READ="msgRead";
	@Autowired
	UserDaoImp userDao;
	@Override
	public Blog map2Object(Map<String, Object> map) {
		Blog blog=new Blog();
		blog.setDate((Timestamp) map.get(MSG_TIME));
		blog.setMsgContent((String) map.get(MSG_CONTENT));
		blog.setMsgFrom((Integer) map.get(MSG_FROM));
		blog.setMsgId((Integer) map.get(MSG_ID));
		blog.setMsgRead((Boolean) map.get(MSG_READ));
		blog.setMsgTo((Integer) map.get(MSG_TO));
		blog.setMsgType((Integer) map.get(MSG_TYPE));
		blog.setMsgToName(userDao.nickName(blog.getMsgTo()));
		return blog;
	}

	@Override
	public String getTableName() {
		return "msg_notice";
	}
	@SuppressWarnings("deprecation")
	@Override
	public int findAllCount() {
		String sql="select count(profId) from profile";
		JdbcTemplate jdbcTemplate=geJdbcTemplate();
		
		int count=jdbcTemplate.queryForInt(sql);
		return count;
	}

	@Override
	public Map<String, Object> object2Map(Blog blog) {
		Map<String,Object> map=new HashMap<>();
		map.put(MSG_CONTENT, blog.getMsgContent());
		map.put(MSG_FROM, blog.getMsgFrom());
		map.put(MSG_ID, blog.getMsgId());
		map.put(MSG_READ, blog.getMsgRead());
		map.put(MSG_TYPE, blog.getMsgType());
		map.put(MSG_ID, blog.getMsgId());
		map.put(MSG_TO, blog.getMsgTo());
		return map;
	}

	@Override
	public String getPrimary() {
		return MSG_ID;
	}

}
