package ke.co.turbosoft.med.service;

import ke.co.turbosoft.med.entity.Member;
import ke.co.turbosoft.med.entity.Principal;

import java.util.List;

/**
 * Created by ktonym on 1/2/15.
 */
public interface PrincipalService {
    List<Principal> findAll();
    List<Member> listMembers(Principal principal);
    void addMember(Member member);
    void removeMember(Member member);
    void save(Principal principal);
}
