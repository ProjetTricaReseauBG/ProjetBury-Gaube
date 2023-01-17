package be.heh.projettrica.infra.addaptater.secondary.orm;

import org.springframework.data.jpa.repository.JpaRepository;

// This is an interface that extends Spring Data JPA's JpaRepository
// JpaRepository provides basic CRUD operations for the entity type TournoisJpaEntity and the primary key type Long
public interface TournoisRepository extends JpaRepository<TournoisJpaEntity,Long> {
}
