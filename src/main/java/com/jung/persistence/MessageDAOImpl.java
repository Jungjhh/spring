package com.jung.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.jung.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {
	
	@Inject
	private SqlSession session;

	private String namespace = "com.jung.mapper.MessageMapper";
	
	@Override
	public void create(MessageVO vo) throws Exception {
		session.insert(namespace+".create", vo);
	}

	@Override
	public MessageVO readMessage(Integer mno) throws Exception {
		return session.selectOne(namespace+".readMessage", mno);
	}

	@Override
	public void updateState(Integer mno) throws Exception {
		session.update(namespace+".updateState", mno);
	}
	

}
