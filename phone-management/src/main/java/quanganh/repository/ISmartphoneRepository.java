package quanganh.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import quanganh.model.Smartphone;

@Repository
public interface ISmartphoneRepository extends CrudRepository<Smartphone, Long> {
}