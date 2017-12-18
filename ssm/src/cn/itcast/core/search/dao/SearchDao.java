package cn.itcast.core.search.dao;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;

import cn.itcast.core.pojo.User;

public interface SearchDao {

	List<User> search(SolrQuery solrQuery) throws Exception;

}
