package com.core.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.transaction.annotation.Transactional;

import com.core.action.LoginAction;
@Transactional
public abstract class BaseDao<T> {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private final String tableName;
	private String FIELD_PRIMARY;
	private static final Log log = LogFactory.getLog(LoginAction.class);
	public BaseDao() {
		tableName = getTableName();
		FIELD_PRIMARY=getPrimary();
	}
	
	public T findById(String id) {
		Map<String, Object> map = findMapById(id);
		return map2Object(map);
	}

	public abstract T map2Object(Map<String, Object> map);

	public abstract String getTableName();

	private Map<String, Object> findMapById(String id) {
		long start = System.nanoTime();
		if (id == null) {
			return null;
		}
		String sql = "select * from " + tableName + " where id" + " = ?";
		List<Object> list = new ArrayList<Object>();
		list.add(id);
		final Map<String, Object> map = new HashMap<String, Object>();
		try {
			jdbcTemplate.query(sql, list.toArray(), new RowCallbackHandler() {
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					ResultSetMetaData metaData = rs.getMetaData();
					int columnCount = metaData.getColumnCount();
					for (int i = 1; i <= columnCount; i++) {
						String columnName = metaData.getColumnLabel(i);
						// String columnName = metaData.getColumnName(i);
						map.put(columnName, rs.getObject(i));
					}
				}
			});
		} catch (DataAccessException e) {

		}
		long end = System.nanoTime();
		log.info("查询时间："+(end-start));
		if (map.size() == 0) {
			return null;
		}
		return map;
	}

	public List<Map<String, Object>> findAll() {
		long start = System.nanoTime();
		String sql = "select * from " + tableName;
		final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			jdbcTemplate.query(sql, new RowCallbackHandler() {
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					ResultSetMetaData metaData = rs.getMetaData();
					Map<String, Object> map = new HashMap<String, Object>();
					int columnCount = metaData.getColumnCount();
					for (int i = 1; i <= columnCount; i++) {
						String columnName = metaData.getColumnLabel(i);
						map.put(columnName, rs.getObject(i));
					}
					list.add(map);
				}
			});
		} catch (DataAccessException e) {
		}
		long end = System.nanoTime();
		log.info("查询时间："+(end-start));
		return list;
	}
	public List<Map<String, Object>> findAllDESC(String orderby) {
		long start = System.nanoTime();
		String sql = "select * from " + tableName +" order by "+orderby+" desc";
		
		final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			jdbcTemplate.query(sql, new RowCallbackHandler() {
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					ResultSetMetaData metaData = rs.getMetaData();
					Map<String, Object> map = new HashMap<String, Object>();
					int columnCount = metaData.getColumnCount();
					for (int i = 1; i <= columnCount; i++) {
						String columnName = metaData.getColumnLabel(i);
						map.put(columnName, rs.getObject(i));
					}
					list.add(map);
				}
			});
		} catch (DataAccessException e) {
		}
		long end = System.nanoTime();
		log.info("查询时间："+(end-start));
		return list;
	}
	public List<T> findAllLimitObjs(int currentPage){
		List<Map<String, Object>> maps=findAllLimit(currentPage);
		List<T> tList=new ArrayList<>();
		for (Map<String, Object> map : maps) {
			tList.add(map2Object(map));
		}
		return tList;
	}
	public List<Map<String, Object>> findAllLimit(int currentPage){
		long start = System.nanoTime();
		int index=(currentPage-1)*20;
		String sql = "select * from " + tableName+" limit "+ index+",20";
		log.info(sql);
		final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			jdbcTemplate.query(sql, new RowCallbackHandler() {
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					ResultSetMetaData metaData = rs.getMetaData();
					Map<String, Object> map = new HashMap<String, Object>();
					int columnCount = metaData.getColumnCount();
					for (int i = 1; i <= columnCount; i++) {
						String columnName = metaData.getColumnLabel(i);
						map.put(columnName, rs.getObject(i));
					}
					list.add(map);
				}
			});
		} catch (DataAccessException e) {
		}
		long end = System.nanoTime();
		log.info("查询时间："+(end-start));
		return list;
	}
	public List<T> findObjsByFields(Map<String, Object> map) {
		final List<T> list = new ArrayList<T>();
		List<Map<String, Object>> listMap = findByFields(map);
		for (Map<String, Object> resultMap : listMap) {
			list.add(map2Object(resultMap));
		}
		return list;
	}
	public List<T> findObjsByFieldsLimit(Map<String, Object> map,int currentPage){
		final List<T> list = new ArrayList<T>();
		List<Map<String, Object>> listMap = findByFieldsLimit(map,currentPage);
		for (Map<String, Object> resultMap : listMap) {
			list.add(map2Object(resultMap));
		}
		return list;
	}
	public List<T> findAll2Objs() {
		final List<T> list=new ArrayList<>();
		List<Map<String, Object>> listMap=findAll();
		for (Map<String, Object> map : listMap) {
			list.add(map2Object(map));
		}
		return list;
	}
	@SuppressWarnings("deprecation")
	public  int findAllCount(){
		String sql="select count("+FIELD_PRIMARY+") from "+tableName;		
		int count=jdbcTemplate.queryForInt(sql);
		return count;
	}
	public List<Map<String, Object>> findByFields(Map<String, Object> map) {

		long start = System.nanoTime();
		if (null == map || map.size() == 0) {
			return null;
		}
		final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		final List<Object> values = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer("select * from " + tableName + " where ");
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			sql.append(key + "=? and ");
			values.add(map.get(key));
		}

		sql.delete(sql.length() - 4, sql.length());
		try {
			jdbcTemplate.query(sql.toString(), values.toArray(), new RowCallbackHandler() {
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					ResultSetMetaData metaData = rs.getMetaData();
					Map<String, Object> map = new HashMap<String, Object>();
					int columnCount = metaData.getColumnCount();
					for (int i = 1; i <= columnCount; i++) {
						String columnName = metaData.getColumnLabel(i);
						map.put(columnName, rs.getObject(i));
					}
					list.add(map);
				}
			});
		} catch (DataAccessException e) {
		}
		long end = System.nanoTime();
		log.info("查询时间："+(end-start));
		return list;
	}
	public List<Map<String, Object>> findByFieldsLimit(Map<String, Object> map,int current) {

		long start = System.nanoTime();
		if (null == map || map.size() == 0) {
			return null;
		}
		final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		final List<Object> values = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer("select * from " + tableName + " where ");
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			sql.append(key + "=? and ");
			values.add(map.get(key));
		}
		
		sql.delete(sql.length() - 4, sql.length());
		sql.append("limit "+(current-1)*20+",20");
		log.info(sql.toString());
		try {
			jdbcTemplate.query(sql.toString(), values.toArray(), new RowCallbackHandler() {
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					ResultSetMetaData metaData = rs.getMetaData();
					Map<String, Object> map = new HashMap<String, Object>();
					int columnCount = metaData.getColumnCount();
					for (int i = 1; i <= columnCount; i++) {
						String columnName = metaData.getColumnLabel(i);
						map.put(columnName, rs.getObject(i));
					}
					list.add(map);
				}
			});
		} catch (DataAccessException e) {
		}
		long end = System.nanoTime();
		log.info("查询时间："+(end-start));
		return list;
	}
	public void update(T t) {
		update(t, Boolean.FALSE);
	}

	
	public void update(T t, Boolean isUpdateNull) {
		if (null == t) {
			return;
		}
		Map<String, Object> map = object2Map(t);
		update(map, isUpdateNull);
	}
	
	public abstract Map<String, Object> object2Map(T t) ;

	public void save(Map<String, Object> map) {
		long start = System.nanoTime();
		if (null == map || map.size() == 0) {
			return;
		}
		List<Object> list = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer("insert into " + tableName + " (");
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
		log.info(sql.toString());
		try{
			jdbcTemplate.update(sql.toString(), list.toArray());
		}catch(DataAccessException e){
		} 
		long end = System.nanoTime();
		log.info("查询时间："+(end-start));
	}
	public void update(final Map<String, Object> map,
			final Boolean isUpdateNull) {
		long start = System.nanoTime();
		if (null == map || map.size() == 0) {
			log.warn("更新的信息为null，无法更新，直接返回！");
			return;
		}
		// 判断是否携带了主键值
		String tid_value = (String) map.get(FIELD_PRIMARY);
		if (tid_value==null) {
		}

		List<Object> list = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer("update " + tableName + " set ");
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
				" where " + FIELD_PRIMARY + " = ?");// 去掉最后一个","符号，同时添加where条件
		list.add(tid_value);
		try{
			jdbcTemplate.update(sql.toString(), list.toArray());
		}catch(DataAccessException e){
		} 
		long end = System.nanoTime();
		System.out.println(end-start);
	}
	public Boolean isExistTable(String tabName) {
		try {
			ResultSet rs = jdbcTemplate.getDataSource().getConnection().getMetaData().getTables(null, null, tabName,
					null);
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
		}
		return null;
	}
	public long findProfNumById(int id){
		System.out.println(id);
		String sql="select count(userId) as num from `profile` GROUP BY userId having userId=?;";
		Object[] objects={id};
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql, objects);
		if (!list.isEmpty()) {
			Map<String, Object> map=jdbcTemplate.queryForMap(sql,objects);
			return (Long) map.get("num");
		}else{
			return 0;
		}
		
			
		
	}
	
	public List<Map<String, Object>> findBySQL(String sql, Object... objs) {
		long start = System.nanoTime();
		final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		if (null == objs) {
			objs = new Object[0];
		}
		try{
			jdbcTemplate.query(sql, objs, new RowCallbackHandler() {
				@Override
				public void processRow(ResultSet rs) throws SQLException {
					ResultSetMetaData metaData = rs.getMetaData();
					Map<String, Object> map = new HashMap<String, Object>();
					int columnCount = metaData.getColumnCount();
					for (int i = 1; i <= columnCount; i++) {
						String columnName = metaData.getColumnLabel(i);
						Object val = rs.getObject(i);
						if (3==metaData.getColumnType(i)) {
							if (val!=null) {
								val = Long.parseLong(val.toString());
							}
						}
						map.put(columnName, val);
					}
					list.add(map);
				}
			});
		}catch(DataAccessException e){
		} 
		long end = System.nanoTime();
		
		return list;
	}
	public List<T> findObjsByFieldsOrderBy(Map<String, Object> map,String orderColum, Boolean isASC) {
		final List<T> list = new ArrayList<T>();
		List<Map<String, Object>> listMap = findByFieldsOrderBy(map,orderColum,isASC);
		for (Map<String, Object> resultMap : listMap) {
			list.add(map2Object(resultMap));
		}
		return list;
	}
	public List<Map<String, Object>> findByFieldsOrderBy(Map<String, Object> map,String orderColum, Boolean isASC) {
		long start = System.nanoTime();
		if (null == map || map.size() == 0) {
			return null;
		}
		final List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		final List<Object> values = new ArrayList<Object>();
		StringBuffer sql = new StringBuffer("select * from " + tableName
				+ " where ");
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			sql.append(key + "=? and ");
			values.add(map.get(key));
		}
		sql.delete(sql.length() - 4, sql.length());
		if (orderColum!=null) {
			if (isASC) {
				sql.append(" order by " + orderColum + " asc");
			} else {
				sql.append(" order by " + orderColum + " desc");
			}
		}
		try {
			jdbcTemplate.query(sql.toString(), values.toArray(),
					new RowCallbackHandler() {
						@Override
						public void processRow(ResultSet rs)
								throws SQLException {
							ResultSetMetaData metaData = rs.getMetaData();
							Map<String, Object> map = new HashMap<String, Object>();
							int columnCount = metaData.getColumnCount();
							for (int i = 1; i <= columnCount; i++) {
								String columnName = metaData.getColumnLabel(i);
								map.put(columnName, rs.getObject(i));
							}
							list.add(map);
						}
					});
		} catch(DataAccessException e){
		} 
		long end = System.nanoTime();
		
		return list;
	}

	public JdbcTemplate geJdbcTemplate(){
		return this.jdbcTemplate;
	}
	public abstract String getPrimary();
	public static void main(String[] args) {
		
	}
}
