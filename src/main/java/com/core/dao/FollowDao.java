package com.core.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.core.domin.Follow;
@Service
public class FollowDao extends BaseDao<Follow>{
	public static final String FM_ID="fmId";
	public static final String FANS_ID="fansId";
	public static final String FOLLOW_ID="followId";
	public static final String GROUP_ID="groupId";
	@Override
	public Follow map2Object(Map<String, Object> map) {
		Follow follow=new Follow();
		follow.setFansId((Integer) map.get(FANS_ID));
		follow.setFmId((Integer) map.get(FM_ID));
		follow.setFollowId((Integer) map.get(FOLLOW_ID));
		follow.setGroupId((Integer) map.get(GROUP_ID));
		return follow;
		
		
		
		
	}

	@Override
	public String getTableName() {
		return "fans_manage";
	}

	@Override
	public Map<String, Object> object2Map(Follow follow) {
		Map<String, Object> map=new HashMap<>();
		
		map.put(FM_ID, follow.getFmId());
		map.put(GROUP_ID, follow.getGroupId());
		map.put(FANS_ID, follow.getFansId());
		map.put(FOLLOW_ID, follow.getFollowId());
		return map;
	}

	@Override
	public String getPrimary() {
		return "fmId";
	}
	public long getFansCount(int followId){
		String sql="select followId,count(fansId) AS num from fans_manage group by followId HAVING followId=?";
		List<Map<String, Object>> maps=findBySQL(sql, followId);
		long count=(long) maps.get(0).get("num");
		return count;
	}
	public long getFollowCount(int fansId){
		String sql="select count(followId) AS num from fans_manage group by fansId HAVING fansId=?";
		List<Map<String, Object>> maps=findBySQL(sql, fansId);
		long count=(long) maps.get(0).get("num");
		return count;
	}
	
}
