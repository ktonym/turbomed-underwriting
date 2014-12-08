package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.Member;

import java.util.List;

/**
 * Created by akipkoech on 12/8/14.
 */
public interface MemberService {
    List<Member> findAll();
    void cancel(Member member);
}
