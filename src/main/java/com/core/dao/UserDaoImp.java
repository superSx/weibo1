package com.core.dao;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.core.domin.LoginBean;
import com.core.domin.RegistBean;
import com.core.domin.User;
@Service
@Transactional(propagation=Propagation.SUPPORTS)
public class UserDaoImp implements UserDao{
	private static Log log=LogFactory.getLog(UserDaoImp.class);
	public static final String USER_ID="userId";
	public static final String LOGIN_NAME="loginName";
	public static final String NICK_NAME="nickName";
	public static final String True_NAME="trueName";
	public static final String PROVINCE="Province";
	public static final String CITY="City";
	public static final String SEX="Sex";
	public static final String BIRTHDAY="Birthday";
	public static final String EMAIL="Email";
	public static final String QQ="QQ";
	public static final String MSN="MSN";
	public static final String INTRODUCE="introduce";
	public static final String IDENTIFIER="identifier";
	public static final String SCHOOL_TYPE="schoolType";
	public static final String SCHOOL_NAME="schoolName";
	public static final String COLLEGE="college";
	public static final String SCHOOL_TIME="schoolTime";
	public static final String WORK_PROV="workProv";
	public static final String WORK_CITY="workCity";
	public static final String WORK_PLACE="workPlace";
	public static final String WORK_TIME_FROM="workTimeFrom";
	public static final String WORK_TIME_TO="workTimeTo";
	public static final String DEPARTMENT="department";
	public static final String TAG="tag";
	public static final String COMPOWER="compower";
	public static final String MSGPOWER="msgpower";
	public static final String SEARCHPOWER="searchpower";
	public static final String BLACKLIST="blacklist";
	public static final String MY_FACE="myFace";
	public static final String REG_TIME="regTime";
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public boolean login(LoginBean loginBean) {
		String sql="select loginName from login where loginName=? and password=?";
		Object[] objects={loginBean.getLoginName(),loginBean.getAssword()};
		List<?> result=jdbcTemplate.queryForList(sql, objects);
		if (result.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean regist(RegistBean registBean) {
		if (!exist(registBean.getLoginName())) {
			LoginBean loginBean=new LoginBean();
			loginBean.setAssword(registBean.getPassword());
			loginBean.setLoginName(registBean.getLoginName());
			loginBean.setLoginType(0);
			updateLoginTable(loginBean);
			String sql="insert into userinfo(loginName,nickName,Province,City,Sex,Identifier,regTime) values(?,?,?,?,?,?,?);";
			Date now=new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String time = dateFormat.format( now ); 
			Object[] objects={registBean.getLoginName(),registBean.getNickName(),registBean.getProvince(),
					registBean.getCity(),registBean.getSex(),registBean.getIdentifier(),time};
			jdbcTemplate.update(sql, objects);
			return true;
		}
		return false;
	}
	@Transactional
	public void save(Map<String, Object> map) {
		long start = System.nanoTime();
		if (null == map || map.size() == 0) {
			return;
		}
		List<Object> list = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer("insert into " + "userinfo" + " (");
		StringBuffer values = new StringBuffer("");
		Set<String> keySet = map.keySet();

		for (String colum : keySet) {
			if (null == map.get(colum)) {
				continue;
			}
			sql.append("`"+colum + "`,");
			values.append("?,");
			list.add(map.get(colum));
		}

		sql.deleteCharAt(sql.length() - 1);// 去掉最后一个","符号
		values.deleteCharAt(values.length() - 1);// 去掉最后一个","符号
		sql.append(") values(" + values.toString() + ")");
		try{
			jdbcTemplate.update(sql.toString(), list.toArray());
		}catch(DataAccessException e){
		} 
		long end = System.nanoTime();
		log.info("查询时间："+(end-start));
	}
	public Map<String, Object> findUserMapByName(String name){
		String sql="select * from userinfo where loginName=?";
		Object[] objects={name};
		Map<String, Object> result=jdbcTemplate.queryForMap(sql,objects);
		
		if (result!=null) {
			return result;
		}	
		
		return new HashMap<>();
	}
	public boolean existNickName(String nickName){
		String sql="select userId from userinfo where nickName=?";
		Object[] args={nickName};
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql,args);
		if (!list.isEmpty()) {
			return true;
		}else{
			return false;
		}
	}
	public int getIdByNickName(String nickName){
		if (existNickName(nickName)) {
			String sql="select userId from userinfo where nickName=?";
			Object[] args={nickName};
			List<Map<String, Object>> list=jdbcTemplate.queryForList(sql,args);
			return (int) list.get(0).get("userId");
		}else{
			return 0;
		}
	}
	public String nickName(int id){
		String sql="select nickName from userinfo where userId=?";
		Object[] args={id};
		if (jdbcTemplate.queryForList(sql, args).isEmpty()) {
			return "";
		}
		return jdbcTemplate.queryForObject(sql, args, java.lang.String.class);
		
	}
	@Transactional
	public List<Map<String,Object>> queryFirst3(){
		String sql="select loginName,sex from userinfo limit 0,3;";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	public User queryUserByName(String loginName){
		return new User();
	}
	public List<Map<String, Object>> currentMsgs(){
		String sql="select msgContent from msg_notice ORDER BY msgTime DESC LIMIT 0,10";
		List<Map<String, Object>> list =jdbcTemplate.queryForList(sql);
		return list;
	}
	public boolean updateLoginTable(LoginBean loginBean) {
		String sql="insert into login(loginName,password,loginType) values(?,?,?);";
		Object[] objects={loginBean.getLoginName(),loginBean.getAssword(),loginBean.getLoginType()};
		jdbcTemplate.update(sql, objects);
		return true;
	}
	public boolean exist(String userName){
		String sql="select (loginName) from login where loginName='"+userName+"'";
		List<?> users=jdbcTemplate.queryForList(sql);
		if (!users.isEmpty()) {
			return true;
		}
		return false;
	}

	public List<Map<String, Object>> queryFunny3() {
		String sql="select loginName,sex from userinfo order by rand() limit 0,3;";
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		return list;
	}
	public void updateLogin(LoginBean loginBean){
		String sql="update login set password=? where loginName=?";
		Object[] objects={loginBean.getAssword(),loginBean.getLoginName()};
		jdbcTemplate.update(sql, objects);
	}
	public void update(User user) {
		update(user, Boolean.FALSE);
	}

	
	public void update(User user, Boolean isUpdateNull) {
		if (null == user) {
			return;
		}
		Map<String, Object> map = obj2Map(user);
		update(map, isUpdateNull);
	}
	public void update(final Map<String, Object> map,
			final Boolean isUpdateNull) {
		long start = System.nanoTime();
		if (null == map || map.size() == 0) {
			log.warn("更新的信息为null，无法更新，直接返回！");
			return;
		}
		// 判断是否携带了主键值
		Integer tid_value = (Integer) map.get("userId");
		if (tid_value==null) {
		}

		List<Object> list = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer("update " + "userinfo" + " set ");
		Set<String> keySet = map.keySet();
		if (isUpdateNull) {// 更新null值
			for (String key : keySet) {
				sql.append("`"+key+"`" + " = ?,");
				list.add(map.get(key));
			}
		} else {// 不更新null
			for (String key : keySet) {
				// 如果为null，则不处理。
				if (null == map.get(key)) {
					continue;
				}
				sql.append("`"+key+"`" + " = ?,");
				list.add(map.get(key));
			}
		}
		sql.deleteCharAt(sql.length() - 1).append(
				" where " + "userId" + " = ?");// 去掉最后一个","符号，同时添加where条件
		list.add(tid_value);
		try{
			jdbcTemplate.update(sql.toString(), list.toArray());
		}catch(DataAccessException e){
		} 
		long end = System.nanoTime();
		System.out.println(end-start);
	}
	public Map<String, Object> obj2Map(User user){
		Map<String, Object> map=new HashMap<>();
		map.put(LOGIN_NAME, user.getLoginName());
		map.put(USER_ID, user.getUserId());
		map.put(BIRTHDAY, user.getBirthday());
		map.put(BLACKLIST, user.getBlacklist());
		map.put(CITY, user.getCity());
		map.put(COLLEGE, user.getCollege());
		map.put(COMPOWER, user.getComPower());
		map.put(DEPARTMENT, user.getDepartment());
		map.put(EMAIL, user.getEmail());
		map.put(IDENTIFIER, user.getIdentifier());
		map.put(INTRODUCE, user.getIntruduce());
		map.put(MSGPOWER, user.getMsgPower());
		map.put(MSN, user.getMSN());
		map.put(MY_FACE, user.getMyFace());
		map.put(NICK_NAME, user.getNickName());
		map.put(PROVINCE, user.getProvince());
		map.put(QQ, user.getQQ());
		map.put(REG_TIME, user.getRegTime());
		map.put(SCHOOL_NAME, user.getSchoolName());
		map.put(SCHOOL_TIME, user.getSchoolTime());
		map.put(SCHOOL_TYPE, user.getSchoolType());
		map.put(SEARCHPOWER, user.getSearchPower());
		map.put(SEX, user.getSex());
		map.put(TAG, user.getTag());
		map.put(True_NAME, user.getTrueName());
		map.put(USER_ID, user.getUserId());
		map.put(WORK_CITY, user.getWorkCity());
		map.put(WORK_PLACE, user.getWorkplace());
		map.put(WORK_PROV, user.getWorkProv());
		map.put(WORK_TIME_FROM, user.getWorkTimeFrom());
		map.put(WORK_TIME_TO, user.getWorkTimeTo());
		return map;
	}
	public User mapToObj(Map<String, Object> map){
		User user=new User();
		user.setBirthday(map.get(BIRTHDAY).toString());
		user.setBlacklist((String) map.get(BLACKLIST));
		user.setCity((String) map.get(CITY));
		user.setCollege((String) map.get("colleage"));
		user.setComPower((Boolean) map.get(COMPOWER));
		user.setDepartment((String) map.get(DEPARTMENT));
		user.setEmail((String) map.get(EMAIL));
		user.setIdentifier((String) map.get(IDENTIFIER));
		user.setIntruduce((String) map.get(INTRODUCE));
		user.setLoginName((String) map.get(LOGIN_NAME));
		user.setMsgPower((Boolean) map.get(MSGPOWER));
		user.setMSN((String) map.get(MSN));
		user.setMyFace((String) map.get(MY_FACE));
		user.setNickName((String) map.get(NICK_NAME));
		user.setProvince((String) map.get(PROVINCE));
		user.setQQ((String) map.get(QQ));
		user.setRegTime((Timestamp) map.get(REG_TIME));
		user.setSchoolName((String) map.get(SCHOOL_NAME));
		user.setSchoolTime((Long) map.get(SCHOOL_TIME));
		user.setSchoolType((Long) map.get(SCHOOL_TYPE));
		user.setSearchPower((Boolean) map.get(SEARCHPOWER));
		user.setSex((String) map.get(SEX));
		user.setTag((String) map.get(TAG));
		user.setTrueName((String) map.get(True_NAME));
		user.setWorkCity((String) map.get(WORK_CITY));
		user.setWorkplace((String) map.get(WORK_PLACE));
		user.setWorkProv((String) map.get(WORK_PROV));
		user.setWorkTimeFrom((Long) map.get(WORK_TIME_FROM));
		user.setWorkTimeTo((Long) map.get(WORK_TIME_TO));
		user.setUserId((Integer) map.get(USER_ID));
		log.info("user:"+user);

		return user;
	}

}
