package cn.itcast.core.search.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import cn.itcast.core.pojo.User;
import cn.itcast.core.search.dao.SearchDao;

@Component
public class SearchDaoImpl implements SearchDao {

	@Autowired
	private SolrServer solrServer;

	@Override
	public List<User> search(SolrQuery solrQuery) throws Exception {
		QueryResponse queryResponse = solrServer.query(solrQuery);
		SolrDocumentList solrDocumentList = queryResponse.getResults();
		List<User> list = new ArrayList();
		for (SolrDocument solrDocument : solrDocumentList) {
			User user = new User();
			//user.setId((Integer) solrDocument.get("id"));
			user.setName((String) solrDocument.get("user_name"));
			user.setBirthday((Date) solrDocument.get("user_birthday"));
			list.add(user);
		}
		
		
		return list;
	}

}
