package dev.easbarba.apito_backend.repository;

import dev.easbarba.apito_backend.domain.Referee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefereeRepository extends CrudRepository<Referee, Long> {}
