package cn.itcast.core.service.impl;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.core.mapper.UserMapper;
import cn.itcast.core.pojo.User;
import cn.itcast.core.search.dao.SearchDao;
import cn.itcast.core.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private SearchDao searchDao;
	@Override
	public void save(User user) {
		userMapper.save(user);

	}
	@Override
	public List<User> search(String searchString) throws Exception {
		SolrQuery solrQuery = new SolrQuery();
		 //solrQuery.set("user_name", searchString);
		solrQuery.setQuery("user_name:"+searchString);
		return searchDao.search(solrQuery);
	}

}
