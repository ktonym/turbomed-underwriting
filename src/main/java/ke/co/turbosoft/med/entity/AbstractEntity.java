package ke.co.turbosoft.med.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.MappedSuperclass;

/**
 * Created by akipkoech on 12/8/14.
 */
@MappedSuperclass
@SuppressWarnings("serial")
public class AbstractEntity extends AbstractPersistable<Integer>{

}
