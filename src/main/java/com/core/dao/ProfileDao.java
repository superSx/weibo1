package com.core.dao;

import java.sql.Timestamp;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.domin.Profile;
@Service
@Transactional
public class ProfileDao extends BaseDao<Profile> {

	public final static String PROF_ID="profId";
	public final static String USER_ID="userId";
	public final static String Prof_TIME="profTime";
	public final static String TC_ID="tcId";
	public final static String IMAGE_REF="ImageRef";
	public final static String PROF_CONTENT="profContent";
	@Override
	public Profile map2Object(Map<String, Object> map) {
		Profile profile=new Profile();
		profile.setProfContent((String) map.get(PROF_CONTENT));
		profile.setProfId((int) map.get(PROF_ID));
		profile.setProfTime( (Timestamp) map.get(Prof_TIME));
		profile.setTcId((int) map.get(TC_ID));
		profile.setUserId((int)map.get(USER_ID));
		if (map.get(IMAGE_REF)==null) profile.setImageRef("");
		else profile.setImageRef((String) map.get(IMAGE_REF));
		return profile;
	}
	@Override
	public String getTableName() {
		return "profile";
	}

	
	@Override
	public String getPrimary() {
		return PROF_ID;
	}
	@Override
	public Map<String, Object> object2Map(Profile t) {
		return null;
	}
	
	
	
}
