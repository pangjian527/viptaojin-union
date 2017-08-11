package com.viptaojin.union.dao;

import com.viptaojin.union.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pj on 5/10/17.
 */
@Repository
public interface MemberRepository extends JpaRepository<Member,String> {

    public Member findByUsername(String username);

}
