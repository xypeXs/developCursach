package ru.rsatu.cursach.repository.reference;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.rsatu.cursach.entity.BaseReferenceEntity;

@NoRepositoryBean
public interface BaseReferenceRepository <T extends BaseReferenceEntity> extends CrudRepository<T, Long> {
}
