package com.cxhu.comprehensive.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.cxhu.comprehensive.domain.Additional_type;

@Component
/**操作赠品*/
public interface Additional_typeDao extends JpaRepository<Additional_type, Integer> {
	
}
